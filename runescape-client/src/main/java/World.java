import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("World")
public class World {
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1559226187
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 315503089
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("q")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("x")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("ka")
	@ObfuscatedGetter(
		intValue = 1149397885
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1230812985
	)
	@Export("id")
	int id;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1926875123
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -999023629
	)
	@Export("population")
	int population;
	@ObfuscatedName("y")
	@Export("host")
	String host;
	@ObfuscatedName("p")
	@Export("activity")
	String activity;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -307094013
	)
	@Export("location")
	int location;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 392698997
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1463155043"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1651148983"
	)
	boolean method1687() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2074539917"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "128"
	)
	boolean method1689() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1238207705"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "877895545"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;IIB)Z",
		garbageValue = "-20"
	)
	@Export("SpriteBuffer_bufferFile")
	public static boolean SpriteBuffer_bufferFile(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			Player.SpriteBuffer_decode(var3);
			return true;
		}
	}
}
