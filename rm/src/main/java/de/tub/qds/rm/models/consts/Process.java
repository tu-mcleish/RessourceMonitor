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

import de.tub.qds.rm.models.consts.pks.ProcessPK;
import de.tub.qds.rm.models.values.ProcessValue;

@Entity
public class Process implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	ProcessPK processId;
	boolean processIsParentProcess;
	@OneToMany(mappedBy = "processValueId.processValueProcess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Set<ProcessValue> processValues;

	public Process() {
	}

	public Process(ProcessPK id, boolean isParentProcess) {
		super();
		this.processId = id;
		this.processIsParentProcess = isParentProcess;
		this.processValues = new HashSet<ProcessValue>();
	}

	public ProcessPK getProcessId() {
		return processId;
	}

	public void setProcessId(ProcessPK processId) {
		this.processId = processId;
	}

	public boolean isProcessIsParentProcess() {
		return processIsParentProcess;
	}

	public void setProcessIsParentProcess(boolean processIsParentProcess) {
		this.processIsParentProcess = processIsParentProcess;
	}

	@JsonIgnore
	public Set<ProcessValue> getProcessValues() {
		return processValues;
	}

	public void setProcessValues(Set<ProcessValue> processValues) {
		this.processValues = processValues;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}