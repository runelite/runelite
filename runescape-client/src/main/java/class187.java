import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class187 extends class69 {
   @ObfuscatedName("j")
   int[] field3013 = new int[16];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 128394509
   )
   int field3014 = 256;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1912152473
   )
   int field3015;
   @ObfuscatedName("m")
   class199 field3016 = new class199(128);
   @ObfuscatedName("l")
   int[] field3017 = new int[16];
   @ObfuscatedName("t")
   int[] field3018 = new int[16];
   @ObfuscatedName("q")
   int[] field3019 = new int[16];
   @ObfuscatedName("x")
   int[] field3020 = new int[16];
   @ObfuscatedName("g")
   int[] field3021 = new int[16];
   @ObfuscatedName("v")
   int[] field3022 = new int[16];
   @ObfuscatedName("h")
   int[] field3023 = new int[16];
   @ObfuscatedName("u")
   int[] field3024 = new int[16];
   @ObfuscatedName("ax")
   class189 field3025 = new class189(this);
   @ObfuscatedName("c")
   int[] field3026 = new int[16];
   @ObfuscatedName("z")
   int[] field3027 = new int[16];
   @ObfuscatedName("n")
   int[] field3028 = new int[16];
   @ObfuscatedName("k")
   int[] field3029 = new int[16];
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 458590867
   )
   int field3030;
   @ObfuscatedName("r")
   int[] field3031 = new int[16];
   @ObfuscatedName("aj")
   class190[][] field3032 = new class190[16][128];
   @ObfuscatedName("an")
   class185 field3033 = new class185();
   @ObfuscatedName("a")
   int[] field3034 = new int[16];
   @ObfuscatedName("b")
   class190[][] field3035 = new class190[16][128];
   @ObfuscatedName("ap")
   boolean field3036;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = 671210642904741093L
   )
   long field3037;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -7649658063127388643L
   )
   long field3038;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1029101715
   )
   int field3039 = 1000000;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1444951062"
   )
   void method3652(int var1) {
      for(class190 var2 = (class190)this.field3025.field3051.method3882(); var2 != null; var2 = (class190)this.field3025.field3051.method3891()) {
         if((var1 < 0 || var1 == var2.field3061) && var2.field3070 < 0) {
            this.field3035[var2.field3061][var2.field3067] = null;
            var2.field3070 = 0;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-98129253"
   )
   public synchronized void method3653(int var1) {
      this.field3014 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1448436267"
   )
   int method3654() {
      return this.field3014;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   public synchronized void method3656() {
      for(class184 var1 = (class184)this.field3016.method3847(); var1 != null; var1 = (class184)this.field3016.method3852()) {
         var1.method3580();
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-1793188679"
   )
   int method3657(class190 var1) {
      int var2 = var1.field3064 + (var1.field3078 * var1.field3066 >> 12);
      var2 += (this.field3022[var1.field3061] - 8192) * this.field3027[var1.field3061] >> 12;
      class188 var3 = var1.field3060;
      int var4;
      if(var3.field3041 > 0 && (var3.field3047 > 0 || this.field3023[var1.field3061] > 0)) {
         var4 = var3.field3047 << 2;
         int var5 = var3.field3046 << 1;
         if(var1.field3074 < var5) {
            var4 = var4 * var1.field3074 / var5;
         }

         var4 += this.field3023[var1.field3061] >> 7;
         double var6 = Math.sin((double)(var1.field3073 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field3059.field1306 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class59.field1268 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2071825463"
   )
   synchronized boolean method3660() {
      return this.field3033.method3588();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1008720448"
   )
   void method3662(int var1, int var2) {
      this.field3031[var1] = var2;
      this.field3029[var1] = var2 & -128;
      this.method3663(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1458058420"
   )
   void method3663(int var1, int var2) {
      if(this.field3020[var1] != var2) {
         this.field3020[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3032[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZI)V",
      garbageValue = "-394146444"
   )
   void method3665(class190 var1, boolean var2) {
      int var3 = var1.field3059.field1305.length;
      int var4;
      if(var2 && var1.field3059.field1304) {
         int var5 = var3 + var3 - var1.field3059.field1308;
         var4 = (int)((long)var5 * (long)this.field3028[var1.field3061] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3057.method1399();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field3028[var1.field3061] >> 6);
      }

      var1.field3057.method1495(var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1276984012"
   )
   void method3667(int var1, int var2, int var3) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1968403321"
   )
   void method3669(int var1, int var2) {
      this.field3022[var1] = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   void method3670(int var1) {
      for(class190 var2 = (class190)this.field3025.field3051.method3882(); var2 != null; var2 = (class190)this.field3025.field3051.method3891()) {
         if(var1 < 0 || var2.field3061 == var1) {
            if(var2.field3057 != null) {
               var2.field3057.method1403(class59.field1268 / 100);
               if(var2.field3057.method1407()) {
                  this.field3025.field3052.method1204(var2.field3057);
               }

               var2.method3797();
            }

            if(var2.field3070 < 0) {
               this.field3035[var2.field3061][var2.field3067] = null;
            }

            var2.method3990();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "40"
   )
   void method3671(int var1) {
      if(var1 >= 0) {
         this.field3021[var1] = 12800;
         this.field3017[var1] = 8192;
         this.field3013[var1] = 16383;
         this.field3022[var1] = 8192;
         this.field3023[var1] = 0;
         this.field3024[var1] = 8192;
         this.method3674(var1);
         this.method3675(var1);
         this.field3018[var1] = 0;
         this.field3026[var1] = 32767;
         this.field3027[var1] = 256;
         this.field3028[var1] = 0;
         this.method3677(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3671(var1);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   void method3673() {
      this.method3670(-1);
      this.method3671(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3020[var1] = this.field3031[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3029[var1] = this.field3031[var1] & -128;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   void method3674(int var1) {
      if((this.field3018[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3025.field3051.method3882(); null != var2; var2 = (class190)this.field3025.field3051.method3891()) {
            if(var2.field3061 == var1 && this.field3035[var1][var2.field3067] == null && var2.field3070 < 0) {
               var2.field3070 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1061186970"
   )
   void method3675(int var1) {
      if((this.field3018[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3025.field3051.method3882(); var2 != null; var2 = (class190)this.field3025.field3051.method3891()) {
            if(var2.field3061 == var1) {
               var2.field3075 = 0;
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1661883763"
   )
   void method3676(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3711(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3705(var3, var4, var5);
         } else {
            this.method3711(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3667(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3029[var3] = (var5 << 14) + (this.field3029[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3029[var3] = (var5 << 7) + (this.field3029[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3023[var3] = (var5 << 7) + (this.field3023[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3023[var3] = (this.field3023[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field3024[var3] = (this.field3024[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field3024[var3] = var5 + (this.field3024[var3] & -128);
         }

         if(var4 == 7) {
            this.field3021[var3] = (var5 << 7) + (this.field3021[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3021[var3] = (this.field3021[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field3017[var3] = (var5 << 7) + (this.field3017[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3017[var3] = (this.field3017[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field3013[var3] = (this.field3013[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field3013[var3] = (this.field3013[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3018[var3] |= 1;
            } else {
               this.field3018[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3018[var3] |= 2;
            } else {
               this.method3674(var3);
               this.field3018[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3026[var3] = (this.field3026[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field3026[var3] = (this.field3026[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field3026[var3] = (this.field3026[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3026[var3] = var5 + (this.field3026[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3670(var3);
         }

         if(var4 == 121) {
            this.method3671(var3);
         }

         if(var4 == 123) {
            this.method3652(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3026[var3];
            if(var6 == 16384) {
               this.field3027[var3] = (var5 << 7) + (this.field3027[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3026[var3];
            if(var6 == 16384) {
               this.field3027[var3] = (this.field3027[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field3028[var3] = (var5 << 7) + (this.field3028[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3028[var3] = var5 + (this.field3028[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3018[var3] |= 4;
            } else {
               this.method3675(var3);
               this.field3018[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3677(var3, (this.field3019[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3677(var3, (this.field3019[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3663(var3, this.field3029[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3713(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3669(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3673();
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2009613536"
   )
   void method3677(int var1, int var2) {
      this.field3019[var1] = var2;
      this.field3034[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-1171231228"
   )
   int method3679(class190 var1) {
      class188 var2 = var1.field3060;
      int var3 = this.field3021[var1.field3061] * this.field3013[var1.field3061] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = 16384 + var1.field3062 * var3 >> 15;
      var3 = 128 + this.field3014 * var3 >> 8;
      if(var2.field3042 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3076 * 1.953125E-5D * (double)var2.field3042) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3044) {
         var4 = var1.field3068;
         var5 = var2.field3044[var1.field3069 + 1];
         if(var1.field3069 < var2.field3044.length - 2) {
            var6 = (var2.field3044[var1.field3069] & 255) << 8;
            var7 = (var2.field3044[2 + var1.field3069] & 255) << 8;
            var5 += (var2.field3044[var1.field3069 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3070 > 0 && null != var2.field3048) {
         var4 = var1.field3070;
         var5 = var2.field3048[var1.field3071 + 1];
         if(var1.field3071 < var2.field3048.length - 2) {
            var6 = (var2.field3048[var1.field3071] & 255) << 8;
            var7 = (var2.field3048[2 + var1.field3071] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3048[var1.field3071 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("l")
   protected synchronized class69 vmethod3775() {
      return this.field3025;
   }

   @ObfuscatedName("j")
   protected synchronized class69 vmethod3776() {
      return null;
   }

   @ObfuscatedName("r")
   protected synchronized int vmethod3783() {
      return 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "261684560"
   )
   public synchronized boolean method3684(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3575();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2977.method3847(); null != var7; var7 = (class200)var1.field2977.method3852()) {
         int var8 = (int)var7.field3167;
         class184 var9 = (class184)this.field3016.method3856((long)var8);
         if(null == var9) {
            var9 = class132.method2880(var2, var8);
            if(null == var9) {
               var5 = false;
               continue;
            }

            this.field3016.method3849(var9, (long)var8);
         }

         if(!var9.method3577(var3, var7.field3145, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3569();
      }

      return var5;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)Z",
      garbageValue = "0"
   )
   boolean method3687(class190 var1) {
      if(var1.field3057 == null) {
         if(var1.field3070 >= 0) {
            var1.method3990();
            if(var1.field3065 > 0 && this.field3032[var1.field3061][var1.field3065] == var1) {
               this.field3032[var1.field3061][var1.field3065] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIIB)Z",
      garbageValue = "74"
   )
   boolean method3688(class190 var1, int[] var2, int var3, int var4) {
      var1.field3063 = class59.field1268 / 100;
      if(var1.field3070 < 0 || var1.field3057 != null && !var1.field3057.method1406()) {
         int var5 = var1.field3066;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3024[var1.field3061] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3066 = var5;
         }

         var1.field3057.method1404(this.method3657(var1));
         class188 var6 = var1.field3060;
         boolean var7 = false;
         ++var1.field3074;
         var1.field3073 += var6.field3041;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3066 * var1.field3078 >> 12) + (var1.field3067 - 60 << 8));
         if(var6.field3042 > 0) {
            if(var6.field3045 > 0) {
               var1.field3076 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3045 * var8) + 0.5D);
            } else {
               var1.field3076 += 128;
            }
         }

         if(null != var6.field3044) {
            if(var6.field3043 > 0) {
               var1.field3068 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3043 * var8) + 0.5D);
            } else {
               var1.field3068 += 128;
            }

            while(var1.field3069 < var6.field3044.length - 2 && var1.field3068 > (var6.field3044[var1.field3069 + 2] & 255) << 8) {
               var1.field3069 += 2;
            }

            if(var1.field3069 == var6.field3044.length - 2 && var6.field3044[var1.field3069 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3070 >= 0 && null != var6.field3048 && (this.field3018[var1.field3061] & 1) == 0 && (var1.field3065 < 0 || var1 != this.field3032[var1.field3061][var1.field3065])) {
            if(var6.field3040 > 0) {
               var1.field3070 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3040) + 0.5D);
            } else {
               var1.field3070 += 128;
            }

            while(var1.field3071 < var6.field3048.length - 2 && var1.field3070 > (var6.field3048[var1.field3071 + 2] & 255) << 8) {
               var1.field3071 += 2;
            }

            if(var6.field3048.length - 2 == var1.field3071) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3057.method1403(var1.field3063);
            if(null != var2) {
               var1.field3057.vmethod3778(var2, var3, var4);
            } else {
               var1.field3057.vmethod3779(var4);
            }

            if(var1.field3057.method1407()) {
               this.field3025.field3052.method1204(var1.field3057);
            }

            var1.method3797();
            if(var1.field3070 >= 0) {
               var1.method3990();
               if(var1.field3065 > 0 && this.field3032[var1.field3061][var1.field3065] == var1) {
                  this.field3032[var1.field3061][var1.field3065] = null;
               }
            }

            return true;
         } else {
            var1.field3057.method1402(var1.field3063, this.method3679(var1), this.method3770(var1));
            return false;
         }
      } else {
         var1.method3797();
         var1.method3990();
         if(var1.field3065 > 0 && var1 == this.field3032[var1.field3061][var1.field3065]) {
            this.field3032[var1.field3061][var1.field3065] = null;
         }

         return true;
      }
   }

   public class187() {
      this.method3673();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "4108"
   )
   void method3705(int var1, int var2, int var3) {
      this.method3711(var1, var2, 64);
      if((this.field3018[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3025.field3051.method3883(); null != var4; var4 = (class190)this.field3025.field3051.method3898()) {
            if(var1 == var4.field3061 && var4.field3070 < 0) {
               this.field3035[var1][var4.field3067] = null;
               this.field3035[var1][var2] = var4;
               int var5 = var4.field3064 + (var4.field3066 * var4.field3078 >> 12);
               var4.field3064 += var2 - var4.field3067 << 8;
               var4.field3078 = var5 - var4.field3064;
               var4.field3066 = 4096;
               var4.field3067 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3016.method3856((long)this.field3020[var1]);
      if(var9 != null) {
         class65 var8 = var9.field2980[var2];
         if(null != var8) {
            class190 var6 = new class190();
            var6.field3061 = var1;
            var6.field3056 = var9;
            var6.field3059 = var8;
            var6.field3060 = var9.field2983[var2];
            var6.field3065 = var9.field2984[var2];
            var6.field3067 = var2;
            var6.field3062 = var9.field2989 * var3 * var3 * var9.field2981[var2] + 1024 >> 11;
            var6.field3058 = var9.field2982[var2] & 255;
            var6.field3064 = (var2 << 8) - (var9.field2986[var2] & 32767);
            var6.field3076 = 0;
            var6.field3068 = 0;
            var6.field3069 = 0;
            var6.field3070 = -1;
            var6.field3071 = 0;
            if(this.field3028[var1] == 0) {
               var6.field3057 = class67.method1390(var8, this.method3657(var6), this.method3679(var6), this.method3770(var6));
            } else {
               var6.field3057 = class67.method1390(var8, this.method3657(var6), 0, this.method3770(var6));
               this.method3665(var6, var9.field2986[var2] < 0);
            }

            if(var9.field2986[var2] < 0) {
               var6.field3057.method1392(-1);
            }

            if(var6.field3065 >= 0) {
               class190 var7 = this.field3032[var1][var6.field3065];
               if(null != var7 && var7.field3070 < 0) {
                  this.field3035[var1][var7.field3067] = null;
                  var7.field3070 = 0;
               }

               this.field3032[var1][var6.field3065] = var6;
            }

            this.field3025.field3051.method3877(var6);
            this.field3035[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("x")
   protected synchronized void vmethod3778(int[] var1, int var2, int var3) {
      if(this.field3033.method3588()) {
         int var4 = this.field3039 * this.field3033.field2990 / class59.field1268;

         do {
            long var5 = this.field3037 + (long)var3 * (long)var4;
            if(this.field3038 - var5 >= 0L) {
               this.field3037 = var5;
               break;
            }

            int var7 = (int)((this.field3038 - this.field3037 + (long)var4 - 1L) / (long)var4);
            this.field3037 += (long)var7 * (long)var4;
            this.field3025.vmethod3778(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3731();
         } while(this.field3033.method3588());
      }

      this.field3025.vmethod3778(var1, var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-348162785"
   )
   void method3711(int var1, int var2, int var3) {
      class190 var4 = this.field3035[var1][var2];
      if(null != var4) {
         this.field3035[var1][var2] = null;
         if((this.field3018[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3025.field3051.method3882(); var5 != null; var5 = (class190)this.field3025.field3051.method3891()) {
               if(var5.field3061 == var4.field3061 && var5.field3070 < 0 && var4 != var5) {
                  var4.field3070 = 0;
                  break;
               }
            }
         } else {
            var4.field3070 = 0;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   void method3713(int var1, int var2) {
   }

   @ObfuscatedName("v")
   protected synchronized void vmethod3779(int var1) {
      if(this.field3033.method3588()) {
         int var2 = this.field3039 * this.field3033.field2990 / class59.field1268;

         do {
            long var3 = (long)var1 * (long)var2 + this.field3037;
            if(this.field3038 - var3 >= 0L) {
               this.field3037 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3038 - this.field3037) - 1L) / (long)var2);
            this.field3037 += (long)var5 * (long)var2;
            this.field3025.vmethod3779(var5);
            var1 -= var5;
            this.method3731();
         } while(this.field3033.method3588());
      }

      this.field3025.vmethod3779(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZI)V",
      garbageValue = "1167057765"
   )
   public synchronized void method3722(class183 var1, boolean var2) {
      this.method3750();
      this.field3033.method3591(var1.field2976);
      this.field3036 = var2;
      this.field3037 = 0L;
      int var3 = this.field3033.method3589();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3033.method3590(var4);
         this.field3033.method3593(var4);
         this.field3033.method3627(var4);
      }

      this.field3015 = this.field3033.method3597();
      this.field3030 = this.field3033.field2994[this.field3015];
      this.field3038 = this.field3033.method3596(this.field3030);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3731() {
      int var1 = this.field3015;
      int var2 = this.field3030;

      long var3;
      for(var3 = this.field3038; var2 == this.field3030; var3 = this.field3033.method3596(var2)) {
         while(this.field3033.field2994[var1] == var2) {
            this.field3033.method3590(var1);
            int var5 = this.field3033.method3612(var1);
            if(var5 == 1) {
               this.field3033.method3592();
               this.field3033.method3627(var1);
               if(this.field3033.method3598()) {
                  if(!this.field3036 || var2 == 0) {
                     this.method3673();
                     this.field3033.method3608();
                     return;
                  }

                  this.field3033.method3599(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3676(var5);
            }

            this.field3033.method3593(var1);
            this.field3033.method3627(var1);
         }

         var1 = this.field3033.method3597();
         var2 = this.field3033.field2994[var1];
      }

      this.field3015 = var1;
      this.field3030 = var2;
      this.field3038 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   public synchronized void method3750() {
      this.field3033.method3608();
      this.method3673();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "92"
   )
   public synchronized void method3766(int var1, int var2) {
      this.method3662(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-117528967"
   )
   synchronized void method3769() {
      for(class184 var1 = (class184)this.field3016.method3847(); null != var1; var1 = (class184)this.field3016.method3852()) {
         var1.method3990();
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-2119876368"
   )
   int method3770(class190 var1) {
      int var2 = this.field3017[var1.field3061];
      return var2 < 8192?32 + var2 * var1.field3058 >> 6:16384 - (32 + (128 - var1.field3058) * (16384 - var2) >> 6);
   }
}
