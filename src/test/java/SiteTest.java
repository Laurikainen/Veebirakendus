package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class NavigationLanguageTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();



    @Before
    public void setUp() throws Exception {
        //if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
        System.setProperty("webdriver.gecko.driver", "D:/Users/kaarel/Downloads/geckodriver-v0.23.0-win64/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("marionette", true);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test
    public void testBasicNavigationAndLanguage() throws Exception {
        driver.get("https://tron-online.herokuapp.com/");
        driver.findElement(By.linkText("Main page")).click();
        try {
            assertEquals("Game info", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Play Game")).click();
        try {
            assertEquals("Sudoku", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Forum")).click();
        try {
            assertEquals("Forum", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("User Info")).click();
        try {
            assertEquals("Upload a profile picture", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Statistics")).click();
        try {
            assertEquals("Visitors statistics", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Sitemap", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Estonian")).click();
        try {
            assertEquals("Sisukaart", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Pealeht")).click();
        try {
            assertEquals("Mängu kirjeldus", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Mängi mängu")).click();
        try {
            assertEquals("Sudoku", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Foorum")).click();
        try {
            assertEquals("Foorum", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Kasutaja Info")).click();
        try {
            assertEquals("Lae ülesse profiilipilt", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Statistika")).click();
        try {
            assertEquals("Külastajate statistika", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sisukaart")).click();
        try {
            assertEquals("Sisukaart", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sisukaart'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Inglise keel")).click();
        try {
            assertEquals("Sitemap", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
                } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSitemapFunctionality() throws Exception {
        driver.get("https://tron-online.herokuapp.com/sitemap?lang=en");
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[3]/following::a[1]")).click();
        try {
            assertEquals("Contact information", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Click for information about the developers'])[1]/following::h2[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("About us")).click();
        try {
            assertEquals("Location of Institute of Computer Science", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='About us'])[1]/following::h2[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Googles privacy policy'])[1]/following::a[1]")).click();
        try {
            assertEquals("Sudoku", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Play Game'])[2]/following::a[1]")).click();
        try {
            assertEquals("Upload a profile picture", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Upload a profile picture")).click();
        try {
            assertEquals("Upload a profile picture", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Upload a profile picture'])[1]/following::a[1]")).click();
        try {
            assertEquals("Forum", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Main page'])[2]/following::a[1]")).click();
        try {
            assertEquals("Visitors statistics", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Googles privacy policy")).click();
        try {
            assertEquals("Information Collection and Use", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy of Tron and Forums'])[1]/following::h2[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.linkText("Sitemap")).click();
        try {
            assertEquals("Functions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[2]/following::th[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testUploadingAndUser() throws Exception {
        driver.get("https://tron-online.herokuapp.com/");
        driver.findElement(By.linkText("User Info")).click();
        try {
            assertEquals("Upload a profile picture", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sitemap'])[1]/following::h1[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.id("data")).clear();
        driver.findElement(By.id("data")).sendKeys("D:\\DungeonRaider\\spCjPDr.png");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Format - jpeg, png'])[1]/following::input[2]")).click();
        try {
            driver.findElement(By.linkText("User Info")).click();
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }

        try {
            assertEquals("spCjPDr.png", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='User Info'])[2]/following::p[10]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='User Info'])[2]/following::input[1]")).click();
        try {
            assertEquals("Picture deleted", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Upload a profile picture'])[1]/following::p[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }        catch (UnhandledAlertException f) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
