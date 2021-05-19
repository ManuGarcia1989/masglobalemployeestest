# Employees Mas Global Test Reclutier

---


   
----
## Content

- [Architecture used](#Architecture)
- [Technologies and tools](#Technologies)
- [Installation](#Installation)
- [API](#API)
- [Contributors](#Contributors)
- [License](#License)

----

# Architecture

- A microservice is proposed that uses lightweight protocols such as HTTP or REST API and use Redis as a Distributed Cache of High-Performance (Microservices Architecture).
- A service-oriented code architecture is proposed with routes, controllers, validators, entities and repository pattern (Clean code).
- This REST service uses a caching strategy for balanced performance of external APIs
----


## Technologies

* [Java 8] - Programming language
* [Python 3] - Programming language
* [Spring-boot] - Server
* [Spring-core] - Framework
* [Django] - Framework
* [Make GNU] - Compile Project
* [Git] - Code versioning
* [Maven] - Dependency management
* [IDEA IntelliJ] - IDE
* [H2] - Temp Database
* [GitHub] - Repository
* [JUnit] - Framework for testing
* [Mockito] - Mocker services for testing
* [Docker & Compose] - Container Framework

-------

# Installation


| Requires | URL |
| ------ | ------ |
| Python 3 | https://www.python.org/downloads/ |
| Java 8 | https://www.java.com/es/download/ |
| Git | https://git-scm.com/downloads |
| Docker | https://docs.docker.com/engine/install/ |
| Compose | https://docs.docker.com/compose/install/ |



## Build and Run containers

Run all containers
```
$ docker-compose up --build -d
```

Down containers
```
$ docker-compose down
```

## Developing application locally

### Run server
If your machine not has environments of repository then do:

```
export $(cat .env.example | grep -v ^# | xargs)
```

Use spring profiles to debug/run application not in container locally. For this reason use run command:

To run stand-alone application as a jar-file use this command:
```
java -Duser.timezone=America/Bogota -Dspring.profiles.active=local -jar build/libs/geo*jar
```

For Intellij or Any IDE editor, please setup environment variables and the following properties:
```
-Dspring.profiles.active=local
```

# API

- Base URL
```
{{ host }}/api/v1/*
```
- Employees
```
curl -L -X GET 'localhost:8080/api/v1/employees'
```
- Employee By Id
```
curl -L -X GET 'localhost:8080/api/v1/employee/{cc}'
```
- Employee Annual Salary
```
curl -L -X GET 'localhost:8080/api/v1/employee/salary/{cc}'
```
- Create Employee
```
curl -L -X POST 'localhost:8080/api/v1/create_employee' -H 'Content-Type: application/json' --data-raw '
{
  "CC": "string",
  "FirstName": "string",
  "Hourly": true,
  "HourlySalary": 0,
  "LastName": "string",
  "Position": "string"
}'
```
- Swagger
```
curl -L -X GET 'localhost:8080/swagger-ui.html'
```

# Contributors
- [Manuel Alejandro García](https://www.linkedin.com/in/manuel-alejandro-garcia-romero-01b1b1187/) - Backend Developer / Electronic Engineering

# License
This project is property of Mas Global.