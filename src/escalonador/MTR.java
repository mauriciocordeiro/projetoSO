package escalonador;

/**
 *
 * @author Mauricio
 */
public class MTR extends Thread {
    
    private final long TIMESLICE = 2000;
    private Queue readyQueue;
    private Queue blockedQueue;
    
    public MTR() {
        this.setPriority(MAX_PRIORITY);
        readyQueue = new Queue();
        blockedQueue = new Queue();
    }
    
    public void enqueueReadyProcess(Process p) {
        readyQueue.add(p);
    }
    
    @Override
    public void run() {      
        
    }
}
