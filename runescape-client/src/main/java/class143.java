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

@ObfuscatedName("eh")
public class class143 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("l")
   @Export("mouse")
   public static class143 field2202 = new class143();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 123866251
   )
   @Export("mouseIdleTicks")
   public static volatile int field2203 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -28568323
   )
   public static volatile int field2204 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -56094333
   )
   public static volatile int field2205 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1629012797
   )
   public static int field2206 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 154252767
   )
   public static int field2207 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -5066674797032795343L
   )
   public static long field2208 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -612917441
   )
   public static int field2209 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1814860957
   )
   public static volatile int field2210 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1539906261
   )
   public static volatile int field2211 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1718135847
   )
   public static volatile int field2212 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -7877901811282267279L
   )
   public static volatile long field2213 = 0L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -712580859
   )
   public static volatile int field2214 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1542061827
   )
   public static int field2215 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1744835287
   )
   public static int field2216 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 704447889
   )
   public static int field2217 = 0;

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2202 != null) {
         field2203 = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2202) {
         field2203 = 0;
         field2204 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2202 != null) {
         field2203 = 0;
         field2205 = -1;
         field2214 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field2202 != null) {
         field2203 = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2202) {
         field2204 = 0;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "23"
   )
   static final boolean method3111(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class122 var4 = new class122(var0);
      int var5 = -1;

      label81:
      while(true) {
         int var6 = var4.method2646();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2646();
               if(var9 == 0) {
                  continue label81;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2633() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class42 var15 = class160.method3312(var5);
                  if(var12 != 22 || !client.field301 || var15.field944 != 0 || var15.field998 == 1 || var15.field983) {
                     if(!var15.method857()) {
                        ++client.field493;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2646();
            if(var9 == 0) {
               break;
            }

            var4.method2633();
         }
      }
   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != field2202) {
         field2203 = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2202) {
         field2203 = 0;
         field2211 = var1.getX();
         field2212 = var1.getY();
         field2213 = class56.method1249();
         if(var1.isAltDown()) {
            field2210 = 4;
            field2204 = 4;
         } else if(var1.isMetaDown()) {
            field2210 = 2;
            field2204 = 2;
         } else {
            field2210 = 1;
            field2204 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZB)V",
      garbageValue = "1"
   )
   static void method3118(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field741 = (class189.field3056 - client.field508) / 2;
         class33.field777 = 202 + class33.field741;
      }

      byte var4;
      int var5;
      int var7;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      Graphics var23;
      int var29;
      int var31;
      int var32;
      int var33;
      if(class33.field772) {
         if(null == class32.field731) {
            class32.field731 = class54.method1167(client.field451, "sl_back", "");
         }

         if(null == class174.field2789) {
            class174.field2789 = class36.method773(client.field451, "sl_flags", "");
         }

         if(class33.field773 == null) {
            class33.field773 = class36.method773(client.field451, "sl_arrows", "");
         }

         if(class48.field1081 == null) {
            class48.field1081 = class36.method773(client.field451, "sl_stars", "");
         }

         class82.method1907(class33.field741, 23, 765, 480, 0);
         class82.method1892(class33.field741, 0, 125, 23, 12425273, 9135624);
         class82.method1892(125 + class33.field741, 0, 640, 23, 5197647, 2697513);
         var0.method4173("Select a world", class33.field741 + 62, 15, 0, -1);
         if(class48.field1081 != null) {
            class48.field1081[1].method1954(140 + class33.field741, 1);
            var1.method4170("Members only world", 152 + class33.field741, 10, 16777215, -1);
            class48.field1081[0].method1954(140 + class33.field741, 12);
            var1.method4170("Free world", 152 + class33.field741, 21, 16777215, -1);
         }

         if(null != class33.field773) {
            var29 = 280 + class33.field741;
            if(class27.field666[0] == 0 && class27.field665[0] == 0) {
               class33.field773[2].method1954(var29, 4);
            } else {
               class33.field773[0].method1954(var29, 4);
            }

            if(class27.field666[0] == 0 && class27.field665[0] == 1) {
               class33.field773[3].method1954(15 + var29, 4);
            } else {
               class33.field773[1].method1954(15 + var29, 4);
            }

            var0.method4170("World", var29 + 32, 17, 16777215, -1);
            var5 = class33.field741 + 390;
            if(class27.field666[0] == 1 && class27.field665[0] == 0) {
               class33.field773[2].method1954(var5, 4);
            } else {
               class33.field773[0].method1954(var5, 4);
            }

            if(class27.field666[0] == 1 && class27.field665[0] == 1) {
               class33.field773[3].method1954(15 + var5, 4);
            } else {
               class33.field773[1].method1954(15 + var5, 4);
            }

            var0.method4170("Players", 32 + var5, 17, 16777215, -1);
            var31 = 500 + class33.field741;
            if(class27.field666[0] == 2 && class27.field665[0] == 0) {
               class33.field773[2].method1954(var31, 4);
            } else {
               class33.field773[0].method1954(var31, 4);
            }

            if(class27.field666[0] == 2 && class27.field665[0] == 1) {
               class33.field773[3].method1954(var31 + 15, 4);
            } else {
               class33.field773[1].method1954(15 + var31, 4);
            }

            var0.method4170("Location", var31 + 32, 17, 16777215, -1);
            var7 = 610 + class33.field741;
            if(class27.field666[0] == 3 && class27.field665[0] == 0) {
               class33.field773[2].method1954(var7, 4);
            } else {
               class33.field773[0].method1954(var7, 4);
            }

            if(class27.field666[0] == 3 && class27.field665[0] == 1) {
               class33.field773[3].method1954(15 + var7, 4);
            } else {
               class33.field773[1].method1954(var7 + 15, 4);
            }

            var0.method4170("Type", var7 + 32, 17, 16777215, -1);
         }

         class82.method1907(708 + class33.field741, 4, 50, 16, 0);
         var1.method4173("Cancel", 708 + class33.field741 + 25, 16, 16777215, -1);
         class33.field743 = -1;
         if(null != class32.field731) {
            var4 = 88;
            byte var36 = 19;
            var31 = 765 / (1 + var4);
            var7 = 480 / (var36 + 1);

            do {
               var32 = var7;
               var33 = var31;
               if((var31 - 1) * var7 >= class27.field663) {
                  --var31;
               }

               if((var7 - 1) * var31 >= class27.field663) {
                  --var7;
               }

               if(var31 * (var7 - 1) >= class27.field663) {
                  --var7;
               }
            } while(var32 != var7 || var33 != var31);

            var32 = (765 - var31 * var4) / (var31 + 1);
            if(var32 > 5) {
               var32 = 5;
            }

            var33 = (480 - var7 * var36) / (var7 + 1);
            if(var33 > 5) {
               var33 = 5;
            }

            var10 = (765 - var31 * var4 - var32 * (var31 - 1)) / 2;
            var11 = (480 - var7 * var36 - var33 * (var7 - 1)) / 2;
            var12 = 23 + var11;
            var13 = var10 + class33.field741;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < class27.field663; ++var16) {
               class27 var17 = class27.field662[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.field669);
               if(var17.field669 == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.field669 > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method637()) {
                  if(var17.method632()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method636()) {
                  var21 = 16711680;
                  if(var17.method632()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method634()) {
                  if(var17.method632()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method632()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(field2206 >= var13 && field2209 >= var12 && field2206 < var13 + var4 && field2209 < var36 + var12 && var18) {
                  class33.field743 = var16;
                  class32.field731[var20].method1810(var13, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class32.field731[var20].method1851(var13, var12);
               }

               if(null != class174.field2789) {
                  class174.field2789[(var17.method632()?8:0) + var17.field672].method1954(var13 + 29, var12);
               }

               var0.method4173(Integer.toString(var17.field667), 15 + var13, 5 + var36 / 2 + var12, var21, -1);
               var1.method4173(var19, var13 + 60, 5 + var36 / 2 + var12, 268435455, -1);
               var12 += var33 + var36;
               ++var14;
               if(var14 >= var7) {
                  var12 = 23 + var11;
                  var13 += var4 + var32;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4165(class27.field662[class33.field743].field680) + 6;
               int var22 = 8 + var1.field3235;
               class82.method1907(field2206 - var16 / 2, 20 + field2209 + 5, var16, var22, 16777120);
               class82.method1893(field2206 - var16 / 2, field2209 + 20 + 5, var16, var22, 0);
               var1.method4173(class27.field662[class33.field743].field680, field2206, 4 + var1.field3235 + field2209 + 20 + 5, 0, -1);
            }
         }

         try {
            var23 = class107.field1867.getGraphics();
            class54.field1173.vmethod1965(var23, 0, 0);
         } catch (Exception var26) {
            class107.field1867.repaint();
         }

      } else {
         if(var3) {
            class33.field745.method1851(class33.field741, 0);
            class33.field746.method1851(382 + class33.field741, 0);
            class106.field1847.method1954(382 + class33.field741 - class106.field1847.field1498 / 2, 18);
         }

         if(client.field303 == 0 || client.field303 == 5) {
            var4 = 20;
            var0.method4173("RuneScape is loading - please wait...", class33.field777 + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1893(class33.field777 + 180 - 152, var5, 304, 34, 9179409);
            class82.method1893(180 + class33.field777 - 151, var5 + 1, 302, 32, 0);
            class82.method1907(class33.field777 + 180 - 150, var5 + 2, class33.field757 * 3, 30, 9179409);
            class82.method1907(class33.field757 * 3 + (180 + class33.field777 - 150), var5 + 2, 300 - class33.field757 * 3, 30, 0);
            var0.method4173(class33.field758, class33.field777 + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         short var28;
         short var30;
         if(client.field303 == 20) {
            class33.field760.method1954(class33.field777 + 180 - class33.field760.field1498 / 2, 271 - class33.field760.field1503 / 2);
            var28 = 211;
            var0.method4173(class33.field748, class33.field777 + 180, var28, 16776960, 0);
            var29 = var28 + 15;
            var0.method4173(class33.field762, class33.field777 + 180, var29, 16776960, 0);
            var29 += 15;
            var0.method4173(class33.field755, 180 + class33.field777, var29, 16776960, 0);
            var29 += 15;
            var29 += 10;
            if(class33.field761 != 4) {
               var0.method4170("Login: ", 180 + class33.field777 - 110, var29, 16777215, 0);
               var30 = 200;

               for(var24 = class33.field764; var0.method4165(var24) > var30; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method4170(class226.method4169(var24), class33.field777 + 180 - 70, var29, 16777215, 0);
               var29 += 15;
               var0.method4170("Password: " + class138.method3018(class33.field765), class33.field777 + 180 - 108, var29, 16777215, 0);
               var29 += 15;
            }
         }

         if(client.field303 == 10 || client.field303 == 11) {
            class33.field760.method1954(class33.field777, 171);
            short var6;
            if(class33.field761 == 0) {
               var28 = 251;
               var0.method4173("Welcome to RuneScape", class33.field777 + 180, var28, 16776960, 0);
               var29 = var28 + 30;
               var5 = 180 + class33.field777 - 80;
               var6 = 291;
               class33.field763.method1954(var5 - 73, var6 - 20);
               var0.method4174("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class33.field777;
               class33.field763.method1954(var5 - 73, var6 - 20);
               var0.method4174("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.field761 == 1) {
               var0.method4173(class33.field740, class33.field777 + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method4173(class33.field748, class33.field777 + 180, var28, 16777215, 0);
               var29 = var28 + 15;
               var0.method4173(class33.field762, 180 + class33.field777, var29, 16777215, 0);
               var29 += 15;
               var0.method4173(class33.field755, class33.field777 + 180, var29, 16777215, 0);
               var29 += 15;
               var5 = 180 + class33.field777 - 80;
               var6 = 321;
               class33.field763.method1954(var5 - 73, var6 - 20);
               var0.method4173("Continue", var5, 5 + var6, 16777215, 0);
               var5 = 180 + class33.field777 + 80;
               class33.field763.method1954(var5 - 73, var6 - 20);
               var0.method4173("Cancel", var5, 5 + var6, 16777215, 0);
            } else {
               short var8;
               if(class33.field761 == 2) {
                  var28 = 211;
                  var0.method4173(class33.field748, 180 + class33.field777, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4173(class33.field762, class33.field777 + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4173(class33.field755, 180 + class33.field777, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 10;
                  var0.method4170("Login: ", 180 + class33.field777 - 110, var29, 16777215, 0);
                  var30 = 200;

                  for(var24 = class33.field764; var0.method4165(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4170(class226.method4169(var24) + (class33.field769 == 0 & client.field305 % 40 < 20?class16.method205(16776960) + "|":""), class33.field777 + 180 - 70, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4170("Password: " + class138.method3018(class33.field765) + (class33.field769 == 1 & client.field305 % 40 < 20?class16.method205(16776960) + "|":""), 180 + class33.field777 - 108, var29, 16777215, 0);
                  var29 += 15;
                  var7 = class33.field777 + 180 - 80;
                  var8 = 321;
                  class33.field763.method1954(var7 - 73, var8 - 20);
                  var0.method4173("Login", var7, var8 + 5, 16777215, 0);
                  var7 = 80 + 180 + class33.field777;
                  class33.field763.method1954(var7 - 73, var8 - 20);
                  var0.method4173("Cancel", var7, var8 + 5, 16777215, 0);
                  var28 = 357;
                  var1.method4173("Forgotten your password? <col=ffffff>Click here.", 180 + class33.field777, var28, 16776960, 0);
               } else if(class33.field761 == 3) {
                  var28 = 201;
                  var0.method4173("Invalid username or password.", class33.field777 + 180, var28, 16776960, 0);
                  var29 = var28 + 20;
                  var1.method4173("For accounts created after 24th November 2010, please use your", class33.field777 + 180, var29, 16776960, 0);
                  var29 += 15;
                  var1.method4173("email address to login. Otherwise please login with your username.", class33.field777 + 180, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class33.field777;
                  var6 = 276;
                  class33.field763.method1954(var5 - 73, var6 - 20);
                  var2.method4173("Try again", var5, 5 + var6, 16777215, 0);
                  var5 = 180 + class33.field777;
                  var6 = 326;
                  class33.field763.method1954(var5 - 73, var6 - 20);
                  var2.method4173("Forgotten password?", var5, 5 + var6, 16777215, 0);
               } else if(class33.field761 == 4) {
                  var0.method4173("Authenticator", 180 + class33.field777, 211, 16776960, 0);
                  var28 = 236;
                  var0.method4173(class33.field748, 180 + class33.field777, var28, 16777215, 0);
                  var29 = var28 + 15;
                  var0.method4173(class33.field762, class33.field777 + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4173(class33.field755, class33.field777 + 180, var29, 16777215, 0);
                  var29 += 15;
                  var0.method4170("PIN: " + class138.method3018(class33.field767) + (client.field305 % 40 < 20?class16.method205(16776960) + "|":""), 180 + class33.field777 - 108, var29, 16777215, 0);
                  var29 -= 8;
                  var0.method4170("Trust this computer", 180 + class33.field777 - 9, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4170("for 30 days: ", 180 + class33.field777 - 9, var29, 16776960, 0);
                  var5 = class33.field777 + 180 - 9 + var0.method4165("for 30 days: ") + 15;
                  var31 = var29 - var0.field3235;
                  class83 var25;
                  if(class33.field768) {
                     var25 = class22.field596;
                  } else {
                     var25 = class47.field1075;
                  }

                  var25.method1954(var5, var31);
                  var29 += 15;
                  var32 = 180 + class33.field777 - 80;
                  short var9 = 321;
                  class33.field763.method1954(var32 - 73, var9 - 20);
                  var0.method4173("Continue", var32, var9 + 5, 16777215, 0);
                  var32 = 80 + 180 + class33.field777;
                  class33.field763.method1954(var32 - 73, var9 - 20);
                  var0.method4173("Cancel", var32, var9 + 5, 16777215, 0);
                  var1.method4173("<u=ff>Can\'t Log In?</u>", class33.field777 + 180, var9 + 36, 255, 0);
               } else if(class33.field761 == 5) {
                  var0.method4173("Forgotten your password?", 180 + class33.field777, 201, 16776960, 0);
                  var28 = 221;
                  var2.method4173(class33.field748, class33.field777 + 180, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var2.method4173(class33.field762, class33.field777 + 180, var29, 16776960, 0);
                  var29 += 15;
                  var2.method4173(class33.field755, 180 + class33.field777, var29, 16776960, 0);
                  var29 += 15;
                  var29 += 14;
                  var0.method4170("Username/email: ", class33.field777 + 180 - 145, var29, 16777215, 0);
                  var30 = 174;

                  for(var24 = class33.field764; var0.method4165(var24) > var30; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method4170(class226.method4169(var24) + (client.field305 % 40 < 20?class16.method205(16776960) + "|":""), class33.field777 + 180 - 34, var29, 16777215, 0);
                  var29 += 15;
                  var7 = 180 + class33.field777 - 80;
                  var8 = 321;
                  class33.field763.method1954(var7 - 73, var8 - 20);
                  var0.method4173("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class33.field777 + 180 + 80;
                  class33.field763.method1954(var7 - 73, var8 - 20);
                  var0.method4173("Back", var7, 5 + var8, 16777215, 0);
               } else if(class33.field761 == 6) {
                  var28 = 211;
                  var0.method4173(class33.field748, 180 + class33.field777, var28, 16776960, 0);
                  var29 = var28 + 15;
                  var0.method4173(class33.field762, class33.field777 + 180, var29, 16776960, 0);
                  var29 += 15;
                  var0.method4173(class33.field755, 180 + class33.field777, var29, 16776960, 0);
                  var29 += 15;
                  var5 = 180 + class33.field777;
                  var6 = 321;
                  class33.field763.method1954(var5 - 73, var6 - 20);
                  var0.method4173("Back", var5, var6 + 5, 16777215, 0);
               }
            }
         }

         if(class33.field775 > 0) {
            class12.method171(class33.field775);
            class33.field775 = 0;
         }

         var28 = 256;
         if(class33.field749 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field749 > 768) {
                  class138.field2141[var5] = class140.method3052(class153.field2310[var5], class18.field269[var5], 1024 - class33.field749);
               } else if(class33.field749 > 256) {
                  class138.field2141[var5] = class18.field269[var5];
               } else {
                  class138.field2141[var5] = class140.method3052(class18.field269[var5], class153.field2310[var5], 256 - class33.field749);
               }
            }
         } else if(class33.field752 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field752 > 768) {
                  class138.field2141[var5] = class140.method3052(class153.field2310[var5], class33.field750[var5], 1024 - class33.field752);
               } else if(class33.field752 > 256) {
                  class138.field2141[var5] = class33.field750[var5];
               } else {
                  class138.field2141[var5] = class140.method3052(class33.field750[var5], class153.field2310[var5], 256 - class33.field752);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class138.field2141[var5] = class153.field2310[var5];
            }
         }

         class82.method1908(class33.field741, 9, class33.field741 + 128, var28 + 7);
         class33.field745.method1851(class33.field741, 0);
         class82.method1880();
         var5 = 0;
         var31 = class54.field1173.field1470 * 9 + class33.field741;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var32 = class33.field742[var7] * (var28 - var7) / var28;
            var33 = var32 + 22;
            if(var33 < 0) {
               var33 = 0;
            }

            var5 += var33;

            for(var10 = var33; var10 < 128; ++var10) {
               var11 = class29.field699[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class138.field2141[var11];
                  var14 = class54.field1173.field1474[var31];
                  class54.field1173.field1474[var31++] = (var13 * (var14 & 16711935) + var12 * (var11 & 16711935) & -16711936) + (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var31;
               }
            }

            var31 += class54.field1173.field1470 + var33 - 128;
         }

         class82.method1908(765 + class33.field741 - 128, 9, class33.field741 + 765, 7 + var28);
         class33.field746.method1851(class33.field741 + 382, 0);
         class82.method1880();
         var5 = 0;
         var31 = class33.field741 + 637 + class54.field1173.field1470 * 9 + 24;

         for(var7 = 1; var7 < var28 - 1; ++var7) {
            var32 = class33.field742[var7] * (var28 - var7) / var28;
            var33 = 103 - var32;
            var31 += var32;

            for(var10 = 0; var10 < var33; ++var10) {
               var11 = class29.field699[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class138.field2141[var11];
                  var14 = class54.field1173.field1474[var31];
                  class54.field1173.field1474[var31++] = ((var14 & '\uff00') * var13 + var12 * (var11 & '\uff00') & 16711680) + (var13 * (var14 & 16711935) + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var31;
               }
            }

            var5 += 128 - var33;
            var31 += class54.field1173.field1470 - var33 - var32;
         }

         class33.field747[class136.field2123.field148?1:0].method1954(class33.field741 + 765 - 40, 463);
         if(client.field303 > 5 && client.field326 == 0) {
            if(null != class33.field774) {
               var29 = class33.field741 + 5;
               var30 = 463;
               byte var35 = 100;
               byte var34 = 35;
               class33.field774.method1954(var29, var30);
               var0.method4173("World" + " " + client.field407, var35 / 2 + var29, var34 / 2 + var30 - 2, 16777215, 0);
               if(null != class117.field2027) {
                  var1.method4173("Loading...", var35 / 2 + var29, 12 + var34 / 2 + var30, 16777215, 0);
               } else {
                  var1.method4173("Click to switch", var35 / 2 + var29, 12 + var30 + var34 / 2, 16777215, 0);
               }
            } else {
               class33.field774 = class137.method3010(client.field451, "sl_button", "");
            }
         }

         try {
            var23 = class107.field1867.getGraphics();
            class54.field1173.vmethod1965(var23, 0, 0);
         } catch (Exception var27) {
            class107.field1867.repaint();
         }

      }
   }
}
