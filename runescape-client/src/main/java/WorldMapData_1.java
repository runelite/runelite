import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ac")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("lq")
	@ObfuscatedGetter(
		intValue = -759112177
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1108561207
	)
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1693102949
	)
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1779998121
	)
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -468577011
	)
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "1"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field303.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort();
			super.regionYLow = var1.readUnsignedShort();
			this.chunkXLow = var1.readUnsignedByte();
			this.chunkYLow = var1.readUnsignedByte();
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			this.chunkX = var1.readUnsignedByte();
			this.chunkY = var1.readUnsignedByte();
			super.groupId = var1.method5591();
			super.fileId = var1.method5591();
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;B)V",
		garbageValue = "-78"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field205 = new byte[super.planes][64][64];
		super.field206 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class39.field297.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			int var5 = var1.readUnsignedByte();
			int var6 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
				for (int var7 = 0; var7 < 8; ++var7) {
					for (int var8 = 0; var8 < 8; ++var8) {
						this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "3"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1104006476"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2123096151"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-50915018"
	)
	@Export("getChunkY")
	int getChunkY() {
		return this.chunkY;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_1)) {
			return false;
		} else {
			WorldMapData_1 var2 = (WorldMapData_1)var1;
			if (super.regionX == var2.regionX && super.regionY == var2.regionY) {
				return var2.chunkX == this.chunkX && var2.chunkY == this.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)Lcq;",
		garbageValue = "-96"
	)
	static ClientPreferences method813() {
		AccessFile var0 = null;
		ClientPreferences var1 = new ClientPreferences();

		try {
			var0 = KeyHandler.getPreferencesFile("", WorldMapArchiveLoader.field3965.name, false);
			byte[] var2 = new byte[(int)var0.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var0.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var1 = new ClientPreferences(new Buffer(var2));
		} catch (Exception var6) {
		}

		try {
			if (var0 != null) {
				var0.close();
			}
		} catch (Exception var5) {
		}

		return var1;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILce;ZB)I",
		garbageValue = "66"
	)
	static int method814(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		signature = "(Lgh;B)V",
		garbageValue = "49"
	)
	static final void method816(class194 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var37;
		if (class194.field2327 == var0) {
			var37 = var1.method5604();
			var3 = var37 >> 2;
			var4 = var37 & 3;
			var5 = Client.field699[var3];
			var6 = var1.readUnsignedByte();
			var7 = (var6 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
			var8 = (var6 & 7) + PlatformInfo.field3959;
			if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
				Skeleton.updatePendingSpawn(ScriptEvent.Client_plane, var7, var8, var5, -1, var3, var4, 0, -1);
			}

		} else {
			int var9;
			int var11;
			int var12;
			int var13;
			byte var14;
			if (class194.field2324 == var0) {
				byte var2 = var1.method5608();
				var3 = var1.method5614();
				var4 = var1.readUnsignedShort();
				var5 = var1.method5614();
				var6 = var1.method5604();
				var7 = var6 >> 2;
				var8 = var6 & 3;
				var9 = Client.field699[var7];
				byte var10 = var1.readByte();
				var11 = var1.method5603();
				var12 = (var11 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
				var13 = (var11 & 7) + PlatformInfo.field3959;
				var14 = var1.method5606();
				int var15 = var1.method5614();
				byte var16 = var1.method5606();
				Player var17;
				if (var4 == Client.localPlayerIndex) {
					var17 = ByteArrayPool.localPlayer;
				} else {
					var17 = Client.players[var4];
				}

				if (var17 != null) {
					ObjectDefinition var18 = WorldMapSection2.getObjectDefinition(var5);
					int var19;
					int var20;
					if (var8 != 1 && var8 != 3) {
						var19 = var18.sizeX;
						var20 = var18.sizeY;
					} else {
						var19 = var18.sizeY;
						var20 = var18.sizeX;
					}

					int var21 = var12 + (var19 >> 1);
					int var22 = var12 + (var19 + 1 >> 1);
					int var23 = var13 + (var20 >> 1);
					int var24 = var13 + (var20 + 1 >> 1);
					int[][] var25 = Tiles.Tiles_heights[ScriptEvent.Client_plane];
					int var26 = var25[var21][var24] + var25[var21][var23] + var25[var22][var23] + var25[var22][var24] >> 2;
					int var27 = (var12 << 7) + (var19 << 6);
					int var28 = (var13 << 7) + (var20 << 6);
					Model var29 = var18.getModel(var7, var8, var25, var27, var26, var28);
					if (var29 != null) {
						Skeleton.updatePendingSpawn(ScriptEvent.Client_plane, var12, var13, var9, -1, 0, 0, var15 + 1, var3 + 1);
						var17.animationCycleStart = var15 + Client.cycle;
						var17.animationCycleEnd = var3 + Client.cycle;
						var17.model0 = var29;
						var17.field662 = var19 * 64 + var12 * 128;
						var17.field657 = var20 * 64 + var13 * 128;
						var17.tileHeight2 = var26;
						byte var30;
						if (var10 > var14) {
							var30 = var10;
							var10 = var14;
							var14 = var30;
						}

						if (var2 > var16) {
							var30 = var2;
							var2 = var16;
							var16 = var30;
						}

						var17.field659 = var12 + var10;
						var17.field661 = var14 + var12;
						var17.field660 = var2 + var13;
						var17.field664 = var13 + var16;
					}
				}
			}

			TileItem var32;
			if (class194.field2331 == var0) {
				var37 = var1.method5605();
				var3 = (var37 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
				var4 = (var37 & 7) + PlatformInfo.field3959;
				var5 = var1.readUnsignedShort();
				if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
					NodeDeque var31 = Client.groundItems[ScriptEvent.Client_plane][var3][var4];
					if (var31 != null) {
						for (var32 = (TileItem)var31.last(); var32 != null; var32 = (TileItem)var31.previous()) {
							if ((var5 & 32767) == var32.id) {
								var32.remove();
								break;
							}
						}

						if (var31.last() == null) {
							Client.groundItems[ScriptEvent.Client_plane][var3][var4] = null;
						}

						World.updateItemPile(var3, var4);
					}
				}

			} else if (class194.field2329 == var0) {
				var37 = var1.readUnsignedShort();
				var3 = var1.method5614();
				var4 = var1.method5564();
				var5 = var1.readUnsignedByte();
				var6 = (var5 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
				var7 = (var5 & 7) + PlatformInfo.field3959;
				if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
					NodeDeque var41 = Client.groundItems[ScriptEvent.Client_plane][var6][var7];
					if (var41 != null) {
						for (TileItem var34 = (TileItem)var41.last(); var34 != null; var34 = (TileItem)var41.previous()) {
							if ((var3 & 32767) == var34.id && var37 == var34.quantity) {
								var34.quantity = var4;
								break;
							}
						}

						World.updateItemPile(var6, var7);
					}
				}

			} else if (class194.field2330 == var0) {
				var37 = var1.readUnsignedByte();
				var3 = (var37 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
				var4 = (var37 & 7) + PlatformInfo.field3959;
				var5 = var1.method5614();
				var6 = var1.method5605();
				var7 = var6 >> 2;
				var8 = var6 & 3;
				var9 = Client.field699[var7];
				if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
					Skeleton.updatePendingSpawn(ScriptEvent.Client_plane, var3, var4, var9, var5, var7, var8, 0, -1);
				}

			} else {
				int var39;
				if (class194.field2325 == var0) {
					var37 = var1.readUnsignedByte();
					var3 = var1.method5605();
					var4 = (var3 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
					var5 = (var3 & 7) + PlatformInfo.field3959;
					var6 = var1.method5613();
					var7 = var1.method5605();
					var8 = var7 >> 4 & 15;
					var9 = var7 & 7;
					if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
						var39 = var8 + 1;
						if (ByteArrayPool.localPlayer.pathX[0] >= var4 - var39 && ByteArrayPool.localPlayer.pathX[0] <= var4 + var39 && ByteArrayPool.localPlayer.pathY[0] >= var5 - var39 && ByteArrayPool.localPlayer.pathY[0] <= var5 + var39 && Client.areaSoundEffectVolume != 0 && var9 > 0 && Client.soundEffectCount < 50) {
							Client.soundEffectIds[Client.soundEffectCount] = var6;
							Client.queuedSoundEffectLoops[Client.soundEffectCount] = var9;
							Client.queuedSoundEffectDelays[Client.soundEffectCount] = var37;
							Client.soundEffects[Client.soundEffectCount] = null;
							Client.soundLocations[Client.soundEffectCount] = var8 + (var5 << 8) + (var4 << 16);
							++Client.soundEffectCount;
						}
					}
				}

				if (class194.field2323 == var0) {
					var37 = var1.method5613();
					var3 = var1.method5564();
					var4 = var1.readUnsignedByte();
					var5 = (var4 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
					var6 = (var4 & 7) + PlatformInfo.field3959;
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						var32 = new TileItem();
						var32.id = var37;
						var32.quantity = var3;
						if (Client.groundItems[ScriptEvent.Client_plane][var5][var6] == null) {
							Client.groundItems[ScriptEvent.Client_plane][var5][var6] = new NodeDeque();
						}

						Client.groundItems[ScriptEvent.Client_plane][var5][var6].addFirst(var32);
						World.updateItemPile(var5, var6);
					}

				} else if (class194.field2332 == var0) {
					var37 = var1.method5613();
					var3 = var1.method5605() * 4;
					var4 = var1.method5604() * 4;
					var5 = var1.method5604();
					byte var38 = var1.method5607();
					var7 = var1.method5614();
					var8 = var1.method5564();
					var9 = var1.readUnsignedByte();
					var39 = (var9 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
					var11 = (var9 & 7) + PlatformInfo.field3959;
					var12 = var1.readUnsignedByte();
					var13 = var1.readShort();
					var14 = var1.method5607();
					var6 = var38 + var39;
					int var40 = var14 + var11;
					if (var39 >= 0 && var11 >= 0 && var39 < 104 && var11 < 104 && var6 >= 0 && var40 >= 0 && var6 < 104 && var40 < 104 && var7 != 65535) {
						var39 = var39 * 128 + 64;
						var11 = var11 * 128 + 64;
						var6 = var6 * 128 + 64;
						var40 = var40 * 128 + 64;
						Projectile var35 = new Projectile(var7, ScriptEvent.Client_plane, var39, var11, class277.getTileHeight(var39, var11, ScriptEvent.Client_plane) - var4, var8 + Client.cycle, var37 + Client.cycle, var5, var12, var13, var3);
						var35.setDestination(var6, var40, class277.getTileHeight(var6, var40, ScriptEvent.Client_plane) - var3, var8 + Client.cycle);
						Client.projectiles.addFirst(var35);
					}

				} else if (class194.field2326 == var0) {
					var37 = var1.method5603();
					var3 = var1.readUnsignedShort();
					var4 = var1.method5603();
					var5 = (var4 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
					var6 = (var4 & 7) + PlatformInfo.field3959;
					var7 = var1.method5613();
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						var5 = var5 * 128 + 64;
						var6 = var6 * 128 + 64;
						GraphicsObject var33 = new GraphicsObject(var3, ScriptEvent.Client_plane, var5, var6, class277.getTileHeight(var5, var6, ScriptEvent.Client_plane) - var37, var7, Client.cycle);
						Client.graphicsObjects.addFirst(var33);
					}

				} else if (class194.field2328 == var0) {
					var37 = var1.method5605();
					var3 = (var37 >> 4 & 7) + GrandExchangeOfferTotalQuantityComparator.field91;
					var4 = (var37 & 7) + PlatformInfo.field3959;
					var5 = var1.readUnsignedByte();
					var6 = var5 >> 2;
					var7 = var5 & 3;
					var8 = Client.field699[var6];
					var9 = var1.method5614();
					if (var3 >= 0 && var4 >= 0 && var3 < 103 && var4 < 103) {
						if (var8 == 0) {
							BoundaryObject var36 = GrandExchangeOfferWorldComparator.scene.method3199(ScriptEvent.Client_plane, var3, var4);
							if (var36 != null) {
								var11 = WorldMapRectangle.Entity_unpackID(var36.tag);
								if (var6 == 2) {
									var36.entity1 = new DynamicObject(var11, 2, var7 + 4, ScriptEvent.Client_plane, var3, var4, var9, false, var36.entity1);
									var36.entity2 = new DynamicObject(var11, 2, var7 + 1 & 3, ScriptEvent.Client_plane, var3, var4, var9, false, var36.entity2);
								} else {
									var36.entity1 = new DynamicObject(var11, var6, var7, ScriptEvent.Client_plane, var3, var4, var9, false, var36.entity1);
								}
							}
						}

						if (var8 == 1) {
							WallDecoration var42 = GrandExchangeOfferWorldComparator.scene.method3252(ScriptEvent.Client_plane, var3, var4);
							if (var42 != null) {
								var11 = WorldMapRectangle.Entity_unpackID(var42.tag);
								if (var6 != 4 && var6 != 5) {
									if (var6 == 6) {
										var42.entity1 = new DynamicObject(var11, 4, var7 + 4, ScriptEvent.Client_plane, var3, var4, var9, false, var42.entity1);
									} else if (var6 == 7) {
										var42.entity1 = new DynamicObject(var11, 4, (var7 + 2 & 3) + 4, ScriptEvent.Client_plane, var3, var4, var9, false, var42.entity1);
									} else if (var6 == 8) {
										var42.entity1 = new DynamicObject(var11, 4, var7 + 4, ScriptEvent.Client_plane, var3, var4, var9, false, var42.entity1);
										var42.entity2 = new DynamicObject(var11, 4, (var7 + 2 & 3) + 4, ScriptEvent.Client_plane, var3, var4, var9, false, var42.entity2);
									}
								} else {
									var42.entity1 = new DynamicObject(var11, 4, var7, ScriptEvent.Client_plane, var3, var4, var9, false, var42.entity1);
								}
							}
						}

						if (var8 == 2) {
							GameObject var43 = GrandExchangeOfferWorldComparator.scene.method3201(ScriptEvent.Client_plane, var3, var4);
							if (var6 == 11) {
								var6 = 10;
							}

							if (var43 != null) {
								var43.entity = new DynamicObject(WorldMapRectangle.Entity_unpackID(var43.tag), var6, var7, ScriptEvent.Client_plane, var3, var4, var9, false, var43.entity);
							}
						}

						if (var8 == 3) {
							FloorDecoration var44 = GrandExchangeOfferWorldComparator.scene.getFloorDecoration(ScriptEvent.Client_plane, var3, var4);
							if (var44 != null) {
								var44.entity = new DynamicObject(WorldMapRectangle.Entity_unpackID(var44.tag), 22, var7, ScriptEvent.Client_plane, var3, var4, var9, false, var44.entity);
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "85"
	)
	@Export("selectSpell")
	static void selectSpell(int var0, int var1, int var2, int var3) {
		Widget var4 = GrandExchangeOfferUnitPriceComparator.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			GrandExchangeOfferOwnWorldComparator.runScriptEvent(var5);
		}

		Client.field837 = var3;
		Client.isSpellSelected = true;
		class7.selectedSpellWidget = var0;
		Client.selectedSpellChildIndex = var1;
		AbstractWorldMapIcon.selectedSpellFlags = var2;
		ItemContainer.invalidateWidget(var4);
	}
}
