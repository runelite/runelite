/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.annotations.Component;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.Widget;

@Slf4j
public class WidgetOverlay extends Overlay
{
	public static Collection<WidgetOverlay> createOverlays(final OverlayManager overlayManager, final Client client)
	{
		return Arrays.asList(
			// classic resizable - these are in render order for managed overlay picking
			new WidgetOverlay(client, InterfaceID.ToplevelOsrsStretch.CHAT_CONTAINER, "RESIZABLE_VIEWPORT_CHATBOX_PARENT", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToplevelOsrsStretch.SIDE_MENU, "RESIZABLE_VIEWPORT_INVENTORY_PARENT", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToplevelOsrsStretch.MAP_CONTAINER, "RESIZABLE_MINIMAP_STONES_WIDGET", OverlayPosition.CANVAS_TOP_RIGHT),
			// modern resizable
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.CHAT_CONTAINER, "RESIZABLE_VIEWPORT_BOTTOM_LINE_CHATBOX_PARENT", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.MAP_CONTAINER, "RESIZABLE_MINIMAP_WIDGET", OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.SIDE_STATIC_LAYER, "RESIZABLE_VIEWPORT_BOTTOM_LINE_TABS1", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.SIDE_MOVABLE_LAYER, "RESIZABLE_VIEWPORT_BOTTOM_LINE_TABS2", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.SIDE_CONTAINER, "RESIZABLE_VIEWPORT_BOTTOM_LINE_INVENTORY_PARENT", OverlayPosition.DYNAMIC),
			// The client forces the oxygen bar below the xp tracker, so set its priority lower
			new WidgetOverlay(client, InterfaceID.FossilUnderwater.OXYGEN_LAYER, "FOSSIL_ISLAND_OXYGENBAR", OverlayPosition.TOP_CENTER),
			new XpTrackerWidgetOverlay(overlayManager, client, InterfaceID.XpDrops.CONTAINER,  "EXPERIENCE_TRACKER_WIDGET", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.RaidsOverlay.DATA, "RAIDS_POINTS_INFOBOX", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.TobHud.NAMES_CONTAINER, "TOB_PARTY_INTERFACE", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.TobHud.STATUS_CONTAINER, "TOB_PARTY_STATS", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.GodwarsOverlay.KILLS_LAYER, "GWD_KC", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.HosidiusStripFarming.PANEL, "TITHE_FARM", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.PestLanderOverlay.INFO, "PEST_CONTROL_BOAT_INFO", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.PestStatusOverlay.CONTENT_LEFT, "PEST_CONTROL_KNIGHT_INFO_CONTAINER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.PestStatusOverlay.CONTENT_RIGHT, "PEST_CONTROL_ACTIVITY_SHIELD_INFO_CONTAINER", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.HosidiusServeryHud.CONTENT, "ZEAH_MESS_HALL_COOKING_DISPLAY", OverlayPosition.TOP_LEFT),
			new PvpKDRWidgetOverlay(client, InterfaceID.PvpIcons.KD_CONTAINER, "PVP_KILLDEATH_COUNTER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.CataBoss.CATA_ALTARS, "SKOTIZO_CONTAINER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.NtkOverlay.CONTENT, "PYRAMID_PLUNDER_DATA", OverlayPosition.ABOVE_CHATBOX_RIGHT),
			new WidgetOverlay(client, InterfaceID.BrLobbyoverlay.CONTENT, "LMS_INFO", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.BrOverlay.CONTENT, "LMS_KDA", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.GauntletOverlay.CONTENT, "GAUNTLET_TIMER_CONTAINER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.HallowedOverlay.CONTENT, "HALLOWED_SEPULCHRE_TIMER_CONTAINER", OverlayPosition.TOP_LEFT),
			// The client forces the health overlay bar below the xp tracker, so set its priority lower
			new WidgetOverlay(client, InterfaceID.HpbarHud.HP, "HEALTH_OVERLAY_BAR", OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, InterfaceID.TobHud.PROGRESS_CONTAINER, "TOB_HEALTH_BAR", OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, InterfaceID.NightmareTotems.TOTEMS, "NIGHTMARE_PILLAR_HEALTH", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.FossilVolcanicMine.VENT_CHAMBERS_INFO, "VOLCANIC_MINE_VENTS_INFOBOX_GROUP", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.FossilVolcanicMine.MAIN_INFO, "VOLCANIC_MINE_STABILITY_INFOBOX_GROUP", OverlayPosition.BOTTOM_LEFT),
			new WidgetOverlay(client, InterfaceID.Toplevel.MULTIWAY_ICON, "MULTICOMBAT_FIXED", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.ToplevelPreEoc.MULTIWAY_ICON, "MULTICOMBAT_RESIZABLE_MODERN", OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.ToplevelOsrsStretch.MULTIWAY_ICON, "MULTICOMBAT_RESIZABLE_CLASSIC", OverlayPosition.CANVAS_TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.TemporossHud.STATUS, "TEMPOROSS_STATUS_INDICATOR", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.TemporossLobbyHud.CONTENT, "TEMPOROSS_LOBBY", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.BarbassaultOverHeal.CONTENT_BOTTOM, "BA_HEAL_TEAMMATES", OverlayPosition.BOTTOM_LEFT),
			new WidgetOverlay(client, InterfaceID.BarbassaultOverRecruitPlayerNames.CONTENT, "BA_TEAM", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.PvpIcons.ICONS, "PVP_WILDERNESS_SKULL_CONTAINER", OverlayPosition.DYNAMIC),
			new WidgetOverlay(client, InterfaceID.ToaLobby.CONTENT, "TOA_PARTY_LAYER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.ToaHud.CONTENT, "TOA_RAID_LAYER", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.GotrHud.CONTENT, "GOTR_MAIN_DISPLAY", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.BrewOverlay.CONTENT_RIGHT, "TROUBLE_BREWING_SCORE", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.BrewWaitingRoomOverlay.CONTENTS, "TROUBLE_BREWING_LOBBY", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.FlamtaerStatus.TEMPLE_LAYER, "MORTTON_TEMPLE_STATUS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.BoardgamesDraughtsOverlay.CONTENT, "BGR_RANK_DISPLAY_DRAUGHTS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.BoardgamesRunelinkOverlay.CONTENT, "BGR_RANK_DISPLAY_RUNELINK", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.BoardgamesRunesquaresOverlay.CONTENT, "BGR_RANK_DISPLAY_RUNESQUARES", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.BoardgamesRuneversiOverlay.CONTENT, "BGR_RANK_DISPLAY_RUNEVERSI", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.AgilityarenaOverlay.CONTENT, "AGILITY_ARENA_LIGHT_INDICATOR", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.Gnomeball.CONTENTS, "GNOMEBALL_SCORE", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingAlchem.CONTENTS, "MTA_ALCHEMY_POINTS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingEncha.CONTENT_TOP, "MTA_ENCHANT_POINTS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingEncha.CONTENT_RIGHT, "MTA_ENCHANT_BONUS", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingTele.CONTENT_TOP, "MTA_TELEKINETIC_POINTS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingTele.CONTENT_RIGHT, "MTA_TELEKINETIC_SOLVED", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingGrave.CONTENT_TOP, "MTA_GRAVEYARD_POINTS", OverlayPosition.TOP_RIGHT),
			new WidgetOverlay(client, InterfaceID.MagictrainingGrave.CONTENT_RIGHT, "MTA_GRAVEYARD_VALUES", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.Dt2Infection.OVERLAY, "STRANGLER_INFECTION_OVERLAY", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.Sanity.OVERLAY, "SANITY_OVERLAY", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.PmoonHud.CONTENT, "MOONS_OF_PERIL", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.MotherlodeHud.DATA, "MLM_LAYER", OverlayPosition.TOP_LEFT),
			// Castle Wars Lobby
			new WidgetOverlay(client, InterfaceID.CastlewarsWaitingroom.CONTENT, "CASTLEWARS_LOBBY_TIME_REMAINING", OverlayPosition.TOP_CENTER),
			// Castle Wars Saradomin
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlaySaradomin.CASTLEWARS_SARADOMIN_EJECT, "CASTLEWARS_SARADOMIN_LEAVE_WAITING_ROOM", OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlaySaradomin.TIMER, "CASTLEWARS_SARADOMIN_GAME_TIMER", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlaySaradomin.SIDEBOX, "CASTLEWARS_SARADOMIN_CASTLE_AND_ROCK_GROUP_STATUS", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlaySaradomin.SCORES, "CASTLEWARS_SARADOMIN_SCORE_BOX", OverlayPosition.TOP_CENTER),
			// Castle Wars Zamorak
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlayZamorak.CASTLEWARS_ZAMORAK_EJECT, "CASTLEWARS_ZAMORAK_LEAVE_WAITING_ROOM", OverlayPosition.TOP_CENTER),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlayZamorak.TIMER, "CASTLEWARS_ZAMORAK_GAME_TIMER", OverlayPosition.BOTTOM_RIGHT),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlayZamorak.SIDEBOX, "CASTLEWARS_ZAMORAK_CASTLE_AND_ROCK_GROUP_STATUS", OverlayPosition.TOP_LEFT),
			new WidgetOverlay(client, InterfaceID.CastlewarsStatusOverlayZamorak.SCORES, "CASTLEWARS_ZAMORAK_SCORE_BOX", OverlayPosition.TOP_CENTER)
		);
	}

	protected final Client client;
	@Component
	protected final int componentId;
	protected final String name;
	private final Rectangle parentBounds = new Rectangle();
	private boolean revalidate;

	private WidgetOverlay(final Client client, @Component final int componentId, final String name, final OverlayPosition overlayPosition)
	{
		this(client, componentId, name, overlayPosition, Overlay.PRIORITY_HIGHEST);
	}

	private WidgetOverlay(final Client client, @Component final int componentId, final String name, final OverlayPosition overlayPosition, final float overlayPriority)
	{
		this.client = client;
		this.componentId = componentId;
		this.name = name;
		setPriority(overlayPriority);
		setLayer(OverlayLayer.UNDER_WIDGETS);
		setPosition(overlayPosition);
		setMovable(true);
		setSnappable(true);
		// It's almost possible to drawAfterInterface() here, but that fires
		// *after* the native components are drawn, which is too late.
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Widget widget = client.getWidget(componentId);
		final Rectangle parent = getParentBounds(widget);

		if (parent.isEmpty())
		{
			return null;
		}

		assert widget != null;

		final Rectangle bounds = getBounds();
		// OverlayRenderer sets the overlay bounds to where it would like the overlay to render at prior to calling
		// render(). If the overlay has a preferred location or position set we update the widget position to that.
		if (getPreferredLocation() != null || getPreferredPosition() != null)
		{
			// The widget relative pos is relative to the parent
			widget.setForcedPosition(bounds.x - parent.x, bounds.y - parent.y);
		}
		else
		{
			if (revalidate)
			{
				revalidate = false;
				log.debug("Revalidating {}", name);
				widget.setForcedPosition(-1, -1);
				// Revalidate the widget to reposition it back to its normal location after an overlay reset
				widget.revalidate();
			}

			// Update the overlay bounds to the widget bounds so the drag overlay renders correctly.
			// Note OverlayManager uses original bounds reference to render managing mode and for
			// onMouseOver, so update the existing bounds vs. replacing the reference.
			Rectangle widgetBounds = widget.getBounds();
			bounds.setBounds(widgetBounds.x, widgetBounds.y, widgetBounds.width, widgetBounds.height);
		}

		return new Dimension(widget.getWidth(), widget.getHeight());
	}

	private Rectangle getParentBounds(final Widget widget)
	{
		if (widget == null || widget.isHidden())
		{
			parentBounds.setBounds(new Rectangle());
			return parentBounds;
		}

		final Widget parent = widget.getParent();
		final Rectangle bounds;

		if (parent == null)
		{
			bounds = new Rectangle(client.getRealDimensions());
		}
		else
		{
			bounds = parent.getBounds();
		}

		parentBounds.setBounds(bounds);
		return bounds;
	}

	@Override
	public Rectangle getParentBounds()
	{
		if (!client.isClientThread())
		{
			// During overlay drag this is called on the EDT, so we just
			// cache and reuse the last known parent bounds.
			return parentBounds;
		}

		final Widget widget = client.getWidget(componentId);
		return getParentBounds(widget);
	}

	@Override
	public void revalidate()
	{
		// Revalidate must be called on the client thread, so defer til next frame
		revalidate = true;
	}

	private static class XpTrackerWidgetOverlay extends WidgetOverlay
	{
		private final OverlayManager overlayManager;

		private XpTrackerWidgetOverlay(OverlayManager overlayManager, Client client, @Component int componentId, String name, OverlayPosition overlayPosition)
		{
			super(client, componentId, name, overlayPosition);
			this.overlayManager = overlayManager;
		}

		@Override
		public Dimension render(Graphics2D graphics)
		{
			// The xptracker component layer isn't hidden if the counter and process bar are both configured "Off",
			// it just has its children hidden.
			if (client.getVarbitValue(VarbitID.XPDROPS_COUNTER_TYPE) == 30 // Off
				&& client.getVarbitValue(VarbitID.XPDROPS_PROGRESS_TYPE) == 0) // Off
			{
				return null;
			}

			return super.render(graphics);
		}

		/**
		 * Get the overlay position of the xptracker based on the configured location in-game.
		 *
		 * @return
		 */
		@Override
		public OverlayPosition getPosition()
		{
			if (!client.isClientThread())
			{
				// During overlay drag, getPosition() is called on the EDT, so we just
				// cache and reuse the last known configured position.
				return super.getPosition();
			}

			OverlayPosition position;
			switch (client.getVarbitValue(VarbitID.XPDROPS_POSITION))
			{
				case 0:
				default:
					position = OverlayPosition.TOP_RIGHT;
					break;
				case 1:
					position = OverlayPosition.TOP_CENTER;
					break;
				case 2:
					position = OverlayPosition.TOP_LEFT;
					break;
			}

			if (position != super.getPosition())
			{
				log.debug("Xp tracker moved position");
				setPosition(position);
				overlayManager.rebuildOverlayLayers();
			}
			return position;
		}
	}

	private static class PvpKDRWidgetOverlay extends WidgetOverlay
	{
		private PvpKDRWidgetOverlay(Client client, @Component int componentId, String name, OverlayPosition overlayPosition)
		{
			super(client, componentId, name, overlayPosition);
		}

		@Override
		public Dimension render(Graphics2D graphics)
		{
			// Don't draw widget overlay if the PVP KDR stats text will be empty
			if (client.getVarbitValue(VarbitID.KD_TOGGLE) == 1)
			{
				return super.render(graphics);
			}

			return null;
		}
	}
}
