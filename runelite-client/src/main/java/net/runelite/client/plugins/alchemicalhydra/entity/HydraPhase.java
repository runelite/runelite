/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package net.runelite.client.plugins.alchemicalhydra.entity;

import java.awt.Color;
import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ProjectileID;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SpriteManager;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_1_1;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_1_2;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_2_1;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_2_2;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_3_1;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_3_2;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_4_1;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_4_2;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_FIRE;
import static net.runelite.client.plugins.alchemicalhydra.AlchemicalHydraPlugin.HYDRA_LIGHTNING;
import net.runelite.client.plugins.alchemicalhydra.overlay.AttackOverlay;
import net.runelite.client.util.ImageUtil;

@Getter
@RequiredArgsConstructor
public enum HydraPhase
{
	POISON(3, HYDRA_1_1, HYDRA_1_2, ProjectileID.HYDRA_POISON, 0,
		825, SpriteID.BIG_ASS_GUTHIX_SPELL, new WorldPoint(1371, 10263, 0), Color.GREEN, Color.RED),
	LIGHTNING(3, HYDRA_2_1, HYDRA_2_2, 0, HYDRA_LIGHTNING,
		550, SpriteID.BIG_SPEC_TRANSFER, new WorldPoint(1371, 10272, 0), Color.CYAN, Color.GREEN),
	FLAME(3, HYDRA_3_1, HYDRA_3_2, 0, HYDRA_FIRE,
		275, SpriteID.BIG_SUPERHEAT, new WorldPoint(1362, 10272, 0), Color.RED, Color.CYAN),
	ENRAGED(1, HYDRA_4_1, HYDRA_4_2, ProjectileID.HYDRA_POISON, 0,
		0, SpriteID.BIG_ASS_GUTHIX_SPELL, null, null, null);

	private final int attacksPerSwitch;
	private final int deathAnimation1;
	private final int deathAnimation2;
	private final int specialProjectileId;
	private final int specialAnimationId;
	private final int hpThreshold;

	@Getter(AccessLevel.NONE)
	private final int spriteId;

	private final WorldPoint fountainWorldPoint;

	private final Color phaseColor;
	private final Color fountainColor;

	private BufferedImage specialImage;

	public BufferedImage getSpecialImage(final SpriteManager spriteManager)
	{
		if (specialImage == null)
		{
			final BufferedImage tmp = spriteManager.getSprite(spriteId, 0);
			specialImage = tmp == null ? null : ImageUtil.resizeImage(tmp, AttackOverlay.IMAGE_SIZE, AttackOverlay.IMAGE_SIZE);
		}

		return specialImage;
	}
}
