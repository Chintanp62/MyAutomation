package data;

import tests.Xls_Reader;

public class DataFile {
	Xls_Reader d = new Xls_Reader("C:\\Selenium\\testing\\NikulTest.xlsx");
	
	
	public String emailWithSpecialChar = d.getCellData("Data1", "UserName", 4);
	public String wrongEmail = d.getCellData("Data1", "UserName", 3);
	public String wrongPassword = d.getCellData("Data1", "Password", 2);
	public String speacialCharEmailErr = d.getCellData("Data1", "Email Error", 5);
	public String emptyEmailErr = d.getCellData("Data1", "Email Error", 4);
	public String emptyPasswordErr = d.getCellData("Data1", "Password Error", 3);
	public String globalErr = d.getCellData("Data1", "Global Error", 2);


}
