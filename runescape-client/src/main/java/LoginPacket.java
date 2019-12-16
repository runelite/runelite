import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fm")
@Implements("LoginPacket")
public class LoginPacket implements class175 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	public static final LoginPacket field2282;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	static final LoginPacket field2288;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	public static final LoginPacket field2285;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	public static final LoginPacket field2283;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	static final LoginPacket field2284;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "[Lfm;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1664908847
	)
	@Export("id")
	public final int id;

	static {
		field2282 = new LoginPacket(14, 0);
		field2288 = new LoginPacket(15, 4);
		field2285 = new LoginPacket(16, -2);
		field2283 = new LoginPacket(18, -2);
		field2284 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = new LoginPacket[]{field2288, field2285, field2282, field2283, field2284};
		LoginPacket[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			LoginPacket_indexedValues[var1[var2].id] = var1[var2];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lbs;",
		garbageValue = "-2092272344"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1470208015"
	)
	static int method3575(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Tile.getWidget(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? UserComparator7.field1946 : class197.field2398;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1079 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field557 = Interpreter.field1079 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "5"
	)
	static final void method3574() {
		Client.field678 = 0;
		int var0 = MusicPatchPcmStream.baseX * 64 + (Message.localPlayer.x >> 7);
		int var1 = ScriptEvent.baseY * 64 + (Message.localPlayer.y >> 7);
		if (var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
			Client.field678 = 1;
		}

		if (var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
			Client.field678 = 1;
		}

		if (Client.field678 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
			Client.field678 = 0;
		}

	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "(IIIZB)V",
		garbageValue = "58"
	)
	static final void method3572(int var0, int var1, int var2, boolean var3) {
		if (MusicPatch.loadInterface(var0)) {
			FloorOverlayDefinition.resizeInterface(UserComparator7.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}

	@ObfuscatedName("jj")
	@ObfuscatedSignature(
		signature = "(Lha;B)V",
		garbageValue = "67"
	)
	@Export("invalidateWidget")
	static void invalidateWidget(Widget var0) {
		if (var0.cycle == Client.field832) {
			Client.field833[var0.rootIndex] = true;
		}

	}
}
