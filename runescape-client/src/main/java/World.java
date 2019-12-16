import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("World")
public class World {
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1287165751
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 583854419
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("x")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("a")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1519088655
	)
	@Export("id")
	int id;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1545527697
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1058065385
	)
	@Export("population")
	int population;
	@ObfuscatedName("k")
	@Export("host")
	String host;
	@ObfuscatedName("s")
	@Export("activity")
	String activity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -511848303
	)
	@Export("location")
	int location;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1131143169
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "-26711"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1453157769"
	)
	boolean method1782() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2060131341"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1753772408"
	)
	boolean method1780() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1313707308"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1940654935"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-44264871"
	)
	boolean method1775() {
		return (1073741824 & this.properties) != 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)Lik;",
		garbageValue = "20"
	)
	@Export("getEnum")
	public static EnumDefinition getEnum(int var0) {
		EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class286.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumDefinition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
