import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -282420327
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1779699599
   )
   @Export("height")
   int height;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -548339645
   )
   int field1711;
   @ObfuscatedName("z")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 210904615
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1526972223
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 889080781
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1933226197
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1239478893
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 66149531
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1908777395
   )
   int field1720;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2113744199
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -60819167
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1296830943
   )
   @Export("relativeX")
   int relativeX;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZB)V",
      garbageValue = "-75"
   )
   static void method2256(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field745 = (FaceNormal.field1499 - Client.field333) / 2;
         class33.loginWindowX = 202 + class33.field745;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var14;
      Graphics var23;
      int var34;
      int var36;
      int var37;
      int var40;
      int var41;
      if(class33.worldSelectShown) {
         if(null == class156.field2322) {
            class156.field2322 = class10.method128(class109.field1922, "sl_back", "");
         }

         if(null == ItemLayer.field1739) {
            ItemLayer.field1739 = Sequence.method898(class109.field1922, "sl_flags", "");
         }

         if(class5.field92 == null) {
            class5.field92 = Sequence.method898(class109.field1922, "sl_arrows", "");
         }

         if(null == class26.field637) {
            class26.field637 = Sequence.method898(class109.field1922, "sl_stars", "");
         }

         class82.method1831(class33.field745, 23, 765, 480, 0);
         class82.method1836(class33.field745, 0, 125, 23, 12425273, 9135624);
         class82.method1836(125 + class33.field745, 0, 640, 23, 5197647, 2697513);
         var0.method4046("Select a world", 62 + class33.field745, 15, 0, -1);
         if(null != class26.field637) {
            class26.field637[1].method1896(class33.field745 + 140, 1);
            var1.method4079("Members only world", 152 + class33.field745, 10, 16777215, -1);
            class26.field637[0].method1896(class33.field745 + 140, 12);
            var1.method4079("Free world", 152 + class33.field745, 21, 16777215, -1);
         }

         if(null != class5.field92) {
            var34 = 280 + class33.field745;
            if(World.field649[0] == 0 && World.field652[0] == 0) {
               class5.field92[2].method1896(var34, 4);
            } else {
               class5.field92[0].method1896(var34, 4);
            }

            if(World.field649[0] == 0 && World.field652[0] == 1) {
               class5.field92[3].method1896(var34 + 15, 4);
            } else {
               class5.field92[1].method1896(var34 + 15, 4);
            }

            var0.method4079("World", 32 + var34, 17, 16777215, -1);
            var5 = 390 + class33.field745;
            if(World.field649[0] == 1 && World.field652[0] == 0) {
               class5.field92[2].method1896(var5, 4);
            } else {
               class5.field92[0].method1896(var5, 4);
            }

            if(World.field649[0] == 1 && World.field652[0] == 1) {
               class5.field92[3].method1896(var5 + 15, 4);
            } else {
               class5.field92[1].method1896(var5 + 15, 4);
            }

            var0.method4079("Players", 32 + var5, 17, 16777215, -1);
            var36 = class33.field745 + 500;
            if(World.field649[0] == 2 && World.field652[0] == 0) {
               class5.field92[2].method1896(var36, 4);
            } else {
               class5.field92[0].method1896(var36, 4);
            }

            if(World.field649[0] == 2 && World.field652[0] == 1) {
               class5.field92[3].method1896(15 + var36, 4);
            } else {
               class5.field92[1].method1896(15 + var36, 4);
            }

            var0.method4079("Location", var36 + 32, 17, 16777215, -1);
            var7 = 610 + class33.field745;
            if(World.field649[0] == 3 && World.field652[0] == 0) {
               class5.field92[2].method1896(var7, 4);
            } else {
               class5.field92[0].method1896(var7, 4);
            }

            if(World.field649[0] == 3 && World.field652[0] == 1) {
               class5.field92[3].method1896(15 + var7, 4);
            } else {
               class5.field92[1].method1896(var7 + 15, 4);
            }

            var0.method4079("Type", var7 + 32, 17, 16777215, -1);
         }

         class82.method1831(class33.field745 + 708, 4, 50, 16, 0);
         var1.method4046("Cancel", 708 + class33.field745 + 25, 16, 16777215, -1);
         class33.field752 = -1;
         if(class156.field2322 != null) {
            var4 = 88;
            byte var42 = 19;
            var36 = 765 / (1 + var4);
            var7 = 480 / (1 + var42);

            do {
               var37 = var7;
               var9 = var36;
               if((var36 - 1) * var7 >= World.field646) {
                  --var36;
               }

               if((var7 - 1) * var36 >= World.field646) {
                  --var7;
               }

               if((var7 - 1) * var36 >= World.field646) {
                  --var7;
               }
            } while(var37 != var7 || var36 != var9);

            var37 = (765 - var36 * var4) / (var36 + 1);
            if(var37 > 5) {
               var37 = 5;
            }

            var9 = (480 - var42 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var36 * var4 - (var36 - 1) * var37) / 2;
            var11 = (480 - var42 * var7 - var9 * (var7 - 1)) / 2;
            var40 = 23 + var11;
            var41 = var10 + class33.field745;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field646; ++var16) {
               World var17 = class35.worldList[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method597()) {
                  if(var17.method593()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method619()) {
                  var21 = 16711680;
                  if(var17.method593()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method594()) {
                  if(var17.method593()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method593()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class143.field2204 >= var41 && class143.field2210 >= var40 && class143.field2204 < var4 + var41 && class143.field2210 < var42 + var40 && var18) {
                  class33.field752 = var16;
                  class156.field2322[var20].method1744(var41, var40, 128, 16777215);
                  var15 = true;
               } else {
                  class156.field2322[var20].method1738(var41, var40);
               }

               if(ItemLayer.field1739 != null) {
                  ItemLayer.field1739[(var17.method593()?8:0) + var17.location].method1896(29 + var41, var40);
               }

               var0.method4046(Integer.toString(var17.id), 15 + var41, 5 + var40 + var42 / 2, var21, -1);
               var1.method4046(var19, var41 + 60, 5 + var40 + var42 / 2, 268435455, -1);
               var40 += var42 + var9;
               ++var14;
               if(var14 >= var7) {
                  var40 = 23 + var11;
                  var41 += var37 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method4099(class35.worldList[class33.field752].activity) + 6;
               int var22 = var1.field3240 + 8;
               class82.method1831(class143.field2204 - var16 / 2, 5 + class143.field2210 + 20, var16, var22, 16777120);
               class82.method1837(class143.field2204 - var16 / 2, class143.field2210 + 20 + 5, var16, var22, 0);
               var1.method4046(class35.worldList[class33.field752].activity, class143.field2204, 4 + 20 + class143.field2210 + 5 + var1.field3240, 0, -1);
            }
         }

         try {
            var23 = class129.canvas.getGraphics();
            class40.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            class129.canvas.repaint();
         }

      } else {
         if(var3) {
            class40.field883.method1738(class33.field745, 0);
            class13.field195.method1738(class33.field745 + 382, 0);
            class162.field2660.method1896(class33.field745 + 382 - class162.field2660.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method4046("RuneScape is loading - please wait...", 180 + class33.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1837(class33.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            class82.method1837(180 + class33.loginWindowX - 151, 1 + var5, 302, 32, 0);
            class82.method1831(180 + class33.loginWindowX - 150, 2 + var5, class33.field737 * 3, 30, 9179409);
            class82.method1831(class33.field737 * 3 + (180 + class33.loginWindowX - 150), var5 + 2, 300 - class33.field737 * 3, 30, 0);
            var0.method4046(class33.field738, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class232.field3276.method1896(180 + class33.loginWindowX - class232.field3276.originalWidth / 2, 271 - class232.field3276.height / 2);
            var33 = 211;
            var0.method4046(class33.loginMessage1, class33.loginWindowX + 180, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method4046(class33.loginMessage2, class33.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var0.method4046(class33.loginMessage3, class33.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class33.loginIndex != 4) {
               var0.method4079("Login: ", class33.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class33.username; var0.method4099(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method4079(class226.method4082(var24), class33.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class33.field733;
               var28 = class143.method3024('*', var27.length());
               var0.method4079(var26 + var28, 180 + class33.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class232.field3276.method1896(class33.loginWindowX, 171);
            short var6;
            if(class33.loginIndex == 0) {
               var33 = 251;
               var0.method4046("Welcome to RuneScape", 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class33.loginWindowX + 180 - 80;
               var6 = 291;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var0.method4100("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class33.loginWindowX + 180;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var0.method4100("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4046(class33.field740, class33.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method4046(class33.loginMessage1, class33.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4046(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method4046(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var5 = 180 + class33.loginWindowX - 80;
               var6 = 321;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var0.method4046("Continue", var5, 5 + var6, 16777215, 0);
               var5 = class33.loginWindowX + 180 + 80;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var0.method4046("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class33.loginIndex == 2) {
               var33 = 211;
               var0.method4046(class33.loginMessage1, class33.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4046(class33.loginMessage2, class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var0.method4046(class33.loginMessage3, class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 10;
               var0.method4079("Login: ", class33.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class33.username; var0.method4099(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method4079(class226.method4082(var24) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class154.method3185(16776960) + "|":""), 180 + class33.loginWindowX - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class33.field733;
               var28 = class143.method3024('*', var27.length());
               var0.method4079(var26 + var28 + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class154.method3185(16776960) + "|":""), class33.loginWindowX + 180 - 108, var34, 16777215, 0);
               var34 += 15;
               var11 = 180 + class33.loginWindowX - 80;
               short var12 = 321;
               class33.field721.method1896(var11 - 73, var12 - 20);
               var0.method4046("Login", var11, 5 + var12, 16777215, 0);
               var11 = 180 + class33.loginWindowX + 80;
               class33.field721.method1896(var11 - 73, var12 - 20);
               var0.method4046("Cancel", var11, var12 + 5, 16777215, 0);
               var33 = 357;
               var1.method4046("Forgotten your password? <col=ffffff>Click here.", 180 + class33.loginWindowX, var33, 16776960, 0);
            } else if(class33.loginIndex == 3) {
               var33 = 201;
               var0.method4046("Invalid username or password.", 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method4046("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var1.method4046("email address to login. Otherwise please login with your username.", 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var5 = 180 + class33.loginWindowX;
               var6 = 276;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var2.method4046("Try again", var5, 5 + var6, 16777215, 0);
               var5 = class33.loginWindowX + 180;
               var6 = 326;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var2.method4046("Forgotten password?", var5, 5 + var6, 16777215, 0);
            } else if(class33.loginIndex == 4) {
               var0.method4046("Authenticator", class33.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method4046(class33.loginMessage1, 180 + class33.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method4046(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method4046(class33.loginMessage3, 180 + class33.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var24 = "PIN: ";
               var26 = SecondaryBufferProvider.authCode;
               String var25 = class143.method3024('*', var26.length());
               var0.method4079(var24 + var25 + (Client.gameCycle % 40 < 20?class154.method3185(16776960) + "|":""), 180 + class33.loginWindowX - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method4079("Trust this computer", 180 + class33.loginWindowX - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method4079("for 30 days: ", 180 + class33.loginWindowX - 9, var34, 16776960, 0);
               var9 = 180 + class33.loginWindowX - 9 + var0.method4099("for 30 days: ") + 15;
               var10 = var34 - var0.field3240;
               ModIcon var30;
               if(class33.field731) {
                  var30 = class33.field723;
               } else {
                  var30 = class21.field576;
               }

               var30.method1896(var9, var10);
               var34 += 15;
               var40 = class33.loginWindowX + 180 - 80;
               short var13 = 321;
               class33.field721.method1896(var40 - 73, var13 - 20);
               var0.method4046("Continue", var40, var13 + 5, 16777215, 0);
               var40 = 80 + 180 + class33.loginWindowX;
               class33.field721.method1896(var40 - 73, var13 - 20);
               var0.method4046("Cancel", var40, var13 + 5, 16777215, 0);
               var1.method4046("<u=ff>Can\'t Log In?</u>", 180 + class33.loginWindowX, 36 + var13, 255, 0);
            } else if(class33.loginIndex == 5) {
               var0.method4046("Forgotten your password?", 180 + class33.loginWindowX, 201, 16776960, 0);
               var33 = 221;
               var2.method4046(class33.loginMessage1, 180 + class33.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method4046(class33.loginMessage2, class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var2.method4046(class33.loginMessage3, class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method4079("Username/email: ", 180 + class33.loginWindowX - 145, var34, 16777215, 0);
               var35 = 174;

               for(var24 = class33.username; var0.method4099(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method4079(class226.method4082(var24) + (Client.gameCycle % 40 < 20?class154.method3185(16776960) + "|":""), class33.loginWindowX + 180 - 34, var34, 16777215, 0);
               var34 += 15;
               var7 = class33.loginWindowX + 180 - 80;
               short var8 = 321;
               class33.field721.method1896(var7 - 73, var8 - 20);
               var0.method4046("Recover", var7, var8 + 5, 16777215, 0);
               var7 = class33.loginWindowX + 180 + 80;
               class33.field721.method1896(var7 - 73, var8 - 20);
               var0.method4046("Back", var7, 5 + var8, 16777215, 0);
            } else if(class33.loginIndex == 6) {
               var33 = 211;
               var0.method4046(class33.loginMessage1, class33.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method4046(class33.loginMessage2, 180 + class33.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method4046(class33.loginMessage3, class33.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class33.loginWindowX + 180;
               var6 = 321;
               class33.field721.method1896(var5 - 73, var6 - 20);
               var0.method4046("Back", var5, 5 + var6, 16777215, 0);
            }
         }

         if(class33.field751 > 0) {
            var34 = class33.field751;
            var35 = 256;
            class33.field750 += 128 * var34;
            if(class33.field750 > class130.field2098.length) {
               class33.field750 -= class130.field2098.length;
               var36 = (int)(Math.random() * 12.0D);
               class116.method2497(class33.field722[var36]);
            }

            var36 = 0;
            var7 = 128 * var34;
            var37 = 128 * (var35 - var34);

            for(var9 = 0; var9 < var37; ++var9) {
               var10 = ChatMessages.field270[var36 + var7] - class130.field2098[var36 + class33.field750 & class130.field2098.length - 1] * var34 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               ChatMessages.field270[var36++] = var10;
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               var10 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var40 = (int)(Math.random() * 100.0D);
                  if(var40 < 50 && var11 > 10 && var11 < 118) {
                     ChatMessages.field270[var11 + var10] = 255;
                  } else {
                     ChatMessages.field270[var10 + var11] = 0;
                  }
               }
            }

            if(class33.field742 > 0) {
               class33.field742 -= 4 * var34;
            }

            if(class33.field732 > 0) {
               class33.field732 -= 4 * var34;
            }

            if(class33.field742 == 0 && class33.field732 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var34));
               if(var9 == 0) {
                  class33.field742 = 1024;
               }

               if(var9 == 1) {
                  class33.field732 = 1024;
               }
            }

            for(var9 = 0; var9 < var35 - var34; ++var9) {
               class33.field729[var9] = class33.field729[var34 + var9];
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               class33.field729[var9] = (int)(Math.sin((double)class33.field736 / 14.0D) * 16.0D + Math.sin((double)class33.field736 / 15.0D) * 14.0D + Math.sin((double)class33.field736 / 16.0D) * 12.0D);
               ++class33.field736;
            }

            class33.field749 += var34;
            var9 = (var34 + (Client.gameCycle & 1)) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class33.field749 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var40 = (int)(Math.random() * 128.0D) + 128;
                  ChatMessages.field270[var11 + (var40 << 7)] = 192;
               }

               class33.field749 = 0;
               var10 = 0;

               label619:
               while(true) {
                  if(var10 >= var35) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label619;
                        }

                        var11 = 0;

                        for(var40 = -var9; var40 < var35; ++var40) {
                           var41 = 128 * var40;
                           if(var9 + var40 < var35) {
                              var11 += Frames.field1835[128 * var9 + var41 + var10];
                           }

                           if(var40 - (var9 + 1) >= 0) {
                              var11 -= Frames.field1835[var10 + var41 - (1 + var9) * 128];
                           }

                           if(var40 >= 0) {
                              ChatMessages.field270[var10 + var41] = var11 / (2 * var9 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var40 = 128 * var10;

                  for(var41 = -var9; var41 < 128; ++var41) {
                     if(var9 + var41 < 128) {
                        var11 += ChatMessages.field270[var41 + var40 + var9];
                     }

                     if(var41 - (1 + var9) >= 0) {
                        var11 -= ChatMessages.field270[var40 + var41 - (var9 + 1)];
                     }

                     if(var41 >= 0) {
                        Frames.field1835[var41 + var40] = var11 / (2 * var9 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class33.field751 = 0;
         }

         var33 = 256;
         if(class33.field742 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field742 > 768) {
                  class33.field730[var5] = ChatMessages.method217(class0.field12[var5], ItemLayer.field1734[var5], 1024 - class33.field742);
               } else if(class33.field742 > 256) {
                  class33.field730[var5] = ItemLayer.field1734[var5];
               } else {
                  class33.field730[var5] = ChatMessages.method217(ItemLayer.field1734[var5], class0.field12[var5], 256 - class33.field742);
               }
            }
         } else if(class33.field732 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field732 > 768) {
                  class33.field730[var5] = ChatMessages.method217(class0.field12[var5], FrameMap.field1816[var5], 1024 - class33.field732);
               } else if(class33.field732 > 256) {
                  class33.field730[var5] = FrameMap.field1816[var5];
               } else {
                  class33.field730[var5] = ChatMessages.method217(FrameMap.field1816[var5], class0.field12[var5], 256 - class33.field732);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class33.field730[var5] = class0.field12[var5];
            }
         }

         class82.method1825(class33.field745, 9, class33.field745 + 128, 7 + var33);
         class40.field883.method1738(class33.field745, 0);
         class82.method1824();
         var5 = 0;
         var36 = class40.bufferProvider.width * 9 + class33.field745;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = class33.field729[var7] * (var33 - var7) / var33;
            var9 = var37 + 22;
            if(var9 < 0) {
               var9 = 0;
            }

            var5 += var9;

            for(var10 = var9; var10 < 128; ++var10) {
               var11 = ChatMessages.field270[var5++];
               if(var11 != 0) {
                  var40 = var11;
                  var41 = 256 - var11;
                  var11 = class33.field730[var11];
                  var14 = class40.bufferProvider.pixels[var36];
                  class40.bufferProvider.pixels[var36++] = (var40 * (var11 & 16711935) + var41 * (var14 & 16711935) & -16711936) + ((var11 & '\uff00') * var40 + var41 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var36;
               }
            }

            var36 += var9 + class40.bufferProvider.width - 128;
         }

         class82.method1825(class33.field745 + 765 - 128, 9, 765 + class33.field745, 7 + var33);
         class13.field195.method1738(382 + class33.field745, 0);
         class82.method1824();
         var5 = 0;
         var36 = class33.field745 + 637 + 24 + class40.bufferProvider.width * 9;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = class33.field729[var7] * (var33 - var7) / var33;
            var9 = 103 - var37;
            var36 += var37;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = ChatMessages.field270[var5++];
               if(var11 != 0) {
                  var40 = var11;
                  var41 = 256 - var11;
                  var11 = class33.field730[var11];
                  var14 = class40.bufferProvider.pixels[var36];
                  class40.bufferProvider.pixels[var36++] = (var40 * (var11 & '\uff00') + (var14 & '\uff00') * var41 & 16711680) + ((var14 & 16711935) * var41 + var40 * (var11 & 16711935) & -16711936) >> 8;
               } else {
                  ++var36;
               }
            }

            var5 += 128 - var9;
            var36 += class40.bufferProvider.width - var9 - var37;
         }

         ChatMessages.field276[class161.field2659.field136?1:0].method1896(765 + class33.field745 - 40, 463);
         if(Client.gameState > 5 && Client.field281 == 0) {
            if(ChatMessages.field277 != null) {
               var34 = 5 + class33.field745;
               var35 = 463;
               byte var39 = 100;
               byte var38 = 35;
               ChatMessages.field277.method1896(var34, var35);
               var0.method4046("World" + " " + Client.world, var34 + var39 / 2, var35 + var38 / 2 - 2, 16777215, 0);
               if(class173.worldServersDownload != null) {
                  var1.method4046("Loading...", var39 / 2 + var34, 12 + var38 / 2 + var35, 16777215, 0);
               } else {
                  var1.method4046("Click to switch", var34 + var39 / 2, var35 + var38 / 2 + 12, 16777215, 0);
               }
            } else {
               ChatMessages.field277 = Item.method650(class109.field1922, "sl_button", "");
            }
         }

         try {
            var23 = class129.canvas.getGraphics();
            class40.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            class129.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "2121482323"
   )
   public static class49 method2257(int var0) {
      class49 var1 = (class49)class49.field1076.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class49.field1078.method3290(33, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method996(new Buffer(var2));
         }

         class49.field1076.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1694470618"
   )
   public static int method2258() {
      return class140.keyboardIdleTicks;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1655203230"
   )
   public static int method2259(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }
}
