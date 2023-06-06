package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.models.NewItemPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewItemTests extends BaseTest {

    private final String PROJECT_NAME = "Project12345";

    @Test
    public void testFirst() throws InterruptedException {
        NewItemPage newItemPage = new MainPage(getDriver()).clickNewItemButton();
        Thread.sleep(2000);

        String actualUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "http://localhost:8080/view/all/newJob");
    }

    @Test
    public void testSecond() {
        String actualProjectName = new MainPage(getDriver())
                .clickNewItemButton()
                .enterTheNameOfTheProject(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getTheItemName();

        Assert.assertEquals(actualProjectName, "Project " + PROJECT_NAME);
    }
}
