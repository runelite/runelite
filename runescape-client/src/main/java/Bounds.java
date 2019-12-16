import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -136751855
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1318120515
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -388222223
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1704369811
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-535694945"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "69"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;I)V",
		garbageValue = "871538763"
	)
	public void method5997(Bounds var1, Bounds var2) {
		this.method6005(var1, var2);
		this.method5999(var1, var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;I)V",
		garbageValue = "-541537742"
	)
	void method6005(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method6000() > var1.method6000()) {
			var2.highX -= var2.method6000() - var1.method6000();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;B)V",
		garbageValue = "-89"
	)
	void method5999(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method5994() > var1.method5994()) {
			var2.highY -= var2.method5994() - var1.method5994();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1022454109"
	)
	int method6000() {
		return this.lowX + this.highX;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "1"
	)
	int method5994() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}
}
