package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderPage;
import org.portfolio.models.component.MainHeaderComponent;

public class ItemFreestyleProjectPage extends BaseMainHeaderPage<ItemFreestyleProjectPage> {

    public ItemFreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent<ItemFreestyleProjectPage> getHeader() {
        return super.getHeader();
    }

    public String getTheItemName() {
        String projectNameTitle =
                getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
        return projectNameTitle;
    }

}
