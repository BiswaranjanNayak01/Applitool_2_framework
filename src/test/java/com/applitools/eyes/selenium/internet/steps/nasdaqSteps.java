package com.applitools.eyes.selenium.internet.steps;

import com.applitools.eyes.selenium.internet.steps.nasdaqPage.FormNasdaqPage;
import com.applitools.eyes.selenium.internet.steps.nasdaqPage.nasdaqSite;
import com.applitools.eyes.selenium.pageapi.PageTest;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.applitools.eyes.selenium.introspection.Introspect.getThreadId;

public class nasdaqSteps extends PageTest {
    private static final Logger log = LoggerFactory.getLogger(nasdaqSteps.class.getName());

    private FormNasdaqPage FormNasdaqPage;

    public nasdaqSteps(nasdaqSite site) {
        super(site);
        this.FormNasdaqPage = new FormNasdaqPage(site);
    }

    @Given("I am on the Nasdaq home page")
    public void loadFormAuthenticationPage() {
        log.info("Thread ID [{}] loading Form Authentication page", getThreadId());
        site.load(FormNasdaqPage);
    }
}
