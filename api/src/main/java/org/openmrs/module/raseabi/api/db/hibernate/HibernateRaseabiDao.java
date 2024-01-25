package org.openmrs.module.raseabi.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.raseabi.api.db.RaseabiDao;
import org.openmrs.module.raseabi.api.model.Appointment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HibernateRaseabiDao implements RaseabiDao {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT          pi.identifier AS patientIdentifier,\n"
		        + "                concat(pn.given_name, \" \", pn.family_name) AS names,\n"
		        + "                pa.start_date_time AS startDate, \n"
		        + "                pa.end_date_time AS endDate,\n"
		        + "                per.gender,\n"
		        + "                pattr.value AS mobileNumber \n"
		        + "                FROM patient_appointment pa\n"
		        + "                LEFT JOIN patient_identifier pi ON pa.patient_id = pi.patient_id AND pi.identifier_type = 3 \n"
		        + "                LEFT JOIN person_name pn ON pa.patient_id = pn.person_id \n"
		        + "                LEFT JOIN person per ON pa.patient_id = per.person_id AND per.dead = 0\n"
		        + "                INNER JOIN person_attribute pattr ON pa.patient_id = pattr.person_id AND pattr.person_attribute_type_id = 26;");
		
		Session session = sessionFactory.getCurrentSession();
		
		Collection<Object[]> collection = session.createSQLQuery(sb.toString()).list();
		
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		for (Object[] ob : collection) {
			Appointment appointment = new Appointment();
			appointment.setPatientIdentifier(ob[0].toString());
			appointment.setNames(ob[1].toString());
			appointment.setStartDate(ob[3].toString());
			appointment.setEndDate(ob[4].toString());
			appointment.setGender(ob[5].toString());
			appointment.setMobileNumber(ob[6].toString());
			
			appointments.add(appointment);
		}
		
		return appointments;
	}
	
//	@Override
//	public Appointment getAppointment(Integer appointmentId) {
//		return null;
//	}
	
}
