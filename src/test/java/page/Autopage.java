package page;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
public class Autopage 
{	
	WebDriver driver;
	By Logo=By.xpath("//*[@id=\"imgaffilate\"]");
	
	By Logins=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[4]/ul/li[6]/a");
	By Email=By.xpath("//*[@id=\"txtloginSignupUsername\"]");
	By Skip=By.xpath("//*[@id=\"wpapper\"]/div/div/a[2]");
	
	By designer=By.xpath("//*[@id=\"designdiv\"]");
	By RGRK=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/ul/li[3]/ul/li[5]/a");
	By cat=By.xpath("//*[@id=\"loadFilter\"]/div/ul/li[1]/i");
	By leh=By.xpath("//*[@id=\"fliterBox_style\"]/div[2]/label");
	By country=By.xpath("//*[@id=\"countrycode\"]");
	By nothanks=By.xpath("//*[@id=\"regtodayMain\"]/div[2]/a");
	By pat=By.xpath("//*[@id=\"loadFilter\"]/div/ul/li[6]/i");
	By emb=By.xpath("//*[@id=\"fliterBox_pattern\"]/div[2]");
	By pri=By.xpath("//*[@id=\"loadFilter\"]/div/ul/li[10]/i");
	By che=By.xpath("//*[@id=\"divPriceRange\"]/div/label");
	
	By search=By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div[1]/div");
	By srchcont=By.name("q");
	By firstone=By.xpath("//*[@id=\"searchResult\"]/div/div[2]/ul/li[1]/a");
	By shot=By.xpath("//*[@id=\"currencyBox\"]");
	
	By wholesale=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[4]/ul/li[1]/a");
	By names=By.id("txtRepName");
	By emailid=By.id("txtwholeEmail");
	By num=By.id("txtwholePh");
	By address=By.id("txtareaDelivery");
	By pieces=By.name("FABOE_ITEM_PIECES");
	By comment=By.name("FABOE_ADDITIONAL_COMMENT");
	By texts=By.name("CaptchaInputText");
	By dress=By.xpath("//*[@id=\"JsonProductList\"]/li[2]/a/div[1]/img");
	By ring=By.xpath("//*[@id=\"wrapper\"]/div[16]/div[2]/div[4]/ul[1]/li[6]/a");
	By color=By.xpath("//*[@id=\"wrapper\"]/div[6]/div/div[2]/div[2]/div[5]/a[2]/img");
	By no=By.xpath("//*[@id=\"wzrk-cancel\"]");
	By close=By.xpath("//*[@id=\"imgcloseload\"]/i");
	
	By tagname=By.tagName("a");
	
	public Autopage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void basic()//gettitle and getpagesource and check a word is present
	{
		String title=driver.getTitle();
		System.out.println("Title is "+title);
		String content=driver.getPageSource();
		if(content.contains("Indya"))
		{
			System.out.println("Indya is present");
		}
		else
		{
			System.out.println("Indya is not present");
		}
		WebElement logo = driver.findElement(Logo);
		if(logo.isDisplayed())
		{
			System.out.println("logo is displayed");
		}
		else
		{
			System.out.println("logo is not displayed");
		}
	}
	
	public void login(String email)//login details
	{
		driver.findElement(Logins).click(); 
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Skip).click();
	}
	
	public void dropdown()//dropdown
	{
		WebElement mouse=driver.findElement(designer);
		Actions act =new Actions(driver);
		act.moveToElement(mouse).perform();
		driver.findElement(RGRK).click();
		driver.findElement(cat).click();
		driver.findElement(leh).click();
		WebElement code = driver.findElement(country);
		Select d=new Select(code);
		d.selectByValue("+91");
		List<WebElement> count = d.getOptions();
		System.out.println("no.of country="+count.size());	
		driver.findElement(nothanks).click();
		driver.findElement(pat).click();
		driver.findElement(emb).click();
		driver.navigate().refresh();
		driver.findElement(pri).click();
		WebElement chkbox = driver.findElement(che);
		if(chkbox.isSelected())
		{
			System.out.println("checkbox is selected");
		}
		else
		{
			System.out.println("checkbox is not selected");
		}
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}
	public void datadriven() throws Exception
	{
		driver.findElement(wholesale).click();
        File f=new File("C:\\Users\\aleen\\Desktop\\Alee\\STS\\project\\data.xlsx");
        FileInputStream fi=new FileInputStream(f);
        XSSFWorkbook wb=new XSSFWorkbook(fi);
        XSSFSheet sh=wb.getSheet("Sheet1");
        System.out.println(sh.getLastRowNum());
        for(int i=1;i<=sh.getLastRowNum();i++)
        {
        	String name=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(name);
			String email=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(email);
			double contactno=sh.getRow(i).getCell(2).getNumericCellValue();
			System.out.println(contactno);
			String addresss=sh.getRow(i).getCell(3).getStringCellValue();
			System.out.println(addresss);
			double noofpieces=sh.getRow(i).getCell(4).getNumericCellValue();
			System.out.println(noofpieces);
			String comments=sh.getRow(i).getCell(5).getStringCellValue();
			System.out.println(comments);
			String text=sh.getRow(i).getCell(6).getStringCellValue();
			System.out.println(text);
			
            driver.findElement(names).clear();
            driver.findElement(names).sendKeys(name);
            driver.findElement(emailid).clear();
			driver.findElement(emailid).sendKeys(email);
			driver.findElement(num).clear();
			driver.findElement(num).sendKeys(String.valueOf(contactno));
			driver.findElement(address).clear();
			driver.findElement(address).sendKeys(addresss);
			driver.findElement(pieces).clear();
			driver.findElement(pieces).sendKeys(String.valueOf(noofpieces));
			driver.findElement(comment).clear();
			driver.findElement(comment).sendKeys(comments);
			driver.findElement(texts).clear();
			driver.findElement(texts).sendKeys(text);	
			driver.navigate().refresh();
			
		}
        driver.navigate().back();
	}
	
	public void screenshot(String content) throws Exception
	{
		driver.findElement(search).click();
		driver.findElement(srchcont).sendKeys(content);
		driver.findElement(firstone).click();
		WebElement box = driver.findElement(shot);
		File scr = box.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr, new File("./screenshot//currenybox.png"));
	}
	public void windowhandleandscrolldown() throws Exception 
	{
		String first=driver.getWindowHandle();
		driver.findElement(dress).click();
		//driver.findElement(close).click();
		Set<String> second = driver.getWindowHandles();
		for(String handle:second)
		{
			System.out.println(handle);
			if(!handle.equalsIgnoreCase(first))
			{
				driver.switchTo().window(handle);
				//driver.findElement(no).click();
				//driver.findElement(close).click();
				driver.findElement(color).click();
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,5000)", "");
				driver.navigate().back();
				driver.close();
				driver.switchTo().window(first);
			}
		}
	}
	public void links()
	{
		driver.navigate().refresh();
		driver.findElement(Logo).click();
		List<WebElement> count = driver.findElements(tagname);
		System.out.println("count="+count.size());
		for(WebElement li:count)
		{
			String links=li.getAttribute("href");
			String text=li.getText();
			try
			{
				URL u = new URL(links);
				HttpURLConnection con=(HttpURLConnection)u.openConnection();
				con.connect();
				if(con.getResponseCode()==200)
				{
					System.out.println("valid--"+links+"--"+text);
				}
				else if(con.getResponseCode()==404)
				{
					System.out.println("invalid--"+links+"--"+text);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		 }
	}
}


