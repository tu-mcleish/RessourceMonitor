package de.tub.qds.rm.models.consts.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.consts.Process;
import de.tub.qds.rm.models.consts.pks.ProcessPK;

public interface ProcessRepo extends JpaRepository<Process, ProcessPK> {
	
	public Process findByProcessIdProcessIdentifier(long processIdentifier);
	public boolean existsByProcessIdProcessIdentifier(long processIdentifier);

}