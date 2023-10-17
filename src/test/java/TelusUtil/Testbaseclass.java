package TelusUtil;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

public class Testbaseclass {

	protected WebUtil util=  new WebUtil();
	protected Properties prop;
	private ExtentReports ext;
	
	
	@BeforeSuite
	public void applicationOpen() {
		prop= util.getconfigProp();
		

	}
	
	@BeforeClass
	public	void launchBrouser(ITestContext name) throws InterruptedException {
		prop= util.getconfigProp();
		util.LaunchBrowser(prop.getProperty("BrowserName"), "Browser selected from prperty file");
		Thread.sleep(3000);
		util.getUrl("https://telustvplus.com/#/");
	}
	
	@BeforeMethod()
	public void login(Method name) throws Exception {
		ext=util.initReports(System.getProperty("user.dir")+"/NewReport/"+name.getName()+"html");
		util.setextentExt(ext);
		util.setExtentLogger(name.getName());
		
	}
	
	 @AfterMethod
		public void Report() {
	    	util.flush();
	    	util.getWebDriver().quit();
		}
}
