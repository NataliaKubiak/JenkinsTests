package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class UsersPage extends BaseMainHeaderFooterPage<UsersPage> {

    @FindBy(xpath = "//h1")
    private WebElement usersPageTitle;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public String getUsersPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(usersPageTitle)).getText();
    }
}
