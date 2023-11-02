package com.applitools.eyes.selenium.internet.steps.nasdaqPage;

import com.applitools.eyes.selenium.managers.WebDriverManager;
import com.applitools.eyes.selenium.pageapi.Site;

public class nasdaqSite extends Site {
    public static final String baseUrl = "https://www.nasdaq.com";

    public nasdaqSite(WebDriverManager driverManager) {
        super(driverManager, baseUrl);
    }

}
