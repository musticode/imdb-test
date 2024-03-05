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
