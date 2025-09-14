import sys, json, base64
FS_TAG = "VFS"
SIGN = f"{FS_TAG}$ "
VFS = None
CWD = []
VFS_PATH = None
START_SCRIPT = None
# загрузка VFS
def load_vfs(path):
    global VFS, FS_TAG, SIGN
    try:
        with open(path, "r", encoding="utf-8") as f:
            VFS = json.load(f)
        FS_TAG = path.split("/")[-1].split("\\")[-1].split(".")[0]
        SIGN = f"{FS_TAG}$ "
    except Exception as e:
        print(f"Ошибка загрузки VFS: {e}")
        sys.exit(1)

# парсер
def split_line(inp):
    segs = inp.strip().split()
    if not segs:
        return None, []
    return segs[0], segs[1:]

def resolve(path):
    node = VFS
    parts = (path.strip("/").split("/") if path.startswith("/")
             else CWD + path.split("/"))
    res = []
    for p in parts:
        if p in ("", "."):
            continue
        if p == "..":
            if res:
                res.pop()
            node = VFS
            for r in res:
                node = node["children"][r]
            continue
        if node["type"] != "dir" or p not in node["children"]:
            raise FileNotFoundError(path)
        node = node["children"][p]
        res.append(p)
    return node, res


# ls
def cmd_ls(args):
    try:
        path = args[0] if args else "."
        node, _ = resolve(path if path != "." else "/".join(CWD))
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


# cat
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


# echo
def cmd_echo(args):
    print(" ".join(args))


# rev
def cmd_rev(args):
    if not args:
        print("")
    else:
        print(" ".join(args)[::-1])


# conf-dump
def cmd_conf(_):
    print(f"FS_PATH={VFS_PATH}")
    print(f"START_SCRIPT={START_SCRIPT}")
    print(f"CWD=/{'/'.join(CWD)}")


# mkdir
def cmd_mkdir(args):
    if not args:
        print("Ошибка mkdir: имя не указано")
        return
    name = args[0]
    try:
        node, _ = resolve("/".join(CWD) if CWD else "/")
        if name in node["children"]:
            print(f"Ошибка mkdir: {name} уже существует")
            return
        node["children"][name] = {"type": "dir", "children": {}}
    except Exception:
        print(f"Ошибка mkdir: {name}")


# rm
def cmd_rm(args):
    if not args:
        print("Ошибка rm: имя не указано")
        return
    name = args[0]
    try:
        node, _ = resolve("/".join(CWD) if CWD else "/")
        if name not in node["children"]:
            print(f"Ошибка rm: {name}")
            return
        del node["children"][name]
    except Exception:
        print(f"Ошибка rm: {name}")


# команды
def do_cmd(cmd, args):
    if cmd == "ls":
        cmd_ls(args)
    elif cmd == "cd":
        cmd_cd(args)
    elif cmd == "pwd":
        cmd_pwd(args)
    elif cmd == "cat":
        cmd_cat(args)
    elif cmd == "echo":
        cmd_echo(args)
    elif cmd == "rev":
        cmd_rev(args)
    elif cmd == "conf-dump":
        cmd_conf(args)
    elif cmd == "mkdir":
        cmd_mkdir(args)
    elif cmd == "rm":
        cmd_rm(args)
    elif cmd == "exit":
        sys.exit(0)
    else:
        print(f"unknown: {cmd}")


# script
def run_script(path):
    with open(path, encoding="utf-8") as f:
        for line in f:
            s = line.strip()
            if not s or s.startswith("#"):
                continue
            print(f"{SIGN}{s}")
            cmd, args = split_line(s)
            try:
                do_cmd(cmd, args)
            except Exception as e:
                print(f"Ошибка: {e}")

# repl
def repl():
    while True:
        try:
            line = input(SIGN)
        except EOFError:
            break
        cmd, args = split_line(line)
        if cmd:
            try:
                do_cmd(cmd, args)
            except Exception as e:
                print("oops:", e)
def main():
    global VFS_PATH, START_SCRIPT
    if len(sys.argv) > 1:
        VFS_PATH = sys.argv[1]
    if len(sys.argv) > 2:
        START_SCRIPT = sys.argv[2]
    load_vfs(VFS_PATH)
    if START_SCRIPT:
        run_script(START_SCRIPT)
    repl()


if __name__ == "__main__":
    main()
