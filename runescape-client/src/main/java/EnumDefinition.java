import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("iv")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("EnumDefinition_archive")
	public static AbstractArchive EnumDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("ez")
	@ObfuscatedGetter(
		intValue = -1722936721
	)
	static int field3324;
	@ObfuscatedName("e")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("p")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("k")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1879425987
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1202748617
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("i")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("c")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("f")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "49"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkf;IB)V",
		garbageValue = "19"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.inputType = (char)var1.readUnsignedByte();
		} else if (var2 == 2) {
			this.outputType = (char)var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.defaultInt = var1.readInt();
		} else {
			int var3;
			if (var2 == 5) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.strVals = new String[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.strVals[var3] = var1.readStringCp1252NullTerminated();
				}
			} else if (var2 == 6) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.intVals = new int[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.intVals[var3] = var1.readInt();
				}
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-54"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}

	@ObfuscatedName("q")
	public static final void method4550(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				long var2 = var0 - 1L;

				try {
					Thread.sleep(var2);
				} catch (InterruptedException var8) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var7) {
				}
			} else {
				try {
					Thread.sleep(var0);
				} catch (InterruptedException var6) {
				}
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-2052329100"
	)
	static int method4532(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.ADD) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var4 + var3;
			return 1;
		} else if (var0 == ScriptOpcodes.SUB) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == ScriptOpcodes.MULTIPLY) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == ScriptOpcodes.DIV) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOM) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOMINC) {
			var3 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == ScriptOpcodes.INTERPOLATE) {
			HealthBarUpdate.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
			return 1;
		} else if (var0 == ScriptOpcodes.ADDPERCENT) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 + var4 * var3 / 100;
			return 1;
		} else if (var0 == ScriptOpcodes.SETBIT) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == ScriptOpcodes.CLEARBIT) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == ScriptOpcodes.TESTBIT) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.MOD) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == ScriptOpcodes.POW) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.INVPOW) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == ScriptOpcodes.AND) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == ScriptOpcodes.OR) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SCALE) {
			HealthBarUpdate.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
			return 1;
		} else {
			return 2;
		}
	}
}
