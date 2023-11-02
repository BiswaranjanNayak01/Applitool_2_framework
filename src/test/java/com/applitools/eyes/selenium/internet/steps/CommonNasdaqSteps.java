package com.applitools.eyes.selenium.internet.steps;

import com.applitools.eyes.options.LayoutBreakpointsOptions;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.selenium.internet.steps.nasdaqPage.nasdaqSite;
import com.applitools.eyes.selenium.managers.EyesManager;
import com.applitools.eyes.selenium.pageapi.PageTest;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.applitools.eyes.selenium.introspection.Introspect.getThreadId;

public class CommonNasdaqSteps extends PageTest {
    private static final Logger log = LoggerFactory.getLogger(CommonNasdaqSteps.class);

    protected final nasdaqSite site;
    private final EyesManager eyesManager;


    public CommonNasdaqSteps(nasdaqSite site, EyesManager eyesManager) {
        super(site);
        this.site = site;
        this.eyesManager = eyesManager;
    }

    @Then("check the {string} step with eyes in Nasdaq")
    public void checkWithEyes(String step) {
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
        eyesManager.eyes().check(Target.window().withName(step));
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
    }
    @Then("check the {string} step with eyes in Nasdaq with eyes name")
    public void checkWithEye(String step) {
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
        eyesManager.eyes("Biswa_eyes").check(Target.window().withName(step));
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
    }

    @Then("check the {string} page for all layout breakpoints in Nasdaq")
    public void checkWithEyesLayoutBreakpoints(String step) {
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
        eyesManager.eyes().check(Target.window().layoutBreakpoints(new LayoutBreakpointsOptions().breakpoints(true).reload()).withName(step));
        log.info("Thread ID [{}] checking the page for step '{}'", getThreadId(), step);
    }

}
