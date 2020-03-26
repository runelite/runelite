import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("PacketBuffer")
public class PacketBuffer extends Buffer {
	@ObfuscatedName("m")
	static final int[] field3707;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("isaacCipher")
	IsaacCipher isaacCipher;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2144680439
	)
	@Export("bitIndex")
	int bitIndex;

	static {
		field3707 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
	}

	public PacketBuffer(int var1) {
		super(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([II)V",
		garbageValue = "-1491722671"
	)
	@Export("newIsaacCipher")
	public void newIsaacCipher(int[] var1) {
		this.isaacCipher = new IsaacCipher(var1);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Llp;I)V",
		garbageValue = "452312441"
	)
	@Export("setIsaacCipher")
	public void setIsaacCipher(IsaacCipher var1) {
		this.isaacCipher = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-407468573"
	)
	@Export("writeByteIsaac")
	public void writeByteIsaac(int var1) {
		super.array[++super.offset - 1] = (byte)(var1 + this.isaacCipher.nextInt());
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1676648466"
	)
	@Export("readByteIsaac")
	public int readByteIsaac() {
		return super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "36"
	)
	public boolean method5524() {
		int var1 = super.array[super.offset] - this.isaacCipher.method6364() & 255;
		return var1 >= 128;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "787135806"
	)
	@Export("readSmartByteShortIsaac")
	public int readSmartByteShortIsaac() {
		int var1 = super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
		return var1 < 128 ? var1 : (var1 - 128 << 8) + (super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "330744535"
	)
	public void method5516(byte[] var1, int var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			var1[var4 + var2] = (byte)(super.array[++super.offset - 1] - this.isaacCipher.nextInt());
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-6"
	)
	@Export("importIndex")
	public void importIndex() {
		this.bitIndex = super.offset * 8;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-43"
	)
	@Export("readBits")
	public int readBits(int var1) {
		int var2 = this.bitIndex >> 3;
		int var3 = 8 - (this.bitIndex & 7);
		int var4 = 0;

		for (this.bitIndex += var1; var1 > var3; var3 = 8) {
			var4 += (super.array[var2++] & field3707[var3]) << var1 - var3;
			var1 -= var3;
		}

		if (var3 == var1) {
			var4 += super.array[var2] & field3707[var3];
		} else {
			var4 += super.array[var2] >> var3 - var1 & field3707[var1];
		}

		return var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "931642026"
	)
	@Export("exportIndex")
	public void exportIndex() {
		super.offset = (this.bitIndex + 7) / 8;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "0"
	)
	@Export("bitsRemaining")
	public int bitsRemaining(int var1) {
		return var1 * 8 - this.bitIndex;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIIIILej;Lfm;S)V",
		garbageValue = "7907"
	)
	static final void method5554(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectDefinition var8 = WorldMapSection2.getObjectDefinition(var3);
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
			int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = IsaacCipher.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			int var23;
			int var24;
			if (var8.hasSound()) {
				ObjectSound var22 = new ObjectSound();
				var22.plane = var0;
				var22.x = var1 * 128;
				var22.y = var2 * 128;
				var23 = var8.sizeX;
				var24 = var8.sizeY;
				if (var4 == 1 || var4 == 3) {
					var23 = var8.sizeY;
					var24 = var8.sizeX;
				}

				var22.field1110 = (var23 + var1) * 128;
				var22.field1100 = (var24 + var2) * 128;
				var22.soundEffectId = var8.ambientSoundId;
				var22.field1106 = var8.int4 * 128;
				var22.field1104 = var8.int5;
				var22.field1105 = var8.int6;
				var22.soundEffectIds = var8.soundEffectIds;
				if (var8.transforms != null) {
					var22.obj = var8;
					var22.set();
				}

				ObjectSound.objectSounds.addFirst(var22);
				if (var22.soundEffectIds != null) {
					var22.field1107 = var22.field1104 + (int)(Math.random() * (double)(var22.field1105 - var22.field1104));
				}
			}

			Object var34;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var34, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else if (var5 != 10 && var5 != 11) {
				int[] var10000;
				if (var5 >= 12) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.method3187(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
					if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
						var10000 = class51.field404[var0][var1];
						var10000[var2] |= 2340;
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				} else if (var5 == 0) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(0, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field544[var4], 0, var19, var21);
					if (var4 == 0) {
						if (var8.clipped) {
							SoundCache.field1462[var0][var1][var2] = 50;
							SoundCache.field1462[var0][var1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = class51.field404[var0][var1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 1) {
						if (var8.clipped) {
							SoundCache.field1462[var0][var1][var2 + 1] = 50;
							SoundCache.field1462[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = class51.field404[var0][var1];
							var10000[var2 + 1] |= 1170;
						}
					} else if (var4 == 2) {
						if (var8.clipped) {
							SoundCache.field1462[var0][var1 + 1][var2] = 50;
							SoundCache.field1462[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = class51.field404[var0][var1 + 1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 3) {
						if (var8.clipped) {
							SoundCache.field1462[var0][var1][var2] = 50;
							SoundCache.field1462[var0][var1 + 1][var2] = 50;
						}

						if (var8.modelClipped) {
							var10000 = class51.field404[var0][var1];
							var10000[var2] |= 1170;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3630(var1, var2, var5, var4, var8.boolean1);
					}

					if (var8.int2 != 16) {
						var6.method3210(var0, var1, var2, var8.int2);
					}

				} else if (var5 == 1) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(1, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field542[var4], 0, var19, var21);
					if (var8.clipped) {
						if (var4 == 0) {
							SoundCache.field1462[var0][var1][var2 + 1] = 50;
						} else if (var4 == 1) {
							SoundCache.field1462[var0][var1 + 1][var2 + 1] = 50;
						} else if (var4 == 2) {
							SoundCache.field1462[var0][var1 + 1][var2] = 50;
						} else if (var4 == 3) {
							SoundCache.field1462[var0][var1][var2] = 50;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3630(var1, var2, var5, var4, var8.boolean1);
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

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var29, (Entity)var30, Tiles.field544[var4], Tiles.field544[var28], var19, var21);
						if (var8.modelClipped) {
							if (var4 == 0) {
								var10000 = class51.field404[var0][var1];
								var10000[var2] |= 585;
								var10000 = class51.field404[var0][var1];
								var10000[1 + var2] |= 1170;
							} else if (var4 == 1) {
								var10000 = class51.field404[var0][var1];
								var10000[var2 + 1] |= 1170;
								var10000 = class51.field404[var0][var1 + 1];
								var10000[var2] |= 585;
							} else if (var4 == 2) {
								var10000 = class51.field404[var0][var1 + 1];
								var10000[var2] |= 585;
								var10000 = class51.field404[var0][var1];
								var10000[var2] |= 1170;
							} else if (var4 == 3) {
								var10000 = class51.field404[var0][var1];
								var10000[var2] |= 1170;
								var10000 = class51.field404[var0][var1];
								var10000[var2] |= 585;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3630(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3210(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 3) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(3, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field542[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								SoundCache.field1462[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								SoundCache.field1462[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								SoundCache.field1462[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								SoundCache.field1462[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3630(var1, var2, var5, var4, var8.boolean1);
						}

					} else if (var5 == 9) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.method3187(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3210(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 4) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(4, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field544[var4], 0, 0, 0, var19, var21);
					} else {
						long var31;
						Object var33;
						if (var5 == 5) {
							var28 = 16;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (var31 != 0L) {
								var28 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var31)).int2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, Tiles.field544[var4], 0, var28 * Tiles.field541[var4], var28 * Tiles.field547[var4], var19, var21);
						} else if (var5 == 6) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var31)).int2 / 2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, 256, var4, var28 * Tiles.field546[var4], var28 * Tiles.field552[var4], var19, var21);
						} else if (var5 == 7) {
							var23 = var4 + 2 & 3;
							if (var8.animationId == -1 && var8.transforms == null) {
								var34 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
							} else {
								var34 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, 256, var23, 0, 0, var19, var21);
						} else if (var5 == 8) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (var31 != 0L) {
								var28 = WorldMapSection2.getObjectDefinition(WorldMapRectangle.Entity_unpackID(var31)).int2 / 2;
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

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)var26, 256, var4, var28 * Tiles.field546[var4], var28 * Tiles.field552[var4], var19, var21);
						}
					}
				}
			} else {
				if (var8.animationId == -1 && var8.transforms == null) {
					var34 = var8.getEntity(10, var4, var15, var17, var16, var18);
				} else {
					var34 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
				}

				if (var34 != null && var6.method3187(var0, var1, var2, var16, var9, var10, (Entity)var34, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
					var23 = 15;
					if (var34 instanceof Model) {
						var23 = ((Model)var34).method2993() / 4;
						if (var23 > 30) {
							var23 = 30;
						}
					}

					for (var24 = 0; var24 <= var9; ++var24) {
						for (int var25 = 0; var25 <= var10; ++var25) {
							if (var23 > SoundCache.field1462[var0][var24 + var1][var25 + var2]) {
								SoundCache.field1462[var0][var24 + var1][var25 + var2] = (byte)var23;
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
