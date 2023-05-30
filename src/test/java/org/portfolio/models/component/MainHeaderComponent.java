package org.portfolio.models.component;

import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

public class MainHeaderComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderComponent(Page page) {
        super(page);
    }

    //write action methods like click, etc.
}
