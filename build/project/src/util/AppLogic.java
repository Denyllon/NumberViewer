package util;

public class AppLogic {
	
	private String[] leftTable = new String[20];
	private String[] rightTable = new String[15];
		
	private int leftClock = 0;
	private int rightClock = 0;
	
	public int getLeftClock() {
		return leftClock;
	}

	public void setLeftClock(int leftClock) {
		this.leftClock = leftClock;
	}
	
	public int getRightClock() {
		return rightClock;
	}

	public void setRightClock(int rightClock) {
		this.rightClock = rightClock;
	}

	public String getLeftTableField(int x) {
		return leftTable[x-1];
	}
	
	public void addLeftTableField(String number) {
		leftTable[leftClock] = number;
		leftClock++;
	}
	
	public void clearLeftTableField(String number) {
		
		for (int i=0; i < leftTable.length; i++) {
			if (leftTable[i].equals(number)) {
				leftTable[i] = "";
				leftClock--;
			}
		}
		sortLeftTable();		
	}
	
	public String getRightTableField(int x) {
		return rightTable[x-1];
	}
	
	public void addRightTableField(String number) {
		rightTable[rightClock] = number;
		rightClock++;
	}
	
	public void clearRightTable() {
		for(int i=0; i < rightTable.length; i++) {
			rightTable[i] = "";
		}
		rightClock = 0;
	}
	
	public void fillTables() {
		for (int i=0; i < leftTable.length; i++) {
			leftTable[i] = "";
		}
		for (int i=0; i < rightTable.length; i++) {
			rightTable[i] = "";
		}
	}
	
	public void sortLeftTable() {
		for (int i=0; i < leftTable.length-1; i++) {
			if (leftTable[i].equals(new String(""))) {
				for (int j=i; j < leftTable.length-1; j++){
					leftTable[j] = leftTable[j+1];
				}
			}
		}
		leftTable[leftTable.length-1] = "";
	}
	
	public boolean validate(String number) {
		for (int i=0; i < leftTable.length; i++) {
			if (leftTable[i].equals(number))
				return true;
			}
		for (int i=0; i < rightTable.length; i++) {
			if (rightTable[i].equals(number))
				return true;
		}
		return false;
	}
}
	

