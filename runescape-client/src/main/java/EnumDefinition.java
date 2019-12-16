import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("y")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("w")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("p")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1935496033
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2015380105
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("x")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("a")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("d")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "-1351538350"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;II)V",
		garbageValue = "789591005"
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
		signature = "(I)I",
		garbageValue = "-1025007031"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}
}
