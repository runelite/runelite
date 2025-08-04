package net.runelite.client.plugins.synthetickeytest;

import net.runelite.client.plugins.Plugin;
import com.google.inject.Provides;
import java.awt.Color;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.input.MouseManager;

@PluginDescriptor(
        name = "Synthetic Key Test",
        description = "Tests use of synthetic key creation for mouse binds",
        tags = {"enter", "mouse", "key"},
        enabledByDefault = false
)
public class SyntheticKeyTestPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private MouseManager mouseManager;

    @Inject
    private SyntheticKeyTestListener inputListener;

    @Override
    protected void startUp() throws Exception
    {
        mouseManager.registerMouseListener(inputListener);

    }

    @Override
    protected void shutDown() throws Exception
    {
        mouseManager.unregisterMouseListener(inputListener);
    }

    @Provides
    SyntheticKeyTestConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(SyntheticKeyTestConfig.class);
    }

}
