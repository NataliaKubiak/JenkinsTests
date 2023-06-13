package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseModel;

public class JenkinsOfficialWebsitePage extends BaseModel {

    public JenkinsOfficialWebsitePage(WebDriver driver) {
        super(driver);
    }

    public String getOfficialWebsiteTitle() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h1"))).getText();
    }
}
