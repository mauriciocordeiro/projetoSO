package peterson;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/13/2014
 */
public class Init {    
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        
        Writer writer = new Writer(buffer, 0);
        Reader reader = new Reader(buffer, 1);
        
        writer.start();
        reader.start();
    }
}
