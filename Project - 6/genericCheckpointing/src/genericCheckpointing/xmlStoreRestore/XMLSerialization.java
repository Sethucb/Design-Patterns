package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.store.Results;
import genericCheckpointing.util.SerializableObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class XMLSerialization implements SerStrategy{

	private static Results results;

	public XMLSerialization(String fileName){
		if(results == null){
			results = new Results(fileName);	
		}
	}

	public void processInput(SerializableObject sObject){
		String className = sObject.getClass().getName();
		if(className.contains("First")){
			serializeFirst(sObject);
		}
		else if(className.contains("Second")){
			serializeSecond(sObject);
		}
	}

	private String serializeTag(String tag,String tagType,String tagVal){
		String string = "  <";
		string += tag + " xsi:type=\"xsd:";
		if(tagType.contains("String")){
			string += "string\">";
		}
		else{
			string += tagType + "\">";
		}
		string += tagVal + "</" + tag + ">";
		return string;
	}

	private void serializeFirst(Object object){
		try{
			String serializeString = "<DPSerialization>" + "\n";
			serializeString += " <complexType xsi:type=\"" + object.getClass().getName() + "\">" + "\n";
			for(Field field : object.getClass().getDeclaredFields()){
				String fieldName = field.getName();
				Object fieldTypeObj = field.getType();
				String fieldType = fieldTypeObj.toString();
				
				String newFieldName = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
				String getVal = "get" + newFieldName;
				Method method = object.getClass().getMethod(getVal);
				Object fieldObj = method.invoke(object);
				String fieldVal = fieldObj.toString();
				if(fieldType.equals("int")){
					int fieldInt = Integer.parseInt(fieldVal);
					if(fieldInt < 10){
						continue;
					}
				}
				if(fieldType.equals("long")){
					long fieldLong = Long.parseLong(fieldVal);
					if((int)fieldLong < 10){
						continue;
					}
				}
				serializeString += serializeTag(fieldName,fieldType,fieldVal) + "\n";
			}
			serializeString += " </complexType>" + "\n";
			serializeString += "</DPSerialization>" + "\n";
			results.writeSchedulesToFile(serializeString);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void serializeSecond(Object object){
		try{
			String serializeString = "<DPSerialization>" + "\n";
			serializeString += " <complexType xsi:type=\"" + object.getClass().getName() + "\">" + "\n";
			for(Field field : object.getClass().getDeclaredFields()){
				String fieldName = field.getName();
				Object fieldTypeObj = field.getType();
				String fieldType = fieldTypeObj.toString();
				
				String newFieldName = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
				String getVal = "get" + newFieldName;
				Method method = object.getClass().getMethod(getVal);
				Object fieldObj = method.invoke(object);
				String fieldVal = fieldObj.toString();
				if(fieldType.equals("double") ){
					double fieldDouble = Double.parseDouble(fieldVal);
					if((int)fieldDouble < 10){
						continue;
					}
				}
				serializeString += serializeTag(fieldName,fieldType,fieldVal) + "\n";
			}
			serializeString += " </complexType>" + "\n";
			serializeString += "</DPSerialization>" + "\n";
			results.writeSchedulesToFile(serializeString);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeFile(){
		results.closeFile();
	}
}