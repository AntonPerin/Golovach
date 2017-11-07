package B02L3_CashTransfer;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class EasyTest {

    public static void main(String[] args) {
        for (int k = 0; k < 1000000; k++) {
            final Random rnd = new Random(k);
            EasyManager manager = new XEasyManager();
            final AtomicBoolean zedDead = new AtomicBoolean(false);
            XEasyAccount[] accounts = {
                    new XEasyAccount(rnd, zedDead),
                    new XEasyAccount(rnd, zedDead),
                    new XEasyAccount(rnd, zedDead)};
            int[] money = {-1, -1, +2};
            boolean ok = manager.transfer(accounts, money);
            if (ok) {
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getTotalChange() != money[i]) {
                        throw new AssertionError("FAIL commit: " + Arrays.toString(accounts));
                    }
                }
            } else {
                if (!zedDead.get()) {
                    throw new AssertionError("Zed alive but roll back");
                }
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getTotalChange() !=0){
                        throw new AssertionError("FAIL rollback: " + Arrays.toString(accounts));
                    }
                }
            }
        }
        System.out.println("OK!");
    }
}





