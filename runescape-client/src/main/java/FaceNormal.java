import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgz;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -133317529
	)
	@Export("x")
	int x;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -328773159
	)
	@Export("y")
	int y;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -138913585
	)
	@Export("z")
	int z;

	FaceNormal() {
	}
}
