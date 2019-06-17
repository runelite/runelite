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
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2095480747
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("o")
   @Export("__o")
   int[] __o;
   @ObfuscatedName("u")
   @Export("__u")
   int[] __u;
   @ObfuscatedName("g")
   @Export("__g")
   int[] __g;
   @ObfuscatedName("l")
   @Export("__l")
   int[] __l;
   @ObfuscatedName("e")
   @Export("__e")
   int[] __e;
   @ObfuscatedName("x")
   @Export("__x")
   int[] __x;
   @ObfuscatedName("d")
   @Export("__d")
   int[] __d;
   @ObfuscatedName("k")
   @Export("__k")
   int[] __k;
   @ObfuscatedName("n")
   @Export("surfaceOffsetY")
   int[] __n;
   @ObfuscatedName("y")
   @Export("__y")
   int[] __y;
   @ObfuscatedName("h")
   @Export("__h")
   int[] __h;
   @ObfuscatedName("b")
   @Export("__b")
   int[] __b;
   @ObfuscatedName("c")
   @Export("__c")
   int[] __c;
   @ObfuscatedName("r")
   @Export("__r")
   int[] __r;
   @ObfuscatedName("p")
   @Export("__p")
   int[] __p;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   @Export("__v")
   MusicPatchNode[][] __v;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   @Export("__ag")
   MusicPatchNode[][] __ag;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   @Export("midiFile")
   MidiFileReader midiFile;
   @ObfuscatedName("aj")
   @Export("__aj")
   boolean __aj;
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
   @Export("__ac")
   long __ac;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 3736036110499628937L
   )
   @Export("__ay")
   long __ay;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   @Export("patchStream")
   MusicPatchPcmStream patchStream;

   public MidiPcmStream() {
      this.__f = 256;
      this.__q = 1000000;
      this.__o = new int[16];
      this.__u = new int[16];
      this.__g = new int[16];
      this.__l = new int[16];
      this.__e = new int[16];
      this.__x = new int[16];
      this.__d = new int[16];
      this.__k = new int[16];
      this.__n = new int[16];
      this.__y = new int[16];
      this.__h = new int[16];
      this.__b = new int[16];
      this.__c = new int[16];
      this.__r = new int[16];
      this.__p = new int[16];
      this.__v = new MusicPatchNode[16][128];
      this.__ag = new MusicPatchNode[16][128];
      this.midiFile = new MidiFileReader();
      this.patchStream = new MusicPatchPcmStream(this);
      this.musicPatches = new NodeHashTable(128);
      this.__at_354();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "92"
   )
   @Export("__m_340")
   public synchronized void __m_340(int var1) {
      this.__f = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2067929289"
   )
   @Export("__f_341")
   public int __f_341() {
      return this.__f;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhe;Lir;Ldt;II)Z",
      garbageValue = "-324121369"
   )
   @Export("loadMusicTrack")
   public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractIndexCache var2, SoundCache var3, int var4) {
      var1.__f_381();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
         if(var9 == null) {
            var9 = Login.method2045(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var9, (long)var8);
         }

         if(!var9.__f_373(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.clear();
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
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
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
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Ldc;"
   )
   protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("l")
   protected synchronized int __l_171() {
      return 0;
   }

   @ObfuscatedName("e")
   protected synchronized void __e_172(int[] var1, int var2, int var3) {
      if(this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.__q / class309.PcmPlayer_sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.__ac;
            if(this.__ay - var5 >= 0L) {
               this.__ac = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.__ay - this.__ac) - 1L) / (long)var4);
            this.__ac += (long)var4 * (long)var7;
            this.patchStream.__e_172(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.__ai_367();
         } while(this.midiFile.isReady());
      }

      this.patchStream.__e_172(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhe;ZI)V",
      garbageValue = "-1859383102"
   )
   @Export("setMusicTrack")
   public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
      this.clear();
      this.midiFile.parse(var1.midi);
      this.__aj = var2;
      this.__ac = 0L;
      int var3 = this.midiFile.trackCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.__ay = this.midiFile.__a_372(this.trackLength);
   }

   @ObfuscatedName("d")
   protected synchronized void __d_173(int var1) {
      if(this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.__q / class309.PcmPlayer_sampleRate;

         do {
            long var3 = this.__ac + (long)var2 * (long)var1;
            if(this.__ay - var3 >= 0L) {
               this.__ac = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.__ay - this.__ac) - 1L) / (long)var2);
            this.__ac += (long)var5 * (long)var2;
            this.patchStream.__d_173(var5);
            var1 -= var5;
            this.__ai_367();
         } while(this.midiFile.isReady());
      }

      this.patchStream.__d_173(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1847546868"
   )
   @Export("clear")
   public synchronized void clear() {
      this.midiFile.clear();
      this.__at_354();
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
   @Export("__j_342")
   public synchronized void __j_342(int var1, int var2) {
      this.__s_343(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1475022240"
   )
   @Export("__s_343")
   void __s_343(int var1, int var2) {
      this.__l[var1] = var2;
      this.__x[var1] = var2 & -128;
      this.__t_344(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-213159072"
   )
   @Export("__t_344")
   void __t_344(int var1, int var2) {
      if(var2 != this.__e[var1]) {
         this.__e[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.__ag[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "15"
   )
   @Export("__y_345")
   void __y_345(int var1, int var2, int var3) {
      this.__b_347(var1, var2, 64);
      if((this.__y[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if(var4.__m == var1 && var4.__a < 0) {
               this.__v[var1][var4.__u] = null;
               this.__v[var1][var2] = var4;
               int var5 = (var4.__d * var4.__x >> 12) + var4.__e;
               var4.__e += var2 - var4.__u << 8;
               var4.__x = var5 - var4.__e;
               var4.__d = 4096;
               var4.__u = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.__e[var1]);
      if(var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if(var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.__m = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.__w = var9.__u[var2];
            var6.__o = var9.__g[var2];
            var6.__u = var2;
            var6.__g = var3 * var3 * var9.__w[var2] * var9.__m + 1024 >> 11;
            var6.__l = var9.__o[var2] & 255;
            var6.__e = (var2 << 8) - (var9.__q[var2] & 32767);
            var6.__k = 0;
            var6.__o = 0;
            var6.__i = 0;
            var6.__a = -1;
            var6.__z = 0;
            if(this.__c[var1] == 0) {
               var6.stream = RawPcmStream.method2524(var8, this.__aa_359(var6), this.__ax_360(var6), this.__af_361(var6));
            } else {
               var6.stream = RawPcmStream.method2524(var8, this.__aa_359(var6), 0, this.__af_361(var6));
               this.__h_346(var6, var9.__q[var2] < 0);
            }

            if(var9.__q[var2] < 0) {
               var6.stream.__x_181(-1);
            }

            if(var6.__o >= 0) {
               MusicPatchNode var7 = this.__ag[var1][var6.__o];
               if(var7 != null && var7.__a < 0) {
                  this.__v[var1][var7.__u] = null;
                  var7.__a = 0;
               }

               this.__ag[var1][var6.__o] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.__v[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lha;ZI)V",
      garbageValue = "-1455849160"
   )
   @Export("__h_346")
   void __h_346(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if(var2 && var1.rawSound.__o) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)var5 * (long)this.__c[var1.__m] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.__h_188();
         }
      } else {
         var4 = (int)((long)this.__c[var1.__m] * (long)var3 >> 6);
      }

      var1.stream.__y_187(var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1244653525"
   )
   @Export("__b_347")
   void __b_347(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.__v[var1][var2];
      if(var4 != null) {
         this.__v[var1][var2] = null;
         if((this.__y[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if(var5.__m == var4.__m && var5.__a < 0 && var5 != var4) {
                  var4.__a = 0;
                  break;
               }
            }
         } else {
            var4.__a = 0;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1055105177"
   )
   @Export("__c_348")
   void __c_348(int var1, int var2, int var3) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-43"
   )
   @Export("__p_349")
   void __p_349(int var1, int var2) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   @Export("__v_350")
   void __v_350(int var1, int var2) {
      this.__d[var1] = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "137929054"
   )
   @Export("__ah_351")
   void __ah_351(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if(var1 < 0 || var2.__m == var1) {
            if(var2.stream != null) {
               var2.stream.__v_192(class309.PcmPlayer_sampleRate / 100);
               if(var2.stream.__at_196()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.__m_370();
            }

            if(var2.__a < 0) {
               this.__v[var2.__m][var2.__u] = null;
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
   @Export("__ab_352")
   void __ab_352(int var1) {
      if(var1 >= 0) {
         this.__o[var1] = 12800;
         this.__u[var1] = 8192;
         this.__g[var1] = 16383;
         this.__d[var1] = 8192;
         this.__k[var1] = 0;
         this.__n[var1] = 8192;
         this.__ad_355(var1);
         this.__ap_356(var1);
         this.__y[var1] = 0;
         this.__h[var1] = 32767;
         this.__b[var1] = 256;
         this.__c[var1] = 0;
         this.__ao_358(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.__ab_352(var1);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1458917637"
   )
   @Export("__ae_353")
   void __ae_353(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if((var1 < 0 || var2.__m == var1) && var2.__a < 0) {
            this.__v[var2.__m][var2.__u] = null;
            var2.__a = 0;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "808372536"
   )
   @Export("__at_354")
   void __at_354() {
      this.__ah_351(-1);
      this.__ab_352(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.__e[var1] = this.__l[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.__x[var1] = this.__l[var1] & -128;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1934460661"
   )
   @Export("__ad_355")
   void __ad_355(int var1) {
      if((this.__y[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if(var2.__m == var1 && this.__v[var1][var2.__u] == null && var2.__a < 0) {
               var2.__a = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1305073262"
   )
   @Export("__ap_356")
   void __ap_356(int var1) {
      if((this.__y[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if(var2.__m == var1) {
               var2.__b = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1168111396"
   )
   @Export("__au_357")
   void __au_357(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.__b_347(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.__y_345(var3, var4, var5);
         } else {
            this.__b_347(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.__c_348(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.__x[var3] = (var5 << 14) + (this.__x[var3] & -2080769);
         }

         if(var4 == 32) {
            this.__x[var3] = (var5 << 7) + (this.__x[var3] & -16257);
         }

         if(var4 == 1) {
            this.__k[var3] = (var5 << 7) + (this.__k[var3] & -16257);
         }

         if(var4 == 33) {
            this.__k[var3] = var5 + (this.__k[var3] & -128);
         }

         if(var4 == 5) {
            this.__n[var3] = (var5 << 7) + (this.__n[var3] & -16257);
         }

         if(var4 == 37) {
            this.__n[var3] = var5 + (this.__n[var3] & -128);
         }

         if(var4 == 7) {
            this.__o[var3] = (var5 << 7) + (this.__o[var3] & -16257);
         }

         if(var4 == 39) {
            this.__o[var3] = var5 + (this.__o[var3] & -128);
         }

         if(var4 == 10) {
            this.__u[var3] = (var5 << 7) + (this.__u[var3] & -16257);
         }

         if(var4 == 42) {
            this.__u[var3] = var5 + (this.__u[var3] & -128);
         }

         if(var4 == 11) {
            this.__g[var3] = (var5 << 7) + (this.__g[var3] & -16257);
         }

         if(var4 == 43) {
            this.__g[var3] = var5 + (this.__g[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.__y[var3] |= 1;
            } else {
               this.__y[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.__y[var3] |= 2;
            } else {
               this.__ad_355(var3);
               this.__y[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.__h[var3] = (var5 << 7) + (this.__h[var3] & 127);
         }

         if(var4 == 98) {
            this.__h[var3] = (this.__h[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.__h[var3] = (var5 << 7) + (this.__h[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.__h[var3] = (this.__h[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.__ah_351(var3);
         }

         if(var4 == 121) {
            this.__ab_352(var3);
         }

         if(var4 == 123) {
            this.__ae_353(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.__h[var3];
            if(var6 == 16384) {
               this.__b[var3] = (var5 << 7) + (this.__b[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.__h[var3];
            if(var6 == 16384) {
               this.__b[var3] = var5 + (this.__b[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.__c[var3] = (var5 << 7) + (this.__c[var3] & -16257);
         }

         if(var4 == 48) {
            this.__c[var3] = var5 + (this.__c[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.__y[var3] |= 4;
            } else {
               this.__ap_356(var3);
               this.__y[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.__ao_358(var3, (var5 << 7) + (this.__r[var3] & -16257));
         }

         if(var4 == 49) {
            this.__ao_358(var3, var5 + (this.__r[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.__t_344(var3, var4 + this.__x[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.__p_349(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.__v_350(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.__at_354();
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1380282032"
   )
   @Export("__ao_358")
   void __ao_358(int var1, int var2) {
      this.__r[var1] = var2;
      this.__p[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "-1821299983"
   )
   @Export("__aa_359")
   int __aa_359(MusicPatchNode var1) {
      int var2 = (var1.__d * var1.__x >> 12) + var1.__e;
      var2 += (this.__d[var1.__m] - 8192) * this.__b[var1.__m] >> 12;
      MusicPatchNode2 var3 = var1.__w;
      int var4;
      if(var3.__l > 0 && (var3.__g > 0 || this.__k[var1.__m] > 0)) {
         var4 = var3.__g << 2;
         int var5 = var3.__e << 1;
         if(var1.__j < var5) {
            var4 = var4 * var1.__j / var5;
         }

         var4 += this.__k[var1.__m] >> 7;
         double var6 = Math.sin((double)(var1.__s & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class309.PcmPlayer_sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "24812899"
   )
   @Export("__ax_360")
   int __ax_360(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.__w;
      int var3 = this.__o[var1.__m] * this.__g[var1.__m] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.__g + 16384 >> 15;
      var3 = var3 * this.__f + 128 >> 8;
      if(var2.__q > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.__q * (double)var1.__k * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.__m != null) {
         var4 = var1.__o;
         var5 = var2.__m[var1.__i + 1];
         if(var1.__i < var2.__m.length - 2) {
            var6 = (var2.__m[var1.__i] & 255) << 8;
            var7 = (var2.__m[var1.__i + 2] & 255) << 8;
            var5 += (var2.__m[var1.__i + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.__a > 0 && var2.__f != null) {
         var4 = var1.__a;
         var5 = var2.__f[var1.__z + 1];
         if(var1.__z < var2.__f.length - 2) {
            var6 = (var2.__f[var1.__z] & 255) << 8;
            var7 = (var2.__f[var1.__z + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.__f[var1.__z + 3] - var5) / (var7 - var6);
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
   @Export("__af_361")
   int __af_361(MusicPatchNode var1) {
      int var2 = this.__u[var1.__m];
      return var2 < 8192?var2 * var1.__l + 32 >> 6:16384 - ((128 - var1.__l) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   @Export("__ai_367")
   void __ai_367() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.__ay; var2 == this.trackLength; var3 = this.midiFile.__a_372(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if(var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if(this.midiFile.isDone()) {
                  if(!this.__aj || var2 == 0) {
                     this.__at_354();
                     this.midiFile.clear();
                     return;
                  }

                  this.midiFile.reset(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.__au_357(var5);
            }

            this.midiFile.readTrackLength(var1);
            this.midiFile.markTrackPosition(var1);
         }

         var1 = this.midiFile.getPrioritizedTrack();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.__ay = var3;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lha;I)Z",
      garbageValue = "1820762013"
   )
   @Export("__ba_368")
   boolean __ba_368(MusicPatchNode var1) {
      if(var1.stream == null) {
         if(var1.__a >= 0) {
            var1.remove();
            if(var1.__o > 0 && var1 == this.__ag[var1.__m][var1.__o]) {
               this.__ag[var1.__m][var1.__o] = null;
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
   @Export("__bb_369")
   boolean __bb_369(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.__y = class309.PcmPlayer_sampleRate / 100;
      if(var1.__a < 0 || var1.stream != null && !var1.stream.__ae_195()) {
         int var5 = var1.__d;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.__n[var1.__m] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.__d = var5;
         }

         var1.stream.__ah_193(this.__aa_359(var1));
         MusicPatchNode2 var6 = var1.__w;
         boolean var7 = false;
         ++var1.__j;
         var1.__s += var6.__l;
         double var8 = 5.086263020833333E-6D * (double)((var1.__u - 60 << 8) + (var1.__x * var1.__d >> 12));
         if(var6.__q > 0) {
            if(var6.__u > 0) {
               var1.__k += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.__u) + 0.5D);
            } else {
               var1.__k += 128;
            }
         }

         if(var6.__m != null) {
            if(var6.__w > 0) {
               var1.__o += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.__w) + 0.5D);
            } else {
               var1.__o += 128;
            }

            while(var1.__i < var6.__m.length - 2 && var1.__o > (var6.__m[var1.__i + 2] & 255) << 8) {
               var1.__i += 2;
            }

            if(var6.__m.length - 2 == var1.__i && var6.__m[var1.__i + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.__a >= 0 && var6.__f != null && (this.__y[var1.__m] & 1) == 0 && (var1.__o < 0 || var1 != this.__ag[var1.__m][var1.__o])) {
            if(var6.__o > 0) {
               var1.__a += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.__o) + 0.5D);
            } else {
               var1.__a += 128;
            }

            while(var1.__z < var6.__f.length - 2 && var1.__a > (var6.__f[var1.__z + 2] & 255) << 8) {
               var1.__z += 2;
            }

            if(var6.__f.length - 2 == var1.__z) {
               var7 = true;
            }
         }

         if(var7) {
            var1.stream.__v_192(var1.__y);
            if(var2 != null) {
               var1.stream.__e_172(var2, var3, var4);
            } else {
               var1.stream.__d_173(var4);
            }

            if(var1.stream.__at_196()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.__m_370();
            if(var1.__a >= 0) {
               var1.remove();
               if(var1.__o > 0 && var1 == this.__ag[var1.__m][var1.__o]) {
                  this.__ag[var1.__m][var1.__o] = null;
               }
            }

            return true;
         } else {
            var1.stream.__p_191(var1.__y, this.__ax_360(var1), this.__af_361(var1));
            return false;
         }
      } else {
         var1.__m_370();
         var1.remove();
         if(var1.__o > 0 && var1 == this.__ag[var1.__m][var1.__o]) {
            this.__ag[var1.__m][var1.__o] = null;
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
   static final void PcmStream_disable(PcmStream var0) {
      var0.active = false;
      if(var0.sound != null) {
         var0.sound.position = 0;
      }

      for(PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
         PcmStream_disable(var1);
      }

   }
}
