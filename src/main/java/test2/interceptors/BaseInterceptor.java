package test2.interceptors;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class BaseInterceptor extends EmptyInterceptor{
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(BaseInterceptor.class.getName());
	private static final long	serialVersionUID	= 1L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if(entity instanceof InterceptorEntity){
			InterceptorProxy proxy = new InterceptorProxy(state, propertyNames);
			((InterceptorEntity)entity).onCreate(proxy);
			return proxy.isChanged();
		} else{
			return false;
		}
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		if(entity instanceof InterceptorEntity){
			InterceptorProxy proxy = new InterceptorProxy(currentState, propertyNames);
			((InterceptorEntity)entity).onUpdate(proxy);
			return proxy.isChanged();
		} else{
			return false;
		}
	}
	
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		return super.onLoad(entity, id, state, propertyNames, types);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void preFlush(Iterator entities) {
		super.preFlush(entities);
	}
}
