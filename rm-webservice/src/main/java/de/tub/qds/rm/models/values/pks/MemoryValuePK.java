package de.tub.qds.rm.models.values.pks;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.tub.qds.rm.models.consts.Memory;

@Embeddable
public class MemoryValuePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long memoryValueMeasurementId;
	Timestamp memoryValueTimestamp;
	@ManyToOne(targetEntity=Memory.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Memory memoryValueMemory;

	public MemoryValuePK() {
	}

	public MemoryValuePK(Memory memory, Long measurement, Timestamp timestamp) {
		super();
		this.memoryValueMemory = memory;
		this.memoryValueMeasurementId = measurement;
		this.memoryValueTimestamp = timestamp;
	}

	public Long getMemoryValueMeasurementId() {
		return memoryValueMeasurementId;
	}

	public void setMemoryValueMeasurementId(Long memoryValueMeasurementId) {
		this.memoryValueMeasurementId = memoryValueMeasurementId;
	}

	public Timestamp getMemoryValueTimestamp() {
		return memoryValueTimestamp;
	}

	public void setMemoryValueTimestamp(Timestamp memoryValueTimestamp) {
		this.memoryValueTimestamp = memoryValueTimestamp;
	}

	@JsonIgnore
	public Memory getMemoryValueMemory() {
		return memoryValueMemory;
	}

	public void setMemoryValueMemory(Memory memoryValueMemory) {
		this.memoryValueMemory = memoryValueMemory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
