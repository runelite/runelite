import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class184 extends class66 {
   @ObfuscatedName("az")
   class186 field2959 = new class186(this);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1826018299
   )
   int field2960 = 256;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -417308481
   )
   int field2961 = 1000000;
   @ObfuscatedName("n")
   int[] field2962 = new int[16];
   @ObfuscatedName("x")
   int[] field2963 = new int[16];
   @ObfuscatedName("y")
   int[] field2964 = new int[16];
   @ObfuscatedName("c")
   int[] field2965 = new int[16];
   @ObfuscatedName("r")
   int[] field2966 = new int[16];
   @ObfuscatedName("l")
   int[] field2967 = new int[16];
   @ObfuscatedName("i")
   int[] field2968 = new int[16];
   @ObfuscatedName("p")
   int[] field2969 = new int[16];
   @ObfuscatedName("u")
   int[] field2970 = new int[16];
   @ObfuscatedName("b")
   class196 field2971 = new class196(128);
   @ObfuscatedName("f")
   int[] field2972 = new int[16];
   @ObfuscatedName("q")
   int[] field2973 = new int[16];
   @ObfuscatedName("a")
   int[] field2975 = new int[16];
   @ObfuscatedName("d")
   int[] field2976 = new int[16];
   @ObfuscatedName("e")
   class187[][] field2977 = new class187[16][128];
   @ObfuscatedName("aw")
   class187[][] field2978 = new class187[16][128];
   @ObfuscatedName("an")
   class182 field2979 = new class182();
   @ObfuscatedName("ag")
   boolean field2980;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -761877015
   )
   int field2981;
   @ObfuscatedName("m")
   int[] field2982 = new int[16];
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = 4851370941550616389L
   )
   long field2983;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = 2483166093977547913L
   )
   long field2984;
   @ObfuscatedName("s")
   int[] field2985 = new int[16];
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1569623817
   )
   int field2987;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1258574739"
   )
   public synchronized void method3608(int var1) {
      this.field2960 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1973382230"
   )
   public int method3609() {
      return this.field2960;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-49587052"
   )
   public synchronized void method3612() {
      for(class181 var1 = (class181)this.field2971.method3799(); var1 != null; var1 = (class181)this.field2971.method3800()) {
         var1.method3916();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZB)V",
      garbageValue = "-39"
   )
   synchronized void method3613(class180 var1, boolean var2) {
      this.method3614();
      this.field2979.method3539(var1.field2924);
      this.field2980 = var2;
      this.field2983 = 0L;
      int var3 = this.field2979.method3542();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2979.method3543(var4);
         this.field2979.method3545(var4);
         this.field2979.method3544(var4);
      }

      this.field2981 = this.field2979.method3550();
      this.field2987 = this.field2979.field2939[this.field2981];
      this.field2984 = this.field2979.method3549(this.field2987);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1372539310"
   )
   public synchronized void method3614() {
      this.field2979.method3540();
      this.method3652();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-805865479"
   )
   void method3617() {
      int var1 = this.field2981;
      int var2 = this.field2987;

      long var3;
      for(var3 = this.field2984; var2 == this.field2987; var3 = this.field2979.method3549(var2)) {
         while(this.field2979.field2939[var1] == var2) {
            this.field2979.method3543(var1);
            int var5 = this.field2979.method3546(var1);
            if(var5 == 1) {
               this.field2979.method3552();
               this.field2979.method3544(var1);
               if(this.field2979.method3551()) {
                  if(!this.field2980 || var2 == 0) {
                     this.method3652();
                     this.field2979.method3540();
                     return;
                  }

                  this.field2979.method3593(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3630(var5);
            }

            this.field2979.method3545(var1);
            this.field2979.method3544(var1);
         }

         var1 = this.field2979.method3550();
         var2 = this.field2979.field2939[var1];
      }

      this.field2981 = var1;
      this.field2987 = var2;
      this.field2984 = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-5"
   )
   void method3618(int var1, int var2) {
      if(var2 != this.field2965[var1]) {
         this.field2965[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2978[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "480"
   )
   void method3619(int var1, int var2, int var3) {
      this.method3621(var1, var2, 64);
      if((this.field2975[var1] & 2) != 0) {
         for(class187 var4 = (class187)this.field2959.field3002.method3824(); var4 != null; var4 = (class187)this.field2959.field3002.method3826()) {
            if(var1 == var4.field3014 && var4.field3021 < 0) {
               this.field2977[var1][var4.field3012] = null;
               this.field2977[var1][var2] = var4;
               int var8 = (var4.field3013 * var4.field3019 >> 12) + var4.field3015;
               var4.field3015 += var2 - var4.field3012 << 8;
               var4.field3013 = var8 - var4.field3015;
               var4.field3019 = 4096;
               var4.field3012 = var2;
               return;
            }
         }
      }

      class181 var9 = (class181)this.field2971.method3807((long)this.field2965[var1]);
      if(null != var9) {
         class62 var5 = var9.field2926[var2];
         if(null != var5) {
            class187 var6 = new class187();
            var6.field3014 = var1;
            var6.field3008 = var9;
            var6.field3017 = var5;
            var6.field3010 = var9.field2933[var2];
            var6.field3011 = var9.field2931[var2];
            var6.field3012 = var2;
            var6.field3025 = 1024 + var9.field2928[var2] * var9.field2925 * var3 * var3 >> 11;
            var6.field3009 = var9.field2930[var2] & 255;
            var6.field3015 = (var2 << 8) - (var9.field2927[var2] & 32767);
            var6.field3018 = 0;
            var6.field3016 = 0;
            var6.field3020 = 0;
            var6.field3021 = -1;
            var6.field3022 = 0;
            if(this.field2982[var1] == 0) {
               var6.field3007 = class64.method1312(var5, this.method3663(var6), this.method3633(var6), this.method3634(var6));
            } else {
               var6.field3007 = class64.method1312(var5, this.method3663(var6), 0, this.method3634(var6));
               this.method3717(var6, var9.field2927[var2] < 0);
            }

            if(var9.field2927[var2] < 0) {
               var6.field3007.method1314(-1);
            }

            if(var6.field3011 >= 0) {
               class187 var7 = this.field2978[var1][var6.field3011];
               if(null != var7 && var7.field3021 < 0) {
                  this.field2977[var1][var7.field3012] = null;
                  var7.field3021 = 0;
               }

               this.field2978[var1][var6.field3011] = var6;
            }

            this.field2959.field3002.method3819(var6);
            this.field2977[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1071265053"
   )
   void method3621(int var1, int var2, int var3) {
      class187 var4 = this.field2977[var1][var2];
      if(var4 != null) {
         this.field2977[var1][var2] = null;
         if((this.field2975[var1] & 2) != 0) {
            for(class187 var5 = (class187)this.field2959.field3002.method3844(); null != var5; var5 = (class187)this.field2959.field3002.method3834()) {
               if(var4.field3014 == var5.field3014 && var5.field3021 < 0 && var4 != var5) {
                  var4.field3021 = 0;
                  break;
               }
            }
         } else {
            var4.field3021 = 0;
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-110"
   )
   void method3622(int var1, int var2, int var3) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1958065589"
   )
   void method3623(int var1, int var2) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1171267075"
   )
   void method3625(int var1) {
      for(class187 var2 = (class187)this.field2959.field3002.method3844(); var2 != null; var2 = (class187)this.field2959.field3002.method3834()) {
         if(var1 < 0 || var1 == var2.field3014) {
            if(var2.field3007 != null) {
               var2.field3007.method1362(class56.field1153 / 100);
               if(var2.field3007.method1329()) {
                  this.field2959.field3003.method1167(var2.field3007);
               }

               var2.method3751();
            }

            if(var2.field3021 < 0) {
               this.field2977[var2.field3014][var2.field3012] = null;
            }

            var2.method3916();
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1668492769"
   )
   synchronized void method3626() {
      for(class181 var1 = (class181)this.field2971.method3799(); null != var1; var1 = (class181)this.field2971.method3800()) {
         var1.method3534();
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1310018974"
   )
   void method3627(int var1) {
      for(class187 var2 = (class187)this.field2959.field3002.method3844(); var2 != null; var2 = (class187)this.field2959.field3002.method3834()) {
         if((var1 < 0 || var2.field3014 == var1) && var2.field3021 < 0) {
            this.field2977[var2.field3014][var2.field3012] = null;
            var2.field3021 = 0;
         }
      }

   }

   public class184() {
      this.method3652();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2004829170"
   )
   void method3629(int var1, int var2) {
      this.field2970[var1] = var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1062373069"
   )
   void method3630(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3621(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3619(var3, var4, var5);
         } else {
            this.method3621(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3622(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2967[var3] = (var5 << 14) + (this.field2967[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2967[var3] = (var5 << 7) + (this.field2967[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2969[var3] = (var5 << 7) + (this.field2969[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2969[var3] = var5 + (this.field2969[var3] & -128);
         }

         if(var4 == 5) {
            this.field2962[var3] = (var5 << 7) + (this.field2962[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2962[var3] = var5 + (this.field2962[var3] & -128);
         }

         if(var4 == 7) {
            this.field2976[var3] = (this.field2976[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2976[var3] = var5 + (this.field2976[var3] & -128);
         }

         if(var4 == 10) {
            this.field2963[var3] = (var5 << 7) + (this.field2963[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2963[var3] = (this.field2963[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field2964[var3] = (var5 << 7) + (this.field2964[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2964[var3] = var5 + (this.field2964[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2975[var3] |= 1;
            } else {
               this.field2975[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2975[var3] |= 2;
            } else {
               this.method3640(var3);
               this.field2975[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2972[var3] = (this.field2972[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2972[var3] = var5 + (this.field2972[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2972[var3] = (this.field2972[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2972[var3] = 16384 + (this.field2972[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method3625(var3);
         }

         if(var4 == 121) {
            this.method3710(var3);
         }

         if(var4 == 123) {
            this.method3627(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2972[var3];
            if(var6 == 16384) {
               this.field2973[var3] = (var5 << 7) + (this.field2973[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2972[var3];
            if(var6 == 16384) {
               this.field2973[var3] = var5 + (this.field2973[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2982[var3] = (var5 << 7) + (this.field2982[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2982[var3] = var5 + (this.field2982[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2975[var3] |= 4;
            } else {
               this.method3697(var3);
               this.field2975[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3631(var3, (var5 << 7) + (this.field2985[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3631(var3, var5 + (this.field2985[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3618(var3, this.field2967[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3623(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3629(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3652();
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1690480575"
   )
   void method3631(int var1, int var2) {
      this.field2985[var1] = var2;
      this.field2968[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "-2083163662"
   )
   int method3633(class187 var1) {
      class185 var2 = var1.field3010;
      int var3 = this.field2976[var1.field3014] * this.field2964[var1.field3014] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field3025 + 16384 >> 15;
      var3 = var3 * this.field2960 + 128 >> 8;
      if(var2.field2997 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2997 * (double)var1.field3018 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field2996) {
         var4 = var1.field3016;
         var5 = var2.field2996[1 + var1.field3020];
         if(var1.field3020 < var2.field2996.length - 2) {
            var6 = (var2.field2996[var1.field3020] & 255) << 8;
            var7 = (var2.field2996[2 + var1.field3020] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2996[var1.field3020 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3021 > 0 && null != var2.field2999) {
         var4 = var1.field3021;
         var5 = var2.field2999[var1.field3022 + 1];
         if(var1.field3022 < var2.field2999.length - 2) {
            var6 = (var2.field2999[var1.field3022] & 255) << 8;
            var7 = (var2.field2999[var1.field3022 + 2] & 255) << 8;
            var5 += (var2.field2999[var1.field3022 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "1"
   )
   int method3634(class187 var1) {
      int var2 = this.field2963[var1.field3014];
      return var2 < 8192?32 + var2 * var1.field3009 >> 6:16384 - ((128 - var1.field3009) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("r")
   protected synchronized class66 vmethod3736() {
      return null;
   }

   @ObfuscatedName("c")
   protected synchronized int vmethod3724() {
      return 0;
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3721(int[] var1, int var2, int var3) {
      if(this.field2979.method3541()) {
         int var4 = this.field2979.field2936 * this.field2961 / class56.field1153;

         do {
            long var5 = this.field2983 + (long)var4 * (long)var3;
            if(this.field2984 - var5 >= 0L) {
               this.field2983 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2984 - this.field2983) - 1L) / (long)var4);
            this.field2983 += (long)var4 * (long)var7;
            this.field2959.vmethod3721(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3617();
         } while(this.field2979.method3541());
      }

      this.field2959.vmethod3721(var1, var2, var3);
   }

   @ObfuscatedName("p")
   protected synchronized void vmethod3725(int var1) {
      if(this.field2979.method3541()) {
         int var2 = this.field2961 * this.field2979.field2936 / class56.field1153;

         do {
            long var3 = this.field2983 + (long)var1 * (long)var2;
            if(this.field2984 - var3 >= 0L) {
               this.field2983 = var3;
               break;
            }

            int var5 = (int)((this.field2984 - this.field2983 + (long)var2 - 1L) / (long)var2);
            this.field2983 += (long)var5 * (long)var2;
            this.field2959.vmethod3725(var5);
            var1 -= var5;
            this.method3617();
         } while(this.field2979.method3541());
      }

      this.field2959.vmethod3725(var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-26"
   )
   void method3640(int var1) {
      if((this.field2975[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field2959.field3002.method3844(); null != var2; var2 = (class187)this.field2959.field3002.method3834()) {
            if(var2.field3014 == var1 && null == this.field2977[var1][var2.field3012] && var2.field3021 < 0) {
               var2.field3021 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIII)Z",
      garbageValue = "-401921307"
   )
   boolean method3642(class187 var1, int[] var2, int var3, int var4) {
      var1.field3026 = class56.field1153 / 100;
      if(var1.field3021 < 0 || null != var1.field3007 && !var1.field3007.method1391()) {
         int var5 = var1.field3019;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2962[var1.field3014]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3019 = var5;
         }

         var1.field3007.method1326(this.method3663(var1));
         class185 var6 = var1.field3010;
         boolean var7 = false;
         ++var1.field3023;
         var1.field3024 += var6.field2989;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3012 - 60 << 8) + (var1.field3013 * var1.field3019 >> 12));
         if(var6.field2997 > 0) {
            if(var6.field2994 > 0) {
               var1.field3018 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2994) + 0.5D);
            } else {
               var1.field3018 += 128;
            }
         }

         if(null != var6.field2996) {
            if(var6.field2992 > 0) {
               var1.field3016 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2992) + 0.5D);
            } else {
               var1.field3016 += 128;
            }

            while(var1.field3020 < var6.field2996.length - 2 && var1.field3016 > (var6.field2996[var1.field3020 + 2] & 255) << 8) {
               var1.field3020 += 2;
            }

            if(var6.field2996.length - 2 == var1.field3020 && var6.field2996[var1.field3020 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3021 >= 0 && var6.field2999 != null && (this.field2975[var1.field3014] & 1) == 0 && (var1.field3011 < 0 || this.field2978[var1.field3014][var1.field3011] != var1)) {
            if(var6.field2993 > 0) {
               var1.field3021 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2993) + 0.5D);
            } else {
               var1.field3021 += 128;
            }

            while(var1.field3022 < var6.field2999.length - 2 && var1.field3021 > (var6.field2999[var1.field3022 + 2] & 255) << 8) {
               var1.field3022 += 2;
            }

            if(var1.field3022 == var6.field2999.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3007.method1362(var1.field3026);
            if(var2 != null) {
               var1.field3007.vmethod3721(var2, var3, var4);
            } else {
               var1.field3007.vmethod3725(var4);
            }

            if(var1.field3007.method1329()) {
               this.field2959.field3003.method1167(var1.field3007);
            }

            var1.method3751();
            if(var1.field3021 >= 0) {
               var1.method3916();
               if(var1.field3011 > 0 && this.field2978[var1.field3014][var1.field3011] == var1) {
                  this.field2978[var1.field3014][var1.field3011] = null;
               }
            }

            return true;
         } else {
            var1.field3007.method1324(var1.field3026, this.method3633(var1), this.method3634(var1));
            return false;
         }
      } else {
         var1.method3751();
         var1.method3916();
         if(var1.field3011 > 0 && var1 == this.field2978[var1.field3014][var1.field3011]) {
            this.field2978[var1.field3014][var1.field3011] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)Z",
      garbageValue = "1318806161"
   )
   boolean method3651(class187 var1) {
      if(var1.field3007 == null) {
         if(var1.field3021 >= 0) {
            var1.method3916();
            if(var1.field3011 > 0 && this.field2978[var1.field3014][var1.field3011] == var1) {
               this.field2978[var1.field3014][var1.field3011] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1295851339"
   )
   void method3652() {
      this.method3625(-1);
      this.method3710(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2965[var1] = this.field2966[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2967[var1] = this.field2966[var1] & -128;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "-1881340479"
   )
   int method3663(class187 var1) {
      int var2 = (var1.field3013 * var1.field3019 >> 12) + var1.field3015;
      var2 += (this.field2970[var1.field3014] - 8192) * this.field2973[var1.field3014] >> 12;
      class185 var3 = var1.field3010;
      int var4;
      if(var3.field2989 > 0 && (var3.field2995 > 0 || this.field2969[var1.field3014] > 0)) {
         var4 = var3.field2995 << 2;
         int var5 = var3.field2990 << 1;
         if(var1.field3023 < var5) {
            var4 = var1.field3023 * var4 / var5;
         }

         var4 += this.field2969[var1.field3014] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3024 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field3017.field1199) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1153 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "9"
   )
   public synchronized void method3694(int var1, int var2) {
      this.method3703(var1, var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "47"
   )
   void method3697(int var1) {
      if((this.field2975[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field2959.field3002.method3844(); null != var2; var2 = (class187)this.field2959.field3002.method3834()) {
            if(var2.field3014 == var1) {
               var2.field3027 = 0;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2105518121"
   )
   void method3703(int var1, int var2) {
      this.field2966[var1] = var2;
      this.field2967[var1] = var2 & -128;
      this.method3618(var1, var2);
   }

   @ObfuscatedName("y")
   protected synchronized class66 vmethod3722() {
      return this.field2959;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-9"
   )
   public synchronized boolean method3707() {
      return this.field2979.method3541();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1726441209"
   )
   void method3710(int var1) {
      if(var1 >= 0) {
         this.field2976[var1] = 12800;
         this.field2963[var1] = 8192;
         this.field2964[var1] = 16383;
         this.field2970[var1] = 8192;
         this.field2969[var1] = 0;
         this.field2962[var1] = 8192;
         this.method3640(var1);
         this.method3697(var1);
         this.field2975[var1] = 0;
         this.field2972[var1] = 32767;
         this.field2973[var1] = 256;
         this.field2982[var1] = 0;
         this.method3631(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3710(var1);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;IB)Z",
      garbageValue = "22050"
   )
   synchronized boolean method3711(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3524();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2923.method3799(); null != var7; var7 = (class197)var1.field2923.method3800()) {
         int var8 = (int)var7.field3113;
         class181 var9 = (class181)this.field2971.method3807((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3271(var8);
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

            this.field2971.method3797(var10, (long)var8);
         }

         if(!var9.method3535(var3, var7.field3093, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3525();
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZB)V",
      garbageValue = "1"
   )
   void method3717(class187 var1, boolean var2) {
      int var3 = var1.field3017.field1198.length;
      int var4;
      if(var1.field3017.field1202) {
         int var5 = var3 + var3 - var1.field3017.field1200;
         var4 = (int)((long)var5 * (long)this.field2982[var1.field3014] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3007.method1321();
         }
      } else {
         var4 = (int)((long)this.field2982[var1.field3014] * (long)var3 >> 6);
      }

      var1.field3007.method1411(var4);
   }
}
