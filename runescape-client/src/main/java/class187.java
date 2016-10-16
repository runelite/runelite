import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class187 extends class69 {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -875249802564843945L
   )
   long field3010;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1981229171
   )
   int field3011 = 256;
   @ObfuscatedName("y")
   int[] field3013 = new int[16];
   @ObfuscatedName("p")
   int[] field3014 = new int[16];
   @ObfuscatedName("g")
   int[] field3015 = new int[16];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1563115547
   )
   int field3016 = 1000000;
   @ObfuscatedName("f")
   int[] field3017 = new int[16];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1136899687
   )
   int field3018;
   @ObfuscatedName("h")
   int[] field3019 = new int[16];
   @ObfuscatedName("r")
   int[] field3020 = new int[16];
   @ObfuscatedName("u")
   int[] field3021 = new int[16];
   @ObfuscatedName("c")
   int[] field3022 = new int[16];
   @ObfuscatedName("x")
   int[] field3024 = new int[16];
   @ObfuscatedName("v")
   int[] field3025 = new int[16];
   @ObfuscatedName("l")
   int[] field3026 = new int[16];
   @ObfuscatedName("e")
   int[] field3027 = new int[16];
   @ObfuscatedName("j")
   class190[][] field3028 = new class190[16][128];
   @ObfuscatedName("m")
   int[] field3029 = new int[16];
   @ObfuscatedName("ah")
   class185 field3030 = new class185();
   @ObfuscatedName("am")
   boolean field3031;
   @ObfuscatedName("i")
   int[] field3032 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1600204359
   )
   int field3033;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = 4084463471752791541L
   )
   long field3034;
   @ObfuscatedName("ae")
   class190[][] field3035 = new class190[16][128];
   @ObfuscatedName("an")
   class189 field3036 = new class189(this);
   @ObfuscatedName("k")
   int[] field3037 = new int[16];
   @ObfuscatedName("s")
   XHashTable field3038 = new XHashTable(128);

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1631676179"
   )
   void method3580(int var1) {
      if(var1 >= 0) {
         this.field3013[var1] = 12800;
         this.field3014[var1] = 8192;
         this.field3015[var1] = 16383;
         this.field3019[var1] = 8192;
         this.field3020[var1] = 0;
         this.field3021[var1] = 8192;
         this.method3659(var1);
         this.method3603(var1);
         this.field3022[var1] = 0;
         this.field3032[var1] = 32767;
         this.field3024[var1] = 256;
         this.field3025[var1] = 0;
         this.method3689(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3580(var1);
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-25"
   )
   int method3582() {
      return this.field3011;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   synchronized void method3584() {
      for(class184 var1 = (class184)this.field3038.method3780(); null != var1; var1 = (class184)this.field3038.method3785()) {
         var1.method3512();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZB)V",
      garbageValue = "66"
   )
   synchronized void method3586(class183 var1, boolean var2) {
      this.method3587();
      this.field3030.method3518(var1.field2970);
      this.field3031 = var2;
      this.field3034 = 0L;
      int var3 = this.field3030.method3545();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3030.method3529(var4);
         this.field3030.method3522(var4);
         this.field3030.method3535(var4);
      }

      this.field3033 = this.field3030.method3530();
      this.field3018 = this.field3030.field2988[this.field3033];
      this.field3010 = this.field3030.method3525(this.field3018);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1638746323"
   )
   public synchronized void method3587() {
      this.field3030.method3519();
      this.method3601();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-816786666"
   )
   public synchronized boolean method3588() {
      return this.field3030.method3517();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "46"
   )
   public synchronized void method3589(int var1, int var2) {
      this.method3590(var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-91"
   )
   void method3590(int var1, int var2) {
      this.field3029[var1] = var2;
      this.field3037[var1] = var2 & -128;
      this.method3602(var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "592382980"
   )
   void method3592(int var1, int var2, int var3) {
      this.method3594(var1, var2, 64);
      if((this.field3022[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3036.field3053.method3823(); null != var4; var4 = (class190)this.field3036.field3053.method3828()) {
            if(var4.field3067 == var1 && var4.field3060 < 0) {
               this.field3028[var1][var4.field3072] = null;
               this.field3028[var1][var2] = var4;
               int var5 = var4.field3063 + (var4.field3055 * var4.field3065 >> 12);
               var4.field3063 += var2 - var4.field3072 << 8;
               var4.field3055 = var5 - var4.field3063;
               var4.field3065 = 4096;
               var4.field3072 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3038.method3775((long)this.field3017[var1]);
      if(var9 != null) {
         class65 var8 = var9.field2980[var2];
         if(null != var8) {
            class190 var6 = new class190();
            var6.field3067 = var1;
            var6.field3069 = var9;
            var6.field3057 = var8;
            var6.field3056 = var9.field2976[var2];
            var6.field3059 = var9.field2977[var2];
            var6.field3072 = var2;
            var6.field3061 = 1024 + var3 * var3 * var9.field2973 * var9.field2974[var2] >> 11;
            var6.field3062 = var9.field2975[var2] & 255;
            var6.field3063 = (var2 << 8) - (var9.field2972[var2] & 32767);
            var6.field3066 = 0;
            var6.field3058 = 0;
            var6.field3070 = 0;
            var6.field3060 = -1;
            var6.field3064 = 0;
            if(this.field3025[var1] == 0) {
               var6.field3073 = class67.method1309(var8, this.method3606(var6), this.method3597(var6), this.method3608(var6));
            } else {
               var6.field3073 = class67.method1309(var8, this.method3606(var6), 0, this.method3608(var6));
               this.method3593(var6, var9.field2972[var2] < 0);
            }

            if(var9.field2972[var2] < 0) {
               var6.field3073.method1311(-1);
            }

            if(var6.field3059 >= 0) {
               class190 var7 = this.field3035[var1][var6.field3059];
               if(var7 != null && var7.field3060 < 0) {
                  this.field3028[var1][var7.field3072] = null;
                  var7.field3060 = 0;
               }

               this.field3035[var1][var6.field3059] = var6;
            }

            this.field3036.field3053.method3801(var6);
            this.field3028[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZB)V",
      garbageValue = "127"
   )
   void method3593(class190 var1, boolean var2) {
      int var3 = var1.field3057.field1273.length;
      int var4;
      if(var2 && var1.field3057.field1272) {
         int var5 = var3 + var3 - var1.field3057.field1274;
         var4 = (int)((long)var5 * (long)this.field3025[var1.field3067] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3073.method1384();
         }
      } else {
         var4 = (int)((long)this.field3025[var1.field3067] * (long)var3 >> 6);
      }

      var1.field3073.method1316(var4);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-24"
   )
   void method3594(int var1, int var2, int var3) {
      class190 var4 = this.field3028[var1][var2];
      if(null != var4) {
         this.field3028[var1][var2] = null;
         if((this.field3022[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3036.field3053.method3808(); null != var5; var5 = (class190)this.field3036.field3053.method3810()) {
               if(var5.field3067 == var4.field3067 && var5.field3060 < 0 && var4 != var5) {
                  var4.field3060 = 0;
                  break;
               }
            }
         } else {
            var4.field3060 = 0;
         }

      }
   }

   @ObfuscatedName("f")
   protected synchronized int vmethod3707() {
      return 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass190;S)I",
      garbageValue = "-24149"
   )
   int method3597(class190 var1) {
      class188 var2 = var1.field3056;
      int var3 = this.field3015[var1.field3067] * this.field3013[var1.field3067] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field3061 >> 15;
      var3 = 128 + this.field3011 * var3 >> 8;
      if(var2.field3041 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field3066 * (double)var2.field3041) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3050) {
         var4 = var1.field3058;
         var5 = var2.field3050[var1.field3070 + 1];
         if(var1.field3070 < var2.field3050.length - 2) {
            var6 = (var2.field3050[var1.field3070] & 255) << 8;
            var7 = (var2.field3050[2 + var1.field3070] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3050[3 + var1.field3070] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field3060 > 0 && null != var2.field3040) {
         var4 = var1.field3060;
         var5 = var2.field3040[1 + var1.field3064];
         if(var1.field3064 < var2.field3040.length - 2) {
            var6 = (var2.field3040[var1.field3064] & 255) << 8;
            var7 = (var2.field3040[2 + var1.field3064] & 255) << 8;
            var5 += (var2.field3040[3 + var1.field3064] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method3598(int var1) {
      for(class190 var2 = (class190)this.field3036.field3053.method3808(); var2 != null; var2 = (class190)this.field3036.field3053.method3810()) {
         if(var1 < 0 || var1 == var2.field3067) {
            if(var2.field3073 != null) {
               var2.field3073.method1322(class59.field1219 / 100);
               if(var2.field3073.method1326()) {
                  this.field3036.field3054.method1143(var2.field3073);
               }

               var2.method3731();
            }

            if(var2.field3060 < 0) {
               this.field3028[var2.field3067][var2.field3072] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "221880193"
   )
   void method3599(int var1) {
      for(class190 var2 = (class190)this.field3036.field3053.method3808(); null != var2; var2 = (class190)this.field3036.field3053.method3810()) {
         if((var1 < 0 || var2.field3067 == var1) && var2.field3060 < 0) {
            this.field3028[var2.field3067][var2.field3072] = null;
            var2.field3060 = 0;
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "323506952"
   )
   void method3601() {
      this.method3598(-1);
      this.method3580(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3017[var1] = this.field3029[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3037[var1] = this.field3029[var1] & -128;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1442135958"
   )
   void method3602(int var1, int var2) {
      if(var2 != this.field3017[var1]) {
         this.field3017[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3035[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   void method3603(int var1) {
      if((this.field3022[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3036.field3053.method3808(); var2 != null; var2 = (class190)this.field3036.field3053.method3810()) {
            if(var2.field3067 == var1) {
               var2.field3075 = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method3604(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3594(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3592(var3, var4, var5);
         } else {
            this.method3594(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3668(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3037[var3] = (this.field3037[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field3037[var3] = (var5 << 7) + (this.field3037[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3020[var3] = (var5 << 7) + (this.field3020[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3020[var3] = (this.field3020[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field3021[var3] = (this.field3021[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field3021[var3] = var5 + (this.field3021[var3] & -128);
         }

         if(var4 == 7) {
            this.field3013[var3] = (this.field3013[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field3013[var3] = var5 + (this.field3013[var3] & -128);
         }

         if(var4 == 10) {
            this.field3014[var3] = (this.field3014[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field3014[var3] = var5 + (this.field3014[var3] & -128);
         }

         if(var4 == 11) {
            this.field3015[var3] = (var5 << 7) + (this.field3015[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3015[var3] = var5 + (this.field3015[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3022[var3] |= 1;
            } else {
               this.field3022[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3022[var3] |= 2;
            } else {
               this.method3659(var3);
               this.field3022[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3032[var3] = (var5 << 7) + (this.field3032[var3] & 127);
         }

         if(var4 == 98) {
            this.field3032[var3] = var5 + (this.field3032[var3] & 16256);
         }

         if(var4 == 101) {
            this.field3032[var3] = (var5 << 7) + 16384 + (this.field3032[var3] & 127);
         }

         if(var4 == 100) {
            this.field3032[var3] = var5 + (this.field3032[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3598(var3);
         }

         if(var4 == 121) {
            this.method3580(var3);
         }

         if(var4 == 123) {
            this.method3599(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3032[var3];
            if(var6 == 16384) {
               this.field3024[var3] = (var5 << 7) + (this.field3024[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3032[var3];
            if(var6 == 16384) {
               this.field3024[var3] = (this.field3024[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field3025[var3] = (this.field3025[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field3025[var3] = var5 + (this.field3025[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3022[var3] |= 4;
            } else {
               this.method3603(var3);
               this.field3022[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3689(var3, (this.field3026[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3689(var3, (this.field3026[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3602(var3, var4 + this.field3037[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3654(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3611(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3601();
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "1228472319"
   )
   int method3606(class190 var1) {
      int var2 = var1.field3063 + (var1.field3055 * var1.field3065 >> 12);
      var2 += this.field3024[var1.field3067] * (this.field3019[var1.field3067] - 8192) >> 12;
      class188 var3 = var1.field3056;
      int var4;
      if(var3.field3048 > 0 && (var3.field3045 > 0 || this.field3020[var1.field3067] > 0)) {
         var4 = var3.field3045 << 2;
         int var5 = var3.field3039 << 1;
         if(var1.field3071 < var5) {
            var4 = var4 * var1.field3071 / var5;
         }

         var4 += this.field3020[var1.field3067] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3068 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field3057.field1276 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class59.field1219 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass190;S)I",
      garbageValue = "339"
   )
   int method3608(class190 var1) {
      int var2 = this.field3014[var1.field3067];
      return var2 < 8192?var2 * var1.field3062 + 32 >> 6:16384 - (32 + (128 - var1.field3062) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("g")
   protected synchronized class69 vmethod3708() {
      return this.field3036;
   }

   @ObfuscatedName("m")
   protected synchronized class69 vmethod3709() {
      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1878056060"
   )
   void method3611(int var1, int var2) {
      this.field3019[var1] = var2;
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3711(int[] var1, int var2, int var3) {
      if(this.field3030.method3517()) {
         int var4 = this.field3030.field2985 * this.field3016 / class59.field1219;

         do {
            long var5 = this.field3034 + (long)var4 * (long)var3;
            if(this.field3010 - var5 >= 0L) {
               this.field3034 = var5;
               break;
            }

            int var7 = (int)((this.field3010 - this.field3034 + (long)var4 - 1L) / (long)var4);
            this.field3034 += (long)var4 * (long)var7;
            this.field3036.vmethod3711(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3614();
         } while(this.field3030.method3517());
      }

      this.field3036.vmethod3711(var1, var2, var3);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   void method3614() {
      int var1 = this.field3033;
      int var2 = this.field3018;

      long var3;
      for(var3 = this.field3010; var2 == this.field3018; var3 = this.field3030.method3525(var2)) {
         while(this.field3030.field2988[var1] == var2) {
            this.field3030.method3529(var1);
            int var5 = this.field3030.method3540(var1);
            if(var5 == 1) {
               this.field3030.method3524();
               this.field3030.method3535(var1);
               if(this.field3030.method3536()) {
                  if(!this.field3031 || var2 == 0) {
                     this.method3601();
                     this.field3030.method3519();
                     return;
                  }

                  this.field3030.method3531(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3604(var5);
            }

            this.field3030.method3522(var1);
            this.field3030.method3535(var1);
         }

         var1 = this.field3030.method3530();
         var2 = this.field3030.field2988[var1];
      }

      this.field3033 = var1;
      this.field3018 = var2;
      this.field3010 = var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass190;S)Z",
      garbageValue = "1410"
   )
   boolean method3615(class190 var1) {
      if(null == var1.field3073) {
         if(var1.field3060 >= 0) {
            var1.unlink();
            if(var1.field3059 > 0 && this.field3035[var1.field3067][var1.field3059] == var1) {
               this.field3035[var1.field3067][var1.field3059] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "39"
   )
   synchronized void method3617(int var1) {
      this.field3011 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "2045472197"
   )
   synchronized boolean method3622(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3503();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2969.method3780(); null != var7; var7 = (class200)var1.field2969.method3785()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3038.method3775((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3302(var8);
            class184 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class184(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field3038.method3776(var10, (long)var8);
         }

         if(!var9.method3515(var3, var7.field3144, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3504();
      }

      return var5;
   }

   public class187() {
      this.method3601();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   void method3654(int var1, int var2) {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-120240463"
   )
   void method3659(int var1) {
      if((this.field3022[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3036.field3053.method3808(); null != var2; var2 = (class190)this.field3036.field3053.method3810()) {
            if(var1 == var2.field3067 && this.field3028[var1][var2.field3072] == null && var2.field3060 < 0) {
               var2.field3060 = 0;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1469701278"
   )
   synchronized void method3662() {
      for(class184 var1 = (class184)this.field3038.method3780(); var1 != null; var1 = (class184)this.field3038.method3785()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "-1282273400"
   )
   boolean method3665(class190 var1, int[] var2, int var3, int var4) {
      var1.field3074 = class59.field1219 / 100;
      if(var1.field3060 < 0 || var1.field3073 != null && !var1.field3073.method1433()) {
         int var5 = var1.field3065;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field3021[var1.field3067]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3065 = var5;
         }

         var1.field3073.method1323(this.method3606(var1));
         class188 var6 = var1.field3056;
         boolean var7 = false;
         ++var1.field3071;
         var1.field3068 += var6.field3048;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3072 - 60 << 8) + (var1.field3055 * var1.field3065 >> 12));
         if(var6.field3041 > 0) {
            if(var6.field3044 > 0) {
               var1.field3066 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3044) + 0.5D);
            } else {
               var1.field3066 += 128;
            }
         }

         if(var6.field3050 != null) {
            if(var6.field3042 > 0) {
               var1.field3058 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3042 * var8) + 0.5D);
            } else {
               var1.field3058 += 128;
            }

            while(var1.field3070 < var6.field3050.length - 2 && var1.field3058 > (var6.field3050[var1.field3070 + 2] & 255) << 8) {
               var1.field3070 += 2;
            }

            if(var1.field3070 == var6.field3050.length - 2 && var6.field3050[var1.field3070 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3060 >= 0 && var6.field3040 != null && (this.field3022[var1.field3067] & 1) == 0 && (var1.field3059 < 0 || var1 != this.field3035[var1.field3067][var1.field3059])) {
            if(var6.field3043 > 0) {
               var1.field3060 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3043) + 0.5D);
            } else {
               var1.field3060 += 128;
            }

            while(var1.field3064 < var6.field3040.length - 2 && var1.field3060 > (var6.field3040[var1.field3064 + 2] & 255) << 8) {
               var1.field3064 += 2;
            }

            if(var1.field3064 == var6.field3040.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3073.method1322(var1.field3074);
            if(null != var2) {
               var1.field3073.vmethod3711(var2, var3, var4);
            } else {
               var1.field3073.vmethod3712(var4);
            }

            if(var1.field3073.method1326()) {
               this.field3036.field3054.method1143(var1.field3073);
            }

            var1.method3731();
            if(var1.field3060 >= 0) {
               var1.unlink();
               if(var1.field3059 > 0 && var1 == this.field3035[var1.field3067][var1.field3059]) {
                  this.field3035[var1.field3067][var1.field3059] = null;
               }
            }

            return true;
         } else {
            var1.field3073.method1321(var1.field3074, this.method3597(var1), this.method3608(var1));
            return false;
         }
      } else {
         var1.method3731();
         var1.unlink();
         if(var1.field3059 > 0 && var1 == this.field3035[var1.field3067][var1.field3059]) {
            this.field3035[var1.field3067][var1.field3059] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2010207720"
   )
   void method3668(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-739170488"
   )
   void method3689(int var1, int var2) {
      this.field3026[var1] = var2;
      this.field3027[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3712(int var1) {
      if(this.field3030.method3517()) {
         int var2 = this.field3030.field2985 * this.field3016 / class59.field1219;

         do {
            long var3 = this.field3034 + (long)var2 * (long)var1;
            if(this.field3010 - var3 >= 0L) {
               this.field3034 = var3;
               break;
            }

            int var5 = (int)((this.field3010 - this.field3034 + (long)var2 - 1L) / (long)var2);
            this.field3034 += (long)var5 * (long)var2;
            this.field3036.vmethod3712(var5);
            var1 -= var5;
            this.method3614();
         } while(this.field3030.method3517());
      }

      this.field3036.vmethod3712(var1);
   }
}
