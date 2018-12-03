@echo off

echo ---Deploying site


copy d:\home\site\repository\SandBox\target\*.war  %DEPLOYMENT_TARGET%\webapps\*.war