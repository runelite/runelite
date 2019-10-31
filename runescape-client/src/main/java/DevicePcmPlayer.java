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

@ObfuscatedName("at")
@Implements("DevicePcmPlayer")
public class DevicePcmPlayer extends PcmPlayer {
	@ObfuscatedName("a")
	@Export("format")
	AudioFormat format;
	@ObfuscatedName("t")
	@Export("line")
	SourceDataLine line;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1308062251
	)
	@Export("capacity2")
	int capacity2;
	@ObfuscatedName("q")
	@Export("byteSamples")
	byte[] byteSamples;

	DevicePcmPlayer() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-122"
	)
	@Export("init")
	protected void init() {
		this.format = new AudioFormat((float)(PcmPlayer.PcmPlayer_sampleRate * 22050), 16, InterfaceParent.PcmPlayer_stereo ? 2 : 1, true, false);
		this.byteSamples = new byte[256 << (InterfaceParent.PcmPlayer_stereo ? 2 : 1)];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1329305761"
	)
	@Export("open")
	protected void open(int var1) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.format, var1 << (InterfaceParent.PcmPlayer_stereo ? 2 : 1));
			this.line = (SourceDataLine)AudioSystem.getLine(var2);
			this.line.open();
			this.line.start();
			this.capacity2 = var1;
		} catch (LineUnavailableException var5) {
			if (GraphicsObject.method2158(var1) != 1) {
				int var4 = var1 - 1;
				var4 |= var4 >>> 1;
				var4 |= var4 >>> 2;
				var4 |= var4 >>> 4;
				var4 |= var4 >>> 8;
				var4 |= var4 >>> 16;
				int var3 = var4 + 1;
				this.open(var3);
			} else {
				this.line = null;
				throw var5;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2053382901"
	)
	@Export("position")
	protected int position() {
		return this.capacity2 - (this.line.available() >> (InterfaceParent.PcmPlayer_stereo ? 2 : 1));
	}

	@ObfuscatedName("q")
	@Export("write")
	protected void write() {
		int var1 = 256;
		if (InterfaceParent.PcmPlayer_stereo) {
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-359946727"
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
		garbageValue = "47548316"
	)
	@Export("discard")
	protected void discard() {
		this.line.flush();
	}
}
