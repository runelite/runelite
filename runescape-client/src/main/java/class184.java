import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class184 extends class66 {
   @ObfuscatedName("i")
   int[] field2960 = new int[16];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1169125907
   )
   int field2961 = 256;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -427551049
   )
   int field2962 = 1000000;
   @ObfuscatedName("s")
   int[] field2963 = new int[16];
   @ObfuscatedName("f")
   class196 field2964 = new class196(128);
   @ObfuscatedName("d")
   int[] field2965 = new int[16];
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = 8240353894645308883L
   )
   long field2966;
   @ObfuscatedName("m")
   int[] field2967 = new int[16];
   @ObfuscatedName("g")
   int[] field2968 = new int[16];
   @ObfuscatedName("b")
   int[] field2969 = new int[16];
   @ObfuscatedName("r")
   int[] field2970 = new int[16];
   @ObfuscatedName("ax")
   class182 field2971 = new class182();
   @ObfuscatedName("y")
   int[] field2973 = new int[16];
   @ObfuscatedName("v")
   int[] field2974 = new int[16];
   @ObfuscatedName("c")
   int[] field2975 = new int[16];
   @ObfuscatedName("n")
   int[] field2976 = new int[16];
   @ObfuscatedName("a")
   int[] field2977 = new int[16];
   @ObfuscatedName("z")
   int[] field2978 = new int[16];
   @ObfuscatedName("j")
   class187[][] field2979 = new class187[16][128];
   @ObfuscatedName("ag")
   class187[][] field2980 = new class187[16][128];
   @ObfuscatedName("l")
   int[] field2981 = new int[16];
   @ObfuscatedName("ao")
   boolean field2982;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1895079485
   )
   int field2983;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1636355343
   )
   int field2984;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 1228022527580233305L
   )
   long field2985;
   @ObfuscatedName("k")
   int[] field2986 = new int[16];
   @ObfuscatedName("as")
   class186 field2987 = new class186(this);

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method3635(int var1) {
      for(class187 var2 = (class187)this.field2987.field3005.method3852(); null != var2; var2 = (class187)this.field2987.field3005.method3857()) {
         if((var1 < 0 || var2.field3018 == var1) && var2.field3021 < 0) {
            this.field2979[var2.field3018][var2.field3012] = null;
            var2.field3021 = 0;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1327357193"
   )
   public synchronized void method3636(int var1) {
      this.field2961 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass180;Lclass167;Lclass59;II)Z",
      garbageValue = "-1856402533"
   )
   public synchronized boolean method3638(class180 var1, class167 var2, class59 var3, int var4) {
      var1.method3549();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class197 var7 = (class197)var1.field2924.method3825(); null != var7; var7 = (class197)var1.field2924.method3823()) {
         int var8 = (int)var7.field3115;
         class181 var9 = (class181)this.field2964.method3822((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3291(var8);
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

            this.field2964.method3826(var10, (long)var8);
         }

         if(!var9.method3560(var3, var7.field3095, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3550();
      }

      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   public synchronized void method3639() {
      for(class181 var1 = (class181)this.field2964.method3825(); null != var1; var1 = (class181)this.field2964.method3823()) {
         var1.method3558();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   synchronized void method3640() {
      for(class181 var1 = (class181)this.field2964.method3825(); var1 != null; var1 = (class181)this.field2964.method3823()) {
         var1.method3946();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass180;ZI)V",
      garbageValue = "1063083428"
   )
   public synchronized void method3641(class180 var1, boolean var2) {
      this.method3642();
      this.field2971.method3568(var1.field2925);
      this.field2982 = var2;
      this.field2985 = 0L;
      int var3 = this.field2971.method3576();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2971.method3582(var4);
         this.field2971.method3574(var4);
         this.field2971.method3572(var4);
      }

      this.field2983 = this.field2971.method3606();
      this.field2984 = this.field2971.field2949[this.field2983];
      this.field2966 = this.field2971.method3604(this.field2984);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   public synchronized void method3642() {
      this.field2971.method3594();
      this.method3662();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-384824361"
   )
   public synchronized boolean method3644() {
      return this.field2971.method3608();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-63"
   )
   void method3645(int var1, int var2) {
      this.field2976[var1] = var2;
      this.field2968[var1] = var2 & -128;
      this.method3646(var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1602925386"
   )
   void method3646(int var1, int var2) {
      if(this.field2967[var1] != var2) {
         this.field2967[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2980[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1086055184"
   )
   void method3647(int var1, int var2, int var3) {
      this.method3699(var1, var2, 64);
      if((this.field2974[var1] & 2) != 0) {
         for(class187 var4 = (class187)this.field2987.field3005.method3856(); null != var4; var4 = (class187)this.field2987.field3005.method3858()) {
            if(var4.field3018 == var1 && var4.field3021 < 0) {
               this.field2979[var1][var4.field3012] = null;
               this.field2979[var1][var2] = var4;
               int var5 = var4.field3015 + (var4.field3023 * var4.field3007 >> 12);
               var4.field3015 += var2 - var4.field3012 << 8;
               var4.field3007 = var5 - var4.field3015;
               var4.field3023 = 4096;
               var4.field3012 = var2;
               return;
            }
         }
      }

      class181 var9 = (class181)this.field2964.method3822((long)this.field2967[var1]);
      if(var9 != null) {
         class62 var8 = var9.field2927[var2];
         if(var8 != null) {
            class187 var6 = new class187();
            var6.field3018 = var1;
            var6.field3008 = var9;
            var6.field3009 = var8;
            var6.field3027 = var9.field2926[var2];
            var6.field3016 = var9.field2936[var2];
            var6.field3012 = var2;
            var6.field3013 = 1024 + var9.field2929[var2] * var9.field2932 * var3 * var3 >> 11;
            var6.field3022 = var9.field2930[var2] & 255;
            var6.field3015 = (var2 << 8) - (var9.field2931[var2] & 32767);
            var6.field3014 = 0;
            var6.field3017 = 0;
            var6.field3020 = 0;
            var6.field3021 = -1;
            var6.field3010 = 0;
            if(this.field2960[var1] == 0) {
               var6.field3025 = class64.method1362(var8, this.method3661(var6), this.method3674(var6), this.method3694(var6));
            } else {
               var6.field3025 = class64.method1362(var8, this.method3661(var6), 0, this.method3694(var6));
               this.method3654(var6, var9.field2931[var2] < 0);
            }

            if(var9.field2931[var2] < 0) {
               var6.field3025.method1383(-1);
            }

            if(var6.field3016 >= 0) {
               class187 var7 = this.field2980[var1][var6.field3016];
               if(var7 != null && var7.field3021 < 0) {
                  this.field2979[var1][var7.field3012] = null;
                  var7.field3021 = 0;
               }

               this.field2980[var1][var6.field3016] = var6;
            }

            this.field2987.field3005.method3877(var6);
            this.field2979[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-92"
   )
   void method3650(int var1, int var2, int var3) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-94"
   )
   int method3651() {
      return this.field2961;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-2"
   )
   void method3652(int var1) {
      if(var1 >= 0) {
         this.field2969[var1] = 12800;
         this.field2981[var1] = 8192;
         this.field2965[var1] = 16383;
         this.field2963[var1] = 8192;
         this.field2970[var1] = 0;
         this.field2986[var1] = 8192;
         this.method3657(var1);
         this.method3655(var1);
         this.field2974[var1] = 0;
         this.field2973[var1] = 32767;
         this.field2975[var1] = 256;
         this.field2960[var1] = 0;
         this.method3660(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3652(var1);
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-112"
   )
   void method3653(int var1) {
      for(class187 var2 = (class187)this.field2987.field3005.method3852(); var2 != null; var2 = (class187)this.field2987.field3005.method3857()) {
         if(var1 < 0 || var1 == var2.field3018) {
            if(null != var2.field3025) {
               var2.field3025.method1375(class56.field1196 / 100);
               if(var2.field3025.method1505()) {
                  this.field2987.field3001.method1229(var2.field3025);
               }

               var2.method3777();
            }

            if(var2.field3021 < 0) {
               this.field2979[var2.field3018][var2.field3012] = null;
            }

            var2.method3946();
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass187;ZI)V",
      garbageValue = "-232192238"
   )
   void method3654(class187 var1, boolean var2) {
      int var3 = var1.field3009.field1247.length;
      int var4;
      if(var2 && var1.field3009.field1250) {
         int var5 = var3 + var3 - var1.field3009.field1246;
         var4 = (int)((long)this.field2960[var1.field3018] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3025.method1371();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2960[var1.field3018] >> 6);
      }

      var1.field3025.method1370(var4);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1205888119"
   )
   void method3655(int var1) {
      if((this.field2974[var1] & 4) != 0) {
         for(class187 var2 = (class187)this.field2987.field3005.method3852(); null != var2; var2 = (class187)this.field2987.field3005.method3857()) {
            if(var1 == var2.field3018) {
               var2.field3024 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2110043762"
   )
   void method3657(int var1) {
      if((this.field2974[var1] & 2) != 0) {
         for(class187 var2 = (class187)this.field2987.field3005.method3852(); var2 != null; var2 = (class187)this.field2987.field3005.method3857()) {
            if(var1 == var2.field3018 && this.field2979[var1][var2.field3012] == null && var2.field3021 < 0) {
               var2.field3021 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-60"
   )
   void method3660(int var1, int var2) {
      this.field2977[var1] = var2;
      this.field2978[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "1"
   )
   int method3661(class187 var1) {
      int var2 = (var1.field3023 * var1.field3007 >> 12) + var1.field3015;
      var2 += (this.field2963[var1.field3018] - 8192) * this.field2975[var1.field3018] >> 12;
      class185 var3 = var1.field3027;
      int var4;
      if(var3.field2995 > 0 && (var3.field2994 > 0 || this.field2970[var1.field3018] > 0)) {
         var4 = var3.field2994 << 2;
         int var5 = var3.field2996 << 1;
         if(var1.field3011 < var5) {
            var4 = var4 * var1.field3011 / var5;
         }

         var4 += this.field2970[var1.field3018] >> 7;
         double var6 = Math.sin((double)(var1.field3019 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(256 * var1.field3009.field1248) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class56.field1196 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method3662() {
      this.method3653(-1);
      this.method3652(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2967[var1] = this.field2976[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2968[var1] = this.field2976[var1] & -128;
      }

   }

   @ObfuscatedName("d")
   protected synchronized class66 vmethod3760() {
      return this.field2987;
   }

   @ObfuscatedName("n")
   protected synchronized class66 vmethod3752() {
      return null;
   }

   @ObfuscatedName("m")
   protected synchronized int vmethod3753() {
      return 0;
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod3764(int[] var1, int var2, int var3) {
      if(this.field2971.method3608()) {
         int var4 = this.field2962 * this.field2971.field2950 / class56.field1196;

         do {
            long var5 = this.field2985 + (long)var3 * (long)var4;
            if(this.field2966 - var5 >= 0L) {
               this.field2985 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2966 - this.field2985) - 1L) / (long)var4);
            this.field2985 += (long)var7 * (long)var4;
            this.field2987.vmethod3764(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3669();
         } while(this.field2971.method3608());
      }

      this.field2987.vmethod3764(var1, var2, var3);
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3755(int var1) {
      if(this.field2971.method3608()) {
         int var2 = this.field2971.field2950 * this.field2962 / class56.field1196;

         do {
            long var3 = this.field2985 + (long)var2 * (long)var1;
            if(this.field2966 - var3 >= 0L) {
               this.field2985 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2966 - this.field2985) - 1L) / (long)var2);
            this.field2985 += (long)var2 * (long)var5;
            this.field2987.vmethod3755(var5);
            var1 -= var5;
            this.method3669();
         } while(this.field2971.method3608());
      }

      this.field2987.vmethod3755(var1);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "936695148"
   )
   void method3669() {
      int var1 = this.field2983;
      int var2 = this.field2984;

      long var3;
      for(var3 = this.field2966; var2 == this.field2984; var3 = this.field2971.method3604(var2)) {
         while(var2 == this.field2971.field2949[var1]) {
            this.field2971.method3582(var1);
            int var5 = this.field2971.method3575(var1);
            if(var5 == 1) {
               this.field2971.method3573();
               this.field2971.method3572(var1);
               if(this.field2971.method3580()) {
                  if(!this.field2982 || var2 == 0) {
                     this.method3662();
                     this.field2971.method3594();
                     return;
                  }

                  this.field2971.method3581(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3712(var5);
            }

            this.field2971.method3574(var1);
            this.field2971.method3572(var1);
         }

         var1 = this.field2971.method3606();
         var2 = this.field2971.field2949[var1];
      }

      this.field2983 = var1;
      this.field2984 = var2;
      this.field2966 = var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass187;[IIIB)Z",
      garbageValue = "102"
   )
   boolean method3671(class187 var1, int[] var2, int var3, int var4) {
      var1.field3026 = class56.field1196 / 100;
      if(var1.field3021 < 0 || var1.field3025 != null && !var1.field3025.method1408()) {
         int var5 = var1.field3023;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2986[var1.field3018]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3023 = var5;
         }

         var1.field3025.method1499(this.method3661(var1));
         class185 var6 = var1.field3027;
         boolean var7 = false;
         ++var1.field3011;
         var1.field3019 += var6.field2995;
         double var8 = (double)((var1.field3007 * var1.field3023 >> 12) + (var1.field3012 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field2990 > 0) {
            if(var6.field2993 > 0) {
               var1.field3014 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2993) + 0.5D);
            } else {
               var1.field3014 += 128;
            }
         }

         if(null != var6.field2998) {
            if(var6.field2991 > 0) {
               var1.field3017 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2991) + 0.5D);
            } else {
               var1.field3017 += 128;
            }

            while(var1.field3020 < var6.field2998.length - 2 && var1.field3017 > (var6.field2998[var1.field3020 + 2] & 255) << 8) {
               var1.field3020 += 2;
            }

            if(var1.field3020 == var6.field2998.length - 2 && var6.field2998[var1.field3020 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3021 >= 0 && null != var6.field2989 && (this.field2974[var1.field3018] & 1) == 0 && (var1.field3016 < 0 || this.field2980[var1.field3018][var1.field3016] != var1)) {
            if(var6.field2992 > 0) {
               var1.field3021 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2992) + 0.5D);
            } else {
               var1.field3021 += 128;
            }

            while(var1.field3010 < var6.field2989.length - 2 && var1.field3021 > (var6.field2989[2 + var1.field3010] & 255) << 8) {
               var1.field3010 += 2;
            }

            if(var1.field3010 == var6.field2989.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3025.method1375(var1.field3026);
            if(var2 != null) {
               var1.field3025.vmethod3764(var2, var3, var4);
            } else {
               var1.field3025.vmethod3755(var4);
            }

            if(var1.field3025.method1505()) {
               this.field2987.field3001.method1229(var1.field3025);
            }

            var1.method3777();
            if(var1.field3021 >= 0) {
               var1.method3946();
               if(var1.field3016 > 0 && this.field2980[var1.field3018][var1.field3016] == var1) {
                  this.field2980[var1.field3018][var1.field3016] = null;
               }
            }

            return true;
         } else {
            var1.field3025.method1411(var1.field3026, this.method3674(var1), this.method3694(var1));
            return false;
         }
      } else {
         var1.method3777();
         var1.method3946();
         if(var1.field3016 > 0 && this.field2980[var1.field3018][var1.field3016] == var1) {
            this.field2980[var1.field3018][var1.field3016] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass187;B)I",
      garbageValue = "-97"
   )
   int method3674(class187 var1) {
      class185 var2 = var1.field3027;
      int var3 = 4096 + this.field2969[var1.field3018] * this.field2965[var1.field3018] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var1.field3013 * var3 + 16384 >> 15;
      var3 = this.field2961 * var3 + 128 >> 8;
      if(var2.field2990 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3014 * 1.953125E-5D * (double)var2.field2990) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2998 != null) {
         var4 = var1.field3017;
         var5 = var2.field2998[var1.field3020 + 1];
         if(var1.field3020 < var2.field2998.length - 2) {
            var6 = (var2.field2998[var1.field3020] & 255) << 8;
            var7 = (var2.field2998[2 + var1.field3020] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2998[3 + var1.field3020] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field3021 > 0 && null != var2.field2989) {
         var4 = var1.field3021;
         var5 = var2.field2989[var1.field3010 + 1];
         if(var1.field3010 < var2.field2989.length - 2) {
            var6 = (var2.field2989[var1.field3010] & 255) << 8;
            var7 = (var2.field2989[var1.field3010 + 2] & 255) << 8;
            var5 += (var2.field2989[var1.field3010 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1215712378"
   )
   void method3690(int var1, int var2) {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)I",
      garbageValue = "-1876835148"
   )
   int method3694(class187 var1) {
      int var2 = this.field2981[var1.field3018];
      return var2 < 8192?var1.field3022 * var2 + 32 >> 6:16384 - (32 + (16384 - var2) * (128 - var1.field3022) >> 6);
   }

   public class184() {
      this.method3662();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "998017109"
   )
   void method3699(int var1, int var2, int var3) {
      class187 var4 = this.field2979[var1][var2];
      if(null != var4) {
         this.field2979[var1][var2] = null;
         if((this.field2974[var1] & 2) != 0) {
            for(class187 var5 = (class187)this.field2987.field3005.method3852(); null != var5; var5 = (class187)this.field2987.field3005.method3857()) {
               if(var4.field3018 == var5.field3018 && var5.field3021 < 0 && var5 != var4) {
                  var4.field3021 = 0;
                  break;
               }
            }
         } else {
            var4.field3021 = 0;
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass187;I)Z",
      garbageValue = "-2109148926"
   )
   boolean method3705(class187 var1) {
      if(var1.field3025 == null) {
         if(var1.field3021 >= 0) {
            var1.method3946();
            if(var1.field3016 > 0 && this.field2980[var1.field3018][var1.field3016] == var1) {
               this.field2980[var1.field3018][var1.field3016] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "2400"
   )
   void method3712(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3699(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3647(var3, var4, var5);
         } else {
            this.method3699(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3650(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2968[var3] = (var5 << 14) + (this.field2968[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2968[var3] = (this.field2968[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field2970[var3] = (var5 << 7) + (this.field2970[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2970[var3] = (this.field2970[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2986[var3] = (this.field2986[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2986[var3] = var5 + (this.field2986[var3] & -128);
         }

         if(var4 == 7) {
            this.field2969[var3] = (this.field2969[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2969[var3] = var5 + (this.field2969[var3] & -128);
         }

         if(var4 == 10) {
            this.field2981[var3] = (var5 << 7) + (this.field2981[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2981[var3] = var5 + (this.field2981[var3] & -128);
         }

         if(var4 == 11) {
            this.field2965[var3] = (var5 << 7) + (this.field2965[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2965[var3] = (this.field2965[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2974[var3] |= 1;
            } else {
               this.field2974[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2974[var3] |= 2;
            } else {
               this.method3657(var3);
               this.field2974[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2973[var3] = (this.field2973[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2973[var3] = (this.field2973[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2973[var3] = (var5 << 7) + 16384 + (this.field2973[var3] & 127);
         }

         if(var4 == 100) {
            this.field2973[var3] = var5 + (this.field2973[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3653(var3);
         }

         if(var4 == 121) {
            this.method3652(var3);
         }

         if(var4 == 123) {
            this.method3635(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2973[var3];
            if(var6 == 16384) {
               this.field2975[var3] = (this.field2975[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field2973[var3];
            if(var6 == 16384) {
               this.field2975[var3] = var5 + (this.field2975[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2960[var3] = (this.field2960[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field2960[var3] = (this.field2960[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2974[var3] |= 4;
            } else {
               this.method3655(var3);
               this.field2974[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3660(var3, (this.field2977[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3660(var3, (this.field2977[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3646(var3, this.field2968[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3690(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3745(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3662();
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-112"
   )
   void method3745(int var1, int var2) {
      this.field2963[var1] = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "554579108"
   )
   public synchronized void method3747(int var1, int var2) {
      this.method3645(var1, var2);
   }
}
