package escalonador;

/**
 *
 * @author Mauricio
 */
public class Kernel {
    
    private static final int ROUNDROBIN = 0;    
    private static final int MTR = 1;    
    
    public static void main(String[] args) {
        
        int execute = MTR;
        
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
            
//            Queue process = new Queue();
//            process.add(new Process(3000, 0000));
//            process.add(new Process(2000, 2000));
//            process.add(new Process(6000, 5000));
//            process.add(new Process(8000, 3000));
//            process.add(new Process(5000, 1000));

            
            MTR scheduler = new MTR();
            scheduler.start();
            scheduler.enqueueReadyProcess(new Process(3000, 0000));
            long st = System.currentTimeMillis();
            while(System.currentTimeMillis()-st<1000);
            scheduler.enqueueReadyProcess(new Process(5000, 1000));
            while(System.currentTimeMillis()-st<2000);
            scheduler.enqueueReadyProcess(new Process(2000, 2000));
            while(System.currentTimeMillis()-st<3000);
            scheduler.enqueueReadyProcess(new Process(8000, 3000));
            while(System.currentTimeMillis()-st<5000);
            scheduler.enqueueReadyProcess(new Process(6000, 5000));
            
        }
        
    }
    
}
