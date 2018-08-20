package de.tub.qds.rm.models.consts.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class OperatingSystemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE) long operatingSystemIdentifier;
	String operatingSystemManufacturer;
	String operatingSystemFamily;
	String operatingSystemVersion;
	String operatingSystemCodeName;
	String operatingSystemBuild;

	public OperatingSystemPK() {
	}

	public OperatingSystemPK(String manufacturer, String family, String version, String codeName, String build) {
		super();
		this.operatingSystemManufacturer = manufacturer;
		this.operatingSystemFamily = family;
		this.operatingSystemVersion = version;
		this.operatingSystemCodeName = codeName;
		this.operatingSystemBuild = build;
	}
	
	public long getOperatingSystemIdentifier() {
		return operatingSystemIdentifier;
	}

	public void setOperatingSystemIdentifier(long operatingSystemIdentifier) {
		this.operatingSystemIdentifier = operatingSystemIdentifier;
	}

	public String getOperatingSystemManufacturer() {
		return operatingSystemManufacturer;
	}

	public void setOperatingSystemManufacturer(String opratingSystemManufacturer) {
		this.operatingSystemManufacturer = opratingSystemManufacturer;
	}

	public String getOperatingSystemFamily() {
		return operatingSystemFamily;
	}

	public void setOperatingSystemFamily(String operatingSystemFamily) {
		this.operatingSystemFamily = operatingSystemFamily;
	}

	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public String getOperatingSystemCodeName() {
		return operatingSystemCodeName;
	}

	public void setOperatingSystemCodeName(String operatingSystemCodeName) {
		this.operatingSystemCodeName = operatingSystemCodeName;
	}

	public String getOperatingSystemBuild() {
		return operatingSystemBuild;
	}

	public void setOperatingSystemBuild(String operatingSystemBuild) {
		this.operatingSystemBuild = operatingSystemBuild;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}