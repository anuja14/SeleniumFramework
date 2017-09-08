package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelTest
{
	/**
	 * This function reads data from excel sheet based on test case name passed as parameter,returned from ReadTCs function
	 * @param Sheetname
	 * @return
	 * @throws IOException
	 */
   public static HashMap<Integer,ArrayList <String>> ReadExcelFrmwrk(String Sheetname) throws IOException
   {
	 File newfile= new File("C:\\Users\\anuja\\TestTwo.xls") ;
	 FileInputStream inputstream = new FileInputStream(newfile);
	 HSSFWorkbook workbook = new HSSFWorkbook (inputstream);
	 Sheet sheet = workbook.getSheet(Sheetname);
	 Row row;
	 Cell cell;
	 HashMap<Integer,ArrayList<String>> hmp = new HashMap<Integer,ArrayList<String>>();
	 for ( int i=sheet.getFirstRowNum()+1; i<=sheet.getLastRowNum();i++)
	 {
		 row=sheet.getRow(i);
		 ArrayList<String> lst = new ArrayList<String>();
		 for(int j=row.getFirstCellNum();j<row.getLastCellNum()-1;j++)
		 {
			 cell=row.getCell(j) ;
			 System.out.println(cell.getStringCellValue());
			 lst.add(cell.getStringCellValue()+" ");
			 System.out.println(lst);
			 hmp.put(i,lst);
		 }
	     }
	 return hmp;
   }
   
   /**
    * This function writes the given result into the excel sheet
    * @param row
    * @param Result
    * @param Sheetname
    * @param ResultColumn
    * @throws IOException
    */
   public static void WriteResultFrmwrk(Integer row, String Result,String Sheetname,Integer ResultColumn) throws IOException
   {
	  File newfile = new File("C:\\Users\\anuja\\TestTwo.xls") ;
	  FileInputStream inputstrm= new FileInputStream(newfile);
	  HSSFWorkbook workbook = new HSSFWorkbook (inputstrm);
	  Sheet sheet = workbook.getSheet(Sheetname);
	  Row rows;
	  rows=sheet.getRow(row);
	  Cell cells=rows.createCell(ResultColumn);
	  cells.setCellValue(Result);
	  FileOutputStream output = new FileOutputStream(newfile);
	  workbook.write(output);
	 }
   
 /**
  * This function reads the names of the test cases present in the excel to be executed.
  * @param sheetname
  * @return
  * @throws IOException
  */
  public static ArrayList<String> ReadTCs(String sheetname) throws IOException
  {
	 File myfile= new File("C:\\Users\\anuja\\TestTwo.xls");
	 FileInputStream inputstream = new FileInputStream(myfile);
	 HSSFWorkbook workbook = new HSSFWorkbook(inputstream);
	 Sheet sheet = workbook.getSheet(sheetname);
	 Row rows;
	 Cell cell;
	 ArrayList<String> lst= new ArrayList<String>();
	 for(int i =sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++)
	 {
		rows= sheet.getRow(i);
		cell=rows.getCell(0);
		lst.add(cell.getStringCellValue());
	 }
	return lst; 
  }
}
