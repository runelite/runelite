import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("NPCDefinition")
public class NPCDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("NpcDefinition_archive")
	static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("NpcDefinition_modelArchive")
	static AbstractArchive NpcDefinition_modelArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("NpcDefinition_cached")
	static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("NpcDefinition_cachedModels")
	static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive7")
	static Archive archive7;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2095411363
	)
	@Export("id")
	public int id;
	@ObfuscatedName("l")
	@Export("name")
	public String name;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 182085113
	)
	@Export("size")
	public int size;
	@ObfuscatedName("i")
	@Export("models")
	int[] models;
	@ObfuscatedName("c")
	int[] field3463;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -530997781
	)
	@Export("readySequence")
	public int readySequence;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1697646117
	)
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -225693269
	)
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -480719565
	)
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -527626491
	)
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1672595499
	)
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -389638615
	)
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("g")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("a")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("j")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("t")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("h")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("o")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -785647373
	)
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1029052063
	)
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 409024439
	)
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("z")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1025761835
	)
	int field3489;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -704573687
	)
	int field3477;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -958294189
	)
	@Export("headIconPrayer")
	public int headIconPrayer;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 648485331
	)
	public int field3492;
	@ObfuscatedName("ad")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 971935579
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -375353725
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("ax")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("az")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("ae")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "Lla;"
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
		this.field3489 = 0;
		this.field3477 = 0;
		this.headIconPrayer = -1;
		this.field3492 = 32;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.isInteractable = true;
		this.isClickable = true;
		this.isFollower = false;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-169621084"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1547887563"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "-24"
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
			this.field3463 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3463[var4] = var1.readUnsignedShort();
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
			this.field3489 = var1.readByte();
		} else if (var2 == 101) {
			this.field3477 = var1.readByte() * 5;
		} else if (var2 == 102) {
			this.headIconPrayer = var1.readUnsignedShort();
		} else if (var2 == 103) {
			this.field3492 = var1.readUnsignedShort();
		} else if (var2 != 106 && var2 != 118) {
			if (var2 == 107) {
				this.isInteractable = false;
			} else if (var2 == 109) {
				this.isClickable = false;
			} else if (var2 == 111) {
				this.isFollower = true;
			} else if (var2 == 249) {
				this.params = WorldMapArea.readStringIntParameters(var1, this.params);
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lis;ILis;IB)Ldm;",
		garbageValue = "27"
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
					var8[var9] = ModelData.method2769(NpcDefinition_modelArchive, this.models[var9], 0);
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

				var5 = var11.toModel(this.field3489 + 64, this.field3477 + 850, -30, -50, -30);
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
		signature = "(B)Lds;",
		garbageValue = "87"
	)
	@Export("getModelData")
	public final ModelData getModelData() {
		if (this.transforms != null) {
			NPCDefinition var1 = this.transform();
			return var1 == null ? null : var1.getModelData();
		} else if (this.field3463 == null) {
			return null;
		} else {
			boolean var5 = false;

			for (int var2 = 0; var2 < this.field3463.length; ++var2) {
				if (!NpcDefinition_modelArchive.tryLoadFile(this.field3463[var2], 0)) {
					var5 = true;
				}
			}

			if (var5) {
				return null;
			} else {
				ModelData[] var6 = new ModelData[this.field3463.length];

				for (int var3 = 0; var3 < this.field3463.length; ++var3) {
					var6[var3] = ModelData.method2769(NpcDefinition_modelArchive, this.field3463[var3], 0);
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lij;",
		garbageValue = "942859640"
	)
	@Export("transform")
	public final NPCDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = GrandExchangeOfferOwnWorldComparator.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? GameShell.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-119"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = GrandExchangeOfferOwnWorldComparator.getVarbit(this.transformVarbit);
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-696362374"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		IterableNodeHashTable var4 = this.params;
		int var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			IntegerNode var5 = (IntegerNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = var5.integer;
			}
		}

		return var3;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-1901190491"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return GrandExchangeOfferWorldComparator.method54(this.params, var1, var2);
	}
}
