package dataObjects;

import java.util.List;

public class dataUtil {

    public String getData(String field,List<List<String>> data, String existingValue)
    {
        int columnCount = data.get(0).size();
        String columnData = "";
        for (int i = 0; i < columnCount; i++) {
            if(data.get(0).get(i).equals(field))
                columnData = data.get(1).get(i);
        }
        if(columnData.equals(""))
            return existingValue;
        else
            return columnData;
    }
}
