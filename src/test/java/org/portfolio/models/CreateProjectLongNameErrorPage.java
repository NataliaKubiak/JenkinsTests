package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.base.BaseErrorHeaderPage;

public class CreateProjectLongNameErrorPage extends BaseErrorHeaderPage<CreateProjectLongNameErrorPage> {

    @FindBy(xpath = "//h2")
    private WebElement problemText;

    public CreateProjectLongNameErrorPage(WebDriver driver) {
        super(driver);
    }

    public String getProblemText() {
        return getWait5().until(ExpectedConditions.visibilityOf(problemText)).getText();
    }
}
