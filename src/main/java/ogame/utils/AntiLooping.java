package ogame.utils;

public class AntiLooping {

    private int executeCount = 0;
    private  final int maxExecuteCount;

    public AntiLooping(int maxExecute) {
        this.maxExecuteCount = maxExecute;
    }

    public void reset(){
        executeCount = 0;
    }

    public void count(){
        executeCount++;
    }

    /**
     * Checks if executeCount is greater tha maxExecute;
     * @return If is greater returns true;
     */
    public boolean isExecuteHigherThanMaxExecute(){
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
