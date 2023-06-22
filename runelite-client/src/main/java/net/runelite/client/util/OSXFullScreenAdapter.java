package net.runelite.client.util;

import com.apple.eawt.FullScreenAdapter;
import com.apple.eawt.event.FullScreenEvent;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class OSXFullScreenAdapter extends FullScreenAdapter
{
    private final Frame gui;

    public OSXFullScreenAdapter(Frame gui)
    {
        this.gui = gui;
    }

    @Override
    public void windowEnteredFullScreen(FullScreenEvent e)
    {
        log.debug("Window entered fullscreen mode--setting extended state to {}", JFrame.MAXIMIZED_BOTH);
        gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @Override
    public void windowExitedFullScreen(FullScreenEvent e)
    {
        log.debug("Window exited fullscreen mode--setting extended state to {}", JFrame.NORMAL);
        gui.setExtendedState(JFrame.NORMAL);
    }
}
