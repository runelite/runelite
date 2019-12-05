import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("World")
public class World {
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -2124078527
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -92333775
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("y")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("w")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 176871977
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 767874413
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1258994719
	)
	@Export("population")
	int population;
	@ObfuscatedName("e")
	@Export("host")
	String host;
	@ObfuscatedName("n")
	@Export("activity")
	String activity;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1182748769
	)
	@Export("location")
	int location;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1616243125
	)
	@Export("index")
	int index;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-946882921"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-32"
	)
	boolean method1802() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1605869890"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1798300394"
	)
	boolean method1785() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-758716073"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "5"
	)
	boolean method1788() {
		return (1073741824 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILhf;IIIZI)V",
		garbageValue = "592972731"
	)
	public static void method1819(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		class197.field2411 = 1;
		class197.musicTrackArchive = var1;
		UrlRequester.musicTrackGroupId = var2;
		UserComparator7.musicTrackFileId = var3;
		class197.musicTrackVolume = var4;
		ArchiveLoader.musicTrackBoolean = var5;
		class335.field4014 = var0;
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "1377503152"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = class2.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (0L != var5) {
			var7 = class2.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (WallDecoration.method3340(var5)) {
				var10 = var4;
			}

			int[] var11 = Interpreter.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = ItemContainer.Entity_unpackID(var5);
			ObjectDefinition var14 = Occluder.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = GrandExchangeOfferTotalQuantityComparator.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var1 * 4 + var16 + 48, (104 - var2 - var14.sizeY) * 4 + var17 + 48);
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

		var5 = class2.scene.getGameObjectTag(var0, var1, var2);
		if (0L != var5) {
			var7 = class2.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = ItemContainer.Entity_unpackID(var5);
			ObjectDefinition var24 = Occluder.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = GrandExchangeOfferTotalQuantityComparator.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (WallDecoration.method3340(var5)) {
					var12 = 15597568;
				}

				int[] var23 = Interpreter.sceneMinimapSprite.pixels;
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

		var5 = class2.scene.getFloorDecorationTag(var0, var1, var2);
		if (0L != var5) {
			var7 = ItemContainer.Entity_unpackID(var5);
			ObjectDefinition var20 = Occluder.getObjectDefinition(var7);
			if (var20.mapSceneId != -1) {
				IndexedSprite var21 = GrandExchangeOfferTotalQuantityComparator.mapSceneSprites[var20.mapSceneId];
				if (var21 != null) {
					var10 = (var20.sizeX * 4 - var21.subWidth) / 2;
					int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
					var21.drawAt(var10 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var22 + 48);
				}
			}
		}

	}
}
