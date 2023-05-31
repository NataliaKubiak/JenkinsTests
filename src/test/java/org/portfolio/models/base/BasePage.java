package org.portfolio.models.base;

import org.openqa.selenium.WebDriver;

//this is a PAGE with a header - name BaseHeaderPage
//we have the same header on all pages so we can rename BaseHeaderPage to BasePage

//<Header> - any name (should be understandable)
//<... extends BaseHeaderComponent> - limits so it's impossible to insert String or int
public abstract class BasePage<Header extends BaseHeaderComponent> extends BaseModel {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    //return ANY Header from the BaseHeader inheritance line
    //no body coz we don't know which exactly header to create
    public abstract Header getHeader();
}
