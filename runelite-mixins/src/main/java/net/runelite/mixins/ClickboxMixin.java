package net.runelite.mixins;

import net.runelite.api.Model;
import net.runelite.api.Perspective;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSModel;

/**
 * Class to check clickboxes of models. Mostly refactored code from the client.
 */
@Mixin(RSClient.class)
public abstract class ClickboxMixin implements RSClient
{
	@Shadow("clientInstance")
	private static RSClient client;

	private static final int MAX_ENTITES_AT_MOUSE = 1000;
	private static final int CLICKBOX_CLOSE = 50;
	private static final int CLICKBOX_FAR = 3500;
	private static final int OBJECT_INTERACTION_FAR = 35; // Max distance, in tiles, from camera

	@Inject
	private static final int[] rl$modelViewportXs = new int[4700];

	@Inject
	private static final int[] rl$modelViewportYs = new int[4700];

	@Inject
	public void checkClickbox(Model rlModel, int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int _x, int _y, int _z, long hash)
	{
		RSModel model = (RSModel) rlModel;
		boolean hasFlag = hash != 0L && (int) (hash >>> 16 & 1L) != 1;
		boolean viewportContainsMouse = client.getViewportContainsMouse();

		if (!hasFlag || !viewportContainsMouse || client.getOculusOrbState() != 0)
		{
			return;
		}

		boolean bb = boundingboxCheck(model, _x, _y, _z);
		if (!bb)
		{
			return;
		}

		if (Math.sqrt(_x * _x + _z * _z) > OBJECT_INTERACTION_FAR * Perspective.LOCAL_TILE_SIZE)
		{
			return;
		}

		// only need a boundingbox check?
		if (model.isClickable())
		{
			addHashAtMouse(hash);
			return;
		}

		// otherwise we must check if the mouse is in a triangle
		final int vertexCount = model.getVerticesCount();
		final int triangleCount = model.getTrianglesCount();

		final int[] vertexX = model.getVerticesX();
		final int[] vertexY = model.getVerticesY();
		final int[] vertexZ = model.getVerticesZ();

		final int[] triangleX = model.getTrianglesX();
		final int[] triangleY = model.getTrianglesY();
		final int[] triangleZ = model.getTrianglesZ();

		final int[] color3 = model.getFaceColors3();

		final int zoom = client.get3dZoom();

		final int centerX = client.getCenterX();
		final int centerY = client.getCenterY();

		int sin = 0;
		int cos = 0;
		if (orientation != 0)
		{
			sin = Perspective.SINE[orientation];
			cos = Perspective.COSINE[orientation];
		}

		for (int i = 0; i < vertexCount; ++i)
		{
			int x = vertexX[i];
			int y = vertexY[i];
			int z = vertexZ[i];

			int var42;
			if (orientation != 0)
			{
				var42 = z * sin + x * cos >> 16;
				z = z * cos - x * sin >> 16;
				x = var42;
			}

			x += _x;
			y += _y;
			z += _z;

			var42 = z * yawSin + yawCos * x >> 16;
			z = yawCos * z - x * yawSin >> 16;
			x = var42;
			var42 = pitchCos * y - z * pitchSin >> 16;
			z = y * pitchSin + pitchCos * z >> 16;

			if (z >= 50)
			{
				rl$modelViewportYs[i] = x * zoom / z + centerX;
				rl$modelViewportXs[i] = var42 * zoom / z + centerY;
			}
			else
			{
				rl$modelViewportYs[i] = -5000;
			}
		}

		final int viewportMouseX = client.getViewportMouseX();
		final int viewportMouseY = client.getViewportMouseY();

		for (int i = 0; i < triangleCount; ++i)
		{
			if (color3[i] == -2)
			{
				continue;
			}

			final int vA = triangleX[i];
			final int vB = triangleY[i];
			final int vC = triangleZ[i];

			int y1 = rl$modelViewportYs[vA];
			int y2 = rl$modelViewportYs[vB];
			int y3 = rl$modelViewportYs[vC];

			int x1 = rl$modelViewportXs[vA];
			int x2 = rl$modelViewportXs[vB];
			int x3 = rl$modelViewportXs[vC];

			if (y1 == -5000 || y2 == -5000 || y3 == -5000)
			{
				continue;
			}

			final int radius = model.isClickable() ? 20 : 5;

			int var18 = radius + viewportMouseY;
			boolean var34;
			if (var18 < x1 && var18 < x2 && var18 < x3)
			{
				var34 = false;
			}
			else
			{
				var18 = viewportMouseY - radius;
				if (var18 > x1 && var18 > x2 && var18 > x3)
				{
					var34 = false;
				}
				else
				{
					var18 = radius + viewportMouseX;
					if (var18 < y1 && var18 < y2 && var18 < y3)
					{
						var34 = false;
					}
					else
					{
						var18 = viewportMouseX - radius;
						if (var18 > y1 && var18 > y2 && var18 > y3)
						{
							var34 = false;
						}
						else
						{
							var34 = true;
						}
					}
				}
			}

			if (var34)
			{
				addHashAtMouse(hash);
				break;
			}
		}
	}

