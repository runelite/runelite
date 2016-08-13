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
   public static class143 mouse = new class143();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 123866251
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
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
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
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
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2205 = -1;
         field2214 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != mouse) {
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
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label71:
      while(true) {
         int var6 = var4.method2646();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var12;
            ObjectComposition var15;
            do {
               int var13;
               int var14;
               do {
                  do {
                     do {
                        do {
                           int var9;
                           while(var8) {
                              var9 = var4.method2646();
                              if(var9 == 0) {
                                 continue label71;
                              }

                              var4.method2633();
                           }

                           var9 = var4.method2646();
                           if(var9 == 0) {
                              continue label71;
                           }

                           var7 += var9 - 1;
                           int var10 = var7 & 63;
                           int var11 = var7 >> 6 & 63;
                           var12 = var4.method2633() >> 2;
                           var13 = var11 + var1;
                           var14 = var10 + var2;
                        } while(var13 <= 0);
                     } while(var14 <= 0);
                  } while(var13 >= 103);
               } while(var14 >= 103);

               var15 = class160.getObjectDefinition(var5);
            } while(var12 == 22 && Client.field301 && var15.field944 == 0 && var15.field998 != 1 && !var15.field983);

            if(!var15.method857()) {
               ++Client.field493;
               var3 = false;
            }

            var8 = true;
         }
      }
   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field2205 = var1.getX();
         field2214 = var1.getY();
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
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
         class33.field741 = (class189.field3056 - Client.field508) / 2;
         class33.loginWindowX = 202 + class33.field741;
      }

      byte var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      Graphics var12;
      int var13;
      int var14;
      int var15;
      int var16;
      if(class33.worldSelectShown) {
         if(null == class32.field731) {
            class32.field731 = class54.method1167(Client.field451, "sl_back", "");
         }

         if(null == class174.field2789) {
            class174.field2789 = NPC.method773(Client.field451, "sl_flags", "");
         }

         if(class33.field773 == null) {
            class33.field773 = NPC.method773(Client.field451, "sl_arrows", "");
         }

         if(class48.field1081 == null) {
            class48.field1081 = NPC.method773(Client.field451, "sl_stars", "");
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
            var13 = 280 + class33.field741;
            if(World.field666[0] == 0 && World.field665[0] == 0) {
               class33.field773[2].method1954(var13, 4);
            } else {
               class33.field773[0].method1954(var13, 4);
            }

            if(World.field666[0] == 0 && World.field665[0] == 1) {
               class33.field773[3].method1954(15 + var13, 4);
            } else {
               class33.field773[1].method1954(15 + var13, 4);
            }

            var0.method4170("World", var13 + 32, 17, 16777215, -1);
            var5 = class33.field741 + 390;
            if(World.field666[0] == 1 && World.field665[0] == 0) {
               class33.field773[2].method1954(var5, 4);
            } else {
               class33.field773[0].method1954(var5, 4);
            }

            if(World.field666[0] == 1 && World.field665[0] == 1) {
               class33.field773[3].method1954(15 + var5, 4);
            } else {
               class33.field773[1].method1954(15 + var5, 4);
            }

            var0.method4170("Players", 32 + var5, 17, 16777215, -1);
            var14 = 500 + class33.field741;
            if(World.field666[0] == 2 && World.field665[0] == 0) {
               class33.field773[2].method1954(var14, 4);
            } else {
               class33.field773[0].method1954(var14, 4);
            }

            if(World.field666[0] == 2 && World.field665[0] == 1) {
               class33.field773[3].method1954(var14 + 15, 4);
            } else {
               class33.field773[1].method1954(15 + var14, 4);
            }

            var0.method4170("Location", var14 + 32, 17, 16777215, -1);
            var6 = 610 + class33.field741;
            if(World.field666[0] == 3 && World.field665[0] == 0) {
               class33.field773[2].method1954(var6, 4);
            } else {
               class33.field773[0].method1954(var6, 4);
            }

            if(World.field666[0] == 3 && World.field665[0] == 1) {
               class33.field773[3].method1954(15 + var6, 4);
            } else {
               class33.field773[1].method1954(var6 + 15, 4);
            }

            var0.method4170("Type", var6 + 32, 17, 16777215, -1);
         }

         class82.method1907(708 + class33.field741, 4, 50, 16, 0);
         var1.method4173("Cancel", 708 + class33.field741 + 25, 16, 16777215, -1);
         class33.field743 = -1;
         if(null != class32.field731) {
            var4 = 88;
            byte var17 = 19;
            var14 = 765 / (1 + var4);
            var6 = 480 / (var17 + 1);

            while(true) {
               var15 = var6;
               var16 = var14;
               if((var14 - 1) * var6 >= World.field663) {
                  --var14;
               }

               if((var6 - 1) * var14 >= World.field663) {
                  --var6;
               }

               if(var14 * (var6 - 1) >= World.field663) {
                  --var6;
               }

               if(var15 == var6 && var16 == var14) {
                  var15 = (765 - var14 * var4) / (var14 + 1);
                  if(var15 > 5) {
                     var15 = 5;
                  }

                  var16 = (480 - var6 * var17) / (var6 + 1);
                  if(var16 > 5) {
                     var16 = 5;
                  }

                  var7 = (765 - var14 * var4 - var15 * (var14 - 1)) / 2;
                  var8 = (480 - var6 * var17 - var16 * (var6 - 1)) / 2;
                  var9 = 23 + var8;
                  var10 = var7 + class33.field741;
                  var11 = 0;
                  boolean var18 = false;

                  int var19;
                  for(var19 = 0; var19 < World.field663; ++var19) {
                     World var20 = World.worldList[var19];
                     boolean var21 = true;
                     String var22 = Integer.toString(var20.playerCount);
                     if(var20.playerCount == -1) {
                        var22 = "OFF";
                        var21 = false;
                     } else if(var20.playerCount > 1980) {
                        var22 = "FULL";
                        var21 = false;
                     }

                     int var23 = 0;
                     byte var24;
                     if(var20.method637()) {
                        if(var20.method632()) {
                           var24 = 7;
                        } else {
                           var24 = 6;
                        }
                     } else if(var20.method636()) {
                        var23 = 16711680;
                        if(var20.method632()) {
                           var24 = 5;
                        } else {
                           var24 = 4;
                        }
                     } else if(var20.method634()) {
                        if(var20.method632()) {
                           var24 = 3;
                        } else {
                           var24 = 2;
                        }
                     } else if(var20.method632()) {
                        var24 = 1;
                     } else {
                        var24 = 0;
                     }

                     if(field2206 >= var10 && field2209 >= var9 && field2206 < var10 + var4 && field2209 < var17 + var9 && var21) {
                        class33.field743 = var19;
                        class32.field731[var24].method1810(var10, var9, 128, 16777215);
                        var18 = true;
                     } else {
                        class32.field731[var24].method1851(var10, var9);
                     }

                     if(null != class174.field2789) {
                        class174.field2789[(var20.method632()?8:0) + var20.location].method1954(var10 + 29, var9);
                     }

                     var0.method4173(Integer.toString(var20.id), 15 + var10, 5 + var17 / 2 + var9, var23, -1);
                     var1.method4173(var22, var10 + 60, 5 + var17 / 2 + var9, 268435455, -1);
                     var9 += var16 + var17;
                     ++var11;
                     if(var11 >= var6) {
                        var9 = 23 + var8;
                        var10 += var4 + var15;
                        var11 = 0;
                     }
                  }

                  if(var18) {
                     var19 = var1.method4165(World.worldList[class33.field743].activity) + 6;
                     int var30 = 8 + var1.field3235;
                     class82.method1907(field2206 - var19 / 2, 20 + field2209 + 5, var19, var30, 16777120);
                     class82.method1893(field2206 - var19 / 2, field2209 + 20 + 5, var19, var30, 0);
                     var1.method4173(World.worldList[class33.field743].activity, field2206, 4 + var1.field3235 + field2209 + 20 + 5, 0, -1);
                  }
                  break;
               }
            }
         }

         try {
            var12 = class107.canvas.getGraphics();
            class54.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var26) {
            class107.canvas.repaint();
         }
      } else {
         if(var3) {
            class33.field745.method1851(class33.field741, 0);
            class33.field746.method1851(382 + class33.field741, 0);
            Frames.field1847.method1954(382 + class33.field741 - Frames.field1847.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4173("RuneScape is loading - please wait...", class33.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1893(class33.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            class82.method1893(180 + class33.loginWindowX - 151, var5 + 1, 302, 32, 0);
            class82.method1907(class33.loginWindowX + 180 - 150, var5 + 2, class33.field757 * 3, 30, 9179409);
            class82.method1907(class33.field757 * 3 + (180 + class33.loginWindowX - 150), var5 + 2, 300 - class33.field757 * 3, 30, 0);
            var0.method4173(class33.field758, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var27;
         short var28;
         short var29;
         if(Client.gameState == 20) {
            class33.field760.method1954(class33.loginWindowX + 180 - class33.field760.originalWidth / 2, 271 - class33.field760.height / 2);
            var28 = 211;
            var0.method4173(class33.loginMessage1, class33.loginWindowX + 180, var28, 16776960, 0);
            var13 = var28 + 15;
            var0.method4173(class33.loginMessage2, class33.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var0.method4173(class33.loginMessage3, 180 + class33.loginWindowX, var13, 16776960, 0);
            var13 += 15;
            var13 += 10;
            if(class33.loginIndex != 4) {
               var0.method4170("Login: ", 180 + class33.loginWindowX - 110, var13, 16777215, 0);
               var29 = 200;

               for(var27 = class33.username; var0.method4165(var27) > var29; var27 = var27.substring(0, var27.length() - 1)) {
                  ;
               }

               var0.method4170(class226.method4169(var27), class33.loginWindowX + 180 - 70, var13, 16777215, 0);
               var13 += 15;
               var0.method4170("Password: " + class138.method3018(class33.field765), class33.loginWindowX + 180 - 108, var13, 16777215, 0);
               var13 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class33.field760.method1954(class33.loginWindowX, 171);
            short var31;
            if(class33.loginIndex == 0) {
               var28 = 251;
               var0.method4173("Welcome to RuneScape", class33.loginWindowX + 180, var28, 16776960, 0);
               var13 = var28 + 30;
               var5 = 180 + class33.loginWindowX - 80;
               var31 = 291;
               class33.field763.method1954(var5 - 73, var31 - 20);
               var0.method4174("New User", var5 - 73, var31 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 260 + class33.loginWindowX;
               class33.field763.method1954(var5 - 73, var31 - 20);
               var0.method4174("Existing User", var5 - 73, var31 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4173(class33.field740, class33.loginWindowX + 180, 211, 16776960, 0);
               var28 = 236;
               var0.method4173(class33.loginMessage1, class33.loginWindowX + 180, var28, 16777215, 0);
               var13 = var28 + 15;
               var0.method4173(class33.loginMessage2, 180 + class33.loginWindowX, var13, 16777215, 0);
               var13 += 15;
               var0.method4173(class33.loginMessage3, class33.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var5 = 180 + class33.loginWindowX - 80;
               var31 = 321;
               class33.field763.method1954(var5 - 73, var31 - 20);
               var0.method4173("Continue", var5, 5 + var31, 16777215, 0);
               var5 = 180 + class33.loginWindowX + 80;
               class33.field763.method1954(var5 - 73, var31 - 20);
               var0.method4173("Cancel", var5, 5 + var31, 16777215, 0);
            } else {
               short var32;
               if(class33.loginIndex == 2) {
                  var28 = 211;
                  var0.method4173(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16776960, 0);
                  var13 = var28 + 15;
                  var0.method4173(class33.loginMessage2, class33.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var0.method4173(class33.loginMessage3, 180 + class33.loginWindowX, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 10;
                  var0.method4170("Login: ", 180 + class33.loginWindowX - 110, var13, 16777215, 0);
                  var29 = 200;

                  for(var27 = class33.username; var0.method4165(var27) > var29; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.method4170(class226.method4169(var27) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class16.method205(16776960) + "|":""), class33.loginWindowX + 180 - 70, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4170("Password: " + class138.method3018(class33.field765) + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class16.method205(16776960) + "|":""), 180 + class33.loginWindowX - 108, var13, 16777215, 0);
                  var13 += 15;
                  var6 = class33.loginWindowX + 180 - 80;
                  var32 = 321;
                  class33.field763.method1954(var6 - 73, var32 - 20);
                  var0.method4173("Login", var6, var32 + 5, 16777215, 0);
                  var6 = 260 + class33.loginWindowX;
                  class33.field763.method1954(var6 - 73, var32 - 20);
                  var0.method4173("Cancel", var6, var32 + 5, 16777215, 0);
                  var28 = 357;
                  var1.method4173("Forgotten your password? <col=ffffff>Click here.", 180 + class33.loginWindowX, var28, 16776960, 0);
               } else if(class33.loginIndex == 3) {
                  var28 = 201;
                  var0.method4173("Invalid username or password.", class33.loginWindowX + 180, var28, 16776960, 0);
                  var13 = var28 + 20;
                  var1.method4173("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var1.method4173("email address to login. Otherwise please login with your username.", class33.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var31 = 276;
                  class33.field763.method1954(var5 - 73, var31 - 20);
                  var2.method4173("Try again", var5, 5 + var31, 16777215, 0);
                  var5 = 180 + class33.loginWindowX;
                  var31 = 326;
                  class33.field763.method1954(var5 - 73, var31 - 20);
                  var2.method4173("Forgotten password?", var5, 5 + var31, 16777215, 0);
               } else if(class33.loginIndex == 4) {
                  var0.method4173("Authenticator", 180 + class33.loginWindowX, 211, 16776960, 0);
                  var28 = 236;
                  var0.method4173(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16777215, 0);
                  var13 = var28 + 15;
                  var0.method4173(class33.loginMessage2, class33.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4173(class33.loginMessage3, class33.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4170("PIN: " + class138.method3018(class33.authCode) + (Client.gameCycle % 40 < 20?class16.method205(16776960) + "|":""), 180 + class33.loginWindowX - 108, var13, 16777215, 0);
                  var13 -= 8;
                  var0.method4170("Trust this computer", 180 + class33.loginWindowX - 9, var13, 16776960, 0);
                  var13 += 15;
                  var0.method4170("for 30 days: ", 180 + class33.loginWindowX - 9, var13, 16776960, 0);
                  var5 = class33.loginWindowX + 180 - 9 + var0.method4165("for 30 days: ") + 15;
                  var14 = var13 - var0.field3235;
                  ModIcon var35;
                  if(class33.field768) {
                     var35 = class22.field596;
                  } else {
                     var35 = class47.field1075;
                  }

                  var35.method1954(var5, var14);
                  var13 += 15;
                  var15 = 180 + class33.loginWindowX - 80;
                  short var36 = 321;
                  class33.field763.method1954(var15 - 73, var36 - 20);
                  var0.method4173("Continue", var15, var36 + 5, 16777215, 0);
                  var15 = 260 + class33.loginWindowX;
                  class33.field763.method1954(var15 - 73, var36 - 20);
                  var0.method4173("Cancel", var15, var36 + 5, 16777215, 0);
                  var1.method4173("<u=ff>Can\'t Log In?</u>", class33.loginWindowX + 180, var36 + 36, 255, 0);
               } else if(class33.loginIndex != 5) {
                  if(class33.loginIndex == 6) {
                     var28 = 211;
                     var0.method4173(class33.loginMessage1, 180 + class33.loginWindowX, var28, 16776960, 0);
                     var13 = var28 + 15;
                     var0.method4173(class33.loginMessage2, class33.loginWindowX + 180, var13, 16776960, 0);
                     var13 += 15;
                     var0.method4173(class33.loginMessage3, 180 + class33.loginWindowX, var13, 16776960, 0);
                     var13 += 15;
                     var5 = 180 + class33.loginWindowX;
                     var31 = 321;
                     class33.field763.method1954(var5 - 73, var31 - 20);
                     var0.method4173("Back", var5, var31 + 5, 16777215, 0);
                  }
               } else {
                  var0.method4173("Forgotten your password?", 180 + class33.loginWindowX, 201, 16776960, 0);
                  var28 = 221;
                  var2.method4173(class33.loginMessage1, class33.loginWindowX + 180, var28, 16776960, 0);
                  var13 = var28 + 15;
                  var2.method4173(class33.loginMessage2, class33.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var2.method4173(class33.loginMessage3, 180 + class33.loginWindowX, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 14;
                  var0.method4170("Username/email: ", class33.loginWindowX + 180 - 145, var13, 16777215, 0);
                  var29 = 174;

                  for(var27 = class33.username; var0.method4165(var27) > var29; var27 = var27.substring(1)) {
                     ;
                  }

                  var0.method4170(class226.method4169(var27) + (Client.gameCycle % 40 < 20?class16.method205(16776960) + "|":""), class33.loginWindowX + 180 - 34, var13, 16777215, 0);
                  var13 += 15;
                  var6 = 180 + class33.loginWindowX - 80;
                  var32 = 321;
                  class33.field763.method1954(var6 - 73, var32 - 20);
                  var0.method4173("Recover", var6, var32 + 5, 16777215, 0);
                  var6 = class33.loginWindowX + 180 + 80;
                  class33.field763.method1954(var6 - 73, var32 - 20);
                  var0.method4173("Back", var6, 5 + var32, 16777215, 0);
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
         var14 = class54.bufferProvider.width * 9 + class33.field741;

         for(var6 = 1; var6 < var28 - 1; ++var6) {
            var15 = class33.field742[var6] * (var28 - var6) / var28;
            var16 = var15 + 22;
            if(var16 < 0) {
               var16 = 0;
            }

            var5 += var16;

            for(var7 = var16; var7 < 128; ++var7) {
               var8 = ChatLineBuffer.field699[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = class138.field2141[var8];
                  var11 = class54.bufferProvider.pixels[var14];
                  class54.bufferProvider.pixels[var14++] = (var10 * (var11 & 16711935) + var9 * (var8 & 16711935) & -16711936) + (var9 * (var8 & '\uff00') + var10 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var14;
               }
            }

            var14 += class54.bufferProvider.width + var16 - 128;
         }

         class82.method1908(765 + class33.field741 - 128, 9, class33.field741 + 765, 7 + var28);
         class33.field746.method1851(class33.field741 + 382, 0);
         class82.method1880();
         var5 = 0;
         var14 = class33.field741 + 637 + class54.bufferProvider.width * 9 + 24;

         for(var6 = 1; var6 < var28 - 1; ++var6) {
            var15 = class33.field742[var6] * (var28 - var6) / var28;
            var16 = 103 - var15;
            var14 += var15;

            for(var7 = 0; var7 < var16; ++var7) {
               var8 = ChatLineBuffer.field699[var5++];
               if(var8 != 0) {
                  var9 = var8;
                  var10 = 256 - var8;
                  var8 = class138.field2141[var8];
                  var11 = class54.bufferProvider.pixels[var14];
                  class54.bufferProvider.pixels[var14++] = ((var11 & '\uff00') * var10 + var9 * (var8 & '\uff00') & 16711680) + (var10 * (var11 & 16711935) + (var8 & 16711935) * var9 & -16711936) >> 8;
               } else {
                  ++var14;
               }
            }

            var5 += 128 - var16;
            var14 += class54.bufferProvider.width - var16 - var15;
         }

         class33.field747[class136.field2123.field148?1:0].method1954(class33.field741 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field326 == 0) {
            if(null != class33.field774) {
               var13 = class33.field741 + 5;
               var29 = 463;
               byte var33 = 100;
               byte var34 = 35;
               class33.field774.method1954(var13, var29);
               var0.method4173("World " + Client.world, var33 / 2 + var13, var34 / 2 + var29 - 2, 16777215, 0);
               if(null != class117.worldServersDownload) {
                  var1.method4173("Loading...", var33 / 2 + var13, 12 + var34 / 2 + var29, 16777215, 0);
               } else {
                  var1.method4173("Click to switch", var33 / 2 + var13, 12 + var29 + var34 / 2, 16777215, 0);
               }
            } else {
               class33.field774 = class137.method3010(Client.field451, "sl_button", "");
            }
         }

         try {
            var12 = class107.canvas.getGraphics();
            class54.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var25) {
            class107.canvas.repaint();
         }
      }

   }
}
