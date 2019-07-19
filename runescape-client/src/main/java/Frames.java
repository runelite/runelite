import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("Frames")
public class Frames extends DualNode {
	@ObfuscatedName("i")
	@Export("SpriteBuffer_spritePalette")
	public static int[] SpriteBuffer_spritePalette;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[Lda;"
	)
	@Export("frames")
	Animation[] frames;

	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;IZ)V"
	)
	Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Animation[var6];
		int[] var7 = var1.getGroupFileIds(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]);
			Skeleton var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
				if (var11 == var12.id) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13;
				if (var4) {
					var13 = var2.getFile(0, var11);
				} else {
					var13 = var2.getFile(var11, 0);
				}

				var10 = new Skeleton(var11, var13);
				var5.addFirst(var10);
			}

			this.frames[var7[var8]] = new Animation(var9, var10);
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1644534064"
	)
	@Export("hasAlphaTransform")
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IILfl;Lfv;I)Z",
		garbageValue = "4377134"
	)
	public static final boolean method3267(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
		int var4 = var0;
		int var5 = var1;
		byte var6 = 64;
		byte var7 = 64;
		int var8 = var0 - var6;
		int var9 = var1 - var7;
		class173.directions[var6][var7] = 99;
		class173.distances[var6][var7] = 0;
		byte var10 = 0;
		int var11 = 0;
		class173.bufferX[var10] = var0;
		byte var10001 = var10;
		int var18 = var10 + 1;
		class173.bufferY[var10001] = var1;
		int[][] var12 = var3.flags;

		while (var11 != var18) {
			var4 = class173.bufferX[var11];
			var5 = class173.bufferY[var11];
			var11 = var11 + 1 & 4095;
			int var16 = var4 - var8;
			int var17 = var5 - var9;
			int var13 = var4 - var3.xInset;
			int var14 = var5 - var3.yInset;
			if (var2.vmethod3594(2, var4, var5, var3)) {
				class173.field2088 = var4;
				class218.field2707 = var5;
				return true;
			}

			int var15 = class173.distances[var16][var17] + 1;
			if (var16 > 0 && class173.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17] = 2;
				class173.distances[var16 - 1][var17] = var15;
			}

			if (var16 < 126 && class173.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17] = 8;
				class173.distances[var16 + 1][var17] = var15;
			}

			if (var17 > 0 && class173.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 - 1] = 1;
				class173.distances[var16][var17 - 1] = var15;
			}

			if (var17 < 126 && class173.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 + 1] = 4;
				class173.distances[var16][var17 + 1] = var15;
			}

			if (var16 > 0 && var17 > 0 && class173.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 - 1] = 3;
				class173.distances[var16 - 1][var17 - 1] = var15;
			}

			if (var16 < 126 && var17 > 0 && class173.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 - 1] = 9;
				class173.distances[var16 + 1][var17 - 1] = var15;
			}

			if (var16 > 0 && var17 < 126 && class173.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 + 1] = 6;
				class173.distances[var16 - 1][var17 + 1] = var15;
			}

			if (var16 < 126 && var17 < 126 && class173.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 + 1] = 12;
				class173.distances[var16 + 1][var17 + 1] = var15;
			}
		}

		class173.field2088 = var4;
		class218.field2707 = var5;
		return false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ldm;IIIB)Z",
		garbageValue = "44"
	)
	@Export("boundingBoxCheck")
	static final boolean boundingBoxCheck(Model var0, int var1, int var2, int var3) {
		boolean var4 = ViewportMouse.ViewportMouse_isInViewport;
		if (!var4) {
			return false;
		} else {
			int var5;
			int var6;
			int var7;
			int var8;
			int var11;
			int var12;
			int var13;
			int var16;
			int var17;
			if (!ViewportMouse.ViewportMouse_false0) {
				var5 = Scene.Scene_cameraPitchSine;
				var6 = Scene.Scene_cameraPitchCosine;
				var7 = Scene.Scene_cameraYawSine;
				var8 = Scene.Scene_cameraYawCosine;
				byte var9 = 50;
				short var10 = 3500;
				var11 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var9 / Rasterizer3D.Rasterizer3D_zoom;
				var12 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var9 / Rasterizer3D.Rasterizer3D_zoom;
				var13 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.Rasterizer3D_clipMidX) * var10 / Rasterizer3D.Rasterizer3D_zoom;
				int var14 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.Rasterizer3D_clipMidY) * var10 / Rasterizer3D.Rasterizer3D_zoom;
				int var15 = Rasterizer3D.rot1(var12, var9, var6, var5);
				var16 = Rasterizer3D.rot2(var12, var9, var6, var5);
				var12 = var15;
				var15 = Rasterizer3D.rot1(var14, var10, var6, var5);
				var17 = Rasterizer3D.rot2(var14, var10, var6, var5);
				var14 = var15;
				var15 = Rasterizer3D.rot3(var11, var16, var8, var7);
				var16 = Rasterizer3D.rot4(var11, var16, var8, var7);
				var11 = var15;
				var15 = Rasterizer3D.rot3(var13, var17, var8, var7);
				var17 = Rasterizer3D.rot4(var13, var17, var8, var7);
				ModelData0.field1871 = (var11 + var15) / 2;
				ViewportMouse.field1745 = (var12 + var14) / 2;
				ViewportMouse.field1746 = (var16 + var17) / 2;
				GroundItem.field1242 = (var15 - var11) / 2;
				GrandExchangeEvent.field48 = (var14 - var12) / 2;
				Canvas.field422 = (var17 - var16) / 2;
				ScriptFrame.field527 = Math.abs(GroundItem.field1242);
				ViewportMouse.field1741 = Math.abs(GrandExchangeEvent.field48);
				MenuAction.field1160 = Math.abs(Canvas.field422);
			}

			var5 = var0.xMid + var1;
			var6 = var2 + var0.yMid;
			var7 = var3 + var0.zMid;
			var8 = var0.xMidOffset;
			var16 = var0.yMidOffset;
			var17 = var0.zMidOffset;
			var11 = ModelData0.field1871 - var5;
			var12 = ViewportMouse.field1745 - var6;
			var13 = ViewportMouse.field1746 - var7;
			if (Math.abs(var11) > var8 + ScriptFrame.field527) {
				return false;
			} else if (Math.abs(var12) > var16 + ViewportMouse.field1741) {
				return false;
			} else if (Math.abs(var13) > var17 + MenuAction.field1160) {
				return false;
			} else if (Math.abs(var13 * GrandExchangeEvent.field48 - var12 * Canvas.field422) > var17 * ViewportMouse.field1741 + var16 * MenuAction.field1160) {
				return false;
			} else if (Math.abs(var11 * Canvas.field422 - var13 * GroundItem.field1242) > var8 * MenuAction.field1160 + var17 * ScriptFrame.field527) {
				return false;
			} else {
				return Math.abs(var12 * GroundItem.field1242 - var11 * GrandExchangeEvent.field48) <= var16 * ScriptFrame.field527 + var8 * ViewportMouse.field1741;
			}
		}
	}
}
