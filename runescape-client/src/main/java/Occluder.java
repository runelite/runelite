import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1590617607
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -547083531
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -50213873
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 468551341
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1458013883
	)
	@Export("type")
	int type;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1331967011
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -455782375
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 819505963
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1618672975
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1033011613
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1435330577
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 681234965
	)
	int field1891;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 460124457
	)
	int field1900;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -947874837
	)
	int field1901;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1101467095
	)
	int field1903;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1920736103
	)
	int field1904;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1277839357
	)
	int field1889;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 461878441
	)
	int field1905;

	Occluder() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IB)Lir;",
		garbageValue = "-54"
	)
	@Export("getObjectDefinition")
	public static ObjectDefinition getObjectDefinition(int var0) {
		ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectDefinition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectDefinition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lgb;",
		garbageValue = "1401703013"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2127, ServerPacket.field2129, ServerPacket.field2168, ServerPacket.field2118, ServerPacket.field2119, ServerPacket.field2120, ServerPacket.field2121, ServerPacket.field2122, ServerPacket.field2123, ServerPacket.field2124, ServerPacket.field2159, ServerPacket.field2126, ServerPacket.field2165, ServerPacket.field2145, ServerPacket.field2200, ServerPacket.field2169, ServerPacket.field2131, ServerPacket.field2132, ServerPacket.field2117, ServerPacket.field2134, ServerPacket.field2135, ServerPacket.field2136, ServerPacket.field2137, ServerPacket.field2138, ServerPacket.field2139, ServerPacket.field2140, ServerPacket.field2141, ServerPacket.field2142, ServerPacket.field2181, ServerPacket.field2151, ServerPacket.field2173, ServerPacket.field2146, ServerPacket.field2178, ServerPacket.field2183, ServerPacket.field2172, ServerPacket.field2150, ServerPacket.field2148, ServerPacket.field2152, ServerPacket.field2153, ServerPacket.field2125, ServerPacket.field2143, ServerPacket.field2116, ServerPacket.field2157, ServerPacket.field2144, ServerPacket.field2115, ServerPacket.field2160, ServerPacket.field2161, ServerPacket.field2149, ServerPacket.field2163, ServerPacket.field2164, ServerPacket.field2133, ServerPacket.field2166, ServerPacket.field2128, ServerPacket.field2156, ServerPacket.field2162, ServerPacket.field2155, ServerPacket.field2171, ServerPacket.field2193, ServerPacket.field2167, ServerPacket.field2174, ServerPacket.field2175, ServerPacket.field2176, ServerPacket.field2177, ServerPacket.field2154, ServerPacket.field2179, ServerPacket.field2180, ServerPacket.field2158, ServerPacket.field2182, ServerPacket.field2130, ServerPacket.field2184, ServerPacket.field2187, ServerPacket.field2186, ServerPacket.field2147, ServerPacket.field2188, ServerPacket.field2189, ServerPacket.field2190, ServerPacket.field2191, ServerPacket.field2192, ServerPacket.field2170, ServerPacket.field2194, ServerPacket.field2195, ServerPacket.field2196, ServerPacket.field2197, ServerPacket.field2198, ServerPacket.field2199, ServerPacket.field2185};
	}
}
