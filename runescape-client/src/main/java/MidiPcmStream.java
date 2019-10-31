import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = -1186569365
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -969808631
	)
	int field2399;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1268396736
	)
	int field2387;
	@ObfuscatedName("q")
	int[] field2388;
	@ObfuscatedName("v")
	int[] field2398;
	@ObfuscatedName("l")
	int[] field2390;
	@ObfuscatedName("c")
	int[] field2391;
	@ObfuscatedName("o")
	int[] field2413;
	@ObfuscatedName("i")
	int[] field2393;
	@ObfuscatedName("d")
	int[] field2396;
	@ObfuscatedName("m")
	int[] field2395;
	@ObfuscatedName("p")
	int[] field2389;
	@ObfuscatedName("b")
	int[] field2386;
	@ObfuscatedName("z")
	int[] field2394;
	@ObfuscatedName("f")
	int[] field2400;
	@ObfuscatedName("g")
	int[] field2401;
	@ObfuscatedName("w")
	int[] field2392;
	@ObfuscatedName("u")
	int[] field2403;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "[[Lgq;"
	)
	MusicPatchNode[][] field2409;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "[[Lgq;"
	)
	MusicPatchNode[][] field2385;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "Lgr;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("ar")
	boolean field2407;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = -1908280461
	)
	@Export("track")
	int track;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 1604575573
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		longValue = -5934484016518299703L
	)
	long field2410;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		longValue = 6514613664969707015L
	)
	long field2411;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Lgd;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field2399 = 256;
		this.field2387 = -727379968;
		this.field2388 = new int[16];
		this.field2398 = new int[16];
		this.field2390 = new int[16];
		this.field2391 = new int[16];
		this.field2413 = new int[16];
		this.field2393 = new int[16];
		this.field2396 = new int[16];
		this.field2395 = new int[16];
		this.field2389 = new int[16];
		this.field2386 = new int[16];
		this.field2394 = new int[16];
		this.field2400 = new int[16];
		this.field2401 = new int[16];
		this.field2392 = new int[16];
		this.field2403 = new int[16];
		this.field2409 = new MusicPatchNode[16][128];
		this.field2385 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method3866();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "636798046"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2399 = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "13"
	)
	public int method3848() {
		return this.field2399;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lgb;Lhq;Ldm;II)Z",
		garbageValue = "220322847"
	)
	@Export("loadMusicTrack")
	public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method4072();
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

			if (!var9.method4034(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "893329353"
	)
	@Export("clearAll")
	public synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1692689357"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "()Ldj;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("o")
	protected synchronized int vmethod4063() {
		return 0;
	}

	@ObfuscatedName("i")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2387 * 1000000 / (PcmPlayer.PcmPlayer_sampleRate * 22050);

			do {
				long var5 = this.field2410 + (long)var3 * (long)var4;
				if (this.field2411 - var5 >= 0L) {
					this.field2410 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2411 - this.field2410) - 1L) / (long)var4);
				this.field2410 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method3945();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lgb;ZI)V",
		garbageValue = "-369065525"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2407 = var2;
		this.field2410 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2411 = this.midiFile.method3987(this.trackLength);
	}

	@ObfuscatedName("m")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2387 * 1000000 / (PcmPlayer.PcmPlayer_sampleRate * 22050);

			do {
				long var3 = (long)var2 * (long)var1 + this.field2410;
				if (this.field2411 - var3 >= 0L) {
					this.field2410 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2411 - this.field2410) - 1L) / (long)var2);
				this.field2410 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method3945();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "54"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method3866();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1270364746"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1705668679"
	)
	public synchronized void method3899(int var1, int var2) {
		this.method3856(var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1521021753"
	)
	void method3856(int var1, int var2) {
		this.field2391[var1] = var2;
		this.field2393[var1] = var2 & -128;
		this.method3968(var1, var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1482867334"
	)
	void method3968(int var1, int var2) {
		if (var2 != this.field2413[var1]) {
			this.field2413[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2385[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1390676014"
	)
	void method3858(int var1, int var2, int var3) {
		this.method3860(var1, var2, 64);
		if ((this.field2386[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2425 == var1 && var4.field2428 < 0) {
					this.field2409[var1][var4.field2419] = null;
					this.field2409[var1][var2] = var4;
					int var5 = (var4.field2424 * var4.field2423 >> 12) + var4.field2416;
					var4.field2416 += var2 - var4.field2419 << 8;
					var4.field2423 = var5 - var4.field2416;
					var4.field2424 = 4096;
					var4.field2419 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2413[var1]);
		if (var9 != null) {
			RawSound var8 = var9.rawSounds[var2];
			if (var8 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field2425 = var1;
				var6.patch = var9;
				var6.rawSound = var8;
				var6.field2417 = var9.field2458[var2];
				var6.field2422 = var9.field2459[var2];
				var6.field2419 = var2;
				var6.field2430 = var3 * var3 * var9.field2453[var2] * var9.field2454 + 1024 >> 11;
				var6.field2421 = var9.field2457[var2] & 255;
				var6.field2416 = (var2 << 8) - (var9.field2460[var2] & 32767);
				var6.field2420 = 0;
				var6.field2431 = 0;
				var6.field2427 = 0;
				var6.field2428 = -1;
				var6.field2429 = 0;
				if (this.field2401[var1] == 0) {
					var6.stream = RawPcmStream.method2767(var8, this.method3934(var6), this.method3875(var6), this.method3873(var6));
				} else {
					var6.stream = RawPcmStream.method2767(var8, this.method3934(var6), 0, this.method3873(var6));
					this.method3885(var6, var9.field2460[var2] < 0);
				}

				if (var9.field2460[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field2422 >= 0) {
					MusicPatchNode var7 = this.field2385[var1][var6.field2422];
					if (var7 != null && var7.field2428 < 0) {
						this.field2409[var1][var7.field2419] = null;
						var7.field2428 = 0;
					}

					this.field2385[var1][var6.field2422] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field2409[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lgq;ZI)V",
		garbageValue = "-1702436335"
	)
	void method3885(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field1363) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2401[var1.field2425] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method2708();
			}
		} else {
			var4 = (int)((long)this.field2401[var1.field2425] * (long)var3 >> 6);
		}

		var1.stream.method2707(var4);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-493444967"
	)
	void method3860(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2409[var1][var2];
		if (var4 != null) {
			this.field2409[var1][var2] = null;
			if ((this.field2386[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var4.field2425 == var5.field2425 && var5.field2428 < 0 && var4 != var5) {
						var4.field2428 = 0;
						break;
					}
				}
			} else {
				var4.field2428 = 0;
			}

		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1280416212"
	)
	void method3943(int var1, int var2, int var3) {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-122"
	)
	void method3862(int var1, int var2) {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1364823347"
	)
	void method3949(int var1, int var2) {
		this.field2396[var1] = var2;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "948298750"
	)
	void method3864(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2425 == var1) {
				if (var2.stream != null) {
					var2.stream.method2722(PcmPlayer.PcmPlayer_sampleRate * 22050 / 100);
					if (var2.stream.method2716()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method3974();
				}

				if (var2.field2428 < 0) {
					this.field2409[var2.field2425][var2.field2419] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "996018902"
	)
	void method3865(int var1) {
		if (var1 >= 0) {
			this.field2388[var1] = 12800;
			this.field2398[var1] = 8192;
			this.field2390[var1] = 16383;
			this.field2396[var1] = 8192;
			this.field2395[var1] = 0;
			this.field2389[var1] = 8192;
			this.method3898(var1);
			this.method3868(var1);
			this.field2386[var1] = 0;
			this.field2394[var1] = 32767;
			this.field2400[var1] = 256;
			this.field2401[var1] = 0;
			this.method3870(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method3865(var1);
			}

		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1405411261"
	)
	void method3908(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2425 == var1) && var2.field2428 < 0) {
				this.field2409[var2.field2425][var2.field2419] = null;
				var2.field2428 = 0;
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1685703107"
	)
	void method3866() {
		this.method3864(-1);
		this.method3865(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2413[var1] = this.field2391[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2393[var1] = this.field2391[var1] & -128;
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2123052342"
	)
	void method3898(int var1) {
		if ((this.field2386[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2425 == var1 && this.field2409[var1][var2.field2419] == null && var2.field2428 < 0) {
					var2.field2428 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1415970764"
	)
	void method3868(int var1) {
		if ((this.field2386[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2425 == var1) {
					var2.field2434 = 0;
				}
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1364540347"
	)
	void method3869(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3860(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method3858(var3, var4, var5);
			} else {
				this.method3860(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method3943(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2393[var3] = (var5 << 14) + (this.field2393[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2393[var3] = (var5 << 7) + (this.field2393[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2395[var3] = (var5 << 7) + (this.field2395[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2395[var3] = var5 + (this.field2395[var3] & -128);
			}

			if (var4 == 5) {
				this.field2389[var3] = (var5 << 7) + (this.field2389[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2389[var3] = var5 + (this.field2389[var3] & -128);
			}

			if (var4 == 7) {
				this.field2388[var3] = (var5 << 7) + (this.field2388[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2388[var3] = var5 + (this.field2388[var3] & -128);
			}

			if (var4 == 10) {
				this.field2398[var3] = (var5 << 7) + (this.field2398[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2398[var3] = var5 + (this.field2398[var3] & -128);
			}

			if (var4 == 11) {
				this.field2390[var3] = (var5 << 7) + (this.field2390[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2390[var3] = var5 + (this.field2390[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2386;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2386;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2386;
					var10000[var3] |= 2;
				} else {
					this.method3898(var3);
					var10000 = this.field2386;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2394[var3] = (var5 << 7) + (this.field2394[var3] & 127);
			}

			if (var4 == 98) {
				this.field2394[var3] = (this.field2394[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2394[var3] = (var5 << 7) + (this.field2394[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2394[var3] = (this.field2394[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method3864(var3);
			}

			if (var4 == 121) {
				this.method3865(var3);
			}

			if (var4 == 123) {
				this.method3908(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2394[var3];
				if (var6 == 16384) {
					this.field2400[var3] = (var5 << 7) + (this.field2400[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2394[var3];
				if (var6 == 16384) {
					this.field2400[var3] = var5 + (this.field2400[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2401[var3] = (var5 << 7) + (this.field2401[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2401[var3] = var5 + (this.field2401[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2386;
					var10000[var3] |= 4;
				} else {
					this.method3868(var3);
					var10000 = this.field2386;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method3870(var3, (var5 << 7) + (this.field2392[var3] & -16257));
			}

			if (var4 == 49) {
				this.method3870(var3, var5 + (this.field2392[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3968(var3, var4 + this.field2393[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method3862(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method3949(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method3866();
			}
		}
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-1849310694"
	)
	void method3870(int var1, int var2) {
		this.field2392[var1] = var2;
		this.field2403[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(Lgq;I)I",
		garbageValue = "-1843561"
	)
	int method3934(MusicPatchNode var1) {
		int var2 = (var1.field2423 * var1.field2424 >> 12) + var1.field2416;
		var2 += (this.field2396[var1.field2425] - 8192) * this.field2400[var1.field2425] >> 12;
		MusicPatchNode2 var3 = var1.field2417;
		int var4;
		if (var3.field2367 > 0 && (var3.field2360 > 0 || this.field2395[var1.field2425] > 0)) {
			var4 = var3.field2360 << 2;
			int var5 = var3.field2368 << 1;
			if (var1.field2426 < var5) {
				var4 = var4 * var1.field2426 / var5;
			}

			var4 += this.field2395[var1.field2425] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2414 & 511));
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)(PcmPlayer.PcmPlayer_sampleRate * 22050) + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		signature = "(Lgq;B)I",
		garbageValue = "-86"
	)
	int method3875(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2417;
		int var3 = this.field2390[var1.field2425] * this.field2388[var1.field2425] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2430 + 16384 >> 15;
		var3 = var3 * this.field2399 + 128 >> 8;
		if (var2.field2371 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2371 * (double)var1.field2420 * 1.953125E-5D) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2364 != null) {
			var4 = var1.field2431;
			var5 = var2.field2364[var1.field2427 * 4 + 1];
			if (var1.field2427 * 4 < var2.field2364.length - 2) {
				var6 = (var2.field2364[var1.field2427 * 4] & 255) << 8;
				var7 = (var2.field2364[var1.field2427 * 4 + 2] & 255) << 8;
				var5 += (var2.field2364[var1.field2427 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		if (var1.field2428 > 0 && var2.field2361 != null) {
			var4 = var1.field2428;
			var5 = var2.field2361[var1.field2429 * 4 + 1];
			if (var1.field2429 * 4 < var2.field2361.length - 2) {
				var6 = (var2.field2361[var1.field2429 * 4] & 255) << 8;
				var7 = (var2.field2361[var1.field2429 * 4 + 2] & 255) << 8;
				var5 += (var2.field2361[var1.field2429 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		signature = "(Lgq;B)I",
		garbageValue = "22"
	)
	int method3873(MusicPatchNode var1) {
		int var2 = this.field2398[var1.field2425];
		return var2 < 8192 ? var2 * var1.field2421 + 32 >> 6 : 16384 - ((128 - var1.field2421) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1715674660"
	)
	void method3945() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2411; var2 == this.trackLength; var3 = this.midiFile.method3987(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2407 || var2 == 0) {
							this.method3866();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method3869(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2411 = var3;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		signature = "(Lgq;I)Z",
		garbageValue = "-1707560993"
	)
	boolean method3880(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2428 >= 0) {
				var1.remove();
				if (var1.field2422 > 0 && var1 == this.field2385[var1.field2425][var1.field2422]) {
					this.field2385[var1.field2425][var1.field2422] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		signature = "(Lgq;[IIII)Z",
		garbageValue = "-1765185106"
	)
	boolean method3881(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2433 = PcmPlayer.PcmPlayer_sampleRate * 22050 / 100;
		if (var1.field2428 < 0 || var1.stream != null && !var1.stream.method2789()) {
			int var5 = var1.field2424;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2389[var1.field2425] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2424 = var5;
			}

			var1.stream.method2743(this.method3934(var1));
			MusicPatchNode2 var6 = var1.field2417;
			boolean var7 = false;
			++var1.field2426;
			var1.field2414 += var6.field2367;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2419 - 60 << 8) + (var1.field2423 * var1.field2424 >> 12));
			if (var6.field2371 > 0) {
				if (var6.field2365 > 0) {
					var1.field2420 = var1.field2420 * -308789248 + (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2365) + 0.5D) * -308789248;
				} else {
					var1.field2420 = var1.field2420 * -308789248 + -870318080;
				}
			}

			if (var6.field2364 != null) {
				if (var6.field2366 > 0) {
					var1.field2431 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2366 * var8) + 0.5D);
				} else {
					var1.field2431 += 128;
				}

				while (var1.field2427 * 4 < var6.field2364.length - 2 && var1.field2431 > (var6.field2364[var1.field2427 * 4 + 2] & 255) << 8) {
					var1.field2427 = var1.field2427 * 4 + 2;
				}

				if (var1.field2427 * 4 == var6.field2364.length - 2 && var6.field2364[var1.field2427 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2428 >= 0 && var6.field2361 != null && (this.field2386[var1.field2425] & 1) == 0 && (var1.field2422 < 0 || var1 != this.field2385[var1.field2425][var1.field2422])) {
				if (var6.field2363 > 0) {
					var1.field2428 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2363 * var8) + 0.5D);
				} else {
					var1.field2428 += 128;
				}

				while (var1.field2429 * 4 < var6.field2361.length - 2 && var1.field2428 > (var6.field2361[var1.field2429 * 4 + 2] & 255) << 8) {
					var1.field2429 = var1.field2429 * 4 + 2;
				}

				if (var1.field2429 * 4 == var6.field2361.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method2722(var1.field2433);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method2716()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method3974();
				if (var1.field2428 >= 0) {
					var1.remove();
					if (var1.field2422 > 0 && var1 == this.field2385[var1.field2425][var1.field2422]) {
						this.field2385[var1.field2425][var1.field2422] = null;
					}
				}

				return true;
			} else {
				var1.stream.method2711(var1.field2433, this.method3875(var1), this.method3873(var1));
				return false;
			}
		} else {
			var1.method3974();
			var1.remove();
			if (var1.field2422 > 0 && var1 == this.field2385[var1.field2425][var1.field2422]) {
				this.field2385[var1.field2425][var1.field2422] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("gk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-75"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			ScriptEvent.clientPreferences.roofsHidden = !ScriptEvent.clientPreferences.roofsHidden;
			HitSplatDefinition.savePreferences();
			if (ScriptEvent.clientPreferences.roofsHidden) {
				class30.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				class30.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			Client.displayFps = !Client.displayFps;
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				Login.worldMap.showCoord = !Login.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				Client.displayFps = true;
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				Client.displayFps = false;
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				AbstractWorldMapIcon.method652();
			}
		}

		PacketBufferNode var1 = SoundSystem.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(var0.length() + 1);
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var1);
	}
}
