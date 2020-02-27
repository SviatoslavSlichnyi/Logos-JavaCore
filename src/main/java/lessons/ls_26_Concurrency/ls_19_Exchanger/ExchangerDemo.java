package lessons.ls_26_Concurrency.ls_19_Exchanger;

import java.util.concurrent.Exchanger;

/**
 *  Exchanger is needed to pass data between threads.
 */

public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new Questionnaire(exchanger);
    }

    static class Mike extends Thread {
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi.\nMy name is Mike");
                sleep(1_000);
                exchanger.exchange("I am 20 years old.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Questionnaire extends Thread {
        Exchanger<String> exchanger;

        public Questionnaire(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                sleep(1_000);
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
