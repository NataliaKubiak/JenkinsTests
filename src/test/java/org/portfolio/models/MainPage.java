package org.portfolio.models;

import org.openqa.selenium.WebDriver;
import org.portfolio.models.base.BaseMainHeaderPage;

//extends BasePage - I have there <Header> that's why I need to mention Header here too
//set a <MainHeaderComponent> to get this particular header through getHeader()

//after creating BaseMainHeaderPage inherit from it and remove overridden getHeader()

public class MainPage extends BaseMainHeaderPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //action methods
}
