import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1060370967
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1597072337
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -456113605
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -239139767
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1269806188"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "838675503"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lld;Lld;B)V",
		garbageValue = "-7"
	)
	public void method6047(Bounds var1, Bounds var2) {
		this.method6051(var1, var2);
		this.method6052(var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lld;Lld;I)V",
		garbageValue = "-1938755982"
	)
	void method6051(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX = (var2.highX * -2075179277 - (var1.lowX * -2075179277 - this.lowX * -2075179277)) * -456113605;
			var2.lowX = var1.lowX;
		}

		if (var2.method6053() > var1.method6053()) {
			var2.highX -= var2.method6053() - var1.method6053();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lld;Lld;I)V",
		garbageValue = "-642069303"
	)
	void method6052(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY = (var2.highY * -707514887 - (var1.lowY * -707514887 - this.lowY * -707514887)) * -239139767;
			var2.lowY = var1.lowY;
		}

		if (var2.method6050() > var1.method6050()) {
			var2.highY -= var2.method6050() - var1.method6050();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	int method6053() {
		return this.lowX + this.highX;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "180335993"
	)
	int method6050() {
		return this.highY + this.lowY;
	}

	public String toString() {
		return null;
	}
}
