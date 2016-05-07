import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class184 extends class66 {
   @ObfuscatedName("t")
   int[] field2981 = new int[16];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 461116891
   )
   int field2982 = 256;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 838664503
   )
   int field2983 = 1000000;
   @ObfuscatedName("w")
   int[] field2984 = new int[16];
   @ObfuscatedName("d")
   int[] field2985 = new int[16];
   @ObfuscatedName("f")
   int[] field2986 = new int[16];
   @ObfuscatedName("s")
   class196 field2987 = new class196(128);
   @ObfuscatedName("b")
   int[] field2988 = new int[16];
   @ObfuscatedName("k")
   int[] field2989 = new int[16];
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1080633591
   )
   int field2990;
   @ObfuscatedName("l")
   int[] field2991 = new int[16];
   @ObfuscatedName("g")
   int[] field2994 = new int[16];
   @ObfuscatedName("y")
   int[] field2995 = new int[16];
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -2130779138894793345L
   )
   long field2996;
   @ObfuscatedName("q")
   int[] field2997 = new int[16];
   @ObfuscatedName("n")
   int[] field2998 = new int[16];
   @ObfuscatedName("x")
   int[] field2999 = new int[16];
   @ObfuscatedName("ab")
   class187[][] field3000 = new class187[16][128];
   @ObfuscatedName("ad")
   class182 field3001 = new class182();
   @ObfuscatedName("an")
   boolean field3002;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -689807511
   )
   int field3003;
   @ObfuscatedName("o")
   int[] field3004 = new int[16];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -6425937374394519957L
   )
   long field3005;
   @ObfuscatedName("u")
   int[] field3006 = new int[16];
   @ObfuscatedName("ao")
   class186 field3007 = new class186(this);
   @ObfuscatedName("v")
   class187[][] field3008 = new class187[16][128];
   @ObfuscatedName("c")
   int[] field3009 = new int[16];

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "28607"
   )
   public synchronized void method3578(int var1) {
      this.field2982 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-115"
   )
   int method3579() {
      return this.field2982;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "22050"
   )
   synchronized boolean method3580(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3502();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2943.method3780(); var7 != null; var7 = (class197)var1.field2943.method3781()) {
         int var8 = (int)var7.field3125;
         class181 var9 = (class181)this.field2987.method3777((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3244(var8);
            class181 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class181(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field2987.method3778(var10, (long)var8);
         }

         if(!var9.method3506(var3, var7.field3104, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3495();
      }

      return var5;
   }

   @ObfuscatedName("b")
   protected synchronized int vmethod3705() {
      return 0;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1915869350"
   )
   void method3582(int var1) {
      if((this.field2984[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field3007.field3024.method3812(); null != var2; var2 = (class187)this.field3007.field3024.method3817()) {
            if(var1 == var2.field3046 && null == this.field3008[var1][var2.field3031] && var2.field3027 < 0) {
               var2.field3027 = 0;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZI)V",
      garbageValue = "514186258"
   )
   synchronized void method3583(class180 var1, boolean var2) {
      this.method3584();
      this.field3001.method3533(var1.field2944);
      this.field3002 = var2;
      this.field3005 = 0L;
      int var3 = this.field3001.method3561();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3001.method3517(var4);
         this.field3001.method3520(var4);
         this.field3001.method3557(var4);
      }

      this.field3003 = this.field3001.method3525();
      this.field2990 = this.field3001.field2960[this.field3003];
      this.field2996 = this.field3001.method3524(this.field2990);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2045680598"
   )
   synchronized void method3584() {
      this.field3001.method3514();
      this.method3598();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-79970691"
   )
   public synchronized boolean method3585() {
      return this.field3001.method3515();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "9"
   )
   public synchronized void method3586(int var1, int var2) {
      this.method3635(var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-482536926"
   )
   void method3588(int var1, int var2) {
      if(var2 != this.field2988[var1]) {
         this.field2988[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3000[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZB)V",
      garbageValue = "1"
   )
   void method3590(class187 var1, boolean var2) {
      int var3 = var1.field3041.field1237.length;
      int var4;
      if(var1.field3041.field1238) {
         int var5 = var3 + var3 - var1.field3041.field1236;
         var4 = (int)((long)var5 * (long)this.field2986[var1.field3046] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3045.method1290();
         }
      } else {
         var4 = (int)((long)this.field2986[var1.field3046] * (long)var3 >> 6);
      }

      var1.field3045.method1289(var4);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "990127688"
   )
   void method3592(int var1, int var2, int var3) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1895074887"
   )
   static int method3594(int var0) {
      class27 var1 = (class27)class11.field168.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method623();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-131061118"
   )
   void method3597(int var1) {
      for(class187 var2 = (class187)this.field3007.field3024.method3812(); null != var2; var2 = (class187)this.field3007.field3024.method3817()) {
         if((var1 < 0 || var2.field3046 == var1) && var2.field3027 < 0) {
            this.field3008[var2.field3046][var2.field3031] = null;
            var2.field3027 = 0;
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1944129782"
   )
   void method3598() {
      this.method3631(-1);
      this.method3614(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2988[var1] = this.field3004[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2989[var1] = this.field3004[var1] & -128;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-812991124"
   )
   void method3601(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3609(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3655(var3, var4, var5);
         } else {
            this.method3609(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3592(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2989[var3] = (var5 << 14) + (this.field2989[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2989[var3] = (var5 << 7) + (this.field2989[var3] & -16257);
         }

         if(1 == var4) {
            this.field2991[var3] = (var5 << 7) + (this.field2991[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2991[var3] = var5 + (this.field2991[var3] & -128);
         }

         if(var4 == 5) {
            this.field2981[var3] = (this.field2981[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2981[var3] = (this.field2981[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2999[var3] = (var5 << 7) + (this.field2999[var3] & -16257);
         }

         if(39 == var4) {
            this.field2999[var3] = (this.field2999[var3] & -128) + var5;
         }

         if(10 == var4) {
            this.field2985[var3] = (var5 << 7) + (this.field2985[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2985[var3] = (this.field2985[var3] & -128) + var5;
         }

         if(11 == var4) {
            this.field3006[var3] = (var5 << 7) + (this.field3006[var3] & -16257);
         }

         if(var4 == 43) {
            this.field3006[var3] = var5 + (this.field3006[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2984[var3] |= 1;
            } else {
               this.field2984[var3] &= -2;
            }
         }

         if(65 == var4) {
            if(var5 >= 64) {
               this.field2984[var3] |= 2;
            } else {
               this.method3582(var3);
               this.field2984[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2994[var3] = (this.field2994[var3] & 127) + (var5 << 7);
         }

         if(98 == var4) {
            this.field2994[var3] = var5 + (this.field2994[var3] & 16256);
         }

         if(101 == var4) {
            this.field2994[var3] = (var5 << 7) + (this.field2994[var3] & 127) + 16384;
         }

         if(100 == var4) {
            this.field2994[var3] = var5 + (this.field2994[var3] & 16256) + 16384;
         }

         if(120 == var4) {
            this.method3631(var3);
         }

         if(var4 == 121) {
            this.method3614(var3);
         }

         if(var4 == 123) {
            this.method3597(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2994[var3];
            if(var6 == 16384) {
               this.field2995[var3] = (this.field2995[var3] & -16257) + (var5 << 7);
            }
         }

         if(38 == var4) {
            var6 = this.field2994[var3];
            if(var6 == 16384) {
               this.field2995[var3] = var5 + (this.field2995[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2986[var3] = (this.field2986[var3] & -16257) + (var5 << 7);
         }

         if(48 == var4) {
            this.field2986[var3] = var5 + (this.field2986[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2984[var3] |= 4;
            } else {
               this.method3661(var3);
               this.field2984[var3] &= -5;
            }
         }

         if(17 == var4) {
            this.method3602(var3, (var5 << 7) + (this.field2997[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3602(var3, (this.field2997[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3588(var3, this.field2989[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3625(var3, var4);
      } else if(224 == var2) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3604(var3, var4);
      } else {
         var2 = var1 & 255;
         if(255 == var2) {
            this.method3598();
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1749872304"
   )
   void method3602(int var1, int var2) {
      this.field2997[var1] = var2;
      this.field2998[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "1669714050"
   )
   int method3603(class187 var1) {
      int var2 = var1.field3028 + (var1.field3035 * var1.field3036 >> 12);
      var2 += this.field2995[var1.field3046] * (this.field3009[var1.field3046] - 8192) >> 12;
      class185 var3 = var1.field3029;
      int var4;
      if(var3.field3015 > 0 && (var3.field3016 > 0 || this.field2991[var1.field3046] > 0)) {
         var4 = var3.field3016 << 2;
         int var5 = var3.field3019 << 1;
         if(var1.field3042 < var5) {
            var4 = var4 * var1.field3042 / var5;
         }

         var4 += this.field2991[var1.field3046] >> 7;
         double var6 = Math.sin((double)(var1.field3043 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3041.field1240 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1186 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-303522132"
   )
   void method3604(int var1, int var2) {
      this.field3009[var1] = var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "-30"
   )
   int method3605(class187 var1) {
      int var2 = this.field2985[var1.field3046];
      return var2 < 8192?32 + var2 * var1.field3033 >> 6:16384 - (32 + (128 - var1.field3033) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("u")
   protected synchronized class66 vmethod3709() {
      return this.field3007;
   }

   @ObfuscatedName("o")
   protected synchronized class66 vmethod3704() {
      return null;
   }

   public class184() {
      this.method3598();
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3706(int[] var1, int var2, int var3) {
      if(this.field3001.method3515()) {
         int var4 = this.field2983 * this.field3001.field2957 / class56.field1186;

         do {
            long var5 = this.field3005 + (long)var3 * (long)var4;
            if(this.field2996 - var5 >= 0L) {
               this.field3005 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2996 - this.field3005) - 1L) / (long)var4);
            this.field3005 += (long)var4 * (long)var7;
            this.field3007.vmethod3706(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3610();
         } while(this.field3001.method3515());
      }

      this.field3007.vmethod3706(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "879605839"
   )
   void method3609(int var1, int var2, int var3) {
      class187 var4 = this.field3008[var1][var2];
      if(var4 != null) {
         this.field3008[var1][var2] = null;
         if((this.field2984[var1] & 2) != 0) {
            for(class187 var5 = (class187)this.field3007.field3024.method3812(); var5 != null; var5 = (class187)this.field3007.field3024.method3817()) {
               if(var4.field3046 == var5.field3046 && var5.field3027 < 0 && var4 != var5) {
                  var4.field3027 = 0;
                  break;
               }
            }
         } else {
            var4.field3027 = 0;
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   void method3610() {
      int var1 = this.field3003;
      int var2 = this.field2990;

      long var3;
      for(var3 = this.field2996; var2 == this.field2990; var3 = this.field3001.method3524(var2)) {
         while(this.field3001.field2960[var1] == var2) {
            this.field3001.method3517(var1);
            int var5 = this.field3001.method3521(var1);
            if(var5 == 1) {
               this.field3001.method3519();
               this.field3001.method3557(var1);
               if(this.field3001.method3526()) {
                  if(!this.field3002 || var2 == 0) {
                     this.method3598();
                     this.field3001.method3514();
                     return;
                  }

                  this.field3001.method3527(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3601(var5);
            }

            this.field3001.method3520(var1);
            this.field3001.method3557(var1);
         }

         var1 = this.field3001.method3525();
         var2 = this.field3001.field2960[var1];
      }

      this.field3003 = var1;
      this.field2990 = var2;
      this.field2996 = var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)Z",
      garbageValue = "1945315449"
   )
   boolean method3611(class187 var1) {
      if(var1.field3045 == null) {
         if(var1.field3027 >= 0) {
            var1.method3898();
            if(var1.field3034 > 0 && this.field3000[var1.field3046][var1.field3034] == var1) {
               this.field3000[var1.field3046][var1.field3034] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   void method3614(int var1) {
      if(var1 >= 0) {
         this.field2999[var1] = 12800;
         this.field2985[var1] = 8192;
         this.field3006[var1] = 16383;
         this.field3009[var1] = 8192;
         this.field2991[var1] = 0;
         this.field2981[var1] = 8192;
         this.method3582(var1);
         this.method3661(var1);
         this.field2984[var1] = 0;
         this.field2994[var1] = 32767;
         this.field2995[var1] = 256;
         this.field2986[var1] = 0;
         this.method3602(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3614(var1);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "254018854"
   )
   void method3625(int var1, int var2) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   synchronized void method3630() {
      for(class181 var1 = (class181)this.field2987.method3780(); var1 != null; var1 = (class181)this.field2987.method3781()) {
         var1.method3508();
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "124"
   )
   void method3631(int var1) {
      for(class187 var2 = (class187)this.field3007.field3024.method3812(); null != var2; var2 = (class187)this.field3007.field3024.method3817()) {
         if(var1 < 0 || var1 == var2.field3046) {
            if(var2.field3045 != null) {
               var2.field3045.method1439(class56.field1186 / 100);
               if(var2.field3045.method1326()) {
                  this.field3007.field3022.method1127(var2.field3045);
               }

               var2.method3724();
            }

            if(var2.field3027 < 0) {
               this.field3008[var2.field3046][var2.field3031] = null;
            }

            var2.method3898();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1843536403"
   )
   void method3635(int var1, int var2) {
      this.field3004[var1] = var2;
      this.field2989[var1] = var2 & -128;
      this.method3588(var1, var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIII)Z",
      garbageValue = "-1573338260"
   )
   boolean method3640(class187 var1, int[] var2, int var3, int var4) {
      var1.field3030 = class56.field1186 / 100;
      if(var1.field3027 < 0 || var1.field3045 != null && !var1.field3045.method1287()) {
         int var5 = var1.field3036;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2981[var1.field3046] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3036 = var5;
         }

         var1.field3045.method1295(this.method3603(var1));
         class185 var6 = var1.field3029;
         boolean var7 = false;
         ++var1.field3042;
         var1.field3043 += var6.field3015;
         double var8 = (double)((var1.field3035 * var1.field3036 >> 12) + (var1.field3031 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field3012 > 0) {
            if(var6.field3010 > 0) {
               var1.field3037 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3010 * var8) + 0.5D);
            } else {
               var1.field3037 += 128;
            }
         }

         if(var6.field3018 != null) {
            if(var6.field3013 > 0) {
               var1.field3044 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3013) + 0.5D);
            } else {
               var1.field3044 += 128;
            }

            while(var1.field3039 < var6.field3018.length - 2 && var1.field3044 > (var6.field3018[var1.field3039 + 2] & 255) << 8) {
               var1.field3039 += 2;
            }

            if(var1.field3039 == var6.field3018.length - 2 && var6.field3018[1 + var1.field3039] == 0) {
               var7 = true;
            }
         }

         if(var1.field3027 >= 0 && var6.field3011 != null && (this.field2984[var1.field3046] & 1) == 0 && (var1.field3034 < 0 || this.field3000[var1.field3046][var1.field3034] != var1)) {
            if(var6.field3014 > 0) {
               var1.field3027 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3014 * var8) + 0.5D);
            } else {
               var1.field3027 += 128;
            }

            while(var1.field3026 < var6.field3011.length - 2 && var1.field3027 > (var6.field3011[var1.field3026 + 2] & 255) << 8) {
               var1.field3026 += 2;
            }

            if(var1.field3026 == var6.field3011.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3045.method1439(var1.field3030);
            if(null != var2) {
               var1.field3045.vmethod3706(var2, var3, var4);
            } else {
               var1.field3045.vmethod3707(var4);
            }

            if(var1.field3045.method1326()) {
               this.field3007.field3022.method1127(var1.field3045);
            }

            var1.method3724();
            if(var1.field3027 >= 0) {
               var1.method3898();
               if(var1.field3034 > 0 && var1 == this.field3000[var1.field3046][var1.field3034]) {
                  this.field3000[var1.field3046][var1.field3034] = null;
               }
            }

            return true;
         } else {
            var1.field3045.method1395(var1.field3030, this.method3659(var1), this.method3605(var1));
            return false;
         }
      } else {
         var1.method3724();
         var1.method3898();
         if(var1.field3034 > 0 && this.field3000[var1.field3046][var1.field3034] == var1) {
            this.field3000[var1.field3046][var1.field3034] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   void method3655(int var1, int var2, int var3) {
      this.method3609(var1, var2, 64);
      if((this.field2984[var1] & 2) != 0) {
         for(class187 var4 = (class187)this.field3007.field3024.method3831(); null != var4; var4 = (class187)this.field3007.field3024.method3814()) {
            if(var4.field3046 == var1 && var4.field3027 < 0) {
               this.field3008[var1][var4.field3031] = null;
               this.field3008[var1][var2] = var4;
               int var5 = var4.field3028 + (var4.field3035 * var4.field3036 >> 12);
               var4.field3028 += var2 - var4.field3031 << 8;
               var4.field3035 = var5 - var4.field3028;
               var4.field3036 = 4096;
               var4.field3031 = var2;
               return;
            }
         }
      }

      class181 var8 = (class181)this.field2987.method3777((long)this.field2988[var1]);
      if(null != var8) {
         class62 var9 = var8.field2953[var2];
         if(null != var9) {
            class187 var6 = new class187();
            var6.field3046 = var1;
            var6.field3038 = var8;
            var6.field3041 = var9;
            var6.field3029 = var8.field2952[var2];
            var6.field3034 = var8.field2951[var2];
            var6.field3031 = var2;
            var6.field3032 = var8.field2946[var2] * var8.field2950 * var3 * var3 + 1024 >> 11;
            var6.field3033 = var8.field2949[var2] & 255;
            var6.field3028 = (var2 << 8) - (var8.field2947[var2] & 32767);
            var6.field3037 = 0;
            var6.field3044 = 0;
            var6.field3039 = 0;
            var6.field3027 = -1;
            var6.field3026 = 0;
            if(0 == this.field2986[var1]) {
               var6.field3045 = class64.method1281(var9, this.method3603(var6), this.method3659(var6), this.method3605(var6));
            } else {
               var6.field3045 = class64.method1281(var9, this.method3603(var6), 0, this.method3605(var6));
               this.method3590(var6, var8.field2947[var2] < 0);
            }

            if(var8.field2947[var2] < 0) {
               var6.field3045.method1428(-1);
            }

            if(var6.field3034 >= 0) {
               class187 var7 = this.field3000[var1][var6.field3034];
               if(var7 != null && var7.field3027 < 0) {
                  this.field3008[var1][var7.field3031] = null;
                  var7.field3027 = 0;
               }

               this.field3000[var1][var6.field3034] = var6;
            }

            this.field3007.field3024.method3807(var6);
            this.field3008[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "0"
   )
   int method3659(class187 var1) {
      class185 var2 = var1.field3029;
      int var3 = this.field3006[var1.field3046] * this.field2999[var1.field3046] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field3032 * var3 + 16384 >> 15;
      var3 = this.field2982 * var3 + 128 >> 8;
      if(var2.field3012 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3037 * 1.953125E-5D * (double)var2.field3012) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3018) {
         var4 = var1.field3044;
         var5 = var2.field3018[var1.field3039 + 1];
         if(var1.field3039 < var2.field3018.length - 2) {
            var6 = (var2.field3018[var1.field3039] & 255) << 8;
            var7 = (var2.field3018[var1.field3039 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3018[var1.field3039 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field3027 > 0 && var2.field3011 != null) {
         var4 = var1.field3027;
         var5 = var2.field3011[var1.field3026 + 1];
         if(var1.field3026 < var2.field3011.length - 2) {
            var6 = (var2.field3011[var1.field3026] & 255) << 8;
            var7 = (var2.field3011[var1.field3026 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3011[var1.field3026 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2057307578"
   )
   void method3661(int var1) {
      if((this.field2984[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field3007.field3024.method3812(); var2 != null; var2 = (class187)this.field3007.field3024.method3817()) {
            if(var1 == var2.field3046) {
               var2.field3047 = 0;
            }
         }
      }

   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3707(int var1) {
      if(this.field3001.method3515()) {
         int var2 = this.field3001.field2957 * this.field2983 / class56.field1186;

         do {
            long var3 = (long)var2 * (long)var1 + this.field3005;
            if(this.field2996 - var3 >= 0L) {
               this.field3005 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2996 - this.field3005) - 1L) / (long)var2);
            this.field3005 += (long)var5 * (long)var2;
            this.field3007.vmethod3707(var5);
            var1 -= var5;
            this.method3610();
         } while(this.field3001.method3515());
      }

      this.field3007.vmethod3707(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   synchronized void method3690() {
      for(class181 var1 = (class181)this.field2987.method3780(); null != var1; var1 = (class181)this.field2987.method3781()) {
         var1.method3898();
      }

   }
}
