import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("ClientPacket")
public class ClientPacket implements class181 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2228;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2220;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2181;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2182;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2183;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2184;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final ClientPacket field2189;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2186;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2187;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2252;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2209;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2277;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2282;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2192;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2193;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2202;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2195;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2196;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2197;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2198;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2199;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2188;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2256;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2191;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2231;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2204;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2205;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2206;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2207;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2208;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2200;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2210;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2211;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2201;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2213;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2214;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2180;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2216;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2217;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2218;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2219;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2179;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2238;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2222;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2190;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2224;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2225;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2226;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2227;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2280;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2229;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2230;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2273;
	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2232;
	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2233;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2258;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2235;
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2236;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2237;
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final ClientPacket field2261;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2239;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2247;
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2185;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2242;
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2243;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2244;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2245;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2246;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2215;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2248;
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2255;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2250;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2251;
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2249;
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2253;
	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2254;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2257;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2241;
	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2234;
	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2270;
	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2259;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2221;
	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2260;
	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2262;
	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2263;
	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2264;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2265;
	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2266;
	@ObfuscatedName("co")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2267;
	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2268;
	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2269;
	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2276;
	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2271;
	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2272;
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	static final ClientPacket field2203;
	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2274;
	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2275;
	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2223;
	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2194;
	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2278;
	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		signature = "Lgx;"
	)
	public static final ClientPacket field2240;
	@ObfuscatedName("gk")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("cg")
	@ObfuscatedGetter(
		intValue = -495540295
	)
	@Export("id")
	final int id;
	@ObfuscatedName("cf")
	@ObfuscatedGetter(
		intValue = -1101670465
	)
	@Export("length")
	final int length;

	static {
		field2228 = new ClientPacket(0, 9);
		field2220 = new ClientPacket(1, 4);
		field2181 = new ClientPacket(2, 3);
		field2182 = new ClientPacket(3, -1);
		field2183 = new ClientPacket(4, -1);
		field2184 = new ClientPacket(5, 15);
		field2189 = new ClientPacket(6, -1);
		field2186 = new ClientPacket(7, 8);
		field2187 = new ClientPacket(8, -2);
		field2252 = new ClientPacket(9, 4);
		field2209 = new ClientPacket(10, 1);
		field2277 = new ClientPacket(11, 6);
		field2282 = new ClientPacket(12, 3);
		field2192 = new ClientPacket(13, 7);
		field2193 = new ClientPacket(14, 3);
		field2202 = new ClientPacket(15, -1);
		field2195 = new ClientPacket(16, -1);
		field2196 = new ClientPacket(17, 8);
		field2197 = new ClientPacket(18, -1);
		field2198 = new ClientPacket(19, 2);
		field2199 = new ClientPacket(20, -1);
		field2188 = new ClientPacket(21, 3);
		field2256 = new ClientPacket(22, 3);
		field2191 = new ClientPacket(23, 8);
		field2231 = new ClientPacket(24, 3);
		field2204 = new ClientPacket(25, -1);
		field2205 = new ClientPacket(26, 9);
		field2206 = new ClientPacket(27, 11);
		field2207 = new ClientPacket(28, -2);
		field2208 = new ClientPacket(29, 7);
		field2200 = new ClientPacket(30, 7);
		field2210 = new ClientPacket(31, 0);
		field2211 = new ClientPacket(32, 8);
		field2201 = new ClientPacket(33, -1);
		field2213 = new ClientPacket(34, -1);
		field2214 = new ClientPacket(35, 7);
		field2180 = new ClientPacket(36, 9);
		field2216 = new ClientPacket(37, 6);
		field2217 = new ClientPacket(38, 9);
		field2218 = new ClientPacket(39, 8);
		field2219 = new ClientPacket(40, 8);
		field2179 = new ClientPacket(41, 2);
		field2238 = new ClientPacket(42, 0);
		field2222 = new ClientPacket(43, 2);
		field2190 = new ClientPacket(44, 8);
		field2224 = new ClientPacket(45, 7);
		field2225 = new ClientPacket(46, 3);
		field2226 = new ClientPacket(47, 16);
		field2227 = new ClientPacket(48, -1);
		field2280 = new ClientPacket(49, 0);
		field2229 = new ClientPacket(50, 3);
		field2230 = new ClientPacket(51, -2);
		field2273 = new ClientPacket(52, 8);
		field2232 = new ClientPacket(53, 10);
		field2233 = new ClientPacket(54, 11);
		field2258 = new ClientPacket(55, 8);
		field2235 = new ClientPacket(56, 3);
		field2236 = new ClientPacket(57, 3);
		field2237 = new ClientPacket(58, 8);
		field2261 = new ClientPacket(59, 2);
		field2239 = new ClientPacket(60, 4);
		field2247 = new ClientPacket(61, -1);
		field2185 = new ClientPacket(62, 8);
		field2242 = new ClientPacket(63, 16);
		field2243 = new ClientPacket(64, -1);
		field2244 = new ClientPacket(65, 7);
		field2245 = new ClientPacket(66, 0);
		field2246 = new ClientPacket(67, -1);
		field2215 = new ClientPacket(68, 8);
		field2248 = new ClientPacket(69, 8);
		field2255 = new ClientPacket(70, -1);
		field2250 = new ClientPacket(71, 8);
		field2251 = new ClientPacket(72, 3);
		field2249 = new ClientPacket(73, 15);
		field2253 = new ClientPacket(74, 8);
		field2254 = new ClientPacket(75, 13);
		field2257 = new ClientPacket(76, 5);
		field2241 = new ClientPacket(77, 14);
		field2234 = new ClientPacket(78, 3);
		field2270 = new ClientPacket(79, 7);
		field2259 = new ClientPacket(80, 8);
		field2221 = new ClientPacket(81, 4);
		field2260 = new ClientPacket(82, 8);
		field2262 = new ClientPacket(83, 2);
		field2263 = new ClientPacket(84, 8);
		field2264 = new ClientPacket(85, 13);
		field2265 = new ClientPacket(86, 0);
		field2266 = new ClientPacket(87, -1);
		field2267 = new ClientPacket(88, -1);
		field2268 = new ClientPacket(89, 3);
		field2269 = new ClientPacket(90, 7);
		field2276 = new ClientPacket(91, 8);
		field2271 = new ClientPacket(92, 4);
		field2272 = new ClientPacket(93, 3);
		field2203 = new ClientPacket(94, 7);
		field2274 = new ClientPacket(95, 16);
		field2275 = new ClientPacket(96, -1);
		field2223 = new ClientPacket(97, 13);
		field2194 = new ClientPacket(98, 8);
		field2278 = new ClientPacket(99, 7);
		field2240 = new ClientPacket(100, 7);
	}

	ClientPacket(int var1, int var2) {
		this.id = var1;
		this.length = var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "1627354797"
	)
	@Export("readPlayerUpdate")
	static void readPlayerUpdate(PacketBuffer var0, int var1) {
		boolean var2 = var0.readBits(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.readBits(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.field606 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (HealthBar.baseY * 64 + var4.pathY[0] >> 13) + (UserComparator8.baseX * 64 + var4.pathX[0] >> 13 << 14);
				if (var4.field934 != -1) {
					Players.Players_orientations[var1] = var4.field934;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					class247.updateExternalPlayer(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.readBits(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
					if (var2) {
						var4.field606 = true;
						var4.tileX = var6;
						var4.tileY = var7;
					} else {
						var4.field606 = false;
						var4.method1334(var6, var7, Players.field1228[var1]);
					}
				} else {
					var4.resetPath(var6, var7);
					var4.field606 = false;
				}

			} else if (var3 == 2) {
				var5 = var0.readBits(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field606 = false;
				} else if (var2) {
					var4.field606 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field606 = false;
					var4.method1334(var6, var7, Players.field1228[var1]);
				}

			} else {
				var5 = var0.readBits(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.readBits(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field606 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field606 = false;
							var4.method1334(var10, var11, Players.field1228[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field606 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						Player.Client_plane = var4.Client_plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (UserComparator8.baseX * 64 + var8 + var4.pathX[0] & 16383) - UserComparator8.baseX * 64;
					var11 = (HealthBar.baseY * 64 + var9 + var4.pathY[0] & 16383) - HealthBar.baseY * 64;
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.field606 = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.field606 = false;
							var4.method1334(var10, var11, Players.field1228[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.field606 = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						Player.Client_plane = var4.plane;
					}

				}
			}
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lhq;Ljava/lang/String;Ljava/lang/String;I)Llw;",
		garbageValue = "-210604118"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return WorldMapAreaData.method762(var0, var3, var4);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "64"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2065171333"
	)
	static void method3764() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			GrandExchangeOffer.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1 = SecureRandomCallable.method1225();
			byte var0;
			if (var1 == 0L) {
				var0 = 5;
			} else {
				String var4 = Login.Login_username;
				Random var5 = new Random();
				Buffer var6 = new Buffer(128);
				Buffer var7 = new Buffer(128);
				int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
				var6.writeByte(10);

				int var9;
				for (var9 = 0; var9 < 4; ++var9) {
					var6.writeInt(var5.nextInt());
				}

				var6.writeInt(var8[0]);
				var6.writeInt(var8[1]);
				var6.writeLong(var1);
				var6.writeLong(0L);

				for (var9 = 0; var9 < 4; ++var9) {
					var6.writeInt(var5.nextInt());
				}

				var6.encryptRsa(class80.field1119, class80.field1120);
				var7.writeByte(10);

				for (var9 = 0; var9 < 3; ++var9) {
					var7.writeInt(var5.nextInt());
				}

				var7.writeLong(var5.nextLong());
				var7.writeLongMedium(var5.nextLong());
				if (Client.randomDatData != null) {
					var7.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
				} else {
					byte[] var10 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var10);

						int var11;
						for (var11 = 0; var11 < 24 && var10[var11] == 0; ++var11) {
						}

						if (var11 >= 24) {
							throw new IOException();
						}
					} catch (Exception var25) {
						for (int var12 = 0; var12 < 24; ++var12) {
							var10[var12] = -1;
						}
					}

					var7.writeBytes(var10, 0, var10.length);
				}

				var7.writeLong(var5.nextLong());
				var7.encryptRsa(class80.field1119, class80.field1120);
				var9 = UserComparator6.stringCp1252NullTerminatedByteSize(var4);
				if (var9 % 8 != 0) {
					var9 += 8 - var9 % 8;
				}

				Buffer var26 = new Buffer(var9);
				var26.writeStringCp1252NullTerminated(var4);
				var26.offset = var9;
				var26.xteaEncryptAll(var8);
				Buffer var20 = new Buffer(var7.offset + var6.offset + var26.offset + 5);
				var20.writeByte(2);
				var20.writeByte(var6.offset);
				var20.writeBytes(var6.array, 0, var6.offset);
				var20.writeByte(var7.offset);
				var20.writeBytes(var7.array, 0, var7.offset);
				var20.writeShort(var26.offset);
				var20.writeBytes(var26.array, 0, var26.offset);
				byte[] var13 = var20.array;
				String var22 = ItemContainer.method1252(var13, 0, var13.length);
				String var14 = var22;

				byte var3;
				try {
					URL var15 = new URL(WorldMapElement.method4547("services", false) + "m=accountappeal/login.ws");
					URLConnection var16 = var15.openConnection();
					var16.setDoInput(true);
					var16.setDoOutput(true);
					var16.setConnectTimeout(5000);
					OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
					var17.write("data2=" + class312.method6014(var14) + "&dest=" + class312.method6014("passwordchoice.ws"));
					var17.flush();
					InputStream var18 = var16.getInputStream();
					var20 = new Buffer(new byte[1000]);

					while (true) {
						int var19 = var18.read(var20.array, var20.offset, 1000 - var20.offset);
						if (var19 == -1) {
							var17.close();
							var18.close();
							String var23 = new String(var20.array);
							if (var23.startsWith("OFFLINE")) {
								var3 = 4;
							} else if (var23.startsWith("WRONG")) {
								var3 = 7;
							} else if (var23.startsWith("RELOAD")) {
								var3 = 3;
							} else if (var23.startsWith("Not permitted for social network accounts.")) {
								var3 = 6;
							} else {
								var20.xteaDecryptAll(var8);

								while (var20.offset > 0 && var20.array[var20.offset - 1] == 0) {
									--var20.offset;
								}

								var23 = new String(var20.array, 0, var20.offset);
								if (SequenceDefinition.isValidURL(var23)) {
									class2.openURL(var23, true, false);
									var3 = 2;
								} else {
									var3 = 5;
								}
							}
							break;
						}

						var20.offset += var19;
						if (var20.offset >= 1000) {
							var3 = 5;
							break;
						}
					}
				} catch (Throwable var24) {
					var24.printStackTrace();
					var3 = 5;
				}

				var0 = var3;
			}

			switch(var0) {
			case 2:
				GrandExchangeOffer.setLoginResponseString(Strings.field2894, Strings.field3013, Strings.field3014);
				Login.loginIndex = 6;
				break;
			case 3:
				GrandExchangeOffer.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				GrandExchangeOffer.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				GrandExchangeOffer.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				GrandExchangeOffer.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				GrandExchangeOffer.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-78"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
