import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("fs")
public class class174 {
   class174() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "-127633992"
   )
   static void method3312(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field859 = (class32.field755 - Client.field362) / 2;
         class41.loginWindowX = class41.field859 + 202;
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
      int var34;
      int var36;
      int var37;
      int var41;
      if(class41.worldSelectShown) {
         if(null == class8.field73) {
            class8.field73 = class99.method1981(FileOnDisk.indexSprites, "sl_back", "");
         }

         if(null == class30.field718) {
            class30.field718 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_flags", "");
         }

         if(null == class36.field789) {
            class36.field789 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_arrows", "");
         }

         if(null == XGrandExchangeOffer.field45) {
            XGrandExchangeOffer.field45 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4007(class41.field859, 23, 765, 480, 0);
         Rasterizer2D.method4012(class41.field859, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4012(class41.field859 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method3963("Select a world", class41.field859 + 62, 15, 0, -1);
         if(XGrandExchangeOffer.field45 != null) {
            XGrandExchangeOffer.field45[1].method4088(140 + class41.field859, 1);
            var1.method3930("Members only world", class41.field859 + 152, 10, 16777215, -1);
            XGrandExchangeOffer.field45[0].method4088(class41.field859 + 140, 12);
            var1.method3930("Free world", class41.field859 + 152, 21, 16777215, -1);
         }

         if(class36.field789 != null) {
            var34 = class41.field859 + 280;
            if(World.field699[0] == 0 && World.field698[0] == 0) {
               class36.field789[2].method4088(var34, 4);
            } else {
               class36.field789[0].method4088(var34, 4);
            }

            if(World.field699[0] == 0 && World.field698[0] == 1) {
               class36.field789[3].method4088(15 + var34, 4);
            } else {
               class36.field789[1].method4088(var34 + 15, 4);
            }

            var0.method3930("World", var34 + 32, 17, 16777215, -1);
            var5 = 390 + class41.field859;
            if(World.field699[0] == 1 && World.field698[0] == 0) {
               class36.field789[2].method4088(var5, 4);
            } else {
               class36.field789[0].method4088(var5, 4);
            }

            if(World.field699[0] == 1 && World.field698[0] == 1) {
               class36.field789[3].method4088(var5 + 15, 4);
            } else {
               class36.field789[1].method4088(15 + var5, 4);
            }

            var0.method3930("Players", 32 + var5, 17, 16777215, -1);
            var36 = 500 + class41.field859;
            if(World.field699[0] == 2 && World.field698[0] == 0) {
               class36.field789[2].method4088(var36, 4);
            } else {
               class36.field789[0].method4088(var36, 4);
            }

            if(World.field699[0] == 2 && World.field698[0] == 1) {
               class36.field789[3].method4088(15 + var36, 4);
            } else {
               class36.field789[1].method4088(var36 + 15, 4);
            }

            var0.method3930("Location", 32 + var36, 17, 16777215, -1);
            var7 = 610 + class41.field859;
            if(World.field699[0] == 3 && World.field698[0] == 0) {
               class36.field789[2].method4088(var7, 4);
            } else {
               class36.field789[0].method4088(var7, 4);
            }

            if(World.field699[0] == 3 && World.field698[0] == 1) {
               class36.field789[3].method4088(var7 + 15, 4);
            } else {
               class36.field789[1].method4088(15 + var7, 4);
            }

            var0.method3930("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4007(708 + class41.field859, 4, 50, 16, 0);
         var1.method3963("Cancel", 25 + 708 + class41.field859, 16, 16777215, -1);
         class41.field866 = -1;
         if(class8.field73 != null) {
            var4 = 88;
            byte var40 = 19;
            var36 = 765 / (var4 + 1);
            var7 = 480 / (var40 + 1);

            do {
               var37 = var7;
               var9 = var36;
               if(var7 * (var36 - 1) >= World.field708) {
                  --var36;
               }

               if((var7 - 1) * var36 >= World.field708) {
                  --var7;
               }

               if(var36 * (var7 - 1) >= World.field708) {
                  --var7;
               }
            } while(var37 != var7 || var36 != var9);

            var37 = (765 - var36 * var4) / (var36 + 1);
            if(var37 > 5) {
               var37 = 5;
            }

            var9 = (480 - var40 * var7) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var36 * var4 - var37 * (var36 - 1)) / 2;
            var11 = (480 - var7 * var40 - (var7 - 1) * var9) / 2;
            var12 = 23 + var11;
            var41 = class41.field859 + var10;
            var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field708; ++var16) {
               World var17 = World.worldList[var16];
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
               if(var17.method619()) {
                  if(var17.method632()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method600()) {
                  var21 = 16711680;
                  if(var17.method632()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method598()) {
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

               if(class115.field1817 >= var41 && class115.field1818 >= var12 && class115.field1817 < var4 + var41 && class115.field1818 < var40 + var12 && var18) {
                  class41.field866 = var16;
                  class8.field73[var20].method4153(var41, var12, 128, 16777215);
                  var15 = true;
               } else {
                  class8.field73[var20].method4141(var41, var12);
               }

               if(class30.field718 != null) {
                  class30.field718[(var17.method632()?8:0) + var17.location].method4088(var41 + 29, var12);
               }

               var0.method3963(Integer.toString(var17.id), 15 + var41, 5 + var12 + var40 / 2, var21, -1);
               var1.method3963(var19, var41 + 60, var12 + var40 / 2 + 5, 268435455, -1);
               var12 += var9 + var40;
               ++var14;
               if(var14 >= var7) {
                  var12 = var11 + 23;
                  var41 += var4 + var37;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3897(World.worldList[class41.field866].activity) + 6;
               int var22 = var1.field3117 + 8;
               Rasterizer2D.method4007(class115.field1817 - var16 / 2, 5 + class115.field1818 + 20, var16, var22, 16777120);
               Rasterizer2D.method4013(class115.field1817 - var16 / 2, 20 + class115.field1818 + 5, var16, var22, 0);
               var1.method3963(World.worldList[class41.field866].activity, class115.field1817, var1.field3117 + 5 + class115.field1818 + 20 + 4, 0, -1);
            }
         }

         try {
            var23 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            Projectile.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field838.method4141(class41.field859, 0);
            class1.field7.method4141(class41.field859 + 382, 0);
            class41.field839.method4088(382 + class41.field859 - class41.field839.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3963("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4013(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4013(180 + class41.loginWindowX - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4007(180 + class41.loginWindowX - 150, 2 + var5, class41.field851 * 3, 30, 9179409);
            Rasterizer2D.method4007(class41.loginWindowX + 180 - 150 + class41.field851 * 3, 2 + var5, 300 - class41.field851 * 3, 30, 0);
            var0.method3963(class41.field852, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class41.field836.method4088(180 + class41.loginWindowX - class41.field836.originalWidth / 2, 271 - class41.field836.height / 2);
            var33 = 211;
            var0.method3963(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method3963(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
            var34 += 15;
            var0.method3963(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class41.loginIndex != 4) {
               var0.method3930("Login: ", class41.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3897(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3930(FontTypeFace.method3900(var24), class41.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               String var27 = class41.password;
               String var28 = class165.method3197('*', var27.length());
               var0.method3930(var26 + var28, 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field836.method4088(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var33 = 251;
               var0.method3963("Welcome to RuneScape", 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = 180 + class41.loginWindowX - 80;
               var6 = 291;
               class88.field1561.method4088(var5 - 73, var6 - 20);
               var0.method3905("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class88.field1561.method4088(var5 - 73, var6 - 20);
               var0.method3905("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3963(class41.field854, 180 + class41.loginWindowX, 211, 16776960, 0);
               var33 = 236;
               var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method3963(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method3963(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 321;
               class88.field1561.method4088(var5 - 73, var6 - 20);
               var0.method3963("Continue", var5, 5 + var6, 16777215, 0);
               var5 = 180 + class41.loginWindowX + 80;
               class88.field1561.method4088(var5 - 73, var6 - 20);
               var0.method3963("Cancel", var5, var6 + 5, 16777215, 0);
            } else {
               short var8;
               if(class41.loginIndex == 2) {
                  var33 = 211;
                  var0.method3963(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
                  var34 = var33 + 15;
                  var0.method3963(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
                  var34 += 15;
                  var0.method3963(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16776960, 0);
                  var34 += 15;
                  var34 += 10;
                  var0.method3930("Login: ", class41.loginWindowX + 180 - 110, var34, 16777215, 0);
                  var35 = 200;

                  for(var24 = class41.username; var0.method3897(var24) > var35; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3930(FontTypeFace.method3900(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), 180 + class41.loginWindowX - 70, var34, 16777215, 0);
                  var34 += 15;
                  var0.method3930("Password: " + class212.method3983(class41.password) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), class41.loginWindowX + 180 - 108, var34, 16777215, 0);
                  var34 += 15;
                  var7 = class41.loginWindowX + 180 - 80;
                  var8 = 321;
                  class88.field1561.method4088(var7 - 73, var8 - 20);
                  var0.method3963("Login", var7, 5 + var8, 16777215, 0);
                  var7 = class41.loginWindowX + 180 + 80;
                  class88.field1561.method4088(var7 - 73, var8 - 20);
                  var0.method3963("Cancel", var7, 5 + var8, 16777215, 0);
                  var33 = 357;
                  var1.method3963("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var33, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var33 = 201;
                  var0.method3963("Invalid username or password.", 180 + class41.loginWindowX, var33, 16776960, 0);
                  var34 = var33 + 20;
                  var1.method3963("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var34, 16776960, 0);
                  var34 += 15;
                  var1.method3963("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var34, 16776960, 0);
                  var34 += 15;
                  var5 = 180 + class41.loginWindowX;
                  var6 = 276;
                  class88.field1561.method4088(var5 - 73, var6 - 20);
                  var2.method3963("Try again", var5, var6 + 5, 16777215, 0);
                  var5 = 180 + class41.loginWindowX;
                  var6 = 326;
                  class88.field1561.method4088(var5 - 73, var6 - 20);
                  var2.method3963("Forgotten password?", var5, 5 + var6, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3963("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
                  var33 = 236;
                  var0.method3963(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
                  var34 = var33 + 15;
                  var0.method3963(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16777215, 0);
                  var34 += 15;
                  var0.method3963(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
                  var34 += 15;
                  var24 = "PIN: ";
                  var26 = Ignore.authCode;
                  String var25 = class165.method3197('*', var26.length());
                  var0.method3930(var24 + var25 + (Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), 180 + class41.loginWindowX - 108, var34, 16777215, 0);
                  var34 -= 8;
                  var0.method3930("Trust this computer", class41.loginWindowX + 180 - 9, var34, 16776960, 0);
                  var34 += 15;
                  var0.method3930("for 30 days: ", 180 + class41.loginWindowX - 9, var34, 16776960, 0);
                  var9 = class41.loginWindowX + 180 - 9 + var0.method3897("for 30 days: ") + 15;
                  var10 = var34 - var0.field3117;
                  ModIcon var30;
                  if(class41.field861) {
                     var30 = class47.field951;
                  } else {
                     var30 = class172.field2373;
                  }

                  var30.method4088(var9, var10);
                  var34 += 15;
                  var12 = 180 + class41.loginWindowX - 80;
                  short var13 = 321;
                  class88.field1561.method4088(var12 - 73, var13 - 20);
                  var0.method3963("Continue", var12, 5 + var13, 16777215, 0);
                  var12 = 80 + 180 + class41.loginWindowX;
                  class88.field1561.method4088(var12 - 73, var13 - 20);
                  var0.method3963("Cancel", var12, 5 + var13, 16777215, 0);
                  var1.method3963("<u=ff>Can\'t Log In?</u>", 180 + class41.loginWindowX, 36 + var13, 255, 0);
               } else if(class41.loginIndex == 5) {
                  var0.method3963("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
                  var33 = 221;
                  var2.method3963(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
                  var34 = var33 + 15;
                  var2.method3963(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
                  var34 += 15;
                  var2.method3963(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
                  var34 += 15;
                  var34 += 14;
                  var0.method3930("Username/email: ", class41.loginWindowX + 180 - 145, var34, 16777215, 0);
                  var35 = 174;

                  for(var24 = class41.username; var0.method3897(var24) > var35; var24 = var24.substring(1)) {
                     ;
                  }

                  var0.method3930(FontTypeFace.method3900(var24) + (Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), 180 + class41.loginWindowX - 34, var34, 16777215, 0);
                  var34 += 15;
                  var7 = 180 + class41.loginWindowX - 80;
                  var8 = 321;
                  class88.field1561.method4088(var7 - 73, var8 - 20);
                  var0.method3963("Recover", var7, 5 + var8, 16777215, 0);
                  var7 = 80 + class41.loginWindowX + 180;
                  class88.field1561.method4088(var7 - 73, var8 - 20);
                  var0.method3963("Back", var7, 5 + var8, 16777215, 0);
               } else if(class41.loginIndex == 6) {
                  var33 = 211;
                  var0.method3963(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
                  var34 = var33 + 15;
                  var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
                  var34 += 15;
                  var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
                  var34 += 15;
                  var5 = class41.loginWindowX + 180;
                  var6 = 321;
                  class88.field1561.method4088(var5 - 73, var6 - 20);
                  var0.method3963("Back", var5, 5 + var6, 16777215, 0);
               }
            }
         }

         if(class41.field849 > 0) {
            GroundObject.method1565(class41.field849);
            class41.field849 = 0;
         }

         var33 = 256;
         if(class41.field845 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field845 > 768) {
                  class137.field1933[var5] = VertexNormal.method1666(class63.field1122[var5], Friend.field158[var5], 1024 - class41.field845);
               } else if(class41.field845 > 256) {
                  class137.field1933[var5] = Friend.field158[var5];
               } else {
                  class137.field1933[var5] = VertexNormal.method1666(Friend.field158[var5], class63.field1122[var5], 256 - class41.field845);
               }
            }
         } else if(class41.field846 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class41.field846 > 768) {
                  class137.field1933[var5] = VertexNormal.method1666(class63.field1122[var5], class41.field867[var5], 1024 - class41.field846);
               } else if(class41.field846 > 256) {
                  class137.field1933[var5] = class41.field867[var5];
               } else {
                  class137.field1933[var5] = VertexNormal.method1666(class41.field867[var5], class63.field1122[var5], 256 - class41.field846);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class137.field1933[var5] = class63.field1122[var5];
            }
         }

         Rasterizer2D.method4001(class41.field859, 9, 128 + class41.field859, var33 + 7);
         class41.field838.method4141(class41.field859, 0);
         Rasterizer2D.method4000();
         var5 = 0;
         var36 = class115.bufferProvider.width * 9 + class41.field859;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = class41.field843[var7] * (var33 - var7) / var33;
            var9 = 22 + var37;
            if(var9 < 0) {
               var9 = 0;
            }

            var5 += var9;

            for(var10 = var9; var10 < 128; ++var10) {
               var11 = class25.field603[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var41 = 256 - var11;
                  var11 = class137.field1933[var11];
                  var14 = class115.bufferProvider.pixels[var36];
                  class115.bufferProvider.pixels[var36++] = (var12 * (var11 & 16711935) + (var14 & 16711935) * var41 & -16711936) + (var12 * (var11 & '\uff00') + var41 * (var14 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var36;
               }
            }

            var36 += var9 + class115.bufferProvider.width - 128;
         }

         Rasterizer2D.method4001(class41.field859 + 765 - 128, 9, 765 + class41.field859, 7 + var33);
         class1.field7.method4141(class41.field859 + 382, 0);
         Rasterizer2D.method4000();
         var5 = 0;
         var36 = class115.bufferProvider.width * 9 + 24 + 637 + class41.field859;

         for(var7 = 1; var7 < var33 - 1; ++var7) {
            var37 = (var33 - var7) * class41.field843[var7] / var33;
            var9 = 103 - var37;
            var36 += var37;

            for(var10 = 0; var10 < var9; ++var10) {
               var11 = class25.field603[var5++];
               if(var11 != 0) {
                  var12 = var11;
                  var41 = 256 - var11;
                  var11 = class137.field1933[var11];
                  var14 = class115.bufferProvider.pixels[var36];
                  class115.bufferProvider.pixels[var36++] = (var12 * (var11 & '\uff00') + var41 * (var14 & '\uff00') & 16711680) + (var41 * (var14 & 16711935) + (var11 & 16711935) * var12 & -16711936) >> 8;
               } else {
                  ++var36;
               }
            }

            var5 += 128 - var9;
            var36 += class115.bufferProvider.width - var9 - var37;
         }

         class41.field840[class148.field2058.field719?1:0].method4088(765 + class41.field859 - 40, 463);
         if(Client.gameState > 5 && Client.field308 == 0) {
            if(null != CollisionData.field1858) {
               var34 = 5 + class41.field859;
               var35 = 463;
               byte var39 = 100;
               byte var38 = 35;
               CollisionData.field1858.method4088(var34, var35);
               var0.method3963("World" + " " + Client.world, var39 / 2 + var34, var35 + var38 / 2 - 2, 16777215, 0);
               if(class15.worldServersDownload != null) {
                  var1.method3963("Loading...", var34 + var39 / 2, var38 / 2 + var35 + 12, 16777215, 0);
               } else {
                  var1.method3963("Click to switch", var34 + var39 / 2, var38 / 2 + var35 + 12, 16777215, 0);
               }
            } else {
               CollisionData.field1858 = XGrandExchangeOffer.method30(FileOnDisk.indexSprites, "sl_button", "");
            }
         }

         try {
            var23 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            Projectile.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;I)V",
      garbageValue = "828301632"
   )
   public static void method3313(CipherBuffer var0) {
      ClassInfo var1 = (ClassInfo)class227.field3244.method2442();
      if(null != var1) {
         int var2 = var0.offset;
         var0.putInt(var1.field3236);

         for(int var3 = 0; var3 < var1.field3240; ++var3) {
            if(var1.field3235[var3] != 0) {
               var0.putByte(var1.field3235[var3]);
            } else {
               try {
                  int var4 = var1.field3237[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3238[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(null == var11) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.method2931((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.method2889(var2);
         var1.unlink();
      }
   }
}
