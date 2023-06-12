package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.component.MainHeaderFooterComponent;

//base class - page + exact MainHeaderComponent
//we should pass as a generic Page itself (coz MainHeaderComp has <Page> -> add <Self> instead of <Page> coz it's more understandable
public abstract class BaseMainHeaderFooterPage<Self extends BasePage<?>> extends BasePage<MainHeaderFooterComponent<Self>> {

    public BaseMainHeaderFooterPage(WebDriver driver) {
        super(driver);
    }

    //instead of getDriver() we pass page itself -> (this)
    @Override
    public MainHeaderFooterComponent<Self> getHeaderFooter() {
        return new MainHeaderFooterComponent<>((Self) this);
    }
}
