import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive9")
	static Archive archive9;
	@ObfuscatedName("t")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1284529716"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var1 + var2 * 64];
	}

	@ObfuscatedName("a")
	public static final int method472(double var0, double var2, double var4) {
		double var6 = var4;
		double var8 = var4;
		double var10 = var4;
		if (0.0D != var2) {
			double var12;
			if (var4 < 0.5D) {
				var12 = (1.0D + var2) * var4;
			} else {
				var12 = var2 + var4 - var2 * var4;
			}

			double var14 = 2.0D * var4 - var12;
			double var16 = 0.3333333333333333D + var0;
			if (var16 > 1.0D) {
				--var16;
			}

			double var20 = var0 - 0.3333333333333333D;
			if (var20 < 0.0D) {
				++var20;
			}

			if (6.0D * var16 < 1.0D) {
				var6 = 6.0D * (var12 - var14) * var16 + var14;
			} else if (2.0D * var16 < 1.0D) {
				var6 = var12;
			} else if (3.0D * var16 < 2.0D) {
				var6 = 6.0D * (var12 - var14) * (0.6666666666666666D - var16) + var14;
			} else {
				var6 = var14;
			}

			if (6.0D * var0 < 1.0D) {
				var8 = 6.0D * (var12 - var14) * var0 + var14;
			} else if (var0 * 2.0D < 1.0D) {
				var8 = var12;
			} else if (var0 * 3.0D < 2.0D) {
				var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
			} else {
				var8 = var14;
			}

			if (var20 * 6.0D < 1.0D) {
				var10 = var20 * 6.0D * (var12 - var14) + var14;
			} else if (var20 * 2.0D < 1.0D) {
				var10 = var12;
			} else if (var20 * 3.0D < 2.0D) {
				var10 = (0.6666666666666666D - var20) * (var12 - var14) * 6.0D + var14;
			} else {
				var10 = var14;
			}
		}

		int var22 = (int)(var6 * 256.0D);
		int var13 = (int)(256.0D * var8);
		int var23 = (int)(256.0D * var10);
		int var15 = var23 + (var13 << 8) + (var22 << 16);
		return var15;
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "5"
	)
	static void method473() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				Player.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(Lge;I)V",
		garbageValue = "-226939781"
	)
	static final void method474(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var11;
		int var37;
		if (class185.field2300 == var0) {
			var2 = var1.readUnsignedShort();
			var3 = var1.readUnsignedByte();
			var4 = (var3 >> 4 & 7) + SpriteMask.field2501;
			var5 = (var3 & 7) + GrandExchangeOffer.field61;
			var6 = var1.method5697();
			var7 = var6 >> 2;
			var8 = var6 & 3;
			var37 = Client.field692[var7];
			if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
				if (var37 == 0) {
					BoundaryObject var10 = WorldMapArea.scene.method3225(Player.Client_plane, var4, var5);
					if (var10 != null) {
						var11 = UserComparator8.Entity_unpackID(var10.tag);
						if (var7 == 2) {
							var10.entity1 = new DynamicObject(var11, 2, var8 + 4, Player.Client_plane, var4, var5, var2, false, var10.entity1);
							var10.entity2 = new DynamicObject(var11, 2, var8 + 1 & 3, Player.Client_plane, var4, var5, var2, false, var10.entity2);
						} else {
							var10.entity1 = new DynamicObject(var11, var7, var8, Player.Client_plane, var4, var5, var2, false, var10.entity1);
						}
					}
				}

				if (var37 == 1) {
					WallDecoration var38 = WorldMapArea.scene.method3339(Player.Client_plane, var4, var5);
					if (var38 != null) {
						var11 = UserComparator8.Entity_unpackID(var38.tag);
						if (var7 != 4 && var7 != 5) {
							if (var7 == 6) {
								var38.entity1 = new DynamicObject(var11, 4, var8 + 4, Player.Client_plane, var4, var5, var2, false, var38.entity1);
							} else if (var7 == 7) {
								var38.entity1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, Player.Client_plane, var4, var5, var2, false, var38.entity1);
							} else if (var7 == 8) {
								var38.entity1 = new DynamicObject(var11, 4, var8 + 4, Player.Client_plane, var4, var5, var2, false, var38.entity1);
								var38.entity2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, Player.Client_plane, var4, var5, var2, false, var38.entity2);
							}
						} else {
							var38.entity1 = new DynamicObject(var11, 4, var8, Player.Client_plane, var4, var5, var2, false, var38.entity1);
						}
					}
				}

				if (var37 == 2) {
					GameObject var39 = WorldMapArea.scene.method3227(Player.Client_plane, var4, var5);
					if (var7 == 11) {
						var7 = 10;
					}

					if (var39 != null) {
						var39.entity = new DynamicObject(UserComparator8.Entity_unpackID(var39.tag), var7, var8, Player.Client_plane, var4, var5, var2, false, var39.entity);
					}
				}

				if (var37 == 3) {
					FloorDecoration var40 = WorldMapArea.scene.getFloorDecoration(Player.Client_plane, var4, var5);
					if (var40 != null) {
						var40.entity = new DynamicObject(UserComparator8.Entity_unpackID(var40.tag), 22, var8, Player.Client_plane, var4, var5, var2, false, var40.entity);
					}
				}
			}

		} else if (class185.field2293 == var0) {
			var2 = var1.method5639();
			var3 = var1.method5648();
			var4 = var1.method5648();
			var5 = var1.readUnsignedByte();
			var6 = (var5 >> 4 & 7) + SpriteMask.field2501;
			var7 = (var5 & 7) + GrandExchangeOffer.field61;
			if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
				var6 = var6 * 128 + 64;
				var7 = var7 * 128 + 64;
				GraphicsObject var44 = new GraphicsObject(var4, Player.Client_plane, var6, var7, GraphicsObject.getTileHeight(var6, var7, Player.Client_plane) - var2, var3, Client.cycle);
				Client.graphicsObjects.addFirst(var44);
			}

		} else {
			int var12;
			int var13;
			int var32;
			if (class185.field2298 == var0) {
				var2 = var1.method5650();
				var3 = var1.method5622();
				var4 = var1.method5622() * 4;
				var5 = var1.method5647();
				var6 = var1.readUnsignedByte();
				var7 = (var6 >> 4 & 7) + SpriteMask.field2501;
				var8 = (var6 & 7) + GrandExchangeOffer.field61;
				var37 = var1.method5639() * 4;
				var32 = var1.method5647();
				byte var41 = var1.method5671();
				byte var42 = var1.method5671();
				var13 = var1.method5697();
				int var43 = var1.method5647();
				var11 = var41 + var7;
				var12 = var42 + var8;
				if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104 && var11 >= 0 && var12 >= 0 && var11 < 104 && var12 < 104 && var5 != 65535) {
					var7 = var7 * 128 + 64;
					var8 = var8 * 128 + 64;
					var11 = var11 * 128 + 64;
					var12 = var12 * 128 + 64;
					Projectile var15 = new Projectile(var5, Player.Client_plane, var7, var8, GraphicsObject.getTileHeight(var7, var8, Player.Client_plane) - var4, var32 + Client.cycle, var43 + Client.cycle, var13, var3, var2, var37);
					var15.setDestination(var11, var12, GraphicsObject.getTileHeight(var11, var12, Player.Client_plane) - var37, var32 + Client.cycle);
					Client.projectiles.addFirst(var15);
				}

			} else {
				TileItem var33;
				if (class185.field2292 == var0) {
					var2 = var1.readUnsignedShort();
					var3 = var1.method5646();
					var4 = var1.readUnsignedByte();
					var5 = (var4 >> 4 & 7) + SpriteMask.field2501;
					var6 = (var4 & 7) + GrandExchangeOffer.field61;
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						var33 = new TileItem();
						var33.id = var3;
						var33.quantity = var2;
						if (Client.groundItems[Player.Client_plane][var5][var6] == null) {
							Client.groundItems[Player.Client_plane][var5][var6] = new NodeDeque();
						}

						Client.groundItems[Player.Client_plane][var5][var6].addFirst(var33);
						class4.updateItemPile(var5, var6);
					}

				} else {
					if (class185.field2291 == var0) {
						var2 = var1.method5648();
						var3 = var1.readUnsignedShort();
						var4 = var1.method5622();
						var5 = var4 >> 2;
						var6 = var4 & 3;
						var7 = Client.field692[var5];
						var8 = var1.readUnsignedShort();
						byte var9 = var1.method5763();
						var32 = var1.method5697();
						var11 = (var32 >> 4 & 7) + SpriteMask.field2501;
						var12 = (var32 & 7) + GrandExchangeOffer.field61;
						var13 = var1.method5646();
						byte var14 = var1.method5640();
						byte var34 = var1.readByte();
						byte var16 = var1.method5671();
						Player var17;
						if (var13 == Client.localPlayerIndex) {
							var17 = class215.localPlayer;
						} else {
							var17 = Client.players[var13];
						}

						if (var17 != null) {
							ObjectDefinition var18 = WorldMapDecorationType.getObjectDefinition(var3);
							int var19;
							int var20;
							if (var6 != 1 && var6 != 3) {
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
							int[][] var25 = Tiles.Tiles_heights[Player.Client_plane];
							int var26 = var25[var22][var24] + var25[var21][var24] + var25[var22][var23] + var25[var21][var23] >> 2;
							int var27 = (var11 << 7) + (var19 << 6);
							int var28 = (var12 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var5, var6, var25, var27, var26, var28);
							if (var29 != null) {
								GrandExchangeOfferWorldComparator.updatePendingSpawn(Player.Client_plane, var11, var12, var7, -1, 0, 0, var2 + 1, var8 + 1);
								var17.animationCycleStart = var2 + Client.cycle;
								var17.animationCycleEnd = var8 + Client.cycle;
								var17.model0 = var29;
								var17.field620 = var11 * 128 + var19 * 64;
								var17.field613 = var12 * 128 + var20 * 64;
								var17.tileHeight2 = var26;
								byte var30;
								if (var34 > var9) {
									var30 = var34;
									var34 = var9;
									var9 = var30;
								}

								if (var16 > var14) {
									var30 = var16;
									var16 = var14;
									var14 = var30;
								}

								var17.field595 = var34 + var11;
								var17.field612 = var9 + var11;
								var17.field611 = var16 + var12;
								var17.field604 = var14 + var12;
							}
						}
					}

					if (class185.field2299 == var0) {
						var2 = var1.method5622();
						var3 = var2 >> 2;
						var4 = var2 & 3;
						var5 = Client.field692[var3];
						var6 = var1.readUnsignedByte();
						var7 = (var6 >> 4 & 7) + SpriteMask.field2501;
						var8 = (var6 & 7) + GrandExchangeOffer.field61;
						if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
							GrandExchangeOfferWorldComparator.updatePendingSpawn(Player.Client_plane, var7, var8, var5, -1, var3, var4, 0, -1);
						}

					} else if (class185.field2296 == var0) {
						var2 = var1.method5622();
						var3 = (var2 >> 4 & 7) + SpriteMask.field2501;
						var4 = (var2 & 7) + GrandExchangeOffer.field61;
						var5 = var1.method5648();
						var6 = var1.method5639();
						var7 = var6 >> 2;
						var8 = var6 & 3;
						var37 = Client.field692[var7];
						if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
							GrandExchangeOfferWorldComparator.updatePendingSpawn(Player.Client_plane, var3, var4, var37, var5, var7, var8, 0, -1);
						}

					} else if (class185.field2297 == var0) {
						var2 = var1.method5647();
						var3 = var1.method5648();
						var4 = var1.readUnsignedByte();
						var5 = (var4 >> 4 & 7) + SpriteMask.field2501;
						var6 = (var4 & 7) + GrandExchangeOffer.field61;
						var7 = var1.method5647();
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
							NodeDeque var31 = Client.groundItems[Player.Client_plane][var5][var6];
							if (var31 != null) {
								for (TileItem var35 = (TileItem)var31.last(); var35 != null; var35 = (TileItem)var31.previous()) {
									if ((var2 & 32767) == var35.id && var7 == var35.quantity) {
										var35.quantity = var3;
										break;
									}
								}

								class4.updateItemPile(var5, var6);
							}
						}

					} else if (class185.field2294 != var0) {
						if (class185.field2295 == var0) {
							var2 = var1.method5622();
							var3 = var1.method5697();
							var4 = var3 >> 4 & 15;
							var5 = var3 & 7;
							var6 = var1.method5697();
							var7 = (var6 >> 4 & 7) + SpriteMask.field2501;
							var8 = (var6 & 7) + GrandExchangeOffer.field61;
							var37 = var1.method5646();
							if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
								var32 = var4 + 1;
								if (class215.localPlayer.pathX[0] >= var7 - var32 && class215.localPlayer.pathX[0] <= var7 + var32 && class215.localPlayer.pathY[0] >= var8 - var32 && class215.localPlayer.pathY[0] <= var8 + var32 && Client.areaSoundEffectVolume != 0 && var5 > 0 && Client.soundEffectCount < 50) {
									Client.soundEffectIds[Client.soundEffectCount] = var37;
									Client.queuedSoundEffectLoops[Client.soundEffectCount] = var5;
									Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
									Client.soundEffects[Client.soundEffectCount] = null;
									Client.soundLocations[Client.soundEffectCount] = var4 + (var8 << 8) + (var7 << 16);
									++Client.soundEffectCount;
								}
							}
						}

					} else {
						var2 = var1.readUnsignedShort();
						var3 = var1.method5622();
						var4 = (var3 >> 4 & 7) + SpriteMask.field2501;
						var5 = (var3 & 7) + GrandExchangeOffer.field61;
						if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
							NodeDeque var36 = Client.groundItems[Player.Client_plane][var4][var5];
							if (var36 != null) {
								for (var33 = (TileItem)var36.last(); var33 != null; var33 = (TileItem)var36.previous()) {
									if ((var2 & 32767) == var33.id) {
										var33.remove();
										break;
									}
								}

								if (var36.last() == null) {
									Client.groundItems[Player.Client_plane][var4][var5] = null;
								}

								class4.updateItemPile(var4, var5);
							}
						}

					}
				}
			}
		}
	}
}
