package net.runelite.mixins;

import java.awt.Canvas;
import java.awt.event.FocusListener;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSCanvas;
import net.runelite.rs.api.RSClient;

@Mixin(RSCanvas.class)
public abstract class RSCanvasMixin extends Canvas implements RSCanvas
{
	@Shadow("client")
	private static RSClient client;

	// This is inverted because it is false initialized.
	@Inject
	private static boolean shouldNotHaveFocus;

	@Inject
	@Override
	public void removeFocusListener(FocusListener l)
	{
		super.removeFocusListener(l);
		shouldNotHaveFocus = !this.hasFocus();
	}

	@Inject
	@Override
	public void requestFocus()
	{
		// Runescape requests focus whenever the window is resized. Because of this, PluginPanels cannot have focus
		// if they cause the sidebar to expand. This change prevents Runescape from requesting focus whenever it wants
		if (!shouldNotHaveFocus)
		{
			this.requestFocusInWindow();
		}
	}

	@Inject
	@Override
	public void setSize(int width, int height)
	{
		if (client.isStretchedEnabled())
		{
			super.setSize(client.getStretchedDimensions().width, client.getStretchedDimensions().height);
		}
		else
		{
			super.setSize(width, height);
		}
	}

	@Inject
	@Override
	public void setLocation(int x, int y)
	{
		if (client.isStretchedEnabled())
		{
			super.setLocation((getParent().getWidth() - client.getStretchedDimensions().width) / 2, 0);
		}
		else
		{
			super.setLocation(x, y);
		}
	}
}
