import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public final class class54 {
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field483;
	@ObfuscatedName("eo")
	@ObfuscatedGetter(
		intValue = -460965205
	)
	static int field482;
	@ObfuscatedName("kc")
	@ObfuscatedGetter(
		intValue = -612545979
	)
	@Export("menuHeight")
	static int menuHeight;

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2012474432"
	)
	static void method1105() {
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-396551795"
	)
	public static void method1104() {
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}
}
