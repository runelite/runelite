import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("ModelData0")
public class ModelData0 {
	@ObfuscatedName("gq")
	@Export("xteaKeys")
	static int[][] xteaKeys;

	ModelData0() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SIII)V",
		garbageValue = "-2014451002"
	)
	@Export("sortItemsByName")
	public static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhp;",
		garbageValue = "927119221"
	)
	@Export("getWidgetChild")
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = WorldMapElement.getWidget(var0);
		if (var1 == -1) {
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
		}
	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1772928872"
	)
	@Export("drawProjectiles")
	static final void drawProjectiles() {
		for (Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
			if (var0.plane == ItemContainer.plane && Client.cycle <= var0.cycleEnd) {
				if (Client.cycle >= var0.cycleStart) {
					if (var0.targetIndex > 0) {
						NPC var1 = Client.npcs[var0.targetIndex - 1];
						if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
							var0.setDestination(var1.x, var1.y, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					if (var0.targetIndex < 0) {
						int var2 = -var0.targetIndex - 1;
						Player var3;
						if (var2 == Client.localPlayerIndex) {
							var3 = WorldMapIcon_1.localPlayer;
						} else {
							var3 = Client.players[var2];
						}

						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
							var0.setDestination(var3.x, var3.y, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					var0.advance(Client.field879);
					Player.scene.drawEntity(ItemContainer.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "1845013682"
	)
	static final void method3198(int var0, int var1, boolean var2) {
		if (!var2 || var0 != class13.field86 || class16.field101 != var1) {
			class13.field86 = var0;
			class16.field101 = var1;
			FloorDecoration.updateGameState(25);
			MusicPatch.drawLoadingMessage("Loading - please wait.", true);
			int var3 = PacketWriter.baseX * 64;
			int var4 = RouteStrategy.baseY * 64;
			PacketWriter.baseX = (var0 - 6) * 8;
			RouteStrategy.baseY = (var1 - 6) * 8;
			int var5 = PacketWriter.baseX * 64 - var3;
			int var6 = RouteStrategy.baseY * 64 - var4;
			var3 = PacketWriter.baseX * 64;
			var4 = RouteStrategy.baseY * 64;

			int var7;
			int var9;
			int[] var10000;
			for (var7 = 0; var7 < 32768; ++var7) {
				NPC var8 = Client.npcs[var7];
				if (var8 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var8.pathX;
						var10000[var9] -= var5;
						var10000 = var8.pathY;
						var10000[var9] -= var6;
					}

					var8.x -= var5 * 128;
					var8.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var21.pathX;
						var10000[var9] -= var5;
						var10000 = var21.pathY;
						var10000[var9] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var20 = 0;
			byte var18 = 104;
			byte var22 = 1;
			if (var5 < 0) {
				var20 = 103;
				var18 = -1;
				var22 = -1;
			}

			byte var10 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var6 < 0) {
				var10 = 103;
				var11 = -1;
				var12 = -1;
			}

			int var14;
			for (int var13 = var20; var18 != var13; var13 += var22) {
				for (var14 = var10; var11 != var14; var14 += var12) {
					int var15 = var5 + var13;
					int var16 = var6 + var14;

					for (int var17 = 0; var17 < 4; ++var17) {
						if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
							Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
						} else {
							Client.groundItems[var17][var13][var14] = null;
						}
					}
				}
			}

			for (PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
				var19.x -= var5;
				var19.y -= var6;
				if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
					var19.remove();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.isCameraLocked = false;
			WallDecoration.cameraX -= var5 << 7;
			UserComparator7.cameraZ -= var6 << 7;
			DynamicObject.oculusOrbFocalPointX -= var5 << 7;
			FriendSystem.oculusOrbFocalPointY -= var6 << 7;
			Client.field651 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "-38"
	)
	static void method3201(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, FontName.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != WorldMapIcon_1.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.method5545(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5432(var3[var6]);
					var8.packetBuffer.method5545(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5443(var3[var6]);
					var8.packetBuffer.method5435(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5435(0);
					var8.packetBuffer.writeShortLE(var3[var6]);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			DirectByteArrayCopier.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
