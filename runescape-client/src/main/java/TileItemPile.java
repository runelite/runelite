import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 960185027
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 518288239
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1518597633
	)
	@Export("y")
	int y;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = 1765844833924880689L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -483031039
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;Lhq;Lhq;I)V",
		garbageValue = "320810810"
	)
	@Export("Widget_setArchives")
	public static void Widget_setArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		Coord.Widget_archive = var0;
		StructDefinition.Widget_modelsArchive = var1;
		Widget.Widget_spritesArchive = var2;
		Widget.Widget_fontsArchive = var3;
		Widget.Widget_interfaceComponents = new Widget[Coord.Widget_archive.getGroupCount()][];
		class215.Widget_loadedInterfaces = new boolean[Coord.Widget_archive.getGroupCount()];
	}
}
