package genericCheckpointing.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class ProxyCreator{

	private InvocationHandler handler = null;

	public ProxyCreator(InvocationHandler handlerIn){
		handler = handlerIn;
	}

	public StoreRestoreI createProxy(){
		StoreRestoreI storeRestoreRef = (StoreRestoreI)Proxy.newProxyInstance(
			getClass().getClassLoader(),
			new Class[] { StoreI.class, RestoreI.class  },
			handler
			);

		return storeRestoreRef;
	}
}