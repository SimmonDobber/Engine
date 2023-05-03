package threader;

import java.util.ArrayList;
import java.util.List;

import display.DisplayBean;
import input.InputBean;
import lombok.Getter;
import scene.SceneBean;
import threader.thread.ThreadedConsumer;

public class ThreaderBean implements Threader {

    private static Threader threader;

    private final List<ThreadedConsumer> threadedConsumers;
    @Getter
    private final CountLatch countLatch;
    private boolean running;

    private ThreaderBean() {
        this.threadedConsumers = new ArrayList<>();
        this.countLatch = new CountLatch();
        this.running = false;
    }

    public static Threader getThreader() {
        if (threader == null) {
            threader = new ThreaderBean();
        }
        return threader;
    }

    public void start() {
        this.running = true;
        initializeListeners();
        listen();
    }

    @Override
    public void addConsumer(ThreadedConsumer threadedConsumer) {
        this.threadedConsumers.add(threadedConsumer);
    }

    @Override
    public void removeConsumer(ThreadedConsumer threadedConsumer) {
        this.threadedConsumers.remove(threadedConsumer);
    }

    private void initializeListeners() {
        InputBean.getInput().initializeInputListener();
        SceneBean.getScene().initializeListeners();
        DisplayBean.getDisplay().draw();
    }

    private synchronized void listen() {
        while (this.running) {
            this.threadedConsumers.forEach(ThreadedConsumer::consume);
            this.countLatch.await();
        }
    }

}
