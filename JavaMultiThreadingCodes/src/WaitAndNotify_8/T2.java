package WaitAndNotify_8;

public class T2 implements Runnable{
    public Processor p;

    public T2(Processor p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            this.p.consume();
        } catch (InterruptedException ignored) {}
    }
}
