package testCases;

import org.testng.annotations.Test;
import org.testng.Assert; 

import pageObjects.AccountRegPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


    @Test(groups={"Regression", "Master"})
    public void verify_account_registration() {
        logger.info("Starting the acc_reg method");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickRegister();
            logger.info("Clicked on Register");

            AccountRegPage arp = new AccountRegPage(driver);
            logger.info("Filling details");
            arp.setFirstName(randomString().toUpperCase());
            arp.setLastName(randomString().toUpperCase());
            arp.setEmail(randomString() + "@yopmail.com");
            arp.setPassword(randomNum());
            arp.setNewsLetter();
            arp.setTermAndCondition();
            arp.continuebtn();

            String confirmMsg = arp.getConfirmationMsg();
            logger.info("Validating expected message");
            if (confirmMsg.equals("Your Account Has Been Created!")) {
                Assert.assertTrue(true);
            } else {
                logger.error("Error");
                logger.debug("Debug");
                Assert.assertTrue(false);
            }

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Test finished");

    }


}
