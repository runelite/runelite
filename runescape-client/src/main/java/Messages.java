import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cq")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("u")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llb;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 2018287287
	)
	@Export("Messages_count")
	static int Messages_count;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1088425627
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lat;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhg;I)V",
		garbageValue = "-1903945924"
	)
	public static void method2230(Huffman var0) {
		class210.huffman = var0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "-1564166931"
	)
	static int method2241(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1090 : class188.field2352;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.method1655(MenuAction.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}
}
