package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class UserConfigPage extends BaseMainHeaderFooterPage<UserConfigPage> {

    @FindBy(xpath = "//div[@id='breadcrumbBar']//li[@aria-current='page']")
    private WebElement userConfigPageTitleBreadcrumbs;

    public UserConfigPage(WebDriver driver) {
        super(driver);
    }

    public String getUserConfigPageTitleFromBreadcrumbs() {
        return getWait5().until(ExpectedConditions.visibilityOf(userConfigPageTitleBreadcrumbs)).getText();
    }
}
