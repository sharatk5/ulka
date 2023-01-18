package org.basecu;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
    public static Actions a;
    
    public static Robot r;
    
    public static Alert al;
    
    public static Select s;
	
	public static void launchBrowser() {
		
		
		WebDriverManager.chromedriver().setup();
 driver=new ChromeDriver();
		
	}

	public static void passUrl(String url) {
		
		driver.get(url);
		
		}
	
	public static void toMax() {
		
		
		driver.manage().window().maximize();}
	
	
	public static void toInputValue(WebElement element, String input) {
		
	
element.sendKeys(input);
	}
	
	public static void toClick(WebElement element) {
		
		element.click();}
	
	public static void toGetText(WebElement element) {
		
		String text = element.getText();
System.out.println(text);

	}
	
	public static void toGetAtt(WebElement element, String input ) {
		
		
		String att = element.getAttribute(input);
		
		
		System.out.println(att);}
	
	public static void toMoveToElement(WebElement element) {

		
		 a=new Actions(driver);
		
		a.moveToElement(element);
		
		} 
	public static void toDoubleClick() {
		
		a.doubleClick();}
	
	public static void toRightClick() {
		a.contextClick();
		}
	
	public static void toDragDrop(WebElement src, WebElement des) {
		
		a.dragAndDrop(src, des);}
	
	public static void toMouseScroll(WebElement target) {
		
		
		a.clickAndHold(target);

	}
	
	
	public static void toInputMouse(String input) {
		
		a.sendKeys(input);}

public static void toPressEnter() throws AWTException {
	
	Robot r=new Robot();
	
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);

}
public static void toPressDown() {
	
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);}

public static void toPressUp() {
	
	r.keyPress(KeyEvent.VK_UP);
	r.keyRelease(KeyEvent.VK_UP);

}

public static void toPressTab() {

	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
}

public static void toSelectAllkey()  {
	
	

r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_A);


r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_A);

}


public static void tocut() {
	

	
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_X);
	
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_X);

}

public static void toAcceptAlert() {
	
	 al=driver.switchTo().alert();
	
	al.accept();
}
public static void toDismissAlert() {
	
	al.dismiss();}
	
	
	public static void toInputAlert(String input) {
		
		al.sendKeys(input);

	}
	
	public static void toGetTextAlert() {
		
		String text = al.getText();
		
		System.out.println(text);

	}
	
	public static void toScreenshot( String pathname) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File ss = ts.getScreenshotAs(OutputType.FILE);

		File f=new File(pathname);
		
		FileUtils.copyFile(ss, f);
	}

	public static void toSwitchWindow(int i) {
		
		Set<String> AllIds = driver.getWindowHandles();
		
		List<String> l=new ArrayList();
		
		l.addAll(AllIds);
		driver.switchTo().window(l.get(i));}


	public static void toSwitchFrame(WebElement element) {
		
		driver.switchTo().frame(element);

	}

	public static void toSwitchFramename(String input) {
		
		driver.switchTo().frame(input);

	}
	
	public static void toSwitchParentframe() {
		
		driver.switchTo().parentFrame();}

public void toSwitchHtml() {
	 driver.switchTo().defaultContent();}


public static void toDDText(WebElement element, String input) {
	
	
	 s=new Select(element);
	
	s.selectByVisibleText(input);

}

public static void toDDIndex(int i) {
	
	s.selectByIndex(i);

}

public static void toDDValue(String Value) {

	s.selectByValue(Value);
}


public static void toGetDDelements() {
	
	List<WebElement> options = s.getOptions();
	
	
	for (int i = 0; i <= options.size(); i++) {
		
		
		WebElement w = options.get(i);
		
		System.out.println(w.getAttribute("value"));
		
	}
	}

public static void toPerformImplicitWait() {
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


public static String exceread(int row,int cell) throws IOException {
	
	
	File f =new File("C:\\Users\\REYANSH\\eclipse-workspace\\MavenFramework\\Excel files\\Data2.xlsx");
	FileInputStream g=new FileInputStream(f);
	
	Workbook w=new XSSFWorkbook(g);
	
	Sheet s = w.getSheet("Sheet1");
	
	String value;
	
	Row r = s.getRow(row);
	
	Cell c = r.getCell(cell);
	
  int cellType = c.getCellType();
		
	if (cellType==1) { 
			
			 value = c.getStringCellValue();
			
			
			
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
			
			 value = sim.format(d);
		}
		else {
			
			double n = c.getNumericCellValue();
			
			long l=(long) n;
			
			 value = String.valueOf(l);
			
			
		}
		
		return value;
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
	
	 
	 
}





	










































