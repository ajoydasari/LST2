package dataObjects;

import java.util.List;

public class SNOWUser {
    public String username;

    public void initialize(List<List<String>> data){
        this.username = data.get(1).get(0);
    }
}
