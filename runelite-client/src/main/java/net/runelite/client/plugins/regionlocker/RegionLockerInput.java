package net.runelite.client.plugins.regionlocker;

import net.runelite.client.input.KeyListener;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

public class RegionLockerInput implements KeyListener {
    private static final int UNLOCK_KEY = KeyEvent.VK_SHIFT;
    private static final int BLOCK_KEY = KeyEvent.VK_CONTROL;

    @Inject
    private RegionLockerPlugin plugin;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == UNLOCK_KEY)
        {
            plugin.setUnlockKeyPressed(true);
        }
        if (e.getKeyCode() == BLOCK_KEY)
        {
            plugin.setBlockKeyPressed(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == UNLOCK_KEY)
        {
            plugin.setUnlockKeyPressed(false);
        }
        if (e.getKeyCode() == BLOCK_KEY)
        {
            plugin.setBlockKeyPressed(false);
        }
    }
}
