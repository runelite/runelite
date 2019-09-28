import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("iq")
@Implements("VarpDefinition")
public class VarpDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("VarpDefinition_archive")
	public static AbstractArchive VarpDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1786777659
	)
	@Export("VarpDefinition_fileCount")
	public static int VarpDefinition_fileCount;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("VarpDefinition_cached")
	static EvictingDualNodeHashTable VarpDefinition_cached;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 223624365
	)
	@Export("type")
	public int type;

	static {
		VarpDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	VarpDefinition() {
		this.type = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "769888015"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "217607439"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) {
			this.type = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1744608160"
	)
	static int method4347(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
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
}
