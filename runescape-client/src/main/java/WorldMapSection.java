import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lac;I)V",
		garbageValue = "2098672163"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-327883108"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-1535371561"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-1322751923"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(III)Lhb;",
		garbageValue = "1439979703"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkl;B)V",
		garbageValue = "-99"
	)
	@Export("read")
	void read(Buffer var1);
}
