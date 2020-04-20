package SaveText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class SaveText {
    private HashMap<String, HashMap<String, Integer>> exportDatas;
    private String savePath;
    String fileName;
    File dataFile;

    public SaveText(HashMap<String, HashMap<String, Integer>> exportDatas) {
        this.exportDatas = exportDatas;
        this.savePath = System.getProperty("user.home") + "\\log";
        this.fileName = setFileName();

        File file = new File(savePath);
        file.mkdir();

        setDataFile();
    }

    private String setFileName () {
        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초");
        Date time = new Date();

        String name = "\\" + format.format(time) + ".txt";

        return name;
    }

    private void setDataFile () {
        this.dataFile = new File(savePath + fileName);

        Iterator<String> keyItr = this.exportDatas.keySet().iterator();
        HashMap<String, Integer> tempMap;

        try {
            FileWriter fw = new FileWriter(dataFile);

            while(keyItr.hasNext()) {
                String key = keyItr.next();
                Integer total = 0;
                tempMap = this.exportDatas.get(key);

                fw.write(key + "\n");

                Iterator<String> tempKeyItr = tempMap.keySet().iterator();

                while(tempKeyItr.hasNext()) {
                    String tempKey = tempKeyItr.next();

                    if(tempKey.toUpperCase().equals("FREE")) {
                        continue;
                    }
                    else if(tempKey.equals("1개만구매")) {
                        continue;
                    }
                    else {
                        fw.write(tempKey + "\t : " + tempMap.get(tempKey) + "\t재고" + "\n");
                        System.out.println(tempMap.get(tempKey) + "수량 테스트");
                        total += tempMap.get(tempKey);
                    }
                }

                fw.write("\nTOTAL\t : " + total + "\n\n");
               // System.out.println(total);
            }

            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getDataFile () {
        return this.dataFile;
    }
}
