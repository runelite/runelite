package net.runelite.client.plugins.alfred.scripts.collection;

import net.runelite.client.plugins.alfred.Alfred;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorldDataCollectionThread extends Thread {
    public final ExecutorService executor = Executors.newFixedThreadPool(100);
    public static int completed = 0;
    private int started = 0;

    @Override
    public void run() {
        completed = 0;
        started = 0;
        while (true) {
            Runnable worker = new WorldDataCollectionTask(started);
            executor.execute(worker);
            Alfred.sleep(3500);
            started++;
            updateStatus();
        }
    }

    private void updateStatus() {
        Alfred.setStatus("World Data Collection, Started: " + started + ", Completed: " + completed);
    }
}
