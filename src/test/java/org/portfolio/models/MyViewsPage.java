package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class MyViewsPage extends BaseMainHeaderFooterPage<MyViewsPage> {

    @FindBy(xpath = "//div[@id='breadcrumbBar']//a[@href='/user/admin/my-views/']")
    private WebElement myViewsPageTitleBreadcrumbs;

    public MyViewsPage(WebDriver driver) {
        super(driver);
    }

    public String getMyViewsPageTitleFromBreadcrumbs() {
        return getWait5().until(ExpectedConditions.visibilityOf(myViewsPageTitleBreadcrumbs)).getText();
    }
}
