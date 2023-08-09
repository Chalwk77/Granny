package com.chalwk.util;

import java.util.Timer;
import java.util.TimerTask;

public class NewTimer extends TimerTask {

    /**
     * @param delay The delay in seconds.
     * This method will initialize a timer that will execute the run() method every delay seconds.
     */
    public void initTimer(int delay) {
        Timer timer = new Timer();
        timer.schedule(this,  0, delay * 1000L);
    }

    @Override
    public void run() {


    }
}
