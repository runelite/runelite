import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fy")
public class class169 {
	@ObfuscatedName("q")
	static boolean field2055;
	@ObfuscatedName("w")
	static File field2050;
	@ObfuscatedName("e")
	static Hashtable field2052;
	@ObfuscatedName("l")
	@Export("isStereo")
	protected static boolean isStereo;
	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "Lke;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;

	static {
		field2055 = false;
		field2052 = new Hashtable(16);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lhp;IIIZI)V",
		garbageValue = "1090882543"
	)
	public static void method3503(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2402 = 1;
		GrandExchangeOfferNameComparator.musicTrackArchive = var0;
		class197.musicTrackGroupId = var1;
		class197.musicTrackFileId = var2;
		ScriptFrame.field529 = var3;
		BuddyRankComparator.musicTrackBoolean = var4;
		class197.field2404 = 10000;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-786180451"
	)
	static int method3501(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else {
			return 2;
		}
	}
}
