import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 423851547
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1677824649
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -538039303
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1526818253
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -53860035
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1526698757
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 578545777
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = 6449837147219780293L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -972053307
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-1053109132"
	)
	public static final boolean method3420(char var0) {
		if (Character.isISOControl(var0)) {
			return false;
		} else if (UserComparator8.isAlphaNumeric(var0)) {
			return true;
		} else {
			char[] var1 = class338.field4036;

			int var2;
			char var3;
			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			var1 = class338.field4038;

			for (var2 = 0; var2 < var1.length; ++var2) {
				var3 = var1[var2];
				if (var0 == var3) {
					return true;
				}
			}

			return false;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIB)Lbt;",
		garbageValue = "-95"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-441211068"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1171525777"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		Frames.method3397();
		class227.method4276();
		VarcInt.method4548();
		class40.addNpcsToScene(true);
		WorldMapSprite.method473();
		class40.addNpcsToScene(false);
		MouseHandler.method1172();
		FontName.method5442();
		Calendar.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var4;
		int var5;
		if (!Client.isCameraLocked) {
			var4 = Client.camAngleX;
			if (Client.field717 / 256 > var4) {
				var4 = Client.field717 / 256;
			}

			if (Client.field641[4] && Client.field795[4] + 128 > var4) {
				var4 = Client.field795[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			GrandExchangeOfferNameComparator.method183(IgnoreList.oculusOrbFocalPointX, Tiles.field497, AbstractArchive.oculusOrbFocalPointY, var4, var5, WorldMapSection0.method285(var4), var3);
		}

		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		if (!Client.isCameraLocked) {
			if (ScriptEvent.clientPreferences.roofsHidden) {
				var5 = Player.Client_plane;
			} else {
				label525: {
					var6 = 3;
					if (class247.cameraPitch < 310) {
						if (Client.oculusOrbState == 1) {
							var7 = IgnoreList.oculusOrbFocalPointX >> 7;
							var8 = AbstractArchive.oculusOrbFocalPointY >> 7;
						} else {
							var7 = class215.localPlayer.x >> 7;
							var8 = class215.localPlayer.y >> 7;
						}

						var9 = UrlRequester.cameraX >> 7;
						var10 = GrandExchangeOfferAgeComparator.cameraZ >> 7;
						if (var9 < 0 || var10 < 0 || var9 >= 104 || var10 >= 104) {
							var5 = Player.Client_plane;
							break label525;
						}

						if (var7 < 0 || var8 < 0 || var7 >= 104 || var8 >= 104) {
							var5 = Player.Client_plane;
							break label525;
						}

						if ((Tiles.Tiles_renderFlags[Player.Client_plane][var9][var10] & 4) != 0) {
							var6 = Player.Client_plane;
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

							while (var9 != var7) {
								if (var9 < var7) {
									++var9;
								} else if (var9 > var7) {
									--var9;
								}

								if ((Tiles.Tiles_renderFlags[Player.Client_plane][var9][var10] & 4) != 0) {
									var6 = Player.Client_plane;
								}

								var14 += var13;
								if (var14 >= 65536) {
									var14 -= 65536;
									if (var10 < var8) {
										++var10;
									} else if (var10 > var8) {
										--var10;
									}

									if ((Tiles.Tiles_renderFlags[Player.Client_plane][var9][var10] & 4) != 0) {
										var6 = Player.Client_plane;
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

								if ((Tiles.Tiles_renderFlags[Player.Client_plane][var9][var10] & 4) != 0) {
									var6 = Player.Client_plane;
								}

								var14 += var13;
								if (var14 >= 65536) {
									var14 -= 65536;
									if (var9 < var7) {
										++var9;
									} else if (var9 > var7) {
										--var9;
									}

									if ((Tiles.Tiles_renderFlags[Player.Client_plane][var9][var10] & 4) != 0) {
										var6 = Player.Client_plane;
									}
								}
							}
						}
					}

					if (class215.localPlayer.x >= 0 && class215.localPlayer.y >= 0 && class215.localPlayer.x < 13312 && class215.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[Player.Client_plane][class215.localPlayer.x >> 7][class215.localPlayer.y >> 7] & 4) != 0) {
							var6 = Player.Client_plane;
						}

						var5 = var6;
					} else {
						var5 = Player.Client_plane;
					}
				}
			}

			var4 = var5;
		} else {
			if (ScriptEvent.clientPreferences.roofsHidden) {
				var5 = Player.Client_plane;
			} else {
				var6 = GraphicsObject.getTileHeight(UrlRequester.cameraX, GrandExchangeOfferAgeComparator.cameraZ, Player.Client_plane);
				if (var6 - class16.cameraY < 800 && (Tiles.Tiles_renderFlags[Player.Client_plane][UrlRequester.cameraX >> 7][GrandExchangeOfferAgeComparator.cameraZ >> 7] & 4) != 0) {
					var5 = Player.Client_plane;
				} else {
					var5 = 3;
				}
			}

			var4 = var5;
		}

		var5 = UrlRequester.cameraX;
		var6 = class16.cameraY;
		var7 = GrandExchangeOfferAgeComparator.cameraZ;
		var8 = class247.cameraPitch;
		var9 = WorldMapData_1.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field641[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field877[var10] * 2 + 1) - (double)Client.field877[var10] + Math.sin((double)Client.field880[var10] * ((double)Client.field879[var10] / 100.0D)) * (double)Client.field795[var10]);
				if (var10 == 0) {
					UrlRequester.cameraX += var11;
				}

				if (var10 == 1) {
					class16.cameraY += var11;
				}

				if (var10 == 2) {
					GrandExchangeOfferAgeComparator.cameraZ += var11;
				}

				if (var10 == 3) {
					WorldMapData_1.cameraYaw = var11 + WorldMapData_1.cameraYaw & 2047;
				}

				if (var10 == 4) {
					class247.cameraPitch += var11;
					if (class247.cameraPitch < 128) {
						class247.cameraPitch = 128;
					}

					if (class247.cameraPitch > 383) {
						class247.cameraPitch = 383;
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
			var12 = var10 - var0;
			var13 = var11 - var1;
			ViewportMouse.ViewportMouse_x = var12;
			ViewportMouse.ViewportMouse_y = var13;
			ViewportMouse.ViewportMouse_isInViewport = true;
			ViewportMouse.ViewportMouse_entityCount = 0;
			ViewportMouse.ViewportMouse_false0 = false;
		} else {
			ViewportMouse.ViewportMouse_isInViewport = false;
			ViewportMouse.ViewportMouse_entityCount = 0;
		}

		ChatChannel.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		ChatChannel.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		WorldMapArea.scene.draw(UrlRequester.cameraX, class16.cameraY, GrandExchangeOfferAgeComparator.cameraZ, class247.cameraPitch, WorldMapData_1.cameraYaw, var4);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		ChatChannel.playPcmPlayers();
		WorldMapArea.scene.clearTempGameObjects();
		Client.overheadTextCount = 0;
		boolean var30 = false;
		var14 = -1;
		int var15 = -1;
		int var16 = Players.Players_count;
		int[] var17 = Players.Players_indices;

		int var18;
		for (var18 = 0; var18 < var16 + Client.npcCount; ++var18) {
			Object var19;
			if (var18 < var16) {
				var19 = Client.players[var17[var18]];
				if (var17[var18] == Client.combatTargetPlayerIndex) {
					var30 = true;
					var14 = var18;
					continue;
				}

				if (var19 == class215.localPlayer) {
					var15 = var18;
					continue;
				}
			} else {
				var19 = Client.npcs[Client.npcIndices[var18 - var16]];
			}

			AbstractSocket.drawActor2d((Actor)var19, var18, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var15 != -1) {
			AbstractSocket.drawActor2d(class215.localPlayer, var15, var0, var1, var2, var3);
		}

		if (var30) {
			AbstractSocket.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var14, var0, var1, var2, var3);
		}

		for (var18 = 0; var18 < Client.overheadTextCount; ++var18) {
			int var28 = Client.overheadTextXs[var18];
			int var20 = Client.overheadTextYs[var18];
			int var21 = Client.overheadTextXOffsets[var18];
			int var22 = Client.overheadTextAscents[var18];
			boolean var23 = true;

			while (var23) {
				var23 = false;

				for (int var24 = 0; var24 < var18; ++var24) {
					if (var20 + 2 > Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] && var20 - var22 < Client.overheadTextYs[var24] + 2 && var28 - var21 < Client.overheadTextXOffsets[var24] + Client.overheadTextXs[var24] && var21 + var28 > Client.overheadTextXs[var24] - Client.overheadTextXOffsets[var24] && Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] < var20) {
						var20 = Client.overheadTextYs[var24] - Client.overheadTextAscents[var24];
						var23 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var18];
			Client.viewportTempY = Client.overheadTextYs[var18] = var20;
			String var29 = Client.overheadText[var18];
			if (Client.chatEffects == 0) {
				int var25 = 16776960;
				if (Client.overheadTextColors[var18] < 6) {
					var25 = Client.field829[Client.overheadTextColors[var18]];
				}

				if (Client.overheadTextColors[var18] == 6) {
					var25 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var18] == 7) {
					var25 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var18] == 8) {
					var25 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var26;
				if (Client.overheadTextColors[var18] == 9) {
					var26 = 150 - Client.overheadTextCyclesRemaining[var18];
					if (var26 < 50) {
						var25 = var26 * 1280 + 16711680;
					} else if (var26 < 100) {
						var25 = 16776960 - (var26 - 50) * 327680;
					} else if (var26 < 150) {
						var25 = (var26 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var18] == 10) {
					var26 = 150 - Client.overheadTextCyclesRemaining[var18];
					if (var26 < 50) {
						var25 = var26 * 5 + 16711680;
					} else if (var26 < 100) {
						var25 = 16711935 - (var26 - 50) * 327680;
					} else if (var26 < 150) {
						var25 = (var26 - 100) * 327680 + 255 - (var26 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var18] == 11) {
					var26 = 150 - Client.overheadTextCyclesRemaining[var18];
					if (var26 < 50) {
						var25 = 16777215 - var26 * 327685;
					} else if (var26 < 100) {
						var25 = (var26 - 50) * 327685 + 65280;
					} else if (var26 < 150) {
						var25 = 16777215 - (var26 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var18] == 0) {
					class43.fontBold12.drawCentered(var29, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0);
				}

				if (Client.overheadTextEffects[var18] == 1) {
					class43.fontBold12.drawCenteredWave(var29, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 2) {
					class43.fontBold12.drawCenteredWave2(var29, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 3) {
					class43.fontBold12.drawCenteredShake(var29, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var18]);
				}

				if (Client.overheadTextEffects[var18] == 4) {
					var26 = (150 - Client.overheadTextCyclesRemaining[var18]) * (class43.fontBold12.stringWidth(var29) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					class43.fontBold12.draw(var29, var0 + Client.viewportTempX + 50 - var26, Client.viewportTempY + var1, var25, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var18] == 5) {
					var26 = 150 - Client.overheadTextCyclesRemaining[var18];
					int var27 = 0;
					if (var26 < 25) {
						var27 = var26 - 25;
					} else if (var26 > 125) {
						var27 = var26 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class43.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					class43.fontBold12.drawCentered(var29, var0 + Client.viewportTempX, var27 + Client.viewportTempY + var1, var25, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				class43.fontBold12.drawCentered(var29, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		WorldMapLabel.method475(var0, var1);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field693);
		RouteStrategy.method3734(var0, var1, var2, var3);
		UrlRequester.cameraX = var5;
		class16.cameraY = var6;
		GrandExchangeOfferAgeComparator.cameraZ = var7;
		class247.cameraPitch = var8;
		WorldMapData_1.cameraYaw = var9;
		if (Client.isLoading) {
			byte var31 = 0;
			var14 = var31 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
			if (var14 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			GrandExchangeEvents.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
