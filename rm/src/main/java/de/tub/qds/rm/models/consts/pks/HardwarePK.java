package de.tub.qds.rm.models.consts.pks;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.SystemModel;

@Embeddable
public class HardwarePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE) int hardwareIdentifier;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	SystemModel hardwareSystemModel;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Baseboard hardwareBaseboard;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Firmware hardwareFirmware;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Processor hardwareProcessor;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Memory hardwareMemory;

	public HardwarePK() {
	}

	public HardwarePK(Firmware firmware, Processor processor, Memory memory, Baseboard baseboard,
			SystemModel systemModel) {
		super();
		this.hardwareFirmware = firmware;
		this.hardwareProcessor = processor;
		this.hardwareMemory = memory;
		this.hardwareBaseboard = baseboard;
		this.hardwareSystemModel = systemModel;
		/*
		 * this.hardwareNetworks = new HashSet<Network>(); this.hardwareMemory =
		 * memory; this.hardwareDisks = new HashSet<Disk>();
		 */
	}
	
	public int getHardwareIdentifier() {
		return hardwareIdentifier;
	}

	public void setHardwareIdentifier(int hardwareIdentifier) {
		this.hardwareIdentifier = hardwareIdentifier;
	}

	public SystemModel getHardwareSystemModel() {
		return hardwareSystemModel;
	}

	public void setHardwareSystemModel(SystemModel hardwareSystemModel) {
		this.hardwareSystemModel = hardwareSystemModel;
	}

	public Baseboard getHardwareBaseboard() {
		return hardwareBaseboard;
	}

	public void setHardwareBaseboard(Baseboard hardwareBaseboard) {
		this.hardwareBaseboard = hardwareBaseboard;
	}

	public Firmware getHardwareFirmware() {
		return hardwareFirmware;
	}

	public void setHardwareFirmware(Firmware hardwareFirmware) {
		this.hardwareFirmware = hardwareFirmware;
	}

	public Processor getHardwareProcessor() {
		return hardwareProcessor;
	}

	public void setHardwareProcessor(Processor hardwareProcessor) {
		this.hardwareProcessor = hardwareProcessor;
	}

	public Memory getHardwareMemory() {
		return hardwareMemory;
	}

	public void setHardwareMemory(Memory hardwareMemory) {
		this.hardwareMemory = hardwareMemory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}