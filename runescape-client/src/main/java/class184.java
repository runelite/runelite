import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class184 extends class66 {
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1384770199
   )
   int field2966;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -868204379
   )
   int field2967 = 256;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 876521361
   )
   int field2968 = 1000000;
   @ObfuscatedName("j")
   class196 field2970 = new class196(128);
   @ObfuscatedName("e")
   int[] field2971 = new int[16];
   @ObfuscatedName("i")
   int[] field2972 = new int[16];
   @ObfuscatedName("ao")
   class186 field2973 = new class186(this);
   @ObfuscatedName("c")
   int[] field2974 = new int[16];
   @ObfuscatedName("l")
   int[] field2975 = new int[16];
   @ObfuscatedName("z")
   int[] field2976 = new int[16];
   @ObfuscatedName("ab")
   boolean field2977;
   @ObfuscatedName("n")
   int[] field2980 = new int[16];
   @ObfuscatedName("w")
   int[] field2981 = new int[16];
   @ObfuscatedName("g")
   int[] field2982 = new int[16];
   @ObfuscatedName("s")
   int[] field2983 = new int[16];
   @ObfuscatedName("k")
   int[] field2984 = new int[16];
   @ObfuscatedName("o")
   int[] field2985 = new int[16];
   @ObfuscatedName("v")
   int[] field2986 = new int[16];
   @ObfuscatedName("f")
   class187[][] field2987 = new class187[16][128];
   @ObfuscatedName("au")
   class187[][] field2988 = new class187[16][128];
   @ObfuscatedName("aq")
   class182 field2989 = new class182();
   @ObfuscatedName("u")
   int[] field2990 = new int[16];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1069828359
   )
   int field2991;
   @ObfuscatedName("r")
   int[] field2992 = new int[16];
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = 6145558138345556537L
   )
   long field2993;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 5188126685871625241L
   )
   long field2994;
   @ObfuscatedName("x")
   int[] field2995 = new int[16];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1900240521"
   )
   public synchronized void method3559(int var1) {
      this.field2967 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1315328235"
   )
   public int method3560() {
      return this.field2967;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2126746923"
   )
   synchronized void method3562() {
      for(class181 var1 = (class181)this.field2970.method3745(); var1 != null; var1 = (class181)this.field2970.method3746()) {
         var1.method3481();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1385592720"
   )
   public synchronized void method3563() {
      for(class181 var1 = (class181)this.field2970.method3745(); var1 != null; var1 = (class181)this.field2970.method3746()) {
         var1.method3883();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZB)V",
      garbageValue = "-87"
   )
   synchronized void method3564(class180 var1, boolean var2) {
      this.method3565();
      this.field2989.method3487(var1.field2929);
      this.field2977 = var2;
      this.field2993 = 0L;
      int var3 = this.field2989.method3490();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2989.method3489(var4);
         this.field2989.method3494(var4);
         this.field2989.method3492(var4);
      }

      this.field2991 = this.field2989.method3510();
      this.field2966 = this.field2989.field2945[this.field2991];
      this.field2994 = this.field2989.method3493(this.field2966);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1639606663"
   )
   public synchronized void method3565() {
      this.field2989.method3527();
      this.method3662();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "32"
   )
   void method3569(int var1, int var2) {
      if(var2 != this.field2974[var1]) {
         this.field2974[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2988[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1501817573"
   )
   void method3571(int var1, int var2, int var3) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "83"
   )
   void method3572(int var1, int var2, int var3) {
      class187 var4 = this.field2987[var1][var2];
      if(null != var4) {
         this.field2987[var1][var2] = null;
         if((this.field2981[var1] & 2) != 0) {
            for(class187 var5 = (class187)this.field2973.field3006.method3784(); var5 != null; var5 = (class187)this.field2973.field3006.method3777()) {
               if(var5.field3030 == var4.field3030 && var5.field3026 < 0 && var5 != var4) {
                  var4.field3026 = 0;
                  break;
               }
            }
         } else {
            var4.field3026 = 0;
         }

      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "13"
   )
   int method3573(class187 var1) {
      int var2 = var1.field3020 + (var1.field3022 * var1.field3021 >> 12);
      var2 += this.field2983[var1.field3030] * (this.field2975[var1.field3030] - 8192) >> 12;
      class185 var3 = var1.field3015;
      int var4;
      if(var3.field2996 > 0 && (var3.field3003 > 0 || this.field2990[var1.field3030] > 0)) {
         var4 = var3.field3003 << 2;
         int var5 = var3.field3004 << 1;
         if(var1.field3012 < var5) {
            var4 = var1.field3012 * var4 / var5;
         }

         var4 += this.field2990[var1.field3030] >> 7;
         double var6 = Math.sin((double)(var1.field3031 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(256 * var1.field3013.field1214) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class56.field1181 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1061973342"
   )
   void method3574(int var1, int var2) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method3576(int var1) {
      for(class187 var2 = (class187)this.field2973.field3006.method3784(); var2 != null; var2 = (class187)this.field2973.field3006.method3777()) {
         if(var1 < 0 || var1 == var2.field3030) {
            if(var2.field3035 != null) {
               var2.field3035.method1333(class56.field1181 / 100);
               if(var2.field3035.method1318()) {
                  this.field2973.field3008.method1146(var2.field3035);
               }

               var2.method3696();
            }

            if(var2.field3026 < 0) {
               this.field2987[var2.field3030][var2.field3017] = null;
            }

            var2.method3883();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1856482854"
   )
   void method3577(int var1) {
      if(var1 >= 0) {
         this.field2976[var1] = 12800;
         this.field2995[var1] = 8192;
         this.field2971[var1] = 16383;
         this.field2975[var1] = 8192;
         this.field2990[var1] = 0;
         this.field2992[var1] = 8192;
         this.method3580(var1);
         this.method3581(var1);
         this.field2981[var1] = 0;
         this.field2982[var1] = 32767;
         this.field2983[var1] = 256;
         this.field2984[var1] = 0;
         this.method3583(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3577(var1);
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-190207833"
   )
   void method3578(int var1) {
      for(class187 var2 = (class187)this.field2973.field3006.method3784(); null != var2; var2 = (class187)this.field2973.field3006.method3777()) {
         if((var1 < 0 || var1 == var2.field3030) && var2.field3026 < 0) {
            this.field2987[var2.field3030][var2.field3017] = null;
            var2.field3026 = 0;
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-721975820"
   )
   void method3580(int var1) {
      if((this.field2981[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field2973.field3006.method3784(); var2 != null; var2 = (class187)this.field2973.field3006.method3777()) {
            if(var1 == var2.field3030 && this.field2987[var1][var2.field3017] == null && var2.field3026 < 0) {
               var2.field3026 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1804829048"
   )
   void method3581(int var1) {
      if((this.field2981[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field2973.field3006.method3784(); null != var2; var2 = (class187)this.field2973.field3006.method3777()) {
            if(var1 == var2.field3030) {
               var2.field3032 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1090532771"
   )
   void method3582(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(128 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3572(var3, var4, var5);
      } else if(144 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3639(var3, var4, var5);
         } else {
            this.method3572(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3571(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2980[var3] = (var5 << 14) + (this.field2980[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2980[var3] = (var5 << 7) + (this.field2980[var3] & -16257);
         }

         if(1 == var4) {
            this.field2990[var3] = (this.field2990[var3] & -16257) + (var5 << 7);
         }

         if(33 == var4) {
            this.field2990[var3] = (this.field2990[var3] & -128) + var5;
         }

         if(5 == var4) {
            this.field2992[var3] = (this.field2992[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2992[var3] = var5 + (this.field2992[var3] & -128);
         }

         if(7 == var4) {
            this.field2976[var3] = (var5 << 7) + (this.field2976[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2976[var3] = var5 + (this.field2976[var3] & -128);
         }

         if(10 == var4) {
            this.field2995[var3] = (this.field2995[var3] & -16257) + (var5 << 7);
         }

         if(42 == var4) {
            this.field2995[var3] = var5 + (this.field2995[var3] & -128);
         }

         if(var4 == 11) {
            this.field2971[var3] = (var5 << 7) + (this.field2971[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2971[var3] = (this.field2971[var3] & -128) + var5;
         }

         if(64 == var4) {
            if(var5 >= 64) {
               this.field2981[var3] |= 1;
            } else {
               this.field2981[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2981[var3] |= 2;
            } else {
               this.method3580(var3);
               this.field2981[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2982[var3] = (this.field2982[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2982[var3] = (this.field2982[var3] & 16256) + var5;
         }

         if(101 == var4) {
            this.field2982[var3] = (var5 << 7) + 16384 + (this.field2982[var3] & 127);
         }

         if(var4 == 100) {
            this.field2982[var3] = var5 + (this.field2982[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3576(var3);
         }

         if(121 == var4) {
            this.method3577(var3);
         }

         if(123 == var4) {
            this.method3578(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2982[var3];
            if(var6 == 16384) {
               this.field2983[var3] = (this.field2983[var3] & -16257) + (var5 << 7);
            }
         }

         if(38 == var4) {
            var6 = this.field2982[var3];
            if(var6 == 16384) {
               this.field2983[var3] = var5 + (this.field2983[var3] & -128);
            }
         }

         if(16 == var4) {
            this.field2984[var3] = (var5 << 7) + (this.field2984[var3] & -16257);
         }

         if(48 == var4) {
            this.field2984[var3] = (this.field2984[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2981[var3] |= 4;
            } else {
               this.method3581(var3);
               this.field2981[var3] &= -5;
            }
         }

         if(17 == var4) {
            this.method3583(var3, (var5 << 7) + (this.field2985[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3583(var3, (this.field2985[var3] & -128) + var5);
         }

      } else if(192 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3569(var3, this.field2980[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3574(var3, var4);
      } else if(224 == var2) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3624(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3662();
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "965046058"
   )
   void method3583(int var1, int var2) {
      this.field2985[var1] = var2;
      this.field2986[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "1147381992"
   )
   int method3585(class187 var1) {
      class185 var2 = var1.field3015;
      int var3 = this.field2971[var1.field3030] * this.field2976[var1.field3030] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = 16384 + var3 * var1.field3018 >> 15;
      var3 = var3 * this.field2967 + 128 >> 8;
      if(var2.field3002 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3002 * (double)var1.field3029 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field2997) {
         var4 = var1.field3024;
         var5 = var2.field2997[1 + var1.field3025];
         if(var1.field3025 < var2.field2997.length - 2) {
            var6 = (var2.field2997[var1.field3025] & 255) << 8;
            var7 = (var2.field2997[2 + var1.field3025] & 255) << 8;
            var5 += (var2.field2997[3 + var1.field3025] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3026 > 0 && var2.field2998 != null) {
         var4 = var1.field3026;
         var5 = var2.field2998[var1.field3027 + 1];
         if(var1.field3027 < var2.field2998.length - 2) {
            var6 = (var2.field2998[var1.field3027] & 255) << 8;
            var7 = (var2.field2998[var1.field3027 + 2] & 255) << 8;
            var5 += (var2.field2998[3 + var1.field3027] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "-1389802109"
   )
   int method3586(class187 var1) {
      int var2 = this.field2995[var1.field3030];
      return var2 < 8192?32 + var1.field3023 * var2 >> 6:16384 - (32 + (128 - var1.field3023) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("i")
   protected synchronized class66 vmethod3674() {
      return null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)Z",
      garbageValue = "-1266744771"
   )
   boolean method3590(class187 var1) {
      if(var1.field3035 == null) {
         if(var1.field3026 >= 0) {
            var1.method3883();
            if(var1.field3016 > 0 && this.field2988[var1.field3030][var1.field3016] == var1) {
               this.field2988[var1.field3030][var1.field3016] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2144681287"
   )
   void method3592() {
      int var1 = this.field2991;
      int var2 = this.field2966;

      long var3;
      for(var3 = this.field2994; this.field2966 == var2; var3 = this.field2989.method3493(var2)) {
         while(this.field2989.field2945[var1] == var2) {
            this.field2989.method3489(var1);
            int var5 = this.field2989.method3534(var1);
            if(1 == var5) {
               this.field2989.method3486();
               this.field2989.method3492(var1);
               if(this.field2989.method3499()) {
                  if(!this.field2977 || 0 == var2) {
                     this.method3662();
                     this.field2989.method3527();
                     return;
                  }

                  this.field2989.method3514(var3);
               }
               break;
            }

            if(0 != (var5 & 128)) {
               this.method3582(var5);
            }

            this.field2989.method3494(var1);
            this.field2989.method3492(var1);
         }

         var1 = this.field2989.method3510();
         var2 = this.field2989.field2945[var1];
      }

      this.field2991 = var1;
      this.field2966 = var2;
      this.field2994 = var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIII)Z",
      garbageValue = "-605691868"
   )
   boolean method3594(class187 var1, int[] var2, int var3, int var4) {
      var1.field3034 = class56.field1181 / 100;
      if(var1.field3026 < 0 || var1.field3035 != null && !var1.field3035.method1403()) {
         int var5 = var1.field3022;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2992[var1.field3030]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3022 = var5;
         }

         var1.field3035.method1315(this.method3573(var1));
         class185 var6 = var1.field3015;
         boolean var7 = false;
         ++var1.field3012;
         var1.field3031 += var6.field2996;
         double var8 = (double)((var1.field3021 * var1.field3022 >> 12) + (var1.field3017 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field3002 > 0) {
            if(var6.field3001 > 0) {
               var1.field3029 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3001) + 0.5D);
            } else {
               var1.field3029 += 128;
            }
         }

         if(var6.field2997 != null) {
            if(var6.field2999 > 0) {
               var1.field3024 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2999) + 0.5D);
            } else {
               var1.field3024 += 128;
            }

            while(var1.field3025 < var6.field2997.length - 2 && var1.field3024 > (var6.field2997[2 + var1.field3025] & 255) << 8) {
               var1.field3025 += 2;
            }

            if(var1.field3025 == var6.field2997.length - 2 && var6.field2997[1 + var1.field3025] == 0) {
               var7 = true;
            }
         }

         if(var1.field3026 >= 0 && var6.field2998 != null && (this.field2981[var1.field3030] & 1) == 0 && (var1.field3016 < 0 || var1 != this.field2988[var1.field3030][var1.field3016])) {
            if(var6.field3000 > 0) {
               var1.field3026 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3000) + 0.5D);
            } else {
               var1.field3026 += 128;
            }

            while(var1.field3027 < var6.field2998.length - 2 && var1.field3026 > (var6.field2998[var1.field3027 + 2] & 255) << 8) {
               var1.field3027 += 2;
            }

            if(var1.field3027 == var6.field2998.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3035.method1333(var1.field3034);
            if(null != var2) {
               var1.field3035.vmethod3676(var2, var3, var4);
            } else {
               var1.field3035.vmethod3677(var4);
            }

            if(var1.field3035.method1318()) {
               this.field2973.field3008.method1146(var1.field3035);
            }

            var1.method3696();
            if(var1.field3026 >= 0) {
               var1.method3883();
               if(var1.field3016 > 0 && this.field2988[var1.field3030][var1.field3016] == var1) {
                  this.field2988[var1.field3030][var1.field3016] = null;
               }
            }

            return true;
         } else {
            var1.field3035.method1402(var1.field3034, this.method3585(var1), this.method3586(var1));
            return false;
         }
      } else {
         var1.method3696();
         var1.method3883();
         if(var1.field3016 > 0 && this.field2988[var1.field3030][var1.field3016] == var1) {
            this.field2988[var1.field3030][var1.field3016] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "9"
   )
   public synchronized void method3597(int var1, int var2) {
      this.method3651(var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1607597693"
   )
   public synchronized boolean method3599() {
      return this.field2989.method3496();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZI)V",
      garbageValue = "0"
   )
   void method3606(class187 var1, boolean var2) {
      int var3 = var1.field3013.field1213.length;
      int var4 = (int)((long)var3 * (long)this.field2984[var1.field3030] >> 6);
      var1.field3035.method1309(var4);
   }

   @ObfuscatedName("c")
   protected synchronized int vmethod3675() {
      return 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1126157389"
   )
   void method3624(int var1, int var2) {
      this.field2975[var1] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "22050"
   )
   synchronized boolean method3630(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3476();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2930.method3745(); null != var7; var7 = (class197)var1.field2930.method3746()) {
         int var8 = (int)var7.field3122;
         class181 var9 = (class181)this.field2970.method3742((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3272(var8);
            class181 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class181(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field2970.method3743(var10, (long)var8);
         }

         if(!var9.method3482(var3, var7.field3102, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3475();
      }

      return var5;
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod3677(int var1) {
      if(this.field2989.method3496()) {
         int var2 = this.field2989.field2954 * this.field2968 / class56.field1181;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2993;
            if(this.field2994 - var3 >= 0L) {
               this.field2993 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2994 - this.field2993) - 1L) / (long)var2);
            this.field2993 += (long)var5 * (long)var2;
            this.field2973.vmethod3677(var5);
            var1 -= var5;
            this.method3592();
         } while(this.field2989.method3496());
      }

      this.field2973.vmethod3677(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "-15576"
   )
   void method3639(int var1, int var2, int var3) {
      this.method3572(var1, var2, 64);
      if((this.field2981[var1] & 2) != 0) {
         for(class187 var4 = (class187)this.field2973.field3006.method3785(); null != var4; var4 = (class187)this.field2973.field3006.method3787()) {
            if(var1 == var4.field3030 && var4.field3026 < 0) {
               this.field2987[var1][var4.field3017] = null;
               this.field2987[var1][var2] = var4;
               int var5 = (var4.field3021 * var4.field3022 >> 12) + var4.field3020;
               var4.field3020 += var2 - var4.field3017 << 8;
               var4.field3021 = var5 - var4.field3020;
               var4.field3022 = 4096;
               var4.field3017 = var2;
               return;
            }
         }
      }

      class181 var8 = (class181)this.field2970.method3742((long)this.field2974[var1]);
      if(var8 != null) {
         class62 var9 = var8.field2933[var2];
         if(null != var9) {
            class187 var6 = new class187();
            var6.field3030 = var1;
            var6.field3036 = var8;
            var6.field3013 = var9;
            var6.field3015 = var8.field2940[var2];
            var6.field3016 = var8.field2937[var2];
            var6.field3017 = var2;
            var6.field3018 = 1024 + var8.field2932 * var3 * var3 * var8.field2934[var2] >> 11;
            var6.field3023 = var8.field2935[var2] & 255;
            var6.field3020 = (var2 << 8) - (var8.field2931[var2] & 32767);
            var6.field3029 = 0;
            var6.field3024 = 0;
            var6.field3025 = 0;
            var6.field3026 = -1;
            var6.field3027 = 0;
            if(0 == this.field2984[var1]) {
               var6.field3035 = class64.method1447(var9, this.method3573(var6), this.method3585(var6), this.method3586(var6));
            } else {
               var6.field3035 = class64.method1447(var9, this.method3573(var6), 0, this.method3586(var6));
               this.method3606(var6, var8.field2931[var2] < 0);
            }

            if(var8.field2931[var2] < 0) {
               var6.field3035.method1303(-1);
            }

            if(var6.field3016 >= 0) {
               class187 var7 = this.field2988[var1][var6.field3016];
               if(var7 != null && var7.field3026 < 0) {
                  this.field2987[var1][var7.field3017] = null;
                  var7.field3026 = 0;
               }

               this.field2988[var1][var6.field3016] = var6;
            }

            this.field2973.field3006.method3779(var6);
            this.field2987[var1][var2] = var6;
         }
      }
   }

   public class184() {
      this.method3662();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1763335389"
   )
   void method3651(int var1, int var2) {
      this.field2972[var1] = var2;
      this.field2980[var1] = var2 & -128;
      this.method3569(var1, var2);
   }

   @ObfuscatedName("e")
   protected synchronized class66 vmethod3673() {
      return this.field2973;
   }

   @ObfuscatedName("n")
   protected synchronized void vmethod3676(int[] var1, int var2, int var3) {
      if(this.field2989.method3496()) {
         int var4 = this.field2968 * this.field2989.field2954 / class56.field1181;

         do {
            long var5 = this.field2993 + (long)var3 * (long)var4;
            if(this.field2994 - var5 >= 0L) {
               this.field2993 = var5;
               break;
            }

            int var7 = (int)((this.field2994 - this.field2993 + (long)var4 - 1L) / (long)var4);
            this.field2993 += (long)var4 * (long)var7;
            this.field2973.vmethod3676(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3592();
         } while(this.field2989.method3496());
      }

      this.field2973.vmethod3676(var1, var2, var3);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1160349831"
   )
   void method3662() {
      this.method3576(-1);
      this.method3577(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2974[var1] = this.field2972[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2980[var1] = this.field2972[var1] & -128;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-982867716"
   )
   static final boolean method3672(int var0, int var1) {
      class40 var2 = class85.method1903(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method789(var1);
   }
}
