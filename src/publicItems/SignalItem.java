package publicItems;

import java.util.ArrayList;
import java.util.Calendar;
public class SignalItem {
	private String subject;
	private Calendar start_time;
	private Calendar end_time;
	private int sigqual;
	private ArrayList<Integer> rawWave = new ArrayList<>();
	
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public Calendar getStart_time(){
		return this.start_time;
	}
	public void setStart_time(Calendar startTime){
		this.start_time = startTime;
	}
	public Calendar getEnd_time(){
		return this.end_time;
	}
	public void setEnd_time(Calendar EndTime){
		this.end_time = EndTime;
	}
	public int getSignalQuality(){
		return this.sigqual;
	}
	public void setSignalQuality(int quality){
		this.sigqual = quality;
	}
	
	public ArrayList<Integer> getRawWave(){
		return this.rawWave;
	}
	
	public boolean setRawWave(String rawWave){
		//this.rawWave.clear();
		String[] waveData = rawWave.split(" ");
		for(String tmp: waveData){
			int waveDot = Integer.parseInt(tmp);
			this.rawWave.add(waveDot);
		}
		return true;
	}
	
}
