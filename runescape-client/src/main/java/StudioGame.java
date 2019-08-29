import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhv;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("t")
	@Export("name")
	public final String name;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1258776417
	)
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-32"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Lie;",
		garbageValue = "1021508128"
	)
	@Export("FloorUnderlayDefinition_get")
	public static FloorUnderlayDefinition FloorUnderlayDefinition_get(int var0) {
		FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
			var1 = new FloorUnderlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZB)V",
		garbageValue = "4"
	)
	static void method4056(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field404.startsWith("win") && !var3) {
				GrandExchangeOffer.method109(var0, 0);
				return;
			}

			if (class51.field404.startsWith("mac")) {
				WorldMapSection0.method232(var0, 1, var2);
				return;
			}

			WorldMapSection0.method232(var0, 2, "openjs");
		} else {
			GrandExchangeOffer.method109(var0, 3);
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkx;II)V",
		garbageValue = "-990783681"
	)
	@Export("readPlayerUpdate")
	static void readPlayerUpdate(PacketBuffer var0, int var1) {
		boolean var2 = var0.readBits(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.readBits(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.field614 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (PacketWriter.baseX * 64 + var4.pathX[0] >> 13 << 14) + (RouteStrategy.baseY * 64 + var4.pathY[0] >> 13);
				if (var4.field946 != -1) {
					Players.Players_orientations[var1] = var4.field946;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					WorldMapLabelSize.updateExternalPlayer(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.readBits(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
					if (var2) {
						var4.field614 = true;
						var4.tileX = var6;
						var4.tileY = var7;
					} else {
						var4.field614 = false;
						var4.method1190(var6, var7, Players.field1230[var1]);
					}
				} else {
					var4.resetPath(var6, var7);
					var4.field614 = false;
				}

			} else if (var3 == 2) {
				var5 = var0.readBits(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field614 = false;
				} else if (var2) {
					var4.field614 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field614 = false;
					var4.method1190(var6, var7, Players.field1230[var1]);
				}

			} else {
				var5 = var0.readBits(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.readBits(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field614 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field614 = false;
							var4.method1190(var10, var11, Players.field1230[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field614 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ItemContainer.plane = var4.plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (PacketWriter.baseX * 64 + var8 + var4.pathX[0] & 16383) - PacketWriter.baseX * 64;
					var11 = (RouteStrategy.baseY * 64 + var9 + var4.pathY[0] & 16383) - RouteStrategy.baseY * 64;
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field614 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field614 = false;
							var4.method1190(var10, var11, Players.field1230[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field614 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ItemContainer.plane = var4.plane;
					}

				}
			}
		}
	}

	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-674863226"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field836 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (UserComparator7.getWindowedMode() == 1) {
			WorldMapID.client.setMaxCanvasSize(765, 503);
		} else {
			WorldMapID.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			WorldMapCacheName.method593();
		}

	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIIB)V",
		garbageValue = "-114"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			WorldMapManager.method607(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field911 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}
}
