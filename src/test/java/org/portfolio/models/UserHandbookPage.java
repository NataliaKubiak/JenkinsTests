package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class UserHandbookPage extends BaseMainHeaderFooterPage<UserHandbookPage> {

    @FindBy(xpath = "//h5[contains(text(), 'User Handbook')]")
    private WebElement userHandbookPageTitle;

    public UserHandbookPage(WebDriver driver) {
        super(driver);
    }

    public String getUserHandbookPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(userHandbookPageTitle)).getText();
    }
}
