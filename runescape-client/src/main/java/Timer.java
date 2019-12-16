import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("Timer")
public class Timer {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = 1687468324454291725L
	)
	long field3560;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = 7655978754782259035L
	)
	long field3554;
	@ObfuscatedName("y")
	public boolean field3555;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		longValue = 1665338134164527579L
	)
	long field3556;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = -779441764559487179L
	)
	long field3559;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = 4469164127837216533L
	)
	long field3558;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 602333417
	)
	int field3562;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1059100831
	)
	int field3557;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1625866105
	)
	int field3561;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -463850423
	)
	int field3563;

	public Timer() {
		this.field3560 = -1L;
		this.field3554 = -1L;
		this.field3555 = false;
		this.field3556 = 0L;
		this.field3559 = 0L;
		this.field3558 = 0L;
		this.field3562 = 0;
		this.field3557 = 0;
		this.field3561 = 0;
		this.field3563 = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1677674321"
	)
	public void method5016() {
		this.field3560 = WorldMapID.currentTimeMillis();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "608753777"
	)
	public void method5025() {
		if (-1L != this.field3560) {
			this.field3559 = WorldMapID.currentTimeMillis() - this.field3560;
			this.field3560 = -1L;
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "45949945"
	)
	public void method5017(int var1) {
		this.field3554 = WorldMapID.currentTimeMillis();
		this.field3562 = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1761247014"
	)
	public void method5037() {
		if (this.field3554 != -1L) {
			this.field3556 = WorldMapID.currentTimeMillis() - this.field3554;
			this.field3554 = -1L;
		}

		++this.field3561;
		this.field3555 = true;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1677674321"
	)
	public void method5039() {
		this.field3555 = false;
		this.field3557 = 0;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "541541745"
	)
	public void method5020() {
		this.method5037();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "1449461967"
	)
	@Export("write")
	public void write(Buffer var1) {
		MusicPatchNode2.method3670(var1, this.field3559);
		MusicPatchNode2.method3670(var1, this.field3556);
		MusicPatchNode2.method3670(var1, this.field3558);
		var1.writeShort(this.field3562);
		var1.writeShort(this.field3557);
		var1.writeShort(this.field3561);
		var1.writeShort(this.field3563);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "880088989"
	)
	public static int method5033(byte[] var0, int var1, int var2) {
		int var3 = -1;

		for (int var4 = var1; var4 < var2; ++var4) {
			var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
		}

		var3 = ~var3;
		return var3;
	}
}
