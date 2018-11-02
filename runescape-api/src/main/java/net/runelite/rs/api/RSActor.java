/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.rs.api;

import net.runelite.api.Actor;
import net.runelite.mapping.Import;

public interface RSActor extends RSRenderable, Actor
{
	@Import("interacting")
	int getRSInteracting();

	@Import("overhead")
	@Override
	String getOverheadText();

	@Import("overhead")
	@Override
	void setOverheadText(String overheadText);

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("pathX")
	int[] getPathX();

	@Import("pathY")
	int[] getPathY();

	@Import("animation")
	@Override
	int getAnimation();

	@Import("animation")
	@Override
	void setAnimation(int animation);

	@Import("graphic")
	@Override
	int getGraphic();

	@Import("graphic")
	@Override
	void setGraphic(int graphic);

	@Import("combatInfoList")
	RSCombatInfoList getCombatInfoList();

	@Import("orientation")
	@Override
	int getOrientation();

	@Import("logicalHeight")
	@Override
	int getLogicalHeight();

	@Import("idlePoseAnimation")
	@Override
	void setIdlePoseAnimation(int animation);

	@Import("poseAnimation")
	@Override
	void setPoseAnimation(int animation);

	@Import("actionFrame")
	int getActionFrame();

	@Import("actionFrame")
	@Override
	void setActionFrame(int frame);

	@Import("actionFrameCycle")
	int getActionFrameCycle();

	@Import("poseFrame")
	int getPoseFrame();

	@Import("poseFrame")
	void setPoseFrame(int frame);

	@Import("poseFrameCycle")
	int getPoseFrameCycle();

	@Import("spotAnimFrame")
	int getSpotAnimFrame();

	@Import("spotAnimFrame")
	@Override
	void setSpotAnimFrame(int frame);

	@Import("spotAnimFrameCycle")
	int getSpotAnimFrameCycle();

	@Import("hitsplatValues")
	int[] getHitsplatValues();

	@Import("hitsplatTypes")
	int[] getHitsplatTypes();

	@Import("hitsplatCycles")
	int[] getHitsplatCycles();
}
