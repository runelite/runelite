import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class188 {
	@ObfuscatedName("z")
	static int[] field2322;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 823451467
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;

	static {
		new Object();
		field2322 = new int[33];
		field2322[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2322[var1] = var0 - 1;
			var0 += var0;
		}

	}
}
