package org.openmrs.module.emrapi.disposition.actions;

import org.openmrs.Obs;
import org.openmrs.Visit;
import org.openmrs.module.emrapi.EmrApiProperties;
import org.openmrs.module.emrapi.adt.AdtAction;
import org.openmrs.module.emrapi.adt.AdtService;
import org.openmrs.module.emrapi.encounter.EncounterDomainWrapper;
import org.openmrs.module.emrapi.visit.VisitDomainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.openmrs.module.emrapi.adt.AdtAction.Type.DISCHARGE;

/**
 * Will actually discharge the patient from inpatient care (using
 * {@link org.openmrs.module.emrapi.adt.AdtService#admitPatient(org.openmrs.module.emrapi.adt.Admission)})
 * if they are currently admitted.
 *
 * This may not be the recommended workflow -- you might expect a disposition of Discharge to be an order for
 * discharge, not the official discharge itself, which might be done by a specific employee at the inpatient ward where
 * the patient is currently admitted.
 *
 * However in a hacky shortcut workflow you can use this action to have a Discharge disposition immediately discharge a
 * patient.
 */
@Component("dischargeIfAdmittedDispositionAction")
public class DischargeIfAdmittedDispositionAction implements DispositionAction {

    @Autowired
    EmrApiProperties emrApiProperties;

    @Autowired
    AdtService adtService;

    @Override
    public void action(EncounterDomainWrapper encounterDomainWrapper, Obs dispositionObsGroupBeingCreated, Map<String, String[]> requestParameters) {
        Visit visit = encounterDomainWrapper.getVisit();
        VisitDomainWrapper visitDomainWrapper = adtService.wrap(visit);

        if (visitDomainWrapper.isAdmitted(encounterDomainWrapper.getEncounter().getEncounterDatetime())) {
            AdtAction discharge = new AdtAction(visit, encounterDomainWrapper.getLocation(), encounterDomainWrapper.getProviders(), DISCHARGE);
            discharge.setActionDatetime(encounterDomainWrapper.getEncounter().getEncounterDatetime());
            adtService.createAdtEncounterFor(discharge);
        }
    }

    public void setAdtService(AdtService adtService) {
        this.adtService = adtService;
    }

    public void setEmrApiProperties(EmrApiProperties emrApiProperties) {
        this.emrApiProperties = emrApiProperties;
    }
}
