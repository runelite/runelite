/*
 * Copyright (c) 2019, Bjornenalfa
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
package net.runelite.client.plugins.raids;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.ClanMember;
import net.runelite.api.Client;
import net.runelite.api.MenuOpcode;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;

@Singleton
public class RaidsPartyOverlay extends Overlay
{
	static final String PARTY_OVERLAY_RESET = "Reset missing";
	static final String PARTY_OVERLAY_REFRESH = "Refresh party";
	private final PanelComponent panelComponent = new PanelComponent();
	private final PanelComponent panel = new PanelComponent();
	@Inject
	private Client client;
	@Inject
	private RaidsPlugin plugin;

	@Inject
	private RaidsPartyOverlay(final RaidsPlugin plugin)
	{
		super(plugin);
		setPosition(OverlayPosition.TOP_RIGHT);
		setPriority(OverlayPriority.HIGH);
		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Raids party overlay"));
		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY, PARTY_OVERLAY_RESET, "Raids party overlay"));
		getMenuEntries().add(new OverlayMenuEntry(MenuOpcode.RUNELITE_OVERLAY, PARTY_OVERLAY_REFRESH, "Raids party overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!plugin.isInRaidChambers())
		{
			return null;
		}

		if (client.getClanChatCount() == 0)
		{
			// Player left clan chat
			return null;
		}

		boolean inLobby = client.getVar(VarPlayer.IN_RAID_PARTY) != -1; // -1 if raid started

		int partySize = client.getVar(Varbits.RAID_PARTY_SIZE);

		int playerCount = client.getPlayers().size();

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);


		String partyCountString;

		Color countColor = Color.WHITE;
		if (inLobby)
		{
			partyCountString = String.format("%d/%d", playerCount, partySize);
			// While we are in the lobby compare to players visible on the screen
			if (partySize <= playerCount)
			{
				countColor = Color.GREEN;
			}
			else
			{
				countColor = Color.RED;
			}
		}
		else
		{
			// If raid has started then we compare the current party size to what it was when we started
			partyCountString = String.format("%d/%d", partySize, plugin.getStartPlayerCount());
			if (plugin.getMissingPartyMembers().size() > 0)
			{
				countColor = Color.RED; // Somebody is missing
			}
		}

		panel.getChildren().clear();

		tableComponent.addRow("Party size:", ColorUtil.prependColorTag(partyCountString, countColor));

		if (inLobby)
		{
			int world = client.getWorld();
			int wrongWorldClanMembers = 0;
			int clanMemberCount = 0;
			for (ClanMember clanMember : client.getClanMembers())
			{
				if (clanMember != null)
				{
					if (clanMember.getWorld() != world)
					{
						wrongWorldClanMembers++;
					}
					else
					{
						clanMemberCount++;
					}
				}
			}

			// Show amount of people on the right world but not at the raids area
			Color notInPartyColor = Color.GREEN;
			int notInParty = clanMemberCount - partySize;

			if (notInParty > 0)
			{
				notInPartyColor = Color.WHITE;
			}

			tableComponent.addRow("Not at raids:", ColorUtil.prependColorTag(String.valueOf(notInParty), notInPartyColor));


			// Show amount of clan members that are not in the right world.
			Color wrongWorldColor;
			if (wrongWorldClanMembers == 0)
			{
				wrongWorldColor = Color.GREEN;
			}
			else
			{
				wrongWorldColor = Color.WHITE;
			}

			tableComponent.addRow("Wrong world:", ColorUtil.prependColorTag(String.valueOf(wrongWorldClanMembers), wrongWorldColor));

		}
		else
		{
			Set<String> missingPartyMembers = plugin.getMissingPartyMembers();
			if (missingPartyMembers.size() > 0)
			{


				tableComponent.addRow("Missing players:", "");

				for (String member : missingPartyMembers)
				{
					tableComponent.addRow(ColorUtil.prependColorTag(member, Color.RED), "");
				}
			}
		}

		panelComponent.getChildren().add(tableComponent);

		return panel.render(graphics);
	}
}
