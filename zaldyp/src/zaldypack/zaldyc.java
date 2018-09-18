package zaldypack;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class zaldyc {

	public static void main(String[] args) throws InterruptedException
	{
		String fname = RandomStringUtils.randomAlphabetic(8); 
		String lname = RandomStringUtils.randomAlphabetic(8);
		String user = RandomStringUtils.randomAlphabetic(8);
		String pass = RandomStringUtils.randomAlphabetic(8);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Blu\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://react-redux-registration-login-example.stackblitz.io/login");
		
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[3]/a")).click();
		Thread.sleep(3000);
		//register
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[1]/input")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[2]/input")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[3]/input")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[4]/input")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[5]/button")).click();
		Thread.sleep(3000);
		//login
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[1]/input")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[2]/input")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/form/div[3]/button")).click();
		Thread.sleep(7000);
		
		
		//check if the user’s first name is correctly displayed once logged in
		String bodyText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/h1")).getText();
		System.out.println("Verify  first name captured in page. \n" + bodyText);
		
		if (bodyText.contains(fname))
		{System.out.println("Confirmed first name is correct");}
		else 
		{System.out.println("First name is not the same with the webpage");}
		
		//check if their full name appears under the “All registered users” list.
		Thread.sleep(3000);
		String nameList = driver.findElement(By.xpath("//div[@id='app']/div/div/div/div/div/ul/li")).getText();
		System.out.println("\nVerify full name captured in page. \n" +nameList);
		//System.out.println(fname +" "+ lname); //print fullname
		if (nameList.contains(fname + " " + lname))
		{System.out.println("Confirmed full name appears in the All Registered list");}
		else 
		{System.out.println("First name is not the same with the webpage");}
		
		//Assert.assertEquals(bodyText, bodyText.contains(fname)); 
	}

}
