package WaitAndNotify_8;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final Account account = new Account("thang", 1000.0, "des");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.withDrawMoney();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    account.consume();
                } catch (InterruptedException ignored) {}
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        try {
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
        System.out.println(account);

    }
}
