// Unit 4.3 PA
// Michael L. Moore
// 11/3/2021

public class WaterSensor extends Sensor{
		
	//Constructor
	public WaterSensor (int levelOne, int levelTwo) {
		super();
	}
	
	public boolean check(int levelOne, int levelTwo) {
		

			if (levelOne == levelTwo || levelOne > levelTwo) {
				String level = "Machine is full.";
				System.out.printf("  Water Level: %s", level);
				System.out.println("");
				full = true;
			}
			
			else if (levelTwo > levelOne){
				
				String level = "Machine is empty.";
				System.out.printf("  Water Level: %s", level);
				System.out.println("");
				full = false;
			}

		return full;
		
	}
}
