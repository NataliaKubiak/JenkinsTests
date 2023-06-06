package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewItemTest extends BaseTest {

    private final String PROJECT_NAME = "Project12345";

    @Test
    public void testCreateNewFreestyleProject() {
        boolean freestyleProjectIsPresent = new MainPage(getDriver())
                .clickNewItemButton()
                .enterTheNameOfTheProject(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeader()
                .clickLogo()
                .itemIsDisplayedOnDashboard(PROJECT_NAME);

        Assert.assertTrue(freestyleProjectIsPresent, "Freestyle Project with a name " + PROJECT_NAME
                + "is not displayed on Dashboard");

        //post-condition
        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }
}
