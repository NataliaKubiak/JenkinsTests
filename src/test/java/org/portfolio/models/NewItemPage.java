package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;

public class NewItemPage extends BaseMainHeaderPage<NewItemPage> {
    public NewItemPage(WebDriver driver) {
        super(driver);
    }

    //action methods
    public NewItemPage enterTheNameOfTheProject(String projectName) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(projectName);
        return this;
    }
}
