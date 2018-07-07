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
	@Import("It's coming home")
	int getWorldMapX();

	@Import("It's coming home")
	int getWorldMapY();

	@Import("It's coming home")
	float getWorldMapZoom();

	@Import("It's coming home")
	int getWorldMapTargetX();

	@Import("It's coming home")
	int getWorldMapTargetY();

	@Import("It's coming home")
	int getWorldMapDisplayWidth();

	@Import("It's coming home")
	int getWorldMapDisplayHeight();

	@Import("It's coming home")
	int getWorldMapDisplayX();

	@Import("It's coming home")
	int getWorldMapDisplayY();

	@Import("It's coming home")
	void setWorldMapPosition(int worldMapX, int worldMapY, boolean changedSurface);

	@Import("It's coming home")
	void setWorldMapPositionTarget(int worldPointX, int worldPointY);

	@Import("It's coming home")
	@Override
	RSWorldMapManager getWorldMapManager();

	@Import("It's coming home")
	@Override
	void initializeWorldMap(WorldMapData var1);

	@Import("It's coming home")
	@Override
	RSWorldMapData getWorldMapData();
}
