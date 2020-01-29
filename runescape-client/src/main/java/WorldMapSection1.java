import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
@Implements("WorldMapSection1")
public class WorldMapSection1 implements WorldMapSection {
	@ObfuscatedName("qx")
	@ObfuscatedSignature(
		signature = "Ldj;"
	)
	@Export("decimator")
	static Decimator decimator;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive15")
	static Archive archive15;
	@ObfuscatedName("ek")
	static int[] field295;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1032814753
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 161851669
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1056408349
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1194427309
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -27645919
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -290110331
	)
	@Export("regionEndY")
	int regionEndY;

	WorldMapSection1() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) {
			var1.regionLowX = this.regionEndX;
		}

		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX;
		}

		if (var1.regionLowY > this.regionEndY) {
			var1.regionLowY = this.regionEndY;
		}

		if (var1.regionHighY < this.regionEndY) {
			var1.regionHighY = this.regionEndY;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "37"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-96920779"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "911083222"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
			int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1927273541"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;IIB)Llt;",
		garbageValue = "-81"
	)
	@Export("SpriteBuffer_getSprite")
	public static Sprite SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		return !class228.method4199(var0, var1, var2) ? null : PendingSpawn.method1738();
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-301044323"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		GrandExchangeOfferUnitPriceComparator.method141();
		if (Client.renderSelf) {
			class51.addPlayerToScene(class192.localPlayer, false);
		}

		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class51.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		ItemContainer.addNpcsToScene(true);
		WorldMapData_1.method733();
		ItemContainer.addNpcsToScene(false);

		int var6;
		for (Projectile var4 = (Projectile)Client.projectiles.last(); var4 != null; var4 = (Projectile)Client.projectiles.previous()) {
			if (var4.plane == Clock.Client_plane && Client.cycle <= var4.cycleEnd) {
				if (Client.cycle >= var4.cycleStart) {
					if (var4.targetIndex > 0) {
						NPC var20 = Client.npcs[var4.targetIndex - 1];
						if (var20 != null && var20.x >= 0 && var20.x < 13312 && var20.y >= 0 && var20.y < 13312) {
							var4.setDestination(var20.x, var20.y, WorldMapSectionType.getTileHeight(var20.x, var20.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					if (var4.targetIndex < 0) {
						var6 = -var4.targetIndex - 1;
						Player var22;
						if (var6 == Client.localPlayerIndex) {
							var22 = class192.localPlayer;
						} else {
							var22 = Client.players[var6];
						}

						if (var22 != null && var22.x >= 0 && var22.x < 13312 && var22.y >= 0 && var22.y < 13312) {
							var4.setDestination(var22.x, var22.y, WorldMapSectionType.getTileHeight(var22.x, var22.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					var4.advance(Client.field707);
					ServerBuild.scene.drawEntity(Clock.Client_plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1L, false);
				}
			} else {
				var4.remove();
			}
		}

		Tiles.method1156();
		GrandExchangeOfferUnitPriceComparator.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var5;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var14;
		int var19;
		if (!Client.isCameraLocked) {
			var19 = Client.camAngleX;
			if (Client.field818 / 256 > var19) {
				var19 = Client.field818 / 256;
			}

			if (Client.field775[4] && Client.field699[4] + 128 > var19) {
				var19 = Client.field699[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = PendingSpawn.oculusOrbFocalPointX;
			var7 = WorldMapSectionType.field166;
			var8 = Skeleton.oculusOrbFocalPointY;
			var9 = var19 * 3 + 600;
			var10 = Canvas.method864(var9, var3);
			var11 = 2048 - var19 & 2047;
			var12 = 2048 - var5 & 2047;
			int var13 = 0;
			var14 = 0;
			int var15 = var10;
			int var16;
			int var17;
			int var18;
			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var17 * var14 - var10 * var16 >> 16;
				var15 = var16 * var14 + var17 * var10 >> 16;
				var14 = var18;
			}

			if (var12 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var12];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var18 = var17 * var13 + var15 * var16 >> 16;
				var15 = var15 * var17 - var13 * var16 >> 16;
				var13 = var18;
			}

			HitSplatDefinition.cameraX = var6 - var13;
			class51.cameraY = var7 - var14;
			Actor.cameraZ = var8 - var15;
			GrandExchangeOffer.cameraPitch = var19;
			FriendSystem.cameraYaw = var5;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (PendingSpawn.oculusOrbFocalPointX >> 7 != class192.localPlayer.x >> 7 || Skeleton.oculusOrbFocalPointY >> 7 != class192.localPlayer.y >> 7)) {
				var16 = class192.localPlayer.plane;
				var17 = Messages.baseX * 64 + (PendingSpawn.oculusOrbFocalPointX >> 7);
				var18 = Language.baseY * 64 + (Skeleton.oculusOrbFocalPointY >> 7);
				WorldMapRegion.method563(var17, var18, var16, true);
			}
		}

		if (!Client.isCameraLocked) {
			var19 = class96.method2346();
		} else {
			if (WorldMapSection2.clientPreferences.roofsHidden) {
				var5 = Clock.Client_plane;
			} else {
				var6 = WorldMapSectionType.getTileHeight(HitSplatDefinition.cameraX, Actor.cameraZ, Clock.Client_plane);
				if (var6 - class51.cameraY < 800 && (Tiles.Tiles_renderFlags[Clock.Client_plane][HitSplatDefinition.cameraX >> 7][Actor.cameraZ >> 7] & 4) != 0) {
					var5 = Clock.Client_plane;
				} else {
					var5 = 3;
				}
			}

			var19 = var5;
		}

		var5 = HitSplatDefinition.cameraX;
		var6 = class51.cameraY;
		var7 = Actor.cameraZ;
		var8 = GrandExchangeOffer.cameraPitch;
		var9 = FriendSystem.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field775[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field892[var10] * 2 + 1) - (double)Client.field892[var10] + Math.sin((double)Client.field895[var10] * ((double)Client.field894[var10] / 100.0D)) * (double)Client.field699[var10]);
				if (var10 == 0) {
					HitSplatDefinition.cameraX += var11;
				}

				if (var10 == 1) {
					class51.cameraY += var11;
				}

				if (var10 == 2) {
					Actor.cameraZ += var11;
				}

				if (var10 == 3) {
					FriendSystem.cameraYaw = var11 + FriendSystem.cameraYaw & 2047;
				}

				if (var10 == 4) {
					GrandExchangeOffer.cameraPitch += var11;
					if (GrandExchangeOffer.cameraPitch < 128) {
						GrandExchangeOffer.cameraPitch = 128;
					}

					if (GrandExchangeOffer.cameraPitch > 383) {
						GrandExchangeOffer.cameraPitch = 383;
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
			Message.method1246(var10 - var0, var11 - var1);
		} else {
			ViewportMouse.ViewportMouse_isInViewport = false;
			ViewportMouse.ViewportMouse_entityCount = 0;
		}

		UserComparator3.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		UserComparator3.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		ServerBuild.scene.draw(HitSplatDefinition.cameraX, class51.cameraY, Actor.cameraZ, GrandExchangeOffer.cameraPitch, FriendSystem.cameraYaw, var19);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		UserComparator3.playPcmPlayers();
		ServerBuild.scene.clearTempGameObjects();
		class208.method4017(var0, var1, var2, var3);
		if (Client.hintArrowType == 2) {
			MouseRecorder.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - Messages.baseX * 64 << 7), (Client.hintArrowY - Language.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				SecureRandomCallable.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field707);
		RouteStrategy.method3662(var0, var1, var2, var3);
		HitSplatDefinition.cameraX = var5;
		class51.cameraY = var6;
		Actor.cameraZ = var7;
		GrandExchangeOffer.cameraPitch = var8;
		FriendSystem.cameraYaw = var9;
		if (Client.isLoading) {
			byte var21 = 0;
			var14 = var21 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
			if (var14 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class197.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
