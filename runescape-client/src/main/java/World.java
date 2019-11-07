import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("World")
public class World {
	@ObfuscatedName("n")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 494221483
	)
	@Export("World_count")
	static int World_count;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1998589339
	)
	@Export("World_listCount")
	static int World_listCount;
	@ObfuscatedName("o")
	@Export("World_sortOption2")
	static int[] World_sortOption2;
	@ObfuscatedName("i")
	@Export("World_sortOption1")
	static int[] World_sortOption1;
	@ObfuscatedName("am")
	static Image field996;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -962932589
	)
	@Export("id")
	int id;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -932185849
	)
	@Export("properties")
	int properties;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -148659453
	)
	@Export("population")
	int population;
	@ObfuscatedName("k")
	@Export("host")
	String host;
	@ObfuscatedName("x")
	@Export("activity")
	String activity;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1478384809
	)
	@Export("location")
	int location;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -556966481
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1210336025"
	)
	@Export("isMembersOnly")
	boolean isMembersOnly() {
		return (1 & this.properties) != 0;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-293217805"
	)
	boolean method1917() {
		return (2 & this.properties) != 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "726558642"
	)
	@Export("isPvp")
	boolean isPvp() {
		return (4 & this.properties) != 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "526640456"
	)
	boolean method1885() {
		return (8 & this.properties) != 0;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-771328937"
	)
	@Export("isDeadman")
	boolean isDeadman() {
		return (536870912 & this.properties) != 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-188040655"
	)
	@Export("isBeta")
	boolean isBeta() {
		return (33554432 & this.properties) != 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-320413166"
	)
	boolean method1887() {
		return (1073741824 & this.properties) != 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "-113"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}
}
