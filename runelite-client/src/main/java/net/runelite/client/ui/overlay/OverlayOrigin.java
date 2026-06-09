/*
 * Copyright (c) 2026, Adam <Adam@sigterm.info>
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
package net.runelite.client.ui.overlay;

import java.awt.Point;
import net.runelite.api.Client;
import net.runelite.api.annotations.Component;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;

enum OverlayOrigin
{
	AUTO,
	MANUAL,
	SIDEPANEL
		{
			@Override
			Widget getWidget(Client client)
			{
				return getComponent(
					client,
					InterfaceID.ToplevelOsrsStretch.SIDE_MENU,
					InterfaceID.ToplevelPreEoc.SIDE_CONTAINER,
					InterfaceID.Toplevel.SIDE
				);
			}
		},
	CHATBOX
		{
			@Override
			Widget getWidget(Client client)
			{
				return getComponent(
					client,
					InterfaceID.ToplevelOsrsStretch.CHAT_CONTAINER,
					InterfaceID.ToplevelPreEoc.CHAT_CONTAINER,
					InterfaceID.Toplevel.CHAT_CONTAINER
				);
			}
		},
	MINIMAP
		{
			@Override
			Widget getWidget(Client client)
			{
				return getComponent(
					client,
					InterfaceID.ToplevelOsrsStretch.MAP_CONTAINER,
					InterfaceID.ToplevelPreEoc.MAP_CONTAINER,
					InterfaceID.Toplevel.MAPCONTAINER
				);
			}
		};

	Widget getWidget(Client client)
	{
		return null;
	}

	private static Widget getComponent(Client client, @Component int stretch, @Component int eoc, @Component int fixed)
	{
		if (client.isResized())
		{
			if (client.getTopLevelInterfaceId() == InterfaceID.TOPLEVEL_PRE_EOC)
			{
				return client.getWidget(eoc);
			}
			else
			{
				return client.getWidget(stretch);
			}
		}
		return client.getWidget(fixed);
	}

	final Point coord = new Point();
}
