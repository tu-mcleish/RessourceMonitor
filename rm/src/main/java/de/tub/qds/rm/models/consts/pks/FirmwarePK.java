package de.tub.qds.rm.models.consts.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class FirmwarePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE) int firmwareIdentifier;
	String firmwareManufacturer;
	String firmwareName;
	String firmwareDescription;
	String firmwareVersion;
	String firmwareReleaseDate;

	public FirmwarePK() {
	}

	public FirmwarePK(String manufacturer, String name, String description, String version, String releaseDate) {
		super();
		this.firmwareManufacturer = manufacturer;
		this.firmwareName = name;
		this.firmwareDescription = description;
		this.firmwareVersion = version;
		this.firmwareReleaseDate = releaseDate;
	}

	public int getFirmwareIdentifier() {
		return firmwareIdentifier;
	}

	public void setFirmwareIdentifier(int firmwareIdentifier) {
		this.firmwareIdentifier = firmwareIdentifier;
	}

	public String getFirmwareManufacturer() {
		return firmwareManufacturer;
	}

	public void setFirmwareManufacturer(String firmwareManufacturer) {
		this.firmwareManufacturer = firmwareManufacturer;
	}

	public String getFirmwareName() {
		return firmwareName;
	}

	public void setFirmwareName(String firmwareName) {
		this.firmwareName = firmwareName;
	}

	public String getFirmwareDescription() {
		return firmwareDescription;
	}

	public void setFirmwareDescription(String firmwareDescription) {
		this.firmwareDescription = firmwareDescription;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getFirmwareReleaseDate() {
		return firmwareReleaseDate;
	}

	public void setFirmwareReleaseDate(String firmwareReleaseDate) {
		this.firmwareReleaseDate = firmwareReleaseDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}