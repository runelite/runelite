package net.runelite.client.plugins.alfred.scripts.chickenkiller;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Alfred Chicken Killer", enabledByDefault = false)
@Slf4j
public class ChickenKillerPlugin extends Plugin {
    private ChickenKillerThread chickenKillerThread;


    @Override
    protected void startUp() throws Exception {
        chickenKillerThread = new ChickenKillerThread();
        chickenKillerThread.start();
    }

    @Override
    protected void shutDown() throws Exception {
        chickenKillerThread.stop();
    }
}
