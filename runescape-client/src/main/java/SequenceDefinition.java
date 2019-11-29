import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("SequenceDefinition_animationsArchive")
	static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("SequenceDefinition_cached")
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("SequenceDefinition_cachedFrames")
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;
	@ObfuscatedName("p")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("h")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("y")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("w")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1382390397
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("k")
	int[] field3525;
	@ObfuscatedName("x")
	public boolean field3523;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1226148923
	)
	public int field3527;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1315195187
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -756969187
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -651997909
	)
	public int field3516;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 613007297
	)
	public int field3531;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1604806417
	)
	public int field3515;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -441641943
	)
	public int field3533;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3523 = false;
		this.field3527 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3516 = 99;
		this.field3531 = -1;
		this.field3515 = -1;
		this.field3533 = 2;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkg;B)V",
		garbageValue = "-2"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "-474728171"
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
			this.field3525 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3525[var4] = var1.readUnsignedByte();
			}

			this.field3525[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3523 = true;
		} else if (var2 == 5) {
			this.field3527 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3516 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3531 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3515 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3533 = var1.readUnsignedByte();
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-12"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3531 == -1) {
			if (this.field3525 != null) {
				this.field3531 = 2;
			} else {
				this.field3531 = 0;
			}
		}

		if (this.field3515 == -1) {
			if (this.field3525 != null) {
				this.field3515 = 2;
			} else {
				this.field3515 = 0;
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ldf;IB)Ldf;",
		garbageValue = "33"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = Canvas.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ldf;III)Ldf;",
		garbageValue = "-551635617"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = Canvas.getFrames(var2 >> 16);
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ldf;II)Ldf;",
		garbageValue = "1568692010"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = Canvas.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ldf;ILiy;IS)Ldf;",
		garbageValue = "-1911"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = Canvas.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = Canvas.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3525);
				return var7;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ldf;II)Ldf;",
		garbageValue = "1087252773"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = Canvas.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = Canvas.getFrames(var6 >> 16);
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "-816742084"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}
