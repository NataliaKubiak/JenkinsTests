package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.component.MainHeaderComponent;

//base class - page + exact MainHeaderComponent
//we should pass as a generic Page itself (coz MainHeaderComp has <Page> -> add <Self> instead of <Page> coz it's more understandable
public abstract class BaseMainHeaderPage<Self extends BasePage<?>> extends BasePage<MainHeaderComponent<Self>> {

    public BaseMainHeaderPage(WebDriver driver) {
        super(driver);
    }

    //instead of getDriver() we pass page itself -> (this)
    @Override
    public MainHeaderComponent<Self> getHeader() {
        return new MainHeaderComponent<>((Self) this);
    }
}
