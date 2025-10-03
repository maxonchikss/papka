@echo off

where python >nul 2>nul
if errorlevel 1 (
    echo Ошибка: Python не найден в PATH.
    pause
    exit /b
)

python emulator4.py test4.json run4.txt

echo.
pause
