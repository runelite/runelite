import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1726409249
	)
	@Export("world")
	public int world;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1414783729
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -25627413
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1769610141"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "734760061"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-182915585"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}
}
