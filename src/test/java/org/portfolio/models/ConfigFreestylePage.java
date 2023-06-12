package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class ConfigFreestylePage extends BaseMainHeaderFooterPage<ConfigFreestylePage> {

    public ConfigFreestylePage(WebDriver driver) {
        super(driver);
    }

    public FreestyleProjectPage clickSaveWithDefaultSettings() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();
        return new FreestyleProjectPage(getDriver());
    }
}
