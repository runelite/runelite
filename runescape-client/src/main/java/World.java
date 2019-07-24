import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("World")
public class World {
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "[Lbw;"
	)
	@Export("worlds")
	static World[] worlds;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 774267173
	)
	@Export("worldsCount")
	static int worldsCount;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2084454035
	)
	@Export("worldListWorldCount")
	static int worldListWorldCount;
	@ObfuscatedName("i")
	@Export("sortOption2")
	static int[] sortOption2;
	@ObfuscatedName("c")
	@Export("sortOption1")
	static int[] sortOption1;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lex;"
	)
	static UrlRequest field1027;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 790181133
	)
	@Export("id")
	int id;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 630491985
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -432731733
	)
	@Export("population")
	int population;
	@ObfuscatedName("r")
	@Export("host")
	String host;
	@ObfuscatedName("v")
	@Export("activity")
	String activity;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 657222747
	)
	@Export("location")
	int location;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1014616139
	)
	@Export("index")
	int index;

	static {
		worldsCount = 0;
		worldListWorldCount = 0;
		sortOption2 = new int[]{1, 1, 1, 1};
		sortOption1 = new int[]{0, 1, 2, 3};
	}

	World() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2029214211"
	)
	boolean method1682() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1353649797"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1749102436"
	)
	boolean method1698() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2068007512"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1648546006"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lkx;B)I",
		garbageValue = "80"
	)
	static int method1686(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BI)Lcx;",
		garbageValue = "-75241458"
	)
	@Export("newScript")
	static Script newScript(byte[] var0) {
		Script var1 = new Script();
		Buffer var2 = new Buffer(var0);
		var2.offset = var2.array.length - 2;
		int var3 = var2.readUnsignedShort();
		int var4 = var2.array.length - 2 - var3 - 12;
		var2.offset = var4;
		int var5 = var2.readInt();
		var1.localIntCount = var2.readUnsignedShort();
		var1.localStringCount = var2.readUnsignedShort();
		var1.intArgumentCount = var2.readUnsignedShort();
		var1.stringArgumentCount = var2.readUnsignedShort();
		int var6 = var2.readUnsignedByte();
		int var7;
		int var8;
		if (var6 > 0) {
			var1.switches = var1.method2182(var6);

			for (var7 = 0; var7 < var6; ++var7) {
				var8 = var2.readUnsignedShort();
				int var9;
				int var11;
				if (var8 > 0) {
					var11 = var8 - 1;
					var11 |= var11 >>> 1;
					var11 |= var11 >>> 2;
					var11 |= var11 >>> 4;
					var11 |= var11 >>> 8;
					var11 |= var11 >>> 16;
					int var10 = var11 + 1;
					var9 = var10;
				} else {
					var9 = 1;
				}

				IterableNodeHashTable var13 = new IterableNodeHashTable(var9);
				var1.switches[var7] = var13;

				while (var8-- > 0) {
					var11 = var2.readInt();
					int var12 = var2.readInt();
					var13.put(new IntegerNode(var12), (long)var11);
				}
			}
		}

		var2.offset = 0;
		var2.readStringCp1252NullTerminatedOrNull();
		var1.opcodes = new int[var5];
		var1.intOperands = new int[var5];
		var1.stringOperands = new String[var5];

		for (var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
			var8 = var2.readUnsignedShort();
			if (var8 == 3) {
				var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
			} else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
				var1.intOperands[var7] = var2.readInt();
			} else {
				var1.intOperands[var7] = var2.readUnsignedByte();
			}
		}

		return var1;
	}
}
