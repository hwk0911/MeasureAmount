package SaveText;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;

public class SaveText {
    private String route;
    private HashMap<String, HashMap<String, Double>> dataMap;

    public SaveText (HashMap<String, HashMap<String, Double>> dataMap, String route) {
        this.dataMap = dataMap;
        this.route = route;
    }

    public String retRoute () {
        return this.route;
    }

    public void makeFile () throws Exception{
        File file = new File(route + "\\data.txt");
        file.delete();

        file = new File(route + "\\data.txt");

        this.route += "\\data.txt";
        FileWriter fileWriter = new FileWriter(file, true);

        HashMap<String, Double> colors;

        Iterator<String> dataItr = dataMap.keySet().iterator();

        while(dataItr.hasNext()) {
            String key = dataItr.next();
            Iterator<String> colorsItr = dataMap.get(key).keySet().iterator();

            //System.out.println("제품명 : " + key);
            fileWriter.write("제품명 : " + key + "\n");

            while(colorsItr.hasNext()) {
                String colorKey = colorsItr.next();
                colors = dataMap.get(key);

                System.out.println(colorKey + " : " + colors.get(colorKey));
                fileWriter.write(colorKey + " : " + colors.get(colorKey).intValue() + "\n");
            }
            fileWriter.write("\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }

    public void endProgram () {
        File file = new File(this.route);
        file.delete();
    }
}
