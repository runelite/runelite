import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Laa;B)V",
		garbageValue = "-111"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-1417818612"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2132898041"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1209167521"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIS)Lhf;",
		garbageValue = "7283"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-568369534"
	)
	@Export("read")
	void read(Buffer var1);
}
