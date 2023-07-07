package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class RestApiPage extends BaseMainHeaderFooterPage<RestApiPage> {

    @FindBy(xpath = "//h1")
    private WebElement restApiPageTitle;

    public RestApiPage(WebDriver driver) {
        super(driver);
    }

    public String getRestApiPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(restApiPageTitle)).getText();
    }
}
