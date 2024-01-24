package org.openmrs.module.raseabi.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.raseabi.api.model.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface RaseabiService extends OpenmrsService {
	
	List<Appointment> getAllAppointments();
}
