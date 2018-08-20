package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.pks.FirmwarePK;

public interface FirmwareRepo extends JpaRepository<Firmware, FirmwarePK> {

	public Firmware findByFirmwareIdFirmwareIdentifier(int firmwareIdentifier);
	public boolean existsByFirmwareIdFirmwareIdentifier(int firmwareIdentifier);
	
}