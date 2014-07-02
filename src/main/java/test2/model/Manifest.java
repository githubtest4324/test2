package test2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import test2.interceptors.InterceptorEntity;
import test2.interceptors.InterceptorProxy;



@Entity
public class Manifest implements Serializable, InterceptorEntity, IReferentiable {
	@SuppressWarnings("unused")
	private final static Logger	logger			= Logger.getLogger(Manifest.class.getName());
	private static final long	serialVersionUID	= 1L;
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	private String referenceNo;
	@ManyToOne(targetEntity=Ord.class)
	private Ord order;
	
	@Embedded
	private TraceInformation traceable;

	
	
	public static final String ID = "id";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static final String REFERENCE_NO = "referenceNo";
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public static final String ORDER = "order";
	public Ord getOrder() {
		return order;
	}
	public void setOrder(Ord order) {
		this.order = order;
	}
	public TraceInformation getTraceable() {
		return traceable;
	}
	public void setTraceable(TraceInformation traceable) {
		this.traceable = traceable;
	}
	public boolean beforeSave() {
		if(this.traceable==null){
			this.traceable = new TraceInformation();
		}
		this.traceable.setLastUpdateDate(new Date());
		return true;
	}
	public void onUpdate(InterceptorProxy proxy) {
		proxy.changeProperty("lastUpdateDate", new Date());
	}
	public void onCreate(InterceptorProxy proxy) {
		TraceInformation tr = new TraceInformation();
		tr.setCreationDate(new Date());
		proxy.changeProperty("traceable", tr);
	}
	
	
}
