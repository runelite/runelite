import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
	@ObfuscatedName("rc")
	@ObfuscatedGetter(
		intValue = -1971912431
	)
	static int field3643;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("Widget_modelsArchive")
	public static AbstractArchive Widget_modelsArchive;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 674667209
	)
	public int field3646;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("username")
	public Username username;
	@ObfuscatedName("z")
	@Export("world")
	public short world;

	@ObfuscatedSignature(
		signature = "(Ljb;I)V"
	)
	FriendLoginUpdate(Username var1, int var2) {
		this.field3646 = (int)(TaskHandler.currentTimeMillis() / 1000L);
		this.username = var1;
		this.world = (short)var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1735579843"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
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
}
