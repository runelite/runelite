import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("y")
	public static short[][] field533;
	@ObfuscatedName("k")
	@Export("musicTrackBoolean")
	public static boolean musicTrackBoolean;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1292831283
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -95708581
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lij;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1362696328"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4355(var1) || this.archive.method4354(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lik;",
		garbageValue = "141715201"
	)
	static VerticalAlignment[] method1177() {
		return new VerticalAlignment[]{VerticalAlignment.field3200, VerticalAlignment.VerticalAlignment_centered, VerticalAlignment.field3201};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-84"
	)
	public static void method1178() {
		class96.reflectionChecks = new IterableNodeDeque();
	}
}
