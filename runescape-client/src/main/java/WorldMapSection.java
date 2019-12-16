import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "515570621"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "2033433479"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-66"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1684413985"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lht;",
		garbageValue = "21"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "74"
	)
	@Export("read")
	void read(Buffer var1);
}
