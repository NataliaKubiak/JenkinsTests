package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;

public class CreateNewItemPage extends BaseMainHeaderPage<CreateNewItemPage> {

    public CreateNewItemPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewItemPage enterProjectName(String projectName) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(projectName);
        return this;
    }

    public ConfigFreestylePage chooseFreestyleProjectAndOK() {
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        return new ConfigFreestylePage(getDriver());
    }

    public CreateNewItemErrorPage chooseFreestyleProjectAndOkToErrorPage() {
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        return new CreateNewItemErrorPage(getDriver());
    }

    public CreateProjectLongNameErrorPage chooseFreestyleProjectAndOkToErrorLongNamePage() {
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        return new CreateProjectLongNameErrorPage(getDriver());
    }

    public String getWarningMessage() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("itemname-invalid"))).getText();
    }
}
