import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public enum class192 implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2375("", 0, new class191[]{class191.field2364}),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2367("", 1, new class191[]{class191.field2362, class191.field2364}),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2368("", 2, new class191[]{class191.field2362, class191.field2365, class191.field2364}),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2381("", 3, new class191[]{class191.field2362}),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2370("", 4),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2373("", 5, new class191[]{class191.field2362, class191.field2364}),
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2372("", 6, new class191[]{class191.field2364}),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2376("", 8, new class191[]{class191.field2362, class191.field2364}),
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2374("", 9, new class191[]{class191.field2362, class191.field2365}),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2369("", 10, new class191[]{class191.field2362}),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2371("", 11, new class191[]{class191.field2362}),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2377("", 12, new class191[]{class191.field2362, class191.field2364}),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2378("", 13, new class191[]{class191.field2362});

	@ObfuscatedName("dl")
	@ObfuscatedGetter(
		longValue = -5559382654824697645L
	)
	static long field2382;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -646625045
	)
	final int field2379;
	@ObfuscatedName("v")
	final Set field2380;

	static {
		method3674();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgj;)V"
	)
	class192(String var3, int var4, class191[] var5) {
		this.field2380 = new HashSet();
		this.field2379 = var4;
		class191[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class191 var8 = var6[var7];
			this.field2380.add(var8);
		}

	}

	class192(String var3, int var4) {
		this.field2380 = new HashSet();
		this.field2379 = var4;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	public int rsOrdinal() {
		return this.field2379;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "69"
	)
	static int method3679(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lgd;",
		garbageValue = "858782431"
	)
	static class192[] method3674() {
		return new class192[]{field2377, field2374, field2369, field2378, field2372, field2373, field2381, field2367, field2371, field2370, field2376, field2368, field2375};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "46"
	)
	public static void method3678() {
		class96.reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)Z",
		garbageValue = "-31"
	)
	public static boolean method3677(CharSequence var0) {
		boolean var2 = false;
		boolean var3 = false;
		int var4 = 0;
		int var5 = var0.length();
		int var6 = 0;

		boolean var1;
		while (true) {
			if (var6 >= var5) {
				var1 = var3;
				break;
			}

			label82: {
				char var7 = var0.charAt(var6);
				if (var6 == 0) {
					if (var7 == '-') {
						var2 = true;
						break label82;
					}

					if (var7 == '+') {
						break label82;
					}
				}

				int var9;
				if (var7 >= '0' && var7 <= '9') {
					var9 = var7 - '0';
				} else if (var7 >= 'A' && var7 <= 'Z') {
					var9 = var7 - '7';
				} else {
					if (var7 < 'a' || var7 > 'z') {
						var1 = false;
						break;
					}

					var9 = var7 - 'W';
				}

				if (var9 >= 10) {
					var1 = false;
					break;
				}

				if (var2) {
					var9 = -var9;
				}

				int var8 = var9 + var4 * 10;
				if (var4 != var8 / 10) {
					var1 = false;
					break;
				}

				var4 = var8;
				var3 = true;
			}

			++var6;
		}

		return var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-881071999"
	)
	@Export("changeWorldSelectSorting")
	static void changeWorldSelectSorting(int var0, int var1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = var0;
		var3[0] = var1;
		int var4 = 1;

		for (int var5 = 0; var5 < 4; ++var5) {
			if (World.sortOption1[var5] != var0) {
				var2[var4] = World.sortOption1[var5];
				var3[var4] = World.sortOption2[var5];
				++var4;
			}
		}

		World.sortOption1 = var2;
		World.sortOption2 = var3;
		Client.sortWorlds(World.worlds, 0, World.worlds.length - 1, World.sortOption1, World.sortOption2);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-72629118"
	)
	static int method3669(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.nextDual).count;
		}
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "2005954129"
	)
	static void method3675(int var0) {
		Client.oculusOrbState = var0;
	}
}
