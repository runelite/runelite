import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
public class class187 extends class69 {
   @ObfuscatedName("a")
   int[] field3014 = new int[16];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1484168581
   )
   int field3015 = 256;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1732802041
   )
   int field3016 = 1000000;
   @ObfuscatedName("ac")
   boolean field3017;
   @ObfuscatedName("l")
   class199 field3018 = new class199(128);
   @ObfuscatedName("s")
   int[] field3019 = new int[16];
   @ObfuscatedName("q")
   int[] field3020 = new int[16];
   @ObfuscatedName("u")
   int[] field3021 = new int[16];
   @ObfuscatedName("n")
   int[] field3022 = new int[16];
   @ObfuscatedName("b")
   int[] field3023 = new int[16];
   @ObfuscatedName("m")
   int[] field3024 = new int[16];
   @ObfuscatedName("h")
   int[] field3025 = new int[16];
   @ObfuscatedName("v")
   int[] field3026 = new int[16];
   @ObfuscatedName("k")
   int[] field3027 = new int[16];
   @ObfuscatedName("x")
   int[] field3028 = new int[16];
   @ObfuscatedName("t")
   int[] field3029 = new int[16];
   @ObfuscatedName("y")
   int[] field3030 = new int[16];
   @ObfuscatedName("j")
   int[] field3031 = new int[16];
   @ObfuscatedName("ad")
   class190[][] field3033 = new class190[16][128];
   @ObfuscatedName("c")
   class190[][] field3034 = new class190[16][128];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -7938300487657102395L
   )
   long field3035;
   @ObfuscatedName("e")
   int[] field3036 = new int[16];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2031353517
   )
   int field3037;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = 7473253796947959749L
   )
   long field3038;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1739442819
   )
   int field3039;
   @ObfuscatedName("ak")
   class189 field3040 = new class189(this);
   @ObfuscatedName("as")
   class185 field3041 = new class185();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-46"
   )
   public synchronized void method3750(int var1) {
      this.field3015 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "1616268285"
   )
   public synchronized boolean method3751(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3674();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2982.method3939(); null != var7; var7 = (class200)var1.field2982.method3935()) {
         int var8 = (int)var7.field3175;
         class184 var9 = (class184)this.field3018.method3936((long)var8);
         if(var9 == null) {
            var9 = class181.method3631(var2, var8);
            if(null == var9) {
               var5 = false;
               continue;
            }

            this.field3018.method3940(var9, (long)var8);
         }

         if(!var9.method3683(var3, var7.field3152, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3670();
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "420345453"
   )
   void method3752(int var1, int var2) {
      this.field3023[var1] = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "296465848"
   )
   public synchronized void method3754() {
      this.field3041.method3692();
      this.method3769();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZI)V",
      garbageValue = "2058551464"
   )
   public synchronized void method3755(class183 var1, boolean var2) {
      this.method3754();
      this.field3041.method3691(var1.field2983);
      this.field3017 = var2;
      this.field3038 = 0L;
      int var3 = this.field3041.method3694();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3041.method3732(var4);
         this.field3041.method3705(var4);
         this.field3041.method3695(var4);
      }

      this.field3039 = this.field3041.method3702();
      this.field3037 = this.field3041.field2999[this.field3039];
      this.field3035 = this.field3041.method3710(this.field3037);
   }

   public class187() {
      this.method3769();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1716572739"
   )
   public synchronized boolean method3756() {
      return this.field3041.method3693();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1094979926"
   )
   public synchronized void method3757(int var1, int var2) {
      this.method3758(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-4346"
   )
   void method3758(int var1, int var2) {
      this.field3027[var1] = var2;
      this.field3022[var1] = var2 & -128;
      this.method3787(var1, var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-386911362"
   )
   void method3759(int var1, int var2) {
      this.field3030[var1] = var2;
      this.field3014[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1927103821"
   )
   void method3760(int var1, int var2, int var3) {
      this.method3762(var1, var2, 64);
      if((this.field3026[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3040.field3057.method3969(); var4 != null; var4 = (class190)this.field3040.field3057.method3971()) {
            if(var1 == var4.field3078 && var4.field3083 < 0) {
               this.field3034[var1][var4.field3081] = null;
               this.field3034[var1][var2] = var4;
               int var8 = (var4.field3072 * var4.field3071 >> 12) + var4.field3070;
               var4.field3070 += var2 - var4.field3081 << 8;
               var4.field3071 = var8 - var4.field3070;
               var4.field3072 = 4096;
               var4.field3081 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3018.method3936((long)this.field3021[var1]);
      if(var9 != null) {
         class65 var5 = var9.field2985[var2];
         if(null != var5) {
            class190 var6 = new class190();
            var6.field3078 = var1;
            var6.field3063 = var9;
            var6.field3067 = var5;
            var6.field3065 = var9.field2989[var2];
            var6.field3066 = var9.field2984[var2];
            var6.field3081 = var2;
            var6.field3068 = var9.field2991[var2] * var3 * var3 * var9.field2986 + 1024 >> 11;
            var6.field3069 = var9.field2988[var2] & 255;
            var6.field3070 = (var2 << 8) - (var9.field2987[var2] & 32767);
            var6.field3064 = 0;
            var6.field3080 = 0;
            var6.field3075 = 0;
            var6.field3083 = -1;
            var6.field3077 = 0;
            if(this.field3029[var1] == 0) {
               var6.field3074 = class67.method1428(var5, this.method3774(var6), this.method3775(var6), this.method3829(var6));
            } else {
               var6.field3074 = class67.method1428(var5, this.method3774(var6), 0, this.method3829(var6));
               this.method3761(var6, var9.field2987[var2] < 0);
            }

            if(var9.field2987[var2] < 0) {
               var6.field3074.method1430(-1);
            }

            if(var6.field3066 >= 0) {
               class190 var7 = this.field3033[var1][var6.field3066];
               if(null != var7 && var7.field3083 < 0) {
                  this.field3034[var1][var7.field3081] = null;
                  var7.field3083 = 0;
               }

               this.field3033[var1][var6.field3066] = var6;
            }

            this.field3040.field3057.method3963(var6);
            this.field3034[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZB)V",
      garbageValue = "14"
   )
   void method3761(class190 var1, boolean var2) {
      int var3 = var1.field3067.field1304.length;
      int var4;
      if(var2 && var1.field3067.field1305) {
         int var5 = var3 + var3 - var1.field3067.field1301;
         var4 = (int)((long)var5 * (long)this.field3029[var1.field3078] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3074.method1495();
         }
      } else {
         var4 = (int)((long)this.field3029[var1.field3078] * (long)var3 >> 6);
      }

      var1.field3074.method1436(var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2139425430"
   )
   void method3762(int var1, int var2, int var3) {
      class190 var4 = this.field3034[var1][var2];
      if(null != var4) {
         this.field3034[var1][var2] = null;
         if((this.field3026[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3040.field3057.method3980(); var5 != null; var5 = (class190)this.field3040.field3057.method3970()) {
               if(var5.field3078 == var4.field3078 && var5.field3083 < 0 && var4 != var5) {
                  var4.field3083 = 0;
                  break;
               }
            }
         } else {
            var4.field3083 = 0;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1638369985"
   )
   void method3763(int var1, int var2, int var3) {
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1700160886"
   )
   void method3764(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3762(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3760(var3, var4, var5);
         } else {
            this.method3762(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3763(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3022[var3] = (var5 << 14) + (this.field3022[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3022[var3] = (this.field3022[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field3024[var3] = (var5 << 7) + (this.field3024[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3024[var3] = var5 + (this.field3024[var3] & -128);
         }

         if(var4 == 5) {
            this.field3020[var3] = (var5 << 7) + (this.field3020[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3020[var3] = (this.field3020[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field3036[var3] = (var5 << 7) + (this.field3036[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3036[var3] = var5 + (this.field3036[var3] & -128);
         }

         if(var4 == 10) {
            this.field3025[var3] = (var5 << 7) + (this.field3025[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3025[var3] = (this.field3025[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field3019[var3] = (this.field3019[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field3019[var3] = var5 + (this.field3019[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3026[var3] |= 1;
            } else {
               this.field3026[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3026[var3] |= 2;
            } else {
               this.method3770(var3);
               this.field3026[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3031[var3] = (var5 << 7) + (this.field3031[var3] & 127);
         }

         if(var4 == 98) {
            this.field3031[var3] = (this.field3031[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field3031[var3] = (this.field3031[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3031[var3] = var5 + 16384 + (this.field3031[var3] & 16256);
         }

         if(var4 == 120) {
            this.method3766(var3);
         }

         if(var4 == 121) {
            this.method3767(var3);
         }

         if(var4 == 123) {
            this.method3768(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3028[var3] = (this.field3028[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field3031[var3];
            if(var6 == 16384) {
               this.field3028[var3] = var5 + (this.field3028[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field3029[var3] = (var5 << 7) + (this.field3029[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3029[var3] = (this.field3029[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3026[var3] |= 4;
            } else {
               this.method3771(var3);
               this.field3026[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3759(var3, (this.field3030[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3759(var3, var5 + (this.field3030[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3787(var3, var4 + this.field3022[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3806(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3752(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3769();
         }
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-53805502"
   )
   void method3766(int var1) {
      for(class190 var2 = (class190)this.field3040.field3057.method3980(); null != var2; var2 = (class190)this.field3040.field3057.method3970()) {
         if(var1 < 0 || var2.field3078 == var1) {
            if(var2.field3074 != null) {
               var2.field3074.method1431(class59.field1254 / 100);
               if(var2.field3074.method1445()) {
                  this.field3040.field3061.method1251(var2.field3074);
               }

               var2.method3895();
            }

            if(var2.field3083 < 0) {
               this.field3034[var2.field3078][var2.field3081] = null;
            }

            var2.method4067();
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   void method3767(int var1) {
      if(var1 >= 0) {
         this.field3036[var1] = 12800;
         this.field3025[var1] = 8192;
         this.field3019[var1] = 16383;
         this.field3023[var1] = 8192;
         this.field3024[var1] = 0;
         this.field3020[var1] = 8192;
         this.method3770(var1);
         this.method3771(var1);
         this.field3026[var1] = 0;
         this.field3031[var1] = 32767;
         this.field3028[var1] = 256;
         this.field3029[var1] = 0;
         this.method3759(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3767(var1);
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "116290999"
   )
   void method3768(int var1) {
      for(class190 var2 = (class190)this.field3040.field3057.method3980(); var2 != null; var2 = (class190)this.field3040.field3057.method3970()) {
         if((var1 < 0 || var2.field3078 == var1) && var2.field3083 < 0) {
            this.field3034[var2.field3078][var2.field3081] = null;
            var2.field3083 = 0;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-526557242"
   )
   void method3769() {
      this.method3766(-1);
      this.method3767(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3021[var1] = this.field3027[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3022[var1] = this.field3027[var1] & -128;
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "906498566"
   )
   void method3770(int var1) {
      if((this.field3026[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3040.field3057.method3980(); null != var2; var2 = (class190)this.field3040.field3057.method3970()) {
            if(var2.field3078 == var1 && this.field3034[var1][var2.field3081] == null && var2.field3083 < 0) {
               var2.field3083 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-132160441"
   )
   void method3771(int var1) {
      if((this.field3026[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3040.field3057.method3980(); null != var2; var2 = (class190)this.field3040.field3057.method3970()) {
            if(var2.field3078 == var1) {
               var2.field3082 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "14"
   )
   int method3774(class190 var1) {
      int var2 = var1.field3070 + (var1.field3071 * var1.field3072 >> 12);
      var2 += (this.field3023[var1.field3078] - 8192) * this.field3028[var1.field3078] >> 12;
      class188 var3 = var1.field3065;
      int var4;
      if(var3.field3049 > 0 && (var3.field3048 > 0 || this.field3024[var1.field3078] > 0)) {
         var4 = var3.field3048 << 2;
         int var5 = var3.field3054 << 1;
         if(var1.field3062 < var5) {
            var4 = var4 * var1.field3062 / var5;
         }

         var4 += this.field3024[var1.field3078] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3079 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(256 * var1.field3067.field1302) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class59.field1254 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-925202309"
   )
   int method3775(class190 var1) {
      class188 var2 = var1.field3065;
      int var3 = this.field3019[var1.field3078] * this.field3036[var1.field3078] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var1.field3068 * var3 >> 15;
      var3 = 128 + this.field3015 * var3 >> 8;
      if(var2.field3044 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3044 * 1.953125E-5D * (double)var1.field3064) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3050) {
         var4 = var1.field3080;
         var5 = var2.field3050[1 + var1.field3075];
         if(var1.field3075 < var2.field3050.length - 2) {
            var6 = (var2.field3050[var1.field3075] & 255) << 8;
            var7 = (var2.field3050[var1.field3075 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3050[var1.field3075 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3083 > 0 && var2.field3043 != null) {
         var4 = var1.field3083;
         var5 = var2.field3043[1 + var1.field3077];
         if(var1.field3077 < var2.field3043.length - 2) {
            var6 = (var2.field3043[var1.field3077] & 255) << 8;
            var7 = (var2.field3043[2 + var1.field3077] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3043[var1.field3077 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("s")
   protected synchronized class69 vmethod3870() {
      return this.field3040;
   }

   @ObfuscatedName("k")
   protected synchronized class69 vmethod3871() {
      return null;
   }

   @ObfuscatedName("u")
   protected synchronized int vmethod3872() {
      return 0;
   }

   @ObfuscatedName("n")
   protected synchronized void vmethod3873(int[] var1, int var2, int var3) {
      if(this.field3041.method3693()) {
         int var4 = this.field3041.field3005 * this.field3016 / class59.field1254;

         do {
            long var5 = this.field3038 + (long)var3 * (long)var4;
            if(this.field3035 - var5 >= 0L) {
               this.field3038 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3035 - this.field3038) - 1L) / (long)var4);
            this.field3038 += (long)var4 * (long)var7;
            this.field3040.vmethod3873(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3795();
         } while(this.field3041.method3693());
      }

      this.field3040.vmethod3873(var1, var2, var3);
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod3874(int var1) {
      if(this.field3041.method3693()) {
         int var2 = this.field3016 * this.field3041.field3005 / class59.field1254;

         do {
            long var3 = (long)var2 * (long)var1 + this.field3038;
            if(this.field3035 - var3 >= 0L) {
               this.field3038 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3035 - this.field3038) - 1L) / (long)var2);
            this.field3038 += (long)var5 * (long)var2;
            this.field3040.vmethod3874(var5);
            var1 -= var5;
            this.method3795();
         } while(this.field3041.method3693());
      }

      this.field3040.vmethod3874(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-997592831"
   )
   public synchronized void method3782() {
      for(class184 var1 = (class184)this.field3018.method3939(); var1 != null; var1 = (class184)this.field3018.method3935()) {
         var1.method4067();
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "1814100268"
   )
   boolean method3783(class190 var1) {
      if(var1.field3074 == null) {
         if(var1.field3083 >= 0) {
            var1.method4067();
            if(var1.field3066 > 0 && this.field3033[var1.field3078][var1.field3066] == var1) {
               this.field3033[var1.field3078][var1.field3066] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "-189259618"
   )
   boolean method3784(class190 var1, int[] var2, int var3, int var4) {
      var1.field3073 = class59.field1254 / 100;
      if(var1.field3083 < 0 || null != var1.field3074 && !var1.field3074.method1528()) {
         int var5 = var1.field3072;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3020[var1.field3078] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3072 = var5;
         }

         var1.field3074.method1442(this.method3774(var1));
         class188 var6 = var1.field3065;
         boolean var7 = false;
         ++var1.field3062;
         var1.field3079 += var6.field3049;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3071 * var1.field3072 >> 12) + (var1.field3081 - 60 << 8));
         if(var6.field3044 > 0) {
            if(var6.field3047 > 0) {
               var1.field3064 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3047 * var8) + 0.5D);
            } else {
               var1.field3064 += 128;
            }
         }

         if(null != var6.field3050) {
            if(var6.field3045 > 0) {
               var1.field3080 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3045) + 0.5D);
            } else {
               var1.field3080 += 128;
            }

            while(var1.field3075 < var6.field3050.length - 2 && var1.field3080 > (var6.field3050[var1.field3075 + 2] & 255) << 8) {
               var1.field3075 += 2;
            }

            if(var1.field3075 == var6.field3050.length - 2 && var6.field3050[var1.field3075 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3083 >= 0 && var6.field3043 != null && (this.field3026[var1.field3078] & 1) == 0 && (var1.field3066 < 0 || var1 != this.field3033[var1.field3078][var1.field3066])) {
            if(var6.field3042 > 0) {
               var1.field3083 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3042) + 0.5D);
            } else {
               var1.field3083 += 128;
            }

            while(var1.field3077 < var6.field3043.length - 2 && var1.field3083 > (var6.field3043[var1.field3077 + 2] & 255) << 8) {
               var1.field3077 += 2;
            }

            if(var1.field3077 == var6.field3043.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3074.method1431(var1.field3073);
            if(var2 != null) {
               var1.field3074.vmethod3873(var2, var3, var4);
            } else {
               var1.field3074.vmethod3874(var4);
            }

            if(var1.field3074.method1445()) {
               this.field3040.field3061.method1251(var1.field3074);
            }

            var1.method3895();
            if(var1.field3083 >= 0) {
               var1.method4067();
               if(var1.field3066 > 0 && this.field3033[var1.field3078][var1.field3066] == var1) {
                  this.field3033[var1.field3078][var1.field3066] = null;
               }
            }

            return true;
         } else {
            var1.field3074.method1440(var1.field3073, this.method3775(var1), this.method3829(var1));
            return false;
         }
      } else {
         var1.method3895();
         var1.method4067();
         if(var1.field3066 > 0 && this.field3033[var1.field3078][var1.field3066] == var1) {
            this.field3033[var1.field3078][var1.field3066] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "56"
   )
   void method3787(int var1, int var2) {
      if(var2 != this.field3021[var1]) {
         this.field3021[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3033[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1126281588"
   )
   void method3795() {
      int var1 = this.field3039;
      int var2 = this.field3037;

      long var3;
      for(var3 = this.field3035; var2 == this.field3037; var3 = this.field3041.method3710(var2)) {
         while(var2 == this.field3041.field2999[var1]) {
            this.field3041.method3732(var1);
            int var5 = this.field3041.method3698(var1);
            if(var5 == 1) {
               this.field3041.method3697();
               this.field3041.method3695(var1);
               if(this.field3041.method3725()) {
                  if(!this.field3017 || var2 == 0) {
                     this.method3769();
                     this.field3041.method3692();
                     return;
                  }

                  this.field3041.method3704(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3764(var5);
            }

            this.field3041.method3705(var1);
            this.field3041.method3695(var1);
         }

         var1 = this.field3041.method3702();
         var2 = this.field3041.field2999[var1];
      }

      this.field3039 = var1;
      this.field3037 = var2;
      this.field3035 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-668162334"
   )
   void method3806(int var1, int var2) {
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-1693965049"
   )
   int method3829(class190 var1) {
      int var2 = this.field3025[var1.field3078];
      return var2 < 8192?32 + var2 * var1.field3069 >> 6:16384 - ((128 - var1.field3069) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "19272"
   )
   public synchronized void method3839() {
      for(class184 var1 = (class184)this.field3018.method3939(); var1 != null; var1 = (class184)this.field3018.method3935()) {
         var1.method3679();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method3862() {
      return this.field3015;
   }
}
