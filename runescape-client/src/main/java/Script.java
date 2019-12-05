import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lef;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("f")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("b")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("g")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1633620765
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 212878753
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -133776919
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 329828895
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Llb;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)[Llb;",
		garbageValue = "-135060615"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BIIB)Z",
		garbageValue = "27"
	)
	static final boolean method2257(byte[] var0, int var1, int var2) {
		boolean var3 = true;
		Buffer var4 = new Buffer(var0);
		int var5 = -1;

		label69:
		while (true) {
			int var6 = var4.method5710();
			if (var6 == 0) {
				return var3;
			}

			var5 += var6;
			int var7 = 0;
			boolean var8 = false;

			while (true) {
				int var9;
				while (!var8) {
					var9 = var4.readUShortSmart();
					if (var9 == 0) {
						continue label69;
					}

					var7 += var9 - 1;
					int var10 = var7 & 63;
					int var11 = var7 >> 6 & 63;
					int var12 = var4.readUnsignedByte() >> 2;
					int var13 = var11 + var1;
					int var14 = var10 + var2;
					if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
						ObjectDefinition var15 = Occluder.getObjectDefinition(var5);
						if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
							if (!var15.needsModelFiles()) {
								++Client.field850;
								var3 = false;
							}

							var8 = true;
						}
					}
				}

				var9 = var4.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var4.readUnsignedByte();
			}
		}
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "-1415762573"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (UserComparator3.loadInterface(var0)) {
			UserComparator9.updateInterface(FloorDecoration.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}
}
