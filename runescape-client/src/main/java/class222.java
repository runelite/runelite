import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class222 {
	@ObfuscatedName("gx")
	@Export("regionLandArchiveIds")
	static int[] regionLandArchiveIds;
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-785436226"
	)
	static void method4090() {
		if (MouseRecorder.loadWorlds()) {
			Login.worldSelectOpen = true;
			Login.worldSelectPage = 0;
			Login.worldSelectPagesCount = 0;
		}

	}
}
