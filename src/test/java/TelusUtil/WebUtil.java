package TelusUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebUtil {

	public WebDriver driver ;
	private ExtentReports extreport;
	private ExtentTest extTest;
	private Properties prop;
	private JavascriptExecutor executor;


	public WebUtil() {

		try {
			readConfigFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// ================================================ExtentTest===========================================
	public ExtentReports initReports(String reportResultName) {
		ExtentHtmlReporter ExtHtmlRport = new ExtentHtmlReporter(reportResultName);
		ExtHtmlRport.config().setReportName("Function Reports Automation");
		ExtHtmlRport.config().setDocumentTitle("SeleniumPlayGround Functionality Reports");
		extreport = new ExtentReports();
		extreport.setSystemInfo("username", System.getProperty("user.name"));
		extreport.setSystemInfo("OS", System.getProperty("user.os"));
		extreport.setSystemInfo("Envoirment", "QA");
		extreport.attachReporter(ExtHtmlRport);
		return extreport;
	}

	public void setExtentLogger(String testcaseName) {
		extTest = extreport.createTest(testcaseName);

	}
	public void setextentExt(ExtentReports ext) {
		extreport=ext;
	}

	public void flush() {
		extreport.flush();
	}

	public void readConfigFile() throws IOException {
		prop = new Properties();
		File file = new File("PropertyFile//Config.properties");
		System.out.println(file.getAbsolutePath());
		FileInputStream fileInputStrObj;
		fileInputStrObj = new FileInputStream(file);

		try {
			prop.load(fileInputStrObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getconfigProp() {
		return prop;
	}

	// 3=========================Launch Browser==========================================//

	public WebDriver LaunchBrowser(String browsername, String msg) {
		if (browsername.equalsIgnoreCase("Chrome")) {
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\STUDENT DETAIL\\appium-cucumber-testng-poc\\src\\test\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	// ====================================Get Url// Method==================================================//
	public void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	    public  void waitForElementVisibility(WebElement locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        wait.until(ExpectedConditions.visibilityOf(locator));
	    }



}

