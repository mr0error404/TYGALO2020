# Getting Started
Simple microservice to login through the mobile number:
* When you register for the first time, the application will take your phone number and send you a verification code, and it will take your name and gender and register your account.
* After that, when the user logs in using his phone number, the login will be marked if the device used for the login process is the same as the one he logged in previously. Otherwise, he will send a verification code for verification.
* http://localhost:8080/api/user
# Request
```
  {
    "phoneNumber" :"+962781681506",
    "firstName" : "Waqar",
    "lastName" : "Khan",
    "status" : "ACTIVE",
    "pinCode" : 88765,
    "gender" : "M",
    "fcmToken" : "hjduj9-llkid-lllaip",
    "deviceId" : "hjduj9-llkid-lllaii"

}
  ```

# Response 
```
{
    "phoneNumber": "+962781681506",
    "firstName": "Waqar",
    "lastName": "Khan",
    "status": "ACTIVE",
    "pinCode": 78658,
    "gender": null,
    "fcmToken": "hjduj9-llkid-lllaiq",
    "deviceId": "hjduj9-llkid-lllaii",
    "externalId": "SM213f4fa9b842a8f8b2f7bb13b7da007f"
}
```
### Reference Documentation
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

