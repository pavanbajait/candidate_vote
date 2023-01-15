
## Candidate Election Vote Management 
Backend of online Candidate Election Vote Management where candidate can enter his details, can add vote in his account , can know tthe count of votes of pertcular candidate , can knbow the all candidate name & their vote counts respectively also can get the Election winner candidate name & his count vote.

## Features:

* Developed this REST API for an online Candidate Election Vote Management. This API performs all the fundamental CRUD operations of any Online Election vote Management application with all necesary validation at every step.
* Build on Springboot REST Archtecture so that classified in three layers but as in task it is mention that I have to store data in variable instead of databases I created this application in two layers name as, @Controller @Service 
* Provided all necessary validations as well as Exceptions.


## Tech Stack

* Java
* Spring Framework
* Spring Boot


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](\src\main\resources\application.properties) file. 
* Update the port number

    server.port=8080
    

## API Endpoint

1.  http://localhost:8080/entercandidate?name=ajay
2.  http://localhost:8080/castvote?name=ajay
3.  http://localhost:8080/countvote?name=ajay
4.  http://localhost:8080/listvote
5.  http://localhost:8080/getwinner

## Testing
API testing done by postman , for all request & their desired responses , please go through the postman collection file which I attached herewith.

## Contributors

👤 **Pavan Bajait**

- GitHub: [@Pavan Bajait](https://github.com/pavanbajait)

- LinkedIn: [@Pavan Bajait](https://www.linkedin.com/in/pavan-bajait/)



Footer
© 2023 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
Election-Candidate_Vote_Management/README.md at main.
