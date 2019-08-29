import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class223 {
	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "4"
	)
	static void method4036(int var0, int var1, int var2, int var3) {
		Widget var4 = ModelData0.getWidgetChild(var0, var1);
		if (var4 != null && var4.onTargetEnter != null) {
			ScriptEvent var5 = new ScriptEvent();
			var5.widget = var4;
			var5.args = var4.onTargetEnter;
			class81.runScriptEvent(var5);
		}

		Client.field736 = var3;
		Client.isSpellSelected = true;
		NetCache.field3162 = var0;
		Client.field816 = var1;
		WorldMapSectionType.selectedSpellFlags = var2;
		FriendSystem.invalidateWidget(var4);
	}
}
