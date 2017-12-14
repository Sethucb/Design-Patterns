package genericCheckpointing.util;


public class MyAllTypesFirst extends SerializableObject{

	private int myInt = 0;
	private int myOtherInt = 0;
	private long myLong = 0;
	private long myOtherLong = 0;
	private String myString = "";
	private boolean myBool = true;

	public MyAllTypesFirst(int myIntIn,int myOtherIntIn,long myLongIn,long myOtherLongIn,String myStringIn,boolean myBoolIn){
		myInt = myIntIn;
		myOtherInt = myOtherIntIn;
		myLong = myLongIn;
		myOtherLong = myOtherLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}

	public MyAllTypesFirst(){		
	}

	@Override
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		if(!(object instanceof MyAllTypesFirst)){
			return false;
		}

		MyAllTypesFirst first = (MyAllTypesFirst)object;

		return myInt == first.getMyInt() && myOtherInt == first.getMyOtherInt() && 
			myLong == first.getMyLong() && myOtherLong == first.getMyOtherLong() && 
			myString.equals(first.getMyString()) && myBool == first.getMyBool();
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1 + myInt + myOtherInt + (int)myLong + (int)myOtherLong;
        result += (myBool == true) ? 5 : 10;
        result = prime * result + ((myString == null) ? 0 : myString.hashCode());
        return result;
    }

    @Override
    public String toString(){
    	String string = "Class:MyAllTypesFirst";
    	string += "\nmyInt:" + String.valueOf(myInt) + "\nmyOtherInt:"+ String.valueOf(myOtherInt);
    	string += "\nmyLong:" + String.valueOf(myLong) + "\nmyOtherLong:" + String.valueOf(myOtherLong);
    	string += "\nmyString:" + myString + "\nmyBool:" + String.valueOf(myBool) + "\n";
    	return string;
    }

	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		// System.out.println("myInt is "+ String.valueOf(myInt));
		this.myInt = myInt;
	}
	public int getMyOtherInt() {
		return myOtherInt;
	}
	public void setMyOtherInt(int myOtherInt) {
		// System.out.println("myOtherInt is "+ String.valueOf(myOtherInt));
		this.myOtherInt = myOtherInt;
	}
	public long getMyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		// System.out.println("myLong is "+ String.valueOf(myLong));
		this.myLong = myLong;
	}
	public long getMyOtherLong() {
		return myOtherLong;
	}
	public void setMyOtherLong(long myOtherLong) {
		// System.out.println("myOtherLong is "+ String.valueOf(myOtherLong));
		this.myOtherLong = myOtherLong;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		// System.out.println("Stri is "+myString);
		this.myString = myString;
	}
	public boolean getMyBool() {
		return myBool;
	}
	public void setMyBool(boolean myBool) {
		// System.out.println("Bool os "+myBool);
		this.myBool = myBool;
	}


}