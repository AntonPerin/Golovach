package B02L3_CashTransfer;

import static B02L3_CashTransfer.AEasyAccount.printEasyAccount;

/*Program that tests method transfer01.
Method trying to make set of transactions to given EasyAccounts.
It may be three variants:
1. Transaction success - then trying to make next transaction;
2. Transaction error(TryAgain) - then trying to do this transaction again;
3. Transaction error(Can't make transaction) - then method have to discard all transactions made before.*/

public class ProgramSetOfTransactions {
    public static void main(String[] args) throws Throwable {
        int num =15; //Number of accounts that will be created and placed to array bankAccounts
                    //And number of cash transactions

        AEasyAccount[] bankAccounts = new AEasyAccount[num];
        int[] cash = new int[num];
        cash[0]=50;
        for (int i =0;i<bankAccounts.length;i++){
            bankAccounts[i]=new AEasyAccount();
            cash[i]=cash[0]+i*100;
        }

//        AEasyAccount a = new AEasyAccount(100);
//        AEasyAccount b = new AEasyAccount(0);
//        AEasyAccount c = new AEasyAccount(0);
//        AEasyAccount d = new AEasyAccount(400);
//        AEasyAccount a1 = new AEasyAccount(500);
//        AEasyAccount b1 = new AEasyAccount(600);
//        AEasyAccount c1 = new AEasyAccount(700);
//        AEasyAccount d1 = new AEasyAccount(800);
//        AEasyAccount[] bankAccounts = {a, b, c};//, d,a1,b1,c1,d1};
//        int[] cash={-100,70,30};//,300,400,500,600,700};

        printEasyAccount(bankAccounts);

        boolean tRes= AEasyAccount.transfer01(bankAccounts,cash);
        System.out.println("All transactions are "+tRes+"!");
        System.out.println();

        printEasyAccount(bankAccounts);
    }
}
