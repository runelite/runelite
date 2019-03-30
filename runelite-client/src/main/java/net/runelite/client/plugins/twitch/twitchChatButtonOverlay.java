/*
 * Copyright (c) 2019, jzimmm <jordan.zimmerman26@gmail.com>
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
package net.runelite.client.plugins.twitch;

import net.runelite.api.Client;
import net.runelite.api.SpriteID;
import net.runelite.api.VarClientInt;
import net.runelite.client.plugins.twitch.TwitchConfig;
import net.runelite.client.plugins.twitch.TwitchPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.util.ColorUtil;
import javax.inject.Inject;
import java.awt.*;

public class twitchChatButtonOverlay extends Overlay
{
	private final Client client;
	private final TwitchConfig config;
	private final TwitchPlugin plugin;

	private static final int TWITCH_CHAT_PANE = 6;
	private static final int CLAN_CHAT_BUTTON = 4;


	@Inject
	private twitchChatButtonOverlay(Client client, TwitchConfig config, TwitchPlugin plugin)
	{
		this.client = client;
		this.config = config;
		this.plugin = plugin;

		setLayer(OverlayLayer.UNDER_WIDGETS);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.getTwitchChatSelected())
		{
			return null;
		}

		setSprite();

		return null;
	}

	private void setSprite()
	{
		if (client.getVar(VarClientInt.CHAT_PANE_SELECTED) == TWITCH_CHAT_PANE && client.getVar(VarClientInt.CHAT_BUTTON_HOVERED_OVER) == CLAN_CHAT_BUTTON)
		{
			plugin.clanChatButtonBackground.setSpriteId(SpriteID.CHATBOX_BUTTON_SELECTED_HOVERED);
		}
		else if ( client.getVar(VarClientInt.CHAT_BUTTON_HOVERED_OVER) == CLAN_CHAT_BUTTON)
		{
			plugin.clanChatButtonBackground.setSpriteId(SpriteID.CHATBOX_BUTTON_HOVERED);
		}
		else if (client.getVar(VarClientInt.CHAT_PANE_SELECTED) == TWITCH_CHAT_PANE)
		{
			plugin.clanChatButtonBackground.setSpriteId(SpriteID.CHATBOX_BUTTON_SELECTED);
		}
		else
		{
			plugin.clanChatButtonBackground.setSpriteId(SpriteID.CHATBOX_BUTTON);
		}

		String filterText = plugin.getTwitchChatFilter()
				? ColorUtil.wrapWithColorTag("Off", new Color(0xFF0000))
				: ColorUtil.wrapWithColorTag("On", new Color(0x00FF00));
		plugin.clanChatButtonFilterText.setText(filterText);
	}

}
