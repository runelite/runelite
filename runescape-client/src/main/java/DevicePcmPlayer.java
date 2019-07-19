import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
	@ObfuscatedName("q")
	@Export("format")
	AudioFormat format;
	@ObfuscatedName("w")
	@Export("line")
	SourceDataLine line;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1783357217
	)
	@Export("capacity2")
	int capacity2;
	@ObfuscatedName("p")
	@Export("byteSamples")
	byte[] byteSamples;

	DevicePcmPlayer() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1518489339"
	)
	@Export("init")
	protected void init() {
		this.format = new AudioFormat((float)CollisionMap.PcmPlayer_sampleRate, 16, class169.isStereo ? 2 : 1, true, false);
		this.byteSamples = new byte[256 << (class169.isStereo ? 2 : 1)];
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "2"
	)
	@Export("open")
	protected void open(int var1) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.format, var1 << (class169.isStereo ? 2 : 1));
			this.line = (SourceDataLine)AudioSystem.getLine(var2);
			this.line.open();
			this.line.start();
			this.capacity2 = var1;
		} catch (LineUnavailableException var7) {
			int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
			var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
			var4 = (var4 >>> 4) + var4 & 252645135;
			var4 += var4 >>> 8;
			var4 += var4 >>> 16;
			int var3 = var4 & 255;
			if (var3 != 1) {
				int var6 = var1 - 1;
				var6 |= var6 >>> 1;
				var6 |= var6 >>> 2;
				var6 |= var6 >>> 4;
				var6 |= var6 >>> 8;
				var6 |= var6 >>> 16;
				int var5 = var6 + 1;
				this.open(var5);
			} else {
				this.line = null;
				throw var7;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "97"
	)
	@Export("position")
	protected int position() {
		return this.capacity2 - (this.line.available() >> (class169.isStereo ? 2 : 1));
	}

	@ObfuscatedName("p")
	@Export("write")
	protected void write() {
		int var1 = 256;
		if (class169.isStereo) {
			var1 <<= 1;
		}

		for (int var2 = 0; var2 < var1; ++var2) {
			int var3 = super.samples[var2];
			if ((var3 + 8388608 & -16777216) != 0) {
				var3 = 8388607 ^ var3 >> 31;
			}

			this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
			this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
		}

		this.line.write(this.byteSamples, 0, var1 << 1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "57"
	)
	@Export("close")
	protected void close() {
		if (this.line != null) {
			this.line.close();
			this.line = null;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-313753219"
	)
	@Export("discard")
	protected void discard() {
		this.line.flush();
	}
}
