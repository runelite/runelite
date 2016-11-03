import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class187 extends class69 {
   @ObfuscatedName("ay")
   class189 field3015 = new class189(this);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -881856239
   )
   int field3016 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -858489141
   )
   int field3017 = 1000000;
   @ObfuscatedName("c")
   int[] field3018 = new int[16];
   @ObfuscatedName("v")
   int[] field3019 = new int[16];
   @ObfuscatedName("j")
   int[] field3020 = new int[16];
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -175855653
   )
   int field3021;
   @ObfuscatedName("o")
   class190[][] field3022 = new class190[16][128];
   @ObfuscatedName("u")
   int[] field3023 = new int[16];
   @ObfuscatedName("h")
   int[] field3024 = new int[16];
   @ObfuscatedName("b")
   int[] field3025 = new int[16];
   @ObfuscatedName("k")
   XHashTable field3026 = new XHashTable(128);
   @ObfuscatedName("al")
   class185 field3027 = new class185();
   @ObfuscatedName("n")
   int[] field3028 = new int[16];
   @ObfuscatedName("z")
   int[] field3029 = new int[16];
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1616652333
   )
   int field3030;
   @ObfuscatedName("d")
   int[] field3031 = new int[16];
   @ObfuscatedName("t")
   int[] field3032 = new int[16];
   @ObfuscatedName("l")
   int[] field3033 = new int[16];
   @ObfuscatedName("aq")
   class190[][] field3034 = new class190[16][128];
   @ObfuscatedName("a")
   int[] field3035 = new int[16];
   @ObfuscatedName("av")
   boolean field3036;
   @ObfuscatedName("x")
   int[] field3037 = new int[16];
   @ObfuscatedName("m")
   int[] field3038 = new int[16];
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = -3757748080783321395L
   )
   long field3039;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -2620597028786115707L
   )
   long field3041;
   @ObfuscatedName("y")
   int[] field3042 = new int[16];

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-369114608"
   )
   void method3638(int var1, int var2) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3631"
   )
   public synchronized void method3639(int var1) {
      this.field3016 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2110775361"
   )
   public int method3640() {
      return this.field3016;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "1643263364"
   )
   synchronized boolean method3641(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3544();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2978.method3825(); var7 != null; var7 = (class200)var1.field2978.method3826()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3026.method3828((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3310(var8);
            class184 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class184(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field3026.method3822(var10, (long)var8);
         }

         if(!var9.method3556(var3, var7.field3144, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3545();
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1429344523"
   )
   synchronized void method3642() {
      for(class184 var1 = (class184)this.field3026.method3825(); null != var1; var1 = (class184)this.field3026.method3826()) {
         var1.method3557();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-69344012"
   )
   public synchronized boolean method3646() {
      return this.field3027.method3566();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public synchronized void method3647(int var1, int var2) {
      this.method3648(var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1100136604"
   )
   void method3648(int var1, int var2) {
      this.field3038[var1] = var2;
      this.field3023[var1] = var2 & -128;
      this.method3649(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1053164612"
   )
   void method3649(int var1, int var2) {
      if(var2 != this.field3042[var1]) {
         this.field3042[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3034[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1321958646"
   )
   void method3650(int var1, int var2, int var3) {
      this.method3652(var1, var2, 64);
      if((this.field3035[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3015.field3055.method3852(); var4 != null; var4 = (class190)this.field3015.field3055.method3856()) {
            if(var4.field3071 == var1 && var4.field3061 < 0) {
               this.field3022[var1][var4.field3063] = null;
               this.field3022[var1][var2] = var4;
               int var5 = var4.field3066 + (var4.field3080 * var4.field3068 >> 12);
               var4.field3066 += var2 - var4.field3063 << 8;
               var4.field3080 = var5 - var4.field3066;
               var4.field3068 = 4096;
               var4.field3063 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3026.method3828((long)this.field3042[var1]);
      if(null != var9) {
         class65 var8 = var9.field2981[var2];
         if(var8 != null) {
            class190 var6 = new class190();
            var6.field3071 = var1;
            var6.field3059 = var9;
            var6.field3060 = var8;
            var6.field3058 = var9.field2985[var2];
            var6.field3062 = var9.field2984[var2];
            var6.field3063 = var2;
            var6.field3072 = var3 * var3 * var9.field2986 * var9.field2983[var2] + 1024 >> 11;
            var6.field3064 = var9.field2980[var2] & 255;
            var6.field3066 = (var2 << 8) - (var9.field2982[var2] & 32767);
            var6.field3069 = 0;
            var6.field3070 = 0;
            var6.field3065 = 0;
            var6.field3061 = -1;
            var6.field3067 = 0;
            if(this.field3037[var1] == 0) {
               var6.field3076 = class67.method1463(var8, this.method3743(var6), this.method3726(var6), this.method3666(var6));
            } else {
               var6.field3076 = class67.method1463(var8, this.method3743(var6), 0, this.method3666(var6));
               this.method3725(var6, var9.field2982[var2] < 0);
            }

            if(var9.field2982[var2] < 0) {
               var6.field3076.method1347(-1);
            }

            if(var6.field3062 >= 0) {
               class190 var7 = this.field3034[var1][var6.field3062];
               if(null != var7 && var7.field3061 < 0) {
                  this.field3022[var1][var7.field3063] = null;
                  var7.field3061 = 0;
               }

               this.field3034[var1][var6.field3062] = var6;
            }

            this.field3015.field3055.method3844(var6);
            this.field3022[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1190035358"
   )
   void method3652(int var1, int var2, int var3) {
      class190 var4 = this.field3022[var1][var2];
      if(var4 != null) {
         this.field3022[var1][var2] = null;
         if((this.field3035[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3015.field3055.method3864(); null != var5; var5 = (class190)this.field3015.field3055.method3851()) {
               if(var5.field3071 == var4.field3071 && var5.field3061 < 0 && var5 != var4) {
                  var4.field3061 = 0;
                  break;
               }
            }
         } else {
            var4.field3061 = 0;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2079104972"
   )
   void method3653(int var1, int var2, int var3) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "325426906"
   )
   void method3655(int var1, int var2) {
      this.field3024[var1] = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1054251106"
   )
   void method3658(int var1) {
      for(class190 var2 = (class190)this.field3015.field3055.method3864(); null != var2; var2 = (class190)this.field3015.field3055.method3851()) {
         if((var1 < 0 || var2.field3071 == var1) && var2.field3061 < 0) {
            this.field3022[var2.field3071][var2.field3063] = null;
            var2.field3061 = 0;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   void method3659() {
      this.method3738(-1);
      this.method3703(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3042[var1] = this.field3038[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3023[var1] = this.field3038[var1] & -128;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-55297837"
   )
   void method3662(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3652(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3650(var3, var4, var5);
         } else {
            this.method3652(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3653(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3023[var3] = (var5 << 14) + (this.field3023[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3023[var3] = (var5 << 7) + (this.field3023[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3033[var3] = (var5 << 7) + (this.field3033[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3033[var3] = var5 + (this.field3033[var3] & -128);
         }

         if(var4 == 5) {
            this.field3025[var3] = (var5 << 7) + (this.field3025[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3025[var3] = (this.field3025[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field3018[var3] = (this.field3018[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field3018[var3] = var5 + (this.field3018[var3] & -128);
         }

         if(var4 == 10) {
            this.field3019[var3] = (this.field3019[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field3019[var3] = var5 + (this.field3019[var3] & -128);
         }

         if(var4 == 11) {
            this.field3020[var3] = (var5 << 7) + (this.field3020[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3020[var3] = var5 + (this.field3020[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3035[var3] |= 1;
            } else {
               this.field3035[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3035[var3] |= 2;
            } else {
               this.method3740(var3);
               this.field3035[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3028[var3] = (var5 << 7) + (this.field3028[var3] & 127);
         }

         if(var4 == 98) {
            this.field3028[var3] = var5 + (this.field3028[var3] & 16256);
         }

         if(var4 == 101) {
            this.field3028[var3] = (var5 << 7) + (this.field3028[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field3028[var3] = (this.field3028[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method3738(var3);
         }

         if(var4 == 121) {
            this.method3703(var3);
         }

         if(var4 == 123) {
            this.method3658(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3028[var3];
            if(var6 == 16384) {
               this.field3029[var3] = (var5 << 7) + (this.field3029[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3028[var3];
            if(var6 == 16384) {
               this.field3029[var3] = var5 + (this.field3029[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field3037[var3] = (var5 << 7) + (this.field3037[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3037[var3] = var5 + (this.field3037[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3035[var3] |= 4;
            } else {
               this.method3677(var3);
               this.field3035[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3663(var3, (var5 << 7) + (this.field3031[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3663(var3, (this.field3031[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3649(var3, var4 + this.field3023[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3638(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3655(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3659();
         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "81"
   )
   void method3663(int var1, int var2) {
      this.field3031[var1] = var2;
      this.field3032[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "1761763468"
   )
   int method3666(class190 var1) {
      int var2 = this.field3019[var1.field3071];
      return var2 < 8192?32 + var1.field3064 * var2 >> 6:16384 - (32 + (128 - var1.field3064) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("j")
   protected synchronized class69 vmethod3751() {
      return this.field3015;
   }

   @ObfuscatedName("m")
   protected synchronized class69 vmethod3755() {
      return null;
   }

   @ObfuscatedName("y")
   protected synchronized int vmethod3758() {
      return 0;
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod3766(int[] var1, int var2, int var3) {
      if(this.field3027.method3566()) {
         int var4 = this.field3017 * this.field3027.field2992 / class59.field1249;

         do {
            long var5 = this.field3039 + (long)var4 * (long)var3;
            if(this.field3041 - var5 >= 0L) {
               this.field3039 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3041 - this.field3039) - 1L) / (long)var4);
            this.field3039 += (long)var4 * (long)var7;
            this.field3015.vmethod3766(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3672();
         } while(this.field3027.method3566());
      }

      this.field3015.vmethod3766(var1, var2, var3);
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3754(int var1) {
      if(this.field3027.method3566()) {
         int var2 = this.field3027.field2992 * this.field3017 / class59.field1249;

         do {
            long var3 = this.field3039 + (long)var2 * (long)var1;
            if(this.field3041 - var3 >= 0L) {
               this.field3039 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3041 - this.field3039) - 1L) / (long)var2);
            this.field3039 += (long)var2 * (long)var5;
            this.field3015.vmethod3754(var5);
            var1 -= var5;
            this.method3672();
         } while(this.field3027.method3566());
      }

      this.field3015.vmethod3754(var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-469014562"
   )
   void method3672() {
      int var1 = this.field3021;
      int var2 = this.field3030;

      long var3;
      for(var3 = this.field3041; this.field3030 == var2; var3 = this.field3027.method3575(var2)) {
         while(var2 == this.field3027.field2998[var1]) {
            this.field3027.method3591(var1);
            int var5 = this.field3027.method3572(var1);
            if(var5 == 1) {
               this.field3027.method3570();
               this.field3027.method3569(var1);
               if(this.field3027.method3584()) {
                  if(!this.field3036 || var2 == 0) {
                     this.method3659();
                     this.field3027.method3565();
                     return;
                  }

                  this.field3027.method3578(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3662(var5);
            }

            this.field3027.method3571(var1);
            this.field3027.method3569(var1);
         }

         var1 = this.field3027.method3592();
         var2 = this.field3027.field2998[var1];
      }

      this.field3021 = var1;
      this.field3030 = var2;
      this.field3041 = var3;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)Z",
      garbageValue = "-7"
   )
   boolean method3673(class190 var1) {
      if(var1.field3076 == null) {
         if(var1.field3061 >= 0) {
            var1.unlink();
            if(var1.field3062 > 0 && this.field3034[var1.field3071][var1.field3062] == var1) {
               this.field3034[var1.field3071][var1.field3062] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIB)Z",
      garbageValue = "60"
   )
   boolean method3674(class190 var1, int[] var2, int var3, int var4) {
      var1.field3077 = class59.field1249 / 100;
      if(var1.field3061 < 0 || var1.field3076 != null && !var1.field3076.method1361()) {
         int var5 = var1.field3068;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field3025[var1.field3071]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3068 = var5;
         }

         var1.field3076.method1359(this.method3743(var1));
         class188 var6 = var1.field3058;
         boolean var7 = false;
         ++var1.field3074;
         var1.field3075 += var6.field3046;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3080 * var1.field3068 >> 12) + (var1.field3063 - 60 << 8));
         if(var6.field3047 > 0) {
            if(var6.field3050 > 0) {
               var1.field3069 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3050) + 0.5D);
            } else {
               var1.field3069 += 128;
            }
         }

         if(null != var6.field3054) {
            if(var6.field3048 > 0) {
               var1.field3070 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3048 * var8) + 0.5D);
            } else {
               var1.field3070 += 128;
            }

            while(var1.field3065 < var6.field3054.length - 2 && var1.field3070 > (var6.field3054[2 + var1.field3065] & 255) << 8) {
               var1.field3065 += 2;
            }

            if(var1.field3065 == var6.field3054.length - 2 && var6.field3054[1 + var1.field3065] == 0) {
               var7 = true;
            }
         }

         if(var1.field3061 >= 0 && null != var6.field3045 && (this.field3035[var1.field3071] & 1) == 0 && (var1.field3062 < 0 || var1 != this.field3034[var1.field3071][var1.field3062])) {
            if(var6.field3049 > 0) {
               var1.field3061 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3049) + 0.5D);
            } else {
               var1.field3061 += 128;
            }

            while(var1.field3067 < var6.field3045.length - 2 && var1.field3061 > (var6.field3045[var1.field3067 + 2] & 255) << 8) {
               var1.field3067 += 2;
            }

            if(var6.field3045.length - 2 == var1.field3067) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3076.method1358(var1.field3077);
            if(var2 != null) {
               var1.field3076.vmethod3766(var2, var3, var4);
            } else {
               var1.field3076.vmethod3754(var4);
            }

            if(var1.field3076.method1394()) {
               this.field3015.field3057.method1176(var1.field3076);
            }

            var1.method3774();
            if(var1.field3061 >= 0) {
               var1.unlink();
               if(var1.field3062 > 0 && this.field3034[var1.field3071][var1.field3062] == var1) {
                  this.field3034[var1.field3071][var1.field3062] = null;
               }
            }

            return true;
         } else {
            var1.field3076.method1357(var1.field3077, this.method3726(var1), this.method3666(var1));
            return false;
         }
      } else {
         var1.method3774();
         var1.unlink();
         if(var1.field3062 > 0 && var1 == this.field3034[var1.field3071][var1.field3062]) {
            this.field3034[var1.field3071][var1.field3062] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1216062624"
   )
   void method3677(int var1) {
      if((this.field3035[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3015.field3055.method3864(); var2 != null; var2 = (class190)this.field3015.field3055.method3851()) {
            if(var1 == var2.field3071) {
               var2.field3078 = 0;
            }
         }
      }

   }

   public class187() {
      this.method3659();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZB)V",
      garbageValue = "7"
   )
   synchronized void method3702(class183 var1, boolean var2) {
      this.method3735();
      this.field3027.method3564(var1.field2979);
      this.field3036 = var2;
      this.field3039 = 0L;
      int var3 = this.field3027.method3567();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3027.method3591(var4);
         this.field3027.method3571(var4);
         this.field3027.method3569(var4);
      }

      this.field3021 = this.field3027.method3592();
      this.field3030 = this.field3027.field2998[this.field3021];
      this.field3041 = this.field3027.method3575(this.field3030);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "100"
   )
   void method3703(int var1) {
      if(var1 >= 0) {
         this.field3018[var1] = 12800;
         this.field3019[var1] = 8192;
         this.field3020[var1] = 16383;
         this.field3024[var1] = 8192;
         this.field3033[var1] = 0;
         this.field3025[var1] = 8192;
         this.method3740(var1);
         this.method3677(var1);
         this.field3035[var1] = 0;
         this.field3028[var1] = 32767;
         this.field3029[var1] = 256;
         this.field3037[var1] = 0;
         this.method3663(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3703(var1);
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-743154966"
   )
   public synchronized void method3721() {
      for(class184 var1 = (class184)this.field3026.method3825(); null != var1; var1 = (class184)this.field3026.method3826()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZB)V",
      garbageValue = "-9"
   )
   void method3725(class190 var1, boolean var2) {
      int var3 = var1.field3060.field1292.length;
      int var4;
      if(var2 && var1.field3060.field1293) {
         int var5 = var3 + var3 - var1.field3060.field1291;
         var4 = (int)((long)var5 * (long)this.field3037[var1.field3071] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3076.method1354();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field3037[var1.field3071] >> 6);
      }

      var1.field3076.method1353(var4);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "671639599"
   )
   int method3726(class190 var1) {
      class188 var2 = var1.field3058;
      int var3 = this.field3018[var1.field3071] * this.field3020[var1.field3071] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field3072 + 16384 >> 15;
      var3 = 128 + this.field3016 * var3 >> 8;
      if(var2.field3047 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3069 * 1.953125E-5D * (double)var2.field3047) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field3054 != null) {
         var4 = var1.field3070;
         var5 = var2.field3054[1 + var1.field3065];
         if(var1.field3065 < var2.field3054.length - 2) {
            var6 = (var2.field3054[var1.field3065] & 255) << 8;
            var7 = (var2.field3054[2 + var1.field3065] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3054[var1.field3065 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field3061 > 0 && null != var2.field3045) {
         var4 = var1.field3061;
         var5 = var2.field3045[var1.field3067 + 1];
         if(var1.field3067 < var2.field3045.length - 2) {
            var6 = (var2.field3045[var1.field3067] & 255) << 8;
            var7 = (var2.field3045[2 + var1.field3067] & 255) << 8;
            var5 += (var2.field3045[3 + var1.field3067] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1697505442"
   )
   public synchronized void method3735() {
      this.field3027.method3565();
      this.method3659();
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1446969619"
   )
   static boolean method3736(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class112.method2486(var0, class43.field996);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class112.method2486(var3.name, class43.field996))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class112.method2486(var3.previousName, class43.field996))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "448921577"
   )
   void method3738(int var1) {
      for(class190 var2 = (class190)this.field3015.field3055.method3864(); var2 != null; var2 = (class190)this.field3015.field3055.method3851()) {
         if(var1 < 0 || var1 == var2.field3071) {
            if(null != var2.field3076) {
               var2.field3076.method1358(class59.field1249 / 100);
               if(var2.field3076.method1394()) {
                  this.field3015.field3057.method1176(var2.field3076);
               }

               var2.method3774();
            }

            if(var2.field3061 < 0) {
               this.field3022[var2.field3071][var2.field3063] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   void method3740(int var1) {
      if((this.field3035[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3015.field3055.method3864(); var2 != null; var2 = (class190)this.field3015.field3055.method3851()) {
            if(var2.field3071 == var1 && null == this.field3022[var1][var2.field3063] && var2.field3061 < 0) {
               var2.field3061 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "-13"
   )
   int method3743(class190 var1) {
      int var2 = (var1.field3068 * var1.field3080 >> 12) + var1.field3066;
      var2 += (this.field3024[var1.field3071] - 8192) * this.field3029[var1.field3071] >> 12;
      class188 var3 = var1.field3058;
      int var4;
      if(var3.field3046 > 0 && (var3.field3051 > 0 || this.field3033[var1.field3071] > 0)) {
         var4 = var3.field3051 << 2;
         int var5 = var3.field3053 << 1;
         if(var1.field3074 < var5) {
            var4 = var1.field3074 * var4 / var5;
         }

         var4 += this.field3033[var1.field3071] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3075 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field3060.field1290) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class59.field1249 + 0.5D);
      return var4 < 1?1:var4;
   }
}
