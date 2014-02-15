package model1;

import java.util.ArrayList;
import java.util.Date;
public class SignalItem {
	private String subject;
	private Date start_time;
	private Date end_time;
	private int sigqual;
	private ArrayList<Integer> rawWave;
	
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public Date getStart_time(){
		return this.start_time;
	}
	public void setStart_time(Date startTime){
		this.start_time = startTime;
	}
	public Date getEnd_time(){
		return this.end_time;
	}
	public void setEnd_time(Date EndTime){
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
		this.rawWave.clear();
		String[] waveData = rawWave.split(" ");
		for(String tmp: waveData){
			int waveDot = Integer.getInteger(tmp);
			this.rawWave.add(waveDot);
		}
		return true;
	}
	
}
