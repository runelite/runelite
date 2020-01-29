import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljw;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lch;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgw;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lgu;[IIIII)V",
		garbageValue = "-1926827063"
	)
	void method3968(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2429[var1.field2447] & 4) != 0 && var1.field2459 < 0) {
			int var6 = this.superStream.field2422[var1.field2447] / PcmPlayer.field1398;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2465) / var6;
				if (var7 > var4) {
					var1.field2465 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2465 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.field1398 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2432[var1.field2447] == 0) {
					var1.stream = RawPcmStream.method2673(var1.rawSound, var10.method2621(), var10.method2612(), var10.method2613());
				} else {
					var1.stream = RawPcmStream.method2673(var1.rawSound, var10.method2621(), 0, var10.method2613());
					this.superStream.method3775(var1, var1.patch.field2483[var1.field2450] < 0);
					var1.stream.method2614(var8, var10.method2612());
				}

				if (var1.patch.field2483[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2619(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2712()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lgu;II)V",
		garbageValue = "1369494496"
	)
	void method3972(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2429[var1.field2447] & 4) != 0 && var1.field2459 < 0) {
			int var3 = this.superStream.field2422[var1.field2447] / PcmPlayer.field1398;
			int var4 = (var3 + 1048575 - var1.field2465) / var3;
			var1.field2465 = var3 * var2 + var1.field2465 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2432[var1.field2447] == 0) {
					var1.stream = RawPcmStream.method2673(var1.rawSound, var1.stream.method2621(), var1.stream.method2612(), var1.stream.method2613());
				} else {
					var1.stream = RawPcmStream.method2673(var1.rawSound, var1.stream.method2621(), 0, var1.stream.method2613());
					this.superStream.method3775(var1, var1.patch.field2483[var1.field2450] < 0);
				}

				if (var1.patch.field2483[var1.field2450] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2465 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
		if (var1 == null) {
			return null;
		} else {
			return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "()Ldn;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		MusicPatchNode var1;
		do {
			var1 = (MusicPatchNode)this.queue.previous();
			if (var1 == null) {
				return null;
			}
		} while(var1.stream == null);

		return var1.stream;
	}

	@ObfuscatedName("l")
	protected int vmethod3965() {
		return 0;
	}

	@ObfuscatedName("j")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3822(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2464) {
						this.method3968(var6, var1, var4, var5, var5 + var4);
						var6.field2464 -= var5;
						break;
					}

					this.method3968(var6, var1, var4, var6.field2464, var4 + var5);
					var4 += var6.field2464;
					var5 -= var6.field2464;
				} while(!this.superStream.method3848(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("p")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3822(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2464) {
						this.method3972(var3, var2);
						var3.field2464 -= var2;
						break;
					}

					this.method3972(var3, var3.field2464);
					var2 -= var3.field2464;
				} while(!this.superStream.method3848(var3, (int[])null, 0, var2));
			}
		}

	}
}
