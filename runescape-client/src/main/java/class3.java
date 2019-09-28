import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class3 implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lu;"
	)
	static final class3 field7;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lu;"
	)
	static final class3 field15;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lu;"
	)
	static final class3 field8;
	@ObfuscatedName("ax")
	static String field18;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1838246195
	)
	final int field12;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 689062233
	)
	public final int field9;
	@ObfuscatedName("p")
	final Class field11;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lz;"
	)
	public final class0 field13;

	static {
		field7 = new class3(1, 0, Integer.class, new class1());
		field15 = new class3(0, 1, Long.class, new class2());
		field8 = new class3(2, 2, String.class, new class4());
	}

	@ObfuscatedSignature(
		signature = "(IILjava/lang/Class;Lz;)V"
	)
	class3(int var1, int var2, Class var3, class0 var4) {
		this.field12 = var1;
		this.field9 = var2;
		this.field11 = var3;
		this.field13 = var4;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field9;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;I)Ljava/lang/Object;",
		garbageValue = "-1513659890"
	)
	public Object method35(Buffer var1) {
		return this.field13.vmethod55(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)[Lu;",
		garbageValue = "-1521919568"
	)
	public static class3[] method41() {
		return new class3[]{field8, field15, field7};
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "1159986112"
	)
	public static String method52(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class289.field3641[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class289.field3641[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class289.field3641[(var6 & 15) << 2 | var7 >>> 6]).append(class289.field3641[var7 & 63]);
				} else {
					var3.append(class289.field3641[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class289.field3641[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Class;B)Lu;",
		garbageValue = "-104"
	)
	public static class3 method33(Class var0) {
		class3[] var1 = method41();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class3 var3 = var1[var2];
			if (var3.field11 == var0) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2040711536"
	)
	@Export("WorldMapRegion_clearCachedSprites")
	static void WorldMapRegion_clearCachedSprites() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "1231494139"
	)
	static void method51(int var0, int var1, int var2, int var3) {
		for (ObjectSound var4 = (ObjectSound)ObjectSound.objectSounds.last(); var4 != null; var4 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var4.soundEffectId != -1 || var4.soundEffectIds != null) {
				int var5 = 0;
				if (var1 > var4.field1059 * 128) {
					var5 += var1 - var4.field1059 * 128;
				} else if (var1 < var4.x * 16384) {
					var5 += var4.x * 16384 - var1;
				}

				if (var2 > var4.field1060 * 128) {
					var5 += var2 - var4.field1060 * 128;
				} else if (var2 < var4.y * 128) {
					var5 += var4.y * 128 - var2;
				}

				if (var5 - 64 <= var4.field1061 && Client.field868 != 0 && var0 == var4.plane) {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}

					int var6 = (var4.field1061 - var5) * Client.field868 / var4.field1061;
					if (var4.stream1 == null) {
						if (var4.soundEffectId >= 0) {
							SoundEffect var7 = SoundEffect.readSoundEffect(GrandExchangeOfferAgeComparator.archive4, var4.soundEffectId, 0);
							if (var7 != null) {
								RawSound var8 = var7.toRawSound().resample(Interpreter.decimator);
								RawPcmStream var9 = RawPcmStream.createRawPcmStream(var8, 100, var6);
								var9.setNumLoops(-1);
								WorldMapLabelSize.pcmStreamMixer.addSubStream(var9);
								var4.stream1 = var9;
							}
						}
					} else {
						var4.stream1.method2519(var6);
					}

					if (var4.stream2 == null) {
						if (var4.soundEffectIds != null && (var4.field1067 -= var3) <= 0) {
							int var11 = (int)(Math.random() * (double)var4.soundEffectIds.length);
							SoundEffect var12 = SoundEffect.readSoundEffect(GrandExchangeOfferAgeComparator.archive4, var4.soundEffectIds[var11], 0);
							if (var12 != null) {
								RawSound var13 = var12.toRawSound().resample(Interpreter.decimator);
								RawPcmStream var10 = RawPcmStream.createRawPcmStream(var13, 100, var6);
								var10.setNumLoops(0);
								WorldMapLabelSize.pcmStreamMixer.addSubStream(var10);
								var4.stream2 = var10;
								var4.field1067 = var4.field1064 + (int)(Math.random() * (double)(var4.field1070 - var4.field1064));
							}
						}
					} else {
						var4.stream2.method2519(var6);
						if (!var4.stream2.hasNext()) {
							var4.stream2 = null;
						}
					}
				} else {
					if (var4.stream1 != null) {
						WorldMapLabelSize.pcmStreamMixer.removeSubStream(var4.stream1);
						var4.stream1 = null;
					}

					if (var4.stream2 != null) {
						WorldMapLabelSize.pcmStreamMixer.removeSubStream(var4.stream2);
						var4.stream2 = null;
					}
				}
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BB)Lcu;",
		garbageValue = "-44"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.newIterableNodeHashTable(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0 ? Timer.method4935(var8) : 1);
				var1.switches[var7] = var9;

				while (var8-- > 0) {
					int var10 = var2.readInt();
					int var11 = var2.readInt();
					var9.put(new IntegerNode(var11), (long)var10);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-537744176"
	)
	static void method48() {
		Login.loginIndex = 24;
		PlayerType.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIIIIIILex;Lfa;S)V",
		garbageValue = "23648"
	)
	static final void method50(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Scene var7, CollisionMap var8) {
		ObjectDefinition var9 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var4);
		int var10;
		int var11;
		if (var5 != 1 && var5 != 3) {
			var10 = var9.sizeX;
			var11 = var9.sizeY;
		} else {
			var10 = var9.sizeY;
			var11 = var9.sizeX;
		}

		int var12;
		int var13;
		if (var10 + var2 <= 104) {
			var12 = (var10 >> 1) + var2;
			var13 = var2 + (var10 + 1 >> 1);
		} else {
			var12 = var2;
			var13 = var2 + 1;
		}

		int var14;
		int var15;
		if (var3 + var11 <= 104) {
			var14 = var3 + (var11 >> 1);
			var15 = var3 + (var11 + 1 >> 1);
		} else {
			var14 = var3;
			var15 = var3 + 1;
		}

		int[][] var16 = Tiles.Tiles_heights[var1];
		int var17 = var16[var13][var15] + var16[var12][var14] + var16[var13][var14] + var16[var12][var15] >> 2;
		int var18 = (var2 << 7) + (var10 << 6);
		int var19 = (var3 << 7) + (var11 << 6);
		long var20 = class267.calculateTag(var2, var3, 2, var9.int1 == 0, var4);
		int var22 = (var5 << 6) + var6;
		if (var9.int3 == 1) {
			var22 += 256;
		}

		Object var23;
		if (var6 == 22) {
			if (var9.animationId == -1 && var9.transforms == null) {
				var23 = var9.getModel(22, var5, var16, var18, var17, var19);
			} else {
				var23 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
			}

			var7.newFloorDecoration(var0, var2, var3, var17, (Entity)var23, var20, var22);
			if (var9.interactType == 1) {
				var8.setBlockedByFloorDec(var2, var3);
			}

		} else if (var6 != 10 && var6 != 11) {
			if (var6 >= 12) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(var6, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.method3056(var0, var2, var3, var17, 1, 1, (Entity)var23, 0, var20, var22);
				if (var9.interactType != 0) {
					var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
				}

			} else if (var6 == 0) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(0, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field489[var5], 0, var20, var22);
				if (var9.interactType != 0) {
					var8.method3508(var2, var3, var6, var5, var9.boolean1);
				}

			} else if (var6 == 1) {
				if (var9.animationId == -1 && var9.transforms == null) {
					var23 = var9.getModel(1, var5, var16, var18, var17, var19);
				} else {
					var23 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
				}

				var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field493[var5], 0, var20, var22);
				if (var9.interactType != 0) {
					var8.method3508(var2, var3, var6, var5, var9.boolean1);
				}

			} else {
				int var29;
				if (var6 == 2) {
					var29 = var5 + 1 & 3;
					Object var24;
					Object var25;
					if (var9.animationId == -1 && var9.transforms == null) {
						var24 = var9.getModel(2, var5 + 4, var16, var18, var17, var19);
						var25 = var9.getModel(2, var29, var16, var18, var17, var19);
					} else {
						var24 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						var25 = new DynamicObject(var4, 2, var29, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var24, (Entity)var25, Tiles.field489[var5], Tiles.field489[var29], var20, var22);
					if (var9.interactType != 0) {
						var8.method3508(var2, var3, var6, var5, var9.boolean1);
					}

				} else if (var6 == 3) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(3, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newBoundaryObject(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field493[var5], 0, var20, var22);
					if (var9.interactType != 0) {
						var8.method3508(var2, var3, var6, var5, var9.boolean1);
					}

				} else if (var6 == 9) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(var6, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.method3056(var0, var2, var3, var17, 1, 1, (Entity)var23, 0, var20, var22);
					if (var9.interactType != 0) {
						var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
					}

				} else if (var6 == 4) {
					if (var9.animationId == -1 && var9.transforms == null) {
						var23 = var9.getModel(4, var5, var16, var18, var17, var19);
					} else {
						var23 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
					}

					var7.newWallDecoration(var0, var2, var3, var17, (Entity)var23, (Entity)null, Tiles.field489[var5], 0, 0, 0, var20, var22);
				} else {
					Object var26;
					long var30;
					if (var6 == 5) {
						var29 = 16;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (var30 != 0L) {
							var29 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var30)).int2;
						}

						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)null, Tiles.field489[var5], 0, var29 * Tiles.field491[var5], var29 * Tiles.field492[var5], var20, var22);
					} else if (var6 == 6) {
						var29 = 8;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (var30 != 0L) {
							var29 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var30)).int2 / 2;
						}

						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5 + 4, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)null, 256, var5, var29 * Tiles.field484[var5], var29 * Tiles.field494[var5], var20, var22);
					} else if (var6 == 7) {
						int var32 = var5 + 2 & 3;
						if (var9.animationId == -1 && var9.transforms == null) {
							var23 = var9.getModel(4, var32 + 4, var16, var18, var17, var19);
						} else {
							var23 = new DynamicObject(var4, 4, var32 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var23, (Entity)null, 256, var32, 0, 0, var20, var22);
					} else if (var6 == 8) {
						var29 = 8;
						var30 = var7.getBoundaryObjectTag(var0, var2, var3);
						if (var30 != 0L) {
							var29 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var30)).int2 / 2;
						}

						int var28 = var5 + 2 & 3;
						Object var27;
						if (var9.animationId == -1 && var9.transforms == null) {
							var26 = var9.getModel(4, var5 + 4, var16, var18, var17, var19);
							var27 = var9.getModel(4, var28 + 4, var16, var18, var17, var19);
						} else {
							var26 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
							var27 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Entity)null);
						}

						var7.newWallDecoration(var0, var2, var3, var17, (Entity)var26, (Entity)var27, 256, var5, var29 * Tiles.field484[var5], var29 * Tiles.field494[var5], var20, var22);
					}
				}
			}
		} else {
			if (var9.animationId == -1 && var9.transforms == null) {
				var23 = var9.getModel(10, var5, var16, var18, var17, var19);
			} else {
				var23 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Entity)null);
			}

			if (var23 != null) {
				var7.method3056(var0, var2, var3, var17, var10, var11, (Entity)var23, var6 == 11 ? 256 : 0, var20, var22);
			}

			if (var9.interactType != 0) {
				var8.addGameObject(var2, var3, var10, var11, var9.boolean1);
			}

		}
	}

	@ObfuscatedName("ji")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "323283253"
	)
	static void method47(int var0, int var1) {
		MenuAction var2 = ParamDefinition.tempMenuAction;
		InvDefinition.menuAction(var2.argument1, var2.argument2, var2.opcode, var2.argument0, var2.action, var2.action, var0, var1);
		ParamDefinition.tempMenuAction = null;
	}
}
