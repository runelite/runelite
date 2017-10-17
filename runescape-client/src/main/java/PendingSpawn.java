import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("ay")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1651549617
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -312494517
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1876464223
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 844197819
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1704318747
   )
   @Export("level")
   int level;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 353999161
   )
   int field1198;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2022071317
   )
   int field1200;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2026118391
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1909627483
   )
   int field1199;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1977896395
   )
   @Export("id")
   int id;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1825847549
   )
   int field1203;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 751998357
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lju;Lju;Lju;ZI)V",
      garbageValue = "192955221"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1419 = (class60.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1419 + 202;
         WorldMapType2.field539 = class90.loginWindowX + 180;
      }

      if(class90.worldSelectShown) {
         class25.method173(var0, var1);
      } else {
         if(var3) {
            class208.field2603.method5173(class90.field1419, 0);
            ScriptState.field791.method5173(class90.field1419 + 382, 0);
            class90.logoSprite.method5147(class90.field1419 + 382 - class90.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4843("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method5129(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method5129(class90.loginWindowX + 180 - 150 + class90.loadingBarPercentage * 3, var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.method4843(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var9;
         int var11;
         char[] var12;
         int var13;
         char[] var14;
         int var15;
         String var17;
         String var20;
         String var23;
         short var26;
         int var27;
         short var28;
         String var32;
         if(Client.gameState == 20) {
            class90.field1411.method5147(class90.loginWindowX + 180 - class90.field1411.originalWidth / 2, 271 - class90.field1411.height / 2);
            var26 = 201;
            var0.method4843(class90.loginMessage1, class90.loginWindowX + 180, var26, 16776960, 0);
            var27 = var26 + 15;
            var0.method4843(class90.loginMessage2, class90.loginWindowX + 180, var27, 16776960, 0);
            var27 += 15;
            var0.method4843(class90.loginMessage3, class90.loginWindowX + 180, var27, 16776960, 0);
            var27 += 15;
            var27 += 7;
            if(class90.loginIndex != 4) {
               var0.method4840("Login: ", class90.loginWindowX + 180 - 110, var27, 16777215, 0);
               var28 = 200;
               if(!class23.preferences.field1304) {
                  var17 = class90.username;
               } else {
                  var9 = class90.username;
                  var11 = var9.length();
                  var12 = new char[var11];

                  for(var13 = 0; var13 < var11; ++var13) {
                     var12[var13] = 42;
                  }

                  var23 = new String(var12);
                  var17 = var23;
               }

               for(var17 = var17; var0.method4918(var17) > var28; var17 = var17.substring(0, var17.length() - 1)) {
                  ;
               }

               var0.method4840(FontTypeFace.appendTags(var17), class90.loginWindowX + 180 - 70, var27, 16777215, 0);
               var27 += 15;
               var9 = "Password: ";
               var20 = class90.password;
               var13 = var20.length();
               var14 = new char[var13];

               for(var15 = 0; var15 < var13; ++var15) {
                  var14[var15] = 42;
               }

               var32 = new String(var14);
               var0.method4840(var9 + var32, class90.loginWindowX + 180 - 108, var27, 16777215, 0);
               var27 += 15;
            }
         }

         int var8;
         int var10;
         int var16;
         int var21;
         int var22;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class90.field1411.method5147(class90.loginWindowX, 171);
            short var6;
            if(class90.loginIndex == 0) {
               var26 = 251;
               var0.method4843("Welcome to RuneScape", class90.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 291;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var0.method4844("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var0.method4844("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.method4843(class90.field1428, class90.loginWindowX + 180, 201, 16776960, 0);
               var26 = 236;
               var0.method4843(class90.loginMessage1, class90.loginWindowX + 180, var26, 16777215, 0);
               var27 = var26 + 15;
               var0.method4843(class90.loginMessage2, class90.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               var0.method4843(class90.loginMessage3, class90.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var6 = 321;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var0.method4843("Continue", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var0.method4843("Cancel", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var26 = 201;
               var0.method4843(class90.loginMessage1, WorldMapType2.field539, var26, 16776960, 0);
               var27 = var26 + 15;
               var0.method4843(class90.loginMessage2, WorldMapType2.field539, var27, 16776960, 0);
               var27 += 15;
               var0.method4843(class90.loginMessage3, WorldMapType2.field539, var27, 16776960, 0);
               var27 += 15;
               var27 += 7;
               var0.method4840("Login: ", WorldMapType2.field539 - 110, var27, 16777215, 0);
               var28 = 200;
               if(!class23.preferences.field1304) {
                  var17 = class90.username;
               } else {
                  var9 = class90.username;
                  var11 = var9.length();
                  var12 = new char[var11];

                  for(var13 = 0; var13 < var11; ++var13) {
                     var12[var13] = 42;
                  }

                  var23 = new String(var12);
                  var17 = var23;
               }

               for(var17 = var17; var0.method4918(var17) > var28; var17 = var17.substring(1)) {
                  ;
               }

               var0.method4840(FontTypeFace.appendTags(var17) + (class90.field1439 == 0 & Client.gameCycle % 40 < 20?class60.getColTags(16776960) + "|":""), WorldMapType2.field539 - 70, var27, 16777215, 0);
               var27 += 15;
               var9 = "Password: ";
               var20 = class90.password;
               var13 = var20.length();
               var14 = new char[var13];

               for(var15 = 0; var15 < var13; ++var15) {
                  var14[var15] = 42;
               }

               var32 = new String(var14);
               var0.method4840(var9 + var32 + (class90.field1439 == 1 & Client.gameCycle % 40 < 20?class60.getColTags(16776960) + "|":""), WorldMapType2.field539 - 108, var27, 16777215, 0);
               var27 += 15;
               var26 = 277;
               var21 = WorldMapType2.field539 + -117;
               IndexedSprite var25 = class2.method8(class90.field1414, class90.field1435);
               var25.method5147(var21, var26);
               var21 = var21 + var25.originalWidth + 5;
               var1.method4840("Remember username", var21, var26 + 13, 16776960, 0);
               var21 = WorldMapType2.field539 + 24;
               var25 = class2.method8(class23.preferences.field1304, class90.field1436);
               var25.method5147(var21, var26);
               var21 = var21 + var25.originalWidth + 5;
               var1.method4840("Hide username", var21, var26 + 13, 16776960, 0);
               var27 = var26 + 15;
               var22 = WorldMapType2.field539 - 80;
               short var34 = 321;
               class90.field1412.method5147(var22 - 73, var34 - 20);
               var0.method4843("Login", var22, var34 + 5, 16777215, 0);
               var22 = WorldMapType2.field539 + 80;
               class90.field1412.method5147(var22 - 73, var34 - 20);
               var0.method4843("Cancel", var22, var34 + 5, 16777215, 0);
               var26 = 357;
               var1.method4843("Forgotten your password? <col=ffffff>Click here.", WorldMapType2.field539, var26, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var26 = 201;
               var0.method4843("Invalid username or password.", class90.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 20;
               var1.method4843("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var1.method4843("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var5 = class90.loginWindowX + 180;
               var6 = 276;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var2.method4843("Try again", var5, var6 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var6 = 326;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var2.method4843("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class90.loginIndex == 4) {
               var0.method4843("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
               var26 = 236;
               var0.method4843(class90.loginMessage1, class90.loginWindowX + 180, var26, 16777215, 0);
               var27 = var26 + 15;
               var0.method4843(class90.loginMessage2, class90.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               var0.method4843(class90.loginMessage3, class90.loginWindowX + 180, var27, 16777215, 0);
               var27 += 15;
               String var18 = "PIN: ";
               String var19 = class90.field1437;
               var10 = var19.length();
               char[] var36 = new char[var10];

               for(var21 = 0; var21 < var10; ++var21) {
                  var36[var21] = 42;
               }

               var9 = new String(var36);
               var0.method4840(var18 + var9 + (Client.gameCycle % 40 < 20?class60.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var27, 16777215, 0);
               var27 -= 8;
               var0.method4840("Trust this computer", class90.loginWindowX + 180 - 9, var27, 16776960, 0);
               var27 += 15;
               var0.method4840("for 30 days: ", class90.loginWindowX + 180 - 9, var27, 16776960, 0);
               var16 = 180 + class90.loginWindowX - 9 + var0.method4918("for 30 days: ") + 15;
               var10 = var27 - var0.verticalSpace;
               IndexedSprite var37;
               if(class90.field1438) {
                  var37 = class90.field1415;
               } else {
                  var37 = TextureProvider.field1758;
               }

               var37.method5147(var16, var10);
               var27 += 15;
               var21 = class90.loginWindowX + 180 - 80;
               short var33 = 321;
               class90.field1412.method5147(var21 - 73, var33 - 20);
               var0.method4843("Continue", var21, var33 + 5, 16777215, 0);
               var21 = class90.loginWindowX + 180 + 80;
               class90.field1412.method5147(var21 - 73, var33 - 20);
               var0.method4843("Cancel", var21, var33 + 5, 16777215, 0);
               var1.method4843("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var33 + 36, 255, 0);
            } else if(class90.loginIndex == 5) {
               var0.method4843("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
               var26 = 221;
               var2.method4843(class90.loginMessage1, class90.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 15;
               var2.method4843(class90.loginMessage2, class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var2.method4843(class90.loginMessage3, class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var27 += 14;
               var0.method4840("Username/email: ", class90.loginWindowX + 180 - 145, var27, 16777215, 0);
               var28 = 174;
               if(!class23.preferences.field1304) {
                  var17 = class90.username;
               } else {
                  var9 = class90.username;
                  var11 = var9.length();
                  var12 = new char[var11];

                  for(var13 = 0; var13 < var11; ++var13) {
                     var12[var13] = 42;
                  }

                  var23 = new String(var12);
                  var17 = var23;
               }

               for(var17 = var17; var0.method4918(var17) > var28; var17 = var17.substring(1)) {
                  ;
               }

               var0.method4840(FontTypeFace.appendTags(var17) + (Client.gameCycle % 40 < 20?class60.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var27, 16777215, 0);
               var27 += 15;
               var8 = class90.loginWindowX + 180 - 80;
               short var35 = 321;
               class90.field1412.method5147(var8 - 73, var35 - 20);
               var0.method4843("Recover", var8, var35 + 5, 16777215, 0);
               var8 = class90.loginWindowX + 180 + 80;
               class90.field1412.method5147(var8 - 73, var35 - 20);
               var0.method4843("Back", var8, var35 + 5, 16777215, 0);
            } else if(class90.loginIndex == 6) {
               var26 = 201;
               var0.method4843(class90.loginMessage1, class90.loginWindowX + 180, var26, 16776960, 0);
               var27 = var26 + 15;
               var0.method4843(class90.loginMessage2, class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var0.method4843(class90.loginMessage3, class90.loginWindowX + 180, var27, 16776960, 0);
               var27 += 15;
               var5 = class90.loginWindowX + 180;
               var6 = 321;
               class90.field1412.method5147(var5 - 73, var6 - 20);
               var0.method4843("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         int var7;
         int var29;
         if(class90.field1413 > 0) {
            var27 = class90.field1413;
            var28 = 256;
            class90.field1421 += var27 * 128;
            if(class90.field1421 > ScriptState.field792.length) {
               class90.field1421 -= ScriptState.field792.length;
               var29 = (int)(Math.random() * 12.0D);
               class227.method4199(class266.field3666[var29]);
            }

            var29 = 0;
            var7 = var27 * 128;
            var8 = (var28 - var27) * 128;

            for(var16 = 0; var16 < var8; ++var16) {
               var10 = ClanMember.field917[var7 + var29] - var27 * ScriptState.field792[var29 + class90.field1421 & ScriptState.field792.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               ClanMember.field917[var29++] = var10;
            }

            for(var16 = var28 - var27; var16 < var28; ++var16) {
               var10 = var16 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var21 = (int)(Math.random() * 100.0D);
                  if(var21 < 50 && var11 > 10 && var11 < 118) {
                     ClanMember.field917[var10 + var11] = 255;
                  } else {
                     ClanMember.field917[var11 + var10] = 0;
                  }
               }
            }

            if(class90.field1423 > 0) {
               class90.field1423 -= var27 * 4;
            }

            if(class90.field1420 > 0) {
               class90.field1420 -= var27 * 4;
            }

            if(class90.field1423 == 0 && class90.field1420 == 0) {
               var16 = (int)(Math.random() * (double)(2000 / var27));
               if(var16 == 0) {
                  class90.field1423 = 1024;
               }

               if(var16 == 1) {
                  class90.field1420 = 1024;
               }
            }

            for(var16 = 0; var16 < var28 - var27; ++var16) {
               class90.field1418[var16] = class90.field1418[var16 + var27];
            }

            for(var16 = var28 - var27; var16 < var28; ++var16) {
               class90.field1418[var16] = (int)(Math.sin((double)class90.field1422 / 14.0D) * 16.0D + Math.sin((double)class90.field1422 / 15.0D) * 14.0D + Math.sin((double)class90.field1422 / 16.0D) * 12.0D);
               ++class90.field1422;
            }

            class90.field1441 += var27;
            var16 = (var27 + (Client.gameCycle & 1)) / 2;
            if(var16 > 0) {
               for(var10 = 0; var10 < class90.field1441 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var21 = (int)(Math.random() * 128.0D) + 128;
                  ClanMember.field917[var11 + (var21 << 7)] = 192;
               }

               class90.field1441 = 0;
               var10 = 0;

               label544:
               while(true) {
                  if(var10 >= var28) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label544;
                        }

                        var11 = 0;

                        for(var21 = -var16; var21 < var28; ++var21) {
                           var13 = var21 * 128;
                           if(var16 + var21 < var28) {
                              var11 += class224.field2854[var16 * 128 + var10 + var13];
                           }

                           if(var21 - (var16 + 1) >= 0) {
                              var11 -= class224.field2854[var10 + var13 - (var16 + 1) * 128];
                           }

                           if(var21 >= 0) {
                              ClanMember.field917[var10 + var13] = var11 / (var16 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var21 = var10 * 128;

                  for(var13 = -var16; var13 < 128; ++var13) {
                     if(var16 + var13 < 128) {
                        var11 += ClanMember.field917[var16 + var21 + var13];
                     }

                     if(var13 - (var16 + 1) >= 0) {
                        var11 -= ClanMember.field917[var13 + var21 - (var16 + 1)];
                     }

                     if(var13 >= 0) {
                        class224.field2854[var21 + var13] = var11 / (var16 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class90.field1413 = 0;
         }

         var26 = 256;
         if(class90.field1423 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1423 > 768) {
                  class41.field577[var5] = Preferences.method1647(WidgetNode.field837[var5], class5.field41[var5], 1024 - class90.field1423);
               } else if(class90.field1423 > 256) {
                  class41.field577[var5] = class5.field41[var5];
               } else {
                  class41.field577[var5] = Preferences.method1647(class5.field41[var5], WidgetNode.field837[var5], 256 - class90.field1423);
               }
            }
         } else if(class90.field1420 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1420 > 768) {
                  class41.field577[var5] = Preferences.method1647(WidgetNode.field837[var5], class1.field10[var5], 1024 - class90.field1420);
               } else if(class90.field1420 > 256) {
                  class41.field577[var5] = class1.field10[var5];
               } else {
                  class41.field577[var5] = Preferences.method1647(class1.field10[var5], WidgetNode.field837[var5], 256 - class90.field1420);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class41.field577[var5] = WidgetNode.field837[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class90.field1419, 9, class90.field1419 + 128, var26 + 7);
         class208.field2603.method5173(class90.field1419, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var29 = class12.field275.width * 9 + class90.field1419;

         for(var7 = 1; var7 < var26 - 1; ++var7) {
            var8 = class90.field1418[var7] * (var26 - var7) / var26;
            var16 = var8 + 22;
            if(var16 < 0) {
               var16 = 0;
            }

            var5 += var16;

            for(var10 = var16; var10 < 128; ++var10) {
               var11 = ClanMember.field917[var5++];
               if(var11 != 0) {
                  var21 = var11;
                  var13 = 256 - var11;
                  var11 = class41.field577[var11];
                  var22 = class12.field275.pixels[var29];
                  class12.field275.pixels[var29++] = (var13 * (var22 & '\uff00') + var21 * (var11 & '\uff00') & 16711680) + ((var11 & 16711935) * var21 + (var22 & 16711935) * var13 & -16711936) >> 8;
               } else {
                  ++var29;
               }
            }

            var29 += var16 + class12.field275.width - 128;
         }

         Rasterizer2D.setDrawRegion(class90.field1419 + 765 - 128, 9, class90.field1419 + 765, var26 + 7);
         ScriptState.field791.method5173(class90.field1419 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var29 = class12.field275.width * 9 + class90.field1419 + 637 + 24;

         for(var7 = 1; var7 < var26 - 1; ++var7) {
            var8 = class90.field1418[var7] * (var26 - var7) / var26;
            var16 = 103 - var8;
            var29 += var8;

            for(var10 = 0; var10 < var16; ++var10) {
               var11 = ClanMember.field917[var5++];
               if(var11 != 0) {
                  var21 = var11;
                  var13 = 256 - var11;
                  var11 = class41.field577[var11];
                  var22 = class12.field275.pixels[var29];
                  class12.field275.pixels[var29++] = ((var11 & 16711935) * var21 + (var22 & 16711935) * var13 & -16711936) + (var13 * (var22 & '\uff00') + var21 * (var11 & '\uff00') & 16711680) >> 8;
               } else {
                  ++var29;
               }
            }

            var5 += 128 - var16;
            var29 += class12.field275.width - var16 - var8;
         }

         class90.titlemuteSprite[class23.preferences.muted?1:0].method5147(class90.field1419 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class64.field816 != null) {
               var27 = class90.field1419 + 5;
               var28 = 463;
               byte var31 = 100;
               byte var30 = 35;
               class64.field816.method5147(var27, var28);
               var0.method4843("World" + " " + Client.world, var31 / 2 + var27, var30 / 2 + var28 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.method4843("Loading...", var31 / 2 + var27, var30 / 2 + var28 + 12, 16777215, 0);
               } else {
                  var1.method4843("Click to switch", var31 / 2 + var27, var30 / 2 + var28 + 12, 16777215, 0);
               }
            } else {
               class64.field816 = class70.getSprite(class37.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1834722285"
   )
   static void method1585() {
      if(class90.field1409) {
         class90.field1411 = null;
         class90.field1412 = null;
         class266.field3666 = null;
         class208.field2603 = null;
         ScriptState.field791 = null;
         class90.logoSprite = null;
         class90.titlemuteSprite = null;
         TextureProvider.field1758 = null;
         class90.field1415 = null;
         ClanMember.field916 = null;
         class33.field488 = null;
         class177.field2431 = null;
         class149.field2214 = null;
         class64.field816 = null;
         WidgetNode.field837 = null;
         class5.field41 = null;
         class1.field10 = null;
         class41.field577 = null;
         ScriptState.field792 = null;
         Varbit.field3383 = null;
         ClanMember.field917 = null;
         class224.field2854 = null;
         class138.method2927(2);
         IndexDataBase.sendConInfo(true);
         class90.field1409 = false;
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1718543985"
   )
   static void method1586(int var0, int var1) {
      class24.method170(ScriptVarType.field239, var0, var1);
      ScriptVarType.field239 = null;
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lbk;ZB)V",
      garbageValue = "-18"
   )
   static final void method1584(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class215.method4106(var2);
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3646(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3647()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var6 = PacketBuffer.method3528(var3);
      if(var6 != null) {
         class25.method172(var6);
      }

      class14.method86();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class93.loadWidget(var5)) {
            class251.method4526(class177.widgets[var5], 1);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "1"
   )
   static int method1582(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
      } else {
         var3 = var2?class81.field1341:class81.field1340;
      }

      class25.method172(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--class81.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = AbstractByteBuffer.localPlayer.composition.method4070();
            return 1;
         } else {
            return 2;
         }
      } else {
         class81.intStackSize -= 2;
         int var4 = class81.intStack[class81.intStackSize];
         int var5 = class81.intStack[class81.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class46.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2707 = var6.offsetX2d;
         var3.field2708 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2716 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2716 = 1;
         } else {
            var3.field2716 = 2;
         }

         if(var3.field2713 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2713;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1979821811"
   )
   static final void method1581() {
      int var0 = AbstractByteBuffer.localPlayer.x;
      int var1 = AbstractByteBuffer.localPlayer.y;
      if(Occluder.field2140 - var0 < -500 || Occluder.field2140 - var0 > 500 || class40.field569 - var1 < -500 || class40.field569 - var1 > 500) {
         Occluder.field2140 = var0;
         class40.field569 = var1;
      }

      if(var0 != Occluder.field2140) {
         Occluder.field2140 += (var0 - Occluder.field2140) / 16;
      }

      if(var1 != class40.field569) {
         class40.field569 += (var1 - class40.field569) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.field738 == 4 && class110.field1650) {
         var2 = MouseInput.field746 - Client.field1000;
         Client.field941 = var2 * 2;
         Client.field1000 = var2 != -1 && var2 != 1?(Client.field1000 + MouseInput.field746) / 2:MouseInput.field746;
         var3 = Client.field1153 - MouseInput.field745;
         Client.field1149 = var3 * 2;
         Client.field1153 = var3 != -1 && var3 != 1?(Client.field1153 + MouseInput.field745) / 2:MouseInput.field745;
      } else {
         if(KeyFocusListener.field655[96]) {
            Client.field1149 += (-24 - Client.field1149) / 2;
         } else if(KeyFocusListener.field655[97]) {
            Client.field1149 += (24 - Client.field1149) / 2;
         } else {
            Client.field1149 /= 2;
         }

         if(KeyFocusListener.field655[98]) {
            Client.field941 += (12 - Client.field941) / 2;
         } else if(KeyFocusListener.field655[99]) {
            Client.field941 += (-12 - Client.field941) / 2;
         } else {
            Client.field941 /= 2;
         }

         Client.field1000 = MouseInput.field746;
         Client.field1153 = MouseInput.field745;
      }

      Client.mapAngle = Client.field1149 / 2 + Client.mapAngle & 2047;
      Client.field921 += Client.field941 / 2;
      if(Client.field921 < 128) {
         Client.field921 = 128;
      }

      if(Client.field921 > 383) {
         Client.field921 = 383;
      }

      var2 = Occluder.field2140 >> 7;
      var3 = class40.field569 >> 7;
      int var4 = CacheFile.getTileHeight(Occluder.field2140, class40.field569, class5.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class5.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field1124) {
         Client.field1124 += (var6 - Client.field1124) / 24;
      } else if(var6 < Client.field1124) {
         Client.field1124 += (var6 - Client.field1124) / 80;
      }

   }
}
