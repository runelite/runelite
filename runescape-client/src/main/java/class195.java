import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class195 {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIIIB)I",
		garbageValue = "90"
	)
	static final int method3695(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhe;IS)V",
		garbageValue = "-23676"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2555 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2706 == null) {
				var0.field2706 = new int[var0.field2555.length];
			}

			var0.field2706[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "2095745244"
	)
	static final void method3696(String var0) {
		GrandExchangeEvent.method165("Please remove " + var0 + " from your friend list first");
	}
}
