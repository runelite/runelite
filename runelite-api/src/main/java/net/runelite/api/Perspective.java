/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.api;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import static net.runelite.api.Constants.EXTENDED_SCENE_SIZE;
import static net.runelite.api.Constants.TILE_FLAG_BRIDGE;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.geometry.RectangleUnion;
import net.runelite.api.geometry.Shapes;
import net.runelite.api.geometry.SimplePolygon;
import net.runelite.api.model.Jarvis;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import org.jetbrains.annotations.ApiStatus;

/**
 * A utility class containing methods to help with conversion between
 * in-game features to canvas areas.
 */
public class Perspective
{
	public static final double UNIT = Math.PI / 1024d; // How much of the circle each unit of SINE/COSINE is

	public static final int LOCAL_COORD_BITS = 7;
	public static final int LOCAL_TILE_SIZE = 1 << LOCAL_COORD_BITS; // 128 - size of a tile in local coordinates
	public static final int LOCAL_HALF_TILE_SIZE = LOCAL_TILE_SIZE / 2;

	public static final int SCENE_SIZE = Constants.SCENE_SIZE; // in tiles

	public static final int[] SINE = new int[2048]; // sine angles for each of the 2048 units, * 65536 and stored as an int
	public static final int[] COSINE = new int[2048]; // cosine

	private static final int ESCENE_OFFSET = (Constants.EXTENDED_SCENE_SIZE - Constants.SCENE_SIZE) / 2;

	static
	{
		for (int i = 0; i < 2048; ++i)
		{
			SINE[i] = (int) (65536.0D * Math.sin((double) i * UNIT));
			COSINE[i] = (int) (65536.0D * Math.cos((double) i * UNIT));
		}
	}

