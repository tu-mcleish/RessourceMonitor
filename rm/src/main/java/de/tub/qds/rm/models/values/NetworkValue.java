package de.tub.qds.rm.models.values;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import de.tub.qds.rm.models.values.pks.NetworkValuePK;

@Entity
public class NetworkValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	NetworkValuePK networkValueId;
	long networkValueBytesRecv;
	long networkValueBytesSent;
	long networkValuePacketsRecv;
	long networkValuePacketsSent;
	long networkValueInErrors;
	long networkValueOutErrors;

	public NetworkValue() {
	}

	public NetworkValue(NetworkValuePK id, long bytesRecv, long bytesSent, long packetsRecv, long packetsSent,
			long inErrors, long outErrors) {
		super();
		this.networkValueId = id;
		this.networkValueBytesRecv = bytesRecv;
		this.networkValueBytesSent = bytesSent;
		this.networkValuePacketsRecv = packetsRecv;
		this.networkValuePacketsSent = packetsSent;
		this.networkValueInErrors = inErrors;
		this.networkValueOutErrors = outErrors;
	}

	
	public NetworkValuePK getNetworkValueId() {
		return networkValueId;
	}

	public void setNetworkValueId(NetworkValuePK networkValueId) {
		this.networkValueId = networkValueId;
	}

	public long getNetworkValueBytesRecv() {
		return networkValueBytesRecv;
	}

	public void setNetworkValueBytesRecv(long networkValueBytesRecv) {
		this.networkValueBytesRecv = networkValueBytesRecv;
	}

	public long getNetworkValueBytesSent() {
		return networkValueBytesSent;
	}

	public void setNetworkValueBytesSent(long networkValueBytesSent) {
		this.networkValueBytesSent = networkValueBytesSent;
	}

	public long getNetworkValuePacketsRecv() {
		return networkValuePacketsRecv;
	}

	public void setNetworkValuePacketsRecv(long networkValuePacketsRecv) {
		this.networkValuePacketsRecv = networkValuePacketsRecv;
	}

	public long getNetworkValuePacketsSent() {
		return networkValuePacketsSent;
	}

	public void setNetworkValuePacketsSent(long networkValuePacketsSent) {
		this.networkValuePacketsSent = networkValuePacketsSent;
	}

	public long getNetworkValueInErrors() {
		return networkValueInErrors;
	}

	public void setNetworkValueInErrors(long networkValueInErrors) {
		this.networkValueInErrors = networkValueInErrors;
	}

	public long getNetworkValueOutErrors() {
		return networkValueOutErrors;
	}

	public void setNetworkValueOutErrors(long networkValueOutErrors) {
		this.networkValueOutErrors = networkValueOutErrors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}