import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("Ignored")
public class Ignored extends User {
	@ObfuscatedName("pw")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1062228261
	)
	@Export("id")
	int id;

	Ignored() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lji;B)I",
		garbageValue = "8"
	)
	@Export("compareTo_ignored")
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(Ljg;I)I",
		garbageValue = "105019827"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored)var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(BI)C",
		garbageValue = "-1328701707"
	)
	public static char method5284(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class287.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}
}
