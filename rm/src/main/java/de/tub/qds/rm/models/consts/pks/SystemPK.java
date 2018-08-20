package de.tub.qds.rm.models.consts.pks;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.OperatingSystem;

@Embeddable
public class SystemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE) long systemIdentifier;
	String systemHostName;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	OperatingSystem systemOperatingSystem;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Hardware systemHardware;

	public SystemPK() {
	}

	public SystemPK(String hostName, OperatingSystem operatingSystem, Hardware hardware) {
		super();
		this.systemHostName = hostName;
		this.systemOperatingSystem = operatingSystem;
		this.systemHardware = hardware;
	}
	
	public long getSystemIdentifier() {
		return systemIdentifier;
	}

	public void setSystemIdentifier(long systemIdentifier) {
		this.systemIdentifier = systemIdentifier;
	}

	public String getSystemHostName() {
		return systemHostName;
	}

	public void setSystemHostName(String systemHostName) {
		this.systemHostName = systemHostName;
	}

	@JsonIgnore
	public OperatingSystem getSystemOperatingSystem() {
		return systemOperatingSystem;
	}

	public void setSystemOperatingSystem(OperatingSystem systemOperatingSystem) {
		this.systemOperatingSystem = systemOperatingSystem;
	}
	@JsonIgnore
	public Hardware getSystemHardware() {
		return systemHardware;
	}

	public void setSystemHardware(Hardware systemHardware) {
		this.systemHardware = systemHardware;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}