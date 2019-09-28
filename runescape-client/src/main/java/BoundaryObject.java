import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive3")
	static Archive archive3;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -21907105
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 614934347
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -602196191
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1866626591
	)
	@Export("y")
	int y;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1916194803
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = 7018407287880452951L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -461421073
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "31"
	)
	static final boolean method3226(char var0) {
		return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
	}
}
