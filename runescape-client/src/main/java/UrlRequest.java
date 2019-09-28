import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -535227307
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("crossSprites")
	static Sprite[] crossSprites;
	@ObfuscatedName("z")
	@Export("url")
	final URL url;
	@ObfuscatedName("n")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("v")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "737522726"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-213988486"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "142413926"
	)
	public static void method3269() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3127 != 0) {
				ArchiveDiskActionHandler.field3127 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "-1347303356"
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
				var4.field621 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (class223.baseX * 64 + var4.pathX[0] >> 13 << 14) + (class286.baseY * 64 + var4.pathY[0] >> 13);
				if (var4.field957 != -1) {
					Players.Players_orientations[var1] = var4.field957;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					class290.updateExternalPlayer(var0, var1);
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
						var4.field621 = true;
						var4.tileX = var6;
						var4.tileY = var7;
					} else {
						var4.field621 = false;
						var4.method1274(var6, var7, Players.field1235[var1]);
					}
				} else {
					var4.resetPath(var6, var7);
					var4.field621 = false;
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
					var4.field621 = false;
				} else if (var2) {
					var4.field621 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field621 = false;
					var4.method1274(var6, var7, Players.field1235[var1]);
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
					if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
						var4.resetPath(var10, var11);
						var4.field621 = false;
					} else if (var2) {
						var4.field621 = true;
						var4.tileX = var10;
						var4.tileY = var11;
					} else {
						var4.field621 = false;
						var4.method1274(var10, var11, Players.field1235[var1]);
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						WorldMapRectangle.plane = var4.plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (class223.baseX * 64 + var8 + var4.pathX[0] & 16383) - class223.baseX * 64;
					var11 = (class286.baseY * 64 + var9 + var4.pathY[0] & 16383) - class286.baseY * 64;
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field621 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field621 = false;
							var4.method1274(var10, var11, Players.field1235[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field621 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						WorldMapRectangle.plane = var4.plane;
					}

				}
			}
		}
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	static void method3279() {
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			Players.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(Lho;Lit;IIZI)V",
		garbageValue = "-1977494158"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			AttackOption.insertMenuItem(var7, World.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}
