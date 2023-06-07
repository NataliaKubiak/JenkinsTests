package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.MainPage;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

public class ErrorHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public ErrorHeaderComponent(Page page) {
        super(page);
    }

    public MainPage clickLogo() {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("jenkins-home-link"))).click();
        return new MainPage(getDriver());
    }
}
