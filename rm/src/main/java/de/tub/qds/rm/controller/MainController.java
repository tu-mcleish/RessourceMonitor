package de.tub.qds.rm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.models.consts.Baseboard;
import de.tub.qds.rm.models.consts.Disk;
import de.tub.qds.rm.models.consts.FileStore;
import de.tub.qds.rm.models.consts.Firmware;
import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.Network;
import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.Processor;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.SystemModel;
import de.tub.qds.rm.models.consts.pks.FirmwarePK;
import de.tub.qds.rm.models.consts.pks.HardwarePK;
import de.tub.qds.rm.models.consts.pks.OperatingSystemPK;
import de.tub.qds.rm.models.consts.pks.SystemPK;
import de.tub.qds.rm.models.consts.repos.BaseboardRepo;
import de.tub.qds.rm.models.consts.repos.DiskRepo;
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.consts.repos.FirmwareRepo;
import de.tub.qds.rm.models.consts.repos.HardwareDiskRepo;
import de.tub.qds.rm.models.consts.repos.HardwareNetworkRepo;
import de.tub.qds.rm.models.consts.repos.HardwareRepo;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.consts.repos.NetworkRepo;
import de.tub.qds.rm.models.consts.repos.OperatingSystemRepo;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.consts.repos.ProcessorRepo;
import de.tub.qds.rm.models.consts.repos.SystemModelRepo;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

@RestController
public class MainController {
	
	@Autowired BaseboardRepo baseboardRepo;
	@Autowired DiskRepo diskRepo;
	@Autowired FileStoreRepo fileStoreRepo;
	@Autowired FirmwareRepo firmwareRepo;
	@Autowired HardwareDiskRepo hardwareDiskRepo;
	@Autowired HardwareNetworkRepo hardwareNetworkRepo;
	@Autowired HardwareRepo hardwareRepo;
	@Autowired MeasurementRepo measurementRepo;
	@Autowired MemoryRepo memoryRepo;
	@Autowired NetworkRepo networkRepo;
	@Autowired OperatingSystemRepo operatingSystemRepo;
	@Autowired ProcessRepo processRepo;
	@Autowired ProcessorRepo processorRepo;
	@Autowired SystemModelRepo systemModelRepo;
	@Autowired SystemRepo systemRepo;
	
