import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public final class class123 {
   @ObfuscatedName("bc")
   static class168 field1997;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1547052301
   )
   int field1999;
   @ObfuscatedName("x")
   int[] field2001 = new int[256];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 360962501
   )
   int field2002;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 623020805
   )
   int field2003;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1931977089
   )
   int field2004;
   @ObfuscatedName("mk")
   @Export("clanMembers")
   static class24[] field2005;
   @ObfuscatedName("e")
   int[] field2006 = new int[256];

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "126"
   )
   final void method2754() {
      this.field2003 += ++this.field2004;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.field2006[var1];
         if(0 == (var1 & 2)) {
            if((var1 & 1) == 0) {
               this.field2002 ^= this.field2002 << 13;
            } else {
               this.field2002 ^= this.field2002 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2002 ^= this.field2002 << 2;
         } else {
            this.field2002 ^= this.field2002 >>> 16;
         }

         this.field2002 += this.field2006[128 + var1 & 255];
         int var3;
         this.field2006[var1] = var3 = this.field2003 + this.field2006[(var2 & 1020) >> 2] + this.field2002;
         this.field2001[var1] = this.field2003 = this.field2006[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-19"
   )
   final int method2755() {
      if(0 == --this.field1999 + 1) {
         this.method2754();
         this.field1999 = 255;
      }

      return this.field2001[this.field1999];
   }

   class123(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.field2001[var2] = var1[var2];
      }

      this.method2761();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   final void method2761() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2001[var1];
         var3 += this.field2001[1 + var1];
         var4 += this.field2001[var1 + 2];
         var5 += this.field2001[var1 + 3];
         var6 += this.field2001[var1 + 4];
         var7 += this.field2001[5 + var1];
         var8 += this.field2001[var1 + 6];
         var9 += this.field2001[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2006[var1] = var2;
         this.field2006[var1 + 1] = var3;
         this.field2006[var1 + 2] = var4;
         this.field2006[var1 + 3] = var5;
         this.field2006[4 + var1] = var6;
         this.field2006[5 + var1] = var7;
         this.field2006[6 + var1] = var8;
         this.field2006[7 + var1] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.field2006[var1];
         var3 += this.field2006[1 + var1];
         var4 += this.field2006[var1 + 2];
         var5 += this.field2006[3 + var1];
         var6 += this.field2006[4 + var1];
         var7 += this.field2006[var1 + 5];
         var8 += this.field2006[var1 + 6];
         var9 += this.field2006[7 + var1];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.field2006[var1] = var2;
         this.field2006[var1 + 1] = var3;
         this.field2006[var1 + 2] = var4;
         this.field2006[3 + var1] = var5;
         this.field2006[var1 + 4] = var6;
         this.field2006[var1 + 5] = var7;
         this.field2006[6 + var1] = var8;
         this.field2006[var1 + 7] = var9;
      }

      this.method2754();
      this.field1999 = 256;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;Lclass224;ZI)V",
      garbageValue = "1662427922"
   )
   static void method2762(class224 var0, class224 var1, class224 var2, boolean var3) {
      if(var3) {
         class31.field696 = (class5.field102 - client.field488) / 2;
         class31.field702 = class31.field696 + 202;
      }

      if(class31.field726) {
         class11.method153(var0, var1);
      } else {
         if(var3) {
            class186.field3010.method1698(class31.field696, 0);
            class31.field700.method1698(class31.field696 + 382, 0);
            class31.field701.method1867(382 + class31.field696 - class31.field701.field1403 / 2, 18);
         }

         int var5;
         if(client.field283 == 0 || 5 == client.field283) {
            byte var4 = 20;
            var0.method4007("RuneScape is loading - please wait...", class31.field702 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1801(class31.field702 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1801(class31.field702 + 180 - 151, var5 + 1, 302, 32, 0);
            class79.method1783(class31.field702 + 180 - 150, 2 + var5, class31.field730 * 3, 30, 9179409);
            class79.method1783(class31.field730 * 3 + (180 + class31.field702 - 150), var5 + 2, 300 - class31.field730 * 3, 30, 0);
            var0.method4007(class31.field711, 180 + class31.field702, 276 - var4, 16777215, -1);
         }

         String var6;
         short var15;
         int var16;
         short var17;
         if(20 == client.field283) {
            class31.field731.method1867(class31.field702 + 180 - class31.field731.field1403 / 2, 271 - class31.field731.field1401 / 2);
            var15 = 211;
            var0.method4007(class31.field714, class31.field702 + 180, var15, 16776960, 0);
            var16 = var15 + 15;
            var0.method4007(class31.field729, 180 + class31.field702, var16, 16776960, 0);
            var16 += 15;
            var0.method4007(class31.field716, class31.field702 + 180, var16, 16776960, 0);
            var16 += 15;
            var16 += 10;
            if(class31.field712 != 4) {
               var0.method4006("Login: ", class31.field702 + 180 - 110, var16, 16777215, 0);
               var17 = 200;

               for(var6 = class31.field698; var0.method4002(var6) > var17; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4006(class223.method4005(var6), class31.field702 + 180 - 70, var16, 16777215, 0);
               var16 += 15;
               var0.method4006("Password: " + class44.method910(class31.field710), class31.field702 + 180 - 108, var16, 16777215, 0);
               var16 += 15;
            }
         }

         int var7;
         int var20;
         int var21;
         if(client.field283 == 10 || 11 == client.field283) {
            class31.field731.method1867(class31.field702, 171);
            short var18;
            if(0 == class31.field712) {
               var15 = 251;
               var0.method4007("Welcome to RuneScape", class31.field702 + 180, var15, 16776960, 0);
               var16 = var15 + 30;
               var5 = class31.field702 + 180 - 80;
               var18 = 291;
               class31.field705.method1867(var5 - 73, var18 - 20);
               var0.method4008("New User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class31.field702 + 180 + 80;
               class31.field705.method1867(var5 - 73, var18 - 20);
               var0.method4008("Existing User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(1 == class31.field712) {
               var0.method4007(class31.field719, class31.field702 + 180, 211, 16776960, 0);
               var15 = 236;
               var0.method4007(class31.field714, class31.field702 + 180, var15, 16777215, 0);
               var16 = var15 + 15;
               var0.method4007(class31.field729, 180 + class31.field702, var16, 16777215, 0);
               var16 += 15;
               var0.method4007(class31.field716, class31.field702 + 180, var16, 16777215, 0);
               var16 += 15;
               var5 = class31.field702 + 180 - 80;
               var18 = 321;
               class31.field705.method1867(var5 - 73, var18 - 20);
               var0.method4007("Continue", var5, 5 + var18, 16777215, 0);
               var5 = 80 + class31.field702 + 180;
               class31.field705.method1867(var5 - 73, var18 - 20);
               var0.method4007("Cancel", var5, 5 + var18, 16777215, 0);
            } else {
               short var8;
               if(class31.field712 == 2) {
                  var15 = 211;
                  var0.method4007(class31.field714, class31.field702 + 180, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4007(class31.field729, 180 + class31.field702, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4007(class31.field716, 180 + class31.field702, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 10;
                  var0.method4006("Login: ", 180 + class31.field702 - 110, var16, 16777215, 0);
                  var17 = 200;

                  for(var6 = class31.field698; var0.method4002(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4006(class223.method4005(var6) + (class31.field722 == 0 & client.field285 % 40 < 20?class219.method3968(16776960) + "|":""), class31.field702 + 180 - 70, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4006("Password: " + class44.method910(class31.field710) + (class31.field722 == 1 & client.field285 % 40 < 20?class219.method3968(16776960) + "|":""), 180 + class31.field702 - 108, var16, 16777215, 0);
                  var16 += 15;
                  var7 = 180 + class31.field702 - 80;
                  var8 = 321;
                  class31.field705.method1867(var7 - 73, var8 - 20);
                  var0.method4007("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 180 + class31.field702 + 80;
                  class31.field705.method1867(var7 - 73, var8 - 20);
                  var0.method4007("Cancel", var7, 5 + var8, 16777215, 0);
                  var15 = 357;
                  var1.method4007("Forgotten your password? <col=ffffff>Click here.", 180 + class31.field702, var15, 16776960, 0);
               } else if(class31.field712 == 3) {
                  var15 = 201;
                  var0.method4007("Invalid username or password.", class31.field702 + 180, var15, 16776960, 0);
                  var16 = var15 + 20;
                  var1.method4007("For accounts created after 24th November 2010, please use your", 180 + class31.field702, var16, 16776960, 0);
                  var16 += 15;
                  var1.method4007("email address to login. Otherwise please login with your username.", class31.field702 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var5 = 180 + class31.field702;
                  var18 = 276;
                  class31.field705.method1867(var5 - 73, var18 - 20);
                  var2.method4007("Try again", var5, 5 + var18, 16777215, 0);
                  var5 = class31.field702 + 180;
                  var18 = 326;
                  class31.field705.method1867(var5 - 73, var18 - 20);
                  var2.method4007("Forgotten password?", var5, var18 + 5, 16777215, 0);
               } else if(4 == class31.field712) {
                  var0.method4007("Authenticator", 180 + class31.field702, 211, 16776960, 0);
                  var15 = 236;
                  var0.method4007(class31.field714, 180 + class31.field702, var15, 16777215, 0);
                  var16 = var15 + 15;
                  var0.method4007(class31.field729, class31.field702 + 180, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4007(class31.field716, class31.field702 + 180, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4006("PIN: " + class44.method910(class101.field1739) + (client.field285 % 40 < 20?class219.method3968(16776960) + "|":""), 180 + class31.field702 - 108, var16, 16777215, 0);
                  var16 -= 8;
                  var0.method4006("Trust this computer", class31.field702 + 180 - 9, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4006("for 30 days: ", 180 + class31.field702 - 9, var16, 16776960, 0);
                  var5 = 180 + class31.field702 - 9 + var0.method4002("for 30 days: ") + 15;
                  var21 = var16 - var0.field3192;
                  class80 var19;
                  if(class31.field721) {
                     var19 = class1.field21;
                  } else {
                     var19 = class77.field1379;
                  }

                  var19.method1867(var5, var21);
                  var16 += 15;
                  var20 = class31.field702 + 180 - 80;
                  short var9 = 321;
                  class31.field705.method1867(var20 - 73, var9 - 20);
                  var0.method4007("Continue", var20, var9 + 5, 16777215, 0);
                  var20 = 180 + class31.field702 + 80;
                  class31.field705.method1867(var20 - 73, var9 - 20);
                  var0.method4007("Cancel", var20, var9 + 5, 16777215, 0);
                  var1.method4007("<u=ff>Can\'t Log In?</u>", 180 + class31.field702, 36 + var9, 255, 0);
               } else if(class31.field712 == 5) {
                  var0.method4007("Forgotten your password?", 180 + class31.field702, 201, 16776960, 0);
                  var15 = 221;
                  var2.method4007(class31.field714, 180 + class31.field702, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var2.method4007(class31.field729, class31.field702 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var2.method4007(class31.field716, class31.field702 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 14;
                  var0.method4006("Username/email: ", class31.field702 + 180 - 145, var16, 16777215, 0);
                  var17 = 174;

                  for(var6 = class31.field698; var0.method4002(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4006(class223.method4005(var6) + (client.field285 % 40 < 20?class219.method3968(16776960) + "|":""), class31.field702 + 180 - 34, var16, 16777215, 0);
                  var16 += 15;
                  var7 = 180 + class31.field702 - 80;
                  var8 = 321;
                  class31.field705.method1867(var7 - 73, var8 - 20);
                  var0.method4007("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 180 + class31.field702 + 80;
                  class31.field705.method1867(var7 - 73, var8 - 20);
                  var0.method4007("Back", var7, 5 + var8, 16777215, 0);
               } else if(6 == class31.field712) {
                  var15 = 211;
                  var0.method4007(class31.field714, class31.field702 + 180, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4007(class31.field729, 180 + class31.field702, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4007(class31.field716, 180 + class31.field702, var16, 16776960, 0);
                  var16 += 15;
                  var5 = 180 + class31.field702;
                  var18 = 321;
                  class31.field705.method1867(var5 - 73, var18 - 20);
                  var0.method4007("Back", var5, var18 + 5, 16777215, 0);
               }
            }
         }

         if(class31.field708 > 0) {
            var16 = class31.field708;
            var17 = 256;
            class31.field715 += var16 * 128;
            if(class31.field715 > class56.field1165.length) {
               class31.field715 -= class56.field1165.length;
               var21 = (int)(Math.random() * 12.0D);
               class8.method111(class31.field697[var21]);
            }

            var21 = 0;
            var7 = var16 * 128;
            var20 = (var17 - var16) * 128;

            int var10;
            int var22;
            for(var22 = 0; var22 < var20; ++var22) {
               var10 = class5.field86[var7 + var21] - var16 * class56.field1165[class31.field715 + var21 & class56.field1165.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class5.field86[var21++] = var10;
            }

            int var11;
            int var12;
            for(var22 = var17 - var16; var22 < var17; ++var22) {
               var10 = 128 * var22;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class5.field86[var11 + var10] = 255;
                  } else {
                     class5.field86[var11 + var10] = 0;
                  }
               }
            }

            if(class31.field704 > 0) {
               class31.field704 -= var16 * 4;
            }

            if(class31.field713 > 0) {
               class31.field713 -= 4 * var16;
            }

            if(0 == class31.field704 && class31.field713 == 0) {
               var22 = (int)(Math.random() * (double)(2000 / var16));
               if(var22 == 0) {
                  class31.field704 = 1024;
               }

               if(var22 == 1) {
                  class31.field713 = 1024;
               }
            }

            for(var22 = 0; var22 < var17 - var16; ++var22) {
               class31.field703[var22] = class31.field703[var16 + var22];
            }

            for(var22 = var17 - var16; var22 < var17; ++var22) {
               class31.field703[var22] = (int)(Math.sin((double)class31.field709 / 14.0D) * 16.0D + Math.sin((double)class31.field709 / 15.0D) * 14.0D + Math.sin((double)class31.field709 / 16.0D) * 12.0D);
               ++class31.field709;
            }

            class31.field707 += var16;
            var22 = ((client.field285 & 1) + var16) / 2;
            if(var22 > 0) {
               for(var10 = 0; var10 < class31.field707 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class5.field86[(var12 << 7) + var11] = 192;
               }

               class31.field707 = 0;
               var10 = 0;

               label274:
               while(true) {
                  int var13;
                  if(var10 >= var17) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label274;
                        }

                        var11 = 0;

                        for(var12 = -var22; var12 < var17; ++var12) {
                           var13 = var12 * 128;
                           if(var22 + var12 < var17) {
                              var11 += class176.field2907[var13 + var10 + 128 * var22];
                           }

                           if(var12 - (var22 + 1) >= 0) {
                              var11 -= class176.field2907[var10 + var13 - (1 + var22) * 128];
                           }

                           if(var12 >= 0) {
                              class5.field86[var10 + var13] = var11 / (1 + var22 * 2);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var13 = -var22; var13 < 128; ++var13) {
                     if(var22 + var13 < 128) {
                        var11 += class5.field86[var22 + var13 + var12];
                     }

                     if(var13 - (var22 + 1) >= 0) {
                        var11 -= class5.field86[var12 + var13 - (1 + var22)];
                     }

                     if(var13 >= 0) {
                        class176.field2907[var13 + var12] = var11 / (var22 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class31.field708 = 0;
         }

         class12.method159();
         class138.field2111[class4.field75.field143?1:0].method1867(class31.field696 + 765 - 40, 463);
         if(client.field283 > 5 && client.field292 == 0) {
            if(class10.field162 != null) {
               var16 = 5 + class31.field696;
               var17 = 463;
               byte var24 = 100;
               byte var23 = 35;
               class10.field162.method1867(var16, var17);
               var0.method4007("World" + " " + client.field274, var24 / 2 + var16, var17 + var23 / 2 - 2, 16777215, 0);
               if(null != class17.field245) {
                  var1.method4007("Loading...", var16 + var24 / 2, 12 + var17 + var23 / 2, 16777215, 0);
               } else {
                  var1.method4007("Click to switch", var24 / 2 + var16, 12 + var17 + var23 / 2, 16777215, 0);
               }
            } else {
               class10.field162 = class102.method2275(class178.field2917, "sl_button", "");
            }
         }

         try {
            Graphics var25 = class3.field66.getGraphics();
            class75.field1363.vmethod1873(var25, 0, 0);
         } catch (Exception var14) {
            class3.field66.repaint();
         }

      }
   }
}
