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
      String var17;
      if(class41.worldSelectShown) {
         if(class8.field73 == null) {
            class8.field73 = class99.method1981(FileOnDisk.indexSprites, "sl_back", "");
         }

         if(Preferences.field718 == null) {
            Preferences.field718 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_flags", "");
         }

         if(class36.field789 == null) {
            class36.field789 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_arrows", "");
         }

         if(XGrandExchangeOffer.field45 == null) {
            XGrandExchangeOffer.field45 = ItemComposition.method3719(FileOnDisk.indexSprites, "sl_stars", "");
         }

         Rasterizer2D.method4007(class41.field859, 23, 765, 480, 0);
         Rasterizer2D.method4012(class41.field859, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method4012(class41.field859 + 125, 0, 640, 23, 5197647, 2697513);
         var0.method3963("Select a world", class41.field859 + 62, 15, 0, -1);
         if(XGrandExchangeOffer.field45 != null) {
            XGrandExchangeOffer.field45[1].method4088(class41.field859 + 140, 1);
            var1.method3930("Members only world", class41.field859 + 152, 10, 16777215, -1);
            XGrandExchangeOffer.field45[0].method4088(class41.field859 + 140, 12);
            var1.method3930("Free world", class41.field859 + 152, 21, 16777215, -1);
         }

         if(class36.field789 != null) {
            var13 = class41.field859 + 280;
            if(World.field699[0] == 0 && World.field698[0] == 0) {
               class36.field789[2].method4088(var13, 4);
            } else {
               class36.field789[0].method4088(var13, 4);
            }

            if(World.field699[0] == 0 && World.field698[0] == 1) {
               class36.field789[3].method4088(var13 + 15, 4);
            } else {
               class36.field789[1].method4088(var13 + 15, 4);
            }

            var0.method3930("World", var13 + 32, 17, 16777215, -1);
            var5 = class41.field859 + 390;
            if(World.field699[0] == 1 && World.field698[0] == 0) {
               class36.field789[2].method4088(var5, 4);
            } else {
               class36.field789[0].method4088(var5, 4);
            }

            if(World.field699[0] == 1 && World.field698[0] == 1) {
               class36.field789[3].method4088(var5 + 15, 4);
            } else {
               class36.field789[1].method4088(var5 + 15, 4);
            }

            var0.method3930("Players", var5 + 32, 17, 16777215, -1);
            var14 = class41.field859 + 500;
            if(World.field699[0] == 2 && World.field698[0] == 0) {
               class36.field789[2].method4088(var14, 4);
            } else {
               class36.field789[0].method4088(var14, 4);
            }

            if(World.field699[0] == 2 && World.field698[0] == 1) {
               class36.field789[3].method4088(var14 + 15, 4);
            } else {
               class36.field789[1].method4088(var14 + 15, 4);
            }

            var0.method3930("Location", var14 + 32, 17, 16777215, -1);
            var6 = class41.field859 + 610;
            if(World.field699[0] == 3 && World.field698[0] == 0) {
               class36.field789[2].method4088(var6, 4);
            } else {
               class36.field789[0].method4088(var6, 4);
            }

            if(World.field699[0] == 3 && World.field698[0] == 1) {
               class36.field789[3].method4088(var6 + 15, 4);
            } else {
               class36.field789[1].method4088(var6 + 15, 4);
            }

            var0.method3930("Type", var6 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4007(class41.field859 + 708, 4, 50, 16, 0);
         var1.method3963("Cancel", class41.field859 + 733, 16, 16777215, -1);
         class41.field866 = -1;
         if(class8.field73 != null) {
            var4 = 88;
            byte var18 = 19;
            var14 = 765 / (var4 + 1);
            var6 = 480 / (var18 + 1);

            while(true) {
               var15 = var6;
               var7 = var14;
               if(var6 * (var14 - 1) >= World.field708) {
                  --var14;
               }

               if((var6 - 1) * var14 >= World.field708) {
                  --var6;
               }

               if(var14 * (var6 - 1) >= World.field708) {
                  --var6;
               }

               if(var15 == var6 && var14 == var7) {
                  var15 = (765 - var14 * var4) / (var14 + 1);
                  if(var15 > 5) {
                     var15 = 5;
                  }

                  var7 = (480 - var18 * var6) / (var6 + 1);
                  if(var7 > 5) {
                     var7 = 5;
                  }

                  var8 = (765 - var14 * var4 - var15 * (var14 - 1)) / 2;
                  var9 = (480 - var6 * var18 - (var6 - 1) * var7) / 2;
                  var10 = var9 + 23;
                  var16 = class41.field859 + var8;
                  var11 = 0;
                  boolean var19 = false;

                  int var20;
                  for(var20 = 0; var20 < World.field708; ++var20) {
                     World var21 = World.worldList[var20];
                     boolean var22 = true;
                     var17 = Integer.toString(var21.playerCount);
                     if(var21.playerCount == -1) {
                        var17 = "OFF";
                        var22 = false;
                     } else if(var21.playerCount > 1980) {
                        var17 = "FULL";
                        var22 = false;
                     }

                     int var23 = 0;
                     byte var24;
                     if(var21.method619()) {
                        if(var21.method632()) {
                           var24 = 7;
                        } else {
                           var24 = 6;
                        }
                     } else if(var21.method600()) {
                        var23 = 16711680;
                        if(var21.method632()) {
                           var24 = 5;
                        } else {
                           var24 = 4;
                        }
                     } else if(var21.method598()) {
                        if(var21.method632()) {
                           var24 = 3;
                        } else {
                           var24 = 2;
                        }
                     } else if(var21.method632()) {
                        var24 = 1;
                     } else {
                        var24 = 0;
                     }

                     if(class115.field1817 >= var16 && class115.field1818 >= var10 && class115.field1817 < var4 + var16 && class115.field1818 < var18 + var10 && var22) {
                        class41.field866 = var20;
                        class8.field73[var24].method4153(var16, var10, 128, 16777215);
                        var19 = true;
                     } else {
                        class8.field73[var24].method4141(var16, var10);
                     }

                     if(Preferences.field718 != null) {
                        Preferences.field718[(var21.method632()?8:0) + var21.location].method4088(var16 + 29, var10);
                     }

                     var0.method3963(Integer.toString(var21.id), var16 + 15, var10 + 5 + var18 / 2, var23, -1);
                     var1.method3963(var17, var16 + 60, var10 + var18 / 2 + 5, 268435455, -1);
                     var10 += var7 + var18;
                     ++var11;
                     if(var11 >= var6) {
                        var10 = var9 + 23;
                        var16 += var4 + var15;
                        var11 = 0;
                     }
                  }

                  if(var19) {
                     var20 = var1.method3897(World.worldList[class41.field866].activity) + 6;
                     int var32 = var1.field3117 + 8;
                     Rasterizer2D.method4007(class115.field1817 - var20 / 2, class115.field1818 + 5 + 20, var20, var32, 16777120);
                     Rasterizer2D.method4013(class115.field1817 - var20 / 2, class115.field1818 + 20 + 5, var20, var32, 0);
                     var1.method3963(World.worldList[class41.field866].activity, class115.field1817, var1.field3117 + 5 + class115.field1818 + 20 + 4, 0, -1);
                  }
                  break;
               }
            }
         }

         try {
            var12 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var28) {
            Projectile.canvas.repaint();
         }
      } else {
         if(var3) {
            class41.field838.method4141(class41.field859, 0);
            class1.field7.method4141(class41.field859 + 382, 0);
            class41.field839.method4088(class41.field859 + 382 - class41.field839.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3963("RuneScape is loading - please wait...", class41.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4013(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4013(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4007(class41.loginWindowX + 180 - 150, var5 + 2, class41.field851 * 3, 30, 9179409);
            Rasterizer2D.method4007(class41.loginWindowX + 180 - 150 + class41.field851 * 3, var5 + 2, 300 - class41.field851 * 3, 30, 0);
            var0.method3963(class41.field852, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var29;
         String var30;
         short var31;
         short var33;
         if(Client.gameState == 20) {
            class41.field836.method4088(class41.loginWindowX + 180 - class41.field836.originalWidth / 2, 271 - class41.field836.height / 2);
            var31 = 211;
            var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16776960, 0);
            var13 = var31 + 15;
            var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var13 += 10;
            if(class41.loginIndex != 4) {
               var0.method3930("Login: ", class41.loginWindowX + 180 - 110, var13, 16777215, 0);
               var33 = 200;

               for(var29 = class41.username; var0.method3897(var29) > var33; var29 = var29.substring(0, var29.length() - 1)) {
                  ;
               }

               var0.method3930(FontTypeFace.method3900(var29), class41.loginWindowX + 180 - 70, var13, 16777215, 0);
               var13 += 15;
               var30 = "Password: ";
               String var34 = class41.password;
               var17 = class165.method3197('*', var34.length());
               var0.method3930(var30 + var17, class41.loginWindowX + 180 - 108, var13, 16777215, 0);
               var13 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field836.method4088(class41.loginWindowX, 171);
            short var35;
            if(class41.loginIndex == 0) {
               var31 = 251;
               var0.method3963("Welcome to RuneScape", class41.loginWindowX + 180, var31, 16776960, 0);
               var13 = var31 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var35 = 291;
               class88.field1561.method4088(var5 - 73, var35 - 20);
               var0.method3905("New User", var5 - 73, var35 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class88.field1561.method4088(var5 - 73, var35 - 20);
               var0.method3905("Existing User", var5 - 73, var35 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3963(class41.field854, class41.loginWindowX + 180, 211, 16776960, 0);
               var31 = 236;
               var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16777215, 0);
               var13 = var31 + 15;
               var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var35 = 321;
               class88.field1561.method4088(var5 - 73, var35 - 20);
               var0.method3963("Continue", var5, var35 + 5, 16777215, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class88.field1561.method4088(var5 - 73, var35 - 20);
               var0.method3963("Cancel", var5, var35 + 5, 16777215, 0);
            } else {
               short var36;
               if(class41.loginIndex == 2) {
                  var31 = 211;
                  var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16776960, 0);
                  var13 = var31 + 15;
                  var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 10;
                  var0.method3930("Login: ", class41.loginWindowX + 180 - 110, var13, 16777215, 0);
                  var33 = 200;

                  for(var29 = class41.username; var0.method3897(var29) > var33; var29 = var29.substring(1)) {
                     ;
                  }

                  var0.method3930(FontTypeFace.method3900(var29) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), class41.loginWindowX + 180 - 70, var13, 16777215, 0);
                  var13 += 15;
                  var0.method3930("Password: " + class212.method3983(class41.password) + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), class41.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 += 15;
                  var6 = class41.loginWindowX + 180 - 80;
                  var36 = 321;
                  class88.field1561.method4088(var6 - 73, var36 - 20);
                  var0.method3963("Login", var6, var36 + 5, 16777215, 0);
                  var6 = class41.loginWindowX + 180 + 80;
                  class88.field1561.method4088(var6 - 73, var36 - 20);
                  var0.method3963("Cancel", var6, var36 + 5, 16777215, 0);
                  var31 = 357;
                  var1.method3963("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var31, 16776960, 0);
               } else if(class41.loginIndex == 3) {
                  var31 = 201;
                  var0.method3963("Invalid username or password.", class41.loginWindowX + 180, var31, 16776960, 0);
                  var13 = var31 + 20;
                  var1.method3963("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var1.method3963("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var5 = class41.loginWindowX + 180;
                  var35 = 276;
                  class88.field1561.method4088(var5 - 73, var35 - 20);
                  var2.method3963("Try again", var5, var35 + 5, 16777215, 0);
                  var5 = class41.loginWindowX + 180;
                  var35 = 326;
                  class88.field1561.method4088(var5 - 73, var35 - 20);
                  var2.method3963("Forgotten password?", var5, var35 + 5, 16777215, 0);
               } else if(class41.loginIndex == 4) {
                  var0.method3963("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
                  var31 = 236;
                  var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16777215, 0);
                  var13 = var31 + 15;
                  var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var29 = "PIN: ";
                  var30 = Ignore.authCode;
                  String var39 = class165.method3197('*', var30.length());
                  var0.method3930(var29 + var39 + (Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), class41.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 -= 8;
                  var0.method3930("Trust this computer", class41.loginWindowX + 180 - 9, var13, 16776960, 0);
                  var13 += 15;
                  var0.method3930("for 30 days: ", class41.loginWindowX + 180 - 9, var13, 16776960, 0);
                  var7 = class41.loginWindowX + 180 - 9 + var0.method3897("for 30 days: ") + 15;
                  var8 = var13 - var0.field3117;
                  ModIcon var25;
                  if(class41.field861) {
                     var25 = class47.field951;
                  } else {
                     var25 = class172.field2373;
                  }

                  var25.method4088(var7, var8);
                  var13 += 15;
                  var10 = class41.loginWindowX + 180 - 80;
                  short var26 = 321;
                  class88.field1561.method4088(var10 - 73, var26 - 20);
                  var0.method3963("Continue", var10, var26 + 5, 16777215, 0);
                  var10 = class41.loginWindowX + 260;
                  class88.field1561.method4088(var10 - 73, var26 - 20);
                  var0.method3963("Cancel", var10, var26 + 5, 16777215, 0);
                  var1.method3963("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var26 + 36, 255, 0);
               } else if(class41.loginIndex != 5) {
                  if(class41.loginIndex == 6) {
                     var31 = 211;
                     var0.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16776960, 0);
                     var13 = var31 + 15;
                     var0.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
                     var13 += 15;
                     var0.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
                     var13 += 15;
                     var5 = class41.loginWindowX + 180;
                     var35 = 321;
                     class88.field1561.method4088(var5 - 73, var35 - 20);
                     var0.method3963("Back", var5, var35 + 5, 16777215, 0);
                  }
               } else {
                  var0.method3963("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
                  var31 = 221;
                  var2.method3963(class41.loginMessage1, class41.loginWindowX + 180, var31, 16776960, 0);
                  var13 = var31 + 15;
                  var2.method3963(class41.loginMessage2, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var2.method3963(class41.loginMessage3, class41.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 14;
                  var0.method3930("Username/email: ", class41.loginWindowX + 180 - 145, var13, 16777215, 0);
                  var33 = 174;

                  for(var29 = class41.username; var0.method3897(var29) > var33; var29 = var29.substring(1)) {
                     ;
                  }

                  var0.method3930(FontTypeFace.method3900(var29) + (Client.gameCycle % 40 < 20?XItemContainer.method153(16776960) + "|":""), class41.loginWindowX + 180 - 34, var13, 16777215, 0);
                  var13 += 15;
                  var6 = class41.loginWindowX + 180 - 80;
                  var36 = 321;
                  class88.field1561.method4088(var6 - 73, var36 - 20);
                  var0.method3963("Recover", var6, var36 + 5, 16777215, 0);
                  var6 = class41.loginWindowX + 80 + 180;
                  class88.field1561.method4088(var6 - 73, var36 - 20);
                  var0.method3963("Back", var6, var36 + 5, 16777215, 0);
               }
            }
         }

         if(class41.field849 > 0) {
            GroundObject.method1565(class41.field849);
            class41.field849 = 0;
         }

         var31 = 256;
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

         Rasterizer2D.method4001(class41.field859, 9, class41.field859 + 128, var31 + 7);
         class41.field838.method4141(class41.field859, 0);
         Rasterizer2D.method4000();
         var5 = 0;
         var14 = class115.bufferProvider.width * 9 + class41.field859;

         for(var6 = 1; var6 < var31 - 1; ++var6) {
            var15 = class41.field843[var6] * (var31 - var6) / var31;
            var7 = var15 + 22;
            if(var7 < 0) {
               var7 = 0;
            }

            var5 += var7;

            for(var8 = var7; var8 < 128; ++var8) {
               var9 = class25.field603[var5++];
               if(var9 != 0) {
                  var10 = var9;
                  var16 = 256 - var9;
                  var9 = class137.field1933[var9];
                  var11 = class115.bufferProvider.pixels[var14];
                  class115.bufferProvider.pixels[var14++] = (var10 * (var9 & 16711935) + (var11 & 16711935) * var16 & -16711936) + (var10 * (var9 & '\uff00') + var16 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var14;
               }
            }

            var14 += var7 + class115.bufferProvider.width - 128;
         }

         Rasterizer2D.method4001(class41.field859 + 765 - 128, 9, class41.field859 + 765, var31 + 7);
         class1.field7.method4141(class41.field859 + 382, 0);
         Rasterizer2D.method4000();
         var5 = 0;
         var14 = class115.bufferProvider.width * 9 + 24 + 637 + class41.field859;

         for(var6 = 1; var6 < var31 - 1; ++var6) {
            var15 = (var31 - var6) * class41.field843[var6] / var31;
            var7 = 103 - var15;
            var14 += var15;

            for(var8 = 0; var8 < var7; ++var8) {
               var9 = class25.field603[var5++];
               if(var9 != 0) {
                  var10 = var9;
                  var16 = 256 - var9;
                  var9 = class137.field1933[var9];
                  var11 = class115.bufferProvider.pixels[var14];
                  class115.bufferProvider.pixels[var14++] = (var10 * (var9 & '\uff00') + var16 * (var11 & '\uff00') & 16711680) + (var16 * (var11 & 16711935) + (var9 & 16711935) * var10 & -16711936) >> 8;
               } else {
                  ++var14;
               }
            }

            var5 += 128 - var7;
            var14 += class115.bufferProvider.width - var7 - var15;
         }

         class41.field840[class148.field2058.field719?1:0].method4088(class41.field859 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field308 == 0) {
            if(CollisionData.field1858 != null) {
               var13 = class41.field859 + 5;
               var33 = 463;
               byte var38 = 100;
               byte var37 = 35;
               CollisionData.field1858.method4088(var13, var33);
               var0.method3963("World " + Client.world, var38 / 2 + var13, var33 + var37 / 2 - 2, 16777215, 0);
               if(class15.worldServersDownload != null) {
                  var1.method3963("Loading...", var13 + var38 / 2, var37 / 2 + var33 + 12, 16777215, 0);
               } else {
                  var1.method3963("Click to switch", var13 + var38 / 2, var37 / 2 + var33 + 12, 16777215, 0);
               }
            } else {
               CollisionData.field1858 = XGrandExchangeOffer.method30(FileOnDisk.indexSprites, "sl_button", "");
            }
         }

         try {
            var12 = Projectile.canvas.getGraphics();
            class115.bufferProvider.draw(var12, 0, 0);
         } catch (Exception var27) {
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
      if(var1 != null) {
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

                  Method var7;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var7 = var1.methods[var3];
                        var6 = var7.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var7 = var1.methods[var3];
                     byte[][] var8 = var1.args[var3];
                     Object[] var9 = new Object[var8.length];

                     for(int var10 = 0; var10 < var8.length; ++var10) {
                        ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                        var9[var10] = var11.readObject();
                     }

                     Object var24 = Reflection.invoke(var7, (Object)null, var9);
                     if(var24 == null) {
                        var0.putByte(0);
                     } else if(var24 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.putByte(2);
                        var0.method2931((String)var24);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var12) {
                  var0.putByte(-10);
               } catch (InvalidClassException var13) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var14) {
                  var0.putByte(-12);
               } catch (OptionalDataException var15) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var16) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var17) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var18) {
                  var0.putByte(-16);
               } catch (SecurityException var19) {
                  var0.putByte(-17);
               } catch (IOException var20) {
                  var0.putByte(-18);
               } catch (NullPointerException var21) {
                  var0.putByte(-19);
               } catch (Exception var22) {
                  var0.putByte(-20);
               } catch (Throwable var23) {
                  var0.putByte(-21);
               }
            }
         }

         var0.method2889(var2);
         var1.unlink();
      }

   }
}
