import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("rb")
	@ObfuscatedGetter(
		intValue = 68473183
	)
	static int field2549;
	@ObfuscatedName("l")
	public static short[][] field2545;
	@ObfuscatedName("j")
	public static short[] field2547;
	@ObfuscatedName("p")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("PlayerAppearance_cachedModels")
	public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("c")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("t")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("o")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 925869529
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -8371390842284104293L
	)
	@Export("hash")
	long hash;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = 5198838895924808709L
	)
	long field2544;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "-1314477676"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < CollisionMap.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = WorldMapSection2.KitDefinition_get(var6);
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
		garbageValue = "1565149766"
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
							var3 = CollisionMap.KitDefinition_fileCount - 1;
						}
					} else {
						++var3;
						if (var3 >= CollisionMap.KitDefinition_fileCount) {
							var3 = 0;
						}
					}

					var4 = WorldMapSection2.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var4.bodypartID != (this.isFemale ? 7 : 0) + var1);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "1120894554"
	)
	public void method4066(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = field2545[var1].length - 1;
				}
			} while(!FileSystem.method3572(var1, var3));
		} else {
			do {
				++var3;
				if (var3 >= field2545[var1].length) {
					var3 = 0;
				}
			} while(!FileSystem.method3572(var1, var3));
		}

		this.bodyColors[var1] = var3;
		this.setHash();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1200198186"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "2032757019"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-104"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.hash;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.hash = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.hash <<= 4;
			if (this.equipment[var5] >= 256) {
				this.hash += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.hash += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.hash += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.hash <<= 3;
			this.hash += (long)this.bodyColors[var5];
		}

		this.hash <<= 1;
		this.hash += (long)(this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (var1 != 0L && this.hash != var1) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lip;ILip;IB)Ldx;",
		garbageValue = "66"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return NetCache.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else {
			long var5 = this.hash;
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
					if (var11 >= 256 && var11 < 512 && !WorldMapSection2.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !HealthBarDefinition.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (this.field2544 != -1L) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2544);
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
							var14 = WorldMapSection2.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = HealthBarDefinition.ItemDefinition_get(var13 - 512).method4732(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var18 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < field2545[var13].length) {
							var18.recolor(WorldMapLabelSize.field128[var13], field2545[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < class208.field2514[var13].length) {
							var18.recolor(field2547[var13], class208.field2514[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var18.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2544 = var5;
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Ldg;",
		garbageValue = "1124292416"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return NetCache.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !WorldMapSection2.KitDefinition_get(var3 - 256).method4533()) {
					var1 = true;
				}

				if (var3 >= 512 && !HealthBarDefinition.ItemDefinition_get(var3 - 512).method4731(this.isFemale)) {
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
						var6 = WorldMapSection2.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = HealthBarDefinition.ItemDefinition_get(var5 - 512).method4741(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < field2545[var5].length) {
						var8.recolor(WorldMapLabelSize.field128[var5], field2545[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < class208.field2514[var5].length) {
						var8.recolor(field2547[var5], class208.field2514[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "34382709"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + NetCache.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-905088016"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}
}
