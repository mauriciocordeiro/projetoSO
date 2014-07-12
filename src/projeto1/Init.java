package projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/27/2014
 */
public class Init {
    
    public static void main(String[] args) {
        
        Buffer buffer = new Buffer();
        
        /*
         * Create threads
        */
        Consumer[] consumers = new Consumer[25];
        for (int i = 0; i < 25; i++) {
            consumers[i] = new Consumer(buffer);            
        }
        
        Producer[] producers = new Producer[25];
        for (int i = 0; i < 25; i++) {
            producers[i] = new Producer(buffer);            
        }
        
        /*
         * Start Threads 
         */
        for (int i = 0; i < 25; i++) {
            producers[i].start();
        }
        
        for (int i = 0; i < 25; i++) {
            consumers[i].start();            
        }
        
        /*
         * Join Threads
         */
        for (int i = 0; i < producers.length; i++) {
            try {
                producers[i].join();
                consumers[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}
