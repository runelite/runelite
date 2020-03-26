import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("hk")
@Implements("PlayerAppearance")
public class PlayerAppearance {
	@ObfuscatedName("t")
	public static short[] field2539;
	@ObfuscatedName("e")
	public static short[][] field2535;
	@ObfuscatedName("s")
	@Export("equipmentIndices")
	static final int[] equipmentIndices;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("PlayerAppearance_cachedModels")
	static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("x")
	@Export("equipment")
	int[] equipment;
	@ObfuscatedName("m")
	@Export("bodyColors")
	int[] bodyColors;
	@ObfuscatedName("k")
	@Export("isFemale")
	public boolean isFemale;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1293293343
	)
	@Export("npcTransformId")
	public int npcTransformId;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = 3080768602890783779L
	)
	@Export("hash")
	long hash;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = 1388997665214268647L
	)
	long field2538;

	static {
		equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
		PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "([I[IZII)V",
		garbageValue = "522059742"
	)
	@Export("update")
	public void update(int[] var1, int[] var2, boolean var3, int var4) {
		if (var1 == null) {
			var1 = new int[12];

			for (int var5 = 0; var5 < 7; ++var5) {
				for (int var6 = 0; var6 < KitDefinition.KitDefinition_fileCount; ++var6) {
					KitDefinition var7 = WorldMapElement.KitDefinition_get(var6);
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "1928193476"
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

					var4 = WorldMapElement.KitDefinition_get(var3);
				} while(var4 == null || var4.nonSelectable || var1 + (this.isFemale ? 7 : 0) != var4.bodypartID);

				this.equipment[equipmentIndices[var1]] = var3 + 256;
				this.setHash();
			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IZI)V",
		garbageValue = "-1053799565"
	)
	public void method4089(int var1, boolean var2) {
		int var3 = this.bodyColors[var1];
		boolean var4;
		if (!var2) {
			do {
				--var3;
				if (var3 < 0) {
					var3 = VertexNormal.field1764[var1].length - 1;
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
				if (var3 >= VertexNormal.field1764[var1].length) {
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1082412676"
	)
	@Export("changeSex")
	public void changeSex(boolean var1) {
		if (this.isFemale != var1) {
			this.update((int[])null, this.bodyColors, var1, -1);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1419902667"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "110"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljc;ILjc;II)Lel;",
		garbageValue = "-1571730911"
	)
	@Export("getModel")
	public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.npcTransformId != -1) {
			return class237.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
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
					if (var11 >= 256 && var11 < 512 && !WorldMapElement.KitDefinition_get(var11 - 256).ready()) {
						var9 = true;
					}

					if (var11 >= 512 && !AbstractWorldMapData.ItemDefinition_get(var11 - 512).hasNoValidModel(this.isFemale)) {
						var9 = true;
					}
				}

				if (var9) {
					if (this.field2538 != -1L) {
						var8 = (Model)PlayerAppearance_cachedModels.get(this.field2538);
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
							var14 = WorldMapElement.KitDefinition_get(var13 - 256).getModelData();
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}

						if (var13 >= 512) {
							var14 = AbstractWorldMapData.ItemDefinition_get(var13 - 512).method4722(this.isFemale);
							if (var14 != null) {
								var16[var11++] = var14;
							}
						}
					}

					ModelData var17 = new ModelData(var16, var11);

					for (var13 = 0; var13 < 5; ++var13) {
						if (this.bodyColors[var13] < VertexNormal.field1764[var13].length) {
							var17.recolor(WorldMapLabel.field278[var13], VertexNormal.field1764[var13][this.bodyColors[var13]]);
						}

						if (this.bodyColors[var13] < field2535[var13].length) {
							var17.recolor(field2539[var13], field2535[var13][this.bodyColors[var13]]);
						}
					}

					var8 = var17.toModel(64, 850, -30, -50, -30);
					PlayerAppearance_cachedModels.put(var8, var5);
					this.field2538 = var5;
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(S)Lea;",
		garbageValue = "180"
	)
	@Export("getModelData")
	ModelData getModelData() {
		if (this.npcTransformId != -1) {
			return class237.getNpcDefinition(this.npcTransformId).getModelData();
		} else {
			boolean var1 = false;

			int var3;
			for (int var2 = 0; var2 < 12; ++var2) {
				var3 = this.equipment[var2];
				if (var3 >= 256 && var3 < 512 && !WorldMapElement.KitDefinition_get(var3 - 256).method4523()) {
					var1 = true;
				}

				if (var3 >= 512 && !AbstractWorldMapData.ItemDefinition_get(var3 - 512).method4772(this.isFemale)) {
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
						var6 = WorldMapElement.KitDefinition_get(var5 - 256).getKitDefinitionModels();
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}

					if (var5 >= 512) {
						var6 = AbstractWorldMapData.ItemDefinition_get(var5 - 512).method4724(this.isFemale);
						if (var6 != null) {
							var7[var3++] = var6;
						}
					}
				}

				ModelData var8 = new ModelData(var7, var3);

				for (var5 = 0; var5 < 5; ++var5) {
					if (this.bodyColors[var5] < VertexNormal.field1764[var5].length) {
						var8.recolor(WorldMapLabel.field278[var5], VertexNormal.field1764[var5][this.bodyColors[var5]]);
					}

					if (this.bodyColors[var5] < field2535[var5].length) {
						var8.recolor(field2539[var5], field2535[var5][this.bodyColors[var5]]);
					}
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1778112126"
	)
	@Export("getChatHeadId")
	public int getChatHeadId() {
		return this.npcTransformId == -1 ? (this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20) : 305419896 + class237.getNpcDefinition(this.npcTransformId).id;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lbb;II)V",
		garbageValue = "2013269807"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (class25.isWorldMapEvent(var0.type)) {
			TileItem.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = class25.WorldMapElement_get(TileItem.worldMapEvent.mapElement);
			var3 = BoundaryObject.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = WorldMapSprite.getScript(var17);
		}

		if (var3 != null) {
			Interpreter.Interpreter_intStackSize = 0;
			Interpreter.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1125 = false;

			try {
				int var10;
				try {
					AbstractUserComparator.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					Interpreter.Interpreter_stringLocals = new String[var3.localStringCount];
					int var9 = 0;

					int var11;
					String var18;
					for (var10 = 1; var10 < var2.length; ++var10) {
						if (var2[var10] instanceof Integer) {
							var11 = (Integer)var2[var10];
							if (var11 == -2147483647) {
								var11 = var0.mouseX;
							}

							if (var11 == -2147483646) {
								var11 = var0.mouseY;
							}

							if (var11 == -2147483645) {
								var11 = var0.widget != null ? var0.widget.id * -1381479581 * -957641141 : -1;
							}

							if (var11 == -2147483644) {
								var11 = var0.opIndex;
							}

							if (var11 == -2147483643) {
								var11 = var0.widget != null ? var0.widget.childIndex * -611900971 * -547025027 : -1;
							}

							if (var11 == -2147483642) {
								var11 = var0.dragTarget != null ? var0.dragTarget.id * -1381479581 * -957641141 : -1;
							}

							if (var11 == -2147483641) {
								var11 = var0.dragTarget != null ? var0.dragTarget.childIndex * -611900971 * -547025027 : -1;
							}

							if (var11 == -2147483640) {
								var11 = var0.keyTyped;
							}

							if (var11 == -2147483639) {
								var11 = var0.keyPressed;
							}

							AbstractUserComparator.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							Interpreter.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1127 = var0.field604;

					while (true) {
						++var10;
						if (var10 > var1) {
							throw new RuntimeException();
						}

						++var17;
						int var29 = var5[var17];
						int var20;
						if (var29 >= 100) {
							boolean var32;
							if (var3.intOperands[var17] == 1) {
								var32 = true;
							} else {
								var32 = false;
							}

							var20 = class201.method3760(var29, var3, var32);
							switch(var20) {
							case 0:
								return;
							case 1:
							default:
								break;
							case 2:
								throw new IllegalStateException();
							}
						} else if (var29 == ScriptOpcodes.ICONST) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							class22.changeGameOptions(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.RETURN) {
							if (Interpreter.Interpreter_frameDepth == 0) {
								return;
							}

							ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
							var3 = var34.script;
							var5 = var3.opcodes;
							var6 = var3.intOperands;
							var17 = var34.pc;
							AbstractUserComparator.Interpreter_intLocals = var34.intLocals;
							Interpreter.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Projectile.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							FloorDecoration.method2952(var11, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractUserComparator.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							AbstractUserComparator.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							Interpreter.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							Interpreter.Interpreter_stringStackSize -= var11;
							String var31 = MusicPatchNode.method3921(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--Interpreter.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--Interpreter.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator4.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									UserComparator4.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var21 < 0 || var21 > 5000) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrayLengths[var11] = var21;
									byte var22 = -1;
									if (var20 == 105) {
										var22 = 0;
									}

									for (var15 = 0; var15 < var21; ++var15) {
										Interpreter.Interpreter_arrays[var11][var15] = var22;
									}
								} else if (var29 == ScriptOpcodes.GET_ARRAY_INT) {
									var11 = var6[var17];
									var20 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									Interpreter.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = UserComparator4.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									UserComparator4.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = UserComparator4.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									UserComparator4.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = WorldMapSprite.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (Interpreter.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (Interpreter.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								Interpreter.Interpreter_intStackSize -= var12.intArgumentCount;
								Interpreter.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = AbstractUserComparator.Interpreter_intLocals;
								var19.stringLocals = Interpreter.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								AbstractUserComparator.Interpreter_intLocals = var13;
								Interpreter.Interpreter_stringLocals = var14;
							}
						}
					}
				} catch (Exception var27) {
					StringBuilder var24 = new StringBuilder(30);
					var24.append("").append(var3.key).append(" ");

					for (var10 = Interpreter.Interpreter_frameDepth - 1; var10 >= 0; --var10) {
						var24.append("").append(Interpreter.Interpreter_frames[var10].script.key).append(" ");
					}

					var24.append("").append(var7);
					WorldMapDecorationType.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1125) {
					Interpreter.field1126 = true;
					class227.method4184();
					Interpreter.field1126 = false;
					Interpreter.field1125 = false;
				}

			}
		}
	}

	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-167013262"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		if (var0 == -3) {
			HealthBarUpdate.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			HealthBarUpdate.setLoginResponseString("Error connecting to server.", "Please try using a different world.", "");
		} else if (var0 == -1) {
			HealthBarUpdate.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1218 = 1;
		} else if (var0 == 4) {
			class39.method645(0);
		} else if (var0 == 5) {
			Login.field1218 = 2;
			HealthBarUpdate.setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			HealthBarUpdate.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			HealthBarUpdate.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			HealthBarUpdate.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			HealthBarUpdate.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			HealthBarUpdate.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			HealthBarUpdate.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			HealthBarUpdate.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			HealthBarUpdate.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			HealthBarUpdate.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			HealthBarUpdate.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			HealthBarUpdate.setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			class39.method645(1);
		} else if (var0 == 19) {
			HealthBarUpdate.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			HealthBarUpdate.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			HealthBarUpdate.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			HealthBarUpdate.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			HealthBarUpdate.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			HealthBarUpdate.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			HealthBarUpdate.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			HealthBarUpdate.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			HealthBarUpdate.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			HealthBarUpdate.setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			HealthBarUpdate.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			HealthBarUpdate.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				HealthBarUpdate.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				MouseRecorder.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				HealthBarUpdate.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				MouseRecorder.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				HealthBarUpdate.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		MouseRecorder.updateGameState(10);
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1233914639"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (InterfaceParent.clanChat != null) {
			PacketBufferNode var1 = FaceNormal.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class234.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
