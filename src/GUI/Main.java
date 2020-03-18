package GUI;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static LoadingContainer loadingContainer;

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

    public static void startMainContainer () {
        MainContainer mainContainer = new MainContainer();
        mainContainer.setVisible(true);
        mainContainer.setDefaultCloseOperation(mainContainer.EXIT_ON_CLOSE);
    }
}
