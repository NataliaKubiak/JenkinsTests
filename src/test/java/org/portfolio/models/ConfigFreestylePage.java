package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class ConfigFreestylePage extends BaseMainHeaderFooterPage<ConfigFreestylePage> {

    @FindBy(name = "Submit")
    private WebElement saveButton;

    public ConfigFreestylePage(WebDriver driver) {
        super(driver);
    }

    public FreestyleProjectPage clickSaveWithDefaultSettings() {
        getWait5().until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return new FreestyleProjectPage(getDriver());
    }
}
