import java.util.HashSet;
import java.util.Set;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public enum class201 implements Enumerated {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2375("", 0, new class200[]{class200.field2370}),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2382("", 1, new class200[]{class200.field2371, class200.field2370}),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2374("", 2, new class200[]{class200.field2371, class200.field2369, class200.field2370}),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2376("", 3, new class200[]{class200.field2371}),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2378("", 4),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2379("", 5, new class200[]{class200.field2371, class200.field2370}),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2380("", 6, new class200[]{class200.field2370}),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2381("", 8, new class200[]{class200.field2371, class200.field2370}),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2377("", 9, new class200[]{class200.field2371, class200.field2369}),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2383("", 10, new class200[]{class200.field2371}),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2384("", 11, new class200[]{class200.field2371}),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2385("", 12, new class200[]{class200.field2371, class200.field2370}),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	field2386("", 13, new class200[]{class200.field2371});

	@ObfuscatedName("bh")
	static String field2390;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1460687895
	)
	@Export("id")
	final int id;
	@ObfuscatedName("h")
	final Set field2388;

	static {
		method3753();
	}

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I[Lgy;)V"
	)
	class201(String var3, int var4, class200[] var5) {
		this.field2388 = new HashSet();
		this.id = var4;
		class200[] var6 = var5;

		for (int var7 = 0; var7 < var6.length; ++var7) {
			class200 var8 = var6[var7];
			this.field2388.add(var8);
		}

	}

	class201(String var3, int var4) {
		this.field2388 = new HashSet();
		this.id = var4;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "56"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgd;",
		garbageValue = "-2096888845"
	)
	static class201[] method3753() {
		return new class201[]{field2379, field2385, field2386, field2376, field2384, field2380, field2381, field2377, field2378, field2374, field2375, field2382, field2383};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1010005518"
	)
	static int method3761(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-122"
	)
	public static int method3763(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1096677335"
	)
	static int method3760(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return WorldMapLabel.method517(var0, var1, var2);
		} else if (var0 < 1100) {
			return SecureRandomCallable.method1249(var0, var1, var2);
		} else if (var0 < 1200) {
			return UserList.method5225(var0, var1, var2);
		} else if (var0 < 1300) {
			return class2.method28(var0, var1, var2);
		} else if (var0 < 1400) {
			return Decimator.method2649(var0, var1, var2);
		} else if (var0 < 1500) {
			return WorldMapEvent.method866(var0, var1, var2);
		} else if (var0 < 1600) {
			return GrandExchangeOffer.method191(var0, var1, var2);
		} else if (var0 < 1700) {
			return GrandExchangeOfferWorldComparator.method137(var0, var1, var2);
		} else if (var0 < 1800) {
			return NPC.method2147(var0, var1, var2);
		} else if (var0 < 1900) {
			return WorldMapSection1.method683(var0, var1, var2);
		} else if (var0 < 2000) {
			return PlayerType.method4233(var0, var1, var2);
		} else if (var0 < 2100) {
			return SecureRandomCallable.method1249(var0, var1, var2);
		} else if (var0 < 2200) {
			return UserList.method5225(var0, var1, var2);
		} else if (var0 < 2300) {
			return class2.method28(var0, var1, var2);
		} else if (var0 < 2400) {
			return Decimator.method2649(var0, var1, var2);
		} else if (var0 < 2500) {
			return WorldMapEvent.method866(var0, var1, var2);
		} else if (var0 < 2600) {
			return WorldMapManager.method750(var0, var1, var2);
		} else if (var0 < 2700) {
			return class7.method101(var0, var1, var2);
		} else if (var0 < 2800) {
			return UrlRequest.method3423(var0, var1, var2);
		} else if (var0 < 2900) {
			return Message.method1318(var0, var1, var2);
		} else if (var0 < 3000) {
			return PlayerType.method4233(var0, var1, var2);
		} else if (var0 < 3200) {
			return Widget.method4183(var0, var1, var2);
		} else if (var0 < 3300) {
			return NPC.method2145(var0, var1, var2);
		} else if (var0 < 3400) {
			return AbstractUserComparator.method5119(var0, var1, var2);
		} else if (var0 < 3500) {
			return class52.method904(var0, var1, var2);
		} else if (var0 < 3700) {
			return class13.method132(var0, var1, var2);
		} else if (var0 < 4000) {
			return class224.method4124(var0, var1, var2);
		} else if (var0 < 4100) {
			return ObjectDefinition.method4710(var0, var1, var2);
		} else if (var0 < 4200) {
			return AbstractWorldMapData.method384(var0, var1, var2);
		} else if (var0 < 4300) {
			return class22.method258(var0, var1, var2);
		} else if (var0 < 5100) {
			return BoundaryObject.method3376(var0, var1, var2);
		} else if (var0 < 5400) {
			return WorldMapEvent.method865(var0, var1, var2);
		} else if (var0 < 5600) {
			return AbstractWorldMapData.method380(var0, var1, var2);
		} else if (var0 < 5700) {
			return WorldMapData_1.method814(var0, var1, var2);
		} else if (var0 < 6300) {
			return MouseRecorder.method1290(var0, var1, var2);
		} else if (var0 < 6600) {
			return GrandExchangeOfferNameComparator.method238(var0, var1, var2);
		} else {
			return var0 < 6700 ? IgnoreList.method5130(var0, var1, var2) : 2;
		}
	}
}
