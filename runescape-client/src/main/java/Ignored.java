import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lbr;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "Lfa;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -361646417
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljo;I)I",
		garbageValue = "-1242016495"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ljd;I)I",
		garbageValue = "-1938562722"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "103"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}
}
