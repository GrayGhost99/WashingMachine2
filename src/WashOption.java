// Unit 4.3 PA
// Michael L. Moore
// 11/3/2021

public class WashOption {
	
	private int washSelection;
	
	
	public void setWashSelection(int washSelection) {
		System.out.println("\nYou chose option: " + washSelection);
		this.washSelection = washSelection;
	}
	
	public int getWashSelection() {
		return washSelection;
	}
}
