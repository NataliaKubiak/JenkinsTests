package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.base.BasePage;
import org.portfolio.models.component.MainHeaderComponent;

public class MainPage extends BasePage<MainHeaderComponent> {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent getHeader() {
        return new MainHeaderComponent(getDriver()); //don't see why it doesn't work without casting
    }
}
