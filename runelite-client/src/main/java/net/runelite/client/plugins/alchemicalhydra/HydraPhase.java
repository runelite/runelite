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
package net.runelite.client.plugins.alchemicalhydra;

import java.awt.image.BufferedImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.AnimationID;
import net.runelite.api.ProjectileID;
import net.runelite.api.SpriteID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.util.ImageUtil;

@Getter(AccessLevel.PACKAGE)
@RequiredArgsConstructor
enum HydraPhase
{
	ONE(3, AnimationID.HYDRA_1_1, AnimationID.HYDRA_1_2, ProjectileID.HYDRA_POISON, 0, SpriteID.BIG_ASS_GUTHIX_SPELL, new WorldPoint(1371, 10263, 0)),
	TWO(3, AnimationID.HYDRA_2_1, AnimationID.HYDRA_2_2, 0, AnimationID.HYDRA_LIGHTNING, SpriteID.BIG_SPEC_TRANSFER, new WorldPoint(1371, 10272, 0)),
	THREE(3, AnimationID.HYDRA_3_1, AnimationID.HYDRA_3_2, 0, AnimationID.HYDRA_FIRE, SpriteID.BIG_SUPERHEAT, new WorldPoint(1362, 10272, 0)),
	FOUR(1, AnimationID.HYDRA_4_1, AnimationID.HYDRA_4_2, ProjectileID.HYDRA_POISON, 0, SpriteID.BIG_ASS_GUTHIX_SPELL, null);

	private final int attacksPerSwitch;
	private final int deathAnim1;
	private final int deathAnim2;
	private final int specProjectileId;
	private final int specAnimationId;

	@Getter(AccessLevel.NONE)
	private final int specImageID;
	private final WorldPoint fountain;

	private BufferedImage specImage;

	BufferedImage getSpecImage(SpriteManager spriteManager)
	{
		if (specImage == null)
		{
			BufferedImage tmp = spriteManager.getSprite(specImageID, 0);
			specImage = tmp == null ? null : ImageUtil.resizeImage(tmp, HydraOverlay.IMGSIZE, HydraOverlay.IMGSIZE);
		}

		return specImage;
	}
}