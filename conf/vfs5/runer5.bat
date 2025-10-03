@echo off

where python >nul 2>nul
if errorlevel 1 (
    echo Ошибка: Python не найден в PATH.
    pause
    exit /b
)

python emulator5.py test5.json run5.txt

echo.
pause