	/**
	 * Translates two-dimensional ground coordinates within the 3D world to
	 * their corresponding coordinates on the game screen.
	 *
	 * @param client the game client
	 * @param point ground coordinate
	 * @param plane ground plane on the z axis
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	@Nullable
	public static Point localToCanvas(@Nonnull Client client, @Nonnull LocalPoint point, int plane)
	{
		return localToCanvas(client, point, plane, 0);
	}

	/**
	 * Translates two-dimensional ground coordinates within the 3D world to
	 * their corresponding coordinates on the game screen.
	 *
	 * @param client the game client
	 * @param point ground coordinate
	 * @param plane ground plane on the z axis
	 * @param zOffset distance from ground on the z axis
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	@Nullable
	public static Point localToCanvas(@Nonnull Client client, @Nonnull LocalPoint point, int plane, int zOffset)
	{
		final int tileHeight = getTileHeight(client, point, plane);
		return localToCanvas(client, point.getX(), point.getY(), tileHeight - zOffset);
	}

	/**
	 * Translates three-dimensional local coordinates within the 3D world to
	 * their corresponding coordinates on the game screen.
	 *
	 * @param client the game client
	 * @param x ground coordinate on the x axis
	 * @param y ground coordinate on the y axis
	 * @param z
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	public static Point localToCanvas(@Nonnull Client client, int x, int y, int z)
	{
		return client.isGpu() ? localToCanvasGpu(client, x, y, z) : localToCanvasCpu(client, x, y, z);
	}

	private static Point localToCanvasCpu(Client client, int x, int y, int z)
	{
		if (x >= -ESCENE_OFFSET << LOCAL_COORD_BITS && y >= -ESCENE_OFFSET << LOCAL_COORD_BITS &&
			x <= SCENE_SIZE + ESCENE_OFFSET << LOCAL_COORD_BITS && y <= SCENE_SIZE + ESCENE_OFFSET << LOCAL_COORD_BITS)
		{
			x -= client.getCameraX();
			y -= client.getCameraY();
			z -= client.getCameraZ();

			final int cameraPitch = client.getCameraPitch();
			final int cameraYaw = client.getCameraYaw();

			final int pitchSin = SINE[cameraPitch];
			final int pitchCos = COSINE[cameraPitch];
			final int yawSin = SINE[cameraYaw];
			final int yawCos = COSINE[cameraYaw];

			final int
				x1 = x * yawCos + y * yawSin >> 16,
				y1 = y * yawCos - x * yawSin >> 16,
				y2 = z * pitchCos - y1 * pitchSin >> 16,
				z1 = y1 * pitchCos + z * pitchSin >> 16;

			if (z1 >= 50)
			{
				final int scale = client.getScale();
				final int pointX = client.getViewportWidth() / 2 + x1 * scale / z1;
				final int pointY = client.getViewportHeight() / 2 + y2 * scale / z1;
				return new Point(
					pointX + client.getViewportXOffset(),
					pointY + client.getViewportYOffset()
				);
			}
		}

		return null;
	}

	private static Point localToCanvasGpu(Client client, int x, int y, int z)
	{
		if (x >= -ESCENE_OFFSET << LOCAL_COORD_BITS && y >= -ESCENE_OFFSET << LOCAL_COORD_BITS &&
			x <= SCENE_SIZE + ESCENE_OFFSET << LOCAL_COORD_BITS && y <= SCENE_SIZE + ESCENE_OFFSET << LOCAL_COORD_BITS)
		{
			final double
				cameraPitch = client.getCameraFpPitch(),
				cameraYaw = client.getCameraFpYaw();

			final float
				fx = x - (float) client.getCameraFpX(),
				fy = y - (float) client.getCameraFpY(),
				fz = z - (float) client.getCameraFpZ(),
				pitchSin = (float) Math.sin(cameraPitch),
				pitchCos = (float) Math.cos(cameraPitch),
				yawSin = (float) Math.sin(cameraYaw),
				yawCos = (float) Math.cos(cameraYaw);

			final float
				x1 = fx * yawCos + fy * yawSin,
				y1 = fy * yawCos - fx * yawSin,
				y2 = fz * pitchCos - y1 * pitchSin,
				z1 = y1 * pitchCos + fz * pitchSin;

			if (z1 >= 50f)
			{
				final int scale = client.getScale();
				final int pointX = Math.round(client.getViewportWidth() / 2f + x1 * scale / z1);
				final int pointY = Math.round(client.getViewportHeight() / 2f + y2 * scale / z1);
				return new Point(
					pointX + client.getViewportXOffset(),
					pointY + client.getViewportYOffset()
				);
			}
		}

		return null;
	}

	/**
	 * Translates a model's vertices into 2d space.
	 */
	public static void modelToCanvas(Client client, int end, int x3dCenter, int y3dCenter, int z3dCenter, int rotate, float[] x3d, float[] y3d, float[] z3d, int[] x2d, int[] y2d)
	{
		// There is a separate implementation for GPU since GPU uses a slightly more precise projection that can
		// cause features like model outlines being noticeably off otherwise.
		if (client.isGpu())
		{
			modelToCanvasGpu(client, end, x3dCenter, y3dCenter, z3dCenter, rotate, x3d, y3d, z3d, x2d, y2d);
		}
		else
		{
			modelToCanvasCpu(client, end, x3dCenter, y3dCenter, z3dCenter, rotate, x3d, y3d, z3d, x2d, y2d);
		}
	}

