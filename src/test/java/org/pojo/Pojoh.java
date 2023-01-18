package org.pojo;

import org.basecu.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoh extends BaseClass {
	
	
public Pojoh() {
	
	
	PageFactory.initElements(driver, this);
	}

@FindBy(id="email")
 private WebElement username;

@FindBy(id="pass")

private WebElement pass;

@FindBy(xpath="//button[text()='Log in']")

private WebElement log;

public WebElement getUsername() {
	return username;
}

public WebElement getPass() {
	return pass;
}

public WebElement getLog() {
	return log;
}



}
