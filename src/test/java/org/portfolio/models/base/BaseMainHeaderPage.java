package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.component.MainHeaderComponent;

//base class - page + exact MainHeaderComponent
public abstract class BaseMainHeaderPage extends BasePage<MainHeaderComponent> {

    public BaseMainHeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent getHeader() {
        return new MainHeaderComponent(getDriver());
    }
}
