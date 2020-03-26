import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lce;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1351429101
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("k")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("d")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1106697441"
	)
	static void method1242(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			var1.remove();
		}
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(IIIIIB)V",
		garbageValue = "-113"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (var5 != 0L) {
			var7 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (Decimator.method2635(var5)) {
				var10 = var4;
			}

			int[] var11 = ArchiveDisk.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = WorldMapRectangle.Entity_unpackID(var5);
			ObjectDefinition var14 = WorldMapSection2.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = class169.mapSceneSprites[var14.mapSceneId];
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

		var5 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = WorldMapRectangle.Entity_unpackID(var5);
			ObjectDefinition var24 = WorldMapSection2.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = class169.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var13 + var1 * 4 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (Decimator.method2635(var5)) {
					var12 = 15597568;
				}

				int[] var23 = ArchiveDisk.sceneMinimapSprite.pixels;
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

		var5 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(var0, var1, var2);
		if (0L != var5) {
			var7 = WorldMapRectangle.Entity_unpackID(var5);
			ObjectDefinition var20 = WorldMapSection2.getObjectDefinition(var7);
			if (var20.mapSceneId != -1) {
				IndexedSprite var21 = class169.mapSceneSprites[var20.mapSceneId];
				if (var21 != null) {
					var10 = (var20.sizeX * 4 - var21.subWidth) / 2;
					int var22 = (var20.sizeY * 4 - var21.subHeight) / 2;
					var21.drawAt(var10 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var22 + 48);
				}
			}
		}

	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1005499202"
	)
	static final void method1241() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.hitpoints == -1) {
				var0.delay = 0;
				WorldMapSectionType.method348(var0);
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
		garbageValue = "-1778070098"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuShiftClick[Client.menuOptionsCount] = var6;
				++Client.menuOptionsCount;
			}

		}
	}
}
