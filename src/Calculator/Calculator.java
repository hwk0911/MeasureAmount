package Calculator;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
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
        HashMap<String, Integer> processData;

        for(List<String> exportData : this.exportDatas) {
            if(exportData.get(0).equals("상품명")){
                continue;
            }
            else if(exportData.get(1).equals("옵션 정보")) {
                continue;
            }
            else if(exportData.get(2).equals("수량")) {
                continue;
            }

            if(this.processDatas.containsKey(exportData.get(0))){
                processData = this.processDatas.get(exportData.get(0));
            }
            else{
                processData = new HashMap<>();
            }

            String[] colors = exportData.get(1).split("/");
            Double tempAmount = Double.parseDouble(exportData.get(2));
            Integer amount = tempAmount.intValue();

            System.out.println(amount);

            for(String color : colors) {
                if(color.toUpperCase().equals("FREE")) {
                    continue;
                }
                else if(color.equals("1개만구매")) {
                    continue;
                }

                if(processData.containsKey(color)) {
                    processData.put(color, processData.get(color) + amount);
                }
                else {
                    processData.put(color, amount);
                }
            }

            processDatas.put(exportData.get(0), processData);
        }

        this.check();
    }

    public HashMap<String, HashMap<String, Integer>> getProcessDatas() {
        return this.processDatas;
    }

    public void check () {
        Iterator<String> itr = this.processDatas.keySet().iterator();
        HashMap<String, Integer> map;

        while(itr.hasNext()) {
            String bigKey = itr.next();

            System.out.println(bigKey);

            map = this.processDatas.get(bigKey);
            Iterator<String> sItr = map.keySet().iterator();

            while(sItr.hasNext()) {
                String sKey = sItr.next();
                System.out.println(sKey + "\t" + map.get(sKey));
            }
        }
    }
}
