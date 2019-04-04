package net.runelite.client.plugins.regionlocker;

import net.runelite.client.config.Keybind;
import net.runelite.client.input.KeyListener;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

public class RegionLockerInput implements KeyListener {
    static Keybind UNLOCK_KEY;
    static Keybind BLOCK_KEY;

    @Inject
    private RegionLockerPlugin plugin;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (UNLOCK_KEY.matches(e))
        {
            plugin.setUnlockKeyPressed(true);
        }
        if (BLOCK_KEY.matches(e))
        {
            plugin.setBlockKeyPressed(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (UNLOCK_KEY.matches(e))
        {
            plugin.setUnlockKeyPressed(false);
        }
        if (BLOCK_KEY.matches(e))
        {
            plugin.setBlockKeyPressed(false);
        }
    }
}
