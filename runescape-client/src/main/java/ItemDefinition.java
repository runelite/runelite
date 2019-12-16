import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("ItemDefinition")
public class ItemDefinition extends DualNode {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("ItemDefinition_modelArchive")
	static AbstractArchive ItemDefinition_modelArchive;
	@ObfuscatedName("x")
	@Export("ItemDefinition_inMembersWorld")
	static boolean ItemDefinition_inMembersWorld;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1592128497
	)
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("ItemDefinition_cached")
	static EvictingDualNodeHashTable ItemDefinition_cached;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("ItemDefinition_cachedModels")
	static EvictingDualNodeHashTable ItemDefinition_cachedModels;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("ItemDefinition_cachedSprites")
	static EvictingDualNodeHashTable ItemDefinition_cachedSprites;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive1")
	static Archive archive1;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1070204959
	)
	@Export("id")
	public int id;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -693135883
	)
	@Export("model")
	int model;
	@ObfuscatedName("l")
	@Export("name")
	public String name;
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
	@ObfuscatedGetter(
		intValue = 785772529
	)
	@Export("zoom2d")
	public int zoom2d;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -848519743
	)
	@Export("xan2d")
	public int xan2d;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1979835091
	)
	@Export("yan2d")
	public int yan2d;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 130944553
	)
	@Export("zan2d")
	public int zan2d;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -977084785
	)
	@Export("offsetX2d")
	public int offsetX2d;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -631330381
	)
	@Export("offsetY2d")
	public int offsetY2d;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 440066331
	)
	@Export("isStackable")
	public int isStackable;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -186300413
	)
	@Export("price")
	public int price;
	@ObfuscatedName("aw")
	@Export("isMembersOnly")
	public boolean isMembersOnly;
	@ObfuscatedName("as")
	@Export("groundActions")
	public String[] groundActions;
	@ObfuscatedName("ak")
	@Export("inventoryActions")
	public String[] inventoryActions;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -1938570583
	)
	@Export("shiftClickIndex")
	int shiftClickIndex;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1452164645
	)
	@Export("maleModel")
	int maleModel;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 195242013
	)
	@Export("maleModel1")
	int maleModel1;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 1805803195
	)
	@Export("maleOffset")
	int maleOffset;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -992390513
	)
	@Export("femaleModel")
	int femaleModel;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1602872537
	)
	@Export("femaleModel1")
	int femaleModel1;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1432685421
	)
	@Export("femaleOffset")
	int femaleOffset;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -567109747
	)
	@Export("maleModel2")
	int maleModel2;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -1467762471
	)
	@Export("femaleModel2")
	int femaleModel2;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 543483201
	)
	@Export("maleHeadModel")
	int maleHeadModel;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -93642959
	)
	@Export("maleHeadModel2")
	int maleHeadModel2;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -685966397
	)
	@Export("femaleHeadModel")
	int femaleHeadModel;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 1572395247
	)
	@Export("femaleHeadModel2")
	int femaleHeadModel2;
	@ObfuscatedName("ax")
	@Export("countobj")
	int[] countobj;
	@ObfuscatedName("at")
	@Export("countco")
	int[] countco;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -345365193
	)
	@Export("note")
	public int note;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -120980907
	)
	@Export("noteTemplate")
	public int noteTemplate;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 537794657
	)
	@Export("resizeX")
	int resizeX;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 710858879
	)
	@Export("resizeY")
	int resizeY;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1994951249
	)
	@Export("resizeZ")
	int resizeZ;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -740674709
	)
	@Export("ambient")
	public int ambient;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 1117780027
	)
	@Export("contrast")
	public int contrast;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -1310493757
	)
	@Export("team")
	public int team;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("params")
	IterableNodeHashTable params;
	@ObfuscatedName("bl")
	@Export("isTradable")
	public boolean isTradable;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		intValue = 1520856187
	)
	@Export("unnotedId")
	int unnotedId;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 480654725
	)
	@Export("notedId")
	int notedId;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 1889081019
	)
	@Export("placeholder")
	public int placeholder;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -50574295
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "41"
	)
	@Export("post")
	void post() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "874687185"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "-1294049187"
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
				this.contrast = var1.readByte();
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
				this.params = Calendar.readStringIntParameters(var1, this.params);
			}
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;I)V",
		garbageValue = "-1450285007"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;B)V",
		garbageValue = "33"
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lii;Lii;B)V",
		garbageValue = "54"
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Ldd;",
		garbageValue = "1663251439"
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
				return PacketBufferNode.ItemDefinition_get(var2).getModelData(1);
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Ldw;",
		garbageValue = "1098912111"
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
				return PacketBufferNode.ItemDefinition_get(var2).getModel(1);
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

				var5 = var6.toModel(this.ambient + 64, this.contrast * 5 + 768, -50, -10, -50);
				var5.isSingleTile = true;
				ItemDefinition_cachedModels.put(var5, (long)this.id);
				return var5;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)Lii;",
		garbageValue = "-519915564"
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
				return PacketBufferNode.ItemDefinition_get(var2);
			}
		}

		return this;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ZI)Z",
		garbageValue = "-90397002"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ZB)Ldd;",
		garbageValue = "-26"
	)
	public final ModelData method4703(boolean var1) {
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
		garbageValue = "517363999"
	)
	public final boolean method4692(boolean var1) {
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ZI)Ldd;",
		garbageValue = "-451251342"
	)
	public final ModelData method4661(boolean var1) {
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "1"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return class83.method2071(this.params, var1, var2);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-513455254"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return class14.method151(this.params, var1, var2);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1952337242"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-989883641"
	)
	public static void method4715(int var0) {
		if (var0 != -1) {
			if (Widget.Widget_loadedInterfaces[var0]) {
				FriendLoginUpdate.Widget_archive.clearFilesGroup(var0);
				if (UserComparator7.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < UserComparator7.Widget_interfaceComponents[var0].length; ++var2) {
						if (UserComparator7.Widget_interfaceComponents[var0][var2] != null) {
							if (UserComparator7.Widget_interfaceComponents[var0][var2].type != 2) {
								UserComparator7.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						UserComparator7.Widget_interfaceComponents[var0] = null;
					}

					Widget.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "30"
	)
	@Export("Login_promptCredentials")
	static void Login_promptCredentials(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (Interpreter.clientPreferences.rememberedUsername != null) {
				Login.Login_username = Interpreter.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		WorldMapCacheName.method618();
	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1424977093"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}
}
