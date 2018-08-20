package de.tub.qds.rm.models.consts.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import de.tub.qds.rm.models.consts.Measurement;

@Embeddable
public class ProcessPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE) long processIdentifier;
	String processName;
	long processPid;
	@ManyToOne
	Measurement processMeasurement;

	public ProcessPK() {
	}

	public ProcessPK(String name, int pid) {
		super();
		this.processName = name;
		this.processPid = pid;
	}
	

	public long getProcessIdentifier() {
		return processIdentifier;
	}

	public void setProcessIdentifier(long processIdentifier) {
		this.processIdentifier = processIdentifier;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public long getProcessPid() {
		return processPid;
	}

	public void setProcessPid(long processPid) {
		this.processPid = processPid;
	}

	public Measurement getProcessMeasurement() {
		return processMeasurement;
	}

	public void setProcessMeasurement(Measurement processMeasurement) {
		this.processMeasurement = processMeasurement;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}