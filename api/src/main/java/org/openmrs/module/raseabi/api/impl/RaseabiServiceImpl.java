package org.openmrs.module.raseabi.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.raseabi.api.RaseabiService;
import org.openmrs.module.raseabi.api.db.RaseabiDao;
import org.openmrs.module.raseabi.api.model.Appointment;

import java.util.List;

public class RaseabiServiceImpl extends BaseOpenmrsService implements RaseabiService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private RaseabiDao raseabiDao;
	
	public RaseabiDao getRaseabiDao() {
		return raseabiDao;
	}
	
	public void setRaseabiDao(RaseabiDao raseabiDao) {
		this.raseabiDao = raseabiDao;
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
		return raseabiDao.getAllAppointments();
	}
}
