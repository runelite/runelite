import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("ParamDefinition_archive")
	static AbstractArchive ParamDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("ParamDefinition_cached")
	static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1398808155
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("e")
	@Export("type")
	char type;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -956924169
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("k")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("l")
	@Export("autoDisable")
	boolean autoDisable;

	static {
		ParamDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	ParamDefinition() {
		this.autoDisable = true;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-67"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkf;B)V",
		garbageValue = "-1"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "506424646"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			byte var4 = var1.readByte();
			int var5 = var4 & 255;
			if (var5 == 0) {
				throw new IllegalArgumentException("" + Integer.toString(var5, 16));
			}

			if (var5 >= 128 && var5 < 160) {
				char var6 = class288.cp1252AsciiExtension[var5 - 128];
				if (var6 == 0) {
					var6 = '?';
				}

				var5 = var6;
			}

			char var3 = (char)var5;
			this.type = var3;
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "715128499"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Lin;",
		garbageValue = "1544024361"
	)
	@Export("StructDefinition_getStructDefinition")
	public static StructDefinition StructDefinition_getStructDefinition(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructDefinition.StructDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
