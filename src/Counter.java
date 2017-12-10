public class Counter {
    private static int count;
    private Object key = new Object();
    public void incrementCount(){
        synchronized (key) {
            this.count = this.count + 1; //thread safe
        }
    }
    public int getCount(){
        return this.count;
    }
}
