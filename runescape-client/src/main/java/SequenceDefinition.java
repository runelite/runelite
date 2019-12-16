import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("qi")
	@ObfuscatedGetter(
		intValue = 364724224
	)
	static int field3477;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_archive")
	public static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_animationsArchive")
	public static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	public static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("SequenceDefinition_cached")
	static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("SequenceDefinition_cachedFrames")
	static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("b")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("e")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("x")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("a")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 626636947
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("c")
	int[] field3487;
	@ObfuscatedName("o")
	public boolean field3488;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -796386043
	)
	public int field3492;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2083462623
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -520888257
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -569309439
	)
	public int field3496;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -877726895
	)
	public int field3478;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -134908293
	)
	public int field3493;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1454093345
	)
	public int field3495;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3488 = false;
		this.field3492 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3496 = 99;
		this.field3478 = -1;
		this.field3493 = -1;
		this.field3495 = 2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "469124776"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "62604408"
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
			this.field3487 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3487[var4] = var1.readUnsignedByte();
			}

			this.field3487[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3488 = true;
		} else if (var2 == 5) {
			this.field3492 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3496 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3478 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3493 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3495 = var1.readUnsignedByte();
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1097095520"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3478 == -1) {
			if (this.field3487 != null) {
				this.field3478 = 2;
			} else {
				this.field3478 = 0;
			}
		}

		if (this.field3493 == -1) {
			if (this.field3487 != null) {
				this.field3493 = 2;
			} else {
				this.field3493 = 0;
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ldw;II)Ldw;",
		garbageValue = "903952456"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class4.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ldw;III)Ldw;",
		garbageValue = "-118800541"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = class4.getFrames(var2 >> 16);
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ldw;II)Ldw;",
		garbageValue = "103025381"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class4.getFrames(var2 >> 16);
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
		signature = "(Ldw;ILiv;IB)Ldw;",
		garbageValue = "118"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = class4.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = class4.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3487);
				return var7;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ldw;IB)Ldw;",
		garbageValue = "58"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = class4.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = class4.getFrames(var6 >> 16);
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

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(Lbh;B)V",
		garbageValue = "47"
	)
	static final void method4821(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = class14.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = class14.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = class14.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = class14.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var1 != 0L) {
			int var6 = class14.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = class2.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field912 = var4;
		var0.field911 = var5;
	}
}
