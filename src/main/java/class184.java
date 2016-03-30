import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class184 extends class66 {
   @ObfuscatedName("am")
   class182 field2974 = new class182();
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1733344401
   )
   int field2975 = 256;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 874735731
   )
   int field2976 = 1000000;
   @ObfuscatedName("e")
   int[] field2977 = new int[16];
   @ObfuscatedName("y")
   int[] field2978 = new int[16];
   @ObfuscatedName("m")
   int[] field2979 = new int[16];
   @ObfuscatedName("x")
   class196 field2980 = new class196(128);
   @ObfuscatedName("v")
   int[] field2981 = new int[16];
   @ObfuscatedName("l")
   int[] field2982 = new int[16];
   @ObfuscatedName("af")
   class187[][] field2983 = new class187[16][128];
   @ObfuscatedName("s")
   int[] field2984 = new int[16];
   @ObfuscatedName("j")
   int[] field2985 = new int[16];
   @ObfuscatedName("r")
   int[] field2986 = new int[16];
   @ObfuscatedName("k")
   int[] field2987 = new int[16];
   @ObfuscatedName("f")
   int[] field2988 = new int[16];
   @ObfuscatedName("ac")
   class186 field2989 = new class186(this);
   @ObfuscatedName("c")
   int[] field2990 = new int[16];
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = -2552606644712335125L
   )
   long field2991;
   @ObfuscatedName("b")
   class187[][] field2992 = new class187[16][128];
   @ObfuscatedName("ar")
   boolean field2993;
   @ObfuscatedName("g")
   int[] field2994 = new int[16];
   @ObfuscatedName("z")
   int[] field2995 = new int[16];
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 339339915
   )
   int field2996;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1402766965
   )
   int field2997;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = 5783868066395413231L
   )
   long field2998;
   @ObfuscatedName("n")
   int[] field2999 = new int[16];
   @ObfuscatedName("h")
   int[] field3000 = new int[16];
   @ObfuscatedName("me")
   static byte field3001;

   @ObfuscatedName("w")
   public synchronized void method3615(int var1) {
      this.field2975 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "77"
   )
   void method3616(int var1, int var2, int var3) {
      this.method3628(var1, var2);
      if(0 != (this.field3000[var1] & 2)) {
         for(class187 var4 = (class187)this.field2989.field3012.method3840(); null != var4; var4 = (class187)this.field2989.field3012.method3842()) {
            if(var4.field3026 == var1 && var4.field3020 < 0) {
               this.field2992[var1][var4.field3037] = null;
               this.field2992[var1][var2] = var4;
               int var5 = var4.field3019 + (var4.field3025 * var4.field3024 >> 12);
               var4.field3019 += var2 - var4.field3037 << 8;
               var4.field3024 = var5 - var4.field3019;
               var4.field3025 = 4096;
               var4.field3037 = var2;
               return;
            }
         }
      }

      class181 var8 = (class181)this.field2980.method3806((long)this.field2981[var1]);
      if(null != var8) {
         class62 var9 = var8.field2939[var2];
         if(var9 != null) {
            class187 var6 = new class187();
            var6.field3026 = var1;
            var6.field3016 = var8;
            var6.field3017 = var9;
            var6.field3038 = var8.field2943[var2];
            var6.field3036 = var8.field2944[var2];
            var6.field3037 = var2;
            var6.field3021 = var3 * var3 * var8.field2938 * var8.field2942[var2] + 1024 >> 11;
            var6.field3022 = var8.field2949[var2] & 255;
            var6.field3019 = (var2 << 8) - (var8.field2940[var2] & 32767);
            var6.field3028 = 0;
            var6.field3027 = 0;
            var6.field3018 = 0;
            var6.field3020 = -1;
            var6.field3030 = 0;
            if(0 == this.field2986[var1]) {
               var6.field3033 = class64.method1319(var9, this.method3620(var6), this.method3641(var6), this.method3642(var6));
            } else {
               var6.field3033 = class64.method1319(var9, this.method3620(var6), 0, this.method3642(var6));
               this.method3627(var6, var8.field2940[var2] < 0);
            }

            if(var8.field2940[var2] < 0) {
               var6.field3033.method1322(-1);
            }

            if(var6.field3036 >= 0) {
               class187 var7 = this.field2983[var1][var6.field3036];
               if(var7 != null && var7.field3020 < 0) {
                  this.field2992[var1][var7.field3037] = null;
                  var7.field3020 = 0;
               }

               this.field2983[var1][var6.field3036] = var6;
            }

            this.field2989.field3012.method3834(var6);
            this.field2992[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   public synchronized void method3618() {
      for(class181 var1 = (class181)this.field2980.method3805(); var1 != null; var1 = (class181)this.field2980.method3809()) {
         var1.method3539();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1271432382"
   )
   public synchronized void method3619() {
      for(class181 var1 = (class181)this.field2980.method3805(); null != var1; var1 = (class181)this.field2980.method3809()) {
         var1.method3935();
      }

   }

   @ObfuscatedName("at")
   int method3620(class187 var1) {
      int var2 = (var1.field3025 * var1.field3024 >> 12) + var1.field3019;
      var2 += (this.field2995[var1.field3026] - 8192) * this.field2988[var1.field3026] >> 12;
      class185 var3 = var1.field3038;
      int var4;
      if(var3.field3010 > 0 && (var3.field3009 > 0 || this.field2984[var1.field3026] > 0)) {
         var4 = var3.field3009 << 2;
         int var5 = var3.field3002 << 1;
         if(var1.field3015 < var5) {
            var4 = var1.field3015 * var4 / var5;
         }

         var4 += this.field2984[var1.field3026] >> 7;
         double var6 = Math.sin((double)(var1.field3032 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3017.field1237 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class129.field2058 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("j")
   public synchronized boolean method3622() {
      return this.field2974.method3557();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-100900670"
   )
   void method3625() {
      int var1 = this.field2996;
      int var2 = this.field2997;

      long var3;
      for(var3 = this.field2991; var2 == this.field2997; var3 = this.field2974.method3586(var2)) {
         while(var2 == this.field2974.field2962[var1]) {
            this.field2974.method3559(var1);
            int var5 = this.field2974.method3563(var1);
            if(1 == var5) {
               this.field2974.method3561();
               this.field2974.method3556(var1);
               if(this.field2974.method3570()) {
                  if(!this.field2993 || 0 == var2) {
                     this.method3672();
                     this.field2974.method3580();
                     return;
                  }

                  this.field2974.method3569(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3638(var5);
            }

            this.field2974.method3562(var1);
            this.field2974.method3556(var1);
         }

         var1 = this.field2974.method3554();
         var2 = this.field2974.field2962[var1];
      }

      this.field2996 = var1;
      this.field2997 = var2;
      this.field2991 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZB)V",
      garbageValue = "0"
   )
   void method3627(class187 var1, boolean var2) {
      int var3 = var1.field3017.field1238.length;
      int var4;
      if(var2 && var1.field3017.field1240) {
         int var5 = var3 + var3 - var1.field3017.field1236;
         var4 = (int)((long)this.field2986[var1.field3026] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3033.method1328();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2986[var1.field3026] >> 6);
      }

      var1.field3033.method1373(var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1453736080"
   )
   void method3628(int var1, int var2) {
      class187 var3 = this.field2992[var1][var2];
      if(var3 != null) {
         this.field2992[var1][var2] = null;
         if((this.field3000[var1] & 2) != 0) {
            for(class187 var4 = (class187)this.field2989.field3012.method3836(); null != var4; var4 = (class187)this.field2989.field3012.method3841()) {
               if(var4.field3026 == var3.field3026 && var4.field3020 < 0 && var4 != var3) {
                  var3.field3020 = 0;
                  break;
               }
            }
         } else {
            var3.field3020 = 0;
         }

      }
   }

   @ObfuscatedName("h")
   void method3629() {
   }

   @ObfuscatedName("f")
   void method3631(int var1, int var2) {
      this.field2995[var1] = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "286373273"
   )
   void method3632(int var1) {
      for(class187 var2 = (class187)this.field2989.field3012.method3836(); null != var2; var2 = (class187)this.field2989.field3012.method3841()) {
         if(var1 < 0 || var2.field3026 == var1) {
            if(var2.field3033 != null) {
               var2.field3033.method1332(class129.field2058 / 100);
               if(var2.field3033.method1335()) {
                  this.field2989.field3014.method1188(var2.field3033);
               }

               var2.method3756();
            }

            if(var2.field3020 < 0) {
               this.field2992[var2.field3026][var2.field3037] = null;
            }

            var2.method3935();
         }
      }

   }

   @ObfuscatedName("ae")
   void method3633(int var1) {
      if(var1 >= 0) {
         this.field2977[var1] = 12800;
         this.field2978[var1] = 8192;
         this.field2979[var1] = 16383;
         this.field2995[var1] = 8192;
         this.field2984[var1] = 0;
         this.field2985[var1] = 8192;
         this.method3636(var1);
         this.method3670(var1);
         this.field3000[var1] = 0;
         this.field2987[var1] = 32767;
         this.field2988[var1] = 256;
         this.field2986[var1] = 0;
         this.method3639(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3633(var1);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-916076493"
   )
   void method3636(int var1) {
      if((this.field3000[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field2989.field3012.method3836(); null != var2; var2 = (class187)this.field2989.field3012.method3841()) {
            if(var2.field3026 == var1 && this.field2992[var1][var2.field3037] == null && var2.field3020 < 0) {
               var2.field3020 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1694139950"
   )
   void method3638(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(128 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3628(var3, var4);
      } else if(144 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3616(var3, var4, var5);
         } else {
            this.method3628(var3, var4);
         }

      } else if(160 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3629();
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2982[var3] = (var5 << 14) + (this.field2982[var3] & -2080769);
         }

         if(32 == var4) {
            this.field2982[var3] = (var5 << 7) + (this.field2982[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2984[var3] = (this.field2984[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field2984[var3] = var5 + (this.field2984[var3] & -128);
         }

         if(5 == var4) {
            this.field2985[var3] = (var5 << 7) + (this.field2985[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2985[var3] = var5 + (this.field2985[var3] & -128);
         }

         if(var4 == 7) {
            this.field2977[var3] = (var5 << 7) + (this.field2977[var3] & -16257);
         }

         if(39 == var4) {
            this.field2977[var3] = var5 + (this.field2977[var3] & -128);
         }

         if(var4 == 10) {
            this.field2978[var3] = (var5 << 7) + (this.field2978[var3] & -16257);
         }

         if(42 == var4) {
            this.field2978[var3] = var5 + (this.field2978[var3] & -128);
         }

         if(11 == var4) {
            this.field2979[var3] = (var5 << 7) + (this.field2979[var3] & -16257);
         }

         if(43 == var4) {
            this.field2979[var3] = var5 + (this.field2979[var3] & -128);
         }

         if(64 == var4) {
            if(var5 >= 64) {
               this.field3000[var3] |= 1;
            } else {
               this.field3000[var3] &= -2;
            }
         }

         if(65 == var4) {
            if(var5 >= 64) {
               this.field3000[var3] |= 2;
            } else {
               this.method3636(var3);
               this.field3000[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2987[var3] = (var5 << 7) + (this.field2987[var3] & 127);
         }

         if(98 == var4) {
            this.field2987[var3] = var5 + (this.field2987[var3] & 16256);
         }

         if(101 == var4) {
            this.field2987[var3] = (this.field2987[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2987[var3] = 16384 + (this.field2987[var3] & 16256) + var5;
         }

         if(120 == var4) {
            this.method3632(var3);
         }

         if(var4 == 121) {
            this.method3633(var3);
         }

         if(123 == var4) {
            this.method3703(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2987[var3];
            if(var6 == 16384) {
               this.field2988[var3] = (var5 << 7) + (this.field2988[var3] & -16257);
            }
         }

         if(38 == var4) {
            var6 = this.field2987[var3];
            if(var6 == 16384) {
               this.field2988[var3] = var5 + (this.field2988[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2986[var3] = (var5 << 7) + (this.field2986[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2986[var3] = (this.field2986[var3] & -128) + var5;
         }

         if(81 == var4) {
            if(var5 >= 64) {
               this.field3000[var3] |= 4;
            } else {
               this.method3670(var3);
               this.field3000[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3639(var3, (this.field2999[var3] & -16257) + (var5 << 7));
         }

         if(49 == var4) {
            this.method3639(var3, var5 + (this.field2999[var3] & -128));
         }

      } else if(192 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3679(var3, var4 + this.field2982[var3]);
      } else if(208 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3669();
      } else if(224 == var2) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3631(var3, var4);
      } else {
         var2 = var1 & 255;
         if(255 == var2) {
            this.method3672();
         }
      }
   }

   @ObfuscatedName("ak")
   void method3639(int var1, int var2) {
      this.field2999[var1] = var2;
      this.field2994[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aw")
   int method3641(class187 var1) {
      class185 var2 = var1.field3038;
      int var3 = 4096 + this.field2979[var1.field3026] * this.field2977[var1.field3026] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field3021 >> 15;
      var3 = var3 * this.field2975 + 128 >> 8;
      if(var2.field3004 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field3028 * (double)var2.field3004) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field3003 != null) {
         var4 = var1.field3027;
         var5 = var2.field3003[var1.field3018 + 1];
         if(var1.field3018 < var2.field3003.length - 2) {
            var6 = (var2.field3003[var1.field3018] & 255) << 8;
            var7 = (var2.field3003[2 + var1.field3018] & 255) << 8;
            var5 += (var2.field3003[var1.field3018 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field3020 > 0 && var2.field3008 != null) {
         var4 = var1.field3020;
         var5 = var2.field3008[var1.field3030 + 1];
         if(var1.field3030 < var2.field3008.length - 2) {
            var6 = (var2.field3008[var1.field3030] & 255) << 8;
            var7 = (var2.field3008[2 + var1.field3030] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3008[3 + var1.field3030] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("as")
   int method3642(class187 var1) {
      int var2 = this.field2978[var1.field3026];
      return var2 < 8192?32 + var2 * var1.field3022 >> 6:16384 - (32 + (128 - var1.field3022) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("y")
   protected synchronized class66 vmethod3729() {
      return this.field2989;
   }

   @ObfuscatedName("m")
   protected synchronized class66 vmethod3749() {
      return null;
   }

   @ObfuscatedName("c")
   protected synchronized int vmethod3745() {
      return 0;
   }

   @ObfuscatedName("v")
   protected synchronized void vmethod3733(int[] var1, int var2, int var3) {
      if(this.field2974.method3557()) {
         int var4 = this.field2976 * this.field2974.field2951 / class129.field2058;

         do {
            long var5 = this.field2998 + (long)var4 * (long)var3;
            if(this.field2991 - var5 >= 0L) {
               this.field2998 = var5;
               break;
            }

            int var7 = (int)((this.field2991 - this.field2998 + (long)var4 - 1L) / (long)var4);
            this.field2998 += (long)var4 * (long)var7;
            this.field2989.vmethod3733(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3625();
         } while(this.field2974.method3557());
      }

      this.field2989.vmethod3733(var1, var2, var3);
   }

   @ObfuscatedName("z")
   protected synchronized void vmethod3734(int var1) {
      if(this.field2974.method3557()) {
         int var2 = this.field2976 * this.field2974.field2951 / class129.field2058;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2998;
            if(this.field2991 - var3 >= 0L) {
               this.field2998 = var3;
               break;
            }

            int var5 = (int)((this.field2991 - this.field2998 + (long)var2 - 1L) / (long)var2);
            this.field2998 += (long)var2 * (long)var5;
            this.field2989.vmethod3734(var5);
            var1 -= var5;
            this.method3625();
         } while(this.field2974.method3557());
      }

      this.field2989.vmethod3734(var1);
   }

   @ObfuscatedName("ax")
   boolean method3649(class187 var1) {
      if(null == var1.field3033) {
         if(var1.field3020 >= 0) {
            var1.method3935();
            if(var1.field3036 > 0 && var1 == this.field2983[var1.field3026][var1.field3036]) {
               this.field2983[var1.field3026][var1.field3036] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   public synchronized void method3652() {
      this.field2974.method3580();
      this.method3672();
   }

   @ObfuscatedName("q")
   public synchronized void method3658(int var1, int var2) {
      this.method3721(var1, var2);
   }

   @ObfuscatedName("k")
   void method3669() {
   }

   @ObfuscatedName("ad")
   void method3670(int var1) {
      if((this.field3000[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field2989.field3012.method3836(); null != var2; var2 = (class187)this.field2989.field3012.method3841()) {
            if(var2.field3026 == var1) {
               var2.field3031 = 0;
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "365155273"
   )
   void method3672() {
      this.method3632(-1);
      this.method3633(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2981[var1] = this.field2990[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2982[var1] = this.field2990[var1] & -128;
      }

   }

   public class184() {
      this.method3672();
   }

   @ObfuscatedName("x")
   public int method3676() {
      return this.field2975;
   }

   @ObfuscatedName("d")
   void method3679(int var1, int var2) {
      if(this.field2981[var1] != var2) {
         this.field2981[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2983[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("l")
   public synchronized void method3694(class180 var1, boolean var2) {
      this.method3652();
      this.field2974.method3555(var1.field2936);
      this.field2993 = var2;
      this.field2998 = 0L;
      int var3 = this.field2974.method3558();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2974.method3559(var4);
         this.field2974.method3562(var4);
         this.field2974.method3556(var4);
      }

      this.field2996 = this.field2974.method3554();
      this.field2997 = this.field2974.field2962[this.field2996];
      this.field2991 = this.field2974.method3586(this.field2997);
   }

   @ObfuscatedName("az")
   void method3703(int var1) {
      for(class187 var2 = (class187)this.field2989.field3012.method3836(); null != var2; var2 = (class187)this.field2989.field3012.method3841()) {
         if((var1 < 0 || var2.field3026 == var1) && var2.field3020 < 0) {
            this.field2992[var2.field3026][var2.field3037] = null;
            var2.field3020 = 0;
         }
      }

   }

   @ObfuscatedName("an")
   boolean method3714(class187 var1, int[] var2, int var3, int var4) {
      var1.field3034 = class129.field2058 / 100;
      if(var1.field3020 < 0 || null != var1.field3033 && !var1.field3033.method1334()) {
         int var5 = var1.field3025;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2985[var1.field3026]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3025 = var5;
         }

         var1.field3033.method1428(this.method3620(var1));
         class185 var6 = var1.field3038;
         boolean var7 = false;
         ++var1.field3015;
         var1.field3032 += var6.field3010;
         double var8 = (double)((var1.field3037 - 60 << 8) + (var1.field3024 * var1.field3025 >> 12)) * 5.086263020833333E-6D;
         if(var6.field3004 > 0) {
            if(var6.field3007 > 0) {
               var1.field3028 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3007 * var8) + 0.5D);
            } else {
               var1.field3028 += 128;
            }
         }

         if(var6.field3003 != null) {
            if(var6.field3005 > 0) {
               var1.field3027 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3005 * var8) + 0.5D);
            } else {
               var1.field3027 += 128;
            }

            while(var1.field3018 < var6.field3003.length - 2 && var1.field3027 > (var6.field3003[var1.field3018 + 2] & 255) << 8) {
               var1.field3018 += 2;
            }

            if(var1.field3018 == var6.field3003.length - 2 && var6.field3003[1 + var1.field3018] == 0) {
               var7 = true;
            }
         }

         if(var1.field3020 >= 0 && null != var6.field3008 && 0 == (this.field3000[var1.field3026] & 1) && (var1.field3036 < 0 || var1 != this.field2983[var1.field3026][var1.field3036])) {
            if(var6.field3006 > 0) {
               var1.field3020 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3006 * var8) + 0.5D);
            } else {
               var1.field3020 += 128;
            }

            while(var1.field3030 < var6.field3008.length - 2 && var1.field3020 > (var6.field3008[2 + var1.field3030] & 255) << 8) {
               var1.field3030 += 2;
            }

            if(var1.field3030 == var6.field3008.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3033.method1332(var1.field3034);
            if(var2 != null) {
               var1.field3033.vmethod3733(var2, var3, var4);
            } else {
               var1.field3033.vmethod3734(var4);
            }

            if(var1.field3033.method1335()) {
               this.field2989.field3014.method1188(var1.field3033);
            }

            var1.method3756();
            if(var1.field3020 >= 0) {
               var1.method3935();
               if(var1.field3036 > 0 && var1 == this.field2983[var1.field3026][var1.field3036]) {
                  this.field2983[var1.field3026][var1.field3036] = null;
               }
            }

            return true;
         } else {
            var1.field3033.method1331(var1.field3034, this.method3641(var1), this.method3642(var1));
            return false;
         }
      } else {
         var1.method3756();
         var1.method3935();
         if(var1.field3036 > 0 && var1 == this.field2983[var1.field3026][var1.field3036]) {
            this.field2983[var1.field3026][var1.field3036] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("a")
   void method3721(int var1, int var2) {
      this.field2990[var1] = var2;
      this.field2982[var1] = var2 & -128;
      this.method3679(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "22050"
   )
   public synchronized boolean method3722(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3532();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2937.method3805(); var7 != null; var7 = (class197)var1.field2937.method3809()) {
         int var8 = (int)var7.field3123;
         class181 var9 = (class181)this.field2980.method3806((long)var8);
         if(var9 == null) {
            var9 = class37.method774(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2980.method3807(var9, (long)var8);
         }

         if(!var9.method3538(var3, var7.field3103, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3533();
      }

      return var5;
   }
}
