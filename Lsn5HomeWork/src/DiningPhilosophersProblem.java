import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersProblem {

    private static final int CNT_PHILOSOPHERS = 5; // Всего философов
    private final Philosopher[] philosophers;
    private final Fork[] forks;
    private final ReentrantLock table = new ReentrantLock();

    public DiningPhilosophersProblem() {
        philosophers = new Philosopher[CNT_PHILOSOPHERS];
        forks = new Fork[CNT_PHILOSOPHERS];

        for (int i = 0; i < CNT_PHILOSOPHERS; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < CNT_PHILOSOPHERS; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % CNT_PHILOSOPHERS]);
            new Thread(philosophers[i]).start();
        }
    }

    class Philosopher implements Runnable {
        private final int id;
        private final Fork leftFork;
        private final Fork rightFork;
        private int mealsEaten = 0;

        public Philosopher(int id, Fork leftFork, Fork rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            while (mealsEaten < 3) {
                table.lock();
                try {
                    if (leftFork.grab()) {
                        rightFork.grab();
                        eat();
                    }
                    rightFork.putDown();
                    leftFork.putDown();
                } finally {
                    table.unlock();
                }
                think();
            }
        }

        private void eat() {
            System.out.println("Философ " + id + " ест.");
            mealsEaten++;
            System.out.println("Философ " + id + " поел " + mealsEaten + " раз(а)");
        }

        private void think() {

            System.out.println("Философ " + id + " размышляет.");

        }
    }

    class Fork {

        public boolean grab() {
            try {
                return table.tryLock(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                return false;
            }
        }

        public void putDown() {
            table.unlock();
        }

      /*  boolean isFree()
        {
            return semaphore.availablePermits() > 0;
        }*/
    }
}
