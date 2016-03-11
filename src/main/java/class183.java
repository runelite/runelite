import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class183 extends class66 {
   @ObfuscatedName("k")
   int[] field2959 = new int[16];
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1299944197
   )
   int field2960 = 256;
   @ObfuscatedName("i")
   int[] field2961 = new int[16];
   @ObfuscatedName("b")
   int[] field2962 = new int[16];
   @ObfuscatedName("f")
   int[] field2963 = new int[16];
   @ObfuscatedName("m")
   int[] field2964 = new int[16];
   @ObfuscatedName("o")
   int[] field2965 = new int[16];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -221262583
   )
   int field2966;
   @ObfuscatedName("ai")
   class185 field2967 = new class185(this);
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = -6524248238338373235L
   )
   long field2968;
   @ObfuscatedName("n")
   int[] field2969 = new int[16];
   @ObfuscatedName("r")
   int[] field2970 = new int[16];
   @ObfuscatedName("p")
   int[] field2971 = new int[16];
   @ObfuscatedName("w")
   int[] field2972 = new int[16];
   @ObfuscatedName("t")
   int[] field2973 = new int[16];
   @ObfuscatedName("c")
   int[] field2974 = new int[16];
   @ObfuscatedName("x")
   int[] field2975 = new int[16];
   @ObfuscatedName("e")
   int[] field2976 = new int[16];
   @ObfuscatedName("v")
   class186[][] field2977 = new class186[16][128];
   @ObfuscatedName("j")
   class195 field2978 = new class195(128);
   @ObfuscatedName("ak")
   class181 field2979 = new class181();
   @ObfuscatedName("am")
   boolean field2980;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1721232109
   )
   int field2981;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1591503073
   )
   int field2982 = 1000000;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = -1761923199436082627L
   )
   long field2983;
   @ObfuscatedName("h")
   int[] field2984 = new int[16];
   @ObfuscatedName("ab")
   class186[][] field2985 = new class186[16][128];

   @ObfuscatedName("j")
   public synchronized void method3549(int var1) {
      this.field2960 = var1;
   }

   @ObfuscatedName("l")
   int method3550() {
      return this.field2960;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass179;Lclass166;Lclass59;II)Z",
      garbageValue = "22050"
   )
   public synchronized boolean method3551(class179 var1, class166 var2, class59 var3, int var4) {
      var1.method3461();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class196 var7 = (class196)var1.field2923.method3748(); var7 != null; var7 = (class196)var1.field2923.method3747()) {
         int var8 = (int)var7.field3112;
         class180 var9 = (class180)this.field2978.method3744((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method3219(var8);
            class180 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class180(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2978.method3746(var10, (long)var8);
         }

         if(!var9.method3472(var3, var7.field3090, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3462();
      }

      return var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   synchronized void method3553() {
      for(class180 var1 = (class180)this.field2978.method3748(); var1 != null; var1 = (class180)this.field2978.method3747()) {
         var1.method3853();
      }

   }

   @ObfuscatedName("k")
   public synchronized void method3554(class179 var1, boolean var2) {
      this.method3637();
      this.field2979.method3493(var1.field2924);
      this.field2980 = var2;
      this.field2983 = 0L;
      int var3 = this.field2979.method3482();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2979.method3483(var4);
         this.field2979.method3486(var4);
         this.field2979.method3484(var4);
      }

      this.field2981 = this.field2979.method3491();
      this.field2966 = this.field2979.field2941[this.field2981];
      this.field2968 = this.field2979.method3490(this.field2966);
   }

   @ObfuscatedName("q")
   public synchronized boolean method3556() {
      return this.field2979.method3481();
   }

   @ObfuscatedName("g")
   void method3558(int var1, int var2) {
      this.field2965[var1] = var2;
      this.field2969[var1] = var2 & -128;
      this.method3645(var1, var2);
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3676(int var1) {
      if(this.field2979.method3481()) {
         int var2 = this.field2982 * this.field2979.field2938 / class102.field1780;

         do {
            long var3 = this.field2983 + (long)var2 * (long)var1;
            if(this.field2968 - var3 >= 0L) {
               this.field2983 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2968 - this.field2983) - 1L) / (long)var2);
            this.field2983 += (long)var2 * (long)var5;
            this.field2967.vmethod3676(var5);
            var1 -= var5;
            this.method3582();
         } while(this.field2979.method3481());
      }

      this.field2967.vmethod3676(var1);
   }

   @ObfuscatedName("p")
   void method3563() {
   }

   @ObfuscatedName("w")
   void method3564() {
   }

   @ObfuscatedName("t")
   void method3565(int var1, int var2) {
      this.field2959[var1] = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1797936758"
   )
   void method3566(int var1) {
      for(class186 var2 = (class186)this.field2967.field2999.method3773(); var2 != null; var2 = (class186)this.field2967.field2999.method3772()) {
         if(var1 < 0 || var2.field3012 == var1) {
            if(null != var2.field3018) {
               var2.field3018.method1315(class102.field1780 / 100);
               if(var2.field3018.method1302()) {
                  this.field2967.field3001.method1152(var2.field3018);
               }

               var2.method3698();
            }

            if(var2.field3017 < 0) {
               this.field2977[var2.field3012][var2.field3008] = null;
            }

            var2.method3853();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1270952642"
   )
   void method3567(int var1) {
      if(var1 >= 0) {
         this.field2961[var1] = 12800;
         this.field2963[var1] = 8192;
         this.field2964[var1] = 16383;
         this.field2959[var1] = 8192;
         this.field2970[var1] = 0;
         this.field2962[var1] = 8192;
         this.method3658(var1);
         this.method3660(var1);
         this.field2971[var1] = 0;
         this.field2972[var1] = 32767;
         this.field2973[var1] = 256;
         this.field2974[var1] = 0;
         this.method3575(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3567(var1);
         }

      }
   }

   @ObfuscatedName("e")
   void method3568(int var1) {
      for(class186 var2 = (class186)this.field2967.field2999.method3773(); null != var2; var2 = (class186)this.field2967.field2999.method3772()) {
         if((var1 < 0 || var1 == var2.field3012) && var2.field3017 < 0) {
            this.field2977[var2.field3012][var2.field3008] = null;
            var2.field3017 = 0;
         }
      }

   }

   @ObfuscatedName("v")
   void method3569() {
      this.method3566(-1);
      this.method3567(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2984[var1] = this.field2965[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2969[var1] = this.field2965[var1] & -128;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-43"
   )
   void method3572(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(128 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3636(var3, var4);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3635(var3, var4, var5);
         } else {
            this.method3636(var3, var4);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3563();
      } else if(176 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(0 == var4) {
            this.field2969[var3] = (var5 << 14) + (this.field2969[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2969[var3] = (var5 << 7) + (this.field2969[var3] & -16257);
         }

         if(1 == var4) {
            this.field2970[var3] = (this.field2970[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field2970[var3] = (this.field2970[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2962[var3] = (this.field2962[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2962[var3] = var5 + (this.field2962[var3] & -128);
         }

         if(var4 == 7) {
            this.field2961[var3] = (this.field2961[var3] & -16257) + (var5 << 7);
         }

         if(39 == var4) {
            this.field2961[var3] = (this.field2961[var3] & -128) + var5;
         }

         if(10 == var4) {
            this.field2963[var3] = (var5 << 7) + (this.field2963[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2963[var3] = var5 + (this.field2963[var3] & -128);
         }

         if(var4 == 11) {
            this.field2964[var3] = (this.field2964[var3] & -16257) + (var5 << 7);
         }

         if(43 == var4) {
            this.field2964[var3] = (this.field2964[var3] & -128) + var5;
         }

         if(64 == var4) {
            if(var5 >= 64) {
               this.field2971[var3] |= 1;
            } else {
               this.field2971[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2971[var3] |= 2;
            } else {
               this.method3658(var3);
               this.field2971[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2972[var3] = (var5 << 7) + (this.field2972[var3] & 127);
         }

         if(98 == var4) {
            this.field2972[var3] = var5 + (this.field2972[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2972[var3] = (var5 << 7) + 16384 + (this.field2972[var3] & 127);
         }

         if(100 == var4) {
            this.field2972[var3] = (this.field2972[var3] & 16256) + 16384 + var5;
         }

         if(120 == var4) {
            this.method3566(var3);
         }

         if(121 == var4) {
            this.method3567(var3);
         }

         if(123 == var4) {
            this.method3568(var3);
         }

         int var6;
         if(6 == var4) {
            var6 = this.field2972[var3];
            if(16384 == var6) {
               this.field2973[var3] = (var5 << 7) + (this.field2973[var3] & -16257);
            }
         }

         if(38 == var4) {
            var6 = this.field2972[var3];
            if(16384 == var6) {
               this.field2973[var3] = (this.field2973[var3] & -128) + var5;
            }
         }

         if(16 == var4) {
            this.field2974[var3] = (this.field2974[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field2974[var3] = var5 + (this.field2974[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2971[var3] |= 4;
            } else {
               this.method3660(var3);
               this.field2971[var3] &= -5;
            }
         }

         if(17 == var4) {
            this.method3575(var3, (var5 << 7) + (this.field2975[var3] & -16257));
         }

         if(49 == var4) {
            this.method3575(var3, (this.field2975[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3645(var3, this.field2969[var3] + var4);
      } else if(208 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3564();
      } else if(224 == var2) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3565(var3, var4);
      } else {
         var2 = var1 & 255;
         if(255 == var2) {
            this.method3569();
         }
      }
   }

   @ObfuscatedName("an")
   int method3574(class186 var1) {
      int var2 = (var1.field3013 * var1.field3023 >> 12) + var1.field3011;
      var2 += this.field2973[var1.field3012] * (this.field2959[var1.field3012] - 8192) >> 12;
      class184 var3 = var1.field3006;
      int var4;
      if(var3.field2994 > 0 && (var3.field2997 > 0 || this.field2970[var1.field3012] > 0)) {
         var4 = var3.field2997 << 2;
         int var5 = var3.field2995 << 1;
         if(var1.field3019 < var5) {
            var4 = var4 * var1.field3019 / var5;
         }

         var4 += this.field2970[var1.field3012] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3020 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field3015.field1241) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class102.field1780 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ao")
   void method3575(int var1, int var2) {
      this.field2975[var1] = var2;
      this.field2976[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("al")
   int method3576(class186 var1) {
      int var2 = this.field2963[var1.field3012];
      return var2 < 8192?var2 * var1.field3003 + 32 >> 6:16384 - (32 + (128 - var1.field3003) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("m")
   protected synchronized class66 vmethod3677() {
      return this.field2967;
   }

   @ObfuscatedName("o")
   protected synchronized class66 vmethod3678() {
      return null;
   }

   @ObfuscatedName("n")
   protected synchronized void vmethod3680(int[] var1, int var2, int var3) {
      if(this.field2979.method3481()) {
         int var4 = this.field2982 * this.field2979.field2938 / class102.field1780;

         do {
            long var5 = this.field2983 + (long)var3 * (long)var4;
            if(this.field2968 - var5 >= 0L) {
               this.field2983 = var5;
               break;
            }

            int var7 = (int)((this.field2968 - this.field2983 + (long)var4 - 1L) / (long)var4);
            this.field2983 += (long)var4 * (long)var7;
            this.field2967.vmethod3680(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3582();
         } while(this.field2979.method3481());
      }

      this.field2967.vmethod3680(var1, var2, var3);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "584789802"
   )
   void method3582() {
      int var1 = this.field2981;
      int var2 = this.field2966;

      long var3;
      for(var3 = this.field2968; var2 == this.field2966; var3 = this.field2979.method3490(var2)) {
         while(var2 == this.field2979.field2941[var1]) {
            this.field2979.method3483(var1);
            int var5 = this.field2979.method3526(var1);
            if(var5 == 1) {
               this.field2979.method3485();
               this.field2979.method3484(var1);
               if(this.field2979.method3479()) {
                  if(!this.field2980 || 0 == var2) {
                     this.method3569();
                     this.field2979.method3480();
                     return;
                  }

                  this.field2979.method3492(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3572(var5);
            }

            this.field2979.method3486(var1);
            this.field2979.method3484(var1);
         }

         var1 = this.field2979.method3491();
         var2 = this.field2979.field2941[var1];
      }

      this.field2981 = var1;
      this.field2966 = var2;
      this.field2968 = var3;
   }

   @ObfuscatedName("h")
   protected synchronized int vmethod3679() {
      return 0;
   }

   @ObfuscatedName("ap")
   boolean method3584(class186 var1, int[] var2, int var3, int var4) {
      var1.field3022 = class102.field1780 / 100;
      if(var1.field3017 < 0 || var1.field3018 != null && !var1.field3018.method1318()) {
         int var5 = var1.field3013;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2962[var1.field3012]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3013 = var5;
         }

         var1.field3018.method1316(this.method3574(var1));
         class184 var6 = var1.field3006;
         boolean var7 = false;
         ++var1.field3019;
         var1.field3020 += var6.field2994;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3008 - 60 << 8) + (var1.field3013 * var1.field3023 >> 12));
         if(var6.field2989 > 0) {
            if(var6.field2992 > 0) {
               var1.field3014 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2992) + 0.5D);
            } else {
               var1.field3014 += 128;
            }
         }

         if(var6.field2991 != null) {
            if(var6.field2987 > 0) {
               var1.field3016 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2987 * var8) + 0.5D);
            } else {
               var1.field3016 += 128;
            }

            while(var1.field3021 < var6.field2991.length - 2 && var1.field3016 > (var6.field2991[var1.field3021 + 2] & 255) << 8) {
               var1.field3021 += 2;
            }

            if(var1.field3021 == var6.field2991.length - 2 && var6.field2991[1 + var1.field3021] == 0) {
               var7 = true;
            }
         }

         if(var1.field3017 >= 0 && null != var6.field2988 && 0 == (this.field2971[var1.field3012] & 1) && (var1.field3007 < 0 || this.field2985[var1.field3012][var1.field3007] != var1)) {
            if(var6.field2990 > 0) {
               var1.field3017 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2990) + 0.5D);
            } else {
               var1.field3017 += 128;
            }

            while(var1.field3005 < var6.field2988.length - 2 && var1.field3017 > (var6.field2988[2 + var1.field3005] & 255) << 8) {
               var1.field3005 += 2;
            }

            if(var6.field2988.length - 2 == var1.field3005) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3018.method1315(var1.field3022);
            if(null != var2) {
               var1.field3018.vmethod3680(var2, var3, var4);
            } else {
               var1.field3018.vmethod3676(var4);
            }

            if(var1.field3018.method1302()) {
               this.field2967.field3001.method1152(var1.field3018);
            }

            var1.method3698();
            if(var1.field3017 >= 0) {
               var1.method3853();
               if(var1.field3007 > 0 && var1 == this.field2985[var1.field3012][var1.field3007]) {
                  this.field2985[var1.field3012][var1.field3007] = null;
               }
            }

            return true;
         } else {
            var1.field3018.method1361(var1.field3022, this.method3602(var1), this.method3576(var1));
            return false;
         }
      } else {
         var1.method3698();
         var1.method3853();
         if(var1.field3007 > 0 && var1 == this.field2985[var1.field3012][var1.field3007]) {
            this.field2985[var1.field3012][var1.field3007] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   public synchronized void method3596() {
      for(class180 var1 = (class180)this.field2978.method3748(); var1 != null; var1 = (class180)this.field2978.method3747()) {
         var1.method3473();
      }

   }

   @ObfuscatedName("at")
   int method3602(class186 var1) {
      class184 var2 = var1.field3006;
      int var3 = 4096 + this.field2961[var1.field3012] * this.field2964[var1.field3012] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var1.field3009 * var3 + 16384 >> 15;
      var3 = var3 * this.field2960 + 128 >> 8;
      if(var2.field2989 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3014 * 1.953125E-5D * (double)var2.field2989) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field2991) {
         var4 = var1.field3016;
         var5 = var2.field2991[var1.field3021 + 1];
         if(var1.field3021 < var2.field2991.length - 2) {
            var6 = (var2.field2991[var1.field3021] & 255) << 8;
            var7 = (var2.field2991[2 + var1.field3021] & 255) << 8;
            var5 += (var2.field2991[3 + var1.field3021] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3017 > 0 && var2.field2988 != null) {
         var4 = var1.field3017;
         var5 = var2.field2988[1 + var1.field3005];
         if(var1.field3005 < var2.field2988.length - 2) {
            var6 = (var2.field2988[var1.field3005] & 255) << 8;
            var7 = (var2.field2988[var1.field3005 + 2] & 255) << 8;
            var5 += (var2.field2988[var1.field3005 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1893593205"
   )
   void method3635(int var1, int var2, int var3) {
      this.method3636(var1, var2);
      if((this.field2971[var1] & 2) != 0) {
         for(class186 var4 = (class186)this.field2967.field2999.method3774(); var4 != null; var4 = (class186)this.field2967.field2999.method3776()) {
            if(var4.field3012 == var1 && var4.field3017 < 0) {
               this.field2977[var1][var4.field3008] = null;
               this.field2977[var1][var2] = var4;
               int var5 = var4.field3011 + (var4.field3013 * var4.field3023 >> 12);
               var4.field3011 += var2 - var4.field3008 << 8;
               var4.field3023 = var5 - var4.field3011;
               var4.field3013 = 4096;
               var4.field3008 = var2;
               return;
            }
         }
      }

      class180 var8 = (class180)this.field2978.method3744((long)this.field2984[var1]);
      if(null != var8) {
         class62 var9 = var8.field2926[var2];
         if(null != var9) {
            class186 var6 = new class186();
            var6.field3012 = var1;
            var6.field3004 = var8;
            var6.field3015 = var9;
            var6.field3006 = var8.field2936[var2];
            var6.field3007 = var8.field2931[var2];
            var6.field3008 = var2;
            var6.field3009 = var3 * var3 * var8.field2925 * var8.field2928[var2] + 1024 >> 11;
            var6.field3003 = var8.field2929[var2] & 255;
            var6.field3011 = (var2 << 8) - (var8.field2927[var2] & 32767);
            var6.field3014 = 0;
            var6.field3016 = 0;
            var6.field3021 = 0;
            var6.field3017 = -1;
            var6.field3005 = 0;
            if(0 == this.field2974[var1]) {
               var6.field3018 = class64.method1355(var9, this.method3574(var6), this.method3602(var6), this.method3576(var6));
            } else {
               var6.field3018 = class64.method1355(var9, this.method3574(var6), 0, this.method3576(var6));
               this.method3641(var6, var8.field2927[var2] < 0);
            }

            if(var8.field2927[var2] < 0) {
               var6.field3018.method1304(-1);
            }

            if(var6.field3007 >= 0) {
               class186 var7 = this.field2985[var1][var6.field3007];
               if(var7 != null && var7.field3017 < 0) {
                  this.field2977[var1][var7.field3008] = null;
                  var7.field3017 = 0;
               }

               this.field2985[var1][var6.field3007] = var6;
            }

            this.field2967.field2999.method3768(var6);
            this.field2977[var1][var2] = var6;
         }
      }
   }

   public class183() {
      this.method3569();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1633144929"
   )
   void method3636(int var1, int var2) {
      class186 var3 = this.field2977[var1][var2];
      if(var3 != null) {
         this.field2977[var1][var2] = null;
         if(0 != (this.field2971[var1] & 2)) {
            for(class186 var4 = (class186)this.field2967.field2999.method3773(); var4 != null; var4 = (class186)this.field2967.field2999.method3772()) {
               if(var3.field3012 == var4.field3012 && var4.field3017 < 0 && var3 != var4) {
                  var3.field3017 = 0;
                  break;
               }
            }
         } else {
            var3.field3017 = 0;
         }

      }
   }

   @ObfuscatedName("b")
   public synchronized void method3637() {
      this.field2979.method3480();
      this.method3569();
   }

   @ObfuscatedName("d")
   void method3641(class186 var1, boolean var2) {
      int var3 = var1.field3015.field1239.length;
      int var4;
      if(var2 && var1.field3015.field1242) {
         int var5 = var3 + var3 - var1.field3015.field1240;
         var4 = (int)((long)this.field2974[var1.field3012] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3018.method1311();
         }
      } else {
         var4 = (int)((long)this.field2974[var1.field3012] * (long)var3 >> 6);
      }

      var1.field3018.method1310(var4);
   }

   @ObfuscatedName("y")
   void method3645(int var1, int var2) {
      if(this.field2984[var1] != var2) {
         this.field2984[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2985[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ae")
   boolean method3652(class186 var1) {
      if(var1.field3018 == null) {
         if(var1.field3017 >= 0) {
            var1.method3853();
            if(var1.field3007 > 0 && var1 == this.field2985[var1.field3012][var1.field3007]) {
               this.field2985[var1.field3012][var1.field3007] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("u")
   public synchronized void method3655(int var1, int var2) {
      this.method3558(var1, var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2032291229"
   )
   void method3658(int var1) {
      if((this.field2971[var1] & 2) != 0) {
         for(class186 var2 = (class186)this.field2967.field2999.method3773(); null != var2; var2 = (class186)this.field2967.field2999.method3772()) {
            if(var1 == var2.field3012 && this.field2977[var1][var2.field3008] == null && var2.field3017 < 0) {
               var2.field3017 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aa")
   void method3660(int var1) {
      if((this.field2971[var1] & 4) != 0) {
         for(class186 var2 = (class186)this.field2967.field2999.method3773(); var2 != null; var2 = (class186)this.field2967.field2999.method3772()) {
            if(var2.field3012 == var1) {
               var2.field3010 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   static final void method3663(class37 var0, int var1) {
      class4.method42(var0.field839, var0.field848, var1);
   }
}
