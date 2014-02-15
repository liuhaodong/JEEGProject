package model1;

import java.util.Date;

public class TaskItem {
	private Date start_time;
	private Date end_time;
	private String subject;
	
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
}
