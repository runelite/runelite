import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -513074151
	)
	@Export("PcmPlayer_count")
	static int PcmPlayer_count;
	@ObfuscatedName("ec")
	@ObfuscatedGetter(
		intValue = -1042709879
	)
	@Export("port2")
	static int port2;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 577791457
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 2080109751
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 748443287
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 6356128824356996537L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1037477129
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("er")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1136881308"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				WorldMapID.client.method891();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field658 = 0;
				Client.field659 = 0;
				Client.timer.method4899(var0);
				if (var0 != 20) {
					WorldMapArea.method358(false);
				}
			}

			if (var0 != 20 && var0 != 40 && Bounds.field3845 != null) {
				Bounds.field3845.close();
				Bounds.field3845 = null;
			}

			if (Client.gameState == 25) {
				Client.field719 = 0;
				Client.field676 = 0;
				Client.field886 = 1;
				Client.field678 = 0;
				Client.field718 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					BoundaryObject.method3213(GameObject.archive10, class2.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					BoundaryObject.method3213(GameObject.archive10, class2.archive8, false, 4);
				} else {
					DynamicObject.method2153();
				}
			} else {
				BoundaryObject.method3213(GameObject.archive10, class2.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1412444391"
	)
	static final void method2788() {
		for (PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0.hitpoints > 0) {
				--var0.hitpoints;
			}

			if (var0.hitpoints == 0) {
				if (var0.objectId < 0 || WorldMapSprite.method404(var0.objectId, var0.field903)) {
					Script.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.objectId, var0.field907, var0.field903);
					var0.remove();
				}
			} else {
				if (var0.delay > 0) {
					--var0.delay;
				}

				if (var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || WorldMapSprite.method404(var0.id, var0.field911))) {
					Script.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field911);
					var0.delay = -1;
					if (var0.id == var0.objectId && var0.objectId == -1) {
						var0.remove();
					} else if (var0.id == var0.objectId && var0.orientation == var0.field907 && var0.field903 == var0.field911) {
						var0.remove();
					}
				}
			}
		}

	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "507499403"
	)
	static final void method2786(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetXs[var4] + Client.rootWidgetWidths[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetHeights[var4] + Client.rootWidgetYs[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field703[var4] = true;
			}
		}

	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "183516662"
	)
	static void method2787(Buffer var0) {
		if (Client.randomDatData != null) {
			var0.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}
}
