package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.ProcessValuePK;

@Entity
public class ProcessValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	ProcessValuePK processValueId;
	int processValueThreadCount;
	int processValuePriority;
	long processValuevirtualSize;
	long processValueResidentSetSize;
	long processValueKernelTime;
	long processValueUserTime;
	long processValueUpTime;
	long processValueStartTime;
	long processValueBytesRead;
	long processValueBytesWritten;
	long processValueHandles;

	public ProcessValue() {
	}

	public ProcessValue(ProcessValuePK id, int threadCount, int priority, long virtualSize, long residentSetSize,
			long kernelTime, long userTime, long upTime, long startTime, long bytesRead, long bytesWritten,
			long handles) {
		super();
		this.processValueId = id;
		this.processValueThreadCount = threadCount;
		this.processValuePriority = priority;
		this.processValuevirtualSize = virtualSize;
		this.processValueResidentSetSize = residentSetSize;
		this.processValueKernelTime = kernelTime;
		this.processValueUserTime = userTime;
		this.processValueUpTime = upTime;
		this.processValueStartTime = startTime;
		this.processValueBytesRead = bytesRead;
		this.processValueBytesWritten = bytesWritten;
		this.processValueHandles = handles;
	}

	
	public ProcessValuePK getProcessValueId() {
		return processValueId;
	}

	public void setProcessValueId(ProcessValuePK processValueId) {
		this.processValueId = processValueId;
	}

	public int getProcessValueThreadCount() {
		return processValueThreadCount;
	}

	public void setProcessValueThreadCount(int processValueThreadCount) {
		this.processValueThreadCount = processValueThreadCount;
	}

	public int getProcessValuePriority() {
		return processValuePriority;
	}

	public void setProcessValuePriority(int processValuePriority) {
		this.processValuePriority = processValuePriority;
	}

	public long getProcessValuevirtualSize() {
		return processValuevirtualSize;
	}

	public void setProcessValuevirtualSize(long processValuevirtualSize) {
		this.processValuevirtualSize = processValuevirtualSize;
	}

	public long getProcessValueResidentSetSize() {
		return processValueResidentSetSize;
	}

	public void setProcessValueResidentSetSize(long processValueResidentSetSize) {
		this.processValueResidentSetSize = processValueResidentSetSize;
	}

	public long getProcessValueKernelTime() {
		return processValueKernelTime;
	}

	public void setProcessValueKernelTime(long processValueKernelTime) {
		this.processValueKernelTime = processValueKernelTime;
	}

	public long getProcessValueUserTime() {
		return processValueUserTime;
	}

	public void setProcessValueUserTime(long processValueUserTime) {
		this.processValueUserTime = processValueUserTime;
	}

	public long getProcessValueUpTime() {
		return processValueUpTime;
	}

	public void setProcessValueUpTime(long processValueUpTime) {
		this.processValueUpTime = processValueUpTime;
	}

	public long getProcessValueStartTime() {
		return processValueStartTime;
	}

	public void setProcessValueStartTime(long processValueStartTime) {
		this.processValueStartTime = processValueStartTime;
	}

	public long getProcessValueBytesRead() {
		return processValueBytesRead;
	}

	public void setProcessValueBytesRead(long processValueBytesRead) {
		this.processValueBytesRead = processValueBytesRead;
	}

	public long getProcessValueBytesWritten() {
		return processValueBytesWritten;
	}

	public void setProcessValueBytesWritten(long processValueBytesWritten) {
		this.processValueBytesWritten = processValueBytesWritten;
	}

	public long getProcessValueHandles() {
		return processValueHandles;
	}

	public void setProcessValueHandles(long processValueHandles) {
		this.processValueHandles = processValueHandles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}