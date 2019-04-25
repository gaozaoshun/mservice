FROM hub.c.163.com/library/java:8-alpine

ADD target/*.jar app.jar

EXPOSE 10000

ENTRYPOINT ["java","-jar","/app.jar"]