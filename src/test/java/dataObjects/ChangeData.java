package dataObjects;

import java.util.List;

public class ChangeData extends dataUtil{
    public String Requester;
    public String ITService;
    public String Component;
    public String Symptom;
    public String ProblemType;
    public String TFSReference;
    public String SupplierReference;
    public String OwningGroup;
    public String AssignmentGroup;
    public String Impact;
    public String Urgency;
    public String Priority;
    public String ProblemTitle;
    public String ProblemStatement;
    public String BusinessImpact;
    public String Workaround;
    public String WorkNotes;
    public String ResolutionCode;
    public String ResolutionNotes;
    public String RootcauseInfo;
    public String SolutionDeploymentDetails;
    public String ResolutionDetails;
    public String ClosureCode;
    public String ClosureNotes;
    public String Opened;

    public void initialize(List<List<String>> data){
        this.Requester = getData("Requester", data, this.Requester);
        this.ITService = getData("ITService", data, this.ITService);
        this.Component = getData("Component", data, this.Component);
        this.Symptom = getData("Symptom", data, this.Symptom);
        this.ProblemType = getData("ProblemType", data, this.ProblemType);
        this.TFSReference = getData("TFSReference", data, this.TFSReference);
        this.SupplierReference = getData("SupplierReference", data, this.SupplierReference);
        this.OwningGroup = getData("OwningGroup", data, this.OwningGroup);
        this.AssignmentGroup = getData("AssignmentGroup", data, this.AssignmentGroup);
        this.Impact = getData("Impact", data, this.Impact);
        this.Urgency = getData("Urgency", data, this.Urgency);
        this.Priority = getData("Priority", data, this.Priority);
        this.ProblemTitle = getData("ProblemTitle", data, this.ProblemTitle);
        this.ProblemStatement = getData("ProblemStatement", data, this.ProblemStatement);
        this.BusinessImpact = getData("BusinessImpact", data, this.BusinessImpact);
        this.Workaround = getData("Workaround", data, this.Workaround);
        this.WorkNotes = getData("WorkNotes", data, this.WorkNotes);
        this.ResolutionCode = getData("ResolutionCode", data, this.ResolutionCode);
        this.ResolutionNotes = getData("ResolutionNotes", data, this.ResolutionNotes);
        this.SolutionDeploymentDetails = getData("SolutionDeploymentDetails", data, this.SolutionDeploymentDetails);
        this.ResolutionDetails = getData("ResolutionDetails", data, this.ResolutionDetails);
        this.RootcauseInfo = getData("RootcauseInfo", data, this.RootcauseInfo);
        this.ClosureCode = getData("ClosureCode", data, this.ClosureCode);
        this.ClosureNotes = getData("ClosureNotes", data, this.ClosureNotes);
    }
}
