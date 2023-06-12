package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class CreateNewItemErrorPage extends BaseMainHeaderFooterPage<CreateNewItemErrorPage> {

    public CreateNewItemErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }

    public String getErrorText() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='main-panel']/p"))).getText();
    }
}
