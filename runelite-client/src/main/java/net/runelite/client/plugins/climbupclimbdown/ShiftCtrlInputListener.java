package net.runelite.client.plugins.climbupclimbdown;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.input.KeyListener;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

@Slf4j
public class ShiftCtrlInputListener implements KeyListener {

	@Inject
	Client client;

	@Inject
	ClimbPlugin plugin;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SHIFT:
				if (plugin.isHoldingShift()) return;
				plugin.setHoldingShift(true);
				break;
			case KeyEvent.VK_CONTROL:
				if (plugin.isHoldingCtrl()) return;
				plugin.setHoldingCtrl(true);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_SHIFT:
				if (!plugin.isHoldingShift()) return;
				plugin.setHoldingShift(false);
				break;
			case KeyEvent.VK_CONTROL:
				if (!plugin.isHoldingCtrl()) return;
				plugin.setHoldingCtrl(false);
				break;
		}
	}
}
