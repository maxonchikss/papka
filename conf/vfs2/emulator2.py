# 1. Параметры командной строки:
# – Путь к физическому расположению VFS.
# – Путь к стартовому скрипту.
# 2. Стартовый скрипт для выполнения команд эмулятора: выполняет команды
# последовательно, ошибочные строки пропускает. При выполнении скрипта
# на экране отображается как ввод, так и вывод, имитируя диалог с
# пользователем.
# 3. Сообщить об ошибке во время исполнения стартового скрипта.
# 4. Реализовать вывод параметров эмулятора в формате ключ-значение с
# помощью служебной команды conf-dump.
# 5. Создать несколько скриптов реальной ОС, в которой выполняется эмулятор.
# Включить в каждый скрипт вызовы эмулятора для тестирования всех
# поддерживаемых параметров командной строки.
import sys
import os

FS_TAG = "VFS"
SIGN = f"{FS_TAG}$ "

VFS_PATH = None
START_SCRIPT = None

# парсер
def split_line(inp):
    segs = inp.strip().split()
    if not segs:
        return None, []
    return segs[0], segs[1:]

# обработка команд
def do_cmd(cmd: str, args: list[str]):
    global VFS_PATH, START_SCRIPT

    if cmd == "ls":
        try:
            items = os.listdir(os.getcwd())
            print("\n".join(items))
        except Exception as e:
            print(f"Ошибка ls: {e}")

    elif cmd == "cd":
        if not args:
            print("cd: путь не указан")
            return
        try:
            os.chdir(args[0])
            print(f"Текущая директория: {os.getcwd()}")
        except Exception as e:
            print(f"Ошибка cd: {e}")

    elif cmd == "exit":
        print("bye bro")
        sys.exit(0)

    elif cmd == "conf-dump":
        print(f"FS_PATH = {VFS_PATH}")
        print(f"START_SCRIPT = {START_SCRIPT}")

    else:
        print(f"????? unknown: {cmd}")

# выполнение скрипта
def run_start_script(script_path):
    if not os.path.isfile(script_path):
        print(f"Стартовый скрипт '{script_path}' не найден!")
        return
    print(f"=== Выполнение стартового скрипта: {script_path} ===")
    with open(script_path, "r") as f:
        for line in f:
            line = line.strip()
            if not line or line.startswith("#"):
                continue
            print(f"{SIGN}{line}")
            cmd, args = split_line(line)
            if cmd is None:
                continue
            try:
                do_cmd(cmd, args)
            except SystemExit:
                raise
            except Exception as e:
                print(f"Ошибка в строке '{line}': {e}")

# исключения
def loop():
    while True:
        line = input(SIGN)
        if not line.strip():
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


# main
def main():
    global VFS_PATH, START_SCRIPT, FS_TAG, SIGN

    if len(sys.argv) > 1:
        FS_TAG = sys.argv[1]
        SIGN = f"{FS_TAG}$ "
        VFS_PATH = sys.argv[1]

    if len(sys.argv) > 2:
        START_SCRIPT = sys.argv[2]

    print("=== Эмулятор запущен с параметрами ===")
    print(f"VFS_PATH = {VFS_PATH}")
    print(f"START_SCRIPT = {START_SCRIPT}")
    print("======================================")

    # скрипт
    if START_SCRIPT:
        run_start_script(START_SCRIPT)
    loop()

if __name__ == "__main__":
    main()

    
