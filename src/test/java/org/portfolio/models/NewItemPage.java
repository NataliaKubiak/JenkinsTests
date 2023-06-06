package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;
import org.portfolio.models.component.MainHeaderComponent;

public class NewItemPage extends BaseMainHeaderPage<NewItemPage> {

    public NewItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent<NewItemPage> getHeader() {
        return super.getHeader();
    }

    //action methods
    public NewItemPage enterTheNameOfTheProject(String projectName) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(projectName);
        return this;
    }

    public ConfigFreestylePage chooseFreestyleProjectAndOK() {
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        return new ConfigFreestylePage(getDriver());
    }
}
