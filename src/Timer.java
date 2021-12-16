// Unit 4.3 PA
// Michael L. Moore
// 11/3/2021

public class Timer {
		
	
	public Timer(int washTime, int rinseTime, int spinTime) {
	}



	private int value = 0;
	private int duration;
	private int count;
	
	
	
	public int getDuration() {
		return duration;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getCount() {

		return count;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setCount(int count) {

	}
	
	public void start() {		
		System.out.println("\n*********TIMER START!!*********\n");
	}

	public void count() {
	}
	
}

