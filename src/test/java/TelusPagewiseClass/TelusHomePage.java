package TelusPagewiseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TelusUtil.WebUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TelusHomePage {

    //	//=============================================================================================
    private WebUtil commonmethod;


    public TelusHomePage(WebUtil wu) {

        PageFactory.initElements(wu.getWebDriver(), this);
        commonmethod = wu;
    }

    @FindBy(xpath = "//span[@class='close-modal']/button[@class='imageButton ']")
    private WebElement close_popup;

    public void closePopup() {
        close_popup.click();
    }

    @FindBy(xpath = "//header[@class='hubs']//li//a[contains(text(),'On Demand')]")
    private WebElement onDemandHDR;

    public void clickOnDemandHDR() {
        commonmethod.waitForElementVisibility(onDemandHDR);
        onDemandHDR.click();
    }

    @FindBy(xpath = "//div[@class='header']//span[text()='Movies']")
    private WebElement moviesOption;

    public void clickOnMovies() {
        moviesOption.click();
    }

    @FindBy(css = "div.dropdownButton.filterDropdownButton>button")
    private WebElement filterBtn;

    public void getFilterBtn() {
        filterBtn.click();

    }

    @FindBy(xpath = "//div[@class='dropdownList ']//div[text()='Genre']//following-sibling::div//span[text()='Animated']")
    private WebElement animatedOption;

    public void clickOnAnimatedOption() {
        animatedOption.click();
    }

    @FindBy(css = "div.filter-button.filter-apply-button.filter-button-enabled")
    private WebElement applybtn;

    public void clickOnapplybtn() {
        applybtn.click();
    }

    @FindBy(xpath = "//div[@class='grid']//p[@class='subtitle']")

    List<WebElement> list = null;


    public void click18plus() {
        int sz = 0;
        sz = list.size();
        for (int i = 0; i < sz; i++) {
            WebElement webElement = list.get(i);
            scrollToElement(webElement, commonmethod.getWebDriver());
            sz = list.size();
            webElement = list.get(i);
            scrollToElement(webElement, commonmethod.getWebDriver());
            waitForElementToAppear(commonmethod.getWebDriver(), webElement);
            String txt = webElement.getText();
            if (txt.equals("18+")) {
                waits();
                JavascriptExecutor js = (JavascriptExecutor) commonmethod.getWebDriver();
                js.executeScript("arguments[0].click();", webElement);
                break;
            }
        }
    }

    @FindBy(xpath = "//span[@class='line-metadata']")
    private WebElement txt18;

    public String getTxt18plus() {
        return txt18.getText();
    }


    public static void scrollToElement(WebElement web, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", web);

    }

    public static void waitForElementToAppear(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waits() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

