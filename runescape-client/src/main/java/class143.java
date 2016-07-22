import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -4959485784243595389L
   )
   public static long field2208 = 0L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1637341807
   )
   public static volatile int field2209 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -609140643
   )
   public static volatile int field2210 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1683467235
   )
   public static volatile int field2211 = -1;
   @ObfuscatedName("m")
   @Export("mouse")
   public static class143 field2212 = new class143();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1230527217
   )
   public static int field2213 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1140133831
   )
   public static int field2214 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2020800253
   )
   public static volatile int field2215 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 737378321
   )
   public static int field2216 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -384078159
   )
   public static volatile int field2217 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1092974527
   )
   public static volatile int field2218 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1336789869
   )
   public static int field2220 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2102977757
   )
   @Export("mouseIdleTicks")
   public static volatile int field2221 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -269318697
   )
   public static int field2222 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 2419169315753368117L
   )
   public static volatile long field2223 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 906987757
   )
   public static int field2224 = 0;
   @ObfuscatedName("pv")
   @ObfuscatedGetter(
      longValue = -6523081219518586465L
   )
   static long field2225;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2218 = var1.getX();
         field2217 = var1.getY();
         field2223 = class193.method3805();
         if(var1.isAltDown()) {
            field2215 = 4;
            field2209 = 4;
         } else if(var1.isMetaDown()) {
            field2215 = 2;
            field2209 = 2;
         } else {
            field2215 = 1;
            field2209 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2210 = -1;
         field2211 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2210 = var1.getX();
         field2211 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2210 = var1.getX();
         field2211 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2212) {
         field2209 = 0;
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2209 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != field2212) {
         field2221 = 0;
         field2210 = var1.getX();
         field2211 = var1.getY();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "-2016928261"
   )
   static void method3028(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field730 = (class12.field174 - client.field485) / 2;
         class33.field733 = class33.field730 + 202;
      }

      if(class33.field728) {
         class30.method663(var0, var1);
      } else {
         if(var3) {
            class189.field3054.method1798(class33.field730, 0);
            class141.field2199.method1798(class33.field730 + 382, 0);
            class30.field698.method1946(382 + class33.field730 - class30.field698.field1500 / 2, 18);
         }

         int var5;
         if(client.field280 == 0 || client.field280 == 5) {
            byte var4 = 20;
            var0.method4116("RuneScape is loading - please wait...", 180 + class33.field733, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1878(180 + class33.field733 - 152, var5, 304, 34, 9179409);
            class82.method1878(180 + class33.field733 - 151, var5 + 1, 302, 32, 0);
            class82.method1880(class33.field733 + 180 - 150, var5 + 2, class33.field747 * 3, 30, 9179409);
            class82.method1880(class33.field733 + 180 - 150 + class33.field747 * 3, 2 + var5, 300 - class33.field747 * 3, 30, 0);
            var0.method4116(class33.field746, 180 + class33.field733, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var10;
         String var11;
         int var12;
         char[] var13;
         int var14;
         short var25;
         int var26;
         short var27;
         if(client.field280 == 20) {
            class33.field745.method1946(class33.field733 + 180 - class33.field745.field1500 / 2, 271 - class33.field745.field1497 / 2);
            var25 = 211;
            var0.method4116(class33.field729, 180 + class33.field733, var25, 16776960, 0);
            var26 = var25 + 15;
            var0.method4116(class33.field738, 180 + class33.field733, var26, 16776960, 0);
            var26 += 15;
            var0.method4116(class33.field751, 180 + class33.field733, var26, 16776960, 0);
            var26 += 15;
            var26 += 10;
            if(class33.field759 != 4) {
               var0.method4099("Login: ", 180 + class33.field733 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class33.field758; var0.method4094(var6) > var27; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4099(class226.method4098(var6), class33.field733 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class33.field735;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4099(var8 + var11, class33.field733 + 180 - 108, var26, 16777215, 0);
               var26 += 15;
            }
         }

         int var16;
         int var18;
         int var19;
         int var21;
         if(client.field280 == 10 || client.field280 == 11) {
            class33.field745.method1946(class33.field733, 171);
            short var15;
            if(class33.field759 == 0) {
               var25 = 251;
               var0.method4116("Welcome to RuneScape", class33.field733 + 180, var25, 16776960, 0);
               var26 = var25 + 30;
               var5 = 180 + class33.field733 - 80;
               var15 = 291;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var0.method4106("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class33.field733 + 180;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var0.method4106("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.field759 == 1) {
               var0.method4116(class33.field748, class33.field733 + 180, 211, 16776960, 0);
               var25 = 236;
               var0.method4116(class33.field729, 180 + class33.field733, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4116(class33.field738, 180 + class33.field733, var26, 16777215, 0);
               var26 += 15;
               var0.method4116(class33.field751, 180 + class33.field733, var26, 16777215, 0);
               var26 += 15;
               var5 = class33.field733 + 180 - 80;
               var15 = 321;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var0.method4116("Continue", var5, 5 + var15, 16777215, 0);
               var5 = class33.field733 + 180 + 80;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var0.method4116("Cancel", var5, 5 + var15, 16777215, 0);
            } else if(class33.field759 == 2) {
               var25 = 211;
               var0.method4116(class33.field729, class33.field733 + 180, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4116(class33.field738, class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var0.method4116(class33.field751, class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var26 += 10;
               var0.method4099("Login: ", class33.field733 + 180 - 110, var26, 16777215, 0);
               var27 = 200;

               for(var6 = class33.field758; var0.method4094(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4099(class226.method4098(var6) + (class33.field754 == 0 & client.field282 % 40 < 20?class51.method1096(16776960) + "|":""), class33.field733 + 180 - 70, var26, 16777215, 0);
               var26 += 15;
               var8 = "Password: ";
               var10 = class33.field735;
               var12 = var10.length();
               var13 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var13[var14] = 42;
               }

               var11 = new String(var13);
               var0.method4099(var8 + var11 + (class33.field754 == 1 & client.field282 % 40 < 20?class51.method1096(16776960) + "|":""), 180 + class33.field733 - 108, var26, 16777215, 0);
               var26 += 15;
               var16 = 180 + class33.field733 - 80;
               short var30 = 321;
               class33.field731.method1946(var16 - 73, var30 - 20);
               var0.method4116("Login", var16, 5 + var30, 16777215, 0);
               var16 = class33.field733 + 180 + 80;
               class33.field731.method1946(var16 - 73, var30 - 20);
               var0.method4116("Cancel", var16, var30 + 5, 16777215, 0);
               var25 = 357;
               var1.method4116("Forgotten your password? <col=ffffff>Click here.", class33.field733 + 180, var25, 16776960, 0);
            } else if(class33.field759 == 3) {
               var25 = 201;
               var0.method4116("Invalid username or password.", class33.field733 + 180, var25, 16776960, 0);
               var26 = var25 + 20;
               var1.method4116("For accounts created after 24th November 2010, please use your", class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var1.method4116("email address to login. Otherwise please login with your username.", class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var5 = class33.field733 + 180;
               var15 = 276;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var2.method4116("Try again", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class33.field733;
               var15 = 326;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var2.method4116("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else if(class33.field759 == 4) {
               var0.method4116("Authenticator", 180 + class33.field733, 211, 16776960, 0);
               var25 = 236;
               var0.method4116(class33.field729, class33.field733 + 180, var25, 16777215, 0);
               var26 = var25 + 15;
               var0.method4116(class33.field738, 180 + class33.field733, var26, 16777215, 0);
               var26 += 15;
               var0.method4116(class33.field751, 180 + class33.field733, var26, 16777215, 0);
               var26 += 15;
               var6 = "PIN: ";
               var8 = class33.field760;
               var18 = var8.length();
               char[] var28 = new char[var18];

               for(var12 = 0; var12 < var18; ++var12) {
                  var28[var12] = 42;
               }

               String var9 = new String(var28);
               var0.method4099(var6 + var9 + (client.field282 % 40 < 20?class51.method1096(16776960) + "|":""), 180 + class33.field733 - 108, var26, 16777215, 0);
               var26 -= 8;
               var0.method4099("Trust this computer", 180 + class33.field733 - 9, var26, 16776960, 0);
               var26 += 15;
               var0.method4099("for 30 days: ", 180 + class33.field733 - 9, var26, 16776960, 0);
               var19 = 180 + class33.field733 - 9 + var0.method4094("for 30 days: ") + 15;
               var18 = var26 - var0.field3237;
               class83 var29;
               if(class33.field749) {
                  var29 = class30.field696;
               } else {
                  var29 = class33.field732;
               }

               var29.method1946(var19, var18);
               var26 += 15;
               var12 = 180 + class33.field733 - 80;
               short var20 = 321;
               class33.field731.method1946(var12 - 73, var20 - 20);
               var0.method4116("Continue", var12, 5 + var20, 16777215, 0);
               var12 = 80 + 180 + class33.field733;
               class33.field731.method1946(var12 - 73, var20 - 20);
               var0.method4116("Cancel", var12, 5 + var20, 16777215, 0);
               var1.method4116("<u=ff>Can\'t Log In?</u>", class33.field733 + 180, var20 + 36, 255, 0);
            } else if(class33.field759 == 5) {
               var0.method4116("Forgotten your password?", 180 + class33.field733, 201, 16776960, 0);
               var25 = 221;
               var2.method4116(class33.field729, 180 + class33.field733, var25, 16776960, 0);
               var26 = var25 + 15;
               var2.method4116(class33.field738, class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var2.method4116(class33.field751, 180 + class33.field733, var26, 16776960, 0);
               var26 += 15;
               var26 += 14;
               var0.method4099("Username/email: ", class33.field733 + 180 - 145, var26, 16777215, 0);
               var27 = 174;

               for(var6 = class33.field758; var0.method4094(var6) > var27; var6 = var6.substring(1)) {
                  ;
               }

               var0.method4099(class226.method4098(var6) + (client.field282 % 40 < 20?class51.method1096(16776960) + "|":""), 180 + class33.field733 - 34, var26, 16777215, 0);
               var26 += 15;
               var21 = class33.field733 + 180 - 80;
               short var22 = 321;
               class33.field731.method1946(var21 - 73, var22 - 20);
               var0.method4116("Recover", var21, 5 + var22, 16777215, 0);
               var21 = class33.field733 + 180 + 80;
               class33.field731.method1946(var21 - 73, var22 - 20);
               var0.method4116("Back", var21, var22 + 5, 16777215, 0);
            } else if(class33.field759 == 6) {
               var25 = 211;
               var0.method4116(class33.field729, 180 + class33.field733, var25, 16776960, 0);
               var26 = var25 + 15;
               var0.method4116(class33.field738, 180 + class33.field733, var26, 16776960, 0);
               var26 += 15;
               var0.method4116(class33.field751, class33.field733 + 180, var26, 16776960, 0);
               var26 += 15;
               var5 = 180 + class33.field733;
               var15 = 321;
               class33.field731.method1946(var5 - 73, var15 - 20);
               var0.method4116("Back", var5, 5 + var15, 16777215, 0);
            }
         }

         int var31;
         int var32;
         int var34;
         if(class33.field750 > 0) {
            var26 = class33.field750;
            var27 = 256;
            class33.field741 += 128 * var26;
            if(class33.field741 > class33.field739.length) {
               class33.field741 -= class33.field739.length;
               var31 = (int)(Math.random() * 12.0D);
               class137.method2923(class75.field1421[var31]);
            }

            var31 = 0;
            var21 = 128 * var26;
            var34 = (var27 - var26) * 128;

            for(var19 = 0; var19 < var34; ++var19) {
               var18 = class47.field1064[var31 + var21] - var26 * class33.field739[class33.field741 + var31 & class33.field739.length - 1] / 6;
               if(var18 < 0) {
                  var18 = 0;
               }

               class47.field1064[var31++] = var18;
            }

            for(var19 = var27 - var26; var19 < var27; ++var19) {
               var18 = 128 * var19;

               for(var16 = 0; var16 < 128; ++var16) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var16 > 10 && var16 < 118) {
                     class47.field1064[var18 + var16] = 255;
                  } else {
                     class47.field1064[var16 + var18] = 0;
                  }
               }
            }

            if(class33.field737 > 0) {
               class33.field737 -= var26 * 4;
            }

            if(class33.field752 > 0) {
               class33.field752 -= 4 * var26;
            }

            if(class33.field737 == 0 && class33.field752 == 0) {
               var19 = (int)(Math.random() * (double)(2000 / var26));
               if(var19 == 0) {
                  class33.field737 = 1024;
               }

               if(var19 == 1) {
                  class33.field752 = 1024;
               }
            }

            for(var19 = 0; var19 < var27 - var26; ++var19) {
               class33.field757[var19] = class33.field757[var26 + var19];
            }

            for(var19 = var27 - var26; var19 < var27; ++var19) {
               class33.field757[var19] = (int)(Math.sin((double)class33.field744 / 14.0D) * 16.0D + Math.sin((double)class33.field744 / 15.0D) * 14.0D + Math.sin((double)class33.field744 / 16.0D) * 12.0D);
               ++class33.field744;
            }

            class33.field742 += var26;
            var19 = (var26 + (client.field282 & 1)) / 2;
            if(var19 > 0) {
               for(var18 = 0; var18 < class33.field742 * 100; ++var18) {
                  var16 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class47.field1064[var16 + (var12 << 7)] = 192;
               }

               class33.field742 = 0;
               var18 = 0;

               label391:
               while(true) {
                  if(var18 >= var27) {
                     var18 = 0;

                     while(true) {
                        if(var18 >= 128) {
                           break label391;
                        }

                        var16 = 0;

                        for(var12 = -var19; var12 < var27; ++var12) {
                           var32 = 128 * var12;
                           if(var12 + var19 < var27) {
                              var16 += class33.field740[var32 + var18 + 128 * var19];
                           }

                           if(var12 - (var19 + 1) >= 0) {
                              var16 -= class33.field740[var18 + var32 - 128 * (var19 + 1)];
                           }

                           if(var12 >= 0) {
                              class47.field1064[var18 + var32] = var16 / (1 + var19 * 2);
                           }
                        }

                        ++var18;
                     }
                  }

                  var16 = 0;
                  var12 = 128 * var18;

                  for(var32 = -var19; var32 < 128; ++var32) {
                     if(var19 + var32 < 128) {
                        var16 += class47.field1064[var19 + var12 + var32];
                     }

                     if(var32 - (var19 + 1) >= 0) {
                        var16 -= class47.field1064[var12 + var32 - (1 + var19)];
                     }

                     if(var32 >= 0) {
                        class33.field740[var12 + var32] = var16 / (1 + var19 * 2);
                     }
                  }

                  ++var18;
               }
            }

            class33.field750 = 0;
         }

         var25 = 256;
         if(class33.field737 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field737 > 768) {
                  class132.field2104[var5] = class114.method2489(class33.field755[var5], class33.field736[var5], 1024 - class33.field737);
               } else if(class33.field737 > 256) {
                  class132.field2104[var5] = class33.field736[var5];
               } else {
                  class132.field2104[var5] = class114.method2489(class33.field736[var5], class33.field755[var5], 256 - class33.field737);
               }
            }
         } else if(class33.field752 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field752 > 768) {
                  class132.field2104[var5] = class114.method2489(class33.field755[var5], class98.field1694[var5], 1024 - class33.field752);
               } else if(class33.field752 > 256) {
                  class132.field2104[var5] = class98.field1694[var5];
               } else {
                  class132.field2104[var5] = class114.method2489(class98.field1694[var5], class33.field755[var5], 256 - class33.field752);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class132.field2104[var5] = class33.field755[var5];
            }
         }

         class82.method1875(class33.field730, 9, 128 + class33.field730, var25 + 7);
         class189.field3054.method1798(class33.field730, 0);
         class82.method1874();
         var5 = 0;
         var31 = class33.field730 + class78.field1454.field1468 * 9;

         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = class33.field757[var21] * (var25 - var21) / var25;
            var19 = 22 + var34;
            if(var19 < 0) {
               var19 = 0;
            }

            var5 += var19;

            for(var18 = var19; var18 < 128; ++var18) {
               var16 = class47.field1064[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var32 = 256 - var16;
                  var16 = class132.field2104[var16];
                  var14 = class78.field1454.field1467[var31];
                  class78.field1454.field1467[var31++] = ((var14 & 16711935) * var32 + var12 * (var16 & 16711935) & -16711936) + (var32 * (var14 & '\uff00') + (var16 & '\uff00') * var12 & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += var19 + class78.field1454.field1468 - 128;
         }

         class82.method1875(class33.field730 + 765 - 128, 9, 765 + class33.field730, 7 + var25);
         class141.field2199.method1798(382 + class33.field730, 0);
         class82.method1874();
         var5 = 0;
         var31 = class78.field1454.field1468 * 9 + 24 + 637 + class33.field730;

         for(var21 = 1; var21 < var25 - 1; ++var21) {
            var34 = class33.field757[var21] * (var25 - var21) / var25;
            var19 = 103 - var34;
            var31 += var34;

            for(var18 = 0; var18 < var19; ++var18) {
               var16 = class47.field1064[var5++];
               if(var16 != 0) {
                  var12 = var16;
                  var32 = 256 - var16;
                  var16 = class132.field2104[var16];
                  var14 = class78.field1454.field1467[var31];
                  class78.field1454.field1467[var31++] = ((var16 & 16711935) * var12 + (var14 & 16711935) * var32 & -16711936) + ((var14 & '\uff00') * var32 + (var16 & '\uff00') * var12 & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var19;
            var31 += class78.field1454.field1468 - var19 - var34;
         }

         class29.field684[class12.field162.field132?1:0].method1946(class33.field730 + 765 - 40, 463);
         if(client.field280 > 5 && client.field533 == 0) {
            if(class26.field639 != null) {
               var26 = class33.field730 + 5;
               var27 = 463;
               byte var33 = 100;
               byte var35 = 35;
               class26.field639.method1946(var26, var27);
               var0.method4116("World" + " " + client.field272, var26 + var33 / 2, var35 / 2 + var27 - 2, 16777215, 0);
               if(null != class224.field3228) {
                  var1.method4116("Loading...", var26 + var33 / 2, var35 / 2 + var27 + 12, 16777215, 0);
               } else {
                  var1.method4116("Click to switch", var33 / 2 + var26, var35 / 2 + var27 + 12, 16777215, 0);
               }
            } else {
               class26.field639 = class85.method1974(class42.field993, "sl_button", "");
            }
         }

         try {
            Graphics var23 = class112.field1965.getGraphics();
            class78.field1454.vmethod1959(var23, 0, 0);
         } catch (Exception var24) {
            class112.field1965.repaint();
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;III)Lclass227;",
      garbageValue = "-483172193"
   )
   public static class227 method3029(class170 var0, class170 var1, int var2, int var3) {
      if(!class33.method708(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3304(var2, var3);
         class227 var4;
         if(null == var5) {
            var4 = null;
         } else {
            class227 var6 = new class227(var5, class79.field1459, class79.field1460, class79.field1463, class117.field2021, class79.field1462, class10.field151);
            class18.method191();
            var4 = var6;
         }

         return var4;
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-535155050"
   )
   static final void method3030(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class122.method2739(var0)) {
         class51.method1095(class176.field2814[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
