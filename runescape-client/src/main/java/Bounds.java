import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("Bounds")
public class Bounds {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lbt;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	static AbstractSocket field3845;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 927119221
	)
	@Export("lowX")
	public int lowX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1883471895
	)
	@Export("lowY")
	public int lowY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 482662949
	)
	@Export("highX")
	public int highX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1342895921
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-92"
	)
	@Export("setLow")
	public void setLow(int var1, int var2) {
		this.lowX = var1;
		this.lowY = var2;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "638104028"
	)
	@Export("setHigh")
	public void setHigh(int var1, int var2) {
		this.highX = var1;
		this.highY = var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;B)V",
		garbageValue = "15"
	)
	public void method5846(Bounds var1, Bounds var2) {
		this.method5867(var1, var2);
		this.method5848(var1, var2);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;I)V",
		garbageValue = "-157171607"
	)
	void method5867(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX;
		var2.highX = this.highX;
		if (this.lowX < var1.lowX) {
			var2.highX -= var1.lowX - this.lowX;
			var2.lowX = var1.lowX;
		}

		if (var2.method5847() > var1.method5847()) {
			var2.highX -= var2.method5847() - var1.method5847();
		}

		if (var2.highX < 0) {
			var2.highX = 0;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Llh;Llh;I)V",
		garbageValue = "-2140694621"
	)
	void method5848(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY;
		var2.highY = this.highY;
		if (this.lowY < var1.lowY) {
			var2.highY -= var1.lowY - this.lowY;
			var2.lowY = var1.lowY;
		}

		if (var2.method5842() > var1.method5842()) {
			var2.highY -= var2.method5842() - var1.method5842();
		}

		if (var2.highY < 0) {
			var2.highY = 0;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "134601683"
	)
	int method5847() {
		return this.highX + this.lowX;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-901412341"
	)
	int method5842() {
		return this.highY + this.lowY;
	}

	public String abb() {
		return null;
	}

	public String abd() {
		return null;
	}

	public String toString() {
		return null;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lfs;",
		garbageValue = "-2037238373"
	)
	@Export("newClock")
	public static Clock newClock() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}
}
