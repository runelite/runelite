import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("KitDefinition")
public class KitDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("KitDefinition_archive")
	public static AbstractArchive KitDefinition_archive;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("KitDefinition_cached")
	public static EvictingDualNodeHashTable KitDefinition_cached;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	static Widget field3252;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1391426239
	)
	@Export("bodypartID")
	public int bodypartID;
	@ObfuscatedName("p")
	@Export("models2")
	int[] models2;
	@ObfuscatedName("q")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("m")
	@Export("recolorTo")
	short[] recolorTo;
	@ObfuscatedName("y")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("i")
	@Export("retextureTo")
	short[] retextureTo;
	@ObfuscatedName("c")
	@Export("models")
	int[] models;
	@ObfuscatedName("b")
	@Export("nonSelectable")
	public boolean nonSelectable;

	static {
		KitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	KitDefinition() {
		this.bodypartID = -1;
		this.models = new int[]{-1, -1, -1, -1, -1};
		this.nonSelectable = false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "801046571"
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
		signature = "(Lkl;II)V",
		garbageValue = "1307391521"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.bodypartID = var1.readUnsignedByte();
		} else {
			int var3;
			int var4;
			if (var2 == 2) {
				var3 = var1.readUnsignedByte();
				this.models2 = new int[var3];

				for (var4 = 0; var4 < var3; ++var4) {
					this.models2[var4] = var1.readUnsignedShort();
				}
			} else if (var2 == 3) {
				this.nonSelectable = true;
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
			} else if (var2 >= 60 && var2 < 70) {
				this.models[var2 - 60] = var1.readUnsignedShort();
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1837700521"
	)
	@Export("ready")
	public boolean ready() {
		if (this.models2 == null) {
			return true;
		} else {
			boolean var1 = true;

			for (int var2 = 0; var2 < this.models2.length; ++var2) {
				if (!GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive.tryLoadFile(this.models2[var2], 0)) {
					var1 = false;
				}
			}

			return var1;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "538019624"
	)
	@Export("getModelData")
	public ModelData getModelData() {
		if (this.models2 == null) {
			return null;
		} else {
			ModelData[] var1 = new ModelData[this.models2.length];

			for (int var2 = 0; var2 < this.models2.length; ++var2) {
				var1[var2] = ModelData.ModelData_get(GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive, this.models2[var2], 0);
			}

			ModelData var4;
			if (var1.length == 1) {
				var4 = var1[0];
			} else {
				var4 = new ModelData(var1, var1.length);
			}

			int var3;
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-361074735"
	)
	public boolean method4423() {
		boolean var1 = true;

		for (int var2 = 0; var2 < 5; ++var2) {
			if (this.models[var2] != -1 && !GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive.tryLoadFile(this.models[var2], 0)) {
				var1 = false;
			}
		}

		return var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Ldw;",
		garbageValue = "-26"
	)
	@Export("getKitDefinitionModels")
	public ModelData getKitDefinitionModels() {
		ModelData[] var1 = new ModelData[5];
		int var2 = 0;

		for (int var3 = 0; var3 < 5; ++var3) {
			if (this.models[var3] != -1) {
				var1[var2++] = ModelData.ModelData_get(GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive, this.models[var3], 0);
			}
		}

		ModelData var5 = new ModelData(var1, var2);
		int var4;
		if (this.recolorFrom != null) {
			for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
				var5.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
			}
		}

		if (this.retextureFrom != null) {
			for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
				var5.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
			}
		}

		return var5;
	}
}
