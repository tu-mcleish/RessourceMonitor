package de.tub.qds.rm.controller;

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
import de.tub.qds.rm.models.consts.repos.FileStoreRepo;
import de.tub.qds.rm.models.values.FileStoreValue;

@RestController
public class FileStoreController {

	@Autowired
	FileStoreRepo repo;

	@RequestMapping(method = RequestMethod.GET, path = "/fileStore", produces = "application/json")
	public List<FileStore> getFileStores() {
		return repo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/fileStore", produces = "application/json")
	public FileStore postFileStore(
			@RequestParam("fileStoreUuid") String fileStoreUuid, 
			@RequestParam("fileStoreTotalSpace") long fileStoreTotalSpace ,
			@RequestParam("fileStoreName") String fileStoreName,
			@RequestParam("fileStoreVolume") String fileStoreVolume,
			@RequestParam("fileStoreMountPoint") String fileStoreMountPoint,
			@RequestParam("fileStoreDescription") String fileStoreDescription,
			@RequestParam("fileStoreFsType") String fileStoreFsType
			) {
		return repo.save(new FileStore(fileStoreUuid, fileStoreTotalSpace, fileStoreName, fileStoreVolume, fileStoreMountPoint, fileStoreDescription, fileStoreFsType));
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}", produces = "application/json")
	public FileStore getFileStoreById(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid/fileStoreTotalSpace}", produces = "application/json")
	public Long getFileStoreByIdTotalSpace(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreTotalSpace() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreName", produces = "text/plain")
	public String getFileStoreByIdName(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreName() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreVolume", produces = "text/plain")
	public String getFileStoreByIdVolume(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreVolume() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreMountPoint", produces = "text/plain")
	public String getFileStoreByIdMountPoint(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreMountPoint() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreDescription", produces = "text/plain")
	public String getFileStoreByIdDescription(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreDescription() : null;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreFsType", produces = "text/plain")
	public String getFileStoreByIdFsType(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreFsType() : null;
	}
	
	/*@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreFileSystem", produces = "application/json")
	public FileSystem getFileStoreByIdFileSystem(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreFileSystem() : null;
	}*/

	/*@RequestMapping(method = RequestMethod.PUT, path = "/fileStore/{fileStoreUuid}/fileStoreFileSystem", produces = "application/json")
	public FileStore putFileStoreByIdFileSystem(@PathVariable("fileStoreUuid") String fileStoreUuid, @RequestParam("fileSystemId") long fileSystemId) {
		FileStore fileStore = repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get() : null;
		if(fileStore == null) return null;
		Optional<FileSystem> fileSystem = fileSystemRepo.findById(fileSystemId);
		if(!fileSystem.isPresent()) return null;
		fileStore.setFileStoreFileSystem(fileSystem.get());
		return repo.save(fileStore);
	}*/
	
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreDisk", produces = "application/json")
	public Disk getFileStoreByIdDisk(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreDisk() : null;
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/fileStore/{fileStoreUuid}/fileStoreValues", produces = "application/json")
	public Set<FileStoreValue> getFileStoreByIdValues(@PathVariable("fileStoreUuid") String fileStoreUuid) {
		return repo.existsById(fileStoreUuid) ? repo.findById(fileStoreUuid).get().getFileStoreValues() : null;
	}
}