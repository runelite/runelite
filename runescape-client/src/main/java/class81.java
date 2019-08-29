import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class81 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lby;I)V",
		garbageValue = "1766301676"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		WorldMapIcon_1.runScript(var0, 500000);
	}
}
