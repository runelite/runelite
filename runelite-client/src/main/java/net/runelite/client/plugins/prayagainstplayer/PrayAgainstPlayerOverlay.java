/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
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

package net.runelite.client.plugins.prayagainstplayer;

import net.runelite.api.Client;
import net.runelite.api.ItemComposition;
import net.runelite.api.Player;
import net.runelite.api.kit.KitType;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.util.Text;
import net.runelite.api.Point;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

class PrayAgainstPlayerOverlay extends Overlay {

	private final PrayAgainstPlayerPlugin plugin;
	private final PrayAgainstPlayerConfig config;
	private final Client client;

	@Inject
	private PrayAgainstPlayerOverlay(PrayAgainstPlayerPlugin plugin, PrayAgainstPlayerConfig config, Client client) {
		super(plugin);
		this.plugin = plugin;
		this.config = config;
		this.client = client;

		setLayer(OverlayLayer.ABOVE_SCENE);
		setPosition(OverlayPosition.DYNAMIC);
		setPriority(OverlayPriority.HIGH);
	}


	@Override
	public Dimension render(Graphics2D graphics) {
		renderPotentialPlayers(graphics);
		renderAttackingPlayers(graphics);
		return null;
	}

	private void renderPotentialPlayers(Graphics2D graphics) {
		if (plugin.getPotentialPlayersAttackingMe() == null || !plugin.getPotentialPlayersAttackingMe().isEmpty()) {
			try {
				for (PlayerContainer container : plugin.getPotentialPlayersAttackingMe()) {
					if ((System.currentTimeMillis() > (container.getWhenTheyAttackedMe() + container.getMillisToExpireHighlight())) && (container.getPlayer().getInteracting() != client.getLocalPlayer())) {
						plugin.removePlayerFromPotentialContainer(container);
					}
					if (config.drawPotentialTargetsName()) renderNameAboveHead(graphics, container.getPlayer(), config.potentialPlayerColor());
					if (config.drawPotentialTargetHighlight()) renderHighlightedPlayer(graphics, container.getPlayer(), config.potentialPlayerColor());
					if (config.drawPotentialTargetTile()) renderTileUnderPlayer(graphics, container.getPlayer(), config.potentialPlayerColor());
					if (config.drawPotentialTargetPrayAgainst()) renderPrayAgainstOnPlayer(graphics, container.getPlayer(), config.potentialPlayerColor());
				}
			} catch (ConcurrentModificationException e) {
			}
		}
	}

	private void renderAttackingPlayers(Graphics2D graphics) {
		if (plugin.getPlayersAttackingMe() == null || !plugin.getPlayersAttackingMe().isEmpty()) {
			try {
				for (PlayerContainer container : plugin.getPlayersAttackingMe()) {
					if ((System.currentTimeMillis() > (container.getWhenTheyAttackedMe() + container.getMillisToExpireHighlight())) && (container.getPlayer().getInteracting() != client.getLocalPlayer())) {
						plugin.removePlayerFromAttackerContainer(container);
					}

					if (config.drawTargetsName()) renderNameAboveHead(graphics, container.getPlayer(), config.attackerPlayerColor());
					if (config.drawTargetHighlight()) renderHighlightedPlayer(graphics, container.getPlayer(), config.attackerPlayerColor());
					if (config.drawTargetTile()) renderTileUnderPlayer(graphics, container.getPlayer(), config.attackerPlayerColor());
					if (config.drawTargetPrayAgainst()) renderPrayAgainstOnPlayer(graphics, container.getPlayer(), config.attackerPlayerColor());
				}
			} catch (ConcurrentModificationException e) {
			}
		}
	}

	private void renderNameAboveHead(Graphics2D graphics, Player player, Color color) {
		final String name = Text.sanitize(player.getName());
		final int offset = player.getLogicalHeight() + 40;
		Point textLocation = player.getCanvasTextLocation(graphics, name, offset);
		if (textLocation != null) {
			OverlayUtil.renderTextLocation(graphics, textLocation, name, color);
		}
	}

	private void renderHighlightedPlayer(Graphics2D graphics, Player player, Color color) {
		try {
			OverlayUtil.renderPolygon(graphics, player.getConvexHull(), color);
		} catch (NullPointerException e) {
		}
	}

	private void renderTileUnderPlayer(Graphics2D graphics, Player player, Color color) {
		Polygon poly = player.getCanvasTilePoly();
		OverlayUtil.renderPolygon(graphics, poly, color);
	}

	private void renderPrayAgainstOnPlayer(Graphics2D graphics, Player player, Color color) {
		final int offset = (player.getLogicalHeight() / 2) + 75;
		BufferedImage icon;

		switch (WeaponType.checkWeaponOnPlayer(client, player)) {
			case WEAPON_MELEE:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_MELEE);
				break;
			case WEAPON_MAGIC:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_MAGIC);
				break;
			case WEAPON_RANGED:
				icon = plugin.getProtectionIcon(WeaponType.WEAPON_RANGED);
				break;
			default:
				icon = null;
				break;
		}
		try {
			if (icon != null) {
				Point point = player.getCanvasImageLocation(icon, offset);
				OverlayUtil.renderImageLocation(graphics, point, icon);
			} else {
				if (config.drawUnknownWeapons()) {
					int itemId = player.getPlayerComposition().getEquipmentId(KitType.WEAPON);
					ItemComposition itemComposition = client.getItemDefinition(itemId);

					final String str = itemComposition.getName().toUpperCase();
					Point point = player.getCanvasTextLocation(graphics, str, offset);
					OverlayUtil.renderTextLocation(graphics, point, str, color);
				}
			}
		} catch (Exception e) {
		}
	}

}
