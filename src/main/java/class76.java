import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class76 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 839053827
   )
   static int field1379;
   @ObfuscatedName("na")
   static class56 field1380;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 788675499
   )
   static int field1381;
   @ObfuscatedName("y")
   static int[] field1382;
   @ObfuscatedName("g")
   static int[] field1383;
   @ObfuscatedName("ad")
   static int[] field1384;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1256833119
   )
   static int field1385;
   @ObfuscatedName("s")
   static int[] field1386;
   @ObfuscatedName("u")
   public static class118 field1388;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   public static void method1675() {
      if(class139.field2136 != null) {
         class139 var0 = class139.field2136;
         synchronized(class139.field2136) {
            class139.field2136 = null;
         }
      }

   }

   @ObfuscatedName("j")
   public static byte[] method1677(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class0.method6(var3):var3;
      } else if(var0 instanceof class124) {
         class124 var2 = (class124)var0;
         return var2.vmethod2792();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass223;Lclass223;Lclass223;ZB)V",
      garbageValue = "113"
   )
   static void method1688(class223 var0, class223 var1, class223 var2, boolean var3) {
      if(var3) {
         class31.field716 = (class6.field107 - client.field417 * 765) / 2;
         class31.field721 = 202 + class31.field716;
      }

      if(class31.field741) {
         class141.method2993(var0, var1);
      } else {
         if(var3) {
            class31.field717.method1743(class31.field716, 0);
            class31.field718.method1743(class31.field716 + 382, 0);
            class10.field159.method1883(382 + class31.field716 - class10.field159.field1418 / 2, 18);
         }

         int var5;
         if(client.field552 == 0 || client.field552 == 5) {
            byte var4 = 20;
            var0.method4059("RuneScape is loading - please wait...", 180 + class31.field721, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1853(class31.field721 + 180 - 152, var5, 304, 34, 9179409);
            class79.method1853(class31.field721 + 180 - 151, var5 + 1, 302, 32, 0);
            class79.method1830(class31.field721 + 180 - 150, var5 + 2, class31.field750 * 3, 30, 9179409);
            class79.method1830(class31.field721 + 180 - 150 + class31.field750 * 3, 2 + var5, 300 - class31.field750 * 3, 30, 0);
            var0.method4059(class31.field740, 180 + class31.field721, 276 - var4, 16777215, -1);
         }

         String var6;
         short var16;
         int var17;
         short var18;
         if(20 == client.field552) {
            class126.field2038.method1883(class31.field721 + 180 - class126.field2038.field1418 / 2, 271 - class126.field2038.field1417 / 2);
            var16 = 211;
            var0.method4059(class31.field735, class31.field721 + 180, var16, 16776960, 0);
            var17 = var16 + 15;
            var0.method4059(class31.field736, 180 + class31.field721, var17, 16776960, 0);
            var17 += 15;
            var0.method4059(class31.field737, class31.field721 + 180, var17, 16776960, 0);
            var17 += 15;
            var17 += 10;
            if(4 != class31.field733) {
               var0.method4057("Login: ", class31.field721 + 180 - 110, var17, 16777215, 0);
               var18 = 200;

               for(var6 = class31.field742; var0.method4052(var6) > var18; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4057(class222.method4130(var6), class31.field721 + 180 - 70, var17, 16777215, 0);
               var17 += 15;
               var0.method4057("Password: " + class138.method2949(class31.field726), class31.field721 + 180 - 108, var17, 16777215, 0);
               var17 += 15;
            }
         }

         int var7;
         int var21;
         int var22;
         if(10 == client.field552 || client.field552 == 11) {
            class126.field2038.method1883(class31.field721, 171);
            short var19;
            if(class31.field733 == 0) {
               var16 = 251;
               var0.method4059("Welcome to RuneScape", 180 + class31.field721, var16, 16776960, 0);
               var17 = var16 + 30;
               var5 = 180 + class31.field721 - 80;
               var19 = 291;
               class208.field3112.method1883(var5 - 73, var19 - 20);
               var0.method4095("New User", var5 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class31.field721 + 180 + 80;
               class208.field3112.method1883(var5 - 73, var19 - 20);
               var0.method4095("Existing User", var5 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(1 == class31.field733) {
               var0.method4059(class31.field734, class31.field721 + 180, 211, 16776960, 0);
               var16 = 236;
               var0.method4059(class31.field735, 180 + class31.field721, var16, 16777215, 0);
               var17 = var16 + 15;
               var0.method4059(class31.field736, 180 + class31.field721, var17, 16777215, 0);
               var17 += 15;
               var0.method4059(class31.field737, class31.field721 + 180, var17, 16777215, 0);
               var17 += 15;
               var5 = 180 + class31.field721 - 80;
               var19 = 321;
               class208.field3112.method1883(var5 - 73, var19 - 20);
               var0.method4059("Continue", var5, 5 + var19, 16777215, 0);
               var5 = 80 + class31.field721 + 180;
               class208.field3112.method1883(var5 - 73, var19 - 20);
               var0.method4059("Cancel", var5, 5 + var19, 16777215, 0);
            } else {
               short var8;
               if(class31.field733 == 2) {
                  var16 = 211;
                  var0.method4059(class31.field735, 180 + class31.field721, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4059(class31.field736, class31.field721 + 180, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4059(class31.field737, 180 + class31.field721, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 10;
                  var0.method4057("Login: ", class31.field721 + 180 - 110, var17, 16777215, 0);
                  var18 = 200;

                  for(var6 = class31.field742; var0.method4052(var6) > var18; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4057(class222.method4130(var6) + (class31.field738 == 0 & client.field303 % 40 < 20?class51.method1090(16776960) + "|":""), class31.field721 + 180 - 70, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4057("Password: " + class138.method2949(class31.field726) + (class31.field738 == 1 & client.field303 % 40 < 20?class51.method1090(16776960) + "|":""), class31.field721 + 180 - 108, var17, 16777215, 0);
                  var17 += 15;
                  var7 = class31.field721 + 180 - 80;
                  var8 = 321;
                  class208.field3112.method1883(var7 - 73, var8 - 20);
                  var0.method4059("Login", var7, 5 + var8, 16777215, 0);
                  var7 = class31.field721 + 180 + 80;
                  class208.field3112.method1883(var7 - 73, var8 - 20);
                  var0.method4059("Cancel", var7, 5 + var8, 16777215, 0);
                  var16 = 357;
                  var1.method4059("Forgotten your password? <col=ffffff>Click here.", class31.field721 + 180, var16, 16776960, 0);
               } else if(3 == class31.field733) {
                  var16 = 201;
                  var0.method4059("Invalid username or password.", class31.field721 + 180, var16, 16776960, 0);
                  var17 = var16 + 20;
                  var1.method4059("For accounts created after 24th November 2010, please use your", 180 + class31.field721, var17, 16776960, 0);
                  var17 += 15;
                  var1.method4059("email address to login. Otherwise please login with your username.", class31.field721 + 180, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class31.field721 + 180;
                  var19 = 276;
                  class208.field3112.method1883(var5 - 73, var19 - 20);
                  var2.method4059("Try again", var5, 5 + var19, 16777215, 0);
                  var5 = class31.field721 + 180;
                  var19 = 326;
                  class208.field3112.method1883(var5 - 73, var19 - 20);
                  var2.method4059("Forgotten password?", var5, var19 + 5, 16777215, 0);
               } else if(class31.field733 == 4) {
                  var0.method4059("Authenticator", class31.field721 + 180, 211, 16776960, 0);
                  var16 = 236;
                  var0.method4059(class31.field735, class31.field721 + 180, var16, 16777215, 0);
                  var17 = var16 + 15;
                  var0.method4059(class31.field736, 180 + class31.field721, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4059(class31.field737, 180 + class31.field721, var17, 16777215, 0);
                  var17 += 15;
                  var0.method4057("PIN: " + class138.method2949(class27.field669) + (client.field303 % 40 < 20?class51.method1090(16776960) + "|":""), 180 + class31.field721 - 108, var17, 16777215, 0);
                  var17 -= 8;
                  var0.method4057("Trust this computer", 180 + class31.field721 - 9, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4057("for 30 days: ", class31.field721 + 180 - 9, var17, 16776960, 0);
                  var5 = 180 + class31.field721 - 9 + var0.method4052("for 30 days: ") + 15;
                  var22 = var17 - var0.field3193;
                  class80 var20;
                  if(class31.field731) {
                     var20 = class31.field719;
                  } else {
                     var20 = class77.field1393;
                  }

                  var20.method1883(var5, var22);
                  var17 += 15;
                  var21 = 180 + class31.field721 - 80;
                  short var9 = 321;
                  class208.field3112.method1883(var21 - 73, var9 - 20);
                  var0.method4059("Continue", var21, var9 + 5, 16777215, 0);
                  var21 = class31.field721 + 180 + 80;
                  class208.field3112.method1883(var21 - 73, var9 - 20);
                  var0.method4059("Cancel", var21, var9 + 5, 16777215, 0);
                  var1.method4059("<u=ff>Can\'t Log In?</u>", 180 + class31.field721, var9 + 36, 255, 0);
               } else if(class31.field733 == 5) {
                  var0.method4059("Forgotten your password?", class31.field721 + 180, 201, 16776960, 0);
                  var16 = 221;
                  var2.method4059(class31.field735, class31.field721 + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var2.method4059(class31.field736, 180 + class31.field721, var17, 16776960, 0);
                  var17 += 15;
                  var2.method4059(class31.field737, class31.field721 + 180, var17, 16776960, 0);
                  var17 += 15;
                  var17 += 14;
                  var0.method4057("Username/email: ", class31.field721 + 180 - 145, var17, 16777215, 0);
                  var18 = 174;

                  for(var6 = class31.field742; var0.method4052(var6) > var18; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4057(class222.method4130(var6) + (client.field303 % 40 < 20?class51.method1090(16776960) + "|":""), 180 + class31.field721 - 34, var17, 16777215, 0);
                  var17 += 15;
                  var7 = 180 + class31.field721 - 80;
                  var8 = 321;
                  class208.field3112.method1883(var7 - 73, var8 - 20);
                  var0.method4059("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = class31.field721 + 180 + 80;
                  class208.field3112.method1883(var7 - 73, var8 - 20);
                  var0.method4059("Back", var7, var8 + 5, 16777215, 0);
               } else if(class31.field733 == 6) {
                  var16 = 211;
                  var0.method4059(class31.field735, class31.field721 + 180, var16, 16776960, 0);
                  var17 = var16 + 15;
                  var0.method4059(class31.field736, 180 + class31.field721, var17, 16776960, 0);
                  var17 += 15;
                  var0.method4059(class31.field737, 180 + class31.field721, var17, 16776960, 0);
                  var17 += 15;
                  var5 = class31.field721 + 180;
                  var19 = 321;
                  class208.field3112.method1883(var5 - 73, var19 - 20);
                  var0.method4059("Back", var5, 5 + var19, 16777215, 0);
               }
            }
         }

         int var10;
         int var11;
         int var12;
         int var13;
         int var23;
         if(class31.field748 > 0) {
            var17 = class31.field748;
            var18 = 256;
            class31.field727 += 128 * var17;
            if(class31.field727 > class21.field590.length) {
               class31.field727 -= class21.field590.length;
               var22 = (int)(Math.random() * 12.0D);
               class185.method3766(class212.field3138[var22]);
            }

            var22 = 0;
            var7 = 128 * var17;
            var21 = (var18 - var17) * 128;

            for(var23 = 0; var23 < var21; ++var23) {
               var10 = field1384[var7 + var22] - var17 * class21.field590[var22 + class31.field727 & class21.field590.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               field1384[var22++] = var10;
            }

            for(var23 = var18 - var17; var23 < var18; ++var23) {
               var10 = var23 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     field1384[var11 + var10] = 255;
                  } else {
                     field1384[var11 + var10] = 0;
                  }
               }
            }

            if(class31.field725 > 0) {
               class31.field725 -= var17 * 4;
            }

            if(class31.field732 > 0) {
               class31.field732 -= var17 * 4;
            }

            if(class31.field725 == 0 && class31.field732 == 0) {
               var23 = (int)(Math.random() * (double)(2000 / var17));
               if(var23 == 0) {
                  class31.field725 = 1024;
               }

               if(var23 == 1) {
                  class31.field732 = 1024;
               }
            }

            for(var23 = 0; var23 < var18 - var17; ++var23) {
               class31.field722[var23] = class31.field722[var23 + var17];
            }

            for(var23 = var18 - var17; var23 < var18; ++var23) {
               class31.field722[var23] = (int)(Math.sin((double)class31.field730 / 14.0D) * 16.0D + Math.sin((double)class31.field730 / 15.0D) * 14.0D + Math.sin((double)class31.field730 / 16.0D) * 12.0D);
               ++class31.field730;
            }

            class31.field728 += var17;
            var23 = (var17 + (client.field303 & 1)) / 2;
            if(var23 > 0) {
               for(var10 = 0; var10 < class31.field728 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  field1384[(var12 << 7) + var11] = 192;
               }

               class31.field728 = 0;
               var10 = 0;

               label384:
               while(true) {
                  if(var10 >= var18) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label384;
                        }

                        var11 = 0;

                        for(var12 = -var23; var12 < var18; ++var12) {
                           var13 = var12 * 128;
                           if(var23 + var12 < var18) {
                              var11 += class33.field775[128 * var23 + var10 + var13];
                           }

                           if(var12 - (var23 + 1) >= 0) {
                              var11 -= class33.field775[var10 + var13 - 128 * (1 + var23)];
                           }

                           if(var12 >= 0) {
                              field1384[var10 + var13] = var11 / (1 + var23 * 2);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var23; var13 < 128; ++var13) {
                     if(var13 + var23 < 128) {
                        var11 += field1384[var23 + var12 + var13];
                     }

                     if(var13 - (1 + var23) >= 0) {
                        var11 -= field1384[var13 + var12 - (1 + var23)];
                     }

                     if(var13 >= 0) {
                        class33.field775[var12 + var13] = var11 / (1 + 2 * var23);
                     }
                  }

                  ++var10;
               }
            }

            class31.field748 = 0;
         }

         var16 = 256;
         if(class31.field725 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field725 > 768) {
                  class31.field723[var5] = class48.method1019(class17.field256[var5], class31.field724[var5], 1024 - class31.field725);
               } else if(class31.field725 > 256) {
                  class31.field723[var5] = class31.field724[var5];
               } else {
                  class31.field723[var5] = class48.method1019(class31.field724[var5], class17.field256[var5], 256 - class31.field725);
               }
            }
         } else if(class31.field732 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class31.field732 > 768) {
                  class31.field723[var5] = class48.method1019(class17.field256[var5], class12.field172[var5], 1024 - class31.field732);
               } else if(class31.field732 > 256) {
                  class31.field723[var5] = class12.field172[var5];
               } else {
                  class31.field723[var5] = class48.method1019(class12.field172[var5], class17.field256[var5], 256 - class31.field732);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class31.field723[var5] = class17.field256[var5];
            }
         }

         class79.method1852(class31.field716, 9, 128 + class31.field716, var16 + 7);
         class31.field717.method1743(class31.field716, 0);
         class79.method1873();
         var5 = 0;
         var22 = class139.field2149.field1395 * 9 + class31.field716;

         int var14;
         for(var7 = 1; var7 < var16 - 1; ++var7) {
            var21 = class31.field722[var7] * (var16 - var7) / var16;
            var23 = var21 + 22;
            if(var23 < 0) {
               var23 = 0;
            }

            var5 += var23;

            for(var10 = var23; var10 < 128; ++var10) {
               var11 = field1384[var5++];
               if(0 != var11) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class31.field723[var11];
                  var14 = class139.field2149.field1394[var22];
                  class139.field2149.field1394[var22++] = ((var11 & '\uff00') * var12 + (var14 & '\uff00') * var13 & 16711680) + (var12 * (var11 & 16711935) + (var14 & 16711935) * var13 & -16711936) >> 8;
               } else {
                  ++var22;
               }
            }

            var22 += var23 + class139.field2149.field1395 - 128;
         }

         class79.method1852(765 + class31.field716 - 128, 9, class31.field716 + 765, 7 + var16);
         class31.field718.method1743(382 + class31.field716, 0);
         class79.method1873();
         var5 = 0;
         var22 = class31.field716 + 637 + 24 + class139.field2149.field1395 * 9;

         for(var7 = 1; var7 < var16 - 1; ++var7) {
            var21 = class31.field722[var7] * (var16 - var7) / var16;
            var23 = 103 - var21;
            var22 += var21;

            for(var10 = 0; var10 < var23; ++var10) {
               var11 = field1384[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class31.field723[var11];
                  var14 = class139.field2149.field1394[var22];
                  class139.field2149.field1394[var22++] = (var13 * (var14 & 16711935) + (var11 & 16711935) * var12 & -16711936) + ((var11 & '\uff00') * var12 + var13 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var22;
               }
            }

            var5 += 128 - var23;
            var22 += class139.field2149.field1395 - var23 - var21;
         }

         class52.field1160[class89.field1548.field132?1:0].method1883(class31.field716 + 765 - 40, 463);
         if(client.field552 > 5 && 0 == client.field298) {
            if(class31.field746 != null) {
               var17 = 5 + class31.field716;
               var18 = 463;
               byte var25 = 100;
               byte var24 = 35;
               class31.field746.method1883(var17, var18);
               var0.method4059("World" + " " + client.field527, var25 / 2 + var17, var24 / 2 + var18 - 2, 16777215, 0);
               if(class107.field1879 != null) {
                  var1.method4059("Loading...", var25 / 2 + var17, var24 / 2 + var18 + 12, 16777215, 0);
               } else {
                  var1.method4059("Click to switch", var17 + var25 / 2, 12 + var24 / 2 + var18, 16777215, 0);
               }
            } else {
               class31.field746 = class48.method1017(class7.field127, "sl_button", "");
            }
         }

         try {
            Graphics var26 = class45.field1042.getGraphics();
            class139.field2149.vmethod1900(var26, 0, 0);
         } catch (Exception var15) {
            class45.field1042.repaint();
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-583530510"
   )
   static final void method1704() {
      int[] var0 = class32.field759;

      int var1;
      for(var1 = 0; var1 < class32.field774; ++var1) {
         class2 var2 = client.field415[var0[var1]];
         if(var2 != null && var2.field855 > 0) {
            --var2.field855;
            if(0 == var2.field855) {
               var2.field825 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field331; ++var1) {
         int var4 = client.field564[var1];
         class34 var3 = client.field358[var4];
         if(null != var3 && var3.field855 > 0) {
            --var3.field855;
            if(0 == var3.field855) {
               var3.field825 = null;
            }
         }
      }

   }

   @ObfuscatedName("f")
   public static boolean method1707(int var0) {
      return 0 != (var0 >> 28 & 1);
   }
}
