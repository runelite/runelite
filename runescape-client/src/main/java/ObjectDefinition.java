import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("ObjectDefinition")
public class ObjectDefinition extends DualNode {
	@ObfuscatedName("u")
	@Export("ObjectDefinition_isLowDetail")
	static boolean ObjectDefinition_isLowDetail;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("ObjectDefinition_archive")
	static AbstractArchive ObjectDefinition_archive;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("ObjectDefinition_modelsArchive")
	static AbstractArchive ObjectDefinition_modelsArchive;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("ObjectDefinition_cached")
	static EvictingDualNodeHashTable ObjectDefinition_cached;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("ObjectDefinition_cachedModelData")
	public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("ObjectDefinition_cachedEntities")
	static EvictingDualNodeHashTable ObjectDefinition_cachedEntities;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("ObjectDefinition_cachedModels")
	static EvictingDualNodeHashTable ObjectDefinition_cachedModels;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "[Ldq;"
	)
	static ModelData[] field3359;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1224047329
	)
	@Export("id")
	public int id;
	@ObfuscatedName("i")
	@Export("modelIds")
	int[] modelIds;
	@ObfuscatedName("k")
	@Export("models")
	int[] models;
	@ObfuscatedName("x")
	@Export("name")
	public String name;
	@ObfuscatedName("o")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("e")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("n")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("r")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1491775379
	)
	@Export("sizeX")
	public int sizeX;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1523535533
	)
	@Export("sizeY")
	public int sizeY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -497299079
	)
	@Export("interactType")
	public int interactType;
	@ObfuscatedName("s")
	@Export("boolean1")
	public boolean boolean1;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -902316801
	)
	@Export("int1")
	public int int1;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1874021809
	)
	@Export("clipType")
	int clipType;
	@ObfuscatedName("v")
	@Export("nonFlatShading")
	boolean nonFlatShading;
	@ObfuscatedName("q")
	@Export("modelClipped")
	public boolean modelClipped;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 560318425
	)
	@Export("animationId")
	public int animationId;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1161238399
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -1664759947
	)
	@Export("ambient")
	int ambient;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = -740378647
	)
	@Export("contrast")
	int contrast;
	@ObfuscatedName("am")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -1328345039
	)
	@Export("mapIconId")
	public int mapIconId;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 114604009
	)
	@Export("mapSceneId")
	public int mapSceneId;
	@ObfuscatedName("ao")
	@Export("isRotated")
	boolean isRotated;
	@ObfuscatedName("aw")
	@Export("clipped")
	public boolean clipped;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 1275317383
	)
	@Export("modelSizeX")
	int modelSizeX;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 561892729
	)
	@Export("modelHeight")
	int modelHeight;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -830571783
	)
	@Export("modelSizeY")
	int modelSizeY;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = 1415912703
	)
	@Export("offsetX")
	int offsetX;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1898203577
	)
	@Export("offsetHeight")
	int offsetHeight;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1849368413
	)
	@Export("offsetY")
	int offsetY;
	@ObfuscatedName("ac")
	@Export("boolean2")
	public boolean boolean2;
	@ObfuscatedName("az")
	@Export("isSolid")
	boolean isSolid;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1008945237
	)
	@Export("int3")
	public int int3;
	@ObfuscatedName("ae")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -1651874633
	)
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = -1197064613
	)
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 635324039
	)
	@Export("ambientSoundId")
	public int ambientSoundId;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -133480475
	)
	@Export("int4")
	public int int4;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = 1751772739
	)
	@Export("int5")
	public int int5;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -2030067949
	)
	@Export("int6")
	public int int6;
	@ObfuscatedName("au")
	@Export("soundEffectIds")
	public int[] soundEffectIds;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		ObjectDefinition_isLowDetail = false;
		ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
		ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
		ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
		ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
		field3359 = new ModelData[4];
	}

	ObjectDefinition() {
		this.name = "null";
		this.sizeX = 1;
		this.sizeY = 1;
		this.interactType = 2;
		this.boolean1 = true;
		this.int1 = -1;
		this.clipType = -1;
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

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-21114"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-1870971162"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "896131991"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedByte();
			if (var3 > 0) {
				if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
					var1.offset += var3 * 3;
				} else {
					this.models = new int[var3];
					this.modelIds = new int[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.modelIds[var4] = var1.readUnsignedShort();
						this.models[var4] = var1.readUnsignedByte();
					}
				}
			}
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 5) {
			var3 = var1.readUnsignedByte();
			if (var3 > 0) {
				if (this.modelIds != null && !ObjectDefinition_isLowDetail) {
					var1.offset += var3 * 2;
				} else {
					this.models = null;
					this.modelIds = new int[var3];

					for (var4 = 0; var4 < var3; ++var4) {
						this.modelIds[var4] = var1.readUnsignedShort();
					}
				}
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
			if (this.animationId == 65535) {
				this.animationId = -1;
			}
		} else if (var2 == 27) {
			this.interactType = 1;
		} else if (var2 == 28) {
			this.int2 = var1.readUnsignedByte();
		} else if (var2 == 29) {
			this.ambient = var1.readByte();
		} else if (var2 == 39) {
			this.contrast = var1.readByte() * 25;
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
		} else if (var2 != 77 && var2 != 92) {
			if (var2 == 78) {
				this.ambientSoundId = var1.readUnsignedShort();
				this.int4 = var1.readUnsignedByte();
			} else if (var2 == 79) {
				this.int5 = var1.readUnsignedShort();
				this.int6 = var1.readUnsignedShort();
				this.int4 = var1.readUnsignedByte();
				var3 = var1.readUnsignedByte();
				this.soundEffectIds = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.soundEffectIds[var4] = var1.readUnsignedShort();
				}
			} else if (var2 == 81) {
				this.clipType = var1.readUnsignedByte() * 256;
			} else if (var2 == 82) {
				this.mapIconId = var1.readUnsignedShort();
			} else if (var2 == 249) {
				this.params = ModelData0.readStringIntParameters(var1, this.params);
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
			if (var2 == 92) {
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
		signature = "(II)Z",
		garbageValue = "2054916988"
	)
	public final boolean method4691(int var1) {
		if (this.models != null) {
			for (int var4 = 0; var4 < this.models.length; ++var4) {
				if (this.models[var4] == var1) {
					return ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var4] & 65535, 0);
				}
			}

			return true;
		} else if (this.modelIds == null) {
			return true;
		} else if (var1 != 10) {
			return true;
		} else {
			boolean var2 = true;

			for (int var3 = 0; var3 < this.modelIds.length; ++var3) {
				var2 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var3] & 65535, 0);
			}

			return var2;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	@Export("needsModelFiles")
	public final boolean needsModelFiles() {
		if (this.modelIds == null) {
			return true;
		} else {
			boolean var1 = true;

			for (int var2 = 0; var2 < this.modelIds.length; ++var2) {
				var1 &= ObjectDefinition_modelsArchive.tryLoadFile(this.modelIds[var2] & 65535, 0);
			}

			return var1;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II[[IIIII)Lee;",
		garbageValue = "554507629"
	)
	@Export("getEntity")
	public final Entity getEntity(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var7;
		if (this.models == null) {
			var7 = (long)(var2 + (this.id << 10));
		} else {
			var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Object var9 = (Entity)ObjectDefinition_cachedEntities.get(var7);
		if (var9 == null) {
			ModelData var10 = this.getModelData(var1, var2);
			if (var10 == null) {
				return null;
			}

			if (!this.nonFlatShading) {
				var9 = var10.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			} else {
				var10.ambient = (short)(this.ambient + 64);
				var10.contrast = (short)(this.contrast + 768);
				var10.calculateVertexNormals();
				var9 = var10;
			}

			ObjectDefinition_cachedEntities.put((DualNode)var9, var7);
		}

		if (this.nonFlatShading) {
			var9 = ((ModelData)var9).method2839();
		}

		if (this.clipType * 65536 >= 0) {
			if (var9 instanceof Model) {
				var9 = ((Model)var9).contourGround(var3, var4, var5, var6, true, this.clipType * 65536);
			} else if (var9 instanceof ModelData) {
				var9 = ((ModelData)var9).method2819(var3, var4, var5, var6, true, this.clipType * 65536);
			}
		}

		return (Entity)var9;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II[[IIIIS)Ldf;",
		garbageValue = "17896"
	)
	@Export("getModel")
	public final Model getModel(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var7;
		if (this.models == null) {
			var7 = (long)(var2 + (this.id << 10));
		} else {
			var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
		}

		Model var9 = (Model)ObjectDefinition_cachedModels.get(var7);
		if (var9 == null) {
			ModelData var10 = this.getModelData(var1, var2);
			if (var10 == null) {
				return null;
			}

			var9 = var10.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.put(var9, var7);
		}

		if (this.clipType * 65536 >= 0) {
			var9 = var9.contourGround(var3, var4, var5, var6, true, this.clipType * 65536);
		}

		return var9;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II[[IIIILiy;IB)Ldf;",
		garbageValue = "49"
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

			var11 = var12.toModel(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			ObjectDefinition_cachedModels.put(var11, var9);
		}

		if (var7 == null && this.clipType * 65536 == -1) {
			return var11;
		} else {
			if (var7 != null) {
				var11 = var7.transformObjectModel(var11, var8, var2);
			} else {
				var11 = var11.toSharedSequenceModel(true);
			}

			if (this.clipType * 65536 >= 0) {
				var11 = var11.contourGround(var3, var4, var5, var6, false, this.clipType * 65536);
			}

			return var11;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Ldq;",
		garbageValue = "-391634342"
	)
	@Export("getModelData")
	final ModelData getModelData(int var1, int var2) {
		ModelData var3 = null;
		boolean var4;
		int var5;
		int var7;
		if (this.models == null) {
			if (var1 != 10) {
				return null;
			}

			if (this.modelIds == null) {
				return null;
			}

			var4 = this.isRotated;
			if (var1 == 2 && var2 > 3) {
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
					var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var7 & 65535, 0);
					if (var3 == null) {
						return null;
					}

					if (var4) {
						var3.method2878();
					}

					ObjectDefinition_cachedModelData.put(var3, (long)var7);
				}

				if (var5 > 1) {
					field3359[var6] = var3;
				}
			}

			if (var5 > 1) {
				var3 = new ModelData(field3359, var5);
			}
		} else {
			int var9 = -1;

			for (var5 = 0; var5 < this.models.length; ++var5) {
				if (this.models[var5] == var1) {
					var9 = var5;
					break;
				}
			}

			if (var9 == -1) {
				return null;
			}

			var5 = this.modelIds[var9];
			boolean var10 = this.isRotated ^ var2 > 3;
			if (var10) {
				var5 += 65536;
			}

			var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var5);
			if (var3 == null) {
				var3 = ModelData.ModelData_get(ObjectDefinition_modelsArchive, var5 & 65535, 0);
				if (var3 == null) {
					return null;
				}

				if (var10) {
					var3.method2878();
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

		ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorFrom, this.retextureFrom == null, true);
		if (var1 == 4 && var2 > 3) {
			var8.method2822(256);
			var8.changeOffset(45, 0, -45);
		}

		var2 &= 3;
		if (var2 == 1) {
			var8.method2884();
		} else if (var2 == 2) {
			var8.method2872();
		} else if (var2 == 3) {
			var8.method2823();
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
		signature = "(I)Lil;",
		garbageValue = "1137642576"
	)
	@Export("transform")
	public final ObjectDefinition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = FileSystem.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? Occluder.getObjectDefinition(var2) : null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "1"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)Ljava/lang/String;",
		garbageValue = "1"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		return ServerBuild.method4214(this.params, var1, var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-422498348"
	)
	@Export("hasSound")
	public boolean hasSound() {
		if (this.transforms == null) {
			return this.ambientSoundId != -1 || this.soundEffectIds != null;
		} else {
			for (int var1 = 0; var1 < this.transforms.length; ++var1) {
				if (this.transforms[var1] != -1) {
					ObjectDefinition var2 = Occluder.getObjectDefinition(this.transforms[var1]);
					if (var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
						return true;
					}
				}
			}

			return false;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lbo;I)V",
		garbageValue = "-1368226174"
	)
	@Export("doCycleTitle")
	static void doCycleTitle(GameShell var0) {
		int var3;
		int var31;
		if (Login.worldSelectOpen) {
			while (true) {
				if (!InvDefinition.isKeyDown()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (JagexCache.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var1 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(0, 1);
						break;
					}

					int var2 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(1, 1);
						break;
					}

					var3 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(2, 1);
						break;
					}

					var31 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var31 && MouseHandler.MouseHandler_lastPressedX <= var31 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var31 + 15 && MouseHandler.MouseHandler_lastPressedX <= var31 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class270.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						Login.worldSelectOpen = false;
						AbstractByteArrayCopier.leftTitleSprite.drawAt(Login.xPadding, 0);
						class319.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Decimator.logoSprite.drawAt(Login.xPadding + 382 - Decimator.logoSprite.subWidth / 2, 18);
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var5 = Skills.World_worlds[Login.hoveredWorldIndex];
						GrandExchangeOfferAgeComparator.changeWorld(var5);
						Login.worldSelectOpen = false;
						AbstractByteArrayCopier.leftTitleSprite.drawAt(Login.xPadding, 0);
						class319.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Decimator.logoSprite.drawAt(Login.xPadding + 382 - Decimator.logoSprite.subWidth / 2, 18);
					} else {
						if (Login.worldSelectPage > 0 && Skills.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= Skills.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= WorldMapCacheName.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WorldMapCacheName.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && KitDefinition.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= BoundaryObject.canvasWidth - KitDefinition.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= BoundaryObject.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= WorldMapCacheName.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WorldMapCacheName.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (class49.field418 == 13) {
					Login.worldSelectOpen = false;
					AbstractByteArrayCopier.leftTitleSprite.drawAt(Login.xPadding, 0);
					class319.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
					Decimator.logoSprite.drawAt(Login.xPadding + 382 - Decimator.logoSprite.subWidth / 2, 18);
					break;
				}

				if (class49.field418 == 96) {
					if (Login.worldSelectPage > 0 && Skills.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (class49.field418 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && KitDefinition.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				UserComparator10.clientPreferences.titleMusicDisabled = !UserComparator10.clientPreferences.titleMusicDisabled;
				class40.savePreferences();
				if (!UserComparator10.clientPreferences.titleMusicDisabled) {
					WorldMapData_0.method191(AbstractWorldMapData.archive6, "scape main", "", 255, false);
				} else {
					TileItemPile.method2811();
				}
			}

			if (Client.gameState != 5) {
				if (-1L == Login.field1205) {
					Login.field1205 = TaskHandler.currentTimeMillis() + 1000L;
				}

				long var20 = TaskHandler.currentTimeMillis();
				if (class4.method63() && -1L == Login.field1206) {
					Login.field1206 = var20;
					if (Login.field1206 > Login.field1205) {
						Login.field1205 = Login.field1206;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (Language.Language_EN == VarbitDefinition.clientLanguage) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var3 = Login.xPadding + 5;
							short var4 = 463;
							byte var22 = 100;
							byte var6 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var22 + var3 && MouseHandler.MouseHandler_lastPressedY >= var4 && MouseHandler.MouseHandler_lastPressedY <= var6 + var4) {
								WorldMapData_0.method187();
								return;
							}
						}

						if (GrandExchangeOfferOwnWorldComparator.World_request != null) {
							WorldMapData_0.method187();
						}
					}

					var3 = MouseHandler.MouseHandler_lastButton;
					var31 = MouseHandler.MouseHandler_lastPressedX;
					int var42 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 == 0) {
						var31 = MouseHandler.MouseHandler_x;
						var42 = MouseHandler.MouseHandler_y;
					}

					if (!JagexCache.mouseCam && var3 == 4) {
						var3 = 1;
					}

					short var34;
					int var35;
					if (Login.loginIndex == 0) {
						boolean var39 = false;

						while (InvDefinition.isKeyDown()) {
							if (class49.field418 == 84) {
								var39 = true;
							}
						}

						var35 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter - 80;
						var34 = 291;
						if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20) {
							WorldMapAreaData.openURL(PacketBuffer.method5582("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var35 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter + 80;
						if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20 || var39) {
							if ((Client.worldProperties & 33554432) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								Login.loginIndex = 1;
								Buddy.method5251();
							} else if ((Client.worldProperties & 4) != 0) {
								if ((Client.worldProperties & 1024) != 0) {
									Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other almost everywhere";
									Login.Login_response3 = "and the Protect Item prayer won't work.";
								} else {
									Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other";
									Login.Login_response3 = "almost everywhere.";
								}

								Login.Login_response0 = "Warning!";
								Login.loginIndex = 1;
								Buddy.method5251();
							} else if ((Client.worldProperties & 1024) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								Login.loginIndex = 1;
								Buddy.method5251();
							} else {
								class222.Login_promptCredentials(false);
							}
						}
					} else {
						short var7;
						int var32;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!InvDefinition.isKeyDown()) {
									var32 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter - 80;
									var7 = 321;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										class222.Login_promptCredentials(false);
									}

									var32 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter + 80;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										Login.loginIndex = 0;
									}
									break;
								}

								if (class49.field418 == 84) {
									class222.Login_promptCredentials(false);
								} else if (class49.field418 == 13) {
									Login.loginIndex = 0;
								}
							}
						} else {
							short var33;
							boolean var36;
							if (Login.loginIndex == 2) {
								var33 = 201;
								var32 = var33 + 52;
								if (var3 == 1 && var42 >= var32 - 12 && var42 < var32 + 2) {
									Login.currentLoginField = 0;
								}

								var32 += 15;
								if (var3 == 1 && var42 >= var32 - 12 && var42 < var32 + 2) {
									Login.currentLoginField = 1;
								}

								var32 += 15;
								var33 = 361;
								if (GrandExchangeOfferOwnWorldComparator.field638 != null) {
									var35 = GrandExchangeOfferOwnWorldComparator.field638.highX / 2;
									if (var3 == 1 && var31 >= GrandExchangeOfferOwnWorldComparator.field638.lowX - var35 && var31 <= var35 + GrandExchangeOfferOwnWorldComparator.field638.lowX && var42 >= var33 - 15 && var42 < var33) {
										switch(Login.field1186) {
										case 1:
											PacketWriter.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											WorldMapAreaData.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var35 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter - 80;
								var34 = 321;
								if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										PacketWriter.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										PacketWriter.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									PacketWriter.setLoginResponseString("", "Connecting to server...", "");
									Canvas.method872(false);
									class81.updateGameState(20);
									return;
								}

								var35 = Login.loginBoxX + 180 + 80;
								if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									class192.field2395 = 0;
									WorldMapSection0.otp = "";
									Login.field1196 = true;
								}

								var35 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter + -117;
								var34 = 277;
								Login.field1173 = var31 >= var35 && var31 < var35 + HealthBar.field1115 && var42 >= var34 && var42 < var34 + class40.field348;
								if (var3 == 1 && Login.field1173) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && UserComparator10.clientPreferences.rememberedUsername != null) {
										UserComparator10.clientPreferences.rememberedUsername = null;
										class40.savePreferences();
									}
								}

								var35 = GrandExchangeOfferOwnWorldComparator.loginBoxCenter + 24;
								var34 = 277;
								Login.field1195 = var31 >= var35 && var31 < var35 + HealthBar.field1115 && var42 >= var34 && var42 < var34 + class40.field348;
								if (var3 == 1 && Login.field1195) {
									UserComparator10.clientPreferences.hideUsername = !UserComparator10.clientPreferences.hideUsername;
									if (!UserComparator10.clientPreferences.hideUsername) {
										Login.Login_username = "";
										UserComparator10.clientPreferences.rememberedUsername = null;
										Buddy.method5251();
									}

									class40.savePreferences();
								}

								label1235:
								while (true) {
									Transferable var24;
									int var38;
									do {
										while (true) {
											char var37;
											label1149:
											do {
												while (true) {
													while (InvDefinition.isKeyDown()) {
														if (class49.field418 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1149;
															}

															DirectByteArrayCopier.method4010(class297.field3699);
															if (class49.field418 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (class49.field418 == 84 || class49.field418 == 80) {
																Login.currentLoginField = 1;
															}

															var37 = class297.field3699;
															var36 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var37) != -1;
															if (var36 && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + class297.field3699;
															}
														} else {
															Login.loginIndex = 0;
															Login.Login_username = "";
															Login.Login_password = "";
															class192.field2395 = 0;
															WorldMapSection0.otp = "";
															Login.field1196 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (class49.field418 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (class49.field418 == 84 || class49.field418 == 80) {
												Login.currentLoginField = 0;
												if (class49.field418 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														PacketWriter.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														PacketWriter.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													PacketWriter.setLoginResponseString("", "Connecting to server...", "");
													Canvas.method872(false);
													class81.updateGameState(20);
													return;
												}
											}

											if ((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && class49.field418 == 67) {
												Clipboard var23 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var24 = var23.getContents(AbstractWorldMapIcon.client);
												var38 = 20 - Login.Login_password.length();
												break;
											}

											var37 = class297.field3699;
											if (var37 >= ' ' && var37 < 127 || var37 > 127 && var37 < 160 || var37 > 160 && var37 <= 255) {
												var36 = true;
											} else {
												label1362: {
													if (var37 != 0) {
														char[] var26 = class287.cp1252AsciiExtension;

														for (int var27 = 0; var27 < var26.length; ++var27) {
															char var13 = var26[var27];
															if (var37 == var13) {
																var36 = true;
																break label1362;
															}
														}
													}

													var36 = false;
												}
											}

											if (var36) {
												char var43 = class297.field3699;
												boolean var11 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var43) != -1;
												if (var11 && Login.Login_password.length() < 20) {
													Login.Login_password = Login.Login_password + class297.field3699;
												}
											}
										}
									} while(var38 <= 0);

									try {
										String var12 = (String)var24.getTransferData(DataFlavor.stringFlavor);
										int var40 = Math.min(var38, var12.length());
										int var14 = 0;

										while (true) {
											if (var14 >= var40) {
												Login.Login_password = Login.Login_password + var12.substring(0, var40);
												continue label1235;
											}

											char var16 = var12.charAt(var14);
											boolean var15;
											if (var16 >= ' ' && var16 < 127 || var16 > 127 && var16 < 160 || var16 > 160 && var16 <= 255) {
												var15 = true;
											} else {
												label1363: {
													if (var16 != 0) {
														char[] var17 = class287.cp1252AsciiExtension;

														for (int var18 = 0; var18 < var17.length; ++var18) {
															char var19 = var17[var18];
															if (var16 == var19) {
																var15 = true;
																break label1363;
															}
														}
													}

													var15 = false;
												}
											}

											if (!var15) {
												break;
											}

											char var41 = var12.charAt(var14);
											boolean var25 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var41) != -1;
											if (!var25) {
												break;
											}

											++var14;
										}

										Login.loginIndex = 3;
										return;
									} catch (UnsupportedFlavorException var29) {
									} catch (IOException var30) {
									}
								}
							} else if (Login.loginIndex == 3) {
								var32 = Login.loginBoxX + 180;
								var7 = 276;
								if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
									class222.Login_promptCredentials(false);
								}

								var32 = Login.loginBoxX + 180;
								var7 = 326;
								if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
									PacketWriter.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var9;
								if (Login.loginIndex == 4) {
									var32 = Login.loginBoxX + 180 - 80;
									var7 = 321;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										WorldMapSection0.otp.trim();
										if (WorldMapSection0.otp.length() != 6) {
											PacketWriter.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										class192.field2395 = Integer.parseInt(WorldMapSection0.otp);
										WorldMapSection0.otp = "";
										Canvas.method872(true);
										PacketWriter.setLoginResponseString("", "Connecting to server...", "");
										class81.updateGameState(20);
										return;
									}

									if (var3 == 1 && var31 >= Login.loginBoxX + 180 - 9 && var31 <= Login.loginBoxX + 180 + 130 && var42 >= 263 && var42 <= 296) {
										Login.field1196 = !Login.field1196;
									}

									if (var3 == 1 && var31 >= Login.loginBoxX + 180 - 34 && var31 <= Login.loginBoxX + 34 + 180 && var42 >= 351 && var42 <= 363) {
										WorldMapAreaData.openURL(PacketBuffer.method5582("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var32 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										class192.field2395 = 0;
										WorldMapSection0.otp = "";
									}

									while (InvDefinition.isKeyDown()) {
										boolean var8 = false;

										for (var9 = 0; var9 < "1234567890".length(); ++var9) {
											if (class297.field3699 == "1234567890".charAt(var9)) {
												var8 = true;
												break;
											}
										}

										if (class49.field418 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											class192.field2395 = 0;
											WorldMapSection0.otp = "";
										} else {
											if (class49.field418 == 85 && WorldMapSection0.otp.length() > 0) {
												WorldMapSection0.otp = WorldMapSection0.otp.substring(0, WorldMapSection0.otp.length() - 1);
											}

											if (class49.field418 == 84) {
												WorldMapSection0.otp.trim();
												if (WorldMapSection0.otp.length() != 6) {
													PacketWriter.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												class192.field2395 = Integer.parseInt(WorldMapSection0.otp);
												WorldMapSection0.otp = "";
												Canvas.method872(true);
												PacketWriter.setLoginResponseString("", "Connecting to server...", "");
												class81.updateGameState(20);
												return;
											}

											if (var8 && WorldMapSection0.otp.length() < 6) {
												WorldMapSection0.otp = WorldMapSection0.otp + class297.field3699;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var32 = Login.loginBoxX + 180 - 80;
									var7 = 321;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										ScriptFrame.method1163();
										return;
									}

									var32 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
										class222.Login_promptCredentials(true);
									}

									var34 = 361;
									if (class186.field2342 != null) {
										var9 = class186.field2342.highX / 2;
										if (var3 == 1 && var31 >= class186.field2342.lowX - var9 && var31 <= var9 + class186.field2342.lowX && var42 >= var34 - 15 && var42 < var34) {
											WorldMapAreaData.openURL(PacketBuffer.method5582("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (InvDefinition.isKeyDown()) {
										var36 = false;

										for (int var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var10) {
											if (class297.field3699 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var10)) {
												var36 = true;
												break;
											}
										}

										if (class49.field418 == 13) {
											class222.Login_promptCredentials(true);
										} else {
											if (class49.field418 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (class49.field418 == 84) {
												ScriptFrame.method1163();
												return;
											}

											if (var36 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + class297.field3699;
											}
										}
									}
								} else if (Login.loginIndex != 6) {
									if (Login.loginIndex == 7) {
										var32 = Login.loginBoxX + 180 - 80;
										var7 = 321;
										if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
											WorldMapAreaData.openURL(PacketBuffer.method5582("secure", true) + "m=dob/set_dob.ws", true, false);
											PacketWriter.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var32 = Login.loginBoxX + 180 + 80;
										if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
											class222.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 8) {
										var32 = Login.loginBoxX + 180 - 80;
										var7 = 321;
										if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
											WorldMapAreaData.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
											PacketWriter.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var32 = Login.loginBoxX + 180 + 80;
										if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
											class222.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 12) {
										String var28 = "";
										switch(Login.field1185) {
										case 0:
											var28 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
											break;
										case 1:
											var28 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
											break;
										default:
											class222.Login_promptCredentials(false);
										}

										var35 = Login.loginBoxX + 180;
										var34 = 276;
										if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20) {
											WorldMapAreaData.openURL(var28, true, false);
											PacketWriter.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var35 = Login.loginBoxX + 180;
										var34 = 326;
										if (var3 == 1 && var31 >= var35 - 75 && var31 <= var35 + 75 && var42 >= var34 - 20 && var42 <= var34 + 20) {
											class222.Login_promptCredentials(false);
										}
									} else if (Login.loginIndex == 24) {
										var32 = Login.loginBoxX + 180;
										var7 = 301;
										if (var3 == 1 && var31 >= var32 - 75 && var31 <= var32 + 75 && var42 >= var7 - 20 && var42 <= var7 + 20) {
											class222.Login_promptCredentials(false);
										}
									}
								} else {
									while (true) {
										do {
											if (!InvDefinition.isKeyDown()) {
												var33 = 321;
												if (var3 == 1 && var42 >= var33 - 20 && var42 <= var33 + 20) {
													class222.Login_promptCredentials(true);
												}

												return;
											}
										} while(class49.field418 != 84 && class49.field418 != 13);

										class222.Login_promptCredentials(true);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-256216527"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		class312.method6006();

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.obj != null) {
				var1.set();
			}
		}

		int var4 = NetCache.VarpDefinition_get(var0).type;
		if (var4 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var4 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				class60.method1194();
			}

			if (var4 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.musicVolume) {
					if (Client.musicVolume == 0 && Client.currentTrackGroupId != -1) {
						class65.playMusicTrack(AbstractWorldMapData.archive6, Client.currentTrackGroupId, 0, var3, false);
						Client.field742 = false;
					} else if (var3 == 0) {
						TileItemPile.method2811();
						Client.field742 = false;
					} else {
						TilePaint.method3103(var3);
					}

					Client.musicVolume = var3;
				}
			}

			if (var4 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var4 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var4 == 6) {
				Client.chatEffects = var2;
			}

			if (var4 == 9) {
				Client.field807 = var2;
			}

			if (var4 == 10) {
				if (var2 == 0) {
					Client.areaSoundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.areaSoundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.areaSoundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.areaSoundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.areaSoundEffectVolume = 0;
				}
			}

			if (var4 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			AttackOption[] var5;
			if (var4 == 18) {
				var5 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable};
				Client.playerAttackOption = (AttackOption)CollisionMap.findEnumerated(var5, var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var4 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var4 == 22) {
				var5 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable};
				Client.npcAttackOption = (AttackOption)CollisionMap.findEnumerated(var5, var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
