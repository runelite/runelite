import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		longValue = 7514932896341092199L
	)
	long field3566;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		longValue = -7624772815997057519L
	)
	long field3558;
	@ObfuscatedName("i")
	public boolean field3560;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -6215548007371773365L
	)
	long field3561;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 1342387343954855195L
	)
	long field3562;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 5626875843226124193L
	)
	long field3559;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1819950625
	)
	int field3564;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -100578869
	)
	int field3565;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -762061045
	)
	int field3563;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -528915323
	)
	int field3567;

	public Timer() {
		this.field3566 = -1L;
		this.field3558 = -1L;
		this.field3560 = false;
		this.field3561 = 0L;
		this.field3562 = 0L;
		this.field3559 = 0L;
		this.field3564 = 0;
		this.field3565 = 0;
		this.field3563 = 0;
		this.field3567 = 0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	public void method4897() {
		this.field3566 = SequenceDefinition.method4686();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1627555881"
	)
	public void method4898() {
		if (-1L != this.field3566) {
			this.field3562 = SequenceDefinition.method4686() - this.field3566;
			this.field3566 = -1L;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "1"
	)
	public void method4899(int var1) {
		this.field3558 = SequenceDefinition.method4686();
		this.field3564 = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1290905083"
	)
	public void method4900() {
		if (this.field3558 != -1L) {
			this.field3561 = SequenceDefinition.method4686() - this.field3558;
			this.field3558 = -1L;
		}

		++this.field3563;
		this.field3560 = true;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-769614616"
	)
	public void method4925() {
		this.field3560 = false;
		this.field3565 = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "15"
	)
	public void method4901() {
		this.method4900();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-1786942411"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3562;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		long var4 = this.field3561;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		long var6 = this.field3559;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int)var6);
		var1.writeShort(this.field3564);
		var1.writeShort(this.field3565);
		var1.writeShort(this.field3563);
		var1.writeShort(this.field3567);
	}
}
