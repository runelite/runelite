import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -743788715
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 390143547
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1967964901
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1178395907
	)
	@Export("highY")
	public int highY;

	public Bounds(int var1, int var2, int var3, int var4) {
		this.setLow(var1, var2);
		this.setHigh(var3, var4);
	}

	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2024948285"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-30"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;I)V",
		garbageValue = "-782590696"
	)
	public void method6031(Bounds var1, Bounds var2) {
		this.method6032(var1, var2);
		this.method6033(var1, var2);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;I)V",
		garbageValue = "-997217284"
	)
	void method6032(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method6034() > var1.method6034()) {
			var2.highX -= var2.method6034() - var1.method6034();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;I)V",
		garbageValue = "1896853998"
	)
	void method6033(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method6035() > var1.method6035()) {
			var2.highY -= var2.method6035() - var1.method6035();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1353685285"
	)
	int method6034() {
		return this.lowX + this.highX;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-155482088"
	)
	int method6035() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
		garbageValue = "1378927694"
	)
	static String method6058(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = (RunException)var0;
			var1 = var2.message + " | ";
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

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;IIB)Lkr;",
		garbageValue = "-41"
	)
	public static AbstractSocket method6040(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}
}
