import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class195 {
	@ObfuscatedName("d")
	public static short[][] field2359;

	static {
		new HashMap();
	}

	@ObfuscatedName("ll")
	@ObfuscatedSignature(
		signature = "(Lhi;I)I",
		garbageValue = "-906497174"
	)
	@Export("getWidgetClickMask")
	static int getWidgetClickMask(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get(((long)var0.id << 32) + (long)var0.childIndex);
		return var1 != null ? var1.integer : var0.clickMask;
	}
}
