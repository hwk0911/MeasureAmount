package Calculator;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private List<List<String>> exportDatas;
    private HashMap<String, HashMap<String, Integer>> processDatas;
    //private Integer sumTotal;

    public Calculator(List<List<String>> exportDatas) {
        this.exportDatas = exportDatas;
        this.processDatas = new HashMap<>();
        setProcessData();
    }

    public void setProcessData() {
        List<String> exportData;
        HashMap<String, Integer> processData;

        int index = 0;

        for (int size = exportDatas.size(); index < size; ++index) {
            exportData = exportDatas.get(index);

            if(exportData.get(0).equals("상품명")){
                continue;
            }
            if(this.processDatas.containsKey(exportData.get(0))) {
                processData = this.processDatas.get(exportData.get(0));
            }
            else{
                processData = new HashMap<>();
            }

            for (int column = 1, columnSize = exportData.size(); column < columnSize; ++column) {
                if(exportData.get(2).equals("수량")){
                    continue;
                }

                Double amount = Double.parseDouble(exportData.get(2));
                String[] color = exportData.get(1).split("/");

                for (int colorNum = 0, maxColorNum = color.length; colorNum < maxColorNum; ++colorNum) {
                    Integer tempAmount;
                    String option = color[colorNum];

                    if (processData.containsKey(option)) {
                        tempAmount = processData.get(option) + amount.intValue();
                    } else {
                        tempAmount = amount.intValue();
                    }

                    processData.put(option, tempAmount);
                }
            }

            this.processDatas.put(exportData.get(0), processData);
        }
    }

    public HashMap<String, HashMap<String, Integer>> getProcessDatas() {
        return this.processDatas;
    }
}
