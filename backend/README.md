# Spring Boot Backend

## Install

```
mvn clean package
```

## Run on local

```
mvn spring-boot:run
```

The application will be available at `http://localhost:8081`

## How to run database

This will start an empty database. The schema will be created when started the application.


Warning, the schema will be dropped and re-created each time the application starts.

By default, I add two entries; you can view them in the `data.sql` file or simply delete it.

## Packages


### Controllers

Here are the one available controllers.

### Dtos

Here will be placed the Data Transfer Objects. Objects which will be returned to the frontend instead of the database entities.

### Entities

The objects present here are the one which reflect the database structure.

### Exceptions

Here are the custom excecptions.

### Mappers

The Mapstruct mappers are present in this package.

### Repositories

The Spring JPA repositories are present in this package.

### Services

One service are available in this package. 

