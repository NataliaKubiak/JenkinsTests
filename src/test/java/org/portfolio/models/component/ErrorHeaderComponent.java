package org.portfolio.models.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.MainPage;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

public class ErrorHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    @FindBy(id = "jenkins-home-link")
    private WebElement jenkinsLogo;

    public ErrorHeaderComponent(Page page) {
        super(page);
    }

    public MainPage clickLogo() {
        getWait5().until(ExpectedConditions.visibilityOf(jenkinsLogo)).click();
        return new MainPage(getDriver());
    }
}
