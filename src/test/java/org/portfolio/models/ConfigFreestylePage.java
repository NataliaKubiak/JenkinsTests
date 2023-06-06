package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;
import org.portfolio.models.component.MainHeaderComponent;

public class ConfigFreestylePage extends BaseMainHeaderPage<ConfigFreestylePage> {

    public ConfigFreestylePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent<ConfigFreestylePage> getHeader() {
        return super.getHeader();
    }

    public ItemFreestyleProjectPage clickSaveWithDefaultSettings() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();
        return new ItemFreestyleProjectPage(getDriver());
    }
}
