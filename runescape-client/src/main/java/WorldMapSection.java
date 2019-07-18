import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lal;B)V",
		garbageValue = "-53"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "59484528"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "56"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIB)[I",
		garbageValue = "12"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIB)Lhv;",
		garbageValue = "-13"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "1767519038"
	)
	@Export("read")
	void read(Buffer var1);
}
