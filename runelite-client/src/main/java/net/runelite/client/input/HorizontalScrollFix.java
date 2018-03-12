package net.runelite.client.input;

import com.google.inject.Inject;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

/**
 * https://github.com/runelite/runelite/issues/543
 */
public class HorizontalScrollFix
{
	private boolean isShiftDown = false;

	@Inject
	public HorizontalScrollFix(MouseManager mouseManager, KeyManager keyManager)
	{
		mouseManager.registerMouseWheelListener(new MouseWheelListener()
		{
			@Override
			public int getPriority()
			{
				return 1000;
			}

			@Override
			public MouseWheelEvent mouseWheelMoved(MouseWheelEvent event)
			{
				if (event.isShiftDown() && !isShiftDown)
				{
					event.consume();
				}
				return event;
			}
		});
		keyManager.registerKeyListener(new KeyListener()
		{
			@Override
			public int getPriority()
			{
				return 1000;
			}

			@Override
			public void keyTyped(KeyEvent e)
			{
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SHIFT)
				{
					isShiftDown = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_SHIFT)
				{
					isShiftDown = false;
				}
			}
		});
	}
}
