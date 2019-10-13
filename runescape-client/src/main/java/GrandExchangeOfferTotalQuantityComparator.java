import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("GrandExchangeOfferTotalQuantityComparator")
final class GrandExchangeOfferTotalQuantityComparator implements Comparator {
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lm;Lm;I)I",
		garbageValue = "-1270482233"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1729511296"
	)
	public static boolean method93(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("ez")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1447475674"
	)
	static int method100() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field908;
		} else {
			return 10000;
		}
	}

	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "99"
	)
	static void method91(int var0, int var1) {
		int[] var2 = new int[9];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			int var4 = var3 * 32 + 15 + 128;
			int var5 = var4 * 3 + 600;
			int var7 = Rasterizer3D.Rasterizer3D_sine[var4];
			int var9 = var1 - 334;
			if (var9 < 0) {
				var9 = 0;
			} else if (var9 > 100) {
				var9 = 100;
			}

			int var10 = (Client.zoomWidth - Client.zoomHeight) * var9 / 100 + Client.zoomHeight;
			int var8 = var10 * var5 / 256;
			var2[var3] = var7 * var8 >> 16;
		}

		Scene.Scene_buildVisiblityMap(var2, 500, 800, var0 * 334 / var1, 334);
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(Lgw;I)V",
		garbageValue = "865930097"
	)
	static final void method105(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		int var14;
		if (class185.field2298 == var0) {
			byte var2 = var1.readByte();
			byte var3 = var1.readByte();
			var4 = var1.readUnsignedByte();
			var5 = var4 >> 2;
			var6 = var4 & 3;
			var7 = Client.field697[var5];
			var8 = var1.method5471();
			var9 = (var8 >> 4 & 7) + class40.field326;
			var10 = (var8 & 7) + WorldMapSection2.field195;
			byte var11 = var1.method5474();
			var12 = var1.method5480();
			var13 = var1.method5479();
			var14 = var1.readUnsignedShort();
			int var15 = var1.method5480();
			byte var16 = var1.method5473();
			Player var17;
			if (var15 == Client.localPlayerIndex) {
				var17 = class223.localPlayer;
			} else {
				var17 = Client.players[var15];
			}

			if (var17 != null) {
				ObjectDefinition var18 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var14);
				int var19;
				int var20;
				if (var6 != 1 && var6 != 3) {
					var19 = var18.sizeX;
					var20 = var18.sizeY;
				} else {
					var19 = var18.sizeY;
					var20 = var18.sizeX;
				}

				int var21 = var9 + (var19 >> 1);
				int var22 = var9 + (var19 + 1 >> 1);
				int var23 = var10 + (var20 >> 1);
				int var24 = var10 + (var20 + 1 >> 1);
				int[][] var25 = Tiles.Tiles_heights[WorldMapRectangle.plane];
				int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
				int var27 = (var9 << 7) + (var19 << 6);
				int var28 = (var10 << 7) + (var20 << 6);
				Model var29 = var18.getModel(var5, var6, var25, var27, var26, var28);
				if (var29 != null) {
					WorldMapSection1.updatePendingSpawn(WorldMapRectangle.plane, var9, var10, var7, -1, 0, 0, var12 + 1, var13 + 1);
					var17.animationCycleStart = var12 + Client.cycle;
					var17.animationCycleEnd = var13 + Client.cycle;
					var17.model0 = var29;
					var17.field606 = var9 * 128 + var19 * 64;
					var17.field608 = var10 * 128 + var20 * 64;
					var17.tileHeight2 = var26;
					byte var30;
					if (var2 > var11) {
						var30 = var2;
						var2 = var11;
						var11 = var30;
					}

					if (var3 > var16) {
						var30 = var3;
						var3 = var16;
						var16 = var30;
					}

					var17.field622 = var2 + var9;
					var17.field612 = var11 + var9;
					var17.field611 = var10 + var3;
					var17.field613 = var10 + var16;
				}
			}
		}

		int var37;
		int var38;
		int var40;
		if (class185.field2302 == var0) {
			var37 = var1.method5480();
			var38 = var1.method5471();
			var4 = (var38 >> 4 & 7) + class40.field326;
			var5 = (var38 & 7) + WorldMapSection2.field195;
			var6 = var1.readUnsignedByte();
			var7 = var6 >> 2;
			var8 = var6 & 3;
			var9 = Client.field697[var7];
			if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
				if (var9 == 0) {
					BoundaryObject var31 = PacketWriter.scene.method3068(WorldMapRectangle.plane, var4, var5);
					if (var31 != null) {
						var40 = class81.Entity_unpackID(var31.tag);
						if (var7 == 2) {
							var31.entity1 = new DynamicObject(var40, 2, var8 + 4, WorldMapRectangle.plane, var4, var5, var37, false, var31.entity1);
							var31.entity2 = new DynamicObject(var40, 2, var8 + 1 & 3, WorldMapRectangle.plane, var4, var5, var37, false, var31.entity2);
						} else {
							var31.entity1 = new DynamicObject(var40, var7, var8, WorldMapRectangle.plane, var4, var5, var37, false, var31.entity1);
						}
					}
				}

				if (var9 == 1) {
					WallDecoration var42 = PacketWriter.scene.method3069(WorldMapRectangle.plane, var4, var5);
					if (var42 != null) {
						var40 = class81.Entity_unpackID(var42.tag);
						if (var7 != 4 && var7 != 5) {
							if (var7 == 6) {
								var42.entity1 = new DynamicObject(var40, 4, var8 + 4, WorldMapRectangle.plane, var4, var5, var37, false, var42.entity1);
							} else if (var7 == 7) {
								var42.entity1 = new DynamicObject(var40, 4, (var8 + 2 & 3) + 4, WorldMapRectangle.plane, var4, var5, var37, false, var42.entity1);
							} else if (var7 == 8) {
								var42.entity1 = new DynamicObject(var40, 4, var8 + 4, WorldMapRectangle.plane, var4, var5, var37, false, var42.entity1);
								var42.entity2 = new DynamicObject(var40, 4, (var8 + 2 & 3) + 4, WorldMapRectangle.plane, var4, var5, var37, false, var42.entity2);
							}
						} else {
							var42.entity1 = new DynamicObject(var40, 4, var8, WorldMapRectangle.plane, var4, var5, var37, false, var42.entity1);
						}
					}
				}

				if (var9 == 2) {
					GameObject var43 = PacketWriter.scene.method3070(WorldMapRectangle.plane, var4, var5);
					if (var7 == 11) {
						var7 = 10;
					}

					if (var43 != null) {
						var43.entity = new DynamicObject(class81.Entity_unpackID(var43.tag), var7, var8, WorldMapRectangle.plane, var4, var5, var37, false, var43.entity);
					}
				}

				if (var9 == 3) {
					FloorDecoration var44 = PacketWriter.scene.getFloorDecoration(WorldMapRectangle.plane, var4, var5);
					if (var44 != null) {
						var44.entity = new DynamicObject(class81.Entity_unpackID(var44.tag), 22, var8, WorldMapRectangle.plane, var4, var5, var37, false, var44.entity);
					}
				}
			}

		} else {
			TileItem var33;
			if (class185.field2304 == var0) {
				var37 = var1.method5470();
				var38 = (var37 >> 4 & 7) + class40.field326;
				var4 = (var37 & 7) + WorldMapSection2.field195;
				var5 = var1.method5647();
				if (var38 >= 0 && var4 >= 0 && var38 < 104 && var4 < 104) {
					NodeDeque var32 = Client.groundItems[WorldMapRectangle.plane][var38][var4];
					if (var32 != null) {
						for (var33 = (TileItem)var32.last(); var33 != null; var33 = (TileItem)var32.previous()) {
							if ((var5 & 32767) == var33.id) {
								var33.remove();
								break;
							}
						}

						if (var32.last() == null) {
							Client.groundItems[WorldMapRectangle.plane][var38][var4] = null;
						}

						WorldMapCacheName.updateItemPile(var38, var4);
					}
				}

			} else if (class185.field2296 == var0) {
				var37 = var1.method5471();
				var38 = var37 >> 2;
				var4 = var37 & 3;
				var5 = Client.field697[var38];
				var6 = var1.method5470();
				var7 = (var6 >> 4 & 7) + class40.field326;
				var8 = (var6 & 7) + WorldMapSection2.field195;
				if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
					WorldMapSection1.updatePendingSpawn(WorldMapRectangle.plane, var7, var8, var5, -1, var38, var4, 0, -1);
				}

			} else if (class185.field2297 == var0) {
				var37 = var1.method5480();
				var38 = var1.method5479();
				var4 = var1.method5470();
				var5 = (var4 >> 4 & 7) + class40.field326;
				var6 = (var4 & 7) + WorldMapSection2.field195;
				if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
					var33 = new TileItem();
					var33.id = var38;
					var33.quantity = var37;
					if (Client.groundItems[WorldMapRectangle.plane][var5][var6] == null) {
						Client.groundItems[WorldMapRectangle.plane][var5][var6] = new NodeDeque();
					}

					Client.groundItems[WorldMapRectangle.plane][var5][var6].addFirst(var33);
					WorldMapCacheName.updateItemPile(var5, var6);
				}

			} else {
				if (class185.field2300 == var0) {
					var37 = var1.method5511();
					var38 = (var37 >> 4 & 7) + class40.field326;
					var4 = (var37 & 7) + WorldMapSection2.field195;
					var5 = var1.method5511();
					var6 = var5 >> 4 & 15;
					var7 = var5 & 7;
					var8 = var1.readUnsignedShort();
					var9 = var1.method5511();
					if (var38 >= 0 && var4 >= 0 && var38 < 104 && var4 < 104) {
						var10 = var6 + 1;
						if (class223.localPlayer.pathX[0] >= var38 - var10 && class223.localPlayer.pathX[0] <= var10 + var38 && class223.localPlayer.pathY[0] >= var4 - var10 && class223.localPlayer.pathY[0] <= var10 + var4 && Client.field868 != 0 && var7 > 0 && Client.soundEffectCount < 50) {
							Client.soundEffectIds[Client.soundEffectCount] = var8;
							Client.queuedSoundEffectLoops[Client.soundEffectCount] = var7;
							Client.queuedSoundEffectDelays[Client.soundEffectCount] = var9;
							Client.soundEffects[Client.soundEffectCount] = null;
							Client.soundLocations[Client.soundEffectCount] = var6 + (var4 << 8) + (var38 << 16);
							++Client.soundEffectCount;
						}
					}
				}

				if (class185.field2299 == var0) {
					var37 = var1.readUnsignedByte();
					var38 = var37 >> 2;
					var4 = var37 & 3;
					var5 = Client.field697[var38];
					var6 = var1.method5470();
					var7 = (var6 >> 4 & 7) + class40.field326;
					var8 = (var6 & 7) + WorldMapSection2.field195;
					var9 = var1.readUnsignedShort();
					if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
						WorldMapSection1.updatePendingSpawn(WorldMapRectangle.plane, var7, var8, var5, var9, var38, var4, 0, -1);
					}

				} else if (class185.field2295 == var0) {
					var37 = var1.method5647();
					var38 = var1.method5511();
					var4 = (var38 >> 4 & 7) + class40.field326;
					var5 = (var38 & 7) + WorldMapSection2.field195;
					var6 = var1.method5479();
					var7 = var1.method5647();
					byte var39 = var1.method5475();
					var9 = var1.method5511() * 4;
					var10 = var1.readUnsignedByte();
					var40 = var1.method5470();
					byte var41 = var1.method5473();
					var13 = var1.method5486();
					var14 = var1.method5511() * 4;
					var12 = var41 + var4;
					var8 = var39 + var5;
					if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104 && var12 >= 0 && var8 >= 0 && var12 < 104 && var8 < 104 && var37 != 65535) {
						var4 = var4 * 128 + 64;
						var5 = var5 * 128 + 64;
						var12 = var12 * 128 + 64;
						var8 = var8 * 128 + 64;
						Projectile var34 = new Projectile(var37, WorldMapRectangle.plane, var4, var5, MusicPatchPcmStream.getTileHeight(var4, var5, WorldMapRectangle.plane) - var14, var6 + Client.cycle, var7 + Client.cycle, var40, var10, var13, var9);
						var34.setDestination(var12, var8, MusicPatchPcmStream.getTileHeight(var12, var8, WorldMapRectangle.plane) - var9, var6 + Client.cycle);
						Client.projectiles.addFirst(var34);
					}

				} else if (class185.field2303 != var0) {
					if (class185.field2301 == var0) {
						var37 = var1.method5647();
						var38 = var1.method5470();
						var4 = var1.method5470();
						var5 = (var4 >> 4 & 7) + class40.field326;
						var6 = (var4 & 7) + WorldMapSection2.field195;
						var7 = var1.method5479();
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							var5 = var5 * 128 + 64;
							var6 = var6 * 128 + 64;
							GraphicsObject var45 = new GraphicsObject(var7, WorldMapRectangle.plane, var5, var6, MusicPatchPcmStream.getTileHeight(var5, var6, WorldMapRectangle.plane) - var38, var37, Client.cycle);
							Client.graphicsObjects.addFirst(var45);
						}

					}
				} else {
					var37 = var1.method5479();
					var38 = var1.method5480();
					var4 = var1.method5471();
					var5 = (var4 >> 4 & 7) + class40.field326;
					var6 = (var4 & 7) + WorldMapSection2.field195;
					var7 = var1.method5480();
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						NodeDeque var35 = Client.groundItems[WorldMapRectangle.plane][var5][var6];
						if (var35 != null) {
							for (TileItem var36 = (TileItem)var35.last(); var36 != null; var36 = (TileItem)var35.previous()) {
								if ((var37 & 32767) == var36.id && var7 == var36.quantity) {
									var36.quantity = var38;
									break;
								}
							}

							WorldMapCacheName.updateItemPile(var5, var6);
						}
					}

				}
			}
		}
	}
}