	private static void modelToCanvasGpu(Client client, int end, int x3dCenter, int y3dCenter, int z3dCenter, int rotate, float[] x3d, float[] y3d, float[] z3d, int[] x2d, int[] y2d)
	{
		final double
			cameraPitch = client.getCameraFpPitch(),
			cameraYaw = client.getCameraFpYaw();
		final float
			pitchSin = (float) Math.sin(cameraPitch),
			pitchCos = (float) Math.cos(cameraPitch),
			yawSin = (float) Math.sin(cameraYaw),
			yawCos = (float) Math.cos(cameraYaw),
			rotateSin = SINE[rotate] / 65536.0f,
			rotateCos = COSINE[rotate] / 65536.0f,

			cx = x3dCenter - (float) client.getCameraFpX(),
			cy = y3dCenter - (float) client.getCameraFpY(),
			cz = z3dCenter - (float) client.getCameraFpZ(),

			viewportXMiddle = client.getViewportWidth() / 2f,
			viewportYMiddle = client.getViewportHeight() / 2f,
			viewportXOffset = client.getViewportXOffset(),
			viewportYOffset = client.getViewportYOffset(),

			zoom3d = client.getScale();

		for (int i = 0; i < end; i++)
		{
			float x = x3d[i];
			float y = y3d[i];
			float z = z3d[i];

			if (rotate != 0)
			{
				float x0 = x;
				x = x0 * rotateCos + y * rotateSin;
				y = y * rotateCos - x0 * rotateSin;
			}

			x += cx;
			y += cy;
			z += cz;

			final float
				x1 = x * yawCos + y * yawSin,
				y1 = y * yawCos - x * yawSin,
				y2 = z * pitchCos - y1 * pitchSin,
				z1 = y1 * pitchCos + z * pitchSin;

			int viewX, viewY;

			if (z1 < 50)
			{
				viewX = Integer.MIN_VALUE;
				viewY = Integer.MIN_VALUE;
			}
			else
			{
				viewX = Math.round((viewportXMiddle + x1 * zoom3d / z1) + viewportXOffset);
				viewY = Math.round((viewportYMiddle + y2 * zoom3d / z1) + viewportYOffset);
			}

			x2d[i] = viewX;
			y2d[i] = viewY;
		}
	}

	private static void modelToCanvasCpu(Client client, int end, int x3dCenter, int y3dCenter, int z3dCenter, int rotate, float[] x3d, float[] y3d, float[] z3d, int[] x2d, int[] y2d)
	{
		final int
			cameraPitch = client.getCameraPitch(),
			cameraYaw = client.getCameraYaw(),

			pitchSin = SINE[cameraPitch],
			pitchCos = COSINE[cameraPitch],
			yawSin = SINE[cameraYaw],
			yawCos = COSINE[cameraYaw],
			rotateSin = SINE[rotate],
			rotateCos = COSINE[rotate],

			cx = x3dCenter - client.getCameraX(),
			cy = y3dCenter - client.getCameraY(),
			cz = z3dCenter - client.getCameraZ(),

			viewportXMiddle = client.getViewportWidth() / 2,
			viewportYMiddle = client.getViewportHeight() / 2,
			viewportXOffset = client.getViewportXOffset(),
			viewportYOffset = client.getViewportYOffset(),

			zoom3d = client.getScale();

		for (int i = 0; i < end; i++)
		{
			int x = (int) x3d[i];
			int y = (int) y3d[i];
			int z = (int) z3d[i];

			if (rotate != 0)
			{
				int x0 = x;
				x = x0 * rotateCos + y * rotateSin >> 16;
				y = y * rotateCos - x0 * rotateSin >> 16;
			}

			x += cx;
			y += cy;
			z += cz;

			final int
				x1 = x * yawCos + y * yawSin >> 16,
				y1 = y * yawCos - x * yawSin >> 16,
				y2 = z * pitchCos - y1 * pitchSin >> 16,
				z1 = y1 * pitchCos + z * pitchSin >> 16;

			int viewX, viewY;

			if (z1 < 50)
			{
				viewX = Integer.MIN_VALUE;
				viewY = Integer.MIN_VALUE;
			}
			else
			{
				viewX = (viewportXMiddle + x1 * zoom3d / z1) + viewportXOffset;
				viewY = (viewportYMiddle + y2 * zoom3d / z1) + viewportYOffset;
			}

			x2d[i] = viewX;
			y2d[i] = viewY;
		}
	}

