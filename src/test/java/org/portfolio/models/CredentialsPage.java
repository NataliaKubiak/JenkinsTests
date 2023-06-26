package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class CredentialsPage extends BaseMainHeaderFooterPage<CredentialsPage> {

    public CredentialsPage(WebDriver driver) {
        super(driver);
    }

    public String getCredentialsPageTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }
}