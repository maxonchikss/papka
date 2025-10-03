@echo off

where python >nul 2>nul
if errorlevel 1 (
    echo Ошибка: Python не найден в PATH.
    pause
    exit /b
)

python emulator3.py test3.json run3.txt

pause
