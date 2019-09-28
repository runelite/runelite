import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class289 {
	@ObfuscatedName("z")
	static char[] field3641;
	@ObfuscatedName("n")
	static char[] field3643;
	@ObfuscatedName("v")
	static char[] field3642;
	@ObfuscatedName("u")
	static int[] field3640;

	static {
		field3641 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field3641[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3641[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3641[var0] = (char)(var0 + 48 - 52);
		}

		field3641[62] = '+';
		field3641[63] = '/';
		field3643 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3643[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3643[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3643[var0] = (char)(var0 + 48 - 52);
		}

		field3643[62] = '*';
		field3643[63] = '-';
		field3642 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field3642[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field3642[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field3642[var0] = (char)(var0 + 48 - 52);
		}

		field3642[62] = '-';
		field3642[63] = '_';
		field3640 = new int[128];

		for (var0 = 0; var0 < field3640.length; ++var0) {
			field3640[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field3640[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field3640[var0] = var0 - 97 + 26;
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field3640[var0] = var0 - 48 + 52;
		}

		int[] var2 = field3640;
		field3640[43] = 62;
		var2[42] = 62;
		int[] var1 = field3640;
		field3640[47] = 63;
		var1[45] = 63;
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-1781394642"
	)
	static final void method5228(int var0, int var1, boolean var2) {
		if (!var2 || var0 != ServerPacket.field2131 || MusicPatchNode.field2422 != var1) {
			ServerPacket.field2131 = var0;
			MusicPatchNode.field2422 = var1;
			MouseRecorder.updateGameState(25);
			WorldMapSprite.drawLoadingMessage("Loading - please wait.", true);
			int var3 = class223.baseX * 64;
			int var4 = class286.baseY * 64;
			class223.baseX = (var0 - 6) * 8;
			class286.baseY = (var1 - 6) * 8;
			int var5 = class223.baseX * 64 - var3;
			int var6 = class286.baseY * 64 - var4;
			var3 = class223.baseX * 64;
			var4 = class286.baseY * 64;

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
			for (int var13 = var20; var13 != var18; var13 += var22) {
				for (var14 = var10; var14 != var11; var14 += var12) {
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
			GrandExchangeOfferOwnWorldComparator.cameraX -= var5 << 7;
			WorldMapIcon_1.cameraZ -= var6 << 7;
			ObjectSound.oculusOrbFocalPointX -= var5 << 7;
			class14.oculusOrbFocalPointY -= var6 << 7;
			Client.field643 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}
}
