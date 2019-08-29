import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_animationsArchive")
	static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("SequenceDefinition_cached")
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("SequenceDefinition_cachedFrames")
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static ServerBuild field3507;
	@ObfuscatedName("n")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("t")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("q")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("x")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -522121775
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("f")
	int[] field3500;
	@ObfuscatedName("c")
	public boolean field3501;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1194078823
	)
	public int field3508;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1255780887
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1291874465
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1987515665
	)
	public int field3502;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -327317387
	)
	public int field3506;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1253996227
	)
	public int field3505;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -41123277
	)
	public int field3492;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3501 = false;
		this.field3508 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3502 = 99;
		this.field3506 = -1;
		this.field3505 = -1;
		this.field3492 = 2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lky;B)V",
		garbageValue = "1"
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
		signature = "(Lky;II)V",
		garbageValue = "20396859"
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
			this.field3500 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3500[var4] = var1.readUnsignedByte();
			}

			this.field3500[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3501 = true;
		} else if (var2 == 5) {
			this.field3508 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3502 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3506 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3505 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3492 = var1.readUnsignedByte();
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1147971481"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3506 == -1) {
			if (this.field3500 != null) {
				this.field3506 = 2;
			} else {
				this.field3506 = 0;
			}
		}

		if (this.field3505 == -1) {
			if (this.field3500 != null) {
				this.field3505 = 2;
			} else {
				this.field3505 = 0;
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ldo;II)Ldo;",
		garbageValue = "1625064611"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = WorldMapSprite.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ldo;III)Ldo;",
		garbageValue = "1397099935"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = WorldMapSprite.getFrames(var2 >> 16);
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
		signature = "(Ldo;IB)Ldo;",
		garbageValue = "-37"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = WorldMapSprite.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ldo;ILij;II)Ldo;",
		garbageValue = "-111207649"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = WorldMapSprite.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = WorldMapSprite.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3500);
				return var7;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ldo;II)Ldo;",
		garbageValue = "793015931"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = WorldMapSprite.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = WorldMapSprite.getFrames(var6 >> 16);
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)J",
		garbageValue = "1864654090"
	)
	public static final synchronized long method4686() {
		long var0 = System.currentTimeMillis();
		if (var0 < class296.field3688) {
			class296.field3689 += class296.field3688 - var0;
		}

		class296.field3688 = var0;
		return class296.field3689 + var0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)[Llb;",
		garbageValue = "43"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.field3858, FillMode.field3860, FillMode.SOLID};
	}
}
