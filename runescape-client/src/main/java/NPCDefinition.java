import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("NPCDefinition")
public class NPCDefinition extends DualNode {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("NpcDefinition_archive")
	public static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("NpcDefinition_modelArchive")
	public static AbstractArchive NpcDefinition_modelArchive;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("NpcDefinition_cached")
	static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("NpcDefinition_cachedModels")
	static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1437394053
	)
	@Export("id")
	public int id;
	@ObfuscatedName("b")
	@Export("name")
	public String name;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1272907781
	)
	@Export("size")
	public int size;
	@ObfuscatedName("x")
	@Export("models")
	int[] models;
	@ObfuscatedName("a")
	int[] field3436;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -643490475
	)
	@Export("readySequence")
	public int readySequence;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1453036441
	)
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1313837071
	)
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -2006817371
	)
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 868075509
	)
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1582057393
	)
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1584002895
	)
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("t")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("j")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("n")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("u")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("z")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("h")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1760974573
	)
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -674853701
	)
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2021062483
	)
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("q")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -2035323497
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 577893051
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1527639479
	)
	@Export("headIconPrayer")
	public int headIconPrayer;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1588998257
	)
	@Export("rotation")
	public int rotation;
	@ObfuscatedName("ak")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -1212272583
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 529914747
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("aq")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("ao")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("an")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "Llc;"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1780745030"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "643365222"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "731646474"
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
			this.field3436 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3436[var4] = var1.readUnsignedShort();
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
				this.params = Calendar.readStringIntParameters(var1, this.params);
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Liv;ILiv;IB)Ldw;",
		garbageValue = "3"
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)Ldd;",
		garbageValue = "-58"
	)
	@Export("getModelData")
	public final ModelData getModelData() {
		if (this.transforms != null) {
			NPCDefinition var1 = this.transform();
			return var1 == null ? null : var1.getModelData();
		} else if (this.field3436 == null) {
			return null;
		} else {
			boolean var5 = false;

			for (int var2 = 0; var2 < this.field3436.length; ++var2) {
				if (!NpcDefinition_modelArchive.tryLoadFile(this.field3436[var2], 0)) {
					var5 = true;
				}
			}

			if (var5) {
				return null;
			} else {
				ModelData[] var6 = new ModelData[this.field3436.length];

				for (int var3 = 0; var3 < this.field3436.length; ++var3) {
					var6[var3] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.field3436[var3], 0);
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Liw;",
		garbageValue = "47"
	)
	@Export("transform")
	public final NPCDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GameShell.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? AbstractUserComparator.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-251479822"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = GameShell.getVarbit(this.transformVarbit);
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1643903914"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class83.method2071(this.params, var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1559227627"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class14.method151(this.params, var1, var2);
	}
}
