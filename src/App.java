public class App {

    private static Counter counter;

    public static void main(String[] args) throws InterruptedException{
        System.out.println("I am in Thread: "+ Thread.currentThread().getName());
        counter = new Counter();

        //JAVA 8 lambda exp
        Runnable task = () -> {
            for (int i=0; i<1000; i++){
                counter.incrementCount();
            }
        };

        Thread[] threads = new Thread[1000];//creating an array for 1000 threads
        for(int i=0; i<1000; i++){
            threads[i] = new Thread(task); //creation of a new thread
            threads[i].start(); //execution of task starts
        }

        //main thread waits here bcoz of join method.
        for(int i=0; i<1000; i++){
            threads[i].join(); // waiting for threads to complete their tasks
        }

        //expected value of count is 1000*1000
        System.out.println("Value of counter is: " + counter.getCount());
    }
}
