package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class183 extends class66 {
   @ObfuscatedName("d")
   int[] field2946 = new int[16];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 46681017
   )
   int field2947 = 256;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -897476151
   )
   int field2948 = 1000000;
   @ObfuscatedName("l")
   int[] field2949 = new int[16];
   @ObfuscatedName("u")
   int[] field2950 = new int[16];
   @ObfuscatedName("a")
   int[] field2951 = new int[16];
   @ObfuscatedName("h")
   int[] field2952 = new int[16];
   @ObfuscatedName("i")
   int[] field2953 = new int[16];
   @ObfuscatedName("t")
   int[] field2954 = new int[16];
   @ObfuscatedName("s")
   int[] field2955 = new int[16];
   @ObfuscatedName("q")
   int[] field2956 = new int[16];
   @ObfuscatedName("e")
   int[] field2957 = new int[16];
   @ObfuscatedName("v")
   int[] field2959 = new int[16];
   @ObfuscatedName("o")
   int[] field2960 = new int[16];
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 7049075539124310925L
   )
   long field2961;
   @ObfuscatedName("j")
   class195 field2962 = new class195(128);
   @ObfuscatedName("ao")
   class181 field2963 = new class181();
   @ObfuscatedName("c")
   int[] field2964 = new int[16];
   @ObfuscatedName("b")
   class186[][] field2965 = new class186[16][128];
   @ObfuscatedName("aa")
   class186[][] field2966 = new class186[16][128];
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1097195769
   )
   int field2967;
   @ObfuscatedName("as")
   boolean field2968;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1198220653
   )
   int field2969;
   @ObfuscatedName("k")
   int[] field2970 = new int[16];
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 8973205575153923229L
   )
   long field2971;
   @ObfuscatedName("x")
   int[] field2972 = new int[16];
   @ObfuscatedName("ay")
   class185 field2973 = new class185(this);

   @ObfuscatedName("j")
   public synchronized void method3652(int var1) {
      this.field2947 = var1;
   }

   @ObfuscatedName("m")
   public int method3653() {
      return this.field2947;
   }

   @ObfuscatedName("f")
   synchronized boolean method3654(class179 var1, class166 var2, class59 var3, int var4) {
      var1.method3568();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class196 var7 = (class196)var1.field2909.method3835(); var7 != null; var7 = (class196)var1.field2909.method3840()) {
         int var8 = (int)var7.field3104;
         class180 var9 = (class180)this.field2962.method3836((long)var8);
         if(null == var9) {
            byte[] var11 = var2.method3338(var8);
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

            this.field2962.method3839(var10, (long)var8);
         }

         if(!var9.method3583(var3, var7.field3082, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3569();
      }

      return var5;
   }

   @ObfuscatedName("u")
   public synchronized void method3656() {
      for(class180 var1 = (class180)this.field2962.method3835(); null != var1; var1 = (class180)this.field2962.method3840()) {
         var1.method3965();
      }

   }

   @ObfuscatedName("k")
   synchronized void method3657(class179 var1, boolean var2) {
      this.method3658();
      this.field2963.method3589(var1.field2910);
      this.field2968 = var2;
      this.field2971 = 0L;
      int var3 = this.field2963.method3620();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2963.method3593(var4);
         this.field2963.method3596(var4);
         this.field2963.method3594(var4);
      }

      this.field2969 = this.field2963.method3599();
      this.field2967 = this.field2963.field2928[this.field2969];
      this.field2961 = this.field2963.method3600(this.field2967);
   }

   @ObfuscatedName("w")
   public synchronized void method3658() {
      this.field2963.method3590();
      this.method3664();
   }

   @ObfuscatedName("e")
   public synchronized boolean method3659() {
      return this.field2963.method3601();
   }

   @ObfuscatedName("z")
   public synchronized void method3660(int var1, int var2) {
      this.method3661(var1, var2);
   }

   @ObfuscatedName("p")
   void method3661(int var1, int var2) {
      this.field2952[var1] = var2;
      this.field2954[var1] = var2 & -128;
      this.method3662(var1, var2);
   }

   @ObfuscatedName("r")
   void method3662(int var1, int var2) {
      if(var2 != this.field2953[var1]) {
         this.field2953[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2966[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("g")
   void method3663(int var1, int var2, int var3) {
      this.method3761(var1, var2);
      if(0 != (this.field2959[var1] & 2)) {
         for(class186 var4 = (class186)this.field2973.field2986.method3884(); null != var4; var4 = (class186)this.field2973.field2986.method3874()) {
            if(var4.field3006 == var1 && var4.field3005 < 0) {
               this.field2965[var1][var4.field2996] = null;
               this.field2965[var1][var2] = var4;
               int var5 = var4.field3014 + (var4.field3000 * var4.field3001 >> 12);
               var4.field3014 += var2 - var4.field2996 << 8;
               var4.field3000 = var5 - var4.field3014;
               var4.field3001 = 4096;
               var4.field2996 = var2;
               return;
            }
         }
      }

      class180 var8 = (class180)this.field2962.method3836((long)this.field2953[var1]);
      if(null != var8) {
         class62 var9 = var8.field2911[var2];
         if(var9 != null) {
            class186 var6 = new class186();
            var6.field3006 = var1;
            var6.field2992 = var8;
            var6.field2998 = var9;
            var6.field2994 = var8.field2916[var2];
            var6.field2995 = var8.field2912[var2];
            var6.field2996 = var2;
            var6.field2993 = 1024 + var8.field2913 * var3 * var3 * var8.field2919[var2] >> 11;
            var6.field3012 = var8.field2915[var2] & 255;
            var6.field3014 = (var2 << 8) - (var8.field2914[var2] & 32767);
            var6.field2991 = 0;
            var6.field3003 = 0;
            var6.field3004 = 0;
            var6.field3005 = -1;
            var6.field3007 = 0;
            if(this.field2946[var1] == 0) {
               var6.field3009 = class64.method1421(var9, this.method3677(var6), this.method3678(var6), this.method3679(var6));
            } else {
               var6.field3009 = class64.method1421(var9, this.method3677(var6), 0, this.method3679(var6));
               this.method3734(var6, var8.field2914[var2] < 0);
            }

            if(var8.field2914[var2] < 0) {
               var6.field3009.method1348(-1);
            }

            if(var6.field2995 >= 0) {
               class186 var7 = this.field2966[var1][var6.field2995];
               if(null != var7 && var7.field3005 < 0) {
                  this.field2965[var1][var7.field2996] = null;
                  var7.field3005 = 0;
               }

               this.field2966[var1][var6.field2995] = var6;
            }

            this.field2973.field2986.method3868(var6);
            this.field2965[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ay")
   void method3664() {
      this.method3699(-1);
      this.method3670(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2953[var1] = this.field2952[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2954[var1] = this.field2952[var1] & -128;
      }

   }

   @ObfuscatedName("at")
   void method3665(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3761(var3, var4);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3663(var3, var4, var5);
         } else {
            this.method3761(var3, var4);
         }

      } else if(160 == var2) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3666();
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(0 == var4) {
            this.field2954[var3] = (var5 << 14) + (this.field2954[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2954[var3] = (var5 << 7) + (this.field2954[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2955[var3] = (var5 << 7) + (this.field2955[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2955[var3] = var5 + (this.field2955[var3] & -128);
         }

         if(5 == var4) {
            this.field2957[var3] = (var5 << 7) + (this.field2957[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2957[var3] = var5 + (this.field2957[var3] & -128);
         }

         if(7 == var4) {
            this.field2949[var3] = (this.field2949[var3] & -16257) + (var5 << 7);
         }

         if(39 == var4) {
            this.field2949[var3] = var5 + (this.field2949[var3] & -128);
         }

         if(10 == var4) {
            this.field2950[var3] = (var5 << 7) + (this.field2950[var3] & -16257);
         }

         if(42 == var4) {
            this.field2950[var3] = (this.field2950[var3] & -128) + var5;
         }

         if(11 == var4) {
            this.field2951[var3] = (this.field2951[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field2951[var3] = var5 + (this.field2951[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2959[var3] |= 1;
            } else {
               this.field2959[var3] &= -2;
            }
         }

         if(65 == var4) {
            if(var5 >= 64) {
               this.field2959[var3] |= 2;
            } else {
               this.method3673(var3);
               this.field2959[var3] &= -3;
            }
         }

         if(99 == var4) {
            this.field2956[var3] = (this.field2956[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2956[var3] = var5 + (this.field2956[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2956[var3] = (this.field2956[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2956[var3] = var5 + 16384 + (this.field2956[var3] & 16256);
         }

         if(var4 == 120) {
            this.method3699(var3);
         }

         if(var4 == 121) {
            this.method3670(var3);
         }

         if(123 == var4) {
            this.method3741(var3);
         }

         int var6;
         if(6 == var4) {
            var6 = this.field2956[var3];
            if(16384 == var6) {
               this.field2972[var3] = (this.field2972[var3] & -16257) + (var5 << 7);
            }
         }

         if(38 == var4) {
            var6 = this.field2956[var3];
            if(var6 == 16384) {
               this.field2972[var3] = (this.field2972[var3] & -128) + var5;
            }
         }

         if(var4 == 16) {
            this.field2946[var3] = (var5 << 7) + (this.field2946[var3] & -16257);
         }

         if(48 == var4) {
            this.field2946[var3] = var5 + (this.field2946[var3] & -128);
         }

         if(81 == var4) {
            if(var5 >= 64) {
               this.field2959[var3] |= 4;
            } else {
               this.method3674(var3);
               this.field2959[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3676(var3, (var5 << 7) + (this.field2960[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3676(var3, (this.field2960[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3662(var3, var4 + this.field2954[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3743();
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3693(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3664();
         }
      }
   }

   @ObfuscatedName("v")
   void method3666() {
   }

   @ObfuscatedName("o")
   void method3670(int var1) {
      if(var1 >= 0) {
         this.field2949[var1] = 12800;
         this.field2950[var1] = 8192;
         this.field2951[var1] = 16383;
         this.field2970[var1] = 8192;
         this.field2955[var1] = 0;
         this.field2957[var1] = 8192;
         this.method3673(var1);
         this.method3674(var1);
         this.field2959[var1] = 0;
         this.field2956[var1] = 32767;
         this.field2972[var1] = 256;
         this.field2946[var1] = 0;
         this.method3676(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3670(var1);
         }

      }
   }

   @ObfuscatedName("az")
   void method3673(int var1) {
      if((this.field2959[var1] & 2) != 0) {
         for(class186 var2 = (class186)this.field2973.field2986.method3871(); var2 != null; var2 = (class186)this.field2973.field2986.method3873()) {
            if(var1 == var2.field3006 && null == this.field2965[var1][var2.field2996] && var2.field3005 < 0) {
               var2.field3005 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   void method3674(int var1) {
      if((this.field2959[var1] & 4) != 0) {
         for(class186 var2 = (class186)this.field2973.field2986.method3871(); var2 != null; var2 = (class186)this.field2973.field2986.method3873()) {
            if(var2.field3006 == var1) {
               var2.field3011 = 0;
            }
         }
      }

   }

   @ObfuscatedName("al")
   void method3676(int var1, int var2) {
      this.field2960[var1] = var2;
      this.field2964[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ac")
   int method3677(class186 var1) {
      int var2 = (var1.field3000 * var1.field3001 >> 12) + var1.field3014;
      var2 += (this.field2970[var1.field3006] - 8192) * this.field2972[var1.field3006] >> 12;
      class184 var3 = var1.field2994;
      int var4;
      if(var3.field2974 > 0 && (var3.field2977 > 0 || this.field2955[var1.field3006] > 0)) {
         var4 = var3.field2977 << 2;
         int var5 = var3.field2982 << 1;
         if(var1.field3002 < var5) {
            var4 = var4 * var1.field3002 / var5;
         }

         var4 += this.field2955[var1.field3006] >> 7;
         double var6 = Math.sin((double)(var1.field3008 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2998.field1221 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class56.field1183 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ar")
   int method3678(class186 var1) {
      class184 var2 = var1.field2994;
      int var3 = this.field2949[var1.field3006] * this.field2951[var1.field3006] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2993 + 16384 >> 15;
      var3 = var3 * this.field2947 + 128 >> 8;
      if(var2.field2976 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2976 * (double)var1.field2991 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2981 != null) {
         var4 = var1.field3003;
         var5 = var2.field2981[var1.field3004 + 1];
         if(var1.field3004 < var2.field2981.length - 2) {
            var6 = (var2.field2981[var1.field3004] & 255) << 8;
            var7 = (var2.field2981[var1.field3004 + 2] & 255) << 8;
            var5 += (var2.field2981[var1.field3004 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field3005 > 0 && null != var2.field2975) {
         var4 = var1.field3005;
         var5 = var2.field2975[1 + var1.field3007];
         if(var1.field3007 < var2.field2975.length - 2) {
            var6 = (var2.field2975[var1.field3007] & 255) << 8;
            var7 = (var2.field2975[var1.field3007 + 2] & 255) << 8;
            var5 += (var2.field2975[var1.field3007 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ak")
   int method3679(class186 var1) {
      int var2 = this.field2950[var1.field3006];
      return var2 < 8192?32 + var1.field3012 * var2 >> 6:16384 - ((128 - var1.field3012) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("h")
   protected synchronized class66 vmethod3770() {
      return null;
   }

   @ObfuscatedName("i")
   protected synchronized int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("t")
   protected synchronized void vmethod3784(int[] var1, int var2, int var3) {
      if(this.field2963.method3601()) {
         int var4 = this.field2963.field2926 * this.field2948 / class56.field1183;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2971;
            if(this.field2961 - var5 >= 0L) {
               this.field2971 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2961 - this.field2971) - 1L) / (long)var4);
            this.field2971 += (long)var7 * (long)var4;
            this.field2973.vmethod3784(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3685();
         } while(this.field2963.method3601());
      }

      this.field2973.vmethod3784(var1, var2, var3);
   }

   @ObfuscatedName("s")
   protected synchronized void vmethod3787(int var1) {
      if(this.field2963.method3601()) {
         int var2 = this.field2963.field2926 * this.field2948 / class56.field1183;

         do {
            long var3 = this.field2971 + (long)var2 * (long)var1;
            if(this.field2961 - var3 >= 0L) {
               this.field2971 = var3;
               break;
            }

            int var5 = (int)((this.field2961 - this.field2971 + (long)var2 - 1L) / (long)var2);
            this.field2971 += (long)var5 * (long)var2;
            this.field2973.vmethod3787(var5);
            var1 -= var5;
            this.method3685();
         } while(this.field2963.method3601());
      }

      this.field2973.vmethod3787(var1);
   }

   @ObfuscatedName("ag")
   void method3685() {
      int var1 = this.field2969;
      int var2 = this.field2967;

      long var3;
      for(var3 = this.field2961; var2 == this.field2967; var3 = this.field2963.method3600(var2)) {
         while(var2 == this.field2963.field2928[var1]) {
            this.field2963.method3593(var1);
            int var5 = this.field2963.method3619(var1);
            if(1 == var5) {
               this.field2963.method3595();
               this.field2963.method3594(var1);
               if(this.field2963.method3633()) {
                  if(!this.field2968 || 0 == var2) {
                     this.method3664();
                     this.field2963.method3590();
                     return;
                  }

                  this.field2963.method3603(var3);
               }
               break;
            }

            if(0 != (var5 & 128)) {
               this.method3665(var5);
            }

            this.field2963.method3596(var1);
            this.field2963.method3594(var1);
         }

         var1 = this.field2963.method3599();
         var2 = this.field2963.field2928[var1];
      }

      this.field2969 = var1;
      this.field2967 = var2;
      this.field2961 = var3;
   }

   @ObfuscatedName("aq")
   boolean method3686(class186 var1) {
      if(null == var1.field3009) {
         if(var1.field3005 >= 0) {
            var1.method3965();
            if(var1.field2995 > 0 && this.field2966[var1.field3006][var1.field2995] == var1) {
               this.field2966[var1.field3006][var1.field2995] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("a")
   protected synchronized class66 vmethod3774() {
      return this.field2973;
   }

   @ObfuscatedName("x")
   void method3693(int var1, int var2) {
      this.field2970[var1] = var2;
   }

   @ObfuscatedName("d")
   void method3699(int var1) {
      for(class186 var2 = (class186)this.field2973.field2986.method3871(); var2 != null; var2 = (class186)this.field2973.field2986.method3873()) {
         if(var1 < 0 || var1 == var2.field3006) {
            if(var2.field3009 != null) {
               var2.field3009.method1402(class56.field1183 / 100);
               if(var2.field3009.method1363()) {
                  this.field2973.field2987.method1200(var2.field3009);
               }

               var2.method3789();
            }

            if(var2.field3005 < 0) {
               this.field2965[var2.field3006][var2.field2996] = null;
            }

            var2.method3965();
         }
      }

   }

   public class183() {
      this.method3664();
   }

   @ObfuscatedName("n")
   void method3734(class186 var1, boolean var2) {
      int var3 = var1.field2998.field1219.length;
      int var4;
      if(var2 && var1.field2998.field1222) {
         int var5 = var3 + var3 - var1.field2998.field1220;
         var4 = (int)((long)this.field2946[var1.field3006] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field3009.method1427();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2946[var1.field3006] >> 6);
      }

      var1.field3009.method1340(var4);
   }

   @ObfuscatedName("c")
   void method3741(int var1) {
      for(class186 var2 = (class186)this.field2973.field2986.method3871(); null != var2; var2 = (class186)this.field2973.field2986.method3873()) {
         if((var1 < 0 || var1 == var2.field3006) && var2.field3005 < 0) {
            this.field2965[var2.field3006][var2.field2996] = null;
            var2.field3005 = 0;
         }
      }

   }

   @ObfuscatedName("q")
   void method3743() {
   }

   @ObfuscatedName("l")
   synchronized void method3744() {
      for(class180 var1 = (class180)this.field2962.method3835(); null != var1; var1 = (class180)this.field2962.method3840()) {
         var1.method3580();
      }

   }

   @ObfuscatedName("au")
   boolean method3758(class186 var1, int[] var2, int var3, int var4) {
      var1.field2999 = class56.field1183 / 100;
      if(var1.field3005 < 0 || var1.field3009 != null && !var1.field3009.method1345()) {
         int var5 = var1.field3001;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2957[var1.field3006]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field3001 = var5;
         }

         var1.field3009.method1360(this.method3677(var1));
         class184 var6 = var1.field2994;
         boolean var7 = false;
         ++var1.field3002;
         var1.field3008 += var6.field2974;
         double var8 = 5.086263020833333E-6D * (double)((var1.field3001 * var1.field3000 >> 12) + (var1.field2996 - 60 << 8));
         if(var6.field2976 > 0) {
            if(var6.field2979 > 0) {
               var1.field2991 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2979) + 0.5D);
            } else {
               var1.field2991 += 128;
            }
         }

         if(var6.field2981 != null) {
            if(var6.field2984 > 0) {
               var1.field3003 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2984) + 0.5D);
            } else {
               var1.field3003 += 128;
            }

            while(var1.field3004 < var6.field2981.length - 2 && var1.field3003 > (var6.field2981[var1.field3004 + 2] & 255) << 8) {
               var1.field3004 += 2;
            }

            if(var1.field3004 == var6.field2981.length - 2 && var6.field2981[var1.field3004 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field3005 >= 0 && null != var6.field2975 && (this.field2959[var1.field3006] & 1) == 0 && (var1.field2995 < 0 || var1 != this.field2966[var1.field3006][var1.field2995])) {
            if(var6.field2978 > 0) {
               var1.field3005 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2978 * var8) + 0.5D);
            } else {
               var1.field3005 += 128;
            }

            while(var1.field3007 < var6.field2975.length - 2 && var1.field3005 > (var6.field2975[var1.field3007 + 2] & 255) << 8) {
               var1.field3007 += 2;
            }

            if(var1.field3007 == var6.field2975.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field3009.method1402(var1.field2999);
            if(var2 != null) {
               var1.field3009.vmethod3784(var2, var3, var4);
            } else {
               var1.field3009.vmethod3787(var4);
            }

            if(var1.field3009.method1363()) {
               this.field2973.field2987.method1200(var1.field3009);
            }

            var1.method3789();
            if(var1.field3005 >= 0) {
               var1.method3965();
               if(var1.field2995 > 0 && this.field2966[var1.field3006][var1.field2995] == var1) {
                  this.field2966[var1.field3006][var1.field2995] = null;
               }
            }

            return true;
         } else {
            var1.field3009.method1358(var1.field2999, this.method3678(var1), this.method3679(var1));
            return false;
         }
      } else {
         var1.method3789();
         var1.method3965();
         if(var1.field2995 > 0 && var1 == this.field2966[var1.field3006][var1.field2995]) {
            this.field2966[var1.field3006][var1.field2995] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("y")
   void method3761(int var1, int var2) {
      class186 var3 = this.field2965[var1][var2];
      if(var3 != null) {
         this.field2965[var1][var2] = null;
         if((this.field2959[var1] & 2) != 0) {
            for(class186 var4 = (class186)this.field2973.field2986.method3871(); var4 != null; var4 = (class186)this.field2973.field2986.method3873()) {
               if(var4.field3006 == var3.field3006 && var4.field3005 < 0 && var4 != var3) {
                  var3.field3005 = 0;
                  break;
               }
            }
         } else {
            var3.field3005 = 0;
         }

      }
   }
}
