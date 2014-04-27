package br.edu.cordeiro.pso.projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 1.0
 * @since 4/24/2014
 */
public class Consumer extends Thread {

    private Buffer buffer;
    
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        System.out.println(this.getName() + buffer.pull());
    }
}
