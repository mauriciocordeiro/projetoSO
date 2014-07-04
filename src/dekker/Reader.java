package dekker;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/13/2014
 */
public class Reader extends Thread{
    
    private Buffer buffer;
    protected int process;
    
    public Reader(Buffer buffer, int process) {
        this.buffer = buffer;
        this.process = process;
    }
    
    @Override
    public void run() {
        buffer.enterRegion(process);
        buffer.read();
        buffer.leaveRegion(process);
    }
}
