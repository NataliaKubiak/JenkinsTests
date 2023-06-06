package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;
import org.portfolio.models.component.MainHeaderComponent;

public class FreestyleProjectPage extends BaseMainHeaderPage<FreestyleProjectPage> {

    public FreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent<FreestyleProjectPage> getHeader() {
        return super.getHeader();
    }

    //for post-conditions (just deletion without verification)
    public void deleteFreestyleProject() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete Project')]")).click();
        getWait5().until(ExpectedConditions.alertIsPresent()).accept();
    }
}
