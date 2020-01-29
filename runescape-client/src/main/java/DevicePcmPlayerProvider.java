import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class99 {
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Llc;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Ldw;",
		garbageValue = "-1842325799"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1589308129"
	)
	public static void method855() {
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

	}
}
