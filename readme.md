# IMDB Test Project

### Run configurations

- Building project
```
mvn clean install
```
>Additional note to build project in your machine:
> The error message if you see, Fatal error compiling: invalid target release: 11, typically occurs when you're trying to compile your Java code using a version of Java that doesn't support the specified target release.
> 
> To resolve
> > Install java version 11 or update java version


- Running test

if application is successfully built
```
mvn clean test -DsuiteXmlFile=testng.xml
```

if application is not builded successfully
**Go to `testng.xml` file and run this file**


- Generating test report
```
mvn allure:serve
```

### Project Overview 
- In `ImdbTest`class there is test method to run the test case. Running can be done in terminal with the information is declared above or running can be done in IDE by running the testng.xml file or running the test case.
- All used pages implemented in Page Object Pattern. Pages are mapped as object, component. Page's actions are implemented in page objects
- `BasePage` class has main methods that a page can do. Clicking, sending keys to input, scroll down and etc.
- When a page is created, driver instance is injected to page object. All pages need a driver. This driver is created in `BaseTest` class
- `BaseTest` class is running at every test method runs. Before and After methods are methods that runs before and after, this annotations can be different in method, class, test levels.
- Driver instance is created when test started, as browser name driver is injected to pages. If you select firefox, firefox instance will be injected.
- All driver instance will be created in `DriverManager` class. These drivers can be incremented as needs. There can be remote or local different kind of drivers.
- `TestListener` class is listening the test methods, writes logs of test methods

#### Tech Stack

- Selenium WebDriver
- WebDriverManager
- TestNG
- Allure Test Report

