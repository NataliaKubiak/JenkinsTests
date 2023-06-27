package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FreestyleProjectTest extends BaseTest {

    private final String PROJECT_NAME = "FreestyleProject" + getTimeStamp();

    private void createFreestyleProject() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();
    }

    @Test
    public void testOpenFreestyleProjectFromDashboard() {
        createFreestyleProject();

        String freestyleProjectPageTitle = new MainPage(getDriver())
                .clickFreestyleProjectOnDashboard(PROJECT_NAME)
                .getProjectPageTitle();

        Assert.assertEquals(freestyleProjectPageTitle, "Project " + PROJECT_NAME,
                "Freestyle Project page was not opened from a Dashboard");
    }
}
