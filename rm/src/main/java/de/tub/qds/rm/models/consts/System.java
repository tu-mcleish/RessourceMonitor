package de.tub.qds.rm.models.consts;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.pks.SystemPK;

@Entity
public class System implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	SystemPK systemId;
	@OneToMany(mappedBy = "measurementSystem", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	Set<Measurement> systemMeasurements;

	public System() {
		
	}

	public System(SystemPK id) {
		super();
		this.systemId = id;
		this.systemMeasurements = new HashSet<Measurement>();
	}

	public SystemPK getSystemId() {
		return systemId;
	}

	public void setSystemId(SystemPK systemId) {
		this.systemId = systemId;
	}

	@JsonIgnore
	public Set<Measurement> getSystemMeasurements() {
		return systemMeasurements;
	}

	public void setSystemMeasurements(Set<Measurement> systemMeasurements) {
		this.systemMeasurements = systemMeasurements;
	}
	
	/*public void addSystemMeasurement(Measurement systemMeasurement) {
		this.systemMeasurements.add(systemMeasurement);
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}