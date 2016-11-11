import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class187 extends class69 {
   @ObfuscatedName("l")
   int[] field3018 = new int[16];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -337561061
   )
   int field3019 = 256;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1934064145
   )
   int field3020 = 1000000;
   @ObfuscatedName("g")
   int[] field3021 = new int[16];
   @ObfuscatedName("n")
   int[] field3022 = new int[16];
   @ObfuscatedName("u")
   int[] field3023 = new int[16];
   @ObfuscatedName("d")
   int[] field3024 = new int[16];
   @ObfuscatedName("ag")
   class189 field3025 = new class189(this);
   @ObfuscatedName("m")
   int[] field3026 = new int[16];
   @ObfuscatedName("j")
   int[] field3027 = new int[16];
   @ObfuscatedName("t")
   int[] field3028 = new int[16];
   @ObfuscatedName("ad")
   boolean field3029;
   @ObfuscatedName("as")
   class185 field3030 = new class185();
   @ObfuscatedName("q")
   int[] field3031 = new int[16];
   @ObfuscatedName("o")
   int[] field3032 = new int[16];
   @ObfuscatedName("f")
   int[] field3033 = new int[16];
   @ObfuscatedName("b")
   int[] field3034 = new int[16];
   @ObfuscatedName("z")
   int[] field3035 = new int[16];
   @ObfuscatedName("y")
   int[] field3036 = new int[16];
   @ObfuscatedName("am")
   class190[][] field3037 = new class190[16][128];
   @ObfuscatedName("i")
   XHashTable field3038 = new XHashTable(128);
   @ObfuscatedName("a")
   class190[][] field3039 = new class190[16][128];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -342594469
   )
   int field3040;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1583705967
   )
   int field3041;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = -2997464122041355009L
   )
   long field3043;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = 4591810885463796401L
   )
   long field3044;
   @ObfuscatedName("s")
   int[] field3045 = new int[16];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-10"
   )
   public synchronized void method3625(int var1) {
      this.field3019 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-662012395"
   )
   int method3626() {
      return this.field3019;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "232123601"
   )
   public synchronized void method3628() {
      for(class184 var1 = (class184)this.field3038.method3815(); var1 != null; var1 = (class184)this.field3038.method3816()) {
         var1.method3558();
      }

   }

   public class187() {
      this.method3644();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZI)V",
      garbageValue = "-1390726847"
   )
   public synchronized void method3629(class183 var1, boolean var2) {
      this.method3725();
      this.field3030.method3565(var1.field2984);
      this.field3029 = var2;
      this.field3044 = 0L;
      int var3 = this.field3030.method3567();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3030.method3614(var4);
         this.field3030.method3571(var4);
         this.field3030.method3569(var4);
      }

      this.field3040 = this.field3030.method3576();
      this.field3041 = this.field3030.field3009[this.field3040];
      this.field3043 = this.field3030.method3597(this.field3041);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-814589124"
   )
   public synchronized boolean method3631() {
      return this.field3030.method3598();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-42"
   )
   public synchronized void method3632(int var1, int var2) {
      this.method3633(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "3912"
   )
   void method3633(int var1, int var2) {
      this.field3024[var1] = var2;
      this.field3026[var1] = var2 & -128;
      this.method3634(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-41"
   )
   void method3634(int var1, int var2) {
      if(var2 != this.field3018[var1]) {
         this.field3018[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3037[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "24"
   )
   void method3635(int var1, int var2, int var3) {
      this.method3637(var1, var2, 64);
      if((this.field3035[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3025.field3059.method3846(); null != var4; var4 = (class190)this.field3025.field3059.method3848()) {
            if(var4.field3077 == var1 && var4.field3080 < 0) {
               this.field3039[var1][var4.field3075] = null;
               this.field3039[var1][var2] = var4;
               int var5 = var4.field3074 + (var4.field3076 * var4.field3082 >> 12);
               var4.field3074 += var2 - var4.field3075 << 8;
               var4.field3082 = var5 - var4.field3074;
               var4.field3076 = 4096;
               var4.field3075 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3038.method3812((long)this.field3018[var1]);
      if(var9 != null) {
         class65 var8 = var9.field2986[var2];
         if(null != var8) {
            class190 var6 = new class190();
            var6.field3077 = var1;
            var6.field3066 = var9;
            var6.field3085 = var8;
            var6.field3069 = var9.field2993[var2];
            var6.field3070 = var9.field2990[var2];
            var6.field3075 = var2;
            var6.field3072 = var3 * var3 * var9.field2991 * var9.field2988[var2] + 1024 >> 11;
            var6.field3073 = var9.field2989[var2] & 255;
            var6.field3074 = (var2 << 8) - (var9.field2987[var2] & 32767);
            var6.field3071 = 0;
            var6.field3079 = 0;
            var6.field3078 = 0;
            var6.field3080 = -1;
            var6.field3081 = 0;
            if(this.field3033[var1] == 0) {
               var6.field3084 = class67.method1348(var8, this.method3649(var6), this.method3636(var6), this.method3645(var6));
            } else {
               var6.field3084 = class67.method1348(var8, this.method3649(var6), 0, this.method3645(var6));
               this.method3712(var6, var9.field2987[var2] < 0);
            }

            if(var9.field2987[var2] < 0) {
               var6.field3084.method1376(-1);
            }

            if(var6.field3070 >= 0) {
               class190 var7 = this.field3037[var1][var6.field3070];
               if(var7 != null && var7.field3080 < 0) {
                  this.field3039[var1][var7.field3075] = null;
                  var7.field3080 = 0;
               }

               this.field3037[var1][var6.field3070] = var6;
            }

            this.field3025.field3059.method3865(var6);
            this.field3039[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-1616855050"
   )
   int method3636(class190 var1) {
      class188 var2 = var1.field3069;
      int var3 = this.field3023[var1.field3077] * this.field3021[var1.field3077] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field3072 * var3 + 16384 >> 15;
      var3 = var3 * this.field3019 + 128 >> 8;
      if(var2.field3048 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field3071 * (double)var2.field3048) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field3047 != null) {
         var4 = var1.field3079;
         var5 = var2.field3047[var1.field3078 + 1];
         if(var1.field3078 < var2.field3047.length - 2) {
            var6 = (var2.field3047[var1.field3078] & 255) << 8;
            var7 = (var2.field3047[var1.field3078 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3047[var1.field3078 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3080 > 0 && var2.field3057 != null) {
         var4 = var1.field3080;
         var5 = var2.field3057[1 + var1.field3081];
         if(var1.field3081 < var2.field3057.length - 2) {
            var6 = (var2.field3057[var1.field3081] & 255) << 8;
            var7 = (var2.field3057[var1.field3081 + 2] & 255) << 8;
            var5 += (var2.field3057[3 + var1.field3081] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "9"
   )
   void method3637(int var1, int var2, int var3) {
      class190 var4 = this.field3039[var1][var2];
      if(var4 != null) {
         this.field3039[var1][var2] = null;
         if((this.field3035[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3025.field3059.method3845(); null != var5; var5 = (class190)this.field3025.field3059.method3847()) {
               if(var4.field3077 == var5.field3077 && var5.field3080 < 0 && var4 != var5) {
                  var4.field3080 = 0;
                  break;
               }
            }
         } else {
            var4.field3080 = 0;
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-20544975"
   )
   void method3641(int var1) {
      for(class190 var2 = (class190)this.field3025.field3059.method3845(); null != var2; var2 = (class190)this.field3025.field3059.method3847()) {
         if(var1 < 0 || var2.field3077 == var1) {
            if(var2.field3084 != null) {
               var2.field3084.method1361(class59.field1239 / 100);
               if(var2.field3084.method1365()) {
                  this.field3025.field3064.method1177(var2.field3084);
               }

               var2.method3767();
            }

            if(var2.field3080 < 0) {
               this.field3039[var2.field3077][var2.field3075] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "115"
   )
   void method3642(int var1) {
      if(var1 >= 0) {
         this.field3021[var1] = 12800;
         this.field3022[var1] = 8192;
         this.field3023[var1] = 16383;
         this.field3027[var1] = 8192;
         this.field3036[var1] = 0;
         this.field3045[var1] = 8192;
         this.method3663(var1);
         this.method3662(var1);
         this.field3035[var1] = 0;
         this.field3031[var1] = 32767;
         this.field3032[var1] = 256;
         this.field3033[var1] = 0;
         this.method3648(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3642(var1);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-7"
   )
   void method3643(int var1) {
      for(class190 var2 = (class190)this.field3025.field3059.method3845(); null != var2; var2 = (class190)this.field3025.field3059.method3847()) {
         if((var1 < 0 || var1 == var2.field3077) && var2.field3080 < 0) {
            this.field3039[var2.field3077][var2.field3075] = null;
            var2.field3080 = 0;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   void method3644() {
      this.method3641(-1);
      this.method3642(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3018[var1] = this.field3024[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3026[var1] = this.field3024[var1] & -128;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "104"
   )
   int method3645(class190 var1) {
      int var2 = this.field3022[var1.field3077];
      return var2 < 8192?32 + var2 * var1.field3073 >> 6:16384 - ((128 - var1.field3073) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "578138018"
   )
   void method3646(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3637(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3635(var3, var4, var5);
         } else {
            this.method3637(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3713(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3026[var3] = (var5 << 14) + (this.field3026[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3026[var3] = (var5 << 7) + (this.field3026[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3036[var3] = (this.field3036[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field3036[var3] = (this.field3036[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field3045[var3] = (this.field3045[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field3045[var3] = var5 + (this.field3045[var3] & -128);
         }

         if(var4 == 7) {
            this.field3021[var3] = (var5 << 7) + (this.field3021[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3021[var3] = var5 + (this.field3021[var3] & -128);
         }

         if(var4 == 10) {
            this.field3022[var3] = (var5 << 7) + (this.field3022[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3022[var3] = var5 + (this.field3022[var3] & -128);
         }

         if(var4 == 11) {
            this.field3023[var3] = (var5 << 7) + (this.field3023[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3023[var3] = var5 + (this.field3023[var3] & -128);
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
               this.method3663(var3);
               this.field3035[var3] &= -3;
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
            this.field3031[var3] = var5 + (this.field3031[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3641(var3);
         }

         if(var4 == 121) {
            this.method3642(var3);
         }

         if(var4 == 123) {
            this.method3643(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3032[var3] = (this.field3032[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3032[var3] = (this.field3032[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field3033[var3] = (this.field3033[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field3033[var3] = var5 + (this.field3033[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3035[var3] |= 4;
            } else {
               this.method3662(var3);
               this.field3035[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3648(var3, (var5 << 7) + (this.field3034[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3648(var3, var5 + (this.field3034[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3634(var3, this.field3026[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3687(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3711(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3644();
         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1493640834"
   )
   void method3648(int var1, int var2) {
      this.field3034[var1] = var2;
      this.field3028[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-432090959"
   )
   int method3649(class190 var1) {
      int var2 = (var1.field3076 * var1.field3082 >> 12) + var1.field3074;
      var2 += (this.field3027[var1.field3077] - 8192) * this.field3032[var1.field3077] >> 12;
      class188 var3 = var1.field3069;
      int var4;
      if(var3.field3053 > 0 && (var3.field3055 > 0 || this.field3036[var1.field3077] > 0)) {
         var4 = var3.field3055 << 2;
         int var5 = var3.field3054 << 1;
         if(var1.field3068 < var5) {
            var4 = var1.field3068 * var4 / var5;
         }

         var4 += this.field3036[var1.field3077] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3083 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3085.field1285 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class59.field1239 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("u")
   protected synchronized class69 vmethod3756() {
      return this.field3025;
   }

   @ObfuscatedName("d")
   protected synchronized class69 vmethod3744() {
      return null;
   }

   @ObfuscatedName("l")
   protected synchronized int vmethod3745() {
      return 0;
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod3746(int[] var1, int var2, int var3) {
      if(this.field3030.method3598()) {
         int var4 = this.field3020 * this.field3030.field2997 / class59.field1239;

         do {
            long var5 = (long)var3 * (long)var4 + this.field3044;
            if(this.field3043 - var5 >= 0L) {
               this.field3044 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3043 - this.field3044) - 1L) / (long)var4);
            this.field3044 += (long)var7 * (long)var4;
            this.field3025.vmethod3746(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3657();
         } while(this.field3030.method3598());
      }

      this.field3025.vmethod3746(var1, var2, var3);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1931282989"
   )
   void method3657() {
      int var1 = this.field3040;
      int var2 = this.field3041;

      long var3;
      for(var3 = this.field3043; this.field3041 == var2; var3 = this.field3030.method3597(var2)) {
         while(this.field3030.field3009[var1] == var2) {
            this.field3030.method3614(var1);
            int var5 = this.field3030.method3572(var1);
            if(var5 == 1) {
               this.field3030.method3570();
               this.field3030.method3569(var1);
               if(this.field3030.method3568()) {
                  if(!this.field3029 || var2 == 0) {
                     this.method3644();
                     this.field3030.method3563();
                     return;
                  }

                  this.field3030.method3577(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3646(var5);
            }

            this.field3030.method3571(var1);
            this.field3030.method3569(var1);
         }

         var1 = this.field3030.method3576();
         var2 = this.field3030.field3009[var1];
      }

      this.field3040 = var1;
      this.field3041 = var2;
      this.field3043 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "-1405255989"
   )
   boolean method3658(class190 var1) {
      if(null == var1.field3084) {
         if(var1.field3080 >= 0) {
            var1.unlink();
            if(var1.field3070 > 0 && var1 == this.field3037[var1.field3077][var1.field3070]) {
               this.field3037[var1.field3077][var1.field3070] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "806175170"
   )
   synchronized void method3661() {
      for(class184 var1 = (class184)this.field3038.method3815(); null != var1; var1 = (class184)this.field3038.method3816()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1560965396"
   )
   void method3662(int var1) {
      if((this.field3035[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3025.field3059.method3845(); var2 != null; var2 = (class190)this.field3025.field3059.method3847()) {
            if(var2.field3077 == var1) {
               var2.field3086 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1269160755"
   )
   void method3663(int var1) {
      if((this.field3035[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3025.field3059.method3845(); null != var2; var2 = (class190)this.field3025.field3059.method3847()) {
            if(var1 == var2.field3077 && this.field3039[var1][var2.field3075] == null && var2.field3080 < 0) {
               var2.field3080 = 0;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;IS)Z",
      garbageValue = "3610"
   )
   public synchronized boolean method3664(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3543();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2983.method3815(); null != var7; var7 = (class200)var1.field2983.method3816()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3038.method3812((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3311(var8);
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

            this.field3038.method3813(var10, (long)var8);
         }

         if(!var9.method3555(var3, var7.field3152, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3545();
      }

      return var5;
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod3743(int var1) {
      if(this.field3030.method3598()) {
         int var2 = this.field3030.field2997 * this.field3020 / class59.field1239;

         do {
            long var3 = (long)var1 * (long)var2 + this.field3044;
            if(this.field3043 - var3 >= 0L) {
               this.field3044 = var3;
               break;
            }

            int var5 = (int)((this.field3043 - this.field3044 + (long)var2 - 1L) / (long)var2);
            this.field3044 += (long)var5 * (long)var2;
            this.field3025.vmethod3743(var5);
            var1 -= var5;
            this.method3657();
         } while(this.field3030.method3598());
      }

      this.field3025.vmethod3743(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "955252227"
   )
   void method3687(int var1, int var2) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1104790925"
   )
   void method3711(int var1, int var2) {
      this.field3027[var1] = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZI)V",
      garbageValue = "681874782"
   )
   void method3712(class190 var1, boolean var2) {
      int var3 = var1.field3085.field1288.length;
      int var4;
      if(var2 && var1.field3085.field1284) {
         int var5 = var3 + var3 - var1.field3085.field1286;
         var4 = (int)((long)this.field3033[var1.field3077] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3084.method1357();
         }
      } else {
         var4 = (int)((long)this.field3033[var1.field3077] * (long)var3 >> 6);
      }

      var1.field3084.method1356(var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-73"
   )
   void method3713(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-44"
   )
   public synchronized void method3725() {
      this.field3030.method3563();
      this.method3644();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "-16711936"
   )
   boolean method3732(class190 var1, int[] var2, int var3, int var4) {
      var1.field3067 = class59.field1239 / 100;
      if(var1.field3080 < 0 || null != var1.field3084 && !var1.field3084.method1350()) {
         int var5 = var1.field3076;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3045[var1.field3077] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3076 = var5;
         }

         var1.field3084.method1411(this.method3649(var1));
         class188 var6 = var1.field3069;
         boolean var7 = false;
         ++var1.field3068;
         var1.field3083 += var6.field3053;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3075 - 60 << 8) + (var1.field3076 * var1.field3082 >> 12));
         if(var6.field3048 > 0) {
            if(var6.field3051 > 0) {
               var1.field3071 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3051 * var8) + 0.5D);
            } else {
               var1.field3071 += 128;
            }
         }

         if(var6.field3047 != null) {
            if(var6.field3049 > 0) {
               var1.field3079 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3049 * var8) + 0.5D);
            } else {
               var1.field3079 += 128;
            }

            while(var1.field3078 < var6.field3047.length - 2 && var1.field3079 > (var6.field3047[var1.field3078 + 2] & 255) << 8) {
               var1.field3078 += 2;
            }

            if(var6.field3047.length - 2 == var1.field3078 && var6.field3047[var1.field3078 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3080 >= 0 && null != var6.field3057 && (this.field3035[var1.field3077] & 1) == 0 && (var1.field3070 < 0 || this.field3037[var1.field3077][var1.field3070] != var1)) {
            if(var6.field3050 > 0) {
               var1.field3080 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3050) + 0.5D);
            } else {
               var1.field3080 += 128;
            }

            while(var1.field3081 < var6.field3057.length - 2 && var1.field3080 > (var6.field3057[var1.field3081 + 2] & 255) << 8) {
               var1.field3081 += 2;
            }

            if(var1.field3081 == var6.field3057.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3084.method1361(var1.field3067);
            if(null != var2) {
               var1.field3084.vmethod3746(var2, var3, var4);
            } else {
               var1.field3084.vmethod3743(var4);
            }

            if(var1.field3084.method1365()) {
               this.field3025.field3064.method1177(var1.field3084);
            }

            var1.method3767();
            if(var1.field3080 >= 0) {
               var1.unlink();
               if(var1.field3070 > 0 && var1 == this.field3037[var1.field3077][var1.field3070]) {
                  this.field3037[var1.field3077][var1.field3070] = null;
               }
            }

            return true;
         } else {
            var1.field3084.method1360(var1.field3067, this.method3636(var1), this.method3645(var1));
            return false;
         }
      } else {
         var1.method3767();
         var1.unlink();
         if(var1.field3070 > 0 && var1 == this.field3037[var1.field3077][var1.field3070]) {
            this.field3037[var1.field3077][var1.field3070] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "1939055604"
   )
   static final void method3741(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         CollisionData.field1945.method3301(var2);
         if(Widget.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(null != Widget.widgets[var2][var5]) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               Widget.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      for(class204 var4 = (class204)Client.widgetFlags.method3815(); null != var4; var4 = (class204)Client.widgetFlags.method3816()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var7 = class173.method3412(var3);
      if(null != var7) {
         class32.method673(var7);
      }

      class43.method895();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(class14.method172(var5)) {
            class49.method1007(Widget.widgets[var5], 1);
         }
      }

   }
}
