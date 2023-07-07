package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class CreateNewItemErrorPage extends BaseMainHeaderFooterPage<CreateNewItemErrorPage> {

    @FindBy(xpath = "//h1")
    private WebElement errorPageTitle;
    @FindBy(xpath = "//div[@id='main-panel']/p")
    private WebElement errorText;

    public CreateNewItemErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(errorPageTitle)).getText();
    }

    public String getErrorText() {
        return getWait5().until(ExpectedConditions.visibilityOf(errorText)).getText();
    }
}
