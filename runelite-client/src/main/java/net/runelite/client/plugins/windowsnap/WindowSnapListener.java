package net.runelite.client.plugins.windowsnap;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.inject.Inject;
import net.runelite.client.input.KeyListener;

public class WindowSnapListener implements MouseListener, MouseMotionListener, KeyListener
{

	private boolean mouseDragging;

	@Inject
	WindowSnapConfig windowSnapConfig;

	@Inject
	WindowSnapPlugin windowSnapPlugin;

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (mouseDragging && windowSnapConfig.mouseEnabled())
		{
			windowSnapPlugin.windowDragged(e.getXOnScreen(), e.getYOnScreen());
		}

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		mouseDragging = true;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (windowSnapConfig.keyboardShortcutEnabled() && e.isControlDown())
		{
			windowSnapPlugin.keyboardShortcutPressed(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}
}
