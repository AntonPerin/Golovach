package B02L3_CashTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

class XEasyAccount implements EasyAccount {
    private final Random rnd;
    private final AtomicBoolean zedDead;
    private int totalChange = 0;
    private List<Integer> history = new ArrayList<Integer>();
    private boolean imDead = false;

    XEasyAccount(Random rnd, AtomicBoolean zedDead) {
        this.rnd = rnd;
        this.zedDead = zedDead;

    }

    @Override
    public void change(int delta) throws TryAgainException, ZedDeadBabyExtension {
        if (imDead) {
            throw new ZedDeadBabyExtension("This account totally dead!");
        }
        int r = rnd.nextInt(100);
        if(r==0&&!zedDead.get()){
            zedDead.set(true);
            throw new ZedDeadBabyExtension("First time!");
        }else if (r<50){
            throw new TryAgainException();
        }else{
            totalChange+=delta;
            history.add(delta);
        }
    }
    int getTotalChange(){
        return  totalChange;
    }
}