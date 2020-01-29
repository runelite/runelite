import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("cz")
	@ObfuscatedGetter(
		intValue = -1462817165
	)
	public static int field2102;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1839542313
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1525294437
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -860662491
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1587561283
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIILfv;B)Z",
		garbageValue = "50"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-47058796"
	)
	static final void method3662(int var0, int var1, int var2, int var3) {
		TileItemPile.method2835();
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "67"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = ServerBuild.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (var5 != 0L) {
			var7 = ServerBuild.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (KeyHandler.method850(var5)) {
				var10 = var4;
			}

			int[] var11 = WorldMapRectangle.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = GrandExchangeEvents.Entity_unpackID(var5);
			ObjectDefinition var14 = Occluder.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = VertexNormal.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var16 + var1 * 4 + 48, (104 - var2 - var14.sizeY) * 4 + var17 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 1) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var11[var12] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = ServerBuild.scene.getGameObjectTag(var0, var1, var2);
		if (0L != var5) {
			var7 = ServerBuild.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = GrandExchangeEvents.Entity_unpackID(var5);
			ObjectDefinition var24 = Occluder.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = VertexNormal.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var13 + var1 * 4 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (KeyHandler.method850(var5)) {
					var12 = 15597568;
				}

				int[] var23 = WorldMapRectangle.sceneMinimapSprite.pixels;
				var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var23[var19] = var12;
					var23[var19 + 1 + 512] = var12;
					var23[var19 + 1024 + 2] = var12;
					var23[var19 + 1536 + 3] = var12;
				} else {
					var23[var19 + 1536] = var12;
					var23[var19 + 1 + 1024] = var12;
					var23[var19 + 512 + 2] = var12;
					var23[var19 + 3] = var12;
				}
			}
		}

		var5 = ServerBuild.scene.getFloorDecorationTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = GrandExchangeEvents.Entity_unpackID(var5);
			ObjectDefinition var20 = Occluder.getObjectDefinition(var7);
			if (var20.mapSceneId != -1) {
				IndexedSprite var21 = VertexNormal.mapSceneSprites[var20.mapSceneId];
				if (var21 != null) {
					var10 = (var20.sizeX * 4 - var21.subWidth) / 2;
					int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
					var21.drawAt(var10 + var1 * 4 + 48, var22 + (104 - var2 - var20.sizeY) * 4 + 48);
				}
			}
		}

	}
}
