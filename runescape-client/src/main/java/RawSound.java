import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("RawSound")
public class RawSound extends AbstractSound {
	@ObfuscatedName("x")
	@Export("sampleRate")
	public int sampleRate;
	@ObfuscatedName("m")
	@Export("samples")
	public byte[] samples;
	@ObfuscatedName("k")
	@Export("start")
	public int start;
	@ObfuscatedName("d")
	@Export("end")
	int end;
	@ObfuscatedName("w")
	public boolean field1407;

	RawSound(int var1, byte[] var2, int var3, int var4) {
		this.sampleRate = var1;
		this.samples = var2;
		this.start = var3;
		this.end = var4;
	}

	RawSound(int var1, byte[] var2, int var3, int var4, boolean var5) {
		this.sampleRate = var1;
		this.samples = var2;
		this.start = var3;
		this.end = var4;
		this.field1407 = var5;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Ldx;)Ldm;"
	)
	@Export("resample")
	public RawSound resample(Decimator var1) {
		this.samples = var1.resample(this.samples);
		this.sampleRate = var1.scaleRate(this.sampleRate);
		if (this.start == this.end) {
			this.start = this.end = var1.scalePosition(this.start);
		} else {
			this.start = var1.scalePosition(this.start);
			this.end = var1.scalePosition(this.end);
			if (this.start == this.end) {
				--this.start;
			}
		}

		return this;
	}
}
