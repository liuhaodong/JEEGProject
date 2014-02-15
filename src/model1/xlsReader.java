package model1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import jxl.*;
import jxl.read.biff.BiffException;

public class xlsReader {
	public Sheet read_xls(String path) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		return sheet;
	}
}
