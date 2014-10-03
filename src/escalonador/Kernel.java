package escalonador;

/**
 *
 * @author Mauricio
 */
public class Kernel {
    
    private static final int ROUNDROBIN = 0;    
    private static final int MTR = 1;    
    private static final int MTR2 = 2;    
    
    public static void main(String[] args) {
        
        int execute = 1;
        
        if(execute==ROUNDROBIN) {
            RoundRobin scheduler = new RoundRobin();

            scheduler.enqueueReadyProcess(new Process(3000));
            scheduler.enqueueReadyProcess(new Process(2000));
            scheduler.enqueueReadyProcess(new Process(6000));
            scheduler.enqueueReadyProcess(new Process(8000));
            scheduler.enqueueReadyProcess(new Process(5000));

            scheduler.start();
            
        }
        else if(execute==MTR) {
            
            MTR scheduler = new MTR();
            
            scheduler.enqueueProcess(new Process(3000));
            scheduler.start();
            long st = System.currentTimeMillis();
            while(System.currentTimeMillis()-st<1000);
            scheduler.enqueueProcess(new Process(5000));
            while(System.currentTimeMillis()-st<2000);
            scheduler.enqueueProcess(new Process(2000));
            while(System.currentTimeMillis()-st<3000);
            scheduler.enqueueProcess(new Process(8000));
            while(System.currentTimeMillis()-st<5000);
            scheduler.enqueueProcess(new Process(6000));
            
        }
        else if(execute==MTR2) {
            
            long[] arrive = {0, 1000, 2000, 3000, 5000};
            long[] burst = {3000, 5000, 2000, 8000, 6000};
            Queue queue = new Queue();
            
            long st = System.currentTimeMillis();
            queue.add(new Process(burst[0], arrive[0]));
            Process current = queue.remove();
            current.start = System.currentTimeMillis();
            current.state = Process.RUNNING;
            current.start();
            int count = 1;
            do {
                while(System.currentTimeMillis()-st<arrive[count]);
                queue.add(new Process(burst[count], arrive[count]));
                
                current = queue.remove();
                if(current.deadline < queue.get(0).deadline) {
                    current = escalonador.MTR2.changeContext(queue, current);
                }
                
                
                if(current.state == Process.BLOCKED) {
                    current.resume();
                }
                else {
                    current.start();
                }
                
                current.state = Process.RUNNING;
                current.start = System.currentTimeMillis();                
                
                
                count++;
            } while(!queue.isEmpty());
            
        }
        else {
            
            Queue q = new Queue();
            q.add(new Process(6000));
            q.add(new Process(3000));
            q.add(new Process(7000));
            q.add(new Process(1000));
            q.add(new Process(9000));
            for (int i = 0; i < q.size(); i++) {
                System.out.print("["+q.get(i).getDeadline()+"]");                
            }
            System.out.println();
            
            q = q.orderByDeadline();
            
            for (int i = 0; i < q.size(); i++) {
                System.out.print("["+q.get(i).getDeadline()+"]");                
            }
            System.out.println();
        }
        
    }
    
}
