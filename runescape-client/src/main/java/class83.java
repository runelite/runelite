import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ch")
public class class83 {
	@ObfuscatedName("u")
	static final BigInteger field1158;
	@ObfuscatedName("f")
	static final BigInteger field1160;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("NetCache_reference")
	static Buffer NetCache_reference;

	static {
		field1158 = new BigInteger("10001", 16);
		field1160 = new BigInteger("94e80a7ee588d1a5fb0774efe8f6014553fea4aa4055827491c7e94dff7547dde03cd70414c02606e8d2ef1bcb94156dfb4f4abd7b407d9a9956eec5d65bf0afa119cbbef760e19e26954f30fc19a91f3cd3cef7e9bf824f15d2b41f2fa4c59059d88212a350ada947c584a6a1b1e01ce33399aeb88dade6d1e4601f5be82cbb", 16);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;Lhf;I)V",
		garbageValue = "568934897"
	)
	public static void method2090(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		SequenceDefinition.SequenceDefinition_animationsArchive = var1;
		SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "480831567"
	)
	static int method2091(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
			EnumDefinition var5 = Language.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
				EnumDefinition var10 = Language.getEnum(var3);
				Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 3];
			EnumDefinition var7 = Language.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}
}
