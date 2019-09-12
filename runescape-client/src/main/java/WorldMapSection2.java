import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1621014075
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 95944325
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 328290097
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1641271017
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 116585611
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -711757521
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -2106568339
	)
	int field188;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -337977875
	)
	int field194;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1222985831
	)
	int field192;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 117453229
	)
	int field197;

	WorldMapSection2() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lag;S)V",
		garbageValue = "32767"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field188) {
			var1.regionLowX = this.field188;
		}

		if (var1.regionHighX < this.field192) {
			var1.regionHighX = this.field192;
		}

		if (var1.regionLowY > this.field194) {
			var1.regionLowY = this.field194;
		}

		if (var1.regionHighY < this.field197) {
			var1.regionHighY = this.field197;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "950167825"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1510325414"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field188 && var1 >> 6 <= this.field192 && var2 >> 6 >= this.field194 && var2 >> 6 <= this.field197;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-771447481"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field188 * 64 - this.regionStartX * 64 + var2, var3 + (this.field194 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "0"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field188 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field194 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1954302512"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field188 = var1.readUnsignedShort();
		this.field194 = var1.readUnsignedShort();
		this.field192 = var1.readUnsignedShort();
		this.field197 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1220546976"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2084291439"
	)
	public static int method300() {
		return ViewportMouse.ViewportMouse_entityCount;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "542891198"
	)
	static final void method283(String var0) {
		WorldMapCacheName.addGameMessage(30, "", var0);
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(Lbe;B)V",
		garbageValue = "-68"
	)
	static final void method299(Actor var0) {
		int var1 = var0.field963 - Client.cycle;
		int var2 = var0.field959 * 128 + var0.size * 64;
		int var3 = var0.field961 * 128 + var0.size * 64;
		var0.x += (var2 - -78439701 * var0.x) / var1 * 62504387;
		var0.y += (var3 - var0.y) / var1;
		var0.field975 = 0;
		var0.orientation = var0.field965;
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(IIZI)V",
		garbageValue = "882857989"
	)
	static final void method301(int var0, int var1, boolean var2) {
		if (!var2 || var0 != FloorDecoration.field1585 || ReflectionCheck.field1303 != var1) {
			FloorDecoration.field1585 = var0;
			ReflectionCheck.field1303 = var1;
			WorldMapIcon_0.updateGameState(25);
			GZipDecompressor.drawLoadingMessage("Loading - please wait.", true);
			int var3 = class4.baseX * 64;
			int var4 = ScriptEvent.baseY;
			class4.baseX = (var0 - 6) * 8;
			ScriptEvent.baseY = (var1 - 6) * 167776904;
			int var5 = class4.baseX * 64 - var3;
			int var6 = ScriptEvent.baseY - var4;
			var3 = class4.baseX * 64;
			var4 = ScriptEvent.baseY;

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

					var8.x -= var5 * -589373056;
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

					var21.x -= var5 * -589373056;
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
					int var15 = var13 + var5;
					int var16 = var14 + var6;

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
			ScriptFrame.cameraX -= var5 << 7;
			class14.cameraZ -= var6 << 7;
			SecureRandomFuture.oculusOrbFocalPointX -= var5 << 7;
			AbstractByteArrayCopier.oculusOrbFocalPointY -= var6 << 7;
			Client.field848 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}
}
