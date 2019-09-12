import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hl")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("v")
	public static short[][] field2508;
	@ObfuscatedName("d")
	public static short[] field2513;
	@ObfuscatedName("z")
	public static short[][] field2511;
	@ObfuscatedName("n")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("PlayerAppearance_cachedModels")
	public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("c")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("x")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("t")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1955539513
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = -768101756987274503L
	)
	long field2510;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 270376904250557193L
	)
	long field2512;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "128903597"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = class195.KitDefinition_get(var6);
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IZB)V",
		garbageValue = "0"
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

					var4 = class195.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var1 + (this.isFemale ? 7 : 0) != var4.bodypartID);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IZS)V",
		garbageValue = "32089"
	)
	public void method3983(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = field2508[var1].length - 1;
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
				if (var3 >= field2508[var1].length) {
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-80"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1762621259"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1290527854"
	)
	@Export("setHash")
	void setHash() {
		long var1 = this.field2510;
		int var3 = this.equipment[5];
		int var4 = this.equipment[9];
		this.equipment[5] = var4;
		this.equipment[9] = var3;
		this.field2510 = 0L;

		int var5;
		for (var5 = 0; var5 < 12; ++var5) {
			this.field2510 <<= 4;
			if (this.equipment[var5] >= 256) {
				this.field2510 += (long)(this.equipment[var5] - 256);
			}
		}

		if (this.equipment[0] >= 256) {
			this.field2510 += (long)(this.equipment[0] - 256 >> 4);
		}

		if (this.equipment[1] >= 256) {
			this.field2510 += (long)(this.equipment[1] - 256 >> 8);
		}

		for (var5 = 0; var5 < 5; ++var5) {
			this.field2510 <<= 3;
			this.field2510 += (long)this.bodyColors[var5];
		}

		this.field2510 <<= 1;
		this.field2510 += (long)(this.isFemale ? 1 : 0);
		this.equipment[5] = var3;
		this.equipment[9] = var4;
		if (0L != var1 && var1 != this.field2510) {
			PlayerAppearance_cachedModels.remove(var1);
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Liw;ILiw;II)Ldr;",
		garbageValue = "-1695778045"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return FontName.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
		} else {
			long var5 = this.field2510;
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
					if (var11 >= 256 && var11 < 512 && !class195.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !Player.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (this.field2512 != -1L) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2512);
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
							var14 = class195.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = Player.ItemDefinition_get(var13 - 512).method4657(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var18 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < field2508[var13].length) {
							var18.recolor(UserComparator8.field1944[var13], field2508[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < field2511[var13].length) {
							var18.recolor(field2513[var13], field2511[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var18.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2512 = var5;
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Lds;",
		garbageValue = "-383729873"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return FontName.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !class195.KitDefinition_get(var3 - 256).method4457()) {
					var1 = true;
				}

				if (var3 >= 512 && !Player.ItemDefinition_get(var3 - 512).method4665(this.isFemale)) {
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
						var6 = class195.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = Player.ItemDefinition_get(var5 - 512).method4659(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < field2508[var5].length) {
						var8.recolor(UserComparator8.field1944[var5], field2508[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < field2511[var5].length) {
						var8.recolor(field2513[var5], field2511[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-860762506"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + FontName.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lhx;",
		garbageValue = "-850307584"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_ironman, PlayerType.PlayerType_ultimateIronman, PlayerType.PlayerType_hardcoreIronman, PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_normal};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIS)Lcu;",
		garbageValue = "4204"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var6 = (Script)Script.Script_cached.get((long)(var3 << 16));
		Script var5;
		if (var6 != null) {
			var5 = var6;
		} else {
			String var7 = String.valueOf(var3);
			int var8 = Message.archive12.getGroupId(var7);
			if (var8 == -1) {
				var5 = null;
			} else {
				label56: {
					byte[] var9 = Message.archive12.takeFileFlat(var8);
					if (var9 != null) {
						if (var9.length <= 1) {
							var5 = null;
							break label56;
						}

						var6 = AttackOption.newScript(var9);
						if (var6 != null) {
							Script.Script_cached.put(var6, (long)(var3 << 16));
							var5 = var6;
							break label56;
						}
					}

					var5 = null;
				}
			}
		}

		if (var5 != null) {
			return var5;
		} else {
			int var13 = (var2 + 40000 << 8) + var0;
			Script var15 = (Script)Script.Script_cached.get((long)(var13 << 16));
			Script var14;
			if (var15 != null) {
				var14 = var15;
			} else {
				String var10 = String.valueOf(var13);
				int var11 = Message.archive12.getGroupId(var10);
				if (var11 == -1) {
					var14 = null;
				} else {
					byte[] var12 = Message.archive12.takeFileFlat(var11);
					if (var12 != null) {
						if (var12.length <= 1) {
							var14 = null;
							return var14 != null ? var14 : null;
						}

						var15 = AttackOption.newScript(var12);
						if (var15 != null) {
							Script.Script_cached.put(var15, (long)(var13 << 16));
							var14 = var15;
							return var14 != null ? var14 : null;
						}
					}

					var14 = null;
				}
			}

			return var14 != null ? var14 : null;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "909717024"
	)
	static int method3990(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else {
			return 2;
		}
	}
}
