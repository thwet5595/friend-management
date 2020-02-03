# friend-management

Prerequisite for this project:

1.	Java JDK 8 
2.	Maven 
3.	Heroku Account for Deployment. 

REST API Documentation.
Demo, Application Deployed on Heroku Cloud

# Run project locally
```bash
$ git clone https://github.com/thwet5595/friend-management.git
$ cd Friends-Management/
$ mvn clean package
Run Project with .jar
$ java -jar target/*.jar 
Run Project with maven
mvn spring-boot:run

- After app is started, can access the swagger Rest Api documentation with 
   http://localhost:8080/swagger-ui.html
```

# Run Project from Heroku
```bash
- https://friend-management-thwet.herokuapp.com/swagger-ui.html
```

# Technologies Used
```bash
Java 8
SpringBoot
Spring Data JPA
Swagger RestApi Documentation
H2 inmemory Database
Heroku (Deployment)
```

# API
```bash
http://localhost:8080/api/friends
http://localhost:8080/api/list
http://localhost:8080/api/common
http://localhost:8080/api/subscribe
http://localhost:8080/api/block
http://localhost:8080/api/receiveUpdates
```
# Database
H2 database web console
 •	http://localhost:8080/console/
 
```bash
JDBC URL: `jdbc:h2:mem:firendmanagemetdb`
 User Name: `sa`
 Password:
```
