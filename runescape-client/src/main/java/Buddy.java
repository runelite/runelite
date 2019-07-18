import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("ss")
	@ObfuscatedGetter(
		longValue = 7424240758646581017L
	)
	static long field3632;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 90340793
	)
	@Export("world")
	public int world;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1246846103
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -247571967
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1729653997"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "212736889"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-4"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1131109761"
	)
	public static int method5170(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	static int method5176() {
		if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoaderArchive; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field927;
		} else {
			return 10000;
		}
	}
}
