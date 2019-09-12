import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class195 {
	@ObfuscatedName("ak")
	@Export("null_string")
	protected static String null_string;

	static {
		new HashMap();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)[Lga;",
		garbageValue = "-55"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2141, ServerPacket.field2113, ServerPacket.field2122, ServerPacket.field2120, ServerPacket.field2100, ServerPacket.field2101, ServerPacket.field2102, ServerPacket.field2103, ServerPacket.field2104, ServerPacket.field2162, ServerPacket.field2118, ServerPacket.field2107, ServerPacket.field2108, ServerPacket.field2109, ServerPacket.field2110, ServerPacket.field2111, ServerPacket.field2112, ServerPacket.field2098, ServerPacket.field2105, ServerPacket.field2135, ServerPacket.field2134, ServerPacket.field2117, ServerPacket.field2181, ServerPacket.field2119, ServerPacket.field2099, ServerPacket.field2121, ServerPacket.field2096, ServerPacket.field2123, ServerPacket.field2116, ServerPacket.field2137, ServerPacket.field2126, ServerPacket.field2127, ServerPacket.field2142, ServerPacket.field2115, ServerPacket.field2130, ServerPacket.field2168, ServerPacket.field2132, ServerPacket.field2133, ServerPacket.field2131, ServerPacket.field2158, ServerPacket.field2136, ServerPacket.field2182, ServerPacket.field2138, ServerPacket.field2164, ServerPacket.field2172, ServerPacket.field2125, ServerPacket.field2129, ServerPacket.field2106, ServerPacket.field2144, ServerPacket.field2145, ServerPacket.field2146, ServerPacket.field2143, ServerPacket.field2128, ServerPacket.field2149, ServerPacket.field2150, ServerPacket.field2151, ServerPacket.field2152, ServerPacket.field2153, ServerPacket.field2154, ServerPacket.field2124, ServerPacket.field2156, ServerPacket.field2157, ServerPacket.field2147, ServerPacket.field2159, ServerPacket.field2160, ServerPacket.field2161, ServerPacket.field2148, ServerPacket.field2163, ServerPacket.field2155, ServerPacket.field2165, ServerPacket.field2166, ServerPacket.field2167, ServerPacket.field2139, ServerPacket.field2169, ServerPacket.field2170, ServerPacket.field2171, ServerPacket.field2097, ServerPacket.field2173, ServerPacket.field2174, ServerPacket.field2175, ServerPacket.field2176, ServerPacket.field2177, ServerPacket.field2178, ServerPacket.field2179, ServerPacket.field2180, ServerPacket.field2140};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Liq;",
		garbageValue = "2111185945"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	public static void method3663() {
		VarpDefinition.VarpDefinition_cached.clear();
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(Lkz;IB)V",
		garbageValue = "4"
	)
	static void method3664(Buffer var0, int var1) {
		byte[] var2 = var0.array;
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class300.writeRandomDat(var2, var1, Client.randomDatData, 0, 24);
		class49.method828(var0, var1);
	}
}
