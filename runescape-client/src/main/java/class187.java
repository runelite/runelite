import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class187 extends class69 {
   @ObfuscatedName("f")
   class190[][] field3025 = new class190[16][128];
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2019428659
   )
   int field3026 = 256;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1667862669
   )
   int field3027;
   @ObfuscatedName("r")
   int[] field3028 = new int[16];
   @ObfuscatedName("z")
   int[] field3029 = new int[16];
   @ObfuscatedName("m")
   int[] field3030 = new int[16];
   @ObfuscatedName("x")
   int[] field3031 = new int[16];
   @ObfuscatedName("i")
   int[] field3032 = new int[16];
   @ObfuscatedName("g")
   int[] field3033 = new int[16];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -2681018290479254559L
   )
   long field3034;
   @ObfuscatedName("k")
   int[] field3035 = new int[16];
   @ObfuscatedName("as")
   class185 field3036 = new class185();
   @ObfuscatedName("y")
   int[] field3037 = new int[16];
   @ObfuscatedName("s")
   int[] field3038 = new int[16];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1335505531
   )
   int field3039 = 1000000;
   @ObfuscatedName("h")
   int[] field3040 = new int[16];
   @ObfuscatedName("l")
   int[] field3041 = new int[16];
   @ObfuscatedName("c")
   int[] field3042 = new int[16];
   @ObfuscatedName("e")
   int[] field3043 = new int[16];
   @ObfuscatedName("ac")
   class190[][] field3044 = new class190[16][128];
   @ObfuscatedName("t")
   int[] field3045 = new int[16];
   @ObfuscatedName("af")
   boolean field3046;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2106032829
   )
   int field3047;
   @ObfuscatedName("n")
   int[] field3048 = new int[16];
   @ObfuscatedName("a")
   XHashTable field3049 = new XHashTable(128);
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -3935657289085564791L
   )
   long field3050;
   @ObfuscatedName("av")
   class189 field3051 = new class189(this);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-116"
   )
   int method3631() {
      return this.field3026;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1386591413"
   )
   synchronized void method3632() {
      for(class184 var1 = (class184)this.field3049.method3820(); var1 != null; var1 = (class184)this.field3049.method3827()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass183;ZB)V",
      garbageValue = "-41"
   )
   synchronized void method3635(class183 var1, boolean var2) {
      this.method3671();
      this.field3036.method3563(var1.field2987);
      this.field3046 = var2;
      this.field3034 = 0L;
      int var3 = this.field3036.method3586();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3036.method3567(var4);
         this.field3036.method3570(var4);
         this.field3036.method3568(var4);
      }

      this.field3047 = this.field3036.method3575();
      this.field3027 = this.field3036.field3002[this.field3047];
      this.field3050 = this.field3036.method3574(this.field3027);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   public synchronized void method3638(int var1, int var2) {
      this.method3639(var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "64"
   )
   void method3639(int var1, int var2) {
      this.field3048[var1] = var2;
      this.field3033[var1] = var2 & -128;
      this.method3688(var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-165056774"
   )
   void method3641(int var1, int var2, int var3) {
      this.method3643(var1, var2, 64);
      if((this.field3037[var1] & 2) != 0) {
         for(class190 var4 = (class190)this.field3051.field3064.method3855(); var4 != null; var4 = (class190)this.field3051.field3064.method3879()) {
            if(var1 == var4.field3071 && var4.field3088 < 0) {
               this.field3025[var1][var4.field3073] = null;
               this.field3025[var1][var2] = var4;
               int var8 = (var4.field3078 * var4.field3077 >> 12) + var4.field3076;
               var4.field3076 += var2 - var4.field3073 << 8;
               var4.field3077 = var8 - var4.field3076;
               var4.field3078 = 4096;
               var4.field3073 = var2;
               return;
            }
         }
      }

      class184 var9 = (class184)this.field3049.method3817((long)this.field3032[var1]);
      if(var9 != null) {
         class65 var5 = var9.field2992[var2];
         if(var5 != null) {
            class190 var6 = new class190();
            var6.field3071 = var1;
            var6.field3069 = var9;
            var6.field3070 = var5;
            var6.field3082 = var9.field2994[var2];
            var6.field3072 = var9.field2989[var2];
            var6.field3073 = var2;
            var6.field3074 = var9.field2991 * var3 * var3 * var9.field2995[var2] + 1024 >> 11;
            var6.field3081 = var9.field2993[var2] & 255;
            var6.field3076 = (var2 << 8) - (var9.field2997[var2] & 32767);
            var6.field3079 = 0;
            var6.field3080 = 0;
            var6.field3086 = 0;
            var6.field3088 = -1;
            var6.field3068 = 0;
            if(this.field3040[var1] == 0) {
               var6.field3075 = class67.method1350(var5, this.method3655(var6), this.method3706(var6), this.method3657(var6));
            } else {
               var6.field3075 = class67.method1350(var5, this.method3655(var6), 0, this.method3657(var6));
               this.method3685(var6, var9.field2997[var2] < 0);
            }

            if(var9.field2997[var2] < 0) {
               var6.field3075.method1430(-1);
            }

            if(var6.field3072 >= 0) {
               class190 var7 = this.field3044[var1][var6.field3072];
               if(null != var7 && var7.field3088 < 0) {
                  this.field3025[var1][var7.field3073] = null;
                  var7.field3088 = 0;
               }

               this.field3044[var1][var6.field3072] = var6;
            }

            this.field3051.field3064.method3849(var6);
            this.field3025[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-803601834"
   )
   public synchronized void method3642(int var1) {
      this.field3026 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-15790162"
   )
   void method3643(int var1, int var2, int var3) {
      class190 var4 = this.field3025[var1][var2];
      if(null != var4) {
         this.field3025[var1][var2] = null;
         if((this.field3037[var1] & 2) != 0) {
            for(class190 var5 = (class190)this.field3051.field3064.method3854(); null != var5; var5 = (class190)this.field3051.field3064.method3869()) {
               if(var5.field3071 == var4.field3071 && var5.field3088 < 0 && var5 != var4) {
                  var4.field3088 = 0;
                  break;
               }
            }
         } else {
            var4.field3088 = 0;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1607903997"
   )
   void method3644(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-496081671"
   )
   void method3645(int var1, int var2) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "93"
   )
   void method3647(int var1) {
      for(class190 var2 = (class190)this.field3051.field3064.method3854(); var2 != null; var2 = (class190)this.field3051.field3064.method3869()) {
         if(var1 < 0 || var1 == var2.field3071) {
            if(var2.field3075 != null) {
               var2.field3075.method1453(class59.field1265 / 100);
               if(var2.field3075.method1367()) {
                  this.field3051.field3067.method1187(var2.field3075);
               }

               var2.method3771();
            }

            if(var2.field3088 < 0) {
               this.field3025[var2.field3071][var2.field3073] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-385206125"
   )
   void method3649(int var1) {
      for(class190 var2 = (class190)this.field3051.field3064.method3854(); var2 != null; var2 = (class190)this.field3051.field3064.method3869()) {
         if((var1 < 0 || var2.field3071 == var1) && var2.field3088 < 0) {
            this.field3025[var2.field3071][var2.field3073] = null;
            var2.field3088 = 0;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "167369518"
   )
   void method3651(int var1) {
      if((this.field3037[var1] & 2) != 0) {
         for(class190 var2 = (class190)this.field3051.field3064.method3854(); null != var2; var2 = (class190)this.field3051.field3064.method3869()) {
            if(var1 == var2.field3071 && this.field3025[var1][var2.field3073] == null && var2.field3088 < 0) {
               var2.field3088 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "74"
   )
   void method3652(int var1) {
      if((this.field3037[var1] & 4) != 0) {
         for(class190 var2 = (class190)this.field3051.field3064.method3854(); null != var2; var2 = (class190)this.field3051.field3064.method3869()) {
            if(var2.field3071 == var1) {
               var2.field3090 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1368803930"
   )
   void method3653(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3643(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3641(var3, var4, var5);
         } else {
            this.method3643(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3644(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field3033[var3] = (var5 << 14) + (this.field3033[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field3033[var3] = (var5 << 7) + (this.field3033[var3] & -16257);
         }

         if(var4 == 1) {
            this.field3035[var3] = (var5 << 7) + (this.field3035[var3] & -16257);
         }

         if(var4 == 33) {
            this.field3035[var3] = var5 + (this.field3035[var3] & -128);
         }

         if(var4 == 5) {
            this.field3031[var3] = (var5 << 7) + (this.field3031[var3] & -16257);
         }

         if(var4 == 37) {
            this.field3031[var3] = var5 + (this.field3031[var3] & -128);
         }

         if(var4 == 7) {
            this.field3028[var3] = (var5 << 7) + (this.field3028[var3] & -16257);
         }

         if(var4 == 39) {
            this.field3028[var3] = (this.field3028[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field3029[var3] = (var5 << 7) + (this.field3029[var3] & -16257);
         }

         if(var4 == 42) {
            this.field3029[var3] = var5 + (this.field3029[var3] & -128);
         }

         if(var4 == 11) {
            this.field3045[var3] = (this.field3045[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field3045[var3] = var5 + (this.field3045[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field3037[var3] |= 1;
            } else {
               this.field3037[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field3037[var3] |= 2;
            } else {
               this.method3651(var3);
               this.field3037[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field3038[var3] = (var5 << 7) + (this.field3038[var3] & 127);
         }

         if(var4 == 98) {
            this.field3038[var3] = (this.field3038[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field3038[var3] = (this.field3038[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field3038[var3] = (this.field3038[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method3647(var3);
         }

         if(var4 == 121) {
            this.method3717(var3);
         }

         if(var4 == 123) {
            this.method3649(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field3038[var3];
            if(var6 == 16384) {
               this.field3043[var3] = (var5 << 7) + (this.field3043[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field3038[var3];
            if(var6 == 16384) {
               this.field3043[var3] = var5 + (this.field3043[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field3040[var3] = (var5 << 7) + (this.field3040[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3040[var3] = var5 + (this.field3040[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field3037[var3] |= 4;
            } else {
               this.method3652(var3);
               this.field3037[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3707(var3, (this.field3041[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3707(var3, (this.field3041[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3688(var3, this.field3033[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3645(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3724(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3729();
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "-221701398"
   )
   int method3655(class190 var1) {
      int var2 = (var1.field3077 * var1.field3078 >> 12) + var1.field3076;
      var2 += this.field3043[var1.field3071] * (this.field3030[var1.field3071] - 8192) >> 12;
      class188 var3 = var1.field3082;
      int var4;
      if(var3.field3056 > 0 && (var3.field3058 > 0 || this.field3035[var1.field3071] > 0)) {
         var4 = var3.field3058 << 2;
         int var5 = var3.field3060 << 1;
         if(var1.field3084 < var5) {
            var4 = var1.field3084 * var4 / var5;
         }

         var4 += this.field3035[var1.field3071] >> 7;
         double var6 = Math.sin((double)(var1.field3085 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3070.field1303 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class59.field1265 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass190;B)I",
      garbageValue = "57"
   )
   int method3657(class190 var1) {
      int var2 = this.field3029[var1.field3071];
      return var2 < 8192?var1.field3081 * var2 + 32 >> 6:16384 - ((128 - var1.field3081) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("t")
   protected synchronized class69 vmethod3745() {
      return this.field3051;
   }

   @ObfuscatedName("n")
   protected synchronized class69 vmethod3756() {
      return null;
   }

   @ObfuscatedName("i")
   protected synchronized int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod3751(int[] var1, int var2, int var3) {
      if(this.field3036.method3565()) {
         int var4 = this.field3036.field3006 * this.field3039 / class59.field1265;

         do {
            long var5 = this.field3034 + (long)var3 * (long)var4;
            if(this.field3050 - var5 >= 0L) {
               this.field3034 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field3050 - this.field3034) - 1L) / (long)var4);
            this.field3034 += (long)var7 * (long)var4;
            this.field3051.vmethod3751(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3663();
         } while(this.field3036.method3565());
      }

      this.field3051.vmethod3751(var1, var2, var3);
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3749(int var1) {
      if(this.field3036.method3565()) {
         int var2 = this.field3036.field3006 * this.field3039 / class59.field1265;

         do {
            long var3 = (long)var2 * (long)var1 + this.field3034;
            if(this.field3050 - var3 >= 0L) {
               this.field3034 = var3;
               break;
            }

            int var5 = (int)((this.field3050 - this.field3034 + (long)var2 - 1L) / (long)var2);
            this.field3034 += (long)var2 * (long)var5;
            this.field3051.vmethod3749(var5);
            var1 -= var5;
            this.method3663();
         } while(this.field3036.method3565());
      }

      this.field3051.vmethod3749(var1);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1458788001"
   )
   void method3663() {
      int var1 = this.field3047;
      int var2 = this.field3027;

      long var3;
      for(var3 = this.field3050; var2 == this.field3027; var3 = this.field3036.method3574(var2)) {
         while(var2 == this.field3036.field3002[var1]) {
            this.field3036.method3567(var1);
            int var5 = this.field3036.method3571(var1);
            if(var5 == 1) {
               this.field3036.method3569();
               this.field3036.method3568(var1);
               if(this.field3036.method3576()) {
                  if(!this.field3046 || var2 == 0) {
                     this.method3729();
                     this.field3036.method3596();
                     return;
                  }

                  this.field3036.method3587(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3653(var5);
            }

            this.field3036.method3570(var1);
            this.field3036.method3568(var1);
         }

         var1 = this.field3036.method3575();
         var2 = this.field3036.field3002[var1];
      }

      this.field3047 = var1;
      this.field3027 = var2;
      this.field3050 = var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)Z",
      garbageValue = "813533518"
   )
   boolean method3664(class190 var1) {
      if(null == var1.field3075) {
         if(var1.field3088 >= 0) {
            var1.unlink();
            if(var1.field3072 > 0 && this.field3044[var1.field3071][var1.field3072] == var1) {
               this.field3044[var1.field3071][var1.field3072] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass190;[IIII)Z",
      garbageValue = "1652887746"
   )
   boolean method3665(class190 var1, int[] var2, int var3, int var4) {
      var1.field3087 = class59.field1265 / 100;
      if(var1.field3088 < 0 || var1.field3075 != null && !var1.field3075.method1366()) {
         int var5 = var1.field3078;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3031[var1.field3071] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3078 = var5;
         }

         var1.field3075.method1352(this.method3655(var1));
         class188 var6 = var1.field3082;
         boolean var7 = false;
         ++var1.field3084;
         var1.field3085 += var6.field3056;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3078 * var1.field3077 >> 12) + (var1.field3073 - 60 << 8));
         if(var6.field3055 > 0) {
            if(var6.field3054 > 0) {
               var1.field3079 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3054) + 0.5D);
            } else {
               var1.field3079 += 128;
            }
         }

         if(null != var6.field3061) {
            if(var6.field3059 > 0) {
               var1.field3080 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3059 * var8) + 0.5D);
            } else {
               var1.field3080 += 128;
            }

            while(var1.field3086 < var6.field3061.length - 2 && var1.field3080 > (var6.field3061[2 + var1.field3086] & 255) << 8) {
               var1.field3086 += 2;
            }

            if(var6.field3061.length - 2 == var1.field3086 && var6.field3061[var1.field3086 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3088 >= 0 && var6.field3053 != null && (this.field3037[var1.field3071] & 1) == 0 && (var1.field3072 < 0 || var1 != this.field3044[var1.field3071][var1.field3072])) {
            if(var6.field3052 > 0) {
               var1.field3088 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3052) + 0.5D);
            } else {
               var1.field3088 += 128;
            }

            while(var1.field3068 < var6.field3053.length - 2 && var1.field3088 > (var6.field3053[var1.field3068 + 2] & 255) << 8) {
               var1.field3068 += 2;
            }

            if(var1.field3068 == var6.field3053.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3075.method1453(var1.field3087);
            if(var2 != null) {
               var1.field3075.vmethod3751(var2, var3, var4);
            } else {
               var1.field3075.vmethod3749(var4);
            }

            if(var1.field3075.method1367()) {
               this.field3051.field3067.method1187(var1.field3075);
            }

            var1.method3771();
            if(var1.field3088 >= 0) {
               var1.unlink();
               if(var1.field3072 > 0 && this.field3044[var1.field3071][var1.field3072] == var1) {
                  this.field3044[var1.field3071][var1.field3072] = null;
               }
            }

            return true;
         } else {
            var1.field3075.method1404(var1.field3087, this.method3706(var1), this.method3657(var1));
            return false;
         }
      } else {
         var1.method3771();
         var1.unlink();
         if(var1.field3072 > 0 && this.field3044[var1.field3071][var1.field3072] == var1) {
            this.field3044[var1.field3071][var1.field3072] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-117"
   )
   public synchronized void method3671() {
      this.field3036.method3596();
      this.method3729();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1107400869"
   )
   synchronized boolean method3672() {
      return this.field3036.method3565();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "541462571"
   )
   synchronized void method3674() {
      for(class184 var1 = (class184)this.field3049.method3820(); null != var1; var1 = (class184)this.field3049.method3827()) {
         var1.method3555();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass183;Lclass170;Lclass62;II)Z",
      garbageValue = "-351149077"
   )
   synchronized boolean method3675(class183 var1, class170 var2, class62 var3, int var4) {
      var1.method3549();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class200 var7 = (class200)var1.field2988.method3820(); var7 != null; var7 = (class200)var1.field2988.method3827()) {
         int var8 = (int)var7.hash;
         class184 var9 = (class184)this.field3049.method3817((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3323(var8);
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

            this.field3049.method3823(var10, (long)var8);
         }

         if(!var9.method3554(var3, var7.field3148, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3544();
      }

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass190;ZI)V",
      garbageValue = "-1791619500"
   )
   void method3685(class190 var1, boolean var2) {
      int var3 = var1.field3070.field1305.length;
      int var4;
      if(var2 && var1.field3070.field1302) {
         int var5 = var3 + var3 - var1.field3070.field1304;
         var4 = (int)((long)var5 * (long)this.field3040[var1.field3071] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3075.method1359();
         }
      } else {
         var4 = (int)((long)this.field3040[var1.field3071] * (long)var3 >> 6);
      }

      var1.field3075.method1426(var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1024856725"
   )
   void method3688(int var1, int var2) {
      if(var2 != this.field3032[var1]) {
         this.field3032[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3044[var1][var3] = null;
         }
      }

   }

   public class187() {
      this.method3729();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass190;I)I",
      garbageValue = "1999273017"
   )
   int method3706(class190 var1) {
      class188 var2 = var1.field3082;
      int var3 = this.field3028[var1.field3071] * this.field3045[var1.field3071] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var1.field3074 * var3 >> 15;
      var3 = var3 * this.field3026 + 128 >> 8;
      if(var2.field3055 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3055 * (double)var1.field3079 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3061) {
         var4 = var1.field3080;
         var5 = var2.field3061[var1.field3086 + 1];
         if(var1.field3086 < var2.field3061.length - 2) {
            var6 = (var2.field3061[var1.field3086] & 255) << 8;
            var7 = (var2.field3061[var1.field3086 + 2] & 255) << 8;
            var5 += (var2.field3061[3 + var1.field3086] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3088 > 0 && var2.field3053 != null) {
         var4 = var1.field3088;
         var5 = var2.field3053[1 + var1.field3068];
         if(var1.field3068 < var2.field3053.length - 2) {
            var6 = (var2.field3053[var1.field3068] & 255) << 8;
            var7 = (var2.field3053[var1.field3068 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3053[var1.field3068 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method3707(int var1, int var2) {
      this.field3041[var1] = var2;
      this.field3042[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "60200853"
   )
   void method3717(int var1) {
      if(var1 >= 0) {
         this.field3028[var1] = 12800;
         this.field3029[var1] = 8192;
         this.field3045[var1] = 16383;
         this.field3030[var1] = 8192;
         this.field3035[var1] = 0;
         this.field3031[var1] = 8192;
         this.method3651(var1);
         this.method3652(var1);
         this.field3037[var1] = 0;
         this.field3038[var1] = 32767;
         this.field3043[var1] = 256;
         this.field3040[var1] = 0;
         this.method3707(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3717(var1);
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1628020434"
   )
   void method3724(int var1, int var2) {
      this.field3030[var1] = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   void method3729() {
      this.method3647(-1);
      this.method3717(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field3032[var1] = this.field3048[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field3033[var1] = this.field3048[var1] & -128;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "127"
   )
   public static File method3743(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class214.field3185 = new File(class228.field3259, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class214.field3185.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class214.field3185, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method4180()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method4178(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.method2528();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2528();
            }

            if(var9 <= 2) {
               var4 = var8.method2531();
               if(var10 == 1) {
                  var5 = var8.method2531();
               }
            } else {
               var4 = var8.method2559();
               if(var10 == 1) {
                  var5 = var8.method2559();
               }
            }

            var7.method4197();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!class62.method1320(var22, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label123:
         for(int var15 = 0; var15 < class124.field2082.length; ++var15) {
            for(int var16 = 0; var16 < class129.field2120.length; ++var16) {
               File var17 = new File(class129.field2120[var16] + class124.field2082[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class62.method1320(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label123;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class228.field3259 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(null != var5) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         class75.method1624(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
