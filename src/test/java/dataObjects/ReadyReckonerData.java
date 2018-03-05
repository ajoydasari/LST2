package dataObjects;

import java.util.List;

public class ReadyReckonerData extends dataUtil{
    public String ITService;
    public String EmergencyChange;
    public String NewService;
    public String MultiEnvironment;
    public String MultipleSuppliers;
    public String ImpactOtherITSystems;
    public String DeployTogether;

    public void initialize(List<List<String>> data){
        this.ITService = getData("ITService", data, this.ITService);
        this.EmergencyChange = getData("EmergencyChange", data, this.EmergencyChange);
        this.NewService = getData("NewService", data, this.NewService);
        this.MultiEnvironment = getData("MultiEnvironment", data, this.MultiEnvironment);
        this.MultipleSuppliers = getData("MultipleSuppliers", data, this.MultipleSuppliers);
        this.ImpactOtherITSystems = getData("ImpactOtherITSystems", data, this.ImpactOtherITSystems);
        this.DeployTogether = getData("DeployTogether", data, this.DeployTogether);
    }
}
