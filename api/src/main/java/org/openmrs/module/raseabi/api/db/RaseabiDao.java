package org.openmrs.module.raseabi.api.db;

import org.openmrs.module.raseabi.api.model.Appointment;

import java.util.List;

public interface RaseabiDao {
	
	List<Appointment> getAllAppointments();
	
	Appointment getAppointment(Integer appointmentId);
	
}
