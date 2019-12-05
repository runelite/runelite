import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class60 {
	@ObfuscatedName("qc")
	@ObfuscatedSignature(
		signature = "Lde;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("eg")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive20")
	static Archive archive20;

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lhf;Lhf;III)Lky;",
		garbageValue = "-2011149056"
	)
	public static Font method1195(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		return !GraphicsObject.method2030(var0, var2, var3) ? null : FloorOverlayDefinition.method4853(var1.takeFile(var2, var3));
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-30"
	)
	public static void method1194() {
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1426936698"
	)
	static final void method1193(int var0) {
		if (var0 >= 0) {
			int var1 = Client.menuArguments1[var0];
			int var2 = Client.menuArguments2[var0];
			int var3 = Client.menuOpcodes[var0];
			int var4 = Client.menuIdentifiers[var0];
			String var5 = Client.menuActions[var0];
			String var6 = Client.menuTargets[var0];
			class32.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
		}
	}
}
