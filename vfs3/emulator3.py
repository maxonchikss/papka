# 1. Все операции должны производиться в памяти. Запрещается распаковывать
# или иным образом модифицировать данные VFS, за исключением
# возможных служебных команд.
# 2. Источником VFS является JSON-файл. Для двоичных данных используется
# base64 или аналогичный формат.
# 3. Создать несколько скриптов реальной ОС, в которой выполняется эмулятор.
# Включить в каждый скрипт вызовы эмулятора для тестирования работы c
# различными вариантами VFS (минимальный, несколько файлов, не менее 3
# уровней файлов и папок).
# 4. Создать стартовый скрипт для тестирования всех реализованных на этом и
# прошлых этапах команд. Добавить туда примеры всех режимов команд,
# включая работу с VFS и обработку ошибок.
# VFS - ditrectory, docs trouble,
# VFS$ ls ../docs/..
# oops: ../docs/..
import sys, os, json, base64

FS_TAG = "VFS"   # дефолтное имя
SIGN = f"{FS_TAG}$ "

VFS = None       # дерево файловой системы в памяти
CWD = []         # текущая директория
VFS_PATH = None
START_SCRIPT = None

# загрузка vfs
def load_vfs(path):
    global VFS
    try:
        with open(path, "r", encoding="utf-8") as f:
            VFS = json.load(f)
    except Exception as e:
        print(f"Ошибка загрузки VFS: {e}")
        sys.exit(1)

# парсер команд
def split_line(inp):
    segs = inp.strip().split()
    if not segs: return None, []
    return segs[0], segs[1:]

# разрешение пути
def resolve(path: str):
    global VFS, CWD
    if path.startswith("/"):
        parts = path.strip("/").split("/")
        res = []
    else:
        parts = CWD + path.split("/")
        res = []

    node = VFS
    for p in parts:
        if p in ("", "."):  # пусто или "."
            continue
        if p == "..":       # шаг назад
            if res:
                res.pop()
            continue
        if node["type"] != "dir" or p not in node["children"]:
            raise FileNotFoundError(path)
        node = node["children"][p]
        res.append(p)

    return node, res


# list
def cmd_ls(args):
    path = args[0] if args else "."
    node, _ = resolve(path if path != "." else "/".join(CWD))
    if node["type"] != "dir":
        print(path)
        return
    for name in node["children"]:
        print(name)

# change directory
def cmd_cd(args):
    global CWD
    if not args:
        CWD = []
        return
    _, res = resolve(args[0])
    CWD = res

# print working directory
def cmd_pwd(_):
    print("/" + "/".join(CWD))

# concatenate
def cmd_cat(args):
    if not args: return
    node, _ = resolve(args[0])
    if node["type"] != "file": return
    if node.get("mode") == "base64":
        data = base64.b64decode(node["data"]).decode("utf-8", "replace")
    else:
        data = node["data"]
    print(data, end="")

# configuration dump
def cmd_conf(_):
    print(f"FS_PATH={VFS_PATH}")
    print(f"START_SCRIPT={START_SCRIPT}")
    print(f"CWD=/{'/'.join(CWD)}")

# команды
def do_cmd(cmd, args):
    if cmd == "ls": cmd_ls(args)
    elif cmd == "cd": cmd_cd(args)
    elif cmd == "pwd": cmd_pwd(args)
    elif cmd == "cat": cmd_cat(args)
    elif cmd == "conf-dump": cmd_conf(args)
    elif cmd == "exit": sys.exit(0)
    else: print(f"unknown: {cmd}")

# выполнение скрипта
def run_script(path):
    with open(path, encoding="utf-8") as f:
        for line in f:
            s = line.strip()
            if not s or s.startswith("#"): continue
            print(f"{SIGN}{s}")
            cmd, args = split_line(s)
            try: do_cmd(cmd, args)
            except Exception as e: print(f"Ошибка: {e}")

# REPL
def repl():
    global SIGN
    while True:
        try: line = input(SIGN)
        except EOFError: break
        cmd, args = split_line(line)
        if cmd:
            try: do_cmd(cmd, args)
            except Exception as e: print("oops:", e)

def main():
    global VFS_PATH, START_SCRIPT, FS_TAG, SIGN
    if len(sys.argv) > 1:
        VFS_PATH = sys.argv[1]
        # имя берём из аргумента (без расширения, если есть)
        FS_TAG = os.path.splitext(os.path.basename(VFS_PATH))[0]
        SIGN = f"{FS_TAG}$ "
    if len(sys.argv) > 2:
        START_SCRIPT = sys.argv[2]

    load_vfs(VFS_PATH)
    if START_SCRIPT: run_script(START_SCRIPT)
    repl()

if __name__ == "__main__":
    main()


