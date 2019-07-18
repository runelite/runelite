import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class4 implements class0 {
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive9")
	static Archive archive9;
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -904263063
	)
	@Export("selectedItemId")
	static int selectedItemId;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkf;I)V",
		garbageValue = "1977897097"
	)
	public void vmethod43(Object var1, Buffer var2) {
		this.method40((String)var1, var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)Ljava/lang/Object;",
		garbageValue = "-408972538"
	)
	public Object vmethod42(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lkf;B)V",
		garbageValue = "0"
	)
	void method40(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIIII)I",
		garbageValue = "16711935"
	)
	static final int method49(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1991855037"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		ScriptFrame.checkLocalPlayerDestination();
		if (Client.renderSelf) {
			class227.addPlayerToScene(Client.localPlayer, false);
		}

		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class227.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		WorldMapRegion.addNpcsToScene(true);
		int var4 = Players.Players_count;
		int[] var5 = Players.Players_indices;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			if (var5[var6] != Client.combatTargetPlayerIndex && var5[var6] != Client.localPlayerIndex) {
				class227.addPlayerToScene(Client.players[var5[var6]], true);
			}
		}

		WorldMapRegion.addNpcsToScene(false);
		PacketWriter.method2245();
		WorldMapRectangle.method275();
		UrlRequest.setViewportShape(var0, var1, var2, var3, true);
		var0 = Client.viewportOffsetX;
		var1 = Client.viewportOffsetY;
		var2 = Client.viewportWidth;
		var3 = Client.viewportHeight;
		Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
		Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
		int var28;
		if (!Client.isCameraLocked) {
			var4 = Client.camAngleX;
			if (Client.field739 / 256 > var4) {
				var4 = Client.field739 / 256;
			}

			if (Client.field886[4] && Client.field902[4] + 128 > var4) {
				var4 = Client.field902[4] + 128;
			}

			var28 = Client.camAngleY & 2047;
			LoginScreenAnimation.method1724(MouseHandler.oculusOrbFocalPointX, Client.field729, WorldMapArea.oculusOrbFocalPointY, var4, var28, class40.method700(var4), var3);
		}

		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		if (!Client.isCameraLocked) {
			if (WorldMapLabelSize.clientPreferences.roofsHidden) {
				var28 = class42.plane;
			} else {
				label567: {
					var6 = 3;
					if (GrandExchangeOfferNameComparator.cameraPitch < 310) {
						label559: {
							if (Client.oculusOrbState == 1) {
								var7 = MouseHandler.oculusOrbFocalPointX >> 7;
								var8 = WorldMapArea.oculusOrbFocalPointY >> 7;
							} else {
								var7 = Client.localPlayer.x >> 7;
								var8 = Client.localPlayer.y >> 7;
							}

							var9 = PacketBuffer.cameraX >> 7;
							var10 = class1.cameraZ >> 7;
							if (var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104) {
								if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
									if ((Tiles.Tiles_renderFlags[class42.plane][var9][var10] & 4) != 0) {
										var6 = class42.plane;
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

										while (true) {
											if (var7 == var9) {
												break label559;
											}

											if (var9 < var7) {
												++var9;
											} else if (var9 > var7) {
												--var9;
											}

											if ((Tiles.Tiles_renderFlags[class42.plane][var9][var10] & 4) != 0) {
												var6 = class42.plane;
											}

											var14 += var13;
											if (var14 >= 65536) {
												var14 -= 65536;
												if (var10 < var8) {
													++var10;
												} else if (var10 > var8) {
													--var10;
												}

												if ((Tiles.Tiles_renderFlags[class42.plane][var9][var10] & 4) != 0) {
													var6 = class42.plane;
												}
											}
										}
									} else {
										if (var12 > 0) {
											var13 = var11 * 65536 / var12;
											var14 = 32768;

											while (var10 != var8) {
												if (var10 < var8) {
													++var10;
												} else if (var10 > var8) {
													--var10;
												}

												if ((Tiles.Tiles_renderFlags[class42.plane][var9][var10] & 4) != 0) {
													var6 = class42.plane;
												}

												var14 += var13;
												if (var14 >= 65536) {
													var14 -= 65536;
													if (var9 < var7) {
														++var9;
													} else if (var9 > var7) {
														--var9;
													}

													if ((Tiles.Tiles_renderFlags[class42.plane][var9][var10] & 4) != 0) {
														var6 = class42.plane;
													}
												}
											}
										}
										break label559;
									}
								}

								var28 = class42.plane;
								break label567;
							}

							var28 = class42.plane;
							break label567;
						}
					}

					if (Client.localPlayer.x >= 0 && Client.localPlayer.y >= 0 && Client.localPlayer.x < 13312 && Client.localPlayer.y < 13312) {
						if ((Tiles.Tiles_renderFlags[class42.plane][Client.localPlayer.x >> 7][Client.localPlayer.y >> 7] & 4) != 0) {
							var6 = class42.plane;
						}

						var28 = var6;
					} else {
						var28 = class42.plane;
					}
				}
			}

			var4 = var28;
		} else {
			var4 = class83.method1995();
		}

		var28 = PacketBuffer.cameraX;
		var6 = class43.cameraY;
		var7 = class1.cameraZ;
		var8 = GrandExchangeOfferNameComparator.cameraPitch;
		var9 = Interpreter.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field886[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field901[var10] * 2 + 1) - (double)Client.field901[var10] + Math.sin((double)Client.field903[var10] / 100.0D * (double)Client.field904[var10]) * (double)Client.field902[var10]);
				if (var10 == 0) {
					PacketBuffer.cameraX += var11;
				}

				if (var10 == 1) {
					class43.cameraY += var11;
				}

				if (var10 == 2) {
					class1.cameraZ += var11;
				}

				if (var10 == 3) {
					Interpreter.cameraYaw = var11 + Interpreter.cameraYaw & 2047;
				}

				if (var10 == 4) {
					GrandExchangeOfferNameComparator.cameraPitch += var11;
					if (GrandExchangeOfferNameComparator.cameraPitch < 128) {
						GrandExchangeOfferNameComparator.cameraPitch = 128;
					}

					if (GrandExchangeOfferNameComparator.cameraPitch > 383) {
						GrandExchangeOfferNameComparator.cameraPitch = 383;
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
			class190.method3665();
		}

		class186.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		class186.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		GrandExchangeOfferWorldComparator.scene.draw(PacketBuffer.cameraX, class43.cameraY, class1.cameraZ, GrandExchangeOfferNameComparator.cameraPitch, Interpreter.cameraYaw, var4);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		class186.playPcmPlayers();
		GrandExchangeOfferWorldComparator.scene.clearTempGameObjects();
		Client.overheadTextCount = 0;
		boolean var31 = false;
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
					var31 = true;
					var14 = var18;
					continue;
				}

				if (var19 == Client.localPlayer) {
					var15 = var18;
					continue;
				}
			} else {
				var19 = Client.npcs[Client.npcIndices[var18 - var16]];
			}

			Decimator.drawActor2d((Actor)var19, var18, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var15 != -1) {
			Decimator.drawActor2d(Client.localPlayer, var15, var0, var1, var2, var3);
		}

		if (var31) {
			Decimator.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var14, var0, var1, var2, var3);
		}

		for (var18 = 0; var18 < Client.overheadTextCount; ++var18) {
			int var29 = Client.overheadTextXs[var18];
			int var20 = Client.overheadTextYs[var18];
			int var21 = Client.overheadTextXOffsets[var18];
			int var22 = Client.overheadTextAscents[var18];
			boolean var23 = true;

			while (var23) {
				var23 = false;

				for (int var24 = 0; var24 < var18; ++var24) {
					if (var20 + 2 > Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] && var20 - var22 < Client.overheadTextYs[var24] + 2 && var29 - var21 < Client.overheadTextXOffsets[var24] + Client.overheadTextXs[var24] && var21 + var29 > Client.overheadTextXs[var24] - Client.overheadTextXOffsets[var24] && Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] < var20) {
						var20 = Client.overheadTextYs[var24] - Client.overheadTextAscents[var24];
						var23 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var18];
			Client.viewportTempY = Client.overheadTextYs[var18] = var20;
			String var30 = Client.overheadText[var18];
			if (Client.chatEffects == 0) {
				int var25 = 16776960;
				if (Client.overheadTextColors[var18] < 6) {
					var25 = Client.field870[Client.overheadTextColors[var18]];
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
					WorldMapIcon_1.fontBold12.drawCentered(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0);
				}

				if (Client.overheadTextEffects[var18] == 1) {
					WorldMapIcon_1.fontBold12.drawCenteredWave(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 2) {
					WorldMapIcon_1.fontBold12.drawCenteredWave2(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 3) {
					WorldMapIcon_1.fontBold12.drawCenteredShake(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var18]);
				}

				if (Client.overheadTextEffects[var18] == 4) {
					var26 = (150 - Client.overheadTextCyclesRemaining[var18]) * (WorldMapIcon_1.fontBold12.stringWidth(var30) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					WorldMapIcon_1.fontBold12.draw(var30, var0 + Client.viewportTempX + 50 - var26, Client.viewportTempY + var1, var25, 0);
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

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - WorldMapIcon_1.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					WorldMapIcon_1.fontBold12.drawCentered(var30, var0 + Client.viewportTempX, var27 + Client.viewportTempY + var1, var25, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				WorldMapIcon_1.fontBold12.drawCentered(var30, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		if (Client.hintArrowType == 2) {
			class32.worldToScreen(Client.hintArrowSubX * 64 + (Client.hintArrowX - MusicPatchNode2.baseX * 64 << 7), (Client.hintArrowY - class1.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 4);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				class173.headIconHintSprites[0].drawAt2(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}
		}

		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field718);
		AbstractWorldMapData.method273(var0, var1, var2, var3);
		PacketBuffer.cameraX = var28;
		class43.cameraY = var6;
		class1.cameraZ = var7;
		GrandExchangeOfferNameComparator.cameraPitch = var8;
		Interpreter.cameraYaw = var9;
		if (Client.isLoading) {
			byte var32 = 0;
			var14 = var32 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
			if (var14 == 0) {
				Client.isLoading = false;
			}
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			TriBool.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
