package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class CreateNewItemPage extends BaseMainHeaderFooterPage<CreateNewItemPage> {

    @FindBy(id = "ok-button")
    private WebElement okButton;
    @FindBy(xpath = "//li[@class='hudson_model_FreeStyleProject']")
    private WebElement freestyleProjectButton;
    @FindBy(id = "name")
    private WebElement projectNameInput;
    @FindBy(id = "itemname-invalid")
    private WebElement warningMessageWrongData;
    @FindBy(id = "itemname-required")
    private WebElement warningMessageEmptyInput;

    public CreateNewItemPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewItemPage clickFreestyleProjectButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(freestyleProjectButton)).click();
        return this;
    }

    public CreateNewItemPage enterProjectName(String projectName) {
        getWait5().until(ExpectedConditions.visibilityOf(projectNameInput)).sendKeys(projectName);
        return this;
    }

    public ConfigFreestylePage chooseFreestyleProjectAndOK() {
        clickFreestyleProjectButton();
        okButton.click();
        return new ConfigFreestylePage(getDriver());
    }

    public CreateNewItemErrorPage chooseFreestyleProjectAndOkToErrorPage() {
        clickFreestyleProjectButton();
        okButton.click();
        return new CreateNewItemErrorPage(getDriver());
    }

    public CreateProjectLongNameErrorPage chooseFreestyleProjectAndOkToErrorLongNamePage() {
        clickFreestyleProjectButton();
        okButton.click();
        return new CreateProjectLongNameErrorPage(getDriver());
    }

    public String getWarningMessageWrongData() {
        return getWait5().until(ExpectedConditions.visibilityOf(warningMessageWrongData)).getText();
    }

    public String getWarningMessageEmptyInput() {
        return getWait5().until(ExpectedConditions.visibilityOf(warningMessageEmptyInput)).getText();
    }

    public boolean isOkButtonActive() {
        return okButton.isEnabled();
    }
}
