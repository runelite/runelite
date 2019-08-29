import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapSection")
public interface WorldMapSection {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lav;I)V",
		garbageValue = "-1068467910"
	)
	@Export("expandBounds")
	void expandBounds(WorldMapArea var1);

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "1014871771"
	)
	@Export("containsCoord")
	boolean containsCoord(int var1, int var2, int var3);

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "694688168"
	)
	@Export("containsPosition")
	boolean containsPosition(int var1, int var2);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-45443461"
	)
	@Export("getBorderTileLengths")
	int[] getBorderTileLengths(int var1, int var2, int var3);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)Lhd;",
		garbageValue = "1267204541"
	)
	@Export("coord")
	Coord coord(int var1, int var2);

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "1072299144"
	)
	@Export("read")
	void read(Buffer var1);
}
