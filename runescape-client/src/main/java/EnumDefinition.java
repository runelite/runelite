import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("o")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("e")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("i")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 763609869
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1620263743
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("l")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("j")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("m")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-1295672156"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkp;II)V",
		garbageValue = "1239403484"
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

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1222306007"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)Les;",
		garbageValue = "-1471944994"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			AbstractArchive var3 = Canvas.SequenceDefinition_animationsArchive;
			AbstractArchive var4 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
			boolean var5 = true;
			int[] var6 = var3.getGroupFileIds(var0);

			for (int var7 = 0; var7 < var6.length; ++var7) {
				byte[] var8 = var3.getFile(var0, var6[var7]);
				if (var8 == null) {
					var5 = false;
				} else {
					int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
					byte[] var10 = var4.getFile(var9, 0);
					if (var10 == null) {
						var5 = false;
					}
				}
			}

			Frames var2;
			if (!var5) {
				var2 = null;
			} else {
				try {
					var2 = new Frames(var3, var4, var0, false);
				} catch (Exception var12) {
					var2 = null;
				}
			}

			if (var2 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var2, (long)var0);
			}

			return var2;
		}
	}
}
