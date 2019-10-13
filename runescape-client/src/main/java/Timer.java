import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		longValue = 4462782034314037381L
	)
	long field3561;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 6292636731397039659L
	)
	long field3562;
	@ObfuscatedName("v")
	public boolean field3563;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 514076061416709505L
	)
	long field3564;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = 7643347149191032091L
	)
	long field3565;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = 5130392401661119113L
	)
	long field3566;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1178458711
	)
	int field3567;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1318775007
	)
	int field3568;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 808032681
	)
	int field3569;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1068681997
	)
	int field3570;

	public Timer() {
		this.field3561 = -1L;
		this.field3562 = -1L;
		this.field3563 = false;
		this.field3564 = 0L;
		this.field3565 = 0L;
		this.field3566 = 0L;
		this.field3567 = 0;
		this.field3568 = 0;
		this.field3569 = 0;
		this.field3570 = 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-20"
	)
	public void method4936() {
		this.field3561 = class30.currentTimeMillis();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "1"
	)
	public void method4937() {
		if (-1L != this.field3561) {
			this.field3565 = class30.currentTimeMillis() - this.field3561;
			this.field3561 = -1L;
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1928577406"
	)
	public void method4938(int var1) {
		this.field3562 = class30.currentTimeMillis();
		this.field3567 = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1202204199"
	)
	public void method4939() {
		if (-1L != this.field3562) {
			this.field3564 = class30.currentTimeMillis() - this.field3562;
			this.field3562 = -1L;
		}

		++this.field3569;
		this.field3563 = true;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-832320221"
	)
	public void method4940() {
		this.field3563 = false;
		this.field3568 = 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1318451763"
	)
	public void method4941() {
		this.method4939();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "-1798294121"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3565;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		long var4 = this.field3564;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		long var6 = this.field3566;
		var6 /= 10L;
		if (var6 < 0L) {
			var6 = 0L;
		} else if (var6 > 65535L) {
			var6 = 65535L;
		}

		var1.writeShort((int)var6);
		var1.writeShort(this.field3567);
		var1.writeShort(this.field3568);
		var1.writeShort(this.field3569);
		var1.writeShort(this.field3570);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "7"
	)
	public static int method4935(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}
}
