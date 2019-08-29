import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive20")
	static Archive archive20;
	@ObfuscatedName("j")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("i")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("k")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 733828633
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 433175323
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1193864261
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1480737507
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)[Lln;",
		garbageValue = "-825369330"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		signature = "(IIIIIIIB)V",
		garbageValue = "1"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != ItemContainer.plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = Player.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = Player.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = Player.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = Player.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (0L != var7) {
				var12 = Player.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = BoundaryObject.Entity_unpackID(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					Player.scene.removeBoundaryObject(var0, var2, var3);
					var13 = class215.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3497(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					Player.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					Player.scene.removeGameObject(var0, var2, var3);
					var13 = class215.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					Player.scene.removeFloorDecoration(var0, var2, var3);
					var13 = class215.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3527(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				Client.addPendingGameObject(var0, var12, var2, var3, var4, var5, var6, Player.scene, Client.collisionMaps[var0]);
			}
		}

	}
}
