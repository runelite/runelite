package net.runelite.client.plugins.alfred.scripts.collection;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Alfred World Collections", enabledByDefault = false)
@Slf4j
public class WorldCollectionPlugin extends Plugin {
    static final String CONFIG_GROUP = "Alfred World Collection";
    private WorldDataCollectionThread worldDataCollectionThread;


    @Override
    protected void startUp() throws Exception {
        worldDataCollectionThread = new WorldDataCollectionThread();
        worldDataCollectionThread.start();
    }

    @Override
    protected void shutDown() throws Exception {
        worldDataCollectionThread.executor.shutdown();
        worldDataCollectionThread.executor.shutdownNow();
        while (!worldDataCollectionThread.executor.isTerminated()) {
        }
        worldDataCollectionThread.stop();
    }
}
