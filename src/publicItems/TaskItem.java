package publicItems;

import java.util.Calendar;

public class TaskItem {
	private Calendar start_time;
	private Calendar end_time;
	private String subject;
	private String machine;
	private String stim;
	private String block;
	private int correct;
	private double latency;
	private int fluent;
	private int learning;
	private double x;
	private double y;
	
	public int getCorrect(){
		return correct;
	}
	public void setCorrect(String correct){
		int tmp = Integer.getInteger(correct);
		this.correct = tmp;
	}
	
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getMachine(){
		return machine;
	}
	public void setMachine(String machine){
		this.machine = machine;
	}
	
	public String getStim(){
		return stim;
	}
	public void setStim(String stim){
		this.stim = stim;
	}
	
	public String getBlock(){
		return block;
	}
	public void setBlock(String block){
		this.block = block;
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
	
	public double getLatency(){
		return this.latency;
	}
	
	public boolean setLatency(String latency){
		if (latency.equals("/N")) {
			this.latency = 0;
		}else {
			double tmp = Double.valueOf(latency);
			this.latency = tmp;
		}
		return true;
		
	}
	
	public int getFluent(){
		return this.fluent;
	}
	
	public boolean setFluent(String fluent){
		int tmp = Integer.getInteger(fluent);
		this.fluent = tmp;
		return true;
	}
	
	public int getLearning(){
		return this.learning;
	}
	
	public boolean setLearning(String learning){
		int tmp = Integer.getInteger(learning);
		this.learning = tmp;
		return true;
	}
	
	public double getX(){
		return this.x;
	}
	public boolean setX(double x){
		this.x = x;
		return true;
	}
	
	public double getY(){
		return this.y;
	}
	
	public boolean setY(double y){
		this.y = y;
		return true;
	}
}
