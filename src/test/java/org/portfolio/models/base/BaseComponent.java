package org.portfolio.models.base;

//base for actual MainHeader

//<Page ...> - so our Header can have methods which return ANY Page
//<... extends BasePage..> - this Page is a child of BasePage
//< ...BasePage<?>> - this BasePage has any header but it's not important which one (we mention it here with <?> coz BasePage originally has a generic method)

//rename BaseHeaderComponent to BaseComponent (coz it can be used for any component after adding page as a generic)
public abstract class BaseComponent<Page extends BasePage<?>> extends BaseModel {

    private final Page page;

    public BaseComponent(Page page) {
        super(page.getDriver());
        this.page = page;
    }

    protected Page getPage() {
        return page;
    }
}
