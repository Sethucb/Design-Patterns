package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.reflect.Method;

public class XMLDeserialization{

	private static FileProcessor file;
	private static ArrayList<String> list;
	private static int cursor;

	public XMLDeserialization(String fileName){
		if(file == null){
			file = new FileProcessor(fileName);
			cursor = 0;
			list = new ArrayList<String>();
			readFile();
		}
	}

	private void readFile(){
		String line;
		while((line = file.readLine()) != null){
			list.add(line.trim());
		}
	}

	private boolean checkValidBegin(int ind){
		try{
		String string = list.get(ind);
		if(string.equals("<DPSerialization>")){
			return true;
		}
		}catch(Exception e){}
		return false;
	}

	private int getEndInd(int ind){
		for(int i = ind; i < list.size(); i++){
			String str = list.get(i);
			if(str.equals("</DPSerialization>")){
				return i;
			}
		}
		return -1;
	}

	public SerializableObject processInput(){
		SerializableObject object = null;
		int cursor_copy = cursor;
		boolean beginCheck = checkValidBegin(cursor_copy);
		if(beginCheck){
			int endInd = getEndInd(cursor_copy);
			if(endInd == -1){
				System.err.println("Wrong XML file");
				System.exit(1);
			}
			object = createObject(cursor_copy,endInd);
			cursor = endInd + 1;
		}
		return object;
	}

	private SerializableObject createObject(int start,int end){
		// System.out.println("Starts is " + start +  " End "+end);
		String lineClass = list.get(start+1);
		int startClass = lineClass.indexOf("\"") + 1;
		int endClass = lineClass.lastIndexOf("\"");
		String className = lineClass.substring(startClass,endClass);
		Object obj = null;
		try{
			Class myClass = Class.forName(className);
			obj = myClass.newInstance();
			
			int nStart = start + 2;
			int nEnd = end - 1;
			while(nStart < nEnd){
				// System.out.println("Starts is " + nStart +  " End "+nEnd);
				String fieldString = list.get(nStart);
				int sind = fieldString.lastIndexOf("\"") + 2;
				int eend = fieldString.lastIndexOf("<");
				String tagValue  = fieldString.substring(sind,eend);
				Pattern pattern = Pattern.compile("<(\\w+)(?:\\sxsi:type=\"xsd:)(\\w+)\">");
		        Matcher m = pattern.matcher(fieldString);
		        if (m.find()) {
		        String _tagName = m.group(1);
		        String tagName = "set" + _tagName.substring(0,1).toUpperCase() + _tagName.substring(1);
		        String tagType = m.group(2);
		         if(myClass.toString().contains("First")){
						serializeFirst(myClass,obj,tagName,tagType,tagValue);
					}else{
						serializeSecond(myClass,obj,tagName,tagType,tagValue);
					}
		      	}else {
		         System.out.println("Wrong XML format");
		         System.exit(1);
		      }
			nStart++;
			}
						
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return (SerializableObject)obj;
	}

	@SuppressWarnings("unchecked") 
	private void serializeFirst(Class myClass,Object object,String tagName,String tagType,String tagValue){
		try{
			Class[] paramInt = new Class[]{ Integer.TYPE };
			Class[] paramLong = new Class[]{ Long.TYPE };
			Class[] paramBool = new Class[]{ Boolean.TYPE };
			Class[] paramString = new Class[]{ String.class };

			Method method = null;
			if(tagType.equals("string")){
				method = myClass.getDeclaredMethod(tagName,paramString);
				method.invoke(object,tagValue);				
			}		
			else if(tagType.equals("int")){
				method = myClass.getDeclaredMethod(tagName,paramInt);
				int intVal = Integer.parseInt(tagValue);
				method.invoke(object,intVal);
			}
			else if(tagType.equals("long")){
				method = myClass.getDeclaredMethod(tagName,paramLong);
				long longVal = Long.parseLong(tagValue);
				method.invoke(object,longVal);	
			}
			else if(tagType.equals("boolean")){
				Boolean bool = Boolean.valueOf(tagValue);
				method = myClass.getDeclaredMethod(tagName,paramBool);	
				method.invoke(object,bool);	
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	@SuppressWarnings("unchecked") 
	private void serializeSecond(Class myClass,Object object,String tagName,String tagType,String tagValue){
		try{
			Class[] paramDouble = new Class[]{ Double.TYPE };
			Class[] paramFloat = new Class[]{ Float.TYPE };
			Class[] paramShort = new Class[]{ Short.TYPE };
			Class[] paramChar = new Class[]{ Character.TYPE };

			Method method = null;

			if(tagType.equals("double")){
				method = myClass.getDeclaredMethod(tagName,paramDouble);
				double doubleVal = Double.parseDouble(tagValue);
				method.invoke(object,doubleVal);
			}
			else if(tagType.equals("float")){
				method = myClass.getDeclaredMethod(tagName,paramFloat);
				float floatVal = Float.parseFloat(tagValue);
				method.invoke(object,floatVal);
			}
			else if(tagType.equals("short")){
				method = myClass.getDeclaredMethod(tagName,paramShort);
				short shortVal = Short.parseShort(tagValue);
				method.invoke(object,shortVal);
			}
			else if(tagType.equals("char")){
				method = myClass.getDeclaredMethod(tagName,paramChar);
				char charVal = tagValue.charAt(0);
				method.invoke(object,charVal);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void closeFile(){
		file.closeFile();
	}
}	

