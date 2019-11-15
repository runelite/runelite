import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("c")
	public static short[] field2519;
	@ObfuscatedName("o")
	public static short[][] field2520;
	@ObfuscatedName("m")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("PlayerAppearance_cachedModels")
	static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("a")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("t")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("n")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1447721329
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = 3547676045736653443L
	)
	long field2517;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 826558689471794127L
	)
	long field2518;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "2098683582"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = BufferedSource.KitDefinition_get(var6);
					if (var7 != null && !var7.nonSelectable && var7.bodypartID == (var3 ? 7 : 0) + var5) {
						var1[equipmentIndices[var5]] = var6 + 256;
						break;
					}
				}
			}
		}

		this.equipment = var1;
		this.bodyColors = var2;
		this.isFemale = var3;
		this.npcTransformId = var4;
		this.setHash();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "429844211"
	)
	@Export("changeAppearance")
	public void changeAppearance(int var1, boolean var2) {
		if (var1 != 1 || !this.isFemale) {
			int var3 = this.equipment[equipmentIndices[var1]];
			if (var3 != 0) {
				var3 -= 256;

				KitDefinition var4;
				do {
					if (!var2) {
						--var3;
						if (var3 < 0) {
							var3 = KitDefinition.KitDefinition_fileCount - 1;
						}
					} else {
						++var3;
						if (var3 >= KitDefinition.KitDefinition_fileCount) {
							var3 = 0;
						}
					}

					var4 = BufferedSource.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var1 + (this.isFemale ? 7 : 0) != var4.bodypartID);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "1"
	)
	public void method4156(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = field2520[var1].length - 1;
				}

				if (var1 == 4 && var3 >= 8) {
					var4 = false;
				} else {
					var4 = true;
				}
			} while(!var4);
		} else {
			do {
				++var3;
				if (var3 >= field2520[var1].length) {
					var3 = 0;
				}

				if (var1 == 4 && var3 >= 8) {
					var4 = false;
				} else {
					var4 = true;
				}
			} while(!var4);
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "864833529"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "65280"
	)
	@Export("write")
	public void write(Buffer var1) {
		var1.writeByte(this.isFemale ? 1 : 0);

		int var2;
		for (var2 = 0; var2 < 7; ++var2) {
			int var3 = this.equipment[equipmentIndices[var2]];
			if (var3 == 0) {
				var1.writeByte(-1);
			} else {
				var1.writeByte(var3 - 256);
			}
		}

		for (var2 = 0; var2 < 5; ++var2) {
			var1.writeByte(this.bodyColors[var2]);
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1536337357"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.field2517;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.field2517 = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.field2517 <<= 4;
			if (this.equipment[var5] >= 256) {
				this.field2517 += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.field2517 += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.field2517 += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.field2517 <<= 3;
			this.field2517 += (long)this.bodyColors[var5];
		}

		this.field2517 <<= 1;
		this.field2517 += (long)(this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && var1 != this.field2517) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Liv;ILiv;II)Ldv;",
		garbageValue = "-1006380079"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return SecureRandomCallable.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else {
			long var5 = this.field2517;
			int[] var7 = this.equipment;
			if (var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
				var7 = new int[12];

				for (int var15 = 0; var15 < 12; ++var15) {
					var7[var15] = this.equipment[var15];
				}

				if (var1.shield >= 0) {
					var5 += (long)(var1.shield - this.equipment[5] << 40);
					var7[5] = var1.shield;
				}

				if (var1.weapon >= 0) {
					var5 += (long)(var1.weapon - this.equipment[3] << 48);
					var7[3] = var1.weapon;
				}
			}

			Model var8 = (Model)PlayerAppearance_cachedModels.get(var5);
			if (var8 == null) {
				boolean var9 = false;

				int var11;
				for (int var10 = 0; var10 < 12; ++var10) {
					var11 = var7[var10];
					if (var11 >= 256 && var11 < 512 && !BufferedSource.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !class222.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field2518) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2518);
					}

					if (var8 == null) {
						return null;
					}
				}

				if (var8 == null) {
					ModelData[] var16 = new ModelData[12];
					var11 = 0;

					int var13;
					for (int var12 = 0; var12 < 12; ++var12) {
						var13 = var7[var12];
						ModelData var14;
						if (var13 >= 256 && var13 < 512) {
							var14 = BufferedSource.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = class222.ItemDefinition_get(var13 - 512).method4790(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var18 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < field2520[var13].length) {
							var18.recolor(field2519[var13], field2520[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < class195.field2359[var13].length) {
							var18.recolor(class326.field3881[var13], class195.field2359[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var18.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2518 = var5;
				}
			}

			if (var1 == null && var3 == null) {
				return var8;
			} else {
				Model var17;
				if (var1 != null && var3 != null) {
					var17 = var1.applyTransformations(var8, var2, var3, var4);
				} else if (var1 != null) {
					var17 = var1.transformActorModel(var8, var2);
				} else {
					var17 = var3.transformActorModel(var8, var4);
				}

				return var17;
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)Ldu;",
		garbageValue = "-58"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return SecureRandomCallable.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !BufferedSource.KitDefinition_get(var3 - 256).method4602()) {
					var1 = true;
				}

				if (var3 >= 512 && !class222.ItemDefinition_get(var3 - 512).method4791(this.isFemale)) {
					var1 = true;
				}
			}

			if (var1) {
				return null;
			} else {
				ModelData[] var7 = new ModelData[12];
				var3 = 0;

				int var5;
				for (int var4 = 0; var4 < 12; ++var4) {
					var5 = this.equipment[var4];
					ModelData var6;
					if (var5 >= 256 && var5 < 512) {
						var6 = BufferedSource.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = class222.ItemDefinition_get(var5 - 512).method4792(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < field2520[var5].length) {
						var8.recolor(field2519[var5], field2520[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < class195.field2359[var5].length) {
						var8.recolor(class326.field3881[var5], class195.field2359[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2091261693"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + SecureRandomCallable.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "100440409"
	)
	@Export("currentTimeMillis")
	public static final synchronized long currentTimeMillis() {
		long var0 = System.currentTimeMillis();
		if (var0 < class296.field3684) {
			class296.field3683 += class296.field3684 - var0;
		}

		class296.field3684 = var0;
		return var0 + class296.field3683;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-994897132"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lhq;Ljava/lang/String;Ljava/lang/String;I)[Llw;",
		garbageValue = "-1961704142"
	)
	public static IndexedSprite[] method4160(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite[] var5;
		if (!class32.method618(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite[] var7 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

			for (int var8 = 0; var8 < class325.SpriteBuffer_spriteCount; ++var8) {
				IndexedSprite var9 = var7[var8] = new IndexedSprite();
				var9.width = class325.SpriteBuffer_spriteWidth;
				var9.height = class325.SpriteBuffer_spriteHeight;
				var9.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[var8];
				var9.yOffset = HealthBar.SpriteBuffer_yOffsets[var8];
				var9.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[var8];
				var9.subHeight = AttackOption.SpriteBuffer_spriteHeights[var8];
				var9.palette = class325.SpriteBuffer_spritePalette;
				var9.pixels = class325.SpriteBuffer_pixels[var8];
			}

			WorldMapData_1.method787();
			var5 = var7;
		}

		return var5;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "103"
	)
	public static void method4191(int var0) {
		if (var0 != -1) {
			if (class215.Widget_loadedInterfaces[var0]) {
				Coord.Widget_archive.clearFilesGroup(var0);
				if (Widget.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
						if (Widget.Widget_interfaceComponents[var0][var2] != null) {
							if (Widget.Widget_interfaceComponents[var0][var2].type != 2) {
								Widget.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						Widget.Widget_interfaceComponents[var0] = null;
					}

					class215.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ldj;B)V",
		garbageValue = "11"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}
}
