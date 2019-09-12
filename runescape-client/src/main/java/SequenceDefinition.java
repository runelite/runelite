import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("iw")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_archive")
	public static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_animationsArchive")
	public static AbstractArchive SequenceDefinition_animationsArchive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	public static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("SequenceDefinition_cached")
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("SequenceDefinition_cachedFrames")
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("gu")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("u")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("j")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("v")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("d")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -993478563
	)
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("n")
	int[] field3494;
	@ObfuscatedName("h")
	public boolean field3495;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 287380897
	)
	public int field3504;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 520762813
	)
	@Export("shield")
	public int shield;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -561463937
	)
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -916538321
	)
	public int field3492;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -594984365
	)
	public int field3496;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 20396127
	)
	public int field3501;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 881200293
	)
	public int field3502;

	static {
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.frameCount = -1;
		this.field3495 = false;
		this.field3504 = 5;
		this.shield = -1;
		this.weapon = -1;
		this.field3492 = 99;
		this.field3496 = -1;
		this.field3501 = -1;
		this.field3502 = 2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "430086086"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "1868272717"
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
			this.field3494 = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field3494[var4] = var1.readUnsignedByte();
			}

			this.field3494[var3] = 9999999;
		} else if (var2 == 4) {
			this.field3495 = true;
		} else if (var2 == 5) {
			this.field3504 = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.field3492 = var1.readUnsignedByte();
		} else if (var2 == 9) {
			this.field3496 = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.field3501 = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.field3502 = var1.readUnsignedByte();
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1343556698"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.field3496 == -1) {
			if (this.field3494 != null) {
				this.field3496 = 2;
			} else {
				this.field3496 = 0;
			}
		}

		if (this.field3501 == -1) {
			if (this.field3494 != null) {
				this.field3501 = 2;
			} else {
				this.field3501 = 0;
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ldr;II)Ldr;",
		garbageValue = "-213562589"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class173.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ldr;III)Ldr;",
		garbageValue = "1650845543"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		var2 = this.frameIds[var2];
		Frames var4 = class173.getFrames(var2 >> 16);
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ldr;II)Ldr;",
		garbageValue = "-703390998"
	)
	@Export("transformSpotAnimationModel")
	Model transformSpotAnimationModel(Model var1, int var2) {
		var2 = this.frameIds[var2];
		Frames var3 = class173.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var3 == null) {
			return var1.toSharedSpotAnimationModel(true);
		} else {
			Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
			var4.animate(var3, var2);
			return var4;
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ldr;ILiw;II)Ldr;",
		garbageValue = "1097000562"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = class173.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = class173.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.field3494);
				return var7;
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ldr;II)Ldr;",
		garbageValue = "-358919947"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		int var3 = this.frameIds[var2];
		Frames var4 = class173.getFrames(var3 >> 16);
		var3 &= 65535;
		if (var4 == null) {
			return var1.toSharedSequenceModel(true);
		} else {
			Frames var5 = null;
			int var6 = 0;
			if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
				var6 = this.chatFrameIds[var2];
				var5 = class173.getFrames(var6 >> 16);
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

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "4"
	)
	static int method4799(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.CAM_FORCEANGLE) {
			class160.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			int var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (!Client.isCameraLocked) {
				Client.camAngleX = var3;
				Client.camAngleY = var4;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_XA) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.camAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_YA) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.camAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_SETFOLLOWHEIGHT) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			if (var3 < 0) {
				var3 = 0;
			}

			Client.camFollowHeight = var3 * 1593328887;
			return 1;
		} else if (var0 == ScriptOpcodes.CAM_GETFOLLOWHEIGHT) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.camFollowHeight * 172735687;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "477248942"
	)
	static void method4770(Buffer var0) {
		if (Client.randomDatData != null) {
			var0.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}
}
