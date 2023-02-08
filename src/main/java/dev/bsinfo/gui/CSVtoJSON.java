package dev.bsinfo.gui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CSVtoJSON {
    public static JSONArray convert(String filePath) {
        JSONArray result = new JSONArray();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> headers = new ArrayList<>();
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (isHeader) {
                    for (String value : values) {
                        headers.add(value);
                    }
                    isHeader = false;
                } else {
                    JSONObject obj = new JSONObject();
                    for (int i = 0; i < headers.size(); i++) {
                        obj.put(headers.get(i), values[i]);
                    }
                    result.put(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

