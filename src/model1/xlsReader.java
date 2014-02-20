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
import publicItems.TaskItem;

import jxl.*;
import jxl.read.biff.BiffException;

public class xlsReader {
	/*public Sheet read_xls(String path) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		return sheet;
	}*/
	
	public HashMap<String, ArrayList<SignalItem>> getEEGSignal(String path) throws BiffException, IOException, ParseException{
		File file = new File(path);
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
            item.setSignalQuality(Integer.parseInt(element[6]));
            //System.out.println(element[17]);
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
	
	public ArrayList<TaskItem> getTaskItem(String path) throws ParseException, IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		ArrayList<TaskItem> taskItemList = new ArrayList<>();
		//HashMap<String,ArrayList<SignalItem>> taskTable = new HashMap<>();
		line = br.readLine();
        while((line = br.readLine()) != null) {
        	TaskItem item = new TaskItem();
            String [] element = line.split("\t");
            item.setSubject(element[1]);
            item.setMachine(element[0]);
            Calendar start = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            start.setTime(format.parse(element[2]));
            end.setTime(format.parse(element[3]));
            item.setStim(element[4]);
            item.setBlock(element[5]);
            item.setCorrect(element[6]);
            item.setLatency(element[7]);
            item.setFluent(element[8]);
            item.setLearning(element[9]);
         
            taskItemList.add(item);
       }
		return taskItemList;
	}
	
	public static void main(String [] args) throws IOException, ParseException, BiffException{
		ArrayList<TaskItem> list = new ArrayList();
		xlsReader reader = new xlsReader();
		list = reader.getTaskItem("eeg_lex_learning_2013_2014.csv");
		System.out.println(list.get(1).getMachine());
	}
}
