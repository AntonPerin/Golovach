package B02L3_CashTransfer;

import static B02L3_CashTransfer.EasyAccount.printEasyAccount;

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

        EasyAccount[] bankAccounts = new EasyAccount[num];
        int[] cash = new int[num];
        cash[0]=50;
        for (int i =0;i<bankAccounts.length;i++){
            bankAccounts[i]=new EasyAccount();
            cash[i]=cash[0]+i*100;
        }

//        EasyAccount a = new EasyAccount(100);
//        EasyAccount b = new EasyAccount(0);
//        EasyAccount c = new EasyAccount(0);
//        EasyAccount d = new EasyAccount(400);
//        EasyAccount a1 = new EasyAccount(500);
//        EasyAccount b1 = new EasyAccount(600);
//        EasyAccount c1 = new EasyAccount(700);
//        EasyAccount d1 = new EasyAccount(800);
//        EasyAccount[] bankAccounts = {a, b, c};//, d,a1,b1,c1,d1};
//        int[] cash={-100,70,30};//,300,400,500,600,700};

        printEasyAccount(bankAccounts);

        boolean tRes= B02L3_CashTransfer.EasyAccount.transfer01(bankAccounts,cash);
        System.out.println("All transactions are "+tRes+"!");
        System.out.println();

        printEasyAccount(bankAccounts);
    }
}
