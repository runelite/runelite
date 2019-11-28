import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1040348167
	)
	int field2417;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -618997033
	)
	int field2419;
	@ObfuscatedName("g")
	int[] field2437;
	@ObfuscatedName("z")
	int[] field2420;
	@ObfuscatedName("p")
	int[] field2442;
	@ObfuscatedName("h")
	int[] field2422;
	@ObfuscatedName("y")
	int[] field2421;
	@ObfuscatedName("i")
	int[] field2424;
	@ObfuscatedName("k")
	int[] field2425;
	@ObfuscatedName("x")
	int[] field2443;
	@ObfuscatedName("o")
	int[] field2427;
	@ObfuscatedName("s")
	int[] field2428;
	@ObfuscatedName("t")
	int[] field2440;
	@ObfuscatedName("m")
	int[] field2430;
	@ObfuscatedName("v")
	int[] field2441;
	@ObfuscatedName("q")
	int[] field2432;
	@ObfuscatedName("l")
	int[] field2433;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[[Lge;"
	)
	MusicPatchNode[][] field2434;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "[[Lge;"
	)
	MusicPatchNode[][] field2435;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("am")
	boolean field2426;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = -664864555
	)
	@Export("track")
	int track;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = -1177592685
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		longValue = -3140797067045383129L
	)
	long field2431;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		longValue = 7928451830395047815L
	)
	long field2416;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2417 = 256;
		this.field2419 = 1000000;
		this.field2437 = new int[16];
		this.field2420 = new int[16];
		this.field2442 = new int[16];
		this.field2422 = new int[16];
		this.field2421 = new int[16];
		this.field2424 = new int[16];
		this.field2425 = new int[16];
		this.field2443 = new int[16];
		this.field2427 = new int[16];
		this.field2428 = new int[16];
		this.field2440 = new int[16];
		this.field2430 = new int[16];
		this.field2441 = new int[16];
		this.field2432 = new int[16];
		this.field2433 = new int[16];
		this.field2434 = new MusicPatchNode[16][128];
		this.field2435 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3787();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "31"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2417 = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-847322953"
	)
	int method3769() {
		return this.field2417;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lgt;Lhf;Ldk;II)Z",
		garbageValue = "612802869"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method3987();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				byte[] var11 = var2.takeFileFlat(var8);
				MusicPatch var10;
				if (var11 == null) {
					var10 = null;
				} else {
					var10 = new MusicPatch(var11);
				}

				var9 = var10;
				if (var10 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var10, (long)var8);
			}

			if (!var9.method3952(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "34"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1987681948"
	)
	@Export("removeAll")
	synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "()Ldt;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("y")
	protected synchronized int vmethod3963() {
		return 0;
	}

	@ObfuscatedName("w")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2419 * -727379968 / Messages.PcmPlayer_sampleRate;

			do {
				long var5 = this.field2431 + (long)var4 * (long)var3;
				if (this.field2416 - var5 >= 0L) {
					this.field2431 = var5;
					break;
				}

				int var7 = (int)((this.field2416 - this.field2431 + (long)var4 - 1L) / (long)var4);
				this.field2431 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3800();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgt;ZI)V",
		garbageValue = "1137691865"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2426 = var2;
		this.field2431 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2416 = this.midiFile.method3906(this.trackLength);
	}

	@ObfuscatedName("k")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2419 * -727379968 / Messages.PcmPlayer_sampleRate;

			do {
				long var3 = this.field2431 + (long)var2 * (long)var1;
				if (this.field2416 - var3 >= 0L) {
					this.field2431 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2416 - this.field2431) - 1L) / (long)var2);
				this.field2431 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3800();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-196539834"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3787();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2105523598"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "2056390451"
	)
	public synchronized void method3775(int var1, int var2) {
		this.method3817(var1, var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1275355891"
	)
	void method3817(int var1, int var2) {
		this.field2422[var1] = var2;
		this.field2424[var1] = var2 & -128;
		this.method3777(var1, var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1314090559"
	)
	void method3777(int var1, int var2) {
		if (var2 != this.field2421[var1]) {
			this.field2421[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2435[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1833290175"
	)
	void method3778(int var1, int var2, int var3) {
		this.method3816(var1, var2, 64);
		if ((this.field2428[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2449 == var1 && var4.field2459 < 0) {
					this.field2434[var1][var4.field2450] = null;
					this.field2434[var1][var2] = var4;
					int var5 = (var4.field2455 * var4.field2454 >> 12) + var4.field2465;
					var4.field2465 += var2 - var4.field2450 << 8;
					var4.field2454 = var5 - var4.field2465;
					var4.field2455 = 4096;
					var4.field2450 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2421[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2449 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2448 = var9.field2488[var2];
				var6.field2445 = var9.field2487[var2];
				var6.field2450 = var2;
				var6.field2451 = var3 * var3 * var9.field2486[var2] * var9.field2489 + 1024 >> 11;
				var6.field2452 = var9.field2483[var2] & 255;
				var6.field2465 = (var2 << 8) - (var9.field2485[var2] & 32767);
				var6.field2456 = 0;
				var6.field2457 = 0;
				var6.field2458 = 0;
				var6.field2459 = -1;
				var6.field2460 = 0;
				if (this.field2441[var1] == 0) {
					var6.stream = RawPcmStream.method2568(var8, this.method3862(var6), this.method3793(var6), this.method3794(var6));
				} else {
					var6.stream = RawPcmStream.method2568(var8, this.method3862(var6), 0, this.method3794(var6));
					this.method3779(var6, var9.field2485[var2] < 0);
				}

				if (var9.field2485[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2445 >= 0) {
					MusicPatchNode var7 = this.field2435[var1][var6.field2445];
					if (var7 != null && var7.field2459 < 0) {
						this.field2434[var1][var7.field2450] = null;
						var7.field2459 = 0;
					}

					this.field2435[var1][var6.field2445] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2434[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lge;ZI)V",
		garbageValue = "-1090319556"
	)
	void method3779(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1378) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2441[var1.field2449] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2578();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2441[var1.field2449] >> 6);
		}

		var1.stream.method2722(var4);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-33"
	)
	void method3816(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2434[var1][var2];
		if (var4 != null) {
			this.field2434[var1][var2] = null;
			if ((this.field2428[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2449 == var4.field2449 && var5.field2459 < 0 && var5 != var4) {
						var4.field2459 = 0;
						break;
					}
				}
			} else {
				var4.field2459 = 0;
			}

		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-115"
	)
	void method3781(int var1, int var2, int var3) {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1083073471"
	)
	void method3782(int var1, int var2) {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "683649842"
	)
	void method3783(int var1, int var2) {
		this.field2425[var1] = var2;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "41766095"
	)
	void method3784(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2449 == var1) {
				if (var2.stream != null) {
					var2.stream.method2582(Messages.PcmPlayer_sampleRate / 100);
					if (var2.stream.method2686()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3893();
				}

				if (var2.field2459 < 0) {
					this.field2434[var2.field2449][var2.field2450] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "54"
	)
	void method3820(int var1) {
		if (var1 >= 0) {
			this.field2437[var1] = 12800;
			this.field2420[var1] = 8192;
			this.field2442[var1] = 16383;
			this.field2425[var1] = 8192;
			this.field2443[var1] = 0;
			this.field2427[var1] = 8192;
			this.method3837(var1);
			this.method3789(var1);
			this.field2428[var1] = 0;
			this.field2440[var1] = 32767;
			this.field2430[var1] = 256;
			this.field2441[var1] = 0;
			this.method3791(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3820(var1);
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "122"
	)
	void method3786(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2449 == var1) && var2.field2459 < 0) {
				this.field2434[var2.field2449][var2.field2450] = null;
				var2.field2459 = 0;
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-18"
	)
	void method3787() {
		this.method3784(-1);
		this.method3820(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2421[var1] = this.field2422[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2424[var1] = this.field2422[var1] & -128;
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1524706833"
	)
	void method3837(int var1) {
		if ((this.field2428[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2449 == var1 && this.field2434[var1][var2.field2450] == null && var2.field2459 < 0) {
					var2.field2459 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-339945953"
	)
	void method3789(int var1) {
		if ((this.field2428[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2449 == var1) {
					var2.field2463 = 0;
				}
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "640708386"
	)
	void method3770(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3816(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3778(var3, var4, var5);
			} else {
				this.method3816(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3781(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2424[var3] = (var5 << 14) + (this.field2424[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2424[var3] = (var5 << 7) + (this.field2424[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2443[var3] = (var5 << 7) + (this.field2443[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2443[var3] = var5 + (this.field2443[var3] & -128);
			}

			if (var4 == 5) {
				this.field2427[var3] = (var5 << 7) + (this.field2427[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2427[var3] = var5 + (this.field2427[var3] & -128);
			}

			if (var4 == 7) {
				this.field2437[var3] = (var5 << 7) + (this.field2437[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2437[var3] = var5 + (this.field2437[var3] & -128);
			}

			if (var4 == 10) {
				this.field2420[var3] = (var5 << 7) + (this.field2420[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2420[var3] = var5 + (this.field2420[var3] & -128);
			}

			if (var4 == 11) {
				this.field2442[var3] = (var5 << 7) + (this.field2442[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2442[var3] = var5 + (this.field2442[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2428;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2428;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2428;
					var10000[var3] |= 2;
				} else {
					this.method3837(var3);
					var10000 = this.field2428;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2440[var3] = (var5 << 7) + (this.field2440[var3] & 127);
			}

			if (var4 == 98) {
				this.field2440[var3] = (this.field2440[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2440[var3] = (var5 << 7) + (this.field2440[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2440[var3] = (this.field2440[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3784(var3);
			}

			if (var4 == 121) {
				this.method3820(var3);
			}

			if (var4 == 123) {
				this.method3786(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2440[var3];
				if (var6 == 16384) {
					this.field2430[var3] = (var5 << 7) + (this.field2430[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2440[var3];
				if (var6 == 16384) {
					this.field2430[var3] = var5 + (this.field2430[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2441[var3] = (var5 << 7) + (this.field2441[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2441[var3] = var5 + (this.field2441[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2428;
					var10000[var3] |= 4;
				} else {
					this.method3789(var3);
					var10000 = this.field2428;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3791(var3, (var5 << 7) + (this.field2432[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3791(var3, var5 + (this.field2432[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3777(var3, var4 + this.field2424[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3782(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3783(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3787();
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2102724080"
	)
	void method3791(int var1, int var2) {
		this.field2432[var1] = var2;
		this.field2433[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(Lge;B)I",
		garbageValue = "1"
	)
	int method3862(MusicPatchNode var1) {
		int var2 = (var1.field2455 * var1.field2454 >> 12) + var1.field2465;
		var2 += (this.field2425[var1.field2449] - 8192) * this.field2430[var1.field2449] >> 12;
		MusicPatchNode2 var3 = var1.field2448;
		int var4;
		if (var3.field2405 > 0 && (var3.field2401 > 0 || this.field2443[var1.field2449] > 0)) {
			var4 = var3.field2401 << 2;
			int var5 = var3.field2402 << 1;
			if (var1.field2461 < var5) {
				var4 = var4 * var1.field2461 / var5;
			}

			var4 += this.field2443[var1.field2449] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2462 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)Messages.PcmPlayer_sampleRate + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Lge;B)I",
		garbageValue = "7"
	)
	int method3793(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2448;
		int var3 = this.field2442[var1.field2449] * this.field2437[var1.field2449] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2451 + 16384 >> 15;
		var3 = var3 * this.field2417 + 128 >> 8;
		if (var2.field2400 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2456 * (double)var2.field2400) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2404 != null) {
			var4 = var1.field2457;
			var5 = var2.field2404[var1.field2458 * 4 + 1];
			if (var1.field2458 * 4 < var2.field2404.length - 2) {
				var6 = (var2.field2404[var1.field2458 * 4] & 255) << 8;
				var7 = (var2.field2404[var1.field2458 * 4 + 2] & 255) << 8;
				var5 += (var2.field2404[var1.field2458 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2459 > 0 && var2.field2399 != null) {
			var4 = var1.field2459;
			var5 = var2.field2399[var1.field2460 * 4 + 1];
			if (var1.field2460 * 4 < var2.field2399.length - 2) {
				var6 = (var2.field2399[var1.field2460 * 4] & 255) << 8;
				var7 = (var2.field2399[var1.field2460 * 4 + 2] & 255) << 8;
				var5 += (var2.field2399[var1.field2460 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Lge;I)I",
		garbageValue = "1924101342"
	)
	int method3794(MusicPatchNode var1) {
		int var2 = this.field2420[var1.field2449];
		return var2 < 8192 ? var2 * var1.field2452 + 32 >> 6 : 16384 - ((128 - var1.field2452) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "869204676"
	)
	void method3800() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2416; var2 == this.trackLength; var3 = this.midiFile.method3906(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2426 || var2 == 0) {
							this.method3787();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3770(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2416 = var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(Lge;B)Z",
		garbageValue = "0"
	)
	boolean method3801(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2459 >= 0) {
				var1.remove();
				if (var1.field2445 > 0 && var1 == this.field2435[var1.field2449][var1.field2445]) {
					this.field2435[var1.field2449][var1.field2445] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(Lge;[IIII)Z",
		garbageValue = "178317578"
	)
	boolean method3802(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2464 = Messages.PcmPlayer_sampleRate / 100;
		if (var1.field2459 < 0 || var1.stream != null && !var1.stream.method2585()) {
			int var5 = var1.field2455;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2427[var1.field2449] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2455 = var5;
			}

			var1.stream.method2679(this.method3862(var1));
			MusicPatchNode2 var6 = var1.field2448;
			boolean var7 = false;
			++var1.field2461;
			var1.field2462 += var6.field2405;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2450 - 60 << 8) + (var1.field2454 * var1.field2455 >> 12));
			if (var6.field2400 > 0) {
				if (var6.field2403 > 0) {
					var1.field2456 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2403 * var8) + 0.5D);
				} else {
					var1.field2456 += 128;
				}
			}

			if (var6.field2404 != null) {
				if (var6.field2398 > 0) {
					var1.field2457 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2398) + 0.5D);
				} else {
					var1.field2457 += 128;
				}

				while (var1.field2458 * 4 < var6.field2404.length - 2 && var1.field2457 > (var6.field2404[var1.field2458 * 4 + 2] & 255) << 8) {
					var1.field2458 = var1.field2458 * 4 + 2;
				}

				if (var1.field2458 * 4 == var6.field2404.length - 2 && var6.field2404[var1.field2458 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2459 >= 0 && var6.field2399 != null && (this.field2428[var1.field2449] & 1) == 0 && (var1.field2445 < 0 || var1 != this.field2435[var1.field2449][var1.field2445])) {
				if (var6.field2407 > 0) {
					var1.field2459 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2407 * var8) + 0.5D);
				} else {
					var1.field2459 += 128;
				}

				while (var1.field2460 * 4 < var6.field2399.length - 2 && var1.field2459 > (var6.field2399[var1.field2460 * 4 + 2] & 255) << 8) {
					var1.field2460 = var1.field2460 * 4 + 2;
				}

				if (var1.field2460 * 4 == var6.field2399.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2582(var1.field2464);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2686()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3893();
				if (var1.field2459 >= 0) {
					var1.remove();
					if (var1.field2445 > 0 && var1 == this.field2435[var1.field2449][var1.field2445]) {
						this.field2435[var1.field2449][var1.field2445] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2581(var1.field2464, this.method3793(var1), this.method3794(var1));
				return false;
			}
		} else {
			var1.method3893();
			var1.remove();
			if (var1.field2445 > 0 && var1 == this.field2435[var1.field2449][var1.field2445]) {
				this.field2435[var1.field2449][var1.field2445] = null;
			}

			return true;
		}
	}
}
