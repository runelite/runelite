import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class65 extends RouteStrategy {
	class65() {
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIILfa;B)Z",
		garbageValue = "27"
	)
	@Export("hasArrived")
	protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "42"
	)
	static int method1245(int var0, int var1, int var2) {
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)Ljava/lang/String;",
		garbageValue = "-714921437"
	)
	public static String method1250(Buffer var0) {
		return TilePaint.method3042(var0, 32767);
	}
}
