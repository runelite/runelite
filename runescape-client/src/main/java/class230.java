import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class230 extends TaskDataNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   HashTable field2720;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 396720481
   )
   int field2695;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2043541165
   )
   int field2696;
   @ObfuscatedName("d")
   int[] field2697;
   @ObfuscatedName("h")
   int[] field2698;
   @ObfuscatedName("m")
   int[] field2699;
   @ObfuscatedName("z")
   int[] field2700;
   @ObfuscatedName("i")
   int[] field2701;
   @ObfuscatedName("u")
   int[] field2694;
   @ObfuscatedName("x")
   int[] field2703;
   @ObfuscatedName("y")
   int[] field2704;
   @ObfuscatedName("a")
   int[] field2702;
   @ObfuscatedName("j")
   int[] field2716;
   @ObfuscatedName("b")
   int[] field2708;
   @ObfuscatedName("g")
   int[] field2717;
   @ObfuscatedName("f")
   int[] field2709;
   @ObfuscatedName("p")
   int[] field2718;
   @ObfuscatedName("e")
   int[] field2711;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[[Lhn;"
   )
   class231[][] field2712;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[[Lhn;"
   )
   class231[][] field2713;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class232 field2706;
   @ObfuscatedName("ag")
   boolean field2715;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -82343675
   )
   int field2705;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1468374029
   )
   int field2707;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = 1938640762935090109L
   )
   long field2710;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = -5631686506953923457L
   )
   long field2719;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   class234 field2714;

   public class230() {
      this.field2695 = 256;
      this.field2696 = 1000000;
      this.field2697 = new int[16];
      this.field2698 = new int[16];
      this.field2699 = new int[16];
      this.field2700 = new int[16];
      this.field2701 = new int[16];
      this.field2694 = new int[16];
      this.field2703 = new int[16];
      this.field2704 = new int[16];
      this.field2702 = new int[16];
      this.field2716 = new int[16];
      this.field2708 = new int[16];
      this.field2717 = new int[16];
      this.field2709 = new int[16];
      this.field2718 = new int[16];
      this.field2711 = new int[16];
      this.field2712 = new class231[16][128];
      this.field2713 = new class231[16][128];
      this.field2706 = new class232();
      this.field2714 = new class234(this);
      this.field2720 = new HashTable(128);
      this.method4138();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-9"
   )
   public synchronized void method4134(int var1) {
      this.field2695 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-34"
   )
   public int method4250() {
      return this.field2695;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lie;Ljf;Lde;II)Z",
      garbageValue = "1891219158"
   )
   public synchronized boolean method4136(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4337();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2770.first(); var7 != null; var7 = (ByteArrayNode)var1.field2770.next()) {
         int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2720.get((long)var8);
         if(var9 == null) {
            var9 = WorldMapRegion.method536(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2720.put(var9, (long)var8);
         }

         if(!var9.method4307(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4338();
      }

      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424232485"
   )
   public synchronized void method4137() {
      for(class233 var1 = (class233)this.field2720.first(); var1 != null; var1 = (class233)this.field2720.next()) {
         var1.method4308();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "843414358"
   )
   public synchronized void method4141() {
      for(class233 var1 = (class233)this.field2720.first(); var1 != null; var1 = (class233)this.field2720.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized TaskDataNode vmethod4330() {
      return this.field2714;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized TaskDataNode vmethod4321() {
      return null;
   }

   @ObfuscatedName("i")
   protected synchronized int vmethod4314() {
      return 0;
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod4317(int[] var1, int var2, int var3) {
      if(this.field2706.method4269()) {
         int var4 = this.field2706.field2743 * this.field2696 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2710;
            if(this.field2719 - var5 >= 0L) {
               this.field2710 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2719 - this.field2710) - 1L) / (long)var4);
            this.field2710 += (long)var4 * (long)var7;
            this.field2714.vmethod4317(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4230();
         } while(this.field2706.method4269());
      }

      this.field2714.vmethod4317(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lie;ZB)V",
      garbageValue = "4"
   )
   public synchronized void method4139(Track1 var1, boolean var2) {
      this.method4140();
      this.field2706.method4298(var1.field2769);
      this.field2715 = var2;
      this.field2710 = 0L;
      int var3 = this.field2706.method4270();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2706.method4271(var4);
         this.field2706.method4274(var4);
         this.field2706.method4272(var4);
      }

      this.field2705 = this.field2706.method4279();
      this.field2707 = this.field2706.field2753[this.field2705];
      this.field2719 = this.field2706.method4296(this.field2707);
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod4319(int var1) {
      if(this.field2706.method4269()) {
         int var2 = this.field2706.field2743 * this.field2696 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2710 + (long)var1 * (long)var2;
            if(this.field2719 - var3 >= 0L) {
               this.field2710 = var3;
               break;
            }

            int var5 = (int)((this.field2719 - this.field2710 + (long)var2 - 1L) / (long)var2);
            this.field2710 += (long)var2 * (long)var5;
            this.field2714.vmethod4319(var5);
            var1 -= var5;
            this.method4230();
         } while(this.field2706.method4269());
      }

      this.field2714.vmethod4319(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public synchronized void method4140() {
      this.field2706.method4268();
      this.method4138();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "433251189"
   )
   public synchronized boolean method4151() {
      return this.field2706.method4269();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "54614212"
   )
   public synchronized void method4191(int var1, int var2) {
      this.method4241(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2037992674"
   )
   void method4241(int var1, int var2) {
      this.field2700[var1] = var2;
      this.field2694[var1] = var2 & -128;
      this.method4143(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1454798357"
   )
   void method4143(int var1, int var2) {
      if(var2 != this.field2701[var1]) {
         this.field2701[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2713[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-43"
   )
   void method4144(int var1, int var2, int var3) {
      this.method4153(var1, var2, 64);
      if((this.field2716[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2714.field2765.getTail(); var4 != null; var4 = (class231)this.field2714.field2765.getPrevious()) {
            if(var4.field2734 == var1 && var4.field2740 < 0) {
               this.field2712[var1][var4.field2726] = null;
               this.field2712[var1][var2] = var4;
               int var5 = (var4.field2721 * var4.field2730 >> 12) + var4.field2733;
               var4.field2733 += var2 - var4.field2726 << 8;
               var4.field2730 = var5 - var4.field2733;
               var4.field2721 = 4096;
               var4.field2726 = var2;
               return;
            }
         }
      }

      class233 var9 = (class233)this.field2720.get((long)this.field2701[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2757[var2];
         if(var8 != null) {
            class231 var6 = new class231();
            var6.field2734 = var1;
            var6.field2722 = var9;
            var6.field2729 = var8;
            var6.field2724 = var9.field2763[var2];
            var6.field2725 = var9.field2761[var2];
            var6.field2726 = var2;
            var6.field2727 = var3 * var3 * var9.field2756[var2] * var9.field2762 + 1024 >> 11;
            var6.field2728 = var9.field2760[var2] & 255;
            var6.field2733 = (var2 << 8) - (var9.field2759[var2] & 32767);
            var6.field2732 = 0;
            var6.field2731 = 0;
            var6.field2735 = 0;
            var6.field2740 = -1;
            var6.field2736 = 0;
            if(this.field2709[var1] == 0) {
               var6.field2739 = class115.method2318(var8, this.method4158(var6), this.method4159(var6), this.method4226(var6));
            } else {
               var6.field2739 = class115.method2318(var8, this.method4158(var6), 0, this.method4226(var6));
               this.method4145(var6, var9.field2759[var2] < 0);
            }

            if(var9.field2759[var2] < 0) {
               var6.field2739.method2320(-1);
            }

            if(var6.field2725 >= 0) {
               class231 var7 = this.field2713[var1][var6.field2725];
               if(var7 != null && var7.field2740 < 0) {
                  this.field2712[var1][var7.field2726] = null;
                  var7.field2740 = 0;
               }

               this.field2713[var1][var6.field2725] = var6;
            }

            this.field2714.field2765.addFront(var6);
            this.field2712[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhn;ZI)V",
      garbageValue = "702590662"
   )
   void method4145(class231 var1, boolean var2) {
      int var3 = var1.field2729.audioBuffer.length;
      int var4;
      if(var2 && var1.field2729.field1548) {
         int var5 = var3 + var3 - var1.field2729.startPosition;
         var4 = (int)((long)this.field2709[var1.field2734] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2739.method2327();
         }
      } else {
         var4 = (int)((long)this.field2709[var1.field2734] * (long)var3 >> 6);
      }

      var1.field2739.method2315(var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "72"
   )
   void method4153(int var1, int var2, int var3) {
      class231 var4 = this.field2712[var1][var2];
      if(var4 != null) {
         this.field2712[var1][var2] = null;
         if((this.field2716[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2714.field2765.getFront(); var5 != null; var5 = (class231)this.field2714.field2765.getNext()) {
               if(var5.field2734 == var4.field2734 && var5.field2740 < 0 && var5 != var4) {
                  var4.field2740 = 0;
                  break;
               }
            }
         } else {
            var4.field2740 = 0;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "7"
   )
   void method4147(int var1, int var2, int var3) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-105057059"
   )
   void method4238(int var1, int var2) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1482876214"
   )
   void method4149(int var1, int var2) {
      this.field2703[var1] = var2;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   void method4187(int var1) {
      for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
         if(var1 < 0 || var2.field2734 == var1) {
            if(var2.field2739 != null) {
               var2.field2739.method2363(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2739.method2335()) {
                  this.field2714.field2766.method2059(var2.field2739);
               }

               var2.method4262();
            }

            if(var2.field2740 < 0) {
               this.field2712[var2.field2734][var2.field2726] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-548489630"
   )
   void method4235(int var1) {
      if(var1 >= 0) {
         this.field2697[var1] = 12800;
         this.field2698[var1] = 8192;
         this.field2699[var1] = 16383;
         this.field2703[var1] = 8192;
         this.field2704[var1] = 0;
         this.field2702[var1] = 8192;
         this.method4154(var1);
         this.method4155(var1);
         this.field2716[var1] = 0;
         this.field2708[var1] = 32767;
         this.field2717[var1] = 256;
         this.field2709[var1] = 0;
         this.method4164(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4235(var1);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "64"
   )
   void method4152(int var1) {
      for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
         if((var1 < 0 || var2.field2734 == var1) && var2.field2740 < 0) {
            this.field2712[var2.field2734][var2.field2726] = null;
            var2.field2740 = 0;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "990212485"
   )
   void method4138() {
      this.method4187(-1);
      this.method4235(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2701[var1] = this.field2700[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2694[var1] = this.field2700[var1] & -128;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "5002"
   )
   void method4154(int var1) {
      if((this.field2716[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
            if(var2.field2734 == var1 && this.field2712[var1][var2.field2726] == null && var2.field2740 < 0) {
               var2.field2740 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-895931287"
   )
   void method4155(int var1) {
      if((this.field2716[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2714.field2765.getFront(); var2 != null; var2 = (class231)this.field2714.field2765.getNext()) {
            if(var2.field2734 == var1) {
               var2.field2741 = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-254656228"
   )
   void method4181(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4153(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4144(var3, var4, var5);
         } else {
            this.method4153(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4147(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2694[var3] = (var5 << 14) + (this.field2694[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2704[var3] = var5 + (this.field2704[var3] & -128);
         }

         if(var4 == 5) {
            this.field2702[var3] = (var5 << 7) + (this.field2702[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2702[var3] = var5 + (this.field2702[var3] & -128);
         }

         if(var4 == 7) {
            this.field2697[var3] = (var5 << 7) + (this.field2697[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2697[var3] = var5 + (this.field2697[var3] & -128);
         }

         if(var4 == 10) {
            this.field2698[var3] = (var5 << 7) + (this.field2698[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2698[var3] = var5 + (this.field2698[var3] & -128);
         }

         if(var4 == 11) {
            this.field2699[var3] = (var5 << 7) + (this.field2699[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2699[var3] = var5 + (this.field2699[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2716[var3] |= 1;
            } else {
               this.field2716[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2716[var3] |= 2;
            } else {
               this.method4154(var3);
               this.field2716[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2708[var3] = (var5 << 7) + (this.field2708[var3] & 127);
         }

         if(var4 == 98) {
            this.field2708[var3] = (this.field2708[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2708[var3] = (var5 << 7) + (this.field2708[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2708[var3] = (this.field2708[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4187(var3);
         }

         if(var4 == 121) {
            this.method4235(var3);
         }

         if(var4 == 123) {
            this.method4152(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2708[var3];
            if(var6 == 16384) {
               this.field2717[var3] = (var5 << 7) + (this.field2717[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2708[var3];
            if(var6 == 16384) {
               this.field2717[var3] = var5 + (this.field2717[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2709[var3] = (var5 << 7) + (this.field2709[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2709[var3] = var5 + (this.field2709[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2716[var3] |= 4;
            } else {
               this.method4155(var3);
               this.field2716[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4164(var3, (var5 << 7) + (this.field2718[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4164(var3, var5 + (this.field2718[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4143(var3, var4 + this.field2694[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4238(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4149(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4138();
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1116788229"
   )
   void method4164(int var1, int var2) {
      this.field2718[var1] = var2;
      this.field2711[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lhn;B)I",
      garbageValue = "-16"
   )
   int method4158(class231 var1) {
      int var2 = (var1.field2730 * var1.field2721 >> 12) + var1.field2733;
      var2 += (this.field2703[var1.field2734] - 8192) * this.field2717[var1.field2734] >> 12;
      class228 var3 = var1.field2724;
      int var4;
      if(var3.field2683 > 0 && (var3.field2682 > 0 || this.field2704[var1.field2734] > 0)) {
         var4 = var3.field2682 << 2;
         int var5 = var3.field2678 << 1;
         if(var1.field2737 < var5) {
            var4 = var4 * var1.field2737 / var5;
         }

         var4 += this.field2704[var1.field2734] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2738 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2729.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lhn;I)I",
      garbageValue = "-1590092827"
   )
   int method4159(class231 var1) {
      class228 var2 = var1.field2724;
      int var3 = this.field2697[var1.field2734] * this.field2699[var1.field2734] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2727 + 16384 >> 15;
      var3 = var3 * this.field2695 + 128 >> 8;
      if(var2.field2676 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2676 * 1.953125E-5D * (double)var1.field2732) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2680 != null) {
         var4 = var1.field2731;
         var5 = var2.field2680[var1.field2735 + 1];
         if(var1.field2735 < var2.field2680.length - 2) {
            var6 = (var2.field2680[var1.field2735] & 255) << 8;
            var7 = (var2.field2680[var1.field2735 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2680[var1.field2735 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2740 > 0 && var2.field2684 != null) {
         var4 = var1.field2740;
         var5 = var2.field2684[var1.field2736 + 1];
         if(var1.field2736 < var2.field2684.length - 2) {
            var6 = (var2.field2684[var1.field2736] & 255) << 8;
            var7 = (var2.field2684[var1.field2736 + 2] & 255) << 8;
            var5 += (var2.field2684[var1.field2736 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lhn;B)I",
      garbageValue = "22"
   )
   int method4226(class231 var1) {
      int var2 = this.field2698[var1.field2734];
      return var2 < 8192?var2 * var1.field2728 + 32 >> 6:16384 - ((128 - var1.field2728) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1603651630"
   )
   void method4230() {
      int var1 = this.field2705;
      int var2 = this.field2707;

      long var3;
      for(var3 = this.field2719; var2 == this.field2707; var3 = this.field2706.method4296(var2)) {
         while(var2 == this.field2706.field2753[var1]) {
            this.field2706.method4271(var1);
            int var5 = this.field2706.method4275(var1);
            if(var5 == 1) {
               this.field2706.method4273();
               this.field2706.method4272(var1);
               if(this.field2706.method4280()) {
                  if(!this.field2715 || var2 == 0) {
                     this.method4138();
                     this.field2706.method4268();
                     return;
                  }

                  this.field2706.method4285(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4181(var5);
            }

            this.field2706.method4274(var1);
            this.field2706.method4272(var1);
         }

         var1 = this.field2706.method4279();
         var2 = this.field2706.field2753[var1];
      }

      this.field2705 = var1;
      this.field2707 = var2;
      this.field2719 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lhn;I)Z",
      garbageValue = "-1605868033"
   )
   boolean method4167(class231 var1) {
      if(var1.field2739 == null) {
         if(var1.field2740 >= 0) {
            var1.unlink();
            if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
               this.field2713[var1.field2734][var1.field2725] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lhn;[IIIB)Z",
      garbageValue = "5"
   )
   boolean method4146(class231 var1, int[] var2, int var3, int var4) {
      var1.field2723 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2740 < 0 || var1.field2739 != null && !var1.field2739.method2399()) {
         int var5 = var1.field2721;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2702[var1.field2734]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2721 = var5;
         }

         var1.field2739.method2332(this.method4158(var1));
         class228 var6 = var1.field2724;
         boolean var7 = false;
         ++var1.field2737;
         var1.field2738 += var6.field2683;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2726 - 60 << 8) + (var1.field2721 * var1.field2730 >> 12));
         if(var6.field2676 > 0) {
            if(var6.field2681 > 0) {
               var1.field2732 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2681 * var8) + 0.5D);
            } else {
               var1.field2732 += 128;
            }
         }

         if(var6.field2680 != null) {
            if(var6.field2679 > 0) {
               var1.field2731 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2679) + 0.5D);
            } else {
               var1.field2731 += 128;
            }

            while(var1.field2735 < var6.field2680.length - 2 && var1.field2731 > (var6.field2680[var1.field2735 + 2] & 255) << 8) {
               var1.field2735 += 2;
            }

            if(var6.field2680.length - 2 == var1.field2735 && var6.field2680[var1.field2735 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2740 >= 0 && var6.field2684 != null && (this.field2716[var1.field2734] & 1) == 0 && (var1.field2725 < 0 || var1 != this.field2713[var1.field2734][var1.field2725])) {
            if(var6.field2677 > 0) {
               var1.field2740 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2677 * var8) + 0.5D);
            } else {
               var1.field2740 += 128;
            }

            while(var1.field2736 < var6.field2684.length - 2 && var1.field2740 > (var6.field2684[var1.field2736 + 2] & 255) << 8) {
               var1.field2736 += 2;
            }

            if(var6.field2684.length - 2 == var1.field2736) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2739.method2363(var1.field2723);
            if(var2 != null) {
               var1.field2739.vmethod4317(var2, var3, var4);
            } else {
               var1.field2739.vmethod4319(var4);
            }

            if(var1.field2739.method2335()) {
               this.field2714.field2766.method2059(var1.field2739);
            }

            var1.method4262();
            if(var1.field2740 >= 0) {
               var1.unlink();
               if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
                  this.field2713[var1.field2734][var1.field2725] = null;
               }
            }

            return true;
         } else {
            var1.field2739.method2330(var1.field2723, this.method4159(var1), this.method4226(var1));
            return false;
         }
      } else {
         var1.method4262();
         var1.unlink();
         if(var1.field2725 > 0 && var1 == this.field2713[var1.field2734][var1.field2725]) {
            this.field2713[var1.field2734][var1.field2725] = null;
         }

         return true;
      }
   }
}
