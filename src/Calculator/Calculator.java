package Calculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Calculator {
    public HashMap<String, HashMap<String, Double>> dataManufacture (List<String> datas) {
        System.out.println();

        HashMap<String, Double> colors;
        HashMap<String, HashMap<String, Double>> dataMap = new HashMap<>();

        String[] data;
        String[] color;

        for(int index = 0 , size = datas.size() ; index < size ; ++index) {
            data = datas.get(index).split("KHWKHW");

            for(int i = 0 , s = data.length ; i < s ; ++i) {
                System.out.println(data[i]);
            }

            color = data[1].split("/");

            if(dataMap.containsKey(data[0])) {
                colors = dataMap.get(data[0]);

                for(int index_2 = 0, size_2 = color.length ; index_2 < size_2 ; ++index_2) {
                    if(color[index_2].equals("1개만구매")){
                        continue;
                    }
                    else if(colors.containsKey(color[index_2])) {
                        Double amount = colors.get(color[index_2]);
                        Double order = Double.parseDouble(data[2]);

                        colors.put(color[index_2], amount + order);
                    }
                    else {
                        Double order = Double.parseDouble(data[2]);

                        colors.put(color[index_2], order);
                    }
                }

                dataMap.put(data[0], colors);
            }
            else {
                colors = new HashMap<>();

                for(int index_2 = 0, size_2 = color.length ; index_2 < size_2 ; ++index_2) {
                    if(color[index_2].equals("1개만구매")){
                        continue;
                    }
                    else if(colors.containsKey(color[index_2])) {
                        Double amount = colors.get(color[index_2]);
                        Double order = Double.parseDouble(data[2]);

                        colors.put(color[index_2], amount + order);
                    }
                    else {
                        Double order = Double.parseDouble(data[2]);

                        colors.put(color[index_2], order);
                    }
                }

                dataMap.put(data[0], colors);
            }
        }

        Iterator<String> dataItr = dataMap.keySet().iterator();

        System.out.println();

        while(dataItr.hasNext()) {
            String key = dataItr.next();
            Iterator<String> colorsItr = dataMap.get(key).keySet().iterator();

            System.out.println("제품명 : " + key);

            while(colorsItr.hasNext()) {
                String colorKey = colorsItr.next();
                colors = dataMap.get(key);

                System.out.println(colorKey + " : " + colors.get(colorKey));
            }
        }

        return dataMap;
    }
}
