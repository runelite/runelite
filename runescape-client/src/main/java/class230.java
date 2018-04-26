import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class230 extends TaskDataNode {
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   HashTable field2723;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1796912099
   )
   int field2702;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -553442077
   )
   int field2727;
   @ObfuscatedName("z")
   int[] field2704;
   @ObfuscatedName("n")
   int[] field2724;
   @ObfuscatedName("l")
   int[] field2706;
   @ObfuscatedName("s")
   int[] field2713;
   @ObfuscatedName("y")
   int[] field2705;
   @ObfuscatedName("c")
   int[] field2709;
   @ObfuscatedName("h")
   int[] field2710;
   @ObfuscatedName("i")
   int[] field2717;
   @ObfuscatedName("o")
   int[] field2712;
   @ObfuscatedName("u")
   int[] field2711;
   @ObfuscatedName("k")
   int[] field2714;
   @ObfuscatedName("w")
   int[] field2715;
   @ObfuscatedName("m")
   int[] field2716;
   @ObfuscatedName("a")
   int[] field2707;
   @ObfuscatedName("x")
   int[] field2708;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   class231[][] field2719;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   class231[][] field2720;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   class232 field2721;
   @ObfuscatedName("aj")
   boolean field2701;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1442637851
   )
   int field2718;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -616118361
   )
   int field2722;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 8956324582249613093L
   )
   long field2725;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -7731774753571953735L
   )
   long field2726;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   class234 field2703;

   public class230() {
      this.field2702 = 256;
      this.field2727 = 1000000;
      this.field2704 = new int[16];
      this.field2724 = new int[16];
      this.field2706 = new int[16];
      this.field2713 = new int[16];
      this.field2705 = new int[16];
      this.field2709 = new int[16];
      this.field2710 = new int[16];
      this.field2717 = new int[16];
      this.field2712 = new int[16];
      this.field2711 = new int[16];
      this.field2714 = new int[16];
      this.field2715 = new int[16];
      this.field2716 = new int[16];
      this.field2707 = new int[16];
      this.field2708 = new int[16];
      this.field2719 = new class231[16][128];
      this.field2720 = new class231[16][128];
      this.field2721 = new class232();
      this.field2703 = new class234(this);
      this.field2723 = new HashTable(128);
      this.method4255();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-97"
   )
   synchronized void method4324(int var1) {
      this.field2702 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2127532519"
   )
   int method4236() {
      return this.field2702;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lif;Ljr;Ldc;IB)Z",
      garbageValue = "1"
   )
   synchronized boolean method4237(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4455();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2777.first(); var7 != null; var7 = (ByteArrayNode)var1.field2777.next()) {
         int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2723.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.takeRecordFlat(var8);
            class233 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class233(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2723.put(var10, (long)var8);
         }

         if(!var9.method4420(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4456();
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1000369068"
   )
   synchronized void method4350() {
      for(class233 var1 = (class233)this.field2723.first(); var1 != null; var1 = (class233)this.field2723.next()) {
         var1.method4415();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-159429388"
   )
   synchronized void method4239() {
      for(class233 var1 = (class233)this.field2723.first(); var1 != null; var1 = (class233)this.field2723.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected synchronized TaskDataNode vmethod4437() {
      return this.field2703;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected synchronized TaskDataNode vmethod4424() {
      return null;
   }

   @ObfuscatedName("y")
   protected synchronized int vmethod4425() {
      return 0;
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod4441(int[] var1, int var2, int var3) {
      if(this.field2721.method4363()) {
         int var4 = this.field2721.field2751 * this.field2727 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2725 + (long)var3 * (long)var4;
            if(this.field2726 - var5 >= 0L) {
               this.field2725 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2726 - this.field2725) - 1L) / (long)var4);
            this.field2725 += (long)var7 * (long)var4;
            this.field2703.vmethod4441(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4248();
         } while(this.field2721.method4363());
      }

      this.field2703.vmethod4441(var1, var2, var3);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lif;ZI)V",
      garbageValue = "-1535032315"
   )
   synchronized void method4240(Track1 var1, boolean var2) {
      this.method4241();
      this.field2721.method4361(var1.field2778);
      this.field2701 = var2;
      this.field2725 = 0L;
      int var3 = this.field2721.method4375();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2721.method4365(var4);
         this.field2721.method4367(var4);
         this.field2721.method4366(var4);
      }

      this.field2718 = this.field2721.method4373();
      this.field2722 = this.field2721.field2755[this.field2718];
      this.field2726 = this.field2721.method4371(this.field2722);
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod4426(int var1) {
      if(this.field2721.method4363()) {
         int var2 = this.field2721.field2751 * this.field2727 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2725;
            if(this.field2726 - var3 >= 0L) {
               this.field2725 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2726 - this.field2725) - 1L) / (long)var2);
            this.field2725 += (long)var2 * (long)var5;
            this.field2703.vmethod4426(var5);
            var1 -= var5;
            this.method4248();
         } while(this.field2721.method4363());
      }

      this.field2703.vmethod4426(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-209291212"
   )
   synchronized void method4241() {
      this.field2721.method4362();
      this.method4255();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-646729176"
   )
   public synchronized boolean method4242() {
      return this.field2721.method4363();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-107"
   )
   public synchronized void method4243(int var1, int var2) {
      this.method4244(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2114055983"
   )
   void method4244(int var1, int var2) {
      this.field2713[var1] = var2;
      this.field2709[var1] = var2 & -128;
      this.method4235(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1556650444"
   )
   void method4235(int var1, int var2) {
      if(var2 != this.field2705[var1]) {
         this.field2705[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2720[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   void method4246(int var1, int var2, int var3) {
      this.method4245(var1, var2, 64);
      if((this.field2711[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2703.field2774.getTail(); var4 != null; var4 = (class231)this.field2703.field2774.getPrevious()) {
            if(var4.field2735 == var1 && var4.field2741 < 0) {
               this.field2719[var1][var4.field2734] = null;
               this.field2719[var1][var2] = var4;
               int var5 = (var4.field2738 * var4.field2739 >> 12) + var4.field2737;
               var4.field2737 += var2 - var4.field2734 << 8;
               var4.field2738 = var5 - var4.field2737;
               var4.field2739 = 4096;
               var4.field2734 = var2;
               return;
            }
         }
      }

      class233 var9 = (class233)this.field2723.get((long)this.field2705[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2766[var2];
         if(var8 != null) {
            class231 var6 = new class231();
            var6.field2735 = var1;
            var6.field2730 = var9;
            var6.field2731 = var8;
            var6.field2732 = var9.field2770[var2];
            var6.field2733 = var9.field2767[var2];
            var6.field2734 = var2;
            var6.field2749 = var3 * var3 * var9.field2768[var2] * var9.field2773 + 1024 >> 11;
            var6.field2736 = var9.field2765[var2] & 255;
            var6.field2737 = (var2 << 8) - (var9.field2771[var2] & 32767);
            var6.field2740 = 0;
            var6.field2742 = 0;
            var6.field2745 = 0;
            var6.field2741 = -1;
            var6.field2744 = 0;
            if(this.field2716[var1] == 0) {
               var6.field2747 = class115.method2476(var8, this.method4283(var6), this.method4261(var6), this.method4262(var6));
            } else {
               var6.field2747 = class115.method2476(var8, this.method4283(var6), 0, this.method4262(var6));
               this.method4290(var6, var9.field2771[var2] < 0);
            }

            if(var9.field2771[var2] < 0) {
               var6.field2747.method2401(-1);
            }

            if(var6.field2733 >= 0) {
               class231 var7 = this.field2720[var1][var6.field2733];
               if(var7 != null && var7.field2741 < 0) {
                  this.field2719[var1][var7.field2734] = null;
                  var7.field2741 = 0;
               }

               this.field2720[var1][var6.field2733] = var6;
            }

            this.field2703.field2774.addFront(var6);
            this.field2719[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lha;ZI)V",
      garbageValue = "-2139104043"
   )
   void method4290(class231 var1, boolean var2) {
      int var3 = var1.field2731.audioBuffer.length;
      int var4;
      if(var2 && var1.field2731.field1522) {
         int var5 = var3 + var3 - var1.field2731.startPosition;
         var4 = (int)((long)var5 * (long)this.field2716[var1.field2735] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2747.method2502();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2716[var1.field2735] >> 6);
      }

      var1.field2747.method2407(var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "301470822"
   )
   void method4245(int var1, int var2, int var3) {
      class231 var4 = this.field2719[var1][var2];
      if(var4 != null) {
         this.field2719[var1][var2] = null;
         if((this.field2711[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2703.field2774.getFront(); var5 != null; var5 = (class231)this.field2703.field2774.getNext()) {
               if(var4.field2735 == var5.field2735 && var5.field2741 < 0 && var4 != var5) {
                  var4.field2741 = 0;
                  break;
               }
            }
         } else {
            var4.field2741 = 0;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "423660858"
   )
   void method4249(int var1, int var2, int var3) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1044864137"
   )
   void method4250(int var1, int var2) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1101878300"
   )
   void method4251(int var1, int var2) {
      this.field2710[var1] = var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1099783612"
   )
   void method4332(int var1) {
      for(class231 var2 = (class231)this.field2703.field2774.getFront(); var2 != null; var2 = (class231)this.field2703.field2774.getNext()) {
         if(var1 < 0 || var2.field2735 == var1) {
            if(var2.field2747 != null) {
               var2.field2747.method2412(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2747.method2423()) {
                  this.field2703.field2776.method2166(var2.field2747);
               }

               var2.method4357();
            }

            if(var2.field2741 < 0) {
               this.field2719[var2.field2735][var2.field2734] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "998104024"
   )
   void method4253(int var1) {
      if(var1 >= 0) {
         this.field2704[var1] = 12800;
         this.field2724[var1] = 8192;
         this.field2706[var1] = 16383;
         this.field2710[var1] = 8192;
         this.field2717[var1] = 0;
         this.field2712[var1] = 8192;
         this.method4315(var1);
         this.method4234(var1);
         this.field2711[var1] = 0;
         this.field2714[var1] = 32767;
         this.field2715[var1] = 256;
         this.field2716[var1] = 0;
         this.method4259(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4253(var1);
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-724970269"
   )
   void method4254(int var1) {
      for(class231 var2 = (class231)this.field2703.field2774.getFront(); var2 != null; var2 = (class231)this.field2703.field2774.getNext()) {
         if((var1 < 0 || var2.field2735 == var1) && var2.field2741 < 0) {
            this.field2719[var2.field2735][var2.field2734] = null;
            var2.field2741 = 0;
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1017466742"
   )
   void method4255() {
      this.method4332(-1);
      this.method4253(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2705[var1] = this.field2713[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2709[var1] = this.field2713[var1] & -128;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-36"
   )
   void method4315(int var1) {
      if((this.field2711[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2703.field2774.getFront(); var2 != null; var2 = (class231)this.field2703.field2774.getNext()) {
            if(var2.field2735 == var1 && this.field2719[var1][var2.field2734] == null && var2.field2741 < 0) {
               var2.field2741 = 0;
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "192381307"
   )
   void method4234(int var1) {
      if((this.field2711[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2703.field2774.getFront(); var2 != null; var2 = (class231)this.field2703.field2774.getNext()) {
            if(var2.field2735 == var1) {
               var2.field2743 = 0;
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "123"
   )
   void method4258(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4245(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4246(var3, var4, var5);
         } else {
            this.method4245(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4249(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2709[var3] = (var5 << 14) + (this.field2709[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2709[var3] = (var5 << 7) + (this.field2709[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2717[var3] = (var5 << 7) + (this.field2717[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2717[var3] = var5 + (this.field2717[var3] & -128);
         }

         if(var4 == 5) {
            this.field2712[var3] = (var5 << 7) + (this.field2712[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2712[var3] = var5 + (this.field2712[var3] & -128);
         }

         if(var4 == 7) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2704[var3] = var5 + (this.field2704[var3] & -128);
         }

         if(var4 == 10) {
            this.field2724[var3] = (var5 << 7) + (this.field2724[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2724[var3] = var5 + (this.field2724[var3] & -128);
         }

         if(var4 == 11) {
            this.field2706[var3] = (var5 << 7) + (this.field2706[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2706[var3] = var5 + (this.field2706[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2711[var3] |= 1;
            } else {
               this.field2711[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2711[var3] |= 2;
            } else {
               this.method4315(var3);
               this.field2711[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2714[var3] = (var5 << 7) + (this.field2714[var3] & 127);
         }

         if(var4 == 98) {
            this.field2714[var3] = (this.field2714[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2714[var3] = (var5 << 7) + (this.field2714[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2714[var3] = (this.field2714[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4332(var3);
         }

         if(var4 == 121) {
            this.method4253(var3);
         }

         if(var4 == 123) {
            this.method4254(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2714[var3];
            if(var6 == 16384) {
               this.field2715[var3] = (var5 << 7) + (this.field2715[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2714[var3];
            if(var6 == 16384) {
               this.field2715[var3] = var5 + (this.field2715[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2716[var3] = (var5 << 7) + (this.field2716[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2716[var3] = var5 + (this.field2716[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2711[var3] |= 4;
            } else {
               this.method4234(var3);
               this.field2711[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4259(var3, (var5 << 7) + (this.field2707[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4259(var3, var5 + (this.field2707[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4235(var3, var4 + this.field2709[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4250(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4251(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4255();
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-298261130"
   )
   void method4259(int var1, int var2) {
      this.field2707[var1] = var2;
      this.field2708[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lha;B)I",
      garbageValue = "14"
   )
   int method4283(class231 var1) {
      int var2 = (var1.field2738 * var1.field2739 >> 12) + var1.field2737;
      var2 += (this.field2710[var1.field2735] - 8192) * this.field2715[var1.field2735] >> 12;
      class228 var3 = var1.field2732;
      int var4;
      if(var3.field2689 > 0 && (var3.field2688 > 0 || this.field2717[var1.field2735] > 0)) {
         var4 = var3.field2688 << 2;
         int var5 = var3.field2686 << 1;
         if(var1.field2729 < var5) {
            var4 = var4 * var1.field2729 / var5;
         }

         var4 += this.field2717[var1.field2735] >> 7;
         double var6 = Math.sin((double)(var1.field2746 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2731.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "-559834309"
   )
   int method4261(class231 var1) {
      class228 var2 = var1.field2732;
      int var3 = this.field2704[var1.field2735] * this.field2706[var1.field2735] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2749 + 16384 >> 15;
      var3 = var3 * this.field2702 + 128 >> 8;
      if(var2.field2687 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2687 * 1.953125E-5D * (double)var1.field2740) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2690 != null) {
         var4 = var1.field2742;
         var5 = var2.field2690[var1.field2745 + 1];
         if(var1.field2745 < var2.field2690.length - 2) {
            var6 = (var2.field2690[var1.field2745] & 255) << 8;
            var7 = (var2.field2690[var1.field2745 + 2] & 255) << 8;
            var5 += (var2.field2690[var1.field2745 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2741 > 0 && var2.field2683 != null) {
         var4 = var1.field2741;
         var5 = var2.field2683[var1.field2744 + 1];
         if(var1.field2744 < var2.field2683.length - 2) {
            var6 = (var2.field2683[var1.field2744] & 255) << 8;
            var7 = (var2.field2683[var1.field2744 + 2] & 255) << 8;
            var5 += (var2.field2683[var1.field2744 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "-1902509363"
   )
   int method4262(class231 var1) {
      int var2 = this.field2724[var1.field2735];
      return var2 < 8192?var2 * var1.field2736 + 32 >> 6:16384 - ((128 - var1.field2736) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-324850455"
   )
   void method4248() {
      int var1 = this.field2718;
      int var2 = this.field2722;

      long var3;
      for(var3 = this.field2726; var2 == this.field2722; var3 = this.field2721.method4371(var2)) {
         while(var2 == this.field2721.field2755[var1]) {
            this.field2721.method4365(var1);
            int var5 = this.field2721.method4368(var1);
            if(var5 == 1) {
               this.field2721.method4386();
               this.field2721.method4366(var1);
               if(this.field2721.method4411()) {
                  if(!this.field2701 || var2 == 0) {
                     this.method4255();
                     this.field2721.method4362();
                     return;
                  }

                  this.field2721.method4374(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4258(var5);
            }

            this.field2721.method4367(var1);
            this.field2721.method4366(var1);
         }

         var1 = this.field2721.method4373();
         var2 = this.field2721.field2755[var1];
      }

      this.field2718 = var1;
      this.field2722 = var2;
      this.field2726 = var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lha;B)Z",
      garbageValue = "0"
   )
   boolean method4269(class231 var1) {
      if(var1.field2747 == null) {
         if(var1.field2741 >= 0) {
            var1.unlink();
            if(var1.field2733 > 0 && var1 == this.field2720[var1.field2735][var1.field2733]) {
               this.field2720[var1.field2735][var1.field2733] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(Lha;[IIIS)Z",
      garbageValue = "-15889"
   )
   boolean method4330(class231 var1, int[] var2, int var3, int var4) {
      var1.field2748 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2741 < 0 || var1.field2747 != null && !var1.field2747.method2415()) {
         int var5 = var1.field2739;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2712[var1.field2735]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2739 = var5;
         }

         var1.field2747.method2413(this.method4283(var1));
         class228 var6 = var1.field2732;
         boolean var7 = false;
         ++var1.field2729;
         var1.field2746 += var6.field2689;
         double var8 = (double)((var1.field2734 - 60 << 8) + (var1.field2738 * var1.field2739 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2687 > 0) {
            if(var6.field2682 > 0) {
               var1.field2740 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2682 * var8) + 0.5D);
            } else {
               var1.field2740 += 128;
            }
         }

         if(var6.field2690 != null) {
            if(var6.field2685 > 0) {
               var1.field2742 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2685) + 0.5D);
            } else {
               var1.field2742 += 128;
            }

            while(var1.field2745 < var6.field2690.length - 2 && var1.field2742 > (var6.field2690[var1.field2745 + 2] & 255) << 8) {
               var1.field2745 += 2;
            }

            if(var6.field2690.length - 2 == var1.field2745 && var6.field2690[var1.field2745 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2741 >= 0 && var6.field2683 != null && (this.field2711[var1.field2735] & 1) == 0 && (var1.field2733 < 0 || var1 != this.field2720[var1.field2735][var1.field2733])) {
            if(var6.field2692 > 0) {
               var1.field2741 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2692 * var8) + 0.5D);
            } else {
               var1.field2741 += 128;
            }

            while(var1.field2744 < var6.field2683.length - 2 && var1.field2741 > (var6.field2683[var1.field2744 + 2] & 255) << 8) {
               var1.field2744 += 2;
            }

            if(var6.field2683.length - 2 == var1.field2744) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2747.method2412(var1.field2748);
            if(var2 != null) {
               var1.field2747.vmethod4441(var2, var3, var4);
            } else {
               var1.field2747.vmethod4426(var4);
            }

            if(var1.field2747.method2423()) {
               this.field2703.field2776.method2166(var1.field2747);
            }

            var1.method4357();
            if(var1.field2741 >= 0) {
               var1.unlink();
               if(var1.field2733 > 0 && var1 == this.field2720[var1.field2735][var1.field2733]) {
                  this.field2720[var1.field2735][var1.field2733] = null;
               }
            }

            return true;
         } else {
            var1.field2747.method2536(var1.field2748, this.method4261(var1), this.method4262(var1));
            return false;
         }
      } else {
         var1.method4357();
         var1.unlink();
         if(var1.field2733 > 0 && var1 == this.field2720[var1.field2735][var1.field2733]) {
            this.field2720[var1.field2735][var1.field2733] = null;
         }

         return true;
      }
   }
}
