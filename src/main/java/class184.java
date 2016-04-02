import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class184 extends class66 {
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1893129521
   )
   int field2963;
   @ObfuscatedName("e")
   class196 field2964 = new class196(128);
   @ObfuscatedName("u")
   int[] field2965 = new int[16];
   @ObfuscatedName("p")
   int[] field2966 = new int[16];
   @ObfuscatedName("h")
   int[] field2967 = new int[16];
   @ObfuscatedName("v")
   class187[][] field2968 = new class187[16][128];
   @ObfuscatedName("a")
   int[] field2969 = new int[16];
   @ObfuscatedName("r")
   int[] field2970 = new int[16];
   @ObfuscatedName("k")
   int[] field2971 = new int[16];
   @ObfuscatedName("m")
   int[] field2972 = new int[16];
   @ObfuscatedName("q")
   int[] field2973 = new int[16];
   @ObfuscatedName("y")
   int[] field2974 = new int[16];
   @ObfuscatedName("b")
   int[] field2975 = new int[16];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1480445719
   )
   int field2976 = 256;
   @ObfuscatedName("g")
   int[] field2977 = new int[16];
   @ObfuscatedName("t")
   int[] field2978 = new int[16];
   @ObfuscatedName("d")
   int[] field2979 = new int[16];
   @ObfuscatedName("z")
   int[] field2980 = new int[16];
   @ObfuscatedName("ap")
   class182 field2981 = new class182();
   @ObfuscatedName("aq")
   class187[][] field2982 = new class187[16][128];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1629938317
   )
   int field2983 = 1000000;
   @ObfuscatedName("ai")
   boolean field2984;
   @ObfuscatedName("n")
   int[] field2985 = new int[16];
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1283959747
   )
   int field2986;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = 5075229243409345531L
   )
   long field2987;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -2921693164627709253L
   )
   long field2988;
   @ObfuscatedName("ab")
   class186 field2989 = new class186(this);

   @ObfuscatedName("e")
   public synchronized void method3588(int var1) {
      this.field2976 = var1;
   }

   @ObfuscatedName("w")
   int method3589() {
      return this.field2976;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;IB)Z",
      garbageValue = "22050"
   )
   public synchronized boolean method3590(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3500();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2930.method3794(); var7 != null; var7 = (class197)var1.field2930.method3791()) {
         int var8 = (int)var7.field3115;
         class181 var9 = (class181)this.field2964.method3788((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3260(var8);
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

            this.field2964.method3789(var10, (long)var8);
         }

         if(!var9.method3510(var3, var7.field3094, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3498();
      }

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "506914086"
   )
   synchronized void method3592() {
      for(class181 var1 = (class181)this.field2964.method3794(); null != var1; var1 = (class181)this.field2964.method3791()) {
         var1.method3913();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZI)V",
      garbageValue = "-169030563"
   )
   public synchronized void method3593(class180 var1, boolean var2) {
      this.method3679();
      this.field2981.method3551(var1.field2931);
      this.field2984 = var2;
      this.field2987 = 0L;
      int var3 = this.field2981.method3521();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2981.method3522(var4);
         this.field2981.method3565(var4);
         this.field2981.method3525(var4);
      }

      this.field2963 = this.field2981.method3530();
      this.field2986 = this.field2981.field2944[this.field2963];
      this.field2988 = this.field2981.method3529(this.field2986);
   }

   @ObfuscatedName("g")
   protected synchronized class66 vmethod3733() {
      return null;
   }

   @ObfuscatedName("y")
   synchronized boolean method3595() {
      return this.field2981.method3520();
   }

   @ObfuscatedName("i")
   public synchronized void method3596(int var1, int var2) {
      this.method3597(var1, var2);
   }

   @ObfuscatedName("j")
   void method3597(int var1, int var2) {
      this.field2969[var1] = var2;
      this.field2971[var1] = var2 & -128;
      this.method3656(var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1696328159"
   )
   void method3599(int var1, int var2, int var3) {
      this.method3601(var1, var2);
      if(0 != (this.field2975[var1] & 2)) {
         for(class187 var4 = (class187)this.field2989.field3003.method3818(); null != var4; var4 = (class187)this.field2989.field3003.method3844()) {
            if(var4.field3016 == var1 && var4.field3009 < 0) {
               this.field2968[var1][var4.field3010] = null;
               this.field2968[var1][var2] = var4;
               int var5 = (var4.field3015 * var4.field3019 >> 12) + var4.field3013;
               var4.field3013 += var2 - var4.field3010 << 8;
               var4.field3019 = var5 - var4.field3013;
               var4.field3015 = 4096;
               var4.field3010 = var2;
               return;
            }
         }
      }

      class181 var8 = (class181)this.field2964.method3788((long)this.field2970[var1]);
      if(var8 != null) {
         class62 var9 = var8.field2938[var2];
         if(null != var9) {
            class187 var6 = new class187();
            var6.field3016 = var1;
            var6.field3011 = var8;
            var6.field3007 = var9;
            var6.field3008 = var8.field2937[var2];
            var6.field3023 = var8.field2934[var2];
            var6.field3010 = var2;
            var6.field3014 = 1024 + var8.field2935[var2] * var8.field2932 * var3 * var3 >> 11;
            var6.field3012 = var8.field2936[var2] & 255;
            var6.field3013 = (var2 << 8) - (var8.field2933[var2] & 32767);
            var6.field3006 = 0;
            var6.field3017 = 0;
            var6.field3018 = 0;
            var6.field3009 = -1;
            var6.field3025 = 0;
            if(0 == this.field2978[var1]) {
               var6.field3020 = class64.method1300(var9, this.method3612(var6), this.method3614(var6), this.method3674(var6));
            } else {
               var6.field3020 = class64.method1300(var9, this.method3612(var6), 0, this.method3674(var6));
               this.method3600(var6, var8.field2933[var2] < 0);
            }

            if(var8.field2933[var2] < 0) {
               var6.field3020.method1441(-1);
            }

            if(var6.field3023 >= 0) {
               class187 var7 = this.field2982[var1][var6.field3023];
               if(null != var7 && var7.field3009 < 0) {
                  this.field2968[var1][var7.field3010] = null;
                  var7.field3009 = 0;
               }

               this.field2982[var1][var6.field3023] = var6;
            }

            this.field2989.field3003.method3834(var6);
            this.field2968[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("c")
   void method3600(class187 var1, boolean var2) {
      int var3 = var1.field3007.field1203.length;
      int var4;
      if(var2 && var1.field3007.field1206) {
         int var5 = var3 + var3 - var1.field3007.field1205;
         var4 = (int)((long)var5 * (long)this.field2978[var1.field3016] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3020.method1309();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2978[var1.field3016] >> 6);
      }

      var1.field3020.method1349(var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-351338356"
   )
   void method3601(int var1, int var2) {
      class187 var3 = this.field2968[var1][var2];
      if(var3 != null) {
         this.field2968[var1][var2] = null;
         if(0 != (this.field2975[var1] & 2)) {
            for(class187 var4 = (class187)this.field2989.field3003.method3825(); var4 != null; var4 = (class187)this.field2989.field3003.method3827()) {
               if(var3.field3016 == var4.field3016 && var4.field3009 < 0 && var3 != var4) {
                  var3.field3009 = 0;
                  break;
               }
            }
         } else {
            var3.field3009 = 0;
         }

      }
   }

   @ObfuscatedName("b")
   void method3602() {
   }

   @ObfuscatedName("q")
   void method3603() {
   }

   @ObfuscatedName("u")
   void method3604(int var1, int var2) {
      this.field2972[var1] = var2;
   }

   @ObfuscatedName("t")
   void method3605(int var1) {
      for(class187 var2 = (class187)this.field2989.field3003.method3825(); var2 != null; var2 = (class187)this.field2989.field3003.method3827()) {
         if(var1 < 0 || var2.field3016 == var1) {
            if(null != var2.field3020) {
               var2.field3020.method1444(class56.field1153 / 100);
               if(var2.field3020.method1317()) {
                  this.field2989.field3002.method1128(var2.field3020);
               }

               var2.method3740();
            }

            if(var2.field3009 < 0) {
               this.field2968[var2.field3016][var2.field3010] = null;
            }

            var2.method3913();
         }
      }

   }

   @ObfuscatedName("d")
   void method3606(int var1) {
      if(var1 >= 0) {
         this.field2966[var1] = 12800;
         this.field2967[var1] = 8192;
         this.field2977[var1] = 16383;
         this.field2972[var1] = 8192;
         this.field2985[var1] = 0;
         this.field2974[var1] = 8192;
         this.method3609(var1);
         this.method3610(var1);
         this.field2975[var1] = 0;
         this.field2973[var1] = 32767;
         this.field2965[var1] = 256;
         this.field2978[var1] = 0;
         this.method3631(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3606(var1);
         }

      }
   }

   @ObfuscatedName("z")
   void method3607(int var1) {
      for(class187 var2 = (class187)this.field2989.field3003.method3825(); null != var2; var2 = (class187)this.field2989.field3003.method3827()) {
         if((var1 < 0 || var1 == var2.field3016) && var2.field3009 < 0) {
            this.field2968[var2.field3016][var2.field3010] = null;
            var2.field3009 = 0;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "382431920"
   )
   void method3609(int var1) {
      if((this.field2975[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field2989.field3003.method3825(); var2 != null; var2 = (class187)this.field2989.field3003.method3827()) {
            if(var2.field3016 == var1 && null == this.field2968[var1][var2.field3010] && var2.field3009 < 0) {
               var2.field3009 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2081502093"
   )
   void method3610(int var1) {
      if(0 != (this.field2975[var1] & 4)) {
         for(class187 var2 = (class187)this.field2989.field3003.method3825(); null != var2; var2 = (class187)this.field2989.field3003.method3827()) {
            if(var1 == var2.field3016) {
               var2.field3005 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   int method3612(class187 var1) {
      int var2 = (var1.field3019 * var1.field3015 >> 12) + var1.field3013;
      var2 += (this.field2972[var1.field3016] - 8192) * this.field2965[var1.field3016] >> 12;
      class185 var3 = var1.field3008;
      int var4;
      if(var3.field2990 > 0 && (var3.field2996 > 0 || this.field2985[var1.field3016] > 0)) {
         var4 = var3.field2996 << 2;
         int var5 = var3.field2998 << 1;
         if(var1.field3021 < var5) {
            var4 = var4 * var1.field3021 / var5;
         }

         var4 += this.field2985[var1.field3016] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3022 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field3007.field1204 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1153 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("at")
   int method3614(class187 var1) {
      class185 var2 = var1.field3008;
      int var3 = this.field2966[var1.field3016] * this.field2977[var1.field3016] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var1.field3014 * var3 >> 15;
      var3 = 128 + var3 * this.field2976 >> 8;
      if(var2.field2997 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2997 * (double)var1.field3006 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field2992) {
         var4 = var1.field3017;
         var5 = var2.field2992[var1.field3018 + 1];
         if(var1.field3018 < var2.field2992.length - 2) {
            var6 = (var2.field2992[var1.field3018] & 255) << 8;
            var7 = (var2.field2992[var1.field3018 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2992[var1.field3018 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3009 > 0 && null != var2.field2991) {
         var4 = var1.field3009;
         var5 = var2.field2991[1 + var1.field3025];
         if(var1.field3025 < var2.field2991.length - 2) {
            var6 = (var2.field2991[var1.field3025] & 255) << 8;
            var7 = (var2.field2991[2 + var1.field3025] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2991[3 + var1.field3025] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("h")
   protected synchronized class66 vmethod3713() {
      return this.field2989;
   }

   @ObfuscatedName("a")
   protected synchronized int vmethod3715() {
      return 0;
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3716(int[] var1, int var2, int var3) {
      if(this.field2981.method3520()) {
         int var4 = this.field2983 * this.field2981.field2947 / class56.field1153;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2987;
            if(this.field2988 - var5 >= 0L) {
               this.field2987 = var5;
               break;
            }

            int var7 = (int)((this.field2988 - this.field2987 + (long)var4 - 1L) / (long)var4);
            this.field2987 += (long)var4 * (long)var7;
            this.field2989.vmethod3716(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3621();
         } while(this.field2981.method3520());
      }

      this.field2989.vmethod3716(var1, var2, var3);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   void method3621() {
      int var1 = this.field2963;
      int var2 = this.field2986;

      long var3;
      for(var3 = this.field2988; var2 == this.field2986; var3 = this.field2981.method3529(var2)) {
         while(this.field2981.field2944[var1] == var2) {
            this.field2981.method3522(var1);
            int var5 = this.field2981.method3526(var1);
            if(1 == var5) {
               this.field2981.method3563();
               this.field2981.method3525(var1);
               if(this.field2981.method3533()) {
                  if(!this.field2984 || 0 == var2) {
                     this.method3694();
                     this.field2981.method3519();
                     return;
                  }

                  this.field2981.method3537(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3635(var5);
            }

            this.field2981.method3565(var1);
            this.field2981.method3525(var1);
         }

         var1 = this.field2981.method3530();
         var2 = this.field2981.field2944[var1];
      }

      this.field2963 = var1;
      this.field2986 = var2;
      this.field2988 = var3;
   }

   @ObfuscatedName("ak")
   boolean method3622(class187 var1) {
      if(var1.field3020 == null) {
         if(var1.field3009 >= 0) {
            var1.method3913();
            if(var1.field3023 > 0 && this.field2982[var1.field3016][var1.field3023] == var1) {
               this.field2982[var1.field3016][var1.field3023] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("as")
   boolean method3623(class187 var1, int[] var2, int var3, int var4) {
      var1.field3024 = class56.field1153 / 100;
      if(var1.field3009 < 0 || var1.field3020 != null && !var1.field3020.method1316()) {
         int var5 = var1.field3015;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2974[var1.field3016]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3015 = var5;
         }

         var1.field3020.method1314(this.method3612(var1));
         class185 var6 = var1.field3008;
         boolean var7 = false;
         ++var1.field3021;
         var1.field3022 += var6.field2990;
         double var8 = (double)((var1.field3010 - 60 << 8) + (var1.field3019 * var1.field3015 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2997 > 0) {
            if(var6.field2995 > 0) {
               var1.field3006 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2995 * var8) + 0.5D);
            } else {
               var1.field3006 += 128;
            }
         }

         if(var6.field2992 != null) {
            if(var6.field2993 > 0) {
               var1.field3017 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2993 * var8) + 0.5D);
            } else {
               var1.field3017 += 128;
            }

            while(var1.field3018 < var6.field2992.length - 2 && var1.field3017 > (var6.field2992[2 + var1.field3018] & 255) << 8) {
               var1.field3018 += 2;
            }

            if(var1.field3018 == var6.field2992.length - 2 && var6.field2992[1 + var1.field3018] == 0) {
               var7 = true;
            }
         }

         if(var1.field3009 >= 0 && var6.field2991 != null && (this.field2975[var1.field3016] & 1) == 0 && (var1.field3023 < 0 || this.field2982[var1.field3016][var1.field3023] != var1)) {
            if(var6.field2994 > 0) {
               var1.field3009 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2994 * var8) + 0.5D);
            } else {
               var1.field3009 += 128;
            }

            while(var1.field3025 < var6.field2991.length - 2 && var1.field3009 > (var6.field2991[var1.field3025 + 2] & 255) << 8) {
               var1.field3025 += 2;
            }

            if(var6.field2991.length - 2 == var1.field3025) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3020.method1444(var1.field3024);
            if(null != var2) {
               var1.field3020.vmethod3716(var2, var3, var4);
            } else {
               var1.field3020.vmethod3717(var4);
            }

            if(var1.field3020.method1317()) {
               this.field2989.field3002.method1128(var1.field3020);
            }

            var1.method3740();
            if(var1.field3009 >= 0) {
               var1.method3913();
               if(var1.field3023 > 0 && this.field2982[var1.field3016][var1.field3023] == var1) {
                  this.field2982[var1.field3016][var1.field3023] = null;
               }
            }

            return true;
         } else {
            var1.field3020.method1358(var1.field3024, this.method3614(var1), this.method3674(var1));
            return false;
         }
      } else {
         var1.method3740();
         var1.method3913();
         if(var1.field3023 > 0 && this.field2982[var1.field3016][var1.field3023] == var1) {
            this.field2982[var1.field3016][var1.field3023] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("an")
   void method3631(int var1, int var2) {
      this.field2979[var1] = var2;
      this.field2980[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-508"
   )
   void method3635(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3601(var3, var4);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3599(var3, var4, var5);
         } else {
            this.method3601(var3, var4);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3602();
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(0 == var4) {
            this.field2971[var3] = (var5 << 14) + (this.field2971[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2971[var3] = (this.field2971[var3] & -16257) + (var5 << 7);
         }

         if(1 == var4) {
            this.field2985[var3] = (var5 << 7) + (this.field2985[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2985[var3] = var5 + (this.field2985[var3] & -128);
         }

         if(var4 == 5) {
            this.field2974[var3] = (this.field2974[var3] & -16257) + (var5 << 7);
         }

         if(37 == var4) {
            this.field2974[var3] = (this.field2974[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2966[var3] = (this.field2966[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2966[var3] = (this.field2966[var3] & -128) + var5;
         }

         if(10 == var4) {
            this.field2967[var3] = (var5 << 7) + (this.field2967[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2967[var3] = var5 + (this.field2967[var3] & -128);
         }

         if(var4 == 11) {
            this.field2977[var3] = (this.field2977[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field2977[var3] = (this.field2977[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2975[var3] |= 1;
            } else {
               this.field2975[var3] &= -2;
            }
         }

         if(65 == var4) {
            if(var5 >= 64) {
               this.field2975[var3] |= 2;
            } else {
               this.method3609(var3);
               this.field2975[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2973[var3] = (this.field2973[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2973[var3] = var5 + (this.field2973[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2973[var3] = 16384 + (this.field2973[var3] & 127) + (var5 << 7);
         }

         if(100 == var4) {
            this.field2973[var3] = 16384 + (this.field2973[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method3605(var3);
         }

         if(121 == var4) {
            this.method3606(var3);
         }

         if(123 == var4) {
            this.method3607(var3);
         }

         int var6;
         if(6 == var4) {
            var6 = this.field2973[var3];
            if(var6 == 16384) {
               this.field2965[var3] = (this.field2965[var3] & -16257) + (var5 << 7);
            }
         }

         if(38 == var4) {
            var6 = this.field2973[var3];
            if(16384 == var6) {
               this.field2965[var3] = (this.field2965[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field2978[var3] = (var5 << 7) + (this.field2978[var3] & -16257);
         }

         if(48 == var4) {
            this.field2978[var3] = var5 + (this.field2978[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2975[var3] |= 4;
            } else {
               this.method3610(var3);
               this.field2975[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3631(var3, (this.field2979[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3631(var3, var5 + (this.field2979[var3] & -128));
         }

      } else if(192 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3656(var3, var4 + this.field2971[var3]);
      } else if(208 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3603();
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3604(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3694();
         }
      }
   }

   public class184() {
      this.method3694();
   }

   @ObfuscatedName("s")
   public synchronized void method3647() {
      for(class181 var1 = (class181)this.field2964.method3794(); var1 != null; var1 = (class181)this.field2964.method3791()) {
         var1.method3511();
      }

   }

   @ObfuscatedName("l")
   void method3656(int var1, int var2) {
      if(this.field2970[var1] != var2) {
         this.field2970[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2982[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ao")
   int method3674(class187 var1) {
      int var2 = this.field2967[var1.field3016];
      return var2 < 8192?32 + var1.field3012 * var2 >> 6:16384 - (32 + (16384 - var2) * (128 - var1.field3012) >> 6);
   }

   @ObfuscatedName("n")
   public synchronized void method3679() {
      this.field2981.method3519();
      this.method3694();
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod3717(int var1) {
      if(this.field2981.method3520()) {
         int var2 = this.field2983 * this.field2981.field2947 / class56.field1153;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2987;
            if(this.field2988 - var3 >= 0L) {
               this.field2987 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2988 - this.field2987) - 1L) / (long)var2);
            this.field2987 += (long)var5 * (long)var2;
            this.field2989.vmethod3717(var5);
            var1 -= var5;
            this.method3621();
         } while(this.field2981.method3520());
      }

      this.field2989.vmethod3717(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1955721462"
   )
   void method3694() {
      this.method3605(-1);
      this.method3606(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2970[var1] = this.field2969[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2971[var1] = this.field2969[var1] & -128;
      }

   }

   @ObfuscatedName("di")
   static final boolean method3711(class173 var0) {
      int var1 = var0.field2833;
      if(var1 == 205) {
         client.field472 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            client.field551.method3472(var2, 1 == var3);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            client.field551.method3465(var2, var3 == 1);
         }

         if(324 == var1) {
            client.field551.method3488(false);
         }

         if(var1 == 325) {
            client.field551.method3488(true);
         }

         if(var1 == 326) {
            client.field321.method2762(192);
            client.field551.method3496(client.field321);
            return true;
         } else {
            return false;
         }
      }
   }
}
