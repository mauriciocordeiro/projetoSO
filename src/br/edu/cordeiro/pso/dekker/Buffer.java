package br.edu.cordeiro.pso.dekker;

/**
 *
 * @author Mauricio Cordeiro
 * @version 0.1
 * @since 5/10/2014
 * 
 * @about Buffer implementado com o algoritmo de Dekker
 */

public class Buffer {
    
    private int x;
    
    private int wait_turn;
    boolean[] interest = new boolean[2];
    
    public Buffer() {
        x = -1;
    }
    
    public Integer read() {
        return x;
    }
    
    public void write(int x) {
        this.x = x;
    }
    
    /*
     * Métodos para o controle de acesso a região crítica
     */
    protected void enter_region(int process) {
        int other = 1 - process;
        interest[process] = true;
        wait_turn = process;
        while((wait_turn == process) && interest[other]);
        System.err.println("Process " + process + " enter region");
    }
    
    protected void leave_region(int process) {
        interest[process] = false;
        System.err.println("Process " + process + " leave region");
    }
}
