package WaitAndNotify_8;

import java.util.Scanner;

public class Account {
    private String name;
    private Double amount;
    private String description;
    private Double amountWithDraw = 0.0;

    public Account(String name, Double amount, String description) {
        this.name = name;
        this.amount = amount;
        this.description = description;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void withDrawMoney() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        synchronized (this) {
            System.out.println("How much money would you like to withdraw?");
            Double money = scanner.nextDouble();
            this.amountWithDraw = money;
            wait();//this.wait() is fine.
            System.out.println("Transaction done.");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("have you received a money from bank(Y/N)");
            String result = scanner.nextLine();
            if (result.equals("Y") || result.equals("y")) {
                this.amount -= amountWithDraw;
                notify();
            }
            this.amountWithDraw = 0.0;
//            Thread.sleep(5000);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", amountWithDraw=" + amountWithDraw +
                '}';
    }
}
