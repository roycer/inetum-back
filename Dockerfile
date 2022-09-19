ARG MS_NAME=builder

FROM amazoncorretto:11-alpine-jdk as build

ARG MS_NAME

WORKDIR /app/$MS_NAME

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:11-alpine-jdk

ARG MS_NAME

ARG TARGET_FOLDER=/app/$MS_NAME/target

ARG PORT_APP=8085

WORKDIR /app

COPY --from=build $TARGET_FOLDER/builder-0.0.1-SNAPSHOT.jar .

ENV PORT $PORT_APP

EXPOSE $PORT

CMD ["java", "-jar", "builder-0.0.1-SNAPSHOT.jar"]