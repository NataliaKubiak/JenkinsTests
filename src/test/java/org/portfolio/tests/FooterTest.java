package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @Test
    public void testJenkinsVersion() {
        String jenkinsVersion = new MainPage(getDriver())
                .getHeaderFooter()
                .getJenkinsVersionFromFooter();

        Assert.assertEquals(jenkinsVersion, "Jenkins 2.387.2",
                "Jenkins version in footer is not as expected.");
    }

    //TODO rewrite this test so it will switch tab to the off website tab
//    @Test
//    public void testJenkinsVersionLinkRedirect() {
//        String officialWebsiteTitle = new MainPage(getDriver())
//                .getHeaderFooter()
//                .clickJenkinsVersionLinkAndRedirectToOffWebsite()
//                .getOfficialWebsiteTitle();
//
//        Assert.assertTrue(officialWebsiteTitle.contains("Jenkins"));
//    }

    @Test
    public void testRestApiLink() {
        String restApiPageTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickRestApiLinkFooter()
                .getRestApiPageTitle();

        Assert.assertEquals(restApiPageTitle, "REST API",
                "REST API Link redirected to a wrong page.");
    }
}
