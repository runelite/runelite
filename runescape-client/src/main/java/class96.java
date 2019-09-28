import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class96 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2145130731
	)
	static int field1304;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Lgv;",
		garbageValue = "-50"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2126, ServerPacket.field2134, ServerPacket.field2105, ServerPacket.field2098, ServerPacket.field2113, ServerPacket.field2099, ServerPacket.field2101, ServerPacket.field2177, ServerPacket.field2103, ServerPacket.field2140, ServerPacket.field2132, ServerPacket.field2167, ServerPacket.field2107, ServerPacket.field2102, ServerPacket.field2109, ServerPacket.field2110, ServerPacket.field2111, ServerPacket.field2112, ServerPacket.field2145, ServerPacket.field2114, ServerPacket.field2115, ServerPacket.field2096, ServerPacket.field2139, ServerPacket.field2118, ServerPacket.field2119, ServerPacket.field2120, ServerPacket.field2095, ServerPacket.field2122, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2104, ServerPacket.field2133, ServerPacket.field2127, ServerPacket.field2128, ServerPacket.field2117, ServerPacket.field2130, ServerPacket.field2159, ServerPacket.field2141, ServerPacket.field2121, ServerPacket.field2106, ServerPacket.field2135, ServerPacket.field2136, ServerPacket.field2137, ServerPacket.field2138, ServerPacket.field2100, ServerPacket.field2129, ServerPacket.field2174, ServerPacket.field2182, ServerPacket.field2168, ServerPacket.field2144, ServerPacket.field2142, ServerPacket.field2146, ServerPacket.field2147, ServerPacket.field2148, ServerPacket.field2149, ServerPacket.field2150, ServerPacket.field2151, ServerPacket.field2152, ServerPacket.field2153, ServerPacket.field2154, ServerPacket.field2155, ServerPacket.field2156, ServerPacket.field2097, ServerPacket.field2158, ServerPacket.field2157, ServerPacket.field2160, ServerPacket.field2161, ServerPacket.field2162, ServerPacket.field2163, ServerPacket.field2164, ServerPacket.field2165, ServerPacket.field2116, ServerPacket.field2143, ServerPacket.field2166, ServerPacket.field2169, ServerPacket.field2170, ServerPacket.field2171, ServerPacket.field2172, ServerPacket.field2173, ServerPacket.field2183, ServerPacket.field2175, ServerPacket.field2176, ServerPacket.field2179, ServerPacket.field2178, ServerPacket.field2125, ServerPacket.field2180};
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Llu;",
		garbageValue = "-67"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.field3856, FillMode.SOLID, FillMode.field3857};
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Llb;ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "539746719"
	)
	static String method2263(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}
}
