import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("aj")
	@Export("null_string")
	protected static String null_string;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgg;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lgq;[IIIII)V",
		garbageValue = "1620688263"
	)
	void method4044(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2386[var1.field2425] & 4) != 0 && var1.field2428 < 0) {
			int var6 = this.superStream.field2403[var1.field2425] / (PcmPlayer.PcmPlayer_sampleRate * 22050);

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2434) / var6;
				if (var7 > var4) {
					var1.field2434 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2434 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.PcmPlayer_sampleRate * 22050 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2401[var1.field2425] == 0) {
					var1.stream = RawPcmStream.method2767(var1.rawSound, var10.method2714(), var10.method2705(), var10.method2844());
				} else {
					var1.stream = RawPcmStream.method2767(var1.rawSound, var10.method2714(), 0, var10.method2844());
					this.superStream.method3885(var1, var1.patch.field2460[var1.field2419] < 0);
					var1.stream.method2706(var8, var10.method2705());
				}

				if (var1.patch.field2460[var1.field2419] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2722(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2716()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lgq;IB)V",
		garbageValue = "115"
	)
	void method4045(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2386[var1.field2425] & 4) != 0 && var1.field2428 < 0) {
			int var3 = this.superStream.field2403[var1.field2425] / (PcmPlayer.PcmPlayer_sampleRate * 22050);
			int var4 = (var3 + 1048575 - var1.field2434) / var3;
			var1.field2434 = var3 * var2 + var1.field2434 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2401[var1.field2425] == 0) {
					var1.stream = RawPcmStream.method2767(var1.rawSound, var1.stream.method2714(), var1.stream.method2705(), var1.stream.method2844());
				} else {
					var1.stream = RawPcmStream.method2767(var1.rawSound, var1.stream.method2714(), 0, var1.stream.method2844());
					this.superStream.method3885(var1, var1.patch.field2460[var1.field2419] < 0);
				}

				if (var1.patch.field2460[var1.field2419] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2434 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldj;"
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Ldj;"
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

	@ObfuscatedName("o")
	protected int vmethod4063() {
		return 0;
	}

	@ObfuscatedName("i")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3880(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2433) {
						this.method4044(var6, var1, var4, var5, var5 + var4);
						var6.field2433 -= var5;
						break;
					}

					this.method4044(var6, var1, var4, var6.field2433, var4 + var5);
					var4 += var6.field2433;
					var5 -= var6.field2433;
				} while(!this.superStream.method3881(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("m")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3880(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2433) {
						this.method4045(var3, var2);
						var3.field2433 -= var2;
						break;
					}

					this.method4045(var3, var3.field2433);
					var2 -= var3.field2433;
				} while(!this.superStream.method3881(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "([BZB)Ljava/lang/Object;",
		garbageValue = "25"
	)
	public static Object method4064(byte[] var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0.length > 136) {
			DirectByteArrayCopier var2 = new DirectByteArrayCopier();
			var2.set(var0);
			return var2;
		} else {
			return var0;
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "57344"
	)
	static void method4038() {
		Tiles.Tiles_minPlane = 99;
		SoundSystem.field1414 = new byte[4][104][104];
		Tiles.field485 = new byte[4][104][104];
		Tiles.field482 = new byte[4][104][104];
		Tiles.field483 = new byte[4][104][104];
		Tiles.field488 = new int[4][105][105];
		class96.field1300 = new byte[4][105][105];
		UserComparator10.field1964 = new int[105][105];
		Tiles.Tiles_hue = new int[104];
		Tiles.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		Tiles.Tiles_hueMultiplier = new int[104];
		PlayerType.field3083 = new int[104];
	}
}
