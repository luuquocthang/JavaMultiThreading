package WaitAndNotify_8;

public class T1 implements Runnable {
    public Processor p;

    public T1(Processor p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            this.p.produce("T1");
        } catch (InterruptedException ignored) {}
    }
}
