/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice, this
 *    list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.attackstyles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.swing.Timer;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;

class AttackStylesFlashOverlay extends Overlay
{
	private final AttackStylesPlugin plugin;
	private final AttackStylesConfig config;
	private final Client client; // Inject the Client object

	private boolean flashActive = false; // Is the screen flashing right now?
	private Timer flashTimer; // Timer for toggling the flash state
	private static final int FLASH_INTERVAL = 500; // Flash interval in milliseconds
	private static final Color FLASH_COLOR = new Color(255, 0, 0, 100); // Semi-transparent red color

	@Inject
	private AttackStylesFlashOverlay(AttackStylesPlugin plugin, AttackStylesConfig config, Client client)
	{
		this.plugin = plugin;
		this.config = config;
		this.client = client; // Initialize the Client object
		setPosition(OverlayPosition.DYNAMIC);
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Attack style overlay");
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		boolean warnedSkillSelected = plugin.isWarnedSkillSelected();

		// Check if flashing is enabled in the config
		if (config.enableFlashing() && warnedSkillSelected)
		{
			startFlashing();
		}
		else
		{
			// Stop flashing if the warned skill is no longer selected or flashing is disabled
			stopFlashing();
		}

		// Only render the flashing effect if flashActive is true
		if (flashActive)
		{
			// Get the client's dimensions to cover the full window
			Dimension clientDimensions = client.getCanvas().getSize();

			// Draw a semi-transparent red overlay covering the entire client
			graphics.setColor(FLASH_COLOR);
			graphics.fillRect(0, 0, clientDimensions.width, clientDimensions.height);
		}

		return null;
	}

	// Start flashing the screen indefinitely until the style is changed
	void startFlashing()
	{
		if (flashTimer != null && flashTimer.isRunning())
		{
			// Flashing is already running, so no need to start it again
			return;
		}

		flashActive = true; // Start in the active flash state

		// Timer to toggle flash on and off every FLASH_INTERVAL milliseconds
		flashTimer = new Timer(FLASH_INTERVAL, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				flashActive = !flashActive; // Toggle flash state
			}
		});
		flashTimer.start();
	}

	// Stop flashing when the attack style has been changed
	void stopFlashing()
	{
		if (flashTimer != null)
		{
			flashTimer.stop();
			flashActive = false; // Reset the flash state
		}
	}
}
