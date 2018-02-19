package dataObjects;

import java.util.List;

public class ProblemTaskData extends dataUtil{
    public String AssignmentGroup;
    public String TaskDescription;
    public String TaskType;
    public String Priority;
    public String DueDate;
    public String ResolutionDetails;

    public void initialize(List<List<String>> data){
        this.AssignmentGroup = getData("AssignmentGroup", data, this.AssignmentGroup);
        this.TaskDescription = getData("TaskDescription", data, this.TaskDescription);
        this.TaskType = getData("TaskType", data, this.TaskType);
        this.Priority = getData("Priority", data, this.Priority);
        this.DueDate = getData("DueDate", data, this.DueDate);
        this.ResolutionDetails = getData("ResolutionDetails", data, this.ResolutionDetails);
    }
}
