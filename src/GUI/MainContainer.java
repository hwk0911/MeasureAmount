package GUI;

import javax.swing.*;
import java.awt.*;

public class MainContainer extends JFrame {
    Color color;
    Font font;

    MainContainer() {
        super("비앤드지투 발주 도우미 2.0.0.0");
        this.setUndecorated(false);
        this.color = new Color(71, 68,68);

        setContainer();
    }

    private void setContainer () {
        this.setLocation(getPoint().x - 480, getPoint().y - 405);
        this.setSize(960, 810);
        this.setResizable(false);
        //this.setFont();

        this.add(setJPanel());
    }

/*
    private void setFont () {
        //todo : 후에 폰트 수정하여 추가할 것
        //this.font = new Font().
    }
*/
    private JPanel setJPanel () {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(this.color);
        jPanel.setLayout(null);

        jPanel.add(setExportButton()).setLocation(0,725);
        jPanel.add(setPrevButton()).setLocation(700,725);
        jPanel.add(setNextButton()).setLocation(830,725);
        jPanel.add(setFileName()).setSize(960, 50);
        jPanel.add(setDataField()).setLocation(0, 50);

        return jPanel;
    }

    private Point getPoint () {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Point point = new Point();
        point.x = screenSize.width / 2;
        point.y = screenSize.height / 2;

        return point;
    }

    private JButton setExportButton () {
        JButton jButton = new JButton("EXPORT");
        jButton.setSize(700, 50);


        return jButton;
    }

    private JButton setPrevButton() {
        //TODO : 버튼 이미지로 변경할 것
        JButton jButton = new JButton("<");
        jButton.setSize(130, 50);


        return jButton;
    }

    private JButton setNextButton () {
        //TODO : 버튼 이미지로 변경할 것
        JButton jButton = new JButton(">");
        jButton.setSize(130, 50);


        return jButton;
    }

    private JTextField setFileName () {
        JTextField jTextField = new JTextField("FILE NAME TEST");
        jTextField.setEditable(false);
        jTextField.setHorizontalAlignment(JTextField.CENTER);

        return jTextField;
    }

    private JScrollPane setDataField () {

        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(true);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setSize(955, 675);

        return jScrollPane;
    }
}
