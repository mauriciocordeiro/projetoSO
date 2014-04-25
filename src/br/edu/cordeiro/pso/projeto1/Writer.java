package br.edu.cordeiro.pso.projeto1;

import java.util.Random;

/**
 *
 * @author Mauricio Cordeiro
 * @version 1.0
 * @since 4/24/2014
 */
public class Writer extends Thread {
    
    private Buffer buffer;
    
    public Writer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Integer i = new Integer(new Random().nextInt(101));
        System.out.println("Write: " + i.toString() + " Position: " + buffer.getTail());
        buffer.write(i);
    }
}
