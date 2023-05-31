package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//this was BasePage
//renamed to BaseModel coz Pages and Headers should have the same parent (which has waiters and driver)

public abstract class BaseModel {

    private final WebDriver driver;
    private WebDriverWait wait5;

    public BaseModel(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait5() {
        if(wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait5;
    }
}
