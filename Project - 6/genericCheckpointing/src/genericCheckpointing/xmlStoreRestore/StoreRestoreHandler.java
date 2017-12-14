package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.SerStrategy;
import genericCheckpointing.xmlStoreRestore.XMLDeserialization;
import genericCheckpointing.xmlStoreRestore.XMLSerialization;


public class StoreRestoreHandler implements InvocationHandler{

	private String checkPoint;
	private SerStrategy serialize;
	private XMLDeserialization deserialize;

	public StoreRestoreHandler(String checkPointIn){
		checkPoint = checkPointIn;	
	}	

	@Override
	public Object invoke(Object object,Method method,Object[] args){
		if(method.getName().equals("writeObj")){
			// Write to file
			serialize = new XMLSerialization(checkPoint);
			serializeData((SerializableObject)args[0], serialize);
		}
		else if(method.getName().equals("readObj")){
			// Read frm file
			deserialize = new XMLDeserialization(checkPoint);
			return deserializeData(deserialize);
		}
		return null;
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy){
		sStrategy.processInput(sObject);
	}

	public SerializableObject deserializeData(XMLDeserialization deserialize){
		return deserialize.processInput();
	}

	public XMLSerialization getSerializer(){
		return (XMLSerialization)serialize;
	}

	public XMLDeserialization getDeserializer(){
		return deserialize;
	}

}