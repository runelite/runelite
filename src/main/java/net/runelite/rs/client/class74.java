package net.runelite.rs.client;

import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class74 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1006623175
   )
   int field1353;
   @ObfuscatedName("a")
   int[][] field1354;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1713325479
   )
   int field1356;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 581400685
   )
   static int field1357;

   @ObfuscatedName("j")
   byte[] method1614(byte[] var1) {
      if(null != this.field1354) {
         int var2 = (int)((long)this.field1356 * (long)var1.length / (long)this.field1353) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1354[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var7 * var8[var9];
            }

            var5 += this.field1356;
            var9 = var5 / this.field1353;
            var4 += var9;
            var5 -= var9 * this.field1353;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("m")
   int method1615(int var1) {
      if(null != this.field1354) {
         var1 = (int)((long)this.field1356 * (long)var1 / (long)this.field1353);
      }

      return var1;
   }

   @ObfuscatedName("f")
   int method1616(int var1) {
      if(this.field1354 != null) {
         var1 = (int)((long)this.field1356 * (long)var1 / (long)this.field1353) + 6;
      }

      return var1;
   }

   @ObfuscatedName("m")
   static String method1617(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   public class74(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class45.method981(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1353 = var1;
         this.field1356 = var2;
         this.field1354 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1354[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(1.0D + (var6 - 7.0D));
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = 3.141592653589793D * ((double)var8 - var6);
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(0.5D + 65536.0D * var14);
            }
         }

      }
   }

   @ObfuscatedName("a")
   static void method1627(class223 var0, class223 var1, class223 var2, boolean var3) {
      if(var3) {
         class31.field691 = (class129.field2048 - client.field511 * 765) / 2;
         class31.field715 = class31.field691 + 202;
      }

      int var5;
      int var11;
      int var28;
      int var31;
      byte var32;
      int var34;
      int var37;
      int var41;
      int var43;
      int var44;
      if(class31.field721) {
         if(null == class33.field749) {
            class33.field749 = class36.method780(class4.field70, "sl_back", "");
         }

         if(class27.field648 == null) {
            class27.field648 = class41.method896(class4.field70, "sl_flags", "");
         }

         if(class101.field1748 == null) {
            class101.field1748 = class41.method896(class4.field70, "sl_arrows", "");
         }

         if(null == class155.field2289) {
            class155.field2289 = class41.method896(class4.field70, "sl_stars", "");
         }

         class79.method1820(class31.field691, 23, 765, 480, 0);
         class79.method1823(class31.field691, 0, 125, 23, 12425273, 9135624);
         class79.method1823(class31.field691 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method4077("Select a world", 62 + class31.field691, 15, 0, -1);
         if(class155.field2289 != null) {
            class155.field2289[1].method1881(140 + class31.field691, 1);
            var1.method4074("Members only world", 152 + class31.field691, 10, 16777215, -1);
            class155.field2289[0].method1881(140 + class31.field691, 12);
            var1.method4074("Free world", class31.field691 + 152, 21, 16777215, -1);
         }

         if(class101.field1748 != null) {
            var28 = class31.field691 + 280;
            if(class25.field619[0] == 0 && class25.field632[0] == 0) {
               class101.field1748[2].method1881(var28, 4);
            } else {
               class101.field1748[0].method1881(var28, 4);
            }

            if(class25.field619[0] == 0 && 1 == class25.field632[0]) {
               class101.field1748[3].method1881(var28 + 15, 4);
            } else {
               class101.field1748[1].method1881(15 + var28, 4);
            }

            var0.method4074("World", var28 + 32, 17, 16777215, -1);
            var5 = 390 + class31.field691;
            if(class25.field619[0] == 1 && 0 == class25.field632[0]) {
               class101.field1748[2].method1881(var5, 4);
            } else {
               class101.field1748[0].method1881(var5, 4);
            }

            if(class25.field619[0] == 1 && 1 == class25.field632[0]) {
               class101.field1748[3].method1881(15 + var5, 4);
            } else {
               class101.field1748[1].method1881(15 + var5, 4);
            }

            var0.method4074("Players", var5 + 32, 17, 16777215, -1);
            var34 = 500 + class31.field691;
            if(class25.field619[0] == 2 && 0 == class25.field632[0]) {
               class101.field1748[2].method1881(var34, 4);
            } else {
               class101.field1748[0].method1881(var34, 4);
            }

            if(class25.field619[0] == 2 && 1 == class25.field632[0]) {
               class101.field1748[3].method1881(15 + var34, 4);
            } else {
               class101.field1748[1].method1881(var34 + 15, 4);
            }

            var0.method4074("Location", var34 + 32, 17, 16777215, -1);
            var31 = 610 + class31.field691;
            if(class25.field619[0] == 3 && 0 == class25.field632[0]) {
               class101.field1748[2].method1881(var31, 4);
            } else {
               class101.field1748[0].method1881(var31, 4);
            }

            if(class25.field619[0] == 3 && class25.field632[0] == 1) {
               class101.field1748[3].method1881(var31 + 15, 4);
            } else {
               class101.field1748[1].method1881(var31 + 15, 4);
            }

            var0.method4074("Type", 32 + var31, 17, 16777215, -1);
         }

         class79.method1820(class31.field691 + 708, 4, 50, 16, 0);
         var1.method4077("Cancel", 708 + class31.field691 + 25, 16, 16777215, -1);
         var28 = 0;
         var5 = 33554432;
         var34 = client.field277 & var5;

         for(var31 = 0; var31 < class25.field616; ++var31) {
            class25 var36 = class25.field615[var31];
            if(var34 == (var36.field622 & var5) || (var36.field622 & var5) == 0) {
               ++var28;
            }
         }

         class31.field722 = -1;
         if(null != class33.field749) {
            var32 = 88;
            byte var38 = 19;
            var37 = 765 / (1 + var32);
            var41 = 480 / (1 + var38);

            do {
               var11 = var41;
               var43 = var37;
               if(var41 * (var37 - 1) >= var28) {
                  --var37;
               }

               if((var41 - 1) * var37 >= var28) {
                  --var41;
               }

               if(var37 * (var41 - 1) >= var28) {
                  --var41;
               }
            } while(var41 != var11 || var37 != var43);

            var11 = (765 - var37 * var32) / (var37 + 1);
            if(var11 > 5) {
               var11 = 5;
            }

            var43 = (480 - var41 * var38) / (1 + var41);
            if(var43 > 5) {
               var43 = 5;
            }

            var44 = (765 - var32 * var37 - var11 * (var37 - 1)) / 2;
            int var14 = (480 - var41 * var38 - var43 * (var41 - 1)) / 2;
            int var15 = var14 + 23;
            int var16 = class31.field691 + var44;
            int var17 = 0;
            boolean var18 = false;

            int var19;
            for(var19 = 0; var19 < class25.field616; ++var19) {
               class25 var20 = class25.field615[var19];
               if(var34 == (var20.field622 & var5) || (var20.field622 & var5) == 0) {
                  boolean var21 = true;
                  String var22 = Integer.toString(var20.field629);
                  if(-1 == var20.field629) {
                     var22 = "OFF";
                     var21 = false;
                  } else if(var20.field629 > 1980) {
                     var22 = "FULL";
                     var21 = false;
                  }

                  int var24 = 0;
                  byte var23;
                  if(var20.method645()) {
                     var24 = 16711680;
                     if(var20.method660()) {
                        var23 = 5;
                     } else {
                        var23 = 4;
                     }
                  } else if(var20.method643()) {
                     if(var20.method660()) {
                        var23 = 3;
                     } else {
                        var23 = 2;
                     }
                  } else if(var20.method660()) {
                     var23 = 1;
                  } else {
                     var23 = 0;
                  }

                  if(class139.field2134 >= var16 && class139.field2135 >= var15 && class139.field2134 < var32 + var16 && class139.field2135 < var38 + var15 && var21) {
                     class31.field722 = var19;
                     class33.field749[var23].method1733(var16, var15, 128, 16777215);
                     var18 = true;
                  } else {
                     class33.field749[var23].method1728(var16, var15);
                  }

                  if(class27.field648 != null) {
                     class27.field648[(var20.method660()?8:0) + var20.field626].method1881(var16 + 29, var15);
                  }

                  var0.method4077(Integer.toString(var20.field621), var16 + 15, var15 + var38 / 2 + 5, var24, -1);
                  var1.method4077(var22, 60 + var16, var15 + var38 / 2 + 5, 268435455, -1);
                  var15 += var38 + var43;
                  ++var17;
                  if(var17 >= var41) {
                     var15 = var14 + 23;
                     var16 += var32 + var11;
                     var17 = 0;
                  }
               }
            }

            if(var18) {
               var19 = var1.method4161(class25.field615[class31.field722].field633) + 6;
               int var46 = 8 + var1.field3182;
               class79.method1820(class139.field2134 - var19 / 2, 5 + class139.field2135 + 20, var19, var46, 16777120);
               class79.method1815(class139.field2134 - var19 / 2, 20 + class139.field2135 + 5, var19, var46, 0);
               var1.method4077(class25.field615[class31.field722].field633, class139.field2134, 4 + 5 + class139.field2135 + 20 + var1.field3182, 0, -1);
            }
         }

         try {
            Graphics var39 = class17.field244.getGraphics();
            class84.field1440.vmethod1895(var39, 0, 0);
         } catch (Exception var25) {
            class17.field244.repaint();
         }

      } else {
         if(var3) {
            class150.field2240.method1728(class31.field691, 0);
            class31.field693.method1728(382 + class31.field691, 0);
            class33.field755.method1881(382 + class31.field691 - class33.field755.field1407 / 2, 18);
         }

         if(0 == client.field296 || 5 == client.field296) {
            byte var4 = 20;
            var0.method4077("RuneScape is loading - please wait...", 180 + class31.field715, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1815(class31.field715 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1815(class31.field715 + 180 - 151, 1 + var5, 302, 32, 0);
            class79.method1820(class31.field715 + 180 - 150, var5 + 2, class31.field707 * 3, 30, 9179409);
            class79.method1820(class31.field707 * 3 + (class31.field715 + 180 - 150), 2 + var5, 300 - class31.field707 * 3, 30, 0);
            var0.method4077(class31.field700, class31.field715 + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var27;
         short var29;
         if(20 == client.field296) {
            class218.field3148.method1881(class31.field715 + 180 - class218.field3148.field1407 / 2, 271 - class218.field3148.field1410 / 2);
            var27 = 211;
            var0.method4077(class31.field710, 180 + class31.field715, var27, 16776960, 0);
            var28 = var27 + 15;
            var0.method4077(class31.field714, 180 + class31.field715, var28, 16776960, 0);
            var28 += 15;
            var0.method4077(class31.field712, class31.field715 + 180, var28, 16776960, 0);
            var28 += 15;
            var28 += 10;
            if(4 != class31.field709) {
               var0.method4074("Login: ", class31.field715 + 180 - 110, var28, 16777215, 0);
               var29 = 200;

               for(var6 = class31.field713; var0.method4161(var6) > var29; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4074(class222.method4107(var6), 180 + class31.field715 - 70, var28, 16777215, 0);
               var28 += 15;
               var8 = "Password: ";
               var10 = class31.field726;
               var9 = class134.method2909('*', var10.length());
               var0.method4074(var8 + var9, 180 + class31.field715 - 108, var28, 16777215, 0);
               var28 += 15;
            }
         }

         if(client.field296 == 10 || 11 == client.field296) {
            class218.field3148.method1881(class31.field715, 171);
            short var30;
            if(0 == class31.field709) {
               var27 = 251;
               var0.method4077("Welcome to RuneScape", class31.field715 + 180, var27, 16776960, 0);
               var28 = var27 + 30;
               var5 = 180 + class31.field715 - 80;
               var30 = 291;
               class31.field718.method1881(var5 - 73, var30 - 20);
               var0.method4078("New User", var5 - 73, var30 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class31.field715 + 180;
               class31.field718.method1881(var5 - 73, var30 - 20);
               var0.method4078("Existing User", var5 - 73, var30 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class31.field709 == 1) {
               var0.method4077("Warning!", 180 + class31.field715, 211, 16776960, 0);
               var27 = 236;
               var0.method4077(class31.field710, 180 + class31.field715, var27, 16777215, 0);
               var28 = var27 + 15;
               var0.method4077(class31.field714, class31.field715 + 180, var28, 16777215, 0);
               var28 += 15;
               var0.method4077(class31.field712, class31.field715 + 180, var28, 16777215, 0);
               var28 += 15;
               var5 = 180 + class31.field715 - 80;
               var30 = 321;
               class31.field718.method1881(var5 - 73, var30 - 20);
               var0.method4077("Continue", var5, var30 + 5, 16777215, 0);
               var5 = class31.field715 + 180 + 80;
               class31.field718.method1881(var5 - 73, var30 - 20);
               var0.method4077("Cancel", var5, 5 + var30, 16777215, 0);
            } else if(class31.field709 == 2) {
               var27 = 211;
               var0.method4077(class31.field710, class31.field715 + 180, var27, 16776960, 0);
               var28 = var27 + 15;
               var0.method4077(class31.field714, 180 + class31.field715, var28, 16776960, 0);
               var28 += 15;
               var0.method4077(class31.field712, 180 + class31.field715, var28, 16776960, 0);
               var28 += 15;
               var28 += 10;
               var0.method4074("Login: ", class31.field715 + 180 - 110, var28, 16777215, 0);
               var29 = 200;

               for(var6 = class31.field713; var0.method4161(var6) > var29; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4074(class222.method4107(var6) + (0 == class31.field717 & client.field286 % 40 < 20?method1617(16776960) + "|":""), class31.field715 + 180 - 70, var28, 16777215, 0);
               var28 += 15;
               var8 = "Password: ";
               var10 = class31.field726;
               var9 = class134.method2909('*', var10.length());
               var0.method4074(var8 + var9 + (1 == class31.field717 & client.field286 % 40 < 20?method1617(16776960) + "|":""), 180 + class31.field715 - 108, var28, 16777215, 0);
               var28 += 15;
               var11 = 180 + class31.field715 - 80;
               short var12 = 321;
               class31.field718.method1881(var11 - 73, var12 - 20);
               var0.method4077("Login", var11, var12 + 5, 16777215, 0);
               var11 = 180 + class31.field715 + 80;
               class31.field718.method1881(var11 - 73, var12 - 20);
               var0.method4077("Cancel", var11, var12 + 5, 16777215, 0);
               var27 = 357;
               var1.method4077("Forgotten your password? <col=ffffff>Click here.", class31.field715 + 180, var27, 16776960, 0);
            } else if(4 == class31.field709) {
               var0.method4077("Authenticator", class31.field715 + 180, 211, 16776960, 0);
               var27 = 236;
               var0.method4077(class31.field710, 180 + class31.field715, var27, 16777215, 0);
               var28 = var27 + 15;
               var0.method4077(class31.field714, 180 + class31.field715, var28, 16777215, 0);
               var28 += 15;
               var0.method4077(class31.field712, 180 + class31.field715, var28, 16777215, 0);
               var28 += 15;
               var6 = "PIN: ";
               var8 = class50.field1083;
               String var7 = class134.method2909('*', var8.length());
               var0.method4074(var6 + var7 + (client.field286 % 40 < 20?method1617(16776960) + "|":""), class31.field715 + 180 - 108, var28, 16777215, 0);
               var28 -= 8;
               var0.method4074("Trust this computer", 180 + class31.field715 - 9, var28, 16776960, 0);
               var28 += 15;
               var0.method4074("for 30 days: ", class31.field715 + 180 - 9, var28, 16776960, 0);
               var37 = 180 + class31.field715 - 9 + var0.method4161("for 30 days: ") + 15;
               var41 = var28 - var0.field3182;
               class80 var42;
               if(class31.field716) {
                  var42 = class126.field2035;
               } else {
                  var42 = class35.field777;
               }

               var42.method1881(var37, var41);
               var28 += 15;
               var43 = class31.field715 + 180 - 80;
               short var13 = 321;
               class31.field718.method1881(var43 - 73, var13 - 20);
               var0.method4077("Continue", var43, 5 + var13, 16777215, 0);
               var43 = class31.field715 + 180 + 80;
               class31.field718.method1881(var43 - 73, var13 - 20);
               var0.method4077("Cancel", var43, 5 + var13, 16777215, 0);
               var1.method4077("<u=ff>Can\'t Log In?</u>", 180 + class31.field715, 36 + var13, 255, 0);
            } else if(5 == class31.field709) {
               var0.method4077("Forgotten your password?", class31.field715 + 180, 201, 16776960, 0);
               var27 = 221;
               var2.method4077(class31.field710, class31.field715 + 180, var27, 16776960, 0);
               var28 = var27 + 15;
               var2.method4077(class31.field714, class31.field715 + 180, var28, 16776960, 0);
               var28 += 15;
               var2.method4077(class31.field712, class31.field715 + 180, var28, 16776960, 0);
               var28 += 15;
               var28 += 14;
               var0.method4074("Username/email: ", class31.field715 + 180 - 145, var28, 16777215, 0);
               var29 = 174;

               for(var6 = class31.field713; var0.method4161(var6) > var29; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4074(class222.method4107(var6) + (client.field286 % 40 < 20?method1617(16776960) + "|":""), 180 + class31.field715 - 34, var28, 16777215, 0);
               var28 += 15;
               var31 = 180 + class31.field715 - 80;
               short var33 = 321;
               class31.field718.method1881(var31 - 73, var33 - 20);
               var0.method4077("Recover", var31, var33 + 5, 16777215, 0);
               var31 = class31.field715 + 180 + 80;
               class31.field718.method1881(var31 - 73, var33 - 20);
               var0.method4077("Back", var31, var33 + 5, 16777215, 0);
            } else if(class31.field709 == 6) {
               var27 = 211;
               var0.method4077(class31.field710, class31.field715 + 180, var27, 16776960, 0);
               var28 = var27 + 15;
               var0.method4077(class31.field714, 180 + class31.field715, var28, 16776960, 0);
               var28 += 15;
               var0.method4077(class31.field712, 180 + class31.field715, var28, 16776960, 0);
               var28 += 15;
               var5 = 180 + class31.field715;
               var30 = 321;
               class31.field718.method1881(var5 - 73, var30 - 20);
               var0.method4077("Back", var5, 5 + var30, 16777215, 0);
            }
         }

         if(class31.field705 > 0) {
            var28 = class31.field705;
            var29 = 256;
            class31.field692 += var28 * 128;
            if(class31.field692 > class139.field2144.length) {
               class31.field692 -= class139.field2144.length;
               var34 = (int)(Math.random() * 12.0D);
               class15.method208(class102.field1749[var34]);
            }

            var34 = 0;
            var31 = var28 * 128;
            int var35 = 128 * (var29 - var28);

            for(var37 = 0; var37 < var35; ++var37) {
               var41 = class86.field1514[var31 + var34] - var28 * class139.field2144[class31.field692 + var34 & class139.field2144.length - 1] / 6;
               if(var41 < 0) {
                  var41 = 0;
               }

               class86.field1514[var34++] = var41;
            }

            for(var37 = var29 - var28; var37 < var29; ++var37) {
               var41 = var37 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var43 = (int)(Math.random() * 100.0D);
                  if(var43 < 50 && var11 > 10 && var11 < 118) {
                     class86.field1514[var41 + var11] = 255;
                  } else {
                     class86.field1514[var11 + var41] = 0;
                  }
               }
            }

            if(class31.field697 > 0) {
               class31.field697 -= 4 * var28;
            }

            if(class31.field702 > 0) {
               class31.field702 -= 4 * var28;
            }

            if(class31.field697 == 0 && 0 == class31.field702) {
               var37 = (int)(Math.random() * (double)(2000 / var28));
               if(0 == var37) {
                  class31.field697 = 1024;
               }

               if(var37 == 1) {
                  class31.field702 = 1024;
               }
            }

            for(var37 = 0; var37 < var29 - var28; ++var37) {
               class31.field698[var37] = class31.field698[var28 + var37];
            }

            for(var37 = var29 - var28; var37 < var29; ++var37) {
               class31.field698[var37] = (int)(Math.sin((double)class31.field708 / 14.0D) * 16.0D + Math.sin((double)class31.field708 / 15.0D) * 14.0D + Math.sin((double)class31.field708 / 16.0D) * 12.0D);
               ++class31.field708;
            }

            class31.field704 += var28;
            var37 = (var28 + (client.field286 & 1)) / 2;
            if(var37 > 0) {
               for(var41 = 0; var41 < class31.field704 * 100; ++var41) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var43 = (int)(Math.random() * 128.0D) + 128;
                  class86.field1514[var11 + (var43 << 7)] = 192;
               }

               class31.field704 = 0;
               var41 = 0;

               label538:
               while(true) {
                  if(var41 >= var29) {
                     var41 = 0;

                     while(true) {
                        if(var41 >= 128) {
                           break label538;
                        }

                        var11 = 0;

                        for(var43 = -var37; var43 < var29; ++var43) {
                           var44 = var43 * 128;
                           if(var37 + var43 < var29) {
                              var11 += class165.field2653[var44 + var41 + var37 * 128];
                           }

                           if(var43 - (1 + var37) >= 0) {
                              var11 -= class165.field2653[var44 + var41 - 128 * (var37 + 1)];
                           }

                           if(var43 >= 0) {
                              class86.field1514[var44 + var41] = var11 / (2 * var37 + 1);
                           }
                        }

                        ++var41;
                     }
                  }

                  var11 = 0;
                  var43 = 128 * var41;

                  for(var44 = -var37; var44 < 128; ++var44) {
                     if(var37 + var44 < 128) {
                        var11 += class86.field1514[var43 + var44 + var37];
                     }

                     if(var44 - (var37 + 1) >= 0) {
                        var11 -= class86.field1514[var44 + var43 - (1 + var37)];
                     }

                     if(var44 >= 0) {
                        class165.field2653[var44 + var43] = var11 / (1 + var37 * 2);
                     }
                  }

                  ++var41;
               }
            }

            class31.field705 = 0;
         }

         class11.method160();
         class162.field2634[class153.field2277.field135?1:0].method1881(765 + class31.field691 - 40, 463);
         if(client.field296 > 5 && 0 == client.field283) {
            if(null != class10.field159) {
               var28 = class31.field691 + 5;
               var29 = 463;
               byte var40 = 100;
               var32 = 35;
               class10.field159.method1881(var28, var29);
               var0.method4077("World" + " " + client.field421, var28 + var40 / 2, var29 + var32 / 2 - 2, 16777215, 0);
               if(class25.field620 != null) {
                  var1.method4077("Loading...", var28 + var40 / 2, var32 / 2 + var29 + 12, 16777215, 0);
               } else {
                  var1.method4077("Click to switch", var40 / 2 + var28, 12 + var32 / 2 + var29, 16777215, 0);
               }
            } else {
               class10.field159 = class0.method4(class4.field70, "sl_button", "");
            }
         }

         try {
            Graphics var45 = class17.field244.getGraphics();
            class84.field1440.vmethod1895(var45, 0, 0);
         } catch (Exception var26) {
            class17.field244.repaint();
         }

      }
   }
}
