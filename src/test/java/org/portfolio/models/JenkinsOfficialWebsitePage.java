package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseModel;

public class JenkinsOfficialWebsitePage extends BaseModel {

    @FindBy(xpath = "//h1")
    private WebElement offWebsiteTitle;

    public JenkinsOfficialWebsitePage(WebDriver driver) {
        super(driver);
    }

    public String getOfficialWebsiteTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(offWebsiteTitle)).getText();
    }
}
