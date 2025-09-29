# 1. Необходимо реализовать логику для ls и cd.
# 2. Реализовать новые команды: rev, echo.
# 3. Создать стартовый скрипт для тестирования всех реализованных на этом этапе команд. Добавить туда примеры всех режимов команд, включая работу с VFS и обработку ошибок.
import sys, json, base64
FS_TAG = None
SIGN = "$ "
VFS = None
CWD = []
VFS_PATH = None
START_SCRIPT = None

# загрузка VFS
def load_vfs(path):
    global VFS
    with open(path, "r", encoding="utf-8") as f:
        VFS = json.load(f)

# парсер строки
def split_line(inp):
    segs = inp.strip().split()
    if not segs:
        return None, []
    return segs[0], segs[1:]

# разбор пути в VFS
def resolve(path: str):
    global VFS, CWD
    if path.startswith("/"):
        parts = path.strip("/").split("/")
        res = []
    else:
        parts = path.split("/")
        res = CWD.copy()

    node = VFS
    for p in res:
        if p not in node["children"] or node["type"] != "dir":
            raise FileNotFoundError(path)
        node = node["children"][p]

    for p in parts:
        if p in ("", "."):
            continue
        elif p == "..":
            if res:
                res.pop()
            node = VFS
            for r in res:
                node = node["children"][r]
            continue
        else:
            if node["type"] != "dir" or p not in node["children"]:
                raise FileNotFoundError(path)
            node = node["children"][p]
            res.append(p)

    return node, res
# ls
def cmd_ls(args):
    try:
        path = args[0] if args else "."
        node, _ = resolve(path)
        if node["type"] != "dir":
            print(path)
            return
        for name in node["children"]:
            print(name)
    except Exception:
        print(f"Ошибка ls: {args[0] if args else '.'}")
# cd
def cmd_cd(args):
    global CWD
    try:
        if not args:
            CWD = []
            return
        _, res = resolve(args[0])
        CWD = res
    except Exception:
        print(f"Ошибка cd: {args[0] if args else '.'}")
# pwd
def cmd_pwd(_):
    print("/" + "/".join(CWD))
#cat
def cmd_cat(args):
    if not args:
        return
    try:
        node, _ = resolve(args[0])
        if node["type"] != "file":
            raise Exception
        if node.get("mode") == "base64":
            data = base64.b64decode(node["data"]).decode("utf-8", "replace")
        else:
            data = node["data"]
        print(data, end="")
    except Exception:
        print(f"Ошибка cat: {args[0]}")
#cfg
def cmd_conf(_):
    print(f"FS_PATH={VFS_PATH}")
    print(f"START_SCRIPT={START_SCRIPT}")
    print(f"CWD=/{'/'.join(CWD)}")
#echo
def cmd_echo(args):
    print(" ".join(args))
#rev
def cmd_rev(args):
    if not args:
        return
    for path in args:
        try:
            node, _ = resolve(path)
            if node["type"] == "file":
                if node.get("mode") == "base64":
                    data = base64.b64decode(node["data"]).decode("utf-8", "replace")
                else:
                    data = node["data"]
                for line in data.splitlines():
                    print(line[::-1])
            else:
                print(path[::-1])
        except Exception:
            print(path[::-1])


# all
def do_cmd(cmd, args):
    try:
        if cmd == "ls": cmd_ls(args)
        elif cmd == "cd": cmd_cd(args)
        elif cmd == "pwd": cmd_pwd(args)
        elif cmd == "cat": cmd_cat(args)
        elif cmd == "conf-dump": cmd_conf(args)
        elif cmd == "echo": cmd_echo(args)
        elif cmd == "rev":  cmd_rev(args)
        elif cmd == "exit": sys.exit(0)
        else: print(f"unknown: {cmd}")
    except FileNotFoundError as e:
        print(f"oops: {e}")
# script
def run_script(path):
    with open(path, encoding="utf-8") as f:
        for line in f:
            s = line.strip()
            if not s or s.startswith("#"):
                continue
            print(f"{FS_TAG}$ {s}")
            cmd, args = split_line(s)
            try:
                do_cmd(cmd, args)
            except Exception as e:
                print(f"Ошибка: {e}")

# REPL
def repl():
    while True:
        try:
            line = input(f"{FS_TAG}$ ")
        except EOFError:
            break
        cmd, args = split_line(line)
        if cmd:
            try:
                do_cmd(cmd, args)
            except Exception as e:
                print("oops:", e)

def main():
    global VFS_PATH, START_SCRIPT, FS_TAG
    if len(sys.argv) > 1:
        VFS_PATH = sys.argv[1]
        FS_TAG = VFS_PATH.split(".")[0]
    else:
        print("Укажите путь к VFS (json)")
        return
    if len(sys.argv) > 2:
        START_SCRIPT = sys.argv[2]
    load_vfs(VFS_PATH)
    if START_SCRIPT:
        run_script(START_SCRIPT)
    repl()

if __name__ == "__main__":
    main()


