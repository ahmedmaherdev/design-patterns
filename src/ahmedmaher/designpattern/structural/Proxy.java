package ahmedmaher.designpattern.structural;

public class Proxy {

    public static void main(String[] args) {
        IBankAccount protectionProxy = new ProtectionProxy("password", 1000);

        protectionProxy.withdraw(100);
        protectionProxy.withdraw(500);
        protectionProxy.withdraw(1000);

        System.out.println("Current balance: " + protectionProxy.getBalance());
    }
}


// Subject
interface IBankAccount {
    void withdraw(int amount);
    int getBalance();
}

// Real Subject
class BankAccount implements IBankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

// Proxy
class ProtectionProxy implements IBankAccount {
    private final IBankAccount bankAccount;
    private final String password;

    public ProtectionProxy(String password , int balance) {
        this.bankAccount = new BankAccount(balance);
        this.password = password;
    }

    @Override
    public void withdraw(int amount) {
        if(authenticate()) {
            bankAccount.withdraw(amount);
        }else {
            System.out.println("Unauthorized access. Withdrawal failed.");
        }
    }

    @Override
    public int getBalance() {
        if(authenticate()) {
            return bankAccount.getBalance();
        }else {
            System.out.println("Unauthorized access. Balance retrieval failed.");
        }
        return 0;
    }

    private boolean authenticate() {
        String thePassword = "password";
        return thePassword.equals(password);
    }
}