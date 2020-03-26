import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		signature = "Lbn;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1512673055
	)
	int field2415;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 871751543
	)
	int field2419;
	@ObfuscatedName("d")
	int[] field2443;
	@ObfuscatedName("v")
	int[] field2416;
	@ObfuscatedName("q")
	int[] field2417;
	@ObfuscatedName("z")
	int[] field2420;
	@ObfuscatedName("t")
	int[] field2421;
	@ObfuscatedName("e")
	int[] field2422;
	@ObfuscatedName("s")
	int[] field2423;
	@ObfuscatedName("p")
	int[] field2424;
	@ObfuscatedName("n")
	int[] field2437;
	@ObfuscatedName("l")
	int[] field2428;
	@ObfuscatedName("r")
	int[] field2429;
	@ObfuscatedName("o")
	int[] field2430;
	@ObfuscatedName("c")
	int[] field2431;
	@ObfuscatedName("j")
	int[] field2432;
	@ObfuscatedName("y")
	int[] field2433;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[[Lhz;"
	)
	MusicPatchNode[][] field2441;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "[[Lhz;"
	)
	MusicPatchNode[][] field2435;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "Lhc;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("ai")
	boolean field2418;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		intValue = 1099692055
	)
	@Export("track")
	int track;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1127320341
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		longValue = -9197860659257492463L
	)
	long field2440;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		longValue = 573675785122514817L
	)
	long field2425;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "Lhs;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2415 = 256;
		this.field2419 = 1000000;
		this.field2443 = new int[16];
		this.field2416 = new int[16];
		this.field2417 = new int[16];
		this.field2420 = new int[16];
		this.field2421 = new int[16];
		this.field2422 = new int[16];
		this.field2423 = new int[16];
		this.field2424 = new int[16];
		this.field2437 = new int[16];
		this.field2428 = new int[16];
		this.field2429 = new int[16];
		this.field2430 = new int[16];
		this.field2431 = new int[16];
		this.field2432 = new int[16];
		this.field2433 = new int[16];
		this.field2441 = new MusicPatchNode[16][128];
		this.field2435 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3812();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1144046220"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2415 = var1;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "688694968"
	)
	public int method3793() {
		return this.field2415;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lhh;Liy;Ldk;II)Z",
		garbageValue = "33477442"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method4007();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				var9 = class298.method5343(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var9, (long)var8);
			}

			if (!var9.method3970(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "564851445"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1029490375"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("z")
	protected synchronized int vmethod3984() {
		return 0;
	}

	@ObfuscatedName("t")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2419 / PcmPlayer.field1421;

			do {
				long var5 = (long)var4 * (long)var3 + this.field2440;
				if (this.field2425 - var5 >= 0L) {
					this.field2440 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2425 - this.field2440) - 1L) / (long)var4);
				this.field2440 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3825();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lhh;ZI)V",
		garbageValue = "1158871386"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2418 = var2;
		this.field2440 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2425 = this.midiFile.method3935(this.trackLength);
	}

	@ObfuscatedName("s")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2419 / PcmPlayer.field1421;

			do {
				long var3 = this.field2440 + (long)var1 * (long)var2;
				if (this.field2425 - var3 >= 0L) {
					this.field2440 = var3;
					break;
				}

				int var5 = (int)((this.field2425 - this.field2440 + (long)var2 - 1L) / (long)var2);
				this.field2440 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3825();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1819276165"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3812();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-799045616"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "82"
	)
	public synchronized void method3800(int var1, int var2) {
		this.method3801(var1, var2);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1696015287"
	)
	void method3801(int var1, int var2) {
		this.field2420[var1] = var2;
		this.field2422[var1] = var2 & -128;
		this.method3802(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1712067556"
	)
	void method3802(int var1, int var2) {
		if (var2 != this.field2421[var1]) {
			this.field2421[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2435[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-91684183"
	)
	void method3808(int var1, int var2, int var3) {
		this.method3805(var1, var2, 64);
		if ((this.field2428[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2452 == var1 && var4.field2459 < 0) {
					this.field2441[var1][var4.field2464] = null;
					this.field2441[var1][var2] = var4;
					int var5 = (var4.field2455 * var4.field2454 >> 12) + var4.field2445;
					var4.field2445 += var2 - var4.field2464 << 8;
					var4.field2454 = var5 - var4.field2445;
					var4.field2455 = 4096;
					var4.field2464 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2421[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2452 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2460 = var9.field2488[var2];
				var6.field2467 = var9.field2489[var2];
				var6.field2464 = var2;
				var6.field2451 = var3 * var3 * var9.field2487[var2] * var9.field2484 + 1024 >> 11;
				var6.field2465 = var9.field2490[var2] & 255;
				var6.field2445 = (var2 << 8) - (var9.field2485[var2] & 32767);
				var6.field2456 = 0;
				var6.field2457 = 0;
				var6.field2458 = 0;
				var6.field2459 = -1;
				var6.field2448 = 0;
				if (this.field2431[var1] == 0) {
					var6.stream = RawPcmStream.method2685(var8, this.method3864(var6), this.method3818(var6), this.method3819(var6));
				} else {
					var6.stream = RawPcmStream.method2685(var8, this.method3864(var6), 0, this.method3819(var6));
					this.method3852(var6, var9.field2485[var2] < 0);
				}

				if (var9.field2485[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2467 >= 0) {
					MusicPatchNode var7 = this.field2435[var1][var6.field2467];
					if (var7 != null && var7.field2459 < 0) {
						this.field2441[var1][var7.field2464] = null;
						var7.field2459 = 0;
					}

					this.field2435[var1][var6.field2467] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2441[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhz;ZI)V",
		garbageValue = "-1752723924"
	)
	void method3852(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1407) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2431[var1.field2452] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2655();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2431[var1.field2452] >> 6);
		}

		var1.stream.method2664(var4);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "686121236"
	)
	void method3805(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2441[var1][var2];
		if (var4 != null) {
			this.field2441[var1][var2] = null;
			if ((this.field2428[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2452 == var4.field2452 && var5.field2459 < 0 && var4 != var5) {
						var4.field2459 = 0;
						break;
					}
				}
			} else {
				var4.field2459 = 0;
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-97201691"
	)
	void method3900(int var1, int var2, int var3) {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1237765381"
	)
	void method3817(int var1, int var2) {
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "288952234"
	)
	void method3799(int var1, int var2) {
		this.field2423[var1] = var2;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "866447032"
	)
	void method3809(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2452 == var1) {
				if (var2.stream != null) {
					var2.stream.method2706(PcmPlayer.field1421 / 100);
					if (var2.stream.method2672()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3917();
				}

				if (var2.field2459 < 0) {
					this.field2441[var2.field2452][var2.field2464] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1172399116"
	)
	void method3810(int var1) {
		if (var1 >= 0) {
			this.field2443[var1] = 12800;
			this.field2416[var1] = 8192;
			this.field2417[var1] = 16383;
			this.field2423[var1] = 8192;
			this.field2424[var1] = 0;
			this.field2437[var1] = 8192;
			this.method3813(var1);
			this.method3916(var1);
			this.field2428[var1] = 0;
			this.field2429[var1] = 32767;
			this.field2430[var1] = 256;
			this.field2431[var1] = 0;
			this.method3899(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3810(var1);
			}

		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-67"
	)
	void method3840(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2452 == var1) && var2.field2459 < 0) {
				this.field2441[var2.field2452][var2.field2464] = null;
				var2.field2459 = 0;
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "86"
	)
	void method3812() {
		this.method3809(-1);
		this.method3810(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2421[var1] = this.field2420[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2422[var1] = this.field2420[var1] & -128;
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-529276423"
	)
	void method3813(int var1) {
		if ((this.field2428[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2452 == var1 && this.field2441[var1][var2.field2464] == null && var2.field2459 < 0) {
					var2.field2459 = 0;
				}
			}
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "32"
	)
	void method3916(int var1) {
		if ((this.field2428[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2452 == var1) {
					var2.field2462 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1370441478"
	)
	void method3815(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3805(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3808(var3, var4, var5);
			} else {
				this.method3805(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3900(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2422[var3] = (var5 << 14) + (this.field2422[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2422[var3] = (var5 << 7) + (this.field2422[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2424[var3] = (var5 << 7) + (this.field2424[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2424[var3] = var5 + (this.field2424[var3] & -128);
			}

			if (var4 == 5) {
				this.field2437[var3] = (var5 << 7) + (this.field2437[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2437[var3] = var5 + (this.field2437[var3] & -128);
			}

			if (var4 == 7) {
				this.field2443[var3] = (var5 << 7) + (this.field2443[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2443[var3] = var5 + (this.field2443[var3] & -128);
			}

			if (var4 == 10) {
				this.field2416[var3] = (var5 << 7) + (this.field2416[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2416[var3] = var5 + (this.field2416[var3] & -128);
			}

			if (var4 == 11) {
				this.field2417[var3] = (var5 << 7) + (this.field2417[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2417[var3] = var5 + (this.field2417[var3] & -128);
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
					this.method3813(var3);
					var10000 = this.field2428;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2429[var3] = (var5 << 7) + (this.field2429[var3] & 127);
			}

			if (var4 == 98) {
				this.field2429[var3] = (this.field2429[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2429[var3] = (var5 << 7) + (this.field2429[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2429[var3] = (this.field2429[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3809(var3);
			}

			if (var4 == 121) {
				this.method3810(var3);
			}

			if (var4 == 123) {
				this.method3840(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2429[var3];
				if (var6 == 16384) {
					this.field2430[var3] = (var5 << 7) + (this.field2430[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2429[var3];
				if (var6 == 16384) {
					this.field2430[var3] = var5 + (this.field2430[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2431[var3] = (var5 << 7) + (this.field2431[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2431[var3] = var5 + (this.field2431[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2428;
					var10000[var3] |= 4;
				} else {
					this.method3916(var3);
					var10000 = this.field2428;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3899(var3, (var5 << 7) + (this.field2432[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3899(var3, var5 + (this.field2432[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3802(var3, var4 + this.field2422[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3817(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3799(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3812();
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "97"
	)
	void method3899(int var1, int var2) {
		this.field2432[var1] = var2;
		this.field2433[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Lhz;I)I",
		garbageValue = "-1438720370"
	)
	int method3864(MusicPatchNode var1) {
		int var2 = (var1.field2454 * var1.field2455 >> 12) + var1.field2445;
		var2 += (this.field2423[var1.field2452] - 8192) * this.field2430[var1.field2452] >> 12;
		MusicPatchNode2 var3 = var1.field2460;
		int var4;
		if (var3.field2401 > 0 && (var3.field2395 > 0 || this.field2424[var1.field2452] > 0)) {
			var4 = var3.field2395 << 2;
			int var5 = var3.field2394 << 1;
			if (var1.field2461 < var5) {
				var4 = var4 * var1.field2461 / var5;
			}

			var4 += this.field2424[var1.field2452] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2449 & 511));
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.field1421 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Lhz;I)I",
		garbageValue = "-2023927212"
	)
	int method3818(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2460;
		int var3 = this.field2443[var1.field2452] * this.field2417[var1.field2452] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2451 + 16384 >> 15;
		var3 = var3 * this.field2415 + 128 >> 8;
		if (var2.field2396 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2396 * (double)var1.field2456 * 1.953125E-5D) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2402 != null) {
			var4 = var1.field2457;
			var5 = var2.field2402[var1.field2458 + 1];
			if (var1.field2458 < var2.field2402.length - 2) {
				var6 = (var2.field2402[var1.field2458] & 255) << 8;
				var7 = (var2.field2402[var1.field2458 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2402[var1.field2458 + 3] - var5) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		if (var1.field2459 > 0 && var2.field2398 != null) {
			var4 = var1.field2459;
			var5 = var2.field2398[var1.field2448 + 1];
			if (var1.field2448 < var2.field2398.length - 2) {
				var6 = (var2.field2398[var1.field2448] & 255) << 8;
				var7 = (var2.field2398[var1.field2448 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2398[var1.field2448 + 3] - var5) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(Lhz;I)I",
		garbageValue = "1444946212"
	)
	int method3819(MusicPatchNode var1) {
		int var2 = this.field2416[var1.field2452];
		return var2 < 8192 ? var2 * var1.field2465 + 32 >> 6 : 16384 - ((128 - var1.field2465) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-22"
	)
	void method3825() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2425; var2 == this.trackLength; var3 = this.midiFile.method3935(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2418 || var2 == 0) {
							this.method3812();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3815(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2425 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(Lhz;I)Z",
		garbageValue = "-130954859"
	)
	boolean method3826(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2459 >= 0) {
				var1.remove();
				if (var1.field2467 > 0 && var1 == this.field2435[var1.field2452][var1.field2467]) {
					this.field2435[var1.field2452][var1.field2467] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		signature = "(Lhz;[IIIB)Z",
		garbageValue = "0"
	)
	boolean method3884(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2453 = PcmPlayer.field1421 / 100;
		if (var1.field2459 < 0 || var1.stream != null && !var1.stream.method2671()) {
			int var5 = var1.field2455;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2437[var1.field2452] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2455 = var5;
			}

			var1.stream.method2669(this.method3864(var1));
			MusicPatchNode2 var6 = var1.field2460;
			boolean var7 = false;
			++var1.field2461;
			var1.field2449 += var6.field2401;
			double var8 = (double)((var1.field2464 - 60 << 8) + (var1.field2455 * var1.field2454 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2396 > 0) {
				if (var6.field2399 > 0) {
					var1.field2456 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2399 * var8) + 0.5D);
				} else {
					var1.field2456 += 128;
				}
			}

			if (var6.field2402 != null) {
				if (var6.field2397 > 0) {
					var1.field2457 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2397 * var8) + 0.5D);
				} else {
					var1.field2457 += 128;
				}

				while (var1.field2458 < var6.field2402.length - 2 && var1.field2457 > (var6.field2402[var1.field2458 + 2] & 255) << 8) {
					var1.field2458 += 2;
				}

				if (var6.field2402.length - 2 == var1.field2458 && var6.field2402[var1.field2458 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2459 >= 0 && var6.field2398 != null && (this.field2428[var1.field2452] & 1) == 0 && (var1.field2467 < 0 || var1 != this.field2435[var1.field2452][var1.field2467])) {
				if (var6.field2400 > 0) {
					var1.field2459 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2400 * var8) + 0.5D);
				} else {
					var1.field2459 += 128;
				}

				while (var1.field2448 < var6.field2398.length - 2 && var1.field2459 > (var6.field2398[var1.field2448 + 2] & 255) << 8) {
					var1.field2448 += 2;
				}

				if (var6.field2398.length - 2 == var1.field2448) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2706(var1.field2453);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2672()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3917();
				if (var1.field2459 >= 0) {
					var1.remove();
					if (var1.field2467 > 0 && var1 == this.field2435[var1.field2452][var1.field2467]) {
						this.field2435[var1.field2452][var1.field2467] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2704(var1.field2453, this.method3818(var1), this.method3819(var1));
				return false;
			}
		} else {
			var1.method3917();
			var1.remove();
			if (var1.field2467 > 0 && var1 == this.field2435[var1.field2452][var1.field2467]) {
				this.field2435[var1.field2452][var1.field2467] = null;
			}

			return true;
		}
	}
}
