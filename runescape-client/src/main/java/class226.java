import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class226 {
	@ObfuscatedName("gn")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1597824761"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (ScriptFrame.loadInterface(var0)) {
			WorldMapSection0.runComponentCloseListeners(WorldMapLabel.Widget_interfaceComponents[var0], var1);
		}
	}
}
