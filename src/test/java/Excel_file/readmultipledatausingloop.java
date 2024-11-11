package Excel_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readmultipledatausingloop {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./testdata/product.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("product");


for (int i=1;i<30;i++)
{
	Row r = sh.getRow(i);
	String data1 = r.getCell(0).toString();

	String data2 = r.getCell(1).toString();
	System.out.println(data1 + "\t" + data2);
}wb.close();
	}

}
