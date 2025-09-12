# 1. Приложение должно быть реализовано в форме консольного интерфейса
# (CLI).
# 2. Приглашение к вводу должно содержать имя VFS.
# 3. Реализовать простой парсер, который разделяет ввод на команду и
# аргументы по пробелам.
# 4. Реализовать команды-заглушки, которые выводят свое имя и аргументы: ls,
# cd.
# 5. Реализовать команду exit.

import sys
FS_TAG = "VFS"
SIGN = f"{FS_TAG}$ "
#парсер
def split_line(inp):
    segs = inp.strip().split()
    if not segs:
        return None, []
    return segs[0], segs[1:]

#обработка команд
def do_cmd(cmd: str, args: list[str]):
    if cmd == "ls":
        print(f"[ls] got: {args}")
    elif cmd == "cd":
        print(f"[cd] got: {args}")
    elif cmd == "exit":
        print("bye bro")
        sys.exit(0)
    else:
        print(f"????? unknown: {cmd}")

#цикл repl
def loop():
    while True:
        line = input(SIGN)
        if not line.strip(): #пустая строка\пробелы
            continue
        cmd, args = split_line(line)
        if cmd is None:
            continue
        try:
            do_cmd(cmd, args)
        except SystemExit:
            raise
        except Exception as e:
            print(f"oops: {e}")

def main():
    loop()

if __name__ == "__main__":
    main()


























































































































































































