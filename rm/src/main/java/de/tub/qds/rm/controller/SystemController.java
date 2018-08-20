package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.OperatingSystem;
import de.tub.qds.rm.models.consts.System;
import de.tub.qds.rm.models.consts.repos.SystemRepo;

@RestController
public class SystemController {
	
	@Autowired
	SystemRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/system", produces = "application/json")
	public List<System> getSystems() {
		try{
			return repo.findAll();
		}catch(Exception e){
			java.lang.System.out.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}", produces = "application/json")
	public System getSystenBySystemIdSystemIdentifier(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsBySystemIdSystemIdentifier(systemIdentifier) ? repo.findBySystemIdSystemIdentifier(systemIdentifier) : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemHostName", produces = "text/plain")
	public String getSystenBySystemIdSystemIdentifierHostName(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsBySystemIdSystemIdentifier(systemIdentifier) ? repo.findBySystemIdSystemIdentifier(systemIdentifier).getSystemId().getSystemHostName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemOperatingSystem", produces = "application/json")
	public OperatingSystem getSystenBySystemIdSystemIdentifierOperatingSystem(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsBySystemIdSystemIdentifier(systemIdentifier) ? repo.findBySystemIdSystemIdentifier(systemIdentifier).getSystemId().getSystemOperatingSystem() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemHardware", produces = "application/json")
	public Hardware getSystenBySystemIdSystemIdentifierHardware(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsBySystemIdSystemIdentifier(systemIdentifier) ? repo.findBySystemIdSystemIdentifier(systemIdentifier).getSystemId().getSystemHardware() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/system/{systemIdentifier}/systemMeasurements", produces = "application/json")
	public Set<Measurement> getSystenBySystemIdSystemIdentifierMeasurements(@PathVariable("systemIdentifier") long systemIdentifier) {
		return repo.existsBySystemIdSystemIdentifier(systemIdentifier) ? repo.findBySystemIdSystemIdentifier(systemIdentifier).getSystemMeasurements(): null;
	}


}