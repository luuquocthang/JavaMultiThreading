package WaitAndNotify_8;

public class T3 implements Runnable{
    public Processor p;

    public T3(Processor p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            this.p.produce("T3");
        } catch (InterruptedException ignored) {}
    }
}
