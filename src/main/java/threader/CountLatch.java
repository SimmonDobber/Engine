package threader;

import java.util.concurrent.CountDownLatch;

public class CountLatch {

    private CountDownLatch countDownLatch;

    public CountLatch() {
        this.countDownLatch = new CountDownLatch(1);
    }

    public void await() {
        try {
            this.countDownLatch.await();
            countUp();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void countDown() {
        this.countDownLatch.countDown();
    }

    public void countUp() {
        this.countDownLatch = new CountDownLatch((int) (this.countDownLatch.getCount() + 1));
    }

}
