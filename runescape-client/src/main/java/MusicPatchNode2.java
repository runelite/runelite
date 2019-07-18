import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("fb")
	@ObfuscatedGetter(
		intValue = 1668948707
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("q")
	byte[] field2387;
	@ObfuscatedName("w")
	byte[] field2388;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1099658343
	)
	int field2392;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -369193851
	)
	int field2390;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1130103085
	)
	int field2398;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 582227349
	)
	int field2391;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 371780499
	)
	int field2393;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -273928819
	)
	int field2394;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 934948077
	)
	int field2395;

	MusicPatchNode2() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "17338"
	)
	static int method3686(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}
}
