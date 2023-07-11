# QOTSA-API

An API for Queens of the Stone Age songs 🎸

## Requirements

Java 17 or later

Maven 3.x.x or later

## Installation

**Clone the repository**: git clone https://github.com/lambert-o/QOTSA-API

**Navigate to the project directory**: cd QOTSA-API

**Build the project**: make clean compile

## Usage

**Pull and run an image of postgres**: make local-services-up

**Start the API server**: make run

Use Postman (or any other preferred method of making API requests) to **GET** http://localhost:8080/v3/api-docs for API
documentation

A Postman collection can be found in [/assets](../assets)

## Docker

**Build image**: docker build -f Dockerfile.build -t qotsa-api .

**Run image**: docker run -p 8080:8080 qotsa-api
