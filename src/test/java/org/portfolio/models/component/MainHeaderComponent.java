package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.MainPage;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

//this is a header realisation (where we will have action methods)
public class MainHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderComponent(Page page) {
        super(page);
    }

    //action methods
    public MainPage clickLogo() {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("jenkins-home-link"))).click();
        return new MainPage(getDriver());
    }
}
