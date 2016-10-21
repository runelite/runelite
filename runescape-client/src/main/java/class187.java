import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class187 extends class69 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -912392603
   )
   int field3007 = 256;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -173339713
   )
   int field3008 = 1000000;
   @ObfuscatedName("t")
   int[] field3009 = new int[16];
   @ObfuscatedName("v")
   int[] field3010 = new int[16];
   @ObfuscatedName("b")
   int[] field3011 = new int[16];
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 703642866659848949L
   )
   long field3012;
   @ObfuscatedName("aw")
   class189 field3013 = new class189(this);
   @ObfuscatedName("k")
   int[] field3015 = new int[16];
   @ObfuscatedName("h")
   int[] field3016 = new int[16];
   @ObfuscatedName("c")
   int[] field3017 = new int[16];
   @ObfuscatedName("r")
   int[] field3018 = new int[16];
   @ObfuscatedName("z")
   int[] field3020 = new int[16];
   @ObfuscatedName("p")
   int[] field3021 = new int[16];
   @ObfuscatedName("y")
   int[] field3022 = new int[16];
   @ObfuscatedName("s")
   int[] field3023 = new int[16];
   @ObfuscatedName("g")
   class190[][] field3024 = new class190[16][128];
   @ObfuscatedName("l")
   int[] field3025 = new int[16];
   @ObfuscatedName("ay")
   class185 field3026 = new class185();
   @ObfuscatedName("i")
   int[] field3027 = new int[16];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -900934401
   )
   int field3028;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1022748585
   )
   int field3029;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -9054927605799061629L
   )
   long field3030;
   @ObfuscatedName("a")
   int[] field3031 = new int[16];
   @ObfuscatedName("aj")
   class190[][] field3032 = new class190[16][128];
   @ObfuscatedName("ah")
   boolean field3033;
   @ObfuscatedName("f")
   XHashTable field3034 = new XHashTable(128);
   @ObfuscatedName("m")
   int[] field3035 = new int[16];

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   synchronized void method3660() {
      for(class184 var1 = (class184)this.field3034.method3852(); var1 != null; var1 = (class184)this.field3034.method3857()) {
         var1.method3583();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZI)V",
      garbageValue = "1959042477"
   )
   synchronized void method3662(class183 var1, boolean var2) {
      this.method3663();
      this.field3026.method3590(var1.field2967);
      this.field3033 = var2;
      this.field3030 = 0L;
      int var3 = this.field3026.method3597();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3026.method3593(var4);
         this.field3026.method3596(var4);
         this.field3026.method3594(var4);
      }

      this.field3028 = this.field3026.method3627();
      this.field3029 = this.field3026.field2982[this.field3028];
      this.field3012 = this.field3026.method3600(this.field3029);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1800410120"
   )
   public synchronized void method3663() {
      this.field3026.method3591();
      this.method3677();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1465926547"
   )
   public synchronized boolean method3664() {
      return this.field3026.method3592();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "90"
   )
   public synchronized void method3665(int var1, int var2) {
      this.method3762(var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2028702996"
   )
   void method3667(int var1, int var2) {
      if(this.field3015[var1] != var2) {
         this.field3015[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3032[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "21"
   )
   void method3668(int var1, int var2, int var3) {
      this.method3670(var1, var2, 64);
      if((this.field3018[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3013.field3048.method3891(); var4 != null; var4 = (class190)this.field3013.field3048.method3893()) {
            if(var4.field3073 == var1 && var4.field3075 < 0) {
               this.field3024[var1][var4.field3059] = null;
               this.field3024[var1][var2] = var4;
               int var5 = (var4.field3063 * var4.field3064 >> 12) + var4.field3062;
               var4.field3062 += var2 - var4.field3059 << 8;
               var4.field3063 = var5 - var4.field3062;
               var4.field3064 = 4096;
               var4.field3059 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3034.method3849((long)this.field3015[var1]);
      if(var9 != null) {
         class65 var8 = var9.field2970[var2];
         if(var8 != null) {
            class190 var6 = new class190();
            var6.field3073 = var1;
            var6.field3069 = var9;
            var6.field3056 = var8;
            var6.field3068 = var9.field2969[var2];
            var6.field3058 = var9.field2973[var2];
            var6.field3059 = var2;
            var6.field3060 = var3 * var3 * var9.field2974 * var9.field2972[var2] + 1024 >> 11;
            var6.field3061 = var9.field2975[var2] & 255;
            var6.field3062 = (var2 << 8) - (var9.field2971[var2] & 32767);
            var6.field3065 = 0;
            var6.field3066 = 0;
            var6.field3055 = 0;
            var6.field3075 = -1;
            var6.field3057 = 0;
            if(this.field3021[var1] == 0) {
               var6.field3067 = class67.method1356(var8, this.method3737(var6), this.method3682(var6), this.method3688(var6));
            } else {
               var6.field3067 = class67.method1356(var8, this.method3737(var6), 0, this.method3688(var6));
               this.method3745(var6, var9.field2971[var2] < 0);
            }

            if(var9.field2971[var2] < 0) {
               var6.field3067.method1384(-1);
            }

            if(var6.field3058 >= 0) {
               class190 var7 = this.field3032[var1][var6.field3058];
               if(var7 != null && var7.field3075 < 0) {
                  this.field3024[var1][var7.field3059] = null;
                  var7.field3075 = 0;
               }

               this.field3032[var1][var6.field3058] = var6;
            }

            this.field3013.field3048.method3886(var6);
            this.field3024[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2128651379"
   )
   void method3670(int var1, int var2, int var3) {
      class190 var4 = this.field3024[var1][var2];
      if(null != var4) {
         this.field3024[var1][var2] = null;
         if((this.field3018[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3013.field3048.method3890(); null != var5; var5 = (class190)this.field3013.field3048.method3892()) {
               if(var4.field3073 == var5.field3073 && var5.field3075 < 0 && var4 != var5) {
                  var4.field3075 = 0;
                  break;
               }
            }
         } else {
            var4.field3075 = 0;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2039961423"
   )
   void method3671(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-88"
   )
   void method3674(int var1) {
      for(class190 var2 = (class190)this.field3013.field3048.method3890(); var2 != null; var2 = (class190)this.field3013.field3048.method3892()) {
         if((var1 < 0 || var1 == var2.field3073) && var2.field3075 < 0) {
            this.field3024[var2.field3073][var2.field3059] = null;
            var2.field3075 = 0;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-370983258"
   )
   void method3675(int var1) {
      if(var1 >= 0) {
         this.field3009[var1] = 12800;
         this.field3010[var1] = 8192;
         this.field3011[var1] = 16383;
         this.field3025[var1] = 8192;
         this.field3016[var1] = 0;
         this.field3027[var1] = 8192;
         this.method3678(var1);
         this.method3679(var1);
         this.field3018[var1] = 0;
         this.field3031[var1] = 32767;
         this.field3020[var1] = 256;
         this.field3021[var1] = 0;
         this.method3681(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3675(var1);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1852080830"
   )
   void method3677() {
      this.method3761(-1);
      this.method3675(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3015[var1] = this.field3035[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3017[var1] = this.field3035[var1] & -128;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1095851317"
   )
   void method3678(int var1) {
      if((this.field3018[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3013.field3048.method3890(); null != var2; var2 = (class190)this.field3013.field3048.method3892()) {
            if(var1 == var2.field3073 && null == this.field3024[var1][var2.field3059] && var2.field3075 < 0) {
               var2.field3075 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-560329839"
   )
   void method3679(int var1) {
      if((this.field3018[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3013.field3048.method3890(); null != var2; var2 = (class190)this.field3013.field3048.method3892()) {
            if(var2.field3073 == var1) {
               var2.field3074 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "27110257"
   )
   void method3680(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3670(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3668(var3, var4, var5);
         } else {
            this.method3670(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3671(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3017[var3] = (this.field3017[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field3017[var3] = (this.field3017[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field3016[var3] = (var5 << 7) + (this.field3016[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3016[var3] = (this.field3016[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field3027[var3] = (var5 << 7) + (this.field3027[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3027[var3] = (this.field3027[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field3009[var3] = (var5 << 7) + (this.field3009[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3009[var3] = var5 + (this.field3009[var3] & -128);
         }

         if(var4 == 10) {
            this.field3010[var3] = (var5 << 7) + (this.field3010[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3010[var3] = var5 + (this.field3010[var3] & -128);
         }

         if(var4 == 11) {
            this.field3011[var3] = (var5 << 7) + (this.field3011[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3011[var3] = (this.field3011[var3] & -128) + var5;
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
               this.method3678(var3);
               this.field3018[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3031[var3] = (this.field3031[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field3031[var3] = (this.field3031[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field3031[var3] = 16384 + (this.field3031[var3] & 127) + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3031[var3] = var5 + 16384 + (this.field3031[var3] & 16256);
         }

         if(var4 == 120) {
            this.method3761(var3);
         }

         if(var4 == 121) {
            this.method3675(var3);
         }

         if(var4 == 123) {
            this.method3674(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3020[var3] = (var5 << 7) + (this.field3020[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3020[var3] = (this.field3020[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field3021[var3] = (var5 << 7) + (this.field3021[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3021[var3] = (this.field3021[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3018[var3] |= 4;
            } else {
               this.method3679(var3);
               this.field3018[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3681(var3, (var5 << 7) + (this.field3022[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3681(var3, var5 + (this.field3022[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3667(var3, var4 + this.field3017[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3727(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3749(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3677();
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-74992452"
   )
   void method3681(int var1, int var2) {
      this.field3022[var1] = var2;
      this.field3023[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   public class187() {
      this.method3677();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-942214941"
   )
   int method3682(class190 var1) {
      class188 var2 = var1.field3068;
      int var3 = 4096 + this.field3011[var1.field3073] * this.field3009[var1.field3073] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field3060 + 16384 >> 15;
      var3 = 128 + this.field3007 * var3 >> 8;
      if(var2.field3038 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3038 * 1.953125E-5D * (double)var1.field3065) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3044) {
         var4 = var1.field3066;
         var5 = var2.field3044[var1.field3055 + 1];
         if(var1.field3055 < var2.field3044.length - 2) {
            var6 = (var2.field3044[var1.field3055] & 255) << 8;
            var7 = (var2.field3044[2 + var1.field3055] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3044[3 + var1.field3055] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field3075 > 0 && null != var2.field3047) {
         var4 = var1.field3075;
         var5 = var2.field3047[1 + var1.field3057];
         if(var1.field3057 < var2.field3047.length - 2) {
            var6 = (var2.field3047[var1.field3057] & 255) << 8;
            var7 = (var2.field3047[var1.field3057 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3047[3 + var1.field3057] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("b")
   protected synchronized class69 vmethod3776() {
      return this.field3013;
   }

   @ObfuscatedName("m")
   protected synchronized class69 vmethod3777() {
      return null;
   }

   @ObfuscatedName("k")
   protected synchronized int vmethod3778() {
      return 0;
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod3796(int[] var1, int var2, int var3) {
      if(this.field3026.method3592()) {
         int var4 = this.field3008 * this.field3026.field2984 / class59.field1235;

         do {
            long var5 = this.field3030 + (long)var4 * (long)var3;
            if(this.field3012 - var5 >= 0L) {
               this.field3030 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3012 - this.field3030) - 1L) / (long)var4);
            this.field3030 += (long)var7 * (long)var4;
            this.field3013.vmethod3796(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3689();
         } while(this.field3026.method3592());
      }

      this.field3013.vmethod3796(var1, var2, var3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass190;S)I",
      garbageValue = "-23363"
   )
   int method3688(class190 var1) {
      int var2 = this.field3010[var1.field3073];
      return var2 < 8192?var2 * var1.field3061 + 32 >> 6:16384 - (32 + (128 - var1.field3061) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3689() {
      int var1 = this.field3028;
      int var2 = this.field3029;

      long var3;
      for(var3 = this.field3012; this.field3029 == var2; var3 = this.field3026.method3600(var2)) {
         while(this.field3026.field2982[var1] == var2) {
            this.field3026.method3593(var1);
            int var5 = this.field3026.method3612(var1);
            if(var5 == 1) {
               this.field3026.method3601();
               this.field3026.method3594(var1);
               if(this.field3026.method3605()) {
                  if(!this.field3033 || var2 == 0) {
                     this.method3677();
                     this.field3026.method3591();
                     return;
                  }

                  this.field3026.method3603(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3680(var5);
            }

            this.field3026.method3596(var1);
            this.field3026.method3594(var1);
         }

         var1 = this.field3026.method3627();
         var2 = this.field3026.field2982[var1];
      }

      this.field3028 = var1;
      this.field3029 = var2;
      this.field3012 = var3;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "38283667"
   )
   boolean method3690(class190 var1) {
      if(var1.field3067 == null) {
         if(var1.field3075 >= 0) {
            var1.unlink();
            if(var1.field3058 > 0 && var1 == this.field3032[var1.field3073][var1.field3058]) {
               this.field3032[var1.field3073][var1.field3058] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "-235119854"
   )
   boolean method3691(class190 var1, int[] var2, int var3, int var4) {
      var1.field3054 = class59.field1235 / 100;
      if(var1.field3075 < 0 || var1.field3067 != null && !var1.field3067.method1372()) {
         int var5 = var1.field3064;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field3027[var1.field3073]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3064 = var5;
         }

         var1.field3067.method1370(this.method3737(var1));
         class188 var6 = var1.field3068;
         boolean var7 = false;
         ++var1.field3070;
         var1.field3071 += var6.field3043;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3063 * var1.field3064 >> 12) + (var1.field3059 - 60 << 8));
         if(var6.field3038 > 0) {
            if(var6.field3041 > 0) {
               var1.field3065 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3041 * var8) + 0.5D);
            } else {
               var1.field3065 += 128;
            }
         }

         if(var6.field3044 != null) {
            if(var6.field3040 > 0) {
               var1.field3066 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3040 * var8) + 0.5D);
            } else {
               var1.field3066 += 128;
            }

            while(var1.field3055 < var6.field3044.length - 2 && var1.field3066 > (var6.field3044[2 + var1.field3055] & 255) << 8) {
               var1.field3055 += 2;
            }

            if(var6.field3044.length - 2 == var1.field3055 && var6.field3044[1 + var1.field3055] == 0) {
               var7 = true;
            }
         }

         if(var1.field3075 >= 0 && var6.field3047 != null && (this.field3018[var1.field3073] & 1) == 0 && (var1.field3058 < 0 || var1 != this.field3032[var1.field3073][var1.field3058])) {
            if(var6.field3039 > 0) {
               var1.field3075 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3039 * var8) + 0.5D);
            } else {
               var1.field3075 += 128;
            }

            while(var1.field3057 < var6.field3047.length - 2 && var1.field3075 > (var6.field3047[var1.field3057 + 2] & 255) << 8) {
               var1.field3057 += 2;
            }

            if(var1.field3057 == var6.field3047.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3067.method1433(var1.field3054);
            if(null != var2) {
               var1.field3067.vmethod3796(var2, var3, var4);
            } else {
               var1.field3067.vmethod3780(var4);
            }

            if(var1.field3067.method1373()) {
               this.field3013.field3051.method1184(var1.field3067);
            }

            var1.method3804();
            if(var1.field3075 >= 0) {
               var1.unlink();
               if(var1.field3058 > 0 && var1 == this.field3032[var1.field3073][var1.field3058]) {
                  this.field3032[var1.field3073][var1.field3058] = null;
               }
            }

            return true;
         } else {
            var1.field3067.method1353(var1.field3054, this.method3682(var1), this.method3688(var1));
            return false;
         }
      } else {
         var1.method3804();
         var1.unlink();
         if(var1.field3058 > 0 && this.field3032[var1.field3073][var1.field3058] == var1) {
            this.field3032[var1.field3073][var1.field3058] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1094569155"
   )
   public synchronized void method3697(int var1) {
      this.field3007 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   public synchronized void method3721() {
      for(class184 var1 = (class184)this.field3034.method3852(); var1 != null; var1 = (class184)this.field3034.method3857()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-937398922"
   )
   void method3727(int var1, int var2) {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "1942625507"
   )
   int method3737(class190 var1) {
      int var2 = var1.field3062 + (var1.field3064 * var1.field3063 >> 12);
      var2 += (this.field3025[var1.field3073] - 8192) * this.field3020[var1.field3073] >> 12;
      class188 var3 = var1.field3068;
      int var4;
      if(var3.field3043 > 0 && (var3.field3037 > 0 || this.field3016[var1.field3073] > 0)) {
         var4 = var3.field3037 << 2;
         int var5 = var3.field3042 << 1;
         if(var1.field3070 < var5) {
            var4 = var4 * var1.field3070 / var5;
         }

         var4 += this.field3016[var1.field3073] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3071 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field3056.field1279 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class59.field1235 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZB)V",
      garbageValue = "7"
   )
   void method3745(class190 var1, boolean var2) {
      int var3 = var1.field3056.field1278.length;
      int var4;
      if(var2 && var1.field3056.field1281) {
         int var5 = var3 + var3 - var1.field3056.field1277;
         var4 = (int)((long)var5 * (long)this.field3021[var1.field3073] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3067.method1358();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field3021[var1.field3073] >> 6);
      }

      var1.field3067.method1364(var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;IB)Z",
      garbageValue = "0"
   )
   synchronized boolean method3748(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3573();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2968.method3852(); var7 != null; var7 = (class200)var1.field2968.method3857()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3034.method3849((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3289(var8);
            class184 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class184(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field3034.method3850(var10, (long)var8);
         }

         if(!var9.method3582(var3, var7.field3144, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3572();
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   void method3749(int var1, int var2) {
      this.field3025[var1] = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "25"
   )
   void method3761(int var1) {
      for(class190 var2 = (class190)this.field3013.field3048.method3890(); var2 != null; var2 = (class190)this.field3013.field3048.method3892()) {
         if(var1 < 0 || var2.field3073 == var1) {
            if(var2.field3067 != null) {
               var2.field3067.method1433(class59.field1235 / 100);
               if(var2.field3067.method1373()) {
                  this.field3013.field3051.method1184(var2.field3067);
               }

               var2.method3804();
            }

            if(var2.field3075 < 0) {
               this.field3024[var2.field3073][var2.field3059] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1696251161"
   )
   void method3762(int var1, int var2) {
      this.field3035[var1] = var2;
      this.field3017[var1] = var2 & -128;
      this.method3667(var1, var2);
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3780(int var1) {
      if(this.field3026.method3592()) {
         int var2 = this.field3026.field2984 * this.field3008 / class59.field1235;

         do {
            long var3 = this.field3030 + (long)var2 * (long)var1;
            if(this.field3012 - var3 >= 0L) {
               this.field3030 = var3;
               break;
            }

            int var5 = (int)((this.field3012 - this.field3030 + (long)var2 - 1L) / (long)var2);
            this.field3030 += (long)var5 * (long)var2;
            this.field3013.vmethod3780(var5);
            var1 -= var5;
            this.method3689();
         } while(this.field3026.method3592());
      }

      this.field3013.vmethod3780(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1026396414"
   )
   public int method3767() {
      return this.field3007;
   }
}
