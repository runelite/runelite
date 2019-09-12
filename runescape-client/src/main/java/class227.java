import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public final class class227 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Llq;",
		garbageValue = "1253106160"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.SOLID, FillMode.field3852, FillMode.field3855};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1135145838"
	)
	public static boolean method4110(int var0) {
		return var0 >= WorldMapDecorationType.field2714.id && var0 <= WorldMapDecorationType.field2715.id;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(Ldg;I)V",
		garbageValue = "574899"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}
}
