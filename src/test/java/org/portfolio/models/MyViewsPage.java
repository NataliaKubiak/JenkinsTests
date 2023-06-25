package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class MyViewsPage extends BaseMainHeaderFooterPage<MyViewsPage> {

    public MyViewsPage(WebDriver driver) {
        super(driver);
    }

    public String getMyViewsPageTitleFromBreadcrumbs() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='breadcrumbBar']//a[@href='/user/admin/my-views/']"))).getText();
    }
}
