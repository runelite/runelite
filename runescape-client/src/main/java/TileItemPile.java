import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2023976075
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1848174955
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -957349888
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		longValue = 7030774088402658829L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1955777995
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIB)Lbj;",
		garbageValue = "126"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-75"
	)
	public static void method2728(int var0) {
		if (var0 != -1) {
			if (UserComparator3.Widget_loadedInterfaces[var0]) {
				ArchiveDiskActionHandler.Widget_archive.clearFilesGroup(var0);
				if (class289.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < class289.Widget_interfaceComponents[var0].length; ++var2) {
						if (class289.Widget_interfaceComponents[var0][var2] != null) {
							if (class289.Widget_interfaceComponents[var0][var2].type != 2) {
								class289.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						class289.Widget_interfaceComponents[var0] = null;
					}

					UserComparator3.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}
}
