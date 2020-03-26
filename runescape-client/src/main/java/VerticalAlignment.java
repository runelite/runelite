import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	field3193(0, 0),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(1, 1),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	field3196(2, 2);

	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1209420553
	)
	@Export("value")
	public final int value;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1378606847
	)
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-738770564"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.musicVolume != 0 && var0 != -1) {
			class74.method1321(WorldMapRegion.archive11, var0, 0, Client.musicVolume, false);
			Client.field915 = true;
		}

	}
}
