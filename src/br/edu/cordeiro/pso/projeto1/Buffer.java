package br.edu.cordeiro.pso.projeto1;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 4/24/2014
 */
public class Buffer {
    
    private Integer[] buffer = {null, null, null, null, null};
    
    private int tail = -1;
    
    public void write(Integer x) {
        tail++;
        if (buffer[tail] != null || tail>=5) {
            System.err.println("BUFFER OVERFLOW");
            return;
        }
        buffer[tail%5] = x;
    }
    
    public Integer read() {
        if (buffer[tail] == null || tail<0) {
            System.err.println("BUFFER UNDERFLOW");
            return null;
        }
        Integer temp = buffer[tail];
        buffer[tail] = null;
        tail--;
        return temp;
    }
    
    public int getTail() {
        return tail;
    }
}
