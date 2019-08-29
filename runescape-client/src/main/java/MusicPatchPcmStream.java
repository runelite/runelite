import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	static Bounds field2466;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljc;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lcq;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgp;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lgd;[IIIII)V",
		garbageValue = "-1894415083"
	)
	void method3846(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2414[var1.field2437] & 4) != 0 && var1.field2433 < 0) {
			int var6 = this.superStream.field2415[var1.field2437] / PcmPlayer.PcmPlayer_sampleRate;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2439) / var6;
				if (var7 > var4) {
					var1.field2439 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2439 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.PcmPlayer_sampleRate / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2389[var1.field2437] == 0) {
					var1.stream = RawPcmStream.method2460(var1.rawSound, var10.method2603(), var10.method2455(), var10.method2467());
				} else {
					var1.stream = RawPcmStream.method2460(var1.rawSound, var10.method2603(), 0, var10.method2467());
					this.superStream.method3731(var1, var1.patch.field2457[var1.field2424] < 0);
					var1.stream.method2470(var8, var10.method2455());
				}

				if (var1.patch.field2457[var1.field2424] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2473(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2457()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lgd;II)V",
		garbageValue = "1679066242"
	)
	void method3837(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2414[var1.field2437] & 4) != 0 && var1.field2433 < 0) {
			int var3 = this.superStream.field2415[var1.field2437] / PcmPlayer.PcmPlayer_sampleRate;
			int var4 = (var3 + 1048575 - var1.field2439) / var3;
			var1.field2439 = var3 * var2 + var1.field2439 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2389[var1.field2437] == 0) {
					var1.stream = RawPcmStream.method2460(var1.rawSound, var1.stream.method2603(), var1.stream.method2455(), var1.stream.method2467());
				} else {
					var1.stream = RawPcmStream.method2460(var1.rawSound, var1.stream.method2603(), 0, var1.stream.method2467());
					this.superStream.method3731(var1, var1.patch.field2457[var1.field2424] < 0);
				}

				if (var1.patch.field2457[var1.field2424] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2439 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "()Ldz;"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "()Ldz;"
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

	@ObfuscatedName("q")
	protected int vmethod3834() {
		return 0;
	}

	@ObfuscatedName("x")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3680(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2438) {
						this.method3846(var6, var1, var4, var5, var5 + var4);
						var6.field2438 -= var5;
						break;
					}

					this.method3846(var6, var1, var4, var6.field2438, var5 + var4);
					var4 += var6.field2438;
					var5 -= var6.field2438;
				} while(!this.superStream.method3665(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("f")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3680(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2438) {
						this.method3837(var3, var2);
						var3.field2438 -= var2;
						break;
					}

					this.method3837(var3, var3.field2438);
					var2 -= var3.field2438;
				} while(!this.superStream.method3665(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("s")
	public static String method3831(long var0) {
		Calendar.Calendar_calendar.setTime(new Date(var0));
		int var2 = Calendar.Calendar_calendar.get(7);
		int var3 = Calendar.Calendar_calendar.get(5);
		int var4 = Calendar.Calendar_calendar.get(2);
		int var5 = Calendar.Calendar_calendar.get(1);
		int var6 = Calendar.Calendar_calendar.get(11);
		int var7 = Calendar.Calendar_calendar.get(12);
		int var8 = Calendar.Calendar_calendar.get(13);
		return Calendar.DAYS_OF_THE_WEEK[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
	}
}
