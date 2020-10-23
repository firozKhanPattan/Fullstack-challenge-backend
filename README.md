# Fullstack-challenge-backend
spring boot backend application

Steps to Run :

Clone this repository.

https://github.com/firozKhanPattan/Fullstack-challenge-backend.git

Please make sure, the jdk and maven versions are 1.8.x and 3.x respectively.

Build the application using the below command.

mvn clean package

Once successfully built, run the below command to bring up the services.
mvn spring-boot:run

The rest API can be accessed through the below URL.

http://localhost:8080/flight-finder/flights

If you choose to run on different port: for the fron tend to get the data from backend please update the port number in Package.json file in proxy.

The below entry has to be update in package.json file 

"proxy": "http://localhost:8080",

For SwaggerUI documentation, use the below link

http://localhost:8080/swagger-ui.html

Once this is done,

Steps to run front end:

clone the fornt end repository

Run the front end usin npm start

Access the front end using http://localhost:3000/

Note:Front end cannot be accessed with out running the service as the data is served from service.

To run from IDE:

Clone the repository and import the project into IDE.

Please make sure that lombok is installed, as lombok is used for setters and getters and logging.

Api documentation can be found from swagger-ui.html.

Api specific can be found in swagger.yml file

Run as Spring boot application.



