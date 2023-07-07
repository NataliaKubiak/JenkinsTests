package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseMainHeaderFooterPage;

public class BuildsPage extends BaseMainHeaderFooterPage<BuildsPage> {

    @FindBy(xpath = "//h1")
    private WebElement buildsPageTitle;

    public BuildsPage(WebDriver driver) {
        super(driver);
    }

    public String getBuildsPageTitle() {
        return getWait5().until(ExpectedConditions.visibilityOf(buildsPageTitle)).getText();
    }
}
