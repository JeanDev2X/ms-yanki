FROM openjdk:17
VOLUME /tmp
EXPOSE 9000
ADD ./target/ms-yanki-0.0.1-SNAPSHOT.jar ms-yanki.jar
ENTRYPOINT ["java","-jar","/ms.yanki.jar"]