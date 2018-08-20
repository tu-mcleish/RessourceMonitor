package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.SystemModel;
import de.tub.qds.rm.models.consts.repos.SystemModelRepo;

@RestController
public class SystemModelController {
	
	@Autowired
	SystemModelRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/systemModel", produces = "application/json")
	public List<SystemModel> getSystemModels() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}", produces = "application/json")
	public SystemModel getSystemModelById(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelManufacturer", produces = "text/plain")
	public String getSystemModelByIdManufacturer(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelManufacturer() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelModel", produces = "text/plain")
	public String getSystemModelByIdModel(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelModel() : null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/systemModel/{systemModelSerialNumber}/systemModelHardware", produces = "application/json")
	public Set<Hardware> getSystemModelByIdHardware(@PathVariable("systemModelSerialNumber") String systemModelSerialNumber) {
		return repo.existsById(systemModelSerialNumber) ? repo.findById(systemModelSerialNumber).get().getSystemModelHardware() : null;
	}

}