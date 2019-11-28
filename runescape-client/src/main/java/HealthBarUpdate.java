import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("iz")
	@ObfuscatedGetter(
		intValue = -627572607
	)
	@Export("selectedItemId")
	static int selectedItemId;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -8508907
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1785180099
	)
	@Export("health")
	int health;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -529706747
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1993456701
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "2"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1436766786"
	)
	@Export("ViewportMouse_unpackX")
	public static int ViewportMouse_unpackX(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Lfu;III)Lde;",
		garbageValue = "148025221"
	)
	public static final PcmPlayer method1776(TaskHandler var0, int var1, int var2) {
		if (Messages.PcmPlayer_sampleRate == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = Interpreter.pcmPlayerProvider.player();
				var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
				var3.field1401 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (RouteStrategy.field2114 > 0 && PcmPlayer.soundSystem == null) {
					PcmPlayer.soundSystem = new SoundSystem();
					PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(PcmPlayer.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (PcmPlayer.soundSystem != null) {
					if (PcmPlayer.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					PcmPlayer.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		signature = "(Lgd;I)V",
		garbageValue = "1866013369"
	)
	static final void method1779(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (class185.field2340 == var0) {
			var2 = var1.readUnsignedByte();
			var3 = var2 >> 2;
			var4 = var2 & 3;
			var5 = Client.field703[var3];
			var6 = var1.method5689();
			var7 = (var6 >> 4 & 7) + class227.field3092;
			var8 = (var6 & 7) + class40.field343;
			if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
				Varps.updatePendingSpawn(ClientPacket.Client_plane, var7, var8, var5, -1, var3, var4, 0, -1);
			}

		} else {
			int var9;
			if (class185.field2337 == var0) {
				var2 = var1.method5728();
				var3 = var2 >> 2;
				var4 = var2 & 3;
				var5 = Client.field703[var3];
				var6 = var1.readUnsignedShort();
				var7 = var1.readUnsignedByte();
				var8 = (var7 >> 4 & 7) + class227.field3092;
				var9 = (var7 & 7) + class40.field343;
				if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
					Varps.updatePendingSpawn(ClientPacket.Client_plane, var8, var9, var5, var6, var3, var4, 0, -1);
				}

			} else {
				TileItem var32;
				if (class185.field2339 == var0) {
					var2 = var1.readUnsignedShort();
					var3 = var1.readUnsignedByte();
					var4 = (var3 >> 4 & 7) + class227.field3092;
					var5 = (var3 & 7) + class40.field343;
					if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
						NodeDeque var31 = Client.groundItems[ClientPacket.Client_plane][var4][var5];
						if (var31 != null) {
							for (var32 = (TileItem)var31.last(); var32 != null; var32 = (TileItem)var31.previous()) {
								if ((var2 & 32767) == var32.id) {
									var32.remove();
									break;
								}
							}

							if (var31.last() == null) {
								Client.groundItems[ClientPacket.Client_plane][var4][var5] = null;
							}

							HealthBar.updateItemPile(var4, var5);
						}
					}

				} else {
					int var10;
					if (class185.field2334 == var0) {
						var2 = var1.readUnsignedByte();
						var3 = var2 >> 4 & 15;
						var4 = var2 & 7;
						var5 = var1.method5689();
						var6 = (var5 >> 4 & 7) + class227.field3092;
						var7 = (var5 & 7) + class40.field343;
						var8 = var1.method5631();
						var9 = var1.readUnsignedShort();
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							var10 = var3 + 1;
							if (class215.localPlayer.pathX[0] >= var6 - var10 && class215.localPlayer.pathX[0] <= var10 + var6 && class215.localPlayer.pathY[0] >= var7 - var10 && class215.localPlayer.pathY[0] <= var10 + var7 && Client.areaSoundEffectVolume != 0 && var4 > 0 && Client.soundEffectCount < 50) {
								Client.soundEffectIds[Client.soundEffectCount] = var9;
								Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
								Client.queuedSoundEffectDelays[Client.soundEffectCount] = var8;
								Client.soundEffects[Client.soundEffectCount] = null;
								Client.soundLocations[Client.soundEffectCount] = var3 + (var7 << 8) + (var6 << 16);
								++Client.soundEffectCount;
							}
						}
					}

					int var11;
					int var12;
					int var13;
					int var14;
					if (class185.field2336 == var0) {
						var2 = var1.method5689();
						var3 = var1.readUnsignedShort();
						var4 = var1.method5719();
						var5 = var1.method5728();
						var6 = (var5 >> 4 & 7) + class227.field3092;
						var7 = (var5 & 7) + class40.field343;
						byte var37 = var1.readByte();
						var9 = var1.method5689() * 4;
						var10 = var1.method5719();
						var11 = var1.method5689() * 4;
						var12 = var1.method5643();
						byte var40 = var1.readByte();
						var14 = var1.method5728();
						var8 = var37 + var6;
						var13 = var40 + var7;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104 && var8 >= 0 && var13 >= 0 && var8 < 104 && var13 < 104 && var4 != 65535) {
							var6 = var6 * 128 + 64;
							var7 = var7 * 128 + 64;
							var8 = var8 * 128 + 64;
							var13 = var13 * 128 + 64;
							Projectile var15 = new Projectile(var4, ClientPacket.Client_plane, var6, var7, class195.getTileHeight(var6, var7, ClientPacket.Client_plane) - var11, var3 + Client.cycle, var10 + Client.cycle, var14, var2, var12, var9);
							var15.setDestination(var8, var13, class195.getTileHeight(var8, var13, ClientPacket.Client_plane) - var9, var3 + Client.cycle);
							Client.projectiles.addFirst(var15);
						}

					} else if (class185.field2332 == var0) {
						var2 = var1.method5640();
						var3 = var1.method5689();
						var4 = (var3 >> 4 & 7) + class227.field3092;
						var5 = (var3 & 7) + class40.field343;
						var6 = var1.method5728();
						var7 = var6 >> 2;
						var8 = var6 & 3;
						var9 = Client.field703[var7];
						if (var4 >= 0 && var5 >= 0 && var4 < 103 && var5 < 103) {
							if (var9 == 0) {
								BoundaryObject var33 = class2.scene.method3130(ClientPacket.Client_plane, var4, var5);
								if (var33 != null) {
									var11 = ItemContainer.Entity_unpackID(var33.tag);
									if (var7 == 2) {
										var33.entity1 = new DynamicObject(var11, 2, var8 + 4, ClientPacket.Client_plane, var4, var5, var2, false, var33.entity1);
										var33.entity2 = new DynamicObject(var11, 2, var8 + 1 & 3, ClientPacket.Client_plane, var4, var5, var2, false, var33.entity2);
									} else {
										var33.entity1 = new DynamicObject(var11, var7, var8, ClientPacket.Client_plane, var4, var5, var2, false, var33.entity1);
									}
								}
							}

							if (var9 == 1) {
								WallDecoration var41 = class2.scene.method3131(ClientPacket.Client_plane, var4, var5);
								if (var41 != null) {
									var11 = ItemContainer.Entity_unpackID(var41.tag);
									if (var7 != 4 && var7 != 5) {
										if (var7 == 6) {
											var41.entity1 = new DynamicObject(var11, 4, var8 + 4, ClientPacket.Client_plane, var4, var5, var2, false, var41.entity1);
										} else if (var7 == 7) {
											var41.entity1 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, ClientPacket.Client_plane, var4, var5, var2, false, var41.entity1);
										} else if (var7 == 8) {
											var41.entity1 = new DynamicObject(var11, 4, var8 + 4, ClientPacket.Client_plane, var4, var5, var2, false, var41.entity1);
											var41.entity2 = new DynamicObject(var11, 4, (var8 + 2 & 3) + 4, ClientPacket.Client_plane, var4, var5, var2, false, var41.entity2);
										}
									} else {
										var41.entity1 = new DynamicObject(var11, 4, var8, ClientPacket.Client_plane, var4, var5, var2, false, var41.entity1);
									}
								}
							}

							if (var9 == 2) {
								GameObject var42 = class2.scene.method3253(ClientPacket.Client_plane, var4, var5);
								if (var7 == 11) {
									var7 = 10;
								}

								if (var42 != null) {
									var42.entity = new DynamicObject(ItemContainer.Entity_unpackID(var42.tag), var7, var8, ClientPacket.Client_plane, var4, var5, var2, false, var42.entity);
								}
							}

							if (var9 == 3) {
								FloorDecoration var43 = class2.scene.getFloorDecoration(ClientPacket.Client_plane, var4, var5);
								if (var43 != null) {
									var43.entity = new DynamicObject(ItemContainer.Entity_unpackID(var43.tag), 22, var8, ClientPacket.Client_plane, var4, var5, var2, false, var43.entity);
								}
							}
						}

					} else if (class185.field2341 == var0) {
						var2 = var1.method5640();
						var3 = var1.readUnsignedByte();
						var4 = var1.method5641();
						var5 = var1.readUnsignedByte();
						var6 = (var5 >> 4 & 7) + class227.field3092;
						var7 = (var5 & 7) + class40.field343;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							var6 = var6 * 128 + 64;
							var7 = var7 * 128 + 64;
							GraphicsObject var44 = new GraphicsObject(var2, ClientPacket.Client_plane, var6, var7, class195.getTileHeight(var6, var7, ClientPacket.Client_plane) - var3, var4, Client.cycle);
							Client.graphicsObjects.addFirst(var44);
						}

					} else if (class185.field2331 == var0) {
						var2 = var1.readUnsignedShort();
						var3 = var1.method5641();
						var4 = var1.method5641();
						var5 = var1.method5631();
						var6 = (var5 >> 4 & 7) + class227.field3092;
						var7 = (var5 & 7) + class40.field343;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							NodeDeque var34 = Client.groundItems[ClientPacket.Client_plane][var6][var7];
							if (var34 != null) {
								for (TileItem var35 = (TileItem)var34.last(); var35 != null; var35 = (TileItem)var34.previous()) {
									if ((var2 & 32767) == var35.id && var4 == var35.quantity) {
										var35.quantity = var3;
										break;
									}
								}

								HealthBar.updateItemPile(var6, var7);
							}
						}

					} else if (class185.field2335 == var0) {
						var2 = var1.readUnsignedShort();
						var3 = var1.readUnsignedByte();
						var4 = (var3 >> 4 & 7) + class227.field3092;
						var5 = (var3 & 7) + class40.field343;
						var6 = var1.method5640();
						if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
							var32 = new TileItem();
							var32.id = var6;
							var32.quantity = var2;
							if (Client.groundItems[ClientPacket.Client_plane][var4][var5] == null) {
								Client.groundItems[ClientPacket.Client_plane][var4][var5] = new NodeDeque();
							}

							Client.groundItems[ClientPacket.Client_plane][var4][var5].addFirst(var32);
							HealthBar.updateItemPile(var4, var5);
						}

					} else {
						if (class185.field2333 == var0) {
							var2 = var1.readUnsignedShort();
							var3 = var1.method5719();
							var4 = var1.method5689();
							var5 = var4 >> 2;
							var6 = var4 & 3;
							var7 = Client.field703[var5];
							var8 = var1.method5641();
							byte var38 = var1.method5772();
							byte var39 = var1.method5637();
							var11 = var1.readUnsignedByte();
							var12 = (var11 >> 4 & 7) + class227.field3092;
							var13 = (var11 & 7) + class40.field343;
							var14 = var1.method5719();
							byte var36 = var1.method5633();
							byte var16 = var1.method5637();
							Player var17;
							if (var3 == Client.localPlayerIndex) {
								var17 = class215.localPlayer;
							} else {
								var17 = Client.players[var3];
							}

							if (var17 != null) {
								ObjectDefinition var18 = Occluder.getObjectDefinition(var2);
								int var19;
								int var20;
								if (var6 != 1 && var6 != 3) {
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
								int[][] var25 = Tiles.Tiles_heights[ClientPacket.Client_plane];
								int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
								int var27 = (var12 << 7) + (var19 << 6);
								int var28 = (var13 << 7) + (var20 << 6);
								Model var29 = var18.getModel(var5, var6, var25, var27, var26, var28);
								if (var29 != null) {
									Varps.updatePendingSpawn(ClientPacket.Client_plane, var12, var13, var7, -1, 0, 0, var8 + 1, var14 + 1);
									var17.animationCycleStart = var8 + Client.cycle;
									var17.animationCycleEnd = var14 + Client.cycle;
									var17.model0 = var29;
									var17.field623 = var12 * 128 + var19 * 64;
									var17.field617 = var13 * 128 + var20 * 64;
									var17.tileHeight2 = var26;
									byte var30;
									if (var38 > var16) {
										var30 = var38;
										var38 = var16;
										var16 = var30;
									}

									if (var36 > var39) {
										var30 = var36;
										var36 = var39;
										var39 = var30;
									}

									var17.field618 = var12 + var38;
									var17.field621 = var16 + var12;
									var17.field620 = var13 + var36;
									var17.field622 = var13 + var39;
								}
							}
						}

					}
				}
			}
		}
	}
}
