import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("iz")
@Implements("NPCDefinition")
public class NPCDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("NpcDefinition_archive")
	public static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("NpcDefinition_modelArchive")
	public static AbstractArchive NpcDefinition_modelArchive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("NpcDefinition_cached")
	public static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("NpcDefinition_cachedModels")
	public static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1707921153
	)
	@Export("id")
	public int id;
	@ObfuscatedName("g")
	@Export("name")
	public String name;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1764786613
	)
	@Export("size")
	public int size;
	@ObfuscatedName("l")
	@Export("models")
	int[] models;
	@ObfuscatedName("j")
	int[] field3467;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1040050113
	)
	@Export("readySequence")
	public int readySequence;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -710216927
	)
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -188091011
	)
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -987219047
	)
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -444402749
	)
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1834649411
	)
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 703794891
	)
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("k")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("q")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("z")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("y")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("f")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("b")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1620337361
	)
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 629834407
	)
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -867665195
	)
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("u")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1609629677
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 56751531
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1994920091
	)
	@Export("headIconPrayer")
	public int headIconPrayer;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -247642311
	)
	@Export("rotation")
	public int rotation;
	@ObfuscatedName("aj")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1674933673
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -912879563
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("aa")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("aq")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("as")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		NpcDefinition_cached = new EvictingDualNodeHashTable(64);
		NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
	}

	NPCDefinition() {
		this.name = "null";
		this.size = 1;
		this.readySequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.actions = new String[5];
		this.drawMapDot = true;
		this.combatLevel = -1;
		this.widthScale = 128;
		this.heightScale = 128;
		this.isVisible = false;
		this.ambient = 0;
		this.contrast = 0;
		this.headIconPrayer = -1;
		this.rotation = 32;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.isInteractable = true;
		this.isClickable = true;
		this.isFollower = false;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "37"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "44812768"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IB)V",
		garbageValue = "-38"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedByte();
			this.models = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.models[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 12) {
			this.size = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.readySequence = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.walkSequence = var1.readUnsignedShort();
		} else if (var2 == 15) {
			this.turnLeftSequence = var1.readUnsignedShort();
		} else if (var2 == 16) {
			this.turnRightSequence = var1.readUnsignedShort();
		} else if (var2 == 17) {
			this.walkSequence = var1.readUnsignedShort();
			this.walkBackSequence = var1.readUnsignedShort();
			this.walkLeftSequence = var1.readUnsignedShort();
			this.walkRightSequence = var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
			if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.actions[var2 - 30] = null;
			}
		} else if (var2 == 40) {
			var3 = var1.readUnsignedByte();
			this.recolorFrom = new short[var3];
			this.recolorTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.recolorFrom[var4] = (short)var1.readUnsignedShort();
				this.recolorTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 41) {
			var3 = var1.readUnsignedByte();
			this.retextureFrom = new short[var3];
			this.retextureTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.retextureFrom[var4] = (short)var1.readUnsignedShort();
				this.retextureTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 60) {
			var3 = var1.readUnsignedByte();
			this.field3467 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3467[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 93) {
			this.drawMapDot = false;
		} else if (var2 == 95) {
			this.combatLevel = var1.readUnsignedShort();
		} else if (var2 == 97) {
			this.widthScale = var1.readUnsignedShort();
		} else if (var2 == 98) {
			this.heightScale = var1.readUnsignedShort();
		} else if (var2 == 99) {
			this.isVisible = true;
		} else if (var2 == 100) {
			this.ambient = var1.readByte();
		} else if (var2 == 101) {
			this.contrast = var1.readByte();
		} else if (var2 == 102) {
			this.headIconPrayer = var1.readUnsignedShort();
		} else if (var2 == 103) {
			this.rotation = var1.readUnsignedShort();
		} else if (var2 != 106 && var2 != 118) {
			if (var2 == 107) {
				this.isInteractable = false;
			} else if (var2 == 109) {
				this.isClickable = false;
			} else if (var2 == 111) {
				this.isFollower = true;
			} else if (var2 == 249) {
				this.params = MouseRecorder.readStringIntParameters(var1, this.params);
			}
		} else {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 65535) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 65535) {
				this.transformVarp = -1;
			}

			var3 = -1;
			if (var2 == 118) {
				var3 = var1.readUnsignedShort();
				if (var3 == 65535) {
					var3 = -1;
				}
			}

			var4 = var1.readUnsignedByte();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.readUnsignedShort();
				if (this.transforms[var5] == 65535) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lip;ILip;IB)Ldx;",
		garbageValue = "-1"
	)
	@Export("getModel")
	public final Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
		if (this.transforms != null) {
			NPCDefinition var12 = this.transform();
			return var12 == null ? null : var12.getModel(var1, var2, var3, var4);
		} else {
			Model var5 = (Model)NpcDefinition_cachedModels.get((long)this.id);
			if (var5 == null) {
				boolean var6 = false;

				for (int var7 = 0; var7 < this.models.length; ++var7) {
					if (!NpcDefinition_modelArchive.tryLoadFile(this.models[var7], 0)) {
						var6 = true;
					}
				}

				if (var6) {
					return null;
				}

				ModelData[] var8 = new ModelData[this.models.length];

				int var9;
				for (var9 = 0; var9 < this.models.length; ++var9) {
					var8[var9] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.models[var9], 0);
				}

				ModelData var11;
				if (var8.length == 1) {
					var11 = var8[0];
				} else {
					var11 = new ModelData(var8, var8.length);
				}

				if (this.recolorFrom != null) {
					for (var9 = 0; var9 < this.recolorFrom.length; ++var9) {
						var11.recolor(this.recolorFrom[var9], this.recolorTo[var9]);
					}
				}

				if (this.retextureFrom != null) {
					for (var9 = 0; var9 < this.retextureFrom.length; ++var9) {
						var11.retexture(this.retextureFrom[var9], this.retextureTo[var9]);
					}
				}

				var5 = var11.toModel(this.ambient + 64, this.contrast * 5 + 850, -30, -50, -30);
				NpcDefinition_cachedModels.put(var5, (long)this.id);
			}

			Model var10;
			if (var1 != null && var3 != null) {
				var10 = var1.applyTransformations(var5, var2, var3, var4);
			} else if (var1 != null) {
				var10 = var1.transformActorModel(var5, var2);
			} else if (var3 != null) {
				var10 = var3.transformActorModel(var5, var4);
			} else {
				var10 = var5.toSharedSequenceModel(true);
			}

			if (this.widthScale != 128 || this.heightScale != 128) {
				var10.scale(this.widthScale, this.heightScale, this.widthScale);
			}

			return var10;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)Ldg;",
		garbageValue = "1870202783"
	)
	@Export("getModelData")
	public final ModelData getModelData() {
		if (this.transforms != null) {
			NPCDefinition var1 = this.transform();
			return var1 == null ? null : var1.getModelData();
		} else if (this.field3467 == null) {
			return null;
		} else {
			boolean var5 = false;

			for (int var2 = 0; var2 < this.field3467.length; ++var2) {
				if (!NpcDefinition_modelArchive.tryLoadFile(this.field3467[var2], 0)) {
					var5 = true;
				}
			}

			if (var5) {
				return null;
			} else {
				ModelData[] var6 = new ModelData[this.field3467.length];

				for (int var3 = 0; var3 < this.field3467.length; ++var3) {
					var6[var3] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.field3467[var3], 0);
				}

				ModelData var7;
				if (var6.length == 1) {
					var7 = var6[0];
				} else {
					var7 = new ModelData(var6, var6.length);
				}

				int var4;
				if (this.recolorFrom != null) {
					for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
						var7.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
					}
				}

				if (this.retextureFrom != null) {
					for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
						var7.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
					}
				}

				return var7;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Liz;",
		garbageValue = "38"
	)
	@Export("transform")
	public final NPCDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GrandExchangeOfferUnitPriceComparator.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? NetCache.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "780898227"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = GrandExchangeOfferUnitPriceComparator.getVarbit(this.transformVarbit);
			} else if (this.transformVarp != -1) {
				var1 = Varps.Varps_main[this.transformVarp];
			}

			if (var1 >= 0 && var1 < this.transforms.length) {
				return this.transforms[var1] != -1;
			} else {
				return this.transforms[this.transforms.length - 1] != -1;
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-2108676246"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class185.method3686(this.params, var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "2127208203"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return FloorDecoration.method2914(this.params, var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "879039654"
	)
	static int method4818(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class186.field2331 : MidiPcmStream.field2444;
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		signature = "(Lhn;I)V",
		garbageValue = "285871086"
	)
	@Export("invalidateWidget")
	static void invalidateWidget(Widget var0) {
		if (var0.cycle == Client.field850) {
			Client.field851[var0.rootIndex] = true;
		}

	}
}
