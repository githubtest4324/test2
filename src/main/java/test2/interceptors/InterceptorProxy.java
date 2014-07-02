package test2.interceptors;

import java.util.HashMap;
import java.util.Map;

public class InterceptorProxy {
	private Object[] state;
	private Map<String, Integer> mapStateIdByPropertyName = new HashMap<String, Integer>();
	private boolean changed = false;
	
	public InterceptorProxy(Object[] state, String[] propertyNames){
		this.state = state;
		int i = 0;
		for(String name : propertyNames){
			mapStateIdByPropertyName.put(name, new Integer(i));
			i++;
		}
	}
	
	public void changeProperty(String propertyName, Object newValue){
		Integer i = mapStateIdByPropertyName.get(propertyName);
		if(i==null){
			throw new RuntimeException("Wrong property name "+propertyName);
		}
		state[i] = newValue;
		changed = true;
	}

	public boolean isChanged() {
		return changed;
	}
	
}
