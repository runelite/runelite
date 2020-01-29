import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("World")
public class World {
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1866587551
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1158665881
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("l")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("j")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Leg;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1411281577
	)
	@Export("id")
	int id;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 2119129825
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 2120621835
	)
	@Export("population")
	int population;
	@ObfuscatedName("n")
	@Export("host")
	String host;
	@ObfuscatedName("x")
	@Export("activity")
	String activity;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1248235399
	)
	@Export("location")
	int location;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1361119187
	)
	@Export("index")
	int index;

	static {
		World_count = 0;
		World_listCount = 0;
		World_sortOption2 = new int[]{1, 1, 1, 1};
		World_sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "1"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "36"
	)
	boolean method1760() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-764508558"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1545787389"
	)
	boolean method1787() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "1"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1183174451"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1307940370"
	)
	boolean method1767() {
		return (1073741824 & this.properties) != 0;
	}

	@ObfuscatedName("t")
	static final void method1801(long var0) {
		try {
			Thread.sleep(var0);
		} catch (InterruptedException var3) {
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IILfk;Lfv;I)Z",
		garbageValue = "-186074271"
	)
	public static final boolean method1770(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
		int var4 = var0;
		int var5 = var1;
		byte var6 = 64;
		byte var7 = 64;
		int var8 = var0 - var6;
		int var9 = var1 - var7;
		class173.directions[var6][var7] = 99;
		class173.distances[var6][var7] = 0;
		byte var10 = 0;
		int var11 = 0;
		class173.bufferX[var10] = var0;
		byte var10001 = var10;
		int var18 = var10 + 1;
		class173.bufferY[var10001] = var1;
		int[][] var12 = var3.flags;

		while (var18 != var11) {
			var4 = class173.bufferX[var11];
			var5 = class173.bufferY[var11];
			var11 = var11 + 1 & 4095;
			int var16 = var4 - var8;
			int var17 = var5 - var9;
			int var13 = var4 - var3.xInset;
			int var14 = var5 - var3.yInset;
			if (var2.hasArrived(2, var4, var5, var3)) {
				ChatChannel.field1289 = var4;
				class173.field2093 = var5;
				return true;
			}

			int var15 = class173.distances[var16][var17] + 1;
			if (var16 > 0 && class173.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17] = 2;
				class173.distances[var16 - 1][var17] = var15;
			}

			if (var16 < 126 && class173.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17] = 8;
				class173.distances[var16 + 1][var17] = var15;
			}

			if (var17 > 0 && class173.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 - 1] = 1;
				class173.distances[var16][var17 - 1] = var15;
			}

			if (var17 < 126 && class173.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
				class173.bufferX[var18] = var4;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16][var17 + 1] = 4;
				class173.distances[var16][var17 + 1] = var15;
			}

			if (var16 > 0 && var17 > 0 && class173.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 - 1] = 3;
				class173.distances[var16 - 1][var17 - 1] = var15;
			}

			if (var16 < 126 && var17 > 0 && class173.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 - 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 - 1] = 9;
				class173.distances[var16 + 1][var17 - 1] = var15;
			}

			if (var16 > 0 && var17 < 126 && class173.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
				class173.bufferX[var18] = var4 - 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 - 1][var17 + 1] = 6;
				class173.distances[var16 - 1][var17 + 1] = var15;
			}

			if (var16 < 126 && var17 < 126 && class173.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
				class173.bufferX[var18] = var4 + 1;
				class173.bufferY[var18] = var5 + 1;
				var18 = var18 + 1 & 4095;
				class173.directions[var16 + 1][var17 + 1] = 12;
				class173.distances[var16 + 1][var17 + 1] = var15;
			}
		}

		ChatChannel.field1289 = var4;
		class173.field2093 = var5;
		return false;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1273195728"
	)
	static void method1762() {
		if (UserComparator8.loadWorlds()) {
			Login.worldSelectOpen = true;
			Login.worldSelectPage = 0;
			Login.worldSelectPagesCount = 0;
		}

	}
}
