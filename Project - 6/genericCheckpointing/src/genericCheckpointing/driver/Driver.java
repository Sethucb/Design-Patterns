package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.xmlStoreRestore.XMLSerialization;
import genericCheckpointing.xmlStoreRestore.XMLDeserialization;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import java.lang.reflect.InvocationHandler;
import java.util.Random;

public class Driver {

	// Argument check
	private static boolean checkArgs(String[] args){
		if(args[0].equals("${arg0}") || args[0].equals("") || args[1].equals("${arg1}") || args[1].equals("") || args.length != 3){
			return false;
		}
		if(args[2].equals("${arg2}") || args[2].equals("")){
			return false;
		}
		return true;
	}

	public static void main(String[] args) 
	{	
		if(!checkArgs(args)){
			System.err.println("Please specify correct three arguments.");
			System.exit(1);
		}

		String mode = args[0];
		int NUM_OF_OBJECTS = 0;
		String checkPoint = args[2];

		try{
			 NUM_OF_OBJECTS = Integer.parseInt(args[1]);	
		}
		catch(Exception e){
			System.err.println("Please specify an Integer in command line");
			System.exit(1);
		}

	    try{	    
		   		   
		   StoreRestoreHandler handler = new StoreRestoreHandler(checkPoint);

			ProxyCreator proxy = new ProxyCreator(handler);	    
		   StoreRestoreI cpointRef = proxy.createProxy();

		   MyAllTypesFirst myFirst;
			MyAllTypesSecond  mySecond;		    

		    Random random = new Random();

			if(mode.equals("serdeser")){
				SerializableObject[] beforeSerialize = new SerializableObject[2*NUM_OF_OBJECTS];
				SerializableObject[] afterSerialize = new SerializableObject[2*NUM_OF_OBJECTS];
				
				for (int i = 0; i < NUM_OF_OBJECTS; i++) {

					String[] stringArray = {"DP","Design Patterns","Java","Proxy"};
					char[] charArray = {'a','b','C','R','g','Z'};

				    int f_int = random.nextInt(100) + i;
				    int f_oth_int = random.nextInt(100) + (4*i);
				    // System.out.println("Int : "+ String.valueOf(f_int)+" Int :"+String.valueOf(f_oth_int));
				    long f_long = (long) f_int * 213;
				    long f_oth_long = (long)f_oth_int * 545;
				    // System.out.println("Long : "+ String.valueOf(f_long)+" Long :"+String.valueOf(f_oth_long));
				    String f_string = stringArray[random.nextInt(3) + 0];
				    boolean f_bool = (f_int % 2 == 0) ? true : false;
				    myFirst = new MyAllTypesFirst(f_int,f_oth_int,f_long,f_oth_long,f_string,f_bool);
				    
				    double s_myDoubleT = i + (500 - i) * random.nextDouble();
					 double s_myOtherDoubleT = i + (50 - i) * random.nextDouble();
					 // System.out.println("DBL : "+ String.valueOf(s_myDoubleT)+" DBL :"+String.valueOf(s_myOtherDoubleT));
					 float s_myFloatT = i + random.nextFloat() * 25;
					 short s_myShortT = (short) random.nextInt(Short.MAX_VALUE + 1);
					 short s_myOtherShortT = (short) random.nextInt(Short.MAX_VALUE + 1);
					 char s_myCharT = charArray[random.nextInt(5) + 0];
				    mySecond = new MyAllTypesSecond(s_myDoubleT,s_myOtherDoubleT,s_myFloatT,s_myShortT,s_myOtherShortT,s_myCharT);

				    beforeSerialize[2*i] = myFirst;
				    beforeSerialize[(2*i) + 1] = mySecond;
				    
				    ((StoreI) cpointRef).writeObj(myFirst,i,"XML");
				    ((StoreI) cpointRef).writeObj(mySecond, i,"XML");

				}
				XMLSerialization serializer = handler.getSerializer();
				serializer.closeFile();
				SerializableObject myRecordRet;

				for (int j=0; j<2*NUM_OF_OBJECTS; j++) {
				    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				    afterSerialize[j] = myRecordRet;
				}
				XMLDeserialization deserialize = handler.getDeserializer();
				deserialize.closeFile();

				int mismatch = 0;
				for(int k = 0 ; k < 2*NUM_OF_OBJECTS; k++){
					if(!beforeSerialize[k].equals(afterSerialize[k])){
						mismatch++;
					}
				}
				System.out.println("The number of mismatches are "+ mismatch);
			}
			else if(mode.equals("deser")){
				SerializableObject myRecordRet;

				for (int j=0; j< 2*NUM_OF_OBJECTS; j++) {
				    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				    if(myRecordRet != null){
				    	System.out.println(myRecordRet.toString());	
				    }
				}
			}
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
	    }
	}
}