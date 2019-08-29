import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 79767661
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhd;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhd;Lhd;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("s")
	static boolean method730(long var0) {
		return class40.method729(var0) == 2;
	}
}
