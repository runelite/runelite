import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("HealthBarUpdate")
public class HealthBarUpdate extends Node {
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = -1632744841
	)
	static int field986;
	@ObfuscatedName("az")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1232956083
	)
	@Export("cycle")
	int cycle;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -840023753
	)
	@Export("health")
	int health;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -207161283
	)
	@Export("health2")
	int health2;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 309403729
	)
	@Export("cycleOffset")
	int cycleOffset;

	HealthBarUpdate(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-782735751"
	)
	@Export("set")
	void set(int var1, int var2, int var3, int var4) {
		this.cycle = var1;
		this.health = var2;
		this.health2 = var3;
		this.cycleOffset = var4;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lil;",
		garbageValue = "-790003135"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	static int method1683() {
		return 11;
	}
}
