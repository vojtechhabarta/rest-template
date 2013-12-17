rest-template
=============

This sample project shows how to combine Jersey REST framework with CDI (Contexts and Dependency Injection) to develop RESTful web services. REST resources are tested using Arquillian framework.

This is a Maven project and supports mainly these use-cases:

run in jetty
------------

    mvn jetty:run

Runs application locally using `jetty-maven-plugin`. Example resource can then be accessed on <http://localhost:8080/api/template>.

test implementation
-------------------

    mvn -Parquillian-jetty-embedded clean test

or

    mvn -Parquillian-wls-remote clean test

Deploys test deployment to embedded Jetty or remote WebLogic and runs Arquillian tests. These REST tests uses Jersey Client and are written as JUnit tests marked with custom category RealTest.

build war
---------

    mvn clean install

Creates WAR for deployment to application container. Currently used is WebLogic 12c. Only unit tests are run during build.
