import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class187 extends class69 {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 1549804178077982551L
   )
   long field3018;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1798170769
   )
   int field3019 = 256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 388749335
   )
   int field3020 = 1000000;
   @ObfuscatedName("e")
   int[] field3021 = new int[16];
   @ObfuscatedName("b")
   int[] field3022 = new int[16];
   @ObfuscatedName("y")
   int[] field3023 = new int[16];
   @ObfuscatedName("l")
   int[] field3024 = new int[16];
   @ObfuscatedName("m")
   int[] field3025 = new int[16];
   @ObfuscatedName("o")
   class190[][] field3026 = new class190[16][128];
   @ObfuscatedName("x")
   XHashTable field3027 = new XHashTable(128);
   @ObfuscatedName("d")
   int[] field3028 = new int[16];
   @ObfuscatedName("f")
   int[] field3029 = new int[16];
   @ObfuscatedName("z")
   int[] field3030 = new int[16];
   @ObfuscatedName("c")
   int[] field3031 = new int[16];
   @ObfuscatedName("n")
   int[] field3032 = new int[16];
   @ObfuscatedName("v")
   int[] field3033 = new int[16];
   @ObfuscatedName("k")
   int[] field3034 = new int[16];
   @ObfuscatedName("w")
   int[] field3035 = new int[16];
   @ObfuscatedName("i")
   int[] field3036 = new int[16];
   @ObfuscatedName("ah")
   class190[][] field3037 = new class190[16][128];
   @ObfuscatedName("an")
   class185 field3038 = new class185();
   @ObfuscatedName("ag")
   boolean field3039;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 468308995
   )
   int field3040;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 956551549
   )
   int field3041;
   @ObfuscatedName("p")
   int[] field3042 = new int[16];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -7255375859046522455L
   )
   long field3043;
   @ObfuscatedName("ap")
   class189 field3044 = new class189(this);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "255"
   )
   public synchronized void method3617(int var1) {
      this.field3019 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-7"
   )
   public int method3618() {
      return this.field3019;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;IB)Z",
      garbageValue = "1"
   )
   public synchronized boolean method3619(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3531();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2979.method3821(); var7 != null; var7 = (class200)var1.field2979.method3822()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3027.method3830((long)var8);
         if(null == var9) {
            var9 = GroundObject.method2220(var2, var8);
            if(null == var9) {
               var5 = false;
               continue;
            }

            this.field3027.method3819(var9, (long)var8);
         }

         if(!var9.method3549(var3, var7.field3151, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3533();
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-68"
   )
   public synchronized void method3621() {
      for(class184 var1 = (class184)this.field3027.method3821(); null != var1; var1 = (class184)this.field3027.method3822()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZI)V",
      garbageValue = "-473596370"
   )
   public synchronized void method3622(class183 var1, boolean var2) {
      this.method3670();
      this.field3038.method3554(var1.field2980);
      this.field3039 = var2;
      this.field3018 = 0L;
      int var3 = this.field3038.method3557();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3038.method3558(var4);
         this.field3038.method3559(var4);
         this.field3038.method3564(var4);
      }

      this.field3040 = this.field3038.method3566();
      this.field3041 = this.field3038.field2994[this.field3040];
      this.field3043 = this.field3038.method3565(this.field3041);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1462493533"
   )
   public synchronized boolean method3624() {
      return this.field3038.method3556();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-62"
   )
   public synchronized void method3625(int var1, int var2) {
      this.method3626(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "335522815"
   )
   void method3626(int var1, int var2) {
      this.field3024[var1] = var2;
      this.field3042[var1] = var2 & -128;
      this.method3654(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZI)V",
      garbageValue = "-173708208"
   )
   void method3629(class190 var1, boolean var2) {
      int var3 = var1.field3069.field1275.length;
      int var4;
      if(var2 && var1.field3069.field1274) {
         int var5 = var3 + var3 - var1.field3069.field1276;
         var4 = (int)((long)var5 * (long)this.field3023[var1.field3070] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3067.method1352();
         }
      } else {
         var4 = (int)((long)this.field3023[var1.field3070] * (long)var3 >> 6);
      }

      var1.field3067.method1387(var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-22"
   )
   void method3631(int var1, int var2, int var3) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method3632(int var1, int var2) {
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method3633(int var1, int var2) {
      this.field3029[var1] = var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "130999259"
   )
   void method3634(int var1) {
      for(class190 var2 = (class190)this.field3044.field3060.method3850(); null != var2; var2 = (class190)this.field3044.field3060.method3852()) {
         if(var1 < 0 || var1 == var2.field3070) {
            if(var2.field3067 != null) {
               var2.field3067.method1356(class59.field1228 / 100);
               if(var2.field3067.method1360()) {
                  this.field3044.field3059.method1179(var2.field3067);
               }

               var2.method3768();
            }

            if(var2.field3076 < 0) {
               this.field3026[var2.field3070][var2.field3080] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "7844"
   )
   void method3635(int var1) {
      if(var1 >= 0) {
         this.field3030[var1] = 12800;
         this.field3036[var1] = 8192;
         this.field3022[var1] = 16383;
         this.field3029[var1] = 8192;
         this.field3028[var1] = 0;
         this.field3033[var1] = 8192;
         this.method3638(var1);
         this.method3639(var1);
         this.field3021[var1] = 0;
         this.field3031[var1] = 32767;
         this.field3032[var1] = 256;
         this.field3023[var1] = 0;
         this.method3727(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3635(var1);
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1421188843"
   )
   void method3637() {
      this.method3634(-1);
      this.method3635(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3025[var1] = this.field3024[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3042[var1] = this.field3024[var1] & -128;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "24"
   )
   void method3638(int var1) {
      if((this.field3021[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3044.field3060.method3850(); var2 != null; var2 = (class190)this.field3044.field3060.method3852()) {
            if(var1 == var2.field3070 && this.field3026[var1][var2.field3080] == null && var2.field3076 < 0) {
               var2.field3076 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1703894951"
   )
   void method3639(int var1) {
      if((this.field3021[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3044.field3060.method3850(); null != var2; var2 = (class190)this.field3044.field3060.method3852()) {
            if(var2.field3070 == var1) {
               var2.field3082 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "651189779"
   )
   void method3640(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3709(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3673(var3, var4, var5);
         } else {
            this.method3709(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3631(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3042[var3] = (var5 << 14) + (this.field3042[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3042[var3] = (var5 << 7) + (this.field3042[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3028[var3] = (var5 << 7) + (this.field3028[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3028[var3] = var5 + (this.field3028[var3] & -128);
         }

         if(var4 == 5) {
            this.field3033[var3] = (var5 << 7) + (this.field3033[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3033[var3] = (this.field3033[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field3030[var3] = (var5 << 7) + (this.field3030[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3030[var3] = (this.field3030[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field3036[var3] = (var5 << 7) + (this.field3036[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3036[var3] = var5 + (this.field3036[var3] & -128);
         }

         if(var4 == 11) {
            this.field3022[var3] = (var5 << 7) + (this.field3022[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3022[var3] = var5 + (this.field3022[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3021[var3] |= 1;
            } else {
               this.field3021[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3021[var3] |= 2;
            } else {
               this.method3638(var3);
               this.field3021[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3031[var3] = (this.field3031[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field3031[var3] = var5 + (this.field3031[var3] & 16256);
         }

         if(var4 == 101) {
            this.field3031[var3] = (this.field3031[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3031[var3] = var5 + (this.field3031[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3634(var3);
         }

         if(var4 == 121) {
            this.method3635(var3);
         }

         if(var4 == 123) {
            this.method3725(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3032[var3] = (var5 << 7) + (this.field3032[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3032[var3] = (this.field3032[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field3023[var3] = (var5 << 7) + (this.field3023[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3023[var3] = (this.field3023[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3021[var3] |= 4;
            } else {
               this.method3639(var3);
               this.field3021[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3727(var3, (this.field3034[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3727(var3, var5 + (this.field3034[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3654(var3, var4 + this.field3042[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3632(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3633(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3637();
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "2140158458"
   )
   int method3642(class190 var1) {
      int var2 = (var1.field3071 * var1.field3064 >> 12) + var1.field3062;
      var2 += (this.field3029[var1.field3070] - 8192) * this.field3032[var1.field3070] >> 12;
      class188 var3 = var1.field3065;
      int var4;
      if(var3.field3053 > 0 && (var3.field3052 > 0 || this.field3028[var1.field3070] > 0)) {
         var4 = var3.field3052 << 2;
         int var5 = var3.field3054 << 1;
         if(var1.field3078 < var5) {
            var4 = var1.field3078 * var4 / var5;
         }

         var4 += this.field3028[var1.field3070] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3079 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field3069.field1277) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class59.field1228 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "-71"
   )
   int method3643(class190 var1) {
      class188 var2 = var1.field3065;
      int var3 = this.field3030[var1.field3070] * this.field3022[var1.field3070] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field3068 + 16384 >> 15;
      var3 = 128 + var3 * this.field3019 >> 8;
      if(var2.field3048 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3073 * 1.953125E-5D * (double)var2.field3048) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3047) {
         var4 = var1.field3074;
         var5 = var2.field3047[1 + var1.field3075];
         if(var1.field3075 < var2.field3047.length - 2) {
            var6 = (var2.field3047[var1.field3075] & 255) << 8;
            var7 = (var2.field3047[2 + var1.field3075] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3047[var1.field3075 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3076 > 0 && null != var2.field3046) {
         var4 = var1.field3076;
         var5 = var2.field3046[1 + var1.field3077];
         if(var1.field3077 < var2.field3046.length - 2) {
            var6 = (var2.field3046[var1.field3077] & 255) << 8;
            var7 = (var2.field3046[2 + var1.field3077] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3046[var1.field3077 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "1128020928"
   )
   int method3644(class190 var1) {
      int var2 = this.field3036[var1.field3070];
      return var2 < 8192?var1.field3072 * var2 + 32 >> 6:16384 - (32 + (128 - var1.field3072) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("b")
   protected synchronized class69 vmethod3753() {
      return this.field3044;
   }

   @ObfuscatedName("p")
   protected synchronized void vmethod3748(int[] var1, int var2, int var3) {
      if(this.field3038.method3556()) {
         int var4 = this.field3020 * this.field3038.field2993 / class59.field1228;

         do {
            long var5 = this.field3018 + (long)var3 * (long)var4;
            if(this.field3043 - var5 >= 0L) {
               this.field3018 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3043 - this.field3018) - 1L) / (long)var4);
            this.field3018 += (long)var4 * (long)var7;
            this.field3044.vmethod3748(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3738();
         } while(this.field3038.method3556());
      }

      this.field3044.vmethod3748(var1, var2, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-632550907"
   )
   public synchronized void method3650() {
      for(class184 var1 = (class184)this.field3027.method3821(); null != var1; var1 = (class184)this.field3027.method3822()) {
         var1.method3541();
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "314941801"
   )
   boolean method3652(class190 var1, int[] var2, int var3, int var4) {
      var1.field3081 = class59.field1228 / 100;
      if(var1.field3076 < 0 || var1.field3067 != null && !var1.field3067.method1359()) {
         int var5 = var1.field3064;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3033[var1.field3070] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3064 = var5;
         }

         var1.field3067.method1357(this.method3642(var1));
         class188 var6 = var1.field3065;
         boolean var7 = false;
         ++var1.field3078;
         var1.field3079 += var6.field3053;
         double var8 = (double)((var1.field3080 - 60 << 8) + (var1.field3071 * var1.field3064 >> 12)) * 5.086263020833333E-6D;
         if(var6.field3048 > 0) {
            if(var6.field3051 > 0) {
               var1.field3073 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3051) + 0.5D);
            } else {
               var1.field3073 += 128;
            }
         }

         if(null != var6.field3047) {
            if(var6.field3055 > 0) {
               var1.field3074 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3055) + 0.5D);
            } else {
               var1.field3074 += 128;
            }

            while(var1.field3075 < var6.field3047.length - 2 && var1.field3074 > (var6.field3047[2 + var1.field3075] & 255) << 8) {
               var1.field3075 += 2;
            }

            if(var6.field3047.length - 2 == var1.field3075 && var6.field3047[var1.field3075 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3076 >= 0 && null != var6.field3046 && (this.field3021[var1.field3070] & 1) == 0 && (var1.field3066 < 0 || this.field3037[var1.field3070][var1.field3066] != var1)) {
            if(var6.field3050 > 0) {
               var1.field3076 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3050 * var8) + 0.5D);
            } else {
               var1.field3076 += 128;
            }

            while(var1.field3077 < var6.field3046.length - 2 && var1.field3076 > (var6.field3046[var1.field3077 + 2] & 255) << 8) {
               var1.field3077 += 2;
            }

            if(var1.field3077 == var6.field3046.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3067.method1356(var1.field3081);
            if(null != var2) {
               var1.field3067.vmethod3748(var2, var3, var4);
            } else {
               var1.field3067.vmethod3749(var4);
            }

            if(var1.field3067.method1360()) {
               this.field3044.field3059.method1179(var1.field3067);
            }

            var1.method3768();
            if(var1.field3076 >= 0) {
               var1.unlink();
               if(var1.field3066 > 0 && this.field3037[var1.field3070][var1.field3066] == var1) {
                  this.field3037[var1.field3070][var1.field3066] = null;
               }
            }

            return true;
         } else {
            var1.field3067.method1355(var1.field3081, this.method3643(var1), this.method3644(var1));
            return false;
         }
      } else {
         var1.method3768();
         var1.unlink();
         if(var1.field3066 > 0 && this.field3037[var1.field3070][var1.field3066] == var1) {
            this.field3037[var1.field3070][var1.field3066] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "111794168"
   )
   void method3654(int var1, int var2) {
      if(var2 != this.field3025[var1]) {
         this.field3025[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3037[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "68427373"
   )
   boolean method3657(class190 var1) {
      if(null == var1.field3067) {
         if(var1.field3076 >= 0) {
            var1.unlink();
            if(var1.field3066 > 0 && var1 == this.field3037[var1.field3070][var1.field3066]) {
               this.field3037[var1.field3070][var1.field3066] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "511676410"
   )
   public synchronized void method3670() {
      this.field3038.method3567();
      this.method3637();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-974839192"
   )
   void method3673(int var1, int var2, int var3) {
      this.method3709(var1, var2, 64);
      if((this.field3021[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3044.field3060.method3867(); null != var4; var4 = (class190)this.field3044.field3060.method3853()) {
            if(var1 == var4.field3070 && var4.field3076 < 0) {
               this.field3026[var1][var4.field3080] = null;
               this.field3026[var1][var2] = var4;
               int var8 = var4.field3062 + (var4.field3064 * var4.field3071 >> 12);
               var4.field3062 += var2 - var4.field3080 << 8;
               var4.field3071 = var8 - var4.field3062;
               var4.field3064 = 4096;
               var4.field3080 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3027.method3830((long)this.field3025[var1]);
      if(null != var9) {
         class65 var5 = var9.field2982[var2];
         if(null != var5) {
            class190 var6 = new class190();
            var6.field3070 = var1;
            var6.field3063 = var9;
            var6.field3069 = var5;
            var6.field3065 = var9.field2986[var2];
            var6.field3066 = var9.field2983[var2];
            var6.field3080 = var2;
            var6.field3068 = var9.field2985[var2] * var3 * var3 * var9.field2984 + 1024 >> 11;
            var6.field3072 = var9.field2981[var2] & 255;
            var6.field3062 = (var2 << 8) - (var9.field2989[var2] & 32767);
            var6.field3073 = 0;
            var6.field3074 = 0;
            var6.field3075 = 0;
            var6.field3076 = -1;
            var6.field3077 = 0;
            if(this.field3023[var1] == 0) {
               var6.field3067 = class67.method1343(var5, this.method3642(var6), this.method3643(var6), this.method3644(var6));
            } else {
               var6.field3067 = class67.method1343(var5, this.method3642(var6), 0, this.method3644(var6));
               this.method3629(var6, var9.field2989[var2] < 0);
            }

            if(var9.field2989[var2] < 0) {
               var6.field3067.method1345(-1);
            }

            if(var6.field3066 >= 0) {
               class190 var7 = this.field3037[var1][var6.field3066];
               if(var7 != null && var7.field3076 < 0) {
                  this.field3026[var1][var7.field3080] = null;
                  var7.field3076 = 0;
               }

               this.field3037[var1][var6.field3066] = var6;
            }

            this.field3044.field3060.method3844(var6);
            this.field3026[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3749(int var1) {
      if(this.field3038.method3556()) {
         int var2 = this.field3020 * this.field3038.field2993 / class59.field1228;

         do {
            long var3 = this.field3018 + (long)var1 * (long)var2;
            if(this.field3043 - var3 >= 0L) {
               this.field3018 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3043 - this.field3018) - 1L) / (long)var2);
            this.field3018 += (long)var2 * (long)var5;
            this.field3044.vmethod3749(var5);
            var1 -= var5;
            this.method3738();
         } while(this.field3038.method3556());
      }

      this.field3044.vmethod3749(var1);
   }

   @ObfuscatedName("m")
   protected synchronized int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("l")
   protected synchronized class69 vmethod3746() {
      return null;
   }

   public class187() {
      this.method3637();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "98"
   )
   void method3709(int var1, int var2, int var3) {
      class190 var4 = this.field3026[var1][var2];
      if(null != var4) {
         this.field3026[var1][var2] = null;
         if((this.field3021[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3044.field3060.method3850(); var5 != null; var5 = (class190)this.field3044.field3060.method3852()) {
               if(var5.field3070 == var4.field3070 && var5.field3076 < 0 && var4 != var5) {
                  var4.field3076 = 0;
                  break;
               }
            }
         } else {
            var4.field3076 = 0;
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "148125153"
   )
   void method3725(int var1) {
      for(class190 var2 = (class190)this.field3044.field3060.method3850(); null != var2; var2 = (class190)this.field3044.field3060.method3852()) {
         if((var1 < 0 || var2.field3070 == var1) && var2.field3076 < 0) {
            this.field3026[var2.field3070][var2.field3080] = null;
            var2.field3076 = 0;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1742500851"
   )
   void method3727(int var1, int var2) {
      this.field3034[var1] = var2;
      this.field3035[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1217868776"
   )
   void method3738() {
      int var1 = this.field3040;
      int var2 = this.field3041;

      long var3;
      for(var3 = this.field3043; var2 == this.field3041; var3 = this.field3038.method3565(var2)) {
         while(var2 == this.field3038.field2994[var1]) {
            this.field3038.method3558(var1);
            int var5 = this.field3038.method3562(var1);
            if(var5 == 1) {
               this.field3038.method3576();
               this.field3038.method3564(var1);
               if(this.field3038.method3587()) {
                  if(!this.field3039 || var2 == 0) {
                     this.method3637();
                     this.field3038.method3567();
                     return;
                  }

                  this.field3038.method3568(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3640(var5);
            }

            this.field3038.method3559(var1);
            this.field3038.method3564(var1);
         }

         var1 = this.field3038.method3566();
         var2 = this.field3038.field2994[var1];
      }

      this.field3040 = var1;
      this.field3041 = var2;
      this.field3043 = var3;
   }
}
