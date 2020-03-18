package GUI;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public abstract class GUI extends JFrame{
    JFrame jFrame;
    ImageIcon loadingImg;

    String imgRoute;


    GUI (String imgRoute) {
        this.imgRoute = imgRoute;
        setLoadingImg();
    }

    public void showLoading() {
        jFrame.setVisible(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                jFrame.dispose();
                jFrame = null;
                try {
                    setMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        timer.schedule(timerTask, 2000);
    }

    public void setLoadingImg () {
        loadingImg = new ImageIcon(imgRoute);

        Integer loading_x = loadingImg.getIconWidth();
        Integer loading_y = loadingImg.getIconHeight();

        jFrame = new JFrame();

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        JLabel jLabel = new JLabel(loadingImg);

        jFrame.setLocation(size.width / 2 - loading_x / 2, size.height / 2 - loading_y / 2);
        jFrame.setUndecorated(true);
        jFrame.setSize(loading_x, loading_y);
        jFrame.add(jLabel);
        jFrame.setResizable(false);

        //jLabel.add
    }

    public void setMain () throws Exception{
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\hwk09\\Downloads\\data.txt")));

        Double width = size.width * 0.5;
        Double height = size.height * 0.75;



        jFrame = new JFrame();
        jFrame.setLocation(size.width / 2 - width.intValue() / 2, size.height / 2 - height.intValue() / 2);
        jFrame.setSize(width.intValue(), height.intValue());

        File file = new File("C:\\Users\\hwk09\\Downloads\\data.txt");

        JTextArea jTextArea = new JTextArea(200, 200);

        String readLine = "";
        while((readLine = br.readLine()) != null){
            jTextArea.append(readLine + "\n");
        }

        JLabel jLabel = new JLabel(jTextArea.getText());

        jFrame.add(jLabel);
        showMain();
    }

    public void showMain () {
        jFrame.setVisible(true);
    }

}
