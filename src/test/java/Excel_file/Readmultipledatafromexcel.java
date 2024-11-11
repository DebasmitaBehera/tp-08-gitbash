package Excel_file;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readmultipledatafromexcel {

	public static void main(String[] args) throws Exception, IOException {
		FileInputStream fis=new FileInputStream("./testdata/product.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("product");
Row r = sh.getRow(1);
String data1 = r.getCell(0).toString();

String data2 = r.getCell(1).toString();
//System.out.println(data1);
//System.out.println(data2);
System.out.println(data1 + "\t" + data2);

wb.close();
	}

}
