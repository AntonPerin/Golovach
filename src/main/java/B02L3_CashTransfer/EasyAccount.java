package B02L3_CashTransfer;

import java.time.LocalTime;
import java.util.Random;

/* Class that creates accounts with account balance field and unique account id*/

public class EasyAccount {
    private static int id = 1000;
    private int accountId;
    private int accountBalance;

    {
        accountId = id;
        id++;
    }

    public EasyAccount() {

        this.accountBalance = 0;
    }

    EasyAccount(int money) {

        this.accountBalance = money;
    }

    public int getAccountBalance() {

        return accountBalance;
    }

    public int getAccountId() {

        return accountId;
    }

    public void setAccountBalance(int money) {

        this.accountBalance = money;
    }

    public static void printEasyAccount(EasyAccount account) {
        System.out.println("Account whith ID: " + account.getAccountId() +
                " has " + account.getAccountBalance() + " USD");
    }

    public static void printEasyAccount(EasyAccount[] accounts) {
        for (EasyAccount e: accounts) {
            System.out.println("Account whith ID: " + e.getAccountId() +
                    " has " + e.getAccountBalance() + " USD");
        }
        System.out.println();
    }


    public static boolean transfer01(EasyAccount[] accounts, int[] cash) throws Throwable {
        boolean result = true;
        int brIndex = -1;

        for (int i = 0; i < accounts.length; i++) {
            try {
                attemptForward(accounts[i], cash[i]);
            } catch (ZedDeadBabyExtension e) {
                System.out.println("Operation failed for account number " + i);
                result = false;
                brIndex = i;
                printEasyAccount(accounts);
                break;
            }
            System.out.println("Success!");
        }
        if (brIndex > 0) {
            for (int i = (brIndex - 1); i >= 0; i--) {
                attemptBack(accounts[i], (-cash[i]));
                System.out.println("Transaction " + i + " is denied!");
            }
        }
        return result;
    }

    private static void attemptForward(EasyAccount e, int cash) throws ZedDeadBabyExtension, InterruptedException {
        try {
            System.out.println(e.getAccountId() + " one more attempt.");
            e.changeForward(cash);
        } catch (TryAgainException retry) {
            attemptForward(e, cash);
        }
    }

    private static void attemptBack(EasyAccount e, int cash) {
        try {
            System.out.println(e.getAccountId() + " one more attempt to deny transaction ");
            e.changeBack(cash);
        } catch (Exception retry) {
            attemptBack(e, cash);
        }
    }

    private void changeForward(int sumAdd) throws TryAgainException, ZedDeadBabyExtension {
        int maxNs = 15;
        Random nsr = new Random();
        int ns = nsr.nextInt(maxNs);

        if (ns < 5) {
            this.accountBalance += sumAdd;

        } else {
            if (ns < 14) {
                throw new TryAgainException();
            } else {
                throw new ZedDeadBabyExtension();
            }
        }

    }

    private void changeBack(int sumAdd) throws TryAgainException {
        int maxNs = 10;
        Random nsr = new Random();
        int ns = nsr.nextInt(maxNs);

        if (ns < 3) {
            this.accountBalance = this.accountBalance + sumAdd;
        } else {
            throw new TryAgainException();
        }
    }
}




