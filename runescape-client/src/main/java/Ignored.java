import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("a")
	public static String[] field3610;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -2146797941
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lji;I)I",
		garbageValue = "-463772537"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljr;B)I",
		garbageValue = "41"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}
}
