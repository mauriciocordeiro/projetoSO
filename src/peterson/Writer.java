package peterson;

import java.util.Random;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/13/2014
 */
public class Writer extends Thread {
    
    private Buffer buffer;
    protected int process;
    
    public Writer(Buffer buffer, int process) {
        this.buffer = buffer;
        this.process = process;
    }
    
    @Override
    public void run() {
        buffer.enterRegion(process);
        buffer.write(new Random().nextInt(5));
        buffer.leaveRegion(process);
    }
}
