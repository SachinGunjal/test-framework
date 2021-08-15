package com.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Currently executing -> " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Execution completed -> " + scenario.getName() + " : " + (!scenario.isFailed() ? "passed" : "failed"));
    }
}
