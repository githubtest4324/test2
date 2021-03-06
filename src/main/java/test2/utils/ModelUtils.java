package test2.utils;

import java.io.Serializable;
import java.util.Date;

import test2.interceptors.InterceptorProxy;
import test2.model.ITraceable;
import test2.model.TraceInformation;

public class ModelUtils {

	public static void onUpdate(InterceptorProxy proxy, Serializable entity) {
		if (entity instanceof ITraceable) {
			TraceInformation tr = ((ITraceable) entity).getTraceable();
			tr.setLastUpdateDate(new Date());
			proxy.changeProperty(ITraceable.TRACEABLE, tr);
		}
	}

	public static void onCreate(InterceptorProxy proxy, Serializable entity) {
		if (entity instanceof ITraceable) {
			TraceInformation tr = new TraceInformation();
			tr.setCreationDate(new Date());
			proxy.changeProperty(ITraceable.TRACEABLE, tr);
		}
	}

}
