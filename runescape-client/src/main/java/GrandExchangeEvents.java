import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("f")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("b")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("g")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("z")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 130975453
	)
	static int field36;
	@ObfuscatedName("u")
	@Export("events")
	public final List events;

	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	}

	@ObfuscatedSignature(
		signature = "(Lkg;Z)V",
		garbageValue = "1"
	)
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.events = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.events.add(new GrandExchangeEvent(var1, var5, var3));
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZI)V",
		garbageValue = "1634803719"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1784799744"
	)
	static final void method83() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				class3.updateActorSequence(var2, var2.definition.size);
			}
		}

	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		signature = "(Lhl;IIIIIIS)V",
		garbageValue = "3880"
	)
	static final void method82(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field908) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field908 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !JagexCache.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				ScriptEvent.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				ScriptEvent.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				ScriptEvent.invalidateWidget(var0);
				Client.field908 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				ScriptEvent.invalidateWidget(var0);
			}
		}

	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1838875215"
	)
	@Export("runIntfCloseListeners")
	static final void runIntfCloseListeners(int var0, int var1) {
		if (UserComparator3.loadInterface(var0)) {
			WorldMapIcon_0.runComponentCloseListeners(FloorDecoration.Widget_interfaceComponents[var0], var1);
		}
	}
}
