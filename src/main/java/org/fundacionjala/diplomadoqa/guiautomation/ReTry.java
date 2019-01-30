package org.fundacionjala.diplomadoqa.guiautomation;

import java.util.function.Supplier;

/**
 * User: ubaldo villaseca
 * Date: 1/18/2019
 */
public class ReTry {
    public static void run(Callback toReTry) {
        int interval = 1000;
        int timeout = 5;
        int tryCount = 0;
        while (true) {
            try {
                toReTry.call();
                break;
            } catch (Exception e) {
                tryCount++;
                if (tryCount >= timeout) {
                    throw e;
                } else {
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public static Boolean run(Supplier<Boolean> toReTry) {
        int interval = 1000;
        int timeout = 10;
        int tryCount = 0;
        while (!toReTry.get()) {
            tryCount++;
            if (tryCount >= timeout) {
                return false;
            } else {
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return true;
    }
}
