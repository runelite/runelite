import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("EnumDefinition_archive")
	static AbstractArchive EnumDefinition_archive;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("k")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("d")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("w")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1168542031
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 744835807
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("z")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("t")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("e")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "1803562371"
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkb;II)V",
		garbageValue = "-1795608149"
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1493924915"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-530273467"
	)
	public static void method4614(int var0) {
		if (var0 != -1) {
			if (Widget.Widget_loadedInterfaces[var0]) {
				Widget.Widget_archive.clearFilesGroup(var0);
				if (Widget.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
						if (Widget.Widget_interfaceComponents[var0][var2] != null) {
							if (Widget.Widget_interfaceComponents[var0][var2].type != 2) {
								Widget.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						Widget.Widget_interfaceComponents[var0] = null;
					}

					Widget.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}
}
