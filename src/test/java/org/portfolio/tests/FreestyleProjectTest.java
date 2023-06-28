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
    private FreestyleProjectPage deleteFreestyleProject() {
        new FreestyleProjectPage(getDriver()).deleteFreestyleProject();
        return new FreestyleProjectPage(getDriver());
    }

    @Test
    public void testOpenFreestyleProjectFromDashboard() {
        createFreestyleProject();

        String freestyleProjectPageTitle = new MainPage(getDriver())
                .clickFreestyleProjectOnDashboard(PROJECT_NAME)
                .getProjectPageTitle();

        Assert.assertEquals(freestyleProjectPageTitle, "Project " + PROJECT_NAME,
                "Freestyle Project page was not opened from a Dashboard.");
    }

    @Test
    public void testProjectNameAndDescriptionAreDisplayed() {
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
    public void testDisableFreestyleProject() {
        createFreestyleProjectWithDescription();

        String disableWarning = new FreestyleProjectPage(getDriver())
                .clickDisableButton()
                .getDisableWarning();

        Assert.assertTrue(disableWarning.contains("This project is currently disabled"),
                "Freestyle Project was not disabled or the Disable warning was not displayed.");
    }

    @Test
    public void testEnableFreestyleProject() {
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
