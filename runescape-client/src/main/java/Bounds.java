import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1186074789
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -198324779
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -574576823
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 833436879
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-102"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "12"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lls;Lls;I)V",
		garbageValue = "799718452"
	)
	public void method5980(Bounds var1, Bounds var2) {
		this.method5968(var1, var2);
		this.method5964(var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lls;Lls;B)V",
		garbageValue = "-20"
	)
	void method5968(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method5976() > var1.method5976()) {
			var2.highX -= var2.method5976() - var1.method5976();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lls;Lls;I)V",
		garbageValue = "182983589"
	)
	void method5964(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method5965() > var1.method5965()) {
			var2.highY -= var2.method5965() - var1.method5965();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1428102724"
	)
	int method5976() {
		return this.highX + this.lowX;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "185439342"
	)
	int method5965() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}
}
