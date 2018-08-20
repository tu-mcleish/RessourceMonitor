package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.values.pks.DiskValuePK;

@Entity
public class DiskValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	DiskValuePK diskValueId;
	long diskValueReads;
	long diskValueReadBytes;
	long diskValueWrites;
	long diskValueWriteBytes;
	long diskValueTransferTime;

	public DiskValue() {
	}

	public DiskValue(DiskValuePK id, Disk disk, long reads, long readBytes, long writes, long writeBytes,
			long transferTime) {
		super();
		this.diskValueId = id;
		this.diskValueReads = reads;
		this.diskValueReadBytes = readBytes;
		this.diskValueWrites = writes;
		this.diskValueWriteBytes = writeBytes;
		this.diskValueTransferTime = transferTime;
	}

	public DiskValuePK getDiskValueId() {
		return diskValueId;
	}

	public void setDiskValueId(DiskValuePK diskValueId) {
		this.diskValueId = diskValueId;
	}

	public long getDiskValueReads() {
		return diskValueReads;
	}

	public void setDiskValueReads(long diskValueReads) {
		this.diskValueReads = diskValueReads;
	}

	public long getDiskValueReadBytes() {
		return diskValueReadBytes;
	}

	public void setDiskValueReadBytes(long diskValueReadBytes) {
		this.diskValueReadBytes = diskValueReadBytes;
	}

	public long getDiskValueWrites() {
		return diskValueWrites;
	}

	public void setDiskValueWrites(long diskValueWrites) {
		this.diskValueWrites = diskValueWrites;
	}

	public long getDiskValueWriteBytes() {
		return diskValueWriteBytes;
	}

	public void setDiskValueWriteBytes(long diskValueWriteBytes) {
		this.diskValueWriteBytes = diskValueWriteBytes;
	}

	public long getDiskValueTransferTime() {
		return diskValueTransferTime;
	}

	public void setDiskValueTransferTime(long diskValueTransferTime) {
		this.diskValueTransferTime = diskValueTransferTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}