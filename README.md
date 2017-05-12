# Excilys-Computer-Database ![alt text][logo]

[logo]:http://excilysffg.cluster003.ovh.net/wp-content/uploads/2017/01/excilys495-295.png "Logo Excilys"
### What is it ?
#### Excilys-Computer-Database is a :
Complete and effective, end-to-end web application for managing large computers database.
Front-end design up-to-date and user friendly, making managing easy !
Back-end secured and using populars technologies.

### Developpers 
[Taillefer Jordan](https://github.com/jordantaillefer/)
[Matthieu Lemaile](https://github.com/MatthieuLemaile/)
[Boulanger Boris](https://github.com/borisblngr")
[Reynier Maxime](https://github.com/MaximeRnR/)



### Modules

1. Core
2. Persistence
3. Service
4. Webapp
5. CLI


### Dependencies

1. Java 8
2. Maven 3.0.5
   * --- Plugins ---
   * War 3.0.0
   * Checkstyle  2.17
   * Surefire Report 2.19.1
   * Project info 2.7
   * Clean 2.5
   * Javadoc 2.10.4
   * Compiler 3.5.1
3. Spring 4.3.7.RELEASE
   * Core
   * Context
   * Beans
   * AOP
   * Web
   * Web MVC
   * ORM
   * Transactions
   * Jdbc
   * Test
   * Data-jpa 
4. Hibernate 5.2.6.Final
5. MariaDB Connector/J 1.5.9
6. HikariCP 2.6.1
7. Slf4j API 1.7.25
8. JSTL 1.2
9. Servlet API 3.1.0
10. Mockito 1.9.5
11. Junit 4.12
12. Log4j-api 2.8.1
13. Selenium-java 3.3.1
14. Spring Security 4.2.2.RELEASE
15. Jackson-core 2.8.8
16. Jersey-media-json-jackson 2.26-b03
17. Javax.ws.rs 2.1-m05


### Rest Api

| Endpoint | Returns |
| ----- | ------ |
| <ul> <li> **Route:**  ``/computers`` </li> <li> **Method:** ``GET`` </li> <li> **Description:** Retrieve all computers matching with parameters </li> </ul> | <ul> <li> **Parameters:** </br> ``search, column, page`` </li> </br> <li> **Response body:** ``{"id":1,"name":"foo","discontinued":null,``</br>``"introduced":"1994-07-19","companyId":0,"companyName":"foo"}`` </li></ul>|
| <ul> <li> **Route:**  ``/computers/{id}`` </li> <li> **Method:** ``GET`` </li> <li> **Description:** Retrieve a signle computer with the id given in url </li> </ul> | <ul> <li> **Response body:** ``{"id":1,"name":"foo","discontinued":null,``</br>``"introduced":"1994-07-19","companyId":0,"companyName":"foo"}`` </li></ul>|
| <ul> <li> **Route:**  ``/computers`` </li> <li> **Method:** ``POST`` </li> <li> **Description:** Send the computer described in the request body </li> </ul> | <ul> <li> **Request body:** ``{"name":"foo","discontinued":null,``</br>``"introduced":null,"companyId":0,"companyName":"foo"}`` </li></ul>|
| <ul> <li> **Route:**  ``/computers`` </li> <li> **Method:** ``PUT`` </li> <li> **Description:** Send for update the computer described in the request body  </li> </ul> | <ul> <li> **Request body:** ``{"id":1 "name":"foo","discontinued":null,``</br>``"introduced":null,"companyId":0,"companyName":"foo"}`` </li></ul>|
| <ul> <li> **Route:**  ``/computers/count`` </li> <li> **Method:** ``GET`` </li> <li> **Description:** Retrieve the number of computers matching with parameters </li> </ul> | <ul> <li> **Parameters:** </br> ``search, column, page`` </li> </br> <li> **Response body:** ``1`` </li></ul>|



Links : 
[Excilys Training formation](https://github.com/excilys/training-java "Github of the formation")





