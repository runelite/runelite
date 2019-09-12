import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bb")
@Implements("World")
public class World {
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "[Lbb;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1009032865
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -816913473
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("v")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("d")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	static Widget field996;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1056642955
	)
	@Export("id")
	int id;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1368963491
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 122779381
	)
	@Export("population")
	int population;
	@ObfuscatedName("s")
	@Export("host")
	String host;
	@ObfuscatedName("p")
	@Export("activity")
	String activity;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1609624191
	)
	@Export("location")
	int location;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1550083331
	)
	@Export("index")
	int index;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "64"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-20923274"
	)
	boolean method1713() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1975172927"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1825927120"
	)
	boolean method1753() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2106663519"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1161464357"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;Ljava/lang/String;I)I",
		garbageValue = "-1736176836"
	)
	public static int method1755(Buffer var0, String var1) {
		int var2 = var0.offset;
		byte[] var3 = ChatChannel.method2212(var1);
		var0.writeSmartByteShort(var3.length);
		var0.offset += class210.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
		return var0.offset - var2;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1117911862"
	)
	static int method1762(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.GETWINDOWMODE) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class43.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.SETWINDOWMODE) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					MusicPatchNode.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.GETDEFAULTWINDOWMODE) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Actor.clientPreferences.windowMode;
				return 1;
			} else if (var0 != ScriptOpcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == 5310) {
					--class160.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					Actor.clientPreferences.windowMode = var3;
					class296.savePreferences();
				}

				return 1;
			}
		}
	}
}
