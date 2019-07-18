import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("m")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("PlayerAppearance_cachedModels")
	public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("q")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("w")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("e")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1885708295
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = 7554937625342068879L
	)
	long field2539;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 8463042946937370987L
	)
	long field2537;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "646936980"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = ArchiveDiskAction.getKitDefinition(var6);
					if (var7 != null && !var7.nonSelectable && var7.bodypartID == var5 + (var3 ? 7 : 0)) {
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IZS)V",
		garbageValue = "7431"
	)
	public void method3992(int var1, boolean var2) {
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

					var4 = ArchiveDiskAction.getKitDefinition(var3);
				} while(var4 == null || var4.nonSelectable || var4.bodypartID != (this.isFemale ? 7 : 0) + var1);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "1"
	)
	public void method3993(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = class247.field3291[var1].length - 1;
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
				if (var3 >= class247.field3291[var1].length) {
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1889308905"
	)
	public void method4006(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "318518244"
	)
	public void method3995(Buffer var1) {
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
		garbageValue = "-642872346"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.field2539;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.field2539 = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.field2539 <<= 4;
			if (this.equipment[var5] >= 256) {
				this.field2539 += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.field2539 += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.field2539 += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.field2539 <<= 3;
			this.field2539 += (long)this.bodyColors[var5];
		}

		this.field2539 <<= 1;
		this.field2539 += (long)(this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (0L != var1 && var1 != this.field2539) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lis;ILis;IB)Ldm;",
		garbageValue = "-15"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return GameShell.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else {
			long var5 = this.field2539;
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
					if (var11 >= 256 && var11 < 512 && !ArchiveDiskAction.getKitDefinition(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !WorldMapArea.getItemDefinition(var11 - 512).method4646(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (-1L != this.field2537) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2537);
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
							var14 = ArchiveDiskAction.getKitDefinition(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = WorldMapArea.getItemDefinition(var13 - 512).method4694(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var17 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < class247.field3291[var13].length) {
							var17.recolor(ModelData0.field1870[var13], class247.field3291[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < Message.field604[var13].length) {
							var17.recolor(WorldMapCacheName.field309[var13], Message.field604[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var17.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2537 = var5;
				}
			}

			if (var1 == null && var3 == null) {
				return var8;
			} else {
				Model var18;
				if (var1 != null && var3 != null) {
					var18 = var1.applyTransformations(var8, var2, var3, var4);
				} else if (var1 != null) {
					var18 = var1.transformActorModel(var8, var2);
				} else {
					var18 = var3.transformActorModel(var8, var4);
				}

				return var18;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lds;",
		garbageValue = "-1659019882"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return GameShell.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !ArchiveDiskAction.getKitDefinition(var3 - 256).method4445()) {
					var1 = true;
				}

				if (var3 >= 512 && !WorldMapArea.getItemDefinition(var3 - 512).method4683(this.isFemale)) {
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
						var6 = ArchiveDiskAction.getKitDefinition(var5 - 256).method4441();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = WorldMapArea.getItemDefinition(var5 - 512).method4649(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < class247.field3291[var5].length) {
						var8.recolor(ModelData0.field1870[var5], class247.field3291[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < Message.field604[var5].length) {
						var8.recolor(WorldMapCacheName.field309[var5], Message.field604[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1943102032"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + GameShell.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhp;II)Z",
		garbageValue = "-435811450"
	)
	@Export("SpriteBuffer_loadSpriteFlat")
	public static boolean SpriteBuffer_loadSpriteFlat(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			class185.SpriteBuffer_decode(var2);
			return true;
		}
	}
}
