package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.component.ErrorHeaderComponent;

public abstract class BaseErrorHeaderPage<Self extends BasePage<?>> extends BasePage<ErrorHeaderComponent<Self>> {

    public BaseErrorHeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ErrorHeaderComponent<Self> getHeader() {
        return new ErrorHeaderComponent<>((Self) this);
    }
}
