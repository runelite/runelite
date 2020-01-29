import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lae;I)V",
		garbageValue = "-1034100543"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "-110"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "37"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-96920779"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "911083222"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkp;B)V",
		garbageValue = "76"
	)
	@Export("read")
	void read(Buffer var1);
}
