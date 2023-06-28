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

    public FreestyleProjectPage createDescription(String description) {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.id("description-link"))).click();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.name("description"))).sendKeys(description);
        getDriver().findElement(By.name("Submit")).click();
        return this;
    }

    public String getDescriptionText() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='description']/div[1]"))).getText();
    }

    public FreestyleProjectPage clickDisableButton() {
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//form[@id='disable-project']/button"))).click();
        return this;
    }

    public String getDisableWarning() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//form[@id='enable-project']"))).getText();
    }

    public FreestyleProjectPage clickEnableButton() {
        getDriver().findElement(By.xpath("//form[@id='enable-project']/button")).click();
        return this;
    }

    public boolean isDisableProjectButtonDisplayed() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//form[@id='disable-project']/button"))).isDisplayed();
    }

    //for post-conditions (just deletion without verification)
    public void deleteFreestyleProject() {
        getDriver().findElement(By.xpath("//span[contains(text(), 'Delete Project')]")).click();
        getWait5().until(ExpectedConditions.alertIsPresent()).accept();
    }
}
