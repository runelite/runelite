import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("SoundCache")
public class SoundCache {
	@ObfuscatedName("z")
	static byte[][][] field1462;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("soundEffectIndex")
	AbstractArchive soundEffectIndex;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("musicSampleIndex")
	AbstractArchive musicSampleIndex;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("musicSamples")
	NodeHashTable musicSamples;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("rawSounds")
	NodeHashTable rawSounds;

	@ObfuscatedSignature(
		signature = "(Liy;Liy;)V"
	)
	public SoundCache(AbstractArchive var1, AbstractArchive var2) {
		this.musicSamples = new NodeHashTable(256);
		this.rawSounds = new NodeHashTable(256);
		this.soundEffectIndex = var1;
		this.musicSampleIndex = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II[II)Ldm;",
		garbageValue = "-1082666612"
	)
	@Export("getSoundEffect0")
	RawSound getSoundEffect0(int var1, int var2, int[] var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var4 |= var1 << 16;
		long var5 = (long)var4;
		RawSound var7 = (RawSound)this.rawSounds.get(var5);
		if (var7 != null) {
			return var7;
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			SoundEffect var8 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
			if (var8 == null) {
				return null;
			} else {
				var7 = var8.toRawSound();
				this.rawSounds.put(var7, var5);
				if (var3 != null) {
					var3[0] -= var7.samples.length;
				}

				return var7;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II[II)Ldm;",
		garbageValue = "-1027789078"
	)
	@Export("getMusicSample0")
	RawSound getMusicSample0(int var1, int var2, int[] var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var4 |= var1 << 16;
		long var5 = (long)var4 ^ 4294967296L;
		RawSound var7 = (RawSound)this.rawSounds.get(var5);
		if (var7 != null) {
			return var7;
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			VorbisSample var8 = (VorbisSample)this.musicSamples.get(var5);
			if (var8 == null) {
				var8 = VorbisSample.readMusicSample(this.musicSampleIndex, var1, var2);
				if (var8 == null) {
					return null;
				}

				this.musicSamples.put(var8, var5);
			}

			var7 = var8.toRawSound(var3);
			if (var7 == null) {
				return null;
			} else {
				var8.remove();
				this.rawSounds.put(var7, var5);
				return var7;
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I[II)Ldm;",
		garbageValue = "-1326319727"
	)
	@Export("getSoundEffect")
	public RawSound getSoundEffect(int var1, int[] var2) {
		if (this.soundEffectIndex.getGroupCount() == 1) {
			return this.getSoundEffect0(0, var1, var2);
		} else if (this.soundEffectIndex.getGroupFileCount(var1) == 1) {
			return this.getSoundEffect0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I[II)Ldm;",
		garbageValue = "211592248"
	)
	@Export("getMusicSample")
	public RawSound getMusicSample(int var1, int[] var2) {
		if (this.musicSampleIndex.getGroupCount() == 1) {
			return this.getMusicSample0(0, var1, var2);
		} else if (this.musicSampleIndex.getGroupFileCount(var1) == 1) {
			return this.getMusicSample0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "277907731"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != ScriptEvent.Client_plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = GrandExchangeOfferWorldComparator.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (var7 != 0L) {
				var12 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0, var2, var3, var7);
				int var39 = WorldMapRectangle.Entity_unpackID(var7);
				int var40 = var12 & 31;
				int var41 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					GrandExchangeOfferWorldComparator.scene.removeBoundaryObject(var0, var2, var3);
					var13 = WorldMapSection2.getObjectDefinition(var39);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3635(var2, var3, var40, var41, var13.boolean1);
					}
				}

				if (var1 == 1) {
					GrandExchangeOfferWorldComparator.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					GrandExchangeOfferWorldComparator.scene.removeGameObject(var0, var2, var3);
					var13 = WorldMapSection2.getObjectDefinition(var39);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var41, var13.boolean1);
					}
				}

				if (var1 == 3) {
					GrandExchangeOfferWorldComparator.scene.removeFloorDecoration(var0, var2, var3);
					var13 = WorldMapSection2.getObjectDefinition(var39);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3655(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				Scene var42 = GrandExchangeOfferWorldComparator.scene;
				CollisionMap var14 = Client.collisionMaps[var0];
				ObjectDefinition var15 = WorldMapSection2.getObjectDefinition(var4);
				int var16;
				int var17;
				if (var5 != 1 && var5 != 3) {
					var16 = var15.sizeX;
					var17 = var15.sizeY;
				} else {
					var16 = var15.sizeY;
					var17 = var15.sizeX;
				}

				int var18;
				int var19;
				if (var16 + var2 <= 104) {
					var18 = (var16 >> 1) + var2;
					var19 = var2 + (var16 + 1 >> 1);
				} else {
					var18 = var2;
					var19 = var2 + 1;
				}

				int var20;
				int var21;
				if (var3 + var17 <= 104) {
					var20 = var3 + (var17 >> 1);
					var21 = var3 + (var17 + 1 >> 1);
				} else {
					var20 = var3;
					var21 = var3 + 1;
				}

				int[][] var22 = Tiles.Tiles_heights[var12];
				int var23 = var22[var19][var21] + var22[var18][var20] + var22[var19][var20] + var22[var18][var21] >> 2;
				int var24 = (var2 << 7) + (var16 << 6);
				int var25 = (var3 << 7) + (var17 << 6);
				long var26 = IsaacCipher.calculateTag(var2, var3, 2, var15.int1 == 0, var4);
				int var28 = (var5 << 6) + var6;
				if (var15.int3 == 1) {
					var28 += 256;
				}

				Object var29;
				if (var6 == 22) {
					if (var15.animationId == -1 && var15.transforms == null) {
						var29 = var15.getModel(22, var5, var22, var24, var23, var25);
					} else {
						var29 = new DynamicObject(var4, 22, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
					}

					var42.newFloorDecoration(var0, var2, var3, var23, (Entity)var29, var26, var28);
					if (var15.interactType == 1) {
						var14.setBlockedByFloorDec(var2, var3);
					}
				} else if (var6 != 10 && var6 != 11) {
					if (var6 >= 12) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(var6, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.method3187(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
						if (var15.interactType != 0) {
							var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
						}
					} else if (var6 == 0) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(0, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, 0, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field544[var5], 0, var26, var28);
						if (var15.interactType != 0) {
							var14.method3630(var2, var3, var6, var5, var15.boolean1);
						}
					} else if (var6 == 1) {
						if (var15.animationId == -1 && var15.transforms == null) {
							var29 = var15.getModel(1, var5, var22, var24, var23, var25);
						} else {
							var29 = new DynamicObject(var4, 1, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
						}

						var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field542[var5], 0, var26, var28);
						if (var15.interactType != 0) {
							var14.method3630(var2, var3, var6, var5, var15.boolean1);
						}
					} else {
						int var35;
						if (var6 == 2) {
							var35 = var5 + 1 & 3;
							Object var30;
							Object var31;
							if (var15.animationId == -1 && var15.transforms == null) {
								var30 = var15.getModel(2, var5 + 4, var22, var24, var23, var25);
								var31 = var15.getModel(2, var35, var22, var24, var23, var25);
							} else {
								var30 = new DynamicObject(var4, 2, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								var31 = new DynamicObject(var4, 2, var35, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var30, (Entity)var31, Tiles.field544[var5], Tiles.field544[var35], var26, var28);
							if (var15.interactType != 0) {
								var14.method3630(var2, var3, var6, var5, var15.boolean1);
							}
						} else if (var6 == 3) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(3, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, 3, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newBoundaryObject(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field542[var5], 0, var26, var28);
							if (var15.interactType != 0) {
								var14.method3630(var2, var3, var6, var5, var15.boolean1);
							}
						} else if (var6 == 9) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(var6, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.method3187(var0, var2, var3, var23, 1, 1, (Entity)var29, 0, var26, var28);
							if (var15.interactType != 0) {
								var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
							}
						} else if (var6 == 4) {
							if (var15.animationId == -1 && var15.transforms == null) {
								var29 = var15.getModel(4, var5, var22, var24, var23, var25);
							} else {
								var29 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
							}

							var42.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, Tiles.field544[var5], 0, 0, 0, var26, var28);
						} else {
							Object var32;
							long var36;
							if (var6 == 5) {
								var35 = 16;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (var36 != 0L) {
									var35 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var36)).int2;
								}

								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)null, Tiles.field544[var5], 0, var35 * Tiles.field541[var5], var35 * Tiles.field547[var5], var26, var28);
							} else if (var6 == 6) {
								var35 = 8;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (0L != var36) {
									var35 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var36)).int2 / 2;
								}

								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5 + 4, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)null, 256, var5, var35 * Tiles.field546[var5], var35 * Tiles.field552[var5], var26, var28);
							} else if (var6 == 7) {
								int var38 = var5 + 2 & 3;
								if (var15.animationId == -1 && var15.transforms == null) {
									var29 = var15.getModel(4, var38 + 4, var22, var24, var23, var25);
								} else {
									var29 = new DynamicObject(var4, 4, var38 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var29, (Entity)null, 256, var38, 0, 0, var26, var28);
							} else if (var6 == 8) {
								var35 = 8;
								var36 = var42.getBoundaryObjectTag(var0, var2, var3);
								if (var36 != 0L) {
									var35 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var36)).int2 / 2;
								}

								int var34 = var5 + 2 & 3;
								Object var33;
								if (var15.animationId == -1 && var15.transforms == null) {
									var32 = var15.getModel(4, var5 + 4, var22, var24, var23, var25);
									var33 = var15.getModel(4, var34 + 4, var22, var24, var23, var25);
								} else {
									var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
									var33 = new DynamicObject(var4, 4, var34 + 4, var12, var2, var3, var15.animationId, true, (Entity)null);
								}

								var42.newWallDecoration(var0, var2, var3, var23, (Entity)var32, (Entity)var33, 256, var5, var35 * Tiles.field546[var5], var35 * Tiles.field552[var5], var26, var28);
							}
						}
					}
				} else {
					if (var15.animationId == -1 && var15.transforms == null) {
						var29 = var15.getModel(10, var5, var22, var24, var23, var25);
					} else {
						var29 = new DynamicObject(var4, 10, var5, var12, var2, var3, var15.animationId, true, (Entity)null);
					}

					if (var29 != null) {
						var42.method3187(var0, var2, var3, var23, var16, var17, (Entity)var29, var6 == 11 ? 256 : 0, var26, var28);
					}

					if (var15.interactType != 0) {
						var14.addGameObject(var2, var3, var16, var17, var15.boolean1);
					}
				}
			}
		}

	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(Lbi;IIBI)V",
		garbageValue = "1090203781"
	)
	static final void method2609(Player var0, int var1, int var2, byte var3) {
		int var4 = var0.pathX[0];
		int var5 = var0.pathY[0];
		int var6 = var0.transformedSize();
		if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
			if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
				int var8 = var0.transformedSize();
				RouteStrategy var9 = WorldMapDecoration.method438(var1, var2);
				CollisionMap var10 = Client.collisionMaps[var0.plane];
				int[] var11 = Client.field955;
				int[] var12 = Client.field956;

				int var13;
				int var14;
				for (var13 = 0; var13 < 128; ++var13) {
					for (var14 = 0; var14 < 128; ++var14) {
						class182.directions[var13][var14] = 0;
						class182.distances[var13][var14] = 99999999;
					}
				}

				int var15;
				int var16;
				byte var17;
				byte var18;
				int var19;
				int var20;
				byte var21;
				int var22;
				int[][] var23;
				int var24;
				int var25;
				int var26;
				int var27;
				boolean var33;
				boolean var34;
				int var35;
				int var36;
				int var38;
				if (var8 == 1) {
					var15 = var4;
					var16 = var5;
					var17 = 64;
					var18 = 64;
					var19 = var4 - var17;
					var20 = var5 - var18;
					class182.directions[var17][var18] = 99;
					class182.distances[var17][var18] = 0;
					var21 = 0;
					var22 = 0;
					class182.bufferX[var21] = var4;
					var38 = var21 + 1;
					class182.bufferY[var21] = var5;
					var23 = var10.flags;

					while (true) {
						if (var22 == var38) {
							Coord.field2530 = var15;
							class182.field2097 = var16;
							var34 = false;
							break;
						}

						var15 = class182.bufferX[var22];
						var16 = class182.bufferY[var22];
						var22 = var22 + 1 & 4095;
						var35 = var15 - var19;
						var36 = var16 - var20;
						var24 = var15 - var10.xInset;
						var25 = var16 - var10.yInset;
						if (var9.hasArrived(1, var15, var16, var10)) {
							Coord.field2530 = var15;
							class182.field2097 = var16;
							var34 = true;
							break;
						}

						var26 = class182.distances[var35][var36] + 1;
						if (var35 > 0 && class182.directions[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136776) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36] = 2;
							class182.distances[var35 - 1][var36] = var26;
						}

						if (var35 < 127 && class182.directions[var35 + 1][var36] == 0 && (var23[var24 + 1][var25] & 19136896) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36] = 8;
							class182.distances[var35 + 1][var36] = var26;
						}

						if (var36 > 0 && class182.directions[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
							class182.bufferX[var38] = var15;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35][var36 - 1] = 1;
							class182.distances[var35][var36 - 1] = var26;
						}

						if (var36 < 127 && class182.directions[var35][var36 + 1] == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
							class182.bufferX[var38] = var15;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35][var36 + 1] = 4;
							class182.distances[var35][var36 + 1] = var26;
						}

						if (var35 > 0 && var36 > 0 && class182.directions[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36 - 1] = 3;
							class182.distances[var35 - 1][var36 - 1] = var26;
						}

						if (var35 < 127 && var36 > 0 && class182.directions[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36 - 1] = 9;
							class182.distances[var35 + 1][var36 - 1] = var26;
						}

						if (var35 > 0 && var36 < 127 && class182.directions[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36 + 1] = 6;
							class182.distances[var35 - 1][var36 + 1] = var26;
						}

						if (var35 < 127 && var36 < 127 && class182.directions[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 1] & 19136992) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36 + 1] = 12;
							class182.distances[var35 + 1][var36 + 1] = var26;
						}
					}

					var33 = var34;
				} else if (var8 == 2) {
					var15 = var4;
					var16 = var5;
					var17 = 64;
					var18 = 64;
					var19 = var4 - var17;
					var20 = var5 - var18;
					class182.directions[var17][var18] = 99;
					class182.distances[var17][var18] = 0;
					var21 = 0;
					var22 = 0;
					class182.bufferX[var21] = var4;
					var38 = var21 + 1;
					class182.bufferY[var21] = var5;
					var23 = var10.flags;

					while (true) {
						if (var22 == var38) {
							Coord.field2530 = var15;
							class182.field2097 = var16;
							var34 = false;
							break;
						}

						var15 = class182.bufferX[var22];
						var16 = class182.bufferY[var22];
						var22 = var22 + 1 & 4095;
						var35 = var15 - var19;
						var36 = var16 - var20;
						var24 = var15 - var10.xInset;
						var25 = var16 - var10.yInset;
						if (var9.hasArrived(2, var15, var16, var10)) {
							Coord.field2530 = var15;
							class182.field2097 = var16;
							var34 = true;
							break;
						}

						var26 = class182.distances[var35][var36] + 1;
						if (var35 > 0 && class182.directions[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36] = 2;
							class182.distances[var35 - 1][var36] = var26;
						}

						if (var35 < 126 && class182.directions[var35 + 1][var36] == 0 && (var23[var24 + 2][var25] & 19136899) == 0 && (var23[var24 + 2][var25 + 1] & 19136992) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36] = 8;
							class182.distances[var35 + 1][var36] = var26;
						}

						if (var36 > 0 && class182.directions[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0) {
							class182.bufferX[var38] = var15;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35][var36 - 1] = 1;
							class182.distances[var35][var36 - 1] = var26;
						}

						if (var36 < 126 && class182.directions[var35][var36 + 1] == 0 && (var23[var24][var25 + 2] & 19136824) == 0 && (var23[var24 + 1][var25 + 2] & 19136992) == 0) {
							class182.bufferX[var38] = var15;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35][var36 + 1] = 4;
							class182.distances[var35][var36 + 1] = var26;
						}

						if (var35 > 0 && var36 > 0 && class182.directions[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25] & 19136830) == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24][var25 - 1] & 19136911) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36 - 1] = 3;
							class182.distances[var35 - 1][var36 - 1] = var26;
						}

						if (var35 < 126 && var36 > 0 && class182.directions[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136911) == 0 && (var23[var24 + 2][var25 - 1] & 19136899) == 0 && (var23[var24 + 2][var25] & 19136995) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16 - 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36 - 1] = 9;
							class182.distances[var35 + 1][var36 - 1] = var26;
						}

						if (var35 > 0 && var36 < 126 && class182.directions[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136830) == 0 && (var23[var24 - 1][var25 + 2] & 19136824) == 0 && (var23[var24][var25 + 2] & 19137016) == 0) {
							class182.bufferX[var38] = var15 - 1;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 - 1][var36 + 1] = 6;
							class182.distances[var35 - 1][var36 + 1] = var26;
						}

						if (var35 < 126 && var36 < 126 && class182.directions[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 2] & 19137016) == 0 && (var23[var24 + 2][var25 + 2] & 19136992) == 0 && (var23[var24 + 2][var25 + 1] & 19136995) == 0) {
							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36 + 1] = 12;
							class182.distances[var35 + 1][var36 + 1] = var26;
						}
					}

					var33 = var34;
				} else {
					var15 = var4;
					var16 = var5;
					var17 = 64;
					var18 = 64;
					var19 = var4 - var17;
					var20 = var5 - var18;
					class182.directions[var17][var18] = 99;
					class182.distances[var17][var18] = 0;
					var21 = 0;
					var22 = 0;
					class182.bufferX[var21] = var4;
					var38 = var21 + 1;
					class182.bufferY[var21] = var5;
					var23 = var10.flags;

					label822:
					while (true) {
						label820:
						while (true) {
							do {
								do {
									do {
										label797:
										do {
											if (var22 == var38) {
												Coord.field2530 = var15;
												class182.field2097 = var16;
												var34 = false;
												break label822;
											}

											var15 = class182.bufferX[var22];
											var16 = class182.bufferY[var22];
											var22 = var22 + 1 & 4095;
											var35 = var15 - var19;
											var36 = var16 - var20;
											var24 = var15 - var10.xInset;
											var25 = var16 - var10.yInset;
											if (var9.hasArrived(var8, var15, var16, var10)) {
												Coord.field2530 = var15;
												class182.field2097 = var16;
												var34 = true;
												break label822;
											}

											var26 = class182.distances[var35][var36] + 1;
											if (var35 > 0 && class182.directions[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var8 + var25 - 1] & 19136824) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8 - 1) {
														class182.bufferX[var38] = var15 - 1;
														class182.bufferY[var38] = var16;
														var38 = var38 + 1 & 4095;
														class182.directions[var35 - 1][var36] = 2;
														class182.distances[var35 - 1][var36] = var26;
														break;
													}

													if ((var23[var24 - 1][var27 + var25] & 19136830) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var35 < 128 - var8 && class182.directions[var35 + 1][var36] == 0 && (var23[var24 + var8][var25] & 19136899) == 0 && (var23[var24 + var8][var25 + var8 - 1] & 19136992) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8 - 1) {
														class182.bufferX[var38] = var15 + 1;
														class182.bufferY[var38] = var16;
														var38 = var38 + 1 & 4095;
														class182.directions[var35 + 1][var36] = 8;
														class182.distances[var35 + 1][var36] = var26;
														break;
													}

													if ((var23[var24 + var8][var25 + var27] & 19136995) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var36 > 0 && class182.directions[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var8 + var24 - 1][var25 - 1] & 19136899) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8 - 1) {
														class182.bufferX[var38] = var15;
														class182.bufferY[var38] = var16 - 1;
														var38 = var38 + 1 & 4095;
														class182.directions[var35][var36 - 1] = 1;
														class182.distances[var35][var36 - 1] = var26;
														break;
													}

													if ((var23[var27 + var24][var25 - 1] & 19136911) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var36 < 128 - var8 && class182.directions[var35][var36 + 1] == 0 && (var23[var24][var25 + var8] & 19136824) == 0 && (var23[var24 + var8 - 1][var25 + var8] & 19136992) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8 - 1) {
														class182.bufferX[var38] = var15;
														class182.bufferY[var38] = var16 + 1;
														var38 = var38 + 1 & 4095;
														class182.directions[var35][var36 + 1] = 4;
														class182.distances[var35][var36 + 1] = var26;
														break;
													}

													if ((var23[var24 + var27][var25 + var8] & 19137016) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var35 > 0 && var36 > 0 && class182.directions[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8) {
														class182.bufferX[var38] = var15 - 1;
														class182.bufferY[var38] = var16 - 1;
														var38 = var38 + 1 & 4095;
														class182.directions[var35 - 1][var36 - 1] = 3;
														class182.distances[var35 - 1][var36 - 1] = var26;
														break;
													}

													if ((var23[var24 - 1][var27 + (var25 - 1)] & 19136830) != 0 || (var23[var27 + (var24 - 1)][var25 - 1] & 19136911) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var35 < 128 - var8 && var36 > 0 && class182.directions[var35 + 1][var36 - 1] == 0 && (var23[var24 + var8][var25 - 1] & 19136899) == 0) {
												var27 = 1;

												while (true) {
													if (var27 >= var8) {
														class182.bufferX[var38] = var15 + 1;
														class182.bufferY[var38] = var16 - 1;
														var38 = var38 + 1 & 4095;
														class182.directions[var35 + 1][var36 - 1] = 9;
														class182.distances[var35 + 1][var36 - 1] = var26;
														break;
													}

													if ((var23[var24 + var8][var27 + (var25 - 1)] & 19136995) != 0 || (var23[var27 + var24][var25 - 1] & 19136911) != 0) {
														break;
													}

													++var27;
												}
											}

											if (var35 > 0 && var36 < 128 - var8 && class182.directions[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + var8] & 19136824) == 0) {
												for (var27 = 1; var27 < var8; ++var27) {
													if ((var23[var24 - 1][var27 + var25] & 19136830) != 0 || (var23[var27 + (var24 - 1)][var8 + var25] & 19137016) != 0) {
														continue label797;
													}
												}

												class182.bufferX[var38] = var15 - 1;
												class182.bufferY[var38] = var16 + 1;
												var38 = var38 + 1 & 4095;
												class182.directions[var35 - 1][var36 + 1] = 6;
												class182.distances[var35 - 1][var36 + 1] = var26;
											}
										} while(var35 >= 128 - var8);
									} while(var36 >= 128 - var8);
								} while(class182.directions[var35 + 1][var36 + 1] != 0);
							} while((var23[var24 + var8][var8 + var25] & 19136992) != 0);

							for (var27 = 1; var27 < var8; ++var27) {
								if ((var23[var27 + var24][var25 + var8] & 19137016) != 0 || (var23[var24 + var8][var25 + var27] & 19136995) != 0) {
									continue label820;
								}
							}

							class182.bufferX[var38] = var15 + 1;
							class182.bufferY[var38] = var16 + 1;
							var38 = var38 + 1 & 4095;
							class182.directions[var35 + 1][var36 + 1] = 12;
							class182.distances[var35 + 1][var36 + 1] = var26;
						}
					}

					var33 = var34;
				}

				int var7;
				label888: {
					var14 = var4 - 64;
					var15 = var5 - 64;
					var16 = Coord.field2530;
					var35 = class182.field2097;
					if (!var33) {
						var36 = Integer.MAX_VALUE;
						var19 = Integer.MAX_VALUE;
						byte var37 = 10;
						var38 = var9.approxDestinationX;
						var22 = var9.approxDestinationY;
						int var32 = var9.approxDestinationSizeX;
						var24 = var9.approxDestinationSizeY;

						for (var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
							for (var26 = var22 - var37; var26 <= var22 + var37; ++var26) {
								var27 = var25 - var14;
								int var28 = var26 - var15;
								if (var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class182.distances[var27][var28] < 100) {
									int var29 = 0;
									if (var25 < var38) {
										var29 = var38 - var25;
									} else if (var25 > var38 + var32 - 1) {
										var29 = var25 - (var32 + var38 - 1);
									}

									int var30 = 0;
									if (var26 < var22) {
										var30 = var22 - var26;
									} else if (var26 > var22 + var24 - 1) {
										var30 = var26 - (var24 + var22 - 1);
									}

									int var31 = var29 * var29 + var30 * var30;
									if (var31 < var36 || var31 == var36 && class182.distances[var27][var28] < var19) {
										var36 = var31;
										var19 = class182.distances[var27][var28];
										var16 = var25;
										var35 = var26;
									}
								}
							}
						}

						if (var36 == Integer.MAX_VALUE) {
							var7 = -1;
							break label888;
						}
					}

					if (var16 == var4 && var5 == var35) {
						var7 = 0;
					} else {
						var18 = 0;
						class182.bufferX[var18] = var16;
						var36 = var18 + 1;
						class182.bufferY[var18] = var35;

						for (var19 = var20 = class182.directions[var16 - var14][var35 - var15]; var16 != var4 || var5 != var35; var19 = class182.directions[var16 - var14][var35 - var15]) {
							if (var19 != var20) {
								var20 = var19;
								class182.bufferX[var36] = var16;
								class182.bufferY[var36++] = var35;
							}

							if ((var19 & 2) != 0) {
								++var16;
							} else if ((var19 & 8) != 0) {
								--var16;
							}

							if ((var19 & 1) != 0) {
								++var35;
							} else if ((var19 & 4) != 0) {
								--var35;
							}
						}

						var38 = 0;

						while (var36-- > 0) {
							var11[var38] = class182.bufferX[var36];
							var12[var38++] = class182.bufferY[var36];
							if (var38 >= var11.length) {
								break;
							}
						}

						var7 = var38;
					}
				}

				var13 = var7;
				if (var7 >= 1) {
					for (var14 = 0; var14 < var13 - 1; ++var14) {
						var0.method1341(Client.field955[var14], Client.field956[var14], var3);
					}

				}
			}
		}
	}
}
