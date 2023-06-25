package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class UserConfigPage extends BaseMainHeaderFooterPage<UserConfigPage> {

    public UserConfigPage(WebDriver driver) {
        super(driver);
    }

    public String getUserConfigPageTitleFromBreadcrumbs() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='breadcrumbBar']//li[@aria-current='page']"))).getText();
    }
}
