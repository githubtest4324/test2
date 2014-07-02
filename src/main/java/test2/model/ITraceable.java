package test2.model;

public interface ITraceable {
	public static final String TRACEABLE = "traceable";
	public TraceInformation getTraceable();
	public void setTraceable(TraceInformation traceable);
}
