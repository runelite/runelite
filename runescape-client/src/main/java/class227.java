import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public final class class227 {
	@ObfuscatedName("ny")
	@ObfuscatedGetter(
		intValue = 130681721
	)
	static int field3061;

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(Lho;IIS)V",
		garbageValue = "16256"
	)
	@Export("clickWidget")
	static final void clickWidget(Widget var0, int var1, int var2) {
		if (Client.clickedWidget == null && !Client.isMenuOpen) {
			if (var0 != null) {
				Widget var4 = GrandExchangeEvents.method81(var0);
				if (var4 == null) {
					var4 = var0.parent;
				}

				if (var4 != null) {
					Client.clickedWidget = var0;
					var4 = GrandExchangeEvents.method81(var0);
					if (var4 == null) {
						var4 = var0.parent;
					}

					Client.clickedWidgetParent = var4;
					Client.widgetClickX = var1;
					Client.widgetClickY = var2;
					ViewportMouse.widgetDragDuration = 0;
					Client.isDraggingWidget = false;
					int var5 = BuddyRankComparator.getNewestMenuIdx();
					if (var5 != -1) {
						ChatChannel.method2229(var5);
					}

					return;
				}
			}

		}
	}
}
