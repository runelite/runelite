import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("SpotAnimationDefinition_modelArchive")
	public static AbstractArchive SpotAnimationDefinition_modelArchive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 416833363
	)
	public static int field3150;
	@ObfuscatedName("i")
	@Export("ArchiveDiskActionHandler_lock")
	public static Object ArchiveDiskActionHandler_lock;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3150 = 0;
		ArchiveDiskActionHandler_lock = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3150 <= 1) {
							field3150 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3150 = 600;
					}
				} else {
					FriendLoginUpdate.method5325(100L);
					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3150 <= 1) {
							field3150 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3150;
					}
				}
			}
		} catch (Exception var13) {
			class225.RunException_sendStackTrace((String)null, var13);
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIIIIILem;Lfv;I)V",
		garbageValue = "-1749856384"
	)
	static final void method4336(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectDefinition var8 = Occluder.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = GameShell.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			if (var8.hasSound()) {
				ObjectSound.method1931(var0, var1, var2, var8, var4);
			}

			Object var22;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var22, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else {
				int var23;
				if (var5 != 10 && var5 != 11) {
					int[] var10000;
					if (var5 >= 12) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.method3165(var0, var1, var2, var16, 1, 1, (Entity)var22, 0, var19, var21);
						if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
							var10000 = UrlRequest.field1940[var0][var1];
							var10000[var2] |= 2340;
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

					} else if (var5 == 0) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field508[var4], 0, var19, var21);
						if (var4 == 0) {
							if (var8.clipped) {
								InterfaceParent.field565[var0][var1][var2] = 50;
								InterfaceParent.field565[var0][var1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UrlRequest.field1940[var0][var1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 1) {
							if (var8.clipped) {
								InterfaceParent.field565[var0][var1][var2 + 1] = 50;
								InterfaceParent.field565[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UrlRequest.field1940[var0][var1];
								var10000[1 + var2] |= 1170;
							}
						} else if (var4 == 2) {
							if (var8.clipped) {
								InterfaceParent.field565[var0][var1 + 1][var2] = 50;
								InterfaceParent.field565[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UrlRequest.field1940[var0][var1 + 1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 3) {
							if (var8.clipped) {
								InterfaceParent.field565[var0][var1][var2] = 50;
								InterfaceParent.field565[var0][var1 + 1][var2] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UrlRequest.field1940[var0][var1];
								var10000[var2] |= 1170;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3626(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3171(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 1) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field513[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								InterfaceParent.field565[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								InterfaceParent.field565[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								InterfaceParent.field565[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								InterfaceParent.field565[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3626(var1, var2, var5, var4, var8.boolean1);
						}

					} else {
						int var28;
						if (var5 == 2) {
							var28 = var4 + 1 & 3;
							Object var29;
							Object var30;
							if (var8.animationId == -1 && var8.transforms == null) {
								var29 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
								var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
							} else {
								var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var29, (Entity)var30, Tiles.field508[var4], Tiles.field508[var28], var19, var21);
							if (var8.modelClipped) {
								if (var4 == 0) {
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2] |= 585;
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2 + 1] |= 1170;
								} else if (var4 == 1) {
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2 + 1] |= 1170;
									var10000 = UrlRequest.field1940[var0][var1 + 1];
									var10000[var2] |= 585;
								} else if (var4 == 2) {
									var10000 = UrlRequest.field1940[var0][var1 + 1];
									var10000[var2] |= 585;
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2] |= 1170;
								} else if (var4 == 3) {
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2] |= 1170;
									var10000 = UrlRequest.field1940[var0][var1];
									var10000[var2] |= 585;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method3626(var1, var2, var5, var4, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method3171(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 3) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field513[var4], 0, var19, var21);
							if (var8.clipped) {
								if (var4 == 0) {
									InterfaceParent.field565[var0][var1][var2 + 1] = 50;
								} else if (var4 == 1) {
									InterfaceParent.field565[var0][var1 + 1][var2 + 1] = 50;
								} else if (var4 == 2) {
									InterfaceParent.field565[var0][var1 + 1][var2] = 50;
								} else if (var4 == 3) {
									InterfaceParent.field565[var0][var1][var2] = 50;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method3626(var1, var2, var5, var4, var8.boolean1);
							}

						} else if (var5 == 9) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.method3165(var0, var1, var2, var16, 1, 1, (Entity)var22, 0, var19, var21);
							if (var8.interactType != 0 && var7 != null) {
								var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method3171(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 4) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var22, (Entity)null, Tiles.field508[var4], 0, 0, 0, var19, var21);
						} else {
							long var31;
							Object var33;
							if (var5 == 5) {
								var28 = 16;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var31 != 0L) {
									var28 = Occluder.getObjectDefinition(GrandExchangeEvents.Entity_unpackID(var31)).int2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var33 = var8.getEntity(4, var4, var15, var17, var16, var18);
								} else {
									var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, Tiles.field508[var4], 0, var28 * Tiles.field506[var4], var28 * Tiles.field516[var4], var19, var21);
							} else if (var5 == 6) {
								var28 = 8;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (0L != var31) {
									var28 = Occluder.getObjectDefinition(GrandExchangeEvents.Entity_unpackID(var31)).int2 / 2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								} else {
									var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, 256, var4, var28 * Tiles.field503[var4], var28 * Tiles.field517[var4], var19, var21);
							} else if (var5 == 7) {
								var23 = var4 + 2 & 3;
								if (var8.animationId == -1 && var8.transforms == null) {
									var22 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
								} else {
									var22 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var22, (Entity)null, 256, var23, 0, 0, var19, var21);
							} else if (var5 == 8) {
								var28 = 8;
								var31 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (0L != var31) {
									var28 = Occluder.getObjectDefinition(GrandExchangeEvents.Entity_unpackID(var31)).int2 / 2;
								}

								int var27 = var4 + 2 & 3;
								Object var26;
								if (var8.animationId == -1 && var8.transforms == null) {
									var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
									var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
								} else {
									var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
									var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)var26, 256, var4, var28 * Tiles.field503[var4], var28 * Tiles.field517[var4], var19, var21);
							}
						}
					}
				} else {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					if (var22 != null && var6.method3165(var0, var1, var2, var16, var9, var10, (Entity)var22, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
						var23 = 15;
						if (var22 instanceof Model) {
							var23 = ((Model)var22).method2952() / 4;
							if (var23 > 30) {
								var23 = 30;
							}
						}

						for (int var24 = 0; var24 <= var9; ++var24) {
							for (int var25 = 0; var25 <= var10; ++var25) {
								if (var23 > InterfaceParent.field565[var0][var24 + var1][var25 + var2]) {
									InterfaceParent.field565[var0][var24 + var1][var25 + var2] = (byte)var23;
								}
							}
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				}
			}
		}
	}
}
