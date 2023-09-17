package org.yanmachine.infection.infectionGameUtility;

public class TimeRecorder {

    private static long startTime;
    private static boolean isRunning;

    public TimeRecorder() {
        this.isRunning = false;
    }

    // start time
    public static void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    // end time
    public static void stop() {
        if (isRunning) {
            isRunning = false;
        }
    }

    // get elapsed time in seconds
    public static long getElapsedTimeSeconds() {
        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            return (currentTime - startTime) / 1000;
        } else {
            return 0;
        }
    }

}
