package escalonador;

/**
 *
 * @author Mauricio
 */
public class MTR2 {
    
    public MTR2() {
        
    }
    
    public static Process changeContext(Queue q, Process current) {
        current.stop = System.currentTimeMillis();
        current.runtime = current.stop - current.start;
        current.deadline -= current.runtime;
        current.state = Process.BLOCKED;
        current.suspend();
        
        if(q.get(0).deadline < current.deadline) {
            q.add(current);
            q = q.orderByDeadline();
            return q.get(0);
        }
        else {
            return current;
        }
    }    
       
}
