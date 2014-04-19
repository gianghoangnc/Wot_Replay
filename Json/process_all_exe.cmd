@echo off
for /f %%f in ('dir /b .\*.wotreplay') do .\dist\wotrp2j.exe .\%%f -f -r
pause