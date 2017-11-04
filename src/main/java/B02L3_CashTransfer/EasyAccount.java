package B02L3_CashTransfer;

import java.time.LocalTime;

public class EasyAccount {
    static private int id=1000;
    private int accountId;
    int accountBalance;

    {
        accountId = id;
        id++;
    }


    public EasyAccount() {

        this.accountBalance = 0;
    }

    public EasyAccount(int money) {

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
        System.out.println();
    }

    public static void printEasyAccount(EasyAccount[] accounts) {
        for (int j = 0; j < accounts.length; j++) {
            System.out.println("Account whith ID: " + accounts[j].getAccountId() +
                    " has " + accounts[j].getAccountBalance() + " USD");
        }
        System.out.println();
    }


    public static boolean transfer01(EasyAccount[] accounts, int[] cash) throws Throwable{

        boolean result = true;
        int brIndex = -1;

        for (int i = 0; i < accounts.length; i++) {
            try {
                attemptForvard(accounts[i], cash[i]);
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

    private static void attemptForvard(EasyAccount e, int cash) throws ZedDeadBabyExtension , InterruptedException {
        try {
            System.out.println(e.getAccountId() + " one more attempt.");
            e.changeForward(cash);
        } catch (TryAgainException retry) {
            //Thread.sleep(1);
            attemptForvard(e, cash);

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

    public void changeForward(int sumAdd) throws TryAgainException, ZedDeadBabyExtension {
        LocalTime t = LocalTime.now();
        int ns = (t.getNano() / 1000000) % 10;

        if (ns < 4) {
            this.accountBalance +=sumAdd;

        } else {
            if (ns < 8) {
                throw new TryAgainException();
            } else {
                throw new ZedDeadBabyExtension();
            }
        }

    }

    public void changeBack(int sumAdd) throws TryAgainException {
        LocalTime t = LocalTime.now();
        int ns = (t.getNano() / 1000000) % 10;

        if (ns < 1) {
            this.accountBalance = this.accountBalance + sumAdd;
        } else {
            throw new TryAgainException();
        }

    }

//    public static boolean transfer(EasyAccount[] accounts, int[] cash) {
//
//        boolean result = true;
//        for (int i = 0; i < accounts.length; i++) {
//            attemptBack(accounts[i], cash[i]);
//        }
//        return result;
//    }

//    public static boolean transfer0(EasyAccount[] accounts, int[] cash) {
//
//        boolean result = true;
//
//        for (int i = 0; i < accounts.length; i++) {
//            try {
//                attemptForvard(accounts[i], cash[i]);
//            } catch (ZedDeadBabyExtension e) {
//                System.out.println("Operation failed for account number " + i);
//                result = false;
//                break;
//            }
//            System.out.println("Success!");
//        }
//        return result;
//    }


}




