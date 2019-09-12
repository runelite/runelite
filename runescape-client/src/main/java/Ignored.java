import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -741331501
	)
	static int field3577;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2731755
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lja;I)I",
		garbageValue = "-1305970112"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Ljw;B)I",
		garbageValue = "-92"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}
}
