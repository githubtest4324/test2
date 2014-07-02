package test2.interceptors;


public interface InterceptorEntity {
	/**
	 * Called before the entity is updated in the dateabase.
	 * Proxy changes will update the real object before saving in the database.
	 * @return True if the proxy is changed
	 */
	void onUpdate(InterceptorProxy proxy);
	/**
	 * Called before the entity is updated in the dateabase.
	 * Proxy changes will update the real object before saving in the database.
	 * @return True if the proxy is changed
	 */
	void onCreate(InterceptorProxy proxy);
}
