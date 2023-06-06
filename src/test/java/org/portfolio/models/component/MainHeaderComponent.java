package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

//this is a header realisation (where we will have action methods)
public class MainHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderComponent(Page page) {
        super(page);
    }

    //action methods
    public Page clickLogo() {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("jenkins-head-icon"))).click();
        return getPage();
    }
}
