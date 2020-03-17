package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Loading {
    Main(String imgRoute) {
        super(imgRoute);


    }

    public static void main(String[] args) throws Exception {
        //String imgRoute = "\\resource\\Scheme\\load.png";
        String imgRoute = "resource\\Scheme\\load.png";

        Main loading = new Main(imgRoute);
        loading.showLoading();


        loading.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
