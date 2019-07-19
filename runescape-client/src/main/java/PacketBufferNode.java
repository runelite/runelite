import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "[Lgb;"
	)
	@Export("PacketBufferNode_packetBufferNodes")
	public static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 303821237
	)
	@Export("PacketBufferNode_packetBufferNodeCount")
	public static int PacketBufferNode_packetBufferNodeCount;
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "Lht;"
	)
	static ServerBuild field2337;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	@Export("clientPacket")
	public ClientPacket clientPacket;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1717799889
	)
	@Export("clientPacketLength")
	public int clientPacketLength;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("packetBuffer")
	public PacketBuffer packetBuffer;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1405793597
	)
	@Export("index")
	public int index;

	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
		PacketBufferNode_packetBufferNodeCount = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-108"
	)
	public void method3620() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "729695552"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(CLgu;I)C",
		garbageValue = "1821592074"
	)
	static char method3623(char var0, class190 var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != class190.field2350) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != class190.field2350) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else if (var0 == 376) {
			return 'Y';
		} else {
			return var0;
		}
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-13305757"
	)
	static final void method3628() {
		WorldMapElement.method4368(false);
		Client.field705 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < class13.regionLandArchives.length; ++var1) {
			if (SecureRandomFuture.regionMapArchiveIds[var1] != -1 && class13.regionLandArchives[var1] == null) {
				class13.regionLandArchives[var1] = WorldMapCacheName.archive5.takeFile(SecureRandomFuture.regionMapArchiveIds[var1], 0);
				if (class13.regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field705;
				}
			}

			if (WorldMapRectangle.regionLandArchiveIds[var1] != -1 && class80.regionMapArchives[var1] == null) {
				class80.regionMapArchives[var1] = WorldMapCacheName.archive5.takeFileEncrypted(WorldMapRectangle.regionLandArchiveIds[var1], 0, WorldMapRegion.xteaKeys[var1]);
				if (class80.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field705;
				}
			}
		}

		if (!var0) {
			Client.field709 = 1;
		} else {
			Client.field707 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < class13.regionLandArchives.length; ++var1) {
				byte[] var2 = class80.regionMapArchives[var1];
				if (var2 != null) {
					var3 = (DirectByteArrayCopier.regions[var1] >> 8) * 64 - MusicPatchNode2.baseX * 64;
					var4 = (DirectByteArrayCopier.regions[var1] & 255) * 64 - class1.baseY * 64;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= Huffman.method3947(var2, var3, var4);
				}
			}

			if (!var0) {
				Client.field709 = 2;
			} else {
				if (Client.field709 != 0) {
					TriBool.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				class186.playPcmPlayers();
				GrandExchangeOfferWorldComparator.scene.clear();

				for (var1 = 0; var1 < 4; ++var1) {
					Client.collisionMaps[var1].clear();
				}

				int var49;
				for (var1 = 0; var1 < 4; ++var1) {
					for (var49 = 0; var49 < 104; ++var49) {
						for (var3 = 0; var3 < 104; ++var3) {
							Tiles.Tiles_renderFlags[var1][var49][var3] = 0;
						}
					}
				}

				class186.playPcmPlayers();
				Tiles.Tiles_minPlane = 99;
				Tiles.field504 = new byte[4][104][104];
				Tiles.field505 = new byte[4][104][104];
				Tiles.field506 = new byte[4][104][104];
				class268.field3561 = new byte[4][104][104];
				FaceNormal.field1887 = new int[4][105][105];
				class32.field282 = new byte[4][105][105];
				Tiles.field515 = new int[105][105];
				ServerBuild.field3103 = new int[104];
				Tiles.field508 = new int[104];
				Tiles.field507 = new int[104];
				DynamicObject.field1301 = new int[104];
				Fonts.field3689 = new int[104];
				var1 = class13.regionLandArchives.length;

				for (ObjectSound var55 = (ObjectSound)ObjectSound.objectSounds.last(); var55 != null; var55 = (ObjectSound)ObjectSound.objectSounds.previous()) {
					if (var55.stream1 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var55.stream1);
						var55.stream1 = null;
					}

					if (var55.stream2 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var55.stream2);
						var55.stream2 = null;
					}
				}

				ObjectSound.objectSounds.clear();
				WorldMapElement.method4368(true);
				int var6;
				int var7;
				int var9;
				int var10;
				int var11;
				int var12;
				int var51;
				if (!Client.isInInstance) {
					byte[] var5;
					for (var49 = 0; var49 < var1; ++var49) {
						var3 = (DirectByteArrayCopier.regions[var49] >> 8) * 64 - MusicPatchNode2.baseX * 64;
						var4 = (DirectByteArrayCopier.regions[var49] & 255) * 64 - class1.baseY * 64;
						var5 = class13.regionLandArchives[var49];
						if (var5 != null) {
							class186.playPcmPlayers();
							var6 = Canvas.field418 * 8 - 48;
							var7 = ViewportMouse.field1747 * 8 - 48;
							CollisionMap[] var8 = Client.collisionMaps;

							for (var9 = 0; var9 < 4; ++var9) {
								for (var10 = 0; var10 < 64; ++var10) {
									for (var11 = 0; var11 < 64; ++var11) {
										if (var3 + var10 > 0 && var10 + var3 < 103 && var11 + var4 > 0 && var11 + var4 < 103) {
											int[] var10000 = var8[var9].flags[var3 + var10];
											var10000[var11 + var4] &= -16777217;
										}
									}
								}
							}

							Buffer var50 = new Buffer(var5);

							for (var10 = 0; var10 < 4; ++var10) {
								for (var11 = 0; var11 < 64; ++var11) {
									for (var12 = 0; var12 < 64; ++var12) {
										WorldMapLabel.loadTerrain(var50, var10, var3 + var11, var4 + var12, var6, var7, 0);
									}
								}
							}
						}
					}

					for (var49 = 0; var49 < var1; ++var49) {
						var3 = (DirectByteArrayCopier.regions[var49] >> 8) * 64 - MusicPatchNode2.baseX * 64;
						var4 = (DirectByteArrayCopier.regions[var49] & 255) * 64 - class1.baseY * 64;
						var5 = class13.regionLandArchives[var49];
						if (var5 == null && ViewportMouse.field1747 < 800) {
							class186.playPcmPlayers();
							Players.method2092(var3, var4, 64, 64);
						}
					}

					WorldMapElement.method4368(true);

					for (var49 = 0; var49 < var1; ++var49) {
						byte[] var53 = class80.regionMapArchives[var49];
						if (var53 != null) {
							var4 = (DirectByteArrayCopier.regions[var49] >> 8) * 64 - MusicPatchNode2.baseX * 64;
							var51 = (DirectByteArrayCopier.regions[var49] & 255) * 64 - class1.baseY * 64;
							class186.playPcmPlayers();
							AbstractByteArrayCopier.method3933(var53, var4, var51, GrandExchangeOfferWorldComparator.scene, Client.collisionMaps);
						}
					}
				}

				int var52;
				if (Client.isInInstance) {
					for (var49 = 0; var49 < 4; ++var49) {
						class186.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								boolean var56 = false;
								var6 = Client.instanceChunkTemplates[var49][var3][var4];
								if (var6 != -1) {
									var7 = var6 >> 24 & 3;
									var52 = var6 >> 1 & 3;
									var9 = var6 >> 14 & 1023;
									var10 = var6 >> 3 & 2047;
									var11 = (var9 / 8 << 8) + var10 / 8;

									for (var12 = 0; var12 < DirectByteArrayCopier.regions.length; ++var12) {
										if (DirectByteArrayCopier.regions[var12] == var11 && class13.regionLandArchives[var12] != null) {
											ScriptFrame.method1088(class13.regionLandArchives[var12], var49, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var52, Client.collisionMaps);
											var56 = true;
											break;
										}
									}
								}

								if (!var56) {
									var7 = var49;
									var52 = var3 * 8;
									var9 = var4 * 8;

									for (var10 = 0; var10 < 8; ++var10) {
										for (var11 = 0; var11 < 8; ++var11) {
											Tiles.Tiles_heights[var7][var52 + var10][var11 + var9] = 0;
										}
									}

									if (var52 > 0) {
										for (var10 = 1; var10 < 8; ++var10) {
											Tiles.Tiles_heights[var7][var52][var9 + var10] = Tiles.Tiles_heights[var7][var52 - 1][var9 + var10];
										}
									}

									if (var9 > 0) {
										for (var10 = 1; var10 < 8; ++var10) {
											Tiles.Tiles_heights[var7][var52 + var10][var9] = Tiles.Tiles_heights[var7][var52 + var10][var9 - 1];
										}
									}

									if (var52 > 0 && Tiles.Tiles_heights[var7][var52 - 1][var9] != 0) {
										Tiles.Tiles_heights[var7][var52][var9] = Tiles.Tiles_heights[var7][var52 - 1][var9];
									} else if (var9 > 0 && Tiles.Tiles_heights[var7][var52][var9 - 1] != 0) {
										Tiles.Tiles_heights[var7][var52][var9] = Tiles.Tiles_heights[var7][var52][var9 - 1];
									} else if (var52 > 0 && var9 > 0 && Tiles.Tiles_heights[var7][var52 - 1][var9 - 1] != 0) {
										Tiles.Tiles_heights[var7][var52][var9] = Tiles.Tiles_heights[var7][var52 - 1][var9 - 1];
									}
								}
							}
						}
					}

					for (var49 = 0; var49 < 13; ++var49) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var49][var3];
							if (var4 == -1) {
								Players.method2092(var49 * 8, var3 * 8, 8, 8);
							}
						}
					}

					WorldMapElement.method4368(true);

					for (var49 = 0; var49 < 4; ++var49) {
						class186.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							label447:
							for (var4 = 0; var4 < 13; ++var4) {
								var51 = Client.instanceChunkTemplates[var49][var3][var4];
								if (var51 != -1) {
									var6 = var51 >> 24 & 3;
									var7 = var51 >> 1 & 3;
									var52 = var51 >> 14 & 1023;
									var9 = var51 >> 3 & 2047;
									var10 = (var52 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < DirectByteArrayCopier.regions.length; ++var11) {
										if (DirectByteArrayCopier.regions[var11] == var10 && class80.regionMapArchives[var11] != null) {
											byte[] var54 = class80.regionMapArchives[var11];
											int var13 = var3 * 8;
											int var14 = var4 * 8;
											int var15 = (var52 & 7) * 8;
											int var16 = (var9 & 7) * 8;
											Scene var17 = GrandExchangeOfferWorldComparator.scene;
											CollisionMap[] var18 = Client.collisionMaps;
											Buffer var19 = new Buffer(var54);
											int var20 = -1;

											while (true) {
												int var21 = var19.method5509();
												if (var21 == 0) {
													continue label447;
												}

												var20 += var21;
												int var22 = 0;

												while (true) {
													int var23 = var19.readUShortSmart();
													if (var23 == 0) {
														break;
													}

													var22 += var23 - 1;
													int var24 = var22 & 63;
													int var25 = var22 >> 6 & 63;
													int var26 = var22 >> 12;
													int var27 = var19.readUnsignedByte();
													int var28 = var27 >> 2;
													int var29 = var27 & 3;
													if (var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
														ObjectDefinition var30 = ViewportMouse.getObjectDefinition(var20);
														int var33 = var25 & 7;
														int var34 = var24 & 7;
														int var36 = var30.sizeX;
														int var37 = var30.sizeY;
														int var38;
														if ((var29 & 1) == 1) {
															var38 = var36;
															var36 = var37;
															var37 = var38;
														}

														int var35 = var7 & 3;
														int var32;
														if (var35 == 0) {
															var32 = var33;
														} else if (var35 == 1) {
															var32 = var34;
														} else if (var35 == 2) {
															var32 = 7 - var33 - (var36 - 1);
														} else {
															var32 = 7 - var34 - (var37 - 1);
														}

														var38 = var32 + var13;
														int var41 = var25 & 7;
														int var42 = var24 & 7;
														int var44 = var30.sizeX;
														int var45 = var30.sizeY;
														int var46;
														if ((var29 & 1) == 1) {
															var46 = var44;
															var44 = var45;
															var45 = var46;
														}

														int var43 = var7 & 3;
														int var40;
														if (var43 == 0) {
															var40 = var42;
														} else if (var43 == 1) {
															var40 = 7 - var41 - (var44 - 1);
														} else if (var43 == 2) {
															var40 = 7 - var42 - (var45 - 1);
														} else {
															var40 = var41;
														}

														var46 = var40 + var14;
														if (var38 > 0 && var46 > 0 && var38 < 103 && var46 < 103) {
															int var47 = var49;
															if ((Tiles.Tiles_renderFlags[1][var38][var46] & 2) == 2) {
																var47 = var49 - 1;
															}

															CollisionMap var48 = null;
															if (var47 >= 0) {
																var48 = var18[var47];
															}

															GrandExchangeOfferOwnWorldComparator.method1236(var49, var38, var46, var20, var29 + var7 & 3, var28, var17, var48);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}

				WorldMapElement.method4368(true);
				class186.playPcmPlayers();
				GrandExchangeEvents.method72(GrandExchangeOfferWorldComparator.scene, Client.collisionMaps);
				WorldMapElement.method4368(true);
				var49 = Tiles.Tiles_minPlane;
				if (var49 > class42.plane) {
					var49 = class42.plane;
				}

				if (var49 < class42.plane - 1) {
					var49 = class42.plane - 1;
				}

				if (Client.isLowDetail) {
					GrandExchangeOfferWorldComparator.scene.init(Tiles.Tiles_minPlane);
				} else {
					GrandExchangeOfferWorldComparator.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						GrandExchangeOfferWorldComparator.updateItemPile(var3, var4);
					}
				}

				class186.playPcmPlayers();

				for (PendingSpawn var57 = (PendingSpawn)Client.pendingSpawns.last(); var57 != null; var57 = (PendingSpawn)Client.pendingSpawns.previous()) {
					if (var57.hitpoints == -1) {
						var57.delay = 0;
						class294.method5327(var57);
					} else {
						var57.remove();
					}
				}

				ObjectDefinition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var58;
				if (WorldMapSprite.client.hasFrame()) {
					var58 = Archive.method4265(ClientPacket.field2212, Client.packetWriter.isaacCipher);
					var58.packetBuffer.writeInt(1057001181);
					Client.packetWriter.method2219(var58);
				}

				if (!Client.isInInstance) {
					var3 = (Canvas.field418 - 6) / 8;
					var4 = (Canvas.field418 + 6) / 8;
					var51 = (ViewportMouse.field1747 - 6) / 8;
					var6 = (ViewportMouse.field1747 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var52 = var51 - 1; var52 <= var6 + 1; ++var52) {
							if (var7 < var3 || var7 > var4 || var52 < var51 || var52 > var6) {
								WorldMapCacheName.archive5.loadRegionFromName("m" + var7 + "_" + var52);
								WorldMapCacheName.archive5.loadRegionFromName("l" + var7 + "_" + var52);
							}
						}
					}
				}

				class96.updateGameState(30);
				class186.playPcmPlayers();
				KeyHandler.method787();
				var58 = Archive.method4265(ClientPacket.field2279, Client.packetWriter.isaacCipher);
				Client.packetWriter.method2219(var58);
				WallDecoration.method3291();
			}
		}
	}
}
