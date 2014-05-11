package br.edu.cordeiro.pso.dekker;

import java.util.Random;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/10/2014
 */
public class Writer extends Thread {
    
    Buffer buffer;
    protected int process;
    
    public Writer(Buffer buffer, int process) {
        this.buffer = buffer;
        this.process = process;
    }
    
    @Override
    public void run() {
        buffer.enterRegion(process);
        Integer w = new Random().nextInt(5);
        System.out.println("Write: " + w);
        buffer.write(w);
        buffer.leaveRegion(process);
    }
}
