/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.emrapi.encounter.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EncounterTransaction {
    private String locationUuid;
    private Set<String> providerUuid;
    private String patientUuid;     // TODO: mandatory validation
    private String visitTypeUuid;  // TODO: mandatory validation
    private String encounterTypeUuid;   // TODO: mandatory validation
    private Date encounterDateTime;
    private Disposition disposition;
    private List<Observation> observations = new ArrayList<Observation>();
    private List<TestOrder> testOrders = new ArrayList<TestOrder>();
    private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();

    private List<DrugOrder> drugOrders = new ArrayList<DrugOrder>();

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public String getEncounterTypeUuid() {
        return encounterTypeUuid;
    }

    public String getVisitTypeUuid() {
        return visitTypeUuid;
    }

    public EncounterTransaction setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
        return this;
    }

    public EncounterTransaction setVisitTypeUuid(String visitTypeUuid) {
        this.visitTypeUuid = visitTypeUuid;
        return this;
    }

    public EncounterTransaction setEncounterTypeUuid(String encounterTypeUuid) {
        this.encounterTypeUuid = encounterTypeUuid;
        return this;
    }

    public EncounterTransaction setObservations(List<Observation> observations) {
        this.observations = observations;
        return this;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public List<TestOrder> getTestOrders() {
        return testOrders;
    }

    public void setTestOrders(List<TestOrder> testOrders) {
        this.testOrders = testOrders;
    }

    public List<DrugOrder> getDrugOrders() {
        return drugOrders;
    }

    public void setDrugOrders(List<DrugOrder> drugOrders) {
        this.drugOrders = drugOrders;
    }

    public Date getEncounterDateTime() {
        return encounterDateTime == null ? new Date() : encounterDateTime;
    }

    public EncounterTransaction setEncounterDateTime(Date encounterDateTime) {
        this.encounterDateTime = encounterDateTime;
        return this;
    }

    public String getLocationUuid() {
        return locationUuid;
    }

    public EncounterTransaction setLocationUuid(String locationUuid) {
        this.locationUuid = locationUuid;
        return this;
    }

    public Set<String> getProviderUuids() {
        return providerUuid;
    }

    public EncounterTransaction setProviderUuid(Set<String> providerUuid) {
        this.providerUuid = providerUuid;
        return this;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public static class Observation {
        private String observationUuid;
        private String conceptUuid;     // TODO: mandatory validation
        private Object value;
        private String comment;
        private boolean voided;
        private String voidReason;

        public String getObservationUuid() {
            return observationUuid;
        }

        public Observation setObservationUuid(String observationUuid) {
            this.observationUuid = observationUuid;
            return this;
        }

        public String getConceptUuid() {
            return conceptUuid;
        }

        public Observation setConceptUuid(String conceptUuid) {
            this.conceptUuid = conceptUuid;
            return this;
        }

        public Object getValue() {
            return value;
        }

        public Observation setValue(Object value) {
            this.value = value;
            return this;
        }

        public String getComment() {
            return comment;
        }

        public Observation setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Observation setVoided(boolean voided) {
            this.voided = voided;
            return this;
        }

        public boolean isVoided() {
            return voided;
        }

        public String getVoidReason() {
            return voidReason;
        }

        public Observation setVoidReason(String voidReason) {
            this.voidReason = voidReason;
            return this;
        }
    }

    public static class Disposition{
        private String code;
        private String existingObs;
        private boolean voided;
        private String voidReason;
        private List<Observation> additionalObs;

        public List<Observation> getAdditionalObs() {
            return additionalObs;
        }

        public void setAdditionalObs(List<Observation> additionalObs) {
            this.additionalObs = additionalObs;
        }

        public Disposition() {
        }

        public Disposition(String code) {
            this.code = code;
        }

        public String getExistingObs() {
            return existingObs;
        }

        public boolean isVoided() {
            return voided;
        }

        public Disposition setVoided(boolean voided) {
            this.voided = voided;
            return this;
        }

        public String getVoidReason() {
            return voidReason;
        }

        public Disposition setVoidReason(String voidReason) {
            this.voidReason = voidReason;
            return this;
        }

        public Disposition setExistingObs(String existingObs) {
            this.existingObs = existingObs;
            return this;
        }

        public String getCode() {
            return code;
        }

        public Disposition setCode(String code) {
            this.code = code;
            return this;
        }

      /*  public String getDispositionNote() {
            return dispositionNote;
        }

        public Disposition setDispositionNote(String dispositionNote) {
            this.dispositionNote = dispositionNote;
            return this;
        }*/
    }


    public static class TestOrder {
        private String conceptUuid;     // TODO: mandatory validation
        private String orderTypeUuid;
        private String instructions;
        private String uuid;
        private boolean voided;
        private String voidReason;

        public String getConceptUuid() {
            return conceptUuid;
        }

        public TestOrder setConceptUuid(String conceptUuid) {
            this.conceptUuid = conceptUuid;
            return this;
        }

        public String getInstructions() {
            return instructions;
        }

        public TestOrder setInstructions(String instructions) {
            this.instructions = instructions;
            return this;
        }

        public String getUuid() {
            return uuid;
        }

        public TestOrder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public TestOrder setVoided(boolean voided) {
            this.voided = voided;
            return this;
        }

        public boolean isVoided() {
            return voided;
        }

        public String getVoidReason() {
            return voidReason;
        }

        public TestOrder setVoidReason(String voidReason) {
            this.voidReason = voidReason;
            return this;
        }

        public String getOrderTypeUuid() {
            return orderTypeUuid;
        }

        public TestOrder setOrderTypeUuid(String orderTypeUuid) {
            this.orderTypeUuid = orderTypeUuid;
            return this;
        }
    }

    public static class Diagnosis {
        private String order;
        private String certainty;
        private String diagnosis;
        private String existingObs;

        public String getOrder() {
            return order;
        }

        public Diagnosis setOrder(String order) {
            this.order = order;
            return this;
        }

        public String getCertainty() {
            return certainty;
        }

        public Diagnosis setCertainty(String certainty) {
            this.certainty = certainty;
            return this;
        }

        public String getDiagnosis() {
            return diagnosis;
        }

        public Diagnosis setDiagnosis(String diagnosis) {
            this.diagnosis = diagnosis;
            return this;
        }

        public String getExistingObs() {
            return existingObs;
        }

        public Diagnosis setExistingObs(String existingObs) {
            this.existingObs = existingObs;
            return this;
        }
    }

    public static class DrugOrder {
        private String uuid;
        private String conceptUuid;
        private String notes;
        private Date startDate;
        private Date  endDate;
        private Integer numberPerDosage;
        private String dosageInstructionUuid;
        private String dosageFrequencyUuid;
        private boolean prn;

        public String getUuid() {
            return uuid;
        }

        public String getConceptUuid() {
            return conceptUuid;
        }

        public String getNotes() {
            return notes;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public Integer getNumberPerDosage() {
            return numberPerDosage;
        }

        public String getDosageInstructionUuid() {
            return dosageInstructionUuid;
        }

        public String getDosageFrequencyUuid() {
            return dosageFrequencyUuid;
        }

        public boolean isPrn() {
            return prn;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public void setConceptUuid(String conceptUuid) {
            this.conceptUuid = conceptUuid;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public void setNumberPerDosage(Integer numberPerDosage) {
            this.numberPerDosage = numberPerDosage;
        }

        public void setDosageInstructionUuid(String dosageInstructionUuid) {
            this.dosageInstructionUuid = dosageInstructionUuid;
        }

        public void setDosageFrequencyUuid(String dosageFrequencyUuid) {
            this.dosageFrequencyUuid = dosageFrequencyUuid;
        }

        public void setPrn(boolean prn) {
            this.prn = prn;
        }
    }


}