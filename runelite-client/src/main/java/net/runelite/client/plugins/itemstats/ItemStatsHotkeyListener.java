package net.runelite.client.plugins.itemstats;

import java.awt.event.KeyEvent;
import net.runelite.client.config.Keybind;
import net.runelite.client.input.KeyListener;

public class ItemStatsHotkeyListener extends KeyListener {
	private boolean hotkeyHeld = false;
	private final ItemStatConfig config;

	public ItemStatsHotkeyListener(ItemStatConfig config) {
		this.config = config;
	}

	public boolean isHotkeyHeld() {
		return hotkeyHeld;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Keybind keybind = config.statsHotkey();
		if (keybind.matches(e)) {
			hotkeyHeld = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Keybind keybind = config.statsHotkey();
		if (keybind.matches(e)) {
			hotkeyHeld = false;
		}
	}
}
