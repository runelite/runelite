import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "La;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1166565565
	)
	final int field115;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2076201751
	)
	final int field116;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1814191089
	)
	final int field118;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field115 = var1;
		this.field116 = var2;
		this.field118 = var3;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(FI)Z",
		garbageValue = "-419042986"
	)
	boolean method199(float var1) {
		return var1 >= (float)this.field118;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)[La;",
		garbageValue = "0"
	)
	static WorldMapLabelSize[] method200() {
		return new WorldMapLabelSize[]{WorldMapLabelSize_large, WorldMapLabelSize_small, WorldMapLabelSize_medium};
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Lgm;",
		garbageValue = "-1817209959"
	)
	@Export("ServerPacket_values")
	public static ServerPacket[] ServerPacket_values() {
		return new ServerPacket[]{ServerPacket.field2132, ServerPacket.field2185, ServerPacket.field2193, ServerPacket.field2134, ServerPacket.field2129, ServerPacket.field2156, ServerPacket.field2173, ServerPacket.field2135, ServerPacket.field2138, ServerPacket.field2137, ServerPacket.field2155, ServerPacket.field2163, ServerPacket.field2133, ServerPacket.field2151, ServerPacket.field2142, ServerPacket.field2143, ServerPacket.field2130, ServerPacket.field2145, ServerPacket.field2146, ServerPacket.field2199, ServerPacket.field2148, ServerPacket.field2149, ServerPacket.field2150, ServerPacket.field2141, ServerPacket.field2144, ServerPacket.field2153, ServerPacket.field2154, ServerPacket.field2198, ServerPacket.field2140, ServerPacket.field2157, ServerPacket.field2158, ServerPacket.field2159, ServerPacket.field2160, ServerPacket.field2161, ServerPacket.field2162, ServerPacket.field2184, ServerPacket.field2164, ServerPacket.field2192, ServerPacket.field2166, ServerPacket.field2167, ServerPacket.field2168, ServerPacket.field2212, ServerPacket.field2170, ServerPacket.field2171, ServerPacket.field2169, ServerPacket.field2136, ServerPacket.field2174, ServerPacket.field2175, ServerPacket.field2176, ServerPacket.field2177, ServerPacket.field2178, ServerPacket.field2179, ServerPacket.field2180, ServerPacket.field2181, ServerPacket.field2182, ServerPacket.field2183, ServerPacket.field2204, ServerPacket.field2152, ServerPacket.field2196, ServerPacket.field2187, ServerPacket.field2188, ServerPacket.field2128, ServerPacket.field2190, ServerPacket.field2191, ServerPacket.field2131, ServerPacket.field2139, ServerPacket.field2194, ServerPacket.field2165, ServerPacket.field2147, ServerPacket.field2197, ServerPacket.field2202, ServerPacket.field2172, ServerPacket.field2200, ServerPacket.field2201, ServerPacket.field2189, ServerPacket.field2203, ServerPacket.field2205, ServerPacket.field2186, ServerPacket.field2206, ServerPacket.field2207, ServerPacket.field2208, ServerPacket.field2209, ServerPacket.field2210, ServerPacket.field2211, ServerPacket.field2213, ServerPacket.field2195};
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)La;",
		garbageValue = "1217781091"
	)
	static WorldMapLabelSize method209(int var0) {
		WorldMapLabelSize[] var1 = method200();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			WorldMapLabelSize var3 = var1[var2];
			if (var0 == var3.field116) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-673995874"
	)
	static void method208() {
		Client.packetWriter.addNode(ModelData0.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}
