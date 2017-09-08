package framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class DriverClass {

	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
	{
		//get name of test cases to be executed present in the Index workbook
		ArrayList<String> lst = ExcelTest.ReadTCs("Index");
		for (int i = 0 ; i <lst.size();i++)
		{
		 //get all the keywords present for the particular test case
		  HashMap<Integer,ArrayList<String>> map =ExcelTest.ReadExcelFrmwrk(lst.get(i).trim())	;
		  for(int j =1;j<=map.size();j++)	
		  {
			  //unwrap the hash map 
			  ArrayList<String> lst2= map.get(j);
			  //call the functions
			  fbautomation.callmethod(lst2.get(0).trim(), lst2.get(1).trim(), lst2.get(2).trim(), lst2.get(3).trim());
			  
			  //write the result into excel 
			  ExcelTest.WriteResultFrmwrk(j, fbautomation.result, lst.get(i).trim(),4);
		  
			  
			
		}
	}

}
}
