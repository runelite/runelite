import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gc")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 977117713
	)
	@Export("WorldMapElement_count")
	public static int WorldMapElement_count;

	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "19"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "-93"
	)
	@Export("set")
	abstract void set(byte[] var1);

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "2005076338"
	)
	static int method4093(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class96.field1301 : ReflectionCheck.field1310;
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) {
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETID) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.childIndex;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-66"
	)
	static final void method4092() {
		Client.field825 = Client.cycleCntr;
		Ignored.ClanChat_inClanChat = true;
	}
}
