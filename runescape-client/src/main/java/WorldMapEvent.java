import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 945320021
	)
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		signature = "(ILhf;Lhf;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "87"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.musicVolume != 0 && var0 != -1) {
			MusicPatchNode2.playMusicTrack(Decimator.archive11, var0, 0, Client.musicVolume, false);
			Client.field855 = true;
		}

	}
}
