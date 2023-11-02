package com.applitools.eyes.selenium.internet.steps.nasdaqPage;

import org.openqa.selenium.By;

public class FormNasdaqPage extends BasePage_nasdaq {

    private static final String RELATIVE_URL = "/user/login";
    public static final String TITLE_TEXT = "Login Page";

    By title = By.cssSelector("#content h2");
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("#login button");

    public FormNasdaqPage() {
        super(RELATIVE_URL);
    }

    public FormNasdaqPage(nasdaqSite site) {
        super(RELATIVE_URL, site);
    }


    public String getTitle() {
        return find(title).getText();
    }

    public FormNasdaqPage setUsername(String username) {
        find(usernameField).sendKeys(username);
        return this;
    }

    public FormNasdaqPage setPassword(String password) {
        find(passwordField).sendKeys(password);
        return this;
    }

    public FormNasdaqPage clickLoginButton() {
        find(loginButton).click();
        return this;
    }

}
