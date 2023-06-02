package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

//this is a header realisation (where we will have action methods)
public class MainHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderComponent(Page page) {
        super(page);
    }

    //action methods
    public Page clickNotificationIcon() {
        getDriver().findElement(By.id("visible-am-button")).click();
        return getPage();
    }
}
