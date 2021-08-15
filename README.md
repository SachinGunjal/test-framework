# sample-testframework

## Summary
Profile based Test Automation Framework
* Author : Sachin Gunjal

## Tech stack
* Java
* Spring Boot
* Selenium
* Maven
* Cucumber
* Design pattern - Page Object Model (POM)

## Running tests

* Control the dataproviderthreadcount in pom.xml against the -profile local to the desired value (To control the parallel execution)
* Command-line or From IDE terminal 
    * mvn clean test -P profile_desired, for example, mvn clean test -P local
    * Use command line argument, -DbrowserName=edge or -DbrowserName=firefox to run the test case on these browsers. for exampple. mvn clean test -P local -DbrowserName=edge
    * For debugging purposes, use @debug tag to your scenarios and run "local" profile - it is set to run on local env, if you need qa, modify pom.xml "local" profile or append -Denv=qa to override the profile setting for env, for example. mvn clean test -P local -Denv=qa
* From Configurations > choose Cucumber Java
    * Main class: io.cucumber.core.cli.Main
    * Glue: com
    * Features: path to features directory
    * VM args: -Denv=env_desired, optional -Dcucumber.filter.tags="@debug" for debugging purposes
    * Save configuration name as desired

## Test environments
* There could be possibility that we have separate environments and separate url of the application, we can use env.properties in such scenario
* Local  https://testscriptdemo.com/  
* QA - https://testscriptdemo.com/

## Improvements
* We can have multiple testng xml files in config folder to run same script on different devices, for example, I included sample mac and windows config xml
* Support for Saucelabs, BrowserStack and Selenium Grid can be included by having capabilities in conf folder under resources tab.
* Logging can be put in place  
* Page factory can be refined
* Reports can be added using allure etc
* Library can be created for common functions

## Result

![Result.PNG](Result.png)


