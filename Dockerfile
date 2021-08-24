FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine as build
WORKDIR /project
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw clean install package -DskipTests
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine as runtime
# Approach 1
RUN mkdir /app
COPY --from=build /project/target/*.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
# Approach 2
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
#ARG DEPENDENCY=/project/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.ifisolution.ci_cd_demo.CiCdDemoApplication"]