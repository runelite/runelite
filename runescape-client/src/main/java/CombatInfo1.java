import java.awt.Graphics;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1969359703
   )
   int field654;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1923847591
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2099607163
   )
   @Export("health")
   int health;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1450630351
   )
   int field657;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = -2113345181
   )
   @Export("baseY")
   static int baseY;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field654 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field657 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "0"
   )
   void method644(int var1, int var2, int var3, int var4) {
      this.field654 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field657 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;IB)Lclass142;",
      garbageValue = "2"
   )
   static class142 method645(class182 var0, int var1) {
      byte[] var2 = var0.method3278(var1);
      return var2 == null?null:new class142(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZB)V",
      garbageValue = "-48"
   )
   static void method649(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field846 = (XItemContainer.field123 - Client.field537) / 2;
         class41.loginWindowX = 202 + class41.field846;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      int var12;
      int var14;
      Graphics var23;
      int var35;
      int var37;
      int var38;
      int var42;
      if(class41.worldSelectShown) {
         if(null == class229.field3251) {
            class229.field3251 = class26.method622(Friend.field147, "sl_back", "");
         }

         if(null == class196.field2855) {
            class196.field2855 = FrameMap.method1705(Friend.field147, "sl_flags", "");
         }

         if(class57.field1052 == null) {
            class57.field1052 = FrameMap.method1705(Friend.field147, "sl_arrows", "");
         }

         if(null == class103.field1678) {
            class103.field1678 = FrameMap.method1705(Friend.field147, "sl_stars", "");
         }

         Rasterizer2D.method4004(class41.field846, 23, 765, 480, 0);
         Rasterizer2D.method3994(class41.field846, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method3994(125 + class41.field846, 0, 640, 23, 5197647, 2697513);
         var0.method3874("Select a world", 62 + class41.field846, 15, 0, -1);
         if(null != class103.field1678) {
            class103.field1678[1].method4064(class41.field846 + 140, 1);
            var1.method3919("Members only world", class41.field846 + 152, 10, 16777215, -1);
            class103.field1678[0].method4064(class41.field846 + 140, 12);
            var1.method3919("Free world", 152 + class41.field846, 21, 16777215, -1);
         }

         if(null != class57.field1052) {
            var35 = 280 + class41.field846;
            if(World.field669[0] == 0 && World.field674[0] == 0) {
               class57.field1052[2].method4064(var35, 4);
            } else {
               class57.field1052[0].method4064(var35, 4);
            }

            if(World.field669[0] == 0 && World.field674[0] == 1) {
               class57.field1052[3].method4064(var35 + 15, 4);
            } else {
               class57.field1052[1].method4064(15 + var35, 4);
            }

            var0.method3919("World", 32 + var35, 17, 16777215, -1);
            var5 = 390 + class41.field846;
            if(World.field669[0] == 1 && World.field674[0] == 0) {
               class57.field1052[2].method4064(var5, 4);
            } else {
               class57.field1052[0].method4064(var5, 4);
            }

            if(World.field669[0] == 1 && World.field674[0] == 1) {
               class57.field1052[3].method4064(15 + var5, 4);
            } else {
               class57.field1052[1].method4064(15 + var5, 4);
            }

            var0.method3919("Players", var5 + 32, 17, 16777215, -1);
            var37 = class41.field846 + 500;
            if(World.field669[0] == 2 && World.field674[0] == 0) {
               class57.field1052[2].method4064(var37, 4);
            } else {
               class57.field1052[0].method4064(var37, 4);
            }

            if(World.field669[0] == 2 && World.field674[0] == 1) {
               class57.field1052[3].method4064(15 + var37, 4);
            } else {
               class57.field1052[1].method4064(15 + var37, 4);
            }

            var0.method3919("Location", 32 + var37, 17, 16777215, -1);
            var7 = 610 + class41.field846;
            if(World.field669[0] == 3 && World.field674[0] == 0) {
               class57.field1052[2].method4064(var7, 4);
            } else {
               class57.field1052[0].method4064(var7, 4);
            }

            if(World.field669[0] == 3 && World.field674[0] == 1) {
               class57.field1052[3].method4064(var7 + 15, 4);
            } else {
               class57.field1052[1].method4064(var7 + 15, 4);
            }

            var0.method3919("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4004(class41.field846 + 708, 4, 50, 16, 0);
         var1.method3874("Cancel", 25 + class41.field846 + 708, 16, 16777215, -1);
         class41.field853 = -1;
         if(class229.field3251 != null) {
            var4 = 88;
            byte var43 = 19;
            var37 = 765 / (var4 + 1);
            var7 = 480 / (var43 + 1);

            do {
               var38 = var7;
               var9 = var37;
               if((var37 - 1) * var7 >= World.field677) {
                  --var37;
               }

               if(var37 * (var7 - 1) >= World.field677) {
                  --var7;
               }

               if((var7 - 1) * var37 >= World.field677) {
                  --var7;
               }
            } while(var38 != var7 || var37 != var9);

            var38 = (765 - var4 * var37) / (1 + var37);
            if(var38 > 5) {
               var38 = 5;
            }

            var9 = (480 - var7 * var43) / (1 + var7);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var4 * var37 - (var37 - 1) * var38) / 2;
            var11 = (480 - var7 * var43 - var9 * (var7 - 1)) / 2;
            var12 = 23 + var11;
            var42 = var10 + class41.field846;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field677; ++var16) {
               World var17 = WidgetNode.worldList[var16];
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
               if(var17.method657()) {
                  if(var17.method652()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method661()) {
                  var21 = 16711680;
                  if(var17.method652()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method654()) {
                  if(var17.method652()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method652()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1799 >= var42 && class115.field1794 >= var12 && class115.field1799 < var4 + var42 && class115.field1794 < var43 + var12 && var18) {
                  class41.field853 = var16;
                  class229.field3251[var20].method4190(var42, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class229.field3251[var20].method4139(var42, var12);
               }

               if(null != class196.field2855) {
                  class196.field2855[(var17.method652()?8:0) + var17.location].method4064(29 + var42, var12);
               }

               var0.method3874(Integer.toString(var17.id), 15 + var42, var43 / 2 + var12 + 5, var21, -1);
               var1.method3874(var19, var42 + 60, 5 + var43 / 2 + var12, 268435455, -1);
               var12 += var9 + var43;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var42 += var4 + var38;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3884(WidgetNode.worldList[class41.field853].activity) + 6;
               int var22 = 8 + var1.field3086;
               Rasterizer2D.method4004(class115.field1799 - var16 / 2, 20 + class115.field1794 + 5, var16, var22, 16777120);
               Rasterizer2D.method3985(class115.field1799 - var16 / 2, 20 + class115.field1794 + 5, var16, var22, 0);
               var1.method3874(WidgetNode.worldList[class41.field853].activity, class115.field1799, 20 + class115.field1794 + 5 + var1.field3086 + 4, 0, -1);
            }
         }

         try {
            var23 = class32.canvas.getGraphics();
            class13.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            class32.canvas.repaint();
         }

      } else {
         if(var3) {
            class156.field2209.method4139(class41.field846, 0);
            class148.field2032.method4139(382 + class41.field846, 0);
            class1.field11.method4064(class41.field846 + 382 - class1.field11.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3874("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method3985(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method3985(180 + class41.loginWindowX - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4004(class41.loginWindowX + 180 - 150, var5 + 2, class41.field849 * 3, 30, 9179409);
            Rasterizer2D.method4004(180 + class41.loginWindowX - 150 + class41.field849 * 3, var5 + 2, 300 - class41.field849 * 3, 30, 0);
            var0.method3874(class41.field839, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         char[] var28;
         String var29;
         short var34;
         short var36;
         if(Client.gameState == 20) {
            class41.field821.method4064(class41.loginWindowX + 180 - class41.field821.originalWidth / 2, 271 - class41.field821.height / 2);
            var34 = 211;
            var0.method3874(class41.loginMessage1, 180 + class41.loginWindowX, var34, 16776960, 0);
            var35 = var34 + 15;
            var0.method3874(class41.loginMessage2, 180 + class41.loginWindowX, var35, 16776960, 0);
            var35 += 15;
            var0.method3874(class41.loginMessage3, 180 + class41.loginWindowX, var35, 16776960, 0);
            var35 += 15;
            var35 += 10;
            if(class41.loginIndex != 4) {
               var0.method3919("Login: ", 180 + class41.loginWindowX - 110, var35, 16777215, 0);
               var36 = 200;

               for(var24 = class41.username; var0.method3884(var24) > var36; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3919(FontTypeFace.method3937(var24), 180 + class41.loginWindowX - 70, var35, 16777215, 0);
               var35 += 15;
               var26 = "Password: ";
               var27 = class41.field844;
               var12 = var27.length();
               var28 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var28[var14] = 42;
               }

               var29 = new String(var28);
               var0.method3919(var26 + var29, class41.loginWindowX + 180 - 108, var35, 16777215, 0);
               var35 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field821.method4064(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var34 = 251;
               var0.method3874("Welcome to RuneScape", 180 + class41.loginWindowX, var34, 16776960, 0);
               var35 = var34 + 30;
               var5 = 180 + class41.loginWindowX - 80;
               var6 = 291;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var0.method3875("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var0.method3875("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3874(class41.field819, class41.loginWindowX + 180, 211, 16776960, 0);
               var34 = 236;
               var0.method3874(class41.loginMessage1, 180 + class41.loginWindowX, var34, 16777215, 0);
               var35 = var34 + 15;
               var0.method3874(class41.loginMessage2, class41.loginWindowX + 180, var35, 16777215, 0);
               var35 += 15;
               var0.method3874(class41.loginMessage3, 180 + class41.loginWindowX, var35, 16777215, 0);
               var35 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 321;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var0.method3874("Continue", var5, 5 + var6, 16777215, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var0.method3874("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var34 = 211;
               var0.method3874(class41.loginMessage1, 180 + class41.loginWindowX, var34, 16776960, 0);
               var35 = var34 + 15;
               var0.method3874(class41.loginMessage2, 180 + class41.loginWindowX, var35, 16776960, 0);
               var35 += 15;
               var0.method3874(class41.loginMessage3, class41.loginWindowX + 180, var35, 16776960, 0);
               var35 += 15;
               var35 += 10;
               var0.method3919("Login: ", 180 + class41.loginWindowX - 110, var35, 16777215, 0);
               var36 = 200;

               for(var24 = class41.username; var0.method3884(var24) > var36; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3919(FontTypeFace.method3937(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class163.method3157(16776960) + "|":""), class41.loginWindowX + 180 - 70, var35, 16777215, 0);
               var35 += 15;
               var26 = "Password: ";
               var27 = class41.field844;
               var12 = var27.length();
               var28 = new char[var12];

               for(var14 = 0; var14 < var12; ++var14) {
                  var28[var14] = 42;
               }

               var29 = new String(var28);
               var0.method3919(var26 + var29 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class163.method3157(16776960) + "|":""), class41.loginWindowX + 180 - 108, var35, 16777215, 0);
               var35 += 15;
               var11 = 180 + class41.loginWindowX - 80;
               short var41 = 321;
               class41.field820.method4064(var11 - 73, var41 - 20);
               var0.method3874("Login", var11, 5 + var41, 16777215, 0);
               var11 = 80 + 180 + class41.loginWindowX;
               class41.field820.method4064(var11 - 73, var41 - 20);
               var0.method3874("Cancel", var11, 5 + var41, 16777215, 0);
               var34 = 357;
               var1.method3874("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var34, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var34 = 201;
               var0.method3874("Invalid username or password.", class41.loginWindowX + 180, var34, 16776960, 0);
               var35 = var34 + 20;
               var1.method3874("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var35, 16776960, 0);
               var35 += 15;
               var1.method3874("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var35, 16776960, 0);
               var35 += 15;
               var5 = 180 + class41.loginWindowX;
               var6 = 276;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var2.method3874("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class41.loginWindowX + 180;
               var6 = 326;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var2.method3874("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3874("Authenticator", 180 + class41.loginWindowX, 211, 16776960, 0);
               var34 = 236;
               var0.method3874(class41.loginMessage1, class41.loginWindowX + 180, var34, 16777215, 0);
               var35 = var34 + 15;
               var0.method3874(class41.loginMessage2, class41.loginWindowX + 180, var35, 16777215, 0);
               var35 += 15;
               var0.method3874(class41.loginMessage3, 180 + class41.loginWindowX, var35, 16777215, 0);
               var35 += 15;
               var24 = "PIN: ";
               var26 = ChatLineBuffer.authCode;
               var10 = var26.length();
               char[] var44 = new char[var10];

               for(var12 = 0; var12 < var10; ++var12) {
                  var44[var12] = 42;
               }

               String var30 = new String(var44);
               var0.method3919(var24 + var30 + (Client.gameCycle % 40 < 20?class163.method3157(16776960) + "|":""), class41.loginWindowX + 180 - 108, var35, 16777215, 0);
               var35 -= 8;
               var0.method3919("Trust this computer", 180 + class41.loginWindowX - 9, var35, 16776960, 0);
               var35 += 15;
               var0.method3919("for 30 days: ", class41.loginWindowX + 180 - 9, var35, 16776960, 0);
               var9 = class41.loginWindowX + 180 - 9 + var0.method3884("for 30 days: ") + 15;
               var10 = var35 - var0.field3086;
               ModIcon var45;
               if(class41.field848) {
                  var45 = class179.field2677;
               } else {
                  var45 = class60.field1079;
               }

               var45.method4064(var9, var10);
               var35 += 15;
               var12 = class41.loginWindowX + 180 - 80;
               short var13 = 321;
               class41.field820.method4064(var12 - 73, var13 - 20);
               var0.method3874("Continue", var12, var13 + 5, 16777215, 0);
               var12 = 80 + 180 + class41.loginWindowX;
               class41.field820.method4064(var12 - 73, var13 - 20);
               var0.method3874("Cancel", var12, 5 + var13, 16777215, 0);
               var1.method3874("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, 36 + var13, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3874("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
               var34 = 221;
               var2.method3874(class41.loginMessage1, class41.loginWindowX + 180, var34, 16776960, 0);
               var35 = var34 + 15;
               var2.method3874(class41.loginMessage2, 180 + class41.loginWindowX, var35, 16776960, 0);
               var35 += 15;
               var2.method3874(class41.loginMessage3, class41.loginWindowX + 180, var35, 16776960, 0);
               var35 += 15;
               var35 += 14;
               var0.method3919("Username/email: ", 180 + class41.loginWindowX - 145, var35, 16777215, 0);
               var36 = 174;

               for(var24 = class41.username; var0.method3884(var24) > var36; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3919(FontTypeFace.method3937(var24) + (Client.gameCycle % 40 < 20?class163.method3157(16776960) + "|":""), 180 + class41.loginWindowX - 34, var35, 16777215, 0);
               var35 += 15;
               var7 = 180 + class41.loginWindowX - 80;
               short var8 = 321;
               class41.field820.method4064(var7 - 73, var8 - 20);
               var0.method3874("Recover", var7, 5 + var8, 16777215, 0);
               var7 = 80 + class41.loginWindowX + 180;
               class41.field820.method4064(var7 - 73, var8 - 20);
               var0.method3874("Back", var7, var8 + 5, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var34 = 211;
               var0.method3874(class41.loginMessage1, 180 + class41.loginWindowX, var34, 16776960, 0);
               var35 = var34 + 15;
               var0.method3874(class41.loginMessage2, 180 + class41.loginWindowX, var35, 16776960, 0);
               var35 += 15;
               var0.method3874(class41.loginMessage3, class41.loginWindowX + 180, var35, 16776960, 0);
               var35 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 321;
               class41.field820.method4064(var5 - 73, var6 - 20);
               var0.method3874("Back", var5, 5 + var6, 16777215, 0);
            }
         }

         if(class41.field836 > 0) {
            var35 = class41.field836;
            var36 = 256;
            class41.field825 += 128 * var35;
            if(class41.field825 > class60.field1083.length) {
               class41.field825 -= class60.field1083.length;
               var37 = (int)(Math.random() * 12.0D);
               class101.method1939(class41.field823[var37]);
            }

            var37 = 0;
            var7 = 128 * var35;
            var38 = 128 * (var36 - var35);

            for(var9 = 0; var9 < var38; ++var9) {
               var10 = class41.field847[var7 + var37] - class60.field1083[class41.field825 + var37 & class60.field1083.length - 1] * var35 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class41.field847[var37++] = var10;
            }

            for(var9 = var36 - var35; var9 < var36; ++var9) {
               var10 = 128 * var9;

               for(var11 = 0; var11 < 128; ++var11) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var11 > 10 && var11 < 118) {
                     class41.field847[var11 + var10] = 255;
                  } else {
                     class41.field847[var10 + var11] = 0;
                  }
               }
            }

            if(class41.field830 > 0) {
               class41.field830 -= var35 * 4;
            }

            if(class41.field831 > 0) {
               class41.field831 -= 4 * var35;
            }

            if(class41.field830 == 0 && class41.field831 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var35));
               if(var9 == 0) {
                  class41.field830 = 1024;
               }

               if(var9 == 1) {
                  class41.field831 = 1024;
               }
            }

            for(var9 = 0; var9 < var36 - var35; ++var9) {
               class41.field827[var9] = class41.field827[var9 + var35];
            }

            for(var9 = var36 - var35; var9 < var36; ++var9) {
               class41.field827[var9] = (int)(Math.sin((double)class41.field837 / 14.0D) * 16.0D + Math.sin((double)class41.field837 / 15.0D) * 14.0D + Math.sin((double)class41.field837 / 16.0D) * 12.0D);
               ++class41.field837;
            }

            class41.field835 += var35;
            var9 = ((Client.gameCycle & 1) + var35) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class41.field835 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  class41.field847[(var12 << 7) + var11] = 192;
               }

               class41.field835 = 0;
               var10 = 0;

               label637:
               while(true) {
                  if(var10 >= var36) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label637;
                        }

                        var11 = 0;

                        for(var12 = -var9; var12 < var36; ++var12) {
                           var42 = 128 * var12;
                           if(var12 + var9 < var36) {
                              var11 += class41.field833[var9 * 128 + var42 + var10];
                           }

                           if(var12 - (var9 + 1) >= 0) {
                              var11 -= class41.field833[var10 + var42 - (var9 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              class41.field847[var10 + var42] = var11 / (1 + var9 * 2);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var12 = 128 * var10;

                  for(var42 = -var9; var42 < 128; ++var42) {
                     if(var9 + var42 < 128) {
                        var11 += class41.field847[var12 + var42 + var9];
                     }

                     if(var42 - (var9 + 1) >= 0) {
                        var11 -= class41.field847[var42 + var12 - (var9 + 1)];
                     }

                     if(var42 >= 0) {
                        class41.field833[var12 + var42] = var11 / (1 + var9 * 2);
                     }
                  }

                  ++var10;
               }
            }

            class41.field836 = 0;
         }

         var34 = 256;
         if(class41.field830 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field830 > 768) {
                  class41.field828[var5] = class40.method771(class5.field47[var5], class205.field3071[var5], 1024 - class41.field830);
               } else if(class41.field830 > 256) {
                  class41.field828[var5] = class205.field3071[var5];
               } else {
                  class41.field828[var5] = class40.method771(class205.field3071[var5], class5.field47[var5], 256 - class41.field830);
               }
            }
         } else if(class41.field831 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field831 > 768) {
                  class41.field828[var5] = class40.method771(class5.field47[var5], class41.field829[var5], 1024 - class41.field831);
               } else if(class41.field831 > 256) {
                  class41.field828[var5] = class41.field829[var5];
               } else {
                  class41.field828[var5] = class40.method771(class41.field829[var5], class5.field47[var5], 256 - class41.field831);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class41.field828[var5] = class5.field47[var5];
            }
         }

         Rasterizer2D.method3973(class41.field846, 9, class41.field846 + 128, 7 + var34);
         class156.field2209.method4139(class41.field846, 0);
         Rasterizer2D.method3972();
         var5 = 0;
         var37 = class41.field846 + class13.bufferProvider.width * 9;

         for(var7 = 1; var7 < var34 - 1; ++var7) {
            var38 = class41.field827[var7] * (var34 - var7) / var34;
            var9 = var38 + 22;
            if(var9 < 0) {
               var9 = 0;
            }

            var5 += var9;

            for(var10 = var9; var10 < 128; ++var10) {
               var11 = class41.field847[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var42 = 256 - var11;
                  var11 = class41.field828[var11];
                  var14 = class13.bufferProvider.pixels[var37];
                  class13.bufferProvider.pixels[var37++] = (var42 * (var14 & '\uff00') + (var11 & '\uff00') * var12 & 16711680) + (var42 * (var14 & 16711935) + var12 * (var11 & 16711935) & -16711936) >> 8;
               } else {
                  ++var37;
               }
            }

            var37 += class13.bufferProvider.width + var9 - 128;
         }

         Rasterizer2D.method3973(class41.field846 + 765 - 128, 9, class41.field846 + 765, var34 + 7);
         class148.field2032.method4139(382 + class41.field846, 0);
         Rasterizer2D.method3972();
         var5 = 0;
         var37 = 637 + class13.bufferProvider.width * 9 + 24 + class41.field846;

         for(var7 = 1; var7 < var34 - 1; ++var7) {
            var38 = (var34 - var7) * class41.field827[var7] / var34;
            var9 = 103 - var38;
            var37 += var38;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = class41.field847[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var42 = 256 - var11;
                  var11 = class41.field828[var11];
                  var14 = class13.bufferProvider.pixels[var37];
                  class13.bufferProvider.pixels[var37++] = ((var11 & 16711935) * var12 + var42 * (var14 & 16711935) & -16711936) + (var42 * (var14 & '\uff00') + (var11 & '\uff00') * var12 & 16711680) >> 8;
               } else {
                  ++var37;
               }
            }

            var5 += 128 - var9;
            var37 += class13.bufferProvider.width - var9 - var38;
         }

         class41.field824[class85.field1456.field683?1:0].method4064(765 + class41.field846 - 40, 463);
         if(Client.gameState > 5 && Client.field285 == 0) {
            if(class8.field70 != null) {
               var35 = class41.field846 + 5;
               var36 = 463;
               byte var40 = 100;
               byte var39 = 35;
               class8.field70.method4064(var35, var36);
               var0.method3874("World" + " " + Client.world, var35 + var40 / 2, var36 + var39 / 2 - 2, 16777215, 0);
               if(World.worldServersDownload != null) {
                  var1.method3874("Loading...", var40 / 2 + var35, var39 / 2 + var36 + 12, 16777215, 0);
               } else {
                  var1.method3874("Click to switch", var35 + var40 / 2, 12 + var36 + var39 / 2, 16777215, 0);
               }
            } else {
               class8.field70 = class167.method3205(Friend.field147, "sl_button", "");
            }
         }

         try {
            var23 = class32.canvas.getGraphics();
            class13.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var33) {
            class32.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZS)Z",
      garbageValue = "32176"
   )
   public static boolean method650(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
