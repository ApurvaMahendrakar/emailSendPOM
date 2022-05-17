package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSendPage {

	WebDriver driver;
	//all web elements-it contains all page object model
	By email = By.id("identifierId");
	By next1  =By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
	By pass = By.name("password");
	By next2 = By.xpath("//*[@id=\"passwordNext\"]/div/button/span");
	By google_apps = By.xpath("//*[@id=\"gbwa\"]");
	By mail = By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]/li[2]/a/span");
	By compose = By.cssSelector(".T-I.T-I-KE.L3");
	By nothanks = By.xpath("/html/body/div[17]/div[2]/div[3]/button[2]");
	By to = By.name("to");
	By subject = By.name("subjectbox");
	By emailbody = By.cssSelector(".Ar.Au div");
	By fileicon = By.cssSelector(".a1.aaA.aMZ");
	By send = By.className("btA");
	
		////Constructor to initialize object
	public EmailSendPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	public void passEmail(String mail) {
		
		driver.findElement(email).sendKeys(mail);
		
	}
	public void clickOnNext1(){
		
		driver.findElement(next1).click();;
		
	}
   public void passPwd(String pwd) {
		
		driver.findElement(pass).sendKeys(pwd);
		
	}
   public void clickOnNext2(){
		
		driver.findElement(next2).click();;
		
	}
   public void clickOnGA(){
		
		driver.findElement(google_apps).click();
		
	}
   public void clickOnGmail() {
		
		driver.findElement(mail).click();
		
	}
   public void clickOnCompose() {
		
		driver.findElement(compose).click();
		
	}
   public void clickOnNoThanks() {
		
		driver.findElement(nothanks).click();
		
	}
   public void emailTo(String emailTo) {
		
		driver.findElement(to).sendKeys(emailTo);
		
	}
   public void emailSubject(String sub) {
		
		driver.findElement(subject).sendKeys(sub);
		
	}
   public void emailMsg(String msg) {
		
		driver.findElement(emailbody).sendKeys(msg);
		
	}
   public void clickOnAttachFileIcon() {
		
		driver.findElement(fileicon).click();
		
	}
   public void clickOnSend() {
		
		driver.findElement(send).click();
		
	}
   
	
}
