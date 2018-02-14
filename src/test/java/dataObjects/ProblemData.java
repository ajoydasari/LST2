package dataObjects;

import java.util.List;

public class ProblemData extends dataUtil{
    public String Requester;
    public String PSCUser;
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
    public String WorkNotes;
    public String CustomerWorkNotes;
    public String Subject;
    public String ResolutionCode;
    public String ResolutionNotes;
    public String ClosureCode;
    public String ClosureNotes;

    public void initialize(List<List<String>> data){
        this.Requester = getData("Requester", data, this.Requester);
        this.PSCUser = getData("PSCUser", data,this.PSCUser);
        this.CustomerRelated = getData("CustomerRelated", data,this.CustomerRelated);
        this.ITService = getData("ITService", data, this.ITService);
        this.Component = getData("Component", data, this.Component);
        this.Symptom = getData("Symptom", data, this.Symptom);
        this.TFSReference = getData("TFSReference", data, this.TFSReference);
        this.SupplierReference = getData("SupplierReference", data, this.SupplierReference);
        this.OwningGroup = getData("OwningGroup", data, this.OwningGroup);
        this.AssignmentGroup = getData("AssignmentGroup", data, this.AssignmentGroup);
        this.Impact = getData("Impact", data, this.Impact);
        this.Urgency = getData("Urgency", data, this.Urgency);
        this.Priority = getData("Priority", data, this.Priority);
        this.ShortDescription = getData("ShortDescription", data, this.ShortDescription);
        this.Description = getData("Description", data, this.Description);

        this.WorkNotes = getData("WorkNotes", data, this.WorkNotes);
        this.CustomerWorkNotes = getData("CustomerWorkNotes", data, this.CustomerWorkNotes);
        this.Subject = getData("Subject", data, this.Subject);
        this.ResolutionCode = getData("ResolutionCode", data, this.ResolutionCode);
        this.ResolutionNotes = getData("ResolutionNotes", data, this.ResolutionNotes);
        this.ClosureCode = getData("ClosureCode", data, this.ClosureCode);
        this.ClosureNotes = getData("ClosureNotes", data, this.ClosureNotes);
    }
}
