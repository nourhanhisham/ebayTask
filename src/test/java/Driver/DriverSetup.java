package Driver;

import Data.LoadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;

public class DriverSetup {
    protected static WebDriver driver;

    String browser = LoadProperties.userData.getProperty("Browser");
    public static final String URL = "";

    public static void driverConf(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = null;

        if (browser.toLowerCase().equals("firefox")) {
            capabilities = capabilitiesFirefox(capabilities);
            driver = new FirefoxDriver(capabilities);
        } else if (browser.toLowerCase().equals("chrome")) {
            capabilities = capabilitiesChrome(capabilities);
            driver = new ChromeDriver(capabilities);
        }
    }


    public static DesiredCapabilities capabilitiesFirefox(DesiredCapabilities capabilities) {
        WebDriverManager.firefoxdriver().setup();

        capabilities = DesiredCapabilities.firefox();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.http.phishy-userpass-length", 255);
        profile.setEnableNativeEvents(true);
        profile.setAcceptUntrustedCertificates(true);

        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        return capabilities;
    }

    public static DesiredCapabilities capabilitiesChrome(DesiredCapabilities capabilities) {
        String downloadFilepath = System.getProperty("user.dir") + System.getProperty("file.separator") + "target" + System.getProperty("file.separator");
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("enableNetwork", "true");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("test-type");
        option.addArguments("--start-maximized");
        option.setExperimentalOption("prefs", chromePrefs);
        option.addArguments("--browser.download.folderList=2");
        option.addArguments(
                "--browser.helperApps.neverAsk.saveToDisk=image/jpg,text/csv,text/xml,application/xml,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/excel,application/pdf");
        option.addArguments("--browser.download.dir=" + downloadFilepath);
        option.addArguments("allow-running-insecure-content");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return capabilities;
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
