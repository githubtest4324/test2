package test2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class TraceInformation implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private Date creationDate;
	private Date lastUpdateDate;
	private String lastUpdatedBy;
	private String createdBy;

	public static final String CREATION_DATE = "creationDate";
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public static final String LAST_UPDATE_DATE = "lastUpdateDate";
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public static final String LAST_UPDATED_BY = "lastUpdatedBy";
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public static final String CREATED_BY = "createdBy";
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
