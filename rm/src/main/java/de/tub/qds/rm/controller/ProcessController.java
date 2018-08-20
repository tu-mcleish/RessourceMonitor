package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.repos.ProcessRepo;
import de.tub.qds.rm.models.values.ProcessValue;

@RestController
public class ProcessController {
	

	@Autowired
	ProcessRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/process", produces = "application/json")
	public List<Process> getProcesses() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processIdentifier}", produces = "application/json")
	public Process getProcessByProcessIdProcessIdentifier(@PathVariable("processIdentifier") long processIdentifier) {
		return repo.existsByProcessIdProcessIdentifier(processIdentifier) ? repo.findByProcessIdProcessIdentifier(processIdentifier) : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processIdentifier}/processName", produces = "text/plain")
	public String getProcessByProcessIdProcessIdentifierName(@PathVariable("processIdentifier") long processIdentifier) {
		return repo.existsByProcessIdProcessIdentifier(processIdentifier) ? repo.findByProcessIdProcessIdentifier(processIdentifier).getProcessId().getProcessName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processIdentifier}/processPid", produces = "application/json")
	public long getProcessByProcessIdProcessIdentifierPid(@PathVariable("processIdentifier") long processIdentifier) {
		return repo.existsByProcessIdProcessIdentifier(processIdentifier) ? repo.findByProcessIdProcessIdentifier(processIdentifier).getProcessId().getProcessPid() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processIdentifier}/processMeasurement", produces = "application/json")
	public Measurement getProcessByProcessIdProcessIdentifierMeasurement(@PathVariable("processIdentifier") long processIdentifier) {
		return repo.existsByProcessIdProcessIdentifier(processIdentifier) ? repo.findByProcessIdProcessIdentifier(processIdentifier).getProcessId().getProcessMeasurement() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/process/{processIdentifier}/processValues", produces = "application/json")
	public Set<ProcessValue> getProcessByProcessIdProcessIdentifierValues(@PathVariable("processIdentifier") long processIdentifier) {
		return repo.existsByProcessIdProcessIdentifier(processIdentifier) ? repo.findByProcessIdProcessIdentifier(processIdentifier).getProcessValues(): null;
	}


}