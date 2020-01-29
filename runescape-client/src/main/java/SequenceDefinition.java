import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("no")
	@ObfuscatedGetter(
		intValue = -1648433233
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("SequenceDefinition_cached")
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("SequenceDefinition_cachedFrames")
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("g")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("d")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("l")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("j")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 767757023
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("p")
	int[] field3517;
	@ObfuscatedName("h")
	public boolean field3518;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 180698695
	)
	public int field3508;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1537834299
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -698068841
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -796705451
	)
	public int field3522;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2012869833
	)
	public int field3523;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1328326195
	)
	public int field3524;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 738331183
	)
	public int field3516;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3518 = false;
		this.field3508 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3522 = 99;
		this.field3523 = -1;
		this.field3524 = -1;
		this.field3516 = 2;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "-76"
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
		signature = "(Lkp;II)V",
		garbageValue = "-683003303"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedShort();
			this.frameLengths = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameLengths[var4] = var1.readUnsignedShort();
			}

			this.frameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 2) {
			this.frameCount = var1.readUnsignedShort();
		} else if (var2 == 3) {
			var3 = var1.readUnsignedByte();
			this.field3517 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3517[var4] = var1.readUnsignedByte();
			}

			this.field3517[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3518 = true;
		} else if (var2 == 5) {
			this.field3508 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3522 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3523 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3524 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3516 = var1.readUnsignedByte();
		} else if (var2 == 12) {
			var3 = var1.readUnsignedByte();
			this.chatFrameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 13) {
			var3 = var1.readUnsignedByte();
			this.soundEffects = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.soundEffects[var4] = var1.readMedium();
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "145169378"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3523 == -1) {
			if (this.field3517 != null) {
				this.field3523 = 2;
			} else {
				this.field3523 = 0;
			}
		}

		if (this.field3524 == -1) {
			if (this.field3517 != null) {
				this.field3524 = 2;
			} else {
				this.field3524 = 0;
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ldx;IB)Ldx;",
		garbageValue = "4"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = EnumDefinition.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ldx;III)Ldx;",
		garbageValue = "2024082639"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = EnumDefinition.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var5 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var2));
			var3 &= 3;
			if (var3 == 1) {
				var5.rotateY270Ccw();
			} else if (var3 == 2) {
				var5.rotateY180();
			} else if (var3 == 3) {
				var5.rotateY90Ccw();
			}

			var5.animate(var4, var2);
			if (var3 == 1) {
				var5.rotateY90Ccw();
			} else if (var3 == 2) {
				var5.rotateY180();
			} else if (var3 == 3) {
				var5.rotateY270Ccw();
			}

			return var5;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ldx;II)Ldx;",
		garbageValue = "-1856197357"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = EnumDefinition.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ldx;ILip;IB)Ldx;",
		garbageValue = "29"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = EnumDefinition.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = EnumDefinition.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3517);
				return var7;
			}
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ldx;II)Ldx;",
		garbageValue = "221538890"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = EnumDefinition.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = EnumDefinition.getFrames(var6 >> 16);
				var6 &= 65535;
			}

			Model var7;
			if (var5 != null && var6 != 65535) {
				var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6));
				var7.animate(var4, var3);
				var7.animate(var5, var6);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3));
				var7.animate(var4, var3);
				return var7;
			}
		}
	}
}
