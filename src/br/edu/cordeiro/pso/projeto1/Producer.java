package br.edu.cordeiro.pso.projeto1;

import java.util.Random;

/**
 *
 * @author Mauricio Cordeiro
 * @version 1.0
 * @since 4/24/2014
 */
public class Producer extends Thread {
    
    private Buffer buffer;
    
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + buffer.push(new Random().nextInt(101)));
    }
}
