package GUI;

import Calculator.Calculator;
import SaveText.SaveText;
import XLSXController.XLSXController;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainContainer extends JFrame {
    Color color;
    dropTarget filedrop;
    String iconPath;

    MainContainer(String iconPath) {
        super("비앤드지투 발주 도우미 2.0.0.0");
        this.setUndecorated(false);
        this.color = new Color(71, 68,68);
        this.filedrop = new dropTarget();
        this.iconPath = iconPath;

        setContainer();
    }

    private void setContainer () {
        this.setLocation(getPoint().x - 480, getPoint().y - 405);
        this.setSize(960, 810);
        this.setResizable(false);

        //todo : add imageIcon
        this.setIconImage(new ImageIcon(iconPath).getImage());

        this.add(setJPanel());
    }

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
        jButton.setBackground(new Color(71, 68,68));
        jButton.setForeground(Color.white);
        jButton.setFont(new Font("돋움", Font.BOLD, 20));


        return jButton;
    }

    private JButton setPrevButton() {
        //TODO : 버튼 이미지로 변경할 것
        JButton jButton = new JButton("<");
        jButton.setSize(130, 50);
        jButton.setBackground(new Color(71, 68,68));
        jButton.setForeground(Color.white);
        jButton.setFont(new Font("돋움", Font.BOLD, 20));


        return jButton;
    }

    private JButton setNextButton () {
        //TODO : 버튼 이미지로 변경할 것
        JButton jButton = new JButton(">");
        jButton.setSize(130, 50);
        jButton.setBackground(new Color(71, 68,68));
        jButton.setForeground(Color.white);
        jButton.setFont(new Font("돋움", Font.BOLD, 20));


        return jButton;
    }

    private JTextField setFileName () {
        JTextField jTextField = new JTextField("FILE NAME TEST");
        jTextField.setEditable(false);

        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setForeground(Color.white);
        jTextField.setBackground(new Color(71, 68,68));
        jTextField.setFont(new Font("돋움", 1, 20));



        return jTextField;
    }

    private JScrollPane setDataField () {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(true);
        jTextArea.setFont(new Font("돋움", Font.PLAIN, 20));
        jTextArea.setForeground(Color.WHITE);
        jTextArea.setBackground(new Color(71, 68,68));
        jTextArea.setDropTarget(this.filedrop);



        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setSize(955, 675);



        return jScrollPane;
    }
}
class dropTarget extends DropTarget {
    private List<File> temp;
    private List<String> filesPath;

    dropTarget () {
        filesPath = new ArrayList<>();
    }

    public synchronized void drop (DropTargetDropEvent evt) {
        try {
            evt.acceptDrop(DnDConstants.ACTION_COPY);
            this.temp = (List<File>)
                    evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);

            for(int index = 0, size = temp.size() ; index < size ; ++index) {
                System.out.println(temp.get(index).getPath());
                filesPath.add(temp.get(index).getPath());
            }

            XLSXController xlsxController = new XLSXController(filesPath);
            Calculator calculator = new Calculator(xlsxController.getEndExport());
            SaveText saveText = new SaveText(calculator.getProcessDatas());

            openFile(saveText.getDataFile());

            filesPath = new ArrayList<>();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFile (File file) {
        try {
            Desktop.getDesktop().edit(file);
            Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\log"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}