import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class183 extends class66 {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1797134299
   )
   int field2952;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1235248047
   )
   int field2953 = 256;
   @ObfuscatedName("o")
   class186[][] field2954 = new class186[16][128];
   @ObfuscatedName("s")
   int[] field2955 = new int[16];
   @ObfuscatedName("m")
   int[] field2956 = new int[16];
   @ObfuscatedName("x")
   int[] field2957 = new int[16];
   @ObfuscatedName("g")
   int[] field2958 = new int[16];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1496590673
   )
   int field2959 = 1000000;
   @ObfuscatedName("a")
   class195 field2960 = new class195(128);
   @ObfuscatedName("n")
   int[] field2961 = new int[16];
   @ObfuscatedName("l")
   int[] field2962 = new int[16];
   @ObfuscatedName("h")
   int[] field2963 = new int[16];
   @ObfuscatedName("e")
   int[] field2964 = new int[16];
   @ObfuscatedName("d")
   int[] field2965 = new int[16];
   @ObfuscatedName("p")
   int[] field2966 = new int[16];
   @ObfuscatedName("q")
   int[] field2967 = new int[16];
   @ObfuscatedName("w")
   int[] field2968 = new int[16];
   @ObfuscatedName("k")
   int[] field2969 = new int[16];
   @ObfuscatedName("j")
   int[] field2970 = new int[16];
   @ObfuscatedName("ad")
   class186[][] field2971 = new class186[16][128];
   @ObfuscatedName("at")
   class181 field2972 = new class181();
   @ObfuscatedName("aw")
   boolean field2973;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = -6593040268542847059L
   )
   long field2974;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1576101383
   )
   int field2975;
   @ObfuscatedName("y")
   int[] field2976 = new int[16];
   @ObfuscatedName("as")
   class185 field2978 = new class185(this);
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      longValue = -9039167543170484107L
   )
   long field2979;

   @ObfuscatedName("a")
   public synchronized void method3622(int var1) {
      this.field2953 = var1;
   }

   @ObfuscatedName("r")
   int method3623() {
      return this.field2953;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass179;Lclass166;Lclass59;II)Z",
      garbageValue = "22050"
   )
   public synchronized boolean method3624(class179 var1, class166 var2, class59 var3, int var4) {
      var1.method3530();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class196 var7 = (class196)var1.field2917.method3836(); var7 != null; var7 = (class196)var1.field2917.method3827()) {
         int var8 = (int)var7.field3111;
         class180 var9 = (class180)this.field2960.method3824((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3268(var8);
            class180 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class180(var11);
            }

            var9 = var10;
            if(null == var10) {
               var5 = false;
               continue;
            }

            this.field2960.method3831(var10, (long)var8);
         }

         if(!var9.method3540(var3, var7.field3089, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3531();
      }

      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "946332888"
   )
   public synchronized void method3625() {
      for(class180 var1 = (class180)this.field2960.method3836(); null != var1; var1 = (class180)this.field2960.method3827()) {
         var1.method3539();
      }

   }

   @ObfuscatedName("h")
   public synchronized void method3628() {
      this.field2972.method3550();
      this.method3744();
   }

   public class183() {
      this.method3744();
   }

   @ObfuscatedName("c")
   void method3631(int var1, int var2) {
      class186 var3 = this.field2954[var1][var2];
      if(var3 != null) {
         this.field2954[var1][var2] = null;
         if(0 != (this.field2957[var1] & 2)) {
            for(class186 var4 = (class186)this.field2978.field2995.method3860(); null != var4; var4 = (class186)this.field2978.field2995.method3861()) {
               if(var3.field3011 == var4.field3011 && var4.field3013 < 0 && var3 != var4) {
                  var3.field3013 = 0;
                  break;
               }
            }
         } else {
            var3.field3013 = 0;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1048378707"
   )
   void method3632(int var1, int var2, int var3) {
      this.method3631(var1, var2);
      if((this.field2957[var1] & 2) != 0) {
         for(class186 var4 = (class186)this.field2978.field2995.method3872(); var4 != null; var4 = (class186)this.field2978.field2995.method3863()) {
            if(var1 == var4.field3011 && var4.field3013 < 0) {
               this.field2954[var1][var4.field3004] = null;
               this.field2954[var1][var2] = var4;
               int var5 = var4.field3007 + (var4.field3008 * var4.field3003 >> 12);
               var4.field3007 += var2 - var4.field3004 << 8;
               var4.field3008 = var5 - var4.field3007;
               var4.field3003 = 4096;
               var4.field3004 = var2;
               return;
            }
         }
      }

      class180 var8 = (class180)this.field2960.method3824((long)this.field2956[var1]);
      if(var8 != null) {
         class62 var9 = var8.field2920[var2];
         if(var9 != null) {
            class186 var6 = new class186();
            var6.field3011 = var1;
            var6.field3005 = var8;
            var6.field3001 = var9;
            var6.field3016 = var8.field2927[var2];
            var6.field3019 = var8.field2919[var2];
            var6.field3004 = var2;
            var6.field3009 = var3 * var3 * var8.field2924 * var8.field2922[var2] + 1024 >> 11;
            var6.field3006 = var8.field2923[var2] & 255;
            var6.field3007 = (var2 << 8) - (var8.field2921[var2] & 32767);
            var6.field3010 = 0;
            var6.field3000 = 0;
            var6.field3012 = 0;
            var6.field3013 = -1;
            var6.field3014 = 0;
            if(this.field2967[var1] == 0) {
               var6.field3017 = class64.method1327(var9, this.method3646(var6), this.method3641(var6), this.method3648(var6));
            } else {
               var6.field3017 = class64.method1327(var9, this.method3646(var6), 0, this.method3648(var6));
               this.method3633(var6, var8.field2921[var2] < 0);
            }

            if(var8.field2921[var2] < 0) {
               var6.field3017.method1329(-1);
            }

            if(var6.field3019 >= 0) {
               class186 var7 = this.field2971[var1][var6.field3019];
               if(null != var7 && var7.field3013 < 0) {
                  this.field2954[var1][var7.field3004] = null;
                  var7.field3013 = 0;
               }

               this.field2971[var1][var6.field3019] = var6;
            }

            this.field2978.field2995.method3855(var6);
            this.field2954[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("b")
   void method3633(class186 var1, boolean var2) {
      int var3 = var1.field3001.field1231.length;
      int var4;
      if(var2 && var1.field3001.field1234) {
         int var5 = var3 + var3 - var1.field3001.field1230;
         var4 = (int)((long)var5 * (long)this.field2967[var1.field3011] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3017.method1336();
         }
      } else {
         var4 = (int)((long)this.field2967[var1.field3011] * (long)var3 >> 6);
      }

      var1.field3017.method1359(var4);
   }

   @ObfuscatedName("d")
   void method3636() {
   }

   @ObfuscatedName("p")
   void method3637(int var1, int var2) {
      this.field2961[var1] = var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-150928810"
   )
   void method3639(int var1) {
      if(var1 >= 0) {
         this.field2955[var1] = 12800;
         this.field2976[var1] = 8192;
         this.field2964[var1] = 16383;
         this.field2961[var1] = 8192;
         this.field2962[var1] = 0;
         this.field2963[var1] = 8192;
         this.method3642(var1);
         this.method3742(var1);
         this.field2957[var1] = 0;
         this.field2965[var1] = 32767;
         this.field2966[var1] = 256;
         this.field2967[var1] = 0;
         this.method3645(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3639(var1);
         }

      }
   }

   @ObfuscatedName("af")
   int method3641(class186 var1) {
      class184 var2 = var1.field3016;
      int var3 = 4096 + this.field2955[var1.field3011] * this.field2964[var1.field3011] >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field3009 + 16384 >> 15;
      var3 = var3 * this.field2953 + 128 >> 8;
      if(var2.field2984 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2984 * (double)var1.field3010 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(null != var2.field2982) {
         var4 = var1.field3000;
         var5 = var2.field2982[1 + var1.field3012];
         if(var1.field3012 < var2.field2982.length - 2) {
            var6 = (var2.field2982[var1.field3012] & 255) << 8;
            var7 = (var2.field2982[2 + var1.field3012] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2982[3 + var1.field3012] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field3013 > 0 && var2.field2983 != null) {
         var4 = var1.field3013;
         var5 = var2.field2983[1 + var1.field3014];
         if(var1.field3014 < var2.field2983.length - 2) {
            var6 = (var2.field2983[var1.field3014] & 255) << 8;
            var7 = (var2.field2983[2 + var1.field3014] & 255) << 8;
            var5 += (var2.field2983[var1.field3014 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("an")
   void method3642(int var1) {
      if((this.field2957[var1] & 2) != 0) {
         for(class186 var2 = (class186)this.field2978.field2995.method3860(); null != var2; var2 = (class186)this.field2978.field2995.method3861()) {
            if(var1 == var2.field3011 && null == this.field2954[var1][var2.field3004] && var2.field3013 < 0) {
               var2.field3013 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   void method3645(int var1, int var2) {
      this.field2968[var1] = var2;
      this.field2969[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("aq")
   int method3646(class186 var1) {
      int var2 = (var1.field3008 * var1.field3003 >> 12) + var1.field3007;
      var2 += (this.field2961[var1.field3011] - 8192) * this.field2966[var1.field3011] >> 12;
      class184 var3 = var1.field3016;
      int var4;
      if(var3.field2989 > 0 && (var3.field2993 > 0 || this.field2962[var1.field3011] > 0)) {
         var4 = var3.field2993 << 2;
         int var5 = var3.field2990 << 1;
         if(var1.field3015 < var5) {
            var4 = var4 * var1.field3015 / var5;
         }

         var4 += this.field2962[var1.field3011] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2999 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(256 * var1.field3001.field1232) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1185 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ay")
   int method3648(class186 var1) {
      int var2 = this.field2976[var1.field3011];
      return var2 < 8192?32 + var1.field3006 * var2 >> 6:16384 - (32 + (128 - var1.field3006) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "327472614"
   )
   void method3649(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(128 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3631(var3, var4);
      } else if(144 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3632(var3, var4, var5);
         } else {
            this.method3631(var3, var4);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3689();
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2970[var3] = (var5 << 14) + (this.field2970[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2970[var3] = (this.field2970[var3] & -16257) + (var5 << 7);
         }

         if(1 == var4) {
            this.field2962[var3] = (this.field2962[var3] & -16257) + (var5 << 7);
         }

         if(33 == var4) {
            this.field2962[var3] = var5 + (this.field2962[var3] & -128);
         }

         if(var4 == 5) {
            this.field2963[var3] = (var5 << 7) + (this.field2963[var3] & -16257);
         }

         if(37 == var4) {
            this.field2963[var3] = (this.field2963[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2955[var3] = (var5 << 7) + (this.field2955[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2955[var3] = (this.field2955[var3] & -128) + var5;
         }

         if(10 == var4) {
            this.field2976[var3] = (this.field2976[var3] & -16257) + (var5 << 7);
         }

         if(42 == var4) {
            this.field2976[var3] = (this.field2976[var3] & -128) + var5;
         }

         if(11 == var4) {
            this.field2964[var3] = (var5 << 7) + (this.field2964[var3] & -16257);
         }

         if(43 == var4) {
            this.field2964[var3] = var5 + (this.field2964[var3] & -128);
         }

         if(64 == var4) {
            if(var5 >= 64) {
               this.field2957[var3] |= 1;
            } else {
               this.field2957[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2957[var3] |= 2;
            } else {
               this.method3642(var3);
               this.field2957[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2965[var3] = (this.field2965[var3] & 127) + (var5 << 7);
         }

         if(98 == var4) {
            this.field2965[var3] = (this.field2965[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2965[var3] = (this.field2965[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2965[var3] = 16384 + (this.field2965[var3] & 16256) + var5;
         }

         if(var4 == 120) {
            this.method3712(var3);
         }

         if(121 == var4) {
            this.method3639(var3);
         }

         if(123 == var4) {
            this.method3652(var3);
         }

         int var6;
         if(6 == var4) {
            var6 = this.field2965[var3];
            if(var6 == 16384) {
               this.field2966[var3] = (var5 << 7) + (this.field2966[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2965[var3];
            if(var6 == 16384) {
               this.field2966[var3] = (this.field2966[var3] & -128) + var5;
            }
         }

         if(16 == var4) {
            this.field2967[var3] = (this.field2967[var3] & -16257) + (var5 << 7);
         }

         if(48 == var4) {
            this.field2967[var3] = var5 + (this.field2967[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2957[var3] |= 4;
            } else {
               this.method3742(var3);
               this.field2957[var3] &= -5;
            }
         }

         if(17 == var4) {
            this.method3645(var3, (this.field2968[var3] & -16257) + (var5 << 7));
         }

         if(49 == var4) {
            this.method3645(var3, (this.field2968[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3687(var3, this.field2970[var3] + var4);
      } else if(208 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3636();
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3637(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3744();
         }
      }
   }

   @ObfuscatedName("g")
   protected synchronized class66 vmethod3752() {
      return null;
   }

   @ObfuscatedName("m")
   protected synchronized int vmethod3770() {
      return 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   void method3652(int var1) {
      for(class186 var2 = (class186)this.field2978.field2995.method3860(); null != var2; var2 = (class186)this.field2978.field2995.method3861()) {
         if((var1 < 0 || var2.field3011 == var1) && var2.field3013 < 0) {
            this.field2954[var2.field3011][var2.field3004] = null;
            var2.field3013 = 0;
         }
      }

   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3765(int var1) {
      if(this.field2972.method3551()) {
         int var2 = this.field2972.field2928 * this.field2959 / class56.field1185;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2974;
            if(this.field2979 - var3 >= 0L) {
               this.field2974 = var3;
               break;
            }

            int var5 = (int)((this.field2979 - this.field2974 + (long)var2 - 1L) / (long)var2);
            this.field2974 += (long)var5 * (long)var2;
            this.field2978.vmethod3765(var5);
            var1 -= var5;
            this.method3654();
         } while(this.field2972.method3551());
      }

      this.field2978.vmethod3765(var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   void method3654() {
      int var1 = this.field2952;
      int var2 = this.field2975;

      long var3;
      for(var3 = this.field2979; var2 == this.field2975; var3 = this.field2972.method3559(var2)) {
         while(var2 == this.field2972.field2932[var1]) {
            this.field2972.method3553(var1);
            int var5 = this.field2972.method3557(var1);
            if(1 == var5) {
               this.field2972.method3594();
               this.field2972.method3564(var1);
               if(this.field2972.method3582()) {
                  if(!this.field2973 || var2 == 0) {
                     this.method3744();
                     this.field2972.method3550();
                     return;
                  }

                  this.field2972.method3563(var3);
               }
               break;
            }

            if(0 != (var5 & 128)) {
               this.method3649(var5);
            }

            this.field2972.method3585(var1);
            this.field2972.method3564(var1);
         }

         var1 = this.field2972.method3561();
         var2 = this.field2972.field2932[var1];
      }

      this.field2952 = var1;
      this.field2975 = var2;
      this.field2979 = var3;
   }

   @ObfuscatedName("az")
   boolean method3655(class186 var1) {
      if(null == var1.field3017) {
         if(var1.field3013 >= 0) {
            var1.method3946();
            if(var1.field3019 > 0 && this.field2971[var1.field3011][var1.field3019] == var1) {
               this.field2971[var1.field3011][var1.field3019] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("z")
   void method3660(int var1, int var2) {
      this.field2958[var1] = var2;
      this.field2970[var1] = var2 & -128;
      this.method3687(var1, var2);
   }

   @ObfuscatedName("i")
   synchronized boolean method3666() {
      return this.field2972.method3551();
   }

   @ObfuscatedName("v")
   public synchronized void method3673(int var1, int var2) {
      this.method3660(var1, var2);
   }

   @ObfuscatedName("e")
   protected synchronized class66 vmethod3767() {
      return this.field2978;
   }

   @ObfuscatedName("y")
   synchronized void method3681() {
      for(class180 var1 = (class180)this.field2960.method3836(); var1 != null; var1 = (class180)this.field2960.method3827()) {
         var1.method3946();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-88"
   )
   void method3687(int var1, int var2) {
      if(this.field2956[var1] != var2) {
         this.field2956[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2971[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("x")
   void method3689() {
   }

   @ObfuscatedName("j")
   protected synchronized void vmethod3779(int[] var1, int var2, int var3) {
      if(this.field2972.method3551()) {
         int var4 = this.field2959 * this.field2972.field2928 / class56.field1185;

         do {
            long var5 = this.field2974 + (long)var3 * (long)var4;
            if(this.field2979 - var5 >= 0L) {
               this.field2974 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2979 - this.field2974) - 1L) / (long)var4);
            this.field2974 += (long)var4 * (long)var7;
            this.field2978.vmethod3779(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3654();
         } while(this.field2972.method3551());
      }

      this.field2978.vmethod3779(var1, var2, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1746916731"
   )
   void method3712(int var1) {
      for(class186 var2 = (class186)this.field2978.field2995.method3860(); var2 != null; var2 = (class186)this.field2978.field2995.method3861()) {
         if(var1 < 0 || var1 == var2.field3011) {
            if(null != var2.field3017) {
               var2.field3017.method1380(class56.field1185 / 100);
               if(var2.field3017.method1442()) {
                  this.field2978.field2996.method1152(var2.field3017);
               }

               var2.method3782();
            }

            if(var2.field3013 < 0) {
               this.field2954[var2.field3011][var2.field3004] = null;
            }

            var2.method3946();
         }
      }

   }

   @ObfuscatedName("ae")
   boolean method3723(class186 var1, int[] var2, int var3, int var4) {
      var1.field3018 = class56.field1185 / 100;
      if(var1.field3013 < 0 || null != var1.field3017 && !var1.field3017.method1343()) {
         int var5 = var1.field3003;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2963[var1.field3011] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3003 = var5;
         }

         var1.field3017.method1462(this.method3646(var1));
         class184 var6 = var1.field3016;
         boolean var7 = false;
         ++var1.field3015;
         var1.field2999 += var6.field2989;
         double var8 = (double)((var1.field3008 * var1.field3003 >> 12) + (var1.field3004 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field2984 > 0) {
            if(var6.field2987 > 0) {
               var1.field3010 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2987) + 0.5D);
            } else {
               var1.field3010 += 128;
            }
         }

         if(var6.field2982 != null) {
            if(var6.field2988 > 0) {
               var1.field3000 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2988 * var8) + 0.5D);
            } else {
               var1.field3000 += 128;
            }

            while(var1.field3012 < var6.field2982.length - 2 && var1.field3000 > (var6.field2982[var1.field3012 + 2] & 255) << 8) {
               var1.field3012 += 2;
            }

            if(var6.field2982.length - 2 == var1.field3012 && 0 == var6.field2982[1 + var1.field3012]) {
               var7 = true;
            }
         }

         if(var1.field3013 >= 0 && null != var6.field2983 && 0 == (this.field2957[var1.field3011] & 1) && (var1.field3019 < 0 || this.field2971[var1.field3011][var1.field3019] != var1)) {
            if(var6.field2986 > 0) {
               var1.field3013 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2986) + 0.5D);
            } else {
               var1.field3013 += 128;
            }

            while(var1.field3014 < var6.field2983.length - 2 && var1.field3013 > (var6.field2983[var1.field3014 + 2] & 255) << 8) {
               var1.field3014 += 2;
            }

            if(var1.field3014 == var6.field2983.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3017.method1380(var1.field3018);
            if(null != var2) {
               var1.field3017.vmethod3779(var2, var3, var4);
            } else {
               var1.field3017.vmethod3765(var4);
            }

            if(var1.field3017.method1442()) {
               this.field2978.field2996.method1152(var1.field3017);
            }

            var1.method3782();
            if(var1.field3013 >= 0) {
               var1.method3946();
               if(var1.field3019 > 0 && this.field2971[var1.field3011][var1.field3019] == var1) {
                  this.field2971[var1.field3011][var1.field3019] = null;
               }
            }

            return true;
         } else {
            var1.field3017.method1354(var1.field3018, this.method3641(var1), this.method3648(var1));
            return false;
         }
      } else {
         var1.method3782();
         var1.method3946();
         if(var1.field3019 > 0 && this.field2971[var1.field3011][var1.field3019] == var1) {
            this.field2971[var1.field3011][var1.field3019] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   public synchronized void method3727(class179 var1, boolean var2) {
      this.method3628();
      this.field2972.method3549(var1.field2918);
      this.field2973 = var2;
      this.field2974 = 0L;
      int var3 = this.field2972.method3552();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2972.method3553(var4);
         this.field2972.method3585(var4);
         this.field2972.method3564(var4);
      }

      this.field2952 = this.field2972.method3561();
      this.field2975 = this.field2972.field2932[this.field2952];
      this.field2979 = this.field2972.method3559(this.field2975);
   }

   @ObfuscatedName("av")
   void method3742(int var1) {
      if(0 != (this.field2957[var1] & 4)) {
         for(class186 var2 = (class186)this.field2978.field2995.method3860(); var2 != null; var2 = (class186)this.field2978.field2995.method3861()) {
            if(var2.field3011 == var1) {
               var2.field3002 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aa")
   void method3744() {
      this.method3712(-1);
      this.method3639(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2956[var1] = this.field2958[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2970[var1] = this.field2958[var1] & -128;
      }

   }
}
