package GUI;

import javax.swing.*;
import java.awt.*;

public class LoadingContainer extends JFrame {
    String imgRoute;
    ImageIcon loadingImg;

    Integer width;
    Integer height;

    LoadingContainer(String imgRoute) {
        this.imgRoute = imgRoute;
        setImageIcon();

        this.width = loadingImg.getIconWidth();
        this.height = loadingImg.getIconHeight();

        setContainer();
    }

    private void setContainer () {
        this.setUndecorated(true);
        this.setLocation(getPoint().x - width / 2, getPoint().y - height / 2);
        this.setSize(width, height);
        this.add(setJLabel());
        this.setResizable(false);
    }

    private JLabel setJLabel () {
        JLabel jLabel = new JLabel(loadingImg);

        return jLabel;
    }

    private void setImageIcon () {
        this.loadingImg = new ImageIcon(imgRoute);
    }

    private Point getPoint () {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Point point = new Point();
        point.x = screenSize.width / 2;
        point.y = screenSize.height / 2;

        return point;
    }
}
