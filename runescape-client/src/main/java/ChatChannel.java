import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -899235317
	)
	public static int field1289;
	@ObfuscatedName("k")
	public static String[] field1291;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lbn;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -2026360781
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lbn;",
		garbageValue = "0"
	)
	@Export("addMessage")
	Message addMessage(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.remove();
			var5.removeDual();
			var5.set(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lbn;",
		garbageValue = "187354939"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "40"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "-1620265194"
	)
	static final void method2302(int var0, int var1, boolean var2) {
		if (!var2 || var0 != SecureRandomCallable.field530 || Language.field2359 != var1) {
			SecureRandomCallable.field530 = var0;
			Language.field2359 = var1;
			Projectile.updateGameState(25);
			class197.drawLoadingMessage("Loading - please wait.", true);
			int var3 = Messages.baseX * 64;
			int var4 = Language.baseY * 64;
			Messages.baseX = (var0 - 6) * 8;
			Language.baseY = (var1 - 6) * 8;
			int var5 = Messages.baseX * 64 - var3;
			int var6 = Language.baseY * 64 - var4;
			var3 = Messages.baseX * 64;
			var4 = Language.baseY * 64;

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
					int var15 = var13 + var5;
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
			HitSplatDefinition.cameraX -= var5 << 7;
			Actor.cameraZ -= var6 << 7;
			PendingSpawn.oculusOrbFocalPointX -= var5 << 7;
			Skeleton.oculusOrbFocalPointY -= var6 << 7;
			Client.field704 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}
}
