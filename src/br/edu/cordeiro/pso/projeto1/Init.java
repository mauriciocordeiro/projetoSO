package br.edu.cordeiro.pso.projeto1;

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
        Consumer[] readers = new Consumer[25];
        for (int i = 0; i < 25; i++) {
            readers[i] = new Consumer(buffer);            
        }
        
        Producer[] writers = new Producer[25];
        for (int i = 0; i < 25; i++) {
            writers[i] = new Producer(buffer);            
        }
        
        /*
         * Start Threads 
         */
        for (int i = 0; i < 25; i++) {
            writers[i].start();
        }
        
        for (int i = 0; i < 25; i++) {
            readers[i].start();            
        }
        
        /*
         * Join Threads
         */
        for (int i = 0; i < writers.length; i++) {
            try {
                writers[i].join();
                readers[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}
