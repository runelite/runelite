import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class162 implements class161 {
	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lhz;B)V",
		garbageValue = "-41"
	)
	@Export("Widget_setArchives")
	public static void Widget_setArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		ArchiveDiskActionHandler.Widget_archive = var0;
		class293.Widget_modelsArchive = var1;
		HealthBar.Widget_spritesArchive = var2;
		WorldMapSprite.Widget_fontsArchive = var3;
		class289.Widget_interfaceComponents = new Widget[ArchiveDiskActionHandler.Widget_archive.getGroupCount()][];
		UserComparator3.Widget_loadedInterfaces = new boolean[ArchiveDiskActionHandler.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "849753199"
	)
	public static void method3424() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}
}
