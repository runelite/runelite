import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	field3425(0, 0),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(2, 1),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Liz;"
	)
	field3424(1, 2);

	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -618314265
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 345899471
	)
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1134986404"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "1599088353"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = class14.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (var5 != 0L) {
			var7 = class14.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (class42.method790(var5)) {
				var10 = var4;
			}

			int[] var11 = Language.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = class2.Entity_unpackID(var5);
			ObjectDefinition var14 = Coord.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = class162.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var16 + var1 * 4 + 48, var17 + (104 - var2 - var14.sizeY) * 4 + 48);
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

		var5 = class14.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = class14.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = class2.Entity_unpackID(var5);
			ObjectDefinition var24 = Coord.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = class162.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var1 * 4 + var13 + 48, (104 - var2 - var24.sizeY) * 4 + var19 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (class42.method790(var5)) {
					var12 = 15597568;
				}

				int[] var23 = Language.sceneMinimapSprite.pixels;
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

		var5 = class14.scene.getFloorDecorationTag(var0, var1, var2);
		if (0L != var5) {
			var7 = class2.Entity_unpackID(var5);
			ObjectDefinition var20 = Coord.getObjectDefinition(var7);
			if (var20.mapSceneId != -1) {
				IndexedSprite var21 = class162.mapSceneSprites[var20.mapSceneId];
				if (var21 != null) {
					var10 = (var20.sizeX * 4 - var21.subWidth) / 2;
					int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
					var21.drawAt(var1 * 4 + var10 + 48, var22 + (104 - var2 - var20.sizeY) * 4 + 48);
				}
			}
		}

	}
}
