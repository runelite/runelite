import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("en")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1358140077
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 915149021
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1541741189
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -696517801
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 748186775
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1886905411
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -275876635
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = 1621741553403153851L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -183294239
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;I)Ljava/lang/String;",
		garbageValue = "267409657"
	)
	public static String method3356(Buffer var0) {
		return method3358(var0, 32767);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;II)Ljava/lang/String;",
		garbageValue = "149938652"
	)
	static String method3358(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = ScriptFrame.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "777331787"
	)
	public static void method3359() {
		WorldMapElement.WorldMapElement_cachedSprites.clear();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "2015482933"
	)
	static int method3357(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) {
			class320.Interpreter_intStackSize -= 3;
			AbstractWorldMapIcon.queueSoundEffect(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 2]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_SONG) {
			BufferedSink.playSong(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
			return 1;
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) {
			class320.Interpreter_intStackSize -= 2;
			class49.playSoundJingle(Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class320.Interpreter_intStackSize + 1]);
			return 1;
		} else {
			return 2;
		}
	}
}
