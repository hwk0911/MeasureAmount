package GUI;

import ReadExcell.ReadExcell;
import SaveText.SaveText;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.util.HashMap;

public class GUI extends JFrame {
    HashMap<String, HashMap<String, Double>> dataMap;


    private static String defaultRoute = "";

    public GUI() throws Exception{
        super("비앤드지투 발주 도우미");

        setDefaultRoute();
        searcherButton();





        setBounds(960,200,522,200);
        setVisible(true);
    }

    public void setDefaultRoute () throws Exception{
        defaultRoute = System.getProperty("user.home") + "\\Downloads";
        System.out.println(defaultRoute);
    }

    /*
    파일 탐색기 열기
    기본 경로 : Download
    지원 확장자 : xlsx
    return : 기본경로 + 파일명 + 파일 확장자
     */
    public String searcher () {
        File fileName;

        String route = "";

        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(defaultRoute));
        jfc.setFileFilter(new FileNameExtensionFilter("office 엑셀 - xlsx", "xlsx"));

        int returnVal = jfc.showOpenDialog(null);

        if(returnVal == 0) {
            System.out.println("파일 열기를 선택");

            File file = jfc.getSelectedFile();

            route = defaultRoute + "\\" +file.getName();
            System.out.println(route);
        }

        else{
            System.out.println("파일 열기를 취소");
        }

        return route;
    }


    //파일 탐색기 버튼
    public void searcherButton () {
        HashMap<String, HashMap<String, Double>> dataMap;

        //this.setLayout(new FlowLayout());

        JButton openSearcher = new JButton("파일 선택");
        openSearcher.setBounds(30,170,400,100);

        openSearcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReadExcell readExcell = new ReadExcell(searcher());
                    HashMap<String, HashMap<String, Double>> dataMap = readExcell.getData();

                    SaveText saveText = new SaveText(dataMap, defaultRoute);
                    saveText.makeFile();

                    System.out.println(saveText.retRoute());

                    Desktop.getDesktop().edit(new File(saveText.retRoute()));

                    //메모장 텍스트 에어리어 출력 작성하기.
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });




        this.getContentPane().add(openSearcher);
    }

    public static void main(String[] args) throws Exception{
        GUI gt = new GUI();
        gt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
