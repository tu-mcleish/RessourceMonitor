package de.tub.qds.rm;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.tub.qds.rm.models.consts.Measurement;
import de.tub.qds.rm.models.consts.Memory;
import de.tub.qds.rm.models.consts.repos.MeasurementRepo;
import de.tub.qds.rm.models.consts.repos.MemoryRepo;
import de.tub.qds.rm.models.consts.repos.MemoryValueRepo;
import de.tub.qds.rm.models.values.MemoryValue;
import de.tub.qds.rm.models.values.pks.MemoryValuePK;

@Component
public class ScheduledTask {
	@Autowired
	MemoryRepo memRepo;
	@Autowired
	MemoryValueRepo memoryValueRepo;
	@Autowired
	MeasurementRepo measurementRepo;

	@Scheduled(fixedRate = 5000)
	public void execute() {

		List<Measurement> measurements = measurementRepo.findByMeasurementRunningTrue();
		for (Measurement measurement : measurements) {
			JSONObject obj;
			try {
				obj = Unirest.get("http://localhost:8090/systemInfo/hardware/memory").asJson().getBody().getObject();
				long total = obj.optLong("total");
				long available = obj.optLong("available");
				long swapTotal = obj.optLong("swapTotal");
				long swapUsed = obj.optLong("swapUsed");
				Memory memory = memRepo.findById(total).get();
				MemoryValuePK pk = new MemoryValuePK(memory, measurement.getMeasurementId(), new Timestamp(System.currentTimeMillis()));
				memoryValueRepo.save(new MemoryValue(pk, available, swapTotal, swapUsed));

			} catch (UnirestException e) {

			}
		}

	}



	public void add(String s) {
		// arr.add(s);
	}

	public void enable() {
		// enabled = true;
	}

	public void disable() {
		// abled = false;
	}
}