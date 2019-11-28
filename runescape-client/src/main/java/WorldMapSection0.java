import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("bi")
	@Export("otp")
	static String otp;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 794568467
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1084191983
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1594820829
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -937429385
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1148101127
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 253679643
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1649308031
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 842286875
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 491567857
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1271565133
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -79221889
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1895250651
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -422163411
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2009466803
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Laf;I)V",
		garbageValue = "-567179164"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "0"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.newZ + this.oldZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "110675609"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "69"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Lhx;",
		garbageValue = "1062204141"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-179898655"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-720698828"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lhz;",
		garbageValue = "524553725"
	)
	public static ServerBuild[] method245() {
		return new ServerBuild[]{ServerBuild.WIP, ServerBuild.BUILDLIVE, ServerBuild.LIVE, ServerBuild.RC};
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1303877167"
	)
	static final void method251() {
		for (Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
			if (var0.plane == ClientPacket.Client_plane && Client.cycle <= var0.cycleEnd) {
				if (Client.cycle >= var0.cycleStart) {
					if (var0.targetIndex > 0) {
						NPC var1 = Client.npcs[var0.targetIndex - 1];
						if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
							var0.setDestination(var1.x, var1.y, class195.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					if (var0.targetIndex < 0) {
						int var2 = -var0.targetIndex - 1;
						Player var3;
						if (var2 == Client.localPlayerIndex) {
							var3 = class215.localPlayer;
						} else {
							var3 = Client.players[var2];
						}

						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
							var0.setDestination(var3.x, var3.y, class195.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					var0.advance(Client.field704);
					class2.scene.drawEntity(ClientPacket.Client_plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-137026556"
	)
	static boolean method257() {
		return (Client.drawPlayerNames & 4) != 0;
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(IIZB)V",
		garbageValue = "1"
	)
	static final void method259(int var0, int var1, boolean var2) {
		if (!var2 || var0 != CollisionMap.field2086 || SoundCache.field1438 != var1) {
			CollisionMap.field2086 = var0;
			SoundCache.field1438 = var1;
			class81.updateGameState(25);
			WorldMapIcon_1.drawLoadingMessage("Loading - please wait.", true);
			int var3 = class51.baseX * 64;
			int var4 = VarcInt.baseY * 64;
			class51.baseX = (var0 - 6) * 8;
			VarcInt.baseY = (var1 - 6) * 8;
			int var5 = class51.baseX * 64 - var3;
			int var6 = VarcInt.baseY * 64 - var4;
			var3 = class51.baseX * 64;
			var4 = VarcInt.baseY * 64;

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
			class30.cameraX -= var5 << 7;
			FloorDecoration.cameraZ -= var6 << 7;
			class80.oculusOrbFocalPointX -= var5 << 7;
			class81.oculusOrbFocalPointY -= var6 << 7;
			Client.field867 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-57"
	)
	static final void method255(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method3035(var17, var18, var19);
			Rasterizer3D.method3055(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3035(var17, var19, var20);
			Rasterizer3D.method3055(var21, var23, var24, var17, var19, var20, var4);
		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-121"
	)
	public static boolean method254() {
		return Client.staffModLevel >= 2;
	}
}
