import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("il")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("FloorUnderlayDefinition_archive")
	public static AbstractArchive FloorUnderlayDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("FloorUnderlayDefinition_cached")
	static EvictingDualNodeHashTable FloorUnderlayDefinition_cached;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 502539723
	)
	@Export("rgb")
	int rgb;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -387630933
	)
	@Export("hue")
	public int hue;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1309988489
	)
	@Export("saturation")
	public int saturation;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1550343627
	)
	@Export("lightness")
	public int lightness;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 241046707
	)
	@Export("hueMultiplier")
	public int hueMultiplier;

	static {
		FloorUnderlayDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	FloorUnderlayDefinition() {
		this.rgb = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2017124449"
	)
	@Export("postDecode")
	void postDecode() {
		this.setHsl(this.rgb);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "-336580480"
	)
	@Export("decode")
	void decode(Buffer var1, int var2) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.decodeNext(var1, var3, var2);
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkz;III)V",
		garbageValue = "1777076366"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2, int var3) {
		if (var2 == 1) {
			this.rgb = var1.readMedium();
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1419999023"
	)
	@Export("setHsl")
	void setHsl(int var1) {
		double var2 = (double)(var1 >> 16 & 255) / 256.0D;
		double var4 = (double)(var1 >> 8 & 255) / 256.0D;
		double var6 = (double)(var1 & 255) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}

		if (var6 < var8) {
			var8 = var6;
		}

		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}

		if (var6 > var10) {
			var10 = var6;
		}

		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var10 + var8) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}

			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}

			if (var10 == var2) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var10 == var4) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var6 == var10) {
				var12 = (var2 - var4) / (var10 - var8) + 4.0D;
			}
		}

		var12 /= 6.0D;
		this.saturation = (int)(256.0D * var14);
		this.lightness = (int)(256.0D * var16);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

		if (var16 > 0.5D) {
			this.hueMultiplier = (int)((1.0D - var16) * var14 * 512.0D);
		} else {
			this.hueMultiplier = (int)(512.0D * var16 * var14);
		}

		if (this.hueMultiplier < 1) {
			this.hueMultiplier = 1;
		}

		this.hue = (int)((double)this.hueMultiplier * var12);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "1"
	)
	static int method4423(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			class160.Interpreter_intStackSize -= 3;
			class192.queueSoundEffect(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			WorldMapData_1.playSong(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			class160.Interpreter_intStackSize -= 2;
			SecureRandomCallable.playSoundJingle(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "(Lby;IIB)V",
		garbageValue = "0"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = class83.SequenceDefinition_get(var1).field3502;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field924 = 0;
			}

			if (var3 == 2) {
				var0.field924 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || class83.SequenceDefinition_get(var1).field3504 >= class83.SequenceDefinition_get(var0.sequence).field3504) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field924 = 0;
			var0.field969 = var0.pathLength;
		}

	}
}
