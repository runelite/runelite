import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("Tile")
public final class Tile extends Node {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1309939485
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 2038032895
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1013860717
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -371358755
	)
	@Export("originalPlane")
	int originalPlane;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("paint")
	TilePaint paint;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Ldk;"
	)
	@Export("model")
	TileModel model;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("boundaryObject")
	BoundaryObject boundaryObject;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lei;"
	)
	@Export("wallDecoration")
	WallDecoration wallDecoration;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("floorDecoration")
	FloorDecoration floorDecoration;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Ldy;"
	)
	@Export("tileItemPile")
	TileItemPile tileItemPile;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1638075719
	)
	@Export("gameObjectsCount")
	int gameObjectsCount;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Lex;"
	)
	@Export("gameObjects")
	GameObject[] gameObjects;
	@ObfuscatedName("h")
	@Export("gameObjectEdgeMasks")
	int[] gameObjectEdgeMasks;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2114693013
	)
	@Export("gameObjectsEdgeMask")
	int gameObjectsEdgeMask;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1476239689
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("j")
	@Export("drawPrimary")
	boolean drawPrimary;
	@ObfuscatedName("r")
	@Export("drawSecondary")
	boolean drawSecondary;
	@ObfuscatedName("e")
	@Export("drawGameObjects")
	boolean drawGameObjects;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1357741969
	)
	@Export("drawGameObjectEdges")
	int drawGameObjectEdges;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1034029719
	)
	int field1638;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 772889311
	)
	int field1639;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1173456745
	)
	int field1637;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("linkedBelowTile")
	Tile linkedBelowTile;

	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5];
		this.gameObjectEdgeMasks = new int[5];
		this.gameObjectsEdgeMask = 0;
		this.originalPlane = this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "59620731"
	)
	static void method3021(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		NetFileRequest var4 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var2);
		if (var4 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-2"
	)
	public static void method3023() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < JagexCache.idxCount; ++var0) {
				ArchiveLoader.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "104"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				WorldMapID.client.method1029();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field666 = 0;
				Client.field667 = 0;
				Client.timer.method5118(var0);
				if (var0 != 20) {
					WorldMapLabelSize.method235(false);
				}
			}

			if (var0 != 20 && var0 != 40 && Tiles.field499 != null) {
				Tiles.field499.close();
				Tiles.field499 = null;
			}

			if (Client.gameState == 25) {
				Client.field688 = 0;
				Client.field684 = 0;
				Client.field685 = 1;
				Client.field686 = 0;
				Client.field687 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					AttackOption.method2218(WorldMapID.archive10, GrandExchangeOfferUnitPriceComparator.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					AttackOption.method2218(WorldMapID.archive10, GrandExchangeOfferUnitPriceComparator.archive8, false, 4);
				} else {
					Coord.method4144();
				}
			} else {
				AttackOption.method2218(WorldMapID.archive10, GrandExchangeOfferUnitPriceComparator.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(Liv;IIII)V",
		garbageValue = "-723801001"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}
}
