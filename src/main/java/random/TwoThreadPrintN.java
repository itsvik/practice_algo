package random;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadPrintN {


    int i=0;

    private void evenNumber() {
        synchronized (this){
            while(i<100) {
//                try {
                    while (i%2 != 0);
//                        wait();
                    System.out.println(i);
                    notify();
//                } catch (InterruptedException e){
//
//                }
                i++;
            }};
    }
    private void oddNumber() {
        synchronized (this) {
            while(i<100) {
//                try {
                    while (i%2 != 1);
//                        wait();
                    System.out.println(i);
                    notify();
//                } catch (InterruptedException e) {
//
//                }
                i++;
            }
        }
    }
    public static void main(String[] args) {
        TwoThreadPrintN ttp = new TwoThreadPrintN();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ttp.evenNumber();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ttp.oddNumber();
            }
        });
        t1.start();
        t.start();
    }




}
