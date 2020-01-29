import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 625683847
	)
	public int field3632;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljz;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("i")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Ljz;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3632 = (int)(WorldMapIcon_0.currentTimeMillis() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}

	@ObfuscatedName("c")
	public static final void method5325(long var0) {
		if (var0 > 0L) {
			if (var0 % 10L == 0L) {
				World.method1801(var0 - 1L);
				World.method1801(1L);
			} else {
				World.method1801(var0);
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/String;[SIII)V",
		garbageValue = "2127417563"
	)
	@Export("sortItemsByName")
	public static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var4 = (var3 + var2) / 2;
			int var5 = var2;
			String var6 = var0[var4];
			var0[var4] = var0[var3];
			var0[var3] = var6;
			short var7 = var1[var4];
			var1[var4] = var1[var3];
			var1[var3] = var7;

			for (int var8 = var2; var8 < var3; ++var8) {
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
					String var9 = var0[var8];
					var0[var8] = var0[var5];
					var0[var5] = var9;
					short var10 = var1[var8];
					var1[var8] = var1[var5];
					var1[var5++] = var10;
				}
			}

			var0[var3] = var0[var5];
			var0[var5] = var6;
			var1[var3] = var1[var5];
			var1[var5] = var7;
			sortItemsByName(var0, var1, var2, var5 - 1);
			sortItemsByName(var0, var1, var5 + 1, var3);
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1669041813"
	)
	public static boolean method5326(int var0) {
		return (var0 >> 29 & 1) != 0;
	}
}
