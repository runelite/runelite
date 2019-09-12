import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 717279929
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 933713205
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -190922053
	)
	@Export("z")
	int z;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 906423943
	)
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Ldf;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIIZIZI)V",
		garbageValue = "-1345116753"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = World.World_worlds[var6];
			World.World_worlds[var6] = World.World_worlds[var1];
			World.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				World var11 = World.World_worlds[var9];
				int var12 = VerticalAlignment.compareWorlds(var11, var8, var2, var3);
				int var10;
				if (var12 != 0) {
					if (var3) {
						var10 = -var12;
					} else {
						var10 = var12;
					}
				} else if (var4 == -1) {
					var10 = 0;
				} else {
					int var13 = VerticalAlignment.compareWorlds(var11, var8, var4, var5);
					if (var5) {
						var10 = -var13;
					} else {
						var10 = var13;
					}
				}

				if (var10 <= 0) {
					World var14 = World.World_worlds[var9];
					World.World_worlds[var9] = World.World_worlds[var7];
					World.World_worlds[var7++] = var14;
				}
			}

			World.World_worlds[var1] = World.World_worlds[var7];
			World.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkz;J)V"
	)
	static void method2958(Buffer var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.writeShort((int)var1);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-214641711"
	)
	public static void method2960(boolean var0) {
		if (var0 != ItemDefinition.ItemDefinition_inMembersWorld) {
			ItemDefinition.ItemDefinition_cached.clear();
			ItemDefinition.ItemDefinition_cachedModels.clear();
			ItemDefinition.ItemDefinition_cachedSprites.clear();
			ItemDefinition.ItemDefinition_inMembersWorld = var0;
		}

	}
}
