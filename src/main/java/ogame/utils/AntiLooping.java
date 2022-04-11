package ogame.utils;

import java.io.Serializable;

public class AntiLooping implements Serializable {

    private static final long serialVersionUID = 1992L;
    private int executeCount = 0;
    private  final int maxExecuteCount;

    public AntiLooping(int maxExecute) {
        this.maxExecuteCount = maxExecute;
    }

    public void reset(){
        executeCount = 0;
    }

    private void count(){
        executeCount++;
    }

    /**
     * Checks if executeCount is greater tha maxExecute;
     * @return If is greater returns true;
     */
    private boolean isExecuteHigherThanMaxExecute(){
        return executeCount > maxExecuteCount;
    }

    /**
     * Checks if executeCount is greater tha maxExecute;
     * @return If is greater returns true;
     */
    public boolean check(){
        count();
        return isExecuteHigherThanMaxExecute();
    }

}
