package experiments.onjava;


import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExecutor {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue queue;


    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(7);

        for (int i = 0; i < 5; i++) {
            Task task = new Task(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(task);
        }
    }

    public ThreadPoolExecutor(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker(""+i);
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {
        String name ;

        PoolWorker(   String name ){
            super(name);
            this.name = name;
        }
        public void run() {
            Runnable task;

            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("thread entreed and start runing : "+Thread.currentThread().getName()+" ,name : "+name);
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    System.out.println("NOW get task  runing : "+Thread.currentThread().getName()+" ,name : "+name);
                    task = (Runnable)queue.poll();
                }

                // If we don't catch RuntimeException,
                // the pool could leak threads
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}


class Task implements Runnable {

    private int num;

    public Task(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Task " + num + " is running.");
    }
}


