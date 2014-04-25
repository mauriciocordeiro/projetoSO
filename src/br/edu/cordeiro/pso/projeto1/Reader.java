package br.edu.cordeiro.pso.projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 1.0
 * @since 4/24/2014
 */
public class Reader extends Thread {

    private Buffer buffer;
    
    public Reader(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        Integer i = buffer.read();
        System.out.println("Read: " + i.toString() + " Position: " + buffer.getTail());
    }
}
