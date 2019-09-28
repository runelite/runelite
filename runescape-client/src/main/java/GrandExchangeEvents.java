import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("n")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("v")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("u")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("r")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("z")
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
		signature = "(Lkl;Z)V",
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZI)V",
		garbageValue = "663869471"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BZB)Ljava/lang/Object;",
		garbageValue = "-1"
	)
	public static Object method76(byte[] var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0.length > 136) {
			DirectByteArrayCopier var2 = new DirectByteArrayCopier();
			var2.set(var0);
			return var2;
		} else {
			return var0;
		}
	}

	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		signature = "(Lho;B)Lho;",
		garbageValue = "91"
	)
	static Widget method81(Widget var0) {
		int var1 = UserComparator9.method3359(class2.getWidgetClickMask(var0));
		if (var1 == 0) {
			return null;
		} else {
			for (int var2 = 0; var2 < var1; ++var2) {
				var0 = Canvas.getWidget(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}
