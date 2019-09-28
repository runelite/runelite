import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("Friend")
public class Friend extends Buddy {
	@ObfuscatedName("z")
	boolean field3615;
	@ObfuscatedName("n")
	boolean field3614;

	Friend() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljy;I)I",
		garbageValue = "371914259"
	)
	@Export("compareToFriend")
	int compareToFriend(Friend var1) {
		if (super.world == Client.worldId && Client.worldId != var1.world) {
			return -1;
		} else if (Client.worldId == var1.world && super.world != Client.worldId) {
			return 1;
		} else if (super.world != 0 && var1.world == 0) {
			return -1;
		} else if (var1.world != 0 && super.world == 0) {
			return 1;
		} else if (this.field3615 && !var1.field3615) {
			return -1;
		} else if (!this.field3615 && var1.field3615) {
			return 1;
		} else if (this.field3614 && !var1.field3614) {
			return -1;
		} else if (!this.field3614 && var1.field3614) {
			return 1;
		} else {
			return super.world != 0 ? super.int2 - var1.int2 : var1.int2 - super.int2;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljh;I)I",
		garbageValue = "-531306911"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareToFriend((Friend)var1);
	}

	public int compareTo(Object var1) {
		return this.compareToFriend((Friend)var1);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "530220947"
	)
	static void method5148() {
		Tiles.field501 = null;
		Tiles.field483 = null;
		DevicePcmPlayerProvider.field393 = null;
		class287.field3634 = null;
		Tiles.field488 = null;
		Tiles.field486 = null;
		DevicePcmPlayerProvider.field386 = null;
		Tiles.Tiles_hue = null;
		ArchiveLoader.Tiles_saturation = null;
		Tiles.Tiles_lightness = null;
		FontName.Tiles_hueMultiplier = null;
		Tiles.field487 = null;
	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-541695875"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (class223.localPlayer.x >> 7 == Client.destinationX && class223.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		if (Client.renderSelf) {
			Players.addPlayerToScene(class223.localPlayer, false);
		}

		UrlRequest.method3279();
		class4.addNpcsToScene(true);
		Login.method2114();
		class4.addNpcsToScene(false);
		DynamicObject.method2225();

		for (GraphicsObject var4 = (GraphicsObject)Client.graphicsObjects.last(); var4 != null; var4 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var4.plane == WorldMapRectangle.plane && !var4.isFinished) {
				if (Client.cycle >= var4.cycleStart) {
					var4.advance(Client.field698);
					if (var4.isFinished) {
						var4.remove();
					} else {
						PacketWriter.scene.drawEntity(var4.plane, var4.x, var4.y, var4.height, 60, var4, 0, -1L, false);
					}
				}
			} else {
				var4.remove();
			}
		}

		AbstractByteArrayCopier.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var5;
		int var6;
		int var7;
		int var8;
		int var11;
		int var15;
		if (!Client.isCameraLocked) {
			var15 = Client.camAngleX;
			if (Client.field722 / 256 > var15) {
				var15 = Client.field722 / 256;
			}

			if (Client.field835[4] && Client.field883[4] + 128 > var15) {
				var15 = Client.field883[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = ObjectSound.oculusOrbFocalPointX;
			var7 = ModelData0.field1840;
			var8 = class14.oculusOrbFocalPointY;
			var11 = var15 * 3 + 600;
			NPCDefinition.method4677(var6, var7, var8, var15, var5, var11, var3);
		}

		int var9;
		int var10;
		int var12;
		int var13;
		int var14;
		if (!Client.isCameraLocked) {
			if (AbstractArchive.clientPreferences.roofsHidden) {
				var5 = WorldMapRectangle.plane;
			} else {
				label409: {
					var6 = 3;
					if (IgnoreList.cameraPitch < 310) {
						if (Client.oculusOrbState == 1) {
							var7 = ObjectSound.oculusOrbFocalPointX >> 7;
							var8 = class14.oculusOrbFocalPointY >> 7;
						} else {
							var7 = class223.localPlayer.x >> 7;
							var8 = class223.localPlayer.y >> 7;
						}

						var9 = GrandExchangeOfferOwnWorldComparator.cameraX >> 7;
						var10 = WorldMapIcon_1.cameraZ >> 7;
						if (var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
							var5 = WorldMapRectangle.plane;
							break label409;
						}

						if (var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
							var5 = WorldMapRectangle.plane;
							break label409;
						}

						if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][var9][var10] & 4) != 0) {
							var6 = WorldMapRectangle.plane;
						}

						if (var7 > var9) {
							var11 = var7 - var9;
						} else {
							var11 = var9 - var7;
						}

						if (var8 > var10) {
							var12 = var8 - var10;
						} else {
							var12 = var10 - var8;
						}

						if (var11 > var12) {
							var13 = var12 * 65536 / var11;
							var14 = 32768;

							while (var7 != var9) {
								if (var9 < var7) {
									++var9;
								} else if (var9 > var7) {
									--var9;
								}

								if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][var9][var10] & 4) != 0) {
									var6 = WorldMapRectangle.plane;
								}

								var14 += var13;
								if (var14 >= 65536) {
									var14 -= 65536;
									if (var10 < var8) {
										++var10;
									} else if (var10 > var8) {
										--var10;
									}

									if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][var9][var10] & 4) != 0) {
										var6 = WorldMapRectangle.plane;
									}
								}
							}
						} else if (var12 > 0) {
							var13 = var11 * 65536 / var12;
							var14 = 32768;

							while (var8 != var10) {
								if (var10 < var8) {
									++var10;
								} else if (var10 > var8) {
									--var10;
								}

								if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][var9][var10] & 4) != 0) {
									var6 = WorldMapRectangle.plane;
								}

								var14 += var13;
								if (var14 >= 65536) {
									var14 -= 65536;
									if (var9 < var7) {
										++var9;
									} else if (var9 > var7) {
										--var9;
									}

									if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][var9][var10] & 4) != 0) {
										var6 = WorldMapRectangle.plane;
									}
								}
							}
						}
					}

					if (class223.localPlayer.x >= 0 && class223.localPlayer.y >= 0 && class223.localPlayer.x < 13312 && class223.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[WorldMapRectangle.plane][class223.localPlayer.x >> 7][class223.localPlayer.y >> 7] & 4) != 0) {
							var6 = WorldMapRectangle.plane;
						}

						var5 = var6;
					} else {
						var5 = WorldMapRectangle.plane;
					}
				}
			}

			var15 = var5;
		} else {
			var15 = class208.getHighestVisiblePlane();
		}

		var5 = GrandExchangeOfferOwnWorldComparator.cameraX;
		var6 = Varcs.cameraY;
		var7 = WorldMapIcon_1.cameraZ;
		var8 = IgnoreList.cameraPitch;
		var9 = WorldMapSection2.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field835[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field882[var10] * 2 + 1) - (double)Client.field882[var10] + Math.sin((double)Client.field884[var10] / 100.0D * (double)Client.field885[var10]) * (double)Client.field883[var10]);
				if (var10 == 0) {
					GrandExchangeOfferOwnWorldComparator.cameraX += var11;
				}

				if (var10 == 1) {
					Varcs.cameraY += var11;
				}

				if (var10 == 2) {
					WorldMapIcon_1.cameraZ += var11;
				}

				if (var10 == 3) {
					WorldMapSection2.cameraYaw = var11 + WorldMapSection2.cameraYaw & 2047;
				}

				if (var10 == 4) {
					IgnoreList.cameraPitch += var11;
					if (IgnoreList.cameraPitch < 128) {
						IgnoreList.cameraPitch = 128;
					}

					if (IgnoreList.cameraPitch > 383) {
						IgnoreList.cameraPitch = 383;
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
			WorldMapSection1.method582(var10 - var0, var11 - var1);
		} else {
			MenuAction.method2066();
		}

		WorldMapID.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		WorldMapID.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		PacketWriter.scene.draw(GrandExchangeOfferOwnWorldComparator.cameraX, Varcs.cameraY, WorldMapIcon_1.cameraZ, IgnoreList.cameraPitch, WorldMapSection2.cameraYaw, var15);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		WorldMapID.playPcmPlayers();
		PacketWriter.scene.clearTempGameObjects();
		ViewportMouse.method2954(var0, var1, var2, var3);
		Message.method1231(var0, var1);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field698);
		Client.field634 = 0;
		var13 = class223.baseX * 64 + (class223.localPlayer.x >> 7);
		var14 = class286.baseY * 64 + (class223.localPlayer.y >> 7);
		if (var13 >= 3053 && var13 <= 3156 && var14 >= 3056 && var14 <= 3136) {
			Client.field634 = 1;
		}

		if (var13 >= 3072 && var13 <= 3118 && var14 >= 9492 && var14 <= 9535) {
			Client.field634 = 1;
		}

		if (Client.field634 == 1 && var13 >= 3139 && var13 <= 3199 && var14 >= 3008 && var14 <= 3062) {
			Client.field634 = 0;
		}

		GrandExchangeOfferOwnWorldComparator.cameraX = var5;
		Varcs.cameraY = var6;
		WorldMapIcon_1.cameraZ = var7;
		IgnoreList.cameraPitch = var8;
		WorldMapSection2.cameraYaw = var9;
		if (Client.isLoading && class1.method5(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			WorldMapSprite.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
