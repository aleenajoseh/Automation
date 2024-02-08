package test;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.Autopage;
public class Autotest 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void open()
	{
		driver.get("https://www.houseofindya.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void test() throws Exception
	{
		Autopage pg=new Autopage(driver);
		pg.basic();
		System.out.println("basic pass");
		pg.login("aleena219004@sahrdaya.ac.in");
		System.out.println("login pass");
		pg.dropdown();
		System.out.println("dropdown is selected");
		pg.datadriven();
		System.out.println("datadriven is done");
		pg.screenshot("dress");
		System.out.println("screenshot is done");
		pg.windowhandleandscrolldown();
		System.out.println("windowhandle and scrolldown is done");
		pg.links();
		System.out.println("linksprinted");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
}