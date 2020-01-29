import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("ItemDefinition")
public class ItemDefinition extends DualNode {
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("ItemDefinition_archive")
	public static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("ItemDefinition_modelArchive")
	public static AbstractArchive ItemDefinition_modelArchive;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1524909813
	)
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("ItemDefinition_cached")
	public static EvictingDualNodeHashTable ItemDefinition_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("ItemDefinition_cachedModels")
	public static EvictingDualNodeHashTable ItemDefinition_cachedModels;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("ItemDefinition_cachedSprites")
	public static EvictingDualNodeHashTable ItemDefinition_cachedSprites;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("ItemDefinition_fontPlain11")
	public static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -536446943
	)
	@Export("id")
	public int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -406504769
	)
	@Export("model")
	int model;
	@ObfuscatedName("w")
	@Export("name")
	public String name;
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
	@ObfuscatedGetter(
		intValue = 2019539597
	)
	@Export("zoom2d")
	public int zoom2d;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1726268201
	)
	@Export("xan2d")
	public int xan2d;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 93819839
	)
	@Export("yan2d")
	public int yan2d;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 2090410293
	)
	@Export("zan2d")
	public int zan2d;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 205349077
	)
	@Export("offsetX2d")
	public int offsetX2d;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -178910167
	)
	@Export("offsetY2d")
	public int offsetY2d;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1045591487
	)
	@Export("isStackable")
	public int isStackable;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 335051861
	)
	@Export("price")
	public int price;
	@ObfuscatedName("az")
	@Export("isMembersOnly")
	public boolean isMembersOnly;
	@ObfuscatedName("ax")
	@Export("groundActions")
	public String[] groundActions;
	@ObfuscatedName("aj")
	@Export("inventoryActions")
	public String[] inventoryActions;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1996888449
	)
	@Export("shiftClickIndex")
	int shiftClickIndex;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -665766999
	)
	@Export("maleModel")
	int maleModel;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1666037601
	)
	@Export("maleModel1")
	int maleModel1;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 1212173465
	)
	@Export("maleOffset")
	int maleOffset;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1350778211
	)
	@Export("femaleModel")
	int femaleModel;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = 1772230311
	)
	@Export("femaleModel1")
	int femaleModel1;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1256641587
	)
	@Export("femaleOffset")
	int femaleOffset;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -1552928441
	)
	@Export("maleModel2")
	int maleModel2;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 2068450997
	)
	@Export("femaleModel2")
	int femaleModel2;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -1141752707
	)
	@Export("maleHeadModel")
	int maleHeadModel;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -659175095
	)
	@Export("maleHeadModel2")
	int maleHeadModel2;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = -1827024377
	)
	@Export("femaleHeadModel")
	int femaleHeadModel;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1593898643
	)
	@Export("femaleHeadModel2")
	int femaleHeadModel2;
	@ObfuscatedName("at")
	@Export("countobj")
	int[] countobj;
	@ObfuscatedName("an")
	@Export("countco")
	int[] countco;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1326162955
	)
	@Export("note")
	public int note;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1734525481
	)
	@Export("noteTemplate")
	public int noteTemplate;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 978982797
	)
	@Export("resizeX")
	int resizeX;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 4324563
	)
	@Export("resizeY")
	int resizeY;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 232741831
	)
	@Export("resizeZ")
	int resizeZ;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = -916763617
	)
	@Export("ambient")
	public int ambient;
	@ObfuscatedName("bf")
	@ObfuscatedGetter(
		intValue = 1642665557
	)
	@Export("contrast")
	public int contrast;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1763887503
	)
	@Export("team")
	public int team;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("params")
	IterableNodeHashTable params;
	@ObfuscatedName("bb")
	@Export("isTradable")
	public boolean isTradable;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = -1331779555
	)
	@Export("unnotedId")
	int unnotedId;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		intValue = 1529334619
	)
	@Export("notedId")
	int notedId;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		intValue = 1795625835
	)
	@Export("placeholder")
	public int placeholder;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -1321250167
	)
	@Export("placeholderTemplate")
	public int placeholderTemplate;

	static {
		ItemDefinition_cached = new EvictingDualNodeHashTable(64);
		ItemDefinition_cachedModels = new EvictingDualNodeHashTable(50);
		ItemDefinition_cachedSprites = new EvictingDualNodeHashTable(200);
	}

	ItemDefinition() {
		this.name = "null";
		this.zoom2d = 2000;
		this.xan2d = 0;
		this.yan2d = 0;
		this.zan2d = 0;
		this.offsetX2d = 0;
		this.offsetY2d = 0;
		this.isStackable = 0;
		this.price = 1;
		this.isMembersOnly = false;
		this.groundActions = new String[]{null, null, "Take", null, null};
		this.inventoryActions = new String[]{null, null, null, null, "Drop"};
		this.shiftClickIndex = -2;
		this.maleModel = -1;
		this.maleModel1 = -1;
		this.maleOffset = 0;
		this.femaleModel = -1;
		this.femaleModel1 = -1;
		this.femaleOffset = 0;
		this.maleModel2 = -1;
		this.femaleModel2 = -1;
		this.maleHeadModel = -1;
		this.maleHeadModel2 = -1;
		this.femaleHeadModel = -1;
		this.femaleHeadModel2 = -1;
		this.note = -1;
		this.noteTemplate = -1;
		this.resizeX = 128;
		this.resizeY = 128;
		this.resizeZ = 128;
		this.ambient = 0;
		this.contrast = 0;
		this.team = 0;
		this.isTradable = false;
		this.unnotedId = -1;
		this.notedId = -1;
		this.placeholder = -1;
		this.placeholderTemplate = -1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1252611790"
	)
	@Export("post")
	void post() {
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "-72"
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
		garbageValue = "24"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.model = var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.zoom2d = var1.readUnsignedShort();
		} else if (var2 == 5) {
			this.xan2d = var1.readUnsignedShort();
		} else if (var2 == 6) {
			this.yan2d = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.offsetX2d = var1.readUnsignedShort();
			if (this.offsetX2d > 32767) {
				this.offsetX2d -= 65536;
			}
		} else if (var2 == 8) {
			this.offsetY2d = var1.readUnsignedShort();
			if (this.offsetY2d > 32767) {
				this.offsetY2d -= 65536;
			}
		} else if (var2 == 11) {
			this.isStackable = 1;
		} else if (var2 == 12) {
			this.price = var1.readInt();
		} else if (var2 == 16) {
			this.isMembersOnly = true;
		} else if (var2 == 23) {
			this.maleModel = var1.readUnsignedShort();
			this.maleOffset = var1.readUnsignedByte();
		} else if (var2 == 24) {
			this.maleModel1 = var1.readUnsignedShort();
		} else if (var2 == 25) {
			this.femaleModel = var1.readUnsignedShort();
			this.femaleOffset = var1.readUnsignedByte();
		} else if (var2 == 26) {
			this.femaleModel1 = var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.groundActions[var2 - 30] = var1.readStringCp1252NullTerminated();
			if (this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.groundActions[var2 - 30] = null;
			}
		} else if (var2 >= 35 && var2 < 40) {
			this.inventoryActions[var2 - 35] = var1.readStringCp1252NullTerminated();
		} else {
			int var3;
			int var4;
			if (var2 == 40) {
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
			} else if (var2 == 42) {
				this.shiftClickIndex = var1.readByte();
			} else if (var2 == 65) {
				this.isTradable = true;
			} else if (var2 == 78) {
				this.maleModel2 = var1.readUnsignedShort();
			} else if (var2 == 79) {
				this.femaleModel2 = var1.readUnsignedShort();
			} else if (var2 == 90) {
				this.maleHeadModel = var1.readUnsignedShort();
			} else if (var2 == 91) {
				this.femaleHeadModel = var1.readUnsignedShort();
			} else if (var2 == 92) {
				this.maleHeadModel2 = var1.readUnsignedShort();
			} else if (var2 == 93) {
				this.femaleHeadModel2 = var1.readUnsignedShort();
			} else if (var2 == 95) {
				this.zan2d = var1.readUnsignedShort();
			} else if (var2 == 97) {
				this.note = var1.readUnsignedShort();
			} else if (var2 == 98) {
				this.noteTemplate = var1.readUnsignedShort();
			} else if (var2 >= 100 && var2 < 110) {
				if (this.countobj == null) {
					this.countobj = new int[10];
					this.countco = new int[10];
				}

				this.countobj[var2 - 100] = var1.readUnsignedShort();
				this.countco[var2 - 100] = var1.readUnsignedShort();
			} else if (var2 == 110) {
				this.resizeX = var1.readUnsignedShort();
			} else if (var2 == 111) {
				this.resizeY = var1.readUnsignedShort();
			} else if (var2 == 112) {
				this.resizeZ = var1.readUnsignedShort();
			} else if (var2 == 113) {
				this.ambient = var1.readByte();
			} else if (var2 == 114) {
				this.contrast = var1.readByte() * 5;
			} else if (var2 == 115) {
				this.team = var1.readUnsignedByte();
			} else if (var2 == 139) {
				this.unnotedId = var1.readUnsignedShort();
			} else if (var2 == 140) {
				this.notedId = var1.readUnsignedShort();
			} else if (var2 == 148) {
				this.placeholder = var1.readUnsignedShort();
			} else if (var2 == 149) {
				this.placeholderTemplate = var1.readUnsignedShort();
			} else if (var2 == 249) {
				this.params = MouseRecorder.readStringIntParameters(var1, this.params);
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lif;Lif;B)V",
		garbageValue = "4"
	)
	@Export("genCert")
	void genCert(ItemDefinition var1, ItemDefinition var2) {
		this.model = var1.model;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.recolorFrom = var1.recolorFrom;
		this.recolorTo = var1.recolorTo;
		this.retextureFrom = var1.retextureFrom;
		this.retextureTo = var1.retextureTo;
		this.name = var2.name;
		this.isMembersOnly = var2.isMembersOnly;
		this.price = var2.price;
		this.isStackable = 1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lif;Lif;B)V",
		garbageValue = "14"
	)
	@Export("genBought")
	void genBought(ItemDefinition var1, ItemDefinition var2) {
		this.model = var1.model;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.recolorFrom = var2.recolorFrom;
		this.recolorTo = var2.recolorTo;
		this.retextureFrom = var2.retextureFrom;
		this.retextureTo = var2.retextureTo;
		this.name = var2.name;
		this.isMembersOnly = var2.isMembersOnly;
		this.isStackable = var2.isStackable;
		this.maleModel = var2.maleModel;
		this.maleModel1 = var2.maleModel1;
		this.maleModel2 = var2.maleModel2;
		this.femaleModel = var2.femaleModel;
		this.femaleModel1 = var2.femaleModel1;
		this.femaleModel2 = var2.femaleModel2;
		this.maleHeadModel = var2.maleHeadModel;
		this.maleHeadModel2 = var2.maleHeadModel2;
		this.femaleHeadModel = var2.femaleHeadModel;
		this.femaleHeadModel2 = var2.femaleHeadModel2;
		this.team = var2.team;
		this.groundActions = var2.groundActions;
		this.inventoryActions = new String[5];
		if (var2.inventoryActions != null) {
			for (int var3 = 0; var3 < 4; ++var3) {
				this.inventoryActions[var3] = var2.inventoryActions[var3];
			}
		}

		this.inventoryActions[4] = "Discard";
		this.price = 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lif;Lif;B)V",
		garbageValue = "0"
	)
	@Export("genPlaceholder")
	void genPlaceholder(ItemDefinition var1, ItemDefinition var2) {
		this.model = var1.model;
		this.zoom2d = var1.zoom2d;
		this.xan2d = var1.xan2d;
		this.yan2d = var1.yan2d;
		this.zan2d = var1.zan2d;
		this.offsetX2d = var1.offsetX2d;
		this.offsetY2d = var1.offsetY2d;
		this.recolorFrom = var1.recolorFrom;
		this.recolorTo = var1.recolorTo;
		this.retextureFrom = var1.retextureFrom;
		this.retextureTo = var1.retextureTo;
		this.isStackable = var1.isStackable;
		this.name = var2.name;
		this.price = 0;
		this.isMembersOnly = false;
		this.isTradable = false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)Ldg;",
		garbageValue = "2"
	)
	@Export("getModelData")
	public final ModelData getModelData(int var1) {
		int var3;
		if (this.countobj != null && var1 > 1) {
			int var2 = -1;

			for (var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}

			if (var2 != -1) {
				return HealthBarDefinition.ItemDefinition_get(var2).getModelData(1);
			}
		}

		ModelData var4 = ModelData.ModelData_get(ItemDefinition_modelArchive, this.model, 0);
		if (var4 == null) {
			return null;
		} else {
			if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
				var4.resize(this.resizeX, this.resizeY, this.resizeZ);
			}

			if (this.recolorFrom != null) {
				for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
					var4.recolor(this.recolorFrom[var3], this.recolorTo[var3]);
				}
			}

			if (this.retextureFrom != null) {
				for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
					var4.retexture(this.retextureFrom[var3], this.retextureTo[var3]);
				}
			}

			return var4;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Ldx;",
		garbageValue = "1199706901"
	)
	@Export("getModel")
	public final Model getModel(int var1) {
		if (this.countobj != null && var1 > 1) {
			int var2 = -1;

			for (int var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}

			if (var2 != -1) {
				return HealthBarDefinition.ItemDefinition_get(var2).getModel(1);
			}
		}

		Model var5 = (Model)ItemDefinition_cachedModels.get((long)this.id);
		if (var5 != null) {
			return var5;
		} else {
			ModelData var6 = ModelData.ModelData_get(ItemDefinition_modelArchive, this.model, 0);
			if (var6 == null) {
				return null;
			} else {
				if (this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
					var6.resize(this.resizeX, this.resizeY, this.resizeZ);
				}

				int var4;
				if (this.recolorFrom != null) {
					for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
						var6.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
					}
				}

				if (this.retextureFrom != null) {
					for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
						var6.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
					}
				}

				var5 = var6.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
				var5.isSingleTile = true;
				ItemDefinition_cachedModels.put(var5, (long)this.id);
				return var5;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Lif;",
		garbageValue = "25"
	)
	@Export("getCountObj")
	public ItemDefinition getCountObj(int var1) {
		if (this.countobj != null && var1 > 1) {
			int var2 = -1;

			for (int var3 = 0; var3 < 10; ++var3) {
				if (var1 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}

			if (var2 != -1) {
				return HealthBarDefinition.ItemDefinition_get(var2);
			}
		}

		return this;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ZI)Z",
		garbageValue = "-1615353166"
	)
	@Export("hasNoValidModel")
	public final boolean hasNoValidModel(boolean var1) {
		int var2 = this.maleModel;
		int var3 = this.maleModel1;
		int var4 = this.maleModel2;
		if (var1) {
			var2 = this.femaleModel;
			var3 = this.femaleModel1;
			var4 = this.femaleModel2;
		}

		if (var2 == -1) {
			return true;
		} else {
			boolean var5 = true;
			if (!ItemDefinition_modelArchive.tryLoadFile(var2, 0)) {
				var5 = false;
			}

			if (var3 != -1 && !ItemDefinition_modelArchive.tryLoadFile(var3, 0)) {
				var5 = false;
			}

			if (var4 != -1 && !ItemDefinition_modelArchive.tryLoadFile(var4, 0)) {
				var5 = false;
			}

			return var5;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ZI)Ldg;",
		garbageValue = "-695579037"
	)
	public final ModelData method4732(boolean var1) {
		int var2 = this.maleModel;
		int var3 = this.maleModel1;
		int var4 = this.maleModel2;
		if (var1) {
			var2 = this.femaleModel;
			var3 = this.femaleModel1;
			var4 = this.femaleModel2;
		}

		if (var2 == -1) {
			return null;
		} else {
			ModelData var5 = ModelData.ModelData_get(ItemDefinition_modelArchive, var2, 0);
			if (var3 != -1) {
				ModelData var6 = ModelData.ModelData_get(ItemDefinition_modelArchive, var3, 0);
				if (var4 != -1) {
					ModelData var7 = ModelData.ModelData_get(ItemDefinition_modelArchive, var4, 0);
					ModelData[] var8 = new ModelData[]{var5, var6, var7};
					var5 = new ModelData(var8, 3);
				} else {
					ModelData[] var10 = new ModelData[]{var5, var6};
					var5 = new ModelData(var10, 2);
				}
			}

			if (!var1 && this.maleOffset != 0) {
				var5.changeOffset(0, this.maleOffset, 0);
			}

			if (var1 && this.femaleOffset != 0) {
				var5.changeOffset(0, this.femaleOffset, 0);
			}

			int var9;
			if (this.recolorFrom != null) {
				for (var9 = 0; var9 < this.recolorFrom.length; ++var9) {
					var5.recolor(this.recolorFrom[var9], this.recolorTo[var9]);
				}
			}

			if (this.retextureFrom != null) {
				for (var9 = 0; var9 < this.retextureFrom.length; ++var9) {
					var5.retexture(this.retextureFrom[var9], this.retextureTo[var9]);
				}
			}

			return var5;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ZI)Z",
		garbageValue = "509539526"
	)
	public final boolean method4731(boolean var1) {
		int var2 = this.maleHeadModel;
		int var3 = this.maleHeadModel2;
		if (var1) {
			var2 = this.femaleHeadModel;
			var3 = this.femaleHeadModel2;
		}

		if (var2 == -1) {
			return true;
		} else {
			boolean var4 = true;
			if (!ItemDefinition_modelArchive.tryLoadFile(var2, 0)) {
				var4 = false;
			}

			if (var3 != -1 && !ItemDefinition_modelArchive.tryLoadFile(var3, 0)) {
				var4 = false;
			}

			return var4;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ZI)Ldg;",
		garbageValue = "709869485"
	)
	public final ModelData method4741(boolean var1) {
		int var2 = this.maleHeadModel;
		int var3 = this.maleHeadModel2;
		if (var1) {
			var2 = this.femaleHeadModel;
			var3 = this.femaleHeadModel2;
		}

		if (var2 == -1) {
			return null;
		} else {
			ModelData var4 = ModelData.ModelData_get(ItemDefinition_modelArchive, var2, 0);
			if (var3 != -1) {
				ModelData var5 = ModelData.ModelData_get(ItemDefinition_modelArchive, var3, 0);
				ModelData[] var6 = new ModelData[]{var4, var5};
				var4 = new ModelData(var6, 2);
			}

			int var7;
			if (this.recolorFrom != null) {
				for (var7 = 0; var7 < this.recolorFrom.length; ++var7) {
					var4.recolor(this.recolorFrom[var7], this.recolorTo[var7]);
				}
			}

			if (this.retextureFrom != null) {
				for (var7 = 0; var7 < this.retextureFrom.length; ++var7) {
					var4.retexture(this.retextureFrom[var7], this.retextureTo[var7]);
				}
			}

			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "16856082"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-22"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return FloorDecoration.method2914(this.params, var1, var2);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "840008410"
	)
	@Export("getShiftClickIndex")
	public int getShiftClickIndex() {
		if (this.shiftClickIndex != -1 && this.inventoryActions != null) {
			if (this.shiftClickIndex >= 0) {
				return this.inventoryActions[this.shiftClickIndex] != null ? this.shiftClickIndex : -1;
			} else {
				return "Drop".equalsIgnoreCase(this.inventoryActions[4]) ? 4 : -1;
			}
		} else {
			return -1;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-108"
	)
	@Export("Messages_getLastChatID")
	static int Messages_getLastChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}
}
