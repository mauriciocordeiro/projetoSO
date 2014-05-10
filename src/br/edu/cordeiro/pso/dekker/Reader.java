package br.edu.cordeiro.pso.dekker;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/10/2014
 */
public class Reader extends Thread{
    
    private Buffer buffer;
    protected int process;
    
    public Reader(Buffer buffer, int process) {
        this.buffer = buffer;
        this.process = process;
    }
    
    @Override
    public void run() {
        buffer.enter_region(process);
        System.out.println("Read: " + buffer.read());
        buffer.leave_region(process);
    }
}
