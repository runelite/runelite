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

import java.util.Set;
import net.runelite.api.GameObject;
import net.runelite.api.Model;
import net.runelite.api.Projection;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.SceneTileModel;
import net.runelite.api.SceneTilePaint;
import net.runelite.api.Texture;
import net.runelite.api.TileObject;
import net.runelite.api.WorldView;

public interface DrawCallbacks
{
	/**
	 * GPU mode on.
	 */
	int GPU = 0x1;
	/**
	 * GPU hillskew support. Enables the {@link Model#getUnskewedModel()}
	 * API to get the unskewed model.
	 */
	int HILLSKEW = 0x2;
	/**
	 * Requests normals be computed for models. Enables the {@link Model#getVertexNormalsX()}
	 * {@link Model#getVertexNormalsY()} {@link Model#getVertexNormalsZ()} API.
	 */
	int NORMALS = 0x4;
	/**
	 * Disable vertex snapping for animations
	 */
	int NO_VERTEX_SNAPPING = 0x8;
	/**
	 * Enable zbuf renderer.
	 */
	int ZBUF = 0x10;
	/**
	 * Enable the {@link #zoneInFrustum(int, int, int, int)} callback
	 */
	int ZBUF_ZONE_FRUSTUM_CHECK = 0x20;
	/**
	 * Enable the {@link Model#getUnlitFaceColors()} method
	 */
	int UNLIT_FACE_COLORS = 0x40;
	int RENDER_THREADS_MASK = 15;
	int RENDER_THREADS_SHIFT = 7;

	int PASS_OPAQUE = 0;
	int PASS_ALPHA = 1;

	static int RENDER_THREADS(int num)
	{
		return (num & RENDER_THREADS_MASK) << RENDER_THREADS_SHIFT;
	}

	default void draw(Projection projection, Scene scene, Renderable renderable, int orientation, int x, int y, int z, long hash)
	{
	}

	default void drawScenePaint(Scene scene, SceneTilePaint paint, int plane, int tileX, int tileZ)
	{
	}

	default void drawSceneTileModel(Scene scene, SceneTileModel model, int tileX, int tileZ)
	{
	}

	/**
	 * Called when a frame should be drawn.
	 *
	 * @param overlayColor Color of full-viewport overlays, if any
	 */
	void draw(int overlayColor);

	/**
	 * Called before the scene is drawn
	 */
	default void drawScene(double cameraX, double cameraY, double cameraZ, double cameraPitch, double cameraYaw, int plane)
	{
	}

	/**
	 * Called after the scene has been drawn
	 */
	default void postDrawScene()
	{
	}

	default void animate(Texture texture, int diff)
	{
	}

	default void loadScene(Scene scene)
	{
	}

	void swapScene(Scene scene);

	default boolean tileInFrustum(Scene scene, float pitchSin, float pitchCos, float yawSin, float yawCos, int cameraX, int cameraY, int cameraZ, int plane, int msx, int msy)
	{
		return true;
	}

	default boolean zoneInFrustum(int zoneX, int zoneZ, int maxY, int minY)
	{
		return false;
	}

	default void loadScene(WorldView worldView, Scene scene)
	{
	}

	default void despawnWorldView(WorldView worldView)
	{
	}

	default void preSceneDraw(
		Scene scene,
		float cameraX, float cameraY, float cameraZ, float cameraPitch, float cameraYaw,
		int minLevel, int level, int maxLevel, Set<Integer> hideRoofIds)
	{
	}

	default void postSceneDraw(Scene scene)
	{
	}

	default void drawPass(Projection entityProjection, Scene scene, int pass)
	{
	}

	default void drawZoneOpaque(Projection entityProjection, Scene scene, int zx, int zz)
	{
	}

	default void drawZoneAlpha(Projection entityProjection, Scene scene, int level, int zx, int zz)
	{
	}

	default void drawDynamic(Projection worldProjection, Scene scene, TileObject tileObject, Renderable r, Model m, int orient, int x, int y, int z)
	{
	}

	default void drawDynamic(int renderThreadId, Projection worldProjection, Scene scene, TileObject tileObject, Renderable r, Model m, int orient, int x, int y, int z)
	{
		drawDynamic(worldProjection, scene, tileObject, r, m, orient, x, y, z);
	}

	default void drawTemp(Projection worldProjection, Scene scene, GameObject gameObject, Model m, int orient, int x, int y, int z)
	{
	}

	default void invalidateZone(Scene scene, int zx, int zz)
	{
	}
}
