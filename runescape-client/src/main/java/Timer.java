import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		longValue = -5009265909251557427L
	)
	long field3567;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = 3656163850803388837L
	)
	long field3569;
	@ObfuscatedName("n")
	public boolean field3568;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = -5484170024319161763L
	)
	long field3570;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = -1992086956533447559L
	)
	long field3571;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 5115114623583473447L
	)
	long field3572;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1585759455
	)
	int field3573;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1782421563
	)
	int field3574;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 303521947
	)
	int field3575;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 19440131
	)
	int field3576;

	public Timer() {
		this.field3567 = -1L;
		this.field3569 = -1L;
		this.field3568 = false;
		this.field3570 = 0L;
		this.field3571 = 0L;
		this.field3572 = 0L;
		this.field3573 = 0;
		this.field3574 = 0;
		this.field3575 = 0;
		this.field3576 = 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1653711688"
	)
	public void method5115() {
		this.field3567 = PlayerAppearance.currentTimeMillis();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2049281372"
	)
	public void method5123() {
		if (this.field3567 != -1L) {
			this.field3571 = PlayerAppearance.currentTimeMillis() - this.field3567;
			this.field3567 = -1L;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1105909109"
	)
	public void method5118(int var1) {
		this.field3569 = PlayerAppearance.currentTimeMillis();
		this.field3573 = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1135526321"
	)
	public void method5119() {
		if (-1L != this.field3569) {
			this.field3570 = PlayerAppearance.currentTimeMillis() - this.field3569;
			this.field3569 = -1L;
		}

		++this.field3575;
		this.field3568 = true;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "179505930"
	)
	public void method5120() {
		this.field3568 = false;
		this.field3574 = 0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-287296961"
	)
	public void method5121() {
		this.method5119();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkc;I)V",
		garbageValue = "-549220155"
	)
	@Export("write")
	public void write(Buffer var1) {
		WorldMapIcon_1.method354(var1, this.field3571);
		WorldMapIcon_1.method354(var1, this.field3570);
		WorldMapIcon_1.method354(var1, this.field3572);
		var1.writeShort(this.field3573);
		var1.writeShort(this.field3574);
		var1.writeShort(this.field3575);
		var1.writeShort(this.field3576);
	}
}