	/**
	 * Translates two-dimensional ground coordinates within the 3D world to
	 * their corresponding coordinates on the Minimap.
	 *
	 * @param client the game client
	 * @param point ground coordinate
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	@Nullable
	public static Point localToMinimap(@Nonnull Client client, @Nonnull LocalPoint point)
	{
		// client uses square(distance/32) < 6400 for distance.
		// convert to local coords via sqrt(6400) * 32 = 20 tiles
		final int r = 20 << LOCAL_COORD_BITS;
		// then scale based on pixels per tile
		final double s = 4d / client.getMinimapZoom();
		return localToMinimap(client, point, (int) (r * s));
	}

	/**
	 * Translates two-dimensional ground coordinates within the 3D world to
	 * their corresponding coordinates on the Minimap.
	 *
	 * @param client the game client
	 * @param point ground coordinate
	 * @param distance max distance from local player to minimap point
	 * @return a {@link Point} on screen corresponding to the position in
	 * 3D-space
	 */
	@Nullable
	public static Point localToMinimap(@Nonnull Client client, @Nonnull LocalPoint point, int distance)
	{
		LocalPoint localLocation = client.getLocalPlayer().getLocalLocation();
		final int dx = point.getX() - localLocation.getX();
		final int dy = point.getY() - localLocation.getY();

		if (dx * dx + dy * dy < distance * distance)
		{
			Widget minimapDrawWidget;
			if (client.isResized())
			{
				if (client.getVarbitValue(Varbits.SIDE_PANELS) == 1)
				{
					minimapDrawWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_DRAW_AREA);
				}
				else
				{
					minimapDrawWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_STONES_DRAW_AREA);
				}
			}
			else
			{
				minimapDrawWidget = client.getWidget(WidgetInfo.FIXED_VIEWPORT_MINIMAP_DRAW_AREA);
			}

			if (minimapDrawWidget == null || minimapDrawWidget.isHidden())
			{
				return null;
			}

			final double zoom = client.getMinimapZoom() / LOCAL_TILE_SIZE;
			final int x = (int) (dx * zoom);
			final int y = (int) (dy * zoom);

			final int angle = client.getCameraYawTarget() & 0x7FF;

			final int sin = SINE[angle];
			final int cos = COSINE[angle];

			final int rx = cos * x + sin * y >> 16;
			final int ry = sin * x - cos * y >> 16;

