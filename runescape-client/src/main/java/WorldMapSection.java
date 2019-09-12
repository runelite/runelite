import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lag;S)V",
		garbageValue = "32767"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "950167825"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1510325414"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-771447481"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "0"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1954302512"
	)
	@Export("read")
	void read(Buffer var1);
}
