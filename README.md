# 🎯 Final Project

<a id="tools"></a>
<div align="center">

<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Java.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/JUnit5.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Gradle.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Selenide.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Intelij_IDEA.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Allure_Report.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/selenoid.png" width="60" height="50">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Jenkins.svg" width="56" height="56">
<img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/rest-assured.png" width="56" height="56">

</div>

<details>
<summary>Detailed description of the technologies used in the project</summary>

> </br>
> 
> | Logo                                                                                                                               | Name                   | Purpose                                                                                                           |
> | :---:                                                                                                                              | :---:                  | :---                                                                                                              |
> | <a href="https://www.jetbrains.com/idea"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Intelij_IDEA.svg" width="64" height="64" alt="Intellij IDEA"/></a>  | `Intellij`</br>`IDEA`  | Software development environment                                                                         |
> | <a href="https://www.java.com"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Java.svg" width="64" height="64" alt="Java"/></a>                             | `Java`                 | The programming language in which the tests are written                                                                  |
> | <a href="https://junit.org/junit5"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/JUnit5.svg" width="64" height="64" alt="JUnit 5"/></a>                    | `JUnit 5`              | Unit testing framework                                                                             |
> | <a href="https://gradle.org"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Gradle.svg" width="64" height="64" alt="Gradle"/></a>                           | `Gradle`               | Automatic assembly system                                                                                     |
> | <a href="https://selenide.org"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Selenide.svg" width="64" height="64" alt="Selenide"/></a>                     | `Selenide`             | Framework for automated testing of web applications                                                     |                                                   |
> | <a href="https://www.jenkins.io"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Jenkins.svg" width="64" height="64" alt="Jenkins"/></a>                     | `Jenkins`              | software System for ensuring the continuous integration process of software                      |
> | <a href="https://allurereport.org"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/Allure_Report.svg" width="64" height="64" alt="Allure Report"/></a>              | `Allure`</br>`Report`  | Tool for visualizing test run results                                                         |                                                            |
> | <a href="https://telegram.org/"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/telegram.png" width="64" height="64" alt="Telegram"/></a>                    | `Telegram`             | Cross-platform instant messaging system (messenger)                                            |
> | <a href="https://aerokube.com/selenoid"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/selenoid.png" width="64" height="64" alt="Selenoid"/></a>            | `Selenoid`             | Server that allows to run browsers in Docker containers                                                 |                                            |
> | <a href="https://rest-assured.io/"><img src="https://github.com/1ROCKSTAR1/source/blob/main/icons/rest-assured.png" width="64" height="64" alt="Selenoid"/></a>            | `Rest Assured`             | Technology designed to simplify testing and validation of REST APIs                                                |
> 
> </details>

</br>
</br>

## Summary:

- [Technologies and tools](#tools)
- [Test coverage](#cases)
- [Local run tests](#localrun)
- [Jenkins run tests](#remoterun)
- [Allure report](#report)
- [Telegram notifications](#telegram)
- [Run tests video example from Selenoid](#video)

📚 Project's description

A framework for automated testing of the Habitica application at both the web and API levels: the web interface via Selenide and the REST API via RestAssured. The project is built on Page Object Model principles, ensuring a clean architecture and easy code maintenance.
Tests are run locally, as well as using Jenkins and Selenoid. The framework is integrated into the CI/CD pipeline via Jenkins and features a detailed Allure reporting system that clearly displays execution results, including screenshots and logs for each step.
The project uses a modern technology stack: Java 17 for writing tests, Gradle for building, JUnit 5 as a testing framework, and Lombok for reducing boilerplate code. The entire configuration is flexibly configurable via parameters, allowing you to quickly adapt tests to different environments and scenarios.

## 🛠 Technologies

Main stack:

![](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=java&logoColor=white)
![](https://img.shields.io/badge/Gradle-8.0-02303A?style=flat-square&logo=gradle&logoColor=white)
![](https://img.shields.io/badge/JUnit-5.9-25A162?style=flat-square&logo=junit5&logoColor=white)

Testing tools:

![](https://img.shields.io/badge/Selenide-7.2-43B02A?style=flat-square&logo=selenium&logoColor=white)
![](https://img.shields.io/badge/RestAssured-5.3-00A98F?style=flat-square&logo=rest&logoColor=white)
![](https://img.shields.io/badge/Selenoid-1.10-3EAAAF?style=flat-square&logo=docker&logoColor=white)

Utilities and libraries:

![](https://img.shields.io/badge/Lombok-1.18-E6B91E?style=flat-square&logo=lombok&logoColor=white)
![](https://img.shields.io/badge/Allure_Report-2.24-FF6F61?style=flat-square&logo=allure&logoColor=white)

IDE:

![](https://img.shields.io/badge/IntelliJ_IDEA-2024-000000?style=flat-square&logo=intellij-idea&logoColor=white)

CI/CD and management:

![](https://img.shields.io/badge/Jenkins-2.4-D24939?style=flat-square&logo=jenkins&logoColor=white)
![](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white)
![](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)

## 🚀Framework capabilities:


🌐 Web Testing

Selenide: A simplified and powerful framework for UI testing

Selenoid: Run tests in Docker containers for isolation and parallelism

Automatic browser management

🔁 API Testing

REST Assured: A full-featured library for REST API testing

Support for various data formats (JSON, XML)

Response schema validation

➕ Additional Features

Project Lombok: Reduce boilerplate code through annotations

Allure Report: Detailed visualization of test results

Parallel test execution

Configuration via environment variables

<a id="cases"></a>

## 📄 Test Coverage:
### 🌐 Web
◾ Login validation with valid data

◾ Login validation without a populated name field

◾ Login validation without a populated password field

◾ Login validation without populated name and password fields

◾ Task 1 added

◾ Task 2 added

◾ Check Inventory page shown

◾ Check Shops page shown

### 🔁 API
◾ Login validation with ID and token receipt

◾ Login validation with a non-existent user

◾ Login validation with an empty name

◾ Login validation with an empty password

◾ New tag creation validation

◾ New tag creation validation and deletion validation


<a id="localrun"></a>

## Running tests locally
To run WEB tests locally from the IDE or from the terminal, run the following command

```
gradle clean web_test
```

To run API tests locally from the IDE or from the terminal, you need to run the following command

```
gradle clean api_test
```

<a id="remoterun"></a>

## Run tests in [Jenkins](https://jenkins.autotests.cloud/job/%D0%A138_Aastri_Final_Project/)
To run tests in Jenkins, you need to click the Build with parameters button and select the required web/api test scope.

<p align="center">
<img src="images/screenshots/jenkins1.png">
</p>

<p align="center">
<img src="images/screenshots/jenkins2.png">
</p>

<a id="report"></a>

## [Allure report](https://jenkins.autotests.cloud/job/%D0%A138_Aastri_Final_Project/allure/)
### Graphics

<p align="center">
<img src="images/screenshots/Allure1.png">
</p>

<a id="telegram"></a>
## Telegram notifications

Following each test run, Jenkins sends a message to Telegram. The message contains information about the run and a chart with test statistics.

<p align="center">
<img src="images/screenshots/tg1.png" width="400">
</p>

<a id="video"></a>

## Video with an example of running tests in Selenoid
In the Allure report, each test includes a screenshot of the last step and a video of the test being run. Examples of such videos:

<p align="center">
<img src="images/gif/selenoid.gif " width="1000">
</p>

