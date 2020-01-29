import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive2")
	static Archive archive2;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ll;Ll;I)I",
		garbageValue = "250420083"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "362180230"
	)
	public static boolean method76(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhn;IIII)V",
		garbageValue = "1571239297"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field2649 == null) {
			throw new RuntimeException();
		} else {
			var0.field2649[var1] = var2;
			var0.field2560[var1] = var3;
		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(Lgy;I)V",
		garbageValue = "356089511"
	)
	static final void method77(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (class185.field2314 == var0) {
			var2 = var1.method5771();
			var3 = (var2 >> 4 & 7) + SecureRandomCallable.field531;
			var4 = (var2 & 7) + FontName.field3663;
			var5 = var1.method5606();
			var6 = var5 >> 2;
			var7 = var5 & 3;
			var8 = Client.field743[var6];
			if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
				Skills.updatePendingSpawn(Clock.Client_plane, var3, var4, var8, -1, var6, var7, 0, -1);
			}

		} else {
			int var9;
			int var10;
			if (class185.field2327 == var0) {
				var2 = var1.method5740();
				var3 = var1.method5606();
				var4 = var1.readUnsignedByte();
				var5 = (var4 >> 4 & 7) + SecureRandomCallable.field531;
				var6 = (var4 & 7) + FontName.field3663;
				var7 = var1.readUnsignedByte();
				var8 = var7 >> 4 & 15;
				var9 = var7 & 7;
				if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
					var10 = var8 + 1;
					if (class192.localPlayer.pathX[0] >= var5 - var10 && class192.localPlayer.pathX[0] <= var5 + var10 && class192.localPlayer.pathY[0] >= var6 - var10 && class192.localPlayer.pathY[0] <= var6 + var10 && Client.areaSoundEffectVolume != 0 && var9 > 0 && Client.soundEffectCount < 50) {
						Client.soundEffectIds[Client.soundEffectCount] = var2;
						Client.queuedSoundEffectLoops[Client.soundEffectCount] = var9;
						Client.queuedSoundEffectDelays[Client.soundEffectCount] = var3;
						Client.soundEffects[Client.soundEffectCount] = null;
						Client.soundLocations[Client.soundEffectCount] = var8 + (var6 << 8) + (var5 << 16);
						++Client.soundEffectCount;
					}
				}
			}

			TileItem var32;
			if (class185.field2322 == var0) {
				var2 = var1.method5762();
				var3 = var1.method5605();
				var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
				var5 = (var3 & 7) + FontName.field3663;
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					NodeDeque var31 = Client.groundItems[Clock.Client_plane][var4][var5];
					if (var31 != null) {
						for (var32 = (TileItem)var31.last(); var32 != null; var32 = (TileItem)var31.previous()) {
							if ((var2 & 32767) == var32.id) {
								var32.remove();
								break;
							}
						}

						if (var31.last() == null) {
							Client.groundItems[Clock.Client_plane][var4][var5] = null;
						}

						WorldMapEvent.updateItemPile(var4, var5);
					}
				}

			} else if (class185.field2317 == var0) {
				var2 = var1.method5614();
				var3 = var1.method5605();
				var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
				var5 = (var3 & 7) + FontName.field3663;
				var6 = var1.method5614();
				if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
					var32 = new TileItem();
					var32.id = var2;
					var32.quantity = var6;
					if (Client.groundItems[Clock.Client_plane][var4][var5] == null) {
						Client.groundItems[Clock.Client_plane][var4][var5] = new NodeDeque();
					}

					Client.groundItems[Clock.Client_plane][var4][var5].addFirst(var32);
					WorldMapEvent.updateItemPile(var4, var5);
				}

			} else {
				int var11;
				if (class185.field2316 == var0) {
					var2 = var1.readUnsignedShort();
					var3 = var1.method5605();
					var4 = var3 >> 2;
					var5 = var3 & 3;
					var6 = Client.field743[var4];
					var7 = var1.method5606();
					var8 = (var7 >> 4 & 7) + SecureRandomCallable.field531;
					var9 = (var7 & 7) + FontName.field3663;
					if (var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
						if (var6 == 0) {
							BoundaryObject var33 = ServerBuild.scene.method3177(Clock.Client_plane, var8, var9);
							if (var33 != null) {
								var11 = GrandExchangeEvents.Entity_unpackID(var33.tag);
								if (var4 == 2) {
									var33.entity1 = new DynamicObject(var11, 2, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var33.entity1);
									var33.entity2 = new DynamicObject(var11, 2, var5 + 1 & 3, Clock.Client_plane, var8, var9, var2, false, var33.entity2);
								} else {
									var33.entity1 = new DynamicObject(var11, var4, var5, Clock.Client_plane, var8, var9, var2, false, var33.entity1);
								}
							}
						}

						if (var6 == 1) {
							WallDecoration var42 = ServerBuild.scene.method3178(Clock.Client_plane, var8, var9);
							if (var42 != null) {
								var11 = GrandExchangeEvents.Entity_unpackID(var42.tag);
								if (var4 != 4 && var4 != 5) {
									if (var4 == 6) {
										var42.entity1 = new DynamicObject(var11, 4, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var42.entity1);
									} else if (var4 == 7) {
										var42.entity1 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, Clock.Client_plane, var8, var9, var2, false, var42.entity1);
									} else if (var4 == 8) {
										var42.entity1 = new DynamicObject(var11, 4, var5 + 4, Clock.Client_plane, var8, var9, var2, false, var42.entity1);
										var42.entity2 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, Clock.Client_plane, var8, var9, var2, false, var42.entity2);
									}
								} else {
									var42.entity1 = new DynamicObject(var11, 4, var5, Clock.Client_plane, var8, var9, var2, false, var42.entity1);
								}
							}
						}

						if (var6 == 2) {
							GameObject var43 = ServerBuild.scene.method3203(Clock.Client_plane, var8, var9);
							if (var4 == 11) {
								var4 = 10;
							}

							if (var43 != null) {
								var43.entity = new DynamicObject(GrandExchangeEvents.Entity_unpackID(var43.tag), var4, var5, Clock.Client_plane, var8, var9, var2, false, var43.entity);
							}
						}

						if (var6 == 3) {
							FloorDecoration var44 = ServerBuild.scene.getFloorDecoration(Clock.Client_plane, var8, var9);
							if (var44 != null) {
								var44.entity = new DynamicObject(GrandExchangeEvents.Entity_unpackID(var44.tag), 22, var5, Clock.Client_plane, var8, var9, var2, false, var44.entity);
							}
						}
					}

				} else if (class185.field2323 == var0) {
					var2 = var1.method5605();
					var3 = var2 >> 2;
					var4 = var2 & 3;
					var5 = Client.field743[var3];
					var6 = var1.method5762();
					var7 = var1.readUnsignedByte();
					var8 = (var7 >> 4 & 7) + SecureRandomCallable.field531;
					var9 = (var7 & 7) + FontName.field3663;
					if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
						Skills.updatePendingSpawn(Clock.Client_plane, var8, var9, var5, var6, var3, var4, 0, -1);
					}

				} else {
					int var12;
					int var13;
					int var14;
					if (class185.field2320 == var0) {
						var2 = var1.method5605();
						var3 = (var2 >> 4 & 7) + SecureRandomCallable.field531;
						var4 = (var2 & 7) + FontName.field3663;
						byte var37 = var1.readByte();
						var6 = var1.method5740();
						byte var38 = var1.method5618();
						byte var39 = var1.method5780();
						var9 = var1.method5605();
						var10 = var9 >> 2;
						var11 = var9 & 3;
						var12 = Client.field743[var10];
						var13 = var1.method5762();
						var14 = var1.method5614();
						byte var15 = var1.method5618();
						int var16 = var1.method5740();
						Player var17;
						if (var14 == Client.localPlayerIndex) {
							var17 = class192.localPlayer;
						} else {
							var17 = Client.players[var14];
						}

						if (var17 != null) {
							ObjectDefinition var18 = Occluder.getObjectDefinition(var16);
							int var19;
							int var20;
							if (var11 != 1 && var11 != 3) {
								var19 = var18.sizeX;
								var20 = var18.sizeY;
							} else {
								var19 = var18.sizeY;
								var20 = var18.sizeX;
							}

							int var21 = var3 + (var19 >> 1);
							int var22 = var3 + (var19 + 1 >> 1);
							int var23 = var4 + (var20 >> 1);
							int var24 = var4 + (var20 + 1 >> 1);
							int[][] var25 = Tiles.Tiles_heights[Clock.Client_plane];
							int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
							int var27 = (var3 << 7) + (var19 << 6);
							int var28 = (var4 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var10, var11, var25, var27, var26, var28);
							if (var29 != null) {
								Skills.updatePendingSpawn(Clock.Client_plane, var3, var4, var12, -1, 0, 0, var6 + 1, var13 + 1);
								var17.animationCycleStart = var6 + Client.cycle;
								var17.animationCycleEnd = var13 + Client.cycle;
								var17.model0 = var29;
								var17.field622 = var3 * 128 + var19 * 64;
								var17.field620 = var4 * 128 + var20 * 64;
								var17.tileHeight2 = var26;
								byte var30;
								if (var37 > var39) {
									var30 = var37;
									var37 = var39;
									var39 = var30;
								}

								if (var38 > var15) {
									var30 = var38;
									var38 = var15;
									var15 = var30;
								}

								var17.field626 = var37 + var3;
								var17.field628 = var39 + var3;
								var17.field627 = var4 + var38;
								var17.field629 = var4 + var15;
							}
						}
					}

					if (class185.field2318 == var0) {
						var2 = var1.readShort();
						var3 = var1.readUnsignedByte();
						var4 = var1.method5771();
						var5 = (var4 >> 4 & 7) + SecureRandomCallable.field531;
						var6 = (var4 & 7) + FontName.field3663;
						var7 = var1.method5771() * 4;
						var8 = var1.method5762();
						var9 = var1.method5771() * 4;
						var10 = var1.readUnsignedShort();
						var11 = var1.method5606();
						byte var40 = var1.method5609();
						byte var41 = var1.method5618();
						var14 = var1.readUnsignedShort();
						var13 = var41 + var5;
						var12 = var40 + var6;
						if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104 && var13 >= 0 && var12 >= 0 && var13 < 104 && var12 < 104 && var14 != 65535) {
							var5 = var5 * 128 + 64;
							var6 = var6 * 128 + 64;
							var13 = var13 * 128 + 64;
							var12 = var12 * 128 + 64;
							Projectile var34 = new Projectile(var14, Clock.Client_plane, var5, var6, WorldMapSectionType.getTileHeight(var5, var6, Clock.Client_plane) - var7, var10 + Client.cycle, var8 + Client.cycle, var11, var3, var2, var9);
							var34.setDestination(var13, var12, WorldMapSectionType.getTileHeight(var13, var12, Clock.Client_plane) - var9, var10 + Client.cycle);
							Client.projectiles.addFirst(var34);
						}

					} else if (class185.field2315 != var0) {
						if (class185.field2319 == var0) {
							var2 = var1.method5762();
							var3 = var1.method5771();
							var4 = (var3 >> 4 & 7) + SecureRandomCallable.field531;
							var5 = (var3 & 7) + FontName.field3663;
							var6 = var1.readUnsignedByte();
							var7 = var1.method5614();
							if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
								var4 = var4 * 128 + 64;
								var5 = var5 * 128 + 64;
								GraphicsObject var45 = new GraphicsObject(var7, Clock.Client_plane, var4, var5, WorldMapSectionType.getTileHeight(var4, var5, Clock.Client_plane) - var6, var2, Client.cycle);
								Client.graphicsObjects.addFirst(var45);
							}

						}
					} else {
						var2 = var1.method5740();
						var3 = var1.method5762();
						var4 = var1.method5614();
						var5 = var1.method5771();
						var6 = (var5 >> 4 & 7) + SecureRandomCallable.field531;
						var7 = (var5 & 7) + FontName.field3663;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							NodeDeque var35 = Client.groundItems[Clock.Client_plane][var6][var7];
							if (var35 != null) {
								for (TileItem var36 = (TileItem)var35.last(); var36 != null; var36 = (TileItem)var35.previous()) {
									if ((var2 & 32767) == var36.id && var4 == var36.quantity) {
										var36.quantity = var3;
										break;
									}
								}

								WorldMapEvent.updateItemPile(var6, var7);
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "-87"
	)
	static final void method74(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var6 + var13;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method3066(var17, var18, var19);
			Rasterizer3D.method3123(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3066(var17, var19, var20);
			Rasterizer3D.method3123(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
