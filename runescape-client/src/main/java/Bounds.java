import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lr")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -242928427
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1412221703
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1383178295
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -647845267
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
		signature = "(IIS)V",
		garbageValue = "23378"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-361054840"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Llr;Llr;S)V",
		garbageValue = "3042"
	)
	public void method5948(Bounds var1, Bounds var2) {
		this.method5936(var1, var2);
		this.method5938(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Llr;Llr;I)V",
		garbageValue = "1943311297"
	)
	void method5936(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method5947() > var1.method5947()) {
			var2.highX -= var2.method5947() - var1.method5947();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Llr;Llr;B)V",
		garbageValue = "0"
	)
	void method5938(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method5940() > var1.method5940()) {
			var2.highY -= var2.method5940() - var1.method5940();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-241231712"
	)
	int method5947() {
		return this.highX + this.lowX;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1659278045"
	)
	int method5940() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}

	public String aan() {
		return null;
	}

	public String aai() {
		return null;
	}

	public String aar() {
		return null;
	}
}
