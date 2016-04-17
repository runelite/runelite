import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class184 extends class66 {
   @ObfuscatedName("b")
   int[] field2976 = new int[16];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2111696697
   )
   int field2977 = 256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -706826355
   )
   int field2978 = 1000000;
   @ObfuscatedName("ad")
   class187[][] field2979 = new class187[16][128];
   @ObfuscatedName("k")
   int[] field2980 = new int[16];
   @ObfuscatedName("r")
   int[] field2981 = new int[16];
   @ObfuscatedName("p")
   int[] field2982 = new int[16];
   @ObfuscatedName("l")
   int[] field2983 = new int[16];
   @ObfuscatedName("y")
   int[] field2984 = new int[16];
   @ObfuscatedName("h")
   int[] field2985 = new int[16];
   @ObfuscatedName("m")
   int[] field2986 = new int[16];
   @ObfuscatedName("ah")
   boolean field2987;
   @ObfuscatedName("z")
   int[] field2988 = new int[16];
   @ObfuscatedName("s")
   int[] field2989 = new int[16];
   @ObfuscatedName("q")
   int[] field2990 = new int[16];
   @ObfuscatedName("e")
   int[] field2991 = new int[16];
   @ObfuscatedName("a")
   class196 field2992 = new class196(128);
   @ObfuscatedName("o")
   int[] field2993 = new int[16];
   @ObfuscatedName("v")
   class187[][] field2994 = new class187[16][128];
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 578548977
   )
   int field2995;
   @ObfuscatedName("ar")
   class182 field2996 = new class182();
   @ObfuscatedName("x")
   int[] field2997 = new int[16];
   @ObfuscatedName("f")
   int[] field2998 = new int[16];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -676706497
   )
   int field2999;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -8800567682676779593L
   )
   long field3000;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -6296829734445759223L
   )
   long field3001;
   @ObfuscatedName("an")
   class186 field3002 = new class186(this);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "273754823"
   )
   void method3676(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-709571239"
   )
   public synchronized void method3677(int var1) {
      this.field2977 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method3681(int var1, int var2) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZS)V",
      garbageValue = "1333"
   )
   public synchronized void method3682(class180 var1, boolean var2) {
      this.method3683();
      this.field2996.method3607(var1.field2934);
      this.field2987 = var2;
      this.field3000 = 0L;
      int var3 = this.field2996.method3610();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2996.method3647(var4);
         this.field2996.method3614(var4);
         this.field2996.method3612(var4);
      }

      this.field2995 = this.field2996.method3619();
      this.field2999 = this.field2996.field2955[this.field2995];
      this.field3001 = this.field2996.method3611(this.field2999);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2064228704"
   )
   public synchronized void method3683() {
      this.field2996.method3613();
      this.method3697();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "9"
   )
   public synchronized void method3685(int var1, int var2) {
      this.method3686(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1069334115"
   )
   void method3686(int var1, int var2) {
      this.field2982[var1] = var2;
      this.field2986[var1] = var2 & -128;
      this.method3687(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1967535144"
   )
   void method3687(int var1, int var2) {
      if(var2 != this.field2990[var1]) {
         this.field2990[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2979[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2129284739"
   )
   void method3688(int var1, int var2, int var3) {
      this.method3788(var1, var2, 64);
      if(0 != (this.field2985[var1] & 2)) {
         for(class187 var4 = (class187)this.field3002.field3019.method3906(); var4 != null; var4 = (class187)this.field3002.field3019.method3919()) {
            if(var1 == var4.field3031 && var4.field3036 < 0) {
               this.field2994[var1][var4.field3039] = null;
               this.field2994[var1][var2] = var4;
               int var5 = (var4.field3022 * var4.field3028 >> 12) + var4.field3030;
               var4.field3030 += var2 - var4.field3039 << 8;
               var4.field3028 = var5 - var4.field3030;
               var4.field3022 = 4096;
               var4.field3039 = var2;
               return;
            }
         }
      }

      class181 var8 = (class181)this.field2992.method3868((long)this.field2990[var1]);
      if(var8 != null) {
         class62 var9 = var8.field2936[var2];
         if(var9 != null) {
            class187 var6 = new class187();
            var6.field3031 = var1;
            var6.field3023 = var8;
            var6.field3032 = var9;
            var6.field3034 = var8.field2937[var2];
            var6.field3026 = var8.field2941[var2];
            var6.field3039 = var2;
            var6.field3024 = var8.field2940 * var3 * var3 * var8.field2938[var2] + 1024 >> 11;
            var6.field3027 = var8.field2939[var2] & 255;
            var6.field3030 = (var2 << 8) - (var8.field2944[var2] & 32767);
            var6.field3033 = 0;
            var6.field3029 = 0;
            var6.field3035 = 0;
            var6.field3036 = -1;
            var6.field3037 = 0;
            if(0 == this.field2976[var1]) {
               var6.field3040 = class64.method1397(var9, this.method3698(var6), this.method3778(var6), this.method3702(var6));
            } else {
               var6.field3040 = class64.method1397(var9, this.method3698(var6), 0, this.method3702(var6));
               this.method3689(var6, var8.field2944[var2] < 0);
            }

            if(var8.field2944[var2] < 0) {
               var6.field3040.method1399(-1);
            }

            if(var6.field3026 >= 0) {
               class187 var7 = this.field2979[var1][var6.field3026];
               if(var7 != null && var7.field3036 < 0) {
                  this.field2994[var1][var7.field3039] = null;
                  var7.field3036 = 0;
               }

               this.field2979[var1][var6.field3026] = var6;
            }

            this.field3002.field3019.method3900(var6);
            this.field2994[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZI)V",
      garbageValue = "1"
   )
   void method3689(class187 var1, boolean var2) {
      int var3 = var1.field3032.field1239.length;
      int var4;
      if(var1.field3032.field1238) {
         int var5 = var3 + var3 - var1.field3032.field1240;
         var4 = (int)((long)var5 * (long)this.field2976[var1.field3031] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3040.method1481();
         }
      } else {
         var4 = (int)((long)this.field2976[var1.field3031] * (long)var3 >> 6);
      }

      var1.field3040.method1405(var4);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-767448161"
   )
   void method3693(int var1, int var2) {
      this.field2991[var1] = var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1666145506"
   )
   void method3694(int var1) {
      for(class187 var2 = (class187)this.field3002.field3019.method3926(); var2 != null; var2 = (class187)this.field3002.field3019.method3902()) {
         if(var1 < 0 || var1 == var2.field3031) {
            if(var2.field3040 != null) {
               var2.field3040.method1410(class40.field973 / 100);
               if(var2.field3040.method1451()) {
                  this.field3002.field3021.method1253(var2.field3040);
               }

               var2.method3826();
            }

            if(var2.field3036 < 0) {
               this.field2994[var2.field3031][var2.field3039] = null;
            }

            var2.method3998();
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1951255431"
   )
   void method3696(int var1) {
      for(class187 var2 = (class187)this.field3002.field3019.method3926(); var2 != null; var2 = (class187)this.field3002.field3019.method3902()) {
         if((var1 < 0 || var1 == var2.field3031) && var2.field3036 < 0) {
            this.field2994[var2.field3031][var2.field3039] = null;
            var2.field3036 = 0;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1754396944"
   )
   void method3697() {
      this.method3694(-1);
      this.method3741(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2990[var1] = this.field2982[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2986[var1] = this.field2982[var1] & -128;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "-812550079"
   )
   int method3698(class187 var1) {
      int var2 = var1.field3030 + (var1.field3022 * var1.field3028 >> 12);
      var2 += (this.field2991[var1.field3031] - 8192) * this.field2998[var1.field3031] >> 12;
      class185 var3 = var1.field3034;
      int var4;
      if(var3.field3014 > 0 && (var3.field3011 > 0 || this.field2997[var1.field3031] > 0)) {
         var4 = var3.field3011 << 2;
         int var5 = var3.field3015 << 1;
         if(var1.field3038 < var5) {
            var4 = var1.field3038 * var4 / var5;
         }

         var4 += this.field2997[var1.field3031] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3025 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field3032.field1241 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class40.field973 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "99"
   )
   void method3699(int var1) {
      if(0 != (this.field2985[var1] & 4)) {
         for(class187 var2 = (class187)this.field3002.field3019.method3926(); var2 != null; var2 = (class187)this.field3002.field3019.method3902()) {
            if(var1 == var2.field3031) {
               var2.field3042 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "997424580"
   )
   void method3700(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(128 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3788(var3, var4, var5);
      } else if(144 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3688(var3, var4, var5);
         } else {
            this.method3788(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3676(var3, var4, var5);
      } else if(176 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(0 == var4) {
            this.field2986[var3] = (var5 << 14) + (this.field2986[var3] & -2080769);
         }

         if(32 == var4) {
            this.field2986[var3] = (var5 << 7) + (this.field2986[var3] & -16257);
         }

         if(1 == var4) {
            this.field2997[var3] = (var5 << 7) + (this.field2997[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2997[var3] = (this.field2997[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2988[var3] = (var5 << 7) + (this.field2988[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2988[var3] = var5 + (this.field2988[var3] & -128);
         }

         if(7 == var4) {
            this.field2984[var3] = (this.field2984[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2984[var3] = var5 + (this.field2984[var3] & -128);
         }

         if(10 == var4) {
            this.field2980[var3] = (var5 << 7) + (this.field2980[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2980[var3] = (this.field2980[var3] & -128) + var5;
         }

         if(11 == var4) {
            this.field2981[var3] = (this.field2981[var3] & -16257) + (var5 << 7);
         }

         if(43 == var4) {
            this.field2981[var3] = var5 + (this.field2981[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2985[var3] |= 1;
            } else {
               this.field2985[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2985[var3] |= 2;
            } else {
               this.method3766(var3);
               this.field2985[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2989[var3] = (var5 << 7) + (this.field2989[var3] & 127);
         }

         if(98 == var4) {
            this.field2989[var3] = var5 + (this.field2989[var3] & 16256);
         }

         if(101 == var4) {
            this.field2989[var3] = (var5 << 7) + 16384 + (this.field2989[var3] & 127);
         }

         if(100 == var4) {
            this.field2989[var3] = (this.field2989[var3] & 16256) + 16384 + var5;
         }

         if(120 == var4) {
            this.method3694(var3);
         }

         if(var4 == 121) {
            this.method3741(var3);
         }

         if(123 == var4) {
            this.method3696(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2989[var3];
            if(var6 == 16384) {
               this.field2998[var3] = (this.field2998[var3] & -16257) + (var5 << 7);
            }
         }

         if(38 == var4) {
            var6 = this.field2989[var3];
            if(var6 == 16384) {
               this.field2998[var3] = (this.field2998[var3] & -128) + var5;
            }
         }

         if(16 == var4) {
            this.field2976[var3] = (var5 << 7) + (this.field2976[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2976[var3] = (this.field2976[var3] & -128) + var5;
         }

         if(81 == var4) {
            if(var5 >= 64) {
               this.field2985[var3] |= 4;
            } else {
               this.method3699(var3);
               this.field2985[var3] &= -5;
            }
         }

         if(17 == var4) {
            this.method3701(var3, (this.field2983[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3701(var3, var5 + (this.field2983[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3687(var3, var4 + this.field2986[var3]);
      } else if(208 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3681(var3, var4);
      } else if(224 == var2) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3693(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3697();
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1758988456"
   )
   void method3701(int var1, int var2) {
      this.field2983[var1] = var2;
      this.field2993[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "-28"
   )
   int method3702(class187 var1) {
      int var2 = this.field2980[var1.field3031];
      return var2 < 8192?32 + var2 * var1.field3027 >> 6:16384 - ((128 - var1.field3027) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("k")
   protected synchronized class66 vmethod3806() {
      return this.field3002;
   }

   @ObfuscatedName("r")
   protected synchronized class66 vmethod3797() {
      return null;
   }

   @ObfuscatedName("p")
   protected synchronized int vmethod3810() {
      return 0;
   }

   @ObfuscatedName("e")
   protected synchronized void vmethod3800(int var1) {
      if(this.field2996.method3609()) {
         int var2 = this.field2978 * this.field2996.field2950 / class40.field973;

         do {
            long var3 = (long)var2 * (long)var1 + this.field3000;
            if(this.field3001 - var3 >= 0L) {
               this.field3000 = var3;
               break;
            }

            int var5 = (int)((this.field3001 - this.field3000 + (long)var2 - 1L) / (long)var2);
            this.field3000 += (long)var2 * (long)var5;
            this.field3002.vmethod3800(var5);
            var1 -= var5;
            this.method3712();
         } while(this.field2996.method3609());
      }

      this.field3002.vmethod3800(var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)Z",
      garbageValue = "1340109898"
   )
   boolean method3711(class187 var1) {
      if(null == var1.field3040) {
         if(var1.field3036 >= 0) {
            var1.method3998();
            if(var1.field3026 > 0 && var1 == this.field2979[var1.field3031][var1.field3026]) {
               this.field2979[var1.field3031][var1.field3026] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135820646"
   )
   void method3712() {
      int var1 = this.field2995;
      int var2 = this.field2999;

      long var3;
      for(var3 = this.field3001; this.field2999 == var2; var3 = this.field2996.method3611(var2)) {
         while(var2 == this.field2996.field2955[var1]) {
            this.field2996.method3647(var1);
            int var5 = this.field2996.method3643(var1);
            if(1 == var5) {
               this.field2996.method3617();
               this.field2996.method3612(var1);
               if(this.field2996.method3620()) {
                  if(!this.field2987 || 0 == var2) {
                     this.method3697();
                     this.field2996.method3613();
                     return;
                  }

                  this.field2996.method3649(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3700(var5);
            }

            this.field2996.method3614(var1);
            this.field2996.method3612(var1);
         }

         var1 = this.field2996.method3619();
         var2 = this.field2996.field2955[var1];
      }

      this.field2995 = var1;
      this.field2999 = var2;
      this.field3001 = var3;
   }

   @ObfuscatedName("q")
   protected synchronized void vmethod3796(int[] var1, int var2, int var3) {
      if(this.field2996.method3609()) {
         int var4 = this.field2996.field2950 * this.field2978 / class40.field973;

         do {
            long var5 = this.field3000 + (long)var4 * (long)var3;
            if(this.field3001 - var5 >= 0L) {
               this.field3000 = var5;
               break;
            }

            int var7 = (int)((this.field3001 - this.field3000 + (long)var4 - 1L) / (long)var4);
            this.field3000 += (long)var4 * (long)var7;
            this.field3002.vmethod3796(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3712();
         } while(this.field2996.method3609());
      }

      this.field3002.vmethod3796(var1, var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "22050"
   )
   public synchronized boolean method3715(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3592();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2933.method3871(); var7 != null; var7 = (class197)var1.field2933.method3867()) {
         int var8 = (int)var7.field3125;
         class181 var9 = (class181)this.field2992.method3868((long)var8);
         if(var9 == null) {
            var9 = class136.method3014(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2992.method3875(var9, (long)var8);
         }

         if(!var9.method3598(var3, var7.field3103, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3588();
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   public synchronized void method3719() {
      for(class181 var1 = (class181)this.field2992.method3871(); null != var1; var1 = (class181)this.field2992.method3867()) {
         var1.method3600();
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIB)V",
      garbageValue = "47"
   )
   static void method3725(class2 var0, int var1, int var2) {
      if(var0.field848 == var1 && -1 != var1) {
         int var3 = class96.method2279(var1).field1005;
         if(var3 == 1) {
            var0.field849 = 0;
            var0.field872 = 0;
            var0.field851 = var2;
            var0.field852 = 0;
         }

         if(var3 == 2) {
            var0.field852 = 0;
         }
      } else if(-1 == var1 || -1 == var0.field848 || class96.method2279(var1).field999 >= class96.method2279(var0.field848).field999) {
         var0.field848 = var1;
         var0.field849 = 0;
         var0.field872 = 0;
         var0.field851 = var2;
         var0.field852 = 0;
         var0.field875 = var0.field821;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-42"
   )
   synchronized boolean method3736() {
      return this.field2996.method3609();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "33"
   )
   void method3741(int var1) {
      if(var1 >= 0) {
         this.field2984[var1] = 12800;
         this.field2980[var1] = 8192;
         this.field2981[var1] = 16383;
         this.field2991[var1] = 8192;
         this.field2997[var1] = 0;
         this.field2988[var1] = 8192;
         this.method3766(var1);
         this.method3699(var1);
         this.field2985[var1] = 0;
         this.field2989[var1] = 32767;
         this.field2998[var1] = 256;
         this.field2976[var1] = 0;
         this.method3701(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3741(var1);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-3"
   )
   int method3744() {
      return this.field2977;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "384118087"
   )
   synchronized void method3747() {
      for(class181 var1 = (class181)this.field2992.method3871(); null != var1; var1 = (class181)this.field2992.method3867()) {
         var1.method3998();
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIS)Z",
      garbageValue = "12618"
   )
   boolean method3758(class187 var1, int[] var2, int var3, int var4) {
      var1.field3041 = class40.field973 / 100;
      if(var1.field3036 < 0 || null != var1.field3040 && !var1.field3040.method1440()) {
         int var5 = var1.field3022;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2988[var1.field3031] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3022 = var5;
         }

         var1.field3040.method1465(this.method3698(var1));
         class185 var6 = var1.field3034;
         boolean var7 = false;
         ++var1.field3038;
         var1.field3025 += var6.field3014;
         double var8 = (double)((var1.field3022 * var1.field3028 >> 12) + (var1.field3039 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field3009 > 0) {
            if(var6.field3012 > 0) {
               var1.field3033 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3012 * var8) + 0.5D);
            } else {
               var1.field3033 += 128;
            }
         }

         if(null != var6.field3007) {
            if(var6.field3008 > 0) {
               var1.field3029 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3008 * var8) + 0.5D);
            } else {
               var1.field3029 += 128;
            }

            while(var1.field3035 < var6.field3007.length - 2 && var1.field3029 > (var6.field3007[2 + var1.field3035] & 255) << 8) {
               var1.field3035 += 2;
            }

            if(var1.field3035 == var6.field3007.length - 2 && 0 == var6.field3007[var1.field3035 + 1]) {
               var7 = true;
            }
         }

         if(var1.field3036 >= 0 && var6.field3016 != null && (this.field2985[var1.field3031] & 1) == 0 && (var1.field3026 < 0 || var1 != this.field2979[var1.field3031][var1.field3026])) {
            if(var6.field3010 > 0) {
               var1.field3036 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3010) + 0.5D);
            } else {
               var1.field3036 += 128;
            }

            while(var1.field3037 < var6.field3016.length - 2 && var1.field3036 > (var6.field3016[2 + var1.field3037] & 255) << 8) {
               var1.field3037 += 2;
            }

            if(var6.field3016.length - 2 == var1.field3037) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3040.method1410(var1.field3041);
            if(null != var2) {
               var1.field3040.vmethod3796(var2, var3, var4);
            } else {
               var1.field3040.vmethod3800(var4);
            }

            if(var1.field3040.method1451()) {
               this.field3002.field3021.method1253(var1.field3040);
            }

            var1.method3826();
            if(var1.field3036 >= 0) {
               var1.method3998();
               if(var1.field3026 > 0 && var1 == this.field2979[var1.field3031][var1.field3026]) {
                  this.field2979[var1.field3031][var1.field3026] = null;
               }
            }

            return true;
         } else {
            var1.field3040.method1409(var1.field3041, this.method3778(var1), this.method3702(var1));
            return false;
         }
      } else {
         var1.method3826();
         var1.method3998();
         if(var1.field3026 > 0 && var1 == this.field2979[var1.field3031][var1.field3026]) {
            this.field2979[var1.field3031][var1.field3026] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2129091901"
   )
   void method3766(int var1) {
      if((this.field2985[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field3002.field3019.method3926(); var2 != null; var2 = (class187)this.field3002.field3019.method3902()) {
            if(var1 == var2.field3031 && this.field2994[var1][var2.field3039] == null && var2.field3036 < 0) {
               var2.field3036 = 0;
            }
         }
      }

   }

   public class184() {
      this.method3697();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "-46"
   )
   int method3778(class187 var1) {
      class185 var2 = var1.field3034;
      int var3 = this.field2984[var1.field3031] * this.field2981[var1.field3031] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field3024 * var3 + 16384 >> 15;
      var3 = var3 * this.field2977 + 128 >> 8;
      if(var2.field3009 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field3033 * (double)var2.field3009) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3007) {
         var4 = var1.field3029;
         var5 = var2.field3007[var1.field3035 + 1];
         if(var1.field3035 < var2.field3007.length - 2) {
            var6 = (var2.field3007[var1.field3035] & 255) << 8;
            var7 = (var2.field3007[2 + var1.field3035] & 255) << 8;
            var5 += (var2.field3007[3 + var1.field3035] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3036 > 0 && null != var2.field3016) {
         var4 = var1.field3036;
         var5 = var2.field3016[1 + var1.field3037];
         if(var1.field3037 < var2.field3016.length - 2) {
            var6 = (var2.field3016[var1.field3037] & 255) << 8;
            var7 = (var2.field3016[var1.field3037 + 2] & 255) << 8;
            var5 += (var2.field3016[var1.field3037 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-103"
   )
   void method3788(int var1, int var2, int var3) {
      class187 var4 = this.field2994[var1][var2];
      if(null != var4) {
         this.field2994[var1][var2] = null;
         if(0 != (this.field2985[var1] & 2)) {
            for(class187 var5 = (class187)this.field3002.field3019.method3926(); null != var5; var5 = (class187)this.field3002.field3019.method3902()) {
               if(var5.field3031 == var4.field3031 && var5.field3036 < 0 && var4 != var5) {
                  var4.field3036 = 0;
                  break;
               }
            }
         } else {
            var4.field3036 = 0;
         }

      }
   }
}
