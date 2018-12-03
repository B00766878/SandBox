@echo off

echo ---Deploying site


copy d:\home\site\repository\azzureapp\target\*.war  %DEPLOYMENT_TARGET%\webapps\*.war