import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("GrandExchangeOfferNameComparator")
final class GrandExchangeOfferNameComparator implements Comparator {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lo;Lo;I)I",
		garbageValue = "1525556475"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName());
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;B)I",
		garbageValue = "75"
	)
	static int method182(AbstractArchive var0, AbstractArchive var1) {
		int var2 = 0;
		if (var0.tryLoadFileByNames("title.jpg", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo_deadman_mode", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("logo_seasonal_mode", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebox", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("titlebutton", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("runes", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("title_mute", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,0", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,2", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,4", "")) {
			++var2;
		}

		if (var1.tryLoadFileByNames("options_radio_buttons,6", "")) {
			++var2;
		}

		var1.tryLoadFileByNames("sl_back", "");
		var1.tryLoadFileByNames("sl_flags", "");
		var1.tryLoadFileByNames("sl_arrows", "");
		var1.tryLoadFileByNames("sl_stars", "");
		var1.tryLoadFileByNames("sl_button", "");
		return var2;
	}

	@ObfuscatedName("ha")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "-1414450696"
	)
	static final void method183(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		var5 = PcmPlayer.method2637(var5, var6);
		int var7 = 2048 - var3 & 2047;
		int var8 = 2048 - var4 & 2047;
		int var9 = 0;
		int var10 = 0;
		int var11 = var5;
		int var12;
		int var13;
		int var14;
		if (var7 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var7];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var7];
			var14 = var10 * var13 - var12 * var5 >> 16;
			var11 = var13 * var5 + var12 * var10 >> 16;
			var10 = var14;
		}

		if (var8 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var8];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var8];
			var14 = var13 * var9 + var11 * var12 >> 16;
			var11 = var13 * var11 - var9 * var12 >> 16;
			var9 = var14;
		}

		UrlRequester.cameraX = var0 - var9;
		class16.cameraY = var1 - var10;
		GrandExchangeOfferAgeComparator.cameraZ = var2 - var11;
		class247.cameraPitch = var3;
		WorldMapData_1.cameraYaw = var4;
		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (IgnoreList.oculusOrbFocalPointX >> 7 != class215.localPlayer.x >> 7 || AbstractArchive.oculusOrbFocalPointY >> 7 != class215.localPlayer.y >> 7)) {
			var12 = class215.localPlayer.Client_plane;
			var13 = UserComparator8.baseX * 64 + (IgnoreList.oculusOrbFocalPointX >> 7);
			var14 = HealthBar.baseY * 64 + (AbstractArchive.oculusOrbFocalPointY >> 7);
			PacketBufferNode var15 = SoundSystem.getPacketBufferNode(ClientPacket.field2228, Client.packetWriter.isaacCipher);
			var15.packetBuffer.writeIntME(Client.field799);
			var15.packetBuffer.writeByte(var12);
			var15.packetBuffer.method5644(var14);
			var15.packetBuffer.writeShortLE(var13);
			Client.packetWriter.addNode(var15);
		}

	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-604205678"
	)
	static final void method172(boolean var0) {
		ChatChannel.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.field680 && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = SoundSystem.getPacketBufferNode(ClientPacket.field2245, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.field680 = true;
				}
			}

		}
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-93"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			GameObject.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < WorldMapLabel.method479(); ++var8) {
			long var9 = GrandExchangeEvents.method109(var8);
			if (var6 != var9) {
				var6 = var9;
				long var13 = ViewportMouse.ViewportMouse_entityTags[var8];
				int var24 = (int)(var13 >>> 0 & 127L);
				var24 = var24;
				long var15 = ViewportMouse.ViewportMouse_entityTags[var8];
				int var14 = (int)(var15 >>> 7 & 127L);
				var14 = var14;
				int var26 = Username.ViewportMouse_unpackX(var8);
				int var16 = ScriptEvent.method1272(var8);
				if (var26 == 2 && WorldMapArea.scene.getObjectFlags(Player.Client_plane, var24, var14, var9) >= 0) {
					ObjectDefinition var17 = WorldMapDecorationType.getObjectDefinition(var16);
					if (var17.transforms != null) {
						var17 = var17.transform();
					}

					if (var17 == null) {
						continue;
					}

					if (Client.isItemSelected == 1) {
						GameObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + AbstractArchive.colorStartTag(65535) + var17.name, 1, var16, var24, var14);
					} else if (Client.isSpellSelected) {
						if ((class81.selectedSpellFlags & 4) == 4) {
							GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + AbstractArchive.colorStartTag(65535) + var17.name, 2, var16, var24, var14);
						}
					} else {
						String[] var27 = var17.actions;
						if (var27 != null) {
							for (int var28 = 4; var28 >= 0; --var28) {
								if (var27[var28] != null) {
									short var20 = 0;
									if (var28 == 0) {
										var20 = 3;
									}

									if (var28 == 1) {
										var20 = 4;
									}

									if (var28 == 2) {
										var20 = 5;
									}

									if (var28 == 3) {
										var20 = 6;
									}

									if (var28 == 4) {
										var20 = 1001;
									}

									GameObject.insertMenuItemNoShift(var27[var28], AbstractArchive.colorStartTag(65535) + var17.name, var20, var16, var24, var14);
								}
							}
						}

						GameObject.insertMenuItemNoShift("Examine", AbstractArchive.colorStartTag(65535) + var17.name, 1002, var17.id, var24, var14);
					}
				}

				int var18;
				NPC var19;
				Player var21;
				int[] var34;
				int var36;
				if (var26 == 1) {
					NPC var31 = Client.npcs[var16];
					if (var31 == null) {
						continue;
					}

					if (var31.definition.size == 1 && (var31.x & 127) == 64 && (var31.y & 127) == 64) {
						for (var18 = 0; var18 < Client.npcCount; ++var18) {
							var19 = Client.npcs[Client.npcIndices[var18]];
							if (var19 != null && var31 != var19 && var19.definition.size == 1 && var19.x == var31.x && var31.y == var19.y) {
								TaskHandler.addNpcToMenu(var19.definition, Client.npcIndices[var18], var24, var14);
							}
						}

						var18 = Players.Players_count;
						var34 = Players.Players_indices;

						for (var36 = 0; var36 < var18; ++var36) {
							var21 = Client.players[var34[var36]];
							if (var21 != null && var21.x == var31.x && var21.y == var31.y) {
								class40.addPlayerToMenu(var21, var34[var36], var24, var14);
							}
						}
					}

					TaskHandler.addNpcToMenu(var31.definition, var16, var24, var14);
				}

				if (var26 == 0) {
					Player var32 = Client.players[var16];
					if (var32 == null) {
						continue;
					}

					if ((var32.x & 127) == 64 && (var32.y & 127) == 64) {
						for (var18 = 0; var18 < Client.npcCount; ++var18) {
							var19 = Client.npcs[Client.npcIndices[var18]];
							if (var19 != null && var19.definition.size == 1 && var19.x == var32.x && var19.y == var32.y) {
								TaskHandler.addNpcToMenu(var19.definition, Client.npcIndices[var18], var24, var14);
							}
						}

						var18 = Players.Players_count;
						var34 = Players.Players_indices;

						for (var36 = 0; var36 < var18; ++var36) {
							var21 = Client.players[var34[var36]];
							if (var21 != null && var21 != var32 && var21.x == var32.x && var32.y == var21.y) {
								class40.addPlayerToMenu(var21, var34[var36], var24, var14);
							}
						}
					}

					if (var16 != Client.combatTargetPlayerIndex) {
						class40.addPlayerToMenu(var32, var16, var24, var14);
					} else {
						var4 = var9;
					}
				}

				if (var26 == 3) {
					NodeDeque var33 = Client.groundItems[Player.Client_plane][var24][var14];
					if (var33 != null) {
						for (TileItem var37 = (TileItem)var33.first(); var37 != null; var37 = (TileItem)var33.next()) {
							ItemDefinition var35 = class222.ItemDefinition_get(var37.id);
							if (Client.isItemSelected == 1) {
								GameObject.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + AbstractArchive.colorStartTag(16748608) + var35.name, 16, var37.id, var24, var14);
							} else if (Client.isSpellSelected) {
								if ((class81.selectedSpellFlags & 1) == 1) {
									GameObject.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + AbstractArchive.colorStartTag(16748608) + var35.name, 17, var37.id, var24, var14);
								}
							} else {
								String[] var29 = var35.groundActions;

								for (int var30 = 4; var30 >= 0; --var30) {
									if (var29 != null && var29[var30] != null) {
										byte var22 = 0;
										if (var30 == 0) {
											var22 = 18;
										}

										if (var30 == 1) {
											var22 = 19;
										}

										if (var30 == 2) {
											var22 = 20;
										}

										if (var30 == 3) {
											var22 = 21;
										}

										if (var30 == 4) {
											var22 = 22;
										}

										GameObject.insertMenuItemNoShift(var29[var30], AbstractArchive.colorStartTag(16748608) + var35.name, var22, var37.id, var24, var14);
									} else if (var30 == 2) {
										GameObject.insertMenuItemNoShift("Take", AbstractArchive.colorStartTag(16748608) + var35.name, 20, var37.id, var24, var14);
									}
								}

								GameObject.insertMenuItemNoShift("Examine", AbstractArchive.colorStartTag(16748608) + var35.name, 1004, var37.id, var24, var14);
							}
						}
					}
				}
			}
		}

		if (var4 != -1L) {
			var8 = (int)(var4 >>> 0 & 127L);
			int var10 = (int)(var4 >>> 7 & 127L);
			Player var12 = Client.players[Client.combatTargetPlayerIndex];
			class40.addPlayerToMenu(var12, Client.combatTargetPlayerIndex, var8, var10);
		}

	}
}
