import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("ParamDefinition_archive")
	public static AbstractArchive ParamDefinition_archive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("ParamDefinition_cached")
	public static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -508885991
	)
	@Export("PcmPlayer_count")
	public static int PcmPlayer_count;
	@ObfuscatedName("n")
	@Export("type")
	char type;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1697387683
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("v")
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-767348576"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "95444095"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkc;II)V",
		garbageValue = "130264768"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.type = Ignored.method5284(var1.readByte());
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1179619328"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}
}
