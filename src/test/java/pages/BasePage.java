package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);        
    }

    public void selectFromDropdownByIndex(String locator, Integer indexToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(indexToSelect);        
    }

    public void selectFromDropdownByText(String locator, String textToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(textToSelect);        
    }

    public void hoverOverElement(String locator) {
        actions.moveToElement(find(locator));
    }

    public void doubleClick(String locator) {
        actions.doubleClick(find(locator));
    }

    public void rightClick(String locator) {
        actions.contextClick(find(locator));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameId) {
        driver.switchTo().frame(iFrameId);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }
    
    public boolean elementIsEnabled(String locator) {
        return find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator) {
        return find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }
    
}
