import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2093810797
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljn;I)I",
		garbageValue = "1947810954"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljh;I)I",
		garbageValue = "-531306911"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}
}
