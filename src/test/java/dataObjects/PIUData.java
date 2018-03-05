package dataObjects;

import java.util.List;

public class PIUData extends dataUtil{
    public String ChangeCompletedWithinChangeWindow;
    public String ChangeMetSuccessCriteria;
    public String AssetCINeedUpdating;

    public void initialize(List<List<String>> data){
        this.ChangeCompletedWithinChangeWindow = getData("ChangeCompletedWithinChangeWindow", data, this.ChangeCompletedWithinChangeWindow);
        this.ChangeMetSuccessCriteria = getData("ChangeMetSuccessCriteria", data, this.ChangeMetSuccessCriteria);
        this.AssetCINeedUpdating = getData("AssetCINeedUpdating", data, this.AssetCINeedUpdating);
    }
}
