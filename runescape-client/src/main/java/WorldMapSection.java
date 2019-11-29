import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Laf;I)V",
		garbageValue = "-567179164"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IIIB)Z",
		garbageValue = "0"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "110675609"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "69"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)Lhx;",
		garbageValue = "1062204141"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-179898655"
	)
	@Export("read")
	void read(Buffer var1);
}
