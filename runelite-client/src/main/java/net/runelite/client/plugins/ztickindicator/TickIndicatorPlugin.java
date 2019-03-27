/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Credit is due  to SomeoneWithAnInternetConnection and oplosthee
 * for writing the original Runelite Metronome, which inspired this plugin.
 */

package net.runelite.client.plugins.ztickindicator;

import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "TickIndicator",
        description = "Play a sound on tick to get big rhythm",
        tags = {"ticks"},
        enabledByDefault = false
)
public class TickIndicatorPlugin extends Plugin
{
    private boolean hotkey;
    private int counter;

    @Inject
    private Client client;

    @Inject
    private TickIndicatorConfig config;

    @Inject
    private TickIndicatorInput inputListener;

    @Inject
    private KeyManager keyManager;

    @Provides
    TickIndicatorConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(TickIndicatorConfig.class);
    }

    @Override
    protected void startUp()
    {
        hotkey = false;
        keyManager.registerKeyListener(inputListener);
    }

    @Override
    protected void shutDown()
    {
        keyManager.unregisterKeyListener(inputListener);
    }


    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (config.tickCount() == 0 || counter != 0)
        {
            for (int volume = 0; volume < config.Volume1(); volume++)
            {
                client.playSoundEffect(config.SoundEffect1());
            }
        }
        else
        {
            for (int volume = 0; volume < config.Volume2(); volume++)
            {
                client.playSoundEffect(config.SoundEffect2());
            }
        }

        counter++;
        if (config.tickCount() > 0)
        {
            counter = counter % config.tickCount();
        }
    }

    void updateHotkey(boolean pressed)
    {
        if (pressed)
        {
            counter = 0;
        }
    }
}
