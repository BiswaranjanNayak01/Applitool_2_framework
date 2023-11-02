package com.applitools.eyes.selenium.internet.runner;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.managers.EyesBatchManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import static com.applitools.eyes.selenium.introspection.Introspect.getThreadId;


@CucumberOptions(
    features = {                // A comma-delimited list of paths to feature file dirs.
        "src/test/resources/heroku-internet/nasdaq.feature"    // Defaults to this package if left blank or blank string.
    },
    glue = {    // A comma-delimited list of packages containing step definitions.
        "com.applitools.eyes.selenium.cucumber.hooks",
//        "com.applitools.eyes.selenium.cucumber.heroku.internet.steps"
            "com.applitools.eyes.selenium.internet.steps"
    },
//    tags = "@web and @eyes" ,// A tag expression for the tests this runner will run.
    plugin = {  // A comma-delimited list of Cucumber plug-ins.
        //"html:target/cucumber.html",    // html, json and pretty are built in report formatters
        //"json:target/cucumber.json",
        "pretty" 
    }
)
public class NasdaqTestsRunner extends AbstractTestNGCucumberTests {
    private static final Logger log = LoggerFactory.getLogger(NasdaqTestsRunner.class.getName());

    private EyesBatchManager batchManager;

    public NasdaqTestsRunner() {
        this.batchManager = new EyesBatchManager();
    }
    
    @BeforeSuite
    public void openEyesBatch() {
        batchManager.setAppName("Nasdaq 2 Internet Site login");
        batchManager.setBatchName("Nasdaq 2 Internet Site Test Batch login");
        batchManager.createBatchInfo();
        log.info("Thread ID [{}] Eyes BatchID {} OPENING", getThreadId(), batchManager.batchId());
        batchManager.openEyesBatch();
        log.info("Thread ID [{}] Eyes BatchID {} OPEN", getThreadId(), batchManager.batchId());
    }
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        log.info("Thread ID [{}] Eyes BatchID {} TestNGCucumberRunner will launch {} Cucumber Scenarios!", getThreadId(), batchManager.batchId(), scenarios.length);
        return scenarios;
    }
    
    @AfterSuite
    public void closeEyesBatch() {
        log.info("Thread ID [{}] Eyes BatchID {} CLOSING", getThreadId(), batchManager.batchId());
        TestResultsSummary results = batchManager.closeEyesBatch();
        log.info("Thread ID [{}] Eyes BatchID {} CLOSED", getThreadId(), batchManager.batchId());
        batchManager.logAllTestResults(results);
    }

}
