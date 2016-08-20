College Search and Match System
=============



## Dev Environment

* 

* 

* Git


## Setup

* Github repository

https://github.com/yiminliu/collegeSearchAndMatch

* Install maven, jdk 6, and curl


```

* Project Files

```sh
# clone repo
git clone https://github.com/yiminliu/collegeSearchAndMatch.git

cd bedlogic
```

## Run
* Building

```sh
mvn clean package
```

* Running/Stopping

```sh
mvn jetty:run
# To stop, type Ctrl+c on the Jetty shell console
```

* Verify

```sh
# If the curl command is executed from a host other than the server, replace localhost by the dns name or ip of the server.
curl --get http://localhost:8080/

# The accounts endpoint. Replace <customer-code> with the desired account. ie 411703
curl --get http://localhost:8080/<customer-code>
```


## Acknowledgements
BedLogic makes use of the following third-party open source libraries:

* Jetty (http://www.eclipse.org/jetty) - HTTP server
* Jersey (https://jersey.java.net) - JAX-RS REST implementation
* Spring Framework (http://projects.spring.io/spring-framework) - Application features: Dependency Injection, IOC, Data Access via ODBC, and spring-test module for integration testing
* JUnit (http://junit.org) - Testing framework
* Mockito (http://code.google.com/p/mockito/) - Mocking framework
* SLF4J (http://www.slf4j.org) and Logback (http://logback.qos.ch) - Logging api via SLF4J, and implementation via Logback.
