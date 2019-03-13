package net.runelite.client.plugins.windowsnap;

import com.google.inject.Provides;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JFrame;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.ContainableFrame;

@PluginDescriptor(
		name = "Window Snap",
		description = "Allows the RuneLite window to snap like the windows feature",
		tags = {"window", "snap"},
		enabledByDefault = false
)
public class WindowSnapPlugin extends Plugin
{

	@Inject
	ClientUI clientUI;

	@Inject
	WindowSnapListener windowSnapListener;

	@Inject
	KeyManager keyManager;

	@Inject
	WindowSnapConfig windowSnapConfig;

	ContainableFrame frame;
	private int screenWidth;
	private int screenHeight;

	@Override
	protected void startUp() throws Exception
	{
		frame = clientUI.getFrame();
		Insets bounds = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
		screenWidth = frame.getGraphicsConfiguration().getBounds().width - bounds.left - bounds.right;
		screenHeight = frame.getGraphicsConfiguration().getBounds().height - bounds.top - bounds.bottom;
		JComponent titleBar = clientUI.getTitleBar();
		if (titleBar != null)
		{
			titleBar.addMouseListener(windowSnapListener);
			titleBar.addMouseMotionListener(windowSnapListener);
			keyManager.registerKeyListener(windowSnapListener);
		}
		super.startUp();
	}

	@Override
	protected void shutDown() throws Exception
	{
		JComponent titleBar = clientUI.getTitleBar();
		if (titleBar != null)
		{
			titleBar.removeMouseListener(windowSnapListener);
			titleBar.removeMouseMotionListener(windowSnapListener);
			keyManager.unregisterKeyListener(windowSnapListener);
		}
		super.shutDown();
	}

	@Provides
	WindowSnapConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WindowSnapConfig.class);
	}

	public void windowDragged(int xOnScreen, int yOnScreen)
	{
		if (xOnScreen == 0)
		{
			if (yOnScreen == 0)
			{
				snapUpperLeft();
			}
			else if (yOnScreen >= screenHeight - 1)
			{
				snapLowerLeft();
			}
			else
			{
				snapLeft();
			}
		}
		else if (xOnScreen == screenWidth - 1)
		{
			if (yOnScreen == 0)
			{
				snapUpperRight();
			}
			else if (yOnScreen >= screenHeight - 1)
			{
				snapLowerRight();
			}
			else
			{
				snapRight();
			}
		}
		else if (yOnScreen == 0)
		{
			snapFull();
		}
	}

	public void keyboardShortcutPressed(int keyEvent)
	{
		if (keyEvent == KeyEvent.VK_UP)
			snapFull();
		else if (keyEvent == KeyEvent.VK_LEFT)
			snapLeft();
		else if (keyEvent == KeyEvent.VK_RIGHT)
			snapRight();
		else if (keyEvent == KeyEvent.VK_DOWN)
			frame.setExtendedState(JFrame.ICONIFIED);
	}

	public void snapLeft()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		frame.setBounds(0, 0, width, screenHeight);
	}

	public void snapUpperLeft()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		int height = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customHeight() : screenHeight / 2;
		frame.setBounds(0, 0, width, height);
	}

	public void snapLowerLeft()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		int height = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customHeight() : screenHeight / 2;
		frame.setBounds(0, screenHeight / 2, width, height);
	}

	public void snapRight()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		frame.setBounds(screenWidth - width, 0, width, screenHeight);
	}

	public void snapUpperRight()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		int height = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customHeight() : screenHeight / 2;
		frame.setBounds(screenWidth - width, 0, width, height);
	}

	public void snapLowerRight()
	{
		int width = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customWidth() : screenWidth / 2;
		int height = windowSnapConfig.enableCustomSize() ? windowSnapConfig.customHeight() : screenHeight / 2;
		frame.setBounds(screenWidth - width, screenHeight / 2, width, height);
	}

	public void snapFull()
	{
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
}
