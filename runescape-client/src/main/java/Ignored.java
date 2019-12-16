import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("rq")
	@ObfuscatedGetter(
		intValue = 220663936
	)
	static int field3589;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 53560497
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lje;I)I",
		garbageValue = "1201655164"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Ljy;S)I",
		garbageValue = "9221"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}
}
