/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.cycle;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@PluginDescriptor(
        name = "cycle",
        description = "cycle counter",
        tags = {"CoX"},
        enabledByDefault = false
)

public class CyclePlugin extends Plugin {
    int x = 0;

    @Override
    protected void startUp() {
    }

    @Override
    protected void shutDown() {
    }

    @Subscribe
    public void onGameTick(GameTick event) throws IOException
    {
        x++;
        String fileContent = ""+x;
        BufferedWriter writer = new BufferedWriter(new FileWriter("./cycle.txt"));
        writer.write(fileContent);
        writer.close();
    }
}


