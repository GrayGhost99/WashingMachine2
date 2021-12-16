// Unit 4.3 PA
// Michael L. Moore
// 11/3/2021

public class Engine implements Machine {
	private int rotation;

	

	public Engine(int i) {
		rotation = i;
		setRotation(i);
	}

	// return rotation
	public int getRotation() {
		return rotation;
	}

	// set rotation
	public void setRotation(int rotation) {
		this.rotation = rotation;	
	}

	@Override
	public void turnOn() {
		System.out.println("\nEngine is turned on!");
		
	}

	@Override
	public void turnOff() {
		System.out.println("\nEngine is stopping!\n");
		
	}
	
	public void displayEngine(int i) {
		if (i == 1) {
			turnOn();	
		}
		
		else if (i == 0) {
			turnOff();
		}
	}
}
