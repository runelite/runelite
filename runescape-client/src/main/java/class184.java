import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class184 extends class66 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 762954663
   )
   int field2982 = 256;
   @ObfuscatedName("x")
   int[] field2983 = new int[16];
   @ObfuscatedName("h")
   int[] field2985 = new int[16];
   @ObfuscatedName("z")
   int[] field2986 = new int[16];
   @ObfuscatedName("q")
   int[] field2987 = new int[16];
   @ObfuscatedName("f")
   int[] field2988 = new int[16];
   @ObfuscatedName("s")
   int[] field2989 = new int[16];
   @ObfuscatedName("d")
   int[] field2990 = new int[16];
   @ObfuscatedName("p")
   int[] field2991 = new int[16];
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -4300852998474953957L
   )
   long field2992;
   @ObfuscatedName("r")
   int[] field2993 = new int[16];
   @ObfuscatedName("n")
   int[] field2994 = new int[16];
   @ObfuscatedName("y")
   int[] field2995 = new int[16];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1287911711
   )
   int field2996 = 1000000;
   @ObfuscatedName("t")
   class196 field2997 = new class196(128);
   @ObfuscatedName("m")
   int[] field2998 = new int[16];
   @ObfuscatedName("w")
   int[] field2999 = new int[16];
   @ObfuscatedName("e")
   class187[][] field3000 = new class187[16][128];
   @ObfuscatedName("ad")
   class187[][] field3001 = new class187[16][128];
   @ObfuscatedName("as")
   class182 field3002 = new class182();
   @ObfuscatedName("ag")
   boolean field3003;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1902848773
   )
   int field3004;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1323443929
   )
   int field3005;
   @ObfuscatedName("v")
   int[] field3006 = new int[16];
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 5048428174408592893L
   )
   long field3007;
   @ObfuscatedName("aq")
   class186 field3008 = new class186(this);
   @ObfuscatedName("l")
   int[] field3009 = new int[16];

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1164443884"
   )
   void method3547() {
      int var1 = this.field3004;
      int var2 = this.field3005;

      long var3;
      for(var3 = this.field3007; this.field3005 == var2; var3 = this.field3002.method3489(var2)) {
         while(this.field3002.field2964[var1] == var2) {
            this.field3002.method3506(var1);
            int var5 = this.field3002.method3488(var1);
            if(var5 == 1) {
               this.field3002.method3484();
               this.field3002.method3486(var1);
               if(this.field3002.method3491()) {
                  if(!this.field3003 || var2 == 0) {
                     this.method3567();
                     this.field3002.method3479();
                     return;
                  }

                  this.field3002.method3513(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3570(var5);
            }

            this.field3002.method3485(var1);
            this.field3002.method3486(var1);
         }

         var1 = this.field3002.method3490();
         var2 = this.field3002.field2964[var1];
      }

      this.field3004 = var1;
      this.field3005 = var2;
      this.field3007 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "104"
   )
   public int method3548() {
      return this.field2982;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "22050"
   )
   synchronized boolean method3549(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3461();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2948.method3751(); null != var7; var7 = (class197)var1.field2948.method3752()) {
         int var8 = (int)var7.field3125;
         class181 var9 = (class181)this.field2997.method3748((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3275(var8);
            class181 var10;
            if(null == var11) {
               var10 = null;
            } else {
               var10 = new class181(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2997.method3749(var10, (long)var8);
         }

         if(!var9.method3475(var3, var7.field3104, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3462();
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "47"
   )
   public synchronized boolean method3554() {
      return this.field3002.method3480();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1898532180"
   )
   void method3556(int var1, int var2) {
      this.field2988[var1] = var2;
      this.field2990[var1] = var2 & -128;
      this.method3557(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "116"
   )
   void method3557(int var1, int var2) {
      if(this.field2989[var1] != var2) {
         this.field2989[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field3001[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZI)V",
      garbageValue = "1"
   )
   void method3559(class187 var1, boolean var2) {
      int var3 = var1.field3029.field1235.length;
      int var4;
      if(var1.field3029.field1236) {
         int var5 = var3 + var3 - var1.field3029.field1238;
         var4 = (int)((long)var5 * (long)this.field3006[var1.field3043] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3045.method1273();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field3006[var1.field3043] >> 6);
      }

      var1.field3045.method1349(var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "23"
   )
   void method3561(int var1, int var2, int var3) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2090166323"
   )
   void method3562(int var1, int var2) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-50"
   )
   void method3563(int var1, int var2) {
      this.field3009[var1] = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1577000514"
   )
   void method3565(int var1) {
      if(var1 >= 0) {
         this.field2985[var1] = 12800;
         this.field2986[var1] = 8192;
         this.field2993[var1] = 16383;
         this.field3009[var1] = 8192;
         this.field2995[var1] = 0;
         this.field2991[var1] = 8192;
         this.method3568(var1);
         this.method3569(var1);
         this.field2994[var1] = 0;
         this.field2987[var1] = 32767;
         this.field2983[var1] = 256;
         this.field3006[var1] = 0;
         this.method3571(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3565(var1);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1548451386"
   )
   void method3566(int var1) {
      for(class187 var2 = (class187)this.field3008.field3023.method3797(); var2 != null; var2 = (class187)this.field3008.field3023.method3779()) {
         if((var1 < 0 || var2.field3043 == var1) && var2.field3041 < 0) {
            this.field3000[var2.field3043][var2.field3032] = null;
            var2.field3041 = 0;
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1590545279"
   )
   void method3567() {
      this.method3670(-1);
      this.method3565(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2989[var1] = this.field2988[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2990[var1] = this.field2988[var1] & -128;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1463079078"
   )
   void method3568(int var1) {
      if((this.field2994[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field3008.field3023.method3797(); var2 != null; var2 = (class187)this.field3008.field3023.method3779()) {
            if(var1 == var2.field3043 && null == this.field3000[var1][var2.field3032] && var2.field3041 < 0) {
               var2.field3041 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1675690216"
   )
   void method3569(int var1) {
      if((this.field2994[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field3008.field3023.method3797(); var2 != null; var2 = (class187)this.field3008.field3023.method3779()) {
            if(var2.field3043 == var1) {
               var2.field3047 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-90"
   )
   void method3570(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3630(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3601(var3, var4, var5);
         } else {
            this.method3630(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3561(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2990[var3] = (this.field2990[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field2990[var3] = (this.field2990[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field2995[var3] = (this.field2995[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field2995[var3] = (this.field2995[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2991[var3] = (var5 << 7) + (this.field2991[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2991[var3] = var5 + (this.field2991[var3] & -128);
         }

         if(var4 == 7) {
            this.field2985[var3] = (var5 << 7) + (this.field2985[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2985[var3] = (this.field2985[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field2986[var3] = (var5 << 7) + (this.field2986[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2986[var3] = var5 + (this.field2986[var3] & -128);
         }

         if(var4 == 11) {
            this.field2993[var3] = (var5 << 7) + (this.field2993[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2993[var3] = var5 + (this.field2993[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2994[var3] |= 1;
            } else {
               this.field2994[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2994[var3] |= 2;
            } else {
               this.method3568(var3);
               this.field2994[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2987[var3] = (this.field2987[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2987[var3] = var5 + (this.field2987[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2987[var3] = (this.field2987[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2987[var3] = 16384 + (this.field2987[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method3670(var3);
         }

         if(var4 == 121) {
            this.method3565(var3);
         }

         if(var4 == 123) {
            this.method3566(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2987[var3];
            if(var6 == 16384) {
               this.field2983[var3] = (var5 << 7) + (this.field2983[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2987[var3];
            if(var6 == 16384) {
               this.field2983[var3] = var5 + (this.field2983[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field3006[var3] = (var5 << 7) + (this.field3006[var3] & -16257);
         }

         if(var4 == 48) {
            this.field3006[var3] = var5 + (this.field3006[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2994[var3] |= 4;
            } else {
               this.method3569(var3);
               this.field2994[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3571(var3, (var5 << 7) + (this.field2998[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3571(var3, var5 + (this.field2998[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3557(var3, var4 + this.field2990[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3562(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3563(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3567();
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1649582179"
   )
   void method3571(int var1, int var2) {
      this.field2998[var1] = var2;
      this.field2999[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "2147082368"
   )
   int method3573(class187 var1) {
      class185 var2 = var1.field3044;
      int var3 = 4096 + this.field2993[var1.field3043] * this.field2985[var1.field3043] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field3046 >> 15;
      var3 = this.field2982 * var3 + 128 >> 8;
      if(var2.field3017 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field3017 * (double)var1.field3038 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field3011) {
         var4 = var1.field3039;
         var5 = var2.field3011[var1.field3040 + 1];
         if(var1.field3040 < var2.field3011.length - 2) {
            var6 = (var2.field3011[var1.field3040] & 255) << 8;
            var7 = (var2.field3011[var1.field3040 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3011[3 + var1.field3040] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3041 > 0 && var2.field3013 != null) {
         var4 = var1.field3041;
         var5 = var2.field3013[var1.field3027 + 1];
         if(var1.field3027 < var2.field3013.length - 2) {
            var6 = (var2.field3013[var1.field3027] & 255) << 8;
            var7 = (var2.field3013[var1.field3027 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field3013[3 + var1.field3027] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "191134956"
   )
   public synchronized void method3574() {
      this.field3002.method3479();
      this.method3567();
   }

   @ObfuscatedName("f")
   protected synchronized class66 vmethod3677() {
      return null;
   }

   @ObfuscatedName("s")
   protected synchronized int vmethod3678() {
      return 0;
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3679(int[] var1, int var2, int var3) {
      if(this.field3002.method3480()) {
         int var4 = this.field2996 * this.field3002.field2961 / class56.field1194;

         do {
            long var5 = this.field2992 + (long)var3 * (long)var4;
            if(this.field3007 - var5 >= 0L) {
               this.field2992 = var5;
               break;
            }

            int var7 = (int)((this.field3007 - this.field2992 + (long)var4 - 1L) / (long)var4);
            this.field2992 += (long)var7 * (long)var4;
            this.field3008.vmethod3679(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3547();
         } while(this.field3002.method3480());
      }

      this.field3008.vmethod3679(var1, var2, var3);
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod3686(int var1) {
      if(this.field3002.method3480()) {
         int var2 = this.field3002.field2961 * this.field2996 / class56.field1194;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2992;
            if(this.field3007 - var3 >= 0L) {
               this.field2992 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field3007 - this.field2992) - 1L) / (long)var2);
            this.field2992 += (long)var5 * (long)var2;
            this.field3008.vmethod3686(var5);
            var1 -= var5;
            this.method3547();
         } while(this.field3002.method3480());
      }

      this.field3008.vmethod3686(var1);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)Z",
      garbageValue = "-40"
   )
   boolean method3581(class187 var1) {
      if(var1.field3045 == null) {
         if(var1.field3041 >= 0) {
            var1.method3870();
            if(var1.field3031 > 0 && var1 == this.field3001[var1.field3043][var1.field3031]) {
               this.field3001[var1.field3043][var1.field3031] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIB)Z",
      garbageValue = "0"
   )
   boolean method3582(class187 var1, int[] var2, int var3, int var4) {
      var1.field3048 = class56.field1194 / 100;
      if(var1.field3041 < 0 || var1.field3045 != null && !var1.field3045.method1264()) {
         int var5 = var1.field3037;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2991[var1.field3043]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3037 = var5;
         }

         var1.field3045.method1278(this.method3627(var1));
         class185 var6 = var1.field3044;
         boolean var7 = false;
         ++var1.field3042;
         var1.field3036 += var6.field3018;
         double var8 = (double)((var1.field3032 - 60 << 8) + (var1.field3030 * var1.field3037 >> 12)) * 5.086263020833333E-6D;
         if(var6.field3017 > 0) {
            if(var6.field3016 > 0) {
               var1.field3038 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3016 * var8) + 0.5D);
            } else {
               var1.field3038 += 128;
            }
         }

         if(null != var6.field3011) {
            if(var6.field3014 > 0) {
               var1.field3039 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3014) + 0.5D);
            } else {
               var1.field3039 += 128;
            }

            while(var1.field3040 < var6.field3011.length - 2 && var1.field3039 > (var6.field3011[var1.field3040 + 2] & 255) << 8) {
               var1.field3040 += 2;
            }

            if(var1.field3040 == var6.field3011.length - 2 && var6.field3011[var1.field3040 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3041 >= 0 && null != var6.field3013 && (this.field2994[var1.field3043] & 1) == 0 && (var1.field3031 < 0 || var1 != this.field3001[var1.field3043][var1.field3031])) {
            if(var6.field3015 > 0) {
               var1.field3041 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3015) + 0.5D);
            } else {
               var1.field3041 += 128;
            }

            while(var1.field3027 < var6.field3013.length - 2 && var1.field3041 > (var6.field3013[2 + var1.field3027] & 255) << 8) {
               var1.field3027 += 2;
            }

            if(var1.field3027 == var6.field3013.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3045.method1277(var1.field3048);
            if(null != var2) {
               var1.field3045.vmethod3679(var2, var3, var4);
            } else {
               var1.field3045.vmethod3686(var4);
            }

            if(var1.field3045.method1281()) {
               this.field3008.field3025.method1094(var1.field3045);
            }

            var1.method3701();
            if(var1.field3041 >= 0) {
               var1.method3870();
               if(var1.field3031 > 0 && var1 == this.field3001[var1.field3043][var1.field3031]) {
                  this.field3001[var1.field3043][var1.field3031] = null;
               }
            }

            return true;
         } else {
            var1.field3045.method1291(var1.field3048, this.method3573(var1), this.method3663(var1));
            return false;
         }
      } else {
         var1.method3701();
         var1.method3870();
         if(var1.field3031 > 0 && this.field3001[var1.field3043][var1.field3031] == var1) {
            this.field3001[var1.field3043][var1.field3031] = null;
         }

         return true;
      }
   }

   public class184() {
      this.method3567();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZB)V",
      garbageValue = "4"
   )
   synchronized void method3599(class180 var1, boolean var2) {
      this.method3574();
      this.field3002.method3478(var1.field2949);
      this.field3003 = var2;
      this.field2992 = 0L;
      int var3 = this.field3002.method3481();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field3002.method3506(var4);
         this.field3002.method3485(var4);
         this.field3002.method3486(var4);
      }

      this.field3004 = this.field3002.method3490();
      this.field3005 = this.field3002.field2964[this.field3004];
      this.field3007 = this.field3002.method3489(this.field3005);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "11"
   )
   void method3601(int var1, int var2, int var3) {
      this.method3630(var1, var2, 64);
      if((this.field2994[var1] & 2) != 0) {
         for(class187 var4 = (class187)this.field3008.field3023.method3777(); null != var4; var4 = (class187)this.field3008.field3023.method3780()) {
            if(var1 == var4.field3043 && var4.field3041 < 0) {
               this.field3000[var1][var4.field3032] = null;
               this.field3000[var1][var2] = var4;
               int var5 = var4.field3035 + (var4.field3030 * var4.field3037 >> 12);
               var4.field3035 += var2 - var4.field3032 << 8;
               var4.field3030 = var5 - var4.field3035;
               var4.field3037 = 4096;
               var4.field3032 = var2;
               return;
            }
         }
      }

      class181 var9 = (class181)this.field2997.method3748((long)this.field2989[var1]);
      if(var9 != null) {
         class62 var8 = var9.field2951[var2];
         if(var8 != null) {
            class187 var6 = new class187();
            var6.field3043 = var1;
            var6.field3028 = var9;
            var6.field3029 = var8;
            var6.field3044 = var9.field2959[var2];
            var6.field3031 = var9.field2950[var2];
            var6.field3032 = var2;
            var6.field3046 = 1024 + var9.field2954 * var3 * var3 * var9.field2953[var2] >> 11;
            var6.field3034 = var9.field2955[var2] & 255;
            var6.field3035 = (var2 << 8) - (var9.field2952[var2] & 32767);
            var6.field3038 = 0;
            var6.field3039 = 0;
            var6.field3040 = 0;
            var6.field3041 = -1;
            var6.field3027 = 0;
            if(this.field3006[var1] == 0) {
               var6.field3045 = class64.method1340(var8, this.method3627(var6), this.method3573(var6), this.method3663(var6));
            } else {
               var6.field3045 = class64.method1340(var8, this.method3627(var6), 0, this.method3663(var6));
               this.method3559(var6, var9.field2952[var2] < 0);
            }

            if(var9.field2952[var2] < 0) {
               var6.field3045.method1266(-1);
            }

            if(var6.field3031 >= 0) {
               class187 var7 = this.field3001[var1][var6.field3031];
               if(var7 != null && var7.field3041 < 0) {
                  this.field3000[var1][var7.field3032] = null;
                  var7.field3041 = 0;
               }

               this.field3001[var1][var6.field3031] = var6;
            }

            this.field3008.field3023.method3771(var6);
            this.field3000[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("r")
   protected synchronized class66 vmethod3695() {
      return this.field3008;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-98"
   )
   public synchronized void method3613(int var1) {
      this.field2982 = var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "126"
   )
   int method3627(class187 var1) {
      int var2 = var1.field3035 + (var1.field3030 * var1.field3037 >> 12);
      var2 += (this.field3009[var1.field3043] - 8192) * this.field2983[var1.field3043] >> 12;
      class185 var3 = var1.field3044;
      int var4;
      if(var3.field3018 > 0 && (var3.field3012 > 0 || this.field2995[var1.field3043] > 0)) {
         var4 = var3.field3012 << 2;
         int var5 = var3.field3019 << 1;
         if(var1.field3042 < var5) {
            var4 = var1.field3042 * var4 / var5;
         }

         var4 += this.field2995[var1.field3043] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3036 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3029.field1234 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1194 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1444312922"
   )
   void method3630(int var1, int var2, int var3) {
      class187 var4 = this.field3000[var1][var2];
      if(var4 != null) {
         this.field3000[var1][var2] = null;
         if((this.field2994[var1] & 2) != 0) {
            for(class187 var5 = (class187)this.field3008.field3023.method3797(); null != var5; var5 = (class187)this.field3008.field3023.method3779()) {
               if(var5.field3043 == var4.field3043 && var5.field3041 < 0 && var4 != var5) {
                  var4.field3041 = 0;
                  break;
               }
            }
         } else {
            var4.field3041 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "9"
   )
   public synchronized void method3639(int var1, int var2) {
      this.method3556(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public synchronized void method3647() {
      for(class181 var1 = (class181)this.field2997.method3751(); null != var1; var1 = (class181)this.field2997.method3752()) {
         var1.method3870();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   synchronized void method3656() {
      for(class181 var1 = (class181)this.field2997.method3751(); var1 != null; var1 = (class181)this.field2997.method3752()) {
         var1.method3469();
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "67"
   )
   int method3663(class187 var1) {
      int var2 = this.field2986[var1.field3043];
      return var2 < 8192?32 + var2 * var1.field3034 >> 6:16384 - ((16384 - var2) * (128 - var1.field3034) + 32 >> 6);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1334496013"
   )
   void method3670(int var1) {
      for(class187 var2 = (class187)this.field3008.field3023.method3797(); null != var2; var2 = (class187)this.field3008.field3023.method3779()) {
         if(var1 < 0 || var1 == var2.field3043) {
            if(null != var2.field3045) {
               var2.field3045.method1277(class56.field1194 / 100);
               if(var2.field3045.method1281()) {
                  this.field3008.field3025.method1094(var2.field3045);
               }

               var2.method3701();
            }

            if(var2.field3041 < 0) {
               this.field3000[var2.field3043][var2.field3032] = null;
            }

            var2.method3870();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;Ljava/lang/String;B)I",
      garbageValue = "1"
   )
   public static int method3672(class119 var0, String var1) {
      int var2 = var0.field2000;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method2546(var5.length);
      var0.field2000 += class222.field3185.method2396(var5, 0, var5.length, var0.field2001, var0.field2000);
      return var0.field2000 - var2;
   }
}
