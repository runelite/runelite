import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fy")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("q")
	@Export("FileSystem_hasPermissions")
	static boolean FileSystem_hasPermissions;
	@ObfuscatedName("w")
	@Export("FileSystem_cacheDir")
	static File FileSystem_cacheDir;
	@ObfuscatedName("e")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;
	@ObfuscatedName("l")
	@Export("PcmPlayer_stereo")
	protected static boolean PcmPlayer_stereo;
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
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lhp;IIIZI)V",
		garbageValue = "1090882543"
	)
	public static void method3503(AbstractArchive var0, int group, int file, int bitRateMaybe, boolean _false) {
		class197.field2402 = 1;
		GrandExchangeOfferNameComparator.musicTrackArchive = var0;
		class197.musicTrackGroupId = group;
		class197.musicTrackFileId = file;
		ScriptFrame.field529 = bitRateMaybe;
		BuddyRankComparator.musicTrackBoolean = _false;
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
		}
		if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		}
		if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		}
		return 2;
	}
}
