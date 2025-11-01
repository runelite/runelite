package net.runelite.client.plugins.bankwatcher;

import lombok.extern.java.Log;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor (
        name = "Bank Watcher"
)
public class BankWatcherPlugin extends Plugin {

    @Override
    protected void startUp() throws Exception{
        Log.info("Bank watcher plugin started");
    }

    @Override
    protected void shutDown() throws Exception {
        Log.info("Bank watcher plugin has stopped");
    }
}
