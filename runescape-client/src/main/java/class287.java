import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
public class class287 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(IIIB)Lbe;",
		garbageValue = "27"
	)
	static final InterfaceParent method5327(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		class51.Widget_resetModelFrames(var1);
		Widget var4 = Varps.getWidget(var0);
		NPCDefinition.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			NPCDefinition.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		GameObject.method3360();
		WorldMapIcon_1.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var0 >> 16], var4, false);
		WorldMapLabelSize.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			class226.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
