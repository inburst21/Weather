package iskills.com.weather.utils.rx;

import rx.Scheduler;

/**
 * lennyhicks
 * 2/28/18
 */

public interface RxSchedulers {

    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();

}