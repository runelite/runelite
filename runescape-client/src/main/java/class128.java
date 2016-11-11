import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class128 {
   @ObfuscatedName("h")
   static boolean field2084 = false;
   @ObfuscatedName("jb")
   static Widget[] field2088;
   @ObfuscatedName("dc")
   @Export("region")
   static Region region;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "27"
   )
   abstract byte[] vmethod2822();

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2034994711"
   )
   abstract void vmethod2823(byte[] var1);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIS)[LModIcon;",
      garbageValue = "4115"
   )
   static ModIcon[] method2833(class170 var0, int var1, int var2) {
      return !class22.method559(var0, var1, var2)?null:class12.method156();
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1795495090"
   )
   static boolean method2839(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class93.method2141(var0, Client.field302);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class93.method2141(var3.name, Client.field302))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class93.method2141(var3.previousName, Client.field302))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZB)V",
      garbageValue = "-28"
   )
   static void method2840(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field755 = (class62.field1267 - Client.field515) / 2;
         class33.loginWindowX = 202 + class33.field755;
      }

      if(class33.worldSelectShown) {
         class212.method3955(var0, var1);
      } else {
         if(var3) {
            class33.field745.method1748(class33.field755, 0);
            class164.field2694.method1748(class33.field755 + 382, 0);
            Client.field583.method1905(382 + class33.field755 - Client.field583.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4070("RuneScape is loading - please wait...", 180 + class33.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1856(180 + class33.loginWindowX - 152, var5, 304, 34, 9179409);
            class82.method1856(180 + class33.loginWindowX - 151, var5 + 1, 302, 32, 0);
            class82.method1853(class33.loginWindowX + 180 - 150, 2 + var5, class33.field756 * 3, 30, 9179409);
            class82.method1853(class33.field756 * 3 + (180 + class33.loginWindowX - 150), 2 + var5, 300 - class33.field756 * 3, 30, 0);
            var0.method4070(class33.field769, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var19;
         int var20;
         short var21;
         if(Client.gameState == 20) {
            class180.field2958.method1905(class33.loginWindowX + 180 - class180.field2958.originalWidth / 2, 271 - class180.field2958.height / 2);
            var19 = 211;
            var0.method4070(class33.loginMessage1, 180 + class33.loginWindowX, var19, 16776960, 0);
            var20 = var19 + 15;
            var0.method4070(class33.loginMessage2, class33.loginWindowX + 180, var20, 16776960, 0);
            var20 += 15;
            var0.method4070(class33.loginMessage3, 180 + class33.loginWindowX, var20, 16776960, 0);
            var20 += 15;
            var20 += 10;
            if(class33.loginIndex != 4) {
               var0.method4124("Login: ", class33.loginWindowX + 180 - 110, var20, 16777215, 0);
               var21 = 200;

               for(var6 = class33.username; var0.method4062(var6) > var21; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4124(class226.method4066(var6), class33.loginWindowX + 180 - 70, var20, 16777215, 0);
               var20 += 15;
               var0.method4124("Password: " + MessageNode.method767(class33.field764), 180 + class33.loginWindowX - 108, var20, 16777215, 0);
               var20 += 15;
            }
         }

         int var7;
         int var22;
         int var25;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class180.field2958.method1905(class33.loginWindowX, 171);
            short var15;
            if(class33.loginIndex == 0) {
               var19 = 251;
               var0.method4070("Welcome to RuneScape", class33.loginWindowX + 180, var19, 16776960, 0);
               var20 = var19 + 30;
               var5 = 180 + class33.loginWindowX - 80;
               var15 = 291;
               class33.field743.method1905(var5 - 73, var15 - 20);
               var0.method4071("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class33.loginWindowX + 180;
               class33.field743.method1905(var5 - 73, var15 - 20);
               var0.method4071("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4070(class33.field752, 180 + class33.loginWindowX, 211, 16776960, 0);
               var19 = 236;
               var0.method4070(class33.loginMessage1, class33.loginWindowX + 180, var19, 16777215, 0);
               var20 = var19 + 15;
               var0.method4070(class33.loginMessage2, class33.loginWindowX + 180, var20, 16777215, 0);
               var20 += 15;
               var0.method4070(class33.loginMessage3, class33.loginWindowX + 180, var20, 16777215, 0);
               var20 += 15;
               var5 = class33.loginWindowX + 180 - 80;
               var15 = 321;
               class33.field743.method1905(var5 - 73, var15 - 20);
               var0.method4070("Continue", var5, 5 + var15, 16777215, 0);
               var5 = 180 + class33.loginWindowX + 80;
               class33.field743.method1905(var5 - 73, var15 - 20);
               var0.method4070("Cancel", var5, var15 + 5, 16777215, 0);
            } else {
               short var8;
               if(class33.loginIndex == 2) {
                  var19 = 211;
                  var0.method4070(class33.loginMessage1, class33.loginWindowX + 180, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var0.method4070(class33.loginMessage2, class33.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var0.method4070(class33.loginMessage3, 180 + class33.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var20 += 10;
                  var0.method4124("Login: ", 180 + class33.loginWindowX - 110, var20, 16777215, 0);
                  var21 = 200;

                  for(var6 = class33.username; var0.method4062(var6) > var21; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4124(class226.method4066(var6) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class137.method2909(16776960) + "|":""), class33.loginWindowX + 180 - 70, var20, 16777215, 0);
                  var20 += 15;
                  var0.method4124("Password: " + MessageNode.method767(class33.field764) + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class137.method2909(16776960) + "|":""), 180 + class33.loginWindowX - 108, var20, 16777215, 0);
                  var20 += 15;
                  var7 = 180 + class33.loginWindowX - 80;
                  var8 = 321;
                  class33.field743.method1905(var7 - 73, var8 - 20);
                  var0.method4070("Login", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class33.loginWindowX + 180;
                  class33.field743.method1905(var7 - 73, var8 - 20);
                  var0.method4070("Cancel", var7, var8 + 5, 16777215, 0);
                  var19 = 357;
                  var1.method4070("Forgotten your password? <col=ffffff>Click here.", class33.loginWindowX + 180, var19, 16776960, 0);
               } else if(class33.loginIndex == 3) {
                  var19 = 201;
                  var0.method4070("Invalid username or password.", 180 + class33.loginWindowX, var19, 16776960, 0);
                  var20 = var19 + 20;
                  var1.method4070("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var1.method4070("email address to login. Otherwise please login with your username.", 180 + class33.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var15 = 276;
                  class33.field743.method1905(var5 - 73, var15 - 20);
                  var2.method4070("Try again", var5, 5 + var15, 16777215, 0);
                  var5 = 180 + class33.loginWindowX;
                  var15 = 326;
                  class33.field743.method1905(var5 - 73, var15 - 20);
                  var2.method4070("Forgotten password?", var5, var15 + 5, 16777215, 0);
               } else if(class33.loginIndex == 4) {
                  var0.method4070("Authenticator", class33.loginWindowX + 180, 211, 16776960, 0);
                  var19 = 236;
                  var0.method4070(class33.loginMessage1, 180 + class33.loginWindowX, var19, 16777215, 0);
                  var20 = var19 + 15;
                  var0.method4070(class33.loginMessage2, 180 + class33.loginWindowX, var20, 16777215, 0);
                  var20 += 15;
                  var0.method4070(class33.loginMessage3, class33.loginWindowX + 180, var20, 16777215, 0);
                  var20 += 15;
                  var0.method4124("PIN: " + MessageNode.method767(class157.authCode) + (Client.gameCycle % 40 < 20?class137.method2909(16776960) + "|":""), class33.loginWindowX + 180 - 108, var20, 16777215, 0);
                  var20 -= 8;
                  var0.method4124("Trust this computer", class33.loginWindowX + 180 - 9, var20, 16776960, 0);
                  var20 += 15;
                  var0.method4124("for 30 days: ", class33.loginWindowX + 180 - 9, var20, 16776960, 0);
                  var5 = class33.loginWindowX + 180 - 9 + var0.method4062("for 30 days: ") + 15;
                  var25 = var20 - var0.field3243;
                  ModIcon var16;
                  if(class33.field766) {
                     var16 = class14.field223;
                  } else {
                     var16 = XItemContainer.field236;
                  }

                  var16.method1905(var5, var25);
                  var20 += 15;
                  var22 = 180 + class33.loginWindowX - 80;
                  short var9 = 321;
                  class33.field743.method1905(var22 - 73, var9 - 20);
                  var0.method4070("Continue", var22, var9 + 5, 16777215, 0);
                  var22 = 80 + class33.loginWindowX + 180;
                  class33.field743.method1905(var22 - 73, var9 - 20);
                  var0.method4070("Cancel", var22, 5 + var9, 16777215, 0);
                  var1.method4070("<u=ff>Can\'t Log In?</u>", 180 + class33.loginWindowX, 36 + var9, 255, 0);
               } else if(class33.loginIndex == 5) {
                  var0.method4070("Forgotten your password?", class33.loginWindowX + 180, 201, 16776960, 0);
                  var19 = 221;
                  var2.method4070(class33.loginMessage1, 180 + class33.loginWindowX, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var2.method4070(class33.loginMessage2, 180 + class33.loginWindowX, var20, 16776960, 0);
                  var20 += 15;
                  var2.method4070(class33.loginMessage3, class33.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var20 += 14;
                  var0.method4124("Username/email: ", 180 + class33.loginWindowX - 145, var20, 16777215, 0);
                  var21 = 174;

                  for(var6 = class33.username; var0.method4062(var6) > var21; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4124(class226.method4066(var6) + (Client.gameCycle % 40 < 20?class137.method2909(16776960) + "|":""), class33.loginWindowX + 180 - 34, var20, 16777215, 0);
                  var20 += 15;
                  var7 = 180 + class33.loginWindowX - 80;
                  var8 = 321;
                  class33.field743.method1905(var7 - 73, var8 - 20);
                  var0.method4070("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 180 + class33.loginWindowX + 80;
                  class33.field743.method1905(var7 - 73, var8 - 20);
                  var0.method4070("Back", var7, var8 + 5, 16777215, 0);
               } else if(class33.loginIndex == 6) {
                  var19 = 211;
                  var0.method4070(class33.loginMessage1, class33.loginWindowX + 180, var19, 16776960, 0);
                  var20 = var19 + 15;
                  var0.method4070(class33.loginMessage2, class33.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var0.method4070(class33.loginMessage3, class33.loginWindowX + 180, var20, 16776960, 0);
                  var20 += 15;
                  var5 = class33.loginWindowX + 180;
                  var15 = 321;
                  class33.field743.method1905(var5 - 73, var15 - 20);
                  var0.method4070("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         if(class33.field748 > 0) {
            class34.method736(class33.field748);
            class33.field748 = 0;
         }

         var19 = 256;
         if(class33.field750 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field750 > 768) {
                  class52.field1139[var5] = class34.method727(class109.field1925[var5], class155.field2308[var5], 1024 - class33.field750);
               } else if(class33.field750 > 256) {
                  class52.field1139[var5] = class155.field2308[var5];
               } else {
                  class52.field1139[var5] = class34.method727(class155.field2308[var5], class109.field1925[var5], 256 - class33.field750);
               }
            }
         } else if(class33.field751 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class33.field751 > 768) {
                  class52.field1139[var5] = class34.method727(class109.field1925[var5], class33.field754[var5], 1024 - class33.field751);
               } else if(class33.field751 > 256) {
                  class52.field1139[var5] = class33.field754[var5];
               } else {
                  class52.field1139[var5] = class34.method727(class33.field754[var5], class109.field1925[var5], 256 - class33.field751);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class52.field1139[var5] = class109.field1925[var5];
            }
         }

         class82.method1831(class33.field755, 9, class33.field755 + 128, var19 + 7);
         class33.field745.method1748(class33.field755, 0);
         class82.method1830();
         var5 = 0;
         var25 = class220.bufferProvider.width * 9 + class33.field755;

         int var10;
         int var11;
         int var12;
         int var13;
         int var14;
         int var23;
         for(var7 = 1; var7 < var19 - 1; ++var7) {
            var22 = (var19 - var7) * class33.field768[var7] / var19;
            var23 = 22 + var22;
            if(var23 < 0) {
               var23 = 0;
            }

            var5 += var23;

            for(var10 = var23; var10 < 128; ++var10) {
               var11 = Frames.field1832[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class52.field1139[var11];
                  var14 = class220.bufferProvider.pixels[var25];
                  class220.bufferProvider.pixels[var25++] = (var12 * (var11 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) + (var12 * (var11 & 16711935) + var13 * (var14 & 16711935) & -16711936) >> 8;
               } else {
                  ++var25;
               }
            }

            var25 += class220.bufferProvider.width + var23 - 128;
         }

         class82.method1831(765 + class33.field755 - 128, 9, 765 + class33.field755, var19 + 7);
         class164.field2694.method1748(382 + class33.field755, 0);
         class82.method1830();
         var5 = 0;
         var25 = class33.field755 + 24 + class220.bufferProvider.width * 9 + 637;

         for(var7 = 1; var7 < var19 - 1; ++var7) {
            var22 = class33.field768[var7] * (var19 - var7) / var19;
            var23 = 103 - var22;
            var25 += var22;

            for(var10 = 0; var10 < var23; ++var10) {
               var11 = Frames.field1832[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var13 = 256 - var11;
                  var11 = class52.field1139[var11];
                  var14 = class220.bufferProvider.pixels[var25];
                  class220.bufferProvider.pixels[var25++] = ((var14 & '\uff00') * var13 + (var11 & '\uff00') * var12 & 16711680) + (var13 * (var14 & 16711935) + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var25;
               }
            }

            var5 += 128 - var23;
            var25 += class220.bufferProvider.width - var23 - var22;
         }

         class33.field770[Player.field42.field157?1:0].method1905(class33.field755 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field310 == 0) {
            if(class130.field2103 != null) {
               var20 = class33.field755 + 5;
               var21 = 463;
               byte var26 = 100;
               byte var24 = 35;
               class130.field2103.method1905(var20, var21);
               var0.method4070("World" + " " + Client.world, var20 + var26 / 2, var24 / 2 + var21 - 2, 16777215, 0);
               if(null != World.worldServersDownload) {
                  var1.method4070("Loading...", var20 + var26 / 2, var24 / 2 + var21 + 12, 16777215, 0);
               } else {
                  var1.method4070("Click to switch", var20 + var26 / 2, 12 + var24 / 2 + var21, 16777215, 0);
               }
            } else {
               class130.field2103 = Item.method658(ItemComposition.field1199, "sl_button", "");
            }
         }

         try {
            Graphics var17 = class164.canvas.getGraphics();
            class220.bufferProvider.draw(var17, 0, 0);
         } catch (Exception var18) {
            class164.canvas.repaint();
         }

      }
   }
}
