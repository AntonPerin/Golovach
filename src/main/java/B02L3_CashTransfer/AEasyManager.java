//package B02L3_CashTransfer;
//
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicBoolean;
//
///* Class that creates accounts with account balance field and unique account id*/
//
//public class AEasyManager extends  XEasyAccount implements EasyManager {
//
//    AEasyManager(Random rnd, AtomicBoolean zedDead) {
//        super(rnd, zedDead);
//    }
//
//    @Override
//    public boolean transfer(EasyAccount[] accounts, int[] cash) {
//        boolean result = true;
//        int brIndex = -1;
//
//        for (int i = 0; i < accounts.length; i++) {
//            try {
//
//                attempt(accounts[i], cash[i]);
//
//            } catch (ZedDeadBabyExtension e) {
//                System.out.println("Operation failed for account number " + i);
//                result = false;
//                brIndex = i;
//                //printEasyAccount(accounts);
//                break;
//            }
//            System.out.println("Success!");
//        }
//        if (brIndex > 0) {
//            for (int i = (brIndex - 1); i >= 0; i--) {
//
//                attempt(accounts[i], cash[i]);
//
//                System.out.println("Transaction " + i + " is denied!");
//            }
//        }
//        return result;
//    }
//
//    private boolean attempt(EasyAccount account, int cash) throws ZedDeadBabyExtension {
//        try {
//            account.change(cash);
//        } catch (TryAgainException retry) {
//            attempt(account, cash);
//        }
//        return false;
//    }
//
//}
