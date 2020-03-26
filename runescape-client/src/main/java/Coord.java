import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 301187265
	)
	public static int field2530;
	@ObfuscatedName("cd")
	public static char field2531;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 762647407
	)
	@Export("y")
	public int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 660497933
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1808182037
	)
	@Export("x")
	public int x;

	@ObfuscatedSignature(
		signature = "(Lhj;)V"
	)
	public Coord(Coord var1) {
		this.plane = var1.plane;
		this.x = var1.x;
		this.y = var1.y;
	}

	public Coord(int var1, int var2, int var3) {
		this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	public Coord(int var1) {
		if (var1 == -1) {
			this.plane = -1;
		} else {
			this.plane = var1 >> 28 & 3;
			this.x = var1 >> 14 & 16383;
			this.y = var1 & 16383;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1927907066"
	)
	@Export("packed")
	public int packed() {
		return this.plane << 28 | this.x << 14 | this.y;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhj;I)Z",
		garbageValue = "-2112462573"
	)
	@Export("equalsCoord")
	boolean equalsCoord(Coord var1) {
		if (this.plane != var1.plane) {
			return false;
		} else if (this.x != var1.x) {
			return false;
		} else {
			return this.y == var1.y;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "404618696"
	)
	@Export("toString")
	String toString(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
		}
	}

	public String toString() {
		return this.toString(",");
	}

	public int hashCode() {
		return this.packed();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)[Lie;",
		garbageValue = "112"
	)
	static VerticalAlignment[] method4084() {
		return new VerticalAlignment[]{VerticalAlignment.field3193, VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3196};
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1911582516"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (ByteArrayPool.localPlayer.x >> 7 == Client.destinationX && ByteArrayPool.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		if (Client.renderSelf) {
			class22.addPlayerToScene(ByteArrayPool.localPlayer, false);
		}

		WorldMapCacheName.method716();
		Messages.addNpcsToScene(true);
		int var4 = Players.Players_count;
		int[] var5 = Players.Players_indices;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
				class22.addPlayerToScene(Client.players[var5[var6]], true);
			}
		}

		Messages.addNpcsToScene(false);

		for (Projectile var19 = (Projectile)Client.projectiles.last(); var19 != null; var19 = (Projectile)Client.projectiles.previous()) {
			if (var19.plane == ScriptEvent.Client_plane && Client.cycle <= var19.cycleEnd) {
				if (Client.cycle >= var19.cycleStart) {
					if (var19.targetIndex > 0) {
						NPC var21 = Client.npcs[var19.targetIndex - 1];
						if (var21 != null && var21.x >= 0 && var21.x < 13312 && var21.y >= 0 && var21.y < 13312) {
							var19.setDestination(var21.x, var21.y, class277.getTileHeight(var21.x, var21.y, var19.plane) - var19.endHeight, Client.cycle);
						}
					}

					if (var19.targetIndex < 0) {
						var6 = -var19.targetIndex - 1;
						Player var22;
						if (var6 == Client.localPlayerIndex) {
							var22 = ByteArrayPool.localPlayer;
						} else {
							var22 = Client.players[var6];
						}

						if (var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
							var19.setDestination(var22.x, var22.y, class277.getTileHeight(var22.x, var22.y, var19.plane) - var19.endHeight, Client.cycle);
						}
					}

					var19.advance(Client.field741);
					GrandExchangeOfferWorldComparator.scene.drawEntity(ScriptEvent.Client_plane, (int)var19.x, (int)var19.y, (int)var19.z, 60, var19, var19.yaw, -1L, false);
				}
			} else {
				var19.remove();
			}
		}

		GrandExchangeOfferAgeComparator.method249();
		class204.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var20;
		if (!Client.isCameraLocked) {
			var4 = Client.camAngleX;
			if (Client.field941 / 256 > var4) {
				var4 = Client.field941 / 256;
			}

			if (Client.field926[4] && Client.field730[4] + 128 > var4) {
				var4 = Client.field730[4] + 128;
			}

			var20 = Client.camAngleY & 2047;
			var6 = SoundSystem.oculusOrbFocalPointX;
			var7 = Client.field756;
			var8 = ServerPacket.oculusOrbFocalPointY;
			var9 = var4 * 3 + 600;
			var10 = Varcs.method2295(var9, var3);
			var11 = 2048 - var4 & 2047;
			var12 = 2048 - var20 & 2047;
			int var13 = 0;
			int var14 = 0;
			int var15 = var10;
			int var16;
			int var17;
			int var18;
			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var14 * var17 - var16 * var10 >> 16;
				var15 = var16 * var14 + var10 * var17 >> 16;
				var14 = var18;
			}

			if (var12 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var12];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var18 = var17 * var13 + var16 * var15 >> 16;
				var15 = var17 * var15 - var16 * var13 >> 16;
				var13 = var18;
			}

			WorldMapRectangle.cameraX = var6 - var13;
			GrandExchangeOfferWorldComparator.cameraY = var7 - var14;
			class200.cameraZ = var8 - var15;
			class74.cameraPitch = var4;
			WorldMapIcon_1.cameraYaw = var20;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (SoundSystem.oculusOrbFocalPointX >> 7 != ByteArrayPool.localPlayer.x >> 7 || ServerPacket.oculusOrbFocalPointY >> 7 != ByteArrayPool.localPlayer.y >> 7)) {
				var16 = ByteArrayPool.localPlayer.plane;
				var17 = (SoundSystem.oculusOrbFocalPointX >> 7) + class69.baseX;
				var18 = (ServerPacket.oculusOrbFocalPointY >> 7) + class89.baseY;
				GrandExchangeOfferWorldComparator.method148(var17, var18, var16, true);
			}
		}

		if (!Client.isCameraLocked) {
			var4 = UserComparator8.method3503();
		} else {
			var4 = Tiles.method1238();
		}

		var20 = WorldMapRectangle.cameraX;
		var6 = GrandExchangeOfferWorldComparator.cameraY;
		var7 = class200.cameraZ;
		var8 = class74.cameraPitch;
		var9 = WorldMapIcon_1.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field926[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field788[var10] * 2 + 1) - (double)Client.field788[var10] + Math.sin((double)Client.field929[var10] / 100.0D * (double)Client.field930[var10]) * (double)Client.field730[var10]);
				if (var10 == 0) {
					WorldMapRectangle.cameraX += var11;
				}

				if (var10 == 1) {
					GrandExchangeOfferWorldComparator.cameraY += var11;
				}

				if (var10 == 2) {
					class200.cameraZ += var11;
				}

				if (var10 == 3) {
					WorldMapIcon_1.cameraYaw = var11 + WorldMapIcon_1.cameraYaw & 2047;
				}

				if (var10 == 4) {
					class74.cameraPitch += var11;
					if (class74.cameraPitch < 128) {
						class74.cameraPitch = 128;
					}

					if (class74.cameraPitch > 383) {
						class74.cameraPitch = 383;
					}
				}
			}
		}

		var10 = MouseHandler.MouseHandler_x;
		var11 = MouseHandler.MouseHandler_y;
		if (MouseHandler.MouseHandler_lastButton != 0) {
			var10 = MouseHandler.MouseHandler_lastPressedX;
			var11 = MouseHandler.MouseHandler_lastPressedY;
		}

		if (var10 >= var0 && var10 < var0 + var2 && var11 >= var1 && var11 < var3 + var1) {
			AbstractSocket.method5886(var10 - var0, var11 - var1);
		} else {
			GameShell.method1155();
		}

		ChatChannel.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		ChatChannel.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		GrandExchangeOfferWorldComparator.scene.draw(WorldMapRectangle.cameraX, GrandExchangeOfferWorldComparator.cameraY, class200.cameraZ, class74.cameraPitch, WorldMapIcon_1.cameraYaw, var4);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		ChatChannel.playPcmPlayers();
		GrandExchangeOfferWorldComparator.scene.clearTempGameObjects();
		MouseHandler.method1202(var0, var1, var2, var3);
		UserComparator4.method3490(var0, var1);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field741);
		UserComparator5.method3523(var0, var1, var2, var3);
		WorldMapRectangle.cameraX = var20;
		GrandExchangeOfferWorldComparator.cameraY = var6;
		class200.cameraZ = var7;
		class74.cameraPitch = var8;
		WorldMapIcon_1.cameraYaw = var9;
		if (Client.isLoading && WorldMapLabelSize.method292(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			AbstractByteArrayCopier.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
