import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -9171903714968866551L
	)
	long field3554;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = -5435914068902999871L
	)
	long field3550;
	@ObfuscatedName("t")
	public boolean field3549;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -1599166802350177409L
	)
	long field3547;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 4372389580861267497L
	)
	long field3551;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = 5316590132412911643L
	)
	long field3552;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1679669669
	)
	int field3553;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1804275999
	)
	int field3548;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 899354811
	)
	int field3555;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1638408903
	)
	int field3557;

	public Timer() {
		this.field3554 = -1L;
		this.field3550 = -1L;
		this.field3549 = false;
		this.field3547 = 0L;
		this.field3551 = 0L;
		this.field3552 = 0L;
		this.field3553 = 0;
		this.field3548 = 0;
		this.field3555 = 0;
		this.field3557 = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1784177265"
	)
	public void method4969() {
		this.field3554 = SoundCache.method2480();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	public void method4985() {
		if (this.field3554 != -1L) {
			this.field3551 = SoundCache.method2480() - this.field3554;
			this.field3554 = -1L;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1453810338"
	)
	public void method4971(int var1) {
		this.field3550 = SoundCache.method2480();
		this.field3553 = var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-81603528"
	)
	public void method4972() {
		if (-1L != this.field3550) {
			this.field3547 = SoundCache.method2480() - this.field3550;
			this.field3550 = -1L;
		}

		++this.field3555;
		this.field3549 = true;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "934380433"
	)
	public void method4973() {
		this.field3549 = false;
		this.field3548 = 0;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "122"
	)
	public void method4982() {
		this.method4972();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1973767266"
	)
	@Export("write")
	public void write(Buffer var1) {
		long var2 = this.field3551;
		var2 /= 10L;
		if (var2 < 0L) {
			var2 = 0L;
		} else if (var2 > 65535L) {
			var2 = 65535L;
		}

		var1.writeShort((int)var2);
		VertexNormal.method2958(var1, this.field3547);
		long var4 = this.field3552;
		var4 /= 10L;
		if (var4 < 0L) {
			var4 = 0L;
		} else if (var4 > 65535L) {
			var4 = 65535L;
		}

		var1.writeShort((int)var4);
		var1.writeShort(this.field3553);
		var1.writeShort(this.field3548);
		var1.writeShort(this.field3555);
		var1.writeShort(this.field3557);
	}
}
