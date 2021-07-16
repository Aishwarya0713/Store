package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class base {
  public static WebDriver driver;
  public static Properties prop;
  public static Logger log1;
  public static ExtentHtmlReporter htmlReporter;
  public static ExtentReports extent;
  public static ExtentTest test;
  public static ExtentTest childTest;   
  @BeforeSuite
  
  public void bsuite() throws FileNotFoundException, IOException {
	  String log4jConFile="C:\\Users\\Aishwarya.kurkoti\\OneDrive - Qualitest Group\\MavenJava\\src\\main\\java\\resources\\log4j2.xml";
	  ConfigurationSource source = new  ConfigurationSource(new FileInputStream(log4jConFile));
	  Configurator.initialize(null, source);
	  log1 = LogManager.getLogger(base.class.getName());
	  htmlReporter=new ExtentHtmlReporter("./Reports/ex_report.html");
      extent=new ExtentReports();
      extent.attachReporter(htmlReporter); 
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException
  {
      if(result.getStatus()==ITestResult.FAILURE)
      {
          childTest=test.createNode(result.getThrowable().getMessage());
          childTest.fail(result.getThrowable());
      }
      else if(result.getStatus()==ITestResult.SUCCESS)
      {
          childTest=test.createNode(result.getName());
          childTest.pass("as expected"); 
      }
     
  }
   @AfterSuite
   public void aft() {
       extent.flush();
       
   }
  
  
	public static WebDriver initializeDriver() throws IOException   {
		 
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Aishwarya.kurkoti\\eclipse-workspace\\Store\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aishwarya.kurkoti\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	 public ExtentReports extentReport() {
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/ex_report.html");
        ExtentReports extent=new ExtentReports();
            extent.attachReporter(reporter);
            return extent;
           
    }
	 public static  ArrayList<HashMap<String,String>> tcdata(String sheetname) throws IOException
	    {
	        FileInputStream fis = new FileInputStream(new File("./TD/testdata.xlsx"));
	        ArrayList<HashMap<String,String>> ls=new ArrayList<HashMap<String,String>>();
	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet spreadsheet = workbook.getSheet(sheetname);
	        int lastRow = spreadsheet.getLastRowNum();
	        Row firstRow= spreadsheet.getRow(0);
	        for(int i=1;i<=lastRow;i++){
	            HashMap<String,String> hm=new HashMap<String,String>();
	            Row rows = spreadsheet.getRow(i);
	            int lastCell=firstRow.getLastCellNum();
	            for(int j=0;j<lastCell;j++)
	            {
	                Cell dataCell=rows.getCell(j);
	                Cell headerCell=firstRow.getCell(j);
	                String header=getCellData(headerCell,workbook);
	                String value=getCellData(dataCell,workbook);
	                hm.put(header, value);
	            }
	            ls.add(hm);
	            
	        }
	        return ls;
	}
	    public static String getCellData(Cell cell,Workbook workbook)
	    {
	        String cellDataValue="";
	        if(cell==null)
	            return cellDataValue;
	        switch(cell.getCellType())
	        {
	        case BOOLEAN:
	            cellDataValue=Boolean.toString(cell.getBooleanCellValue());
	            break;
	        case _NONE:
	        case BLANK:
	        case ERROR:
	            break;
	        case NUMERIC:
	            cellDataValue=Double.toString(cell.getNumericCellValue());
	            break;
	        case STRING:
	            cellDataValue=cell.getStringCellValue();
	            break;
	        }
	        return cellDataValue;
	    }
	
}
