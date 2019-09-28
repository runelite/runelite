import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("EnumDefinition_archive")
	public static AbstractArchive EnumDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("v")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("u")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("r")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 213418595
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1372083607
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("m")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("y")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("i")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1933011246"
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
		garbageValue = "1574226398"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1423753567"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "54"
	)
	static final void method4508(String var0) {
		class210.addGameMessage(30, "", var0);
	}
}
