package org.fundacionjala.diplomadoqa.guiautomation;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * User: ubaldo villaseca
 * Date: 1/18/2019
 */
public class ReTry {
    public static void doReTry(Supplier<Object> toReTry) {
        int interval = 1000;
        int timeout = 10;
        int tryCount = 0;
        boolean hasExceptionBeenThrown;
        do {
            try {
                toReTry.get();
                hasExceptionBeenThrown = false;
            } catch (Exception e) {
                hasExceptionBeenThrown = true;
                tryCount++;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        } while (hasExceptionBeenThrown && tryCount <= timeout);
    }
}
