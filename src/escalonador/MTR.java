package escalonador;

/**
 *
 * @author Mauricio
 */
public class MTR extends Thread {
    
    private Queue queue;
    private boolean hasNew = false;
    
    private final long RUN = 1500;
    
    public MTR() {
        this.setPriority(MAX_PRIORITY);
        queue = new Queue();
    }
    
    
    protected void enqueueProcess(Process p) {
        queue.add(p);
        queue = queue.orderByDeadline();
        hasNew = true;
        
    }
    
    protected Process dequeueProcess() {
        return queue.remove();
    }
    
       
    @Override
    public void run() {
        while(!queue.isEmpty()) {
            
            System.out.print("QUEUE: ");
            for (int i = 0; i < queue.size(); i++) {
                System.out.print("[" + ((Process) queue.get(i)).getId() + "]");
            }
            System.out.println("");
            
            Process current = dequeueProcess();
            
            if(current.state==Process.BLOCKED) 
                current.resume();
            else 
                current.start();
            
            long start = System.currentTimeMillis();
            current.state = Process.RUNNING;
            while(System.currentTimeMillis() - start < RUN);
            
            if(hasNew && current.getDeadline()>queue.get(0).getDeadline()) {
                System.out.println("Arrive: ["+queue.get(0).getId()+"]");
                
                current.suspend();
                current.setDeadline(current.getDeadline()-RUN);
                current.state = Process.BLOCKED;
                enqueueProcess(current);
            }
            hasNew = false;    
        }        
    }
}
