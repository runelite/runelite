import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("kk")
	@ObfuscatedGetter(
		intValue = -2016617893
	)
	@Export("menuHeight")
	static int menuHeight;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 153550735
	)
	@Export("x")
	int x;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1428823539
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1573119105
	)
	@Export("z")
	int z;

	FaceNormal() {
	}
}
