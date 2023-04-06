# shared-videos-assignment

## Pre-requisites

- Java 11 or more
- Maven 3.8.1
- Youtube API key (https://console.cloud.google.com/)

## Limitations

- There is no much validation for exceptional cases
  - For example: email format, legal password
- Use RAM instead of database to store videos, users
  - Everything will be reset after restarting the application
- High level design will be considered
  - Rate limiter, Circuit breaker, retryable ...

- Don't have VISA to setup payment method for Cloud -> Couldn't deploy app to go live :(

## Default

- User:  admin@gmail.com/A123bd12df2@
