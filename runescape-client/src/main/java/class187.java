import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class187 extends class69 {
   @ObfuscatedName("q")
   int[] field3003 = new int[16];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -425692921
   )
   int field3004 = 256;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2092183771
   )
   int field3005 = 1000000;
   @ObfuscatedName("h")
   int[] field3006 = new int[16];
   @ObfuscatedName("r")
   int[] field3007 = new int[16];
   @ObfuscatedName("a")
   int[] field3008 = new int[16];
   @ObfuscatedName("b")
   int[] field3009 = new int[16];
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -239326601
   )
   int field3010;
   @ObfuscatedName("i")
   int[] field3011 = new int[16];
   @ObfuscatedName("p")
   int[] field3012 = new int[16];
   @ObfuscatedName("ah")
   class190[][] field3013 = new class190[16][128];
   @ObfuscatedName("o")
   int[] field3014 = new int[16];
   @ObfuscatedName("y")
   int[] field3016 = new int[16];
   @ObfuscatedName("m")
   int[] field3017 = new int[16];
   @ObfuscatedName("k")
   int[] field3018 = new int[16];
   @ObfuscatedName("v")
   int[] field3019 = new int[16];
   @ObfuscatedName("n")
   int[] field3020 = new int[16];
   @ObfuscatedName("d")
   int[] field3021 = new int[16];
   @ObfuscatedName("u")
   int[] field3022 = new int[16];
   @ObfuscatedName("ak")
   class185 field3023 = new class185();
   @ObfuscatedName("s")
   class190[][] field3024 = new class190[16][128];
   @ObfuscatedName("as")
   boolean field3025;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1335759419
   )
   int field3026;
   @ObfuscatedName("e")
   class199 field3027 = new class199(128);
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = -6034220115981965435L
   )
   long field3028;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -7790643535101567643L
   )
   long field3029;
   @ObfuscatedName("ap")
   class189 field3030 = new class189(this);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2030277911"
   )
   public synchronized void method3683(int var1) {
      this.field3004 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-72"
   )
   void method3684(int var1) {
      if((this.field3016[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3030.field3043.method3899(); var2 != null; var2 = (class190)this.field3030.field3043.method3918()) {
            if(var2.field3067 == var1 && this.field3024[var1][var2.field3054] == null && var2.field3063 < 0) {
               var2.field3063 = 0;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "-345406198"
   )
   public synchronized boolean method3685(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3603();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2966.method3867(); null != var7; var7 = (class200)var1.field2966.method3868()) {
         int var8 = (int)var7.field3161;
         class184 var9 = (class184)this.field3027.method3864((long)var8);
         if(var9 == null) {
            var9 = class230.method4229(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field3027.method3865(var9, (long)var8);
         }

         if(!var9.method3612(var3, var7.field3140, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3610();
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-557072909"
   )
   public synchronized void method3686() {
      for(class184 var1 = (class184)this.field3027.method3867(); var1 != null; var1 = (class184)this.field3027.method3868()) {
         var1.method3613();
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2077296848"
   )
   void method3687(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3696(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3694(var3, var4, var5);
         } else {
            this.method3696(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3697(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3014[var3] = (var5 << 14) + (this.field3014[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3014[var3] = (var5 << 7) + (this.field3014[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3011[var3] = (this.field3011[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field3011[var3] = (this.field3011[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field3003[var3] = (var5 << 7) + (this.field3003[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3003[var3] = var5 + (this.field3003[var3] & -128);
         }

         if(var4 == 7) {
            this.field3006[var3] = (var5 << 7) + (this.field3006[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3006[var3] = var5 + (this.field3006[var3] & -128);
         }

         if(var4 == 10) {
            this.field3007[var3] = (this.field3007[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field3007[var3] = var5 + (this.field3007[var3] & -128);
         }

         if(var4 == 11) {
            this.field3008[var3] = (var5 << 7) + (this.field3008[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3008[var3] = var5 + (this.field3008[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3016[var3] |= 1;
            } else {
               this.field3016[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3016[var3] |= 2;
            } else {
               this.method3684(var3);
               this.field3016[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3017[var3] = (this.field3017[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field3017[var3] = var5 + (this.field3017[var3] & 16256);
         }

         if(var4 == 101) {
            this.field3017[var3] = (this.field3017[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3017[var3] = var5 + 16384 + (this.field3017[var3] & 16256);
         }

         if(var4 == 120) {
            this.method3749(var3);
         }

         if(var4 == 121) {
            this.method3792(var3);
         }

         if(var4 == 123) {
            this.method3702(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3017[var3];
            if(var6 == 16384) {
               this.field3019[var3] = (var5 << 7) + (this.field3019[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3017[var3];
            if(var6 == 16384) {
               this.field3019[var3] = var5 + (this.field3019[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field3018[var3] = (this.field3018[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field3018[var3] = (this.field3018[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3016[var3] |= 4;
            } else {
               this.method3710(var3);
               this.field3016[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3707(var3, (var5 << 7) + (this.field3020[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3707(var3, var5 + (this.field3020[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3757(var3, this.field3014[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3698(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3699(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3703();
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZB)V",
      garbageValue = "53"
   )
   public synchronized void method3688(class183 var1, boolean var2) {
      this.method3689();
      this.field3023.method3665(var1.field2967);
      this.field3025 = var2;
      this.field3028 = 0L;
      int var3 = this.field3023.method3639();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3023.method3626(var4);
         this.field3023.method3628(var4);
         this.field3023.method3627(var4);
      }

      this.field3026 = this.field3023.method3633();
      this.field3010 = this.field3023.field2983[this.field3026];
      this.field3029 = this.field3023.method3632(this.field3010);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1724881618"
   )
   public synchronized void method3689() {
      this.field3023.method3623();
      this.method3703();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2053535451"
   )
   synchronized boolean method3690() {
      return this.field3023.method3620();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-14"
   )
   public synchronized void method3691(int var1, int var2) {
      this.method3756(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2114916510"
   )
   void method3694(int var1, int var2, int var3) {
      this.method3696(var1, var2, 64);
      if((this.field3016[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3030.field3043.method3900(); null != var4; var4 = (class190)this.field3030.field3043.method3893()) {
            if(var4.field3067 == var1 && var4.field3063 < 0) {
               this.field3024[var1][var4.field3054] = null;
               this.field3024[var1][var2] = var4;
               int var8 = var4.field3057 + (var4.field3058 * var4.field3059 >> 12);
               var4.field3057 += var2 - var4.field3054 << 8;
               var4.field3058 = var8 - var4.field3057;
               var4.field3059 = 4096;
               var4.field3054 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3027.method3864((long)this.field3022[var1]);
      if(var9 != null) {
         class65 var5 = var9.field2978[var2];
         if(null != var5) {
            class190 var6 = new class190();
            var6.field3067 = var1;
            var6.field3062 = var9;
            var6.field3050 = var5;
            var6.field3052 = var9.field2973[var2];
            var6.field3071 = var9.field2974[var2];
            var6.field3054 = var2;
            var6.field3055 = var9.field2969[var2] * var3 * var3 * var9.field2972 + 1024 >> 11;
            var6.field3056 = var9.field2975[var2] & 255;
            var6.field3057 = (var2 << 8) - (var9.field2970[var2] & 32767);
            var6.field3060 = 0;
            var6.field3066 = 0;
            var6.field3051 = 0;
            var6.field3063 = -1;
            var6.field3064 = 0;
            if(this.field3018[var1] == 0) {
               var6.field3061 = class67.method1409(var5, this.method3708(var6), this.method3709(var6), this.method3784(var6));
            } else {
               var6.field3061 = class67.method1409(var5, this.method3708(var6), 0, this.method3784(var6));
               this.method3695(var6, var9.field2970[var2] < 0);
            }

            if(var9.field2970[var2] < 0) {
               var6.field3061.method1411(-1);
            }

            if(var6.field3071 >= 0) {
               class190 var7 = this.field3013[var1][var6.field3071];
               if(var7 != null && var7.field3063 < 0) {
                  this.field3024[var1][var7.field3054] = null;
                  var7.field3063 = 0;
               }

               this.field3013[var1][var6.field3071] = var6;
            }

            this.field3030.field3043.method3895(var6);
            this.field3024[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZB)V",
      garbageValue = "41"
   )
   void method3695(class190 var1, boolean var2) {
      int var3 = var1.field3050.field1304.length;
      int var4;
      if(var2 && var1.field3050.field1300) {
         int var5 = var3 + var3 - var1.field3050.field1302;
         var4 = (int)((long)this.field3018[var1.field3067] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3061.method1418();
         }
      } else {
         var4 = (int)((long)this.field3018[var1.field3067] * (long)var3 >> 6);
      }

      var1.field3061.method1417(var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   void method3696(int var1, int var2, int var3) {
      class190 var4 = this.field3024[var1][var2];
      if(null != var4) {
         this.field3024[var1][var2] = null;
         if((this.field3016[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3030.field3043.method3899(); null != var5; var5 = (class190)this.field3030.field3043.method3918()) {
               if(var4.field3067 == var5.field3067 && var5.field3063 < 0 && var5 != var4) {
                  var4.field3063 = 0;
                  break;
               }
            }
         } else {
            var4.field3063 = 0;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1435034055"
   )
   void method3697(int var1, int var2, int var3) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "89"
   )
   void method3698(int var1, int var2) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1459242634"
   )
   void method3699(int var1, int var2) {
      this.field3012[var1] = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-33"
   )
   void method3702(int var1) {
      for(class190 var2 = (class190)this.field3030.field3043.method3899(); null != var2; var2 = (class190)this.field3030.field3043.method3918()) {
         if((var1 < 0 || var1 == var2.field3067) && var2.field3063 < 0) {
            this.field3024[var2.field3067][var2.field3054] = null;
            var2.field3063 = 0;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "844074258"
   )
   void method3703() {
      this.method3749(-1);
      this.method3792(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3022[var1] = this.field3009[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3014[var1] = this.field3009[var1] & -128;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-32"
   )
   int method3705() {
      return this.field3004;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2130679182"
   )
   void method3707(int var1, int var2) {
      this.field3020[var1] = var2;
      this.field3021[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "74815916"
   )
   int method3708(class190 var1) {
      int var2 = (var1.field3058 * var1.field3059 >> 12) + var1.field3057;
      var2 += this.field3019[var1.field3067] * (this.field3012[var1.field3067] - 8192) >> 12;
      class188 var3 = var1.field3052;
      int var4;
      if(var3.field3038 > 0 && (var3.field3037 > 0 || this.field3011[var1.field3067] > 0)) {
         var4 = var3.field3037 << 2;
         int var5 = var3.field3032 << 1;
         if(var1.field3065 < var5) {
            var4 = var4 * var1.field3065 / var5;
         }

         var4 += this.field3011[var1.field3067] >> 7;
         double var6 = Math.sin((double)(var1.field3049 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field3050.field1301 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class59.field1260 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "12"
   )
   int method3709(class190 var1) {
      class188 var2 = var1.field3052;
      int var3 = this.field3008[var1.field3067] * this.field3006[var1.field3067] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field3055 + 16384 >> 15;
      var3 = var3 * this.field3004 + 128 >> 8;
      if(var2.field3039 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3039 * 1.953125E-5D * (double)var1.field3060) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3031) {
         var4 = var1.field3066;
         var5 = var2.field3031[var1.field3051 + 1];
         if(var1.field3051 < var2.field3031.length - 2) {
            var6 = (var2.field3031[var1.field3051] & 255) << 8;
            var7 = (var2.field3031[2 + var1.field3051] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3031[var1.field3051 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3063 > 0 && null != var2.field3033) {
         var4 = var1.field3063;
         var5 = var2.field3033[var1.field3064 + 1];
         if(var1.field3064 < var2.field3033.length - 2) {
            var6 = (var2.field3033[var1.field3064] & 255) << 8;
            var7 = (var2.field3033[2 + var1.field3064] & 255) << 8;
            var5 += (var2.field3033[var1.field3064 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "143388047"
   )
   void method3710(int var1) {
      if((this.field3016[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3030.field3043.method3899(); null != var2; var2 = (class190)this.field3030.field3043.method3918()) {
            if(var1 == var2.field3067) {
               var2.field3069 = 0;
            }
         }
      }

   }

   @ObfuscatedName("a")
   protected synchronized class69 vmethod3803() {
      return this.field3030;
   }

   @ObfuscatedName("u")
   protected synchronized int vmethod3805() {
      return 0;
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod3806(int[] var1, int var2, int var3) {
      if(this.field3023.method3620()) {
         int var4 = this.field3005 * this.field3023.field2979 / class59.field1260;

         do {
            long var5 = this.field3028 + (long)var3 * (long)var4;
            if(this.field3029 - var5 >= 0L) {
               this.field3028 = var5;
               break;
            }

            int var7 = (int)((this.field3029 - this.field3028 + (long)var4 - 1L) / (long)var4);
            this.field3028 += (long)var7 * (long)var4;
            this.field3030.vmethod3806(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3716();
         } while(this.field3023.method3620());
      }

      this.field3030.vmethod3806(var1, var2, var3);
   }

   @ObfuscatedName("i")
   protected synchronized void vmethod3807(int var1) {
      if(this.field3023.method3620()) {
         int var2 = this.field3005 * this.field3023.field2979 / class59.field1260;

         do {
            long var3 = (long)var1 * (long)var2 + this.field3028;
            if(this.field3029 - var3 >= 0L) {
               this.field3028 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3029 - this.field3028) - 1L) / (long)var2);
            this.field3028 += (long)var5 * (long)var2;
            this.field3030.vmethod3807(var5);
            var1 -= var5;
            this.method3716();
         } while(this.field3023.method3620());
      }

      this.field3030.vmethod3807(var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1990597951"
   )
   void method3716() {
      int var1 = this.field3026;
      int var2 = this.field3010;

      long var3;
      for(var3 = this.field3029; var2 == this.field3010; var3 = this.field3023.method3632(var2)) {
         while(var2 == this.field3023.field2983[var1]) {
            this.field3023.method3626(var1);
            int var5 = this.field3023.method3629(var1);
            if(var5 == 1) {
               this.field3023.method3622();
               this.field3023.method3627(var1);
               if(this.field3023.method3634()) {
                  if(!this.field3025 || var2 == 0) {
                     this.method3703();
                     this.field3023.method3623();
                     return;
                  }

                  this.field3023.method3635(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3687(var5);
            }

            this.field3023.method3628(var1);
            this.field3023.method3627(var1);
         }

         var1 = this.field3023.method3633();
         var2 = this.field3023.field2983[var1];
      }

      this.field3026 = var1;
      this.field3010 = var2;
      this.field3029 = var3;
   }

   @ObfuscatedName("b")
   protected synchronized class69 vmethod3804() {
      return null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "-1280279531"
   )
   boolean method3726(class190 var1) {
      if(var1.field3061 == null) {
         if(var1.field3063 >= 0) {
            var1.method4000();
            if(var1.field3071 > 0 && this.field3013[var1.field3067][var1.field3071] == var1) {
               this.field3013[var1.field3067][var1.field3071] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public class187() {
      this.method3703();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "147679700"
   )
   void method3749(int var1) {
      for(class190 var2 = (class190)this.field3030.field3043.method3899(); var2 != null; var2 = (class190)this.field3030.field3043.method3918()) {
         if(var1 < 0 || var1 == var2.field3067) {
            if(null != var2.field3061) {
               var2.field3061.method1428(class59.field1260 / 100);
               if(var2.field3061.method1426()) {
                  this.field3030.field3047.method1241(var2.field3061);
               }

               var2.method3823();
            }

            if(var2.field3063 < 0) {
               this.field3024[var2.field3067][var2.field3054] = null;
            }

            var2.method4000();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1637896124"
   )
   void method3756(int var1, int var2) {
      this.field3009[var1] = var2;
      this.field3014[var1] = var2 & -128;
      this.method3757(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "64"
   )
   void method3757(int var1, int var2) {
      if(this.field3022[var1] != var2) {
         this.field3022[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3013[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "55954078"
   )
   boolean method3781(class190 var1, int[] var2, int var3, int var4) {
      var1.field3068 = class59.field1260 / 100;
      if(var1.field3063 < 0 || null != var1.field3061 && !var1.field3061.method1454()) {
         int var5 = var1.field3059;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field3003[var1.field3067]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3059 = var5;
         }

         var1.field3061.method1423(this.method3708(var1));
         class188 var6 = var1.field3052;
         boolean var7 = false;
         ++var1.field3065;
         var1.field3049 += var6.field3038;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3054 - 60 << 8) + (var1.field3058 * var1.field3059 >> 12));
         if(var6.field3039 > 0) {
            if(var6.field3036 > 0) {
               var1.field3060 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3036 * var8) + 0.5D);
            } else {
               var1.field3060 += 128;
            }
         }

         if(var6.field3031 != null) {
            if(var6.field3034 > 0) {
               var1.field3066 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3034) + 0.5D);
            } else {
               var1.field3066 += 128;
            }

            while(var1.field3051 < var6.field3031.length - 2 && var1.field3066 > (var6.field3031[2 + var1.field3051] & 255) << 8) {
               var1.field3051 += 2;
            }

            if(var6.field3031.length - 2 == var1.field3051 && var6.field3031[var1.field3051 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3063 >= 0 && var6.field3033 != null && (this.field3016[var1.field3067] & 1) == 0 && (var1.field3071 < 0 || this.field3013[var1.field3067][var1.field3071] != var1)) {
            if(var6.field3035 > 0) {
               var1.field3063 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3035) + 0.5D);
            } else {
               var1.field3063 += 128;
            }

            while(var1.field3064 < var6.field3033.length - 2 && var1.field3063 > (var6.field3033[2 + var1.field3064] & 255) << 8) {
               var1.field3064 += 2;
            }

            if(var1.field3064 == var6.field3033.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3061.method1428(var1.field3068);
            if(var2 != null) {
               var1.field3061.vmethod3806(var2, var3, var4);
            } else {
               var1.field3061.vmethod3807(var4);
            }

            if(var1.field3061.method1426()) {
               this.field3030.field3047.method1241(var1.field3061);
            }

            var1.method3823();
            if(var1.field3063 >= 0) {
               var1.method4000();
               if(var1.field3071 > 0 && var1 == this.field3013[var1.field3067][var1.field3071]) {
                  this.field3013[var1.field3067][var1.field3071] = null;
               }
            }

            return true;
         } else {
            var1.field3061.method1489(var1.field3068, this.method3709(var1), this.method3784(var1));
            return false;
         }
      } else {
         var1.method3823();
         var1.method4000();
         if(var1.field3071 > 0 && this.field3013[var1.field3067][var1.field3071] == var1) {
            this.field3013[var1.field3067][var1.field3071] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "86767441"
   )
   int method3784(class190 var1) {
      int var2 = this.field3007[var1.field3067];
      return var2 < 8192?var1.field3056 * var2 + 32 >> 6:16384 - (32 + (128 - var1.field3056) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1586099277"
   )
   void method3792(int var1) {
      if(var1 >= 0) {
         this.field3006[var1] = 12800;
         this.field3007[var1] = 8192;
         this.field3008[var1] = 16383;
         this.field3012[var1] = 8192;
         this.field3011[var1] = 0;
         this.field3003[var1] = 8192;
         this.method3684(var1);
         this.method3710(var1);
         this.field3016[var1] = 0;
         this.field3017[var1] = 32767;
         this.field3019[var1] = 256;
         this.field3018[var1] = 0;
         this.method3707(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3792(var1);
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1236222660"
   )
   synchronized void method3798() {
      for(class184 var1 = (class184)this.field3027.method3867(); var1 != null; var1 = (class184)this.field3027.method3868()) {
         var1.method4000();
      }

   }
}
