/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import net.runelite.api.RenderOverview;
import net.runelite.api.WorldMapData;
import net.runelite.mapping.Import;

public interface RSRenderOverview extends RenderOverview
{
	@Import("worldMapX")
	int getWorldMapX();

	@Import("worldMapY")
	int getWorldMapY();

	@Import("worldMapZoom")
	float getWorldMapZoom();

	@Import("worldMapTargetX")
	int getWorldMapTargetX();

	@Import("worldMapTargetY")
	int getWorldMapTargetY();

	@Import("worldMapDisplayWidth")
	int getWorldMapDisplayWidth();

	@Import("worldMapDisplayHeight")
	int getWorldMapDisplayHeight();

	@Import("worldMapDisplayX")
	int getWorldMapDisplayX();

	@Import("worldMapDisplayY")
	int getWorldMapDisplayY();

	@Import("setWorldMapPosition")
	void setWorldMapPosition(int worldMapX, int worldMapY, boolean changedSurface);

	@Import("setWorldMapPositionTargetWorldPoint")
	void setWorldMapPositionTarget(int worldPointX, int worldPointY);

	@Import("worldMapManager")
	@Override
	RSWorldMapManager getWorldMapManager();

	@Import("initializeWorldMap")
	@Override
	void initializeWorldMap(WorldMapData var1);

	@Import("worldMapData")
	@Override
	RSWorldMapData getWorldMapData();
}
