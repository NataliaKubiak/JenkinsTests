package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;

public class CreateNewItemPage extends BaseMainHeaderPage<CreateNewItemPage> {

    public CreateNewItemPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getOkButton() {
        return getDriver().findElement(By.id("ok-button"));
    }

    public CreateNewItemPage clickFreestyleProjectButton() {
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//li[@class='hudson_model_FreeStyleProject']"))).click();
        return this;
    }

    public CreateNewItemPage enterProjectName(String projectName) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(projectName);
        return this;
    }

    public ConfigFreestylePage chooseFreestyleProjectAndOK() {
        clickFreestyleProjectButton();
        getOkButton().click();
        return new ConfigFreestylePage(getDriver());
    }

    public CreateNewItemErrorPage chooseFreestyleProjectAndOkToErrorPage() {
        clickFreestyleProjectButton();
        getOkButton().click();
        return new CreateNewItemErrorPage(getDriver());
    }

    public CreateProjectLongNameErrorPage chooseFreestyleProjectAndOkToErrorLongNamePage() {
        clickFreestyleProjectButton();
        getOkButton().click();
        return new CreateProjectLongNameErrorPage(getDriver());
    }

    public String getWarningMessageWrongData() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("itemname-invalid"))).getText();
    }

    public String getWarningMessageEmptyInput() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("itemname-required"))).getText();
    }

    public boolean isOkButtonActive() {
        return getOkButton().isEnabled();
    }
}
