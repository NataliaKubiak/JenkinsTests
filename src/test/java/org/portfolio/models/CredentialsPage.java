package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class CredentialsPage extends BaseMainHeaderFooterPage<CredentialsPage> {

    @FindBy(xpath = "//h1")
    private WebElement credentialsPageTitle;

    public CredentialsPage(WebDriver driver) {
        super(driver);
    }

    public String getCredentialsPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(credentialsPageTitle)).getText();
    }
}
