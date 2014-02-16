package model1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.supercsv.prefs.CsvPreference;

import publicItems.SignalItem;

import jxl.*;
import jxl.read.biff.BiffException;

public class xlsReader {
	/*public Sheet read_xls(String path) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		return sheet;
	}*/
	
	public HashMap<String, ArrayList<SignalItem>> getEEGSignal(String path) throws BiffException, IOException, ParseException{
		File file = new File("eeg_data_thinkgear_2013_2014.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		HashMap<String,ArrayList<SignalItem>> signalTable = new HashMap<>();
		line = br.readLine();
        while((line = br.readLine()) != null) {
        	SignalItem item = new SignalItem();
            String [] element = line.split("\t");
            item.setSubject(element[1]);
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            start.setTime(format.parse(element[2]));
            end.setTime(format.parse(element[3]));
            item.setSignalQuality(Integer.getInteger(element[6]));
            item.setRawWave(element[17]);
            if (signalTable.containsKey(item.getSubject())) {
				signalTable.get(item.getSubject()).add(item);
			}else {
				ArrayList<SignalItem> list = new ArrayList<>();
				list.add(item);
				signalTable.put(item.getSubject(), list);
			}
       }
		return signalTable;
	}
	
	public static void main(String [] args) throws IOException, ParseException, BiffException{
		HashMap<String, ArrayList<SignalItem>> list = new HashMap<>();
		xlsReader reader = new xlsReader();
		list = reader.getEEGSignal("eeg_data_thinkgear_2013_2014.csv");
		System.out.println(list.size());
	}
}
