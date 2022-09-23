/*
 * Copyright (c) 2022, kamielvf <code@kamiel.dev>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
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
package net.runelite.client.plugins.party;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.input.MouseListener;

@RequiredArgsConstructor
public class PartyPingMouseListener implements MouseListener
{
	// distance in px mouse needs to be dragged before radial ping menu is shown
	private static final int PING_MENU_OPEN_DRAG_DISTANCE = 15; 

	private final Client client;
	private final PartyPlugin plugin;
	private final PartyConfig config;

	@Override
	public MouseEvent mouseClicked(MouseEvent event)
	{
		return event;
	}

	@Override
	public MouseEvent mousePressed(MouseEvent event)
	{
		// if user inputs another button we want to close the radial menu
		if (!plugin.isAdvancedPingMenuOpen() || SwingUtilities.isLeftMouseButton(event) ||
			client.isMenuOpen() || !plugin.getParty().isInParty() || !config.pings())
		{
			return event;
		}

		plugin.resetPingMenu();
		return event;
	}

	@Override
	public MouseEvent mouseReleased(MouseEvent event)
	{
		if (plugin.getPendingPartyPing() == null || !SwingUtilities.isLeftMouseButton(event) ||
			client.isMenuOpen() || !plugin.getParty().isInParty() || !config.pings())
		{
			return event;
		}

		// only send ping if the user is not cancelling selection
		if (plugin.getPendingPartyPing().getPingType() != null)
		{
			plugin.getParty().send(plugin.getPendingPartyPing());
		}

		plugin.resetPingMenu();
		return event;
	}

	@Override
	public MouseEvent mouseEntered(MouseEvent event)
	{
		return event;
	}

	@Override
	public MouseEvent mouseExited(MouseEvent event)
	{
		return event;
	}

	@Override
	public MouseEvent mouseDragged(MouseEvent event)
	{
		if (!plugin.isPingHotkeyPressed() && !plugin.isAdvancedPingMenuOpen() || !SwingUtilities.isLeftMouseButton(event) ||
			client.isMenuOpen() || !plugin.getParty().isInParty() || plugin.getPendingPartyPing() == null || !config.pings())
		{
			return event;
		}
		
		Point mousePosition = client.getMouseCanvasPosition();
		int distance = plugin.getMouseStartPosition().distanceTo(mousePosition);

		if (plugin.isAdvancedPingMenuOpen())
		{
			// if mouse is within deadzone we want to cancel selection
			if (distance <= PartyPlugin.PING_MENU_DEADZONE)
			{
				plugin.getPendingPartyPing().setPingType(null);
				return event;
			}

			PartyPingType[] pingTypes = PartyPingType.values();
			double optionSelectionSize = 360.0 / (pingTypes.length - 1);
			double offset = optionSelectionSize / 2.0;

			double angle = Math.toDegrees(Math.atan2(plugin.getMouseStartPosition().getY() - mousePosition.getY(), plugin.getMouseStartPosition().getX() - mousePosition.getX())) - offset;
			if (angle < 0)
			{
				angle += 360;
			}

			int ordinal = (int) Math.floor(angle / optionSelectionSize);
			plugin.getPendingPartyPing().setPingType(pingTypes[ordinal]);
		}
		else if (distance >= PING_MENU_OPEN_DRAG_DISTANCE)
		{
			plugin.setAdvancedPingMenuOpen(true);
			plugin.getPendingPartyPing().setPingType(null);
		}

		return event;
	}

	@Override
	public MouseEvent mouseMoved(MouseEvent event)
	{
		return event;
	}
}
