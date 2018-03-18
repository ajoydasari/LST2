package dataObjects;

import java.util.List;

public class OrderSomethingData extends dataUtil{
    public String WhatDoYouWantToDo;
    public String PoiseID;
    public String AssetNumberPrefix;
    public String AssetNumber;
    public String AsysAccessRequired;
    public String LevelOfAccessRequired;
    public String ASYSScanningCapabilityRequired;
    public String PleaseSelectFromTheFollowing;
    public String PermissionType;
    public String WhatInfoIsMoving;
    public String BusinessBenefitOfMove;
    public String WhereFromAndTo;
    public String Deskside;
    public String BusinessJustification;
    public String Quantity;
    public String RegularOrderName;
    public String Approver;

    public void initialize(List<List<String>> data){
        this.WhatDoYouWantToDo = getData("WhatDoYouWantToDo", data, this.WhatDoYouWantToDo);
        this.PoiseID = getData("PoiseID", data, this.PoiseID);
        this.AssetNumber = getData("AssetNumber", data, this.AssetNumber);
        this.AssetNumberPrefix = getData("AssetNumberPrefix", data, this.AssetNumberPrefix);
        this.AsysAccessRequired = getData("AsysAccessRequired", data, this.AsysAccessRequired);
        this.LevelOfAccessRequired = getData("LevelOfAccessRequired", data, this.LevelOfAccessRequired);
        this.ASYSScanningCapabilityRequired = getData("ASYSScanningCapabilityRequired", data, this.ASYSScanningCapabilityRequired);
        this.PleaseSelectFromTheFollowing = getData("PleaseSelectFromTheFollowing", data, this.PleaseSelectFromTheFollowing);
        this.PermissionType = getData("PermissionType", data, this.PermissionType);
        this.WhatInfoIsMoving = getData("WhatInfoIsMoving", data, this.WhatInfoIsMoving);
        this.BusinessBenefitOfMove = getData("BusinessBenefitOfMove", data, this.BusinessBenefitOfMove);
        this.WhereFromAndTo = getData("WhereFromAndTo", data, this.WhereFromAndTo);
        this.Deskside = getData("Deskside", data, this.Deskside);
        this.BusinessJustification = getData("BusinessJustification", data, this.BusinessJustification);
        this.Quantity = getData("Quantity", data, this.Quantity);
        this.RegularOrderName = getData("RegularOrderName", data, this.RegularOrderName);
        this.Approver = getData("Approver", data, this.Approver);
    }
}
