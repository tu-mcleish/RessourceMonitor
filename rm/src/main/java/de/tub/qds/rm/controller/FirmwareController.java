package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.FirmwareRepo;

@RestController
public class FirmwareController {
	
	@Autowired
	FirmwareRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/firmware", produces = "application/json")
	public List<Firmware> getFileStores() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}", produces = "application/json")
	public Firmware getFirmwareByIdFirmwareIdentifier(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier) : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareManufacturer", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierManufacturer(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getFirmwareId().getFirmwareManufacturer() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareName", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierName(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getFirmwareId().getFirmwareName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareDescription", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierDescription(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getFirmwareId().getFirmwareDescription() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareVersion", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierVersion(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getFirmwareId().getFirmwareVersion() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareReleaseDate", produces = "text/plain")
	public String getFirmwareByIdFirmwareIdentifierReleaseDate(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getFirmwareId().getFirmwareReleaseDate() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/firmware/{firmwareIdentifier}/firmwareHardware", produces = "application/json")
	public Set<Hardware> getFirmwareByIdFirmwareIdentifierHardware(@PathVariable("firmwareIdentifier") int firmwareIdentifier) {
		return repo.existsByFirmwareIdFirmwareIdentifier(firmwareIdentifier) ? repo.findByFirmwareIdFirmwareIdentifier(firmwareIdentifier).getHardware(): null;
	}

}