
# ICD Code Search Tool

Frequently when working on HIT related code I need to have a way to lookup ICD codes. 
Needed a demo app for SpringBoot and Swagger so decided to write this app to serve as an internal dev tool and example.

By default the app uses an embedded H2 database persisting to disk. DB can be changed in `application.properties`


    mvn clean package
    java -jar target/icd-search-0.0.1-SNAPSHOT.jar 

Once the application is running you need to load the data from src/main/resources/data. Destination tables should be obvious.

A swagger UI is running at:

http://localhost:8080/swagger-ui.html