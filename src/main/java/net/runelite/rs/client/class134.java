package net.runelite.rs.client;
import java.awt.Graphics;
import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class134 {
   @ObfuscatedName("l")
   static File field2083;
   @ObfuscatedName("a")
   static Hashtable field2084 = new Hashtable(16);
   @ObfuscatedName("z")
   static int[] field2085;
   @ObfuscatedName("j")
   static boolean field2087 = false;

   @ObfuscatedName("l")
   public static String method2803(CharSequence var0, class211 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || 45 == var5;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = 160 == var5 || 32 == var5 || var5 == 95 || 45 == var5;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var10 = var3 - var2;
         if(var10 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3130) {
               case 8:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var10 <= var6) {
               StringBuilder var11 = new StringBuilder(var10);

               for(int var12 = var2; var12 < var3; ++var12) {
                  char var7 = var0.charAt(var12);
                  if(class130.method2762(var7)) {
                     char var8;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var8 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var8 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var8 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var8 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var8 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var8 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var8 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var8 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var8 = 117;
                        break;
                     case 'ß':
                        var8 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var8 = 121;
                        break;
                     default:
                        var8 = Character.toLowerCase(var7);
                     }

                     if(0 != var8) {
                        var11.append(var8);
                     }
                  }
               }

               if(var11.length() == 0) {
                  return null;
               }

               return var11.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("m")
   static void method2806(class223 var0, class223 var1, class223 var2, boolean var3) {
      if(var3) {
         class31.field732 = (class142.field2190 - client.field503 * 765) / 2;
         class31.field738 = 202 + class31.field732;
      }

      if(class31.field721) {
         class3.method34(var0, var1);
      } else {
         if(var3) {
            class24.field625.method1744(class31.field732, 0);
            class31.field712.method1744(class31.field732 + 382, 0);
            class31.field713.method1838(382 + class31.field732 - class31.field713.field1431 / 2, 18);
         }

         int var5;
         if(0 == client.field295 || 5 == client.field295) {
            byte var4 = 20;
            var0.method4039("RuneScape is loading - please wait...", class31.field738 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class79.method1813(180 + class31.field738 - 152, var5, 304, 34, 9179409);
            class79.method1813(180 + class31.field738 - 151, var5 + 1, 302, 32, 0);
            class79.method1776(180 + class31.field738 - 150, var5 + 2, class31.field724 * 3, 30, 9179409);
            class79.method1776(180 + class31.field738 - 150 + class31.field724 * 3, var5 + 2, 300 - class31.field724 * 3, 30, 0);
            var0.method4039(class31.field723, 180 + class31.field738, 276 - var4, 16777215, -1);
         }

         String var6;
         short var15;
         int var16;
         short var17;
         if(client.field295 == 20) {
            class31.field709.method1838(180 + class31.field738 - class31.field709.field1431 / 2, 271 - class31.field709.field1434 / 2);
            var15 = 211;
            var0.method4039(class31.field728, class31.field738 + 180, var15, 16776960, 0);
            var16 = var15 + 15;
            var0.method4039(class31.field729, class31.field738 + 180, var16, 16776960, 0);
            var16 += 15;
            var0.method4039(class31.field720, 180 + class31.field738, var16, 16776960, 0);
            var16 += 15;
            var16 += 10;
            if(class31.field722 != 4) {
               var0.method3967("Login: ", class31.field738 + 180 - 110, var16, 16777215, 0);
               var17 = 200;

               for(var6 = class31.field731; var0.method3962(var6) > var17; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3967(class222.method3966(var6), 180 + class31.field738 - 70, var16, 16777215, 0);
               var16 += 15;
               var0.method3967("Password: " + class138.method2883(class31.field718), class31.field738 + 180 - 108, var16, 16777215, 0);
               var16 += 15;
            }
         }

         int var7;
         int var20;
         int var21;
         if(client.field295 == 10 || client.field295 == 11) {
            class31.field709.method1838(class31.field738, 171);
            short var18;
            if(0 == class31.field722) {
               var15 = 251;
               var0.method4039("Welcome to RuneScape", class31.field738 + 180, var15, 16776960, 0);
               var16 = var15 + 30;
               var5 = class31.field738 + 180 - 80;
               var18 = 291;
               class31.field710.method1838(var5 - 73, var18 - 20);
               var0.method3970("New User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class31.field738 + 180;
               class31.field710.method1838(var5 - 73, var18 - 20);
               var0.method3970("Existing User", var5 - 73, var18 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(1 == class31.field722) {
               var0.method4039(class31.field711, class31.field738 + 180, 211, 16776960, 0);
               var15 = 236;
               var0.method4039(class31.field728, 180 + class31.field738, var15, 16777215, 0);
               var16 = var15 + 15;
               var0.method4039(class31.field729, class31.field738 + 180, var16, 16777215, 0);
               var16 += 15;
               var0.method4039(class31.field720, 180 + class31.field738, var16, 16777215, 0);
               var16 += 15;
               var5 = class31.field738 + 180 - 80;
               var18 = 321;
               class31.field710.method1838(var5 - 73, var18 - 20);
               var0.method4039("Continue", var5, 5 + var18, 16777215, 0);
               var5 = 180 + class31.field738 + 80;
               class31.field710.method1838(var5 - 73, var18 - 20);
               var0.method4039("Cancel", var5, var18 + 5, 16777215, 0);
            } else {
               short var8;
               if(class31.field722 == 2) {
                  var15 = 211;
                  var0.method4039(class31.field728, class31.field738 + 180, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4039(class31.field729, class31.field738 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4039(class31.field720, 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 10;
                  var0.method3967("Login: ", class31.field738 + 180 - 110, var16, 16777215, 0);
                  var17 = 200;

                  for(var6 = class31.field731; var0.method3962(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3967(class222.method3966(var6) + (class31.field735 == 0 & client.field394 % 40 < 20?class24.method592(16776960) + "|":""), class31.field738 + 180 - 70, var16, 16777215, 0);
                  var16 += 15;
                  var0.method3967("Password: " + class138.method2883(class31.field718) + (class31.field735 == 1 & client.field394 % 40 < 20?class24.method592(16776960) + "|":""), class31.field738 + 180 - 108, var16, 16777215, 0);
                  var16 += 15;
                  var7 = class31.field738 + 180 - 80;
                  var8 = 321;
                  class31.field710.method1838(var7 - 73, var8 - 20);
                  var0.method4039("Login", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + 180 + class31.field738;
                  class31.field710.method1838(var7 - 73, var8 - 20);
                  var0.method4039("Cancel", var7, 5 + var8, 16777215, 0);
                  var15 = 357;
                  var1.method4039("Forgotten your password? <col=ffffff>Click here.", class31.field738 + 180, var15, 16776960, 0);
               } else if(class31.field722 == 3) {
                  var15 = 201;
                  var0.method4039("Invalid username or password.", class31.field738 + 180, var15, 16776960, 0);
                  var16 = var15 + 20;
                  var1.method4039("For accounts created after 24th November 2010, please use your", 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var1.method4039("email address to login. Otherwise please login with your username.", 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var5 = class31.field738 + 180;
                  var18 = 276;
                  class31.field710.method1838(var5 - 73, var18 - 20);
                  var2.method4039("Try again", var5, 5 + var18, 16777215, 0);
                  var5 = 180 + class31.field738;
                  var18 = 326;
                  class31.field710.method1838(var5 - 73, var18 - 20);
                  var2.method4039("Forgotten password?", var5, var18 + 5, 16777215, 0);
               } else if(class31.field722 == 4) {
                  var0.method4039("Authenticator", class31.field738 + 180, 211, 16776960, 0);
                  var15 = 236;
                  var0.method4039(class31.field728, 180 + class31.field738, var15, 16777215, 0);
                  var16 = var15 + 15;
                  var0.method4039(class31.field729, 180 + class31.field738, var16, 16777215, 0);
                  var16 += 15;
                  var0.method4039(class31.field720, 180 + class31.field738, var16, 16777215, 0);
                  var16 += 15;
                  var0.method3967("PIN: " + class138.method2883(class150.field2268) + (client.field394 % 40 < 20?class24.method592(16776960) + "|":""), 180 + class31.field738 - 108, var16, 16777215, 0);
                  var16 -= 8;
                  var0.method3967("Trust this computer", 180 + class31.field738 - 9, var16, 16776960, 0);
                  var16 += 15;
                  var0.method3967("for 30 days: ", 180 + class31.field738 - 9, var16, 16776960, 0);
                  var5 = 180 + class31.field738 - 9 + var0.method3962("for 30 days: ") + 15;
                  var21 = var16 - var0.field3182;
                  class80 var19;
                  if(class31.field734) {
                     var19 = class3.field64;
                  } else {
                     var19 = class150.field2269;
                  }

                  var19.method1838(var5, var21);
                  var16 += 15;
                  var20 = class31.field738 + 180 - 80;
                  short var9 = 321;
                  class31.field710.method1838(var20 - 73, var9 - 20);
                  var0.method4039("Continue", var20, var9 + 5, 16777215, 0);
                  var20 = 80 + 180 + class31.field738;
                  class31.field710.method1838(var20 - 73, var9 - 20);
                  var0.method4039("Cancel", var20, var9 + 5, 16777215, 0);
                  var1.method4039("<u=ff>Can\'t Log In?</u>", class31.field738 + 180, 36 + var9, 255, 0);
               } else if(5 == class31.field722) {
                  var0.method4039("Forgotten your password?", 180 + class31.field738, 201, 16776960, 0);
                  var15 = 221;
                  var2.method4039(class31.field728, 180 + class31.field738, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var2.method4039(class31.field729, 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var2.method4039(class31.field720, class31.field738 + 180, var16, 16776960, 0);
                  var16 += 15;
                  var16 += 14;
                  var0.method3967("Username/email: ", 180 + class31.field738 - 145, var16, 16777215, 0);
                  var17 = 174;

                  for(var6 = class31.field731; var0.method3962(var6) > var17; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method3967(class222.method3966(var6) + (client.field394 % 40 < 20?class24.method592(16776960) + "|":""), class31.field738 + 180 - 34, var16, 16777215, 0);
                  var16 += 15;
                  var7 = 180 + class31.field738 - 80;
                  var8 = 321;
                  class31.field710.method1838(var7 - 73, var8 - 20);
                  var0.method4039("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class31.field738 + 180;
                  class31.field710.method1838(var7 - 73, var8 - 20);
                  var0.method4039("Back", var7, var8 + 5, 16777215, 0);
               } else if(class31.field722 == 6) {
                  var15 = 211;
                  var0.method4039(class31.field728, class31.field738 + 180, var15, 16776960, 0);
                  var16 = var15 + 15;
                  var0.method4039(class31.field729, 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var0.method4039(class31.field720, 180 + class31.field738, var16, 16776960, 0);
                  var16 += 15;
                  var5 = class31.field738 + 180;
                  var18 = 321;
                  class31.field710.method1838(var5 - 73, var18 - 20);
                  var0.method4039("Back", var5, 5 + var18, 16777215, 0);
               }
            }
         }

         if(class31.field730 > 0) {
            var16 = class31.field730;
            var17 = 256;
            class31.field725 += 128 * var16;
            if(class31.field725 > class10.field165.length) {
               class31.field725 -= class10.field165.length;
               var21 = (int)(Math.random() * 12.0D);
               class138.method2885(class31.field736[var21]);
            }

            var21 = 0;
            var7 = 128 * var16;
            var20 = (var17 - var16) * 128;

            int var10;
            int var22;
            for(var22 = 0; var22 < var20; ++var22) {
               var10 = class31.field719[var7 + var21] - class10.field165[var21 + class31.field725 & class10.field165.length - 1] * var16 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class31.field719[var21++] = var10;
            }

            int var11;
            int var12;
            for(var22 = var17 - var16; var22 < var17; ++var22) {
               var10 = var22 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class31.field719[var11 + var10] = 255;
                  } else {
                     class31.field719[var10 + var11] = 0;
                  }
               }
            }

            if(class31.field717 > 0) {
               class31.field717 -= var16 * 4;
            }

            if(class31.field707 > 0) {
               class31.field707 -= 4 * var16;
            }

            if(class31.field717 == 0 && class31.field707 == 0) {
               var22 = (int)(Math.random() * (double)(2000 / var16));
               if(var22 == 0) {
                  class31.field717 = 1024;
               }

               if(1 == var22) {
                  class31.field707 = 1024;
               }
            }

            for(var22 = 0; var22 < var17 - var16; ++var22) {
               class31.field716[var22] = class31.field716[var22 + var16];
            }

            for(var22 = var17 - var16; var22 < var17; ++var22) {
               class31.field716[var22] = (int)(Math.sin((double)class31.field726 / 14.0D) * 16.0D + Math.sin((double)class31.field726 / 15.0D) * 14.0D + Math.sin((double)class31.field726 / 16.0D) * 12.0D);
               ++class31.field726;
            }

            class31.field737 += var16;
            var22 = (var16 + (client.field394 & 1)) / 2;
            if(var22 > 0) {
               for(var10 = 0; var10 < class31.field737 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class31.field719[(var12 << 7) + var11] = 192;
               }

               class31.field737 = 0;
               var10 = 0;

               label275:
               while(true) {
                  int var13;
                  if(var10 >= var17) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label275;
                        }

                        var11 = 0;

                        for(var12 = -var22; var12 < var17; ++var12) {
                           var13 = 128 * var12;
                           if(var22 + var12 < var17) {
                              var11 += class124.field2037[var22 * 128 + var13 + var10];
                           }

                           if(var12 - (var22 + 1) >= 0) {
                              var11 -= class124.field2037[var10 + var13 - (1 + var22) * 128];
                           }

                           if(var12 >= 0) {
                              class31.field719[var10 + var13] = var11 / (2 * var22 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var13 = -var22; var13 < 128; ++var13) {
                     if(var22 + var13 < 128) {
                        var11 += class31.field719[var22 + var12 + var13];
                     }

                     if(var13 - (var22 + 1) >= 0) {
                        var11 -= class31.field719[var12 + var13 - (1 + var22)];
                     }

                     if(var13 >= 0) {
                        class124.field2037[var13 + var12] = var11 / (1 + 2 * var22);
                     }
                  }

                  ++var10;
               }
            }

            class31.field730 = 0;
         }

         class89.method2056();
         class128.field2054[class10.field169.field143?1:0].method1838(class31.field732 + 765 - 40, 463);
         if(client.field295 > 5 && client.field472 == 0) {
            if(class12.field193 != null) {
               var16 = 5 + class31.field732;
               var17 = 463;
               byte var24 = 100;
               byte var23 = 35;
               class12.field193.method1838(var16, var17);
               var0.method4039("World" + " " + client.field286, var24 / 2 + var16, var23 / 2 + var17 - 2, 16777215, 0);
               if(null != class216.field3156) {
                  var1.method4039("Loading...", var16 + var24 / 2, 12 + var23 / 2 + var17, 16777215, 0);
               } else {
                  var1.method4039("Click to switch", var24 / 2 + var16, 12 + var23 / 2 + var17, 16777215, 0);
               }
            } else {
               class12.field193 = class51.method1049(class157.field2595, "sl_button", "");
            }
         }

         try {
            Graphics var25 = class125.field2039.getGraphics();
            class75.field1385.vmethod1842(var25, 0, 0);
         } catch (Exception var14) {
            class125.field2039.repaint();
         }

      }
   }

   @ObfuscatedName("dq")
   static final void method2807(String var0, int var1) {
      client.field329.method2686(128);
      client.field329.method2438(class36.method742(var0) + 1);
      client.field329.method2444(var0);
      client.field329.method2622(var1);
   }
}
