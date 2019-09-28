import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("ParamDefinition")
public class ParamDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("ParamDefinition_archive")
	public static AbstractArchive ParamDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("ParamDefinition_cached")
	static EvictingDualNodeHashTable ParamDefinition_cached;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1829462559
	)
	static int field3287;
	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		signature = "Lcs;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("v")
	@Export("type")
	char type;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -76739099
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("r")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("p")
	@Export("autoDisable")
	boolean autoDisable;

	static {
		ParamDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	ParamDefinition() {
		this.autoDisable = true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-127"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "271304326"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "854773770"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.type = WorldMapEvent.method802(var1.readByte());
		} else if (var2 == 2) {
			this.defaultInt = var1.readInt();
		} else if (var2 == 4) {
			this.autoDisable = false;
		} else if (var2 == 5) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-70"
	)
	@Export("isString")
	public boolean isString() {
		return this.type == 's';
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lba;B)V",
		garbageValue = "-104"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		KeyHandler.runScript(var0, 500000);
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-786706549"
	)
	static final boolean method4480(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
