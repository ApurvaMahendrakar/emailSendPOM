package PageObjectModel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmailSendingTest {

	WebDriver driver;
	
	  // Launch browser.
    @BeforeTest
    public void browserLaunch()
    {
    	System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
     }
    @Test
    public void emailSend() throws InterruptedException, AWTException {
    	
    	EmailSendPage emailSend = new EmailSendPage(driver);
    	driver.get("https://accounts.google.com/");
    	 
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	emailSend.passEmail("apurva.mahendrakar@cogniwize.com");
    	emailSend.clickOnNext1();
    	Thread.sleep(5000);
    	emailSend.passPwd("YSRK3EbB");
    	emailSend.clickOnNext2();
    	emailSend.clickOnGA();
    	Thread.sleep(5000);
		// switch to the frame
		driver.switchTo().frame(0);
		emailSend.clickOnGmail();
		driver.switchTo().defaultContent();
		System.out.println("in default content");
		Thread.sleep(5000);
		// get current url of web page
		String url1 = driver.getCurrentUrl();
		System.out.println("getcurrent url :" + url1);
		// handing window
				Set<String> s1 = driver.getWindowHandles();
				System.out.println("child window is " + s1);
				Iterator<String> i1 = s1.iterator();

				while (i1.hasNext()) {
					String ChildWindow = i1.next();

					System.out.println("title" + driver.switchTo().window(ChildWindow).getTitle());
					Thread.sleep(5000);

				}
    	emailSend.clickOnCompose();
    	emailSend.clickOnNoThanks();
    	emailSend.emailTo("apurva.mahendrakar@cogniwize.com");
    	emailSend.emailSubject("Email Sending -POM demo");
    	emailSend.emailMsg("Hi Apurva, I have sending email attachement using automation script...!!!!!..."+"\n"+"Thank You");
    	emailSend.clickOnAttachFileIcon();
    	
    	
		Thread.sleep(5000);

		// file handling using Robot Class
		Robot rb = new Robot();
		// copy the file path
		StringSelection ss = new StringSelection("D:\\downloads\\0_Apurva Adhar card.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(5000);
		// ctrl+v
		rb.keyPress(KeyEvent.VK_CONTROL); // 
		rb.keyPress(KeyEvent.VK_V); //

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		System.out.println("File Upload successfully");
		
		emailSend.clickOnSend();
		System.out.println("Email sent successfully");
		Thread.sleep(3000);
		// navigate to sent url
		driver.navigate().to("https://mail.google.com/mail/u/0/#sent");
		Thread.sleep(3000);
		// search email subject for email validation
		boolean emailSub = driver.getPageSource().contains("Email Sending -POM demo");
		if (emailSub) {
			System.out.println("Email subject is verified successfully....Test is Passed!!!");
		} else {
			System.out.println("Email subject is not found....Test is Failed!!!!");
		}
		
		Thread.sleep(10000);
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
    	
    	driver.quit();
    	System.out.println("driver closed successfullly...!!!");
    }
    
}

