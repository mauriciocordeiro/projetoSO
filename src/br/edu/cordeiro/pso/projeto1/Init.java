package br.edu.cordeiro.pso.projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/24/2014
 */
public class Init {
    
    public static void main(String[] args) {
        
        Buffer buffer = new Buffer();
        
        /*
         * Create threads
        */
        Reader[] readers = new Reader[25];
        for (int i = 0; i < 25; i++) {
            readers[i] = new Reader(buffer);            
        }
        
        Writer[] writers = new Writer[25];
        for (int i = 0; i < 25; i++) {
            writers[i] = new Writer(buffer);            
        }
        
        for (int i = 0; i < 25; i++) {
            writers[i].start();
        }
        
        for (int i = 0; i < 25; i++) {
            readers[i].start();            
        }
    }
}
