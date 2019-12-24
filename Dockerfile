FROM maven:3.6-jdk-11 as builder
WORKDIR /app
COPY ./Zuul/ /app/
RUN mvn clean install

FROM openjdk:8
COPY --from=builder /app/target/Zuul-0.0.1-SNAPSHOT.jar /
RUN mv /Zuul-0.0.1-SNAPSHOT.jar /app.jar

VOLUME /tmp
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

