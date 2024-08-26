package org.base;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver; 
	
	public static ExtentReports extentReports;
	
	public static File file;
	
	protected static WebDriver browserLaunch(String browsername) {

		if (browsername.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

			//options.addArguments("incognito");

			options.addArguments("start-maximized");

			driver = new ChromeDriver(options);

		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();

		return driver;
	}
	
	protected static void ClearValues(WebDriver driver, WebElement element) {
		
		element.clear();
}
	
	protected static void inputPassing(WebDriver driver, WebElement element, String value) {
	
		element.sendKeys(value);	
	}
	protected static void ClickElement(WebDriver driver, WebElement element) {

		element.click();
	}
	
	protected static void launchingUrl(String Url) {
		
		driver.get(Url);
	}
	
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	
	public void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
	
	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
 
	protected static void passInput(WebElement element, String value) {
		
		element.sendKeys(value);	
	}

	protected static void ClickButton(WebElement element) {
		
		element.click();

	}
	
	protected static void DropDownOptions(WebDriver driver, WebElement element, String name) { 
		
		Select s = new Select(element);
		
		s.selectByValue(name);
		

	}
	
	protected static void getTitle(WebDriver driver) { 
		
		System.out.println(driver.getTitle());
	}
	
	
	protected static void navigate(String ToUrl) {
		
		driver.navigate().to(ToUrl);
		//driver.navigate().back();
		//driver.navigate().forward();

	}
	protected static void CurrentLink() {
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	protected static void ScreenShot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String path = "C:\\Users\\gayat\\BigBasketProject\\Screenshot\\Amazon.png";
		
		File dest = new File(path);
		
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected static void SearchBox(WebElement e) {
		e.sendKeys("Mobiles");
	}	

	protected static void SearchIcon(WebElement s) {
		s.click();
	}
	
	protected static void DropDown(WebElement DropDownOptions) {
		
		Select s = new Select(DropDownOptions);
		
		s.selectByValue("Sydney");
//		List<WebElement> AllOptions = s.getOptions();
//		
//		for (WebElement Options : AllOptions) {
//			System.out.println(Options.getText());	
//		}
			
	}
	
	protected static void FrameOptions() {
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		WebElement MultiFrameParent = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(MultiFrameParent);
		
		driver.switchTo().frame(0);
		
		WebElement ChildTextBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		ChildTextBox.sendKeys("Hello");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		
		WebElement SingleFrameBtn = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		
		driver.switchTo().frame(SingleFrameBtn);
		
		WebElement Iframebtn = driver.findElement(By.xpath("(//h5[text()='iFrame Demo'])[1]"));
		
		String text = Iframebtn.getText();
		
	}
	protected static void Webelementmethods(WebElement Search) {
		
		

        boolean isEnabled = Search.isEnabled();
        System.out.println("Search box is enabled: " + isEnabled);

        boolean isDisplayed = Search.isDisplayed();
        System.out.println("Search box is displayed: " + isDisplayed);

//        boolean isSelected = check.isSelected();
//        System.out.println("Checkbox is selected: " + isSelected);
	}
	
	protected static void mouseActions(WebDriver driver, WebElement mouseOp)  {

    Actions actions = new Actions(driver);
    actions.doubleClick(mouseOp).perform();

    
    mouseOp.sendKeys("Oppo");
    
    Robot r;
	try {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	}
	protected static void AlertOptions(WebElement Alert) {
		
		Alert.click();
		
		driver.switchTo().alert().accept();
		
		WebElement ConfirmBox = driver.findElement(By.id("confirmexample"));
		
		ConfirmBox.click();
		
		driver.switchTo().alert().dismiss();
		
		WebElement PromptBox = driver.findElement(By.id("promptexample"));
		
		PromptBox.click();
		
		driver.switchTo().alert().sendKeys("Hi");
		
		driver.switchTo().alert().accept();
	}
	protected static void ScrollOptions() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0, 500)"); 
    //js.executeScript("window.scrollBy(0, -500)");
	}
	
	protected static void implicitWait(long seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}
	
	
	protected static void explicit_wait(WebDriver driver, WebElement element, String value, Duration seconds ) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		if (value.equalsIgnoreCase("alert accept")) {

			wait.until(ExpectedConditions.alertIsPresent()).accept();

		} else if (value.equalsIgnoreCase("alert dismiss")) {

			wait.until(ExpectedConditions.alertIsPresent()).dismiss();

		} else if (value.equalsIgnoreCase("visibility")) {

			wait.until(ExpectedConditions.visibilityOf(element)).click();

		} else if (value.equalsIgnoreCase("all visibility")) {

			wait.until(ExpectedConditions.visibilityOfAllElements(element));

		} else if (value.equalsIgnoreCase("clickable")) {

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
	
	}
	
	protected static void close() {
		
		driver.close();
	}
	
	protected static void quit() {
		
		driver.quit();
	}
	
//	protected static void fullScreenshot(){
//		
//		Screenshot take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//
//		try {
//			ImageIO.write(take.getImage(), "PNG", new File(System.getProperty("user.dir") + "\\Screenshot\\Amazonfull.png"));
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
	
	
}
