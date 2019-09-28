import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -479130629
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 724783571
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1669121479
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1354833317
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "166241873"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1712715973"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;I)V",
		garbageValue = "2079875928"
	)
	public void method5913(Bounds var1, Bounds var2) {
		this.method5927(var1, var2);
		this.method5914(var1, var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;B)V",
		garbageValue = "-1"
	)
	void method5927(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method5916() > var1.method5916()) {
			var2.highX -= var2.method5916() - var1.method5916();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Lll;Lll;I)V",
		garbageValue = "-1654040739"
	)
	void method5914(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method5912() > var1.method5912()) {
			var2.highY -= var2.method5912() - var1.method5912();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "769635987"
	)
	int method5916() {
		return this.lowX + this.highX;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "59"
	)
	int method5912() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}
}
