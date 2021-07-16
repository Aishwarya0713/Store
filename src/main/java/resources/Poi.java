package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

 

public class Poi {
    public static void main(String args[]) throws IOException
    {
        System.out.println("apache poi");
        ArrayList<HashMap<String,String>> arr=tcdata("Sheet1");
        System.out.println(arr.size());
        System.out.println(arr);
        Iterator<HashMap<String, String>> itr=arr.iterator();
        
        while(itr.hasNext())
        {
        
            HashMap<String, String> a=itr.next();
            String url=a.get("url");
            if(url.equals(""))
            {
                break;
            }
        
            System.out.println("Username "+a.get("url"));
            System.out.println("Password "+a.get("Title"));
            
        
        }
        
        
        
    }
    public static  ArrayList<HashMap<String,String>> tcdata(String sheetname) throws IOException
    {
        FileInputStream fis = new FileInputStream(new File("./TD/testdata.xlsx"));
        
        ArrayList<HashMap<String,String>> ls=new ArrayList<HashMap<String,String>>();
        //  XSSFRow row;
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheet(sheetname);
        int lastRow = spreadsheet.getLastRowNum();
        Row firstRow= spreadsheet.getRow(0);
        System.out.println("last Row"+lastRow);
        
        
        for(int i=1;i<=lastRow;i++){

 

            HashMap<String,String> hm=new HashMap<String,String>();
            Row rows = spreadsheet.getRow(i);
            //System.out.println(i+"::"+row);
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