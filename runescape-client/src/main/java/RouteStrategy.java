import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1683670831
	)
	static int field2114;
	@ObfuscatedName("fv")
	@ObfuscatedGetter(
		longValue = -7982817211457785639L
	)
	static long field2110;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1694860109
	)
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -279352193
	)
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1604762731
	)
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 368404493
	)
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIILfh;B)Z",
		garbageValue = "-103"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "34"
	)
	static boolean method3638(int var0, int var1) {
		return var0 != 4 || var1 < 8;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "62216772"
	)
	static String method3639() {
		return UserComparator10.clientPreferences.hideUsername ? PlayerType.method4212(Login.Login_username) : Login.Login_username;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-377116898"
	)
	static final int method3640(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = class266.method5066(var3, var5);
		int var8 = class266.method5066(var3 + 1, var5);
		int var9 = class266.method5066(var3, var5 + 1);
		int var10 = class266.method5066(var3 + 1, var5 + 1);
		int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
		int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
		int var13 = class286.method5346(var9, var10, var4, var2);
		return class286.method5346(var11, var13, var6, var2);
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1126084733"
	)
	static void method3641() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}
}
