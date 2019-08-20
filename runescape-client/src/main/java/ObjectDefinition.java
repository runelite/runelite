import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("ObjectDefinition")
public class ObjectDefinition extends DualNode {
	@ObfuscatedName("q")
	@Export("ObjectDefinition_isLowDetail")
	public static boolean ObjectDefinition_isLowDetail;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("ObjectDefinition_archive")
	public static AbstractArchive ObjectDefinition_archive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("ObjectDefinition_modelsArchive")
	public static AbstractArchive ObjectDefinition_modelsArchive;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("ObjectDefinition_cached")
	static EvictingDualNodeHashTable ObjectDefinition_cached;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("ObjectDefinition_cachedModelData")
	public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("ObjectDefinition_cachedEntities")
	static EvictingDualNodeHashTable ObjectDefinition_cachedEntities;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("ObjectDefinition_cachedModels")
	static EvictingDualNodeHashTable ObjectDefinition_cachedModels;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Lds;"
	)
	static ModelData[] field3398;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2068374329
	)
	@Export("id")
	public int id;
	@ObfuscatedName("f")
	@Export("modelIds")
	int[] modelIds;
	@ObfuscatedName("m")
	@Export("models")
	int[] models;
	@ObfuscatedName("u")
	@Export("name")
	public String name;
	@ObfuscatedName("x")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("r")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("v")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("y")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 212808303
	)
	@Export("sizeX")
	public int sizeX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 421587309
	)
	@Export("sizeY")
	public int sizeY;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 2015026185
	)
	@Export("interactType")
	public int interactType;
	@ObfuscatedName("t")
	@Export("boolean1")
	public boolean boolean1;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -515360821
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -708119296
	)
	@Export("clipType")
	int clipType;
	@ObfuscatedName("n")
	@Export("nonFlatShading")
	boolean nonFlatShading;
	@ObfuscatedName("d")
	@Export("modelClipped")
	public boolean modelClipped;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -812430179
	)
	@Export("animationId")
	public int animationId;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -424786087
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -521483261
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -785836155
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("as")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1327834339
	)
	@Export("mapIconId")
	public int mapIconId;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -118615167
	)
	@Export("mapSceneId")
	public int mapSceneId;
	@ObfuscatedName("ag")
	@Export("isRotated")
	boolean isRotated;
	@ObfuscatedName("ar")
	@Export("clipped")
	public boolean clipped;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -106428285
	)
	@Export("modelSizeX")
	int modelSizeX;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -535612109
	)
	@Export("modelHeight")
	int modelHeight;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = -1113005599
	)
	@Export("modelSizeY")
	int modelSizeY;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1159375361
	)
	@Export("offsetX")
	int offsetX;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = 744922465
	)
	@Export("offsetHeight")
	int offsetHeight;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1695338293
	)
	@Export("offsetY")
	int offsetY;
	@ObfuscatedName("ac")
	@Export("boolean2")
	public boolean boolean2;
	@ObfuscatedName("ap")
	@Export("isSolid")
	boolean isSolid;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -509602785
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("aa")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = -1303757557
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = 1417540859
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 2125356431
	)
	@Export("ambientSoundId")
	public int ambientSoundId;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1963280521
	)
	@Export("int4")
	public int int4;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = 1234407491
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 69509337
	)
	@Export("int6")
	public int int6;
	@ObfuscatedName("ay")
	@Export("soundEffectIds")
	public int[] soundEffectIds;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		ObjectDefinition_isLowDetail = false;
		ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
		ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
		ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
		ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
		field3398 = new ModelData[4];
	}

	ObjectDefinition() {
		this.name = "null";
		this.sizeX = 1;
		this.sizeY = 1;
		this.interactType = 2;
		this.boolean1 = true;
		this.int1 = -1;
		this.clipType = -256;
		this.nonFlatShading = false;
		this.modelClipped = false;
		this.animationId = -1;
		this.int2 = 16;
		this.ambient = 0;
		this.contrast = 0;
		this.actions = new String[5];
		this.mapIconId = -1;
		this.mapSceneId = -1;
		this.isRotated = false;
		this.clipped = true;
		this.modelSizeX = 128;
		this.modelHeight = 128;
		this.modelSizeY = 128;
		this.offsetX = 0;
		this.offsetHeight = 0;
		this.offsetY = 0;
		this.boolean2 = false;
		this.isSolid = false;
		this.int3 = -1;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.ambientSoundId = -1;
		this.int4 = 0;
		this.int5 = 0;
		this.int6 = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-583792962"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.int1 == -1) {
			this.int1 = 0;
			if (this.modelIds != null && (this.models == null || this.models[0] == 10)) {
				this.int1 = 1;
			}

			for (int var1 = 0; var1 < 5; ++var1) {
				if (this.actions[var1] != null) {
					this.int1 = 1;
				}
			}
		}

		if (this.int3 == -1) {
			this.int3 = this.interactType != 0 ? 1 : 0;
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "82"
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
		signature = "(Lkf;II)V",
		garbageValue = "2121034762"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedByte();
			if (var3 <= 0) {
				return;
			}
			if (this.modelIds == null || ObjectDefinition_isLowDetail) {
				this.models = new int[var3];
				this.modelIds = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.modelIds[var4] = var1.readUnsignedShort();
					this.models[var4] = var1.readUnsignedByte();
				}
			} else {
				var1.offset += 3 * var3;
			}
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 5) {
			var3 = var1.readUnsignedByte();
			if (var3 <= 0) {
				return;
			}
			if (this.modelIds == null || ObjectDefinition_isLowDetail) {
				this.models = null;
				this.modelIds = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.modelIds[var4] = var1.readUnsignedShort();
				}
			} else {
				var1.offset += var3 * 2;
			}
		} else if (var2 == 14) {
			this.sizeX = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.sizeY = var1.readUnsignedByte();
		} else if (var2 == 17) {
			this.interactType = 0;
			this.boolean1 = false;
		} else if (var2 == 18) {
			this.boolean1 = false;
		} else if (var2 == 19) {
			this.int1 = var1.readUnsignedByte();
		} else if (var2 == 21) {
			this.clipType = 0;
		} else if (var2 == 22) {
			this.nonFlatShading = true;
		} else if (var2 == 23) {
			this.modelClipped = true;
		} else if (var2 == 24) {
			this.animationId = var1.readUnsignedShort();
			if (this.animationId == 0xffff) {
				this.animationId = -1;
			}
		} else if (var2 == 27) {
			this.interactType = 1;
		} else if (var2 == 28) {
			this.int2 = var1.readUnsignedByte();
		} else if (var2 == 29) {
			this.ambient = var1.readByte();
		} else if (var2 == 39) {
			this.contrast = var1.readByte();
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
		} else if (var2 == 62) {
			this.isRotated = true;
		} else if (var2 == 64) {
			this.clipped = false;
		} else if (var2 == 65) {
			this.modelSizeX = var1.readUnsignedShort();
		} else if (var2 == 66) {
			this.modelHeight = var1.readUnsignedShort();
		} else if (var2 == 67) {
			this.modelSizeY = var1.readUnsignedShort();
		} else if (var2 == 68) {
			this.mapSceneId = var1.readUnsignedShort();
		} else if (var2 == 69) {
			var1.readUnsignedByte();
		} else if (var2 == 70) {
			this.offsetX = var1.readShort();
		} else if (var2 == 71) {
			this.offsetHeight = var1.readShort();
		} else if (var2 == 72) {
			this.offsetY = var1.readShort();
		} else if (var2 == 73) {
			this.boolean2 = true;
		} else if (var2 == 74) {
			this.isSolid = true;
		} else if (var2 == 75) {
			this.int3 = var1.readUnsignedByte();
		} else if (var2 == 77 || var2 == 92) {
			this.transformVarbit = var1.readUnsignedShort();
			if (this.transformVarbit == 0xffff) {
				this.transformVarbit = -1;
			}

			this.transformVarp = var1.readUnsignedShort();
			if (this.transformVarp == 0xffff) {
				this.transformVarp = -1;
			}

			var3 = -1;
			if (var2 == 92) {
				var3 = var1.readUnsignedShort();
				if (var3 == 0xffff) {
					var3 = -1;
				}
			}

			var4 = var1.readUnsignedByte();
			this.transforms = new int[var4 + 2];

			for (int var5 = 0; var5 <= var4; ++var5) {
				this.transforms[var5] = var1.readUnsignedShort();
				if (this.transforms[var5] == 0xffff) {
					this.transforms[var5] = -1;
				}
			}

			this.transforms[var4 + 1] = var3;
		} else if (var2 == 78) {
			this.ambientSoundId = var1.readUnsignedShort();
			this.int4 = var1.readUnsignedByte();
		} else if (var2 == 79) {
			this.int5 = var1.readUnsignedShort();
			this.int6 = var1.readUnsignedShort();
			this.int4 = var1.readUnsignedByte();
			var3 = var1.readUnsignedByte();
			this.soundEffectIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4)
			{
				this.soundEffectIds[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 81)  {
			this.clipType = var1.readUnsignedByte() * 65536;
		} else if (var2 == 82) {
			this.mapIconId = var1.readUnsignedShort();
		} else if (var2 == 249) {
			this.params = WorldMapArea.readStringIntParameters(var1, this.params);
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-672143890"
	)
	public final boolean method4589(int var1) {
		if (this.models != null) {
			for (int var4 = 0; var4 < this.models.length; ++var4) {
				if (this.models[var4] == var1) {
					return ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var4] & 0xffff, 0);
				}
			}

			return true;
		}
		if (this.modelIds == null) {
			return true;
		}
		if (var1 != 10) {
			return true;
		}
		boolean var2 = true;

		for (int var3 = 0; var3 < this.modelIds.length; ++var3) {
			var2 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var3] & 0xffff, 0);
		}

		return var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-275510577"
	)
	@Export("needsModelFiles")
	public final boolean needsModelFiles() {
		if (this.modelIds == null) {
			return true;
		}
		boolean var1 = true;

		for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
			var1 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var2] & 0xffff, 0);
		}

		return var1;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II[[IIIIB)Leo;",
		garbageValue = "-18"
	)
	@Export("getEntity")
	public final Entity getEntity(int type, int rotation, int[][] tileHeights, int xPacked, int avgHeight, int yPacked) {
		long var7;
		if (this.models == null) {
			var7 = (long)(rotation + (this.id << 10));
		} else {
			var7 = (long)(rotation + (type << 3) + (this.id << 10));
		}

		Object var9 = (Entity)ObjectDefinition_cachedEntities.get(var7);
		if (var9 == null) {
			ModelData var10 = this.getModelData(type, rotation);
			if (var10 == null) {
				return null;
			}

			if (!this.nonFlatShading) {
				var9 = var10.toModel(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
			} else {
				var10.ambient = (short)(this.ambient + 64);
				var10.contrast = (short)(this.contrast * 25 + 768);
				var10.calculateVertexNormals();
				var9 = var10;
			}

			ObjectDefinition_cachedEntities.put((DualNode)var9, var7);
		}

		if (this.nonFlatShading) {
			var9 = ((ModelData)var9).method2775();
		}

		if (this.clipType * 256 >= 0) {
			if (var9 instanceof Model) {
				var9 = ((Model)var9).contourGround(tileHeights, xPacked, avgHeight, yPacked, true, this.clipType * 256);
			} else if (var9 instanceof ModelData) {
				var9 = ((ModelData)var9).method2776(tileHeights, xPacked, avgHeight, yPacked, true, this.clipType * 256);
			}
		}

		return (Entity)var9;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II[[IIIII)Ldm;",
		garbageValue = "-1160623337"
	)
	@Export("getModel")
	public final Model getModel(int type, int rotation, int[][] tileHeights, int xPacked, int avgHeight, int yPacked) {
		long var7;
		if (this.models == null) {
			var7 = (long)(rotation + (this.id << 10));
		} else {
			var7 = (long)(rotation + (type << 3) + (this.id << 10));
		}

		Model var9 = (Model)ObjectDefinition_cachedModels.get(var7);
		if (var9 == null) {
			ModelData var10 = this.getModelData(type, rotation);
			if (var10 == null) {
				return null;
			}

			var9 = var10.toModel(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.put(var9, var7);
		}

		if (this.clipType * 256 >= 0) {
			var9 = var9.contourGround(tileHeights, xPacked, avgHeight, yPacked, true, this.clipType * 256);
		}

		return var9;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II[[IIIILis;IB)Ldm;",
		garbageValue = "5"
	)
	@Export("getModelDynamic")
	public final Model getModelDynamic(int var1, int var2, int[][] var3, int var4, int var5, int var6, SequenceDefinition var7, int var8) {
		long var9;
		if (this.models == null) {
			var9 = (long)(var2 + (this.id << 10));
		} else {
			var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Model var11 = (Model)ObjectDefinition_cachedModels.get(var9);
		if (var11 == null) {
			ModelData var12 = this.getModelData(var1, var2);
			if (var12 == null) {
				return null;
			}

			var11 = var12.toModel(this.ambient + 64, this.contrast * 25 + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.put(var11, var9);
		}

		if (var7 == null && this.clipType * 256 == -1) {
			return var11;
		}
		if (var7 != null) {
			var11 = var7.transformObjectModel(var11, var8, var2);
		} else {
			var11 = var11.toSharedSequenceModel(true);
		}

		if (this.clipType * 256 >= 0) {
			var11 = var11.contourGround(var3, var4, var5, var6, false, this.clipType * 256);
		}

		return var11;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Lds;",
		garbageValue = "828225621"
	)
	@Export("getModelData")
	final ModelData getModelData(int type, int rotation) {
		ModelData var3 = null;
		boolean var4;
		int var5;
		int var7;
		if (this.models == null) {
			if (type != 10) {
				return null;
			}

			if (this.modelIds == null) {
				return null;
			}

			var4 = this.isRotated;
			if (type == 2 && rotation > 3) {
				var4 = !var4;
			}

			var5 = this.modelIds.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				var7 = this.modelIds[var6];
				if (var4) {
					var7 += 65536;
				}

				var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var7);
				if (var3 == null) {
					var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var7 & 0xffff, 0);
					if (var3 == null) {
						return null;
					}

					if (var4) {
						var3.method2785();
					}

					ObjectDefinition_cachedModelData.put(var3, (long)var7);
				}

				if (var5 > 1) {
					field3398[var6] = var3;
				}
			}

			if (var5 > 1) {
				var3 = new ModelData(field3398, var5);
			}
		} else {
			int var9 = -1;

			for (var5 = 0; var5 < this.models.length; ++var5) {
				if (this.models[var5] == type) {
					var9 = var5;
					break;
				}
			}

			if (var9 == -1) {
				return null;
			}

			var5 = this.modelIds[var9];
			boolean var10 = this.isRotated ^ rotation > 3;
			if (var10) {
				var5 += 65536;
			}

			var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var5);
			if (var3 == null) {
				var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var5 & 0xffff, 0);
				if (var3 == null) {
					return null;
				}

				if (var10) {
					var3.method2785();
				}

				ObjectDefinition_cachedModelData.put(var3, (long)var5);
			}
		}

		if (this.modelSizeX == 128 && this.modelHeight == 128 && this.modelSizeY == 128) {
			var4 = false;
		} else {
			var4 = true;
		}

		boolean var11;
		if (this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
			var11 = false;
		} else {
			var11 = true;
		}

		ModelData var8 = new ModelData(var3, rotation == 0 && !var4 && !var11, null == this.recolorFrom, this.retextureFrom == null, true);
		if (type == 4 && rotation > 3) {
			var8.method2781(256);
			var8.changeOffset(45, 0, -45);
		}

		rotation &= 3;
		if (rotation == 1) {
			var8.method2778();
		} else if (rotation == 2) {
			var8.method2797();
		} else if (rotation == 3) {
			var8.method2780();
		}

		if (this.recolorFrom != null) {
			for (var7 = 0; var7 < this.recolorFrom.length; ++var7) {
				var8.recolor(this.recolorFrom[var7], this.recolorTo[var7]);
			}
		}

		if (this.retextureFrom != null) {
			for (var7 = 0; var7 < this.retextureFrom.length; ++var7) {
				var8.retexture(this.retextureFrom[var7], this.retextureTo[var7]);
			}
		}

		if (var4) {
			var8.resize(this.modelSizeX, this.modelHeight, this.modelSizeY);
		}

		if (var11) {
			var8.changeOffset(this.offsetX, this.offsetHeight, this.offsetY);
		}

		return var8;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)Liy;",
		garbageValue = "45"
	)
	@Export("transform")
	public final ObjectDefinition transform() {
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

		return var2 != -1 ? ViewportMouse.getObjectDefinition(var2) : null;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-291840142"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "37"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return GrandExchangeOfferWorldComparator.method54(this.params, var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2033078684"
	)
	@Export("hasSound")
	public boolean hasSound() {
		if (this.transforms == null) {
			return this.ambientSoundId != -1 || this.soundEffectIds != null;
		}
		for (int var1 = 0; var1 < this.transforms.length; ++var1) {
			if (this.transforms[var1] != -1) {
				ObjectDefinition var2 = ViewportMouse.getObjectDefinition(this.transforms[var1]);
				if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
					return true;
				}
			}
		}

		return false;
	}
}
