import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -914762705
	)
	@Export("cacheGamebuild")
	static int cacheGamebuild;
	@ObfuscatedName("cx")
	@ObfuscatedGetter(
		intValue = -435303731
	)
	public static int field1732;
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	static AbstractSocket field1730;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2142857667
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -62403169
	)
	@Export("y")
	int y;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -2087129489
	)
	@Export("z")
	int z;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1861306347
	)
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Ldm;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1271488083"
	)
	static final void method2996() {
		Tiles.method1143("Your ignore list is full. Max of 100 for free users, and 400 for members");
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-68"
	)
	static final void method2995() {
		Client.field711 = Client.cycleCntr;
	}
}
