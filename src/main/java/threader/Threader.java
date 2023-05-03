package threader;

import threader.thread.ThreadedConsumer;

public interface Threader {

    void start();

    void addConsumer(ThreadedConsumer parallelThread);

    void removeConsumer(ThreadedConsumer threadedConsumer);

    CountLatch getCountLatch();

}