	@RequestMapping(method = RequestMethod.GET, path="/createTestDataSet", produces = "application/json")
	public Measurement createTestDataSet(){
		/*Baseboard baseboard = new Baseboard();
		Disk disk = new Disk();
		FileStore fileStore = new FileStore();
		FileSystem fileSystem = new FileSystem();
		Firmware firmware = new Firmware();
		Hardware hardware = new Hardware();*/
		JSONObject obj = null;
		try {
			obj = Unirest.get("http://localhost:8090/systemInfo/hardware/memory").asJson().getBody().getObject();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Measurement measurement = new Measurement();
		OperatingSystem operatingSystem = new OperatingSystem(new OperatingSystemPK("Test", "1", "2", "3", "4"));
		operatingSystemRepo.save(operatingSystem);
		Memory memory = memoryRepo.save(new Memory(obj.getLong("total")));
		Firmware firmware = firmwareRepo.save(new Firmware(new FirmwarePK("1", "2", "3", "4", "5")));
		Baseboard baseboard = baseboardRepo.save(new Baseboard("1", "", "", ""));
		SystemModel systemModel = systemModelRepo.save(new SystemModel("1", "", ""));
		Processor processor = new Processor();
		processor.setProcessorId("1");
		processor = processorRepo.save(processor);
		Hardware hardware = hardwareRepo.save(new Hardware(new HardwarePK(firmware, processor, memory, baseboard, systemModel)));
		//measurement.setMeasurementStartDate(new Date(java.lang.System.currentTimeMillis()));
		measurement.setMeasurementRunning(true);
		System system = new System();
		system.setSystemId(new SystemPK("localhost", operatingSystem, hardware));
		systemRepo.save(system);
		measurementRepo.save(measurement);
		return measurement;
	}
	@RequestMapping(method = RequestMethod.GET, path = "/api")
	public void getApi(HttpServletRequest request, HttpServletResponse response){
	    try {
			response.sendRedirect(request.getContextPath() + "/swagger-ui.html");
		} catch (IOException e) {
			return;
		}
	  }
	
	@RequestMapping(method = RequestMethod.POST, path = "/createTestDataWithLocalhost")
	public void createTestDataWithLocalhost(){
		String testData = null;
		try {
			testData = Unirest.get("http://localhost:8090/systemInfo").asJson().getBody().toString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		DocumentContext context = JsonPath.parse(testData);
		
		String systemModelSerialNumber 	=	context.read("$.hardware.computerSystem.serialNumber").toString();;
		String systemModelManufacturer	=	context.read("$.hardware.computerSystem.manufacturer").toString();;
		String systemModelModel			=	context.read("$.hardware.computerSystem.model").toString();;
		SystemModel systemModel = new SystemModel(systemModelSerialNumber, systemModelManufacturer, systemModelModel);
		systemModelRepo.save(systemModel);
				
		String baseboardSerialNumber	=	context.read("$.hardware.computerSystem.baseboard.serialNumber").toString();
		String baseboardManufacturer	=	context.read("$.hardware.computerSystem.baseboard.manufacturer").toString();
		String baseboardModel			=	context.read("$.hardware.computerSystem.baseboard.model").toString();
		String baseboardVersion			=	context.read("$.hardware.computerSystem.baseboard.version").toString();
		Baseboard baseboard = new Baseboard(baseboardSerialNumber, baseboardManufacturer, baseboardModel, baseboardVersion);
		baseboardRepo.save(baseboard);
		
		String firmwareManufacturer		=	context.read("$.hardware.computerSystem.firmware.manufacturer").toString();
		String firmwareName				=	context.read("$.hardware.computerSystem.firmware.name").toString();
		String firmwareDescription		=	context.read("$.hardware.computerSystem.firmware.description").toString();
		String firmwareVersion			=	context.read("$.hardware.computerSystem.firmware.version").toString();
		String firmwareReleaseDate		=	context.read("$.hardware.computerSystem.firmware.releaseDate").toString();
		FirmwarePK firmwareId = new FirmwarePK(firmwareManufacturer, firmwareName, firmwareDescription, firmwareVersion, firmwareReleaseDate);
		Firmware firmware = new Firmware(firmwareId);
		firmwareRepo.save(firmware);
		
		String processorId					=	context.read("$.hardware.processor.processorID").toString();
		String processorName				=	context.read("$.hardware.processor.name").toString();
		String processorVendor				=	context.read("$.hardware.processor.vendor").toString();
		String processorFamily				=	context.read("$.hardware.processor.family").toString();
		String processorModel				=	context.read("$.hardware.processor.model").toString();
		String processorStepping			=	context.read("$.hardware.processor.stepping").toString();
		int processorPhysicalPackageCount	=	Integer.parseInt(context.read("$.hardware.processor.physicalPackageCount").toString());
		int processorPhysicalProcessorCount =	Integer.parseInt(context.read("$.hardware.processor.physicalProcessorCount").toString());
		int processorLogicalProcessorCount	=	Integer.parseInt(context.read("$.hardware.processor.logicalProcessorCount").toString());
		boolean processorCpu64bit			=	Boolean.getBoolean(context.read("$.hardware.processor.cpu64bit").toString());
		long processorVendorFreq			=	Long.parseLong(context.read("$.hardware.processor.logicalProcessorCount").toString());
		Processor processor = new Processor(processorId, processorName, processorVendor, processorFamily, processorModel, processorStepping, processorPhysicalPackageCount, processorPhysicalProcessorCount, processorLogicalProcessorCount, processorCpu64bit, processorVendorFreq);;
		processorRepo.save(processor);
		
		long memoryTotalSpace =	Long.parseLong(context.read("$.hardware.memory.total").toString());
		Memory memory = new Memory(memoryTotalSpace);
		memoryRepo.save(memory);
		
		List<Disk> disks = new ArrayList<Disk>();
		for(int i = 0; i<Integer.parseInt(context.read("$.hardware.disks.length()").toString()) ; i++)
		{
			String diskSerialNumber	=	context.read("$.hardware.disks["+i+"].serial").toString();
			String diskModel		=	context.read("$.hardware.disks["+i+"].model").toString();
			String diskName			=	context.read("$.hardware.disks["+i+"].name").toString();
			Long diskSize			=	Long.parseLong(context.read("$.hardware.disks["+i+"].size").toString());
			Disk disk = new Disk(diskSerialNumber, diskModel, diskName, diskSize);
			diskRepo.save(disk);
			disks.add(disk);
		}
		
		List<FileStore> fileStores = new ArrayList<FileStore>();
		for(int i = 0; i<Integer.parseInt(context.read("$.operatingSystem.fileSystem.fileStores.length()").toString()) ; i++)
		{
			Long fileStoreTotalSpace	=	Long.parseLong(context.read("$.operatingSystem.fileSystem.fileStores["+i+"].totalSpace").toString());
			String fileStoreUuid		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].uuid").toString();
			String fileStoreName		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].name").toString();
			String fileStoreVolume		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].volume").toString();
			String fileStoreMountPoint	=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].mountPoint").toString();
			String fileStoreDescription	=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].description").toString();
			String fileStoreFsType		=	context.read("$.operatingSystem.fileSystem.fileStores["+i+"].fsType").toString();
			FileStore fileStore = new FileStore(fileStoreUuid, fileStoreTotalSpace, fileStoreName, fileStoreVolume,  fileStoreMountPoint, fileStoreDescription, fileStoreFsType);
			fileStoreRepo.save(fileStore);
			fileStores.add(fileStore);
		}
		
		List<Network> networks = new ArrayList<Network>();
		for(int i = 0; i<Integer.parseInt(context.read("$.hardware.networks.length()").toString()) ; i++)
		{
			String networkIpv4 = "";
			String networkIpv6 = "";
			String networkMac			=	context.read("$.hardware.networks["+i+"].mac").toString();
			String networkName			=	context.read("$.hardware.networks["+i+"].name").toString();
			String networkDisplayName	=	context.read("$.hardware.networks["+i+"].displayName").toString();
			if(Integer.parseInt(context.read("$.hardware.networks["+i+"].ipv4.length()").toString()) > 0){
				networkIpv4			=	context.read("$.hardware.networks["+i+"].ipv4[0]").toString();
			}
			if(Integer.parseInt(context.read("$.hardware.networks["+i+"].ipv6.length()").toString()) > 0){
				networkIpv6			=	context.read("$.hardware.networks["+i+"].ipv6[0]").toString();
			}
			Long networkMtu				=	Long.parseLong(context.read("$.hardware.networks["+i+"].mtu").toString());
			Long networkSpeed			=	Long.parseLong(context.read("$.hardware.networks["+i+"].speed").toString());
			Network network = new Network(networkMac, networkName, networkDisplayName, networkIpv4, networkIpv6, networkMtu, networkSpeed);
			networkRepo.save(network);
			networks.add(network);
		}
		
		String operatingSystemManufacturer	=	context.read("$.operatingSystem.manufacturer").toString();
		String operatingSystemFamily		=	context.read("$.operatingSystem.family").toString();
		String operatingSystemVersion		=	context.read("$.operatingSystem.version.version").toString();
		String operatingSystemCodeName		=	context.read("$.operatingSystem.version.codeName").toString();
		String operatingSystemBuild			=	context.read("$.operatingSystem.version.build").toString();
		OperatingSystemPK operatingSystemId = new OperatingSystemPK(operatingSystemManufacturer, operatingSystemFamily, operatingSystemVersion, operatingSystemCodeName, operatingSystemBuild);
		OperatingSystem operatingSystem = new OperatingSystem(operatingSystemId);
		operatingSystemRepo.save(operatingSystem);
		
		HardwarePK hardwareId = new HardwarePK(firmware, processor, memory, baseboard, systemModel);
		Hardware hardware = new Hardware(hardwareId);
		hardwareRepo.save(hardware);
		
		try{
			SystemPK systemId = new SystemPK("localhost", operatingSystem, hardware);
			System system = new System(systemId);
			systemRepo.save(system);
		}
		catch(Exception e){
			java.lang.System.out.println(e.getMessage());
		}
		
		SystemPK systemId = new SystemPK("localhost", operatingSystem, hardware);
		System system = new System(systemId);
		
		Measurement measurement = new Measurement();
		measurement.setMeasurementSystem(system);
		measurementRepo.save(measurement);
		
	}

	

}