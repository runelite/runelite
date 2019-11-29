import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("jc")
public class class267 {
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive12")
	static Archive archive12;

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "2022043883"
	)
	static int method5067(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == ScriptOpcodes.IF_GETINVOBJECT) {
			var3 = Language.getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETINVCOUNT) {
			var3 = Language.getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_HASSUB) {
			int var5 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTOP) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	static final void method5068() {
		InterfaceParent.method1197(false);
		Client.field676 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < VerticalAlignment.regionLandArchives.length; ++var1) {
			if (BuddyRankComparator.regionMapArchiveIds[var1] != -1 && VerticalAlignment.regionLandArchives[var1] == null) {
				VerticalAlignment.regionLandArchives[var1] = DirectByteArrayCopier.archive5.takeFile(BuddyRankComparator.regionMapArchiveIds[var1], 0);
				if (VerticalAlignment.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field676;
				}
			}

			if (GrandExchangeOfferAgeComparator.regionLandArchiveIds[var1] != -1 && UrlRequest.regionMapArchives[var1] == null) {
				UrlRequest.regionMapArchives[var1] = DirectByteArrayCopier.archive5.takeFileEncrypted(GrandExchangeOfferAgeComparator.regionLandArchiveIds[var1], 0, WorldMapIcon_0.xteaKeys[var1]);
				if (UrlRequest.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field676;
				}
			}
		}

		if (!var0) {
			Client.field699 = 1;
		} else {
			Client.field850 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < VerticalAlignment.regionLandArchives.length; ++var1) {
				byte[] var2 = UrlRequest.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (class226.regions[var1] >> 8) * 64 - class51.baseX * 64;
					var4 = (class226.regions[var1] & 255) * 64 - VarcInt.baseY * 64;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= Script.method2257(var2, var3, var4);
				}
			}

			if (!var0) {
				Client.field699 = 2;
			} else {
				if (Client.field699 != 0) {
					WorldMapIcon_1.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				Tiles.playPcmPlayers();
				class2.scene.clear();

				for (var1 = 0; var1 < 4; ++var1) {
					Client.collisionMaps[var1].clear();
				}

				int var31;
				for (var1 = 0; var1 < 4; ++var1) {
					for (var31 = 0; var31 < 104; ++var31) {
						for (var3 = 0; var3 < 104; ++var3) {
							Tiles.Tiles_renderFlags[var1][var31][var3] = 0;
						}
					}
				}

				Tiles.playPcmPlayers();
				Tiles.Tiles_minPlane = 99;
				Tiles.field498 = new byte[4][104][104];
				Tiles.field499 = new byte[4][104][104];
				Tiles.field500 = new byte[4][104][104];
				Tiles.field501 = new byte[4][104][104];
				WorldMapLabel.field233 = new int[4][105][105];
				class51.field423 = new byte[4][105][105];
				Login.field1207 = new int[105][105];
				Tiles.Tiles_hue = new int[104];
				Tiles.Tiles_saturation = new int[104];
				Tiles.Tiles_lightness = new int[104];
				class290.Tiles_hueMultiplier = new int[104];
				MouseRecorder.field588 = new int[104];
				var1 = VerticalAlignment.regionLandArchives.length;

				for (ObjectSound var41 = (ObjectSound)ObjectSound.objectSounds.last(); var41 != null; var41 = (ObjectSound)ObjectSound.objectSounds.previous()) {
					if (var41.stream1 != null) {
						ClientPacket.pcmStreamMixer.removeSubStream(var41.stream1);
						var41.stream1 = null;
					}

					if (var41.stream2 != null) {
						ClientPacket.pcmStreamMixer.removeSubStream(var41.stream2);
						var41.stream2 = null;
					}
				}

				ObjectSound.objectSounds.clear();
				InterfaceParent.method1197(true);
				int var9;
				int var10;
				int var11;
				int var12;
				int var14;
				int var15;
				int var16;
				int var17;
				int var19;
				int var20;
				int var21;
				int var32;
				if (!Client.isInInstance) {
					byte[] var5;
					for (var31 = 0; var31 < var1; ++var31) {
						var3 = (class226.regions[var31] >> 8) * 64 - class51.baseX * 64;
						var4 = (class226.regions[var31] & 255) * 64 - VarcInt.baseY * 64;
						var5 = VerticalAlignment.regionLandArchives[var31];
						if (var5 != null) {
							Tiles.playPcmPlayers();
							GrandExchangeOffer.method123(var5, var3, var4, CollisionMap.field2086 * 8 - 48, SoundCache.field1438 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var31 = 0; var31 < var1; ++var31) {
						var3 = (class226.regions[var31] >> 8) * 64 - class51.baseX * 64;
						var4 = (class226.regions[var31] & 255) * 64 - VarcInt.baseY * 64;
						var5 = VerticalAlignment.regionLandArchives[var31];
						if (var5 == null && SoundCache.field1438 < 800) {
							Tiles.playPcmPlayers();
							ReflectionCheck.method2316(var3, var4, 64, 64);
						}
					}

					InterfaceParent.method1197(true);

					for (var31 = 0; var31 < var1; ++var31) {
						byte[] var33 = UrlRequest.regionMapArchives[var31];
						if (var33 != null) {
							var4 = (class226.regions[var31] >> 8) * 64 - class51.baseX * 64;
							var32 = (class226.regions[var31] & 255) * 64 - VarcInt.baseY * 64;
							Tiles.playPcmPlayers();
							Scene var34 = class2.scene;
							CollisionMap[] var35 = Client.collisionMaps;
							Buffer var36 = new Buffer(var33);
							var9 = -1;

							while (true) {
								var10 = var36.method5710();
								if (var10 == 0) {
									break;
								}

								var9 += var10;
								var11 = 0;

								while (true) {
									var12 = var36.readUShortSmart();
									if (var12 == 0) {
										break;
									}

									var11 += var12 - 1;
									int var38 = var11 & 63;
									var14 = var11 >> 6 & 63;
									var15 = var11 >> 12;
									var16 = var36.readUnsignedByte();
									var17 = var16 >> 2;
									int var39 = var16 & 3;
									var19 = var14 + var4;
									var20 = var38 + var32;
									if (var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
										var21 = var15;
										if ((Tiles.Tiles_renderFlags[1][var19][var20] & 2) == 2) {
											var21 = var15 - 1;
										}

										CollisionMap var40 = null;
										if (var21 >= 0) {
											var40 = var35[var21];
										}

										EnumDefinition.method4656(var15, var19, var20, var9, var39, var17, var34, var40);
									}
								}
							}
						}
					}
				}

				int var6;
				int var7;
				int var8;
				if (Client.isInInstance) {
					for (var31 = 0; var31 < 4; ++var31) {
						Tiles.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								boolean var42 = false;
								var6 = Client.instanceChunkTemplates[var31][var3][var4];
								if (var6 != -1) {
									var7 = var6 >> 24 & 3;
									var8 = var6 >> 1 & 3;
									var9 = var6 >> 14 & 1023;
									var10 = var6 >> 3 & 2047;
									var11 = (var9 / 8 << 8) + var10 / 8;

									for (var12 = 0; var12 < class226.regions.length; ++var12) {
										if (class226.regions[var12] == var11 && VerticalAlignment.regionLandArchives[var12] != null) {
											byte[] var13 = VerticalAlignment.regionLandArchives[var12];
											var14 = var3 * 8;
											var15 = var4 * 8;
											var16 = (var9 & 7) * 8;
											var17 = (var10 & 7) * 8;
											CollisionMap[] var18 = Client.collisionMaps;

											for (var19 = 0; var19 < 8; ++var19) {
												for (var20 = 0; var20 < 8; ++var20) {
													if (var19 + var14 > 0 && var19 + var14 < 103 && var15 + var20 > 0 && var20 + var15 < 103) {
														int[] var10000 = var18[var31].flags[var14 + var19];
														var10000[var20 + var15] &= -16777217;
													}
												}
											}

											Buffer var37 = new Buffer(var13);

											for (var20 = 0; var20 < 4; ++var20) {
												for (var21 = 0; var21 < 64; ++var21) {
													for (int var22 = 0; var22 < 64; ++var22) {
														if (var7 == var20 && var21 >= var16 && var21 < var16 + 8 && var22 >= var17 && var22 < var17 + 8) {
															int var25 = var14 + class266.method5065(var21 & 7, var22 & 7, var8);
															int var28 = var21 & 7;
															int var29 = var22 & 7;
															int var30 = var8 & 3;
															int var27;
															if (var30 == 0) {
																var27 = var29;
															} else if (var30 == 1) {
																var27 = 7 - var28;
															} else if (var30 == 2) {
																var27 = 7 - var29;
															} else {
																var27 = var28;
															}

															GrandExchangeOffer.loadTerrain(var37, var31, var25, var15 + var27, 0, 0, var8);
														} else {
															GrandExchangeOffer.loadTerrain(var37, 0, -1, -1, 0, 0, 0);
														}
													}
												}
											}

											var42 = true;
											break;
										}
									}
								}

								if (!var42) {
									TilePaint.method3105(var31, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var31 = 0; var31 < 13; ++var31) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var31][var3];
							if (var4 == -1) {
								ReflectionCheck.method2316(var31 * 8, var3 * 8, 8, 8);
							}
						}
					}

					InterfaceParent.method1197(true);

					for (var31 = 0; var31 < 4; ++var31) {
						Tiles.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var32 = Client.instanceChunkTemplates[var31][var3][var4];
								if (var32 != -1) {
									var6 = var32 >> 24 & 3;
									var7 = var32 >> 1 & 3;
									var8 = var32 >> 14 & 1023;
									var9 = var32 >> 3 & 2047;
									var10 = (var8 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < class226.regions.length; ++var11) {
										if (class226.regions[var11] == var10 && UrlRequest.regionMapArchives[var11] != null) {
											FileSystem.method3552(UrlRequest.regionMapArchives[var11], var31, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class2.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				InterfaceParent.method1197(true);
				Tiles.playPcmPlayers();
				Frames.method3319(class2.scene, Client.collisionMaps);
				InterfaceParent.method1197(true);
				var31 = Tiles.Tiles_minPlane;
				if (var31 > ClientPacket.Client_plane) {
					var31 = ClientPacket.Client_plane;
				}

				if (var31 < ClientPacket.Client_plane - 1) {
					var31 = ClientPacket.Client_plane - 1;
				}

				if (Client.isLowDetail) {
					class2.scene.init(Tiles.Tiles_minPlane);
				} else {
					class2.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						HealthBar.updateItemPile(var3, var4);
					}
				}

				Tiles.playPcmPlayers();

				for (PendingSpawn var43 = (PendingSpawn)Client.pendingSpawns.last(); var43 != null; var43 = (PendingSpawn)Client.pendingSpawns.previous()) {
					if (var43.hitpoints == -1) {
						var43.delay = 0;
						class215.method4108(var43);
					} else {
						var43.remove();
					}
				}

				ObjectDefinition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var44;
				if (AbstractWorldMapIcon.client.hasFrame()) {
					var44 = ModelData0.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
					var44.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var44);
				}

				if (!Client.isInInstance) {
					var3 = (CollisionMap.field2086 - 6) / 8;
					var4 = (CollisionMap.field2086 + 6) / 8;
					var32 = (SoundCache.field1438 - 6) / 8;
					var6 = (SoundCache.field1438 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var8 = var32 - 1; var8 <= var6 + 1; ++var8) {
							if (var7 < var3 || var7 > var4 || var8 < var32 || var8 > var6) {
								DirectByteArrayCopier.archive5.loadRegionFromName("m" + var7 + "_" + var8);
								DirectByteArrayCopier.archive5.loadRegionFromName("l" + var7 + "_" + var8);
							}
						}
					}
				}

				class81.updateGameState(30);
				Tiles.playPcmPlayers();
				Tiles.field498 = null;
				Tiles.field499 = null;
				Tiles.field500 = null;
				Tiles.field501 = null;
				WorldMapLabel.field233 = null;
				class51.field423 = null;
				Login.field1207 = null;
				Tiles.Tiles_hue = null;
				Tiles.Tiles_saturation = null;
				Tiles.Tiles_lightness = null;
				class290.Tiles_hueMultiplier = null;
				MouseRecorder.field588 = null;
				var44 = ModelData0.getPacketBufferNode(ClientPacket.field2223, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var44);
				BuddyRankComparator.clock.mark();

				for (var4 = 0; var4 < 32; ++var4) {
					GameShell.graphicsTickTimes[var4] = 0L;
				}

				for (var4 = 0; var4 < 32; ++var4) {
					GameShell.clientTickTimes[var4] = 0L;
				}

				GameShell.gameCyclesToDo = 0;
			}
		}
	}
}
