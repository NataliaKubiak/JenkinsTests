package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class FreestyleProjectPage extends BaseMainHeaderFooterPage<FreestyleProjectPage> {

    public FreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    public String getProjectPageTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }

    //for post-conditions (just deletion without verification)
    public void deleteFreestyleProject() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete Project')]")).click();
        getWait5().until(ExpectedConditions.alertIsPresent()).accept();
    }
}
