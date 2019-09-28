import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("r")
	@Export("SpriteBuffer_yOffsets")
	public static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgb;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lgu;[IIIII)V",
		garbageValue = "1901627378"
	)
	void method3879(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2404[var1.field2420] & 4) != 0 && var1.field2433 < 0) {
			int var6 = this.superStream.field2401[var1.field2420] / UrlRequest.PcmPlayer_sampleRate;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2419) / var6;
				if (var7 > var4) {
					var1.field2419 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2419 += var7 * var6 - 1048576;
				int var8 = UrlRequest.PcmPlayer_sampleRate / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2408[var1.field2420] == 0) {
					var1.stream = RawPcmStream.method2548(var1.rawSound, var10.method2531(), var10.method2522(), var10.method2523());
				} else {
					var1.stream = RawPcmStream.method2548(var1.rawSound, var10.method2531(), 0, var10.method2523());
					this.superStream.method3682(var1, var1.patch.field2457[var1.field2424] < 0);
					var1.stream.method2527(var8, var10.method2522());
				}

				if (var1.patch.field2457[var1.field2424] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2529(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2533()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lgu;IB)V",
		garbageValue = "66"
	)
	void method3875(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2404[var1.field2420] & 4) != 0 && var1.field2433 < 0) {
			int var3 = this.superStream.field2401[var1.field2420] / UrlRequest.PcmPlayer_sampleRate;
			int var4 = (var3 + 1048575 - var1.field2419) / var3;
			var1.field2419 = var3 * var2 + var1.field2419 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2408[var1.field2420] == 0) {
					var1.stream = RawPcmStream.method2548(var1.rawSound, var1.stream.method2531(), var1.stream.method2522(), var1.stream.method2523());
				} else {
					var1.stream = RawPcmStream.method2548(var1.rawSound, var1.stream.method2531(), 0, var1.stream.method2523());
					this.superStream.method3682(var1, var1.patch.field2457[var1.field2424] < 0);
				}

				if (var1.patch.field2457[var1.field2424] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2419 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldc;"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Ldc;"
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

	@ObfuscatedName("m")
	protected int vmethod3882() {
		return 0;
	}

	@ObfuscatedName("y")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3704(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2438) {
						this.method3879(var6, var1, var4, var5, var4 + var5);
						var6.field2438 -= var5;
						break;
					}

					this.method3879(var6, var1, var4, var6.field2438, var4 + var5);
					var4 += var6.field2438;
					var5 -= var6.field2438;
				} while(!this.superStream.method3705(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("c")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3704(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2438) {
						this.method3875(var3, var2);
						var3.field2438 -= var2;
						break;
					}

					this.method3875(var3, var3.field2438);
					var2 -= var3.field2438;
				} while(!this.superStream.method3705(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("gf")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-2075145984"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4] >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var9 * var7 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}
}
