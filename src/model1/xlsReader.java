package model1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import publicItems.SignalItem;

import jxl.*;
import jxl.read.biff.BiffException;

public class xlsReader {
	public Sheet read_xls(String path) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		return sheet;
	}
	
	public HashMap<String, ArrayList<SignalItem>> getEEGSignal(String path) throws BiffException, IOException{
		Sheet signalSheet = read_xls(path);
		for (int i = 1; i < signalSheet.getRows(); i++) {
			SignalItem signalItem = new SignalItem();
			for (int j = 0; j < signalSheet.getColumns(); j++) {
				if (j==1) {
					Cell tmp = signalSheet.getCell(i, j);
					String subject = tmp.getContents();
					signalItem.setSubject(subject);
				}
				Date tmp = new Date();
				tmp.setDate(1);
			}
		}
		return null;
	}
	
}
