# Documenting my Journey with Spring Boot and Spring Security

So my main goal is to learn more about backend development with Spring Boot. 
I have experience as a Full Stack Developer where I built many projects, but for the backend I was using Firebase and Supabase for fast deployments. 
This means I never had much experience with traditional backend development. 
I was so curious that I decided to get my hands 'dirty' and see how it works. 
That is why I am building a project with Spring Boot and Spring Security. 
The project that I am building is a JWT Authentication and Authorization system. 

I will document my journey here, so I can see my progress and also help others who are starting with Spring Boot.

So at first I will create Tasks that I need to do to break down the project into smaller tasks. 

### TODO: 
- [x] Learn about Spring Boot and Spring Security
- [x] Create the security Workflow for the project with draw.io
- [x] Create the class diagram for the project with draw.io
- [x] Create the project with Spring Initializr
  - [x] Dependencies: Spring Web, Spring Security, Spring Data JPA, PostgreSQL Driver, Lombok
- [x] Create the project structure and methodology
- [x] Connect the project to the database (I will use Supabase for this project, to connect it with PostgreSQL)
- [x] Change the application.properties file to application.yml file
- [x] Create the User entity
- [x] Implement the JWT Authentication
  - [x] Add jwt dependencies: jjwt-api, jjwt-impl, jjwt-jackson
  - [x] Create the JwtService class
  - [x] Create the JwtAuthenticationFilter class
  - [x] Create the SecurityConfiguration class
  - [x] Create the AuthenticationController class
  - [x] Create the AuthenticationService class
  - [x] Create the AuthenticationRequest class
  - [x] Create the AuthenticationResponse class
  - [x] Create the RegisterRequest class
  - [x] Create the DemoController class
  - [x] Create the Role enum
  - [x] Update the User entity
  - [x] Update the UserRepository interface
  - [x] Update the SecurityApplication class
- [x] Test the application
- [x] Document the progress
- [x] Push the code to GitHub

### Here we can see the Security Workflow for the project:
![Security Workflow](images/security-workflow.jpg)

### Here we can see the Class Diagram for the project:
![Class Diagram](images/class-diagram.jpg)

### Project Setup
I created the project with Spring Initializr and added the following dependencies:
- Spring Web
- Spring Security
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- jjwt-api // added later
- jjwt-impl // added later
- jjwt-jackson // added later

### Folder Structure and Methodology
I saw a great article on how to structure the project in a clean way and I decided to follow it.
He called it **Domain-Driven Folder Structure** (grouping related entities, repositories, and controllers),
where you create folders based on major features/domains like `user`, `product`, `order`, etc.
I think organizing your Spring Boot project with a clear and modular folder structure
is important for maintainability, readability, and scalability. This approach, in my opinion, suits me perfectly.

So, I will use the Domain-Driven Folder Structure, where I will create folders based on major features/domains like `user`, `auth`, etc.

I will also use the Service-Repository-Controller pattern, where I will create a service layer that will handle the business logic, a repository layer that will handle the database operations, and a controller layer that will handle the HTTP requests.

So for my Project, I will use the following structure:

```
src/main/java/com/
  └── dpertsin
      ├── auth
      │   ├── AuthenticationController // for authentication and authorization
      │   ├── AuthenticationRequest // request body for authentication
      │   ├── AuthenticationResponse // response body for authentication
      │   ├── AuthenticationService // service layer for authentication
      │   └── RegisterRequest // request body for registration
      ├── config
      │   ├── ApplicationConfig // application configuration
      │   ├── JwtAuthenticationFilter // filter for JWT authentication
      │   ├── JwtService // service for JWT
      │   └── SecurityConfiguration // security configuration
      ├── demo
      │   └── DemoController // for testing purposes
      ├── user
      │   ├── Role // enum for user roles
      │   ├── User // entity for user
      │   └── UserRepository // repository for user
      └── SecurityApplication // main class
```
The **auth** package contains classes related to authentication and authorization. This includes the **AuthenticationController**, which handles HTTP requests for authentication, and the **AuthenticationService**, which contains the business logic for authentication. The **AuthenticationRequest** and **AuthenticationResponse** classes represent the request and response bodies for authentication, respectively. The **RegisterRequest** class is used for user registration.

The **config** package includes configuration classes for the application. The **ApplicationConfig** class contains general application configurations, while the **SecurityConfiguration** class configures security settings. The **JwtAuthenticationFilter** is a filter for handling JWT authentication, and the **JwtService** provides methods for working with JWT tokens.

