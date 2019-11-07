import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("SequenceDefinition_cached")
	static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("SequenceDefinition_cachedFrames")
	static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("l")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("c")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("o")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("i")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1066613153
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("m")
	int[] field3505;
	@ObfuscatedName("p")
	public boolean field3514;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 400808599
	)
	public int field3519;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1898265591
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1958425001
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1319479105
	)
	public int field3518;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1982462933
	)
	public int field3504;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1529465451
	)
	public int field3513;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -769081211
	)
	public int field3521;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3514 = false;
		this.field3519 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3518 = 99;
		this.field3504 = -1;
		this.field3513 = -1;
		this.field3521 = 2;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "2146822130"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkc;IB)V",
		garbageValue = "-43"
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
			this.field3505 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3505[var4] = var1.readUnsignedByte();
			}

			this.field3505[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3514 = true;
		} else if (var2 == 5) {
			this.field3519 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3518 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3504 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3513 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3521 = var1.readUnsignedByte();
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-31863"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3504 == -1) {
			if (this.field3505 != null) {
				this.field3504 = 2;
			} else {
				this.field3504 = 0;
			}
		}

		if (this.field3513 == -1) {
			if (this.field3505 != null) {
				this.field3513 = 2;
			} else {
				this.field3513 = 0;
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ldv;IB)Ldv;",
		garbageValue = "-48"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ldv;IIS)Ldv;",
		garbageValue = "180"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ldv;II)Ldv;",
		garbageValue = "-1153349389"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ldv;ILiv;II)Ldv;",
		garbageValue = "1587697769"
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
				var7.animate2(var5, var2, var6, var4, this.field3505);
				return var7;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ldv;II)Ldv;",
		garbageValue = "-916013843"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Z",
		garbageValue = "1272275521"
	)
	@Export("isValidURL")
	static boolean isValidURL(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var2) {
				return false;
			}
		}
	}
}
