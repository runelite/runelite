import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("SequenceDefinition_animationsArchive")
	static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("SequenceDefinition_cached")
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("SequenceDefinition_cachedFrames")
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("aa")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("p")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("q")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("m")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("y")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 646355869
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("c")
	int[] field3509;
	@ObfuscatedName("b")
	public boolean field3504;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1781199649
	)
	public int field3511;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 75980763
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1392893675
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1078760223
	)
	public int field3503;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1818541161
	)
	public int field3515;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2021679627
	)
	public int field3510;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1562384253
	)
	public int field3517;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3504 = false;
		this.field3511 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3503 = 99;
		this.field3515 = -1;
		this.field3510 = -1;
		this.field3517 = 2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-45"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-4421595"
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
			this.field3509 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3509[var4] = var1.readUnsignedByte();
			}

			this.field3509[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3504 = true;
		} else if (var2 == 5) {
			this.field3511 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3503 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3515 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3510 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3517 = var1.readUnsignedByte();
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "30171"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3515 == -1) {
			if (this.field3509 != null) {
				this.field3515 = 2;
			} else {
				this.field3515 = 0;
			}
		}

		if (this.field3510 == -1) {
			if (this.field3509 != null) {
				this.field3510 = 2;
			} else {
				this.field3510 = 0;
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ldh;II)Ldh;",
		garbageValue = "330035631"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class226.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ldh;IIB)Ldh;",
		garbageValue = "2"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = class226.getFrames(var2 >> 16);
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

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ldh;II)Ldh;",
		garbageValue = "-1452846924"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class226.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ldh;ILix;IB)Ldh;",
		garbageValue = "-28"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = class226.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = class226.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3509);
				return var7;
			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ldh;IB)Ldh;",
		garbageValue = "-75"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = class226.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = class226.getFrames(var6 >> 16);
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

	@ObfuscatedName("et")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-645881783"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		DynamicObject.logOut();
		switch(var0) {
		case 1:
			Login.loginIndex = 24;
			PlayerType.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			class3.method48();
		}

	}
}
