package escalonador;

/**
 *
 * @author Mauricio
 */
public class RoundRobin extends Thread{
    
    private final long TIMESLICE = 2000;
    private Queue readyQueue;
    private Queue blockedQueue;
    
    public RoundRobin() {
        this.setPriority(MAX_PRIORITY);
        readyQueue = new Queue();
        blockedQueue = new Queue();
    }
    
    public void enqueueReadyProcess(Process p) {
        readyQueue.add(p);
    }

    @Override
    public void run() {
        
        while(!readyQueue.isEmpty()) {
            System.out.print("READY: ");
            for (int i = 0; i < readyQueue.size(); i++) {
                System.out.print("["+((Process)readyQueue.get(i)).getId()+"]");                
            }
            System.out.println("");
            
            Process currentProcess = (Process) readyQueue.remove();
            if(currentProcess.state==Process.BLOCKED) {
                    currentProcess.resume();
                }
                else {
                    currentProcess.start();
                }           
                long start = System.currentTimeMillis();
                currentProcess.state = Process.RUNNING;
                System.out.println("Running process "+currentProcess.getId());
                while(System.currentTimeMillis()-start<TIMESLICE);
                try {
                    currentProcess.suspend();
                } catch(Exception e){}
                currentProcess.setDeadline(currentProcess.getDeadline()-TIMESLICE);
                if(currentProcess.getDeadline()>0) {
                    currentProcess.state = Process.BLOCKED;
                    blockedQueue.add(currentProcess);
                }
                else {
                    currentProcess.state = Process.FINALIZED;
                    currentProcess.stop();
                }
            System.out.print("BLOCKED: ");
            for (int i = 0; i < blockedQueue.size(); i++) {
                System.out.print("["+((Process)blockedQueue.get(i)).getId()+"]");                
            }
            System.out.println("");
            
            if(!blockedQueue.isEmpty()) {
                readyQueue.add(blockedQueue.remove());
            }
        }
    }
}
