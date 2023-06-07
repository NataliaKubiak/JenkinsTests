package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;

//extends BasePage - I have there <Header> that's why I need to mention Header here too
//set a <MainHeaderComponent> to get this particular header through getHeader()

//after creating BaseMainHeaderPage inherit from it and remove overridden getHeader()

//add <MainPage> so we can return MainPage from BaseMainHeaderPage getHeader()

public class MainPage extends BaseMainHeaderPage<MainPage> {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewItemPage clickNewItemButton() {
        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']")).click();
        return new CreateNewItemPage(getDriver());
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
