package net.runelite.client.plugins.grounditems;

import net.runelite.client.util.HotkeyListener;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;

public class GroundItemHotkeyListener extends HotkeyListener
{
	private Instant lastPress;

	private final GroundItemsPlugin plugin;
	private final GroundItemsConfig config;

	@Inject
	public GroundItemHotkeyListener(GroundItemsPlugin plugin, GroundItemsConfig config)
	{
		super(config::hotkey);

		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public void hotkeyPressed()
	{
		if (plugin.isHideAll())
		{
			plugin.setHideAll(false);
			plugin.setHotKeyPressed(true);
			lastPress = null;
		}
		else if (lastPress != null && !plugin.isHotKeyPressed() && config.doubleTapDelay() > 0 && Duration.between(lastPress, Instant.now()).compareTo(Duration.ofMillis(config.doubleTapDelay())) < 0)
		{
			plugin.setHideAll(true);
			lastPress = null;
		}
		else
		{
			plugin.setHotKeyPressed(true);
			lastPress = Instant.now();
		}
	}

	@Override
	public void hotkeyReleased()
	{
		plugin.setHotKeyPressed(false);
		plugin.setTextBoxBounds(null);
		plugin.setHiddenBoxBounds(null);
		plugin.setHighlightBoxBounds(null);
	}
}
