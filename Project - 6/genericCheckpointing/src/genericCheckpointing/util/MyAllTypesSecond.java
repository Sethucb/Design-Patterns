package genericCheckpointing.util;


public class MyAllTypesSecond extends SerializableObject{

	private double myDoubleT = 0;
	private double myOtherDoubleT = 0;
	private float myFloatT = 0;
	private short myShortT = 0;
	private short myOtherShortT = 0;
	private char myCharT = 'z';

	public MyAllTypesSecond(double myDoubleTIn,double myOtherDoubleTIn,float myFloatTIn,short myShortTIn,short myOtherShortTIn,char myCharTIn){
		myDoubleT = myDoubleTIn;
		myOtherDoubleT = myOtherDoubleTIn;
		myFloatT = myFloatTIn;
		myShortT = myShortTIn;
		myOtherShortT = myOtherShortTIn;
		myCharT = myCharTIn;	
	}

	public MyAllTypesSecond(){		
	}

	@Override
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(!(object instanceof MyAllTypesSecond)){
			return false;
		}

		MyAllTypesSecond second = (MyAllTypesSecond)object;
		
		return myDoubleT == second.getMyDoubleT() && myOtherDoubleT == second.getMyOtherDoubleT() && 
			myFloatT == second.getMyFloatT() && myShortT == second.getMyShortT() && 
			myOtherShortT == second.getMyOtherShortT() && myCharT == second.getMyCharT();
	}

	@Override
    public int hashCode() {
        final int prime = 17;
        int result = 1 + (int)myDoubleT + (int)myOtherDoubleT + (int)myFloatT + (int)myShortT +(int) myOtherShortT +(int)myCharT;
        return result * prime;
    }

     @Override
    public String toString(){
    	String string = "Class:MyAllTypesSecond";
    	string += "\nmyDoubleT:" + String.valueOf(myDoubleT) + "\nmyOtherDoubleT:"+ String.valueOf(myOtherDoubleT);
    	string += "\nmyFloatT:" + String.valueOf(myFloatT) + "\nmyShortT:" + String.valueOf(myShortT);
    	string += "\nmyOtherShortT:" + String.valueOf(myOtherShortT) + "\nmyCharT:" + String.valueOf(myCharT) + "\n";
    	return string;
    }

	public double getMyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		// System.out.println("myDoubleT is " + String.valueOf(myDoubleT));
		this.myDoubleT = myDoubleT;
	}
	public double getMyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		// System.out.println("myOtherDoubleT is "+ String.valueOf(myOtherDoubleT));
		this.myOtherDoubleT = myOtherDoubleT;
	}
	public float getMyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		// System.out.println("myFloatT is " + String.valueOf(myFloatT));
		this.myFloatT = myFloatT;
	}
	public short getMyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		// System.out.println("myShortT is "+ String.valueOf(myShortT));
		this.myShortT = myShortT;
	}
	public short getMyOtherShortT() {
		return myOtherShortT;
	}
	public void setMyOtherShortT(short myOtherShortT) {
		// System.out.println("myOtherShortT is "+String.valueOf(myOtherShortT));
		this.myOtherShortT = myOtherShortT;
	}
	public char getMyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		// System.out.println("myCharT is " + String.valueOf(myCharT));
		this.myCharT = myCharT;
	}
}