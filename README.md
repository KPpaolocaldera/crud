# Crud

Crud is the first application implemented in the SpringBoot with Kotlin training path. The application is focused on building a simple REST API by exploiting the typical three-layer structure of the SpringBoot backend app: controller, service, and repository. The Spring libraries exploited for the project are:
* [SpringBoot Dev Tools](https://docs.spring.io/spring-boot/reference/using/devtools.html), for the basic development tools
* [Spring Web](https://docs.spring.io/spring-boot/reference/web/index.html), for building a RESTful web services
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa), for interacting with a database
* [Spring Doc](https://springdoc.org/), for building an Open Api documentation.

The project demonstrates also the interaction via Spring Data JPA to a PostgreSQL database: the communication is handled by the JpaRepository interface.

## Getting Started

To clone the repository, use the command

$ git clone https://github.com/KPpaolocaldera/crud.git
or a tool for cloning the repository, which can also be the IDE itself.

Then, run the application without any further modification.
Use the postman collection attached below to perform REST HTTP calls to the endpoints exposed by the application.



## Documentation

The Open Api documentation of the application is accessible at the url [http://localhost:8080/kp/crud/swagger-ui.html](http://localhost:8080/kp/crud/swagger-ui.html). Inside the documentation, you can access the single endpoints and try to execute them directly from the web browser. The source code of the documentation is accessible at the link [/kp/crud/v3/api-docs](/kp/crud/v3/api-docs), below the API title.
