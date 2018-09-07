package de.tub.qds.rm.models.consts.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.qds.rm.models.values.DiskValue;
import de.tub.qds.rm.models.values.pks.DiskValuePK;

public interface DiskValueRepo extends JpaRepository<DiskValue, DiskValuePK> {

	Set<DiskValue> findByDiskValueIdDiskValueDiskDiskSerialNumberOrderByDiskValueIdDiskValueTimestampAsc(String diskSerialNumber);
	Set<DiskValue> findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementId(String diskSerialNumber, Long measurementId);
	Set<DiskValue> findByDiskValueIdDiskValueDiskDiskSerialNumberAndDiskValueIdDiskValueMeasurementIdOrderByDiskValueIdDiskValueTimestampAsc(String diskSerialNumber, Long measurementId);
}