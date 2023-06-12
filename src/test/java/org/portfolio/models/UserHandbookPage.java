package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class UserHandbookPage extends BaseMainHeaderFooterPage<UserHandbookPage> {

    public UserHandbookPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h5[contains(text(), 'User Handbook')]"))).getText();
    }
}
