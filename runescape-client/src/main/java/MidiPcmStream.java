import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("musicPatches")
   NodeHashTable musicPatches;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 335918727
   )
   int field495;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2095480747
   )
   int field496;
   @ObfuscatedName("o")
   int[] field497;
   @ObfuscatedName("u")
   int[] field498;
   @ObfuscatedName("g")
   int[] field499;
   @ObfuscatedName("l")
   int[] field500;
   @ObfuscatedName("e")
   int[] field501;
   @ObfuscatedName("x")
   int[] field502;
   @ObfuscatedName("d")
   int[] field503;
   @ObfuscatedName("k")
   int[] field504;
   @ObfuscatedName("n")
   int[] field505;
   @ObfuscatedName("y")
   int[] field506;
   @ObfuscatedName("h")
   int[] field507;
   @ObfuscatedName("b")
   int[] field508;
   @ObfuscatedName("c")
   int[] field509;
   @ObfuscatedName("r")
   int[] field510;
   @ObfuscatedName("p")
   int[] field511;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   MusicPatchNode[][] field512;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   MusicPatchNode[][] field513;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("midiFile")
   MidiFileReader midiFile;
   @ObfuscatedName("aj")
   boolean field514;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1450922835
   )
   @Export("track")
   int track;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 713752539
   )
   @Export("trackLength")
   int trackLength;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = -7547625335559871937L
   )
   long field515;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 3736036110499628937L
   )
   long field516;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   @Export("patchStream")
   MusicPatchPcmStream patchStream;

   public MidiPcmStream() {
      this.field495 = 256;
      this.field496 = 1000000;
      this.field497 = new int[16];
      this.field498 = new int[16];
      this.field499 = new int[16];
      this.field500 = new int[16];
      this.field501 = new int[16];
      this.field502 = new int[16];
      this.field503 = new int[16];
      this.field504 = new int[16];
      this.field505 = new int[16];
      this.field506 = new int[16];
      this.field507 = new int[16];
      this.field508 = new int[16];
      this.field509 = new int[16];
      this.field510 = new int[16];
      this.field511 = new int[16];
      this.field512 = new MusicPatchNode[16][128];
      this.field513 = new MusicPatchNode[16][128];
      this.midiFile = new MidiFileReader();
      this.patchStream = new MusicPatchPcmStream(this);
      this.musicPatches = new NodeHashTable(128);
      this.method186();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "92"
   )
   public synchronized void method169(int var1) {
      this.field495 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2067929289"
   )
   public int method170() {
      return this.field495;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhe;Lir;Ldt;II)Z",
      garbageValue = "-324121369"
   )
   @Export("loadMusicTrack")
   public synchronized boolean loadMusicTrack(MusicTrack musicTrack, AbstractArchive var2, SoundCache var3, int frequency) {
      musicTrack.method226();
      boolean var5 = true;
      int[] var6 = null;
      if (frequency > 0) {
         var6 = new int[]{frequency};
      }

      for (ByteArrayNode var7 = (ByteArrayNode)musicTrack.table.first(); var7 != null; var7 = (ByteArrayNode)musicTrack.table.next()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
         if (var9 == null) {
            var9 = Login.method2045(var2, var8);
            if (var9 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var9, (long)var8);
         }

         if (!var9.method218(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         musicTrack.clear();
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-34"
   )
   @Export("clearAll")
   public synchronized void clearAll() {
      for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.clear();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "42"
   )
   @Export("removeAll")
   public synchronized void removeAll() {
      for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("firstSubStream")
   protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   @Export("nextSubStream")
   protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("l")
   protected synchronized int vmethod262() {
      return 0;
   }

   @ObfuscatedName("e")
   @Export("fill")
   protected synchronized void fill(int[] var1, int var2, int var3) {
      if (this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.field496 / class309.PcmPlayer_sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field515;
            if (this.field516 - var5 >= 0L) {
               this.field515 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field516 - this.field515) - 1L) / (long)var4);
            this.field515 += (long)var4 * (long)var7;
            this.patchStream.fill(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method194();
         } while(this.midiFile.isReady());
      }

      this.patchStream.fill(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhe;ZI)V",
      garbageValue = "-1859383102"
   )
   @Export("setMusicTrack")
   public synchronized void setMusicTrack(MusicTrack musicTrack, boolean var2) {
      this.clear();
      this.midiFile.parse(musicTrack.midi);
      this.field514 = var2;
      this.field515 = 0L;
      int var3 = this.midiFile.trackCount();

      for (int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field516 = this.midiFile.method168(this.trackLength);
   }

   @ObfuscatedName("d")
   @Export("skip")
   protected synchronized void skip(int var1) {
      if (this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.field496 / class309.PcmPlayer_sampleRate;

         do {
            long var3 = this.field515 + (long)var2 * (long)var1;
            if (this.field516 - var3 >= 0L) {
               this.field515 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field516 - this.field515) - 1L) / (long)var2);
            this.field515 += (long)var5 * (long)var2;
            this.patchStream.skip(var5);
            var1 -= var5;
            this.method194();
         } while(this.midiFile.isReady());
      }

      this.patchStream.skip(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1847546868"
   )
   @Export("clear")
   public synchronized void clear() {
      this.midiFile.clear();
      this.method186();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-852762450"
   )
   @Export("isReady")
   public synchronized boolean isReady() {
      return this.midiFile.isReady();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "789206119"
   )
   public synchronized void method174(int var1, int var2) {
      this.method175(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1475022240"
   )
   void method175(int var1, int var2) {
      this.field500[var1] = var2;
      this.field502[var1] = var2 & -128;
      this.method176(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-213159072"
   )
   void method176(int var1, int var2) {
      if (var2 != this.field501[var1]) {
         this.field501[var1] = var2;

         for (int var3 = 0; var3 < 128; ++var3) {
            this.field513[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "15"
   )
   void method177(int var1, int var2, int var3) {
      this.method179(var1, var2, 64);
      if ((this.field506[var1] & 2) != 0) {
         for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if (var4.field574 == var1 && var4.field586 < 0) {
               this.field512[var1][var4.field577] = null;
               this.field512[var1][var2] = var4;
               int var5 = (var4.field582 * var4.field581 >> 12) + var4.field580;
               var4.field580 += var2 - var4.field577 << 8;
               var4.field581 = var5 - var4.field580;
               var4.field582 = 4096;
               var4.field577 = var2;
               return;
            }
         }
      }

      MusicPatch var8 = (MusicPatch)this.musicPatches.get((long)this.field501[var1]);
      if (var8 != null) {
         RawSound var9 = var8.rawSounds[var2];
         if (var9 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field574 = var1;
            var6.patch = var8;
            var6.rawSound = var9;
            var6.field575 = var8.field571[var2];
            var6.field576 = var8.field572[var2];
            var6.field577 = var2;
            var6.field578 = var3 * var3 * var8.field569[var2] * var8.field567 + 1024 >> 11;
            var6.field579 = var8.field570[var2] & 255;
            var6.field580 = (var2 << 8) - (var8.field568[var2] & 32767);
            var6.field583 = 0;
            var6.field584 = 0;
            var6.field585 = 0;
            var6.field586 = -1;
            var6.field587 = 0;
            if (this.field509[var1] == 0) {
               var6.stream = RawPcmStream.method2524(var9, this.method191(var6), this.method192(var6), this.method193(var6));
            } else {
               var6.stream = RawPcmStream.method2524(var9, this.method191(var6), 0, this.method193(var6));
               this.method178(var6, var8.field568[var2] < 0);
            }

            if (var8.field568[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if (var6.field576 >= 0) {
               MusicPatchNode var7 = this.field513[var1][var6.field576];
               if (var7 != null && var7.field586 < 0) {
                  this.field512[var1][var7.field577] = null;
                  var7.field586 = 0;
               }

               this.field513[var1][var6.field576] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field512[var1][var2] = var6;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lha;ZI)V",
      garbageValue = "-1455849160"
   )
   void method178(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if (var2 && var1.rawSound.field756) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)var5 * (long)this.field509[var1.field574] >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method271();
         }
      } else {
         var4 = (int)((long)this.field509[var1.field574] * (long)var3 >> 6);
      }

      var1.stream.method270(var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1244653525"
   )
   void method179(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field512[var1][var2];
      if (var4 != null) {
         this.field512[var1][var2] = null;
         if ((this.field506[var1] & 2) != 0) {
            for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if (var5.field574 == var4.field574 && var5.field586 < 0 && var5 != var4) {
                  var4.field586 = 0;
                  break;
               }
            }
         } else {
            var4.field586 = 0;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1055105177"
   )
   void method180(int var1, int var2, int var3) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-43"
   )
   void method181(int var1, int var2) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   void method182(int var1, int var2) {
      this.field503[var1] = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "137929054"
   )
   void method183(int var1) {
      for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if (var1 < 0 || var2.field574 == var1) {
            if (var2.stream != null) {
               var2.stream.method275(class309.PcmPlayer_sampleRate / 100);
               if (var2.stream.method279()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method219();
            }

            if (var2.field586 < 0) {
               this.field512[var2.field574][var2.field577] = null;
            }

            var2.remove();
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-59494316"
   )
   void method184(int var1) {
      if (var1 >= 0) {
         this.field497[var1] = 12800;
         this.field498[var1] = 8192;
         this.field499[var1] = 16383;
         this.field503[var1] = 8192;
         this.field504[var1] = 0;
         this.field505[var1] = 8192;
         this.method187(var1);
         this.method188(var1);
         this.field506[var1] = 0;
         this.field507[var1] = 32767;
         this.field508[var1] = 256;
         this.field509[var1] = 0;
         this.method190(var1, 8192);
      } else {
         for (var1 = 0; var1 < 16; ++var1) {
            this.method184(var1);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1458917637"
   )
   void method185(int var1) {
      for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if ((var1 < 0 || var2.field574 == var1) && var2.field586 < 0) {
            this.field512[var2.field574][var2.field577] = null;
            var2.field586 = 0;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "808372536"
   )
   void method186() {
      this.method183(-1);
      this.method184(-1);

      int var1;
      for (var1 = 0; var1 < 16; ++var1) {
         this.field501[var1] = this.field500[var1];
      }

      for (var1 = 0; var1 < 16; ++var1) {
         this.field502[var1] = this.field500[var1] & -128;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1934460661"
   )
   void method187(int var1) {
      if ((this.field506[var1] & 2) != 0) {
         for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field574 == var1 && this.field512[var1][var2.field577] == null && var2.field586 < 0) {
               var2.field586 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1305073262"
   )
   void method188(int var1) {
      if ((this.field506[var1] & 4) != 0) {
         for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field574 == var1) {
               var2.field591 = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1168111396"
   )
   void method189(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if (var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method179(var3, var4, var5);
      } else if (var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var5 > 0) {
            this.method177(var3, var4, var5);
         } else {
            this.method179(var3, var4, 64);
         }
      } else if (var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method180(var3, var4, var5);
      } else if (var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var4 == 0) {
            this.field502[var3] = (var5 << 14) + (this.field502[var3] & -2080769);
         }

         if (var4 == 32) {
            this.field502[var3] = (var5 << 7) + (this.field502[var3] & -16257);
         }

         if (var4 == 1) {
            this.field504[var3] = (var5 << 7) + (this.field504[var3] & -16257);
         }

         if (var4 == 33) {
            this.field504[var3] = var5 + (this.field504[var3] & -128);
         }

         if (var4 == 5) {
            this.field505[var3] = (var5 << 7) + (this.field505[var3] & -16257);
         }

         if (var4 == 37) {
            this.field505[var3] = var5 + (this.field505[var3] & -128);
         }

         if (var4 == 7) {
            this.field497[var3] = (var5 << 7) + (this.field497[var3] & -16257);
         }

         if (var4 == 39) {
            this.field497[var3] = var5 + (this.field497[var3] & -128);
         }

         if (var4 == 10) {
            this.field498[var3] = (var5 << 7) + (this.field498[var3] & -16257);
         }

         if (var4 == 42) {
            this.field498[var3] = var5 + (this.field498[var3] & -128);
         }

         if (var4 == 11) {
            this.field499[var3] = (var5 << 7) + (this.field499[var3] & -16257);
         }

         if (var4 == 43) {
            this.field499[var3] = var5 + (this.field499[var3] & -128);
         }

         int[] var6;
         if (var4 == 64) {
            if (var5 >= 64) {
               var6 = this.field506;
               var6[var3] |= 1;
            } else {
               var6 = this.field506;
               var6[var3] &= -2;
            }
         }

         if (var4 == 65) {
            if (var5 >= 64) {
               var6 = this.field506;
               var6[var3] |= 2;
            } else {
               this.method187(var3);
               var6 = this.field506;
               var6[var3] &= -3;
            }
         }

         if (var4 == 99) {
            this.field507[var3] = (var5 << 7) + (this.field507[var3] & 127);
         }

         if (var4 == 98) {
            this.field507[var3] = (this.field507[var3] & 16256) + var5;
         }

         if (var4 == 101) {
            this.field507[var3] = (var5 << 7) + (this.field507[var3] & 127) + 16384;
         }

         if (var4 == 100) {
            this.field507[var3] = (this.field507[var3] & 16256) + var5 + 16384;
         }

         if (var4 == 120) {
            this.method183(var3);
         }

         if (var4 == 121) {
            this.method184(var3);
         }

         if (var4 == 123) {
            this.method185(var3);
         }

         int var7;
         if (var4 == 6) {
            var7 = this.field507[var3];
            if (var7 == 16384) {
               this.field508[var3] = (var5 << 7) + (this.field508[var3] & -16257);
            }
         }

         if (var4 == 38) {
            var7 = this.field507[var3];
            if (var7 == 16384) {
               this.field508[var3] = var5 + (this.field508[var3] & -128);
            }
         }

         if (var4 == 16) {
            this.field509[var3] = (var5 << 7) + (this.field509[var3] & -16257);
         }

         if (var4 == 48) {
            this.field509[var3] = var5 + (this.field509[var3] & -128);
         }

         if (var4 == 81) {
            if (var5 >= 64) {
               var6 = this.field506;
               var6[var3] |= 4;
            } else {
               this.method188(var3);
               var6 = this.field506;
               var6[var3] &= -5;
            }
         }

         if (var4 == 17) {
            this.method190(var3, (var5 << 7) + (this.field510[var3] & -16257));
         }

         if (var4 == 49) {
            this.method190(var3, var5 + (this.field510[var3] & -128));
         }
      } else if (var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method176(var3, var4 + this.field502[var3]);
      } else if (var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method181(var3, var4);
      } else if (var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method182(var3, var4);
      } else {
         var2 = var1 & 255;
         if (var2 == 255) {
            this.method186();
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1380282032"
   )
   void method190(int var1, int var2) {
      this.field510[var1] = var2;
      this.field511[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "-1821299983"
   )
   int method191(MusicPatchNode var1) {
      int var2 = (var1.field582 * var1.field581 >> 12) + var1.field580;
      var2 += (this.field503[var1.field574] - 8192) * this.field508[var1.field574] >> 12;
      MusicPatchNode2 var3 = var1.field575;
      int var4;
      if (var3.field600 > 0 && (var3.field599 > 0 || this.field504[var1.field574] > 0)) {
         var4 = var3.field599 << 2;
         int var5 = var3.field601 << 1;
         if (var1.field588 < var5) {
            var4 = var4 * var1.field588 / var5;
         }

         var4 += this.field504[var1.field574] >> 7;
         double var6 = Math.sin((double)(var1.field589 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class309.PcmPlayer_sampleRate + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "24812899"
   )
   int method192(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field575;
      int var3 = this.field497[var1.field574] * this.field499[var1.field574] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field578 + 16384 >> 15;
      var3 = var3 * this.field495 + 128 >> 8;
      if (var2.field595 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field595 * (double)var1.field583 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if (var2.field593 != null) {
         var4 = var1.field584;
         var5 = var2.field593[var1.field585 + 1];
         if (var1.field585 < var2.field593.length - 2) {
            var6 = (var2.field593[var1.field585] & 255) << 8;
            var7 = (var2.field593[var1.field585 + 2] & 255) << 8;
            var5 += (var2.field593[var1.field585 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if (var1.field586 > 0 && var2.field594 != null) {
         var4 = var1.field586;
         var5 = var2.field594[var1.field587 + 1];
         if (var1.field587 < var2.field594.length - 2) {
            var6 = (var2.field594[var1.field587] & 255) << 8;
            var7 = (var2.field594[var1.field587 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field594[var1.field587 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "360643400"
   )
   int method193(MusicPatchNode var1) {
      int var2 = this.field498[var1.field574];
      return var2 < 8192 ? var2 * var1.field579 + 32 >> 6 : 16384 - ((128 - var1.field579) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   void method194() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for (var3 = this.field516; var2 == this.trackLength; var3 = this.midiFile.method168(var2)) {
         while (var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if (var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if (this.midiFile.isDone()) {
                  if (!this.field514 || var2 == 0) {
                     this.method186();
                     this.midiFile.clear();
                     return;
                  }

                  this.midiFile.reset(var3);
               }
               break;
            }

            if ((var5 & 128) != 0) {
               this.method189(var5);
            }

            this.midiFile.readTrackLength(var1);
            this.midiFile.markTrackPosition(var1);
         }

         var1 = this.midiFile.getPrioritizedTrack();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.field516 = var3;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lha;I)Z",
      garbageValue = "1820762013"
   )
   boolean method195(MusicPatchNode var1) {
      if (var1.stream == null) {
         if (var1.field586 >= 0) {
            var1.remove();
            if (var1.field576 > 0 && var1 == this.field513[var1.field574][var1.field576]) {
               this.field513[var1.field574][var1.field576] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lha;[IIII)Z",
      garbageValue = "-1605961549"
   )
   boolean method196(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field590 = class309.PcmPlayer_sampleRate / 100;
      if (var1.field586 < 0 || var1.stream != null && !var1.stream.method278()) {
         int var5 = var1.field582;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field505[var1.field574] * 4.921259842519685E-4D) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.field582 = var5;
         }

         var1.stream.method276(this.method191(var1));
         MusicPatchNode2 var6 = var1.field575;
         boolean var7 = false;
         ++var1.field588;
         var1.field589 += var6.field600;
         double var8 = 5.086263020833333E-6D * (double)((var1.field577 - 60 << 8) + (var1.field581 * var1.field582 >> 12));
         if (var6.field595 > 0) {
            if (var6.field598 > 0) {
               var1.field583 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field598) + 0.5D);
            } else {
               var1.field583 += 128;
            }
         }

         if (var6.field593 != null) {
            if (var6.field596 > 0) {
               var1.field584 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field596) + 0.5D);
            } else {
               var1.field584 += 128;
            }

            while (var1.field585 < var6.field593.length - 2 && var1.field584 > (var6.field593[var1.field585 + 2] & 255) << 8) {
               var1.field585 += 2;
            }

            if (var6.field593.length - 2 == var1.field585 && var6.field593[var1.field585 + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.field586 >= 0 && var6.field594 != null && (this.field506[var1.field574] & 1) == 0 && (var1.field576 < 0 || var1 != this.field513[var1.field574][var1.field576])) {
            if (var6.field597 > 0) {
               var1.field586 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field597) + 0.5D);
            } else {
               var1.field586 += 128;
            }

            while (var1.field587 < var6.field594.length - 2 && var1.field586 > (var6.field594[var1.field587 + 2] & 255) << 8) {
               var1.field587 += 2;
            }

            if (var6.field594.length - 2 == var1.field587) {
               var7 = true;
            }
         }

         if (var7) {
            var1.stream.method275(var1.field590);
            if (var2 != null) {
               var1.stream.fill(var2, var3, var4);
            } else {
               var1.stream.skip(var4);
            }

            if (var1.stream.method279()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method219();
            if (var1.field586 >= 0) {
               var1.remove();
               if (var1.field576 > 0 && var1 == this.field513[var1.field574][var1.field576]) {
                  this.field513[var1.field574][var1.field576] = null;
               }
            }

            return true;
         } else {
            var1.stream.method274(var1.field590, this.method192(var1), this.method193(var1));
            return false;
         }
      } else {
         var1.method219();
         var1.remove();
         if (var1.field576 > 0 && var1 == this.field513[var1.field574][var1.field576]) {
            this.field513[var1.field574][var1.field576] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Ldc;B)V",
      garbageValue = "30"
   )
   @Export("PcmStream_disable")
   static final void PcmStream_disable(PcmStream stream) {
      stream.active = false;
      if (stream.sound != null) {
         stream.sound.position = 0;
      }

      for (PcmStream var1 = stream.firstSubStream(); var1 != null; var1 = stream.nextSubStream()) {
         PcmStream_disable(var1);
      }

   }
}