			Point loc = minimapDrawWidget.getCanvasLocation();
			int miniMapX = loc.getX() + minimapDrawWidget.getWidth() / 2 + rx;
			int miniMapY = loc.getY() + minimapDrawWidget.getHeight() / 2 + ry;
			return new Point(miniMapX, miniMapY);
		}

		return null;
	}

	/**
	 * Calculates the above ground height of a tile point.
	 *
	 * @param client the game client
	 * @param point the local ground coordinate
	 * @param plane the client plane/ground level
	 * @return the offset from the ground of the tile
	 */
	public static int getTileHeight(@Nonnull Client client, @Nonnull LocalPoint point, int plane)
	{
		int sceneX = point.getSceneX();
		int sceneY = point.getSceneY();
		if (sceneX >= 0 && sceneY >= 0 && sceneX < SCENE_SIZE && sceneY < SCENE_SIZE)
		{
			var wv = client.getWorldView(point.getWorldView());
			byte[][][] tileSettings = wv.getTileSettings();
			int[][][] tileHeights = wv.getTileHeights();

			int z1 = plane;
			if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & TILE_FLAG_BRIDGE) == TILE_FLAG_BRIDGE)
			{
				z1 = plane + 1;
			}

			int x = point.getX() & (LOCAL_TILE_SIZE - 1);
			int y = point.getY() & (LOCAL_TILE_SIZE - 1);
			int var8 = x * tileHeights[z1][sceneX + 1][sceneY] + (LOCAL_TILE_SIZE - x) * tileHeights[z1][sceneX][sceneY] >> LOCAL_COORD_BITS;
			int var9 = tileHeights[z1][sceneX][sceneY + 1] * (LOCAL_TILE_SIZE - x) + x * tileHeights[z1][sceneX + 1][sceneY + 1] >> LOCAL_COORD_BITS;
			return (LOCAL_TILE_SIZE - y) * var8 + y * var9 >> LOCAL_COORD_BITS;
		}

		return 0;
	}

	/**
	 * Get the height of a location, in local coordinates. Interpolates the height from the adjacent tiles.
	 * Does not account for bridges.
	 * @return
	 */
	private static int getHeight(@Nonnull Scene scene, int localX, int localY, int plane)
	{
		int sceneX = (localX >> LOCAL_COORD_BITS) + ESCENE_OFFSET;
		int sceneY = (localY >> LOCAL_COORD_BITS) + ESCENE_OFFSET;
		if (sceneX >= 0 && sceneY >= 0 && sceneX < Constants.EXTENDED_SCENE_SIZE && sceneY < Constants.EXTENDED_SCENE_SIZE)
		{
			int[][][] tileHeights = scene.getTileHeights();

			int x = localX & (LOCAL_TILE_SIZE - 1);
			int y = localY & (LOCAL_TILE_SIZE - 1);
			int var8 = x * tileHeights[plane][sceneX + 1][sceneY] + (LOCAL_TILE_SIZE - x) * tileHeights[plane][sceneX][sceneY] >> LOCAL_COORD_BITS;
			int var9 = tileHeights[plane][sceneX][sceneY + 1] * (LOCAL_TILE_SIZE - x) + x * tileHeights[plane][sceneX + 1][sceneY + 1] >> LOCAL_COORD_BITS;
			return (LOCAL_TILE_SIZE - y) * var8 + y * var9 >> LOCAL_COORD_BITS;
		}

		return 0;
	}

	/**
	 * Calculates a tile polygon from offset worldToScreen() points.
	 *
	 * @param client the game client
	 * @param localLocation local location of the tile
	 * @return a {@link Polygon} on screen corresponding to the given
	 * localLocation.
	 */
	public static Polygon getCanvasTilePoly(@Nonnull Client client, @Nonnull LocalPoint localLocation)
	{
		return getCanvasTileAreaPoly(client, localLocation, 1);
	}

	/**
	 * Calculates a tile polygon from offset worldToScreen() points.
	 *
	 * @param client the game client
	 * @param localLocation local location of the tile
	 * @param zOffset offset from ground plane
	 * @return a {@link Polygon} on screen corresponding to the given
	 * localLocation.
	 */
	public static Polygon getCanvasTilePoly(@Nonnull Client client, @Nonnull LocalPoint localLocation, int zOffset)
	{
		return getCanvasTileAreaPoly(client, localLocation, 1, 1, -1, zOffset);
	}

	/**
	 * Returns a polygon representing an area.
	 *
	 * @param client the game client
	 * @param localLocation the center location of the AoE
	 * @param size the size of the area (ie. 3x3 AoE evaluates to size 3)
	 * @return a polygon representing the tiles in the area
	 */
	public static Polygon getCanvasTileAreaPoly(@Nonnull Client client, @Nonnull LocalPoint localLocation, int size)
	{
		return getCanvasTileAreaPoly(client, localLocation, size, size, -1, 0);
	}

	/**
	 * Returns a polygon representing an area.
	 *
	 * @param client the game client
	 * @param localLocation the center location of the AoE
	 * @param sizeX the size of the area in tiles on the x axis
	 * @param sizeY the size of the area in tiles on the y axis
	 * @param plane the plane of the area
	 * @param zOffset offset from ground plane
	 * @return a polygon representing the tiles in the area
	 */
	public static Polygon getCanvasTileAreaPoly(
		@Nonnull Client client,
		@Nonnull LocalPoint localLocation,
		int sizeX,
		int sizeY,
		int plane,
		int zOffset)
	{
		final int msx = localLocation.getSceneX() + ESCENE_OFFSET;
		final int msy = localLocation.getSceneY() + ESCENE_OFFSET;
		final var wv = client.getWorldView(localLocation.getWorldView());

		if (msx < 0 || msy < 0 || msx >= EXTENDED_SCENE_SIZE || msy >= EXTENDED_SCENE_SIZE || wv == null)
		{
			// out of scene
			return null;
		}

		if (plane == -1)
		{
			plane = wv.getPlane();
		}

		var scene = wv.getScene();
		final byte[][][] tileSettings = scene.getExtendedTileSettings();

		int tilePlane = plane;
		if (plane < Constants.MAX_Z - 1 && (tileSettings[1][msx][msy] & TILE_FLAG_BRIDGE) == TILE_FLAG_BRIDGE)
		{
			tilePlane = plane + 1;
		}

		final int swX = localLocation.getX() - (sizeX * LOCAL_TILE_SIZE / 2);
		final int swY = localLocation.getY() - (sizeY * LOCAL_TILE_SIZE / 2);

		final int neX = localLocation.getX() + (sizeX * LOCAL_TILE_SIZE / 2);
		final int neY = localLocation.getY() + (sizeY * LOCAL_TILE_SIZE / 2);

		final int seX = swX;
		final int seY = neY;

		final int nwX = neX;
		final int nwY = swY;

		final int swHeight = getHeight(scene, swX, swY, tilePlane) - zOffset;
		final int nwHeight = getHeight(scene, nwX, nwY, tilePlane) - zOffset;
		final int neHeight = getHeight(scene, neX, neY, tilePlane) - zOffset;
		final int seHeight = getHeight(scene, seX, seY, tilePlane) - zOffset;

		Point p1 = localToCanvas(client, swX, swY, swHeight);
		Point p2 = localToCanvas(client, nwX, nwY, nwHeight);
		Point p3 = localToCanvas(client, neX, neY, neHeight);
		Point p4 = localToCanvas(client, seX, seY, seHeight);

		if (p1 == null || p2 == null || p3 == null || p4 == null)
		{
			return null;
		}

		Polygon poly = new Polygon();
		poly.addPoint(p1.getX(), p1.getY());
		poly.addPoint(p2.getX(), p2.getY());
		poly.addPoint(p3.getX(), p3.getY());
		poly.addPoint(p4.getX(), p4.getY());

		return poly;
	}

	/**
	 * Calculates text position and centers depending on string length.
	 *
	 * @param client the game client
	 * @param graphics the game graphics
	 * @param localLocation local location of the tile
	 * @param text string for width measurement
	 * @param zOffset offset from ground plane
	 * @return a {@link Point} on screen corresponding to the given
	 * localLocation.
	 */
	public static Point getCanvasTextLocation(
		@Nonnull Client client,
		@Nonnull Graphics2D graphics,
		@Nonnull LocalPoint localLocation,
		@Nullable String text,
		int zOffset)
	{
		if (text == null)
		{
			return null;
		}

		var wv = client.getWorldView(localLocation.getWorldView());
		if (wv == null)
		{
			return null;
		}

		int plane = wv.getPlane();

		Point p = localToCanvas(client, localLocation, plane, zOffset);

		if (p == null)
		{
			return null;
		}

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D bounds = fm.getStringBounds(text, graphics);
		int xOffset = p.getX() - (int) (bounds.getWidth() / 2);

		return new Point(xOffset, p.getY());
	}

	/**
	 * Calculates image position and centers depending on image size.
	 *
	 * @param client the game client
	 * @param localLocation local location of the tile
	 * @param image image for size measurement
	 * @param zOffset offset from ground plane
	 * @return a {@link Point} on screen corresponding to the given
	 * localLocation.
	 */
	public static Point getCanvasImageLocation(
		@Nonnull Client client,
		@Nonnull LocalPoint localLocation,
		@Nonnull BufferedImage image,
		int zOffset)
	{
		var wv = client.getWorldView(localLocation.getWorldView());
		if (wv == null)
		{
			return null;
		}

		int plane = wv.getPlane();

		Point p = localToCanvas(client, localLocation, plane, zOffset);

		if (p == null)
		{
			return null;
		}

		int xOffset = p.getX() - image.getWidth() / 2;
		int yOffset = p.getY() - image.getHeight() / 2;

		return new Point(xOffset, yOffset);
	}

	/**
	 * Calculates image position and centers depending on image size.
	 *
	 * @param client the game client
	 * @param localLocation local location of the tile
	 * @param image image for size measurement
	 * @return a {@link Point} on screen corresponding to the given
	 * localLocation.
	 */
	public static Point getMiniMapImageLocation(
		@Nonnull Client client,
		@Nonnull LocalPoint localLocation,
		@Nonnull BufferedImage image)
	{
		Point p = Perspective.localToMinimap(client, localLocation);

		if (p == null)
		{
			return null;
		}

		int xOffset = p.getX() - image.getWidth() / 2;
		int yOffset = p.getY() - image.getHeight() / 2;

		return new Point(xOffset, yOffset);
	}

	/**
	 * Calculates sprite position and centers depending on sprite size.
	 *
	 * @param client the game client
	 * @param localLocation local location of the tile
	 * @param sprite SpritePixel for size measurement
	 * @param zOffset offset from ground plane
	 * @return a {@link Point} on screen corresponding to the given localLocation.
	 */
	public static Point getCanvasSpriteLocation(
		@Nonnull Client client,
		@Nonnull LocalPoint localLocation,
		@Nonnull SpritePixels sprite,
		int zOffset)
	{
		var wv = client.getWorldView(localLocation.getWorldView());
		if (wv == null)
		{
			return null;
		}

		int plane = wv.getPlane();

		Point p = localToCanvas(client, localLocation, plane, zOffset);

		if (p == null)
		{
			return null;
		}

		int xOffset = p.getX() - sprite.getWidth() / 2;
		int yOffset = p.getY() - sprite.getHeight() / 2;

		return new Point(xOffset, yOffset);
	}

	/**
	 * You don't want this. Use {@link TileObject#getClickbox()} instead.
	 * <p>
	 * Get the on-screen clickable area of {@code model} as though it's for the
	 * object on the tile at ({@code localX}, {@code localY}) and rotated to
	 * angle {@code orientation}.
	 * @param client      the game client
	 * @param model       the model to calculate a clickbox for
	 * @param orientation the orientation of the model (0-2048, where 0 is north)
	 * @param x           x coord in local space
	 * @param z           y coord in local space
	 * @return the clickable area of the model
	 */
	@Nullable
	@ApiStatus.Internal
	public static Shape getClickbox(@Nonnull Client client, Model model, int orientation, int x, int y, int z)
	{
		if (model == null)
		{
			return null;
		}

		SimplePolygon bounds = calculateAABB(client, model, orientation, x, y, z);

		if (bounds == null)
		{
			return null;
		}

		if (model.useBoundingBox())
		{
			return bounds;
		}

		Shapes<SimplePolygon> bounds2d = calculate2DBounds(client, model, orientation, x, y, z);
		if (bounds2d == null)
		{
			return null;
		}

		for (SimplePolygon poly : bounds2d.getShapes())
		{
			poly.intersectWithConvex(bounds);
		}

		return bounds2d;
	}

	private static SimplePolygon calculateAABB(Client client, Model m, int jauOrient, int x, int y, int z)
	{
		AABB aabb = m.getAABB(jauOrient);

		int x1 = aabb.getCenterX();
		int y1 = aabb.getCenterZ();
		int z1 = aabb.getCenterY();

		int ex = aabb.getExtremeX();
		int ey = aabb.getExtremeZ();
		int ez = aabb.getExtremeY();

		int x2 = x1 + ex;
		int y2 = y1 + ey;
		int z2 = z1 + ez;

		x1 -= ex;
		y1 -= ey;
		z1 -= ez;

		float[] xa = new float[]{
			x1, x2, x1, x2,
			x1, x2, x1, x2
		};
		float[] ya = new float[]{
			y1, y1, y2, y2,
			y1, y1, y2, y2
		};
		float[] za = new float[]{
			z1, z1, z1, z1,
			z2, z2, z2, z2
		};

		int[] x2d = new int[8];
		int[] y2d = new int[8];

		modelToCanvasCpu(client, 8, x, y, z, 0, xa, ya, za, x2d, y2d);

		return Jarvis.convexHull(x2d, y2d);
	}

	private static Shapes<SimplePolygon> calculate2DBounds(Client client, Model m, int jauOrient, int x, int y, int z)
	{
		int[] x2d = new int[m.getVerticesCount()];
		int[] y2d = new int[m.getVerticesCount()];
		final int[] faceColors3 = m.getFaceColors3();

		Perspective.modelToCanvasCpu(client,
			m.getVerticesCount(),
			x, y, z,
			jauOrient,
			m.getVerticesX(), m.getVerticesZ(), m.getVerticesY(),
			x2d, y2d);

		final int radius = 5;

		int[][] tris = new int[][]{
			m.getFaceIndices1(),
			m.getFaceIndices2(),
			m.getFaceIndices3()
		};

		int vpX1 = client.getViewportXOffset();
		int vpY1 = client.getViewportXOffset();
		int vpX2 = vpX1 + client.getViewportWidth();
		int vpY2 = vpY1 + client.getViewportHeight();

		List<RectangleUnion.Rectangle> rects = new ArrayList<>(m.getFaceCount());

		nextTri:
		for (int tri = 0; tri < m.getFaceCount(); tri++)
		{
			if (faceColors3[tri] == -2)
			{
				continue;
			}

			int
				minX = Integer.MAX_VALUE,
				minY = Integer.MAX_VALUE,
				maxX = Integer.MIN_VALUE,
				maxY = Integer.MIN_VALUE;

			for (int[] vertex : tris)
			{
				final int idx = vertex[tri];
				final int xs = x2d[idx];
				final int ys = y2d[idx];

				if (xs == Integer.MIN_VALUE || ys == Integer.MIN_VALUE)
				{
					continue nextTri;
				}

				if (xs < minX)
				{
					minX = xs;
				}
				if (xs > maxX)
				{
					maxX = xs;
				}
				if (ys < minY)
				{
					minY = ys;
				}
				if (ys > maxY)
				{
					maxY = ys;
				}
			}

			minX -= radius;
			minY -= radius;
			maxX += radius;
			maxY += radius;

			if (vpX1 > maxX || vpX2 < minX || vpY1 > maxY || vpY2 < minY)
			{
				continue;
			}

			RectangleUnion.Rectangle r = new RectangleUnion.Rectangle(minX, minY, maxX, maxY);

			rects.add(r);
		}

		return RectangleUnion.union(rects);
	}

	/**
	 * Calculates text position and centers on minimap depending on string length.
	 *
	 * @param client the game client
	 * @param graphics the game graphics
	 * @param localLocation local location of the tile
	 * @param text string for width measurement
	 * @return a {@link Point} on screen corresponding to the given
	 * localLocation.
	 */
	public static Point getCanvasTextMiniMapLocation(
		@Nonnull Client client,
		@Nonnull Graphics2D graphics,
		@Nonnull LocalPoint localLocation,
		@Nonnull String text)
	{
		Point p = Perspective.localToMinimap(client, localLocation);

		if (p == null)
		{
			return null;
		}

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D bounds = fm.getStringBounds(text, graphics);
		int xOffset = p.getX() - (int) (bounds.getWidth() / 2);
		int yOffset = p.getY() - (int) (bounds.getHeight() / 2) + fm.getAscent();

		return new Point(xOffset, yOffset);
	}

}
