import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class13 {
	@ObfuscatedName("ph")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("u")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;
	@ObfuscatedName("fl")
	@ObfuscatedGetter(
		intValue = 251089855
	)
	static int field86;

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2019445380"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1076455788"
	)
	@Export("ParamDefinition_clearCached")
	public static void ParamDefinition_clearCached() {
		ParamDefinition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1012366175"
	)
	static final int method162(int var0, int var1) {
		int var2 = WorldMapAreaData.method650(var0 - 1, var1 - 1) + WorldMapAreaData.method650(1 + var0, var1 - 1) + WorldMapAreaData.method650(var0 - 1, var1 + 1) + WorldMapAreaData.method650(var0 + 1, var1 + 1);
		int var3 = WorldMapAreaData.method650(var0 - 1, var1) + WorldMapAreaData.method650(var0 + 1, var1) + WorldMapAreaData.method650(var0, var1 - 1) + WorldMapAreaData.method650(var0, 1 + var1);
		int var4 = WorldMapAreaData.method650(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1410119824"
	)
	static void method163() {
		Login.worldSelectOpen = false;
		Login.leftTitleSprite.drawAt(Login.xPadding, 0);
		Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
		class51.logoSprite.drawAt(Login.xPadding + 382 - class51.logoSprite.subWidth / 2, 18);
	}
}
