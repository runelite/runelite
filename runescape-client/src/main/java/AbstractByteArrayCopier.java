import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	@ObfuscatedName("hw")
	@ObfuscatedGetter(
		intValue = -996347373
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;

	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)[B",
		garbageValue = "49"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "-1981176877"
	)
	@Export("set")
	abstract void set(byte[] var1);

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1334289648"
	)
	static void method3922() {
		if (GrandExchangeOfferUnitPriceComparator.worldMap != null) {
			GrandExchangeOfferUnitPriceComparator.worldMap.method6275(MouseRecorder.plane, class4.baseX * 64 + (Varps.localPlayer.x * -78439701 >> 7), (Varps.localPlayer.y >> 7) + ScriptEvent.baseY, false);
			GrandExchangeOfferUnitPriceComparator.worldMap.loadCache();
		}

	}
}
