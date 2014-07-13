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
    
    private long deadline;
    private long arrive;
    protected int state;
    
    private int count;

    public Process() {
    }

    public Process(long deadline) {
        this.deadline = deadline;
        this.state = READY;
        count = new Long(deadline/1000).intValue();
    } 

    public Process(long deadline, long arrive) {
        this.deadline = deadline;
        this.arrive = arrive;
        this.state = READY;
        count = new Long(deadline/1000).intValue();
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
        while(deadline>0) {
            System.out.println("["+ this.getId()+"] counting "+count--);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
