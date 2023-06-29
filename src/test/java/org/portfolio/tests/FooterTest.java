package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @Test(description = "Find the version of jenkins on the footer")
    public void testJenkinsVersion() {
        String jenkinsVersion = new MainPage(getDriver())
                .getHeaderFooter()
                .getJenkinsVersionFromFooter();

        Assert.assertEquals(jenkinsVersion, "Jenkins 2.387.2",
                "Jenkins version in footer is not as expected.");
    }

    @Test(description = "Open jenkins website by clicking on the version")
    public void testJenkinsVersionLinkRedirect() {
        String officialWebsiteTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickJenkinsVersionLinkAndRedirectToOffWebsite()
                .getOfficialWebsiteTitle();

        Assert.assertTrue(officialWebsiteTitle.contains("Jenkins"));

        //TODO remove it when I write clearData()
        //post-condition
        String originalHandle = getDriver().getWindowHandle();

        for(String windowHandle : getDriver().getWindowHandles()) {
            if (!originalHandle.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Test(description = "Open REST API page by clicking on the link")
    public void testRestApiLink() {
        String restApiPageTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickRestApiLinkFooter()
                .getRestApiPageTitle();

        Assert.assertEquals(restApiPageTitle, "REST API",
                "REST API Link redirected to a wrong page.");
    }
}
