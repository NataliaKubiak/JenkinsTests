package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class FreestyleProjectPage extends BaseMainHeaderFooterPage<FreestyleProjectPage> {

    @FindBy(xpath = "//h1")
    private WebElement projectPageTitle;
    @FindBy(id = "description-link")
    private WebElement addOrEditDescriptionButton;
    @FindBy(name = "description")
    private WebElement descriptionInput;
    @FindBy(name = "Submit")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@id='description']/div[1]")
    private WebElement descriptionOnTheProjectPage;
    @FindBy(xpath = "//form[@id='disable-project']/button")
    private WebElement disableProjectButton;
    @FindBy(xpath = "//form[@id='enable-project']")
    private WebElement disableWarning;
    @FindBy(xpath = "//form[@id='enable-project']/button")
    private WebElement enableButton;
    @FindBy(xpath = "//span[contains(text(), 'Delete Project')]")
    private WebElement deleteButtonSideMenu;

    public FreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    public String getProjectPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(projectPageTitle)).getText();
    }

    public FreestyleProjectPage createDescription(String description) {
        getWait5().until(ExpectedConditions.elementToBeClickable(addOrEditDescriptionButton)).click();
        getWait5().until(ExpectedConditions.elementToBeClickable(descriptionInput)).sendKeys(description);
        saveButton.click();
        return this;
    }

    public String getDescriptionText() {
        return getWait5().until(ExpectedConditions.visibilityOf(descriptionOnTheProjectPage)).getText();
    }

    public FreestyleProjectPage clickDisableButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(disableProjectButton)).click();
        return this;
    }

    public String getDisableWarningText() {
        return getWait5().until(ExpectedConditions.visibilityOf(disableWarning)).getText();
    }

    public FreestyleProjectPage clickEnableButton() {
        enableButton.click();
        return this;
    }

    public boolean isDisableProjectButtonDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(disableProjectButton)).isDisplayed();
    }

    //for post-conditions (just deletion without verification)
    public void deleteFreestyleProject() {
        deleteButtonSideMenu.click();
        getWait5().until(ExpectedConditions.alertIsPresent()).accept();
    }
}
