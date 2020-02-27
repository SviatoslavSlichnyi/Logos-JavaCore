package lessons.ls_26_Concurrency.ls_05_volatile;

public class VolatileDemo {

    /**
     * In time of creation the variable are cached to CPU memory or else place.
     * So when we set a new value to primitive variable field
     * actually we set the value to copy of the field variable
     *
     * In that situation volatile are going to help solve this problem
     * volatile tell to write exactly to main memory
     */
    volatile static int i;

    public static void main(String[] args) {
        new MyThreadWrite().start();
        new MyThreadRead().start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("name value of is " + i);
                    localVar = i;
                }
            }
        }
    }
}


