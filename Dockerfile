FROM openjdk:11
EXPOSE 2021
ARG JAR_FILE=target/Backend_Netflix_Clone-Tm2-2021.jar
ADD ${JAR_FILE} Backend_Netflix_Clone-Tm2-2021.jar
ENTRYPOINT ["java","-jar","/Backend_Netflix_Clone-Tm2-2021.jar"]