import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -460052355
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2012134471
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -295033527
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 168990255
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2660177"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2094067134"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Llw;Llw;I)V",
		garbageValue = "-1378813027"
	)
	public void method6069(Bounds var1, Bounds var2) {
		this.method6070(var1, var2);
		this.method6071(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Llw;Llw;B)V",
		garbageValue = "6"
	)
	void method6070(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method6086() > var1.method6086()) {
			var2.highX -= var2.method6086() - var1.method6086();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Llw;Llw;B)V",
		garbageValue = "72"
	)
	void method6071(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method6085() > var1.method6085()) {
			var2.highY -= var2.method6085() - var1.method6085();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "-14495"
	)
	int method6086() {
		return this.highX + this.lowX;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1630571197"
	)
	int method6085() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}
}
