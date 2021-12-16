// Unit 4.3 PA
// Michael L. Moore
// 11/3/2021

import java.util.Scanner;

public class WashingMachine implements Machine {
	
	//Attributes

	private static int washTime;
	private static int rinseTime;
	private static int spinTime;
	
	
	
	//Constructor
	public WashingMachine(int washTime, int rinseTime, int spinTime) {
		this.washTime = washTime;
		this.rinseTime = rinseTime;
		this.spinTime = spinTime;
	}

	public static void main(String[] args) {

		Scanner time = new Scanner(System.in);
		System.out.print("Please enter the desired wash time in minutes : ");
		int washTime = time.nextInt();
		
		System.out.print("\nPlease enter the desired rinse time in minutes : ");
		int rinseTime = time.nextInt();
		
		System.out.print("\nPlease enter the desired spin time in minutes  : ");
		int spinTime = time.nextInt();
		
		//get user input for wash selection, scan into selection
		System.out.println("\nSelection 1: Standard Wash");
		System.out.println("Selection 2: Rinse Twice");
		System.out.println("Selection 3: Spin Cycle");
		System.out.println("Selection 4: Exit Application");
		System.out.println(""); //space for output formatting
	    System.out.print("Enter Your Selection: ");
	   
		Scanner selection = new Scanner(System.in);
		int washOption = selection.nextInt();
		WashOption opt = new WashOption();
		
		opt.setWashSelection(washOption);
		
		//Specified from sequence diagram main
		int option = opt.getWashSelection();
		
		switch (option) {
		case 1: standardWash(washTime, rinseTime, spinTime); break;
		case 2: twiceRinse(washTime, rinseTime, spinTime); break;
		case 3: spinOnly(spinTime); break;
		default: break;
		}
		// end switch
	
		
		System.out.println("\nExiting..."); 
		time.close();
		selection.close();
	
		} 
	
	// END MAIN ********************************************************************

		
	private static void standardWash(int washTime, int rinseTime, int spinTime) {
		int levelOne = 0;
		int levelTwo = 0;
		int i = 1;
		int n;
		int timea;
		int timeb;
			
		WashingMachine a = new WashingMachine(washTime, rinseTime, spinTime);
		WaterSensor b = new WaterSensor(levelOne, levelTwo);
		Engine engineState = new Engine(i);
		Timer time = new Timer(washTime, rinseTime, spinTime);
		
		a.turnOn();
		System.out.println("\n**********Begin Standard Wash**********");
		
		System.out.printf("%nDesired Wash Time  : %s minuites.%n", washTime);
		System.out.printf("Desired Rinse Time : %s minuites.%n", rinseTime);
		System.out.printf("Desired Spin Time  : %s minuites.%n%n", spinTime);		
		b.check(0, 1);
		a.fill();
		b.check(1, 1);
		engineState.displayEngine(1);		
		a.wash();
		time.start();
		time.setDuration(washTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}	
		engineState.displayEngine(0);
		a.empty();
		b.check(0, 1);
		a.fill();
		b.check(1, 1);
		engineState.displayEngine(1);
		a.rinse();		
		time.start();
		time.setDuration(rinseTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}
		engineState.displayEngine(0);
		a.empty();
		engineState.displayEngine(1);
		a.spin();		
		time.start();
		time.setDuration(spinTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}
		b.check(0, 1);
		engineState.displayEngine(0);
		a.turnOff();		
		System.out.println("\n***********End Standard Wash***********");
	}
	
	private static void twiceRinse(int washTime, int rinseTime, int spinTime) {
		int levelOne = 0;
		int levelTwo = 0;
		int i = 1;
		int n;
		int timea;
		int timeb;
			
		WashingMachine a = new WashingMachine(washTime, rinseTime, spinTime);
		WaterSensor b = new WaterSensor(levelOne, levelTwo);
		Engine engineState = new Engine(i);
		Timer time = new Timer(washTime, rinseTime, spinTime);
		
		a.turnOn();
		System.out.println("\n*******Begin Wash With Two Rinses*******");	
		System.out.printf("%nDesired Wash Time  : %s minuites.%n", washTime);
		System.out.printf("Desired Rinse Time : %s minuites.%n", rinseTime);
		System.out.printf("Desired Spin Time  : %s minuites.%n%n", spinTime);		
		
		b.check(0, 1);
		a.fill();
		b.check(1, 1);
		engineState.displayEngine(1);		
		a.wash();
		time.start();
		time.setDuration(washTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}	
		engineState.displayEngine(0);
		a.empty();
		b.check(0, 1);
		a.fill();
		b.check(1, 1);
		engineState.displayEngine(1);
		a.rinse();		
		time.start();
		time.setDuration(rinseTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}
		engineState.displayEngine(0);
		a.empty();
		System.out.println("\n    ****Second Rinse Cycle****\n");
		b.check(0, 1);
		a.fill();
		b.check(1, 1);
		engineState.displayEngine(1);
		a.rinse();		
		time.start();
		time.setDuration(rinseTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}
		engineState.displayEngine(0);
		a.empty();
		engineState.displayEngine(1);
		a.spin();		
		time.start();
		time.setDuration(spinTime);
		timea = time.getDuration();
		timeb = time.getValue();	
		for(n=timea; n>timeb; n--) {
			System.out.println("Time left: " + n);
		}
		b.check(0, 1);
		engineState.displayEngine(0);
		a.turnOff();		
		System.out.println("\n*******End Wash With Two Rinses*******");
	}

	private static void spinOnly(int spinTime) {
			int levelOne = 0;
			int levelTwo = 0;
			int i = 1;
			int n;
			int timea;
			int timeb;
				
			WashingMachine a = new WashingMachine(washTime, rinseTime, spinTime);
			WaterSensor b = new WaterSensor(levelOne, levelTwo);
			Engine engineState = new Engine(i);
			Timer time = new Timer(washTime, rinseTime, spinTime);
			
			a.turnOn();
			System.out.println("\n**********Begin Spin Only**********");			
			System.out.printf("Desired Spin Time  : %s minuites.%n%n", spinTime);		
			engineState.displayEngine(1);
			a.spin();		
			time.start();
			time.setDuration(spinTime);
			timea = time.getDuration();
			timeb = time.getValue();	
			for(n=timea; n>timeb; n--) {
				System.out.println("Time left: " + n);
			}
			b.check(0, 1);
			engineState.displayEngine(0);
			a.turnOff();		
			System.out.println("\n**********End Spin Only**********");
		}
	
	private static void warn() {
		System.out.println("\nPlease enter a valid input!");
		System.out.println("Selection 1: Standard Wash");
		System.out.println("Selection 2: Rinse Twice");
		System.out.println("Selection 3: Spin Cycle");
		System.out.println("Selection 4: Exit Application");
		System.out.println("");
	}

	public static void spin() {
		System.out.println("\n      ****Spin Cycle****");
	}
	
	private static void fill() {
		System.out.println("  Filling Machine With Water.");
	}
	
	private static void empty() {
		System.out.println("  Draining The Water.");
	}
	
	private static void wash() {
		System.out.println("\n      ****Wash Cycle****");
	}
	
	private static void rinse() {
		System.out.println("\n      ****Rinse Cycle****");
	}

	public void turnOn() {	
		System.out.println("\nThe machine is now ON.\n");
	}

	//@Override
	public void turnOff() {	
		System.out.println("The machine is now OFF.");
	}
}
	
