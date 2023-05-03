package main;

import threader.ThreaderBean;

public class Engine {

    private static Engine engine;

    public void initializeEngine() {
        new BeanConfig().buildBeans();
    }

    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
        return engine;
    }

    public void start() {
        ThreaderBean.getThreader().start();
    }

    private Engine() {
    }

    public static void main(String[] args) {
        new Engine().initializeEngine();
    }

}
