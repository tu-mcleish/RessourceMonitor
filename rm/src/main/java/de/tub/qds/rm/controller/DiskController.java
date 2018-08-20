package de.tub.qds.rm.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.consts.FileStore;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.HardwareDiskRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.values.DiskValue;

@RestController
public class DiskController {
	
	@Autowired
	DiskRepo repo;
	@Autowired
	HardwareRepo hardwareRepo;
	@Autowired
	HardwareDiskRepo hardwareDiskRepo;


	@RequestMapping(method = RequestMethod.GET, path = "/disk", produces = "application/json")
	public List<Disk> getDisks() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/disk", produces = "application/json")
	public Disk postDisk(
			@RequestParam("diskSerialNumber") String diskSerialNumber, 
			@RequestParam("diskModel") String diskModel ,
			@RequestParam("diskName") String diskName,
			@RequestParam("diskSize") long diskSize
			) {
		return repo.save(new Disk(diskSerialNumber, diskModel, diskName, diskSize));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}", produces = "application/json")
	public Disk getDiskById(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber) ? repo.findById(diskSerialNumber).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskModel", produces = "text/plain")
	public String getDiskByIdDiskModel(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskModel() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskName", produces = "text/plain")
	public String getDiskByIdDiskName(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskSize", produces = "application/json")
	public Long getDiskByIdDiskSize(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskSize() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskValues", produces = "application/json")
	public Set<DiskValue> getDiskByIdDiskValues(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskValues() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskFileStores", produces = "application/json")
	public Set<FileStore> getDiskByIdDiskFileStores(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		return repo.existsById(diskSerialNumber)
				? repo.findById(diskSerialNumber).get().getDiskFileStores() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/disk/{diskSerialNumber}/diskHardware", produces = "application/json")
	public Set<Hardware> getDiskByIdDiskHardware(@PathVariable("diskSerialNumber") String diskSerialNumber) {
		Set<Hardware> hardware = new HashSet<Hardware>();
		hardwareDiskRepo.findByDiskSerialNumber(diskSerialNumber).forEach(x -> hardware.add(hardwareRepo.findByHardwareIdHardwareIdentifier(x.getHardwareIdentifier())));
		return hardware;
	}
	
}