import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -311515591
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1344271777
	)
	@Export("x")
	int x;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -779439179
	)
	@Export("y")
	int y;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -3653968665269180135L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1094759427
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "3762"
	)
	public static void method2842() {
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
		garbageValue = "1"
	)
	static String method2843(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = (RunException)var0;
			var1 = var2.string + " | ";
			var0 = var2.throwable;
		} else {
			var1 = "";
		}

		StringWriter var12 = new StringWriter();
		PrintWriter var3 = new PrintWriter(var12);
		var0.printStackTrace(var3);
		var3.close();
		String var4 = var12.toString();
		BufferedReader var5 = new BufferedReader(new StringReader(var4));
		String var6 = var5.readLine();

		while (true) {
			while (true) {
				String var7 = var5.readLine();
				if (var7 == null) {
					var1 = var1 + "| " + var6;
					return var1;
				}

				int var8 = var7.indexOf(40);
				int var9 = var7.indexOf(41, var8 + 1);
				if (var8 >= 0 && var9 >= 0) {
					String var10 = var7.substring(var8 + 1, var9);
					int var11 = var10.indexOf(".java:");
					if (var11 >= 0) {
						var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
						var1 = var1 + var10 + ' ';
						continue;
					}

					var7 = var7.substring(0, var8);
				}

				var7 = var7.trim();
				var7 = var7.substring(var7.lastIndexOf(32) + 1);
				var7 = var7.substring(var7.lastIndexOf(9) + 1);
				var1 = var1 + var7 + ' ';
			}
		}
	}
}
