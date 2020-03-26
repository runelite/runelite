import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("nq")
	@ObfuscatedGetter(
		intValue = -1632730769
	)
	static int field3526;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("SequenceDefinition_cached")
	static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("SequenceDefinition_cachedFrames")
	static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("o")
	public static String field3527;
	@ObfuscatedName("v")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("q")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("z")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("t")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -750244517
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("s")
	int[] field3517;
	@ObfuscatedName("p")
	public boolean field3518;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1293261891
	)
	public int field3519;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1094123699
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -17515833
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1281885521
	)
	public int field3522;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1964972701
	)
	public int field3520;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -457337523
	)
	public int field3524;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -789911207
	)
	public int field3525;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3518 = false;
		this.field3519 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3522 = 99;
		this.field3520 = -1;
		this.field3524 = -1;
		this.field3525 = 2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1859351730"
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
		signature = "(Lkb;II)V",
		garbageValue = "-951623720"
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
			this.field3519 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3522 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3520 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3524 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3525 = var1.readUnsignedByte();
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3520 == -1) {
			if (this.field3517 != null) {
				this.field3520 = 2;
			} else {
				this.field3520 = 0;
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lel;II)Lel;",
		garbageValue = "1747843246"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = GrandExchangeEvents.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lel;III)Lel;",
		garbageValue = "-1535419363"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = GrandExchangeEvents.getFrames(var2 >> 16);
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;",
		garbageValue = "66"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = GrandExchangeEvents.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lel;ILjc;IB)Lel;",
		garbageValue = "1"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = GrandExchangeEvents.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = GrandExchangeEvents.getFrames(var4 >> 16);
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lel;IB)Lel;",
		garbageValue = "14"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = GrandExchangeEvents.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = GrandExchangeEvents.getFrames(var6 >> 16);
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
