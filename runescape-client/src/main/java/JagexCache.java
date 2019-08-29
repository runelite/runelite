import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("u")
	@Export("cacheDir")
	public static File cacheDir;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1902063795
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(CLgk;I)I",
		garbageValue = "57673109"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(Lgt;I)V",
		garbageValue = "-2026077501"
	)
	static final void method3438(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var42;
		if (class185.field2300 == var0) {
			var2 = var1.method5438();
			var3 = var2 >> 2;
			var4 = var2 & 3;
			var5 = Client.field665[var3];
			var6 = var1.readUnsignedByteNegate();
			var7 = (var6 >> 4 & 7) + WorldMapSection1.field283;
			var8 = (var6 & 7) + Varps.field2507;
			var9 = var1.readUnsignedShort();
			if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
				if (var5 == 0) {
					BoundaryObject var10 = Player.scene.method3032(ItemContainer.plane, var7, var8);
					if (var10 != null) {
						var42 = BoundaryObject.Entity_unpackID(var10.tag);
						if (var3 == 2) {
							var10.entity1 = new DynamicObject(var42, 2, var4 + 4, ItemContainer.plane, var7, var8, var9, false, var10.entity1);
							var10.entity2 = new DynamicObject(var42, 2, var4 + 1 & 3, ItemContainer.plane, var7, var8, var9, false, var10.entity2);
						} else {
							var10.entity1 = new DynamicObject(var42, var3, var4, ItemContainer.plane, var7, var8, var9, false, var10.entity1);
						}
					}
				}

				if (var5 == 1) {
					WallDecoration var39 = Player.scene.method3033(ItemContainer.plane, var7, var8);
					if (var39 != null) {
						var42 = BoundaryObject.Entity_unpackID(var39.tag);
						if (var3 != 4 && var3 != 5) {
							if (var3 == 6) {
								var39.entity1 = new DynamicObject(var42, 4, var4 + 4, ItemContainer.plane, var7, var8, var9, false, var39.entity1);
							} else if (var3 == 7) {
								var39.entity1 = new DynamicObject(var42, 4, (var4 + 2 & 3) + 4, ItemContainer.plane, var7, var8, var9, false, var39.entity1);
							} else if (var3 == 8) {
								var39.entity1 = new DynamicObject(var42, 4, var4 + 4, ItemContainer.plane, var7, var8, var9, false, var39.entity1);
								var39.entity2 = new DynamicObject(var42, 4, (var4 + 2 & 3) + 4, ItemContainer.plane, var7, var8, var9, false, var39.entity2);
							}
						} else {
							var39.entity1 = new DynamicObject(var42, 4, var4, ItemContainer.plane, var7, var8, var9, false, var39.entity1);
						}
					}
				}

				if (var5 == 2) {
					GameObject var40 = Player.scene.method3034(ItemContainer.plane, var7, var8);
					if (var3 == 11) {
						var3 = 10;
					}

					if (var40 != null) {
						var40.entity = new DynamicObject(BoundaryObject.Entity_unpackID(var40.tag), var3, var4, ItemContainer.plane, var7, var8, var9, false, var40.entity);
					}
				}

				if (var5 == 3) {
					FloorDecoration var41 = Player.scene.getFloorDecoration(ItemContainer.plane, var7, var8);
					if (var41 != null) {
						var41.entity = new DynamicObject(BoundaryObject.Entity_unpackID(var41.tag), 22, var4, ItemContainer.plane, var7, var8, var9, false, var41.entity);
					}
				}
			}

		} else if (class185.field2301 == var0) {
			var2 = var1.method5445();
			var3 = var1.method5447();
			var4 = var1.method5445();
			var5 = var1.method5436();
			var6 = (var5 >> 4 & 7) + WorldMapSection1.field283;
			var7 = (var5 & 7) + Varps.field2507;
			if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
				NodeDeque var45 = Client.groundItems[ItemContainer.plane][var6][var7];
				if (var45 != null) {
					for (TileItem var32 = (TileItem)var45.last(); var32 != null; var32 = (TileItem)var45.previous()) {
						if ((var2 & 32767) == var32.id && var4 == var32.quantity) {
							var32.quantity = var3;
							break;
						}
					}

					class189.updateItemPile(var6, var7);
				}
			}

		} else if (class185.field2299 == var0) {
			var2 = var1.readUnsignedShort();
			var3 = var1.method5436();
			var4 = var1.method5446();
			var5 = var1.readUnsignedByte();
			var6 = (var5 >> 4 & 7) + WorldMapSection1.field283;
			var7 = (var5 & 7) + Varps.field2507;
			if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
				var6 = var6 * 128 + 64;
				var7 = var7 * 128 + 64;
				GraphicsObject var31 = new GraphicsObject(var2, ItemContainer.plane, var6, var7, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var6, var7, ItemContainer.plane) - var3, var4, Client.cycle);
				Client.graphicsObjects.addFirst(var31);
			}

		} else {
			int var12;
			byte var13;
			int var14;
			int var33;
			if (class185.field2306 == var0) {
				var2 = var1.method5438() * 4;
				var3 = var1.readUnsignedShort();
				var4 = var1.method5446();
				var5 = var1.method5438() * 4;
				var6 = var1.method5448();
				var7 = var1.readUnsignedByte();
				var8 = var1.method5438();
				var9 = var1.method5445();
				var33 = var1.method5436();
				var42 = (var33 >> 4 & 7) + WorldMapSection1.field283;
				var12 = (var33 & 7) + Varps.field2507;
				var13 = var1.method5616();
				byte var43 = var1.method5421();
				var14 = var43 + var42;
				int var44 = var13 + var12;
				if (var42 >= 0 && var12 >= 0 && var42 < 104 && var12 < 104 && var14 >= 0 && var44 >= 0 && var14 < 104 && var44 < 104 && var4 != 65535) {
					var42 = var42 * 128 + 64;
					var12 = var12 * 128 + 64;
					var14 = var14 * 128 + 64;
					var44 = var44 * 128 + 64;
					Projectile var15 = new Projectile(var4, ItemContainer.plane, var42, var12, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var42, var12, ItemContainer.plane) - var5, var9 + Client.cycle, var3 + Client.cycle, var7, var8, var6, var2);
					var15.setDestination(var14, var44, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var14, var44, ItemContainer.plane) - var2, var9 + Client.cycle);
					Client.projectiles.addFirst(var15);
				}

			} else if (class185.field2302 == var0) {
				var2 = var1.method5438();
				var3 = var2 >> 2;
				var4 = var2 & 3;
				var5 = Client.field665[var3];
				var6 = var1.method5438();
				var7 = (var6 >> 4 & 7) + WorldMapSection1.field283;
				var8 = (var6 & 7) + Varps.field2507;
				if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
					StudioGame.updatePendingSpawn(ItemContainer.plane, var7, var8, var5, -1, var3, var4, 0, -1);
				}

			} else {
				TileItem var35;
				if (class185.field2297 == var0) {
					var2 = var1.method5436();
					var3 = (var2 >> 4 & 7) + WorldMapSection1.field283;
					var4 = (var2 & 7) + Varps.field2507;
					var5 = var1.method5447();
					if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
						NodeDeque var34 = Client.groundItems[ItemContainer.plane][var3][var4];
						if (var34 != null) {
							for (var35 = (TileItem)var34.last(); var35 != null; var35 = (TileItem)var34.previous()) {
								if ((var5 & 32767) == var35.id) {
									var35.remove();
									break;
								}
							}

							if (var34.last() == null) {
								Client.groundItems[ItemContainer.plane][var3][var4] = null;
							}

							class189.updateItemPile(var3, var4);
						}
					}

				} else {
					if (class185.field2304 == var0) {
						var2 = var1.readUnsignedByte();
						var3 = (var2 >> 4 & 7) + WorldMapSection1.field283;
						var4 = (var2 & 7) + Varps.field2507;
						var5 = var1.method5438();
						var6 = var1.method5436();
						var7 = var6 >> 4 & 15;
						var8 = var6 & 7;
						var9 = var1.method5447();
						if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
							var33 = var7 + 1;
							if (WorldMapIcon_1.localPlayer.pathX[0] >= var3 - var33 && WorldMapIcon_1.localPlayer.pathX[0] <= var3 + var33 && WorldMapIcon_1.localPlayer.pathY[0] >= var4 - var33 && WorldMapIcon_1.localPlayer.pathY[0] <= var33 + var4 && Client.field860 != 0 && var8 > 0 && Client.soundEffectCount < 50) {
								Client.soundEffectIds[Client.soundEffectCount] = var9;
								Client.queuedSoundEffectLoops[Client.soundEffectCount] = var8;
								Client.queuedSoundEffectDelays[Client.soundEffectCount] = var5;
								Client.soundEffects[Client.soundEffectCount] = null;
								Client.soundLocations[Client.soundEffectCount] = var7 + (var4 << 8) + (var3 << 16);
								++Client.soundEffectCount;
							}
						}
					}

					if (class185.field2303 == var0) {
						var2 = var1.method5446();
						var3 = var1.method5447();
						var4 = var1.method5436();
						var5 = (var4 >> 4 & 7) + WorldMapSection1.field283;
						var6 = (var4 & 7) + Varps.field2507;
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							var35 = new TileItem();
							var35.id = var3;
							var35.quantity = var2;
							if (Client.groundItems[ItemContainer.plane][var5][var6] == null) {
								Client.groundItems[ItemContainer.plane][var5][var6] = new NodeDeque();
							}

							Client.groundItems[ItemContainer.plane][var5][var6].addFirst(var35);
							class189.updateItemPile(var5, var6);
						}

					} else {
						if (class185.field2298 == var0) {
							byte var37 = var1.method5421();
							var3 = var1.method5447();
							byte var38 = var1.method5421();
							var5 = var1.method5446();
							var6 = var1.readUnsignedShort();
							var7 = var1.method5436();
							var8 = var7 >> 2;
							var9 = var7 & 3;
							var33 = Client.field665[var8];
							byte var11 = var1.method5616();
							var12 = var1.method5445();
							var13 = var1.method5421();
							var14 = var1.readUnsignedByteNegate();
							int var36 = (var14 >> 4 & 7) + WorldMapSection1.field283;
							int var16 = (var14 & 7) + Varps.field2507;
							Player var17;
							if (var12 == Client.localPlayerIndex) {
								var17 = WorldMapIcon_1.localPlayer;
							} else {
								var17 = Client.players[var12];
							}

							if (var17 != null) {
								ObjectDefinition var18 = class215.getObjectDefinition(var5);
								int var19;
								int var20;
								if (var9 != 1 && var9 != 3) {
									var19 = var18.sizeX;
									var20 = var18.sizeY;
								} else {
									var19 = var18.sizeY;
									var20 = var18.sizeX;
								}

								int var21 = var36 + (var19 >> 1);
								int var22 = var36 + (var19 + 1 >> 1);
								int var23 = var16 + (var20 >> 1);
								int var24 = var16 + (var20 + 1 >> 1);
								int[][] var25 = Tiles.Tiles_heights[ItemContainer.plane];
								int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
								int var27 = (var36 << 7) + (var19 << 6);
								int var28 = (var16 << 7) + (var20 << 6);
								Model var29 = var18.getModel(var8, var9, var25, var27, var26, var28);
								if (var29 != null) {
									StudioGame.updatePendingSpawn(ItemContainer.plane, var36, var16, var33, -1, 0, 0, var6 + 1, var3 + 1);
									var17.animationCycleStart = var6 + Client.cycle;
									var17.animationCycleEnd = var3 + Client.cycle;
									var17.model0 = var29;
									var17.field599 = var36 * 128 + var19 * 64;
									var17.field601 = var16 * 128 + var20 * 64;
									var17.tileHeight2 = var26;
									byte var30;
									if (var37 > var13) {
										var30 = var37;
										var37 = var13;
										var13 = var30;
									}

									if (var11 > var38) {
										var30 = var11;
										var11 = var38;
										var38 = var30;
									}

									var17.field603 = var37 + var36;
									var17.field616 = var36 + var13;
									var17.field604 = var16 + var11;
									var17.field606 = var38 + var16;
								}
							}
						}

						if (class185.field2305 == var0) {
							var2 = var1.method5436();
							var3 = (var2 >> 4 & 7) + WorldMapSection1.field283;
							var4 = (var2 & 7) + Varps.field2507;
							var5 = var1.method5438();
							var6 = var5 >> 2;
							var7 = var5 & 3;
							var8 = Client.field665[var6];
							var9 = var1.method5446();
							if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
								StudioGame.updatePendingSpawn(ItemContainer.plane, var3, var4, var8, var9, var6, var7, 0, -1);
							}

						}
					}
				}
			}
		}
	}
}
