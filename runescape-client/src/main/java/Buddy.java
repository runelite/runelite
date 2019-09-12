import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -359902741
	)
	@Export("world")
	public int world;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 725247471
	)
	@Export("int2")
	public int int2;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -846387241
	)
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-741499831"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "293368620"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-12107"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}
}
