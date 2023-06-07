package org.portfolio.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseErrorHeaderPage;

public class CreateProjectLongNameErrorPage extends BaseErrorHeaderPage<CreateProjectLongNameErrorPage> {

    public CreateProjectLongNameErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getProblemText() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h2"))).getText();
    }
}