The **demo** package contains the **DemoController**, which is used for testing purposes. This controller includes endpoint to verify that the security setup is working correctly.

The **user** package includes classes related to user management. The **User** class represents the user entity, and the **UserRepository** interface provides methods for database operations related to users. The **Role** enum defines the different roles a user can have.

Finally, the **SecurityApplication** class is the main class of the Spring Boot application, which contains the main method to run the application.

### Database Connection

I also changed the `application.properties` file to `application.yml` file, because it is more readable and easy to understand.

Why I believe it is more readable and easy to understand?
- It is more readable because it is in YAML format, which is more human-readable than properties file.
- It is easy to understand because it is in a key-value pair format, which is easy to understand and write.


I connected the project to the database by adding the following properties to the `application.yml` file:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://<supabase-url> // ofcourse here I am using environment variables
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### User Entity
Now let's create a user class, I am using Lombok to reduce boilerplate code.

With Lombok we can generate getters, setters, constructors, and toString methods with just a few annotations.
So I don't have to write all these methods manually.

I created the User entity with the following fields:
- id
- firstName
- lastName
- email
- password
- roles


### Implement the JWT Authentication
I would suggest navigating the files to see the code, I have added comments to explain the code.

### What is JWT?
You can read with more details here: [jwt.io/introduction](https://jwt.io/introduction/)

JWT stands for Json Web Token. It is a compact, URL-safe means of representing claims to be transferred between two parties.

In its compact form, JSON Web Tokens consist of three parts separated by dots (.), which are:

- Header
- Payload
- Signature

Therefore, a JWT typically looks like the following: `xxxxx.yyyyy.zzzzz`

![JWT example](images/jwt.jpg)

### Test the Application
The app is finished lets test it.

First let's try to access the `/api/v1/demo` endpoint without a token.
As you can see in the image below, we got a 403 Forbidden error, which is expected because we need to be authenticated to access this endpoint.
![403 Forbidden](images/403.jpg)

Now let's try to authenticate and get the token by sending a POST request to the `/api/v1/auth/authenticate` endpoint with the following body, with the wrong credentials.

```json
{
    "email": "test@gmail.com",
    "password": "123456789"
}
```
As you can see in the image below, we got a 403 Forbidden error, which is expected because the credentials are wrong.
![401 Unauthorized](images/authenticate-with-wrong-credentials.jpg)

Now let's try to register a new user by sending a POST request to the `/api/v1/auth/register` endpoint with the following body.

```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "JohnDoe@mail.com",
    "password": "123456789"
}
```
As you can see in the image below, we got a 200 OK, which means the user was created successfully.
![200 OK](images/register.jpg)

and also we get the token in the response body.
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkcGVydHNpbkBnbWFpbC5jb20iLCJpYXQiOjE3MzM5NTMyMDEsImV4cCI6MTczMzk4OTIwMX0.S5vL67GsMgd_SfoPaSkD3pm-0ONQi4PRiUVsDSB2SSA"
}
```
if we now got to jwt and decode the token we can see the payload.
```json
{
  "sub": "dpertsin@gmail.com",
  "iat": 1733953201, // issued at
  "exp": 1733989201 // expiration time
}
```
as you can see in the image below:
![jwt.io](images/encoded.jpg)

Now let's try to authenticate and get the token by sending a POST request to the `/api/v1/auth/authenticate` endpoint with the following body, with the correct credentials.
and ofcourse we getting 200 OK and the token in the response body, as you can see in the image below:
![200 OK](images/authenticate-with-correct-credentials.jpg)


Lastly, let's try to access the `/api/v1/demo` endpoint with the token.
As you can see in the image below, we got a 200 OK and a body reposnse `Hello World, from a secured endpoint!`, which means we are authenticated and authorized to access this endpoint.
![200 OK](images/demo-access-200.jpg)

### Conclusion
I have learned a lot about Spring Boot and Spring Security while building this project.
I have learned how to create a Spring Boot project, connect it to a database, create entities, repositories, services, and controllers.
I have also learned how to implement JWT authentication and authorization with Spring Security.
I have learned how to structure a Spring Boot project in a clean and modular way.
I have learned how to test a Spring Boot application using Postman.

I hope this documentation helps others who are starting with Spring Boot and Spring Security.
Good luck with your projects! 🚀