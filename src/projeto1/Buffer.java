package projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/27/2014
 */
public class Buffer {
    
    private Integer[] buffer = {null, null, null, null, null};
    private final long SECONDS = 1000;
    
    public synchronized String push(Integer x) {
        while(!hasSpace()) {
            try {
                wait(SECONDS);
            }
            catch(InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
        int index = searchToPush(); 
        buffer[index] = x;
        notifyAll();
        
        return "Write: " + x + " Position: " + index;
    }
    
    public synchronized String pull() {
        while(isEmpty()) {
            try {
                wait(SECONDS);
            }
            catch(InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
        int index = searchToPull();
        Integer temp = buffer[index];
        buffer[index] = null;
        notifyAll();
        
        return "Read: " + temp.toString() + " Position: " + index;
    }
    
    public int searchToPush() {
        int space = 0;
        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i]==null) {
                space = i;
                break;
            }            
        }
        return space;
    }
    
    public int searchToPull() {
        int space = 0;
        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i]!=null) {
                space = i;
                break;
            }            
        }
        return space;
    }
    
    public boolean hasSpace() {
        boolean has = false;
        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i]==null) {
                has = true;
                break;
            }
        }
        return has;
    } 
    
    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < buffer.length; i++) {
            if(buffer[i]!=null) {
                empty = false;
            }            
        }
        return empty;
    }
}