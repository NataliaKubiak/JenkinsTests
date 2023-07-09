package org.portfolio.tests;

import org.portfolio.models.FreestyleProjectPage;
import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FreestyleProjectTest extends BaseTest {

    private final String PROJECT_NAME = "FreestyleProject" + getTimeStamp();
    private final String DESCRIPTION = "This is a description " + getTimeStamp();

    private void createFreestyleProject() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();
    }

    private void createFreestyleProjectWithDescription() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .createDescription(DESCRIPTION);
    }

    //post-condition
    @AfterMethod
    private MainPage deleteFreestyleProject() {
        new FreestyleProjectPage(getDriver()).deleteFreestyleProject();
        return new MainPage(getDriver());
    }

    @Test
    public void testOpenProjectFromDashboardVerifyNameAndDescription() {  //changed name. TODO Have to change test itself
        createFreestyleProject();

        String freestyleProjectPageTitle = new MainPage(getDriver())
                .clickFreestyleProjectOnDashboard(PROJECT_NAME)
                .getProjectPageTitle();

        Assert.assertEquals(freestyleProjectPageTitle, "Project " + PROJECT_NAME,
                "Freestyle Project page was not opened from a Dashboard.");
    }

    @Test
    public void testProjectNameAndDescriptionAreDisplayed() { //TODO add this verification to previous test
        //pre-condition
        createFreestyleProjectWithDescription();

        String freestyleProjectPageTitle = new FreestyleProjectPage(getDriver())
                .getProjectPageTitle();
        String descriptionText = new FreestyleProjectPage(getDriver())
                .getDescriptionText();

        Assert.assertTrue(freestyleProjectPageTitle.contains(PROJECT_NAME),
                "Freestyle Project Name was not displayed on the Freestyle Project Page.");
        Assert.assertEquals(descriptionText, DESCRIPTION,
                "Description was not displayed on the Freestyle Project Page.");
    }

    @Test
    public void testDisableProject() {
        createFreestyleProjectWithDescription();

        String disableWarning = new FreestyleProjectPage(getDriver())
                .clickDisableButton()
                .getDisableWarningText();

        Assert.assertTrue(disableWarning.contains("This project is currently disabled"),
                "Freestyle Project was not disabled or the Disable warning was not displayed.");
    }

    @Test
    public void testEnableProject() {
        //pre-conditions
        createFreestyleProjectWithDescription();
        new FreestyleProjectPage(getDriver()).clickDisableButton();

        boolean isDisableButtonDisplayed = new FreestyleProjectPage(getDriver())
                .clickEnableButton()
                .isDisableProjectButtonDisplayed();

        Assert.assertTrue(isDisableButtonDisplayed,
                "The Freestyle Project was not Enabled or the Disable Button was not displayed.");
    }
}
