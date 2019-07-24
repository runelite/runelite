import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("sq")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	public static class237 field944;
	@ObfuscatedName("sw")
	@ObfuscatedSignature(
		signature = "Lb;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1117563783
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1026352463
	)
	@Export("type")
	int type;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1124430139
	)
	@Export("x")
	int x;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1248195559
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 160620695
	)
	int field935;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1900923625
	)
	int field936;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1207440287
	)
	int field933;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1651150405
	)
	@Export("id")
	int id;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1876574001
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -884568825
	)
	int field940;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1567883817
	)
	@Export("delay")
	int delay;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 783887651
	)
	@Export("hitpoints")
	int hitpoints;

	PendingSpawn() {
		this.delay = 0;
		this.hitpoints = -1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1833847542"
	)
	static void method1653(int var0, int var1) {
		long var2 = (long)((var0 << 16) + var1);
		NetFileRequest var4 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var2);
		if (var4 != null) {
			NetCache.NetCache_pendingWritesQueue.addLast(var4);
		}
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(IIIB)Lbo;",
		garbageValue = "124"
	)
	static final InterfaceParent method1652(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		GrandExchangeOfferAgeComparator.method146(var1);
		Widget var4 = class80.getWidget(var0);
		Strings.method4120(var4);
		if (Client.field850 != null) {
			Strings.method4120(Client.field850);
			Client.field850 = null;
		}

		for (int var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			if (class1.isWidgetMenuOpcode(Client.menuOpcodes[var5])) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
						Client.menuActions[var6] = Client.menuActions[var6 + 1];
						Client.menuTargetNames[var6] = Client.menuTargetNames[var6 + 1];
						Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
						Client.menuArguments0[var6] = Client.menuArguments0[var6 + 1];
						Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
						Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
						Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		GrandExchangeOfferAgeComparator.method145();
		WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var0 >> 16], var4, false);
		Canvas.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			WorldMapLabelSize.method175(Client.rootInterface, 1);
		}

		return var3;
	}
}
