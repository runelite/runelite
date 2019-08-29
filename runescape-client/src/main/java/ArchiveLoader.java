import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("ItemDefinition_fontPlain11")
	static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1407926591
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2082038361
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lid;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "273857318"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4199(var1) || this.archive.method4185(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lcr;",
		garbageValue = "-332369983"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = GameShell.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = DesktopPlatformInfoProvider.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "114"
	)
	@Export("NpcDefinition_clearCached")
	public static void NpcDefinition_clearCached() {
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1464962568"
	)
	static int method1100(int var0, int var1) {
		int var2 = var1 - 334;
		if (var2 < 0) {
			var2 = 0;
		} else if (var2 > 100) {
			var2 = 100;
		}

		int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
		return var0 * var3 / 256;
	}
}
