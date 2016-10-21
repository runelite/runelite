import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class145 {
   @ObfuscatedName("e")
   public static class170 field2224;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass227;Lclass227;Lclass227;ZI)V",
      garbageValue = "-9264586"
   )
   static void method3008(class227 var0, class227 var1, class227 var2, boolean var3) {
      if(var3) {
         class33.field720 = (class153.field2296 - Client.field436) / 2;
         class33.loginWindowX = class33.field720 + 202;
      }

      if(class33.worldSelectShown) {
         World.method616(var0, var1);
      } else {
         if(var3) {
            class33.field731.method1761(class33.field720, 0);
            class33.field725.method1761(class33.field720 + 382, 0);
            class33.field749.method1913(class33.field720 + 382 - class33.field749.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4099("RuneScape is loading - please wait...", class33.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class82.method1852(180 + class33.loginWindowX - 152, var5, 304, 34, 9179409);
            class82.method1852(class33.loginWindowX + 180 - 151, 1 + var5, 302, 32, 0);
            class82.method1861(class33.loginWindowX + 180 - 150, var5 + 2, class33.field741 * 3, 30, 9179409);
            class82.method1861(class33.field741 * 3 + (180 + class33.loginWindowX - 150), 2 + var5, 300 - class33.field741 * 3, 30, 0);
            var0.method4099(class33.field742, class33.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var14;
         int var15;
         short var16;
         if(Client.gameState == 20) {
            class33.field748.method1913(180 + class33.loginWindowX - class33.field748.originalWidth / 2, 271 - class33.field748.height / 2);
            var14 = 211;
            var0.method4099(class33.loginMessage1, class33.loginWindowX + 180, var14, 16776960, 0);
            var15 = var14 + 15;
            var0.method4099(class33.loginMessage2, class33.loginWindowX + 180, var15, 16776960, 0);
            var15 += 15;
            var0.method4099(class33.loginMessage3, 180 + class33.loginWindowX, var15, 16776960, 0);
            var15 += 15;
            var15 += 10;
            if(class33.loginIndex != 4) {
               var0.method4096("Login: ", 180 + class33.loginWindowX - 110, var15, 16777215, 0);
               var16 = 200;

               for(var6 = class33.username; var0.method4091(var6) > var16; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4096(class226.method4170(var6), class33.loginWindowX + 180 - 70, var15, 16777215, 0);
               var15 += 15;
               var0.method4096("Password: " + class139.method2929(class33.field724), class33.loginWindowX + 180 - 108, var15, 16777215, 0);
               var15 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class33.field748.method1913(class33.loginWindowX, 171);
            short var10;
            if(class33.loginIndex == 0) {
               var14 = 251;
               var0.method4099("Welcome to RuneScape", class33.loginWindowX + 180, var14, 16776960, 0);
               var15 = var14 + 30;
               var5 = class33.loginWindowX + 180 - 80;
               var10 = 291;
               class33.field722.method1913(var5 - 73, var10 - 20);
               var0.method4125("New User", var5 - 73, var10 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class33.loginWindowX + 180 + 80;
               class33.field722.method1913(var5 - 73, var10 - 20);
               var0.method4125("Existing User", var5 - 73, var10 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class33.loginIndex == 1) {
               var0.method4099(class33.field740, class33.loginWindowX + 180, 211, 16776960, 0);
               var14 = 236;
               var0.method4099(class33.loginMessage1, 180 + class33.loginWindowX, var14, 16777215, 0);
               var15 = var14 + 15;
               var0.method4099(class33.loginMessage2, class33.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var0.method4099(class33.loginMessage3, class33.loginWindowX + 180, var15, 16777215, 0);
               var15 += 15;
               var5 = class33.loginWindowX + 180 - 80;
               var10 = 321;
               class33.field722.method1913(var5 - 73, var10 - 20);
               var0.method4099("Continue", var5, var10 + 5, 16777215, 0);
               var5 = class33.loginWindowX + 180 + 80;
               class33.field722.method1913(var5 - 73, var10 - 20);
               var0.method4099("Cancel", var5, 5 + var10, 16777215, 0);
            } else {
               int var7;
               short var8;
               if(class33.loginIndex == 2) {
                  var14 = 211;
                  var0.method4099(class33.loginMessage1, 180 + class33.loginWindowX, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.method4099(class33.loginMessage2, class33.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4099(class33.loginMessage3, 180 + class33.loginWindowX, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 10;
                  var0.method4096("Login: ", class33.loginWindowX + 180 - 110, var15, 16777215, 0);
                  var16 = 200;

                  for(var6 = class33.username; var0.method4091(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4096(class226.method4170(var6) + (class33.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class92.method2126(16776960) + "|":""), class33.loginWindowX + 180 - 70, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4096("Password: " + class139.method2929(class33.field724) + (class33.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class92.method2126(16776960) + "|":""), 180 + class33.loginWindowX - 108, var15, 16777215, 0);
                  var15 += 15;
                  var7 = class33.loginWindowX + 180 - 80;
                  var8 = 321;
                  class33.field722.method1913(var7 - 73, var8 - 20);
                  var0.method4099("Login", var7, 5 + var8, 16777215, 0);
                  var7 = class33.loginWindowX + 180 + 80;
                  class33.field722.method1913(var7 - 73, var8 - 20);
                  var0.method4099("Cancel", var7, var8 + 5, 16777215, 0);
                  var14 = 357;
                  var1.method4099("Forgotten your password? <col=ffffff>Click here.", 180 + class33.loginWindowX, var14, 16776960, 0);
               } else if(class33.loginIndex == 3) {
                  var14 = 201;
                  var0.method4099("Invalid username or password.", 180 + class33.loginWindowX, var14, 16776960, 0);
                  var15 = var14 + 20;
                  var1.method4099("For accounts created after 24th November 2010, please use your", class33.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var1.method4099("email address to login. Otherwise please login with your username.", 180 + class33.loginWindowX, var15, 16776960, 0);
                  var15 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var10 = 276;
                  class33.field722.method1913(var5 - 73, var10 - 20);
                  var2.method4099("Try again", var5, var10 + 5, 16777215, 0);
                  var5 = 180 + class33.loginWindowX;
                  var10 = 326;
                  class33.field722.method1913(var5 - 73, var10 - 20);
                  var2.method4099("Forgotten password?", var5, 5 + var10, 16777215, 0);
               } else if(class33.loginIndex == 4) {
                  var0.method4099("Authenticator", 180 + class33.loginWindowX, 211, 16776960, 0);
                  var14 = 236;
                  var0.method4099(class33.loginMessage1, 180 + class33.loginWindowX, var14, 16777215, 0);
                  var15 = var14 + 15;
                  var0.method4099(class33.loginMessage2, class33.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4099(class33.loginMessage3, class33.loginWindowX + 180, var15, 16777215, 0);
                  var15 += 15;
                  var0.method4096("PIN: " + class139.method2929(class20.authCode) + (Client.gameCycle % 40 < 20?class92.method2126(16776960) + "|":""), class33.loginWindowX + 180 - 108, var15, 16777215, 0);
                  var15 -= 8;
                  var0.method4096("Trust this computer", 180 + class33.loginWindowX - 9, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4096("for 30 days: ", 180 + class33.loginWindowX - 9, var15, 16776960, 0);
                  var5 = class33.loginWindowX + 180 - 9 + var0.method4091("for 30 days: ") + 15;
                  int var19 = var15 - var0.field3245;
                  ModIcon var11;
                  if(class33.field751) {
                     var11 = class33.field728;
                  } else {
                     var11 = class33.field727;
                  }

                  var11.method1913(var5, var19);
                  var15 += 15;
                  int var18 = class33.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class33.field722.method1913(var18 - 73, var9 - 20);
                  var0.method4099("Continue", var18, var9 + 5, 16777215, 0);
                  var18 = 80 + 180 + class33.loginWindowX;
                  class33.field722.method1913(var18 - 73, var9 - 20);
                  var0.method4099("Cancel", var18, 5 + var9, 16777215, 0);
                  var1.method4099("<u=ff>Can\'t Log In?</u>", 180 + class33.loginWindowX, var9 + 36, 255, 0);
               } else if(class33.loginIndex == 5) {
                  var0.method4099("Forgotten your password?", 180 + class33.loginWindowX, 201, 16776960, 0);
                  var14 = 221;
                  var2.method4099(class33.loginMessage1, class33.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var2.method4099(class33.loginMessage2, 180 + class33.loginWindowX, var15, 16776960, 0);
                  var15 += 15;
                  var2.method4099(class33.loginMessage3, 180 + class33.loginWindowX, var15, 16776960, 0);
                  var15 += 15;
                  var15 += 14;
                  var0.method4096("Username/email: ", class33.loginWindowX + 180 - 145, var15, 16777215, 0);
                  var16 = 174;

                  for(var6 = class33.username; var0.method4091(var6) > var16; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4096(class226.method4170(var6) + (Client.gameCycle % 40 < 20?class92.method2126(16776960) + "|":""), class33.loginWindowX + 180 - 34, var15, 16777215, 0);
                  var15 += 15;
                  var7 = 180 + class33.loginWindowX - 80;
                  var8 = 321;
                  class33.field722.method1913(var7 - 73, var8 - 20);
                  var0.method4099("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class33.loginWindowX + 180 + 80;
                  class33.field722.method1913(var7 - 73, var8 - 20);
                  var0.method4099("Back", var7, 5 + var8, 16777215, 0);
               } else if(class33.loginIndex == 6) {
                  var14 = 211;
                  var0.method4099(class33.loginMessage1, class33.loginWindowX + 180, var14, 16776960, 0);
                  var15 = var14 + 15;
                  var0.method4099(class33.loginMessage2, class33.loginWindowX + 180, var15, 16776960, 0);
                  var15 += 15;
                  var0.method4099(class33.loginMessage3, 180 + class33.loginWindowX, var15, 16776960, 0);
                  var15 += 15;
                  var5 = 180 + class33.loginWindowX;
                  var10 = 321;
                  class33.field722.method1913(var5 - 73, var10 - 20);
                  var0.method4099("Back", var5, 5 + var10, 16777215, 0);
               }
            }
         }

         if(class33.field719 > 0) {
            class180.method3519(class33.field719);
            class33.field719 = 0;
         }

         class54.method1100();
         class168.field2699[class16.field232.field138?1:0].method1913(765 + class33.field720 - 40, 463);
         if(Client.gameState > 5 && Client.field287 == 0) {
            if(class8.field142 != null) {
               var15 = class33.field720 + 5;
               var16 = 463;
               byte var20 = 100;
               byte var17 = 35;
               class8.field142.method1913(var15, var16);
               var0.method4099("World" + " " + Client.world, var15 + var20 / 2, var16 + var17 / 2 - 2, 16777215, 0);
               if(class13.worldServersDownload != null) {
                  var1.method4099("Loading...", var20 / 2 + var15, var16 + var17 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4099("Click to switch", var20 / 2 + var15, 12 + var16 + var17 / 2, 16777215, 0);
               }
            } else {
               class8.field142 = WidgetNode.method47(Item.field690, "sl_button", "");
            }
         }

         try {
            Graphics var12 = GameObject.canvas.getGraphics();
            XClanMember.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var13) {
            GameObject.canvas.repaint();
         }

      }
   }
}
