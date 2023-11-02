package com.applitools.eyes.selenium.internet.steps.nasdaqPage;

import com.applitools.eyes.selenium.pageapi.Page;

public class BasePage_nasdaq extends Page {
    protected com.applitools.eyes.selenium.internet.steps.nasdaqPage.nasdaqSite nasdaqSite;

    public BasePage_nasdaq(String relativeUrl) {
        super(relativeUrl);
    }

    public BasePage_nasdaq(String relativeUrl, com.applitools.eyes.selenium.internet.steps.nasdaqPage.nasdaqSite nasSite) {
        super(relativeUrl, nasSite);
        this.nasdaqSite = nasSite;
    }
}
