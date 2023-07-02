# Spring-Boot-Base-API

A Maven project to use as a base upon which to build an API in Java using SpringBoot.

There are controller, domain and services layers alongside database interaction. Unit and integration testing has been implemented with code coverage enforcement.

## Requirements
Java 17 or later

Maven 3.x.x or later

## Installation

**Clone the repository**: git clone https://github.com/lambert-o/Spring-Boot-Base-API.git

**Navigate to the project directory**: cd Spring-Boot-Base-API

**Build the project**: make clean compile

## Usage

**Pull and run an image of postgres**: make local-services-up

**Start the API server**: make run

Use Postman (or any other preferred method of making API requests) to **GET** http://localhost:8080/v3/api-docs for API documentation

A Postman collection can be found in [/assets](../assets)

## Docker

**Build image**: docker build -f Dockerfile.build -t spring-boot-base-api .

**Run image**: docker run -p 8080:8080 spring-boot-base-api
