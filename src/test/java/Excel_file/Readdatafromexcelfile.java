package Excel_file;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcelfile {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./testdata/Orgnztn.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("org");
		Row r = sh.getRow(1);
		Cell c = r.getCell(2);
		String data=c.getStringCellValue();
		System.out.println(data);

	}

}
