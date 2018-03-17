package dataObjects;

import java.util.List;

public class TemplateData extends dataUtil{
    public String Name;
    public String Table;
    public String ShortDescription;
    public String Groups;

    public void initialize(List<List<String>> data){
        this.Name = getData("Name", data, this.Name);
        this.Table = getData("Table", data, this.Table);
        this.ShortDescription = getData("ShortDescription", data, this.ShortDescription);
        this.Groups = getData("Groups", data, this.Groups);
    }
}
