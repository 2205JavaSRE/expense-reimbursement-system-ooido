FROM maven as build
COPY ./ ./

RUN mvn clean package

FROM openjdk:8-jre

COPY --from=build /target/ExpenseReimbursementSystem-1.0-SNAPSHOT-jar-with-dependencies.jar ./ers.jar

ENV db_url=jdbc:postgresql://database-1.cfec5btl1x1y.us-west-2.rds.amazonaws.com:5432/postgres
ENV db_username=postgres
ENV db_password=fakepass

CMD ["java","-jar","/ers.jar"]
