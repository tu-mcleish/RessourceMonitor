package de.tub.qds.rm.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tub.qds.rm.models.consts.Hardware;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.values.MemoryValue;

@RestController
public class MemoryController {
	
	@Autowired
	MemoryRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/memory", produces = "application/json")
	public List<Memory> getMemories() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}", produces = "application/json")
	public Memory getMemoryByTotalSpace(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		return repo.existsById(memoryTotalSpace) ? repo.findById(memoryTotalSpace).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryValues", produces = "application/json")
	public Set<MemoryValue> getMemoryByTotalSpaceValues(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		return repo.existsById(memoryTotalSpace) ? repo.findById(memoryTotalSpace).get().getMemoryValues() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/memory/{memoryTotalSpace}/memoryHardware", produces = "application/json")
	public Set<Hardware> getMemoryByTotalSpaceHardware(@PathVariable("memoryTotalSpace") long memoryTotalSpace) {
		return repo.existsById(memoryTotalSpace) ? repo.findById(memoryTotalSpace).get().getMemoryHardware() : null;
	}

}