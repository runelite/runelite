import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("t")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("l")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("u")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("j")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("d")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -642929591
	)
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "[Lbu;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("p")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("e")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("q")
	static boolean field1067;
	@ObfuscatedName("y")
	static boolean field1068;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 3372955
	)
	static int field1066;
	@ObfuscatedName("o")
	static final double field1070;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field1067 = false;
		field1068 = false;
		field1066 = 0;
		field1070 = Math.log(2.0D);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lic;",
		garbageValue = "2054556426"
	)
	@Export("HitSplatDefinition_get")
	public static HitSplatDefinition HitSplatDefinition_get(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;B)Llt;",
		garbageValue = "105"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		byte[] var7 = var0.takeFile(var3, var4);
		boolean var6;
		if (var7 == null) {
			var6 = false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var7);
			var6 = true;
		}

		IndexedSprite var5;
		if (!var6) {
			var5 = null;
		} else {
			IndexedSprite var8 = new IndexedSprite();
			var8.width = class325.SpriteBuffer_spriteWidth;
			var8.height = class325.SpriteBuffer_spriteHeight;
			var8.xOffset = class325.SpriteBuffer_xOffsets[0];
			var8.yOffset = SecureRandomCallable.SpriteBuffer_yOffsets[0];
			var8.subWidth = class325.SpriteBuffer_spriteWidths[0];
			var8.subHeight = SoundSystem.SpriteBuffer_spriteHeights[0];
			var8.palette = class325.SpriteBuffer_spritePalette;
			var8.pixels = InvDefinition.SpriteBuffer_pixels[0];
			class192.SpriteBuffer_clear();
			var5 = var8;
		}

		return var5;
	}
}
