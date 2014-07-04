package projeto1;

import java.util.Random;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/27/2014
 */
public class Writer extends Thread {
    
    private Buffer buffer;
    
    public Writer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " " + buffer.push(new Random().nextInt(101)));
    }
}
