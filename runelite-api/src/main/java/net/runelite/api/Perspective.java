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
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import static net.runelite.api.Constants.TILE_FLAG_BRIDGE;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.model.Jarvis;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;

/**
 * A utility class containing methods to help with conversion between
 * in-game features to canvas areas.
 */
public class Perspective
{
	private static final double UNIT = Math.PI / 1024d; // How much of the circle each unit of SINE/COSINE is

	public static final int LOCAL_COORD_BITS = 7;
	public static final int LOCAL_TILE_SIZE = 1 << LOCAL_COORD_BITS; // 128 - size of a tile in local coordinates

	public static final int SCENE_SIZE = Constants.SCENE_SIZE; // in tiles

	public static final int[] SINE = new int[2048]; // sine angles for each of the 2048 units, * 65536 and stored as an int
	public static final int[] COSINE = new int[2048]; // cosine

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
	private static Point localToCanvas(@Nonnull Client client, int x, int y, int z)
	{
		if (x >= 128 && y >= 128 && x <= 13056 && y <= 13056)
		{
			x -= client.getCameraX();
			y -= client.getCameraY();
			z -= client.getCameraZ();

			int cameraPitch = client.getCameraPitch();
			int cameraYaw = client.getCameraYaw();

			int pitchSin = SINE[cameraPitch];
			int pitchCos = COSINE[cameraPitch];
			int yawSin = SINE[cameraYaw];
			int yawCos = COSINE[cameraYaw];

			int var8 = yawCos * x + y * yawSin >> 16;
			y = yawCos * y - yawSin * x >> 16;
			x = var8;
			var8 = pitchCos * z - y * pitchSin >> 16;
			y = z * pitchSin + y * pitchCos >> 16;

			if (y >= 50)
			{
				int pointX = client.getViewportWidth() / 2 + x * client.getScale() / y;
				int pointY = client.getViewportHeight() / 2 + var8 * client.getScale() / y;
				return new Point(
					pointX + client.getViewportXOffset(),
					pointY + client.getViewportYOffset());
			}
		}

		return null;

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
		return localToMinimap(client, point, 6400);
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
		int x = point.getX() / 32 - localLocation.getX() / 32;
		int y = point.getY() / 32 - localLocation.getY() / 32;

		int dist = x * x + y * y;
		if (dist < distance)
		{
			Widget minimapDrawWidget;
			if (client.isResized())
			{
				if (client.getVar(Varbits.SIDE_PANELS) == 1)
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

			final int angle = client.getMapAngle() & 0x7FF;

			final int sin = SINE[angle];
			final int cos = COSINE[angle];

			final int xx = y * sin + cos * x >> 16;
			final int yy = sin * x - y * cos >> 16;

			Point loc = minimapDrawWidget.getCanvasLocation();
			int miniMapX = loc.getX() + xx + minimapDrawWidget.getWidth() / 2;
			int miniMapY = minimapDrawWidget.getHeight() / 2 + loc.getY() + yy;
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
			byte[][][] tileSettings = client.getTileSettings();
			int[][][] tileHeights = client.getTileHeights();

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
	 * @param client
	 * @param localX
	 * @param localY
	 * @param plane
	 * @return
	 */
	private static int getHeight(@Nonnull Client client, int localX, int localY, int plane)
	{
		int sceneX = localX >> LOCAL_COORD_BITS;
		int sceneY = localY >> LOCAL_COORD_BITS;
		if (sceneX >= 0 && sceneY >= 0 && sceneX < SCENE_SIZE && sceneY < SCENE_SIZE)
		{
			int[][][] tileHeights = client.getTileHeights();

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
	 * Returns a polygon representing an area.
	 *
	 * @param client the game client
	 * @param localLocation the center location of the AoE
	 * @param size the size of the area (ie. 3x3 AoE evaluates to size 3)
	 * @return a polygon representing the tiles in the area
	 */
	public static Polygon getCanvasTileAreaPoly(@Nonnull Client client, @Nonnull LocalPoint localLocation, int size)
	{
		final int plane = client.getPlane();

		final int swX = localLocation.getX() - (size * LOCAL_TILE_SIZE / 2);
		final int swY = localLocation.getY() - (size * LOCAL_TILE_SIZE / 2);

		final int neX = localLocation.getX() + (size * LOCAL_TILE_SIZE / 2);
		final int neY = localLocation.getY() + (size * LOCAL_TILE_SIZE / 2);

		final int seX = swX;
		final int seY = neY;

		final int nwX = neX;
		final int nwY = swY;

		final byte[][][] tileSettings = client.getTileSettings();

		final int sceneX = localLocation.getSceneX();
		final int sceneY = localLocation.getSceneY();

		if (sceneX < 0 || sceneY < 0 || sceneX >= SCENE_SIZE || sceneY >= SCENE_SIZE)
		{
			return null;
		}

		int tilePlane = plane;
		if (plane < Constants.MAX_Z - 1 && (tileSettings[1][sceneX][sceneY] & TILE_FLAG_BRIDGE) == TILE_FLAG_BRIDGE)
		{
			tilePlane = plane + 1;
		}

		final int swHeight = getHeight(client, swX, swY, tilePlane);
		final int nwHeight = getHeight(client, nwX, nwY, tilePlane);
		final int neHeight = getHeight(client, neX, neY, tilePlane);
		final int seHeight = getHeight(client, seX, seY, tilePlane);

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
		if (text == null || "".equals(text))
		{
			return null;
		}

		int plane = client.getPlane();

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
		int plane = client.getPlane();

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
		int plane = client.getPlane();

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
	 *
	 * @param client the game client
	 * @param model the model to calculate a clickbox for
	 * @param orientation the orientation of the model (0-2048, where 0 is north)
	 * @param point the coordinate of the tile
	 * @return the clickable area of the model
	 */
	public static Area getClickbox(@Nonnull Client client, Model model, int orientation, @Nonnull LocalPoint point)
	{
		if (model == null)
		{
			return null;
		}

		List<Triangle> triangles = model.getTriangles().stream()
			.map(triangle -> triangle.rotate(orientation))
			.collect(Collectors.toList());

		List<Vertex> vertices = model.getVertices().stream()
				.map(v -> v.rotate(orientation))
				.collect(Collectors.toList());

		Area clickBox = get2DGeometry(client, triangles, point);
		Area visibleAABB = getAABB(client, vertices, point);

		if (visibleAABB == null || clickBox == null)
		{
			return null;
		}

		clickBox.intersect(visibleAABB);
		return clickBox;
	}

	/**
	 * Determine if a given point is off-screen.
	 *
	 * @param client
	 * @param point
	 * @return
	 */
	private static boolean isOffscreen(@Nonnull Client client, @Nonnull Point point)
	{
		return (point.getX() < 0 || point.getX() >= client.getViewportWidth())
			&& (point.getY() < 0 || point.getY() >= client.getViewportHeight());
	}

	private static Area get2DGeometry(
		@Nonnull Client client,
		@Nonnull List<Triangle> triangles,
		@Nonnull LocalPoint point
	)
	{
		int radius = 5;
		Path2D.Double geometry = new Path2D.Double();

		final int tileHeight = getTileHeight(client, point, client.getPlane());

		for (Triangle triangle : triangles)
		{
			Vertex _a = triangle.getA();
			Point a = localToCanvas(client,
				point.getX() - _a.getX(),
				point.getY() - _a.getZ(),
				tileHeight + _a.getY());
			if (a == null)
			{
				continue;
			}

			Vertex _b = triangle.getB();
			Point b = localToCanvas(client,
				point.getX() - _b.getX(),
				point.getY() - _b.getZ(),
				tileHeight + _b.getY());
			if (b == null)
			{
				continue;
			}

			Vertex _c = triangle.getC();
			Point c = localToCanvas(client,
				point.getX() - _c.getX(),
				point.getY() - _c.getZ(),
				tileHeight + _c.getY());
			if (c == null)
			{
				continue;
			}

			if (isOffscreen(client, a) && isOffscreen(client, b) && isOffscreen(client, c))
			{
				continue;
			}

			int minX = Math.min(Math.min(a.getX(), b.getX()), c.getX());
			int minY = Math.min(Math.min(a.getY(), b.getY()), c.getY());

			// For some reason, this calculation is always 4 pixels short of the actual in-client one
			int maxX = Math.max(Math.max(a.getX(), b.getX()), c.getX()) + 4;
			int maxY = Math.max(Math.max(a.getY(), b.getY()), c.getY()) + 4;

			Rectangle clickableRect = new Rectangle(
				minX - radius, minY - radius,
				maxX - minX + radius, maxY - minY + radius
			);

			if (geometry.contains(clickableRect))
			{
				continue;
			}

			geometry.append(clickableRect, false);
		}

		return new Area(geometry);
	}

	private static Area getAABB(
		@Nonnull Client client,
		@Nonnull List<Vertex> vertices,
		@Nonnull LocalPoint point
	)
	{
		int maxX = 0;
		int minX = 0;
		int maxY = 0;
		int minY = 0;
		int maxZ = 0;
		int minZ = 0;

		for (Vertex vertex : vertices)
		{
			int x = vertex.getX();
			int y = vertex.getY();
			int z = vertex.getZ();

			if (x > maxX)
			{
				maxX = x;
			}
			if (x < minX)
			{
				minX = x;
			}

			if (y > maxY)
			{
				maxY = y;
			}
			if (y < minY)
			{
				minY = y;
			}

			if (z > maxZ)
			{
				maxZ = z;
			}
			if (z < minZ)
			{
				minZ = z;
			}
		}

		int centerX = (minX + maxX) / 2;
		int centerY = (minY + maxY) / 2;
		int centerZ = (minZ + maxZ) / 2;

		int extremeX = (maxX - minX + 1) / 2;
		int extremeY = (maxY - minY + 1) / 2;
		int extremeZ = (maxZ - minZ + 1) / 2;

		if (extremeX < 32)
		{
			extremeX = 32;
		}

		if (extremeZ < 32)
		{
			extremeZ = 32;
		}

		int x1 = point.getX() - (centerX - extremeX);
		int y1 = centerY - extremeY;
		int z1 = point.getY() - (centerZ - extremeZ);

		int x2 = point.getX() - (centerX + extremeX);
		int y2 = centerY + extremeY;
		int z2 = point.getY() - (centerZ + extremeZ);

		final int tileHeight = getTileHeight(client, point, client.getPlane());

		Point p1 = localToCanvas(client, x1, z1, tileHeight + y1);
		Point p2 = localToCanvas(client, x1, z2, tileHeight + y1);
		Point p3 = localToCanvas(client, x2, z2, tileHeight + y1);

		Point p4 = localToCanvas(client, x2, z1, tileHeight + y1);
		Point p5 = localToCanvas(client, x1, z1, tileHeight + y2);
		Point p6 = localToCanvas(client, x1, z2, tileHeight + y2);
		Point p7 = localToCanvas(client, x2, z2, tileHeight + y2);
		Point p8 = localToCanvas(client, x2, z1, tileHeight + y2);

		List<Point> points = new ArrayList<>(8);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);

		try
		{
			points = Jarvis.convexHull(points);
		}
		catch (NullPointerException e)
		{
			// No non-null screen points for this AABB e.g. for an way off-screen model
			return null;
		}

		if (points == null)
		{
			return null;
		}

		Polygon hull = new Polygon();
		for (Point p : points)
		{
			if (p != null)
			{
				hull.addPoint(p.getX(), p.getY());
			}
		}

		return new Area(hull);
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
