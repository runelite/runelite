import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("bk")
	public static String field3045;
	@ObfuscatedName("cq")
	public static String field2808;
	@ObfuscatedName("ji")
	public static String field3036;
	@ObfuscatedName("jc")
	public static String field3037;
	@ObfuscatedName("jn")
	public static String field2933;

	static {
		field3045 = "Please visit the support page for assistance.";
		field2808 = "Please visit the support page for assistance.";
		field3036 = "";
		field3037 = "Page has opened in a new window.";
		field2933 = "(Please check your popup blocker.)";
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(Lhn;III)V",
		garbageValue = "-1274264316"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null) {
				Widget var5 = var0;
				int var7 = WorldMapIcon_0.getWidgetClickMask(var0);
				int var6 = var7 >> 17 & 7;
				int var8 = var6;
				Widget var4;
				if (var6 == 0) {
					var4 = null;
				} else {
					int var9 = 0;

					while (true) {
						if (var9 >= var8) {
							var4 = var5;
							break;
						}

						var5 = Varps.getWidget(var5.parentId);
						if (var5 == null) {
							var4 = null;
							break;
						}

						++var9;
					}
				}

				Widget var10 = var4;
				if (var4 == null) {
					var10 = var0.parent;
				}

				if (var10 != null) {
					Client.clickedWidget = var0;
					var4 = ItemContainer.method1184(var0);
					if (var4 == null) {
						var4 = var0.parent;
					}

					Client.clickedWidgetParent = var4;
					Client.widgetClickX = var1;
					Client.widgetClickY = var2;
					SequenceDefinition.widgetDragDuration = 0;
					Client.isDraggingWidget = false;
					int var11 = Client.menuOptionsCount - 1;
					if (var11 != -1) {
						WorldMapRegion.tempMenuAction = new MenuAction();
						WorldMapRegion.tempMenuAction.param0 = Client.menuArguments1[var11];
						WorldMapRegion.tempMenuAction.param1 = Client.menuArguments2[var11];
						WorldMapRegion.tempMenuAction.opcode = Client.menuOpcodes[var11];
						WorldMapRegion.tempMenuAction.identifier = Client.menuIdentifiers[var11];
						WorldMapRegion.tempMenuAction.action = Client.menuActions[var11];
					}

					return;
				}
			}

		}
	}
}