	@Inject
	private void addHashAtMouse(long hash)
	{
		long[] entitiesAtMouse = client.getEntitiesAtMouse();
		int count = client.getEntitiesAtMouseCount();
		if (count < MAX_ENTITES_AT_MOUSE)
		{
			entitiesAtMouse[count] = hash;
			client.setEntitiesAtMouseCount(count + 1);
		}
	}

	@Inject
	private boolean boundingboxCheck(Model model, int x, int y, int z)
	{
		final int cameraPitch = client.getCameraPitch();
		final int cameraYaw = client.getCameraYaw();

		final int pitchSin = Perspective.SINE[cameraPitch];
		final int pitchCos = Perspective.COSINE[cameraPitch];

		final int yawSin = Perspective.SINE[cameraYaw];
		final int yawCos = Perspective.COSINE[cameraYaw];

		final int centerX = client.getCenterX();
		final int centerY = client.getCenterY();

		final int viewportMouseX = client.getViewportMouseX();
		final int viewportMouseY = client.getViewportMouseY();

		final int Rasterizer3D_zoom = client.get3dZoom();

		int var6 = (viewportMouseX - centerX) * CLICKBOX_CLOSE / Rasterizer3D_zoom;
		int var7 = (viewportMouseY - centerY) * CLICKBOX_CLOSE / Rasterizer3D_zoom;
		int var8 = (viewportMouseX - centerX) * CLICKBOX_FAR / Rasterizer3D_zoom;
		int var9 = (viewportMouseY - centerY) * CLICKBOX_FAR / Rasterizer3D_zoom;
		int var10 = rl$rot1(var7, CLICKBOX_CLOSE, pitchCos, pitchSin);
		int var11 = rl$rot2(var7, CLICKBOX_CLOSE, pitchCos, pitchSin);
		var7 = var10;
		var10 = rl$rot1(var9, CLICKBOX_FAR, pitchCos, pitchSin);
		int var12 = rl$rot2(var9, CLICKBOX_FAR, pitchCos, pitchSin);
		var9 = var10;
		var10 = rl$rot3(var6, var11, yawCos, yawSin);
		var11 = rl$rot4(var6, var11, yawCos, yawSin);
		var6 = var10;
		var10 = rl$rot3(var8, var12, yawCos, yawSin);
		var12 = rl$rot4(var8, var12, yawCos, yawSin);
		int field1720 = (var10 - var6) / 2;
		int field638 = (var9 - var7) / 2;
		int field1846 = (var12 - var11) / 2;
		int field1722 = Math.abs(field1720);
		int field601 = Math.abs(field638);
		int field38 = Math.abs(field1846);

		int var38 = x + model.getCenterX();
		int var39 = y + model.getCenterY();
		int var40 = z + model.getCenterZ();
		int var41 = model.getExtremeX();
		int var42 = model.getExtremeY();
		int var43 = model.getExtremeZ();

		int field1861 = (var6 + var10) / 2;
		int field2317 = (var7 + var9) / 2;
		int field528 = (var12 + var11) / 2;

		int var44 = field1861 - var38;
		int var45 = field2317 - var39;
		int var46 = field528 - var40;

		boolean passes;
		if (Math.abs(var44) > var41 + field1722)
		{
			passes = false;
		}
		else if (Math.abs(var45) > var42 + field601)
		{
			passes = false;
		}
		else if (Math.abs(var46) > var43 + field38)
		{
			passes = false;
		}
		else if (Math.abs(var46 * field638 - var45 * field1846) > var42 * field38 + var43 * field601)
		{
			passes = false;
		}
		else if (Math.abs(var44 * field1846 - var46 * field1720) > var43 * field1722 + var41 * field38)
		{
			passes = false;
		}
		else if (Math.abs(var45 * field1720 - var44 * field638) > var42 * field1722 + var41 * field601)
		{
			passes = false;
		}
		else
		{
			passes = true;
		}

		return passes;
	}

	@Inject
	private static int rl$rot1(int var0, int var1, int var2, int var3)
	{
		return var0 * var2 + var3 * var1 >> 16;
	}

	@Inject
	private static int rl$rot2(int var0, int var1, int var2, int var3)
	{
		return var2 * var1 - var3 * var0 >> 16;
	}

	@Inject
	private static int rl$rot3(int var0, int var1, int var2, int var3)
	{
		return var0 * var2 - var3 * var1 >> 16;
	}

	@Inject
	private static int rl$rot4(int var0, int var1, int var2, int var3)
	{
		return var3 * var0 + var2 * var1 >> 16;
	}
}
