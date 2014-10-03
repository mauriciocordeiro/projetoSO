package escalonador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Mauricio
 */
public class Queue implements java.util.Queue<Process>{
    
    private ArrayList<Process> queue;
    
    public Queue() {
        this.queue = new ArrayList<Process>();
    }

    @Override
    public boolean add(Process e) {
        return queue.add(e);
    }

    @Override
    public boolean offer(Process e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Process remove() {
        Process temp = queue.get(0);
        queue.remove(0);
        return temp;
    }
    
    public Process get(int index) {
        return queue.get(index);
    }

    @Override
    public Process poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Process element() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Process peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<Process> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Process[] toArray() {
        Process[] array = new Process[this.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.get(i);            
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends Process> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }
    
    public Queue orderByDeadline() {
        Queue q = new Queue();
        int size = this.size();
        Process[] a = this.toArray();
        Process aux = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if(a[j].getDeadline()>a[j+1].getDeadline()) {
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
        }
                
        for (int i = 0; i < a.length; i++) {
            q.add(a[i]);            
        }
        
        return q;
    }
}
