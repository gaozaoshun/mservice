@echo off
start javaw -jar C:\Users\Administrator\Desktop\mservice\eureka\target\eureka-0.0.1-SNAPSHOT.jar
start javaw -jar C:\Users\Administrator\Desktop\mservice\config\target\config-0.0.1-SNAPSHOT.jar
TIMEOUT /T 5
start javaw -jar C:\Users\Administrator\Desktop\mservice\product\server\target\server-1.0-SNAPSHOT.jar
