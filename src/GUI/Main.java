package GUI;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static LoadingContainer loadingContainer;
    static MainContainer mainContainer;

    public static void main(String[] args) throws Exception {
        String imgRoute = "resource\\Scheme\\load.png";

        startLoadingContainer(imgRoute);
    }

    public static void startLoadingContainer(String imgRoute) {
        loadingContainer = new LoadingContainer(imgRoute);
        loadingContainer.setVisible(true);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                endLoadingContainer();
                startMainContainer();
            }
        };

        timer.schedule(timerTask, 2000);
    }

    public static void endLoadingContainer() {
        loadingContainer.dispose();
        loadingContainer = null;
    }

    public static void startMainContainer() {
        mainContainer = new MainContainer("resource\\icon\\비앤드지투.ico");
        mainContainer.setVisible(true);
        mainContainer.setDefaultCloseOperation(mainContainer.EXIT_ON_CLOSE);

    }
}
