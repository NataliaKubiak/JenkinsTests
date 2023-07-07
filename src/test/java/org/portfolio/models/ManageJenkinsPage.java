package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class ManageJenkinsPage extends BaseMainHeaderFooterPage<ManageJenkinsPage> {

    @FindBy(xpath = "//h1")
    private WebElement jenkinsPageTitle;

    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
    }

    public String getManageJenkinsPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(jenkinsPageTitle)).getText();
    }
}
