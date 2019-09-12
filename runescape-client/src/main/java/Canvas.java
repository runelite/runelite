import java.awt.Component;
import java.awt.Graphics;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1291773237
	)
	public static int field395;
	@ObfuscatedName("c")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "1869082478"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-87"
	)
	@Export("WorldMapElement_clearCached")
	public static void WorldMapElement_clearCached() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1591612905"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (GrandExchangeOfferTotalQuantityComparator.garbageCollector == null || !GrandExchangeOfferTotalQuantityComparator.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						GrandExchangeOfferTotalQuantityComparator.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (GrandExchangeOfferTotalQuantityComparator.garbageCollector != null) {
			long var9 = SoundCache.method2480();
			long var3 = GrandExchangeOfferTotalQuantityComparator.garbageCollector.getCollectionTime();
			if (GameShell.garbageCollectorLastCollectionTime != -1L) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(100L * var5 / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(ZLkt;B)V",
		garbageValue = "-109"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!Client.isInInstance) {
			int var2 = var1.method5514();
			var3 = var1.method5514();
			var4 = var1.readUnsignedShort();
			GrandExchangeOfferAgeComparator.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					GrandExchangeOfferAgeComparator.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			class197.regions = new int[var4];
			WorldMapEvent.regionMapArchiveIds = new int[var4];
			SequenceDefinition.regionLandArchiveIds = new int[var4];
			MusicPatchPcmStream.regionLandArchives = new byte[var4][];
			Client.regionMapArchives = new byte[var4][];
			boolean var16 = false;
			if ((var2 / 8 == 48 || var2 / 8 == 49) && var3 / 8 == 48) {
				var16 = true;
			}

			if (var2 / 8 == 48 && var3 / 8 == 148) {
				var16 = true;
			}

			var4 = 0;

			for (var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
				for (var7 = (var3 - 6) / 8; var7 <= (var3 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					if (!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
						class197.regions[var4] = var8;
						WorldMapEvent.regionMapArchiveIds[var4] = Timer.archive5.getGroupId("m" + var6 + "_" + var7);
						SequenceDefinition.regionLandArchiveIds[var4] = Timer.archive5.getGroupId("l" + var6 + "_" + var7);
						++var4;
					}
				}
			}

			WorldMapSection2.method301(var2, var3, true);
		} else {
			boolean var15 = var1.method5494() == 1;
			var3 = var1.readUnsignedShort();
			var4 = var1.method5459();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			GrandExchangeOfferAgeComparator.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					GrandExchangeOfferAgeComparator.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			class197.regions = new int[var5];
			WorldMapEvent.regionMapArchiveIds = new int[var5];
			SequenceDefinition.regionLandArchiveIds = new int[var5];
			MusicPatchPcmStream.regionLandArchives = new byte[var5][];
			Client.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (class197.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								class197.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								WorldMapEvent.regionMapArchiveIds[var5] = Timer.archive5.getGroupId("m" + var13 + "_" + var14);
								SequenceDefinition.regionLandArchiveIds[var5] = Timer.archive5.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			WorldMapSection2.method301(var3, var4, !var15);
		}

	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(Lgn;I)V",
		garbageValue = "1871694401"
	)
	static final void method815(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var3;
		int var6;
		int var37;
		int var38;
		int var39;
		int var40;
		if (class185.field2299 == var0) {
			var37 = var1.readUnsignedShort();
			var3 = var1.readUnsignedByteNegate();
			var38 = (var3 >> 4 & 7) + WorldMapSection1.field286;
			var39 = (var3 & 7) + ArchiveLoader.field508;
			var6 = var1.method5459();
			var40 = var1.readUnsignedByteNegate();
			if (var38 >= 0 && var39 >= 0 && var38 < 104 && var39 < 104) {
				var38 = var38 * 128 + 64;
				var39 = var39 * 128 + 64;
				GraphicsObject var41 = new GraphicsObject(var37, MouseRecorder.plane, var38, var39, WorldMapAreaData.getTileHeight(var38, var39, MouseRecorder.plane) - var40, var6, Client.cycle);
				Client.graphicsObjects.addFirst(var41);
			}

		} else {
			int var31;
			if (class185.field2303 == var0) {
				var37 = var1.readUnsignedByte();
				var3 = (var37 >> 4 & 7) + WorldMapSection1.field286;
				var38 = (var37 & 7) + ArchiveLoader.field508;
				var39 = var1.method5494();
				var6 = var39 >> 2;
				var40 = var39 & 3;
				var31 = Client.field682[var6];
				if (var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
					Tiles.updatePendingSpawn(MouseRecorder.plane, var3, var38, var31, -1, var6, var40, 0, -1);
				}

			} else {
				byte var4;
				byte var5;
				int var9;
				int var10;
				int var11;
				int var12;
				int var13;
				int var14;
				if (class185.field2296 == var0) {
					var37 = var1.readUnsignedByteNegate();
					var3 = var1.method5506();
					var4 = var1.method5634();
					var5 = var1.method5634();
					var6 = var1.method5494();
					var40 = (var6 >> 4 & 7) + WorldMapSection1.field286;
					var31 = (var6 & 7) + ArchiveLoader.field508;
					var9 = var1.readUnsignedByteNegate() * 4;
					var10 = var1.method5514();
					var11 = var1.method5459();
					var12 = var1.readUnsignedByte() * 4;
					var13 = var1.method5514();
					var14 = var1.readUnsignedByte();
					var39 = var5 + var40;
					var38 = var4 + var31;
					if (var40 >= 0 && var31 >= 0 && var40 < 104 && var31 < 104 && var39 >= 0 && var38 >= 0 && var39 < 104 && var38 < 104 && var10 != 65535) {
						var40 = var40 * 128 + 64;
						var31 = var31 * 128 + 64;
						var39 = var39 * 128 + 64;
						var38 = var38 * 128 + 64;
						Projectile var15 = new Projectile(var10, MouseRecorder.plane, var40, var31, WorldMapAreaData.getTileHeight(var40, var31, MouseRecorder.plane) - var12, var13 + Client.cycle, var11 + Client.cycle, var14, var37, var3, var9);
						var15.setDestination(var39, var38, WorldMapAreaData.getTileHeight(var39, var38, MouseRecorder.plane) - var9, var13 + Client.cycle);
						Client.projectiles.addFirst(var15);
					}

				} else if (class185.field2301 == var0) {
					var37 = var1.method5514();
					var3 = var1.method5547();
					var38 = (var3 >> 4 & 7) + WorldMapSection1.field286;
					var39 = (var3 & 7) + ArchiveLoader.field508;
					var6 = var1.readUnsignedByteNegate();
					var40 = var6 >> 2;
					var31 = var6 & 3;
					var9 = Client.field682[var40];
					if (var38 >= 0 && var39 >= 0 && var38 < 104 && var39 < 104) {
						Tiles.updatePendingSpawn(MouseRecorder.plane, var38, var39, var9, var37, var40, var31, 0, -1);
					}

				} else if (class185.field2304 == var0) {
					var37 = var1.method5514();
					var3 = var1.method5494();
					var38 = (var3 >> 4 & 7) + WorldMapSection1.field286;
					var39 = (var3 & 7) + ArchiveLoader.field508;
					var6 = var1.method5494();
					var40 = var6 >> 2;
					var31 = var6 & 3;
					var9 = Client.field682[var40];
					if (var38 >= 0 && var39 >= 0 && var38 < 103 && var39 < 103) {
						if (var9 == 0) {
							BoundaryObject var32 = WorldMapIcon_1.scene.method3063(MouseRecorder.plane, var38, var39);
							if (var32 != null) {
								var11 = SecureRandomFuture.Entity_unpackID(var32.tag);
								if (var40 == 2) {
									var32.entity1 = new DynamicObject(var11, 2, var31 + 4, MouseRecorder.plane, var38, var39, var37, false, var32.entity1);
									var32.entity2 = new DynamicObject(var11, 2, var31 + 1 & 3, MouseRecorder.plane, var38, var39, var37, false, var32.entity2);
								} else {
									var32.entity1 = new DynamicObject(var11, var40, var31, MouseRecorder.plane, var38, var39, var37, false, var32.entity1);
								}
							}
						}

						if (var9 == 1) {
							WallDecoration var42 = WorldMapIcon_1.scene.method3189(MouseRecorder.plane, var38, var39);
							if (var42 != null) {
								var11 = SecureRandomFuture.Entity_unpackID(var42.tag);
								if (var40 != 4 && var40 != 5) {
									if (var40 == 6) {
										var42.entity1 = new DynamicObject(var11, 4, var31 + 4, MouseRecorder.plane, var38, var39, var37, false, var42.entity1);
									} else if (var40 == 7) {
										var42.entity1 = new DynamicObject(var11, 4, (var31 + 2 & 3) + 4, MouseRecorder.plane, var38, var39, var37, false, var42.entity1);
									} else if (var40 == 8) {
										var42.entity1 = new DynamicObject(var11, 4, var31 + 4, MouseRecorder.plane, var38, var39, var37, false, var42.entity1);
										var42.entity2 = new DynamicObject(var11, 4, (var31 + 2 & 3) + 4, MouseRecorder.plane, var38, var39, var37, false, var42.entity2);
									}
								} else {
									var42.entity1 = new DynamicObject(var11, 4, var31, MouseRecorder.plane, var38, var39, var37, false, var42.entity1);
								}
							}
						}

						if (var9 == 2) {
							GameObject var43 = WorldMapIcon_1.scene.method3065(MouseRecorder.plane, var38, var39);
							if (var40 == 11) {
								var40 = 10;
							}

							if (var43 != null) {
								var43.entity = new DynamicObject(SecureRandomFuture.Entity_unpackID(var43.tag), var40, var31, MouseRecorder.plane, var38, var39, var37, false, var43.entity);
							}
						}

						if (var9 == 3) {
							FloorDecoration var44 = WorldMapIcon_1.scene.getFloorDecoration(MouseRecorder.plane, var38, var39);
							if (var44 != null) {
								var44.entity = new DynamicObject(SecureRandomFuture.Entity_unpackID(var44.tag), 22, var31, MouseRecorder.plane, var38, var39, var37, false, var44.entity);
							}
						}
					}

				} else {
					if (class185.field2297 == var0) {
						byte var2 = var1.method5634();
						var3 = var1.readUnsignedShort();
						var4 = var1.method5497();
						var5 = var1.method5634();
						var6 = var1.method5514();
						byte var7 = var1.method5498();
						var31 = var1.method5503();
						var9 = var1.method5514();
						var10 = var1.readUnsignedByte();
						var11 = (var10 >> 4 & 7) + WorldMapSection1.field286;
						var12 = (var10 & 7) + ArchiveLoader.field508;
						var13 = var1.readUnsignedByte();
						var14 = var13 >> 2;
						int var33 = var13 & 3;
						int var16 = Client.field682[var14];
						Player var17;
						if (var9 == Client.localPlayerIndex) {
							var17 = Varps.localPlayer;
						} else {
							var17 = Client.players[var9];
						}

						if (var17 != null) {
							ObjectDefinition var18 = WallDecoration.getObjectDefinition(var31);
							int var19;
							int var20;
							if (var33 != 1 && var33 != 3) {
								var19 = var18.sizeX;
								var20 = var18.sizeY;
							} else {
								var19 = var18.sizeY;
								var20 = var18.sizeX;
							}

							int var21 = var11 + (var19 >> 1);
							int var22 = var11 + (var19 + 1 >> 1);
							int var23 = var12 + (var20 >> 1);
							int var24 = var12 + (var20 + 1 >> 1);
							int[][] var25 = Tiles.Tiles_heights[MouseRecorder.plane];
							int var26 = var25[var22][var24] + var25[var21][var24] + var25[var21][var23] + var25[var22][var23] >> 2;
							int var27 = (var11 << 7) + (var19 << 6);
							int var28 = (var12 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var14, var33, var25, var27, var26, var28);
							if (var29 != null) {
								Tiles.updatePendingSpawn(MouseRecorder.plane, var11, var12, var16, -1, 0, 0, var6 + 1, var3 + 1);
								var17.animationCycleStart = var6 + Client.cycle;
								var17.animationCycleEnd = var3 + Client.cycle;
								var17.model0 = var29;
								var17.field597 = var11 * 128 + var19 * 64;
								var17.field599 = var12 * 128 + var20 * 64;
								var17.tileHeight2 = var26;
								byte var30;
								if (var4 > var2) {
									var30 = var4;
									var4 = var2;
									var2 = var30;
								}

								if (var7 > var5) {
									var30 = var7;
									var7 = var5;
									var5 = var30;
								}

								var17.field601 = var4 + var11;
								var17.field609 = var11 + var2;
								var17.field602 = var7 + var12;
								var17.field604 = var5 + var12;
							}
						}
					}

					if (class185.field2305 == var0) {
						var37 = var1.method5547();
						var3 = (var37 >> 4 & 7) + WorldMapSection1.field286;
						var38 = (var37 & 7) + ArchiveLoader.field508;
						var39 = var1.method5547();
						var6 = var39 >> 4 & 15;
						var40 = var39 & 7;
						var31 = var1.readUnsignedShort();
						var9 = var1.method5547();
						if (var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
							var10 = var6 + 1;
							if (Varps.localPlayer.pathX[0] >= var3 - var10 && Varps.localPlayer.pathX[0] <= var3 + var10 && Varps.localPlayer.pathY[0] >= var38 - var10 && Varps.localPlayer.pathY[0] <= var38 + var10 && Client.field860 != 0 && var40 > 0 && Client.soundEffectCount < 50) {
								Client.soundEffectIds[Client.soundEffectCount] = var31;
								Client.queuedSoundEffectLoops[Client.soundEffectCount] = var40;
								Client.queuedSoundEffectDelays[Client.soundEffectCount] = var9;
								Client.soundEffects[Client.soundEffectCount] = null;
								Client.soundLocations[Client.soundEffectCount] = var6 + (var38 << 8) + (var3 << 16);
								++Client.soundEffectCount;
							}
						}
					}

					TileItem var35;
					if (class185.field2298 == var0) {
						var37 = var1.readUnsignedByte();
						var3 = (var37 >> 4 & 7) + WorldMapSection1.field286;
						var38 = (var37 & 7) + ArchiveLoader.field508;
						var39 = var1.method5514();
						if (var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
							NodeDeque var34 = Client.groundItems[MouseRecorder.plane][var3][var38];
							if (var34 != null) {
								for (var35 = (TileItem)var34.last(); var35 != null; var35 = (TileItem)var34.previous()) {
									if ((var39 & 32767) == var35.id) {
										var35.remove();
										break;
									}
								}

								if (var34.last() == null) {
									Client.groundItems[MouseRecorder.plane][var3][var38] = null;
								}

								WorldMapCacheName.updateItemPile(var3, var38);
							}
						}

					} else if (class185.field2302 == var0) {
						var37 = var1.method5514();
						var3 = var1.method5503();
						var38 = var1.method5547();
						var39 = (var38 >> 4 & 7) + WorldMapSection1.field286;
						var6 = (var38 & 7) + ArchiveLoader.field508;
						if (var39 >= 0 && var6 >= 0 && var39 < 104 && var6 < 104) {
							var35 = new TileItem();
							var35.id = var37;
							var35.quantity = var3;
							if (Client.groundItems[MouseRecorder.plane][var39][var6] == null) {
								Client.groundItems[MouseRecorder.plane][var39][var6] = new NodeDeque();
							}

							Client.groundItems[MouseRecorder.plane][var39][var6].addFirst(var35);
							WorldMapCacheName.updateItemPile(var39, var6);
						}

					} else if (class185.field2300 == var0) {
						var37 = var1.readUnsignedShort();
						var3 = var1.readUnsignedShort();
						var38 = var1.method5547();
						var39 = (var38 >> 4 & 7) + WorldMapSection1.field286;
						var6 = (var38 & 7) + ArchiveLoader.field508;
						var40 = var1.method5459();
						if (var39 >= 0 && var6 >= 0 && var39 < 104 && var6 < 104) {
							NodeDeque var8 = Client.groundItems[MouseRecorder.plane][var39][var6];
							if (var8 != null) {
								for (TileItem var36 = (TileItem)var8.last(); var36 != null; var36 = (TileItem)var8.previous()) {
									if ((var37 & 32767) == var36.id && var3 == var36.quantity) {
										var36.quantity = var40;
										break;
									}
								}

								WorldMapCacheName.updateItemPile(var39, var6);
							}
						}

					}
				}
			}
		}
	}
}
