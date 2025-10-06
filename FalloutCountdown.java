

/**
 * FalloutCountdown.java
 *
 * A concurrency demo using two threads to simulate RAD exposure in Fallout
 * and its cooldown via an antidote.
 */
public class FalloutCountdown {
    /**
     * Main method that coordinates the execution of two threads:
     * - RadiationExposure: counts up to 20
     * - AntidoteCooldown: counts down to 0 after RadiationExposure completes
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Thread radiationThread = new Thread(new RadiationExposure());
        Thread antidoteThread = new Thread(new AntidoteCooldown());

        radiationThread.start();
        try {
            radiationThread.join(); // Wait for radiation to max out
        } catch (InterruptedException e) {
            System.out.println("Radiation thread interrupted.");
        }

        antidoteThread.start();
    }
}

/**
 * Represents radiation exposure increasing from 1 to 20 RADs.
 */
class RadiationExposure implements Runnable {
    /**
     * Executes the radiation exposure count up.
     */
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Radiation Level: " + i + " RADs");
            sleepOneSecond();
        }
        System.out.println();
        System.out.println("Max radiation reached. Administering antidote...");
    }

    /**
     * Pauses the thread for one second.
     */
    private void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Radiation thread interrupted during sleep.");
        }
    }
}

/**
 * Represents the antidote process decreasing radiation from 20 to 0.
 */
class AntidoteCooldown implements Runnable {
    /**
     * Executes the antidote cooldown count down.
     */
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Antidote Progress: Radiation down to " + i + " RADs");
            sleepOneSecond();
        }
        System.out.println("Radiation neutralized.");
    }

    /**
     * Pauses the thread for one second.
     */
    private void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Antidote thread interrupted during sleep.");
        }
    }
}