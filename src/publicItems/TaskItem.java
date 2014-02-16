package publicItems;

import java.util.Date;

public class TaskItem {
	private Date start_time;
	private Date end_time;
	private String subject;
	private String machine;
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
