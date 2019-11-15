import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("NPCDefinition")
public class NPCDefinition extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("NpcDefinition_archive")
	static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("NpcDefinition_modelArchive")
	static AbstractArchive NpcDefinition_modelArchive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("NpcDefinition_cached")
	public static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("NpcDefinition_cachedModels")
	public static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1672011881
	)
	@Export("id")
	public int id;
	@ObfuscatedName("l")
	@Export("name")
	public String name;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -974449841
	)
	@Export("size")
	public int size;
	@ObfuscatedName("o")
	@Export("models")
	int[] models;
	@ObfuscatedName("i")
	int[] field3476;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1219183499
	)
	@Export("readySequence")
	public int readySequence;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 898691697
	)
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -125318447
	)
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 638028449
	)
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 645048551
	)
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1214563023
	)
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1718781665
	)
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("r")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("e")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("s")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("b")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("z")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("f")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1902455939
	)
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -177695131
	)
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1085992245
	)
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("y")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1272817411
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -430923911
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -222453249
	)
	@Export("headIconPrayer")
	public int headIconPrayer;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1317382483
	)
	@Export("rotation")
	public int rotation;
	@ObfuscatedName("ad")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1215151999
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1120874317
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("av")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("am")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("ab")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "Llr;"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1100218543"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-942023250"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "1669409378"
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
			this.field3476 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3476[var4] = var1.readUnsignedShort();
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
			this.contrast = var1.readByte() * 5;
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
				this.params = UserComparator10.readStringIntParameters(var1, this.params);
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
		signature = "(Liv;ILiv;II)Ldv;",
		garbageValue = "445516226"
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

				var5 = var11.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Ldu;",
		garbageValue = "4"
	)
	@Export("getModelData")
	public final ModelData getModelData() {
		if (this.transforms != null) {
			NPCDefinition var1 = this.transform();
			return var1 == null ? null : var1.getModelData();
		} else if (this.field3476 == null) {
			return null;
		} else {
			boolean var5 = false;

			for (int var2 = 0; var2 < this.field3476.length; ++var2) {
				if (!NpcDefinition_modelArchive.tryLoadFile(this.field3476[var2], 0)) {
					var5 = true;
				}
			}

			if (var5) {
				return null;
			} else {
				ModelData[] var6 = new ModelData[this.field3476.length];

				for (int var3 = 0; var3 < this.field3476.length; ++var3) {
					var6[var3] = ModelData.ModelData_get(NpcDefinition_modelArchive, this.field3476[var3], 0);
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)Lit;",
		garbageValue = "73"
	)
	@Export("transform")
	public final NPCDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = UserComparator9.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? SecureRandomCallable.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "101"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = UserComparator9.getVarbit(this.transformVarbit);
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-955776181"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return FriendsList.method5306(this.params, var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-81"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		IterableNodeHashTable var4 = this.params;
		String var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			ObjectNode var5 = (ObjectNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = (String)var5.obj;
			}
		}

		return var3;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Lkt;",
		garbageValue = "287929847"
	)
	public static PrivateChatMode method4881(int var0) {
		PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field3778, PrivateChatMode.field3782, PrivateChatMode.field3779};
		PrivateChatMode[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			PrivateChatMode var4 = var2[var3];
			if (var0 == var4.field3781) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-2"
	)
	public static void method4880() {
		if (MouseHandler.MouseHandler_instance != null) {
			synchronized(MouseHandler.MouseHandler_instance) {
				MouseHandler.MouseHandler_instance = null;
			}
		}

	}
}
