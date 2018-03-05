package dataObjects;

import java.util.List;

public class RiskImpactData extends dataUtil{
    public String HowManyImpacted;
    public String WhatImpactOnService;
    public String WithinServiceHours;
    public String DateStartTimeCanChange;
    public String TestingDone;
    public String TestingCompleted;
    public String EvidenceProvided;
    public String InvolveOtherSuppliers;
    public String AccessObtained;
    public String CanServicesBeRestored;
    public String PrerequisitesCompleted;

    public void initialize(List<List<String>> data){
        this.HowManyImpacted = getData("HowManyImpacted", data, this.HowManyImpacted);
        this.WhatImpactOnService = getData("WhatImpactOnService", data, this.WhatImpactOnService);
        this.WithinServiceHours = getData("WithinServiceHours", data, this.WithinServiceHours);
        this.DateStartTimeCanChange = getData("DateStartTimeCanChange", data, this.DateStartTimeCanChange);
        this.TestingDone = getData("TestingDone", data, this.TestingDone);
        this.TestingCompleted = getData("TestingCompleted", data, this.TestingCompleted);
        this.EvidenceProvided = getData("EvidenceProvided", data, this.EvidenceProvided);
        this.InvolveOtherSuppliers = getData("InvolveOtherSuppliers", data, this.InvolveOtherSuppliers);
        this.AccessObtained = getData("AccessObtained", data, this.AccessObtained);
        this.CanServicesBeRestored = getData("CanServicesBeRestored", data, this.CanServicesBeRestored);
        this.PrerequisitesCompleted = getData("PrerequisitesCompleted", data, this.PrerequisitesCompleted);
    }
}
