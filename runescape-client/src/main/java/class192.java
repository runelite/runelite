import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public enum class192 implements Enumerated {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2369("", 0, new class191[]{class191.field2352}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2358("", 1, new class191[]{class191.field2350, class191.field2352}),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2359("", 2, new class191[]{class191.field2350, class191.field2354, class191.field2352}),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2360("", 3, new class191[]{class191.field2350}),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2368("", 4),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2362("", 5, new class191[]{class191.field2350, class191.field2352}),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2363("", 6, new class191[]{class191.field2352}),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2373("", 8, new class191[]{class191.field2350, class191.field2352}),
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2365("", 9, new class191[]{class191.field2350, class191.field2354}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2370("", 10, new class191[]{class191.field2350}),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2367("", 11, new class191[]{class191.field2350}),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2361("", 12, new class191[]{class191.field2350, class191.field2352}),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	field2364("", 13, new class191[]{class191.field2350});

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static Widget field2372;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1652165793
	)
	@Export("id")
	final int id;
	@ObfuscatedName("s")
	final Set field2371;

	static {
		method3643();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgd;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2371 = new HashSet();
		this.id = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2371.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2371 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-57"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)[Lgb;",
		garbageValue = "474493993"
	)
	static class192[] method3643() {
		return new class192[]{field2369, field2365, field2360, field2359, field2364, field2363, field2370, field2358, field2361, field2373, field2368, field2367, field2362};
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1164904579"
	)
	public static int method3654() {
		return ViewportMouse.ViewportMouse_entityCount;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "([Lbe;II[I[II)V",
		garbageValue = "2064654352"
	)
	@Export("sortWorlds")
	static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
		if (var1 < var2) {
			int var5 = var1 - 1;
			int var6 = var2 + 1;
			int var7 = (var2 + var1) / 2;
			World var8 = var0[var7];
			var0[var7] = var0[var1];
			var0[var1] = var8;

			while (var5 < var6) {
				boolean var9 = true;

				int var10;
				int var11;
				int var12;
				do {
					--var6;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var6].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var6].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var6].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var6].id;
							var12 = var8.id;
						}

						if (var12 != var11) {
							if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				var9 = true;

				do {
					++var5;

					for (var10 = 0; var10 < 4; ++var10) {
						if (var3[var10] == 2) {
							var11 = var0[var5].index;
							var12 = var8.index;
						} else if (var3[var10] == 1) {
							var11 = var0[var5].population;
							var12 = var8.population;
							if (var11 == -1 && var4[var10] == 1) {
								var11 = 2001;
							}

							if (var12 == -1 && var4[var10] == 1) {
								var12 = 2001;
							}
						} else if (var3[var10] == 3) {
							var11 = var0[var5].isMembersOnly() ? 1 : 0;
							var12 = var8.isMembersOnly() ? 1 : 0;
						} else {
							var11 = var0[var5].id;
							var12 = var8.id;
						}

						if (var12 != var11) {
							if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
								var9 = false;
							}
							break;
						}

						if (var10 == 3) {
							var9 = false;
						}
					}
				} while(var9);

				if (var5 < var6) {
					World var13 = var0[var5];
					var0[var5] = var0[var6];
					var0[var6] = var13;
				}
			}

			sortWorlds(var0, var1, var6, var3, var4);
			sortWorlds(var0, var6 + 1, var2, var3, var4);
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2145211344"
	)
	public static void method3655() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3120 != 0) {
				ArchiveDiskActionHandler.field3120 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}

	@ObfuscatedName("gm")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "551859372"
	)
	@Export("drawEntities")
	static final void drawEntities(int var0, int var1, int var2, int var3) {
		++Client.viewportDrawCount;
		if (Message.localPlayer.x >> 7 == Client.destinationX && Message.localPlayer.y >> 7 == Client.destinationY) {
			Client.destinationX = 0;
		}

		WorldMapAreaData.method686();
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			class14.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

		Archive.addNpcsToScene(true);
		WorldMapIcon_1.method296();
		Archive.addNpcsToScene(false);

		int var6;
		for (Projectile var4 = (Projectile)Client.projectiles.last(); var4 != null; var4 = (Projectile)Client.projectiles.previous()) {
			if (var4.plane == UrlRequest.Client_plane && Client.cycle <= var4.cycleEnd) {
				if (Client.cycle >= var4.cycleStart) {
					if (var4.targetIndex > 0) {
						NPC var31 = Client.npcs[var4.targetIndex - 1];
						if (var31 != null && var31.x >= 0 && var31.x < 13312 && var31.y >= 0 && var31.y < 13312) {
							var4.setDestination(var31.x, var31.y, ScriptEvent.getTileHeight(var31.x, var31.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					if (var4.targetIndex < 0) {
						var6 = -var4.targetIndex - 1;
						Player var35;
						if (var6 == Client.localPlayerIndex) {
							var35 = Message.localPlayer;
						} else {
							var35 = Client.players[var6];
						}

						if (var35 != null && var35.x >= 0 && var35.x < 13312 && var35.y >= 0 && var35.y < 13312) {
							var4.setDestination(var35.x, var35.y, ScriptEvent.getTileHeight(var35.x, var35.y, var4.plane) - var4.endHeight, Client.cycle);
						}
					}

					var4.advance(Client.field690);
					class14.scene.drawEntity(UrlRequest.Client_plane, (int)var4.x, (int)var4.y, (int)var4.z, 60, var4, var4.yaw, -1L, false);
				}
			} else {
				var4.remove();
			}
		}

		UserComparator10.method3337();
		Frames.setViewportShape(var0, var1, var2, var3, true);
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
		int var13;
		int var14;
		int var15;
		int var16;
		int var18;
		int var28;
		if (!Client.isCameraLocked) {
			var28 = Client.camAngleX;
			if (Client.field714 / 256 > var28) {
				var28 = Client.field714 / 256;
			}

			if (Client.field779[4] && Client.field876[4] + 128 > var28) {
				var28 = Client.field876[4] + 128;
			}

			var5 = Client.camAngleY & 2047;
			var6 = WorldMapSectionType.oculusOrbFocalPointX;
			var7 = WorldMapManager.field314;
			var8 = Language.oculusOrbFocalPointY;
			var9 = var28 * 3 + 600;
			var10 = WorldMapManager.method635(var9, var3);
			var11 = 2048 - var28 & 2047;
			var12 = 2048 - var5 & 2047;
			var13 = 0;
			var14 = 0;
			var15 = var10;
			int var17;
			if (var11 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var11];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var11];
				var18 = var17 * var14 - var16 * var10 >> 16;
				var15 = var10 * var17 + var16 * var14 >> 16;
				var14 = var18;
			}

			if (var12 != 0) {
				var16 = Rasterizer3D.Rasterizer3D_sine[var12];
				var17 = Rasterizer3D.Rasterizer3D_cosine[var12];
				var18 = var13 * var17 + var15 * var16 >> 16;
				var15 = var15 * var17 - var16 * var13 >> 16;
				var13 = var18;
			}

			MusicPatchNode2.cameraX = var6 - var13;
			class60.cameraY = var7 - var14;
			UserComparator9.cameraZ = var8 - var15;
			ViewportMouse.cameraPitch = var28;
			WorldMapLabelSize.cameraYaw = var5;
			if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (WorldMapSectionType.oculusOrbFocalPointX >> 7 != Message.localPlayer.x >> 7 || Language.oculusOrbFocalPointY >> 7 != Message.localPlayer.y >> 7)) {
				var16 = Message.localPlayer.plane;
				var17 = MusicPatchPcmStream.baseX * 64 + (WorldMapSectionType.oculusOrbFocalPointX >> 7);
				var18 = ScriptEvent.baseY * 64 + (Language.oculusOrbFocalPointY >> 7);
				PacketBufferNode var19 = class2.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
				var19.packetBuffer.writeIntME(var17);
				var19.packetBuffer.writeShortLE(Client.field710);
				var19.packetBuffer.writeIntME(var18);
				var19.packetBuffer.method5569(var16);
				Client.packetWriter.addNode(var19);
			}
		}

		if (!Client.isCameraLocked) {
			var28 = WorldMapRectangle.method275();
		} else {
			var28 = WorldMapIcon_0.method202();
		}

		var5 = MusicPatchNode2.cameraX;
		var6 = class60.cameraY;
		var7 = UserComparator9.cameraZ;
		var8 = ViewportMouse.cameraPitch;
		var9 = WorldMapLabelSize.cameraYaw;

		for (var10 = 0; var10 < 5; ++var10) {
			if (Client.field779[var10]) {
				var11 = (int)(Math.random() * (double)(Client.field875[var10] * 2 + 1) - (double)Client.field875[var10] + Math.sin((double)Client.field877[var10] / 100.0D * (double)Client.field878[var10]) * (double)Client.field876[var10]);
				if (var10 == 0) {
					MusicPatchNode2.cameraX += var11;
				}

				if (var10 == 1) {
					class60.cameraY += var11;
				}

				if (var10 == 2) {
					UserComparator9.cameraZ += var11;
				}

				if (var10 == 3) {
					WorldMapLabelSize.cameraYaw = var11 + WorldMapLabelSize.cameraYaw & 2047;
				}

				if (var10 == 4) {
					ViewportMouse.cameraPitch += var11;
					if (ViewportMouse.cameraPitch < 128) {
						ViewportMouse.cameraPitch = 128;
					}

					if (ViewportMouse.cameraPitch > 383) {
						ViewportMouse.cameraPitch = 383;
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
			class226.method4099();
		}

		WorldMapLabel.playPcmPlayers();
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
		WorldMapLabel.playPcmPlayers();
		var12 = Rasterizer3D.Rasterizer3D_zoom;
		Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
		class14.scene.draw(MusicPatchNode2.cameraX, class60.cameraY, UserComparator9.cameraZ, ViewportMouse.cameraPitch, WorldMapLabelSize.cameraYaw, var28);
		Rasterizer3D.Rasterizer3D_zoom = var12;
		WorldMapLabel.playPcmPlayers();
		class14.scene.clearTempGameObjects();
		Client.overheadTextCount = 0;
		boolean var33 = false;
		var14 = -1;
		var15 = -1;
		var16 = Players.Players_count;
		int[] var29 = Players.Players_indices;

		for (var18 = 0; var18 < var16 + Client.npcCount; ++var18) {
			Object var34;
			if (var18 < var16) {
				var34 = Client.players[var29[var18]];
				if (var29[var18] == Client.combatTargetPlayerIndex) {
					var33 = true;
					var14 = var18;
					continue;
				}

				if (var34 == Message.localPlayer) {
					var15 = var18;
					continue;
				}
			} else {
				var34 = Client.npcs[Client.npcIndices[var18 - var16]];
			}

			UserComparator5.drawActor2d((Actor)var34, var18, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var15 != -1) {
			UserComparator5.drawActor2d(Message.localPlayer, var15, var0, var1, var2, var3);
		}

		if (var33) {
			UserComparator5.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var14, var0, var1, var2, var3);
		}

		for (var18 = 0; var18 < Client.overheadTextCount; ++var18) {
			int var30 = Client.overheadTextXs[var18];
			int var20 = Client.overheadTextYs[var18];
			int var21 = Client.overheadTextXOffsets[var18];
			int var22 = Client.overheadTextAscents[var18];
			boolean var23 = true;

			while (var23) {
				var23 = false;

				for (int var24 = 0; var24 < var18; ++var24) {
					if (var20 + 2 > Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] && var20 - var22 < Client.overheadTextYs[var24] + 2 && var30 - var21 < Client.overheadTextXOffsets[var24] + Client.overheadTextXs[var24] && var30 + var21 > Client.overheadTextXs[var24] - Client.overheadTextXOffsets[var24] && Client.overheadTextYs[var24] - Client.overheadTextAscents[var24] < var20) {
						var20 = Client.overheadTextYs[var24] - Client.overheadTextAscents[var24];
						var23 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var18];
			Client.viewportTempY = Client.overheadTextYs[var18] = var20;
			String var32 = Client.overheadText[var18];
			if (Client.chatEffects == 0) {
				int var25 = 16776960;
				if (Client.overheadTextColors[var18] < 6) {
					var25 = Client.field864[Client.overheadTextColors[var18]];
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
					GrandExchangeOffer.fontBold12.drawCentered(var32, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0);
				}

				if (Client.overheadTextEffects[var18] == 1) {
					GrandExchangeOffer.fontBold12.drawCenteredWave(var32, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 2) {
					GrandExchangeOffer.fontBold12.drawCenteredWave2(var32, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var18] == 3) {
					GrandExchangeOffer.fontBold12.drawCenteredShake(var32, var0 + Client.viewportTempX, Client.viewportTempY + var1, var25, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var18]);
				}

				if (Client.overheadTextEffects[var18] == 4) {
					var26 = (150 - Client.overheadTextCyclesRemaining[var18]) * (GrandExchangeOffer.fontBold12.stringWidth(var32) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					GrandExchangeOffer.fontBold12.draw(var32, var0 + Client.viewportTempX + 50 - var26, Client.viewportTempY + var1, var25, 0);
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

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - GrandExchangeOffer.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					GrandExchangeOffer.fontBold12.drawCentered(var32, var0 + Client.viewportTempX, var27 + Client.viewportTempY + var1, var25, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				GrandExchangeOffer.fontBold12.drawCentered(var32, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

		WorldMapSprite.method408(var0, var1);
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field690);
		LoginPacket.method3574();
		MusicPatchNode2.cameraX = var5;
		class60.cameraY = var6;
		UserComparator9.cameraZ = var7;
		ViewportMouse.cameraPitch = var8;
		WorldMapLabelSize.cameraYaw = var9;
		if (Client.isLoading && class188.method3601(true, false) == 0) {
			Client.isLoading = false;
		}

		if (Client.isLoading) {
			Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
			class1.drawLoadingMessage("Loading - please wait.", false);
		}

	}
}
