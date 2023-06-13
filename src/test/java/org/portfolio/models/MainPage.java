package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

//extends BasePage - I have there <Header> that's why I need to mention Header here too
//set a <MainHeaderComponent> to get this particular header through getHeader()

//after creating BaseMainHeaderPage inherit from it and remove overridden getHeader()

//add <MainPage> so we can return MainPage from BaseMainHeaderPage getHeader()

public class MainPage extends BaseMainHeaderFooterPage<MainPage> {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMainPageTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }

    public CreateNewItemPage clickNewItemButton() {
        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        return new CreateNewItemPage(getDriver());
    }

    public ManageJenkinsPage clickManageJenkinsButton() {
        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/manage']"))).click();
        return new ManageJenkinsPage(getDriver());
    }

    public boolean itemIsDisplayedOnDashboard(String itemName) {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("job_" + itemName))).isDisplayed();
    }

    public FreestyleProjectPage clickFreestyleProjectOnDashboard(String itemName) {
        getDriver().findElement(By.xpath("//a[@href='job/"+ itemName + "/']")).click();
        return new FreestyleProjectPage(getDriver());
    }
}
