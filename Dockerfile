FROM openjdk:8-jre-alpine
ADD target/ExamThourayaS2.jar ExamThourayaS2.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "ExamThourayaS2.jar"]