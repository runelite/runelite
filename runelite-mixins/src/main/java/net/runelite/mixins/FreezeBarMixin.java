/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package net.runelite.mixins;

import net.runelite.api.FreezeInfo;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSCombatInfo1;
import net.runelite.rs.api.RSCombatInfo2;
import net.runelite.rs.api.RSCombatInfoListHolder;
import net.runelite.rs.api.RSNPC;
import net.runelite.rs.api.RSNPCComposition;

@Mixin(RSClient.class)
public abstract class FreezeBarMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;


	@Copy("draw2DExtras")
	public static final void rs$draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		throw new RuntimeException();
	}

	@Replace("draw2DExtras")
	public static final void rl$draw2DExtras(RSActor actor, int var1, int var2, int var3, int var4, int var5)
	{
		if (actor != null)
		{
			FreezeInfo freezeInfo = actor.getFreeze();

			if (actor.hasComposition() && freezeInfo != null && (freezeInfo.isFrozen() || freezeInfo.isImmune() || freezeInfo.hasQueued()))
			{
				if (actor instanceof RSNPC)
				{
					RSNPCComposition actorComposition = ((RSNPC) actor).getComposition();

					if (actorComposition == null)
						System.out.println("actorComposition null");

					if (actorComposition.getConfigs() != null)
					{
						actorComposition = actorComposition.transform();
					}

					if (actorComposition == null)
					{
						return;
					}
				}

				int offset = 3;
				int healthScale;

				if (actor.getCombatInfoList() == null)
					System.out.println("getCombatInfoList null");

				if (!actor.getCombatInfoList().isEmpty())
				{
					int height = actor.getLogicalHeight() + 15;
					Point canvasPoint = Perspective.worldToCanvas(client, actor.getX(), actor.getY(), height, client.getPlane());

					for (RSCombatInfoListHolder cbInfoListHolder = (RSCombatInfoListHolder) actor.getCombatInfoList().last(); cbInfoListHolder != null; cbInfoListHolder = (RSCombatInfoListHolder) actor.getCombatInfoList().previous())
					{
						RSCombatInfo1 cbInfo1 = cbInfoListHolder.getCombatInfo1(client.getGameCycle());
						if (cbInfo1 != null)
						{
							RSCombatInfo2 cbInfo2 = cbInfoListHolder.getCombatInfo2();

							if (cbInfo2 == null)
								System.out.println("cbInfo2 null");

							healthScale = cbInfo2.getHealthScale();

							int x;
							int y;

							x = var2 + canvasPoint.getX() - (healthScale >> 1);
							y = var3 + canvasPoint.getY() - offset;

							if (canvasPoint.getX() > -1)
							{
								if (freezeInfo == null)
									System.out.println("freezeInfo null");
								if (freezeInfo.isFrozen())
								{
									int width = (int) ((float) freezeInfo.getFrozen() * ((float) healthScale / 32.0f));
									System.out.println(freezeInfo.getFrozen() + " " + width + " " + healthScale);
									int immunityWidth = healthScale - width;
									int immunityStart = x + width;

									client.Rasterizer2D_fillRectangle(x, y - 3, width, 2, 0x36cfe0);
									client.Rasterizer2D_fillRectangle(immunityStart, y - 3, immunityWidth, 2, 0xe09736);
								} else if (freezeInfo.isImmune())
								{
									int width = freezeInfo.getImmune() * (healthScale / 6);

									client.Rasterizer2D_fillRectangle(x, y - 3, width, 2, 0xe09736);
								}
							}
						}
					}
				}
			}
		}

		rs$draw2DExtras(actor, var1, var2, var3, var4, var5);
	}
}
