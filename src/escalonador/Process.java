package escalonador;


/**
 *
 * @author Mauricio
 */
public class Process extends Thread {
    
    public static final int READY = 0;
    public static final int RUNNING = 1;
    public static final int BLOCKED = 2;
    public static final int FINALIZED = 3;
    
    protected long deadline;
    private long arrive;
    
    public long start;
    public long stop;
    public long runtime;
    
    protected int state;
    
    private int count;

    public Process() {
    }

    public Process(long deadline) {
        this.deadline = deadline;
        this.state = READY;
        count = new Long(deadline/1000).intValue();
        this.setPriority(MIN_PRIORITY);
    } 

    public Process(long deadline, long arrive) {
        this.deadline = deadline;
        this.arrive = arrive;
        this.state = READY;
        count = new Long(deadline/1000).intValue();
        this.setPriority(MIN_PRIORITY);
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }
    
    public String getNameState(int state) {
        switch(state) {
            case READY:
                return "Ready";
            case RUNNING:
                return "Running";
            case BLOCKED:
                return "Blocked";
            case FINALIZED:
                return "Finalized";
            default:
                return "";
        }
    }
    
    @Override
    public void run() {
        do {
            System.out.println("["+ this.getId()+"] counting "+count--);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        } while(count>0);
        this.stop();
    }
}
