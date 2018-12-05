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
package net.runelite.api.hooks;

import net.runelite.api.Renderable;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Texture;

public interface DrawCallbacks
{
	void draw(Renderable renderable, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash);

	void drawScenePaint(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
						SceneTilePaint paint, int tileZ, int tileX, int tileY,
						int zoom, int centerX, int centerY);


	void drawSceneModel(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z,
						SceneTileModel model, int tileZ, int tileX, int tileY,
						int zoom, int centerX, int centerY);

	void draw();

	void drawScene(int cameraX, int cameraY, int cameraZ, int cameraPitch, int cameraYaw, int plane);

	void animate(Texture texture, int diff);
}
