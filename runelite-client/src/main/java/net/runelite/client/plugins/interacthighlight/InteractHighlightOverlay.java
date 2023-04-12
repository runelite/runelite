/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.interacthighlight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.outline.ModelOutlineRenderer;
import net.runelite.client.util.ColorUtil;

class InteractHighlightOverlay extends Overlay
{
	private static final Color INTERACT_CLICK_COLOR = new Color(0x90ffffff);

	private final Client client;
	private final InteractHighlightPlugin plugin;
	private final InteractHighlightConfig config;
	private final ModelOutlineRenderer modelOutlineRenderer;

	@Inject
	private InteractHighlightOverlay(Client client, InteractHighlightPlugin plugin, InteractHighlightConfig config, ModelOutlineRenderer modelOutlineRenderer)
	{
		this.client = client;
		this.plugin = plugin;
		this.config = config;
		this.modelOutlineRenderer = modelOutlineRenderer;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		renderMouseover();
		renderTarget();
		return null;
	}

	private void renderMouseover()
	{
		MenuEntry[] menuEntries = client.getMenuEntries();
		if (menuEntries.length == 0)
		{
			return;
		}

		MenuEntry entry = client.isMenuOpen() ? hoveredMenuEntry(menuEntries) : menuEntries[menuEntries.length - 1];
		MenuAction menuAction = entry.getType();

		switch (menuAction)
		{
			case WIDGET_TARGET_ON_GAME_OBJECT:
			case GAME_OBJECT_FIRST_OPTION:
			case GAME_OBJECT_SECOND_OPTION:
			case GAME_OBJECT_THIRD_OPTION:
			case GAME_OBJECT_FOURTH_OPTION:
			case GAME_OBJECT_FIFTH_OPTION:
			case EXAMINE_OBJECT:
			{
				int x = entry.getParam0();
				int y = entry.getParam1();
				int id = entry.getIdentifier();
				TileObject tileObject = plugin.findTileObject(x, y, id);
				if (tileObject != null && config.objectShowHover() && (tileObject != plugin.getInteractedObject() || !config.objectShowInteract()))
				{
					modelOutlineRenderer.drawOutline(tileObject, config.borderWidth(), config.objectHoverHighlightColor(), config.outlineFeather());
				}
				break;
			}
			case WIDGET_TARGET_ON_NPC:
			case NPC_FIRST_OPTION:
			case NPC_SECOND_OPTION:
			case NPC_THIRD_OPTION:
			case NPC_FOURTH_OPTION:
			case NPC_FIFTH_OPTION:
			case EXAMINE_NPC:
			{
				NPC npc = entry.getNpc();
				if (npc != null && config.npcShowHover() && (npc != plugin.getInteractedTarget() || !config.npcShowInteract()))
				{
					Color highlightColor = menuAction == MenuAction.NPC_SECOND_OPTION
						|| menuAction == MenuAction.WIDGET_TARGET_ON_NPC && WidgetInfo.TO_GROUP(client.getSelectedWidget().getId()) == WidgetID.SPELLBOOK_GROUP_ID
						? config.npcAttackHoverHighlightColor() : config.npcHoverHighlightColor();
					modelOutlineRenderer.drawOutline(npc, config.borderWidth(), highlightColor, config.outlineFeather());
				}
				break;
			}
		}
	}

	private void renderTarget()
	{
		TileObject interactedObject = plugin.getInteractedObject();
		if (interactedObject != null && config.objectShowInteract())
		{
			Color clickColor = getClickColor(config.objectHoverHighlightColor(), config.objectInteractHighlightColor(),
				client.getGameCycle() - plugin.getGameCycle());
			modelOutlineRenderer.drawOutline(interactedObject, config.borderWidth(), clickColor, config.outlineFeather());
		}

		Actor target = plugin.getInteractedTarget();
		if (target instanceof NPC && config.npcShowInteract())
		{
			Color startColor = plugin.isAttacked() ? config.npcAttackHoverHighlightColor() : config.npcHoverHighlightColor();
			Color endColor = plugin.isAttacked() ? config.npcAttackHighlightColor() : config.npcInteractHighlightColor();
			Color clickColor = getClickColor(startColor, endColor,
				client.getGameCycle() - plugin.getGameCycle());
			modelOutlineRenderer.drawOutline((NPC) target, config.borderWidth(), clickColor, config.outlineFeather());
		}
	}

	private Color getClickColor(Color start, Color end, long time)
	{
		if (time < 5)
		{
			return ColorUtil.colorLerp(start, INTERACT_CLICK_COLOR, time / 5f);
		}
		else if (time < 10)
		{
			return ColorUtil.colorLerp(INTERACT_CLICK_COLOR, end, (time - 5) / 5f);
		}
		return end;
	}

	private MenuEntry hoveredMenuEntry(final MenuEntry[] menuEntries)
	{
		final int menuX = client.getMenuX();
		final int menuY = client.getMenuY();
		final int menuWidth = client.getMenuWidth();
		final Point mousePosition = client.getMouseCanvasPosition();

		int dy = mousePosition.getY() - menuY;
		dy -= 19; // Height of Choose Option
		if (dy < 0)
		{
			return menuEntries[menuEntries.length - 1];
		}

		int idx = dy / 15; // Height of each menu option
		idx = menuEntries.length - 1 - idx;

		if (mousePosition.getX() > menuX && mousePosition.getX() < menuX + menuWidth
			&& idx >= 0 && idx < menuEntries.length)
		{
			return menuEntries[idx];
		}
		return menuEntries[menuEntries.length - 1];
	}
}
