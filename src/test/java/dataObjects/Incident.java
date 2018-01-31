package dataObjects;

import java.util.List;

public class Incident {
    public String Requester;
    public String CustomerRelated;
    public String ITService;
    public String Component;
    public String Symptom;
    public String TFSReference;
    public String SupplierReference;
    public String OwningGroup;
    public String AssignmentGroup;
    public String Impact;
    public String Urgency;
    public String Priority;
    public String ShortDescription;
    public String Description;

    public void initialize(List<List<String>> data){
        this.Requester = data.get(1).get(0);
        this.CustomerRelated = data.get(1).get(1);
        this.ITService = data.get(1).get(2);
        this.Component = data.get(1).get(3);
        this.Symptom = data.get(1).get(4);
        this.TFSReference = data.get(1).get(5);
        this.SupplierReference = data.get(1).get(6);
        this.OwningGroup = data.get(1).get(7);
        this.AssignmentGroup = data.get(1).get(8);
        this.Impact = data.get(1).get(9);
        this.Urgency = data.get(1).get(10);
        this.Priority = data.get(1).get(11);
        this.ShortDescription = data.get(1).get(12);
        this.Description = data.get(1).get(13);
    }
}

