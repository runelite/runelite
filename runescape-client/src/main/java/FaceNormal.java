import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2144913037
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2071532839
	)
	@Export("y")
	int y;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1947716121
	)
	@Export("z")
	int z;

	FaceNormal() {
	}
}
