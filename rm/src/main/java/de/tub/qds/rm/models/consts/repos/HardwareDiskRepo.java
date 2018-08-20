package de.tub.qds.rm.models.consts.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.joinClasses.HardwareDisk;

public interface HardwareDiskRepo extends JpaRepository<HardwareDisk, Long> {
	
	Set<HardwareDisk>findByHardwareIdentifier(long hardwareIdentifier);
	Set<HardwareDisk>findByDiskSerialNumber(String diskSerialNumber);
	
}