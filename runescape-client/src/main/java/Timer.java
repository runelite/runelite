import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = -5854066689636812733L
	)
	long field3575;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -7523897199781097135L
	)
	long field3568;
	@ObfuscatedName("o")
	public boolean field3569;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = 1307131764923953489L
	)
	long field3570;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -1356096473288243273L
	)
	long field3571;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = 7486360679644359965L
	)
	long field3567;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1117727777
	)
	int field3572;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1378192309
	)
	int field3574;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -966098649
	)
	int field3573;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 895210041
	)
	int field3576;

	public Timer() {
		this.field3575 = -1L;
		this.field3568 = -1L;
		this.field3569 = false;
		this.field3570 = 0L;
		this.field3571 = 0L;
		this.field3567 = 0L;
		this.field3572 = 0;
		this.field3574 = 0;
		this.field3573 = 0;
		this.field3576 = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "40"
	)
	public void method5044() {
		this.field3575 = WorldMapIcon_0.currentTimeMillis();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1041013158"
	)
	public void method5045() {
		if (this.field3575 != -1L) {
			this.field3571 = WorldMapIcon_0.currentTimeMillis() - this.field3575;
			this.field3575 = -1L;
		}

	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1882461656"
	)
	public void method5062(int var1) {
		this.field3568 = WorldMapIcon_0.currentTimeMillis();
		this.field3572 = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2083921672"
	)
	public void method5047() {
		if (this.field3568 != -1L) {
			this.field3570 = WorldMapIcon_0.currentTimeMillis() - this.field3568;
			this.field3568 = -1L;
		}

		++this.field3573;
		this.field3569 = true;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-510534855"
	)
	public void method5057() {
		this.field3569 = false;
		this.field3574 = 0;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1911888392"
	)
	public void method5046() {
		this.method5047();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lkp;I)V",
		garbageValue = "-822547863"
	)
	@Export("write")
	public void write(Buffer var1) {
		DynamicObject.method2291(var1, this.field3571);
		DynamicObject.method2291(var1, this.field3570);
		DynamicObject.method2291(var1, this.field3567);
		var1.writeShort(this.field3572);
		var1.writeShort(this.field3574);
		var1.writeShort(this.field3573);
		var1.writeShort(this.field3576);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "([BIS)I",
		garbageValue = "11848"
	)
	public static int method5068(byte[] var0, int var1) {
		int var3 = -1;

		for (int var4 = 0; var4 < var1; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}
}
