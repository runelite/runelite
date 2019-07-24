import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class60 {
	@ObfuscatedName("ac")
	@Export("null_string")
	protected static String null_string;

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(Lhj;III)V",
		garbageValue = "1446112965"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null && ArchiveLoader.method1099(var0) != null) {
				Client.clickedWidget = var0;
				Client.clickedWidgetParent = ArchiveLoader.method1099(var0);
				Client.widgetClickX = var1;
				Client.widgetClickY = var2;
				class80.widgetDragDuration = 0;
				Client.isDraggingWidget = false;
				int var3 = class13.method151();
				if (var3 != -1) {
					Decimator.method2510(var3);
				}

			}
		}
	}
}
