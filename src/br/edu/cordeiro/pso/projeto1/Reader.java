package br.edu.cordeiro.pso.projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/27/2014
 */
public class Reader extends Thread {

    private Buffer buffer;
    
    public Reader(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println(this.getName() + " " + buffer.pull());
    }
}
