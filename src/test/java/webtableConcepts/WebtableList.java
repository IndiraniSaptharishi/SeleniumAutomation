package webtableConcepts;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebtableList {

	WebDriver driver;
	
	@Test
	public void getDataFromWebtable() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String row="//*[@id='leftcontainer']/table/tbody/tr";
		int rowcount=driver.findElements(By.xpath(row)).size();
		System.out.println(rowcount);
		
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[4]
		//*[@id="leftcontainer"]/table/tbody/tr[5]/td[4]
		
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[3]
		
		String FirstPartXpathCP ="//*[@id='leftcontainer']/table/tbody/tr[";
		String SecondPartXpathCP="]/td[4]";
		
		String FirstPartXpathPC ="//*[@id='leftcontainer']/table/tbody/tr[";
		String SecondPartXpathPC="]/td[3]";
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i=1;i<rowcount;i++) {
			
			String currentprice=driver.findElement(By.xpath(FirstPartXpathCP+i+SecondPartXpathCP)).getText();
			NumberFormat numformat =  NumberFormat.getInstance();
			Number num=numformat.parse(currentprice);
			currentprice=num.toString();
			Double dcurrentprice = Double.parseDouble(currentprice);
			int intprice =dcurrentprice.intValue();
			
			array.add(intprice);
		}
		
		System.out.println(Collections.min(array));
		System.out.println(Collections.max(array));
		Collections.sort(array);
		System.out.println(array);
		System.out.println(array.get(array.size()-1));
		driver.quit();
		
		
		
		
		
	}

}
